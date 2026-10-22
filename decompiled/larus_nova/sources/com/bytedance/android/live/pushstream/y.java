package com.bytedance.android.live.pushstream;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.li;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: classes47.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f89531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f89532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f89533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f89534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d0 f89535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0.a f89536f;

    public final double a() {
        d0 r100 = this.f89535e;
        if (r100 == null) goto L7;
        r100.p();
        return -1.0d;
    L7:
        return -1.0d;
    }

    public final void b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        if (li.f120681a.getValue().isEnable() == false) goto L27;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r100), "PushBase");     // Catch: Exception -> L19
        if (r102.isNull("width") == false) goto L16;
        return;
    L16:
        if (r102.isNull("height") == true) goto L26;
        this.f89534d.f89468g = JSONObjectProtectorUtils.getInt(r102, "width");     // Catch: Exception -> L19
        this.f89534d.f89469h = JSONObjectProtectorUtils.getInt(r102, "height");     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        ALogger.i("ttlive_stream_reuse_stream_horizontal", "error: " + e.toString());
        return;
    L27:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void c(String r100, h0.d r101) {
        b(r100);
        d0 r102 = this.f89531a;
        if (r102 == null) goto L6;
        r102.A();
        return;
    }

    public y(u r100, Handler r101, LiveStream4.g r102, d0 r103, d0.a r104) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "glHandler");
        Intrinsics.checkNotNullParameter(r102, "videoCaptureObserver");
        this.f89534d = r100;
        this.f89535e = r103;
        this.f89536f = r104;
        this.f89531a = r103;
        this.f89532b = new CopyOnWriteArrayList();
        Lazy r105 = LazyKt.lazy(VideoCaptureWrapper$composeDisposable$2.INSTANCE);
        this.f89533c = r105;
        r100.getClass();
        d0 r106 = this.f89535e;
        if (r106 == null) goto L5;
        r106.d0();
    L5:
        Disposable r107 = xs2.b.a().b(pv0.i.class).subscribe(new w(this), x.f89530a);
        ((CompositeDisposable) r105.getValue()).add(r107);
    }
}
