package c0b;

import android.view.View;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;
import com.ss.android.lark.cameraview.cameraViewV2.VideoPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21974a;

    public g(JCameraViewV2 r100) {
        this.f21974a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e0b.c r101 = this.f21974a.f410895b;
        VideoPreview r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r101 = null;
    L5:
        VideoPreview r103 = this.f21974a.f410898e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoView");
    L9:
        r101.i(r102.getHolder(), this.f21974a.f410915v);
        return;
    L8:
        r102 = r103;
        goto L9
    }
}
