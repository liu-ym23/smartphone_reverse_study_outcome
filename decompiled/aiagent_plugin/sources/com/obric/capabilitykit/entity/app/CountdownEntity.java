package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class CountdownEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 1;
    private long countdownSeconds;
    private String label;
    private CountdownStatusEnum status;

    public static final class CREATOR implements Parcelable.Creator<CountdownEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CountdownEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CountdownEntity");
            return (CountdownEntity) ZeusTransformUtils.preCheckCast(r1, CountdownEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CountdownEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CountdownEntity[] newArray(int r1) {
            return new CountdownEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CountdownEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CountdownEntity(Parcel r14) {
        o.e(r14, "parcel");
        this(EntityExtKt.a(r14), r14.readLong(), r14.readLong(), r14.readLong(), r14.readString(), null, 32, null);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 1, r14.readInt());
    }

    public CountdownEntity(String r9, long r10, long r12, long r14, String r16, CountdownStatusEnum r17) {
        o.e(r9, DbHelper.COL_ID);
        super(r9, r10, r12, EntityType.COUNTDOWN);
        this.countdownSeconds = r14;
        this.label = r16;
        this.status = r17;
    }

    public /* synthetic */ CountdownEntity(String r13, long r14, long r16, long r18, String r20, CountdownStatusEnum r21, int r22, h r23) {
        if ((r22 & 16) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r22 & 32) == 0) goto L9;
        CountdownStatusEnum r11 = null;
    L10:
        this(r13, r14, r16, r18, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }

    public final long getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final String getLabel() {
        return this.label;
    }

    public final CountdownStatusEnum getStatus() {
        return this.status;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.status = CountdownStatusEnum.Companion.a((String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setCountdownSeconds(long r1) {
        this.countdownSeconds = r1;
    }

    public final void setLabel(String r1) {
        this.label = r1;
    }

    public final void setStatus(CountdownStatusEnum r1) {
        this.status = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeLong(this.countdownSeconds);
        r3.writeString(this.label);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeInt(1);
        CountdownStatusEnum r2 = this.status;
        if (r2 == null) goto L5;
        String r5 = r2.name();
    L6:
        r3.writeValue(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
