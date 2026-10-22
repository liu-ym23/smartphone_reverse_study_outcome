package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.anchorv4.vm.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/AnchorV4HeadBottomView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv4/vm/c;", "getHeadViewStatusListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/AnchorV4HeadBottomHandler;", "b", "Lkotlin/Lazy;", "getHeadBottomHandler", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/AnchorV4HeadBottomHandler;", "headBottomHandler", "Ld83/b;", "c", "Ld83/b;", "getHeadViewAbility", "()Ld83/b;", "setHeadViewAbility", "(Ld83/b;)V", "headViewAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadBottomView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnresponsiveRecyclerView f168969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f168970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d83.b f168971c;

    public AnchorV4HeadBottomView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4HeadBottomView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final AnchorV4HeadBottomHandler getHeadBottomHandler() {
        return (AnchorV4HeadBottomHandler) this.f168970b.getValue();
    }

    public final c getHeadViewStatusListener() {
        return getHeadBottomHandler();
    }

    public final d83.b getHeadViewAbility() {
        return this.f168971c;
    }

    public final void setHeadViewAbility(d83.b r100) {
        this.f168971c = r100;
    }

    public AnchorV4HeadBottomView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        UnresponsiveRecyclerView r103 = new UnresponsiveRecyclerView(r100, null, 6, 0);
        this.f168969a = r103;
        this.f168970b = LazyKt.lazy(new AnchorV4HeadBottomView$headBottomHandler$2(this));
        addView(r103, -1, com.bytedance.android.shopping.extensions.b.b(12));
    }

    public /* synthetic */ AnchorV4HeadBottomView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
