package com.bytedance.android.live.livelink.platformapi.avclient.video;

import com.bytedance.android.live.pushstream.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.x;

/* JADX INFO: loaded from: classes46.dex */
public final class AndroidVideoStreamApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f81365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f81366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f81367c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidVideoStreamApi f81368a;

        public final void a() {
            wv0.a r100 = (wv0.a) this.f81368a.f81365a.getValue();
            if (r100 == null) goto L6;
            r100.b(this.f81368a.f81367c);
            return;
        }

        public final void b() {
            wv0.a r100 = (wv0.a) this.f81368a.f81365a.getValue();
            if (r100 == null) goto L6;
            r100.release();
            return;
        }

        public a(AndroidVideoStreamApi r100) {
            this.f81368a = r100;
        }
    }

    public final x b() {
        return this.f81367c.b();
    }

    public AndroidVideoStreamApi(d r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        this.f81367c = r100;
        this.f81365a = LazyKt.lazy(AndroidVideoStreamApi$mStreamSignHelper$2.INSTANCE);
        this.f81366b = new a(this);
    }

    public final void c(String r100) {
        this.f81367c.B(r100);
    }

    public final void a(int r100, int r101) {
        this.f81367c.z0(r100, r101);
    }
}
