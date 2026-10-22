package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CounterViewV2 f179319a;

    public j(CounterViewV2 r100) {
        this.f179319a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (r101 != 6) goto L9;
        r100.clearFocus();
        CartViewExtentionsKt.c(r100);
        Integer r103 = CartViewExtentionsKt.a(r100.getText().toString());
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
        this.f179319a.d(r104);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
