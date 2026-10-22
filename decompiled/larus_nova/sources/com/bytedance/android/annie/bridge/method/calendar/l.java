package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import e7.f0;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class l<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f38612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f38613b;

    public l(f0 r100, ContentResolver r101) {
        this.f38612a = r100;
        this.f38613b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final CreateCalendarEventResultModel.Code call() {
        int r100 = e.f38591a;
        f0 r101 = this.f38612a;
        ContentResolver r102 = this.f38613b;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "contentResolver");
        Long r103 = null;
        Cursor r104 = e.a(r102, CalendarContract.Calendars.CONTENT_URI, new String[]{DBDefinition.ID, "name", "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount"}, null, null);
        if (r104 == null) goto L14;
        Cursor r105 = r104;
        List r106 = SequencesKt.toList(SequencesKt.sequence(new CalendarUpdateReducer$getCalendars$1$1(r105, null)));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r105, null);
        if (r106 == null) goto L14;
    L15:
        List r107 = r106;
        Iterator r108 = r107.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        if (ArraysKt.contains(t.f38640a, ((b) r109).f38584d) == false) goto L17;
    L22:
        b r110 = (b) r109;
        if (r110 != null) goto L42;
        Iterator r111 = r107.iterator();
    L26:
        if (r111.hasNext() == false) goto L40;
        Object r112 = r111.next();
        b r113 = (b) r112;
        String r114 = r113.f38584d;
        String[] r115 = t.f38640a;
        if (Intrinsics.areEqual(r114, "com.smartisan.localcalendar") == false) goto L31;
        boolean r116 = Intrinsics.areEqual(r113.f38587g, CloudSearch.SearchBound.LOCAL_SHAPE);
    L38:
        if (r116 == false) goto L26;
    L41:
        r110 = (b) r112;
        goto L42
    L31:
        if (Intrinsics.areEqual(r114, "My calendar") == true) goto L33;
    L37:
        r116 = false;
        goto L38
    L33:
        if (Intrinsics.areEqual(r113.f38585e, "My calendar") == false) goto L37;
        if (Intrinsics.areEqual(r113.f38587g, "My calendar") == false) goto L37;
        r116 = true;
        goto L38
    L40:
        r112 = null;
    L42:
        if (r110 == null) goto L132;
        ContentValues r117 = new ContentValues();
        r117.put("calendar_id", Long.valueOf(r110.f38581a));
        r117.put("eventTimezone", TimeZone.getDefault().getID());
        Long r118 = r101.i();
        if (r118 == null) goto L47;
        r117.put("dtstart", Long.valueOf(r118.longValue()));
    L47:
        Long r119 = r101.c();
        if (r119 == null) goto L50;
        r117.put("dtend", Long.valueOf(r119.longValue()));
    L50:
        String r120 = r101.j();
        String r121 = "";
        if (r120 != null) goto L53;
        r120 = "";
    L53:
        r117.put("title", r120);
        String r122 = r101.e();
        if (r122 != null) goto L56;
        r122 = "";
    L56:
        r117.put("description", r122);
        String r123 = r101.getIdentifier();
        if (r123 != null) goto L59;
        r123 = "";
    L59:
        r117.put("sync_data1", r123);
        Boolean r124 = r101.b();
        if (r124 == null) goto L62;
        boolean r125 = r124.booleanValue();
    L63:
        r117.put("allDay", Boolean.valueOf(r125));
        String r126 = r101.d();
        if (r126 != null) goto L66;
        r126 = "";
    L66:
        r117.put("eventLocation", r126);
        String r127 = r101.k();
        if (r127 == null) goto L70;
        r121 = r127;
    L70:
        r117.put("sync_data3", r121);
        if (r101.f() == null) goto L80;
        if (r101.h() == null) goto L80;
        Integer r128 = r101.f();
        Intrinsics.checkNotNull(r128);
        if (r128.intValue() < 1) goto L80;
        Integer r129 = r101.h();
        Intrinsics.checkNotNull(r129);
        if (r129.intValue() < 1) goto L80;
        Long r130 = r101.c();
        Intrinsics.checkNotNull(r130);
        long r131 = r130.longValue();
        Long r132 = r101.i();
        Intrinsics.checkNotNull(r132);
        r117.put("duration", "P" + ((r131 - r132.longValue()) / ((long) 60000)) + 'M');
        r117.put("rrule", "FREQ=" + r101.g() + ";COUNT=" + r101.f() + ";INTERVAL=" + r101.h());
    L80:
        if (e.b(r102, q.a(CalendarContract.Events.CONTENT_URI), r117, "sync_data1=?", new String[]{r101.getIdentifier()}) <= 0) goto L114;
        Integer r133 = r101.a();
        if (r133 == null) goto L137;
        if (r133.intValue() < 0) goto L136;
        Cursor r134 = e.a(r102, CalendarContract.Events.CONTENT_URI, new String[]{DBDefinition.ID}, "sync_data1=?", new String[]{r101.getIdentifier()});
        Cursor r135 = r134;     // Catch: Throwable -> L106
        if (r135 != null) goto L89;
    L91:
        boolean r136 = false;
    L92:
        if (r136 == false) goto L95;
        long r137 = r135.getLong(0);     // Catch: Throwable -> L106
    L96:
        CloseableKt.closeFinally(r134, null);
        if (r137 < 0) goto L133;
        ContentValues r138 = new ContentValues();
        r138.put("event_id", Long.valueOf(r137));
        Integer r139 = r101.a();
        if (r139 == null) goto L102;
        r103 = Long.valueOf(((long) r139.intValue()) / ((long) 60000));
    L102:
        r138.put(DocumentType.MINUTES_NAME, r103);
        r138.put(com.alipay.sdk.m.p.e.f25671s, 1);
        if (e.b(r102, CalendarContract.Reminders.CONTENT_URI, r138, "event_id=?", new String[]{String.valueOf(r137)}) <= 0) goto L135;
        return CreateCalendarEventResultModel.Code.Success;
    L135:
        return CreateCalendarEventResultModel.Code.Failed;
    L133:
        return CreateCalendarEventResultModel.Code.Failed;
    L95:
        r137 = -1;
        goto L96
    L89:
        if (r135.moveToNext() != true) goto L91;
        r136 = true;
    L106:
        th = move-exception;
        throw th;     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        CloseableKt.closeFinally(r134, th);
        throw th;
    L136:
        return CreateCalendarEventResultModel.Code.InvalidParam;
    L137:
        return CreateCalendarEventResultModel.Code.Success;
    L114:
        return CreateCalendarEventResultModel.Code.Failed;
    L62:
        r125 = false;
        goto L63
    L132:
        return CreateCalendarEventResultModel.Code.Failed;
    L21:
        r109 = null;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L14:
        r106 = CollectionsKt.emptyList();
        goto L15
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
