package com.bytedance.android.livesdk.chatroom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/OverScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkn2/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkn2/k;", "getBase", "()Lkn2/k;", "setBase", "(Lkn2/k;)V", "base", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrollRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kn2.k f105089a;

    public OverScrollRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OverScrollRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void r() {
        if (this.f105089a != null) goto L26;
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if (r100 != null) goto L12;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L10;
        return;
    L10:
        throw new RuntimeException("must set layoutManager first");
    L12:
        if ((r100 instanceof LinearLayoutManager) == false) goto L14;
        int r101 = ((LinearLayoutManager) r100).getOrientation();
    L16:
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L18;
        r101 = ((StaggeredGridLayoutManager) r100).getOrientation();
    L18:
        if (r101 != 0) goto L20;
        kn2.k r102 = new kn2.a(new ln2.c(this));
    L24:
        this.f105089a = r102;
        setOnTouchListener(null);
        return;
    L20:
        if (r101 == 1) goto L22;
        return;
    L22:
        r102 = new kn2.m(new ln2.c(this));
        goto L24
    L14:
        r101 = -1;
        goto L16
    }

    public final kn2.k getBase() {
        return this.f105089a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = super.dispatchTouchEvent(r100);
        kn2.k r102 = this.f105089a;
        if (r102 == null) goto L5;
        r102.onTouch(this, r100);
    L5:
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public final void setBase(kn2.k r100) {
        this.f105089a = r100;
    }

    public OverScrollRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOnTouchListener(null);
    }

    public /* synthetic */ OverScrollRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
