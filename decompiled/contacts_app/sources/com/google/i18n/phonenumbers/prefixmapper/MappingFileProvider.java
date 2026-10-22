package com.google.i18n.phonenumbers.prefixmapper;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class MappingFileProvider implements Externalizable {
    private static final Map<String, String> LOCALE_NORMALIZATION_MAP = null;
    private List<Set<String>> availableLanguages;
    private int[] countryCallingCodes;
    private int numOfEntries;

    static {
        HashMap r0 = new HashMap();
        r0.put("zh_TW", "zh_Hant");
        r0.put("zh_HK", "zh_Hant");
        r0.put("zh_MO", "zh_Hant");
        LOCALE_NORMALIZATION_MAP = Collections.unmodifiableMap(r0);
    }

    public MappingFileProvider() {
        this.numOfEntries = 0;
    }

    public void readFileConfigs(SortedMap<Integer, Set<String>> r6) {
        int r0 = r6.size();
        this.numOfEntries = r0;
        this.countryCallingCodes = new int[r0];
        this.availableLanguages = new ArrayList(this.numOfEntries);
        Iterator<Integer> r1 = r6.keySet().iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L6;
        int r3 = r1.next().intValue();
        int r4 = r2 + 1;
        this.countryCallingCodes[r2] = r3;
        this.availableLanguages.add(new HashSet(r6.get(Integer.valueOf(r3))));
        r2 = r4;
        goto L4
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r7) throws IOException {
        int r0 = r7.readInt();
        this.numOfEntries = r0;
        int[] r1 = this.countryCallingCodes;
        if (r1 != null) goto L5;
    L6:
        this.countryCallingCodes = new int[r0];
    L8:
        if (this.availableLanguages != null) goto L10;
        this.availableLanguages = new ArrayList();
    L10:
        int r2 = 0;
    L12:
        if (r2 >= this.numOfEntries) goto L17;
        this.countryCallingCodes[r2] = r7.readInt();
        int r3 = r7.readInt();
        HashSet r4 = new HashSet();
        int r5 = 0;
    L14:
        if (r5 >= r3) goto L16;
        r4.add(r7.readUTF());
        r5 = r5 + 1;
        goto L14
    L16:
        this.availableLanguages.add(r4);
        r2 = r2 + 1;
        goto L12
    L17:
        return;
    L5:
        if (r1.length >= r0) goto L8;
        goto L6
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r4) throws IOException {
        r4.writeInt(this.numOfEntries);
        int r0 = 0;
    L4:
        if (r0 >= this.numOfEntries) goto L10;
        r4.writeInt(this.countryCallingCodes[r0]);
        Set<String> r1 = this.availableLanguages.get(r0);
        r4.writeInt(r1.size());
        Iterator<String> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r4.writeUTF(r2.next());
        goto L7
    L9:
        r0 = r0 + 1;
        goto L4
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= this.numOfEntries) goto L11;
        r0.append(this.countryCallingCodes[r1]);
        r0.append('|');
        Iterator r2 = new TreeSet(this.availableLanguages.get(r1)).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r0.append((String) r2.next());
        r0.append(',');
        goto L7
    L9:
        r0.append('\n');
        r1 = r1 + 1;
        goto L4
    L11:
        return r0.toString();
    }

    String getFileName(int r4, String r5, String r6, String r7) {
        if (r5.length() != 0) goto L5;
        return "";
    L5:
        int r0 = Arrays.binarySearch(this.countryCallingCodes, r4);
        if (r0 >= 0) goto L8;
        return "";
    L8:
        Set<String> r1 = this.availableLanguages.get(r0);
        if (r1.size() <= 0) goto L14;
        String r3 = findBestMatchingLanguageCode(r1, r5, r6, r7);
        if (r3.length() <= 0) goto L14;
        StringBuilder r8 = new StringBuilder();
        r8.append(r4).append('_').append(r3);
        return r8.toString();
    L14:
        return "";
    }

    private String findBestMatchingLanguageCode(Set<String> r4, String r5, String r6, String r7) {
        String r0 = constructFullLocale(r5, r6, r7).toString();
        String r1 = LOCALE_NORMALIZATION_MAP.get(r0);
        if (r1 == null) goto L8;
        if (r4.contains(r1) == false) goto L8;
        return r1;
    L8:
        if (r4.contains(r0) == false) goto L11;
        return r0;
    L11:
        if (onlyOneOfScriptOrRegionIsEmpty(r6, r7) == false) goto L16;
        if (r4.contains(r5) == false) goto L28;
        return r5;
    L28:
        return "";
    L16:
        if (r6.length() > 0) goto L18;
        return "";
    L18:
        if (r7.length() <= 0) goto L31;
        String r3 = r5 + '_' + r6;
        if (r4.contains(r3) == false) goto L22;
        return r3;
    L22:
        String r8 = r5 + '_' + r7;
        if (r4.contains(r8) == false) goto L26;
        return r8;
    L26:
        if (r4.contains(r5) == false) goto L32;
        return r5;
    L32:
        return "";
    L31:
        return "";
    }

    private boolean onlyOneOfScriptOrRegionIsEmpty(String r1, String r2) {
        if (r1.length() != 0) goto L7;
        if (r2.length() <= 0) goto L7;
    L10:
        return true;
    L7:
        if (r2.length() == 0) goto L9;
    L11:
        return false;
    L9:
        if (r1.length() <= 0) goto L11;
        goto L10
    }

    private StringBuilder constructFullLocale(String r2, String r3, String r4) {
        StringBuilder r0 = new StringBuilder(r2);
        appendSubsequentLocalePart(r3, r0);
        appendSubsequentLocalePart(r4, r0);
        return r0;
    }

    private void appendSubsequentLocalePart(String r1, StringBuilder r2) {
        if (r1.length() <= 0) goto L6;
        r2.append('_').append(r1);
        return;
    }
}
