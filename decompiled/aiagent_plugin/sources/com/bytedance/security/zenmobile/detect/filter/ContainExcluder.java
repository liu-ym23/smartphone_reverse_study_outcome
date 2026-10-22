package com.bytedance.security.zenmobile.detect.filter;

import com.bytedance.security.zenmobile.helpers.WordExpander;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContainExcluder extends Excluder {
    private List<byte[]> references;

    public ContainExcluder(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.references = new ArrayList();
        Iterator<String> r7 = WordExpander.expandWords(r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        this.references.add(r0.getBytes(StandardCharsets.UTF_8));
        goto L4
    L6:
        this.mode = "contain";
    }

    @Override // com.bytedance.security.zenmobile.detect.filter.Excluder
    public boolean exclude(byte[] r6, int r7, int r8) {
        if (r8 > r6.length) goto L14;
        if (r7 < 0) goto L14;
        if (r7 > r8) goto L14;
        Iterator<byte[]> r0 = this.references.iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        if (byteArrayContains(r6, r7, r8, (byte[]) ZeusTransformUtils.preCheckCast(r0.next(), byte[].class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    L14:
        return false;
    }

    private boolean byteArrayContains(byte[] r1, int r2, int r3, byte[] r4) {
    L3:
        if (r2 > (r3 - r4.length)) goto L9;
        if (Arrays.equals(Arrays.copyOfRange(r1, r2, r4.length + r2), r4) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
