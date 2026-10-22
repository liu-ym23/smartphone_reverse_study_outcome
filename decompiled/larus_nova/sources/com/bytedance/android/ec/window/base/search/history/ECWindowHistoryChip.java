package com.bytedance.android.ec.window.base.search.history;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import hp.b;
import hp.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECWindowHistoryChip extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f49524d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ColorStateList f49525e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f49526f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f49527g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f49528h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f49529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f49530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cp.a f49531c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryChip$Style;", "", "ICON", CardAdapter.TEXT, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        public static final Style ICON = null;
        public static final Style TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f49532a = null;

        static {
            Style r100 = new Style("ICON", 0);
            ICON = r100;
            Style r101 = new Style(CardAdapter.TEXT, 1);
            TEXT = r101;
            f49532a = new Style[]{r100, r101};
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) f49532a.clone();
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryChip$WrapCard;", "Landroidx/cardview/widget/CardView;", "Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryChip;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryChip;", "getChip", "()Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryChip;", "chip", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WrapCard extends CardView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECWindowHistoryChip f49533a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WrapCard f49534a;

            public a(WrapCard r100) {
                this.f49534a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-2, -1);     // Catch: Throwable -> L4
                r100.gravity = 17;     // Catch: Throwable -> L4
                WrapCard r101 = this.f49534a;     // Catch: Throwable -> L4
                r101.addView(r101.getChip(), r100);     // Catch: Throwable -> L4
                this.f49534a.setRadius(ECWindowHistoryChip.f49526f);     // Catch: Throwable -> L4
                this.f49534a.setCardElevation(0.0f);     // Catch: Throwable -> L4
                this.f49534a.setCardBackgroundColor(-789516);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final ECWindowHistoryChip getChip() {
            return this.f49533a;
        }

        public WrapCard(Context r100, ECWindowHistoryChip r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "chip");
            super(r100);
            this.f49533a = r101;
            post(new a(this));
        }
    }

    public static final class a {
    }

    static {
        f49524d = vf4.a.b(5);
        f49525e = ColorStateList.valueOf((int) 4279638051L);
        f49526f = vf4.a.b(8);
        f49527g = vf4.a.b(6);
        f49528h = vf4.a.b(12);
    }

    public final void a() {
        setImageResource(R.drawable.shopping_ic_store_v3_expand_less);
    }

    public final void b() {
        setImageResource(R.drawable.shopping_ic_store_v3_expand_more);
    }

    public final cp.a getHistory() {
        return this.f49531c;
    }

    private final void setImageResource(int r100) {
        ImageView r101 = this.f49530b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ImageView r102 = this.f49530b;
        if (r102 == null) goto L9;
        r102.setImageResource(r100);
        return;
    }

    public final void setHistory(cp.a r100) {
        this.f49531c = r100;
        TextView r101 = this.f49529a;
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        String r102 = r100.f464594d;
    L7:
        r101.setText(r102);
        return;
    L6:
        r102 = null;
        goto L7
    }

    public final void setImageDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ImageView r101 = this.f49530b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ImageView r102 = this.f49530b;
        if (r102 == null) goto L9;
        r102.setImageDrawable(r100);
        return;
    }

    public ECWindowHistoryChip(Context r100, Style r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "style");
        super(r100);
        setOrientation(0);
        int r102 = hp.a.f486350a[r101.ordinal()];
        if (r102 != 1) goto L5;
        ImageView r103 = new ImageView(getContext());
        this.f49530b = r103;
        r103.setImageResource(R.drawable.shopping_ic_store_v3_expand_more);
        ImageView r104 = this.f49530b;
        if (r104 == null) goto L26;
        r104.setVisibility(0);
    L26:
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        int r106 = f49524d;
        r105.setMargins(r106, r106, r106, r106);
        post(new b(this, r105));
        return;
    L5:
        if (r102 != 2) goto L29;
        TextView r107 = new TextView(getContext());
        this.f49529a = r107;
        r107.setCompoundDrawablePadding(f49524d);
        TextView r108 = this.f49529a;
        if (r108 == null) goto L10;
        r108.setTextColor(f49525e);
    L10:
        TextView r109 = this.f49529a;
        if (r109 == null) goto L13;
        r109.setMaxLines(1);
    L13:
        TextView r110 = this.f49529a;
        if (r110 == null) goto L16;
        r110.setEllipsize(TextUtils.TruncateAt.END);
    L16:
        TextView r111 = this.f49529a;
        if (r111 == null) goto L19;
        int r112 = f49528h;
        int r113 = f49527g;
        r111.setPadding(r112, r113, r112, r113);
    L19:
        TextView r114 = this.f49529a;
        if (r114 == null) goto L22;
        r114.setTextSize(2, 14.0f);
    L22:
        post(new c(this));
        return;
    }
}
