package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class LifeLogEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String content;
    private String title;

    public static final class CREATOR implements Parcelable.Creator<LifeLogEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LifeLogEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.LifeLogEntity");
            return (LifeLogEntity) ZeusTransformUtils.preCheckCast(r1, LifeLogEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LifeLogEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LifeLogEntity[] newArray(int r1) {
            return new LifeLogEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LifeLogEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public LifeLogEntity(Parcel r10) {
        o.e(r10, "parcel");
        this(EntityExtKt.a(r10), r10.readLong(), r10.readLong(), EntityExtKt.a(r10), EntityExtKt.a(r10));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 0, r10.readInt());
    }

    public LifeLogEntity(String r9, long r10, long r12, String r14, String r15) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, DBDefinition.TITLE);
        o.e(r15, "content");
        super(r9, r10, r12, 1401);
        this.title = r14;
        this.content = r15;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setContent(String r2) {
        o.e(r2, "<set-?>");
        this.content = r2;
    }

    public final void setTitle(String r2) {
        o.e(r2, "<set-?>");
        this.title = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.title);
        r1.writeString(this.content);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}
