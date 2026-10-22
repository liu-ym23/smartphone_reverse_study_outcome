package c0b;

import android.view.View;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21978a;

    public i(JCameraViewV2 r100) {
        this.f21978a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e0b.c r101 = this.f21978a.f410895b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("machine");
        r101 = null;
    L5:
        r101.confirm();
    }
}
