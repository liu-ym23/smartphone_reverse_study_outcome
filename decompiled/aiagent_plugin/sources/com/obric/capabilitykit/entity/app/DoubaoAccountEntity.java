package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class DoubaoAccountEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String doubaoUid;

    public static final class CREATOR implements Parcelable.Creator<DoubaoAccountEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DoubaoAccountEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.DoubaoAccountEntity");
            return (DoubaoAccountEntity) ZeusTransformUtils.preCheckCast(r1, DoubaoAccountEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DoubaoAccountEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DoubaoAccountEntity[] newArray(int r1) {
            return new DoubaoAccountEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DoubaoAccountEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public DoubaoAccountEntity(Parcel r9) {
        o.e(r9, "parcel");
        this(EntityExtKt.a(r9), r9.readLong(), r9.readLong(), EntityExtKt.a(r9));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r9);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r9, 0, r9.readInt());
    }

    public DoubaoAccountEntity(String r9, long r10, long r12, String r14) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "doubaoUid");
        super(r9, r10, r12, 1301);
        this.doubaoUid = r14;
    }

    public final String getDoubaoUid() {
        return this.doubaoUid;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setDoubaoUid(String r2) {
        o.e(r2, "<set-?>");
        this.doubaoUid = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.doubaoUid);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}
