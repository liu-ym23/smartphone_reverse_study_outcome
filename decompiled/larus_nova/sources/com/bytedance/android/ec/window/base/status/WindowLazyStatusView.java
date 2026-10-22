package com.bytedance.android.ec.window.base.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB\u001b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\b\u001a\u00020\u00072\u001c\u0010\u0006\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/window/base/status/WindowLazyStatusView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/ec/window/base/status/c;", "Lcom/bytedance/android/ec/window/base/status/d;", "Landroid/view/View;", "viewCreators", "", "setCreators", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowLazyStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c, d<? extends View>> f49690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c, a> f49691b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f49692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f49693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d<View> f49694c;

        public a(View r100, d<View> r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f49693b = r100;
            this.f49694c = r101;
        }
    }

    public final void a() {
        removeAllViews();
        ((LinkedHashMap) this.f49691b).clear();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        FrameLayout.LayoutParams r100 = super.generateDefaultLayoutParams();
        r100.gravity = 17;
        return r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "newStatus");
        a r101 = (a) ((LinkedHashMap) this.f49691b).get(r100);
        if (r101 != null) goto L8;
        d r102 = (d) ((LinkedHashMap) this.f49690a).get(r100);
        if (r102 != null) goto L7;
        r101 = null;
        goto L8
    L7:
        View r103 = r102.f49707a.invoke();
        r103.setTag(r100);
        addView(r103);
        a r104 = new a(r103, r102);
        this.f49691b.put(r100, r104);
        r101 = r104;
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        Iterator r105 = ((LinkedHashMap) this.f49691b).entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L37;
        Map.Entry r106 = (Map.Entry) r105.next();
        c r107 = (c) r106.getKey();
        a r108 = (a) r106.getValue();
        if (Intrinsics.areEqual(r108, r101) == true) goto L15;
        r108.f49693b.setVisibility(4);
        Integer r109 = r108.f49692a;
        int r110 = r108.f49693b.getVisibility();
        if (r109 != null) goto L30;
    L31:
        d<View> r111 = r108.f49694c;
        if (r111 == null) goto L36;
        Function1<T, Unit> r112 = r111.f49709c;
        if (r112 == 0) goto L36;
        Unit r113 = r112.invoke((T) r108.f49693b);
    L36:
        r108.f49692a = Integer.valueOf(r108.f49693b.getVisibility());
        goto L12
    L30:
        if (r109.intValue() == r110) goto L36;
    L15:
        r108.f49693b.setVisibility(0);
        Integer r114 = r108.f49692a;
        int r115 = r108.f49693b.getVisibility();
        if (r114 != null) goto L19;
    L20:
        d<View> r116 = r108.f49694c;
        if (r116 == null) goto L25;
        Function1<T, Unit> r117 = r116.f49708b;
        if (r117 == 0) goto L25;
        Unit r118 = r117.invoke((T) r108.f49693b);
    L25:
        r108.f49692a = Integer.valueOf(r108.f49693b.getVisibility());
        goto L12
    L19:
        if (r114.intValue() == r115) goto L25;
    }

    public final void setCreators(Map<? extends c, ? extends d<? extends View>> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewCreators");
        removeAllViews();
        ((LinkedHashMap) this.f49691b).clear();
        ((LinkedHashMap) this.f49690a).clear();
        this.f49690a.putAll(r100);
    }

    public WindowLazyStatusView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f49690a = new LinkedHashMap();
        this.f49691b = new LinkedHashMap();
    }
}
