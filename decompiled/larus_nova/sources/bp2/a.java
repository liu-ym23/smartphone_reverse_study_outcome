package bp2;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.privacy.av.universal.observer.PrivacyDetectBackgroundObserver;
import com.bytedance.android.livesdk.privacy.av.universal.observer.PrivacyDetectFragmentObserver;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.privacy.av.universal.observer.a f19966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PrivacyDetectFragmentObserver f19967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PrivacyDetectBackgroundObserver f19968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentActivity f19969d;

    /* JADX INFO: renamed from: bp2.a$a, reason: collision with other inner class name */
    public static final class C0332a {
    }

    static {
    }

    public final void b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        com.bytedance.android.livesdk.privacy.av.universal.observer.a r101 = this.f19966a;     // Catch: Throwable -> L20
        if (r101 == null) goto L7;
        Application r102 = jc1.a.b();     // Catch: Throwable -> L20
        if (r102 == null) goto L7;
        r102.unregisterActivityLifecycleCallbacks(r101.f156698b);     // Catch: Throwable -> L20
    L7:
        PrivacyDetectFragmentObserver r103 = this.f19967b;     // Catch: Throwable -> L20
        if (r103 == null) goto L14;
        FragmentActivity r104 = this.f19969d;     // Catch: Throwable -> L20
        if (r104 == null) goto L14;
        FragmentManager r105 = r104.getSupportFragmentManager();     // Catch: Throwable -> L20
        if (r105 == null) goto L14;
        r105.unregisterFragmentLifecycleCallbacks(r103);     // Catch: Throwable -> L20
    L14:
        PrivacyDetectBackgroundObserver r106 = this.f19968c;     // Catch: Throwable -> L20
        if (r106 == null) goto L17;
        Lazy r107 = HostAppMonitorService.f102946c;     // Catch: Throwable -> L20
        HostAppMonitorService.a.a().b((IHostAppMonitorListener) r106.f156694b.getValue());     // Catch: Throwable -> L20
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L20
        return;
    L17:
        r108 = null;
    L20:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public a() {
    }

    public final void a(FragmentActivity r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        this.f19969d = r100;     // Catch: Throwable -> L17
        PrivacyDetectBackgroundObserver r102 = new PrivacyDetectBackgroundObserver();     // Catch: Throwable -> L17
        if (r102.f156693a == true) goto L5;
        r102.f156693a = true;     // Catch: Throwable -> L17
        Lazy r103 = HostAppMonitorService.f102946c;     // Catch: Throwable -> L17
        HostAppMonitorService.a.a().a((IHostAppMonitorListener) r102.f156694b.getValue());     // Catch: Throwable -> L17
    L5:
        this.f19968c = r102;     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.privacy.av.universal.observer.a r104 = new com.bytedance.android.livesdk.privacy.av.universal.observer.a();     // Catch: Throwable -> L17
        if (r104.f156697a == true) goto L10;
        r104.f156697a = true;     // Catch: Throwable -> L17
        Application r105 = jc1.a.b();     // Catch: Throwable -> L17
        if (r105 == null) goto L10;
        r105.registerActivityLifecycleCallbacks(r104.f156698b);     // Catch: Throwable -> L17
    L10:
        this.f19966a = r104;     // Catch: Throwable -> L17
        PrivacyDetectFragmentObserver r106 = new PrivacyDetectFragmentObserver();     // Catch: Throwable -> L17
        if (r100 == null) goto L15;
        FragmentManager r107 = r100.getSupportFragmentManager();     // Catch: Throwable -> L17
        if (r107 == null) goto L15;
        r107.registerFragmentLifecycleCallbacks(r106, true);     // Catch: Throwable -> L17
    L15:
        this.f19967b = r106;     // Catch: Throwable -> L17
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
