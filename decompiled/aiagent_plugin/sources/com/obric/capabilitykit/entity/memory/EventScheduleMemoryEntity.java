package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
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
public final class EventScheduleMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String address;
    private String date;
    private String endDate;
    private String endTime;
    private String scheduleNme;
    private String startTime;

    public static final class CREATOR implements Parcelable.Creator<EventScheduleMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventScheduleMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity");
            return (EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r1, EventScheduleMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventScheduleMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventScheduleMemoryEntity[] newArray(int r1) {
            return new EventScheduleMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventScheduleMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventScheduleMemoryEntity(Parcel r18) {
        o.e(r18, "parcel");
        this(EntityExtKt.a(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.a(r18), EntityExtKt.a(r18), EntityExtKt.a(r18), r18.readString(), r18.readString(), null, 512, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 1, r18.readInt());
    }

    public EventScheduleMemoryEntity(String r13, long r14, long r16, int r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        o.e(r13, DbHelper.COL_ID);
        o.e(r19, "scheduleNme");
        o.e(r20, "date");
        o.e(r21, "startTime");
        super(r13, r14, r16, EntityType.MEMORY_EVENT_SCHEDULE, r18);
        this.scheduleNme = r19;
        this.date = r20;
        this.startTime = r21;
        this.endTime = r22;
        this.address = r23;
        this.endDate = r24;
    }

    public /* synthetic */ EventScheduleMemoryEntity(String r17, long r18, long r20, int r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29, h r30) {
        if ((r29 & 128) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r29 & 256) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r29 & 512) == 0) goto L13;
        String r15 = null;
    L14:
        this(r17, r18, r20, r22, r23, r24, r25, r13, r14, r15);
        return;
    L13:
        r15 = r28;
        goto L14
    L9:
        r14 = r27;
        goto L11
    L5:
        r13 = r26;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("scheduleNme", makeModelInputValue("日程名称", this.scheduleNme));
        r0.put("startTime", makeModelInputValue("日程开始时间", this.startTime));
        String r1 = this.endTime;
        if (r1 == null) goto L5;
        o.a(r1);
        r0.put("endTime", makeModelInputValue("日程结束时间", r1));
    L5:
        String r2 = this.endDate;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        String r4 = "date";
        if (r3 == false) goto L15;
        JSONObject r5 = makeModelInputValue("日期", this.date);
    L16:
        r0.put(r4, r5);
        String r6 = this.address;
        if (r6 == null) goto L19;
        o.a(r6);
        r0.put(SensitiveType.ADDRESS, makeModelInputValue("地点", r6));
    L19:
        return r0;
    L15:
        r0.put("date", makeModelInputValue("日程开始日期", this.date));
        String r7 = this.endDate;
        o.a(r7);
        r5 = makeModelInputValue("日程结束日期", r7);
        r4 = "endDate";
        goto L16
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getScheduleNme() {
        return this.scheduleNme;
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

    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.endDate = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public final void setDate(String r2) {
        o.e(r2, "<set-?>");
        this.date = r2;
    }

    public final void setEndDate(String r1) {
        this.endDate = r1;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final void setScheduleNme(String r2) {
        o.e(r2, "<set-?>");
        this.scheduleNme = r2;
    }

    public final void setStartTime(String r2) {
        o.e(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.scheduleNme);
        r2.writeString(this.date);
        r2.writeString(this.startTime);
        r2.writeString(this.endTime);
        r2.writeString(this.address);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(1);
        r2.writeValue(this.endDate);
    }
}
