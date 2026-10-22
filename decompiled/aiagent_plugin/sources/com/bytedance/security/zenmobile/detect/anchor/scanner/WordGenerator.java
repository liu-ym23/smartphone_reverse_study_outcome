package com.bytedance.security.zenmobile.detect.anchor.scanner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WordGenerator {
    public WordGenerator() {
    }

    public static List<String> generateWords(String r1) {
        r1.hashCode();
        if (r1.equals("yyyy") == true) goto L9;
        if (r1.equals("china_mobile_prefix") == true) goto L11;
        return null;
    L11:
        return new ChinaMobilePrefixPattern().generateWords();
    L9:
        return new YYYYPattern().generateWords();
    }

    public static Map<String, List<String>> generateAllWords() {
        HashMap r0 = new HashMap();
        r0.put("china_mobile_prefix", generateWords("china_mobile_prefix"));
        r0.put("yyyy", generateWords("yyyy"));
        return r0;
    }
}
