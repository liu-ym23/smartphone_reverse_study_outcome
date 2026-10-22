package com.bytedance.android.shopping.buynow.slice.counter;

import android.widget.EditText;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements SlcKeyboardMonitor.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f171081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f171082b;

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.c
    public final void b(int r100) {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor.c
    public final void a() {
        Function1<Integer, Unit> r100 = this.f171082b;
        Integer r101 = StringsKt.toIntOrNull(this.f171081a.getText().toString());
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        r100.invoke(Integer.valueOf(r102));
        return;
    L5:
        r102 = 1;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(EditText r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "expandTextCounter");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f171081a = r100;
        this.f171082b = r101;
    }
}
