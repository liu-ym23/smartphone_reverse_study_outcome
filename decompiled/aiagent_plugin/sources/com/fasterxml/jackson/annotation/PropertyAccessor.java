package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PropertyAccessor extends Enum<PropertyAccessor> {
    private static final /* synthetic */ PropertyAccessor[] $VALUES = null;
    public static final PropertyAccessor ALL = null;
    public static final PropertyAccessor CREATOR = null;
    public static final PropertyAccessor FIELD = null;
    public static final PropertyAccessor GETTER = null;
    public static final PropertyAccessor IS_GETTER = null;
    public static final PropertyAccessor NONE = null;
    public static final PropertyAccessor SETTER = null;

    public static PropertyAccessor valueOf(String r2) {
        return (PropertyAccessor) ZeusTransformUtils.preCheckCast(Enum.valueOf(PropertyAccessor.class, r2), PropertyAccessor.class, "com.obric.aiagent.plugin");
    }

    public static PropertyAccessor[] values() {
        return (PropertyAccessor[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PropertyAccessor[].class, "com.obric.aiagent.plugin");
    }

    static {
        PropertyAccessor r0 = new PropertyAccessor("GETTER", 0);
        GETTER = r0;
        PropertyAccessor r1 = new PropertyAccessor("SETTER", 1);
        SETTER = r1;
        PropertyAccessor r3 = new PropertyAccessor("CREATOR", 2);
        CREATOR = r3;
        PropertyAccessor r5 = new PropertyAccessor("FIELD", 3);
        FIELD = r5;
        PropertyAccessor r7 = new PropertyAccessor("IS_GETTER", 4);
        IS_GETTER = r7;
        PropertyAccessor r9 = new PropertyAccessor("NONE", 5);
        NONE = r9;
        PropertyAccessor r11 = new PropertyAccessor("ALL", 6);
        ALL = r11;
        $VALUES = new PropertyAccessor[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private PropertyAccessor(String r1, int r2) {
        super(r1, r2);
    }

    public boolean creatorEnabled() {
        if (this != CREATOR) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }

    public boolean getterEnabled() {
        if (this != GETTER) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }

    public boolean isGetterEnabled() {
        if (this != IS_GETTER) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }

    public boolean setterEnabled() {
        if (this != SETTER) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }

    public boolean fieldEnabled() {
        if (this != FIELD) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }
}
