package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001`B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\"\u0010X\u001a\u00020Y2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]H\u0016J\u0018\u0010^\u001a\u00020Y2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010_\u001a\u00020]H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001e\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R\u001a\u0010:\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u001e\u0010<\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R\u001c\u0010A\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\u001c\u0010D\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R\u001c\u0010G\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012R\u001c\u0010J\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R\u001c\u0010M\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0010\"\u0004\bQ\u0010\u0012R\u001e\u0010R\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bS\u00100\"\u0004\bT\u00102R\u001c\u0010U\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012¨\u0006a"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "startTime", "endTime", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "address", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "allDay", "", "getAllDay", "()Z", "setAllDay", "(Z)V", "attendees", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getAttendees", "()Ljava/util/List;", "setAttendees", "(Ljava/util/List;)V", "calendarType", "Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "getCalendarType", "()Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "setCalendarType", "(Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;)V", "completed", "getCompleted", "()Ljava/lang/Boolean;", "setCompleted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndTime", "setEndTime", "endTimestamp", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "iCalendarText", "getICalendarText", "setICalendarText", "icsId", "getIcsId", "setIcsId", "isFavorite", "setFavorite", "jumpCalendarPageStartTimeStamp", "getJumpCalendarPageStartTimeStamp", "setJumpCalendarPageStartTimeStamp", "getName", "setName", "note", "getNote", "setNote", "recurrenceId", "getRecurrenceId", "setRecurrenceId", "reminderDesc", "getReminderDesc", "setReminderDesc", "repeatDescription", "getRepeatDescription", "setRepeatDescription", "rruleDescription", "getRruleDescription", "setRruleDescription", "getStartTime", "setStartTime", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "timeDescription", "getTimeDescription", "setTimeDescription", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScheduleEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 14;
    private static final int RELATED_VERSION = 2;

    @Nullable
    private String address;
    private boolean allDay;

    @Nullable
    private List<ContactEntity> attendees;

    @Nullable
    private CalendarTypeEnum calendarType;

    @Nullable
    private Boolean completed;

    @NotNull
    private String endTime;

    @Nullable
    private Long endTimestamp;

    @Nullable
    private String iCalendarText;

    @Nullable
    private String icsId;
    private boolean isFavorite;

    @Nullable
    private Long jumpCalendarPageStartTimeStamp;

    @NotNull
    private String name;

    @Nullable
    private String note;

    @Nullable
    private String recurrenceId;

    @Nullable
    private String reminderDesc;

    @Nullable
    private String repeatDescription;

    @Nullable
    private String rruleDescription;

    @NotNull
    private String startTime;

    @Nullable
    private Long startTimestamp;

    @Nullable
    private String timeDescription;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ScheduleEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ScheduleEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ScheduleEntity");
            return (ScheduleEntity) r11;
        }

        public final int getVersion() {
            return 16;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ScheduleEntity[] newArray(int r10) {
            return new ScheduleEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ScheduleEntity(@NotNull Parcel r11) {
        q.g(r11, "parcel");
        this(EntityExtKt.f(r11), r11.readLong(), r11.readLong(), EntityExtKt.f(r11), EntityExtKt.f(r11), EntityExtKt.f(r11));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r10 = r11.readInt();
        this.address = r11.readString();
        this.attendees = r11.createTypedArrayList(ContactEntity.CREATOR);
        this.repeatDescription = r11.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 14, r10);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    @Nullable
    public final List<ContactEntity> getAttendees() {
        return this.attendees;
    }

    @Nullable
    public final CalendarTypeEnum getCalendarType() {
        return this.calendarType;
    }

    @Nullable
    public final Boolean getCompleted() {
        return this.completed;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Nullable
    public final String getICalendarText() {
        return this.iCalendarText;
    }

    @Nullable
    public final String getIcsId() {
        return this.icsId;
    }

    @Nullable
    public final Long getJumpCalendarPageStartTimeStamp() {
        return this.jumpCalendarPageStartTimeStamp;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNote() {
        return this.note;
    }

    @Nullable
    public final String getRecurrenceId() {
        return this.recurrenceId;
    }

    @Nullable
    public final String getReminderDesc() {
        return this.reminderDesc;
    }

    @Nullable
    public final String getRepeatDescription() {
        return this.repeatDescription;
    }

    @Nullable
    public final String getRruleDescription() {
        return this.rruleDescription;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    @Nullable
    public final String getTimeDescription() {
        return this.timeDescription;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        Boolean r13 = null;
        CalendarTypeEnum r14 = null;
        switch(r12) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L5;
            default: goto L39;
        };
    L5:
        this.jumpCalendarPageStartTimeStamp = (Long) r10.readValue(r11);
        return;
    L6:
        this.iCalendarText = (String) r10.readValue(r11);
        return;
    L7:
        String r15 = (String) r10.readValue(r11);
        if (r15 == null) goto L10;
        r14 = CalendarTypeEnum.Companion.a(r15);
    L10:
        this.calendarType = r14;
        return;
    L11:
        this.recurrenceId = (String) r10.readValue(r11);
        return;
    L12:
        this.icsId = (String) r10.readValue(r11);
        return;
    L13:
        this.rruleDescription = (String) r10.readValue(r11);
        return;
    L14:
        this.timeDescription = (String) r10.readValue(r11);
        return;
    L15:
        this.reminderDesc = (String) r10.readValue(r11);
        return;
    L16:
        Object r16 = r10.readValue(r11);
        q.e(r16, "null cannot be cast to non-null type kotlin.Boolean");
        this.isFavorite = ((Boolean) r16).booleanValue();
        return;
    L17:
        Object r17 = r10.readValue(r11);
        if ((r17 instanceof Boolean) == false) goto L20;
        r13 = (Boolean) r17;
    L20:
        this.completed = r13;
        return;
    L21:
        this.note = (String) r10.readValue(r11);
        return;
    L22:
        Object r18 = r10.readValue(r11);
        q.e(r18, "null cannot be cast to non-null type kotlin.Boolean");
        this.allDay = ((Boolean) r18).booleanValue();
        return;
    L23:
        this.endTimestamp = (Long) r10.readValue(r11);
        return;
    L24:
        this.startTimestamp = (Long) r10.readValue(r11);
        return;
    }

    public final void setAddress(@Nullable String r10) {
        this.address = r10;
    }

    public final void setAllDay(boolean r10) {
        this.allDay = r10;
    }

    public final void setAttendees(@Nullable List<ContactEntity> r10) {
        this.attendees = r10;
    }

    public final void setCalendarType(@Nullable CalendarTypeEnum r10) {
        this.calendarType = r10;
    }

    public final void setCompleted(@Nullable Boolean r10) {
        this.completed = r10;
    }

    public final void setEndTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.endTime = r10;
    }

    public final void setEndTimestamp(@Nullable Long r10) {
        this.endTimestamp = r10;
    }

    public final void setFavorite(boolean r10) {
        this.isFavorite = r10;
    }

    public final void setICalendarText(@Nullable String r10) {
        this.iCalendarText = r10;
    }

    public final void setIcsId(@Nullable String r10) {
        this.icsId = r10;
    }

    public final void setJumpCalendarPageStartTimeStamp(@Nullable Long r10) {
        this.jumpCalendarPageStartTimeStamp = r10;
    }

    public final void setName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.name = r10;
    }

    public final void setNote(@Nullable String r10) {
        this.note = r10;
    }

    public final void setRecurrenceId(@Nullable String r10) {
        this.recurrenceId = r10;
    }

    public final void setReminderDesc(@Nullable String r10) {
        this.reminderDesc = r10;
    }

    public final void setRepeatDescription(@Nullable String r10) {
        this.repeatDescription = r10;
    }

    public final void setRruleDescription(@Nullable String r10) {
        this.rruleDescription = r10;
    }

    public final void setStartTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.startTime = r10;
    }

    public final void setStartTimestamp(@Nullable Long r10) {
        this.startTimestamp = r10;
    }

    public final void setTimeDescription(@Nullable String r10) {
        this.timeDescription = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        r10.writeString(this.startTime);
        r10.writeString(this.endTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(14);
        r10.writeString(this.address);
        r10.writeTypedList(this.attendees);
        r10.writeString(this.repeatDescription);
        r10.writeValue(this.startTimestamp);
        r10.writeValue(this.endTimestamp);
        r10.writeValue(Boolean.valueOf(this.allDay));
        r10.writeValue(this.note);
        r10.writeValue(this.completed);
        r10.writeValue(Boolean.valueOf(this.isFavorite));
        r10.writeValue(this.reminderDesc);
        r10.writeValue(this.timeDescription);
        r10.writeValue(this.rruleDescription);
        r10.writeValue(this.icsId);
        r10.writeValue(this.recurrenceId);
        CalendarTypeEnum r12 = this.calendarType;
        if (r12 == null) goto L5;
        String r13 = r12.name();
    L6:
        r10.writeValue(r13);
        r10.writeValue(this.iCalendarText);
        r10.writeValue(this.jumpCalendarPageStartTimeStamp);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public ScheduleEntity(@NotNull String r12, long r13, long r15, @NotNull String r17, @NotNull String r18, @NotNull String r19) {
        q.g(r12, "id");
        q.g(r17, "name");
        q.g(r18, "startTime");
        q.g(r19, "endTime");
        super(r12, r13, r15, 401);
        this.name = r17;
        this.startTime = r18;
        this.endTime = r19;
        this.startTimestamp = n.i(r18);
        this.endTimestamp = n.i(this.endTime);
    }
}
