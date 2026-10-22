package cjc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.videoshop.mediaview.VideoPatchLayout;

/* JADX INFO: loaded from: classes40.dex */
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPatchLayout f23999a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        super.handleMessage(r100);
        VideoPatchLayout r101 = this.f23999a;
        com.ss.android.videoshop.mediaview.a r102 = r101.f456041c;
        if (r102 != null) goto L5;
        return;
    L5:
        if (UIUtils.isViewVisible(r102.getView()) == false) goto L9;
        UIUtils.setViewVisibility(r101.f456041c.getView(), 8);
        return;
    }

    public f(VideoPatchLayout r100, Looper r101) {
        this.f23999a = r100;
        super(r101);
    }
}
