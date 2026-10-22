package com.bytedance.security.zenmobile.detect.filter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class RegexpExcluder extends Excluder {
    private Pattern pattern;

    public RegexpExcluder(List<String> r3) {
        this.pattern = Pattern.compile("(" + String.join("|", (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")) + ")");
        this.mode = "regexp";
    }

    @Override // com.bytedance.security.zenmobile.detect.filter.Excluder
    public boolean exclude(byte[] r2, int r3, int r4) {
        if (r4 > r2.length) goto L9;
        if (r3 < 0) goto L11;
        if (r3 > r4) goto L12;
        String r0 = new String(r2, r3, r4 - r3);
        return this.pattern.matcher(r0).find();
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }
}
