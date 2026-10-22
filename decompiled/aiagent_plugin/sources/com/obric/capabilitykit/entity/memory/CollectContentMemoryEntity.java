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
public final class CollectContentMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String appName;
    private String appPkgName;
    private String summary;
    private List<String> tags;
    private String title;

    public static final class CREATOR implements Parcelable.Creator<CollectContentMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectContentMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity");
            return (CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r1, CollectContentMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectContentMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectContentMemoryEntity[] newArray(int r1) {
            return new CollectContentMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectContentMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CollectContentMemoryEntity(Parcel r14) {
        o.e(r14, "parcel");
        this(EntityExtKt.a(r14), r14.readLong(), r14.readLong(), r14.readInt(), EntityExtKt.a(r14), EntityExtKt.a(r14), r14.readString(), r14.readString(), r14.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    public CollectContentMemoryEntity(String r13, long r14, long r16, int r18, String r19, String r20, String r21, String r22, List<String> r23) {
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        o.e(r13, DbHelper.COL_ID);
        o.e(r19, DBDefinition.TITLE);
        o.e(r20, "summary");
        super(r13, r14, r16, EntityType.MEMORY_COLLECT_CONTENT, r18);
        this.title = r19;
        this.summary = r20;
        this.appName = r21;
        this.appPkgName = r22;
        this.tags = r11;
    }

    public /* synthetic */ CollectContentMemoryEntity(String r17, long r18, long r20, int r22, String r23, String r24, String r25, String r26, List r27, int r28, h r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
        if ((r28 & 64) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r28 & 128) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r28 & 256) == 0) goto L13;
        List r15 = null;
    L14:
        this(r17, r18, r20, r22, r23, r24, r13, r14, r15);
        return;
    L13:
        r15 = r1;
        goto L14
    L9:
        r14 = r26;
        goto L11
    L5:
        r13 = r25;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put(DBDefinition.TITLE, makeModelInputValue("内容标题", this.title));
        r0.put("summary", makeModelInputValue("摘要", this.summary));
        String r1 = this.appName;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("appName", makeModelInputValue("内容平台", r1));
    L5:
        List<String> r2 = this.tags;
        if (r2 == null) goto L8;
        r0.put("tags", makeModelInputValue("标签", String.valueOf(r2)));
    L8:
        return r0;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPkgName() {
        return this.appPkgName;
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

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setAppPkgName(String r1) {
        this.appPkgName = r1;
    }

    public final void setSummary(String r2) {
        o.e(r2, "<set-?>");
        this.summary = r2;
    }

    public final void setTags(List<String> r3) {
        this.tags = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setTitle(String r2) {
        o.e(r2, "<set-?>");
        this.title = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.title);
        r2.writeString(this.summary);
        r2.writeString(this.appName);
        r2.writeString(this.appPkgName);
        r2.writeStringList(this.tags);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
