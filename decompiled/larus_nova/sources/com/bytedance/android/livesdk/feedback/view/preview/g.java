package com.bytedance.android.livesdk.feedback.view.preview;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LargeCardPreviewView f125019a;

    public g(LargeCardPreviewView r100) {
        this.f125019a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 == null) goto L12;
        int r102 = ((Number) r101.component1()).intValue();
        int r103 = ((Number) r101.component2()).intValue();
        if (1 > r103) goto L13;
        if (r102 <= r103) goto L11;
        float r104 = r103 / r102;
        int r105 = this.f125019a.f124995e.getWidth();
        float r106 = r105 * r104;
        ViewGroup.LayoutParams r107 = this.f125019a.f124995e.getLayoutParams();
        r107.width = r105;
        r107.height = (int) r106;
        this.f125019a.f124995e.setLayoutParams(r107);
        return;
    L11:
        return;
    L13:
        return;
    }
}
