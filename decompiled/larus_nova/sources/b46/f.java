package b46;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import bytedance.util.BdFileUtils;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public class f extends ContentObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f17528e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f17529f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f17530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f17531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17533d;

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((f16.b) r101).f475063d), Long.valueOf(((f16.b) r100).f475063d));
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f17534a;

        public c(f r100) {
            this.f17534a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17534a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f17528e = new String[]{"tmp.png"};
        f17529f = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截屏录屏"};
    }

    public void b() {
        this.f17532c = System.currentTimeMillis();
        ExecutorService r100 = BulletLogger.f247763a;
        BulletLogger.m("onUserCaptureScreen ScreenCaptureObserver.onChange, timestamp=" + this.f17532c, null, null, null, "", 110);
        List r101 = f16.a.d(this.f17531b);
        StringBuilder r102 = new StringBuilder("onUserCaptureScreen ScreenCaptureObserver.onChange，imageCount=");
        r102.append(this.f17533d);
        r102.append(", images.size=");
        ArrayList r110 = (ArrayList) r101;
        r102.append(r110.size());
        BulletLogger.m(r102.toString(), null, null, null, "", 110);
        if (this.f17533d < r110.size()) goto L6;
        this.f17533d = r110.size();
        return;
    L6:
        this.f17533d = r110.size();
        f16.b r103 = (f16.b) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(r101, new b()));
        if (r103 != null) goto L9;
        return;
    L9:
        com.bytedance.android.anniex.assemble.a r104 = com.bytedance.android.anniex.assemble.a.f40251a;
        BdFileUtils.convertUriToPath(this.f17531b, r103.f475068i);
        String r105 = r103.f475069j;
        if (r105 == null) goto L13;
        a(r105, r103.f475063d);
        return;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100) {
        onChange(r100, null, 4);
    }

    public f(Uri r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "appContext");
        super(null);
        this.f17530a = r100;
        this.f17531b = r101;
        this.f17532c = Long.MIN_VALUE;
        this.f17533d = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "relativePath");
        long r100 = 1000;
        long r101 = this.f17532c - (r111 * r100);
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.m("onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture,interval=" + r101 + " , timestamp=" + (this.f17532c / r100) + ", dateAdded=" + r111, null, null, null, "", 110);
        boolean r112 = false;
        if (r101 >= 5000) goto L5;
        boolean r103 = 1;
    L6:
        Locale r104 = Locale.ROOT;
        if (r110 == null) goto L36;
        String r105 = r110.toLowerCase(r104);
        String[] r106 = f17529f;
        int r107 = r106.length;
        int r108 = 0;
    L10:
        if (r108 >= r107) goto L16;
        if (StringsKt.contains$default(r105, r106[r108], false, 2, null) == true) goto L23;
        r108 = r108 + 1;
    L23:
        r112 = true;
    L25:
        ExecutorService r113 = BulletLogger.f247763a;
        BulletLogger.m("onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, matchDateAdded=" + r103 + ", matchPath=" + r112, null, null, null, "", 110);
        int r114 = r103 ^ 1;
        if (r112 == true) goto L28;
        r114 = r114 | 2;
    L28:
        Iterator<WeakReference<e>> r115 = h.f17538d.iterator();
    L30:
        if (r115.hasNext() == false) goto L34;
        e r116 = r115.next().get();
        if (r116 == null) goto L30;
        r116.a(r114);
        goto L30
    L34:
        return;
    L16:
        if (DeviceUtils.isHuawei() == false) goto L25;
        if (StringsKt.contains$default(r110, "/dcim/camera/", false, 2, null) == false) goto L25;
        String[] r117 = f17528e;
        int r109 = r117.length;
        int r118 = 0;
    L20:
        if (r118 >= r109) goto L25;
        if (StringsKt.contains$default(r105, r117[r118], false, 2, null) == true) goto L23;
        r118 = r118 + 1;
        goto L20
    L36:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        onChange(r100, r101, 4);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101, int r102) {
        if (h.f17539e.get() == false) goto L6;
        return;
    L6:
        if (com.bytedance.ies.bullet.service.base.h.q0() == true) goto L8;
    L16:
        new Handler(Looper.getMainLooper()).postDelayed(new c(this), 1000);
        return;
    L8:
        if (Build.VERSION.SDK_INT < 30) goto L16;
        if ((r102 & 4) != 4) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        ExecutorService r104 = BulletLogger.f247763a;
        BulletLogger.m("onUserCaptureScreen ScreenCaptureObserver.onChange, uri=" + r101 + ", flags=" + r102, null, null, null, "", 110);
        return;
    L12:
        r103 = false;
        goto L13
    }
}
