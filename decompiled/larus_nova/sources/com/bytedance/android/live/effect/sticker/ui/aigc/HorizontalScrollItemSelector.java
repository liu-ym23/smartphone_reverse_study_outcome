package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/HorizontalScrollItemSelector;", "Landroid/widget/HorizontalScrollView;", "", "", "list", "", "setKeywordList", "getCurrentSelectKeyword", "", "getCurrentSelectItemIndex", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/c;", "listener", "setItemSelectListener", "Landroid/widget/LinearLayout$LayoutParams;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getContainerLinearLayoutLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "containerLinearLayoutLayoutParams", "Landroid/widget/LinearLayout;", "b", "getContainerLinearLayout", "()Landroid/widget/LinearLayout;", "containerLinearLayout", "f", "getFirstItemLeftMargin", "()I", "firstItemLeftMargin", ce.f26391f, "getNormalItemLeftMargin", "normalItemLeftMargin", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalScrollItemSelector extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f68530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f68531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f68532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f68533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f68534g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AigcKeywordItemView f68535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollItemSelector f68536b;

        public a(AigcKeywordItemView r100, HorizontalScrollItemSelector r101) {
            this.f68535a = r100;
            this.f68536b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HorizontalScrollItemSelector r101 = this.f68536b;
            int r102 = r101.f68531d;
            if (r102 >= 0) goto L5;
        L17:
            HorizontalScrollItemSelector r103 = this.f68536b;
            AigcKeywordItemView r104 = this.f68535a;
            r103.getClass();
            r104.setSelectStatus(true);
            r103.f68531d = r104.getPosition();
            c r105 = r103.f68532e;
            if (r105 == null) goto L24;
            r105.a();
            return;
        L24:
            return;
        L5:
            if (r102 >= ((ArrayList) r101.f68530c).size()) goto L17;
            if (this.f68536b.f68531d == this.f68535a.getPosition()) goto L21;
            View r106 = HorizontalScrollItemSelector.a(this.f68536b).getChildAt(this.f68536b.f68531d);
            if ((r106 instanceof AigcKeywordItemView) == true) goto L11;
            r106 = null;
        L11:
            AigcKeywordItemView r107 = (AigcKeywordItemView) r106;
            if (r107 == null) goto L14;
            r107.setSelectStatus(false);
        L14:
            HorizontalScrollItemSelector r108 = this.f68536b;
            AigcKeywordItemView r109 = this.f68535a;
            r108.getClass();
            r109.setSelectStatus(true);
            r108.f68531d = r109.getPosition();
            c r110 = r108.f68532e;
            if (r110 == null) goto L22;
            r110.a();
            return;
        L22:
            return;
        }
    }

    public HorizontalScrollItemSelector(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalScrollItemSelector(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final LinearLayout getContainerLinearLayout() {
        return (LinearLayout) this.f68529b.getValue();
    }

    private final LinearLayout.LayoutParams getContainerLinearLayoutLayoutParams() {
        return (LinearLayout.LayoutParams) this.f68528a.getValue();
    }

    private final int getFirstItemLeftMargin() {
        return ((Number) this.f68533f.getValue()).intValue();
    }

    private final int getNormalItemLeftMargin() {
        return ((Number) this.f68534g.getValue()).intValue();
    }

    public final void b() {
        ((ArrayList) this.f68530c).clear();
        this.f68531d = -1;
        scrollTo(0, 0);
        getContainerLinearLayout().removeAllViews();
    }

    public final String getCurrentSelectKeyword() {
        int r100 = this.f68531d;
        if (r100 >= 0) goto L5;
        return "";
    L5:
        if (r100 <= ((ArrayList) this.f68530c).size()) goto L8;
        return "";
    L8:
        return (String) ListProtector.get(this.f68530c, this.f68531d);
    }

    public final void c() {
        View r100 = getContainerLinearLayout().getChildAt(this.f68531d);
        if ((r100 instanceof AigcKeywordItemView) == true) goto L5;
        r100 = null;
    L5:
        AigcKeywordItemView r101 = (AigcKeywordItemView) r100;
        if (r101 == null) goto L8;
        r101.setSelectStatus(false);
    L8:
        this.f68531d = -1;
    }

    public final int getCurrentSelectItemIndex() {
        return this.f68531d;
    }

    public static final /* synthetic */ LinearLayout a(HorizontalScrollItemSelector r100) {
        return r100.getContainerLinearLayout();
    }

    public final void setItemSelectListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f68532e = r100;
    }

    public final void setKeywordList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        b();
        ArrayList r101 = (ArrayList) this.f68530c;
        r101.addAll(r100);
        Iterator r102 = ((ArrayList) this.f68530c).iterator();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L10;
        String r105 = (String) r102.next();
        AigcKeywordItemView r106 = new AigcKeywordItemView(getContext(), null, 6, r103);
        r106.setText(r105);
        r106.setPosition(r104);
        r106.setOnClickListener(new a(r106, this));
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        if (r104 != 0) goto L8;
        int r108 = getFirstItemLeftMargin();
    L9:
        r107.leftMargin = r108;
        getContainerLinearLayout().addView(r106, r107);
        r104 = r104 + 1;
        goto L4
    L8:
        r108 = getNormalItemLeftMargin();
        goto L9
    }

    public HorizontalScrollItemSelector(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f68528a = LazyKt.lazy(HorizontalScrollItemSelector$containerLinearLayoutLayoutParams$2.INSTANCE);
        this.f68529b = LazyKt.lazy(new HorizontalScrollItemSelector$containerLinearLayout$2(r100));
        this.f68530c = new ArrayList();
        this.f68531d = -1;
        this.f68533f = LazyKt.lazy(HorizontalScrollItemSelector$firstItemLeftMargin$2.INSTANCE);
        this.f68534g = LazyKt.lazy(HorizontalScrollItemSelector$normalItemLeftMargin$2.INSTANCE);
        setBackground(null);
        setOverScrollMode(2);
        addView(getContainerLinearLayout(), getContainerLinearLayoutLayoutParams());
    }

    public /* synthetic */ HorizontalScrollItemSelector(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
