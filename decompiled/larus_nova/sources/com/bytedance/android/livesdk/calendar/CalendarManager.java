package com.bytedance.android.livesdk.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import j40.f4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class CalendarManager implements ICalendarManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f104420b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f104421a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f104422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f104423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f104424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f104425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f104426e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f104427f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f104428g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L20;
            a r101 = (a) r100;
            if (this.f104422a == r101.f104422a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f104423b, r101.f104423b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f104424c, r101.f104424c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f104425d, r101.f104425d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f104426e, r101.f104426e) == true) goto L16;
            return false;
        L16:
            if (this.f104427f == r101.f104427f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f104428g, r101.f104428g) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f104422a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f104423b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f104424c;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f104425d;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f104426e;
            if (r112 == null) goto L17;
            int r113 = r112.hashCode();
        L18:
            int r114 = (((r111 + r113) * 31) + this.f104427f) * 31;
            String r115 = this.f104428g;
            if (r115 == null) goto L22;
            r103 = r115.hashCode();
        L22:
            return r114 + r103;
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "Calendar(id=" + this.f104422a + ", name=" + this.f104423b + ", displayName=" + this.f104424c + ", accountType=" + this.f104425d + ", accountName=" + this.f104426e + ", visible=" + this.f104427f + ", ownerAccount=" + this.f104428g + ")";
        }

        public a() {
            this(0, null, null, null, null, 0, null);
        }

        public a(long r100, String r101, String r102, String r103, String r104, int r105, String r106) {
            this.f104422a = r100;
            this.f104423b = r101;
            this.f104424c = r102;
            this.f104425d = r103;
            this.f104426e = r104;
            this.f104427f = r105;
            this.f104428g = r106;
        }
    }

    public static final class b {
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f104429a;

        public c(Function0 r100) {
            this.f104429a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            int[] r101 = (int[]) r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            int r102 = r101.length;
            int r103 = 0;
        L3:
            boolean r104 = true;
            if (r103 >= r102) goto L12;
            if (r101[r103] == 0) goto L9;
            r104 = false;
        L9:
            if (r104 == false) goto L10;
            r103 = r103 + 1;
            goto L3
        L10:
            r104 = false;
        L12:
            if (r104 == true) goto L18;
            ALogger.i("CalendarManager", "no permission to add calendar event");
            f2.b(R.string.ttlive_calendar_no_permission, 0);
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r105 = f4.A;
            Boolean r106 = Boolean.TRUE;
            r105.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r105, r106);
            return Single.error(new Exception("user denied calendar permission"));
        L18:
            return (Single) this.f104429a.invoke();
        }
    }

    static {
        f104420b = new String[]{AccountType.LOCAL, "com.android.huawei.phone", "com.xiaomi"};
    }

    public final ContentResolver e() {
        return this.f104421a.getContentResolver();
    }

    public final a f() {
        Object r100 = null;
        Cursor r101 = c(e(), CalendarContract.Calendars.CONTENT_URI, new String[]{DBDefinition.ID, "name", "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount"}, null, null);
        if (r101 == null) goto L14;
        Cursor r102 = r101;
        List r103 = SequencesKt.toList(SequencesKt.sequence(new CalendarManager$getCalendars$1$1(r102, null)));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r102, null);
        if (r103 == null) goto L14;
    L15:
        List r104 = r103;
        Iterator r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        if (ArraysKt.contains(f104420b, ((a) r106).f104425d) == false) goto L17;
    L22:
        a r107 = (a) r106;
        if (r107 != null) goto L72;
        Iterator r108 = r104.iterator();
    L26:
        if (r108.hasNext() == false) goto L58;
        Object r109 = r108.next();
        a r110 = (a) r109;
        String r111 = r110.f104425d;
        if (r111 == null) goto L54;
        int r112 = r111.hashCode();
        if (r112 == (-1116924142)) goto L48;
        if (r112 == 879034182) goto L41;
        if (r112 != 1664859374) goto L54;
        if (r111.equals("com.smartisan.localcalendar") == false) goto L54;
        boolean r113 = Intrinsics.areEqual(r110.f104428g, CloudSearch.SearchBound.LOCAL_SHAPE);
    L55:
        if (r113 == false) goto L26;
        r100 = r109;
        goto L58
    L41:
        if (r111.equals("com.google") == false) goto L54;
        String r114 = r110.f104426e;
        if (r114 == null) goto L54;
        if (Intrinsics.areEqual(r114, r110.f104428g) == false) goto L54;
    L53:
        r113 = true;
        goto L55
    L48:
        if (r111.equals("My calendar") == false) goto L54;
        if (Intrinsics.areEqual(r110.f104426e, "My calendar") == false) goto L54;
        if (Intrinsics.areEqual(r110.f104428g, "My calendar") == true) goto L53;
    L54:
        r113 = false;
    L58:
        return (a) r100;
    L72:
        return r107;
    L21:
        r106 = null;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L14:
        r103 = CollectionsKt.emptyList();
        goto L15
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final boolean getHasReadPermission() {
        if (ContextCompat.checkSelfPermission(this.f104421a, "android.permission.READ_CALENDAR") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final boolean getHasWritePermission() {
        if (ContextCompat.checkSelfPermission(this.f104421a, "android.permission.WRITE_CALENDAR") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final boolean getHasFullPermission() {
        if (getHasReadPermission() == true) goto L5;
    L7:
        return false;
    L5:
        if (getHasWritePermission() == false) goto L7;
        return true;
    }

    public final Context getContext() {
        return this.f104421a;
    }

    public CalendarManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f104421a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final ICalendarManager.ErrorCode add(ICalendarManager.EventParams r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        String r100 = r110.getEventId();     // Catch: Throwable -> L92
        if (r100 == null) goto L6;
        String r101 = r110.getEventId();     // Catch: Throwable -> L92
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == true) goto L30;
        String r103 = r110.getTitle();     // Catch: Throwable -> L92
        if (r103 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == true) goto L30;
        if (r110.getStartTime() <= 0) goto L30;
        if (r110.getEndTime() <= 0) goto L30;
        if (r110.getStartTime() > r110.getEndTime()) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == true) goto L35;
        ALogger.e("CalendarManager", "invalid event params: " + r110);     // Catch: Throwable -> L92
        return ICalendarManager.ErrorCode.ArgumentError;
    L35:
        if (getHasFullPermission() == true) goto L39;
        ALogger.e("CalendarManager", "no calendar permission: read=" + getHasReadPermission() + " write=" + getHasWritePermission());     // Catch: Throwable -> L92
        return ICalendarManager.ErrorCode.NoPermission;
    L39:
        if (g(r100) == false) goto L42;
        ALogger.i("CalendarManager", "eventId already exists: " + r110);     // Catch: Throwable -> L92
        return ICalendarManager.ErrorCode.AlreadyExists;
    L42:
        a r106 = f();     // Catch: Throwable -> L92
        if (r106 != null) goto L46;
        ALogger.e("CalendarManager", "no available local calendar: " + r110);     // Catch: Throwable -> L92
        return ICalendarManager.ErrorCode.NoAccount;
    L46:
        List<Integer> r107 = r110.getScheduledWeekDays();     // Catch: Throwable -> L92
        ContentValues r108 = new ContentValues();     // Catch: Throwable -> L92
        r108.put("calendar_id", Long.valueOf(r106.f104422a));     // Catch: Throwable -> L92
        r108.put("eventTimezone", TimeZone.getDefault().getID());     // Catch: Throwable -> L92
        long r109 = 1000;
        r108.put("dtstart", Long.valueOf(r110.getStartTime() * r109));     // Catch: Throwable -> L92
        if (r107 != null) goto L49;
    L70:
        r108.put("dtend", Long.valueOf(r110.getEndTime() * r109));     // Catch: Throwable -> L92
    L71:
        String r111 = r110.getDescription();     // Catch: Throwable -> L92
        if (r111 != null) goto L74;
    L77:
        boolean r112 = true;
    L79:
        if (r112 == true) goto L81;
        r108.put("description", r110.getDescription());     // Catch: Throwable -> L92
    L81:
        r108.put("title", r110.getTitle());     // Catch: Throwable -> L92
        r108.put("description", r110.getDescription());     // Catch: Throwable -> L92
        r108.put("sync_data1", r110.getEventId());     // Catch: Throwable -> L92
        Uri r113 = b(e(), CalendarContract.Events.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "com.bytedance").appendQueryParameter("account_type", AccountType.LOCAL).build(), r108);     // Catch: Throwable -> L92
        Integer r114 = r110.getAlarmMinutes();     // Catch: Throwable -> L92
        if (r113 == null) goto L90;
        if (r114 == null) goto L90;
        int r115 = r114.intValue();     // Catch: Throwable -> L92
        String r116 = r113.getLastPathSegment();     // Catch: Throwable -> L92
        if (r116 == null) goto L88;
        Long r117 = Long.valueOf(CastLongProtector.parseLong(r116));     // Catch: Throwable -> L92
    L89:
        ContentValues r118 = new ContentValues();     // Catch: Throwable -> L92
        r118.put(DocumentType.MINUTES_NAME, Integer.valueOf(r115));     // Catch: Throwable -> L92
        r118.put("event_id", r117);     // Catch: Throwable -> L92
        r118.put(com.alipay.sdk.m.p.e.f25671s, 1);     // Catch: Throwable -> L92
        b(e(), CalendarContract.Reminders.CONTENT_URI, r118);     // Catch: Throwable -> L92
        goto L90
    L88:
        r117 = null;
    L90:
        j0.l().sendLog("livesdk_system_calendar_build", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_id", r110.getEventId()), TuplesKt.to("anchor_id", r110.getAnchorId())}), new Object[0]);     // Catch: Throwable -> L92
        return ICalendarManager.ErrorCode.Success;
    L74:
        if (r111.length() == 0) goto L77;
        r112 = false;
        goto L79
    L49:
        if ((!r107.isEmpty()) != true) goto L70;
        List<Integer> r119 = r107;     // Catch: Throwable -> L92
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));     // Catch: Throwable -> L92
        Iterator<T> r121 = r119.iterator();     // Catch: Throwable -> L92
    L52:
        if (r121.hasNext() == false) goto L64;
        int r122 = ((Number) r121.next()).intValue();     // Catch: Throwable -> L92
        int r123 = com.bytedance.android.livesdk.calendar.a.f104431a;     // Catch: Throwable -> L92
        switch(r122) {
            case 0: goto L62;
            case 1: goto L61;
            case 2: goto L60;
            case 3: goto L59;
            case 4: goto L58;
            case 5: goto L57;
            case 6: goto L56;
            default: goto L55;
        };     // Catch: Throwable -> L92
    L55:
        String r124 = "";
    L63:
        r120.add(r124);     // Catch: Throwable -> L92
        goto L52
    L56:
        r124 = "SA";
        goto L63
    L57:
        r124 = "FR";
        goto L63
    L58:
        r124 = "TH";
        goto L63
    L59:
        r124 = "WE";
        goto L63
    L60:
        r124 = "TU";
        goto L63
    L61:
        r124 = "MO";
        goto L63
    L62:
        r124 = "SU";
        goto L63
    L64:
        String r125 = TextUtils.join(",", r120);     // Catch: Throwable -> L92
        if (r125.length() <= 0) goto L67;
        boolean r126 = true;
    L68:
        if (r126 == false) goto L71;
        r108.put("rrule", "FREQ=WEEKLY;INTERVAL=1;BYDAY=" + r125);     // Catch: Throwable -> L92
        r108.put("duration", "P1H");     // Catch: Throwable -> L92
        goto L71
    L67:
        r126 = false;
        goto L68
    L18:
        if (r103.length() == 0) goto L21;
        r104 = false;
    L30:
        r105 = false;
        goto L31
    L10:
        if (r101.length() == 0) goto L13;
        r102 = false;
        goto L14
    L6:
        return ICalendarManager.ErrorCode.ArgumentError;
    L92:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to add calendar event", th);
        return ICalendarManager.ErrorCode.Unknown;
    }

    public final Integer d(long r100) {
        Uri r101 = CalendarContract.Reminders.CONTENT_URI;
        String[] r102 = {String.valueOf(r100)};
        Cursor r103 = c(e(), r101, new String[]{DocumentType.MINUTES_NAME}, "event_id=?", r102);
        if (r103 == null) goto L17;
        Cursor r104 = r103;
        Cursor r105 = r104;     // Catch: Throwable -> L12
        if (r105.moveToNext() == false) goto L10;
        Integer r106 = Integer.valueOf(r105.getInt(0));     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r104, null);
        return r106;
    L10:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r104, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L17:
        return null;
    }

    public final boolean g(String r100) {
        boolean r101 = true;
        Cursor r102 = c(e(), CalendarContract.Events.CONTENT_URI, new String[0], "sync_data1=? and (deleted != 1)", new String[]{r100});
        if (r102 == null) goto L16;
        Cursor r103 = r102;
        if (r103.getCount() > 0) goto L9;
        r101 = false;
    L9:
        CloseableKt.closeFinally(r103, null);
        return r101;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final Pair<ICalendarManager.ErrorCode, ICalendarManager.EventRecord> get(String r110) {
        Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276361k);
    L23:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to get calendar event, eventId=" + r110, th);
    L32:
        return TuplesKt.to(ICalendarManager.ErrorCode.Unknown, null);
    L4:
        if (r110.length() != 0) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L11;
        return TuplesKt.to(ICalendarManager.ErrorCode.ArgumentError, null);
    L11:
        if (getHasReadPermission() == false) goto L13;
        Cursor r101 = c(e(), CalendarContract.Events.CONTENT_URI, new String[]{"sync_data1", "dtstart", "dtend", "title", "description", DBDefinition.ID}, "sync_data1=?", new String[]{r110});     // Catch: Throwable -> L23
        if (r101 == null) goto L32;
        Cursor r102 = r101;     // Catch: Throwable -> L23
        Cursor r103 = r102;     // Catch: Throwable -> L25
        if (r103.moveToNext() == false) goto L20;
        ICalendarManager.ErrorCode r104 = ICalendarManager.ErrorCode.Success;     // Catch: Throwable -> L25
        ICalendarManager.EventRecord r105 = new ICalendarManager.EventRecord();     // Catch: Throwable -> L25
        r105.setEventId(r103.getString(0));     // Catch: Throwable -> L25
        long r106 = 1000;
        r105.setStartTime(r103.getLong(1) / r106);     // Catch: Throwable -> L25
        r105.setEndTime(r103.getLong(2) / r106);     // Catch: Throwable -> L25
        r105.setTitle(r103.getString(3));     // Catch: Throwable -> L25
        r105.setDescription(r103.getString(4));     // Catch: Throwable -> L25
        r105.setAlarmMinutes(d(r103.getLong(5)));     // Catch: Throwable -> L25
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L25
        Pair<ICalendarManager.ErrorCode, ICalendarManager.EventRecord> r108 = TuplesKt.to(r104, r105);     // Catch: Throwable -> L25
    L21:
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L23
        return r108;
    L20:
        r108 = TuplesKt.to(ICalendarManager.ErrorCode.NotFound, null);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L13:
        return TuplesKt.to(ICalendarManager.ErrorCode.NoPermission, null);
    L6:
        r100 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final ICalendarManager.ErrorCode remove(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r101, "anchorId");
    L24:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to add calendar event", th);
        return ICalendarManager.ErrorCode.Unknown;
    L4:
        if (r100.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L11;
        return ICalendarManager.ErrorCode.ArgumentError;
    L11:
        if (getHasWritePermission() == true) goto L15;
        return ICalendarManager.ErrorCode.NoPermission;
    L15:
        if (a(e(), CalendarContract.Events.CONTENT_URI, new String[]{r100}) <= 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        j0.l().sendLog("livesdk_system_calendar_cancel", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_id", r100), TuplesKt.to("anchor_id", r101)}), new Object[0]);     // Catch: Throwable -> L24
    L20:
        if (r103 == false) goto L23;
        return ICalendarManager.ErrorCode.Success;
    L23:
        return ICalendarManager.ErrorCode.NotFound;
    L17:
        r103 = false;
        goto L18
    L6:
        r102 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.calendar.ICalendarManager
    public final Single<ICalendarManager.ErrorCode> requestPermissionAndAdd(final ICalendarManager.EventParams r100, ICalendarManager.IPermissionHandler r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "handler");
        Function0<Single<ICalendarManager.ErrorCode>> r102 = new CalendarManager$requestPermissionAndAdd$proceed$1(this, r100);
        if (getHasFullPermission() == false) goto L6;
        return r102.invoke();
    L6:
        if (f4.A.getValue().booleanValue() == false) goto L9;
        return Single.error(new Exception("user had denied calendar permission before"));
    L9:
        return r101.requestCalendarPermission().onErrorReturnItem(new int[]{-1}).observeOn(AndroidSchedulers.mainThread()).flatMap(new c(r102));
    }

    public static int a(ContentResolver r210, Uri r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "sync_data1=?", r212};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r213 = r111;
        f06.d r106 = r105.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Integer) r106.f474983b).intValue();
    L21:
        return r210.delete(r211, "sync_data1=?", r212);
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r213;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri b(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
