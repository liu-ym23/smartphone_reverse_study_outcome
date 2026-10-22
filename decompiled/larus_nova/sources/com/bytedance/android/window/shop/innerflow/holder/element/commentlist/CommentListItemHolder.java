package com.bytedance.android.window.shop.innerflow.holder.element.commentlist;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.utils.k0;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import wp3.b;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/commentlist/CommentListItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListItemHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f189061e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f189062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f189063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f189064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f189065d;

    public CommentListItemHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f189062a = (SimpleDraweeView) r100.findViewById(R.id.ec_shop_comment_item_avatar);
        this.f189063b = (TextView) r100.findViewById(R.id.ec_shop_comment_item_msg);
        this.f189064c = r100.getContext().getString(R.string.ec_shop_inner_flow_comment_wrapper_left);
        this.f189065d = r100.getContext().getString(R.string.ec_shop_inner_flow_comment_wrapper_right);
    }

    public final void T3(b.C8144b r110) {
        int r100 = k0.f187151a;
        TextView r101 = this.f189063b;
        if (r110 == null) goto L5;
        String r111 = r110.f560574b;
    L6:
        String r102 = "";
        if (r111 != null) goto L9;
        String r103 = "";
    L10:
        float r112 = RangesKt.coerceAtLeast(r101.getWidth() - com.bytedance.android.shopping.extensions.b.b(6), 0.0f);
        String r104 = this.f189064c;
        String r113 = this.f189065d;
        Intrinsics.checkNotNullParameter(r101, "textView");
        if (a2.d(r103) == null) goto L71;
        if (r104 == null) goto L17;
        String r105 = a2.d(r104);
        if (r105 == null) goto L17;
        float r114 = r101.getPaint().measureText(r105);
    L18:
        if (r113 != null) goto L20;
    L22:
        float r115 = 0.0f;
    L23:
        Iterator r106 = StringsKt.split$default(r103, new String[]{"\n"}, false, 0, 6, null).iterator();
    L25:
        if (r106.hasNext() == false) goto L29;
        Object r107 = r106.next();
        if ((!StringsKt.isBlank((String) r107)) == false) goto L25;
    L30:
        String r108 = (String) r107;
        if (r108 != null) goto L34;
        r108 = "";
    L34:
        if (r101.getPaint().measureText(r108) > ((r112 - r114) - r115)) goto L43;
        StringBuilder r116 = new StringBuilder();
        if (r104 != null) goto L38;
        r104 = "";
    L38:
        r116.append(r104);
        r116.append(r108);
        if (r113 == null) goto L42;
        r102 = r113;
    L42:
        r116.append(r102);
        r101.setText(r116.toString());
        return;
    L43:
        int r109 = g1.f45599a;
        String r117 = g1.a.c(r101.getContext(), R.string.commerce_anchor_v3_ellipse, new Object[]{""});
        float r118 = (r114 + r101.getPaint().measureText(r117)) + r115;
    L45:
        if (a2.b(r108) == false) goto L51;
        if (r101.getPaint().measureText(r108) <= (r112 - r118)) goto L51;
        if (r108 != null) goto L49;
        r108 = null;
        goto L45
    L49:
        r108 = r108.substring(0, r108.length() - 1);
    L51:
        StringBuilder r119 = new StringBuilder();
        if (r104 != null) goto L54;
        r104 = "";
    L54:
        r119.append(r104);
        r119.append(r108);
        r119.append(r117);
        if (r113 == null) goto L58;
        r102 = r113;
    L58:
        r119.append(r102);
        r101.setText(r119.toString());
        return;
    L29:
        r107 = null;
        goto L30
    L20:
        if (a2.d(r113) == null) goto L22;
        r115 = r101.getPaint().measureText(r113);
    L17:
        r114 = 0.0f;
        goto L18
    L71:
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r111 = null;
        goto L6
    }
}
