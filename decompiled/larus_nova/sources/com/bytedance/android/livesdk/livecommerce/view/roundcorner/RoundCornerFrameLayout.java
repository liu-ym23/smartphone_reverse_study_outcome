package com.bytedance.android.livesdk.livecommerce.view.roundcorner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rl2.a;
import rl2.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/roundcorner/RoundCornerFrameLayout;", "Landroid/widget/FrameLayout;", "Lrl2/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundCornerFrameLayout extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f153237a;

    public RoundCornerFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundCornerFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // rl2.a
    public final void h() {
        invalidate();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        b r101 = this.f153237a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r101.f538446a.a(r100);
    }

    @Override // rl2.a
    public final void g(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.draw(r100);
    }

    public RoundCornerFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        b r103 = new b(this);
        this.f153237a = r103;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.f538446a.b(r100, r101, r102);
    }

    public /* synthetic */ RoundCornerFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b r104 = this.f153237a;
        int r105 = getWidth();
        int r106 = getHeight();
        r104.f538446a.c(r105, r106);
    }
}
