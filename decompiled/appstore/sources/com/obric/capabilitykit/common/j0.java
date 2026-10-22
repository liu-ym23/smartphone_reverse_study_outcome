package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j0 f11290a = null;

    static {
        f11290a = new j0();
    }

    private j0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof ScheduleEntity) == false) goto L51;
        ScheduleEntity r11 = (ScheduleEntity) r10;
        int r12 = (((r11.getName().hashCode() * 31) + r11.getStartTime().hashCode()) * 31) + r11.getEndTime().hashCode();
        String r13 = r11.getAddress();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        List<ContactEntity> r14 = r11.getAttendees();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.hashCode();
    L10:
        String r15 = r11.getRepeatDescription();
        if (r15 == null) goto L13;
        r12 = (r12 * 31) + r15.hashCode();
    L13:
        Long r16 = r11.getStartTimestamp();
        if (r16 == null) goto L16;
        r12 = (r12 * 31) + Long.hashCode(r16.longValue());
    L16:
        Long r17 = r11.getEndTimestamp();
        if (r17 == null) goto L19;
        r12 = (r12 * 31) + Long.hashCode(r17.longValue());
    L19:
        int r18 = (r12 * 31) + Boolean.hashCode(r11.getAllDay());
        String r19 = r11.getNote();
        if (r19 == null) goto L22;
        r18 = (r18 * 31) + r19.hashCode();
    L22:
        Boolean r20 = r11.getCompleted();
        if (r20 == null) goto L25;
        r18 = (r18 * 31) + Boolean.hashCode(r20.booleanValue());
    L25:
        int r21 = (r18 * 31) + Boolean.hashCode(r11.isFavorite());
        String r22 = r11.getReminderDesc();
        if (r22 == null) goto L28;
        r21 = (r21 * 31) + r22.hashCode();
    L28:
        String r23 = r11.getTimeDescription();
        if (r23 == null) goto L31;
        r21 = (r21 * 31) + r23.hashCode();
    L31:
        String r24 = r11.getRruleDescription();
        if (r24 == null) goto L34;
        r21 = (r21 * 31) + r24.hashCode();
    L34:
        String r25 = r11.getIcsId();
        if (r25 == null) goto L37;
        r21 = (r21 * 31) + r25.hashCode();
    L37:
        String r26 = r11.getRecurrenceId();
        if (r26 == null) goto L40;
        r21 = (r21 * 31) + r26.hashCode();
    L40:
        CalendarTypeEnum r27 = r11.getCalendarType();
        if (r27 == null) goto L43;
        r21 = (r21 * 31) + r27.name().hashCode();
    L43:
        String r28 = r11.getICalendarText();
        if (r28 == null) goto L46;
        r21 = (r21 * 31) + r28.hashCode();
    L46:
        Long r29 = r11.getJumpCalendarPageStartTimeStamp();
        if (r29 != null) goto L49;
        return r21;
    L49:
        return (r21 * 31) + Long.hashCode(r29.longValue());
    L51:
        throw new IllegalStateException("Check failed.");
    }
}
