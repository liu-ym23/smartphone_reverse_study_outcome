package com.obric.agent.entity;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.w;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.o.k;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: ScheduleEntityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14465a = null;

    /* JADX INFO: compiled from: ScheduleEntityUtils.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScheduleEntityUtils.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14466a = null;

        static {
            int[] r0 = new int[DayOfWeek.values().length];
            r0[DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[DayOfWeek.TUESDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[DayOfWeek.WEDNESDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[DayOfWeek.THURSDAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[DayOfWeek.FRIDAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[DayOfWeek.SATURDAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f14466a = r0;
        }
    }

    static {
        f14465a = new a(null);
    }

    public d() {
    }

    public final String a(ScheduleEntity r14, int r15) {
        o.e(r14, "entity");
        StringBuilder r0 = new StringBuilder();
        if (w.a(r14.getName()) == false) goto L5;
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_title_named, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_title_named"), new Object[]{r14.getName()}));
    L7:
        if (w.a(r14.getStartTime()) == false) goto L12;
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_time_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_time_prefix"), new Object[]{new SimpleDateFormat(a(Long.parseLong(r14.getStartTime()), r15), Locale.getDefault()).format(Long.valueOf(Long.parseLong(r14.getStartTime())))}));
        if (w.a(r14.getEndTime()) == false) goto L12;
        r0.append(" - " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Long.valueOf(Long.parseLong(r14.getEndTime()))));
    L12:
        if (w.a(r14.getRepeatDescription()) == false) goto L15;
        r0.append("， " + r14.getRepeatDescription());
    L15:
        if (w.a(r14.getAddress()) == false) goto L22;
        String r7 = r14.getAddress();
        o.a(r7);
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_room_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_room_prefix"), new Object[]{a(d.o.o.a(r7, "🎦", "", false, 4, null))}));
        String r13 = r14.getAddress();
        if (r13 == null) goto L23;
        if (d.o.o.c(r13, "...", false, 2, null) == true) goto L23;
    L23:
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r14.getAttendees(), Collection.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L26;
    L29:
        boolean r17 = true;
    L30:
        if (r17 == true) goto L45;
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_attendees_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_attendees_prefix")));
        List<ContactEntity> r18 = r14.getAttendees();
        if (r18 == null) goto L40;
        List r19 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), 2);
        if (r19 == null) goto L40;
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L37:
        if (r110.hasNext() == false) goto L40;
        r0.append(((ContactEntity) ZeusTransformUtils.preCheckCast(r110.next(), ContactEntity.class, "com.obric.aiagent.plugin")).getName() + 12289);
    L40:
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L42;
        r0.deleteCharAt(r0.length() - 1);
    L42:
        List<ContactEntity> r111 = r14.getAttendees();
        o.a(r111);
        if (r111.size() <= 2) goto L45;
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_more_attendees, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_more_attendees")));
    L45:
        String r112 = r0.toString();
        o.c(r112, "toString(...)");
        return r112;
    L26:
        if (r16.isEmpty() == true) goto L29;
        r17 = false;
        goto L30
    L22:
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_room_unbooked, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_room_unbooked")));
        goto L23
    L5:
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_title_untitled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_title_untitled")));
        goto L7
    }

    public final com.obric.agent.entity.b a(List<ScheduleEntity> r13, boolean r14) {
        List<ScheduleEntity> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        o.e(r15, "entities");
        StringBuilder r0 = new StringBuilder("");
        List<m<Integer, ScheduleEntity>> r16 = a(r15);
        if (r16.size() <= 3) goto L7;
        if (r14 == true) goto L7;
        return new com.obric.agent.entity.b(false, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_multi_found_phone, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_multi_found_phone")));
    L7:
        Iterator<m<Integer, ScheduleEntity>> r17 = r16.iterator();
        int r5 = 1;
    L9:
        if (r17.hasNext() == false) goto L14;
        m r6 = (m) ZeusTransformUtils.preCheckCast(r17.next(), m.class, "com.obric.aiagent.plugin");
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r6.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        ScheduleEntity r8 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r6.d(), ScheduleEntity.class, "com.obric.aiagent.plugin");
        if (r16.size() <= 1) goto L13;
        r0.append(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_item_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_item_prefix"), new Object[]{Integer.valueOf(r5)}));
        r5 = r5 + 1;
    L13:
        r0.append(a(r8, r7) + ";\n");
        goto L9
    L14:
        Application r18 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        int r19 = ZeusTransformUtils.mapRes(R.string.agent_schedule_found_count, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_found_count");
        Object[] r1 = new Object[2];
        if (r5 == 1) goto L18;
        r5 = r5 - 1;
    L18:
        r1[0] = Integer.valueOf(r5);
        r1[1] = r0.toString();
        return new com.obric.agent.entity.b(true, r18.getString(r19, r1));
    }

    private final List<m<Integer, ScheduleEntity>> a(List<ScheduleEntity> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        ScheduleEntity r2 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r12.next(), ScheduleEntity.class, "com.obric.aiagent.plugin");
        String r3 = r2.getAddress() + '_' + r2.getName() + '_' + a(Long.parseLong(r2.getStartTime())) + '_' + a(Long.parseLong(r2.getEndTime()));
        if (r0.containsKey(r3) == true) goto L8;
        r0.put(r3, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r0.get(r3), List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        r4.add(r2);
        goto L4
    L11:
        List<m<Integer, ScheduleEntity>> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r13 = r0.entrySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L36;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r8.hasNext() == false) goto L24;
        ScheduleEntity r14 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r8.next(), ScheduleEntity.class, "com.obric.aiagent.plugin");
        Calendar r15 = Calendar.getInstance();
        r15.setTimeInMillis(Long.parseLong(r14.getStartTime()));
        int r16 = r15.get(7);
        if (r7.containsKey(Integer.valueOf(r16)) == true) goto L20;
        r7.put(Integer.valueOf(r16), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
    L20:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r7.get(Integer.valueOf(r16)), List.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L16;
        r17.add(r14);
        goto L16
    L24:
        if (r7.size() >= 7) goto L25;
        Iterator r18 = r7.entrySet().iterator();
    L28:
        if (r18.hasNext() == false) goto L13;
        List r19 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), List.class, "com.obric.aiagent.plugin");
        if (r19.size() > 1) goto L31;
        Iterator r20 = r19.iterator();
    L34:
        if (r20.hasNext() == false) goto L28;
        r9.add(new m(0, (ScheduleEntity) ZeusTransformUtils.preCheckCast(r20.next(), ScheduleEntity.class, "com.obric.aiagent.plugin")));
        goto L34
    L31:
        r9.add(new m(2, p.k(r19)));
        goto L28
    L25:
        r9.add(new m(1, p.k(r6)));
        goto L13
    L36:
        return r9;
    }

    private final int a(long r2) {
        Calendar r1 = Calendar.getInstance();
        r1.setTimeInMillis(r2);
        int r3 = r1.get(11);
        int r4 = r1.get(12);
        int r5 = (r3 * 3600) + (r4 * 60);
        return r5 + r1.get(13);
    }

    private final String a(long r7, int r9) {
        LocalDate r6 = LocalDate.now();
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r7);
        LocalDate r8 = Instant.ofEpochMilli(r7).atZone(ZoneId.systemDefault()).toLocalDate();
        if (r9 != 1) goto L6;
        String r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_daily, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_daily"));
    L48:
        o.a(r10);
        StringBuilder r11 = new StringBuilder().append(r10);
        if (r0.get(11) >= 12) goto L52;
        String r12 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_time_morning, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_time_morning"));
    L56:
        return r11.append(r12).toString();
    L52:
        if (r0.get(11) < 18) goto L54;
        r12 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_time_evening, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_time_evening"));
        goto L56
    L54:
        r12 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_time_afternoon, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_time_afternoon"));
        goto L56
    L6:
        if (r8.isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6, ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L10;
        if (r9 != 0) goto L10;
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_today, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_today"));
    L10:
        if (r8.isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6.plusDays(1), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L14;
        if (r9 != 0) goto L14;
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_tomorrow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_tomorrow"));
    L14:
        if (r8.isEqual((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6.minusDays(1), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L17;
        if (r9 != 0) goto L17;
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_yesterday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_yesterday"));
    L17:
        int r5 = -1;
        if (r9 != 2) goto L32;
        DayOfWeek r13 = r8.getDayOfWeek();
        if (r13 == null) goto L23;
        r5 = b.f14466a[r13.ordinal()];
    L23:
        switch(r5) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            default: goto L24;
        };
    L24:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_sunday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_sunday"));
        goto L48
    L25:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_saturday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_saturday"));
        goto L48
    L26:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_friday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_friday"));
        goto L48
    L27:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_thursday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_thursday"));
        goto L48
    L28:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_wednesday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_wednesday"));
        goto L48
    L29:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_tuesday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_tuesday"));
        goto L48
    L30:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_repeat_week_monday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_repeat_week_monday"));
        goto L48
    L32:
        if (r8.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6.plusDays(1), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == true) goto L34;
    L47:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_date_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_date_format"));
        goto L48
    L34:
        if (r8.isBefore((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r6.plusDays(7), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L47;
        DayOfWeek r14 = r8.getDayOfWeek();
        if (r14 == null) goto L39;
        r5 = b.f14466a[r14.ordinal()];
    L39:
        switch(r5) {
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            default: goto L40;
        };
    L40:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_sunday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_sunday"));
        goto L48
    L41:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_saturday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_saturday"));
        goto L48
    L42:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_friday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_friday"));
        goto L48
    L43:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_thursday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_thursday"));
        goto L48
    L44:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_wednesday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_wednesday"));
        goto L48
    L45:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_tuesday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_tuesday"));
        goto L48
    L46:
        r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_schedule_week_monday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_schedule_week_monday"));
        goto L48
    }

    private final String a(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        return new k("\\(\\d+\\)").a(r1, "");
    }
}
