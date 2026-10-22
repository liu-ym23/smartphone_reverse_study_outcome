package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/FixedRecyclerView;", "Lcom/bytedance/android/shopping/anchorv3/widget/BasePdpRecyclerView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FixedRecyclerView extends BasePdpRecyclerView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f165593c;

    public FixedRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FixedRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView
    public final boolean r() {
        return this.f165593c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L16:
        r102 = false;
    L17:
        this.f165593c = r102;
        return super.onTouchEvent(r100);
    L14:
        if (r101.intValue() != 2) goto L16;
    L9:
        if (r101.intValue() != 0) goto L11;
    L4:
        r101 = null;
        goto L5
    }

    public FixedRecyclerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setEdgeEffectFactory(new AnonymousClass1(r100));
    }

    public /* synthetic */ FixedRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
