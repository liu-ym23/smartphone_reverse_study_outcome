package c0b;

import android.view.View;
import com.ss.android.lark.cameraview.cameraViewV2.CaptureLayoutV2;
import com.ss.android.lark.cameraview.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayoutV2 f21971a;

    public c(CaptureLayoutV2 r100) {
        this.f21971a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        w r101 = this.f21971a.f410881d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        r101 = null;
    L5:
        int r102 = r101.f411024a;
        if (r102 != 4) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return;
    L14:
        d0b.b r104 = this.f21971a.f410879b;
        if (r104 == null) goto L18;
        r104.onClick();
        return;
    L18:
        return;
    L8:
        if (r102 == 3) goto L11;
        r103 = false;
        goto L12
    }
}
