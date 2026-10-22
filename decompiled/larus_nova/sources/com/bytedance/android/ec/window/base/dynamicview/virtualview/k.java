package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class k<V extends View, LP extends ViewGroup.LayoutParams> implements vo.a<V>, g<LP, Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49313f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f49314g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f49315h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f49316i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f49319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f49320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g<LP, Object> f49321e;

    public static final class a {
        public a() {
        }

        public static View a(View r100, String r101) {
            if ((r100 instanceof ViewGroup) == false) goto L5;
            ViewGroup r102 = (ViewGroup) r100;
            int r103 = r102.getChildCount();
            int r104 = 0;
            int r105 = 0;
        L10:
            if (r105 >= r103) goto L19;
            View r106 = r102.getChildAt(r105);
            if (r106 == null) goto L17;
            if (Intrinsics.areEqual(r106.getTag(k.f49313f), r101) == false) goto L17;
            return r106;
        L17:
            r105 = r105 + 1;
            goto L10
        L19:
            if (Intrinsics.areEqual(r100.getTag(k.f49313f), r101) == false) goto L21;
            return r100;
        L21:
            int r107 = r102.getChildCount();
        L22:
            if (r104 >= r107) goto L32;
            View r108 = r102.getChildAt(r104);
            if (r108 == null) goto L31;
            if ((r108 instanceof ViewGroup) == false) goto L31;
            View r109 = a(r108, r101);
            if (r109 == null) goto L31;
            return r109;
        L31:
            r104 = r104 + 1;
            goto L22
        L32:
            return null;
        L5:
            if (Intrinsics.areEqual(r100.getTag(k.f49313f), r101) == false) goto L8;
            return r100;
        L8:
            return null;
        }
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final void a(Object r100, LP r101, List<? extends k<?, LP>> r102) {
        Intrinsics.checkNotNullParameter(r101, "lp");
        Intrinsics.checkNotNullParameter(r102, "allElements");
        this.f49321e.a(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final LP b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "uiParam");
        return (LP) this.f49321e.b(r100);
    }

    static {
        f49316i = new a();
        f49313f = R.id.ec_window_base_info;
        f49314g = R.id.ec_shop_recommend_name;
        f49315h = R.id.ec_window_video_view_wrapper;
    }

    public void e(V r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        r100.setVisibility(this.f49319c.f49311e);
        r100.setAlpha(this.f49319c.f49310d);
        r100.setId(this.f49318b);
        r100.setTag(f49313f, this.f49317a);
        r100.setTag(f49315h, this.f49320d);
    }

    public final V d(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        V r102 = c(r100);
        e(r102);
        if (r101 == false) goto L10;
        int r103 = ko.a.f504336i;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter("DynamicView", "text");
        if (ECAppInfoService.f48114e.i() == false) goto L10;
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r102.setForeground(new ko.a(r102.getResources()));
    L10:
        return r102;
    }

    public k(String r100, int r101, j r102, String r103, g<LP, Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        Intrinsics.checkNotNullParameter(r102, "uiParam");
        Intrinsics.checkNotNullParameter(r103, "viewType");
        Intrinsics.checkNotNullParameter(r104, "filler");
        this.f49317a = r100;
        this.f49318b = r101;
        this.f49319c = r102;
        this.f49320d = r103;
        this.f49321e = r104;
    }
}
