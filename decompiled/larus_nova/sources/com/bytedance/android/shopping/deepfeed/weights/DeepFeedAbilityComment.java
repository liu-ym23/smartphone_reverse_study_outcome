package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import he3.i1;
import he3.j1;
import he3.p0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAbilityComment;", "Landroid/widget/LinearLayout;", "", "icon", "", SocialConstants.PARAM_APP_DESC, "", "update", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCommentIconRes", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAbilityComment extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f174011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextView f174012b;

    public DeepFeedAbilityComment(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedAbilityComment(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getCommentIconRes() {
        Integer r100 = tc3.f.c();
        if (r100 != null) goto L6;
    L8:
        return R.drawable.shopping_icon_deepfeed_comment;
    L6:
        if (r100.intValue() != 1) goto L8;
        return R.drawable.shopping_deep_feed_ability_comment_new;
    }

    public final void b() {
        update(Integer.valueOf(R.drawable.shopping_icon_deepfeed_comment), "评价");
    }

    private final void update(Integer r100, String r101) {
        if (r100 == null) goto L4;
        int r102 = r100.intValue();
        this.f174011a.setImageResource(r102);
    L4:
        if (r101 == null) goto L7;
        this.f174012b.setText(r101);
        return;
    }

    public final void a(p0 r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "product");
        j1 r100 = r110.f();
        if (r100 == null) goto L7;
        Long r101 = r100.b();
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        i1 r112 = r110.e();
        if (r112 == null) goto L13;
        Long r113 = r112.a();
        if (r113 == null) goto L13;
        long r103 = r113.longValue();
    L15:
        if (tc3.f.e() == true) goto L24;
        if (r111 == true) goto L24;
        long r104 = 10000;
        if (r102 >= r104) goto L20;
    L22:
        this.f174012b.setTextSize(1, 10.0f);
        goto L24
    L20:
        if (r103 < r104) goto L22;
        this.f174012b.setTextSize(1, 9.0f);
    L24:
        if (tc3.f.a() == false) goto L27;
        ViewGroup.LayoutParams r114 = this.f174011a.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r105 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r114.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 24);
        r114.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(getContext(), 24);
        this.f174011a.setLayoutParams(r114);
    L27:
        String r115 = "评价";
        if (r111 == true) goto L30;
        update(Integer.valueOf(getCommentIconRes()), com.bytedance.android.shopping.deepfeed.utlis.j.a(r102) + "评价");
        return;
    L30:
        if (r102 <= 0) goto L33;
        r115 = com.bytedance.android.shopping.deepfeed.utlis.j.a(r102);
    L33:
        update(Integer.valueOf(getCommentIconRes()), r115);
        return;
    L13:
        r103 = 0;
    L7:
        r102 = 0;
        goto L8
    }

    public DeepFeedAbilityComment(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(1);
        setGravity(1);
        LinearLayout.inflate(r100, R.layout.shopping_deep_feed_ability_simple_button, this);
        this.f174011a = (ImageView) findViewById(R.id.iv_icon);
        this.f174012b = (ProductTextView) findViewById(R.id.tv_desc);
    }

    public /* synthetic */ DeepFeedAbilityComment(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
