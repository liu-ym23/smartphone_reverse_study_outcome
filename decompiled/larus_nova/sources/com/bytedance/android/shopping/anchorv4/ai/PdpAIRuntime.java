package com.bytedance.android.shopping.anchorv4.ai;

import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.ec.base.api.ai.AIChatComponentHandle;
import com.bytedance.android.ec.base.api.ai.FloatChatWindowState;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationContext;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpAIRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f165626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIChatComponentHandle f165627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m0 f165628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatChatWindowState f165629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j0 f165630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f165631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f165632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p0 f165633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k0 f165634i;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        p0 r100 = this.f165633h;
        ConversationContext r101 = this.f165634i.h();
        Object r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getConversationId();
    L6:
        final AIChatComponentHandle r104 = r100.b(r103);
        if (r104 != null) goto L9;
        return false;
    L9:
        this.f165627b = r104;
        if (((Boolean) this.f165632g.getValue()).booleanValue() == false) goto L184;
        xe.d r105 = r104.getController();
        int r106 = com.bytedance.android.ec.base.settings.b.f42814a;
        Object r107 = 5000L;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r109 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L174
        r109.getClass();     // Catch: Throwable -> L64
        Object r110 = SDKSettingsCacheManager.f42809b.get("ecom_pdp_doubao_chat_timeout");     // Catch: Throwable -> L64
        if (r110 != null) goto L19;
    L61:
        Object r111 = null;
    L62:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L64
    L66:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);     // Catch: Throwable -> L174
        if (r113 == null) goto L70;
        EnsureManager.ensureNotReachHere(r113);     // Catch: Throwable -> L174
    L70:
        if (Result.m9455isFailureimpl(r112) == false) goto L73;
        r112 = null;
    L73:
        if ((r112 instanceof Long) == true) goto L75;
        r112 = null;
    L75:
        Object r114 = (Long) r112;     // Catch: Throwable -> L174
        if (r114 != null) goto L82;
        r109.getClass();     // Catch: Throwable -> L174
        Object r115 = SDKSettingsCacheManager.f42808a.get("ecom_pdp_doubao_chat_timeout");     // Catch: Throwable -> L174
        if ((r115 instanceof Long) == true) goto L81;
        r115 = null;
    L81:
        r114 = (Long) r115;     // Catch: Throwable -> L174
    L82:
        if (r114 != null) goto L183;
        int r116 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L174
        Object r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.m9452exceptionOrNullimpl(r118) != null) goto L201;
    L171:
        r114 = r118;
    L172:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ecom_pdp_doubao_chat_timeout", r114);     // Catch: Throwable -> L174
        goto L183
    L201:
        r118 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ecom_pdp_doubao_chat_timeout", Long.class, r107);     // Catch: Throwable -> L168
    L169:
        if (r118 != null) goto L171;
        r114 = r107;
    L168:
        r118 = r107;
        goto L169
    L207:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L135
        Object r119 = SDKSettingsCacheManager.f42809b.get("ecom_pdp_doubao_chat_timeout");     // Catch: Throwable -> L135
        if (r119 != null) goto L90;
    L132:
        Object r120 = null;
    L133:
        Object r121 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L135
    L137:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);     // Catch: Throwable -> L161
        if (r122 == null) goto L141;
        EnsureManager.ensureNotReachHere(r122);     // Catch: Throwable -> L161
    L141:
        if (Result.m9455isFailureimpl(r121) == false) goto L144;
        r121 = null;
    L144:
        if ((r121 instanceof Long) == true) goto L146;
        r121 = null;
    L146:
        Long r123 = (Long) r121;     // Catch: Throwable -> L161
        if (r123 == null) goto L149;
        r114 = r123;
        goto L172
    L149:
        jj4.b r124 = jj4.b.f499326b;     // Catch: Throwable -> L161
        Object r125 = jj4.a.a("ecom_pdp_doubao_chat_timeout", Long.class, r107, false);     // Catch: Throwable -> L161
        if (r125 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r125 instanceof Long) == false) goto L156;
        r102 = r125;
    L156:
        Object r126 = (Long) r102;     // Catch: Throwable -> L161
        if (r126 != null) goto L159;
        r126 = r107;
    L159:
        r118 = Result.m9449constructorimpl(r126);     // Catch: Throwable -> L161
    L90:
        if ((r119 instanceof Long) == true) goto L92;
        Object r127 = null;
    L93:
        r120 = (Long) r127;     // Catch: Throwable -> L135
        if (r120 != null) goto L133;
        if ((r119 instanceof Number) == false) goto L120;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L105;
        Float r128 = Float.valueOf(((Number) r119).floatValue());     // Catch: Throwable -> L135
        if ((r128 instanceof Long) == true) goto L103;
        r128 = null;
    L103:
        r120 = (Long) r128;     // Catch: Throwable -> L135
        goto L133
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L111;
        Double r129 = Double.valueOf(((Number) r119).doubleValue());     // Catch: Throwable -> L135
        if ((r129 instanceof Long) == true) goto L109;
        r129 = null;
    L109:
        r120 = (Long) r129;     // Catch: Throwable -> L135
        goto L133
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L117;
        Integer r130 = Integer.valueOf(((Number) r119).intValue());     // Catch: Throwable -> L135
        if ((r130 instanceof Long) == true) goto L115;
        r130 = null;
    L115:
        r120 = (Long) r130;     // Catch: Throwable -> L135
        goto L133
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L120;
        r120 = Long.valueOf(((Number) r119).longValue());     // Catch: Throwable -> L135
    L120:
        if ((r119 instanceof JSONObject) == false) goto L122;
    L199:
        Object r131 = SDKSettingsCacheManager.a().fromJson(r119.toString(), Long.class);     // Catch: Throwable -> L128
        if ((r131 instanceof Long) == true) goto L126;
        r131 = null;
    L126:
        Object r132 = Result.m9449constructorimpl((Long) r131);     // Catch: Throwable -> L128
    L130:
        r120 = r132;
        if (Result.m9455isFailureimpl(r120) == false) goto L133;
    L128:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L135
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L135
        goto L130
    L122:
        if ((r119 instanceof JSONArray) == false) goto L132;
    L92:
        r127 = r119;
    L135:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L161
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L183:
        r105.sa(((Number) r114).longValue());
        goto L184
    L19:
        if ((r110 instanceof Long) == true) goto L21;
        Object r135 = null;
    L22:
        r111 = (Long) r135;     // Catch: Throwable -> L64
        if (r111 != null) goto L62;
        if ((r110 instanceof Number) == false) goto L49;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L34;
        Float r136 = Float.valueOf(((Number) r110).floatValue());     // Catch: Throwable -> L64
        if ((r136 instanceof Long) == true) goto L32;
        r136 = null;
    L32:
        r111 = (Long) r136;     // Catch: Throwable -> L64
        goto L62
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L40;
        Double r137 = Double.valueOf(((Number) r110).doubleValue());     // Catch: Throwable -> L64
        if ((r137 instanceof Long) == true) goto L38;
        r137 = null;
    L38:
        r111 = (Long) r137;     // Catch: Throwable -> L64
        goto L62
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L46;
        Integer r138 = Integer.valueOf(((Number) r110).intValue());     // Catch: Throwable -> L64
        if ((r138 instanceof Long) == true) goto L44;
        r138 = null;
    L44:
        r111 = (Long) r138;     // Catch: Throwable -> L64
        goto L62
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Long.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L49;
        r111 = Long.valueOf(((Number) r110).longValue());     // Catch: Throwable -> L64
    L49:
        if ((r110 instanceof JSONObject) == false) goto L51;
    L211:
        Object r139 = SDKSettingsCacheManager.a().fromJson(r110.toString(), Long.class);     // Catch: Throwable -> L57
        if ((r139 instanceof Long) == true) goto L55;
        r139 = null;
    L55:
        Object r140 = Result.m9449constructorimpl((Long) r139);     // Catch: Throwable -> L57
    L59:
        r111 = r140;
        if (Result.m9455isFailureimpl(r111) == false) goto L62;
    L57:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L64
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
        goto L59
    L51:
        if ((r110 instanceof JSONArray) == false) goto L61;
    L21:
        r135 = r110;
    L64:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L174
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Object r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L179;
        EnsureManager.ensureNotReachHere(r145);
    L179:
        if (Result.m9455isFailureimpl(r144) == true) goto L182;
        r107 = r144;
    L182:
        r114 = r107;
    L184:
        FragmentActivity r146 = this.f165634i.getActivity();
        if (r146 == null) goto L193;
        Window r147 = r146.getWindow();
        if (r147 == null) goto L193;
        int r148 = r147.getAttributes().softInputMode;
        if (this.f165631f != null) goto L192;
        this.f165631f = Integer.valueOf(r148);
    L192:
        r147.setSoftInputMode((r148 & (-241)) | 48);
    L193:
        this.f165633h.a(this.f165634i.i());
        FragmentTransaction r149 = this.f165634i.getFragmentManager().beginTransaction();
        int r150 = this.f165634i.g();
        Fragment r151 = r104.getFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r149, r151, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "pdp_ai_chat_fragment", r150) == true) goto L197;
        r149 = r149.replace(r150, r151, "pdp_ai_chat_fragment");
    L197:
        r149.commitAllowingStateLoss();
        r104.getController().c(new s(this.f165634i));
        m0 r152 = new m0(this.f165633h, this.f165634i);
        r104.getController().d(r152);
        this.f165628c = r152;
        j0 r153 = new j0(this);
        r104.getController().e(r153);
        this.f165630e = r153;
        this.f165634i.a(r104.getController().c9());
        ((ArrayList) this.f165626a).add(this.f165634i.e().a(this.f165634i.g(), new PdpAIRuntime$registerPageCoverObserver$1(r104)));
        final n0 r154 = new n0(this.f165633h, this.f165634i);
        ((ArrayList) this.f165626a).add(this.f165634i.e().c(new PdpAIRuntime$registerPdpEventObserver$1(r154)));
        ((ArrayList) this.f165626a).add(this.f165634i.e().b(new PdpAIRuntime$registerPdpEventObserver$2(r154)));
        return true;
    L5:
        r103 = null;
        goto L6
    }

    public final void b() {
        m0 r100 = this.f165628c;
        if (r100 == null) goto L9;
        AIChatComponentHandle r101 = this.f165627b;
        if (r101 == null) goto L9;
        xe.d r102 = r101.getController();
        if (r102 == null) goto L9;
        r102.a(r100);
    L9:
        this.f165628c = null;
        j0 r103 = this.f165630e;
        if (r103 == null) goto L16;
        AIChatComponentHandle r104 = this.f165627b;
        if (r104 == null) goto L16;
        xe.d r105 = r104.getController();
        if (r105 == null) goto L16;
        r105.b(r103);
    L16:
        this.f165630e = null;
        this.f165629d = FloatChatWindowState.COLLAPSED;
        Iterator r106 = ((ArrayList) this.f165626a).iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        ((f) r106.next()).dispose();
        goto L18
    L20:
        ((ArrayList) this.f165626a).clear();
        AIChatComponentHandle r107 = this.f165627b;
        if (r107 == null) goto L25;
        xe.d r108 = r107.getController();
        if (r108 == null) goto L25;
        r108.c(null);
    L25:
        Integer r109 = this.f165631f;
        if (r109 == null) goto L33;
        int r110 = r109.intValue();
        FragmentActivity r111 = this.f165634i.getActivity();
        if (r111 == null) goto L32;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L32;
        r112.setSoftInputMode(r110);
    L32:
        this.f165631f = null;
    L33:
        AIChatComponentHandle r113 = this.f165627b;
        if (r113 == null) goto L42;
        Fragment r114 = r113.getFragment();
        if (r114 == null) goto L42;
        if (r114.isAdded() == false) goto L42;
        this.f165634i.getFragmentManager().beginTransaction().remove(r114).commitAllowingStateLoss();
    L42:
        this.f165627b = null;
    }

    public PdpAIRuntime(p0 r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        Intrinsics.checkNotNullParameter(r101, "host");
        this.f165633h = r100;
        this.f165634i = r101;
        this.f165626a = new ArrayList();
        this.f165629d = FloatChatWindowState.COLLAPSED;
        this.f165632g = LazyKt.lazy(new PdpAIRuntime$inputDelayAttachEnabled$2(this));
    }
}
