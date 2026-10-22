package com.bytedance.android.shopping.buynow.slice.counter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.buynow.utils.ViewUtilsKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BuyNowCounterView f171077a;

    public a(BuyNowCounterView r100) {
        this.f171077a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (r101 != 6) goto L6;
        r100.clearFocus();
        ViewUtilsKt.a(r100);
        int r103 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r100.getText().toString(), 0);
        BuyNowCounterView r104 = this.f171077a;
        int r105 = BuyNowCounterView.f171057u;
        r104.d(r103);
        return true;
    L6:
        return false;
    }
}
