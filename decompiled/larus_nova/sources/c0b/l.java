package c0b;

import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;
import com.ss.android.lark.cameraview.cameraViewV2.VideoPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements d0b.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21984a;

    @Override // d0b.f
    public final void cancel() {
        e0b.c r100 = this.f21984a.f410895b;
        VideoPreview r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r100 = null;
    L5:
        VideoPreview r102 = this.f21984a.f410898e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L9:
        r100.i(r101.getHolder(), this.f21984a.f410915v);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    @Override // d0b.f
    public final void confirm() {
        e0b.c r100 = this.f21984a.f410895b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r100 = null;
    L5:
        r100.confirm();
    }

    public l(JCameraViewV2 r100) {
        this.f21984a = r100;
    }
}
