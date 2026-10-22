package com.obric.aiagent.assistant.idl.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OSkillManagerConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OSkillManagerConfig implements Parcelable {
    public static final Parcelable.Creator<OSkillManagerConfig> CREATOR = null;
    public static final a Companion = null;
    public static final boolean DEFAULT_SKILL_EXTENSION_ENABLED = true;
    public static final String KEY_SKILL_EXTENSION_ENABLED = "skill_extension_enabled";
    private final Bundle values;

    /* JADX INFO: compiled from: OSkillManagerConfig.kt */
    public static final class Creator implements Parcelable.Creator<OSkillManagerConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OSkillManagerConfig createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new OSkillManagerConfig(r2.readBundle(OSkillManagerConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OSkillManagerConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OSkillManagerConfig[] newArray(int r1) {
            return new OSkillManagerConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OSkillManagerConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: OSkillManagerConfig.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSkillManagerConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OSkillManagerConfig copy$default(OSkillManagerConfig r0, Bundle r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.values;
    L6:
        return r0.copy(r1);
    }

    public final Bundle component1() {
        return this.values;
    }

    public final OSkillManagerConfig copy(Bundle r1) {
        o.e(r1, "values");
        return new OSkillManagerConfig(r1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OSkillManagerConfig.class) == true) goto L8;
        return false;
    L8:
        OSkillManagerConfig r6 = (OSkillManagerConfig) ZeusTransformUtils.preCheckCast(r5, OSkillManagerConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.values, r6.values) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public String toString() {
        return "OSkillManagerConfig(values=" + this.values + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeBundle(this.values);
    }

    public OSkillManagerConfig(Bundle r2) {
        o.e(r2, "values");
        this.values = r2;
    }

    public /* synthetic */ OSkillManagerConfig(Bundle r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new Bundle();
    L5:
        this(r1);
    }

    public final Bundle getValues() {
        return this.values;
    }

    public final <T> T getValue(String r3, T r4) {
        o.e(r3, "key");
        Object r2 = this.values.get(r3);
        if (r2 != null) goto L5;
        return r4;
    L5:
        String r0 = null;
        Boolean r1 = null;
        Integer r5 = null;
        Long r6 = null;
        Double r7 = null;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L10;
        r1 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");
    L10:
        if (r1 == null) goto L12;
        boolean r8 = r1.booleanValue();
    L50:
        return (T) ZeusTransformUtils.preCheckCast(Boolean.valueOf(r8), Object.class, "com.obric.aiagent.plugin");
    L12:
        r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        goto L50
    L15:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L19;
        r5 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
    L19:
        if (r5 == null) goto L21;
        int r9 = r5.intValue();
    L51:
        return (T) ZeusTransformUtils.preCheckCast(Integer.valueOf(r9), Object.class, "com.obric.aiagent.plugin");
    L21:
        r9 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L51
    L24:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L28;
        r6 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin");
    L28:
        if (r6 == null) goto L30;
        long r10 = r6.longValue();
    L52:
        return (T) ZeusTransformUtils.preCheckCast(Long.valueOf(r10), Object.class, "com.obric.aiagent.plugin");
    L30:
        r10 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue();
        goto L52
    L33:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L42;
        if (ZeusTransformUtils.instanceOf(r2, Double.class) == false) goto L37;
        r7 = (Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.aiagent.plugin");
    L37:
        if (r7 == null) goto L39;
        double r11 = r7.doubleValue();
    L53:
        return (T) ZeusTransformUtils.preCheckCast(Double.valueOf(r11), Object.class, "com.obric.aiagent.plugin");
    L39:
        r11 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).doubleValue();
        goto L53
    L42:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L44;
        return r4;
    L44:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L46;
        r0 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L46:
        if (r0 != null) goto L49;
        r0 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L49:
        return (T) ZeusTransformUtils.preCheckCast(r0, Object.class, "com.obric.aiagent.plugin");
    }
}
