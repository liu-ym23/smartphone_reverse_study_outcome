package c0b;

import android.app.Activity;
import android.view.View;
import com.ss.android.lark.cameraview.cameraViewV2.JCameraViewV2;
import com.ss.android.lark.utils.ContextsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JCameraViewV2 f21979a;

    public j(JCameraViewV2 r100) {
        this.f21979a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Activity r101 = ContextsKt.requireActivity(this.f21979a);
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }
}
