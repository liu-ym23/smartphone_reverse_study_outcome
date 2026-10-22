package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/SearchCardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f175603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SearchPictureCardView f175604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchPictureCardView f175605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SearchPictureCardView f175606d;

    public SearchCardView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SearchCardView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public SearchCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_recommend_feed_search_card, this, true);
        this.f175603a = (ViewGroup) findViewById(R.id.card_container);
        this.f175604b = (SearchPictureCardView) findViewById(R.id.image_view_1);
        this.f175605c = (SearchPictureCardView) findViewById(R.id.image_view_2);
        this.f175606d = (SearchPictureCardView) findViewById(R.id.image_view_3);
    }

    public /* synthetic */ SearchCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
