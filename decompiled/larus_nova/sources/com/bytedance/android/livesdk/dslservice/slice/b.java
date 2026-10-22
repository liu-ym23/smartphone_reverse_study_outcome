package com.bytedance.android.livesdk.dslservice.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dsl.recyclerview.i;
import com.bytedance.android.livesdk.dslservice.util.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.q;
import yt1.r;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends com.bytedance.android.livesdk.dslservice.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f122923g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f122924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.dslservice.slice.action.a f122925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.render.r f122926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f122927f;

    public static final class a {
    }

    static {
    }

    @Override // yt1.k
    public final View getView() {
        return this.f122926e.f50701c;
    }

    @Override // yt1.k
    public final void release() {
        Function2<? super q, ? super k, Unit> r100 = this.f122817a;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke(this.f122927f, this);
    L6:
        if (n0.f65363a.getValue().booleanValue() == false) goto L9;
        this.f122924c = null;
        this.f122925d = null;
        return;
    }

    @Override // yt1.k
    public final void a(i r100) {
        com.bytedance.android.livesdk.dslservice.slice.action.a r101 = this.f122925d;
        if (r101 == null) goto L6;
        r101.f122922b = r100;
        return;
    }

    public b(com.bytedance.android.ecom.arch.slice.render.r r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "sliceView");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f122926e = r100;
        this.f122927f = r101;
    }

    @Override // yt1.k
    public final void b(au1.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "lifeType");
        r r102 = this.f122924c;
        if (r102 != null) goto L5;
    L6:
        if (r101 == false) goto L18;
    L7:
        String r103 = r100.f16298a;
        BaseSlcViewManager<?> r104 = this.f122926e.f50700b.f50218f;
        if (r104 == null) goto L10;
        SlcElement r105 = r104.f50270e;
    L11:
        if (r105 == null) goto L19;
        Map<String, IAction> r106 = r105.getAction();
        if (r106 == null) goto L20;
        IAction r107 = r106.get(r103);
        if (r107 == null) goto L21;
        com.bytedance.android.ecom.arch.slice.render.r r108 = this.f122926e;
        SlcTemplateContext r109 = r108.f50700b;
        SlcTemplateContext.e(r109, r107, r108.f50701c, r109.f50222j, null, 24);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r105 = null;
        goto L11
    L18:
        return;
    L5:
        if (r102.f569041b == true) goto L7;
        goto L6
    }

    @Override // yt1.k
    public final void c(String r100, Map<String, ? extends Object> r101, int r102) {
        long r103 = System.currentTimeMillis();
        SliceViewUtilsKt.a(this.f122926e, r100, r101, r102);
        long r104 = System.currentTimeMillis() - r103;
        o.f123008f.i(r104, this.f122927f.f569037a, "BindData");
    }
}
