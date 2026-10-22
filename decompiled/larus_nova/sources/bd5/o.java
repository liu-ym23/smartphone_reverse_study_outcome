package bd5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.widgets.t;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SubMenuViewPad f18673c;

    public o(SubMenuViewPad r100) {
        this.f18673c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        SubMenuViewPad r101 = this.f18673c;
        boolean r102 = !r101.f228395e;
        r101.f228395e = r102;
        r101.b(r102);
        SubMenuViewPad r103 = this.f18673c;
        wc5.f.a r104 = r103.f228391a;
        if (r104 == null) goto L5;
        r104.WU(r103.f228395e);
    L5:
        tt5.a.h("SubMenuViewPad", "onClicked: this:" + this.f18673c.hashCode() + " onClickSwitchMenu");
    }
}
