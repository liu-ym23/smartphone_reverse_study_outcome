package com.obric.oui.popover;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LongClickUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/LongClickUtil;", "", "()V", "setOnLongClickListenerEx", "", "Landroid/view/View;", "longClickListenerEx", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LongClickUtil {
    public static final LongClickUtil INSTANCE = null;

    /* JADX INFO: renamed from: $r8$lambda$8SjGBGMeKb6WLwAFbYl4-kVSHYk, reason: not valid java name */
    public static /* synthetic */ boolean m592$r8$lambda$8SjGBGMeKb6WLwAFbYl4kVSHYk(OnLongClickListenerEx r0, View r1) {
        return m593setOnLongClickListenerEx$lambda0(r0, r1);
    }

    static {
        INSTANCE = new LongClickUtil();
    }

    private LongClickUtil() {
    }

    public final void setOnLongClickListenerEx(View r1, final OnLongClickListenerEx r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "longClickListenerEx");
        r1.setOnTouchListener(r2.getOnTouchListener());
        r1.setOnLongClickListener(new LongClickUtil$$ExternalSyntheticLambda0(r2));
    }

    /* JADX INFO: renamed from: setOnLongClickListenerEx$lambda-0, reason: not valid java name */
    private static final boolean m593setOnLongClickListenerEx$lambda0(OnLongClickListenerEx r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "$longClickListenerEx");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        return r1.onLongClick(r2, r1.getClickPos());
    }
}
