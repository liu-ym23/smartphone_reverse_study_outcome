package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.anchorv3.anchorv3.detail.widget.CategoryView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3GuessULikeTitleView;", "Landroid/widget/RelativeLayout;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3GuessULikeTitleView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CategoryView f165446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f165447b;

    public AnchorV3GuessULikeTitleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3GuessULikeTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public AnchorV3GuessULikeTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        u63.a.a(r100, R.layout.ec_commerce_anchor_v3_guess_u_like_title, this, true);
        this.f165446a = (CategoryView) findViewById(R.id.category_view);
        this.f165447b = (TextView) findViewById(R.id.title);
    }

    public /* synthetic */ AnchorV3GuessULikeTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
