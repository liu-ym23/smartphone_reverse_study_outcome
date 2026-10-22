package com.bytedance.security.zenmobile.detect.filter;

import com.bytedance.security.zenmobile.helpers.WordExpander;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuffixOfExcluder extends Excluder {
    private List<byte[]> references;

    public SuffixOfExcluder(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.references = new ArrayList();
        Iterator<String> r7 = WordExpander.expandWords(r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        this.references.add(r0.getBytes(StandardCharsets.UTF_8));
        goto L4
    L6:
        this.mode = "suffix_of";
    }

    @Override // com.bytedance.security.zenmobile.detect.filter.Excluder
    public boolean exclude(byte[] r6, int r7, int r8) {
        if (r8 > r6.length) goto L14;
        if (r7 < 0) goto L14;
        if (r7 > r8) goto L14;
        Iterator<byte[]> r0 = this.references.iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        if (byteArrayHasSuffix(r6, r7, r8, (byte[]) ZeusTransformUtils.preCheckCast(r0.next(), byte[].class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    L14:
        return false;
    }

    private boolean byteArrayHasSuffix(byte[] r3, int r4, int r5, byte[] r6) {
        if (r5 >= r6.length) goto L5;
        return false;
    L5:
        int r7 = r5 - r6.length;
        if (r7 >= r4) goto L8;
        return false;
    L8:
        int r2 = 0;
    L10:
        if (r2 >= r6.length) goto L15;
        if (r3[r7 + r2] != r6[r2]) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }
}
