package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.o.k;

/* JADX INFO: loaded from: classes4.dex */
public final class ExtraEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final String KEY_EXTRA_1 = "extra1";
    public static final String KEY_EXTRA_10 = "extra10";
    public static final String KEY_EXTRA_2 = "extra2";
    public static final String KEY_EXTRA_3 = "extra3";
    public static final String KEY_EXTRA_4 = "extra4";
    public static final String KEY_EXTRA_5 = "extra5";
    public static final String KEY_EXTRA_6 = "extra6";
    public static final String KEY_EXTRA_7 = "extra7";
    public static final String KEY_EXTRA_8 = "extra8";
    public static final String KEY_EXTRA_9 = "extra9";
    private static final int VERSION = 0;
    private final boolean isSemantic;
    private final String key;
    private Object value;

    public static final class CREATOR implements Parcelable.Creator<ExtraEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtraEntity createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new ExtraEntity(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final ExtraEntity fromJson(String r2) {
            o.e(r2, "json");
            Object r1 = EntityExtKt.a().fromJson(r2, ExtraEntity.class);
            o.c(r1, "entityGson.fromJson(json, ExtraEntity::class.java)");
            return (ExtraEntity) ZeusTransformUtils.preCheckCast(r1, ExtraEntity.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtraEntity[] newArray(int r1) {
            return new ExtraEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ExtraEntity(Parcel r4) {
        o.e(r4, "parcel");
        this(EntityExtKt.a(r4), r4.readValue(ExtraEntity.class.getClassLoader()), EntityExtKt.b(r4));
        readExtensionField(r4, r4.readInt());
    }

    public ExtraEntity(String r2, Object r3, boolean r4) {
        o.e(r2, "key");
        this.key = r2;
        this.value = r3;
        this.isSemantic = r4;
        if (isValidExtraString(r2) == false) goto L10;
        if (EntityExtKt.a(this.value) == false) goto L7;
        return;
    L7:
        StringBuilder r5 = new StringBuilder().append("ExtraEntity's value type ");
        Object r1 = this.value;
        o.a(r1);
        throw new IllegalArgumentException(r5.append(r1.getClass().getName()).append(" is not supported").toString());
    L10:
        throw new IllegalArgumentException("ExtraEntity's key " + r2 + " is not valid, must be extraN (N is 1-10)");
    }

    public /* synthetic */ ExtraEntity(String r1, Object r2, boolean r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    private final void readExtensionField(Parcel r3, int r4) {
        if (r4 <= 0) goto L4;
        int r2 = 0;
    L5:
        ClassLoader r0 = ExtraEntity.class.getClassLoader();
        int r1 = 1;
    L6:
        if (r1 > r2) goto L8;
        r1 = r1 + 1;
    L8:
        if (r1 > r4) goto L10;
        ParcelUtils.INSTANCE.skipValueSafely(r3, r0);
        r1 = r1 + 1;
        goto L8
    L10:
        return;
    L4:
        r2 = r4;
        goto L5
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final boolean isValidExtraString(String r2) {
        o.e(r2, "key");
        return new k("^extra([1-9]|10)$").a(r2);
    }

    public final void setValue(Object r1) {
        this.value = r1;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.key);
        r1.writeValue(this.value);
        EntityExtKt.a(r1, this.isSemantic);
        r1.writeInt(0);
    }
}
