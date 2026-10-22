package com.bytedance.security.zenmobile.detect.helpers;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WordExpander {
    private static final List<String> abbreviations = null;

    public WordExpander() {
    }

    static {
        abbreviations = Arrays.asList(new String[]{DbHelper.COL_ID, "ip", MonitorConstants.DB, "api", "url"});
    }

    public static boolean isAbbreviation(String r1) {
        return abbreviations.contains(r1);
    }

    public static List<String> expandWords(List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        HashSet r0 = new HashSet();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        r0.addAll(expandWord((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return new ArrayList(r0);
    }

    public static List<String> expandWord(String r15) {
        String r0 = "-";
        if (r15.contains("-") == true) goto L6;
        r0 = "_";
    L6:
        HashSet r1 = new HashSet();
        String[] r16 = r15.split("_");
        int r2 = r16.length;
        HashMap[] r3 = new HashMap[r2];
        String[] r4 = new String[r16.length];
        int r6 = 0;
    L8:
        if (r6 >= r16.length) goto L18;
        String r7 = r16[r6];
        r3[r6] = new HashMap();
        r3[r6].put("Original", r7);
        r3[r6].put("Lower", r7.toLowerCase());
        r3[r6].put("Upper", r7.toUpperCase());
        r3[r6].put("Title", toTitleCase(r7));
        if (r6 != 0) goto L12;
        r3[r6].put("Camel", (String) ZeusTransformUtils.preCheckCast(r3[r6].get("Lower"), String.class, "com.obric.aiagent.plugin"));
    L14:
        if (isAbbreviation((String) ZeusTransformUtils.preCheckCast(r3[r6].get("Lower"), String.class, "com.obric.aiagent.plugin")) == false) goto L16;
        r3[r6].put("Abbr", (String) ZeusTransformUtils.preCheckCast(r3[r6].get("Upper"), String.class, "com.obric.aiagent.plugin"));
    L17:
        r6 = r6 + 1;
        goto L8
    L16:
        r3[r6].put("Abbr", (String) ZeusTransformUtils.preCheckCast(r3[r6].get("Title"), String.class, "com.obric.aiagent.plugin"));
        goto L17
    L12:
        r3[r6].put("Camel", (String) ZeusTransformUtils.preCheckCast(r3[r6].get("Title"), String.class, "com.obric.aiagent.plugin"));
        goto L14
    L18:
        String[] r8 = {"Original", "Lower", "Upper", "Title", "Abbr", "Camel"};
        int r9 = 0;
    L19:
        if (r9 >= 6) goto L25;
        String r10 = r8[r9];
        int r11 = 0;
    L21:
        if (r11 >= r2) goto L23;
        r4[r11] = (String) ZeusTransformUtils.preCheckCast(r3[r11].get(r10), String.class, "com.obric.aiagent.plugin");
        r11 = r11 + 1;
        goto L21
    L23:
        r1.add(String.join(r0, r4));
        r1.add(String.join("", r4));
        r9 = r9 + 1;
        goto L19
    L25:
        return new ArrayList(r1);
    }

    private static String toTitleCase(String r3) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.isEmpty() == false) goto L7;
        return r3;
    L7:
        return r3.substring(0, 1).toUpperCase() + r3.substring(1).toLowerCase();
    }
}
