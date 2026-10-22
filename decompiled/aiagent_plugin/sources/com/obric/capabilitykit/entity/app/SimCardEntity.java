package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class SimCardEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String anonymizedPhoneNumber;
    private String phoneNumber;
    private String simCarrier;
    private String simSlot;

    public static final class CREATOR implements Parcelable.Creator<SimCardEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimCardEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.SimCardEntity");
            return (SimCardEntity) ZeusTransformUtils.preCheckCast(r1, SimCardEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SimCardEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimCardEntity[] newArray(int r1) {
            return new SimCardEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SimCardEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public SimCardEntity(Parcel r12) {
        o.e(r12, "parcel");
        this(EntityExtKt.a(r12), r12.readLong(), r12.readLong(), EntityExtKt.a(r12), r12.readString(), r12.readString(), r12.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 0, r12.readInt());
    }

    public SimCardEntity(String r10, long r11, long r13, String r15, String r16, String r17, String r18) {
        o.e(r10, DbHelper.COL_ID);
        o.e(r15, "simSlot");
        super(r10, r11, r13, EntityType.SIM_CARD);
        this.simSlot = r15;
        this.simCarrier = r16;
        this.phoneNumber = r17;
        this.anonymizedPhoneNumber = r18;
    }

    public /* synthetic */ SimCardEntity(String r13, long r14, long r16, String r18, String r19, String r20, String r21, int r22, h r23) {
        if ((r22 & 16) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r22 & 32) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r22 & 64) == 0) goto L13;
        String r11 = null;
    L14:
        this(r13, r14, r16, r18, r9, r10, r11);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    public final String getAnonymizedPhoneNumber() {
        return this.anonymizedPhoneNumber;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getSimCarrier() {
        return this.simCarrier;
    }

    public final String getSimSlot() {
        return this.simSlot;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setAnonymizedPhoneNumber(String r1) {
        this.anonymizedPhoneNumber = r1;
    }

    public final void setPhoneNumber(String r1) {
        this.phoneNumber = r1;
    }

    public final void setSimCarrier(String r1) {
        this.simCarrier = r1;
    }

    public final void setSimSlot(String r2) {
        o.e(r2, "<set-?>");
        this.simSlot = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.simSlot);
        r1.writeString(this.simCarrier);
        r1.writeString(this.phoneNumber);
        r1.writeString(this.anonymizedPhoneNumber);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}
