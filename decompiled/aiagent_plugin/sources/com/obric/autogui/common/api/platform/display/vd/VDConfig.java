package com.obric.autogui.common.api.platform.display.vd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.o;

/* JADX INFO: compiled from: VDConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDConfig {
    private final int densityDpi;
    private final int heightPixels;
    private final String name;
    private final Type type;
    private final int widthPixels;

    /* JADX INFO: compiled from: VDConfig.kt */
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type DefaultOperatingSpace = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DefaultOperatingSpace};
        }

        public static a<Type> getEntries() {
            return $ENTRIES;
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        static {
            DefaultOperatingSpace = new Type("DefaultOperatingSpace", 0);
            Type[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.aiagent.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ VDConfig copy$default(VDConfig r3, String r4, int r5, int r6, int r7, Type r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.name;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.widthPixels;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.heightPixels;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.densityDpi;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.type;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.widthPixels;
    }

    public final int component3() {
        return this.heightPixels;
    }

    public final int component4() {
        return this.densityDpi;
    }

    public final Type component5() {
        return this.type;
    }

    public final VDConfig copy(String r7, int r8, int r9, int r10, Type r11) {
        o.e(r7, "name");
        o.e(r11, "type");
        return new VDConfig(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, VDConfig.class) == true) goto L8;
        return false;
    L8:
        VDConfig r6 = (VDConfig) ZeusTransformUtils.preCheckCast(r5, VDConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (this.widthPixels == r6.widthPixels) goto L15;
        return false;
    L15:
        if (this.heightPixels == r6.heightPixels) goto L18;
        return false;
    L18:
        if (this.densityDpi == r6.densityDpi) goto L21;
        return false;
    L21:
        if (this.type == r6.type) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + Integer.hashCode(this.widthPixels)) * 31) + Integer.hashCode(this.heightPixels)) * 31) + Integer.hashCode(this.densityDpi)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "VDConfig(name=" + this.name + ", widthPixels=" + this.widthPixels + ", heightPixels=" + this.heightPixels + ", densityDpi=" + this.densityDpi + ", type=" + this.type + ')';
    }

    public VDConfig(String r2, int r3, int r4, int r5, Type r6) {
        o.e(r2, "name");
        o.e(r6, "type");
        this.name = r2;
        this.widthPixels = r3;
        this.heightPixels = r4;
        this.densityDpi = r5;
        this.type = r6;
    }

    public final String getName() {
        return this.name;
    }

    public final int getWidthPixels() {
        return this.widthPixels;
    }

    public final int getHeightPixels() {
        return this.heightPixels;
    }

    public final int getDensityDpi() {
        return this.densityDpi;
    }

    public final Type getType() {
        return this.type;
    }
}
