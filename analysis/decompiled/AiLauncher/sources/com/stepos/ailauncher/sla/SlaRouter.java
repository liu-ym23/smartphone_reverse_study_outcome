package com.stepos.ailauncher.sla;

import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.sla.ISla;
import com.stepos.aiengine.algorithm.sla.SlaInput;
import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.aiengine.api.IAlgorithmProperties;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.client.AbilityServiceClient;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AICapabilityProvider;
import com.stepos.aiengine.clients.AlgorithmClients;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.ConfirmDialogParams;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import com.stepos.core.ota.confirmui.EnhancedServiceGuide;
import com.stepos.core.ota.confirmui.FallbackConfirmHost;
import com.stepos.core.ota.confirmui.InProcessConfirmHost;
import com.stepos.core.ota.confirmui.R;
import com.stepos.core.ota.confirmui.TrampolineConfirmHost;
import h8.C4148a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001^B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082\u0010¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u000bJ\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u000bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u000bJ\u0015\u0010%\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u000bJ\u0015\u0010&\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b&\u0010\u000bJ\r\u0010'\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u000bJ\u0015\u0010*\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u000bJ\u0015\u0010+\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\u000bJ\u0015\u0010,\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b,\u0010\u000bJC\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\tH\u0007¢\u0006\u0004\b5\u00106JC\u00108\u001a\u0004\u0018\u0001042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\tH\u0007¢\u0006\u0004\b8\u00109JC\u0010<\u001a\u0004\u0018\u0001042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\u0006\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\tH\u0007¢\u0006\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u00108R\u0014\u0010@\u001a\u00020>8\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u00108R\u0014\u0010A\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010D\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010BR\u0014\u0010E\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010BR\u0014\u0010F\u001a\u00020>8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u00108R\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010\u0007R\u0014\u0010O\u001a\u00020M8\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010\u0007R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010\u0007R\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020M8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010\u0007R\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010BR\u0014\u0010X\u001a\u00020>8\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u00108R\u0014\u0010Y\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010BR\u0014\u0010Z\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010BR\u0014\u0010[\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010BR\u0014\u0010\\\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\\\u0010BR\u0018\u0010]\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010B¨\u0006_"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaRouter;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "J", "(Landroid/content/Context;)V", "", "z", "(Landroid/content/Context;)Z", "Landroid/app/Activity;", "R", "(Landroid/content/Context;)Landroid/app/Activity;", "L", "k", "", "Landroid/widget/TextView;", "p", "()Ljava/util/List;", "Q", "r", "P", "Landroid/os/Bundle;", "F", "(Landroid/content/Context;)Landroid/os/Bundle;", "w", ExifInterface.LATITUDE_SOUTH, "", "x", "()Ljava/lang/String;", "q", "Landroid/content/Intent;", "l", "(Landroid/content/Context;)Landroid/content/Intent;", "t", "u", "n", "m", "()Z", "N", "K", "y", "v", "Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "input", "sessionId", DidiCardProvider.KEY_TRACE_ID, "Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "listener", "localDispatch", "Lcom/stepos/ailauncher/sla/SlaRouter$a;", "G", "(Landroid/content/Context;Lcom/stepos/aiengine/algorithm/sla/SlaInput;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaListener;Z)Lcom/stepos/ailauncher/sla/SlaRouter$a;", "text", "I", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaListener;Z)Lcom/stepos/ailauncher/sla/SlaRouter$a;", "", "pcm", "H", "(Landroid/content/Context;[BLjava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaListener;Z)Lcom/stepos/ailauncher/sla/SlaRouter$a;", "", "SLA_NO_VALID_ACTION", "SLA_SCREEN_LOCKED", "TAG", "Ljava/lang/String;", "KEY_TRACE_ID", "KEY_EXECUTE_ATOMIC", "KEY_TASK_PRIORITY", "TASK_PRIORITY", "LUa/M;", "warmUpScope", "LUa/M;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "warming", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "lastWarmUpAt", "WARM_UP_MIN_INTERVAL_MS", "lastCtaDialogAt", "lastPromptLaunched", "Z", "CTA_DIALOG_DEBOUNCE_MS", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "KEY_ENV_ERROR", "GATE_ERROR_SERVICE_DISABLED", "AIENGINE_PKG", "ENHANCED_SERVICE_REDIRECT_CLASS", "ACTION_OPEN_ENHANCED_SERVICE", "ENHANCED_SERVICE_FRAGMENT", "cachedModelVersion", Const.INTENT_KEY_APIKEY, "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaRouter {
    private static final String ACTION_OPEN_ENHANCED_SERVICE = "com.stepos.aiengine.action.OPEN_ENHANCED_SERVICE_SETTINGS";
    private static final String AIENGINE_PKG = "com.stepos.aiengine";
    private static final long CTA_DIALOG_DEBOUNCE_MS = 1500;
    private static final String ENHANCED_SERVICE_FRAGMENT = "com.stepos.settings.accessibility.StepOSEnhancedServiceFragment";
    private static final String ENHANCED_SERVICE_REDIRECT_CLASS = "com.stepos.aiengine.settings.EnhancedServiceRedirectActivity";
    private static final int GATE_ERROR_SERVICE_DISABLED = 5022;
    private static final String KEY_ENV_ERROR = "envError";
    private static final String KEY_EXECUTE_ATOMIC = "executeAtomic";
    private static final String KEY_TASK_PRIORITY = "task_priority";
    private static final String KEY_TRACE_ID = "trace_id";
    public static final int SLA_NO_VALID_ACTION = 280001;
    public static final int SLA_SCREEN_LOCKED = 280002;
    private static final String TAG = "SLA";
    private static final int TASK_PRIORITY = 2;
    private static final long WARM_UP_MIN_INTERVAL_MS = 5000;
    private static volatile String cachedModelVersion;
    private static volatile long lastCtaDialogAt;
    private static volatile boolean lastPromptLaunched;
    private static volatile long lastWarmUpAt;
    public static final SlaRouter INSTANCE = new SlaRouter();
    private static final Ua.M warmUpScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final AtomicBoolean warming = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaRouter$a;", "", "Lcom/stepos/aiengine/algorithm/sla/ISla;", "sla", "", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "<init>", "(Lcom/stepos/aiengine/algorithm/sla/ISla;J)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "Lcom/stepos/aiengine/algorithm/sla/ISla;", "J", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final long identity;
        private final ISla sla;

        public a(ISla sla, long j10) {
            kotlin.jvm.internal.p.i(sla, "sla");
            this.sla = sla;
            this.identity = j10;
        }

        public final void a() {
            C4148a.d("SLA", "cancel recognize identity=" + this.identity, false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(this.sla.cancel(this.identity)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public static final int A(SlaRouter slaRouter, Context ctx) {
        kotlin.jvm.internal.p.i(ctx, "ctx");
        return !slaRouter.y(ctx) ? 1 : 0;
    }

    public static final Activity B(SlaRouter slaRouter, Context context) {
        return slaRouter.R(context);
    }

    public static final void C(ConfirmDecisionBus.Decision d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        C4148a.k("SLA", "model enable dialog decision=" + d10, false, 4, null);
    }

    public static final void D(ConfirmDecisionBus.SubStage it) {
        kotlin.jvm.internal.p.i(it, "it");
    }

    public static final Y8.t E(String str) {
        ConfirmDecisionBus.INSTANCE.clear(str);
        C4148a.u("SLA", "model enable dialog show failed reqId=" + str, false, 4, null);
        return Y8.t.f7040a;
    }

    public static final void M(Context context) {
        INSTANCE.k(context);
    }

    public static final void O(Context context) {
        lastPromptLaunched = INSTANCE.z(context);
        C4148a.k("SLA", "showModelManagementEnableDialog launched=" + lastPromptLaunched, false, 4, null);
    }

    public static final void o(Context context) {
        SlaRouter slaRouter = INSTANCE;
        kotlin.jvm.internal.p.f(context);
        lastPromptLaunched = !slaRouter.q(context) ? slaRouter.K(context) : false;
        C4148a.k("SLA", "ensureAiEngineReady blocked cta=" + slaRouter.q(context) + " launched=" + lastPromptLaunched, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Integer s(java.lang.Class<?> r3, java.lang.Object r4, android.content.Context r5) {
        /*
            r0 = 0
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = "get"
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.Throwable -> L31
            java.lang.reflect.Method r3 = r3.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L31
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L31
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch: java.lang.Throwable -> L31
            if (r3 != 0) goto L1b
        L19:
            r3 = r0
            goto L33
        L1b:
            java.lang.Class r4 = r3.getClass()     // Catch: java.lang.Throwable -> L31
            java.lang.String r5 = "openEnhancedServiceSettings"
            java.lang.reflect.Method r4 = r4.getMethod(r5, r0)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r3 = r4.invoke(r3, r0)     // Catch: java.lang.Throwable -> L31
            boolean r4 = r3 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L19
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L31
            goto L33
        L31:
            r3 = move-exception
            goto L38
        L33:
            java.lang.Object r3 = kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> L31
            goto L42
        L38:
            kotlin.Result$a r4 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.C4849c.a(r3)
            java.lang.Object r3 = kotlin.Result.b(r3)
        L42:
            java.lang.Throwable r4 = kotlin.Result.e(r3)
            if (r4 == 0) goto L65
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "openEnhancedServiceSettings invoke failed: "
            r5.append(r1)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r5 = 0
            r1 = 4
            java.lang.String r2 = "SLA"
            h8.C4148a.u(r2, r4, r5, r1, r0)
        L65:
            boolean r4 = kotlin.Result.g(r3)
            if (r4 == 0) goto L6c
            goto L6d
        L6c:
            r0 = r3
        L6d:
            java.lang.Integer r0 = (java.lang.Integer) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaRouter.s(java.lang.Class, java.lang.Object, android.content.Context):java.lang.Integer");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle F(android.content.Context r5) {
        /*
            r4 = this;
            r4 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L43
            java.lang.Class<com.stepos.aiengine.update.OtaServiceClient> r0 = com.stepos.aiengine.update.OtaServiceClient.class
            com.stepos.aiengine.update.OtaServiceClient r1 = com.stepos.aiengine.update.OtaServiceClient.INSTANCE     // Catch: java.lang.Throwable -> L43
            java.lang.String r1 = "INSTANCE"
            java.lang.reflect.Field r1 = r0.getDeclaredField(r1)     // Catch: java.lang.Throwable -> L43
            r2 = 1
            r1.setAccessible(r2)     // Catch: java.lang.Throwable -> L43
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = "get"
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            java.lang.Class[] r3 = new java.lang.Class[]{r3}     // Catch: java.lang.Throwable -> L43
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Throwable -> L43
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L43
            java.lang.Object r5 = r0.invoke(r1, r5)     // Catch: java.lang.Throwable -> L43
            if (r5 != 0) goto L2d
        L2b:
            r5 = r4
            goto L45
        L2d:
            java.lang.Class r0 = r5.getClass()     // Catch: java.lang.Throwable -> L43
            java.lang.String r1 = "queryPrecheckEnv"
            java.lang.reflect.Method r0 = r0.getMethod(r1, r4)     // Catch: java.lang.Throwable -> L43
            java.lang.Object r5 = r0.invoke(r5, r4)     // Catch: java.lang.Throwable -> L43
            boolean r0 = r5 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L2b
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch: java.lang.Throwable -> L43
            goto L45
        L43:
            r5 = move-exception
            goto L4a
        L45:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L43
            goto L54
        L4a:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L54:
            java.lang.Throwable r0 = kotlin.Result.e(r5)
            if (r0 == 0) goto L77
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "queryPrecheckEnv failed: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            r2 = 4
            java.lang.String r3 = "SLA"
            h8.C4148a.u(r3, r0, r1, r2, r4)
        L77:
            boolean r0 = kotlin.Result.g(r5)
            if (r0 == 0) goto L7e
            goto L7f
        L7e:
            r4 = r5
        L7f:
            android.os.Bundle r4 = (android.os.Bundle) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaRouter.F(android.content.Context):android.os.Bundle");
    }

    public final a G(Context context, SlaInput input, String sessionId, String traceId, SlaListener listener, boolean localDispatch) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(listener, "listener");
        if (!n(context)) {
            C4148a.k("SLA", "recognize skipped: AI engine not ready", false, 4, null);
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((ISla) AlgorithmClient.loadAlgorithm$default(AlgorithmClients.INSTANCE.getSla(), context, null, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h("SLA", "loadAlgorithm failed: " + thE.getMessage(), false, 4, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        ISla iSla = (ISla) objB;
        if (iSla == null) {
            return null;
        }
        J(context);
        AlgorithmToken algorithmTokenSubmit = AlgorithmToken.INSTANCE.submit();
        if (traceId.length() == 0) {
            C4148a.h("SLA", "recognize traceId 为空 -> 端侧链路追踪将缺失，需排查调用方生成逻辑", false, 4, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("session_id", sessionId);
        bundle.putString("trace_id", traceId);
        bundle.putInt("task_priority", 2);
        if (localDispatch) {
            bundle.putBoolean(KEY_EXECUTE_ATOMIC, false);
        }
        try {
            objB2 = Result.b(Integer.valueOf(iSla.recognize(algorithmTokenSubmit, input, bundle, listener)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = -1;
        }
        int iIntValue = ((Number) objB2).intValue();
        boolean z10 = iIntValue == 0;
        C4148a.k("SLA", "recognize accepted=" + z10 + " code=" + iIntValue + " localDispatch=" + localDispatch + " identity=" + algorithmTokenSubmit.getIdentity() + " sessionId=" + sessionId + " traceId=" + traceId, false, 4, null);
        if (iIntValue == 0) {
            return new a(iSla, algorithmTokenSubmit.getIdentity());
        }
        return null;
    }

    public final a H(Context context, byte[] pcm, String sessionId, String traceId, SlaListener listener, boolean localDispatch) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(pcm, "pcm");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(listener, "listener");
        return G(context, SlaInput.Companion.audioFromBytes$default(SlaInput.INSTANCE, pcm, 0, 0, 6, null), sessionId, traceId, listener, localDispatch);
    }

    public final a I(Context context, String text, String sessionId, String traceId, SlaListener listener, boolean localDispatch) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(listener, "listener");
        return G(context, SlaInput.INSTANCE.text(text), sessionId, traceId, listener, localDispatch);
    }

    public final void J(Context context) {
        Object objB;
        if (cachedModelVersion != null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(AlgorithmClients.INSTANCE.getSla().getInitialProperty(context, IAlgorithmProperties.CURRENT_MODEL));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "read current_model failed: " + thE.getMessage(), false, 4, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || str.length() <= 0) {
            str = null;
        }
        if (str == null) {
            C4148a.u("SLA", "modelVersion 读取为空 -> sla_judge_result.model_version 本轮不上报", false, 4, null);
            return;
        }
        cachedModelVersion = str;
        C4148a.k("SLA", "modelVersion=" + str, false, 4, null);
    }

    public final boolean K(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (lastCtaDialogAt != 0 && jElapsedRealtime - lastCtaDialogAt < 1500) {
            C4148a.k("SLA", "requestCtaDialog skipped: debounce", false, 4, null);
            return true;
        }
        Intent intentL = l(context);
        if (intentL == null) {
            C4148a.u("SLA", "requestCtaDialog: CTA dialog intent is null", false, 4, null);
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            intentL.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intentL);
            lastCtaDialogAt = jElapsedRealtime;
            C4148a.k("SLA", "requestCtaDialog: launched", false, 4, null);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "requestCtaDialog failed: " + thE.getMessage(), false, 4, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void L(final Context context) {
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.sla.F
            @Override // java.lang.Runnable
            public final void run() {
                SlaRouter.M(context);
            }
        };
        Handler handler = mainHandler;
        handler.post(runnable);
        handler.postDelayed(runnable, 80L);
    }

    public final boolean N(final Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.sla.y
            @Override // java.lang.Runnable
            public final void run() {
                SlaRouter.O(context);
            }
        };
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            mainHandler.post(runnable);
        }
        return lastPromptLaunched;
    }

    public final boolean P(Context context) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.SubSettings");
            intent.putExtra(":settings:show_fragment", ENHANCED_SERVICE_FRAGMENT);
            intent.addFlags(268468224);
            context.startActivity(intent);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "local open settings failed: " + thE.getMessage(), false, 4, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean Q(Context context) {
        Object objB;
        boolean z10;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intentAddFlags = new Intent(ACTION_OPEN_ENHANCED_SERVICE).setClassName(AIENGINE_PKG, ENHANCED_SERVICE_REDIRECT_CLASS).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            kotlin.jvm.internal.p.h(intentAddFlags, "addFlags(...)");
            if (intentAddFlags.resolveActivity(context.getPackageManager()) == null) {
                z10 = false;
            } else {
                context.startActivity(intentAddFlags);
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "redirect via AIEngine failed: " + thE.getMessage(), false, 4, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final Activity R(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    public final void S(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (C3474c.INSTANCE.b()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - lastWarmUpAt >= 5000 && warming.compareAndSet(false, true)) {
                lastWarmUpAt = jElapsedRealtime;
                C1060i.d(warmUpScope, null, null, new SlaRouter$warmUp$1(context.getApplicationContext(), null), 3, null);
            }
        }
    }

    public final void k(Context context) {
        String string = context.getString(R$string.voice_ai_engine_enable_message);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        Iterator<T> it = p().iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setText(string);
        }
    }

    public final Intent l(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return AICapabilityProvider.INSTANCE.getCTADialogIntent(context);
    }

    public final boolean m() {
        return lastPromptLaunched;
    }

    public final boolean n(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (t(context)) {
            return true;
        }
        final Context applicationContext = context.getApplicationContext();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.sla.z
            @Override // java.lang.Runnable
            public final void run() {
                SlaRouter.o(applicationContext);
            }
        };
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
            return false;
        }
        mainHandler.post(runnable);
        return false;
    }

    public final List<TextView> p() {
        Object objB;
        List listM;
        int i10 = R.id.ocu_message;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object objInvoke = cls.getMethod("getInstance", null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            List list = obj instanceof List ? (List) obj : null;
            if (list == null) {
                listM = C1173v.m();
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    View view = obj2 instanceof View ? (View) obj2 : null;
                    TextView textView = view != null ? (TextView) view.findViewById(i10) : null;
                    if (textView != null) {
                        arrayList.add(textView);
                    }
                }
                listM = arrayList;
            }
            objB = Result.b(listM);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "findOcuMessageViews failed: " + thE.getMessage(), false, 4, null);
        }
        List listM2 = C1173v.m();
        if (Result.g(objB)) {
            objB = listM2;
        }
        return (List) objB;
    }

    public final boolean q(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return AICapabilityProvider.INSTANCE.hasCTAPermission(context);
    }

    public final boolean r(Context context) {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbilityServiceClient abilityServiceClient = AbilityServiceClient.INSTANCE;
            objB = Result.b(AbilityServiceClient.class);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Class cls = (Class) objB;
        if (cls == null) {
            return false;
        }
        try {
            objB2 = Result.b(cls.getField("INSTANCE").get(null));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        if (objB2 == null) {
            return false;
        }
        Integer numS = s(cls, objB2, context);
        if (numS == null || numS.intValue() != 0) {
            try {
                Result.b(cls.getMethod("invalidate", null).invoke(objB2, null));
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.b(C4849c.a(th3));
            }
            numS = s(cls, objB2, context);
        }
        boolean z10 = numS != null && numS.intValue() == 0;
        C4148a.k("SLA", "openEnhancedServiceSettings binder code=" + numS + " ok=" + z10, false, 4, null);
        return z10;
    }

    public final boolean t(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (q(context)) {
            return u(context);
        }
        return false;
    }

    public final boolean u(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Bundle bundleF = F(context);
        if (bundleF == null) {
            return true;
        }
        int i10 = bundleF.getInt("envError", 0);
        C4148a.k("SLA", "isAiEngineServiceEnabled envError=" + i10, false, 4, null);
        return i10 != 5022;
    }

    public final boolean v(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (!C3474c.INSTANCE.b()) {
            C4148a.d("SLA", "isAvailable=false: feature flag off", false, 4, null);
            return false;
        }
        boolean zW = w(context);
        if (!zW) {
            C4148a.k("SLA", "isAvailable=false supported=" + zW, false, 4, null);
        }
        return zW;
    }

    public final boolean w(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(AlgorithmClients.INSTANCE.getSla().isSupported(context)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final String x() {
        return cachedModelVersion;
    }

    public final boolean y(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (Q(context)) {
            C4148a.k("SLA", "openEnhancedServiceSettings: redirect activity", false, 4, null);
            return true;
        }
        if (r(context)) {
            return true;
        }
        if (P(context)) {
            C4148a.k("SLA", "openEnhancedServiceSettings: local SubSettings", false, 4, null);
            return true;
        }
        C4148a.u("SLA", "openEnhancedServiceSettings: all paths failed", false, 4, null);
        return false;
    }

    public final boolean z(final Context context) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            EnhancedServiceGuide.setLauncher(new InterfaceC5074l() { // from class: com.stepos.ailauncher.sla.A
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Integer.valueOf(SlaRouter.A(this.f28278a, (Context) obj));
                }
            });
            InProcessConfirmHost inProcessConfirmHost = new InProcessConfirmHost(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.B
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SlaRouter.B(this.f28279a, context);
                }
            });
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            FallbackConfirmHost fallbackConfirmHost = new FallbackConfirmHost(inProcessConfirmHost, new TrampolineConfirmHost(applicationContext));
            final String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.ailauncher.sla.C
                @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
                public final void onDecision(ConfirmDecisionBus.Decision decision) {
                    SlaRouter.C(decision);
                }
            }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.ailauncher.sla.D
                @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
                public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                    SlaRouter.D(subStage);
                }
            });
            fallbackConfirmHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.INSTANCE.serviceDisabled(), "voice-ai-engine", SystemClock.elapsedRealtime(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.E
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SlaRouter.E(strRegister);
                }
            }));
            L(context);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "presentModelManagementEnableDialog failed: " + thE.getMessage(), false, 4, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
