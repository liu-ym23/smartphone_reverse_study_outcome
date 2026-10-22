package com.bytedance.android.livesdk.interactivity.square.common.common;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.square.plugin.SquareModelSpanClickListener;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tb2.b;
import tb2.e;
import tb2.g;

/* JADX INFO: loaded from: classes9.dex */
public class CommonModelSpanClickListener implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<View, e, Boolean> f141132a;

    public CommonModelSpanClickListener() {
        CommonModelSpanClickListener$userSpanListener$1 r100 = CommonModelSpanClickListener$userSpanListener$1.INSTANCE;
        this.f141132a = CommonModelSpanClickListener$schemaSpanListener$1.INSTANCE;
        CommonModelSpanClickListener$viewClickListener$1 r101 = CommonModelSpanClickListener$viewClickListener$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ((SquareModelSpanClickListener) this).f141178c.invoke(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l
    public final boolean b(View r100, b r101, ClickableSpan r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "span");
        if ((r101 instanceof g) == false) goto L6;
        return ((SquareModelSpanClickListener) this).f141177b.invoke(r100, r101).booleanValue();
    L6:
        if ((r101 instanceof e) == true) goto L11;
        return false;
    L11:
        return this.f141132a.invoke(r100, r101).booleanValue();
    }
}
