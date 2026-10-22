package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J-\u0010\f\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H\u0016J+\u0010\r\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012R+\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0015j\b\u0012\u0004\u0012\u00020\u0003`\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR+\u0010#\u001a\u0012\u0012\u0004\u0012\u00020 0\u0015j\b\u0012\u0004\u0012\u00020 `\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR+\u0010'\u001a\u0012\u0012\u0004\u0012\u00020$0\u0015j\b\u0012\u0004\u0012\u00020$`\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001bR\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006="}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoImageSquareViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/j;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "getVideoHolder", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "listener", "setOnScrollBeginListener", "setItemClickListener", "getCurrentImagePosition", "getCurrentVideoPosition", "getCurrentItemPosition", "setCurrentSelected", "Ll53/b;", "collisionNegotiator", "setCollisionNegotiator", "Ljava/util/ArrayList;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/transwidget/b;", "Lkotlin/collections/ArrayList;", "e", "Lkotlin/Lazy;", "getMImageHolders", "()Ljava/util/ArrayList;", "mImageHolders", "f", "getMVideoHolders", "mVideoHolders", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/h;", ce.f26391f, "getMOnPageChangedListeners", "mOnPageChangedListeners", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/i;", "h", "getMOnPageDataSetChangedListeners", "mOnPageDataSetChangedListeners", "", ce.f26396k, "Z", "getV4Head", "()Z", "setV4Head", "(Z)V", "v4Head", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/k;", "onVideoImageIndicatorChangedListener", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/k;", "getOnVideoImageIndicatorChangedListener", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/k;", "setOnVideoImageIndicatorChangedListener", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/k;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoImageSquareViewPager extends ViewPager implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f164891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f164892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f164893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f164894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f164895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f164896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f164897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f164898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f164899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f164900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f164901k;

    private final ArrayList<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.b> getMImageHolders() {
        return (ArrayList) this.f164895e.getValue();
    }

    private final ArrayList<h> getMOnPageChangedListeners() {
        return (ArrayList) this.f164897g.getValue();
    }

    private final ArrayList<i> getMOnPageDataSetChangedListeners() {
        return (ArrayList) this.f164898h.getValue();
    }

    private final ArrayList<VideoHolder> getMVideoHolders() {
        return (ArrayList) this.f164896f.getValue();
    }

    public final k getOnVideoImageIndicatorChangedListener() {
        return null;
    }

    public final void setCollisionNegotiator(l53.b r100) {
        Intrinsics.checkNotNullParameter(r100, "collisionNegotiator");
    }

    public final void setOnVideoImageIndicatorChangedListener(k r100) {
    }

    public int getCurrentItemPosition() {
        return getCurrentItem();
    }

    public VideoHolder getVideoHolder() {
        if ((!getMVideoHolders().isEmpty()) == true) goto L7;
        return null;
    L7:
        return (VideoHolder) ListProtector.get(getMVideoHolders(), 0);
    }

    public int getCurrentImagePosition() {
        return this.f164899i;
    }

    public int getCurrentVideoPosition() {
        return this.f164900j;
    }

    public final boolean getV4Head() {
        return this.f164901k;
    }

    public VideoImageSquareViewPager(Context r100) {
        this(r100, null);
    }

    public final void i(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getMOnPageChangedListeners().add(r100);
    }

    public final void j(i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getMOnPageDataSetChangedListeners().add(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f164892b = r100.getX();
        this.f164893c = r100.getY();
    L16:
        if (this.f164894d == false) goto L19;
        super.onTouchEvent(r100);
        return this.f164894d;
    L19:
        return super.onTouchEvent(r100);
    L5:
        if (r101 != 2) goto L16;
        if (Math.abs(r100.getY() - this.f164893c) > Math.abs(r100.getX() - this.f164892b)) goto L12;
        ViewParent r102 = getParent();
        boolean r103 = true;
        if (r102 == null) goto L13;
        r102.requestDisallowInterceptTouchEvent(true);
    L13:
        this.f164894d = r103;
        goto L16
    L12:
        r103 = false;
        goto L13
    }

    public void setCurrentSelected(int r100) {
        setCurrentItem(r100);
    }

    public void setItemClickListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f164891a = r100;
    }

    public void setOnScrollBeginListener(final Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        addOnPageChangeListener(new AnonymousClass1(r100));
    }

    public final void setV4Head(boolean r100) {
        this.f164901k = r100;
    }

    public VideoImageSquareViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f164895e = LazyKt.lazy(VideoImageSquareViewPager$mImageHolders$2.INSTANCE);
        this.f164896f = LazyKt.lazy(VideoImageSquareViewPager$mVideoHolders$2.INSTANCE);
        this.f164897g = LazyKt.lazy(VideoImageSquareViewPager$mOnPageChangedListeners$2.INSTANCE);
        this.f164898h = LazyKt.lazy(VideoImageSquareViewPager$mOnPageDataSetChangedListeners$2.INSTANCE);
        this.f164899i = -2;
        this.f164900j = -2;
        addOnPageChangeListener(new VideoImageSquareViewPager$innerOnPageChangeListener$1(this));
    }

    public static final void h(VideoImageSquareViewPager r100, int r101) {
        Iterator<h> r102 = r100.getMOnPageChangedListeners().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r101);
        goto L4
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r100);
    }
}
