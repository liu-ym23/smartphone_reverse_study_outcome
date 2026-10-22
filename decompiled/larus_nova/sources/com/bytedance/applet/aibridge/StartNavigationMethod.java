package com.bytedance.applet.aibridge;

import androidx.camera.video.AudioStats;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.j0;
import com.larus.platform.api.l1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/StartNavigationMethod;", "Lcom/bytedance/applet/aibridge/AbsStartNavigationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsStartNavigationMethodIDL$StartNavigationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsStartNavigationMethodIDL$StartNavigationResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartNavigationMethod extends AbsStartNavigationMethodIDL {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f3.h<Object> f190873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f190874b = null;

    public static final class a implements j0 {
        public a() {
        }
    }

    public static final class b {
    }

    static {
        f190874b = new a();
    }

    public StartNavigationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r112) {
        AbsStartNavigationMethodIDL.a r113 = (AbsStartNavigationMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = null;
        if (r113.getTo().getLng() != null) goto L5;
    L37:
        f3.h.a.a(r112, "Invalid parameter. destination coordinate required", null, null, 14);
        return;
    L5:
        if (r113.getTo().getLat() == null) goto L37;
        String r114 = r113.getMethod();
        String r101 = AppletNaviType.WALKING;
        if (Intrinsics.areEqual(r114, AppletNaviType.WALKING) == false) goto L10;
    L9:
        String r102 = r101;
        NaviPoi r115 = r113.getFrom();
        if (r115 != null) goto L17;
        Pair<Double, Double> r103 = null;
    L24:
        Double r116 = r113.getTo().getLat();
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r116 == null) goto L27;
        double r105 = r116.doubleValue();
    L28:
        Double r117 = Double.valueOf(r105);
        Double r106 = r113.getTo().getLng();
        if (r106 == null) goto L31;
        r104 = r106.doubleValue();
    L31:
        Pair<Double, Double> r107 = new Pair(r117, Double.valueOf(r104));
        f190873a = r112;
        l1 r108 = com.larus.platform.service.b.a();
        if (r108 == null) goto L39;
        NaviPoi r118 = r113.getFrom();
        if (r118 == null) goto L36;
        r100 = r118.getName();
    L36:
        r108.d(r100, r103, r113.getTo().getName(), r107, r102, r113.getPolicy(), f190874b);
        return;
    L39:
        return;
    L27:
        r105 = 0.0d;
        goto L28
    L17:
        if (r115.getLng() != null) goto L19;
    L21:
        Pair<Double, Double> r109 = null;
    L22:
        r103 = r109;
        goto L24
    L19:
        if (r115.getLat() == null) goto L21;
        r109 = new Pair(r115.getLat(), r115.getLng());
        goto L22
    L10:
        r101 = AppletNaviType.RIDING;
        if (Intrinsics.areEqual(r114, AppletNaviType.RIDING) == true) goto L9;
        r101 = AppletNaviType.DRIVING;
        goto L9
    }
}
