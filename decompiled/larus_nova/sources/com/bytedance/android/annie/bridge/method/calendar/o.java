package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.DeleteCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import e7.g0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast", name = "deleteCalendarEvent")
public final class o extends e7.f<g0, DeleteCalendarEventResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.q f38617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f38618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentResolver f38619c;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f38620a;

        public a(o r100) {
            this.f38620a = r100;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            Intrinsics.checkNotNullParameter(r102, "grantResults");
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r102) == false) goto L10;
            o r103 = this.f38620a;
            g0 r104 = r103.f38618b;
            if (r104 != null) goto L7;
        L9:
            DeleteCalendarEventResultModel r105 = new DeleteCalendarEventResultModel();
            r105.a(DeleteCalendarEventResultModel.Code.Failed);
            r105.b("delete failed.");
            r103.finishWithResult(r105);
            return;
        L7:
            if (r103.f38619c == null) goto L9;
            Intrinsics.checkNotNull(r104);
            ContentResolver r106 = this.f38620a.f38619c;
            Intrinsics.checkNotNull(r106);
            r103.j(r104, r106);
            return;
        L10:
            o r107 = this.f38620a;
            DeleteCalendarEventResultModel r108 = new DeleteCalendarEventResultModel();
            r108.a(DeleteCalendarEventResultModel.Code.NoPermission);
            r108.b("user denied permission");
            r107.finishWithResult(r108);
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f38621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f38622b;

        public c(g0 r100, ContentResolver r101) {
            this.f38621a = r100;
            this.f38622b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final DeleteCalendarEventResultModel.Code call() {
            int r100 = com.bytedance.android.annie.bridge.method.calendar.d.f38590a;
            g0 r101 = this.f38621a;
            ContentResolver r110 = this.f38622b;
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r110, "contentResolver");
            String[] r111 = {DBDefinition.ID};
            String[] r112 = {r101.getIdentifier()};
            Uri r113 = CalendarContract.Events.CONTENT_URI;
            f06.c r114 = new f06.c();
            Object[] r102 = {r113, r111, "sync_data1=?", r112, null};
            f06.b r115 = new f06.b();
            f06.d r103 = r114.b(240004, "android/content/ContentResolver", "query", r110, r102, "android.database.Cursor", r115);
            if (r103.f474982a == false) goto L5;
            r114.a(240004, "android/content/ContentResolver", "query", r110, r102, null, r115, false);
            Cursor r104 = (Cursor) r103.f474983b;
        L6:
            if (r104 != null) goto L9;
            r101.getIdentifier();
            return DeleteCalendarEventResultModel.Code.Failed;
        L9:
            if (r104.moveToNext() == false) goto L14;
            long r105 = r104.getLong(0);
            com.bytedance.android.annie.bridge.method.calendar.d.a(r110, CalendarContract.Reminders.CONTENT_URI, "event_id=?", new String[]{String.valueOf(r105)});
            if (com.bytedance.android.annie.bridge.method.calendar.d.a(r110, CalendarContract.Events.CONTENT_URI, "sync_data1=?", r112) <= 0) goto L18;
            return DeleteCalendarEventResultModel.Code.Success;
        L18:
            return DeleteCalendarEventResultModel.Code.Failed;
        L14:
            r101.getIdentifier();
            return DeleteCalendarEventResultModel.Code.Failed;
        L5:
            Cursor r116 = r110.query(r113, r111, "sync_data1=?", r112, null);
            r114.a(240004, "android/content/ContentResolver", "query", r110, r102, r116, r115, true);
            r104 = r116;
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f38623a;

        public d(o r100) {
            this.f38623a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DeleteCalendarEventResultModel.Code r101 = (DeleteCalendarEventResultModel.Code) r100;
            DeleteCalendarEventResultModel.Code r102 = DeleteCalendarEventResultModel.Code.Success;
            if (r101 != r102) goto L5;
            o r103 = this.f38623a;
            DeleteCalendarEventResultModel r104 = new DeleteCalendarEventResultModel();
            r104.a(r102);
            r104.b("delete Success");
            r103.finishWithResult(r104);
            return;
        L5:
            o r105 = this.f38623a;
            DeleteCalendarEventResultModel r106 = new DeleteCalendarEventResultModel();
            r106.a(DeleteCalendarEventResultModel.Code.Failed);
            r106.b("delete failed.");
            r105.finishWithResult(r106);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f38624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0 f38625b;

        public e(o r100, g0 r101) {
            this.f38624a = r100;
            this.f38625b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            o r101 = this.f38624a;
            DeleteCalendarEventResultModel r102 = new DeleteCalendarEventResultModel();
            g0 r103 = this.f38625b;
            r102.a(DeleteCalendarEventResultModel.Code.Failed);
            r102.b("delete calendar with unknown failure. id = " + r103.getIdentifier() + " , error msg = " + ((Throwable) r100).getMessage());
            r101.finishWithResult(r102);
        }
    }

    static {
    }

    public o(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        com.bytedance.android.annie.container.fragment.q r101 = this.f38617a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        com.bytedance.android.annie.container.fragment.q r102 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r102 == null) goto L9;
        this.f38617a = r102;
        return;
    }

    public o(com.bytedance.android.annie.container.fragment.q r100) {
        com.bytedance.android.annie.container.fragment.q r101 = this.f38617a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.f38617a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        g0 r102 = (g0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentResolver r103 = r101.getContext().getContentResolver();
        if (r103 != null) goto L5;
        DeleteCalendarEventResultModel r104 = new DeleteCalendarEventResultModel();
        r104.a(DeleteCalendarEventResultModel.Code.Failed);
        r104.b("try to obtain contentResolver, but got a null");
        finishWithResult(r104);
        return;
    L5:
        this.f38618b = r102;
        this.f38619c = r103;
        String[] r105 = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        p r106 = null;
        q9.b r107 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        if (r107.isPermissionAllGranted(r101.getContext(), (String[]) Arrays.copyOf(r105, 2)) == false) goto L8;
        j(r102, r103);
        return;
    L8:
        int r108 = f.f38592a;
        Activity r109 = f.a(r101.getContext());
        if (r109 == null) goto L17;
        com.bytedance.android.annie.container.fragment.q r110 = this.f38617a;
        if (r110 != null) goto L13;
        r106 = new p(this, r102, r103);
    L13:
        r107.n(r109, r110, r106, (String[]) Arrays.copyOf(r105, 2));
        return;
    }

    public final void j(g0 r100, ContentResolver r101) {
        Single.fromCallable(new c(r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this, r100));
    }
}
