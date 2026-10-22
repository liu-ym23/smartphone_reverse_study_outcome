package com.stepos.aiengine.modelmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.y0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d0;
import androidx.lifecycle.j0;
import androidx.lifecycle.q;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.o;
import cb.t;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.aiengine.modelmanager.pref.ModelPreference;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.cta.CtaGateGuard;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import com.stepos.core.ota.confirmui.OtaAlertDialog;
import com.stepos.core.ota.d;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.domain.UserUninstallPolicy;
import com.stepos.core.ota.install.PreInstallModels;
import com.stepos.core.ota.process.OtaProcessClient;
import com.stepos.core.ota.process.OtaProcessConfig;
import com.stepos.core.ota.storage.UserUninstallStore;
import d.b;
import gc.r;
import h0.e;
import h6.f;
import h6.h;
import h6.j;
import h6.k;
import h6.s;
import h6.w;
import h6.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import mb.m;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManagerFragment extends PreferenceFragmentCompat {
    private static final String ARG_HIGHLIGHT_ABILITY = "highlight_ability";
    private static final String ARG_HIGHLIGHT_MODEL = "highlight_model";
    public static final a Companion = new a();
    private static final long DISPLAY_READY_DEBOUNCE_MS = 800;
    private static final long PAUSE_ACK_TIMEOUT_MS = 5000;
    private static final String PERF_SUBTAG = "OtaConfirmPerf";
    private static final long PRESET_FALLBACK_MS = 1500;
    private static final long PRESET_INSTALLED_DEBOUNCE_MS = 300;
    private static final long TOGGLE_COOLDOWN_MS = 500;
    private final b<Intent> ctaLauncher;
    private final HashMap<String, Integer> dataRefreshedAtVer;
    private ModelDisplayResourceStore.OnDisplayReadyListener displayReadyListener;
    private final Runnable displayReadyRefresh;
    private boolean editing;
    private final Runnable installedDataRefresh;
    private zb.a<n> pendingCtaAction;
    private String pendingCtaModelId;
    private String pendingHighlightModelId;
    private Runnable presetFallback;
    private final Runnable presetInstalledRefresh;
    private PreInstallModels.OnModelInstalledListener presetModelInstalledListener;
    private PreInstallModels.OnSettledListener presetSettledListener;
    private OtaAlertDialog uninstallDialog;
    private final ExecutorService io = Executors.newSingleThreadExecutor();
    private final Handler main = new Handler(Looper.getMainLooper());
    private List<s> lastRows = EmptyList.f10001a;
    private final HashMap<String, Long> lastToggleAtMs = new HashMap<>();
    private final HashMap<String, Long> pausePendingAtMs = new HashMap<>();
    private Map<String, x> latestSnaps = kotlin.collections.b.d0();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SnapApply {

        /* renamed from: a, reason: collision with root package name */
        public static final SnapApply f5862a;

        /* renamed from: b, reason: collision with root package name */
        public static final SnapApply f5863b;

        /* renamed from: c, reason: collision with root package name */
        public static final SnapApply f5864c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ SnapApply[] f5865d;

        static {
            SnapApply snapApply = new SnapApply("SKIPPED", 0);
            f5862a = snapApply;
            SnapApply snapApply2 = new SnapApply("APPLIED", 1);
            f5863b = snapApply2;
            SnapApply snapApply3 = new SnapApply("RESTRUCTURE", 2);
            f5864c = snapApply3;
            SnapApply[] snapApplyArr = {snapApply, snapApply2, snapApply3};
            f5865d = snapApplyArr;
            kotlin.enums.a.a(snapApplyArr);
        }

        public SnapApply() {
            throw null;
        }

        public static SnapApply valueOf(String str) {
            return (SnapApply) Enum.valueOf(SnapApply.class, str);
        }

        public static SnapApply[] values() {
            return (SnapApply[]) f5865d.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static final void a(a aVar, String str) {
            aVar.getClass();
            e.k("[DIAG] ", str, LogModule.OTA, "MMUpdate");
        }

        public static final void b(a aVar, String str, long j10, String str2, String str3) {
            aVar.getClass();
            if (str.length() == 0) {
                return;
            }
            AIEngineLogger.i(LogModule.OTA, ModelManagerFragment.PERF_SUBTAG, d.j(d.l("OCPERF tid=", SystemClock.elapsedRealtime() - j10, str, " +"), "ms stage=", str2, " ", str3));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.aiengine.modelmanager.ModelManagerFragment$onViewCreated$2", f = "ModelManagerFragment.kt", l = {218}, m = "invokeSuspend")
    /* renamed from: com.stepos.aiengine.modelmanager.ModelManagerFragment$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5866a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @c(c = "com.stepos.aiengine.modelmanager.ModelManagerFragment$onViewCreated$2$1", f = "ModelManagerFragment.kt", l = {221}, m = "invokeSuspend")
        /* renamed from: com.stepos.aiengine.modelmanager.ModelManagerFragment$onViewCreated$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5868a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ModelManagerFragment f5869b;

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            /* renamed from: com.stepos.aiengine.modelmanager.ModelManagerFragment$onViewCreated$2$1$a */
            public static final class a<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ModelManagerFragment f5870a;

                public a(ModelManagerFragment modelManagerFragment) {
                    this.f5870a = modelManagerFragment;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, qb.b bVar) {
                    this.f5870a.applyState((Map) obj);
                    return n.f10413a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelManagerFragment modelManagerFragment, qb.b<? super AnonymousClass1> bVar) {
                super(2, bVar);
                this.f5869b = modelManagerFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final qb.b<n> create(Object obj, qb.b<?> bVar) {
                return new AnonymousClass1(this.f5869b, bVar);
            }

            @Override // zb.p
            public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
                return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
                int i10 = this.f5868a;
                if (i10 == 0) {
                    kotlin.c.b(obj);
                    OtaModelClient.f5871a.getClass();
                    Flow flowConflate = FlowKt.conflate(OtaModelClient.l());
                    a aVar = new a(this.f5869b);
                    this.f5868a = 1;
                    if (flowConflate.collect(aVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.c.b(obj);
                }
                return n.f10413a;
            }
        }

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return ModelManagerFragment.this.new AnonymousClass2(bVar);
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.f5866a;
            if (i10 == 0) {
                kotlin.c.b(obj);
                ModelManagerFragment modelManagerFragment = ModelManagerFragment.this;
                q viewLifecycleOwner = modelManagerFragment.getViewLifecycleOwner();
                g.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.f2214a;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(modelManagerFragment, null);
                this.f5866a = 1;
                if (d0.a(viewLifecycleOwner, anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            return n.f10413a;
        }
    }

    public ModelManagerFragment() {
        b<Intent> bVarRegisterForActivityResult = registerForActivityResult(new e.c(), new k(this));
        g.e(bVarRegisterForActivityResult, "registerForActivityResult(...)");
        this.ctaLauncher = bVarRegisterForActivityResult;
        this.presetInstalledRefresh = new j(this, 2);
        this.displayReadyRefresh = new y0(this, 10);
        this.dataRefreshedAtVer = new HashMap<>();
        this.installedDataRefresh = new j(this, 3);
    }

    private final boolean acceptToggle(String str, String str2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l10 = this.lastToggleAtMs.get(str);
        long jLongValue = jElapsedRealtime - (l10 != null ? l10.longValue() : 0L);
        if (jLongValue >= 500) {
            this.lastToggleAtMs.put(str, Long.valueOf(jElapsedRealtime));
            return true;
        }
        a aVar = Companion;
        StringBuilder sbS = ai.onnxruntime.a.s("onPrimary branch=", str2, " modelId=", str, " ignored (cooldown ");
        sbS.append(jLongValue);
        sbS.append("ms < 500ms)");
        a.a(aVar, sbS.toString());
        return false;
    }

    private final void addGroup(PreferenceScreen preferenceScreen, int i10, List<s> list) {
        ModelManagerFragment modelManagerFragment = this;
        if (list.isEmpty()) {
            return;
        }
        PreferenceCategory preferenceCategory = new PreferenceCategory(modelManagerFragment.requireContext(), null);
        String string = modelManagerFragment.getString(i10);
        if (!TextUtils.equals(string, preferenceCategory.f2353k)) {
            preferenceCategory.f2353k = string;
            preferenceCategory.j();
        }
        preferenceCategory.I = R.layout.pref_category;
        preferenceCategory.f2363v = false;
        if (preferenceCategory.F) {
            preferenceCategory.F = false;
            preferenceCategory.j();
        }
        preferenceScreen.B(preferenceCategory);
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                m.f0();
                throw null;
            }
            s sVar = (s) obj;
            Context contextRequireContext = modelManagerFragment.requireContext();
            g.e(contextRequireContext, "requireContext(...)");
            boolean z = modelManagerFragment.editing;
            int size = list.size();
            ModelManagerFragment$addGroup$1$1 modelManagerFragment$addGroup$1$1 = new ModelManagerFragment$addGroup$1$1(1, modelManagerFragment, ModelManagerFragment.class, "onPrimaryAction", "onPrimaryAction(Lcom/stepos/aiengine/modelmanager/ModelRow;)V", 0);
            modelManagerFragment = this;
            preferenceCategory.B(new ModelPreference(contextRequireContext, sVar, z, i11, size, modelManagerFragment$addGroup$1$1, new ModelManagerFragment$addGroup$1$2(1, modelManagerFragment, ModelManagerFragment.class, "onUninstall", "onUninstall(Lcom/stepos/aiengine/modelmanager/ModelRow;)V", 0)));
            i11 = i12;
        }
    }

    private final Context appContextOrNull() {
        Context context = getContext();
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    private final void applyRows(List<s> list) {
        if (getPreferenceScreen() == null || !g.b(onScreenStructureSig(), structureSig(list))) {
            this.lastRows = list;
            render(list);
            return;
        }
        a.a(Companion, "applyRows: in-place update n=" + list.size());
        for (s sVar : list) {
            ModelPreference modelPreferenceFindPref = findPref(sVar.f9339b);
            if (modelPreferenceFindPref != null) {
                modelPreferenceFindPref.W = sVar;
                modelPreferenceFindPref.j();
            }
        }
        this.lastRows = list;
        toggleEmpty(list.isEmpty());
        scrollToHighlightIfReady();
    }

    private final SnapApply applySnapToRow(s sVar, x xVar) {
        boolean zShouldShowInList = shouldShowInList(sVar);
        ModelGroup modelGroupB = sVar.b();
        String otaId = sVar.f9339b;
        int i10 = xVar.f9357b;
        int i11 = xVar.f9359d;
        if (i10 != 1 && i10 != 2 && i10 != 5) {
            this.pausePendingAtMs.remove(otaId);
        }
        if (i10 == 7) {
            w.f9354a.getClass();
            g.f(otaId, "otaId");
            w.f9355b.remove(otaId);
            sVar.f9343f = 1;
            sVar.f9345i = -1;
            sVar.f9344g = 0;
        } else {
            if (i10 != 6) {
                if (!xVar.f9360e) {
                    w.f9354a.getClass();
                    g.f(otaId, "otaId");
                    if (w.b(otaId)) {
                        if ((i10 == 3 || i10 == 4) && w.d(otaId)) {
                            return SnapApply.f5862a;
                        }
                        if ((i10 == 4 || i10 == 3) && sVar.f9343f == 2) {
                            sVar.f9345i = -1;
                            sVar.f9344g = 0;
                        } else {
                            if (isPauseAckPending(otaId)) {
                                return SnapApply.f5862a;
                            }
                            sVar.f9345i = i10;
                            sVar.f9344g = i10 == 5 ? 100 : xVar.f9358c;
                            if (i10 == 1 || i10 == 2 || i10 == 5) {
                                OtaModelClient.f5871a.getClass();
                                OtaModelClient.c(otaId);
                            }
                        }
                    }
                }
                int i12 = sVar.f9345i;
                if (i12 == 1 || i12 == 2 || i12 == 5 || i12 == 4 || i12 == 3) {
                    sVar.f9345i = -1;
                    sVar.f9344g = 0;
                }
                return SnapApply.f5862a;
            }
            if (!UserUninstallPolicy.INSTANCE.acceptInstalledOverlay(UserUninstallStore.INSTANCE.contains(otaId))) {
                w.f9354a.getClass();
                g.f(otaId, "otaId");
                w.f9355b.remove(otaId);
                sVar.f9343f = 1;
                sVar.f9345i = -1;
                sVar.f9344g = 0;
                return (shouldShowInList(sVar) == zShouldShowInList && sVar.b() == modelGroupB) ? SnapApply.f5863b : SnapApply.f5864c;
            }
            w.f9354a.getClass();
            g.f(otaId, "otaId");
            w.f9355b.remove(otaId);
            int i13 = sVar.f9346j;
            boolean z = i13 > 0 && 1 <= i11 && i11 < i13;
            boolean z3 = sVar.f9343f == 3;
            sVar.f9343f = z ? 3 : 2;
            sVar.f9345i = -1;
            sVar.f9344g = 0;
            if (z3 && !z) {
                scheduleInstalledDataRefresh(otaId, i11);
            }
        }
        return (sVar.b() == modelGroupB && shouldShowInList(sVar) == zShouldShowInList) ? SnapApply.f5863b : SnapApply.f5864c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyState(Map<String, x> map) {
        this.latestSnaps = map;
        if (isAdded()) {
            boolean z = false;
            boolean z3 = false;
            for (s sVar : this.lastRows) {
                x xVar = map.get(sVar.f9339b);
                if (xVar != null) {
                    int i10 = sVar.f9343f;
                    int iOrdinal = applySnapToRow(sVar, xVar).ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            ModelPreference modelPreferenceFindPref = findPref(sVar.f9339b);
                            if (modelPreferenceFindPref != null) {
                                modelPreferenceFindPref.j();
                            }
                        } else {
                            if (iOrdinal != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            z = true;
                        }
                    }
                    if (sVar.f9343f != i10) {
                        z3 = true;
                    }
                }
            }
            if (z) {
                render(this.lastRows);
            }
            if (z3) {
                persistRowsCache();
            }
        }
    }

    private final void cancelPresetFallback() {
        Runnable runnable = this.presetFallback;
        if (runnable != null) {
            this.main.removeCallbacks(runnable);
        }
        this.presetFallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ctaLauncher$lambda$1(ModelManagerFragment modelManagerFragment, ActivityResult result) {
        g.f(result, "result");
        zb.a<n> aVar = modelManagerFragment.pendingCtaAction;
        String str = modelManagerFragment.pendingCtaModelId;
        modelManagerFragment.pendingCtaAction = null;
        modelManagerFragment.pendingCtaModelId = null;
        if (result.getResultCode() == -1 || CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            if (aVar != null) {
                aVar.invoke();
                return;
            }
            return;
        }
        a.a(Companion, "cta denied modelId=" + str + " -> release gate");
        if (str != null) {
            OtaModelClient.f5871a.getClass();
            OtaModelClient.c(str);
        }
        String string = modelManagerFragment.getString(R.string.mm_cta_denied);
        g.e(string, "getString(...)");
        modelManagerFragment.toast(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayReadyRefresh$lambda$3(ModelManagerFragment modelManagerFragment) {
        if (modelManagerFragment.isAdded()) {
            modelManagerFragment.refreshRowsInPlace();
        }
    }

    private final void doPause(s sVar) {
        Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull == null) {
            return;
        }
        this.pausePendingAtMs.put(sVar.f9339b, Long.valueOf(SystemClock.elapsedRealtime()));
        sVar.f9345i = 4;
        ModelPreference modelPreferenceFindPref = findPref(sVar.f9339b);
        if (modelPreferenceFindPref != null) {
            modelPreferenceFindPref.j();
        }
        this.io.execute(new o(12, contextAppContextOrNull, sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doPause$lambda$53(Context context, s sVar) {
        OtaModelClient otaModelClient = OtaModelClient.f5871a;
        String modelId = sVar.f9339b;
        otaModelClient.getClass();
        g.f(context, "context");
        g.f(modelId, "modelId");
        try {
            ModelConfirmFlow.Companion.markDetachedFromExternalControl(modelId);
            OtaModelClient.c(modelId);
            IOtaDeepBinderService iOtaDeepBinderServiceK = otaModelClient.k();
            if (iOtaDeepBinderServiceK != null) {
                iOtaDeepBinderServiceK.pauseDownload(modelId);
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    private final void doRetry(s sVar) {
        Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull == null) {
            return;
        }
        this.pausePendingAtMs.remove(sVar.f9339b);
        this.io.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(sVar, this, contextAppContextOrNull, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doRetry$lambda$48(s sVar, ModelManagerFragment modelManagerFragment, Context context) {
        Object objA;
        try {
            OtaModelClient.f5871a.i(context, sVar.f9343f == 3, sVar.f9339b, sVar.f9340c);
            objA = Boolean.TRUE;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            modelManagerFragment.main.post(new j(modelManagerFragment, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doRetry$lambda$48$lambda$47(ModelManagerFragment modelManagerFragment) {
        String string = modelManagerFragment.getString(R.string.mm_start_failed);
        g.e(string, "getString(...)");
        modelManagerFragment.toast(string);
    }

    private final void doStartOrResume(final s sVar, final boolean z, final String str, final long j10) {
        HashMap<String, Long> map = this.pausePendingAtMs;
        String str2 = sVar.f9339b;
        map.remove(str2);
        final Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull != null) {
            a.b(Companion, str, j10, "CTA_GRANTED_DISPATCH", ai.onnxruntime.a.k("modelId=", str2));
            this.io.execute(new Runnable() { // from class: h6.l
                @Override // java.lang.Runnable
                public final void run() {
                    ModelManagerFragment.doStartOrResume$lambda$52(str, j10, sVar, this, z, contextAppContextOrNull);
                }
            });
        } else {
            if (z) {
                return;
            }
            a.a(Companion, "doStartOrResume: null context, release gate modelId=" + str2);
            OtaModelClient.f5871a.getClass();
            OtaModelClient.c(str2);
        }
    }

    public static /* synthetic */ void doStartOrResume$default(ModelManagerFragment modelManagerFragment, s sVar, boolean z, String str, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i10 & 8) != 0) {
            j10 = 0;
        }
        modelManagerFragment.doStartOrResume(sVar, z, str2, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doStartOrResume$lambda$52(String str, long j10, s sVar, ModelManagerFragment modelManagerFragment, boolean z, Context context) {
        Object objA;
        a aVar = Companion;
        String modelId = sVar.f9339b;
        String displayName = sVar.f9340c;
        a.b(aVar, str, j10, "IO_ENTER", ai.onnxruntime.a.k("modelId=", modelId));
        try {
            if (z) {
                OtaModelClient otaModelClient = OtaModelClient.f5871a;
                otaModelClient.getClass();
                g.f(context, "context");
                g.f(modelId, "modelId");
                g.f(displayName, "displayName");
                otaModelClient.e(context, modelId, false, ModelConfirmFlow.Mode.DOWNLOAD, displayName);
            } else if (sVar.f9343f == 3) {
                OtaModelClient otaModelClient2 = OtaModelClient.f5871a;
                otaModelClient2.getClass();
                g.f(context, "context");
                g.f(modelId, "modelId");
                g.f(displayName, "displayName");
                otaModelClient2.d(context, modelId, ModelConfirmFlow.Mode.UPDATE, str, j10, displayName);
            } else {
                OtaModelClient otaModelClient3 = OtaModelClient.f5871a;
                otaModelClient3.getClass();
                g.f(context, "context");
                g.f(modelId, "modelId");
                g.f(displayName, "displayName");
                otaModelClient3.d(context, modelId, ModelConfirmFlow.Mode.DOWNLOAD, str, j10, displayName);
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            modelManagerFragment.main.post(new j(modelManagerFragment, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doStartOrResume$lambda$52$lambda$51(ModelManagerFragment modelManagerFragment) {
        String string = modelManagerFragment.getString(R.string.mm_start_failed);
        g.e(string, "getString(...)");
        modelManagerFragment.toast(string);
    }

    private final void ensureCta(String str, zb.a<n> aVar) {
        Object objA;
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            aVar.invoke();
            return;
        }
        this.pendingCtaModelId = str;
        this.pendingCtaAction = aVar;
        try {
            b<Intent> bVar = this.ctaLauncher;
            CtaGateGuard ctaGateGuard = CtaGateGuard.INSTANCE;
            Context contextRequireContext = requireContext();
            g.e(contextRequireContext, "requireContext(...)");
            bVar.a(ctaGateGuard.createPolicyIntent(contextRequireContext));
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (Result.b(objA) != null) {
            a.a(Companion, "ensureCta launch failed modelId=" + str + " -> release gate");
            this.pendingCtaAction = null;
            this.pendingCtaModelId = null;
            if (str != null) {
                OtaModelClient.f5871a.getClass();
                OtaModelClient.c(str);
            }
            String string = getString(R.string.mm_cta_denied);
            g.e(string, "getString(...)");
            toast(string);
        }
    }

    public static /* synthetic */ void ensureCta$default(ModelManagerFragment modelManagerFragment, String str, zb.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        modelManagerFragment.ensureCta(str, aVar);
    }

    private final ModelPreference findPref(String str) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            return (ModelPreference) preferenceScreen.C(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installedDataRefresh$lambda$4(ModelManagerFragment modelManagerFragment) {
        if (modelManagerFragment.isAdded()) {
            modelManagerFragment.refreshRowsInPlace();
        }
    }

    private final boolean isPauseAckPending(String str) {
        Long l10 = this.pausePendingAtMs.get(str);
        if (l10 != null) {
            if (SystemClock.elapsedRealtime() - l10.longValue() < 5000) {
                return true;
            }
            this.pausePendingAtMs.remove(str);
            a.a(Companion, "pause ack timeout modelId=" + str + " -> accept live state");
        }
        return false;
    }

    private final List<s> mergeLiveState(List<s> list) {
        for (s sVar : list) {
            x xVar = this.latestSnaps.get(sVar.f9339b);
            if (xVar != null) {
                applySnapToRow(sVar, xVar);
            }
        }
        return list;
    }

    private final List<s> nonPresetRowsForDisplay(List<s> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((s) obj).b() == ModelGroup.f5844b) {
                arrayList.add(obj);
            }
        }
        if (!this.editing) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            int i11 = ((s) obj2).f9343f;
            if (i11 == 2 || i11 == 3) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConfirmFlowEnded(String str, int i10) {
        if (isAdded()) {
            if (i10 == -3) {
                revealRow(str);
                return;
            }
            if (i10 == -2) {
                refreshRowsInPlace();
                return;
            }
            if (i10 == -1) {
                String string = getString(R.string.mm_already_up_to_date);
                g.e(string, "getString(...)");
                toast(string);
                refreshRowsInPlace();
                return;
            }
            if (i10 == 5001) {
                String string2 = getString(R.string.mm_update_no_network);
                g.e(string2, "getString(...)");
                toast(string2);
                return;
            }
            if (i10 == 5901) {
                String string3 = getString(R.string.mm_service_unavailable);
                g.e(string3, "getString(...)");
                toast(string3);
                return;
            }
            switch (i10) {
                case 5003:
                    String string4 = getString(R.string.mm_already_up_to_date);
                    g.e(string4, "getString(...)");
                    toast(string4);
                    reload(false);
                    break;
                case 5004:
                case 5005:
                    String string5 = getString(R.string.mm_start_failed);
                    g.e(string5, "getString(...)");
                    toast(string5);
                    break;
                default:
                    switch (i10) {
                        case 5101:
                        case 5102:
                        case 5103:
                            String otaId = OtaEngine.INSTANCE.resolveAnyToOta(str);
                            g.f(otaId, "otaId");
                            w.f9354a.getClass();
                            if (w.d(otaId)) {
                                String string6 = getString(R.string.mm_state_failed);
                                g.e(string6, "getString(...)");
                                toast(string6);
                                break;
                            }
                            break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPrimaryAction(final s row) {
        PrimaryBranch primaryBranch;
        g.f(row, "row");
        String str = row.f9339b;
        if (row.c()) {
            primaryBranch = PrimaryBranch.f5891a;
        } else {
            int i10 = row.f9345i;
            primaryBranch = i10 == 4 ? PrimaryBranch.f5892b : i10 == 3 ? PrimaryBranch.f5893c : row.f9343f == 3 ? PrimaryBranch.f5894d : PrimaryBranch.f5895e;
        }
        int iOrdinal = primaryBranch.ordinal();
        if (iOrdinal == 0) {
            if (acceptToggle(str, "PAUSE")) {
                a.a(Companion, "onPrimary branch=PAUSE modelId=" + str);
                doPause(row);
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            if (acceptToggle(str, "RESUME")) {
                a.a(Companion, "onPrimary branch=RESUME modelId=" + str);
                ensureCta$default(this, null, new cb.d(11, this, row), 1, null);
                return;
            }
            return;
        }
        if (iOrdinal == 2) {
            a.a(Companion, "onPrimary branch=RETRY modelId=" + str);
            ensureCta$default(this, null, new h(this, row, 0), 1, null);
            return;
        }
        if (iOrdinal != 3 && iOrdinal != 4) {
            throw new NoWhenBranchMatchedException();
        }
        boolean z = row.f9343f == 3;
        a aVar = Companion;
        aVar.getClass();
        String hexString = Long.toHexString(SystemClock.elapsedRealtimeNanos());
        g.e(hexString, "toHexString(...)");
        final String strS0 = r.S0(6, hexString);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = z ? "UPDATE" : "DOWNLOAD";
        int i11 = row.f9343f;
        StringBuilder sbS = ai.onnxruntime.a.s("branch=", str2, " modelId=", str, " installStatus=");
        sbS.append(i11);
        a.b(aVar, strS0, jElapsedRealtime, "CLICK", sbS.toString());
        String str3 = z ? "UPDATE" : "DOWNLOAD";
        int i12 = row.f9343f;
        StringBuilder sbS2 = ai.onnxruntime.a.s("onPrimary branch=", str3, " modelId=", str, " installStatus=");
        sbS2.append(i12);
        a.a(aVar, sbS2.toString());
        OtaModelClient.f5871a.getClass();
        if (OtaModelClient.m(str)) {
            a.b(aVar, strS0, jElapsedRealtime, "GATE_PASS", "modelId=".concat(str));
            ensureCta(str, new zb.a() { // from class: h6.i
                @Override // zb.a
                public final Object invoke() {
                    return ModelManagerFragment.onPrimaryAction$lambda$45(this.f9316a, row, strS0, jElapsedRealtime);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onPrimaryAction$lambda$43(ModelManagerFragment modelManagerFragment, s sVar) {
        doStartOrResume$default(modelManagerFragment, sVar, true, null, 0L, 12, null);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onPrimaryAction$lambda$44(ModelManagerFragment modelManagerFragment, s sVar) {
        modelManagerFragment.doRetry(sVar);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onPrimaryAction$lambda$45(ModelManagerFragment modelManagerFragment, s sVar, String str, long j10) {
        modelManagerFragment.doStartOrResume(sVar, false, str, j10);
        return n.f10413a;
    }

    private final List<String> onScreenStructureSig() {
        String str;
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen == null) {
            return EmptyList.f10001a;
        }
        String string = getString(R.string.mm_group_preset);
        g.e(string, "getString(...)");
        ArrayList arrayList = new ArrayList();
        int size = preferenceScreen.T.size();
        for (int i10 = 0; i10 < size; i10++) {
            Preference preferenceD = preferenceScreen.D(i10);
            PreferenceCategory preferenceCategory = preferenceD instanceof PreferenceCategory ? (PreferenceCategory) preferenceD : null;
            if (preferenceCategory != null) {
                String str2 = g.b(preferenceCategory.f2353k, string) ? "P:" : "N:";
                int size2 = preferenceCategory.T.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    Preference preferenceD2 = preferenceCategory.D(i11);
                    if (preferenceD2 != null && (str = preferenceD2.f2357o) != null) {
                        arrayList.add(str2.concat(str));
                    }
                }
            }
        }
        return kotlin.collections.a.H0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUninstall(s sVar) {
        androidx.fragment.app.o activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        String str = sVar.f9340c;
        if (str.length() == 0) {
            str = sVar.f9339b;
        }
        OtaAlertDialog otaAlertDialog = this.uninstallDialog;
        if (otaAlertDialog != null) {
            if (!otaAlertDialog.isShowing()) {
                otaAlertDialog = null;
            }
            if (otaAlertDialog != null) {
                otaAlertDialog.dismiss();
            }
        }
        OtaAlertDialog otaAlertDialogCreate = new OtaAlertDialog.Builder(activity).setTitle(getString(R.string.mm_uninstall_confirm_title, str)).setMessage(getString(R.string.mm_uninstall_confirm_msg)).setButtonsHorizontal(true).addButton(R.string.mm_uninstall_confirm_cancel, OtaAlertDialog.ButtonStyle.NORMAL, new com.stepos.cpuset.c(6)).addButton(R.string.mm_uninstall_confirm_ok, OtaAlertDialog.ButtonStyle.DESTRUCTIVE, new h(this, sVar, 1)).setCancelable(false).create();
        otaAlertDialogCreate.show();
        this.uninstallDialog = otaAlertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onUninstall$lambda$57(ModelManagerFragment modelManagerFragment, s sVar) {
        modelManagerFragment.performUninstall(sVar.f9339b);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10$lambda$9(String reqId) {
        OtaModelClient.f5871a.getClass();
        g.f(reqId, "reqId");
        ConfirmUiRequest confirmUiRequestRemove = OtaModelClient.f5880k.remove(reqId);
        if (confirmUiRequestRemove == null) {
            return;
        }
        OtaModelClient.f5879j.show(confirmUiRequestRemove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12(ModelManagerFragment modelManagerFragment) {
        modelManagerFragment.main.post(new j(modelManagerFragment, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$12$lambda$11(ModelManagerFragment modelManagerFragment) {
        if (modelManagerFragment.isAdded()) {
            modelManagerFragment.refreshRowsInPlace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$14(ModelManagerFragment modelManagerFragment, String it) {
        g.f(it, "it");
        modelManagerFragment.main.removeCallbacks(modelManagerFragment.presetInstalledRefresh);
        modelManagerFragment.main.postDelayed(modelManagerFragment.presetInstalledRefresh, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$16(ModelManagerFragment modelManagerFragment, String it) {
        g.f(it, "it");
        modelManagerFragment.main.removeCallbacks(modelManagerFragment.displayReadyRefresh);
        modelManagerFragment.main.postDelayed(modelManagerFragment.displayReadyRefresh, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(ModelManagerFragment modelManagerFragment, String modelId, int i10) {
        g.f(modelId, "modelId");
        modelManagerFragment.main.post(new b.m(modelManagerFragment, modelId, i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void performUninstall(final java.lang.String r11) {
        /*
            r10 = this;
            android.content.Context r1 = r10.appContextOrNull()
            if (r1 != 0) goto L7
            return
        L7:
            com.stepos.core.ota.OtaEngine r0 = com.stepos.core.ota.OtaEngine.INSTANCE
            java.lang.String r3 = r0.resolveAnyToOta(r11)
            java.util.List<h6.s> r0 = r10.lastRows
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L31
            java.lang.Object r2 = r0.next()
            r4 = r2
            h6.s r4 = (h6.s) r4
            java.lang.String r4 = r4.f9339b
            boolean r4 = kotlin.jvm.internal.g.b(r4, r3)
            if (r4 == 0) goto L18
            r5.add(r2)
            goto L18
        L31:
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = mb.m.Z(r5, r0)
            r6.<init>(r0)
            int r0 = r5.size()
            r2 = 0
            r4 = r2
        L42:
            if (r4 >= r0) goto L5a
            java.lang.Object r7 = r5.get(r4)
            int r4 = r4 + 1
            h6.s r7 = (h6.s) r7
            int r8 = r7.f9343f
            int r9 = r7.f9345i
            int r7 = r7.f9344g
            int[] r7 = new int[]{r8, r9, r7}
            r6.add(r7)
            goto L42
        L5a:
            java.util.Map<java.lang.String, h6.x> r0 = r10.latestSnaps
            java.util.Map r0 = kotlin.collections.b.h0(r3, r0)
            r10.latestSnaps = r0
            int r0 = r5.size()
            r4 = r2
        L67:
            if (r4 >= r0) goto L7a
            java.lang.Object r7 = r5.get(r4)
            int r4 = r4 + 1
            h6.s r7 = (h6.s) r7
            r8 = 1
            r7.f9343f = r8
            r8 = -1
            r7.f9345i = r8
            r7.f9344g = r2
            goto L67
        L7a:
            java.util.List<h6.s> r0 = r10.lastRows
            java.util.List r0 = r10.structureSig(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "P:"
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto Lb5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "N:"
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto La9
            goto Lb5
        La9:
            boolean r0 = r10.removeRowFromScreen(r3)
            if (r0 != 0) goto Ld3
            java.util.List<h6.s> r0 = r10.lastRows
            r10.render(r0)
            goto Ld3
        Lb5:
            java.lang.Object r0 = kotlin.collections.a.v0(r5)
            h6.s r0 = (h6.s) r0
            if (r0 == 0) goto Lce
            com.stepos.aiengine.modelmanager.pref.ModelPreference r2 = r10.findPref(r3)
            if (r2 == 0) goto Lcb
            r2.W = r0
            r2.j()
            lb.n r0 = lb.n.f10413a
            goto Lcc
        Lcb:
            r0 = 0
        Lcc:
            if (r0 != 0) goto Ld3
        Lce:
            java.util.List<h6.s> r0 = r10.lastRows
            r10.render(r0)
        Ld3:
            r10.persistRowsCache()
            java.util.concurrent.ExecutorService r7 = r10.io
            h6.q r0 = new h6.q
            r4 = r10
            r2 = r11
            r0.<init>()
            r7.execute(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.modelmanager.ModelManagerFragment.performUninstall(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performUninstall$lambda$66(Context context, String modelId, String modelName, ModelManagerFragment modelManagerFragment, List list, List list2) {
        Object objA;
        OtaModelClient otaModelClient = OtaModelClient.f5871a;
        otaModelClient.getClass();
        g.f(context, "context");
        g.f(modelId, "modelId");
        try {
            IOtaDeepBinderService iOtaDeepBinderServiceK = otaModelClient.k();
            objA = Boolean.valueOf(iOtaDeepBinderServiceK != null ? iOtaDeepBinderServiceK.uninstall(modelId) : false);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        n6.a.f10642a.getClass();
        g.f(modelName, "modelName");
        n6.a.a("model_delete_complete", kotlin.collections.b.g0(new Pair("result", zBooleanValue ? "success" : "fail"), new Pair("model_name", modelName)));
        modelManagerFragment.main.post(new h6.g(modelManagerFragment, zBooleanValue, list, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performUninstall$lambda$66$lambda$65(ModelManagerFragment modelManagerFragment, boolean z, List list, List list2) {
        if (modelManagerFragment.isAdded()) {
            if (!z) {
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        m.f0();
                        throw null;
                    }
                    s sVar = (s) obj;
                    sVar.f9343f = ((int[]) list2.get(i10))[0];
                    sVar.f9345i = ((int[]) list2.get(i10))[1];
                    sVar.f9344g = ((int[]) list2.get(i10))[2];
                    i10 = i11;
                }
                modelManagerFragment.render(modelManagerFragment.lastRows);
                modelManagerFragment.persistRowsCache();
                String string = modelManagerFragment.getString(R.string.mm_uninstall_failed);
                g.e(string, "getString(...)");
                modelManagerFragment.toast(string);
            }
            if (z) {
                modelManagerFragment.refreshRowsInPlace();
            }
        }
    }

    private final void persistRowsCache() {
        Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull == null) {
            return;
        }
        List<s> list = this.lastRows;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(s.a((s) it.next(), null, null, 2047));
        }
        this.io.execute(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(this, contextAppContextOrNull, arrayList, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void persistRowsCache$lambda$69(ModelManagerFragment modelManagerFragment, Context context, List list) {
        try {
            OtaModelClient.f5871a.getClass();
            OtaModelClient.j(context, list);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presetInstalledRefresh$lambda$2(ModelManagerFragment modelManagerFragment) {
        if (modelManagerFragment.isAdded()) {
            modelManagerFragment.refreshRowsInPlace();
        }
    }

    private final void refreshRowsInPlace() {
        Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull == null) {
            return;
        }
        this.io.execute(new o(13, contextAppContextOrNull, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRowsInPlace$lambda$29(Context context, ModelManagerFragment modelManagerFragment) {
        OtaModelClient otaModelClient = OtaModelClient.f5871a;
        otaModelClient.getClass();
        g.f(context, "context");
        List listF = otaModelClient.k() != null ? otaModelClient.f(context, "getAvailableModelsForce", new com.stepos.core.common.cloud.d(27)) : EmptyList.f10001a;
        if (!listF.isEmpty()) {
            OtaModelClient.j(context, listF);
        }
        modelManagerFragment.main.post(new f(modelManagerFragment, listF, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRowsInPlace$lambda$29$lambda$28(ModelManagerFragment modelManagerFragment, List list) {
        if (modelManagerFragment.isAdded() && !list.isEmpty()) {
            modelManagerFragment.applyRows(modelManagerFragment.mergeLiveState(list));
        }
    }

    private final void reload(boolean z) {
        Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull == null) {
            return;
        }
        this.io.execute(new t(z, contextAppContextOrNull, this));
    }

    public static /* synthetic */ void reload$default(ModelManagerFragment modelManagerFragment, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = true;
        }
        modelManagerFragment.reload(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0180 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void reload$lambda$24(boolean r23, android.content.Context r24, com.stepos.aiengine.modelmanager.ModelManagerFragment r25) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.modelmanager.ModelManagerFragment.reload$lambda$24(boolean, android.content.Context, com.stepos.aiengine.modelmanager.ModelManagerFragment):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$24$lambda$22(ModelManagerFragment modelManagerFragment, List list) {
        if (modelManagerFragment.isAdded()) {
            List<s> listMergeLiveState = modelManagerFragment.mergeLiveState(list);
            modelManagerFragment.lastRows = listMergeLiveState;
            modelManagerFragment.render(listMergeLiveState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$24$lambda$23(ModelManagerFragment modelManagerFragment, List list, List list2, boolean z) {
        modelManagerFragment.cancelPresetFallback();
        if (modelManagerFragment.isAdded()) {
            if (!list.isEmpty()) {
                modelManagerFragment.applyRows(modelManagerFragment.mergeLiveState(list));
                return;
            }
            if (list2.isEmpty()) {
                if (!z) {
                    String string = modelManagerFragment.getString(R.string.mm_service_unavailable);
                    g.e(string, "getString(...)");
                    modelManagerFragment.toast(string);
                }
                modelManagerFragment.lastRows = list;
                modelManagerFragment.render(list);
            }
        }
    }

    private final boolean removeRowFromScreen(String str) {
        ModelPreference modelPreferenceFindPref;
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int i10 = 0;
        if (preferenceScreen != null && (modelPreferenceFindPref = findPref(str)) != null) {
            PreferenceGroup preferenceGroup = modelPreferenceFindPref.M;
            PreferenceCategory preferenceCategory = preferenceGroup instanceof PreferenceCategory ? (PreferenceCategory) preferenceGroup : null;
            if (preferenceCategory != null) {
                preferenceCategory.E(modelPreferenceFindPref);
                dc.e eVarE0 = dc.h.e0(0, preferenceCategory.T.size());
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = eVarE0.iterator();
                while (((dc.d) it).f8456c) {
                    Preference preferenceD = preferenceCategory.D(((mb.t) it).nextInt());
                    ModelPreference modelPreference = preferenceD instanceof ModelPreference ? (ModelPreference) preferenceD : null;
                    if (modelPreference != null) {
                        arrayList.add(modelPreference);
                    }
                }
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    int i12 = i10 + 1;
                    if (i10 < 0) {
                        m.f0();
                        throw null;
                    }
                    ModelPreference modelPreference2 = (ModelPreference) obj;
                    int size2 = arrayList.size();
                    if (modelPreference2.S != i10 || modelPreference2.T != size2) {
                        modelPreference2.S = i10;
                        modelPreference2.T = size2;
                        modelPreference2.j();
                    }
                    i10 = i12;
                }
                if (arrayList.isEmpty()) {
                    preferenceScreen.E(preferenceCategory);
                }
                toggleEmpty(onScreenStructureSig().isEmpty());
                return true;
            }
        }
        return false;
    }

    private final void render(List<s> list) {
        int i10 = 0;
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((s) it.next()).b() == ModelGroup.f5843a && (i10 = i10 + 1) < 0) {
                    m.e0();
                    throw null;
                }
            }
        }
        a.a(Companion, "render: FULL REBUILD preset=" + i10 + " nonPreset=" + nonPresetRowsForDisplay(list).size());
        androidx.preference.f preferenceManager = getPreferenceManager();
        Context contextRequireContext = requireContext();
        preferenceManager.getClass();
        PreferenceScreen preferenceScreen = new PreferenceScreen(contextRequireContext, null);
        preferenceScreen.m(preferenceManager);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((s) obj).b() == ModelGroup.f5843a) {
                arrayList.add(obj);
            }
        }
        addGroup(preferenceScreen, R.string.mm_group_preset, arrayList);
        addGroup(preferenceScreen, R.string.mm_group_non_preset, nonPresetRowsForDisplay(list));
        setPreferenceScreen(preferenceScreen);
        toggleEmpty(list.isEmpty());
        scrollToHighlightIfReady();
    }

    private final void revealRow(String str) {
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        x xVar = this.latestSnaps.get(strResolveAnyToOta);
        if (xVar != null) {
            String otaId = xVar.f9356a;
            int i10 = xVar.f9357b;
            int i11 = xVar.f9358c;
            int i12 = xVar.f9359d;
            g.f(otaId, "otaId");
            x xVar2 = new x(otaId, i10, i11, i12, false);
            this.latestSnaps = kotlin.collections.b.k0(this.latestSnaps, new Pair(strResolveAnyToOta, xVar2));
            List<s> list = this.lastRows;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (g.b(((s) obj).f9339b, strResolveAnyToOta)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int size = arrayList.size();
            boolean z = false;
            int i13 = 0;
            while (i13 < size) {
                Object obj2 = arrayList.get(i13);
                i13++;
                if (applySnapToRow((s) obj2, xVar2) == SnapApply.f5864c) {
                    z = true;
                } else {
                    ModelPreference modelPreferenceFindPref = findPref(strResolveAnyToOta);
                    if (modelPreferenceFindPref != null) {
                        modelPreferenceFindPref.j();
                    }
                }
            }
            if (z) {
                render(this.lastRows);
            }
        }
    }

    private final void scheduleInstalledDataRefresh(String str, int i10) {
        if (i10 > 0) {
            Integer num = this.dataRefreshedAtVer.get(str);
            if (num != null && num.intValue() == i10) {
                return;
            }
            this.dataRefreshedAtVer.put(str, Integer.valueOf(i10));
            this.main.removeCallbacks(this.installedDataRefresh);
            this.main.postDelayed(this.installedDataRefresh, 800L);
        }
    }

    private final void schedulePresetFallback(List<s> list) {
        cancelPresetFallback();
        f fVar = new f(this, list, 2);
        this.main.postDelayed(fVar, 1500L);
        this.presetFallback = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void schedulePresetFallback$lambda$25(ModelManagerFragment modelManagerFragment, List list) {
        if (modelManagerFragment.isAdded() && modelManagerFragment.lastRows.isEmpty()) {
            a.a(Companion, "preset fallback fired: full data still pending");
            List<s> listMergeLiveState = modelManagerFragment.mergeLiveState(list);
            modelManagerFragment.lastRows = listMergeLiveState;
            modelManagerFragment.render(listMergeLiveState);
        }
    }

    private final void scrollToHighlightIfReady() {
        String str = this.pendingHighlightModelId;
        if (str == null) {
            return;
        }
        String strResolveAnyToOta = OtaEngine.INSTANCE.resolveAnyToOta(str);
        if (findPref(strResolveAnyToOta) == null) {
            return;
        }
        this.pendingHighlightModelId = null;
        scrollToPreference(strResolveAnyToOta);
    }

    private final boolean shouldShowInList(s sVar) {
        int i10;
        return sVar.b() == ModelGroup.f5843a || !this.editing || (i10 = sVar.f9343f) == 2 || i10 == 3;
    }

    private final List<String> structureSig(List<s> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((s) obj).b() == ModelGroup.f5843a) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(m.Z(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            arrayList2.add("P:" + ((s) obj2).f9339b);
        }
        List<s> listNonPresetRowsForDisplay = nonPresetRowsForDisplay(list);
        ArrayList arrayList3 = new ArrayList(m.Z(listNonPresetRowsForDisplay, 10));
        Iterator<T> it = listNonPresetRowsForDisplay.iterator();
        while (it.hasNext()) {
            arrayList3.add("N:" + ((s) it.next()).f9339b);
        }
        return kotlin.collections.a.H0(kotlin.collections.a.D0(arrayList2, arrayList3));
    }

    private final void toast(String str) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, str, 0).show();
        }
    }

    private final void toggleEmpty(boolean z) {
        TextView textView;
        androidx.fragment.app.o activity = getActivity();
        if (activity == null || (textView = (TextView) activity.findViewById(R.id.tv_empty)) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
    }

    public final void highlightAbility(String abilityId) {
        g.f(abilityId, "abilityId");
        highlightModel(abilityId);
    }

    public final void highlightModel(String modelId) {
        g.f(modelId, "modelId");
        this.pendingHighlightModelId = modelId;
        scrollToHighlightIfReady();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_HIGHLIGHT_MODEL)) == null) {
            Bundle arguments2 = getArguments();
            string = arguments2 != null ? arguments2.getString(ARG_HIGHLIGHT_ABILITY) : null;
        }
        this.pendingHighlightModelId = string;
        androidx.preference.f preferenceManager = getPreferenceManager();
        Context contextRequireContext = requireContext();
        preferenceManager.getClass();
        PreferenceScreen preferenceScreen = new PreferenceScreen(contextRequireContext, null);
        preferenceScreen.m(preferenceManager);
        setPreferenceScreen(preferenceScreen);
        reload$default(this, false, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.io.shutdown();
        super.onDestroy();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        OtaModelClient.f5871a.getClass();
        OtaModelClient.f5873c = null;
        PreInstallModels.OnSettledListener onSettledListener = this.presetSettledListener;
        if (onSettledListener != null) {
            PreInstallModels.INSTANCE.removeOnSettledListener(onSettledListener);
        }
        this.presetSettledListener = null;
        PreInstallModels.OnModelInstalledListener onModelInstalledListener = this.presetModelInstalledListener;
        if (onModelInstalledListener != null) {
            PreInstallModels.INSTANCE.removeOnModelInstalledListener(onModelInstalledListener);
        }
        this.presetModelInstalledListener = null;
        ModelDisplayResourceStore.OnDisplayReadyListener onDisplayReadyListener = this.displayReadyListener;
        if (onDisplayReadyListener != null) {
            ModelDisplayResourceStore.INSTANCE.removeOnDisplayReadyListener(onDisplayReadyListener);
        }
        this.displayReadyListener = null;
        this.main.removeCallbacks(this.displayReadyRefresh);
        this.main.removeCallbacks(this.installedDataRefresh);
        this.main.removeCallbacks(this.presetInstalledRefresh);
        cancelPresetFallback();
        OtaModelClient.f5878i = null;
        OtaModelClient.f5879j.dismissPending();
        OtaAlertDialog otaAlertDialog = this.uninstallDialog;
        if (otaAlertDialog != null) {
            if (!otaAlertDialog.isShowing()) {
                otaAlertDialog = null;
            }
            if (otaAlertDialog != null) {
                otaAlertDialog.dismiss();
            }
        }
        this.uninstallDialog = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.lastRows.isEmpty()) {
            return;
        }
        refreshRowsInPlace();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intent intent;
        String stringExtra;
        Intent intent2;
        g.f(view, "view");
        super.onViewCreated(view, bundle);
        setDivider(null);
        setDividerHeight(0);
        getListView().setVerticalScrollBarEnabled(false);
        getListView().setHorizontalScrollBarEnabled(false);
        RecyclerView listView = getListView();
        Context contextRequireContext = requireContext();
        g.e(contextRequireContext, "requireContext(...)");
        listView.addItemDecoration(new i6.a(contextRequireContext));
        Context contextAppContextOrNull = appContextOrNull();
        if (contextAppContextOrNull != null) {
            OtaModelClient.f5871a.getClass();
            if (OtaProcessConfig.INSTANCE.getEnabled()) {
                OtaProcessClient.INSTANCE.bindIfAlive(contextAppContextOrNull);
            }
        }
        q viewLifecycleOwner = getViewLifecycleOwner();
        g.e(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.r.a(viewLifecycleOwner), null, null, new AnonymousClass2(null), 3, null);
        OtaModelClient otaModelClient = OtaModelClient.f5871a;
        k kVar = new k(this);
        otaModelClient.getClass();
        OtaModelClient.f5873c = kVar;
        OtaModelClient.f5878i = new j0(this, 8);
        androidx.fragment.app.o activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("com.stepos.aiengine.extra.PENDING_CONFIRM")) != null) {
            androidx.fragment.app.o activity2 = getActivity();
            if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                intent2.removeExtra("com.stepos.aiengine.extra.PENDING_CONFIRM");
            }
            this.main.post(new h6.m(stringExtra, 0));
        }
        PreInstallModels.OnSettledListener onSettledListener = new PreInstallModels.OnSettledListener() { // from class: h6.n
            @Override // com.stepos.core.ota.install.PreInstallModels.OnSettledListener
            public final void onSettled() {
                ModelManagerFragment.onViewCreated$lambda$12(this.f9330a);
            }
        };
        PreInstallModels preInstallModels = PreInstallModels.INSTANCE;
        preInstallModels.addOnSettledListener(onSettledListener);
        this.presetSettledListener = onSettledListener;
        PreInstallModels.OnModelInstalledListener onModelInstalledListener = new PreInstallModels.OnModelInstalledListener() { // from class: h6.o
            @Override // com.stepos.core.ota.install.PreInstallModels.OnModelInstalledListener
            public final void onModelInstalled(String str) {
                ModelManagerFragment.onViewCreated$lambda$14(this.f9331a, str);
            }
        };
        preInstallModels.addOnModelInstalledListener(onModelInstalledListener);
        this.presetModelInstalledListener = onModelInstalledListener;
        ModelDisplayResourceStore.OnDisplayReadyListener onDisplayReadyListener = new ModelDisplayResourceStore.OnDisplayReadyListener() { // from class: h6.p
            @Override // com.stepos.core.ota.display.ModelDisplayResourceStore.OnDisplayReadyListener
            public final void onDisplayReady(String str) {
                ModelManagerFragment.onViewCreated$lambda$16(this.f9332a, str);
            }
        };
        ModelDisplayResourceStore.INSTANCE.addOnDisplayReadyListener(onDisplayReadyListener);
        this.displayReadyListener = onDisplayReadyListener;
    }

    public final void setEditing(boolean z) {
        if (this.editing == z) {
            return;
        }
        this.editing = z;
        if (this.lastRows.isEmpty()) {
            return;
        }
        render(this.lastRows);
    }
}
