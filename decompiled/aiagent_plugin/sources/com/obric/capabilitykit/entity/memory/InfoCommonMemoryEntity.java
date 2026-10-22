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
public final class InfoCommonMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 0;
    private String infoKey;
    private String infoValue;
    private String observation;
    private String relatedMemoryids;
    private String tag;

    public static final class CREATOR implements Parcelable.Creator<InfoCommonMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoCommonMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity");
            return (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoCommonMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoCommonMemoryEntity[] newArray(int r1) {
            return new InfoCommonMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    public static final class InfoKeyType {
        public static final String ADDRESS = "地址";
        public static final String ANNIVERSARY = "纪念日";
        public static final String IDENTIFICATION = "证件";
        public static final InfoKeyType INSTANCE = null;
        public static final String RELATIONSHIP = "关系";

        static {
            INSTANCE = new InfoKeyType();
        }

        private InfoKeyType() {
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InfoCommonMemoryEntity(Parcel r17) {
        o.e(r17, "parcel");
        this(EntityExtKt.a(r17), r17.readLong(), r17.readLong(), r17.readInt(), EntityExtKt.a(r17), EntityExtKt.a(r17), null, null, null, 448, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 3, r17.readInt());
    }

    public InfoCommonMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, String r21, String r22) {
        o.e(r12, DbHelper.COL_ID);
        o.e(r18, "infoKey");
        o.e(r19, "infoValue");
        super(r12, r13, r15, EntityType.MEMORY_INFO_COMMON, r17);
        this.infoKey = r18;
        this.infoValue = r19;
        this.observation = r20;
        this.relatedMemoryids = r21;
        this.tag = r22;
    }

    public /* synthetic */ InfoCommonMemoryEntity(String r16, long r17, long r19, int r21, String r22, String r23, String r24, String r25, String r26, int r27, h r28) {
        if ((r27 & 64) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r27 & 128) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r27 & 256) == 0) goto L13;
        String r14 = null;
    L14:
        this(r16, r17, r19, r21, r22, r23, r12, r13, r14);
        return;
    L13:
        r14 = r26;
        goto L14
    L9:
        r13 = r25;
        goto L11
    L5:
        r12 = r24;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("infoKey", makeModelInputValue("信息类型", this.infoKey));
        r0.put("infoValue", makeModelInputValue("信息内容", this.infoValue));
        return r0;
    }

    public final String getInfoKey() {
        return this.infoKey;
    }

    public final String getInfoValue() {
        return this.infoValue;
    }

    public final String getObservation() {
        return this.observation;
    }

    public final String getRelatedMemoryids() {
        return this.relatedMemoryids;
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

    public final String getTag() {
        return this.tag;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        o.e(r3, "parcel");
        if (r5 != 1) goto L5;
        this.observation = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r5 != 2) goto L7;
        this.relatedMemoryids = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.aiagent.plugin");
        return;
    L7:
        if (r5 != 3) goto L15;
        this.tag = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setInfoKey(String r2) {
        o.e(r2, "<set-?>");
        this.infoKey = r2;
    }

    public final void setInfoValue(String r2) {
        o.e(r2, "<set-?>");
        this.infoValue = r2;
    }

    public final void setObservation(String r1) {
        this.observation = r1;
    }

    public final void setRelatedMemoryids(String r1) {
        this.relatedMemoryids = r1;
    }

    public final void setTag(String r1) {
        this.tag = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.infoKey);
        r2.writeString(this.infoValue);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(3);
        r2.writeValue(this.observation);
        r2.writeValue(this.relatedMemoryids);
        r2.writeValue(this.tag);
    }
}
