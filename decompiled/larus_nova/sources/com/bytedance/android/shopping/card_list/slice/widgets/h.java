package com.bytedance.android.shopping.card_list.slice.widgets;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CounterView f171858a;

    public h(CounterView r100) {
        this.f171858a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (r101 != 6) goto L9;
        r100.clearFocus();
        CardListExtentionsKt.h(r100);
        Integer r103 = CardListExtentionsKt.b(r100.getText().toString());
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
        this.f171858a.g(r104);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
