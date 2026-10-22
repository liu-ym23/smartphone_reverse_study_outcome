package com.stepos.core.ability.sla;

import ai.onnxruntime.a;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.stepos.base.ability.AbilityBase;
import com.stepos.core.ability.converter.AsrAudioFileDecoder;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.ability.sla.SlaResultBuilder;
import com.stepos.core.common.atomic.AtomicDispatchRequest;
import com.stepos.core.common.atomic.AtomicDispatchResult;
import com.stepos.core.common.atomic.AtomicSdkClientFactory;
import com.stepos.core.common.atomic.IAtomicSdkClient;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.model.manifest.ModelManifest;
import gc.o;
import gc.q;
import h0.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.l;
import qb.b;
import v6.c;
import v6.d;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SlaAbility extends AbilityBase<c, d.q> {
    private final Set<String> lockScreenAllowed;
    private final LockStateProvider lockStateProvider;
    private final Set<String> slaUnsupported;
    private final String tag;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ExecVerdict {
        private final boolean canExecute;
        private final int errorCode;
        private final String reason;

        public ExecVerdict(boolean z, int i10, String str) {
            this.canExecute = z;
            this.errorCode = i10;
            this.reason = str;
        }

        public static /* synthetic */ ExecVerdict copy$default(ExecVerdict execVerdict, boolean z, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z = execVerdict.canExecute;
            }
            if ((i11 & 2) != 0) {
                i10 = execVerdict.errorCode;
            }
            if ((i11 & 4) != 0) {
                str = execVerdict.reason;
            }
            return execVerdict.copy(z, i10, str);
        }

        public final boolean component1() {
            return this.canExecute;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final String component3() {
            return this.reason;
        }

        public final ExecVerdict copy(boolean z, int i10, String str) {
            return new ExecVerdict(z, i10, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExecVerdict)) {
                return false;
            }
            ExecVerdict execVerdict = (ExecVerdict) obj;
            return this.canExecute == execVerdict.canExecute && this.errorCode == execVerdict.errorCode && g.b(this.reason, execVerdict.reason);
        }

        public final boolean getCanExecute() {
            return this.canExecute;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            int iD = a.d(this.errorCode, Boolean.hashCode(this.canExecute) * 31, 31);
            String str = this.reason;
            return iD + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean z = this.canExecute;
            int i10 = this.errorCode;
            String str = this.reason;
            StringBuilder sb2 = new StringBuilder("ExecVerdict(canExecute=");
            sb2.append(z);
            sb2.append(", errorCode=");
            sb2.append(i10);
            sb2.append(", reason=");
            return a.o(sb2, str, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.sla.SlaAbility", f = "SlaAbility.kt", l = {207, 207}, m = "collectFromAsrProtocol")
    /* renamed from: com.stepos.core.ability.sla.SlaAbility$collectFromAsrProtocol$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SlaAbility.this.collectFromAsrProtocol(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.sla.SlaAbility", f = "SlaAbility.kt", l = {244, 244}, m = "collectFromTextProtocol")
    /* renamed from: com.stepos.core.ability.sla.SlaAbility$collectFromTextProtocol$1, reason: invalid class name and case insensitive filesystem */
    public static final class C02951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02951(b<? super C02951> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SlaAbility.this.collectFromTextProtocol(null, null, this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ability.sla.SlaAbility$doFlowInfer$2", f = "SlaAbility.kt", l = {120, 123, 130, 147, 169}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ability.sla.SlaAbility$doFlowInfer$2, reason: invalid class name and case insensitive filesystem */
    public static final class C02972 extends SuspendLambda implements p<FlowCollector<? super Result<? extends d.q>>, b<? super n>, Object> {
        final /* synthetic */ c $input;
        final /* synthetic */ Object $record;
        long J$0;
        long J$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02972(c cVar, Object obj, b<? super C02972> bVar) {
            super(2, bVar);
            this.$input = cVar;
            this.$record = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            C02972 c02972 = SlaAbility.this.new C02972(this.$input, this.$record, bVar);
            c02972.L$0 = obj;
            return c02972;
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends d.q>> flowCollector, b<? super n> bVar) {
            return invoke2((FlowCollector<? super Result<d.q>>) flowCollector, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01ea  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instructions count: 760
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.sla.SlaAbility.C02972.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<d.q>> flowCollector, b<? super n> bVar) {
            return ((C02972) create(flowCollector, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaAbility(p6.a abilityConfig) {
        super(abilityConfig.f11416a, abilityConfig);
        g.f(abilityConfig, "abilityConfig");
        this.tag = "SlaAbility";
        this.lockStateProvider = LockStateProvider.Companion.getDEFAULT();
        this.lockScreenAllowed = l.s0(new String[]{"alarm_clock_add", "alarm_clock_get_current_time_by_city", "alarm_clock_timer_add", "dialer_add_group", "dialer_call_contact", "dialer_call_to", "dialer_contacts_add", "evaluate_expression", "get_current_location", "maps_weather", "open_flash_light", "weatherInfo", "phone_note_add", "phone_note_todo_add", "settings_adjust_display_size", "settings_adjust_font_size", "settings_adjust_sound", "settings_choose_wifi", "settings_config_hotspot", "settings_connect_wifi", "settings_set_brightness", "settings_set_media_sound", "settings_set_screen_off_time", "settings_get_airplane_mode_state", "settings_get_app_lock_state", "settings_get_auto_brightness_state", "settings_get_auto_rotation_state", "settings_get_battery_saver_state", "settings_get_bluetooth_state", "settings_get_charging_notif_sound_state", "settings_get_dark_mode_state", "settings_get_data_state", "settings_get_dialing_keypad_sound_state", "settings_get_hotspot_state", "settings_get_liftToCheck_phone_state", "settings_get_one_handed_mode_state", "settings_get_screen_lock_sound_state", "settings_get_screen_saver_state", "settings_get_tapToCheck_phone_state", "settings_get_touch_sound_state", "settings_get_vibration_state", "settings_get_wifi_state", "sms_auto_retrieve_mms", "sms_delivery_reports", "sms_notify_sound", "sms_notify_vibration", "sms_query", "sms_schedule_send", "sms_send", "sms_send_direct", "sms_send_sound", "sms_settings_auto_retrieval", "sms_settings_delivery_reports", "sms_settings_expired_pickup", "sms_settings_expired_veri", "sms_settings_intelligent_msg", "sms_settings_notif_detail", "sms_settings_risk_url"});
        this.slaUnsupported = l.s0(new String[]{"request_cloud_assist", "request_gui_assist"});
    }

    private final String audioSrc(c.a aVar) {
        String str = aVar.f13389e;
        if (str != null && !q.t0(str)) {
            return BundleContentBridge.KEY_PATH;
        }
        String str2 = aVar.f13388d;
        return (str2 == null || q.t0(str2)) ? "bytes" : "url";
    }

    private final String buildResult(String str, long j10, long j11, Map<String, String> map) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        SlaResultBuilder.MockDecision decisionText = parseDecisionText(str);
        long jElapsedMs = elapsedMs(jElapsedRealtimeNanos);
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.tag;
        String function = decisionText.getFunction();
        boolean fallback = decisionText.getFallback();
        StringBuilder sbO = a0.a.o("结果解析 parseMs=", jElapsedMs, "ms func=", function);
        sbO.append(" fallback=");
        sbO.append(fallback);
        AIEngineLogger.d(logModule, str2, sbO.toString());
        long jElapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos();
        AtomicDispatchResult atomicDispatchResultDispatchAtomic = dispatchAtomic(decisionText, map);
        long jElapsedMs2 = elapsedMs(jElapsedRealtimeNanos2);
        AIEngineLogger.d(logModule, this.tag, "原子能力调用 dispatchMs=" + jElapsedMs2 + "ms status=" + atomicDispatchResultDispatchAtomic.getStatus());
        long jElapsedMs3 = elapsedMs(j10);
        String str3 = this.tag;
        String function2 = decisionText.getFunction();
        boolean fallback2 = decisionText.getFallback();
        String executor = atomicDispatchResultDispatchAtomic.getExecutor();
        AtomicDispatchResult.Status status = atomicDispatchResultDispatchAtomic.getStatus();
        StringBuilder sbM = com.stepos.core.ota.d.m("doFlow done: function=", function2, " fallback=", " executor=", fallback2);
        sbM.append(executor);
        sbM.append(" status=");
        sbM.append(status);
        sbM.append(" modelInferMs=");
        sbM.append(j11);
        sbM.append(" totalMs=");
        sbM.append(jElapsedMs3);
        AIEngineLogger.i(logModule, str3, sbM.toString());
        SlaResultBuilder slaResultBuilder = SlaResultBuilder.INSTANCE;
        if (q.t0(str)) {
            str = null;
        }
        return slaResultBuilder.build(decisionText, atomicDispatchResultDispatchAtomic, str, jElapsedMs3, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r8).collect(r6, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectFromAsrProtocol(v6.c.a r6, java.lang.Object r7, qb.b<? super java.lang.String> r8) throws java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.core.ability.sla.SlaAbility.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.core.ability.sla.SlaAbility$collectFromAsrProtocol$1 r0 = (com.stepos.core.ability.sla.SlaAbility.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.sla.SlaAbility$collectFromAsrProtocol$1 r0 = new com.stepos.core.ability.sla.SlaAbility$collectFromAsrProtocol$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.c.b(r8)
            goto L76
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.c.b(r8)
            goto L64
        L3e:
            kotlin.c.b(r8)
            e7.e r8 = r5.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r2 = com.stepos.base.protocol.ProtocolType.f6380c
            e7.b r8 = r8.b(r2)
            e7.a r8 = (e7.a) r8
            if (r8 == 0) goto L88
            v6.c$a r5 = r5.ensurePcmBuffer(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r8.processAudio(r5, r7, r0)
            if (r8 != r1) goto L63
            goto L75
        L63:
            r5 = r6
        L64:
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
            com.stepos.core.ability.sla.SlaAbility$collectFromAsrProtocol$2 r6 = new com.stepos.core.ability.sla.SlaAbility$collectFromAsrProtocol$2
            r6.<init>()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r8.collect(r6, r0)
            if (r6 != r1) goto L76
        L75:
            return r1
        L76:
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.g.e(r5, r6)
            java.lang.CharSequence r5 = gc.q.L0(r5)
            java.lang.String r5 = r5.toString()
            return r5
        L88:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "AudioProtocol not bound to SlaAbility"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.sla.SlaAbility.collectFromAsrProtocol(v6.c$a, java.lang.Object, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object collectFromAsrProtocol$default(SlaAbility slaAbility, c.a aVar, Object obj, b bVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return slaAbility.collectFromAsrProtocol(aVar, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        if (((kotlinx.coroutines.flow.Flow) r9).collect(r7, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collectFromTextProtocol(v6.c.g r7, java.lang.Object r8, qb.b<? super java.lang.String> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.core.ability.sla.SlaAbility.C02951
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.core.ability.sla.SlaAbility$collectFromTextProtocol$1 r0 = (com.stepos.core.ability.sla.SlaAbility.C02951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ability.sla.SlaAbility$collectFromTextProtocol$1 r0 = new com.stepos.core.ability.sla.SlaAbility$collectFromTextProtocol$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            kotlin.c.b(r9)
            goto L7e
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.L$0
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            kotlin.c.b(r9)
            goto L6c
        L3e:
            kotlin.c.b(r9)
            e7.e r6 = r6.getProtocolManager()
            com.stepos.base.protocol.ProtocolType r9 = com.stepos.base.protocol.ProtocolType.f6380c
            e7.b r6 = r6.b(r9)
            e7.a r6 = (e7.a) r6
            if (r6 == 0) goto L98
            boolean r9 = r6 instanceof e7.h
            if (r9 == 0) goto L56
            e7.h r6 = (e7.h) r6
            goto L57
        L56:
            r6 = 0
        L57:
            if (r6 == 0) goto L90
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r6 = r6.processText(r7, r8, r0)
            if (r6 != r1) goto L69
            goto L7d
        L69:
            r5 = r9
            r9 = r6
            r6 = r5
        L6c:
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            com.stepos.core.ability.sla.SlaAbility$collectFromTextProtocol$2 r7 = new com.stepos.core.ability.sla.SlaAbility$collectFromTextProtocol$2
            r7.<init>()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r9.collect(r7, r0)
            if (r7 != r1) goto L7e
        L7d:
            return r1
        L7e:
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.g.e(r6, r7)
            java.lang.CharSequence r6 = gc.q.L0(r6)
            java.lang.String r6 = r6.toString()
            return r6
        L90:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "SLA model does not support text input (TextProtocol not implemented)"
            r6.<init>(r7)
            throw r6
        L98:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "SLA model not bound"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.sla.SlaAbility.collectFromTextProtocol(v6.c$g, java.lang.Object, qb.b):java.lang.Object");
    }

    public static /* synthetic */ Object collectFromTextProtocol$default(SlaAbility slaAbility, c.g gVar, Object obj, b bVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return slaAbility.collectFromTextProtocol(gVar, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectModelOutput(c cVar, Object obj, b<? super String> bVar) {
        if (cVar instanceof c.a) {
            return collectFromAsrProtocol((c.a) cVar, obj, bVar);
        }
        if (cVar instanceof c.g) {
            return collectFromTextProtocol((c.g) cVar, obj, bVar);
        }
        throw new IllegalArgumentException(a.k("SLA unsupported input type: ", i.a(cVar.getClass()).c()));
    }

    public static /* synthetic */ Object collectModelOutput$default(SlaAbility slaAbility, c cVar, Object obj, b bVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        return slaAbility.collectModelOutput(cVar, obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AtomicDispatchResult dispatchAtomic(SlaResultBuilder.MockDecision mockDecision, Map<String, String> map) {
        Object objA;
        String function = mockDecision.getFunction();
        if (mockDecision.getFallback() || function == null) {
            return new AtomicDispatchResult(ModelManifest.BACKEND_NONE, AtomicDispatchResult.Status.NOT_DISPATCHED, 0, null, null, 0L, 60, null);
        }
        IAtomicSdkClient iAtomicSdkClient = AtomicSdkClientFactory.INSTANCE.get();
        try {
            objA = iAtomicSdkClient.dispatch(new AtomicDispatchRequest(function, mockDecision.getText(), mockDecision.getParams(), mockDecision.getPriority(), map.isEmpty() ? null : map));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, this.tag, a.k("atomic dispatch threw: ", thB.getMessage()), thB);
            String executorId = iAtomicSdkClient.getExecutorId();
            AtomicDispatchResult.Status status = AtomicDispatchResult.Status.FAILED;
            String message = thB.getMessage();
            if (message == null) {
                message = thB.getClass().getSimpleName();
            }
            objA = new AtomicDispatchResult(executorId, status, -1, message, null, 0L, 48, null);
        }
        return (AtomicDispatchResult) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long elapsedMs(long j10) {
        return (SystemClock.elapsedRealtimeNanos() - j10) / 1000000;
    }

    private final c.a ensurePcmBuffer(c.a aVar) throws IOException {
        String str = aVar.f13389e;
        if (aVar.f13386b.length != 0) {
            return aVar;
        }
        if (str == null || q.t0(str)) {
            return aVar;
        }
        ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
        try {
            AsrAudioFileDecoder asrAudioFileDecoder = AsrAudioFileDecoder.INSTANCE;
            g.c(parcelFileDescriptorOpen);
            short[] sArrDecodeFromPfd = asrAudioFileDecoder.decodeFromPfd(parcelFileDescriptorOpen);
            parcelFileDescriptorOpen.close();
            AIEngineLogger.d(LogModule.ABILITY, this.tag, "lazy decode localPath -> samples=" + sArrDecodeFromPfd.length);
            return c.a.c(aVar, sArrDecodeFromPfd, null, null, null, null, 510);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExecVerdict evaluateExecutability(SlaResultBuilder.MockDecision mockDecision, boolean z) {
        String function = mockDecision.getFunction();
        return (mockDecision.getFallback() || function == null) ? new ExecVerdict(false, AIEngineError.SLA_NO_VALID_ACTION, "no valid action recognized") : this.slaUnsupported.contains(function) ? new ExecVerdict(false, AIEngineError.SLA_UNSUPPORTED, a0.a.k("function '", function, "' not supported by on-device SLA")) : (!z || this.lockScreenAllowed.contains(function)) ? new ExecVerdict(true, 0, null) : new ExecVerdict(false, AIEngineError.SLA_SCREEN_LOCKED, a0.a.k("screen locked, function '", function, "' not in lockscreen whitelist"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean executeAtomicFrom(c cVar) {
        Bundle bundle = cVar instanceof c.g ? ((c.g) cVar).f13418d : cVar instanceof c.a ? ((c.a) cVar).f13392i : null;
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("sla.executeAtomic", true);
    }

    private final SlaResultBuilder.MockDecision fallbackDecision(String str, String str2) {
        AIEngineLogger.w(LogModule.ABILITY, this.tag, a.l("decision fallback: reason=", str, " msg=", str2));
        return new SlaResultBuilder.MockDecision(null, "", kotlin.collections.b.d0(), null, 0.0f, EmptyList.f10001a, true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logInputArrival(c cVar) {
        if (cVar instanceof c.a) {
            LogModule logModule = LogModule.ABILITY;
            String str = this.tag;
            c.a aVar = (c.a) cVar;
            String strAudioSrc = audioSrc(aVar);
            int length = aVar.f13386b.length;
            int i10 = aVar.f13387c;
            StringBuilder sbF = e.f("文件到AIEngine src=", strAudioSrc, " samples=", length, " sampleRate=");
            sbF.append(i10);
            AIEngineLogger.d(logModule, str, sbF.toString());
            return;
        }
        if (cVar instanceof c.g) {
            AIEngineLogger.d(LogModule.ABILITY, this.tag, "文本到AIEngine len=" + ((c.g) cVar).f13416b.length());
            return;
        }
        AIEngineLogger.d(LogModule.ABILITY, this.tag, "输入到AIEngine type=" + i.a(cVar.getClass()).c());
    }

    private final Map<String, String> parseArgs(String str) {
        Pair pair;
        if (q.t0(str)) {
            return kotlin.collections.b.d0();
        }
        List<String> listE0 = q.E0(str, new char[]{'\n'});
        ArrayList arrayList = new ArrayList();
        for (String str2 : listE0) {
            int iQ0 = q.q0(str2, ':', 0, 6);
            if (iQ0 <= 0 || iQ0 == str2.length() - 1) {
                pair = null;
            } else {
                String strSubstring = str2.substring(0, iQ0);
                g.e(strSubstring, "substring(...)");
                String string = q.L0(strSubstring).toString();
                String strSubstring2 = str2.substring(iQ0 + 1);
                g.e(strSubstring2, "substring(...)");
                pair = new Pair(string, q.L0(strSubstring2).toString());
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return kotlin.collections.b.m0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SlaResultBuilder.MockDecision parseDecisionText(String str) {
        int i10;
        AIEngineLogger.d(LogModule.ABILITY, this.tag, "raw model output: len=" + str.length());
        if (q.t0(str)) {
            return fallbackDecision("NO_MATCH", "empty model output");
        }
        int iQ0 = q.q0(str, '<', 0, 6);
        int iQ02 = iQ0 >= 0 ? q.q0(str, '>', iQ0, 4) : -1;
        if (iQ0 < 0 || iQ02 <= (i10 = iQ0 + 1)) {
            return fallbackDecision("OUT_OF_DOMAIN", a.g(str.length(), "missing <function> in output (len=", ")"));
        }
        String strSubstring = str.substring(i10, iQ02);
        g.e(strSubstring, "substring(...)");
        String string = q.L0(strSubstring).toString();
        if (string.length() == 0) {
            return fallbackDecision("OUT_OF_DOMAIN", "empty function name");
        }
        String strSubstring2 = str.substring(iQ02 + 1);
        g.e(strSubstring2, "substring(...)");
        String string2 = q.L0(strSubstring2).toString();
        return new SlaResultBuilder.MockDecision(string, string2.length() > 0 ? a.l("<", string, ">", string2) : a0.a.k("<", string, ">"), parseArgs(string2), null, 1.0f, EmptyList.f10001a, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> slaArgsFrom(c cVar) {
        String string;
        Bundle bundle = cVar instanceof c.g ? ((c.g) cVar).f13418d : cVar instanceof c.a ? ((c.a) cVar).f13392i : null;
        if (bundle == null) {
            return kotlin.collections.b.d0();
        }
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            g.c(str);
            if (o.k0(str, "sla.arg.", false) && (string = bundle.getString(str)) != null) {
                map.put(q.z0(str, "sla.arg."), string);
            }
        }
        return map;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public Object doFlowInfer(c cVar, Object obj, b<? super Flow<Result<d.q>>> bVar) {
        return FlowKt.flow(new C02972(cVar, obj, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // com.stepos.base.ability.AbilityBase
    /* renamed from: doInfer-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo19doInfergIAlus(v6.c r15, qb.b<? super kotlin.Result<v6.d.q>> r16) {
        /*
            r14 = this;
            r0 = r16
            boolean r2 = r0 instanceof com.stepos.core.ability.sla.SlaAbility$doInfer$1
            if (r2 == 0) goto L16
            r2 = r0
            com.stepos.core.ability.sla.SlaAbility$doInfer$1 r2 = (com.stepos.core.ability.sla.SlaAbility$doInfer$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
        L14:
            r4 = r2
            goto L1c
        L16:
            com.stepos.core.ability.sla.SlaAbility$doInfer$1 r2 = new com.stepos.core.ability.sla.SlaAbility$doInfer$1
            r2.<init>(r14, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r4.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            long r1 = r4.J$0
            java.lang.Object r3 = r4.L$1
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r4 = r4.L$0
            com.stepos.core.ability.sla.SlaAbility r4 = (com.stepos.core.ability.sla.SlaAbility) r4
            kotlin.c.b(r0)     // Catch: java.lang.Throwable -> L35
            goto L64
        L35:
            r0 = move-exception
            goto L6f
        L37:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3f:
            kotlin.c.b(r0)
            long r8 = android.os.SystemClock.elapsedRealtimeNanos()
            r14.logInputArrival(r15)
            java.util.Map r10 = r14.slaArgsFrom(r15)
            r4.L$0 = r14     // Catch: java.lang.Throwable -> L6b
            r4.L$1 = r10     // Catch: java.lang.Throwable -> L6b
            r4.J$0 = r8     // Catch: java.lang.Throwable -> L6b
            r4.label = r3     // Catch: java.lang.Throwable -> L6b
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r14
            r2 = r15
            java.lang.Object r0 = collectModelOutput$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6b
            if (r0 != r7) goto L61
            return r7
        L61:
            r4 = r14
            r1 = r8
            r3 = r10
        L64:
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L35
        L66:
            r7 = r3
            r12 = r1
            r1 = r4
            r3 = r12
            goto L74
        L6b:
            r0 = move-exception
            r4 = r14
            r1 = r8
            r3 = r10
        L6f:
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
            goto L66
        L74:
            java.lang.Throwable r2 = kotlin.Result.b(r0)
            if (r2 != 0) goto Lae
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            long r5 = r1.elapsedMs(r3)
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r8 = r1.tag
            int r9 = r2.length()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "输入→模型输出 modelInferMs="
            r10.<init>(r11)
            r10.append(r5)
            java.lang.String r11 = "ms outLen="
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.stepos.core.common.log.AIEngineLogger.d(r0, r8, r9)
            java.lang.String r0 = r1.buildResult(r2, r3, r5, r7)
            v6.d$q r1 = new v6.d$q
            r2 = 6
            r3 = 0
            r1.<init>(r0, r3, r3, r2)
            return r1
        Lae:
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.ABILITY
            java.lang.String r1 = r1.tag
            java.lang.String r3 = r2.getMessage()
            java.lang.String r4 = "doInfer model output failed: "
            java.lang.String r3 = ai.onnxruntime.a.k(r4, r3)
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r2}
            com.stepos.core.common.log.AIEngineLogger.w(r0, r1, r3)
            kotlin.Result$Failure r0 = kotlin.c.a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.sla.SlaAbility.mo19doInfergIAlus(v6.c, qb.b):java.lang.Object");
    }

    @Override // p6.d
    public boolean supportsStreaming() {
        return true;
    }

    @Override // com.stepos.base.ability.AbilityBase
    public d.q defaultOutput() {
        return new d.q("", null, null, 6);
    }
}
