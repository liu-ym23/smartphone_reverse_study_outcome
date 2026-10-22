package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.PSHighlightCommonComp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r extends nk6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PSHighlightRenderHelper.a f133455a;

    public r(PSHighlightCommonComp.a r100) {
        this.f133455a = r100;
    }

    @Override // nk6.a
    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f133455a.a(r100);
    }

    @Override // nk6.a
    public final boolean a(View r100, ek6.c r101, ClickableSpan r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "span");
        boolean r103 = this.f133455a.b(r100, r101);
        if (r103 == true) goto L19;
        tb2.b r104 = null;
        if ((r101 instanceof ib2.a) == true) goto L7;
        r101 = null;
    L7:
        ib2.a r105 = (ib2.a) r101;
        if (r105 == null) goto L10;
        tb2.b r106 = r105.f488989a;
    L12:
        if ((r106 instanceof tb2.e) == false) goto L15;
        r104 = r106;
    L15:
        tb2.e r107 = (tb2.e) r104;
        if (r107 != null) goto L18;
        return r103;
    L18:
        return tb2.f.a(r107);
    L10:
        r106 = null;
        goto L12
    L19:
        return r103;
    }
}
