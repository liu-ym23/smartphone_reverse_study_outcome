package bi3;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.shopping.skubuy.platform.view.PlatformLoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements n43.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlatformLoadingView f19097a;

    @Override // n43.c
    public final View getView() {
        return this.f19097a;
    }

    public e(PlatformLoadingView r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingView");
        this.f19097a = r100;
    }

    @Override // n43.b
    public final void d(y43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        PlatformLoadingView r101 = this.f19097a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r102 = false;
        if (r100.f565988a == false) goto L13;
        boolean r103 = r100.f565989b;
        boolean r104 = r100.f565990c;
        r101.setVisibility(0);
        if (r104 == false) goto L7;
        r101.f183193a.c();
    L8:
        if (r103 == false) goto L10;
        r101.f183194b.setVisibility(0);
        r101.f183195c.setVisibility(0);
    L17:
        if (r100.f565988a == true) goto L19;
    L21:
        r101.setClickable(r102);
        return;
    L19:
        if (r100.f565991d == false) goto L21;
        r102 = true;
        goto L21
    L10:
        r101.f183194b.setVisibility(8);
        r101.f183195c.setVisibility(8);
        r101.f183196d.setVisibility(8);
        ObjectAnimator r105 = r101.f183197e;
        if (r105 == null) goto L17;
        r105.cancel();
        goto L17
    L7:
        r101.f183193a.d();
        goto L8
    L13:
        r101.f183193a.d();
        r101.setVisibility(8);
        r101.f183194b.setVisibility(8);
        r101.f183195c.setVisibility(8);
        r101.f183196d.setVisibility(8);
        ObjectAnimator r106 = r101.f183197e;
        if (r106 == null) goto L17;
        r106.cancel();
        goto L17
    }
}
