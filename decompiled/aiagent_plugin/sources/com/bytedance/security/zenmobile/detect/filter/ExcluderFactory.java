package com.bytedance.security.zenmobile.detect.filter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExcluderFactory {
    public ExcluderFactory() {
    }

    public static Excluder createExcluder(String r2, List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -934799095: goto L18;
            case -596578939: goto L14;
            case 96757556: goto L10;
            case 951526612: goto L6;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L27;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            default: goto L22;
        };
    L22:
        return null;
    L29:
        return new ContainExcluder(r4);
    L30:
        return new EqualExcluder(r4);
    L31:
        return new SuffixOfExcluder(r4);
    L27:
        return new RegexpExcluder(r4);
    L6:
        if (r2.equals("contain") == false) goto L21;
        r1 = 3;
        goto L21
    L10:
        if (r2.equals("equal") == false) goto L21;
        r1 = 2;
        goto L21
    L14:
        if (r2.equals("suffix_of") == false) goto L21;
        r1 = 1;
        goto L21
    L18:
        if (r2.equals("regexp") == false) goto L21;
        r1 = 0;
        goto L21
    }
}
