package com.obric.utils;

import android.os.SystemClock;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ClickUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"setOnDebouncedClickListener", "", "Landroid/view/View;", "onClickListener", "Landroid/view/View$OnClickListener;", "intervalMs", "", "onClick", "Lkotlin/Function1;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClickUtilsKt {
    /* JADX INFO: renamed from: $r8$lambda$cVUyCB0Pi-Pov0S-9xrYU4C-qL0, reason: not valid java name */
    public static /* synthetic */ void m780$r8$lambda$cVUyCB0PiPov0S9xrYU4CqL0(Ref.LongRef r0, long r1, Function1 r3, View r4) {
        setOnDebouncedClickListener$lambda$0(r0, r1, r3, r4);
    }

    public static final void setOnDebouncedClickListener(View r7, View.OnClickListener r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "onClickListener");
        setOnDebouncedClickListener$default(r7, r8, 0, 2, null);
    }

    public static /* synthetic */ void setOnDebouncedClickListener$default(View r0, long r1, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 600;
    L5:
        setOnDebouncedClickListener(r0, r1, r3);
    }

    public static final void setOnDebouncedClickListener(View r2, final long r3, final Function1<? super View, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "onClick");
        final Ref.LongRef r0 = new Ref.LongRef();
        r2.setOnClickListener(new ClickUtilsKt$$ExternalSyntheticLambda0(r0, r3, r5));
    }

    private static final void setOnDebouncedClickListener$lambda$0(Ref.LongRef r4, long r5, Function1 r7, View r8) {
        Intrinsics.checkNotNullParameter(r4, "$lastClickTime");
        Intrinsics.checkNotNullParameter(r7, "$onClick");
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - r4.element) >= r5) goto L5;
        return;
    L5:
        r4.element = r0;
        Intrinsics.checkNotNullExpressionValue(r8, BaseSwitches.V);
        r7.invoke(r8);
    }

    public static /* synthetic */ void setOnDebouncedClickListener$default(View r0, View.OnClickListener r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 600;
    L5:
        setOnDebouncedClickListener(r0, r1, r2);
    }

    public static final void setOnDebouncedClickListener(View r1, final View.OnClickListener r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        setOnDebouncedClickListener(r1, r3, new AnonymousClass2(r2));
    }
}
