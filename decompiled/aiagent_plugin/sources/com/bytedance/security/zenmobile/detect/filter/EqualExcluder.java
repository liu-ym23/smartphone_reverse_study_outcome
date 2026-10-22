package com.bytedance.security.zenmobile.detect.filter;

import com.bytedance.security.zenmobile.helpers.WordExpander;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EqualExcluder extends Excluder {
    private List<byte[]> references;

    public EqualExcluder(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.references = new ArrayList();
        Iterator<String> r7 = WordExpander.expandWords(r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        this.references.add(r0.getBytes(StandardCharsets.UTF_8));
        goto L4
    L6:
        this.mode = "equal";
    }

    @Override // com.bytedance.security.zenmobile.detect.filter.Excluder
    public boolean exclude(byte[] r5, int r6, int r7) {
        if (r7 > r5.length) goto L14;
        if (r6 < 0) goto L14;
        if (r6 > r7) goto L14;
        Iterator<byte[]> r4 = this.references.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r4.next(), byte[].class, "com.obric.aiagent.plugin");
        if (Arrays.equals(Arrays.copyOfRange(r5, r6, r7), r0) == false) goto L9;
        return true;
    L14:
        return false;
    }
}
