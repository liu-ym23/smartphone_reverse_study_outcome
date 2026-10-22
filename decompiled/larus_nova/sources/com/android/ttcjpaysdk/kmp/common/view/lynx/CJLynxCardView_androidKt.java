package com.android.ttcjpaysdk.kmp.common.view.lynx;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import com.android.ttcjpaysdk.kmp.common.lynx.CJLynxService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u000f\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0082\u0010¨\u0006\u0010"}, d2 = {"CJLynxCardView", "", "modifier", "Landroidx/compose/ui/Modifier;", "params", "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/CJLynxCardViewParams;", "eventHandler", "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/CJLynxCardViewEventHandler;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/IKmpCJLynxCardLifecycle;", "viewConfig", "Lcom/android/ttcjpaysdk/kmp/common/view/lynx/KmpCJLynxCardViewConfig;", "(Landroidx/compose/ui/Modifier;Lcom/android/ttcjpaysdk/kmp/common/view/lynx/CJLynxCardViewParams;Lcom/android/ttcjpaysdk/kmp/common/view/lynx/CJLynxCardViewEventHandler;Lcom/android/ttcjpaysdk/kmp/common/view/lynx/IKmpCJLynxCardLifecycle;Lcom/android/ttcjpaysdk/kmp/common/view/lynx/KmpCJLynxCardViewConfig;Landroidx/compose/runtime/Composer;II)V", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "cj_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJLynxCardView_androidKt {
    private static final View CJLynxCardView$lambda$12$lambda$11(View r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return r100;
    }

    private static final Unit CJLynxCardView$lambda$17(Modifier r100, CJLynxCardViewParams r110, CJLynxCardViewEventHandler r111, IKmpCJLynxCardLifecycle r112, KmpCJLynxCardViewConfig r113, int r114, int r115, Composer r116, int r117) {
        CJLynxCardView(r100, r110, r111, r112, r113, r116, RecomposeScopeImplKt.updateChangedFlags(r114 | 1), r115);
        return Unit.INSTANCE;
    }

    private static final Unit CJLynxCardView$lambda$4(Modifier r100, CJLynxCardViewParams r110, CJLynxCardViewEventHandler r111, IKmpCJLynxCardLifecycle r112, KmpCJLynxCardViewConfig r113, int r114, int r115, Composer r116, int r117) {
        CJLynxCardView(r100, r110, r111, r112, r113, r116, RecomposeScopeImplKt.updateChangedFlags(r114 | 1), r115);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DisposableEffectResult a(String r100, CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1 r101, IKmpCJLynxCardService r102, View r103, DisposableEffectScope r104) {
        return CJLynxCardView$lambda$8$lambda$7(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit b(String r100) {
        return CJLynxCardView$lambda$10$lambda$9(r100);
    }

    public static /* synthetic */ Unit c(Modifier r100, CJLynxCardViewParams r101, CJLynxCardViewEventHandler r102, IKmpCJLynxCardLifecycle r103, KmpCJLynxCardViewConfig r104, int r105, int r106, Composer r107, int r108) {
        return CJLynxCardView$lambda$17(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* synthetic */ Unit d(String r100, View r101) {
        return CJLynxCardView$lambda$14$lambda$13(r100, r101);
    }

    public static /* synthetic */ View e(View r100, Context r101) {
        return CJLynxCardView$lambda$12$lambda$11(r100, r101);
    }

    public static /* synthetic */ Unit f(String r100, View r101) {
        return CJLynxCardView$lambda$16$lambda$15(r100, r101);
    }

    public static /* synthetic */ Unit g(Modifier r100, CJLynxCardViewParams r101, CJLynxCardViewEventHandler r102, IKmpCJLynxCardLifecycle r103, KmpCJLynxCardViewConfig r104, int r105, int r106, Composer r107, int r108) {
        return CJLynxCardView$lambda$4(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    private static final Unit CJLynxCardView$lambda$10$lambda$9(String r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        CJLynxService.INSTANCE.sendJsEvent("cjpay_lynxcard_common_event_from_native", r100);
        return Unit.INSTANCE;
    }

    private static final Activity findActivity(Context r100) {
    L3:
        if ((r100 instanceof Activity) == true) goto L12;
        if ((r100 instanceof ContextWrapper) == false) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L8:
        return null;
    L12:
        return (Activity) r100;
    }

    private static final Unit CJLynxCardView$lambda$14$lambda$13(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        CJLogger.INSTANCE.d("CJLynxCardView", "onRelease@" + r100);
        return Unit.INSTANCE;
    }

    private static final Unit CJLynxCardView$lambda$16$lambda$15(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        CJLogger.INSTANCE.d("CJLynxCardView", "onUpdate@" + r100);
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult CJLynxCardView$lambda$8$lambda$7(final String r100, final CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1 r101, final IKmpCJLynxCardService r102, final View r103, DisposableEffectScope r104) {
        Intrinsics.checkNotNullParameter(r104, "$this$DisposableEffect");
        return new CJLynxCardView_androidKt$CJLynxCardView$lambda$8$lambda$7$$inlined$onDispose$1(r100, r101, r102, r103);
    }

    public static final void CJLynxCardView(Modifier r210, final CJLynxCardViewParams r211, CJLynxCardViewEventHandler r212, IKmpCJLynxCardLifecycle r310, KmpCJLynxCardViewConfig r311, Composer r312, final int r313, final int r314) {
        Intrinsics.checkNotNullParameter(r211, "params");
        Composer r100 = r312.startRestartGroup(-902531096);
        int r101 = r314 & 1;
        if (r101 == 0) goto L6;
        int r110 = r313 | 6;
        Modifier r102 = r210;
    L14:
        if ((r314 & 2) == 0) goto L17;
        r110 = r110 | 48;
    L23:
        int r111 = r314 & 4;
        if (r111 == 0) goto L27;
        r110 = r110 | 384;
    L33:
        final CJLynxCardViewEventHandler r112 = r212;
    L34:
        int r113 = r314 & 8;
        if (r113 == 0) goto L38;
        r110 = r110 | 3072;
    L47:
        int r114 = r314 & 16;
        if (r114 == 0) goto L51;
        r110 = r110 | 24576;
    L57:
        KmpCJLynxCardViewConfig r115 = r311;
    L59:
        if ((r110 & 9363) == 9362) goto L61;
        boolean r103 = true;
    L63:
        if (r100.shouldExecute(r103, r110 & 1) == false) goto L149;
        if (r101 == 0) goto L66;
        Modifier r104 = Modifier.Companion;
    L68:
        if (r111 == 0) goto L70;
        r112 = null;
    L70:
        if (r113 == 0) goto L72;
        IKmpCJLynxCardLifecycle r213 = null;
    L73:
        if (r114 == 0) goto L75;
        KmpCJLynxCardViewConfig r214 = null;
    L77:
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventStart(-902531096, r110, -1, "com.android.ttcjpaysdk.kmp.common.view.lynx.CJLynxCardView (CJLynxCardView.android.kt:28)");
    L79:
        pd6.b r105 = pd6.c.f528682a;
        final IKmpCJLynxCardService r106 = (IKmpCJLynxCardService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKmpCJLynxCardService.class));
        Activity r107 = findActivity((Context) r100.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
        r100.startReplaceGroup(1849434622);
        Object r116 = r100.rememberedValue();
        Composer.Companion r117 = Composer.Companion;
        if (r116 != r117.getEmpty()) goto L82;
        r116 = CJLynxCardViewKt.generateRandomNumberString(10);
        r100.updateRememberedValue(r116);
    L82:
        final String r118 = (String) r116;
        r100.endReplaceGroup();
        r100.startReplaceGroup(1849434622);
        Object r119 = r100.rememberedValue();
        if (r119 != r117.getEmpty()) goto L85;
        r119 = SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        r100.updateRememberedValue(r119);
    L85:
        final MutableState r120 = (MutableState) r119;
        r100.endReplaceGroup();
        r100.startReplaceGroup(1849434622);
        Object r121 = r100.rememberedValue();
        if (r121 != r117.getEmpty()) goto L88;
        r121 = new CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1(r118, r120, r112);
        r100.updateRememberedValue(r121);
    L88:
        final CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1 r108 = (CJLynxCardView_androidKt$CJLynxCardView$eventCallback$1$1) r121;
        r100.endReplaceGroup();
        Object r122 = r211.getSchema();
        boolean r109 = r211.getUseAnnieXCard();
        r100.startReplaceGroup(-1746271574);
        boolean r123 = (r100.changed(r107) | r100.changed(r122)) | r100.changed(r109);
        Object r124 = r100.rememberedValue();
        if (r123 == false) goto L91;
    L154:
        CJLogger.INSTANCE.d("CJLynxCardView", "onCreate@" + r118 + ": params=" + r211);     // Catch: Exception -> L101
        if (r211.getUseAnnieXCard() == false) goto L96;
        if (r106 == null) goto L99;
        Object r125 = r106.createCJAnnieXCard(r107, r211.getSchema(), r211.getInitData(), r211.getGlobalProps(), r213, r214, r108);     // Catch: Exception -> L101
    L100:
        r124 = r125;
    L103:
        r100.updateRememberedValue(r124);
    L104:
        final View r126 = (View) r124;
        r100.endReplaceGroup();
        if (r126 == null) goto L107;
        r100.startReplaceGroup(-1224400529);
        boolean r127 = r100.changedInstance(r106) | r100.changedInstance(r126);
        Object r128 = r100.rememberedValue();
        if (r127 == false) goto L116;
    L117:
        r128 = new CJLynxCardView_androidKt$CJLynxCardView$1$1(r120, r106, r126, r118, r108, null);
        r100.updateRememberedValue(r128);
    L118:
        r100.endReplaceGroup();
        EffectsKt.LaunchedEffect(r126, (Function2) r128, r100, 0);
        r100.startReplaceGroup(-1224400529);
        boolean r129 = r100.changedInstance(r106) | r100.changedInstance(r126);
        Object r130 = r100.rememberedValue();
        if (r129 == false) goto L121;
    L122:
        r130 = new b(r118, r108, r106, r126);
        r100.updateRememberedValue(r130);
    L123:
        r100.endReplaceGroup();
        EffectsKt.DisposableEffect(r126, (Function1) r130, r100, 0);
        if (r112 == null) goto L126;
        Function1<Function1<? super String, Unit>, Unit> r131 = r112.getSender();
    L127:
        r100.startReplaceGroup(251110983);
        if (r131 == null) goto L134;
        r100.startReplaceGroup(1849434622);
        Object r132 = r100.rememberedValue();
        if (r132 != Composer.Companion.getEmpty()) goto L133;
        r132 = new c();
        r100.updateRememberedValue(r132);
    L133:
        r100.endReplaceGroup();
        r131.invoke((Function1) r132);
        Unit r133 = Unit.INSTANCE;
    L134:
        r100.endReplaceGroup();
        r100.startReplaceGroup(5004770);
        boolean r134 = r100.changedInstance(r126);
        Object r135 = r100.rememberedValue();
        if (r134 == false) goto L137;
    L138:
        r135 = new d(r126);
        r100.updateRememberedValue(r135);
    L139:
        Function1 r136 = (Function1) r135;
        r100.endReplaceGroup();
        r100.startReplaceGroup(5004770);
        Object r137 = r100.rememberedValue();
        Composer.Companion r138 = Composer.Companion;
        if (r137 != r138.getEmpty()) goto L142;
        r137 = new e(r118);
        r100.updateRememberedValue(r137);
    L142:
        Function1 r139 = (Function1) r137;
        r100.endReplaceGroup();
        r100.startReplaceGroup(5004770);
        Object r140 = r100.rememberedValue();
        if (r140 != r138.getEmpty()) goto L145;
        r140 = new f(r118);
        r100.updateRememberedValue(r140);
    L145:
        r100.endReplaceGroup();
        Modifier r141 = r104;
        CJLynxCardViewEventHandler r142 = r112;
        AndroidView_androidKt.AndroidView(r136, r141, null, r139, (Function1) r140, r100, ((r110 << 3) & 112) | 27648, 4);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        final Modifier r143 = r104;
        final CJLynxCardViewEventHandler r144 = r142;
        final KmpCJLynxCardViewConfig r145 = r214;
    L150:
        ScopeUpdateScope r146 = r100.endRestartGroup();
        if (r146 == null) goto L156;
        final IKmpCJLynxCardLifecycle r147 = r213;
        r146.updateScope(new g(r143, r211, r144, r147, r145, r313, r314));
        return;
    L156:
        return;
    L137:
        if (r135 != Composer.Companion.getEmpty()) goto L139;
    L126:
        r131 = null;
        goto L127
    L121:
        if (r130 != Composer.Companion.getEmpty()) goto L123;
    L116:
        if (r128 != Composer.Companion.getEmpty()) goto L118;
    L107:
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventEnd();
    L109:
        ScopeUpdateScope r148 = r100.endRestartGroup();
        if (r148 == null) goto L155;
        final Modifier r149 = r104;
        final CJLynxCardViewEventHandler r150 = r112;
        final IKmpCJLynxCardLifecycle r151 = r213;
        final KmpCJLynxCardViewConfig r152 = r214;
        r148.updateScope(new a(r149, r211, r150, r151, r152, r313, r314));
        return;
    L155:
        return;
    L99:
        r125 = null;
        goto L100
    L96:
        if (r106 == null) goto L99;
        r125 = r106.createLynxCardView(r107, r211.getSchema(), r211.getInitData(), r211.getGlobalProps(), r213, r214);     // Catch: Exception -> L101
    L101:
        e = move-exception;
        CJLogger.INSTANCE.e("CJLynxCardView", "onCreate@" + r118 + " error: " + ExceptionsKt.stackTraceToString(e));
        r124 = null;
        goto L103
    L91:
        if (r124 != r117.getEmpty()) goto L104;
    L75:
        r214 = r115;
        goto L77
    L72:
        r213 = r310;
        goto L73
    L66:
        r104 = r102;
        goto L68
    L149:
        r100.skipToGroupEnd();
        r213 = r310;
        r143 = r102;
        r144 = r112;
        r145 = r115;
        goto L150
    L61:
        r103 = false;
        goto L63
    L51:
        if ((r313 & 24576) != 0) goto L57;
        r115 = r311;
        if (r100.changedInstance(r115) == false) goto L55;
        int r153 = 16384;
    L56:
        r110 = r110 | r153;
        goto L59
    L55:
        r153 = 8192;
        goto L56
    L38:
        if ((r313 & 3072) != 0) goto L47;
        if ((r313 & 4096) != 0) goto L42;
        boolean r154 = r100.changed(r310);
    L43:
        if (r154 == false) goto L45;
        int r155 = 2048;
    L46:
        r110 = r110 | r155;
        goto L47
    L45:
        r155 = 1024;
        goto L46
    L42:
        r154 = r100.changedInstance(r310);
        goto L43
    L27:
        if ((r313 & 384) != 0) goto L33;
        r112 = r212;
        if (r100.changed(r112) == false) goto L31;
        int r156 = 256;
    L32:
        r110 = r110 | r156;
        goto L34
    L31:
        r156 = 128;
        goto L32
    L17:
        if ((r313 & 48) != 0) goto L23;
        if (r100.changed(r211) == false) goto L21;
        int r157 = 32;
    L22:
        r110 = r110 | r157;
        goto L23
    L21:
        r157 = 16;
        goto L22
    L6:
        if ((r313 & 6) != 0) goto L12;
        r102 = r210;
        if (r100.changed(r102) == false) goto L10;
        int r158 = 4;
    L11:
        r110 = r158 | r313;
        goto L14
    L10:
        r158 = 2;
        goto L11
    L12:
        r102 = r210;
        r110 = r313;
        goto L14
    }
}
