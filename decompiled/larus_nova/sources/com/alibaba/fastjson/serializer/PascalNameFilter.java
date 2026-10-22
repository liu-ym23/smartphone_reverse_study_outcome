package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes28.dex */
public class PascalNameFilter implements NameFilter {
    public PascalNameFilter() {
    }

    @Override // com.alibaba.fastjson.serializer.NameFilter
    public String process(Object r100, String r101, Object r102) {
        if (r101 != null) goto L4;
        return r101;
    L4:
        if (r101.length() == 0) goto L9;
        char[] r103 = r101.toCharArray();
        r103[0] = Character.toUpperCase(r103[0]);
        return new String(r103);
    L9:
        return r101;
    }
}
