package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECScrollTagListView;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getHasShopNameScrollEnd", "()Z", "setHasShopNameScrollEnd", "(Z)V", "hasShopNameScrollEnd", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollTagListView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f48723h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECTagListView f48726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECAutoScrollHorizontalScrollView f48727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f48728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f48729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f48730g;

    public static final class a implements View.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECScrollTagListView f48731a;

        public a(ECScrollTagListView r100) {
            this.f48731a = r100;
        }

        @Override // android.view.View.OnScrollChangeListener
        public final void onScrollChange(View r100, int r101, int r102, int r103, int r104) {
            ECTagListView r105 = this.f48731a.f48726c;
            if (r105 == null) goto L15;
            List<View> r106 = com.bytedance.commerce.base.view.b.a(r105);
            if (r106 == null) goto L21;
            Iterator<T> r107 = r106.iterator();
        L8:
            if (r107.hasNext() == false) goto L22;
            View r108 = (View) r107.next();
            if ((r108 instanceof ECTagView) == true) goto L12;
            r108 = null;
        L12:
            ECTagView r109 = (ECTagView) r108;
            if (r109 == null) goto L8;
            r109.f();
            goto L8
        L22:
            return;
        L21:
            return;
        }
    }

    public ECScrollTagListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECScrollTagListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (getVisibility() == 0) goto L6;
        return;
    L6:
        if (this.f48725b == true) goto L8;
        return;
    L8:
        if (this.f48724a == false) goto L23;
        ECAutoScrollHorizontalScrollView r100 = this.f48727d;
        if (r100 != null) goto L12;
        return;
    L12:
        if (r100.f48704b == true) goto L25;
        int r101 = r100.f48703a.getCurrX();
        Intrinsics.checkNotNullParameter(r100, "$this$getMaxScrollRange");
        int r102 = 0;
        if (r100.getChildCount() <= 0) goto L17;
        r102 = Math.max(0, r100.getChildAt(0).getWidth() - ((r100.getWidth() - r100.getPaddingLeft()) - r100.getPaddingRight()));
    L17:
        int r103 = r102 - r101;
        if (r103 <= 0) goto L26;
        int r104 = (r103 * 1000) / r100.f48706d;
        r100.f48703a.startScroll(r101, 0, r103, 0, r104);
        r100.invalidate();
        return;
    L26:
        return;
    L25:
        return;
    }

    public final boolean getHasShopNameScrollEnd() {
        return this.f48724a;
    }

    public final void setHasShopNameScrollEnd(boolean r100) {
        this.f48724a = r100;
    }

    public ECScrollTagListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48728e = 2000;
        this.f48729f = new Handler(Looper.getMainLooper());
        this.f48730g = new a(this);
    }

    public /* synthetic */ ECScrollTagListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
