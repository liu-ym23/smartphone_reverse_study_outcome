package a30;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetEffectComposerInUsedResultModel;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.x;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.z;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.s2;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends s2<JsonObject, LiveGetEffectComposerInUsedResultModel> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        LiveGetEffectComposerInUsedResultModel r102 = new LiveGetEffectComposerInUsedResultModel();
        r102.a(LiveGetEffectComposerInUsedResultModel.Code.Success);
        LiveGetEffectComposerInUsedResultModel.a r103 = new LiveGetEffectComposerInUsedResultModel.a();
        i12.e r104 = o.b();
        ArrayList r105 = null;
        if (r104 == null) goto L5;
        Object r106 = com.bytedance.android.scope.m.f163449e.d(r104, x.class);
    L6:
        x r107 = (x) r106;
        if (r107 == null) goto L17;
        Map<String, Set<String>> r108 = r107.f131836a;
        ArrayList r109 = new ArrayList(r108.size());
        Iterator r110 = ((LinkedHashMap) r108).entrySet().iterator();
    L10:
        if (r110.hasNext() == false) goto L12;
        Map.Entry r111 = (Map.Entry) r110.next();
        r109.add(new z((String) r111.getKey(), CollectionsKt.toList((Iterable) r111.getValue())));
        goto L10
    L12:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r113 = r109.iterator();
    L14:
        if (r113.hasNext() == false) goto L16;
        z r114 = (z) r113.next();
        LiveGetEffectComposerInUsedResultModel.b r115 = new LiveGetEffectComposerInUsedResultModel.b();
        r115.a(r114.f131861b);
        r115.b(r114.f131860a);
        r112.add(r115);
        goto L14
    L16:
        r105 = r112;
    L17:
        r103.a(r105);
        Unit r116 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
