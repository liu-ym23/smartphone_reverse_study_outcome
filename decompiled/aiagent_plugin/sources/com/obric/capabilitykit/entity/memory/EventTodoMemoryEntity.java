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
public final class EventTodoMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String content;
    private String endDate;
    private String endTime;

    public static final class CREATOR implements Parcelable.Creator<EventTodoMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTodoMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity");
            return (EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r1, EventTodoMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTodoMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventTodoMemoryEntity[] newArray(int r1) {
            return new EventTodoMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTodoMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventTodoMemoryEntity(Parcel r12) {
        o.e(r12, "parcel");
        this(EntityExtKt.a(r12), r12.readLong(), r12.readLong(), r12.readInt(), EntityExtKt.a(r12), r12.readString(), r12.readString());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 0, r12.readInt());
    }

    public EventTodoMemoryEntity(String r11, long r12, long r14, int r16, String r17, String r18, String r19) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r17, "content");
        super(r11, r12, r14, EntityType.MEMORY_EVENT_TODO, r16);
        this.content = r17;
        this.endDate = r18;
        this.endTime = r19;
    }

    public /* synthetic */ EventTodoMemoryEntity(String r13, long r14, long r16, int r18, String r19, String r20, String r21, int r22, h r23) {
        if ((r22 & 32) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r22 & 64) == 0) goto L9;
        String r11 = null;
    L10:
        this(r13, r14, r16, r18, r19, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("content", makeModelInputValue("待办内容", this.content));
        String r1 = this.endDate;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("endDate", makeModelInputValue("待办截止日期", r1));
    L5:
        String r2 = this.endTime;
        if (r2 == null) goto L8;
        o.a(r2);
        r0.put("endTime", makeModelInputValue("待办截止时间", r2));
    L8:
        return r0;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getEndTime() {
        return this.endTime;
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

    public final void setContent(String r2) {
        o.e(r2, "<set-?>");
        this.content = r2;
    }

    public final void setEndDate(String r1) {
        this.endDate = r1;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.content);
        r2.writeString(this.endDate);
        r2.writeString(this.endTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
