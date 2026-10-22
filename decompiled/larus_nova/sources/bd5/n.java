package bd5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.widgets.t;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SubMenuViewPad f18672c;

    public n(SubMenuViewPad r100) {
        this.f18672c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        wc5.f.a r101 = this.f18672c.f228391a;
        if (r101 == null) goto L5;
        r101.eF();
    L5:
        tt5.a.h("SubMenuViewPad", "onClicked: this:" + this.f18672c.hashCode() + " onClickFilterMenu");
    }
}
