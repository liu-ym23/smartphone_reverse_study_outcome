package bb8;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.bmhome.banner.BannerAdapter;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerAdapter f18542a;

    public f(BannerAdapter r100) {
        this.f18542a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (this.f18542a.f295877e == false) goto L6;
        r102.start();
        return;
    L6:
        r102.stop();
    }
}
