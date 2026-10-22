package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ScheduleEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 15;
    private static final int RELATED_VERSION = 2;
    private String address;
    private boolean allDay;
    private List<ContactEntity> attendees;
    private CalendarTypeEnum calendarType;
    private Boolean completed;
    private String endTime;
    private Long endTimestamp;
    private String iCalendarText;
    private String icsId;
    private boolean isFavorite;
    private Long jumpCalendarPageStartTimeStamp;
    private String name;
    private String note;
    private String rawRrule;
    private String recurrenceId;
    private String reminderDesc;
    private String repeatDescription;
    private String rruleDescription;
    private String startTime;
    private Long startTimestamp;
    private String timeDescription;

    public static final class CREATOR implements Parcelable.Creator<ScheduleEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ScheduleEntity");
            return (ScheduleEntity) ZeusTransformUtils.preCheckCast(r1, ScheduleEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 17;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleEntity[] newArray(int r1) {
            return new ScheduleEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ScheduleEntity(Parcel r11) {
        o.e(r11, "parcel");
        this(EntityExtKt.a(r11), r11.readLong(), r11.readLong(), EntityExtKt.a(r11), EntityExtKt.a(r11), EntityExtKt.a(r11));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r0 = r11.readInt();
        this.address = r11.readString();
        this.attendees = r11.createTypedArrayList(ContactEntity.CREATOR);
        this.repeatDescription = r11.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 15, r0);
    }

    public ScheduleEntity(String r12, long r13, long r15, String r17, String r18, String r19) {
        o.e(r12, DbHelper.COL_ID);
        o.e(r17, "name");
        o.e(r18, "startTime");
        o.e(r19, "endTime");
        super(r12, r13, r15, 401);
        this.name = r17;
        this.startTime = r18;
        this.endTime = r19;
        this.startTimestamp = d.o.o.e(r18);
        this.endTimestamp = d.o.o.e(this.endTime);
    }

    public final String getAddress() {
        return this.address;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    public final List<ContactEntity> getAttendees() {
        return this.attendees;
    }

    public final CalendarTypeEnum getCalendarType() {
        return this.calendarType;
    }

    public final Boolean getCompleted() {
        return this.completed;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final String getICalendarText() {
        return this.iCalendarText;
    }

    public final String getIcsId() {
        return this.icsId;
    }

    public final Long getJumpCalendarPageStartTimeStamp() {
        return this.jumpCalendarPageStartTimeStamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getRawRrule() {
        return this.rawRrule;
    }

    public final String getRecurrenceId() {
        return this.recurrenceId;
    }

    public final String getReminderDesc() {
        return this.reminderDesc;
    }

    public final String getRepeatDescription() {
        return this.repeatDescription;
    }

    public final String getRruleDescription() {
        return this.rruleDescription;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTimeDescription() {
        return this.timeDescription;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r4, ClassLoader r5, int r6) {
        o.e(r4, "parcel");
        Boolean r0 = null;
        CalendarTypeEnum r1 = null;
        switch(r6) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L41;
        };
    L5:
        this.rawRrule = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L6:
        this.jumpCalendarPageStartTimeStamp = (Long) ZeusTransformUtils.preCheckCast(r4.readValue(r5), Long.class, "com.obric.aiagent.plugin");
        return;
    L7:
        this.iCalendarText = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L8:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L11;
        r1 = CalendarTypeEnum.Companion.a(r7);
    L11:
        this.calendarType = r1;
        return;
    L12:
        this.recurrenceId = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L13:
        this.icsId = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L14:
        this.rruleDescription = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L15:
        this.timeDescription = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L16:
        this.reminderDesc = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L17:
        Object r8 = r4.readValue(r5);
        o.a(r8, "null cannot be cast to non-null type kotlin.Boolean");
        this.isFavorite = ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        return;
    L18:
        Object r9 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r9, Boolean.class) == false) goto L21;
        r0 = (Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin");
    L21:
        this.completed = r0;
        return;
    L22:
        this.note = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.aiagent.plugin");
        return;
    L23:
        Object r10 = r4.readValue(r5);
        o.a(r10, "null cannot be cast to non-null type kotlin.Boolean");
        this.allDay = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        return;
    L24:
        this.endTimestamp = (Long) ZeusTransformUtils.preCheckCast(r4.readValue(r5), Long.class, "com.obric.aiagent.plugin");
        return;
    L25:
        this.startTimestamp = (Long) ZeusTransformUtils.preCheckCast(r4.readValue(r5), Long.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public final void setAllDay(boolean r1) {
        this.allDay = r1;
    }

    public final void setAttendees(List<ContactEntity> r3) {
        this.attendees = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setCalendarType(CalendarTypeEnum r1) {
        this.calendarType = r1;
    }

    public final void setCompleted(Boolean r1) {
        this.completed = r1;
    }

    public final void setEndTime(String r2) {
        o.e(r2, "<set-?>");
        this.endTime = r2;
    }

    public final void setEndTimestamp(Long r1) {
        this.endTimestamp = r1;
    }

    public final void setFavorite(boolean r1) {
        this.isFavorite = r1;
    }

    public final void setICalendarText(String r1) {
        this.iCalendarText = r1;
    }

    public final void setIcsId(String r1) {
        this.icsId = r1;
    }

    public final void setJumpCalendarPageStartTimeStamp(Long r1) {
        this.jumpCalendarPageStartTimeStamp = r1;
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNote(String r1) {
        this.note = r1;
    }

    public final void setRawRrule(String r1) {
        this.rawRrule = r1;
    }

    public final void setRecurrenceId(String r1) {
        this.recurrenceId = r1;
    }

    public final void setReminderDesc(String r1) {
        this.reminderDesc = r1;
    }

    public final void setRepeatDescription(String r1) {
        this.repeatDescription = r1;
    }

    public final void setRruleDescription(String r1) {
        this.rruleDescription = r1;
    }

    public final void setStartTime(String r2) {
        o.e(r2, "<set-?>");
        this.startTime = r2;
    }

    public final void setStartTimestamp(Long r1) {
        this.startTimestamp = r1;
    }

    public final void setTimeDescription(String r1) {
        this.timeDescription = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(15);
        r1.writeString(this.address);
        r1.writeTypedList(this.attendees);
        r1.writeString(this.repeatDescription);
        r1.writeValue(this.startTimestamp);
        r1.writeValue(this.endTimestamp);
        r1.writeValue(Boolean.valueOf(this.allDay));
        r1.writeValue(this.note);
        r1.writeValue(this.completed);
        r1.writeValue(Boolean.valueOf(this.isFavorite));
        r1.writeValue(this.reminderDesc);
        r1.writeValue(this.timeDescription);
        r1.writeValue(this.rruleDescription);
        r1.writeValue(this.icsId);
        r1.writeValue(this.recurrenceId);
        CalendarTypeEnum r3 = this.calendarType;
        if (r3 == null) goto L5;
        String r4 = r3.name();
    L6:
        r1.writeValue(r4);
        r1.writeValue(this.iCalendarText);
        r1.writeValue(this.jumpCalendarPageStartTimeStamp);
        r1.writeValue(this.rawRrule);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
