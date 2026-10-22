package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class Preview extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private String vid;

    public static final class CREATOR implements Parcelable.Creator<Preview> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Preview createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new Preview(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Preview createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Preview[] newArray(int r1) {
            return new Preview[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Preview[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public Preview(Parcel r3) {
        o.e(r3, "parcel");
        this(EntityExtKt.a(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public Preview(String r2) {
        o.e(r2, "vid");
        super(MetaType.Preview);
        this.vid = r2;
    }

    public static /* synthetic */ Preview copy$default(Preview r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.vid;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.vid;
    }

    public final Preview copy(String r1) {
        o.e(r1, "vid");
        return new Preview(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Preview.class) == true) goto L8;
        return false;
    L8:
        Preview r6 = (Preview) ZeusTransformUtils.preCheckCast(r5, Preview.class, "com.obric.aiagent.plugin");
        if (o.a(this.vid, r6.vid) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getVid() {
        return this.vid;
    }

    public int hashCode() {
        return this.vid.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setVid(String r2) {
        o.e(r2, "<set-?>");
        this.vid = r2;
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "Preview(vid=" + this.vid + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.vid);
        r1.writeInt(0);
    }
}
