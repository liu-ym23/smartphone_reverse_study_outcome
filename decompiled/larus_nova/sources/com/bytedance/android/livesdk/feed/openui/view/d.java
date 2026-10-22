package com.bytedance.android.livesdk.feed.openui.view;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveListBlock f124269a;

    public d(LiveListBlock r100) {
        this.f124269a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "motionEvent");
        if (r101.getAction() != 0) goto L5;
    L10:
        ((RecyclerView) this.f124269a.a(R.id.recycler_view)).getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    L5:
        if (r101.getAction() == 2) goto L10;
        if (r101.getAction() == 1) goto L10;
        ((RecyclerView) this.f124269a.a(R.id.recycler_view)).getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
