package av;

import android.view.View;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f16343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f16346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f16347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16349g;

    public d() {
        throw null;
    }

    public d(WeakReference r100, GamecpTracker.b r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "pageExposureListener");
        this.f16343a = r100;
        this.f16344b = 0;
        this.f16345c = 0;
        this.f16346d = r101;
        this.f16347e = 0;
        this.f16348f = 0;
        this.f16349g = false;
    }
}
