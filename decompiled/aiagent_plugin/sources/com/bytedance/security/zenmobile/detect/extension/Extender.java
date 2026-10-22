package com.bytedance.security.zenmobile.detect.extension;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Extender {
    public static final int BACKWARD = -1;
    static final String BOUNDARY = "boundary";
    static final String CHARACTER_SET = "character_set";
    static final String ESCAPED_STRING = "escaped_string";
    public static final int FORWARD = 1;
    static final String REGEXP = "regexp";
    int direction;
    boolean inValue;
    int maxLength;
    int minLength;
    String mode;
    List<String> values;

    public abstract ExtensionResult extend(byte[] r1, int r2);

    public Extender() {
        this.values = new ArrayList();
    }

    public Extender(int r3, List<String> r4, int r5, int r6, boolean r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 < 0) goto L10;
        if (r5 > r6) goto L8;
        this.direction = r3;
        this.values = r8;
        this.minLength = r5;
        this.maxLength = r6;
        this.inValue = r7;
        return;
    L8:
        throw new IllegalArgumentException(String.format("max_length (%d) should not be smaller than min_length (%d)", new Object[]{Integer.valueOf(r6), Integer.valueOf(r5)}));
    L10:
        throw new IllegalArgumentException(String.format("min_length should be non-negative integer but %d is given", new Object[]{Integer.valueOf(r5)}));
    }

    public String getMode() {
        return this.mode;
    }

    public boolean isInValue() {
        return this.inValue;
    }
}
