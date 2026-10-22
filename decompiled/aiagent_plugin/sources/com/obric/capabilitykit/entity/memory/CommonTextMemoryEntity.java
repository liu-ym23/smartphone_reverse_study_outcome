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
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonTextMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 0;
    private String category;
    private String memoryCreateTime;
    private String summary;
    private List<String> tagList;
    private String title;

    public static final class CREATOR implements Parcelable.Creator<CommonTextMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonTextMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity");
            return (CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CommonTextMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommonTextMemoryEntity[] newArray(int r1) {
            return new CommonTextMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonTextMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CommonTextMemoryEntity(Parcel r17) {
        o.e(r17, "parcel");
        this(EntityExtKt.a(r17), r17.readLong(), r17.readLong(), r17.readInt(), EntityExtKt.a(r17), r17.readString(), null, null, null, 448, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 3, r17.readInt());
    }

    public CommonTextMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, List<String> r21, String r22) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        o.e(r12, DbHelper.COL_ID);
        o.e(r18, "summary");
        super(r12, r13, r15, EntityType.MEMORY_COMMON_TEXT, r17);
        this.summary = r18;
        this.memoryCreateTime = r19;
        this.title = r20;
        this.tagList = r10;
        this.category = r22;
    }

    public /* synthetic */ CommonTextMemoryEntity(String r17, long r18, long r20, int r22, String r23, String r24, String r25, List r26, String r27, int r28, h r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        if ((r28 & 32) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r28 & 64) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r28 & 128) == 0) goto L13;
        List r14 = null;
    L15:
        if ((r28 & 256) == 0) goto L17;
        String r15 = null;
    L18:
        this(r17, r18, r20, r22, r23, r12, r13, r14, r15);
        return;
    L17:
        r15 = r27;
        goto L18
    L13:
        r14 = r1;
        goto L15
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
        r0.put(DBDefinition.TITLE, this.title);
        r0.put("summary", makeModelInputValue("总结的记忆内容", this.summary));
        String r1 = this.memoryCreateTime;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("memoryCreateTime", makeModelInputValue("记忆时间", r1));
    L5:
        return r0;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getMemoryCreateTime() {
        return this.memoryCreateTime;
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

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTagList() {
        return this.tagList;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r4, ClassLoader r5, int r6) {
        o.e(r4, "parcel");
        if (r6 == 1) goto L17;
        List<String> r2 = null;
        String r3 = null;
        if (r6 != 2) goto L7;
        Object r7 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r7, List.class) == false) goto L16;
        r2 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L16:
        this.tagList = r2;
        return;
    L7:
        if (r6 != 3) goto L21;
        Object r8 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L12;
        r3 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L12:
        this.category = r3;
        return;
    L21:
        return;
    L17:
        this.title = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
    }

    public final void setCategory(String r1) {
        this.category = r1;
    }

    public final void setMemoryCreateTime(String r1) {
        this.memoryCreateTime = r1;
    }

    public final void setSummary(String r2) {
        o.e(r2, "<set-?>");
        this.summary = r2;
    }

    public final void setTagList(List<String> r3) {
        this.tagList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.summary);
        r2.writeString(this.memoryCreateTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(3);
        r2.writeValue(this.title);
        r2.writeValue(this.tagList);
        r2.writeValue(this.category);
    }
}
