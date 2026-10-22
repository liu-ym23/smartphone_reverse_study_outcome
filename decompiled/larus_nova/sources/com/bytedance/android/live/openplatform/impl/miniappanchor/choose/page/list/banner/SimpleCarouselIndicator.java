package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0013¢\u0006\u0004\b8\u00109J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R*\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010.\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R*\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\r¨\u0006;"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/SimpleCarouselIndicator;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/SimpleCarouselViewPager;", "viewPager", "", "setViewPager", "", "value", "b", FaceService.girlLabel, "getDotsSize", "()F", "setDotsSize", "(F)V", "dotsSize", "c", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "", "d", "I", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsColor", "e", "getSelectedDotColor", "setSelectedDotColor", "selectedDotColor", "f", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "", ce.f26391f, "Z", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "dotsClickable", "h", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", RXScreenCaptureService.KEY_INDEX, "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleCarouselIndicator extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f84205k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f84206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f84207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f84208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f84209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f84210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f84211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f84212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f84213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f84214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f84215j;

    public interface a {
        void a(int r100);

        int getCount();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselIndicator f84216a;

        public b(SimpleCarouselIndicator r100) {
            this.f84216a = r100;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1, java.lang.Object] */
        public final void a() {
            d r100 = this.f84216a.f84215j;
            if (r100 != null) goto L5;
        L7:
            SimpleCarouselIndicator r101 = this.f84216a;
            d r102 = r101.f84215j;
            if (r102 != null) goto L11;
        L18:
            this.f84216a.c();
            this.f84216a.d();
            final d r103 = this.f84216a.f84215j;
            if (r103 != null) goto L22;
            return;
        L22:
            if (r103.getCount() <= 0) goto L31;
            SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1 r104 = r103.f84218a;
            if (r104 == null) goto L28;
            SimpleCarouselViewPager r105 = r103.f84220c;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r104, "listener");
            SimpleCarouselViewPager.a r106 = (SimpleCarouselViewPager.a) ((LinkedHashMap) r105.f84228f).get(r104);
            if (r106 == null) goto L28;
            r105.f84227e.removeOnPageChangeListener(r106);
            SimpleCarouselViewPager.a r107 = r105.f84228f.remove(r104);
        L28:
            ?? r108 = new SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1(r103);
            r103.f84218a = r108;
            SimpleCarouselViewPager r109 = r103.f84220c;
            r109.getClass();
            Intrinsics.checkNotNullParameter(r108, "listener");
            SimpleCarouselViewPager.a r110 = new SimpleCarouselViewPager.a(r109, r108);
            r109.f84227e.addOnPageChangeListener(r110);
            r109.f84228f.put((ViewPager.OnPageChangeListener) r108, r110);
            return;
        L31:
            return;
        L11:
            if (r101.f84206a.size() >= r102.getCount()) goto L14;
            r101.a(r102.getCount() - r101.f84206a.size());
            goto L18
        L14:
            if (r101.f84206a.size() <= r102.getCount()) goto L18;
            int r111 = r101.f84206a.size() - r102.getCount();
            int r112 = 0;
        L16:
            if (r112 >= r111) goto L18;
            r101.removeViewAt(r101.getChildCount() - 1);
            ArrayList<View> r113 = r101.f84206a;
            ListProtector.remove(r113, r113.size() - 1);
            r112 = r112 + 1;
            goto L16
        L5:
            if (r100.getCount() != 1) goto L7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselIndicator f84217a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f84217a.b();
        }

        public c(SimpleCarouselIndicator r100) {
            this.f84217a = r100;
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1 f84218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselIndicator f84219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselViewPager f84220c;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator.a
        public final int getCount() {
            return this.f84220c.getCount();
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner.SimpleCarouselIndicator.a
        public final void a(int r100) {
            SimpleCarouselViewPager r101 = this.f84220c;
            int r102 = r101.getCount();
            if (r100 < 0) goto L7;
            if (r102 <= r100) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == false) goto L12;
            int r104 = r101.f84227e.getCurrentItem();
            int r105 = r101.getCurrentItem();
            r101.f84227e.setCurrentItem(r104 + (r100 - r105), true);
            return;
        L12:
            return;
        L7:
            r103 = false;
            goto L8
        }

        public d(SimpleCarouselIndicator r100, SimpleCarouselViewPager r101) {
            this.f84219b = r100;
            this.f84220c = r101;
        }
    }

    public SimpleCarouselIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimpleCarouselIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        if (this.f84215j != null) goto L5;
        return;
    L5:
        post(new b(this));
    }

    public final void c() {
        int r100 = this.f84206a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L22;
        View r102 = (View) ListProtector.get(this.f84206a, r101);
        Drawable r103 = r102.getBackground();
        if ((r103 instanceof GradientDrawable) == true) goto L7;
        r103 = null;
    L7:
        GradientDrawable r104 = (GradientDrawable) r103;
        if (r104 == null) goto L15;
        d r105 = this.f84215j;
        if (r105 != null) goto L12;
    L14:
        r104.setColor(this.f84209d);
        goto L15
    L12:
        if (r101 != r105.f84220c.getCurrentItem()) goto L14;
        r104.setColor(this.f84210e);
    L15:
        if (r104 == null) goto L17;
        r104.setCornerRadius(this.f84211f);
    L17:
        float r106 = this.f84214i;
        if (r106 <= 0) goto L21;
        if (r104 == null) goto L21;
        r104.setStroke((int) r106, this.f84213h);
    L21:
        r102.setBackground(r104);
        r102.invalidate();
        r101 = r101 + 1;
        goto L3
    }

    public final void d() {
        d r100 = this.f84215j;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.f84220c.getCurrentItem();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        View r103 = (View) ListProtector.get(this.f84206a, r102);
        int r104 = (int) this.f84207b;
        Intrinsics.checkNotNullParameter(r103, "$this$setWidth");
        r103.getLayoutParams().width = r104;
        r103.requestLayout();
        r102 = r102 + 1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    public final boolean getDotsClickable() {
        return this.f84212g;
    }

    public final int getDotsColor() {
        return this.f84209d;
    }

    public final float getDotsCornerRadius() {
        return this.f84211f;
    }

    public final float getDotsSize() {
        return this.f84207b;
    }

    public final float getDotsSpacing() {
        return this.f84208c;
    }

    public final int getDotsStrokeColor() {
        return this.f84213h;
    }

    public final float getDotsStrokeWidth() {
        return this.f84214i;
    }

    public final int getSelectedDotColor() {
        return this.f84210e;
    }

    public final void a(int r100) {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L23;
        d r102 = this.f84215j;
        if (r102 == null) goto L22;
        ImageView r103 = new ImageView(getContext());
        int r104 = (int) this.f84207b;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(r104, r104);
        int r106 = (int) this.f84208c;
        r105.setMargins(r106, 0, r106, 0);
        Unit r107 = Unit.INSTANCE;
        r103.setLayoutParams(r105);
        GradientDrawable r108 = new GradientDrawable();
        r108.setCornerRadius(this.f84211f);
        if (isInEditMode() == false) goto L14;
        if (r101 != 0) goto L11;
        int r109 = this.f84210e;
    L12:
        r108.setColor(r109);
    L18:
        float r110 = this.f84214i;
        if (r110 <= 0) goto L21;
        r108.setStroke((int) r110, this.f84213h);
    L21:
        r103.setBackground(r108);
        r103.setOnClickListener(new hp0.a(this, r101, r102));
        this.f84206a.add(r103);
        addView(r103);
        goto L22
    L11:
        r109 = this.f84209d;
        goto L12
    L14:
        if (r101 != r102.f84220c.getCurrentItem()) goto L16;
        int r111 = this.f84210e;
    L17:
        r108.setColor(r111);
        goto L18
    L16:
        r111 = this.f84209d;
    L22:
        r101 = r101 + 1;
        goto L3
    }

    public final void setDotsClickable(boolean r100) {
        this.f84212g = r100;
    }

    public final void setDotsColor(int r100) {
        if (this.f84209d == r100) goto L6;
        this.f84209d = r100;
        c();
        return;
    }

    public final void setDotsCornerRadius(float r100) {
        if (this.f84211f == r100) goto L6;
        this.f84211f = r100;
        c();
        return;
    }

    public final void setDotsSize(float r100) {
        if (this.f84207b == r100) goto L6;
        this.f84207b = r100;
        d();
        return;
    }

    public final void setDotsSpacing(float r100) {
        if (this.f84208c == r100) goto L16;
        this.f84208c = r100;
        d r101 = this.f84215j;
        if (r101 == null) goto L20;
        int r102 = r101.f84220c.getCurrentItem();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L21;
        View r104 = (View) ListProtector.get(this.f84206a, r103);
        int r105 = (int) this.f84208c;
        Intrinsics.checkNotNullParameter(r104, "$this$setHorizontalMargin");
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        if ((r106 instanceof FrameLayout.LayoutParams) == true) goto L12;
        r106 = null;
    L12:
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        if (r107 == null) goto L15;
        r107.leftMargin = r105;
        r107.rightMargin = r105;
        r104.requestLayout();
    L15:
        r103 = r103 + 1;
        goto L8
    L21:
        return;
    L20:
        return;
    }

    public final void setDotsStrokeColor(int r100) {
        if (this.f84213h == r100) goto L6;
        this.f84213h = r100;
        c();
        return;
    }

    public final void setDotsStrokeWidth(float r100) {
        if (this.f84214i == r100) goto L6;
        this.f84214i = r100;
        c();
        return;
    }

    public final void setSelectedDotColor(int r100) {
        if (this.f84210e == r100) goto L6;
        this.f84210e = r100;
        c();
        return;
    }

    public final void setViewPager(SimpleCarouselViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        PagerAdapter r101 = r100.getAdapter();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.registerDataSetObserver(new c(this));
        this.f84215j = new d(this, r100);
        b();
    }

    public SimpleCarouselIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f84206a = new ArrayList();
        this.f84207b = UtilityKotlinExtentionsKt.h(6);
        this.f84208c = UtilityKotlinExtentionsKt.h(3);
        this.f84209d = ColorProtector.parseColor("#56FFFFFF");
        this.f84210e = ColorProtector.parseColor("#BFFFFFFF");
        this.f84211f = this.f84207b / 2;
        this.f84212g = true;
        this.f84213h = ColorProtector.parseColor("#0F161823");
        this.f84214i = UtilityKotlinExtentionsKt.h(0.5f);
        setOrientation(0);
        if (isInEditMode() == false) goto L6;
        a(5);
        b();
        return;
    }

    public /* synthetic */ SimpleCarouselIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
