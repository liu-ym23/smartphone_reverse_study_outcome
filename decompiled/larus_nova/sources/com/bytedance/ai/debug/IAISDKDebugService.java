package com.bytedance.ai.debug;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.ai.resource.d0;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.bytedance.applet.debug.AppletDebugManager;
import com.lynx.jsbridge.LynxModule;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k2.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface IAISDKDebugService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f36186a = null;

    public static final class Companion implements IAISDKDebugService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f36187b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile IAISDKDebugService f36188c;

        static {
            f36187b = new Companion();
        }

        public Companion() {
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Set<String> A() {
            IAISDKDebugService r100 = f36188c;
            if (r100 == null) goto L7;
            Set<String> r101 = r100.A();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new LinkedHashSet();
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void F() {
            boolean r100 = AppletDebugManager.f191566a;
            IAISDKDebugService r101 = f36188c;
            if (r101 == null) goto L6;
            r101.F();
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final boolean Q() {
            IAISDKDebugService r100 = f36188c;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.Q() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final List<AIPackage> a() {
            IAISDKDebugService r100 = f36188c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.a();
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final String b() {
            IAISDKDebugService r100 = f36188c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.b();
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final DebugMode getDebugMode() {
            IAISDKDebugService r100 = f36188c;
            if (r100 == null) goto L7;
            DebugMode r101 = r100.getDebugMode();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return DebugMode.NORMAL;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void m() {
            IAISDKDebugService r100 = f36188c;
            if (r100 == null) goto L6;
            r100.m();
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final boolean n() {
            IAISDKDebugService r100 = f36188c;
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.n();
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final String o() {
            IAISDKDebugService r100 = f36188c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.o();
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void u() {
            IAISDKDebugService r100 = f36188c;
            if (r100 == null) goto L6;
            r100.u();
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void C(DebugMode r100) {
            Intrinsics.checkNotNullParameter(r100, "debugMode");
            IAISDKDebugService r101 = f36188c;
            if (r101 == null) goto L6;
            r101.C(r100);
            return;
        }

        public final void D(d r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            IAISDKDebugService r101 = f36188c;
            if ((r101 instanceof c) == false) goto L7;
            c r102 = (c) r101;
        L8:
            if (r102 == null) goto L11;
            r102.f(r100);
            return;
        L11:
            return;
        L7:
            r102 = null;
            goto L8
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final String G(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appletName");
            IAISDKDebugService r101 = f36188c;
            if (r101 == null) goto L6;
            String r102 = r101.G(r100);
            if (r102 == null) goto L6;
            return r102;
        L6:
            return "";
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void H(WidgetBoxView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            IAISDKDebugService r101 = f36188c;
            if (r101 == null) goto L6;
            r101.H(r100);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void M(boolean r100) {
            IAISDKDebugService r101 = f36188c;
            if (r101 == null) goto L6;
            r101.M(r100);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final boolean O(String r100) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            IAISDKDebugService r101 = f36188c;
            if (r101 != null) goto L5;
            return false;
        L5:
            if (r101.O(r100) != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void c(Function1<? super Boolean, Unit> r100) {
            IAISDKDebugService r101 = f36188c;
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        public final d f(Function3<? super String, ? super Class<? extends LynxModule>, Object, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "registerModule");
            IAISDKDebugService r101 = f36188c;
            if ((r101 instanceof c) == false) goto L5;
            c r102 = (c) r101;
        L6:
            if (r102 != null) goto L8;
            return null;
        L8:
            return r102.g(r100);
        L5:
            r102 = null;
            goto L6
        }

        public final void g(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "runtime");
            IAISDKDebugService r101 = f36188c;
            if ((r101 instanceof c) == false) goto L5;
            c r102 = (c) r101;
        L6:
            if (r102 == null) goto L9;
            r102.L(r100);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final String h(String r100) {
            Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
            IAISDKDebugService r101 = f36188c;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.h(r100);
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final d0 v(String r100) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            IAISDKDebugService r101 = f36188c;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.v(r100);
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object B(String r100, Continuation<? super String> r101) {
            IAISDKDebugService r102 = f36188c;
            if (r102 != null) goto L5;
            return null;
        L5:
            return r102.B(r100, r101);
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void I(String r100, int r101) {
            Intrinsics.checkNotNullParameter("CDP", "type");
            IAISDKDebugService r102 = f36188c;
            if (r102 == null) goto L6;
            r102.I(r100, r101);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object e(String r100, Continuation r101) {
            IAISDKDebugService r102 = f36188c;
            if (r102 != null) goto L5;
            return null;
        L5:
            return r102.e(r100, r101);
        }

        public final boolean j(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "paramsJson");
            IAISDKDebugService r102 = f36188c;
            if ((r102 instanceof e) == false) goto L5;
            e r103 = (e) r102;
        L6:
            if (r103 != null) goto L8;
        L10:
            return false;
        L8:
            if (r103.N(r100, r101) != true) goto L10;
            return true;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void l(String r100, String r101) {
            IAISDKDebugService r102 = f36188c;
            if (r102 == null) goto L6;
            r102.l(r100, r101);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void q(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "packageName");
            IAISDKDebugService r102 = f36188c;
            if (r102 == null) goto L6;
            r102.q(r100, r101);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final boolean J(String r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
            IAISDKDebugService r103 = f36188c;
            if (r103 != null) goto L5;
            return false;
        L5:
            if (r103.J(r100, r101, r102) != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void d(String r100, String r101, com.bytedance.applet.debug.a r102) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "xToken");
            IAISDKDebugService r103 = f36188c;
            if (r103 == null) goto L6;
            r103.d(r100, r101, r102);
            return;
        }

        public final void i(d r100, Object r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "runtime");
            if (r100 != null) goto L5;
            return;
        L5:
            IAISDKDebugService r103 = f36188c;
            if ((r103 instanceof c) == false) goto L8;
            c r104 = (c) r103;
        L9:
            if (r104 == null) goto L12;
            r104.D(r100, r101, r102);
            return;
        L12:
            return;
        L8:
            r104 = null;
            goto L9
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final boolean p(View r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            IAISDKDebugService r103 = f36188c;
            if (r103 != null) goto L5;
            return false;
        L5:
            if (r103.p(r100, r101, r102) != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void s(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            Intrinsics.checkNotNullParameter(r101, "xToken");
            IAISDKDebugService r103 = f36188c;
            if (r103 == null) goto L6;
            r103.s(r100, r101, r102);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object y(String r100, String r101, Continuation<? super Applet> r102) {
            IAISDKDebugService r103 = f36188c;
            if (r103 != null) goto L5;
            return null;
        L5:
            return r103.y(r100, r101, r102);
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void z(Context r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "appName");
            Intrinsics.checkNotNullParameter(r102, "appVersion");
            IAISDKDebugService r103 = f36188c;
            if (r103 == null) goto L6;
            r103.z(r100, r101, r102);
            return;
        }

        public final boolean t(NativeDebugPanelType r100, String r101, h r102, View r103) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "launchParamsJson");
            Intrinsics.checkNotNullParameter(r102, "listener");
            IAISDKDebugService r104 = f36188c;
            if ((r104 instanceof e) == false) goto L5;
            e r105 = (e) r104;
        L7:
            if (r105 != null) goto L9;
            return false;
        L9:
            if (r105.R(r100, r101, r102, r103) != true) goto L13;
            return true;
        L13:
            return false;
        L5:
            r105 = null;
            goto L7
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object x(String r100, String r101, String r102, Continuation<? super Widget> r103) {
            IAISDKDebugService r104 = f36188c;
            if (r104 != null) goto L5;
            return null;
        L5:
            return r104.x(r100, r101, r102, r103);
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final void E(View r100, String r101, Gravity r110, String r111, Function1<? super Boolean, Unit> r112) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "packageName");
            Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_LAYER_GRAVITY);
            IAISDKDebugService r102 = f36188c;
            if (r102 == null) goto L6;
            r102.E(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object w(int r100, String r110, String r111, String r112, int r113, Continuation<? super OpenPlatformPreviewAppInfoList> r114) {
            if ((r114 instanceof IAISDKDebugService$Companion$getPreviewAppInfoList$1) == false) goto L7;
            IAISDKDebugService$Companion$getPreviewAppInfoList$1 r101 = (IAISDKDebugService$Companion$getPreviewAppInfoList$1) r114;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            IAISDKDebugService$Companion$getPreviewAppInfoList$1 r103 = r101;
            Object r115 = r103.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r103.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r115);
        L19:
            OpenPlatformPreviewAppInfoList r116 = (OpenPlatformPreviewAppInfoList) r115;
            if (r116 == null) goto L22;
            return r116;
        L22:
            return new OpenPlatformPreviewAppInfoList(null, null, null, null, false, 31, null);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r115);
            IAISDKDebugService r106 = f36188c;
            if (r106 == null) goto L22;
            r103.label = 1;
            r115 = r106.w(r100, r110, r111, r112, r113, r103);
            if (r115 != r104) goto L19;
            return r104;
        L7:
            r101 = new IAISDKDebugService$Companion$getPreviewAppInfoList$1(this, r114);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object k(int r110, String r111, String r112, String r113, String r114, int r115, Continuation<? super OpenPlatformPreviewAppVersionList> r116) {
            if ((r116 instanceof IAISDKDebugService$Companion$getPreviewAppVersionList$1) == false) goto L7;
            IAISDKDebugService$Companion$getPreviewAppVersionList$1 r100 = (IAISDKDebugService$Companion$getPreviewAppVersionList$1) r116;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            IAISDKDebugService$Companion$getPreviewAppVersionList$1 r117 = r100;
            Object r102 = r117.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r117.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            String r105 = (String) r117.L$0;
            ResultKt.throwOnFailure(r102);
            Object r106 = r102;
            String r107 = r105;
        L19:
            OpenPlatformPreviewAppVersionList r108 = (OpenPlatformPreviewAppVersionList) r106;
            if (r108 != null) goto L23;
        L21:
            OpenPlatformPreviewVersionPage r109 = null;
            return new OpenPlatformPreviewAppVersionList(r107, r109, 2, 0 == true ? 1 : 0);
        L23:
            return r108;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            IAISDKDebugService r118 = f36188c;
            r107 = r111;
            if (r118 == null) goto L21;
            r117.L$0 = r107;
            r117.label = 1;
            r106 = r118.k(r110, r111, r112, r113, r114, r115, r117);
            if (r106 != r103) goto L19;
            return r103;
        L7:
            r100 = new IAISDKDebugService$Companion$getPreviewAppVersionList$1(this, r116);
            goto L8
        }

        @Override // com.bytedance.ai.debug.IAISDKDebugService
        public final Object r(String r110, long r111, String r112, String r113, String r114, String r115, com.bytedance.applet.debug.view.i r116, Continuation r117) {
            IAISDKDebugService r100 = f36188c;
            if (r100 == null) goto L10;
            Object r101 = r100.r(r110, r111, r112, r113, r114, r115, r116, r117);
            if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r101;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes43.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/debug/IAISDKDebugService$DebugMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "LEGACY_SCAN_PREVIEW", "LOCAL_DEBUG", "SCAN_PREVIEW", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DebugMode extends Enum<DebugMode> {
        public static final DebugMode LEGACY_SCAN_PREVIEW = null;
        public static final DebugMode LOCAL_DEBUG = null;
        public static final DebugMode NORMAL = null;
        public static final DebugMode SCAN_PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DebugMode[] f36189a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36190b = null;
        private final int value;

        public static EnumEntries<DebugMode> getEntries() {
            return f36190b;
        }

        static {
            DebugMode r100 = new DebugMode(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            DebugMode r101 = new DebugMode("LEGACY_SCAN_PREVIEW", 1, 1);
            LEGACY_SCAN_PREVIEW = r101;
            DebugMode r102 = new DebugMode("LOCAL_DEBUG", 2, 2);
            LOCAL_DEBUG = r102;
            DebugMode r103 = new DebugMode("SCAN_PREVIEW", 3, 3);
            SCAN_PREVIEW = r103;
            DebugMode[] r104 = {r100, r101, r102, r103};
            f36189a = r104;
            f36190b = EnumEntriesKt.enumEntries(r104);
        }

        public static DebugMode[] values() {
            return (DebugMode[]) f36189a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DebugMode valueOf(String r100) {
            return (DebugMode) r27.a.a(DebugMode.class, r100);
        }

        public DebugMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX INFO: loaded from: classes43.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/debug/IAISDKDebugService$Gravity;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_CENTER", "BOTTOM_RIGHT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gravity extends Enum<Gravity> {
        public static final Gravity BOTTOM_CENTER = null;
        public static final Gravity BOTTOM_LEFT = null;
        public static final Gravity BOTTOM_RIGHT = null;
        public static final Gravity TOP_LEFT = null;
        public static final Gravity TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Gravity[] f36191a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36192b = null;

        public static EnumEntries<Gravity> getEntries() {
            return f36192b;
        }

        static {
            Gravity r100 = new Gravity("TOP_LEFT", 0);
            TOP_LEFT = r100;
            Gravity r101 = new Gravity("TOP_RIGHT", 1);
            TOP_RIGHT = r101;
            Gravity r102 = new Gravity("BOTTOM_LEFT", 2);
            BOTTOM_LEFT = r102;
            Gravity r103 = new Gravity("BOTTOM_CENTER", 3);
            BOTTOM_CENTER = r103;
            Gravity r104 = new Gravity("BOTTOM_RIGHT", 4);
            BOTTOM_RIGHT = r104;
            Gravity[] r105 = {r100, r101, r102, r103, r104};
            f36191a = r105;
            f36192b = EnumEntriesKt.enumEntries(r105);
        }

        public static Gravity[] values() {
            return (Gravity[]) f36191a.clone();
        }

        public static Gravity valueOf(String r100) {
            return (Gravity) r27.a.a(Gravity.class, r100);
        }

        public Gravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes43.dex */
    public interface a {
        void a();
    }

    public interface b {
        void K(View r100);

        boolean P(WidgetContainer r100);

        boolean i(j r100);

        boolean j(String r100, View r101, boolean r102);

        void t(View r100, boolean r101);
    }

    public interface c {
        void D(d r100, Object r101, String r102);

        void L(Object r100);

        void f(d r100);

        d g(Function3<? super String, ? super Class<? extends LynxModule>, Object, Unit> r100);
    }

    /* JADX INFO: loaded from: classes43.dex */
    public interface d {
    }

    public interface e {
        boolean N(String r100, String r101);

        boolean R(NativeDebugPanelType r100, String r101, h r102, View r103);
    }

    static {
        f36186a = Companion.f36187b;
    }

    Set<String> A();

    Object B(String r100, Continuation<? super String> r101);

    void C(DebugMode r100);

    void E(View r100, String r101, Gravity r102, String r103, Function1<? super Boolean, Unit> r104);

    void F();

    String G(String r100);

    void H(WidgetBoxView r100);

    void I(String r100, int r101);

    boolean J(String r100, boolean r101, String r102);

    void M(boolean r100);

    boolean O(String r100);

    boolean Q();

    List<AIPackage> a();

    String b();

    void c(Function1<? super Boolean, Unit> r100);

    void d(String r100, String r101, com.bytedance.applet.debug.a r102);

    Object e(String r100, Continuation r101);

    DebugMode getDebugMode();

    String h(String r100);

    Object k(int r100, String r101, String r102, String r103, String r104, int r105, Continuation<? super OpenPlatformPreviewAppVersionList> r106);

    void l(String r100, String r101);

    void m();

    boolean n();

    String o();

    boolean p(View r100, float r101, float r102);

    void q(String r100, String r101);

    Object r(String r100, long r101, String r102, String r103, String r104, String r105, com.bytedance.applet.debug.view.i r106, Continuation r107);

    void s(String r100, String r101, int r102);

    void u();

    d0 v(String r100);

    Object w(int r100, String r101, String r102, String r103, int r104, Continuation<? super OpenPlatformPreviewAppInfoList> r105);

    Object x(String r100, String r101, String r102, Continuation<? super Widget> r103);

    Object y(String r100, String r101, Continuation<? super Applet> r102);

    void z(Context r100, String r101, String r102);
}
