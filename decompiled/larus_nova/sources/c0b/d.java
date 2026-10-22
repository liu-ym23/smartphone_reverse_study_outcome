package c0b;

import android.view.View;
import com.ss.android.lark.cameraview.cameraViewV2.CaptureLayoutV2;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayoutV2 f21972a;

    public d(CaptureLayoutV2 r100) {
        this.f21972a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d0b.b r101 = this.f21972a.f410880c;
        if (r101 == null) goto L6;
        r101.onClick();
        return;
    }
}
