package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import bc3.d;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/CommentIndicatorView;", "Landroid/widget/FrameLayout;", "", "selected", "", "setIndicatorSelected", "", "getCurrentProgress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentIndicatorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f172411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f172412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f172413c;

    public static final class a extends com.bytedance.android.ec.core.widget.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CommentIndicatorView f172414g;

        public a(CommentIndicatorView r100) {
            this.f172414g = r100;
            super(null, null, 3);
        }

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            CommentIndicatorView r101 = this.f172414g;
            d r102 = r101.f172413c;
            if (r102 == null) goto L6;
            r102.onItemSelected(r101.f172412b);
            return;
        }
    }

    public CommentIndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getCurrentProgress() {
        return this.f172411a.getProgress();
    }

    public final void setIndicatorSelected(boolean r100) {
        if (r100 == false) goto L4;
        this.f172411a.setProgress(100);
        return;
    L4:
        this.f172411a.setProgress(0);
    }

    public CommentIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_indicator_progress_view, this, true);
        this.f172411a = (ProgressBar) findViewById(R.id.ec_commerce_indicator_progress_bar);
        setOnClickListener(new a(this));
    }

    public /* synthetic */ CommentIndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
