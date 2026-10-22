package a30;

import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.x;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import i12.o;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.f6;
import w20.me;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends f6<me, SetEffectComposerResultModel> {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r210) {
        me r100 = (me) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = com.bytedance.android.livesdk.gift.platform.core.h.q();
        StringBuilder r102 = new StringBuilder();
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getName());
        r103.append(": nodePaths = ");
        List<String> r104 = r100.w();
        if (r104 == null) goto L5;
        String r105 = CollectionsKt.joinToString$default(r104, ",", "[", "]", 0, null, null, 56, null);
    L6:
        r103.append(r105);
        r103.append(", scene = ");
        r103.append(r100.getScene());
        r103.append(", channel = ");
        r103.append(r100.getChannel());
        r102.append(r103.toString());
        r102.append(", enableNewPkEffect = ");
        r102.append(r101);
        jy0.b.d("SetEffectComposerMethod", r102.toString());
        Class<?> r106 = ((JsonAdapter) SetEffectComposerResultModel.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r107 = vh7.b.f554981a;
        Constructor r108 = r107.get(r106);
        if (r108 != null) goto L16;
        r108 = r106.getConstructor(new Class[0]);
        if (r108 == null) goto L15;
        Constructor<? extends SerializableObjectJsonAdapterBase> r109 = r107.putIfAbsent(r106, (Constructor<? extends SerializableObjectJsonAdapterBase>) r108);
        if (r109 == null) goto L16;
        r108 = r109;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L16:
        Object r111 = ((SerializableObjectJsonAdapterBase) r108.newInstance(new Object[0])).createInstance();
        if (r111 == null) goto L215;
        SetEffectComposerResultModel r112 = (SetEffectComposerResultModel) r111;
        Class<?> r113 = ((JsonAdapter) SetEffectComposerResultModel.b.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r114 = r107.get(r113);
        if (r114 != null) goto L28;
        r114 = r113.getConstructor(new Class[0]);
        if (r114 == null) goto L27;
        Constructor<? extends SerializableObjectJsonAdapterBase> r115 = r107.putIfAbsent(r113, r114);
        if (r115 == null) goto L28;
        r114 = r115;
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L28:
        Object r116 = r114.newInstance(new Object[0]).createInstance();
        if (r116 == null) goto L213;
        r112.v8((SetEffectComposerResultModel.b) r116);
        String r117 = r100.getName();
        if (r117 != null) goto L34;
        return;
    L34:
        switch(r117.hashCode()) {
            case -860210598: goto L117;
            case 1389977506: goto L114;
            case 1478557334: goto L111;
            case 2101172676: goto L37;
            default: goto L238;
        };
    L238:
        return;
    L37:
        if (r117.equals("removeComposer") == false) goto L211;
        if (r101 == false) goto L89;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "result");
        GiftContext r118 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r118 == null) goto L44;
        com.bytedance.live.datacontext.m<ca0.i> r119 = r118.getGiftRenderFilterWrapper();
        if (r119 == null) goto L44;
        ca0.i r120 = r119.getValue();
    L45:
        if (r120 != null) goto L47;
        jy0.b.c("SetEffectComposerMethod", "giftRenderFilter is null", null, 4);
        finishWithFailure();
        return;
    L47:
        boolean r121 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r121);
        Object[] r122 = ((ArrayList) m.f(r100.w())).toArray(new String[0]);
        if (r122 == null) goto L88;
        String[] r123 = (String[]) r122;
        i r124 = new i(this);
        String r125 = r100.getChannel();
        i12.e r126 = o.b();
        if (r126 == null) goto L52;
        Object r127 = com.bytedance.android.scope.m.f163449e.d(r126, x.class);
    L53:
        x r128 = (x) r127;
        if (r128 == null) goto L66;
        String r129 = r100.getScene();
        List r130 = ArraysKt.toList(r123);
        Intrinsics.checkNotNullParameter(r130, "nodePath");
        if (r129 != null) goto L58;
        String r131 = "default";
    L59:
        Set r132 = (Set) ((LinkedHashMap) r128.f131836a).get(r131);
        if (r132 == null) goto L66;
        Set<String> r133 = CollectionsKt.toMutableSet(r132);
        if (r133 == null) goto L66;
        r133.removeAll(CollectionsKt.toSet(r130));
        r128.f131836a.put(r131, r133);
        goto L66
    L58:
        r131 = r129;
    L66:
        if (TextUtils.isEmpty(r125) == false) goto L68;
    L86:
        r120.c(r123, r124, r121);
        return;
    L68:
        if (a0.d() == true) goto L86;
        if (TextUtils.equals(r125, "renderFilter") == true) goto L86;
        if (TextUtils.equals(r125, PbRequest.SwitchType.PK) == false) goto L78;
        ca0.b r134 = m.c();
        if (r134 == null) goto L85;
        r134.o(r123);
    L85:
        finishWithSuccess();
        return;
    L78:
        if (TextUtils.equals(r125, "pk_interact") == false) goto L82;
        ca0.b r135 = m.c();
        if (r135 == null) goto L85;
        r135.c(r123);
        goto L85
    L82:
        ca0.b r136 = m.c();
        if (r136 == null) goto L85;
        r136.i(r123);
        goto L85
    L52:
        r127 = null;
        goto L53
    L88:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L44:
        r120 = null;
        goto L45
    L89:
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "result");
        jy0.b.a("SetEffectComposerMethod", "removeComposer, channel = " + r100.getChannel());
        if (m.e() == true) goto L93;
        jy0.b.c("SetEffectComposerMethod", "removeComposer, isInit() == false, return", null, 4);
        finishWithSuccess();
        return;
    L93:
        if (m.d() == true) goto L95;
        jy0.b.c("SetEffectComposerMethod", "removeComposer, isEnable() == false, return", null, 4);
        finishWithSuccess();
        return;
    L95:
        Object[] r137 = ((ArrayList) m.f(r100.w())).toArray(new String[0]);
        if (r137 == null) goto L109;
        String[] r138 = (String[]) r137;
        boolean r139 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r139);
        if (r139 == false) goto L103;
        ca0.b r140 = m.c();
        if (r140 == null) goto L102;
        r140.x(r138);
    L102:
        jy0.b.d("SetEffectComposerMethod", "removeComposer success, stickerHandler = " + r140);
        finishWithResult(r112);
        return;
    L103:
        or2.a r141 = m.a();
        if (r141 != null) goto L106;
        jy0.b.f("SetEffectComposerMethod", "removeComposer, livePlayerClient is null, JSB will not return!", null, 4);
    L106:
        if (r141 == null) goto L222;
        ((or2.j) r141).h(r138, new h(this, r112));
        return;
    L222:
        return;
    L109:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L211:
        return;
    L111:
        if (r117.equals("getComposer") == false) goto L224;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "result");
        return;
    L224:
        return;
    L114:
        if (r117.equals("setComposer") == false) goto L226;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "result");
        return;
    L226:
        return;
    L117:
        if (r117.equals("appendComposer") == false) goto L228;
        String r142 = "";
        if (r101 == false) goto L178;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "result");
        GiftContext r143 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r143 == null) goto L125;
        com.bytedance.live.datacontext.m<ca0.i> r144 = r143.getGiftRenderFilterWrapper();
        if (r144 == null) goto L125;
        ca0.i r145 = r144.getValue();
    L126:
        if (r145 != null) goto L128;
        jy0.b.c("SetEffectComposerMethod", "giftRenderFilter is null", null, 4);
        finishWithFailure();
        return;
    L128:
        boolean r146 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r146);
        Object[] r147 = ((ArrayList) m.f(r100.w())).toArray(new String[0]);
        if (r147 == null) goto L177;
        String[] r148 = (String[]) r147;
        List<String> r149 = r100.getTags();
        if (r149 == null) goto L137;
        Object[] r150 = r149.toArray(new String[0]);
        if (r150 == null) goto L136;
        String[] r151 = (String[]) r150;
    L138:
        g r152 = new g(this);
        String r153 = r100.getChannel();
        i12.e r154 = o.b();
        if (r154 == null) goto L141;
        Object r155 = com.bytedance.android.scope.m.f163449e.d(r154, x.class);
    L142:
        x r156 = (x) r155;
        if (r156 == null) goto L155;
        String r157 = r100.getScene();
        List r158 = ArraysKt.toList(r148);
        Intrinsics.checkNotNullParameter(r158, "nodePath");
        if (r157 != null) goto L147;
        String r159 = "default";
    L148:
        Set r160 = (Set) ((LinkedHashMap) r156.f131836a).get(r159);
        if (r160 == null) goto L152;
        Set<String> r161 = CollectionsKt.toMutableSet(r160);
        if (r161 == null) goto L152;
    L153:
        r161.addAll(CollectionsKt.toSet(r158));
        r156.f131836a.put(r159, r161);
    L152:
        r161 = new LinkedHashSet();
        goto L153
    L147:
        r159 = r157;
    L155:
        if (TextUtils.isEmpty(r153) == false) goto L157;
    L175:
        r145.a(r148, r151, r152, r146);
        return;
    L157:
        if (a0.d() == true) goto L175;
        if (TextUtils.equals(r153, "renderFilter") == true) goto L175;
        if (TextUtils.equals(r153, PbRequest.SwitchType.PK) == false) goto L167;
        ca0.b r162 = m.c();
        if (r162 == null) goto L174;
        r162.k(r148, r151);
    L174:
        finishWithSuccess();
        return;
    L167:
        if (TextUtils.equals(r153, "pk_interact") == false) goto L171;
        ca0.b r163 = m.c();
        if (r163 == null) goto L174;
        r163.w(r148, r151);
        goto L174
    L171:
        ca0.b r164 = m.c();
        if (r164 == null) goto L174;
        r164.f(r148, r151);
        goto L174
    L141:
        r155 = null;
        goto L142
    L136:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L137:
        r151 = new String[]{""};
        goto L138
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L125:
        r145 = null;
        goto L126
    L178:
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "result");
        jy0.b.a("SetEffectComposerMethod", "appendComposer, channel = " + r100.getChannel());
        if (m.e() == true) goto L182;
        jy0.b.c("SetEffectComposerMethod", "appendComposer, isInit() == false, return", null, 4);
        finishWithSuccess();
        return;
    L182:
        if (m.d() == true) goto L184;
        jy0.b.c("SetEffectComposerMethod", "appendComposer, isEnable() == false, return", null, 4);
        finishWithSuccess();
        return;
    L184:
        Object[] r165 = ((ArrayList) m.f(r100.w())).toArray(new String[0]);
        if (r165 == null) goto L210;
        String[] r166 = (String[]) r165;
        List<String> r167 = r100.getTags();
        if (r167 == null) goto L193;
        Object[] r168 = r167.toArray(new String[0]);
        if (r168 == null) goto L192;
        String[] r169 = (String[]) r168;
    L194:
        String r170 = r100.getScene();
        if (r170 == null) goto L198;
        r142 = r170;
    L198:
        boolean r171 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r171);
        if (r171 == false) goto L204;
        ca0.b r172 = m.c();
        if (r172 == null) goto L203;
        r172.d(r166, r169);
    L203:
        jy0.b.d("SetEffectComposerMethod", "appendComposer success, stickerHandler = " + r172);
        finishWithResult(r112);
        return;
    L204:
        or2.a r173 = m.a();
        if (r173 != null) goto L207;
        jy0.b.f("SetEffectComposerMethod", "appendComposer, livePlayerClient is null, JSB will not return!", null, 4);
    L207:
        if (r173 == null) goto L235;
        ((or2.j) r173).a(r166, r169, new f(this, r142, r166, r112));
        return;
    L235:
        return;
    L192:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L193:
        r169 = new String[]{""};
        goto L194
    L210:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L228:
        return;
    L213:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel.SetEffectComposerData");
    L215:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel");
    L5:
        r105 = null;
        goto L6
    }
}
