package com.stepos.ailauncher.chat.fragment;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class AmooAppDetailFragment$screenshotAdapter$1 extends FunctionReferenceImpl implements p9.q<View, List<? extends String>, Integer, Y8.t> {
    public AmooAppDetailFragment$screenshotAdapter$1(Object obj) {
        super(3, obj, AmooAppDetailFragment.class, "showScreenshotPreview", "showScreenshotPreview(Landroid/view/View;Ljava/util/List;I)V", 0);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ Y8.t invoke(View view, List<? extends String> list, Integer num) {
        l(view, list, num.intValue());
        return Y8.t.f7040a;
    }

    public final void l(View p02, List<String> p12, int i10) {
        kotlin.jvm.internal.p.i(p02, "p0");
        kotlin.jvm.internal.p.i(p12, "p1");
        ((AmooAppDetailFragment) this.receiver).i0(p02, p12, i10);
    }
}
