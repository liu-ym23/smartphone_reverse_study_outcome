package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.ReadCalendarEventResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import e7.q0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "readCalendarEvent")
public final class r extends e7.s<q0, ReadCalendarEventResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.q f38629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q0 f38630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentResolver f38631c;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f38632a;

        public a(r r100) {
            this.f38632a = r100;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            Intrinsics.checkNotNullParameter(r102, "grantResults");
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r102) == false) goto L10;
            r r103 = this.f38632a;
            q0 r104 = r103.f38630b;
            if (r104 != null) goto L7;
        L9:
            ReadCalendarEventResultModel r105 = new ReadCalendarEventResultModel();
            r105.b(ReadCalendarEventResultModel.Code.Failed);
            r105.e("read calendar failed");
            r103.finishWithResult(r105);
            return;
        L7:
            if (r103.f38631c == null) goto L9;
            Intrinsics.checkNotNull(r104);
            ContentResolver r106 = this.f38632a.f38631c;
            Intrinsics.checkNotNull(r106);
            r103.j(r104, r106);
            return;
        L10:
            r r107 = this.f38632a;
            ReadCalendarEventResultModel r108 = new ReadCalendarEventResultModel();
            r108.b(ReadCalendarEventResultModel.Code.NoPermission);
            r108.e("user denied permission");
            r107.finishWithResult(r108);
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q0 f38633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f38634b;

        public c(q0 r100, ContentResolver r101) {
            this.f38633a = r100;
            this.f38634b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final ReadCalendarEventResultModel call() {
            int r100 = com.bytedance.android.annie.bridge.method.calendar.c.f38589a;
            q0 r101 = this.f38633a;
            ContentResolver r102 = this.f38634b;
            Intrinsics.checkNotNullParameter(r101, "param");
            Intrinsics.checkNotNullParameter(r102, "contentResolver");
            ReadCalendarEventResultModel r103 = null;
            if (r101.getIdentifier() == null) goto L34;
            Cursor r104 = com.bytedance.android.annie.bridge.method.calendar.c.a(r102, CalendarContract.Events.CONTENT_URI, new String[]{DBDefinition.ID, "sync_data1", "dtstart", "dtend", "title", "description", "eventLocation", "sync_data3", "lastDate"}, "sync_data1=?", new String[]{r101.getIdentifier()});
            if (r104 == null) goto L33;
            Cursor r105 = r104;
            Cursor r106 = r105;     // Catch: Throwable -> L28
            if (r106.getCount() > 0) goto L13;
            r101.getIdentifier();     // Catch: Throwable -> L28
            CloseableKt.closeFinally(r105, null);
            goto L34
        L13:
            if (r106.moveToNext() == false) goto L26;
            ReadCalendarEventResultModel r107 = new ReadCalendarEventResultModel();     // Catch: Throwable -> L28
            r107.b(ReadCalendarEventResultModel.Code.Success);     // Catch: Throwable -> L28
            r107.e("read success");     // Catch: Throwable -> L28
            Integer r108 = com.bytedance.android.annie.bridge.method.calendar.c.b(r106.getLong(0), r102);     // Catch: Throwable -> L28
            if (r108 == null) goto L17;
            r107.a(Integer.valueOf(r108.intValue() * 60000));     // Catch: Throwable -> L28
        L17:
            r107.g(Long.valueOf(r106.getLong(2)));     // Catch: Throwable -> L28
            long r109 = r106.getLong(3);     // Catch: Throwable -> L28
            long r110 = r106.getLong(8);     // Catch: Throwable -> L28
            if (r109 == 0) goto L21;
        L24:
            r107.c(Long.valueOf(r109));     // Catch: Throwable -> L28
            r107.h(r106.getString(4));     // Catch: Throwable -> L28
            r107.f(r106.getString(5));     // Catch: Throwable -> L28
            r107.d(r106.getString(6));     // Catch: Throwable -> L28
            r107.i(r106.getString(7));     // Catch: Throwable -> L28
        L27:
            CloseableKt.closeFinally(r105, null);
            r103 = r107;
            goto L34
        L21:
            if (r110 == 0) goto L23;
            r109 = r110;
            goto L24
        L23:
            r109 = 0;
            goto L24
        L26:
            r107 = null;
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            CloseableKt.closeFinally(r105, th);
            throw th;
        L33:
            b8.a r111 = b8.a.f17992a;
            b8.a.a(new b8.b("[ReportALogMethod]", LogLevel.ERROR, null, "read calendar but meet an error. Please check.", 4), true);
        L34:
            if (r103 != null) goto L40;
            ReadCalendarEventResultModel r112 = new ReadCalendarEventResultModel();
            r112.b(ReadCalendarEventResultModel.Code.Failed);
            r112.e("read calendar but got a null.");
            return r112;
        L40:
            return r103;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f38635a;

        public d(r r100) {
            this.f38635a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            r r101 = this.f38635a;
            r101.finishWithResult((ReadCalendarEventResultModel) r100);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f38636a;

        public e(r r100) {
            this.f38636a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            r r101 = this.f38636a;
            ReadCalendarEventResultModel r102 = new ReadCalendarEventResultModel();
            r102.b(ReadCalendarEventResultModel.Code.Failed);
            r102.e("read calendar with a failure operation. error msg = " + ((Throwable) r100).getMessage());
            r101.finishWithResult(r102);
        }
    }

    static {
    }

    public r(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        com.bytedance.android.annie.container.fragment.q r101 = this.f38629a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        com.bytedance.android.annie.container.fragment.q r102 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r102 == null) goto L9;
        this.f38629a = r102;
        return;
    }

    public r(com.bytedance.android.annie.container.fragment.q r100) {
        com.bytedance.android.annie.container.fragment.q r101 = this.f38629a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.f38629a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        q0 r102 = (q0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentResolver r103 = r101.getContext().getContentResolver();
        if (r103 != null) goto L5;
        ReadCalendarEventResultModel r104 = new ReadCalendarEventResultModel();
        r104.b(ReadCalendarEventResultModel.Code.Failed);
        r104.e("try to obtain contentResolver, but got a null");
        finishWithResult(r104);
        return;
    L5:
        this.f38630b = r102;
        this.f38631c = r103;
        s r105 = null;
        q9.b r106 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        if (r106.isPermissionAllGranted(r101.getContext(), new String[]{"android.permission.READ_CALENDAR"}) == false) goto L8;
        j(r102, r103);
        return;
    L8:
        int r107 = f.f38592a;
        Activity r108 = f.a(r101.getContext());
        if (r108 == null) goto L17;
        com.bytedance.android.annie.container.fragment.q r109 = this.f38629a;
        if (r109 != null) goto L13;
        r105 = new s(this, r102, r103);
    L13:
        r106.n(r108, r109, r105, new String[]{"android.permission.READ_CALENDAR"});
        return;
    }

    public final void j(q0 r100, ContentResolver r101) {
        Single.fromCallable(new c(r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
    }
}
