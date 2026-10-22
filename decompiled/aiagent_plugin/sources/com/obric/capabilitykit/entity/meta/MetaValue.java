package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MetaValue implements Parcelable {
    public static final CREATOR CREATOR = null;
    private int type;

    public static final class CREATOR implements Parcelable.Creator<MetaValue> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaValue createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            throw new UnsupportedOperationException("can't construct MetaValue");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaValue createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final MetaValue fromJson(String r2) {
            o.e(r2, "json");
            Object r1 = EntityExtKt.a().fromJson(r2, MetaValue.class);
            o.c(r1, "entityGson.fromJson(json, MetaValue::class.java)");
            return (MetaValue) ZeusTransformUtils.preCheckCast(r1, MetaValue.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaValue[] newArray(int r1) {
            return new MetaValue[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaValue[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaValue() {
    }

    public MetaValue(int r1) {
        this();
        this.type = r1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public abstract void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3);

    public final void readMetaValueExtensionField$capabilitykitcommon_release(Parcel r3, int r4, int r5) {
        o.e(r3, "parcel");
        if (r5 > r4) goto L6;
        r4 = r5;
    L6:
        ClassLoader r0 = MetaValue.class.getClassLoader();
        int r1 = 1;
    L7:
        if (r1 > r4) goto L9;
        onReadMetaValueExtensionField$capabilitykitcommon_release(r3, r0, r1);
        r1 = r1 + 1;
    L9:
        if (r1 > r5) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r3, r0);
        r1 = r1 + 1;
        goto L9
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        throw new UnsupportedOperationException("MetaValue can't writeToParcel");
    }
}
