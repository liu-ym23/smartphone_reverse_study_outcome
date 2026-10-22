package com.bytedance.android.livesdk.interactivity.api.highlight.indicator;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0013¢\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010*\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R*\u0010.\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\rR$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "", "setViewPager", "", "value", "b", FaceService.girlLabel, "getDotsSize", "()F", "setDotsSize", "(F)V", "dotsSize", "c", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", "", "d", "I", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsColor", "e", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "", "f", "Z", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "dotsClickable", ce.f26391f, "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "h", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;", "getPager", "()Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;", "setPager", "(Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;)V", "pager", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DuxBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<View> f133225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f133226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f133227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f133228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f133229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f133230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f133231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f133232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f133233i;

    public interface a {
        void a(int r100);

        boolean b();

        void c();

        void d(q32.c r100);

        int getCount();

        int getCurrentItem();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBaseIndicator f133234a;

        public b(DuxBaseIndicator r100) {
            this.f133234a = r100;
        }

        public final void a() {
            DuxBaseIndicator r100 = this.f133234a;
            a r101 = r100.f133233i;
            if (r101 == null) goto L15;
            int r102 = 0;
            if (r100.f133225a.size() >= r101.getCount()) goto L11;
            int r103 = r101.getCount() - r100.f133225a.size();
        L8:
            if (r102 >= r103) goto L15;
            r100.a(r102);
            r102 = r102 + 1;
            goto L8
        L11:
            if (r100.f133225a.size() <= r101.getCount()) goto L15;
            int r104 = r100.f133225a.size() - r101.getCount();
        L13:
            if (r102 >= r104) goto L15;
            r100.g();
            r102 = r102 + 1;
        L15:
            this.f133234a.e();
            this.f133234a.f();
            DuxBaseIndicator r105 = this.f133234a;
            a r106 = r105.f133233i;
            if (r106 != null) goto L19;
            return;
        L19:
            if (r106.b() == false) goto L24;
            r106.c();
            q32.b r107 = r105.b();
            r106.d(r107);
            r107.b(r106.getCurrentItem(), 0.0f);
            return;
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
        public final /* synthetic */ DuxBaseIndicator f133235a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            super.onChanged();
            this.f133235a.d();
        }

        public c(DuxBaseIndicator r100) {
            this.f133235a = r100;
        }
    }

    public DuxBaseIndicator(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxBaseIndicator(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a(int r100);

    public abstract q32.b b();

    public abstract void c(int r100);

    public abstract void g();

    public final void d() {
        if (this.f133233i != null) goto L5;
        return;
    L5:
        post(new b(this));
    }

    public final void e() {
        int r100 = this.f133225a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        c(r101);
        r101 = r101 + 1;
        goto L3
    }

    public final void f() {
        a r100 = this.f133233i;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getCurrentItem();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        q32.a.a((View) ListProtector.get(this.f133225a, r102), (int) this.f133226b);
        r102 = r102 + 1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public final boolean getDotsClickable() {
        return this.f133230f;
    }

    public final int getDotsColor() {
        return this.f133228d;
    }

    public final float getDotsCornerRadius() {
        return this.f133229e;
    }

    public final float getDotsSize() {
        return this.f133226b;
    }

    public final float getDotsSpacing() {
        return this.f133227c;
    }

    public final int getDotsStrokeColor() {
        return this.f133231g;
    }

    public final float getDotsStrokeWidth() {
        return this.f133232h;
    }

    public final a getPager() {
        return this.f133233i;
    }

    public final void setDotsClickable(boolean r100) {
        this.f133230f = r100;
    }

    public final void setDotsColor(int r100) {
        if (this.f133228d == r100) goto L6;
        this.f133228d = r100;
        e();
        return;
    }

    public final void setDotsCornerRadius(float r100) {
        if (this.f133229e == r100) goto L6;
        this.f133229e = r100;
        e();
        return;
    }

    public final void setDotsSize(float r100) {
        if (this.f133226b == r100) goto L6;
        this.f133226b = r100;
        f();
        return;
    }

    public final void setDotsSpacing(float r100) {
        if (this.f133227c == r100) goto L16;
        this.f133227c = r100;
        a r101 = this.f133233i;
        if (r101 == null) goto L20;
        int r102 = r101.getCurrentItem();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L21;
        View r104 = (View) ListProtector.get(this.f133225a, r103);
        int r105 = (int) this.f133227c;
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
        if (this.f133231g == r100) goto L6;
        this.f133231g = r100;
        e();
        return;
    }

    public final void setDotsStrokeWidth(float r100) {
        if (this.f133232h == r100) goto L6;
        this.f133232h = r100;
        e();
        return;
    }

    public final void setPager(a r100) {
        this.f133233i = r100;
    }

    public final void setViewPager(final ViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        PagerAdapter r101 = r100.getAdapter();
        if (r101 != null) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L6:
        r101.registerDataSetObserver(new c(this));
        this.f133233i = new AnonymousClass2(r100);
        d();
    }

    public DuxBaseIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f133225a = new ArrayList();
        this.f133226b = UtilityKotlinExtentionsKt.h(4);
        float r103 = 2;
        this.f133227c = UtilityKotlinExtentionsKt.h(r103);
        this.f133228d = ColorProtector.parseColor("#80FFFFFF");
        this.f133229e = this.f133226b / r103;
        this.f133230f = true;
        this.f133231g = ColorProtector.parseColor("#0F161823");
        this.f133232h = UtilityKotlinExtentionsKt.h(0.5f);
    }

    public /* synthetic */ DuxBaseIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
