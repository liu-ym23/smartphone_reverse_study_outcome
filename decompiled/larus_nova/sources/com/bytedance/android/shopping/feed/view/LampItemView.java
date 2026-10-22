package com.bytedance.android.shopping.feed.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.RoundedLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/LampItemView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "getBuyAndCommentContainer", "()Lcom/bytedance/android/ec/core/widget/RoundedLinearLayout;", "buyAndCommentContainer", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "b", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getUserAvatarImage", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "userAvatarImage", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getUserNameArea", "()Landroid/widget/TextView;", "userNameArea", "d", "getBuyOrCommentArea", "buyOrCommentArea", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LampItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundedLinearLayout f175598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f175599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f175600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f175601d;

    public LampItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LampItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final RoundedLinearLayout getBuyAndCommentContainer() {
        return this.f175598a;
    }

    public final TextView getBuyOrCommentArea() {
        return this.f175601d;
    }

    public final ECDraweeView getUserAvatarImage() {
        return this.f175599b;
    }

    public final TextView getUserNameArea() {
        return this.f175600c;
    }

    public LampItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.shopping_product_feed_lamp_item_view, this, true);
    L6:
        RoundedLinearLayout r104 = (RoundedLinearLayout) findViewById(R.id.buy_and_comment_container);
        this.f175598a = r104;
        ECDraweeView r105 = (ECDraweeView) findViewById(R.id.user_avatar_image);
        this.f175599b = r105;
        TextView r106 = (TextView) findViewById(R.id.user_name_area);
        this.f175600c = r106;
        TextView r107 = (TextView) findViewById(R.id.buy_or_comment_info);
        this.f175601d = r107;
        ViewGroup.LayoutParams r108 = r105.getLayoutParams();
        if (r108 == null) goto L11;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r109.width = com.bytedance.android.shopping.extensions.b.b(22);
        r109.height = com.bytedance.android.shopping.extensions.b.b(22);
        r109.setMargins(com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(2));
        wg.a.g(r106, 13);
        wg.a.g(r107, 13);
        r104.setRadius(com.bytedance.android.shopping.extensions.b.b(24));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_product_feed_lamp_item_view, this, true);
        goto L6
    }

    public /* synthetic */ LampItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
