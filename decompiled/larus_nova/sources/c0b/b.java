package c0b;

import android.widget.ImageView;
import com.ss.android.lark.cameraview.cameraViewV2.CaptureLayoutV2;
import com.ss.android.lark.cameraview.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements d0b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayoutV2 f21970a;

    @Override // d0b.a
    public final void b() {
        d0b.a r100 = this.f21970a.f410878a;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // d0b.a
    public final void c() {
        d0b.a r100 = this.f21970a.f410878a;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public b(CaptureLayoutV2 r100) {
        this.f21970a = r100;
    }

    @Override // d0b.a
    public final void a(long r100) {
        d0b.a r101 = this.f21970a.f410878a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // d0b.a
    public final void d(long r100) {
        d0b.a r101 = this.f21970a.f410878a;
        if (r101 == null) goto L5;
        r101.d(r100);
    L5:
        CaptureLayoutV2 r102 = this.f21970a;
        w r103 = null;
        if (r102.f410886i == 0) goto L12;
        ImageView r104 = r102.f410882e;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomLeft");
        r104 = null;
    L10:
        r104.setVisibility(4);
    L12:
        if (r102.f410887j == 0) goto L17;
        ImageView r105 = r102.f410883f;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivCustomRight");
        r105 = null;
    L16:
        r105.setVisibility(4);
    L17:
        w r106 = r102.f410881d;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
    L21:
        r103.setVisibility(4);
        return;
    L20:
        r103 = r106;
        goto L21
    }
}
