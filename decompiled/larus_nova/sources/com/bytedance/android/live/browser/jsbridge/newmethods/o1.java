package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CanLoadFromLokiResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "canLoadFromLoki")
public final class o1 extends w20.l<w20.t7, CanLoadFromLokiResultModel> {

    public static final class a {
    }

    static {
    }

    public o1() {
    }

    public static final void j(o1 r100, Effect r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        CanLoadFromLokiResultModel r102 = new CanLoadFromLokiResultModel();
        r102.a(CanLoadFromLokiResultModel.Code.Success);
        r102.b(Boolean.FALSE);
    L20:
        r100.finishWithResult(r102);
        ALogger.i("CanLoadFromLokiMethod", "result=" + JsonUtil.toJSONString(r102));
        return;
    L5:
        CanLoadFromLokiResultModel r103 = new CanLoadFromLokiResultModel();
        r103.b(Boolean.TRUE);
        r103.d(r101.getUnzipPath());
        final String r104 = r101.getUnzipPath();
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        if (r105.exists() == true) goto L9;
        r105 = null;
    L9:
        if (r105 == null) goto L18;
        FileTreeWalk r106 = FilesKt.walk$default(r105, null, 1, null);
        if (r106 == null) goto L18;
        Sequence r107 = SequencesKt.filter(r106, CanLoadFromLokiMethod$getAllFiles$2.INSTANCE);
        if (r107 == null) goto L18;
        Sequence r108 = SequencesKt.map(r107, new CanLoadFromLokiMethod$getAllFiles$3(r104));
        if (r108 == null) goto L18;
        List<String> r109 = SequencesKt.toList(r108);
        if (r109 == null) goto L18;
    L19:
        r103.c(r109);
        r102 = r103;
    L18:
        r109 = CollectionsKt.emptyList();
        goto L19
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        w20.t7 r101 = (w20.t7) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("CanLoadFromLokiMethod", "params=" + JsonUtil.toJSONString(r101));
        List<String> r111 = LiveEffectContext.f66734h;
        EffectManager r102 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d();
        r102.fetchCategoryEffect(r101.b(), r101.a(), 0, 0, 0, "0", new p1(this, r101, r102));
    }
}
