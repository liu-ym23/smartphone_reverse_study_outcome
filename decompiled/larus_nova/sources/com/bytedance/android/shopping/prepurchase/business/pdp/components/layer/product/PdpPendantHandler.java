package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.content.res.Resources;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.hybrid.bridges.ShowTaskBannerMethod;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpPendantHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f181652f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f181653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f181654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f181655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> f181656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j f181657e;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpPendantHandler f181658a;

        public b(PdpPendantHandler r100) {
            this.f181658a = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
        public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.g.c(this.f181658a.f181656d.e(), "IESLiveKit_ecom_pendant_close_event", this.f181658a.f181654b);
        L6:
            if (r101 != Lifecycle.Event.ON_PAUSE) goto L9;
            this.f181658a.c("onPause containerId=" + this.f181658a.f181653a);
            PdpPendantHandler.a(this.f181658a, 1);
        L9:
            if (r101 != Lifecycle.Event.ON_RESUME) goto L12;
            this.f181658a.c("onResume containerId=" + this.f181658a.f181653a);
            PdpPendantHandler.a(this.f181658a, 0);
            return;
        }
    }

    static {
    }

    public final void b(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        JSONObject r100 = r110.optJSONObject("frame");
        if (r100 == null) goto L9;
        boolean r101 = Intrinsics.areEqual(r100.optString(GXTemplateKey.GAIAX_LAYER_GRAVITY, "right"), "right");
        double r102 = r100.optDouble("width", 86.0d);
        double r103 = r100.optDouble("height", 86.0d);
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r104 = this.f181656d.getContainerAbility().i7();
        int r105 = zh.a.f572117a;
        Integer r106 = Integer.valueOf(r104.f180787d);
        Intrinsics.checkNotNullParameter(r106, "$this$asDip");
        float r107 = r106.intValue();
        Resources r108 = Resources.getSystem();
        int r109 = ((int) (r107 / WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()).density)) + 106;
        if (r101 == false) goto L7;
        double r111 = ((double) (com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r104.f180784a)) + 0)) - r102;
    L8:
        r100.put("x", r111);
        r100.put("y", ((double) (com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(r104.f180785b)) - r109)) - r103);
        goto L9
    L7:
        r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L9:
        int r112 = ShowTaskBannerMethod.f176217e;
        ShowTaskBannerMethod.a.a(this.f181656d.getContainerAbility().getContext(), r110, new PdpPendantHandler$handle$2(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.a(this.f181656d.e(), "IESLiveKit_ecom_pendant_close_event", this.f181654b);
        this.f181655c.getLifecycle().a(new b(this));
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f181656d.w7().d("Detail", "pdp_pendant " + r100);
    }

    public static final void a(PdpPendantHandler r100, int r101) {
        String r102 = r100.f181653a;
        if (r102 == null) goto L6;
        LynxAbilityImpl r103 = r100.f181656d.e().D0();
        JSONObject r104 = new JSONObject();
        r104.put("type", r101);
        r104.put("containerID", r102);
        Unit r105 = Unit.INSTANCE;
        r103.B("ecom.task.banner.timing", r104);
        return;
    }

    public PdpPendantHandler(ProductDetailInfoComponent r100, com.bytedance.android.shopping.prepurchase.arch.container.c r101, com.bytedance.android.shopping.prepurchase.arch.container.component.j r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "serviceRegistry");
        this.f181655c = r100;
        this.f181656d = r101;
        this.f181657e = r102;
        this.f181654b = new o(this);
    }
}
