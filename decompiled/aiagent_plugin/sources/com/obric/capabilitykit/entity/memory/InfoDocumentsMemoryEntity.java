package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class InfoDocumentsMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String idNumber;
    private String idType;
    private String person;

    public static final class CREATOR implements Parcelable.Creator<InfoDocumentsMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoDocumentsMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity");
            return (InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoDocumentsMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoDocumentsMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoDocumentsMemoryEntity[] newArray(int r1) {
            return new InfoDocumentsMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoDocumentsMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InfoDocumentsMemoryEntity(Parcel r12) {
        o.e(r12, "parcel");
        this(EntityExtKt.a(r12), r12.readLong(), r12.readLong(), r12.readInt(), EntityExtKt.a(r12), EntityExtKt.a(r12), r12.readString());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 0, r12.readInt());
    }

    public InfoDocumentsMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20) {
        o.e(r12, DbHelper.COL_ID);
        o.e(r18, "idType");
        o.e(r19, "idNumber");
        super(r12, r13, r15, EntityType.MEMORY_INFO_DOCUMENTS, r17);
        this.idType = r18;
        this.idNumber = r19;
        this.person = r20;
    }

    public /* synthetic */ InfoDocumentsMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, int r21, h r22) {
        if ((r21 & 64) == 0) goto L5;
        String r10 = null;
    L6:
        this(r12, r13, r15, r17, r18, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("idType", makeModelInputValue("证件类型", this.idType));
        r0.put("idNumber", makeModelInputValue("证件号码", this.idNumber));
        String r1 = this.person;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("person", makeModelInputValue("证件人", r1));
    L5:
        return r0;
    }

    public final String getIdNumber() {
        return this.idNumber;
    }

    public final String getIdType() {
        return this.idType;
    }

    public final String getPerson() {
        return this.person;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = getScreenshot();
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p.b();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setIdNumber(String r2) {
        o.e(r2, "<set-?>");
        this.idNumber = r2;
    }

    public final void setIdType(String r2) {
        o.e(r2, "<set-?>");
        this.idType = r2;
    }

    public final void setPerson(String r1) {
        this.person = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.idType);
        r2.writeString(this.idNumber);
        r2.writeString(this.person);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
