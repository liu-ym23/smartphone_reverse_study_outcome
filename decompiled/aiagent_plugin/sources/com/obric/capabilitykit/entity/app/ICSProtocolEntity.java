package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class ICSProtocolEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String doubaoUid;
    private String iCal;

    public static final class CREATOR implements Parcelable.Creator<ICSProtocolEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ICSProtocolEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ICSProtocolEntity");
            return (ICSProtocolEntity) ZeusTransformUtils.preCheckCast(r1, ICSProtocolEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ICSProtocolEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ICSProtocolEntity[] newArray(int r1) {
            return new ICSProtocolEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ICSProtocolEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ICSProtocolEntity(Parcel r10) {
        o.e(r10, "parcel");
        this(EntityExtKt.a(r10), r10.readLong(), r10.readLong(), EntityExtKt.a(r10), r10.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 0, r10.readInt());
    }

    public ICSProtocolEntity(String r9, long r10, long r12, String r14, String r15) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "doubaoUid");
        super(r9, r10, r12, 402);
        this.doubaoUid = r14;
        this.iCal = r15;
    }

    public /* synthetic */ ICSProtocolEntity(String r10, long r11, long r13, String r15, String r16, int r17, h r18) {
        if ((r17 & 16) == 0) goto L5;
        String r8 = null;
    L6:
        this(r10, r11, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final String getDoubaoUid() {
        return this.doubaoUid;
    }

    public final String getICal() {
        return this.iCal;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setDoubaoUid(String r2) {
        o.e(r2, "<set-?>");
        this.doubaoUid = r2;
    }

    public final void setICal(String r1) {
        this.iCal = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.doubaoUid);
        r1.writeString(this.iCal);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}
