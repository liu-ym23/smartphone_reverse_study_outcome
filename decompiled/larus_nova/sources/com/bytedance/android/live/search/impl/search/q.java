package com.bytedance.android.live.search.impl.search;

import android.view.MotionEvent;
import android.widget.EditText;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q implements LiveSearchIntermediateView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchResultFragment f100783a;

    public q(LiveSearchResultFragment r100) {
        this.f100783a = r100;
    }

    @Override // com.bytedance.android.live.search.impl.search.LiveSearchIntermediateView.b
    public final void c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getActionMasked() != 0) goto L12;
        LiveSearchIntermediateViewModel r101 = this.f100783a.f100641p;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.canDismissKeyboardOnActionDown() != true) goto L14;
        int r102 = com.bytedance.android.live.search.impl.search.helper.a.f100772a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.f100783a.f100632g);
        EditText r103 = this.f100783a.f100632g;
        if (r103 == null) goto L15;
        r103.setCursorVisible(false);
        return;
    L15:
        return;
    L14:
        return;
    }
}
