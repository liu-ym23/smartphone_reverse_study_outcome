package com.bytedance.android.anniex.container.util;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.p0;
import com.bytedance.ies.bullet.service.base.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40618a = 0;

    public static final class a implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ia.c f40619a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f40619a.close();
            return Unit.INSTANCE;
        }

        public a(ia.c r100) {
            this.f40619a = r100;
        }
    }

    public static final class b implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ia.c f40620a;

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f40620a.reload(null);
            return Unit.INSTANCE;
        }

        public b(ia.c r100) {
            this.f40620a = r100;
        }
    }

    static {
    }

    public static View a(ia.c r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        t36.d r101 = r100.getCurrentSchema();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(new p(r101, "error_page_style", null).f565862b, "host") == false) goto L7;
        HybridLogger.f("CustomViewUtil", "use host theme to create error view", null, 12);
        String r102 = "default_bid";
    L8:
        String r103 = r100.getViewType();
        s26.d r104 = s26.d.f540305c;
        p0 r105 = (p0) s26.d.f540305c.d(r102, p0.class);
        if (r105 == null) goto L19;
        Context r106 = r100.getSystemContext();
        if (r106 == null) goto L20;
        com.bytedance.ies.bullet.service.base.i r107 = r105.n(r106, r103);
        if (r107 == null) goto L21;
        View r108 = r107.a(new a(r100), new b(r100));
        if (r108 == null) goto L22;
        r108.setLayoutParams(r105.c0(r103));
        return r108;
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    L19:
        return null;
    L7:
        HybridLogger.f("CustomViewUtil", "use custom theme to create error view", null, 12);
        r102 = r100.getBid();
        goto L8
    }

    public static View b(ia.c r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        t36.d r101 = r100.getCurrentSchema();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(new p(r101, "loading_style", null).f565862b, "host") == false) goto L7;
        HybridLogger.f("CustomViewUtil", "use host theme to create loading view", null, 12);
        String r102 = "default_bid";
    L8:
        String r103 = r100.getViewType();
        s26.d r104 = s26.d.f540305c;
        p0 r105 = (p0) s26.d.f540305c.d(r102, p0.class);
        if (r105 == null) goto L22;
        Context r106 = r100.getSystemContext();
        if (r106 == null) goto L23;
        q r107 = r105.b(r106, r103);
        if (r107 == null) goto L24;
        View r108 = r107.getView();
        if (r108 == null) goto L25;
        FrameLayout.LayoutParams r109 = r105.B0(r103);
        if (r109 == null) goto L20;
        r108.setLayoutParams(r109);
    L20:
        return r108;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L7:
        HybridLogger.f("CustomViewUtil", "use custom theme to create loading view", null, 12);
        r102 = r100.getBid();
        goto L8
    }
}
