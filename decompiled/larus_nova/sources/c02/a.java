package c02;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.g;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.widget.GiftPanelWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.live.datacontext.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftPanelWidget.a f21902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GiftPanelWidget f21903b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e
    public final boolean isAdded() {
        if (this.f21902a.f129014b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e
    public final void remove() {
        g r100 = this.f21902a.f129014b;
        if (r100 != null) goto L5;
        return;
    L5:
        FrameLayout r101 = this.f21903b.f129008d;
        if (r101 == null) goto L8;
        r101.removeView(r100.f126598a);
    L8:
        this.f21902a.f129014b = null;
        d r102 = r100.f126600c;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        GiftContext r103 = b.b();
        if (r103 == null) goto L17;
        k<Boolean> r104 = r103.getGiftBannerShowEvent();
        if (r104 == null) goto L18;
        r104.post(Boolean.FALSE);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "topView");
        FrameLayout r101 = this.f21903b.f129008d;
        if (isAdded() == true) goto L24;
        if (r101 == null) goto L27;
        View r102 = r100.f126598a;
        if ((!Intrinsics.areEqual(r102.getParent(), r101)) == false) goto L15;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == true) goto L11;
        r103 = null;
    L11:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L14;
        r104.removeView(r102);
    L14:
        r101.addView(r102, r100.f126599b);
    L15:
        this.f21902a.f129014b = r100;
        d r105 = r100.f126600c;
        if (r105 == null) goto L18;
        r105.b();
    L18:
        GiftContext r106 = b.b();
        if (r106 == null) goto L25;
        k<Boolean> r107 = r106.getGiftBannerShowEvent();
        if (r107 == null) goto L26;
        r107.post(Boolean.TRUE);
        return;
    L26:
        return;
    L25:
        return;
    L27:
        return;
    }

    public a(GiftPanelWidget.a r100, GiftPanelWidget r101) {
        this.f21902a = r100;
        this.f21903b = r101;
    }
}
