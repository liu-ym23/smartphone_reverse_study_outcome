package com.bytedance.security.zenmobile.detect.extension;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ExtenderFactory {
    public ExtenderFactory() {
    }

    public static Extender createExtender(String r9, int r10, List<String> r11, int r12, int r13, boolean r14, Map<String, Object> r15) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        r9.hashCode();
        byte r16 = -1;
        switch(r9.hashCode()) {
            case -2115311574: goto L14;
            case -1789597108: goto L10;
            case -934799095: goto L6;
            default: goto L17;
        };
    L17:
        switch(r16) {
            case 0: goto L22;
            case 1: goto L25;
            case 2: goto L24;
            default: goto L18;
        };
    L18:
        return null;
    L24:
        return new RegexpExtender(r10, r4, r12, r13, r14, r8);
    L25:
        return new CharacterSetExtender(r10, r4, r12, r13, r14, r8);
    L22:
        return new BoundaryExtender(r10, r4, r12, r13, r14, r8);
    L6:
        if (r9.equals("regexp") == false) goto L17;
        r16 = 2;
        goto L17
    L10:
        if (r9.equals("character_set") == false) goto L17;
        r16 = 1;
        goto L17
    L14:
        if (r9.equals("boundary") == false) goto L17;
        r16 = 0;
        goto L17
    }
}
