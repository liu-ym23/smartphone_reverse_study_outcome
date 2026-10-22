package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.ai.PdpAIComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.VirtualCommentComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements ul.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Component<?, ?>> f181805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Component<?, ?> f181806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VirtualCommentComponent f181807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f181808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PdpAIComponent f181809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f181810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> f181811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j f181812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.g<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> f181813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PdpRootComponent.a f181814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n83.m f181815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.helper.u f181816l;

    public static final class a {
    }

    static {
    }

    @Override // ul.c
    public final void a(boolean r100) {
        if (r100 == false) goto L7;
        Iterator<T> r101 = this.f181805a.iterator();
    L5:
        if (r101.hasNext() == false) goto L11;
        ((Component) r101.next()).e2().setVisibility(0);
        goto L5
    L11:
        return;
    L7:
        Iterator<T> r102 = this.f181805a.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        ((Component) r102.next()).e2().setVisibility(8);
        goto L9
    }

    public final void c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (this.f181807c != null) goto L6;
        VirtualCommentComponent r101 = new VirtualCommentComponent();
        b(this, r100, r101, null, 0, 12);
        Unit r102 = Unit.INSTANCE;
        this.f181807c = r101;
        return;
    }

    public static void b(n r100, ViewGroup r101, Component r102, ViewGroup.LayoutParams r103, int r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = -1;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "parentView");
        Intrinsics.checkNotNullParameter(r102, "component");
        r100.f181813i.a(r101, r102, r103, r104);
    }

    public n(PdpRootComponent r100, com.bytedance.android.shopping.prepurchase.arch.container.c r101, com.bytedance.android.shopping.prepurchase.arch.container.component.j r102, com.bytedance.android.shopping.prepurchase.arch.container.component.g r103, PdpRootComponent.a r104, n83.m r105, com.bytedance.android.shopping.anchorv4.helper.u r106) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r103, "componentLoader");
        Intrinsics.checkNotNullParameter(r104, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f181810f = r100;
        this.f181811g = r101;
        this.f181812h = r102;
        this.f181813i = r103;
        this.f181814j = r104;
        this.f181815k = r105;
        this.f181816l = r106;
        this.f181805a = new ArrayList();
    }
}
