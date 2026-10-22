package com.bytedance.android.ec.store.search.history;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import cn.e;
import cn.f;
import cn.g;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;

/* JADX INFO: loaded from: classes44.dex */
public final class HistoryChip extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f48532e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ColorStateList f48533f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f48534g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f48535h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f48536i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f48537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f48538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f48539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Style f48540d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/store/search/history/HistoryChip$Style;", "", "ICON", CardAdapter.TEXT, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style ICON = null;
        public static final Style TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f48541a = null;

        static {
            Style r100 = new Style("ICON", 0);
            ICON = r100;
            Style r101 = new Style(CardAdapter.TEXT, 1);
            TEXT = r101;
            f48541a = new Style[]{r100, r101};
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f48541a.clone();
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/search/history/HistoryChip$WrapCard;", "Landroidx/cardview/widget/CardView;", "Lcom/bytedance/android/ec/store/search/history/HistoryChip;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/store/search/history/HistoryChip;", "getChip", "()Lcom/bytedance/android/ec/store/search/history/HistoryChip;", "chip", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WrapCard extends CardView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HistoryChip f48542a;

        public final HistoryChip getChip() {
            return this.f48542a;
        }

        public WrapCard(Context r100, HistoryChip r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "chip");
            super(r100);
            this.f48542a = r101;
            if (r102 == false) goto L6;
            post(new com.bytedance.android.ec.store.search.history.a(this));
            return;
        }
    }

    public static final class a {
    }

    static {
        f48532e = vf4.a.b(5);
        f48533f = ColorStateList.valueOf((int) 4279638051L);
        f48534g = vf4.a.b(8);
        f48535h = vf4.a.b(6);
        f48536i = vf4.a.b(12);
    }

    private final int getIconId() {
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L5;
        return R.drawable.shopping_ic_store_v3_expand_more_v2;
    L5:
        return R.drawable.shopping_ic_store_v3_expand_more;
    }

    public final void a() {
        setImageResource(getIconId());
        ImageView r100 = this.f48538b;
        if (r100 == null) goto L6;
        r100.setRotation(180.0f);
        return;
    }

    public final void b() {
        setImageResource(getIconId());
        ImageView r100 = this.f48538b;
        if (r100 == null) goto L6;
        r100.setRotation(0.0f);
        return;
    }

    public final TextView getContentTv() {
        return this.f48537a;
    }

    public final h getHistory() {
        return this.f48539c;
    }

    public final Style getStyle() {
        return this.f48540d;
    }

    public static WrapCard c(HistoryChip r100) {
        return new WrapCard(r100.getContext(), r100, true);
    }

    private final void setImageResource(int r100) {
        ImageView r101 = this.f48538b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ImageView r102 = this.f48538b;
        if (r102 == null) goto L9;
        r102.setImageResource(r100);
        return;
    }

    public final void setHistory(h r100) {
        this.f48539c = r100;
        TextView r101 = this.f48537a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        String r102 = r100.f542282d;
    L7:
        r101.setText(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }

    public final void setImageDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ImageView r101 = this.f48538b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ImageView r102 = this.f48538b;
        if (r102 == null) goto L9;
        r102.setImageDrawable(r100);
        return;
    }

    public HistoryChip(Context r100, Style r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "style");
        super(r100);
        this.f48540d = r101;
        setOrientation(0);
        int r102 = e.f24500a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f48538b = new ImageView(getContext());
        b();
        ImageView r103 = this.f48538b;
        if (r103 == null) goto L26;
        r103.setVisibility(0);
    L26:
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        int r105 = f48532e;
        r104.setMargins(r105, r105, r105, r105);
        post(new f(this, r104));
        return;
    L5:
        if (r102 != 2) goto L29;
        TextView r106 = new TextView(getContext());
        this.f48537a = r106;
        r106.setCompoundDrawablePadding(f48532e);
        TextView r107 = this.f48537a;
        if (r107 == null) goto L10;
        r107.setTextColor(f48533f);
    L10:
        TextView r108 = this.f48537a;
        if (r108 == null) goto L13;
        r108.setMaxLines(1);
    L13:
        TextView r109 = this.f48537a;
        if (r109 == null) goto L16;
        r109.setEllipsize(TextUtils.TruncateAt.END);
    L16:
        TextView r110 = this.f48537a;
        if (r110 == null) goto L19;
        int r111 = f48536i;
        int r112 = f48535h;
        r110.setPadding(r111, r112, r111, r112);
    L19:
        TextView r113 = this.f48537a;
        if (r113 == null) goto L22;
        r113.setTextSize(2, 14.0f);
    L22:
        post(new g(this));
        return;
    }
}
