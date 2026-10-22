package co2;

import com.bytedance.android.live.broadcast.api.model.AnchorVideoResolutionManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdk.config.zg;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements q {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.f154693a == false) goto L44;
        HashMap r101 = (HashMap) r100;
        String r102 = (String) r101.get(IPerformanceManager.Params.modules);
        JSONObject r103 = null;
        if (r102 == null) goto L9;
        JSONObject r104 = ln1.a.C6715a.b(r102);
    L11:
        if (r104 != null) goto L37;
    L15:
        r101.put("stream_in_cap_preset", AnchorVideoResolutionManager.f59011c);
        if (r103 != null) goto L18;
        return;
    L18:
        if (zg.f121763a.getValue().booleanValue() == false) goto L32;
        List<String> r105 = LiveEffectContext.f66734h;
        List<Sticker> r106 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.f66753c);
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L20:
        int r109 = 0;
        if (r108.hasNext() == false) goto L27;
        Effect r111 = ((Sticker) r108.next()).getEffect();
        if (r111 == null) goto L25;
        r109 = r111.getProvider();
    L25:
        r107.add(Integer.valueOf(r109));
        goto L20
    L27:
        if ((!r107.isEmpty()) == false) goto L30;
        r103.put(IPerformanceManager.Effect.effect_provider_id, String.valueOf(((Number) ListProtector.get(r107, 0)).intValue()));
    L30:
        if (r110.R0.length() >= 1024) goto L32;
        r101.put(IPerformanceManager.Effect.effect_params, r110.R0);
    L32:
        r103.put(IPerformanceManager.Effect.effect_process_texture_time, String.valueOf(r110.N0));
        r103.put(IPerformanceManager.Effect.effect_pure_algorithm_time, String.valueOf(r110.Q0));
        r103.put(IPerformanceManager.Effect.effect_pure_render_time, String.valueOf(r110.O0));
        r103.put(IPerformanceManager.Effect.effect_wait_algorithm_time, String.valueOf(r110.P0));
        if (r104 == null) goto L35;
        r104.put(IPerformanceManager.MODULE_FACE_STICKER, r103);
    L35:
        r101.put(IPerformanceManager.Params.modules, String.valueOf(r104));
        return;
    L37:
        r103 = JSONObjectProtectorUtils.getJSONObject(r104, IPerformanceManager.MODULE_FACE_STICKER);     // Catch: JSONException -> L14
        goto L15
    L9:
        r104 = null;
        goto L11
    }
}
