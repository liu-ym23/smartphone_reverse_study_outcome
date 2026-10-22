package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    AbstractDoCoMoResultParser() {
    }

    static String[] matchDoCoMoPrefixedField(String r1, String r2, boolean r3) {
        return matchPrefixedField(r1, r2, ';', r3);
    }

    static String matchSingleDoCoMoPrefixedField(String r1, String r2, boolean r3) {
        return matchSinglePrefixedField(r1, r2, ';', r3);
    }
}
