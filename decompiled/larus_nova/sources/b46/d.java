package b46;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends f {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f17527a;

        public a(d r100) {
            this.f17527a = r100;
        }

        public final void a() {
            d r100 = this.f17527a;
            r100.getClass();
            r100.f17532c = System.currentTimeMillis();
            ExecutorService r101 = BulletLogger.f247763a;
            BulletLogger.m("onUserCaptureScreen InternalScreenCaptureObserver.onChange, timestamp=" + r100.f17532c, null, null, null, "", 110);
            String[] r102 = {"_data", "date_added"};
            ContentResolver r110 = r100.f17531b.getContentResolver();
            Uri r103 = r100.f17530a;
            f06.c r111 = new f06.c();
            Object[] r104 = {r103, r102, null, null, "date_modified desc"};
            f06.b r112 = new f06.b();
            f06.d r113 = r111.b(240004, "android/content/ContentResolver", "query", r110, r104, "android.database.Cursor", r112);
            if (r113.f474982a == false) goto L5;
            r111.a(240004, "android/content/ContentResolver", "query", r110, r104, null, r112, false);
            Cursor r105 = (Cursor) r113.f474983b;
        L6:
            if (r105 == null) goto L23;
            Cursor r106 = r105;
            Cursor r107 = r106;     // Catch: Throwable -> L17
            int r108 = r107.getCount();     // Catch: Throwable -> L17
            if (r100.f17533d < r108) goto L11;
            r100.f17533d = r108;     // Catch: Throwable -> L17
        L15:
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L17
            CloseableKt.closeFinally(r106, null);
            return;
        L11:
            r100.f17533d = r108;     // Catch: Throwable -> L17
            if (r107.moveToFirst() == false) goto L15;
            int r114 = r107.getColumnIndex("date_added");     // Catch: Throwable -> L17
            r100.a(r107.getString(r107.getColumnIndex("_data")), r107.getLong(r114));     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            CloseableKt.closeFinally(r106, th);
            throw th;
        L23:
            return;
        L5:
            r105 = r110.query(r103, r102, null, null, "date_modified desc");
            r111.a(240004, "android/content/ContentResolver", "query", r110, r104, r105, r112, true);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // b46.f
    public final void b() {
        new Handler(Looper.getMainLooper()).postDelayed(new a(this), 1000);
    }

    public d(Uri r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "appContext");
        super(r100, r101);
    }
}
