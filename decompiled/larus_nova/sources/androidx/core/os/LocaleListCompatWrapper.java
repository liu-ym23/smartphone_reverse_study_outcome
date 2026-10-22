package androidx.core.os;

import com.bytedance.android.live.uikit.util.RTLUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {
    private static final Locale EN_LATN = null;
    private static final Locale LOCALE_AR_XB = null;
    private static final Locale LOCALE_EN_XA = null;
    private static final Locale[] sEmptyList = null;
    private final Locale[] mList;
    private final String mStringRepresentation;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static String getScript(Locale r100) {
            return r100.getScript();
        }
    }

    static {
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale(RTLUtil.ARABIA_LANG, "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        Locale[] r100 = this.mList;
        int r101 = r100.length;
        int r102 = 1;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = (r102 * 31) + r100[r103].hashCode();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        if (this.mList.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mList.length;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("[");
        int r101 = 0;
    L3:
        Locale[] r102 = this.mList;
        if (r101 >= r102.length) goto L9;
        r100.append(r102[r101]);
        if (r101 >= (this.mList.length - 1)) goto L8;
        r100.append(',');
    L8:
        r101 = r101 + 1;
        goto L3
    L9:
        r100.append("]");
        return r100.toString();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public LocaleListCompatWrapper(Locale... r100) {
        if (r100.length != 0) goto L5;
        this.mList = sEmptyList;
        this.mStringRepresentation = "";
        return;
    L5:
        ArrayList r101 = new ArrayList();
        HashSet r102 = new HashSet();
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
    L7:
        if (r104 >= r100.length) goto L19;
        Locale r105 = r100[r104];
        if (r105 == null) goto L18;
        if (r102.contains(r105) == true) goto L16;
        Locale r106 = (Locale) r105.clone();
        r101.add(r106);
        toLanguageTag(r103, r106);
        if (r104 >= (r100.length - 1)) goto L15;
        r103.append(',');
    L15:
        r102.add(r106);
    L16:
        r104 = r104 + 1;
        goto L7
    L18:
        throw new NullPointerException("list[" + r104 + "] is null");
    L19:
        this.mList = (Locale[]) r101.toArray(new Locale[0]);
        this.mStringRepresentation = r103.toString();
    }

    private int findFirstMatchIndex(Locale r100) {
        int r101 = 0;
    L3:
        Locale[] r102 = this.mList;
        if (r101 >= r102.length) goto L9;
        if (matchScore(r100, r102[r101]) > 0) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return r101;
    L9:
        return Integer.MAX_VALUE;
    }

    private static String getLikelyScript(Locale r100) {
        String r101 = Api21Impl.getScript(r100);
        if (r101.isEmpty() == true) goto L5;
        return r101;
    L5:
        return "";
    }

    private static boolean isPseudoLocale(Locale r100) {
        if (LOCALE_EN_XA.equals(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (LOCALE_AR_XB.equals(r100) == true) goto L8;
        return false;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocaleListCompatWrapper) == true) goto L8;
        return false;
    L8:
        Locale[] r101 = ((LocaleListCompatWrapper) r100).mList;
        if (this.mList.length == r101.length) goto L11;
        return false;
    L11:
        int r102 = 0;
    L12:
        Locale[] r103 = this.mList;
        if (r102 >= r103.length) goto L18;
        if (r103[r102].equals(r101[r102]) == false) goto L16;
        r102 = r102 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r100) {
        if (r100 < 0) goto L6;
        Locale[] r101 = this.mList;
        if (r100 >= r101.length) goto L6;
        return r101[r100];
    L6:
        return null;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] r100) {
        return computeFirstMatch(Arrays.asList(r100), false);
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r100) {
        int r101 = 0;
    L3:
        Locale[] r102 = this.mList;
        if (r101 >= r102.length) goto L9;
        if (r102[r101].equals(r100) == true) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return r101;
    L9:
        return -1;
    }

    private Locale computeFirstMatch(Collection<String> r100, boolean r101) {
        int r102 = computeFirstMatchIndex(r100, r101);
        if (r102 != (-1)) goto L6;
        return null;
    L6:
        return this.mList[r102];
    }

    private int computeFirstMatchIndex(Collection<String> r100, boolean r101) {
        Locale[] r102 = this.mList;
        if (r102.length != 1) goto L6;
        return 0;
    L6:
        if (r102.length != 0) goto L10;
        return -1;
    L10:
        if (r101 == false) goto L16;
        int r103 = findFirstMatchIndex(EN_LATN);
        if (r103 != 0) goto L14;
        return 0;
    L14:
        if (r103 >= Integer.MAX_VALUE) goto L16;
    L17:
        Iterator<String> r104 = r100.iterator();
    L19:
        if (r104.hasNext() == false) goto L25;
        int r105 = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat(r104.next()));
        if (r105 == 0) goto L22;
        if (r105 >= r103) goto L19;
        r103 = r105;
        goto L19
    L22:
        return 0;
    L25:
        if (r103 != Integer.MAX_VALUE) goto L27;
        return 0;
    L27:
        return r103;
    L16:
        r103 = Integer.MAX_VALUE;
        goto L17
    }

    private static int matchScore(Locale r100, Locale r101) {
        if (r100.equals(r101) == false) goto L6;
        return 1;
    L6:
        if (r100.getLanguage().equals(r101.getLanguage()) == true) goto L9;
        return 0;
    L9:
        if (isPseudoLocale(r100) == false) goto L11;
    L24:
        return 0;
    L11:
        if (isPseudoLocale(r101) == true) goto L24;
        String r102 = getLikelyScript(r100);
        if (r102.isEmpty() == false) goto L23;
        String r103 = r100.getCountry();
        if (r103.isEmpty() == false) goto L18;
        return 1;
    L18:
        if (r103.equals(r101.getCountry()) == true) goto L26;
        return 0;
    L26:
        return 1;
    L23:
        return r102.equals(getLikelyScript(r101)) ? 1 : 0;
    }

    public static void toLanguageTag(StringBuilder r100, Locale r101) {
        r100.append(r101.getLanguage());
        String r102 = r101.getCountry();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isEmpty() == true) goto L9;
        r100.append('-');
        r100.append(r101.getCountry());
        return;
    }
}
