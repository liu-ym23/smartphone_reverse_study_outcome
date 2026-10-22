package com.bytedance.android.shopping.anchorv4.containers.page;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.shopping.anchorv4.components.base.ComponentContainer;
import com.bytedance.android.shopping.anchorv4.event_chain.PDPYataCommonEventService;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class PdContext {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f166269o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f166270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PageLifeCycleOwner f166271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorV4VM f166272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AnchorV4Param f166273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FragmentManager f166274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f166275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ComponentContainer f166276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SlcContext f166277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PageFinder f166278i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q f166279j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PdpBottomNavBarHelper f166280k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EventChain f166281l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.action.v f166282m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ng3.a f166283n;

    public static final class a {
    }

    static {
        f166269o = LazyKt.lazy(PdContext$Companion$isDebugOrLocalTest$2.INSTANCE);
    }

    public final boolean a() {
        AnchorV4Param r100 = this.f166273d;
        if (r100 == null) goto L9;
        V4NativeParams r101 = r100.getNativeParams();
        if (r101 == null) goto L9;
        if (r101.getFullMode() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final Context getContext() {
        return this.f166270a;
    }

    public PdContext(Context r100, PageLifeCycleOwner r101, AnchorV4VM r102, AnchorV4Param r103, FragmentManager r104, ComponentContainer r105, PageFinder r106, q r107, PdpBottomNavBarHelper r110, PDPYataCommonEventService r111, com.bytedance.android.shopping.anchorv4.event_chain.e r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "fragmentManager");
        Intrinsics.checkNotNullParameter(r105, "components");
        Intrinsics.checkNotNullParameter(r106, "pageFinder");
        Intrinsics.checkNotNullParameter(r107, "abilityManager");
        Intrinsics.checkNotNullParameter(r110, "bottomNavBarHelper");
        Intrinsics.checkNotNullParameter(r111, "yataCommonEventService");
        Intrinsics.checkNotNullParameter(r112, "yataChainCustomParams");
        this.f166270a = r100;
        this.f166271b = r101;
        this.f166272c = r102;
        this.f166273d = r103;
        this.f166274e = r104;
        this.f166275f = null;
        this.f166276g = r105;
        this.f166277h = null;
        this.f166278i = r106;
        this.f166279j = r107;
        this.f166280k = r110;
        this.f166281l = null;
        this.f166282m = r111;
        this.f166283n = r112;
        r102.setPdContext(this);
    }
}
