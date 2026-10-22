package com.android.server.notification;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.provider.CalendarContract;
import android.service.notification.ZenModeConfig;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class CalendarTracker {
    private static final String[] ATTENDEE_PROJECTION = null;
    private static final String ATTENDEE_SELECTION = "event_id = ? AND attendeeEmail = ?";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_ATTENDEES = false;
    private static final int EVENT_CHECK_LOOKAHEAD = 86400000;
    private static final String INSTANCE_ORDER_BY = "begin ASC";
    private static final String[] INSTANCE_PROJECTION = null;
    private static final String TAG = "ConditionProviders.CT";
    private Callback mCallback;
    private final ContentObserver mObserver;
    private boolean mRegistered;
    private final Context mSystemContext;
    private final Context mUserContext;

    public interface Callback {
        void onChanged();
    }

    public static class CheckEventResult {
        public boolean inEvent;
        public long recheckAt;

        public CheckEventResult() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callback m6037$$Nest$fgetmCallback(CalendarTracker r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6038$$Nest$fgetmUserContext(CalendarTracker r0) {
        return r0.mUserContext;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6039$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable("ConditionProviders", 3);
        INSTANCE_PROJECTION = new String[]{"begin", "end", "title", "visible", "event_id", "calendar_displayName", "ownerAccount", "calendar_id", "availability"};
        ATTENDEE_PROJECTION = new String[]{"event_id", "attendeeEmail", "attendeeStatus"};
    }

    public CalendarTracker(Context systemContext, Context userContext) {
        final Handler r1 = null;
        this.mObserver = new AnonymousClass1(this, r1);
        this.mSystemContext = systemContext;
        this.mUserContext = userContext;
    }

    public void setCallback(Callback callback) {
        if (this.mCallback != callback) goto L5;
        return;
    L5:
        this.mCallback = callback;
        if (this.mCallback == null) goto L8;
        boolean r0 = true;
    L9:
        setRegistered(r0);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("mCallback=");
        pw.println(this.mCallback);
        pw.print(prefix);
        pw.print("mRegistered=");
        pw.println(this.mRegistered);
        pw.print(prefix);
        pw.print("u=");
        pw.println(this.mUserContext.getUserId());
    }

    private ArraySet<Long> getCalendarsWithAccess() {
        long start = System.currentTimeMillis();
        ArraySet<Long> rt = new ArraySet();
        String[] projection = {"_id"};
        Cursor cursor = null;
        cursor = this.mUserContext.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, projection, "calendar_access_level >= 500 AND sync_events = 1", null, null);     // Catch: Throwable -> L9 SQLiteException -> L11
    L4:
        if (cursor == null) goto L13;
        if (cursor.moveToNext() == false) goto L13;
        rt.add(Long.valueOf(cursor.getLong(0)));     // Catch: Throwable -> L9 SQLiteException -> L11
    L13:
        if (cursor == null) goto L20;
    L14:
        cursor.close();
    L20:
        if (DEBUG == false) goto L22;
        Log.d(TAG, "getCalendarsWithAccess took " + (System.currentTimeMillis() - start));
    L22:
        return rt;
    L9:
        th = move-exception;
        if (cursor == null) goto L25;
        cursor.close();
    L25:
        throw th;
    L11:
        e = move-exception;
        Slog.w(TAG, "error querying calendar content provider", e);     // Catch: Throwable -> L9
        if (cursor == null) goto L20;
        goto L14
    }

    public CheckEventResult checkEvent(ZenModeConfig.EventInfo filter, long time) {
        CalendarTracker r1 = this;
        Uri.Builder uriBuilder = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(uriBuilder, time);
        ContentUris.appendId(uriBuilder, time + 86400000);
        Uri uri = uriBuilder.build();
        Cursor cursor = null;
        CheckEventResult result = new CheckEventResult();
        result.recheckAt = 86400000 + time;
        cursor = r1.mUserContext.getContentResolver().query(uri, INSTANCE_PROJECTION, null, null, INSTANCE_ORDER_BY);     // Catch: Throwable -> L92 Exception -> L94
        ArraySet<Long> calendars = r1.getCalendarsWithAccess();     // Catch: Throwable -> L28 Exception -> L30
    L6:
        if (cursor == null) goto L88;
        if (cursor.moveToNext() == false) goto L88;
        long begin = cursor.getLong(0);     // Catch: Throwable -> L28 Exception -> L30
        long end = cursor.getLong(1);     // Catch: Throwable -> L28 Exception -> L30
        String title = cursor.getString(2);     // Catch: Throwable -> L28 Exception -> L30
        if (cursor.getInt(3) != 1) goto L12;
        boolean calendarVisible = true;
    L13:
        int eventId = cursor.getInt(4);     // Catch: Throwable -> L28 Exception -> L30
        String name = cursor.getString(5);     // Catch: Throwable -> L28 Exception -> L30
        String owner = cursor.getString(6);     // Catch: Throwable -> L28 Exception -> L30
        long calendarId = cursor.getLong(7);     // Catch: Throwable -> L28 Exception -> L30
        int availability = cursor.getInt(8);     // Catch: Throwable -> L28 Exception -> L30
        boolean canAccessCal = calendars.contains(Long.valueOf(calendarId));     // Catch: Throwable -> L28 Exception -> L30
        if (DEBUG == false) goto L32;
        boolean canAccessCal2 = canAccessCal;
        Cursor cursor2 = cursor;
        long end2 = end;
    L111:
        Log.d(TAG, String.format("title=%s time=%s-%s vis=%s availability=%s eventId=%s name=%s owner=%s calId=%s canAccessCal=%s", new Object[]{title, new Date(begin), new Date(end2), Boolean.valueOf(calendarVisible), availabilityToString(availability), Integer.valueOf(eventId), name, owner, Long.valueOf(calendarId), Boolean.valueOf(canAccessCal2)}));     // Catch: Throwable -> L20 Exception -> L22
    L34:
        if (time >= begin) goto L36;
    L38:
        boolean meetsTime = false;
    L39:
        if (calendarVisible == false) goto L52;
        if (canAccessCal2 == false) goto L52;
        if (filter.calName != null) goto L47;
        if (filter.calendarId != null) goto L47;
        boolean meetsTime2 = meetsTime;
    L51:
        boolean meetsCalendar = true;
    L55:
        if (availability == 1) goto L57;
        boolean meetsAvailability = true;
    L58:
        if (meetsCalendar == false) goto L87;
        if (meetsAvailability == false) goto L87;
        if (DEBUG == false) goto L63;
        Log.d(TAG, "  MEETS CALENDAR & AVAILABILITY");     // Catch: Throwable -> L20 Exception -> L22
    L63:
        boolean meetsAttendee = r1.meetsAttendee(filter, eventId, owner);     // Catch: Throwable -> L20 Exception -> L22
        if (meetsAttendee == false) goto L87;
        if (DEBUG == false) goto L69;
        Log.d(TAG, "    MEETS ATTENDEE");     // Catch: Throwable -> L20 Exception -> L22
    L69:
        if (meetsTime2 == false) goto L75;
        if (DEBUG == false) goto L73;
        Log.d(TAG, "      MEETS TIME");     // Catch: Throwable -> L20 Exception -> L22
    L73:
        result.inEvent = true;     // Catch: Throwable -> L20 Exception -> L22
    L75:
        if (begin <= time) goto L80;
        if (begin >= result.recheckAt) goto L80;
        result.recheckAt = begin;     // Catch: Throwable -> L20 Exception -> L22
    L80:
        if (end2 <= time) goto L87;
        if (end2 >= result.recheckAt) goto L87;
        result.recheckAt = end2;     // Catch: Throwable -> L20 Exception -> L22
    L87:
        r1 = this;
        uriBuilder = uriBuilder;
        calendars = calendars;
        cursor = cursor2;
        goto L6
    L57:
        meetsAvailability = false;
    L47:
        meetsTime2 = meetsTime;
        if (Objects.equals(filter.calendarId, Long.valueOf(calendarId)) == true) goto L51;
        if (Objects.equals(filter.calName, name) == true) goto L51;
    L53:
        meetsCalendar = false;
    L52:
        meetsTime2 = meetsTime;
        goto L53
    L36:
        if (time >= end2) goto L38;
        meetsTime = true;
    L22:
        e = e;
        cursor = cursor2;
    L105:
        Slog.w(TAG, "error reading calendar", e);     // Catch: Throwable -> L101
        if (cursor == null) goto L100;
        cursor.close();
    L100:
        return result;
    L101:
        th = th;
    L102:
        if (cursor == null) goto L104;
        cursor.close();
    L104:
        throw th;
    L20:
        th = th;
        cursor = cursor2;
    L26:
        e = e;
        cursor = cursor2;
    L24:
        th = th;
        cursor = cursor2;
        goto L102
    L32:
        canAccessCal2 = canAccessCal;
        cursor2 = cursor;
        end2 = end;
        goto L34
    L12:
        calendarVisible = false;
    L88:
        Cursor cursor3 = cursor;
        if (cursor3 == null) goto L100;
        cursor3.close();
    L30:
        e = e;
    L28:
        th = th;
        goto L102
    L94:
        e = e;
    L92:
        th = th;
        goto L102
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean meetsAttendee(ZenModeConfig.EventInfo r23, int r24, String r25) {
        long r4 = System.currentTimeMillis();
        Cursor r12 = null;
        r12 = null;
        r12 = null;
        boolean r13 = false;
        r13 = false;
        r12 = this.mUserContext.getContentResolver().query(CalendarContract.Attendees.CONTENT_URI, ATTENDEE_PROJECTION, ATTENDEE_SELECTION, new String[]{Integer.toString(r24), r25}, null);     // Catch: Throwable -> L41 SQLiteException -> L43
        int r0 = 1;
        if (r12 == null) goto L51;
        if (r12.getCount() == 0) goto L51;
        int r6 = 0;
    L10:
        if (r12.moveToNext() == false) goto L45;
        long r7 = r12.getLong(r13 ? 1 : 0);     // Catch: Throwable -> L41 SQLiteException -> L43
        String r11 = r12.getString(r0);     // Catch: Throwable -> L41 SQLiteException -> L43
        int r15 = r12.getInt(2);     // Catch: Throwable -> L41 SQLiteException -> L43
        int r17 = r0;
        boolean r16 = r13 ? 1 : 0;
        boolean r1 = meetsReply(r23.reply, r15);     // Catch: Throwable -> L23 SQLiteException -> L25
        if (DEBUG == false) goto L28;
        boolean r18 = r1;
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L23 SQLiteException -> L25
        long r19 = r4;
        r2.append("");     // Catch: Throwable -> L19 SQLiteException -> L21
        r2.append(String.format("status=%s, meetsReply=%s", new Object[]{attendeeStatusToString(r15), Boolean.valueOf(r18)}));     // Catch: Throwable -> L19 SQLiteException -> L21
        Log.d(TAG, r2.toString());     // Catch: Throwable -> L19 SQLiteException -> L21
    L30:
        if (r7 == r24) goto L32;
    L39:
        int r3 = r16 ? 1 : 0;
    L40:
        r6 = r6 | r3;
        r13 = r16 ? 1 : 0;
        r0 = r17;
        r4 = r19;
        goto L10
    L32:
        if (Objects.equals(r11, r25) == false) goto L39;
        if (r18 == false) goto L39;
        r3 = r17;
    L21:
        e = e;
    L61:
        Slog.w(TAG, "error querying attendees content provider", e);     // Catch: Throwable -> L35
        if (r12 == null) goto L65;
        r12.close();
    L65:
        if (DEBUG == false) goto L67;
        Log.d(TAG, "meetsAttendee took " + (System.currentTimeMillis() - r19));
    L67:
        return r16;
    L19:
        th = th;
    L68:
        if (r12 == null) goto L71;
        r12.close();
    L71:
        if (DEBUG == false) goto L73;
        Log.d(TAG, "meetsAttendee took " + (System.currentTimeMillis() - r19));
    L73:
        throw th;
    L28:
        r18 = r1;
        r19 = r4;
    L25:
        e = e;
        r19 = r4;
    L23:
        th = th;
    L24:
        r19 = r4;
        goto L68
    L45:
        long r110 = r4;
        boolean r21 = r6;
        r12.close();
        if (DEBUG == false) goto L48;
        Log.d(TAG, "meetsAttendee took " + (System.currentTimeMillis() - r110));
    L48:
        return r21;
    L51:
        if (DEBUG == false) goto L54;
        Log.d(TAG, "No attendees found");     // Catch: Throwable -> L35 SQLiteException -> L37
    L54:
        if (r12 == null) goto L57;
        r12.close();
    L57:
        if (DEBUG == false) goto L59;
        Log.d(TAG, "meetsAttendee took " + (System.currentTimeMillis() - r4));
    L59:
        return 1;
    L37:
        e = e;
    L35:
        th = th;
    L43:
        e = e;
        r19 = r4;
        r16 = r13;
    L41:
        th = th;
        goto L24
    }

    private void setRegistered(boolean registered) {
        if (this.mRegistered != registered) goto L5;
        return;
    L5:
        ContentResolver cr = this.mSystemContext.getContentResolver();
        int userId = this.mUserContext.getUserId();
        if (this.mRegistered == true) goto L8;
    L11:
        this.mRegistered = registered;
        if (DEBUG == false) goto L15;
        Log.d(TAG, "mRegistered = " + registered + " u=" + userId);
    L15:
        if (this.mRegistered == true) goto L17;
        return;
    L17:
        if (DEBUG == false) goto L19;
        Log.d(TAG, "register content observer u=" + userId);
    L19:
        cr.registerContentObserver(CalendarContract.Instances.CONTENT_URI, true, this.mObserver, userId);
        cr.registerContentObserver(CalendarContract.Events.CONTENT_URI, true, this.mObserver, userId);
        cr.registerContentObserver(CalendarContract.Calendars.CONTENT_URI, true, this.mObserver, userId);
        return;
    L8:
        if (DEBUG == false) goto L10;
        Log.d(TAG, "unregister content observer u=" + userId);
    L10:
        cr.unregisterContentObserver(this.mObserver);
        goto L11
    }

    private static String attendeeStatusToString(int status) {
        switch(status) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "ATTENDEE_STATUS_TENTATIVE";
    L7:
        return "ATTENDEE_STATUS_INVITED";
    L9:
        return "ATTENDEE_STATUS_DECLINED";
    L11:
        return "ATTENDEE_STATUS_ACCEPTED";
    L13:
        return "ATTENDEE_STATUS_NONE";
    L4:
        return "ATTENDEE_STATUS_UNKNOWN_" + status;
    }

    private static String availabilityToString(int availability) {
        switch(availability) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "AVAILABILITY_TENTATIVE";
    L7:
        return "AVAILABILITY_FREE";
    L9:
        return "AVAILABILITY_BUSY";
    L4:
        return "AVAILABILITY_UNKNOWN_" + availability;
    }

    private static boolean meetsReply(int reply, int attendeeStatus) {
        switch(reply) {
            case 0: goto L14;
            case 1: goto L8;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        if (attendeeStatus == 1) goto L7;
        return false;
    L7:
        return true;
    L8:
        if (attendeeStatus == 1) goto L12;
        if (attendeeStatus == 4) goto L12;
        return false;
    L12:
        return true;
    L14:
        if (attendeeStatus != 2) goto L16;
        return false;
    L16:
        return true;
    }

    public int getUserId() {
        return this.mUserContext.getUserId();
    }
}
