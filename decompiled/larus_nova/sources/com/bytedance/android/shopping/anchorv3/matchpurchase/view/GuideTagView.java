package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/GuideTagView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideTagView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f165196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f165197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f165198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f165199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f165200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f165201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f165202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f165203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f165204i;

    public GuideTagView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GuideTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public GuideTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        th.a.c(r100, R.layout.shopping_guide_tag_layout, this, true);
        this.f165196a = findViewById(R.id.guide_dot_top);
        this.f165197b = findViewById(R.id.guide_dot_bottom);
        this.f165198c = findViewById(R.id.guide_dot_start);
        this.f165199d = findViewById(R.id.guide_dot_end);
        this.f165200e = (SimpleDraweeView) findViewById(R.id.guide_icon);
        this.f165201f = (TextView) findViewById(R.id.guide_title);
        this.f165202g = (TextView) findViewById(R.id.guide_sub_title);
        this.f165203h = findViewById(R.id.guide_jump_icon);
        this.f165204i = findViewById(R.id.guide_info);
    }

    public /* synthetic */ GuideTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
