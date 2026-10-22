package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7.f0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast", name = "createCalendarEvent")
public final class g extends e7.e<f0, CreateCalendarEventResultModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f38593d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.q f38594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f38595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentResolver f38596c;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f38597a;

        public a(g r100) {
            this.f38597a = r100;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
            Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
            Intrinsics.checkNotNullParameter(r102, "grantResults");
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r102) == false) goto L10;
            g r103 = this.f38597a;
            f0 r104 = r103.f38595b;
            if (r104 != null) goto L7;
        L9:
            CreateCalendarEventResultModel r105 = new CreateCalendarEventResultModel();
            r105.a(CreateCalendarEventResultModel.Code.Failed);
            r105.b("create calendar failed!");
            r103.finishWithResult(r105);
            return;
        L7:
            if (r103.f38596c == null) goto L9;
            Intrinsics.checkNotNull(r104);
            ContentResolver r106 = this.f38597a.f38596c;
            Intrinsics.checkNotNull(r106);
            r103.j(r104, r106);
            return;
        L10:
            g r107 = this.f38597a;
            CreateCalendarEventResultModel r108 = new CreateCalendarEventResultModel();
            r108.a(CreateCalendarEventResultModel.Code.NoPermission);
            r108.b("user denied permission");
            r107.finishWithResult(r108);
        }
    }

    public static final class b {
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f38598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f38599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f38600c;

        public c(g r100, f0 r101, ContentResolver r102) {
            this.f38598a = r100;
            this.f38599b = r101;
            this.f38600c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            g r100 = this.f38598a;
            f0 r101 = this.f38599b;
            ContentResolver r110 = this.f38600c;
            int r102 = g.f38593d;
            r100.getClass();
            String[] r103 = {"sync_data1"};
            boolean r111 = false;
            String[] r112 = {r101.getIdentifier()};
            Uri r104 = CalendarContract.Events.CONTENT_URI;
            f06.c r113 = new f06.c();
            Object[] r114 = {r104, r103, "sync_data1=?", r112, null};
            f06.b r115 = new f06.b();
            f06.d r116 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
            if (r116.f474982a == false) goto L5;
            r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
            Cursor r105 = (Cursor) r116.f474983b;
        L6:
            if (r105 == null) goto L19;
            Cursor r106 = r105;
            if (r106.getCount() <= 0) goto L11;
            r111 = true;
        L11:
            CloseableKt.closeFinally(r106, null);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r106, th);
            throw th;
        L19:
            return Boolean.valueOf(r111);
        L5:
            r105 = r110.query(r104, r103, "sync_data1=?", r112, null);
            r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r105, r115, true);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f38601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f38602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f38603c;

        public d(g r100, f0 r101, ContentResolver r102) {
            this.f38601a = r100;
            this.f38602b = r101;
            this.f38603c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L6;
            g r102 = this.f38601a;
            f0 r103 = this.f38602b;
            ContentResolver r104 = this.f38603c;
            r102.getClass();
            Single.fromCallable(new l(r103, r104)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r102), new n(r102, r103));
            return;
        L6:
            if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L10;
            g r105 = this.f38601a;
            f0 r106 = this.f38602b;
            ContentResolver r107 = this.f38603c;
            r105.getClass();
            Single.fromCallable(new h(r106, r107)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new i(r105), new j(r105));
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f38604a = null;

        static {
            f38604a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    public g(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        com.bytedance.android.annie.container.fragment.q r101 = this.f38594a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        com.bytedance.android.annie.container.fragment.q r102 = (com.bytedance.android.annie.container.fragment.q) r100.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r102 == null) goto L9;
        this.f38594a = r102;
        return;
    }

    public g(com.bytedance.android.annie.container.fragment.q r100) {
        com.bytedance.android.annie.container.fragment.q r101 = this.f38594a;
        if (r101 == null) goto L5;
        r101.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.f38594a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        f0 r102 = (f0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentResolver r103 = r101.getContext().getContentResolver();
        if (r103 != null) goto L5;
        CreateCalendarEventResultModel r104 = new CreateCalendarEventResultModel();
        r104.a(CreateCalendarEventResultModel.Code.Failed);
        r104.b("try to obtain contentResolver, but got a null");
        finishWithResult(r104);
        return;
    L5:
        this.f38595b = r102;
        this.f38596c = r103;
        String[] r105 = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        k r106 = null;
        q9.b r107 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        if (r107.isPermissionAllGranted(r101.getContext(), (String[]) Arrays.copyOf(r105, 2)) == false) goto L9;
        j(r102, r103);
        return;
    L9:
        if (this.f38594a != null) goto L11;
        r106 = new k(this, r102, r103);
    L11:
        int r108 = f.f38592a;
        Activity r109 = f.a(r101.getContext());
        if (r109 == null) goto L17;
        r107.n(r109, this.f38594a, r106, (String[]) Arrays.copyOf(r105, 2));
        return;
    }

    public final void j(f0 r100, ContentResolver r101) {
        Single.fromCallable(new c(this, r100, r101)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new d(this, r100, r101), e.f38604a);
    }
}
