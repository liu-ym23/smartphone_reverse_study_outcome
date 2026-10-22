package c0b;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.cameraview.cameraViewV2.CaptureLayoutV2;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;
import com.ss.android.lark.cameraview.cameraViewV2.VideoPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k implements d0b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21980a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JCameraViewV2 f21981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f21982b;

        public a(JCameraViewV2 r100, long r101) {
            this.f21981a = r100;
            this.f21982b = r101;
        }

        public final void a() {
            e0b.c r100 = this.f21981a.f410895b;
            CaptureLayoutV2 r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("machine");
            r100 = null;
        L5:
            r100.j(this.f21981a.f410894a, true, this.f21982b);
            CaptureLayoutV2 r102 = this.f21981a.f410912s;
            if (r102 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mCaptureLayout");
        L9:
            r101.getClass();
            r101.postDelayed(new c0b.a(r101), 300);
            JCameraViewV2.g(this.f21981a);
            return;
        L8:
            r101 = r102;
            goto L9
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

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JCameraViewV2 f21983a;

        @Override // c0b.e
        public final void a() {
            JCameraViewV2.g(this.f21983a);
        }

        public final void b() {
            JCameraViewV2.h(this.f21983a);
        }

        public b(JCameraViewV2 r100) {
            this.f21983a = r100;
        }
    }

    @Override // d0b.a
    public final void b() {
        e0b.c r100 = this.f21980a.f410895b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r100 = null;
    L5:
        r100.e(new b(this.f21980a));
    }

    @Override // d0b.a
    public final void c() {
        JCameraViewV2.h(this.f21980a);
        e0b.c r100 = this.f21980a.f410895b;
        VideoPreview r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r100 = null;
    L5:
        JCameraViewV2 r102 = this.f21980a;
        Context r103 = r102.f410894a;
        VideoPreview r104 = r102.f410898e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L9:
        r100.f(r103, r101.getHolder().getSurface(), this.f21980a.f410915v);
        return;
    L8:
        r101 = r104;
        goto L9
    }

    public k(JCameraViewV2 r100) {
        this.f21980a = r100;
    }

    @Override // d0b.a
    public final void a(long r100) {
        JCameraViewV2 r101 = this.f21980a;
        r101.postDelayed(new a(r101, r100), ((long) 1000) - r100);
    }

    @Override // d0b.a
    public final void d(long r100) {
        e0b.c r101 = this.f21980a.f410895b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r101 = null;
    L5:
        r101.j(this.f21980a.f410894a, false, r100);
        JCameraViewV2.g(this.f21980a);
    }
}
