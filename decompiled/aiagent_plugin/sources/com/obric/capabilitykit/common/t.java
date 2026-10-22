package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f32067a = null;

    static {
        f32067a = new t();
    }

    private t() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r3) {
        d.h.b.o.e(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, ScheduleEntity.class) == false) goto L54;
        ScheduleEntity r2 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r3, ScheduleEntity.class, "com.obric.aiagent.plugin");
        int r4 = ((((r2.getName().hashCode() + 0) * 31) + r2.getStartTime().hashCode()) * 31) + r2.getEndTime().hashCode();
        String r0 = r2.getAddress();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        List<ContactEntity> r1 = r2.getAttendees();
        if (r1 == null) goto L10;
        r4 = (r4 * 31) + r1.hashCode();
    L10:
        String r5 = r2.getRepeatDescription();
        if (r5 == null) goto L13;
        r4 = (r4 * 31) + r5.hashCode();
    L13:
        Long r6 = r2.getStartTimestamp();
        if (r6 == null) goto L16;
        r4 = (r4 * 31) + Long.hashCode(r6.longValue());
    L16:
        Long r7 = r2.getEndTimestamp();
        if (r7 == null) goto L19;
        r4 = (r4 * 31) + Long.hashCode(r7.longValue());
    L19:
        int r8 = (r4 * 31) + Boolean.hashCode(r2.getAllDay());
        String r9 = r2.getNote();
        if (r9 == null) goto L22;
        r8 = (r8 * 31) + r9.hashCode();
    L22:
        Boolean r10 = r2.getCompleted();
        if (r10 == null) goto L25;
        r8 = (r8 * 31) + Boolean.hashCode(r10.booleanValue());
    L25:
        int r11 = (r8 * 31) + Boolean.hashCode(r2.isFavorite());
        String r12 = r2.getReminderDesc();
        if (r12 == null) goto L28;
        r11 = (r11 * 31) + r12.hashCode();
    L28:
        String r13 = r2.getTimeDescription();
        if (r13 == null) goto L31;
        r11 = (r11 * 31) + r13.hashCode();
    L31:
        String r14 = r2.getRruleDescription();
        if (r14 == null) goto L34;
        r11 = (r11 * 31) + r14.hashCode();
    L34:
        String r15 = r2.getIcsId();
        if (r15 == null) goto L37;
        r11 = (r11 * 31) + r15.hashCode();
    L37:
        String r16 = r2.getRecurrenceId();
        if (r16 == null) goto L40;
        r11 = (r11 * 31) + r16.hashCode();
    L40:
        CalendarTypeEnum r17 = r2.getCalendarType();
        if (r17 == null) goto L43;
        r11 = (r11 * 31) + r17.name().hashCode();
    L43:
        String r18 = r2.getICalendarText();
        if (r18 == null) goto L46;
        r11 = (r11 * 31) + r18.hashCode();
    L46:
        Long r19 = r2.getJumpCalendarPageStartTimeStamp();
        if (r19 == null) goto L49;
        r11 = (r11 * 31) + Long.hashCode(r19.longValue());
    L49:
        String r20 = r2.getRawRrule();
        if (r20 != null) goto L52;
        return r11;
    L52:
        return (r11 * 31) + r20.hashCode();
    L54:
        throw new IllegalStateException("Check failed.".toString());
    }
}
