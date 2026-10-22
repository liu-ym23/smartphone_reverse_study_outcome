package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class UIConfigHelper$updateUIByLayout$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConstraintSet $constraintSet;
    final /* synthetic */ Map $moduleIdMap;

    public UIConfigHelper$updateUIByLayout$2(Map r100, ConstraintSet r101) {
        this.$moduleIdMap = r100;
        this.$constraintSet = r101;
        super(0);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper$updateUIByLayout$2$$special$$inlined$runCatching$lambda$1] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Result.Companion r210 = Result.Companion;     // Catch: Throwable -> L13
        ?? r211 = new UIConfigHelper$updateUIByLayout$2$$special$$inlined$runCatching$lambda$1(this);     // Catch: Throwable -> L13
        Class r100 = INVOKESTATIC_com_bytedance_android_livesdk_livecommerce_promotion_card_utils_UIConfigHelper$updateUIByLayout$2_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.constraintlayout.widget.ConstraintSet$Constraint");     // Catch: Throwable -> L13
        Field r101 = r100.getDeclaredField("leftToLeft");     // Catch: Throwable -> L13
        String r212 = "leftToLeft";
        r101.setAccessible(true);     // Catch: Throwable -> L13
        Field r102 = r100.getDeclaredField("leftToRight");     // Catch: Throwable -> L13
        String r213 = "leftToRight";
        r102.setAccessible(true);     // Catch: Throwable -> L13
        Field r103 = r100.getDeclaredField("rightToLeft");     // Catch: Throwable -> L13
        String r214 = "rightToLeft";
        r103.setAccessible(true);     // Catch: Throwable -> L13
        Field r104 = r100.getDeclaredField("rightToRight");     // Catch: Throwable -> L13
        String r215 = "rightToRight";
        r104.setAccessible(true);     // Catch: Throwable -> L13
        Field r105 = r100.getDeclaredField("topToTop");     // Catch: Throwable -> L13
        String r216 = "topToTop";
        r105.setAccessible(true);     // Catch: Throwable -> L13
        Field r110 = r100.getDeclaredField("topToBottom");     // Catch: Throwable -> L13
        String r217 = "topToBottom";
        r110.setAccessible(true);     // Catch: Throwable -> L13
        Field r111 = r100.getDeclaredField("bottomToTop");     // Catch: Throwable -> L13
        String r218 = "bottomToTop";
        r111.setAccessible(true);     // Catch: Throwable -> L13
        Field r112 = r100.getDeclaredField("bottomToBottom");     // Catch: Throwable -> L13
        String r310 = "bottomToBottom";
        r112.setAccessible(true);     // Catch: Throwable -> L13
        Field r113 = r100.getDeclaredField("startToEnd");     // Catch: Throwable -> L13
        String r311 = "startToEnd";
        r113.setAccessible(true);     // Catch: Throwable -> L13
        Field r114 = r100.getDeclaredField("startToStart");     // Catch: Throwable -> L13
        String r312 = "startToStart";
        r114.setAccessible(true);     // Catch: Throwable -> L13
        Field r115 = r100.getDeclaredField("endToStart");     // Catch: Throwable -> L13
        String r313 = "endToStart";
        r115.setAccessible(true);     // Catch: Throwable -> L13
        Field r106 = r100.getDeclaredField("endToEnd");     // Catch: Throwable -> L13
        String r314 = "endToEnd";
        r106.setAccessible(true);     // Catch: Throwable -> L13
        Field r107 = r100.getDeclaredField("leftMargin");     // Catch: Throwable -> L13
        String r315 = "leftMargin";
        r107.setAccessible(true);     // Catch: Throwable -> L13
        Field r108 = r100.getDeclaredField("rightMargin");     // Catch: Throwable -> L13
        String r316 = "rightMargin";
        r108.setAccessible(true);     // Catch: Throwable -> L13
        Field r219 = r108;
        Field r109 = r100.getDeclaredField("startMargin");     // Catch: Throwable -> L13
        String r317 = "startMargin";
        r109.setAccessible(true);     // Catch: Throwable -> L13
        Field r116 = r109;
        Field r117 = r100.getDeclaredField("endMargin");     // Catch: Throwable -> L13
        String r318 = "endMargin";
        r117.setAccessible(true);     // Catch: Throwable -> L13
        Field r118 = r117;
        Field r119 = r100.getDeclaredField("topMargin");     // Catch: Throwable -> L13
        String r319 = "topMargin";
        r119.setAccessible(true);     // Catch: Throwable -> L13
        Field r120 = r119;
        Field r121 = r100.getDeclaredField("bottomMargin");     // Catch: Throwable -> L13
        String r410 = "bottomMargin";
        r121.setAccessible(true);     // Catch: Throwable -> L13
        Field r122 = r100.getDeclaredField(RemoteMessageConst.Notification.VISIBILITY);     // Catch: Throwable -> L13
        String r123 = RemoteMessageConst.Notification.VISIBILITY;
        r122.setAccessible(true);     // Catch: Throwable -> L13
        UIConfigHelper$updateUIByLayout$2 r124 = this;
        Field r220 = r122;
        Iterator r125 = r124.$moduleIdMap.entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r125.hasNext() == false) goto L11;
        Map.Entry r411 = (Map.Entry) r125.next();     // Catch: Throwable -> L13
        Iterator r412 = r125;
        ConstraintSet.Constraint r126 = r124.$constraintSet.getParameters(((Number) r411.getValue()).intValue());     // Catch: Throwable -> L13
        if (r126 == null) goto L10;
        int r127 = r101.getInt(r126);     // Catch: Throwable -> L13
        Field r413 = r101;
        ?? r128 = r211;
        String r129 = r128.invoke(r127);     // Catch: Throwable -> L13
        String r130 = r128.invoke(r102.getInt(r126));     // Catch: Throwable -> L13
        Field r414 = r102;
        String r131 = r128.invoke(r103.getInt(r126));     // Catch: Throwable -> L13
        Field r415 = r103;
        String r132 = r128.invoke(r104.getInt(r126));     // Catch: Throwable -> L13
        Field r416 = r104;
        String r133 = r128.invoke(r105.getInt(r126));     // Catch: Throwable -> L13
        Field r417 = r105;
        String r134 = r128.invoke(r110.getInt(r126));     // Catch: Throwable -> L13
        Field r418 = r110;
        String r135 = r128.invoke(r111.getInt(r126));     // Catch: Throwable -> L13
        Field r419 = r111;
        String r136 = r128.invoke(r112.getInt(r126));     // Catch: Throwable -> L13
        Field r510 = r112;
        String r137 = r128.invoke(r113.getInt(r126));     // Catch: Throwable -> L13
        Field r511 = r113;
        String r138 = r128.invoke(r114.getInt(r126));     // Catch: Throwable -> L13
        Field r512 = r114;
        String r139 = r128.invoke(r115.getInt(r126));     // Catch: Throwable -> L13
        Field r513 = r115;
        String r140 = r128.invoke(r106.getInt(r126));     // Catch: Throwable -> L13
        int r141 = r107.getInt(r126);     // Catch: Throwable -> L13
        Field r514 = r107;
        Field r142 = r219;
        Field r221 = r106;
        int r143 = r142.getInt(r126);     // Catch: Throwable -> L13
        Field r144 = r116;
        int r145 = r144.getInt(r126);     // Catch: Throwable -> L13
        Field r146 = r118;
        int r147 = r146.getInt(r126);     // Catch: Throwable -> L13
        Field r148 = r120;
        int r149 = r148.getInt(r126);     // Catch: Throwable -> L13
        int r150 = r121.getInt(r126);     // Catch: Throwable -> L13
        Field r610 = r121;
        Field r151 = r220;
        int r152 = r151.getInt(r126);     // Catch: Throwable -> L13
        int r222 = com.bytedance.android.ec.sdk.helper.j.f48125a;     // Catch: Throwable -> L13
        r220 = r151;
        JSONObject r153 = new JSONObject();     // Catch: Throwable -> L13
        r153.put("modelName", ((PromotionCardModuleName) r411.getKey()).getModuleName());     // Catch: Throwable -> L13
        String r154 = r212;
        r153.put(r154, r129);     // Catch: Throwable -> L13
        String r155 = r213;
        r153.put(r155, r130);     // Catch: Throwable -> L13
        String r156 = r214;
        r153.put(r156, r131);     // Catch: Throwable -> L13
        String r157 = r215;
        r153.put(r157, r132);     // Catch: Throwable -> L13
        String r158 = r216;
        r153.put(r158, r133);     // Catch: Throwable -> L13
        String r159 = r217;
        r153.put(r159, r134);     // Catch: Throwable -> L13
        String r160 = r218;
        r153.put(r160, r135);     // Catch: Throwable -> L13
        String r161 = r310;
        r153.put(r161, r136);     // Catch: Throwable -> L13
        String r162 = r311;
        r153.put(r162, r137);     // Catch: Throwable -> L13
        String r163 = r312;
        r153.put(r163, r138);     // Catch: Throwable -> L13
        String r164 = r313;
        r153.put(r164, r139);     // Catch: Throwable -> L13
        String r165 = r314;
        r153.put(r165, r140);     // Catch: Throwable -> L13
        String r166 = r315;
        r153.put(r166, r141);     // Catch: Throwable -> L13
        r218 = r160;
        String r167 = r316;
        r153.put(r167, r143);     // Catch: Throwable -> L13
        r316 = r167;
        String r168 = r317;
        r153.put(r168, r145);     // Catch: Throwable -> L13
        r317 = r168;
        String r169 = r318;
        r153.put(r169, r147);     // Catch: Throwable -> L13
        String r170 = r319;
        r153.put(r170, r149);     // Catch: Throwable -> L13
        String r171 = r410;
        r153.put(r171, r150);     // Catch: Throwable -> L13
        String r172 = r123;
        r153.put(r172, r152);     // Catch: Throwable -> L13
        Unit r173 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r123 = r172;
        com.bytedance.android.ec.sdk.helper.j.a("UIConfigHelper", r153.toString(), null, null);     // Catch: Throwable -> L13
        r217 = r159;
        r216 = r158;
        r215 = r157;
        r212 = r154;
        r214 = r156;
        r213 = r155;
        r410 = r171;
        r315 = r166;
        r314 = r165;
        r313 = r164;
        r312 = r163;
        r311 = r162;
        r310 = r161;
        r319 = r170;
        r318 = r169;
        r106 = r221;
        r125 = r412;
        r101 = r413;
        r102 = r414;
        r103 = r415;
        r104 = r416;
        r105 = r417;
        r110 = r418;
        r111 = r419;
        r112 = r510;
        r113 = r511;
        r114 = r512;
        r115 = r513;
        r211 = r128;
        r107 = r514;
        r219 = r142;
        r116 = r144;
        r118 = r146;
        r120 = r148;
        r121 = r610;
        r124 = this;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r174 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_livecommerce_promotion_card_utils_UIConfigHelper$updateUIByLayout$2_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
