package c0b;

import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements d0b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21973a;

    public f(JCameraViewV2 r100) {
        this.f21973a = r100;
    }

    @Override // d0b.b
    public final void onClick() {
        JCameraViewV2 r100 = this.f21973a;
        r100.f410905l = !r100.f410905l;
        d0b.b r101 = r100.f410897d;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.onClick();
        return;
    L8:
        return;
    }
}
