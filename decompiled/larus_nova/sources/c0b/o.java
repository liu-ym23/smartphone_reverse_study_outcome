package c0b;

import com.ss.android.lark.cameraview.FocusView;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o implements com.ss.android.lark.cameraview.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21990a;

    public o(JCameraViewV2 r100) {
        this.f21990a = r100;
    }

    @Override // com.ss.android.lark.cameraview.e.d
    public final void a() {
        FocusView r100 = this.f21990a.f410913t;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFocusView");
        r100 = null;
    L5:
        r100.setVisibility(4);
    }
}
