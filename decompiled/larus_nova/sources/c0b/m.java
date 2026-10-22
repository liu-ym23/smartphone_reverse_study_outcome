package c0b;

import com.larus.nova.R;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;

/* JADX INFO: loaded from: classes34.dex */
public final class m implements d0b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21985a;

    public m(JCameraViewV2 r100) {
        this.f21985a = r100;
    }

    @Override // d0b.b
    public final void onClick() {
        JCameraViewV2 r100 = this.f21985a;
        int r101 = r100.f410903j % 2;
        if (r101 == 0) goto L7;
        if (r101 != 1) goto L8;
        JCameraViewV2.i(this.f21985a, r100.getResources().getString(R.string.Lark_IM_CameraFlashOn_Text), R.drawable.ud_icon_buzz_outlined);
        this.f21985a.f410904k = true;
    L8:
        this.f21985a.f410903j++;
        return;
    L7:
        JCameraViewV2.i(this.f21985a, r100.getResources().getString(R.string.Lark_IM_CameraFlashOff_Text), R.drawable.ud_icon_cancel_buzz_outlined);
        this.f21985a.f410904k = false;
        goto L8
    }
}
