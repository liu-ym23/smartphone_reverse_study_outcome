package com.bytedance.security.zenmobile.ahocorasick;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Match {
    int end;
    List<byte[]> terms;

    public Match() {
        this.terms = new ArrayList();
    }

    public Match(int r3, List<byte[]> r4) {
        List<byte[]> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.end = r3;
        this.terms = r5;
    }

    public int getEnd() {
        return this.end;
    }

    public List<byte[]> getTerms() {
        return this.terms;
    }
}
