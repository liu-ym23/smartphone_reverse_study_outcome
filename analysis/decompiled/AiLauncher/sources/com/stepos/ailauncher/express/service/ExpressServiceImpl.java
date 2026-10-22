package com.stepos.ailauncher.express.service;

import L5.a;
import La.H;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.screenops.TriggerType;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.U0;
import com.stepos.ailauncher.common.permission.C3185b;
import com.stepos.ailauncher.common.permission.G;
import com.stepos.ailauncher.common.permission.PermScene;
import com.stepos.ailauncher.common.utils.I;
import com.stepos.ailauncher.contract.api.express.IExpressService;
import com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.express.orchestrator.ExpressOrchestrator;
import com.stepos.ailauncher.express.service.ExpressServiceImpl;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001T\u0018\u0000 W2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u001f\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\rJ\u001f\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u000bH\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u000bH\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010\u0003J\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0011J\u0015\u00103\u001a\b\u0012\u0004\u0012\u00020\b02H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010\u0011J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010\u0003R\u0016\u00107\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010(R\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010(R\u0018\u0010J\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010#R\u0018\u0010N\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010KR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010#R\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010#R\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/stepos/ailauncher/express/service/ExpressServiceImpl;", "Lcom/stepos/ailauncher/contract/api/express/IExpressService;", "<init>", "()V", "", "prereq", "c0", "(Z)Z", "", "pkg", "activity", "LY8/t;", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;Ljava/lang/String;)V", "i0", "(Ljava/lang/String;Z)Z", "Q", "()Z", "Lcom/stepos/ability/screenops/TriggerType;", "trigger", "U", "(Ljava/lang/String;Lcom/stepos/ability/screenops/TriggerType;)V", "sceneOnTop", "k0", "(Lcom/stepos/ability/screenops/TriggerType;Z)Z", "P", "R", "reason", "g0", "I", "f0", "l0", "n0", "F", "e0", "J", "G", ExifInterface.LONGITUDE_EAST, "H", "Y", "Z", ExifInterface.LONGITUDE_WEST, "X", "o0", "m0", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "isEnabled", "", "getSupportedPackages", "()Ljava/util/List;", "shouldSuppressAiKeyWake", "onSettingsChanged", "appContext", "Landroid/content/Context;", "Lcom/stepos/ailauncher/express/capsule/h;", "capsule", "Lcom/stepos/ailauncher/express/capsule/h;", "Lcom/stepos/ailauncher/express/orchestrator/ExpressOrchestrator;", "orchestrator", "Lcom/stepos/ailauncher/express/orchestrator/ExpressOrchestrator;", "Lcom/stepos/ailauncher/express/scene/a;", "monitor", "Lcom/stepos/ailauncher/express/scene/a;", "LL5/a;", "sceneRecoveryStore", "LL5/a;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "listening", "pendingListenAfterEnter", "lastEnterPkg", "Ljava/lang/String;", "", "lastEnterAtElapsed", "pendingLeavePkg", "sceneGeneration", "Ljava/lang/Runnable;", "leaveConfirmation", "Ljava/lang/Runnable;", "softPauseUntilElapsed", "com/stepos/ailauncher/express/service/ExpressServiceImpl$c", "sceneWatch", "Lcom/stepos/ailauncher/express/service/ExpressServiceImpl$c;", "Companion", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExpressServiceImpl implements IExpressService {
    private static final long AUTH_UI_END_GRACE_MS = 800;
    private static final long AUTH_UI_SOFT_PAUSE_MS = 8000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ENTER_DEDUPE_MS = 800;
    private static final long EXPANDED_WATCH_MS = 50;
    private static final long EXPRESS_APP_SWITCH_SUPPRESS_MS = 2500;
    private static final long LEAVE_CONFIRM_MS = 150;
    private static final long SCENE_WATCH_MS = 200;
    private static final String TAG = "ExpressServiceImpl";
    private Context appContext;
    private com.stepos.ailauncher.express.capsule.h capsule;
    private long lastEnterAtElapsed;
    private String lastEnterPkg;
    private Runnable leaveConfirmation;
    private volatile boolean listening;
    private com.stepos.ailauncher.express.scene.a monitor;
    private ExpressOrchestrator orchestrator;
    private String pendingLeavePkg;
    private volatile boolean pendingListenAfterEnter;
    private long sceneGeneration;
    private L5.a sceneRecoveryStore;
    private volatile long softPauseUntilElapsed;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final c sceneWatch = new c();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/express/service/ExpressServiceImpl$a;", "", "<init>", "()V", "", "gesture", "appOn", "prereq", "newUser", "expressSwitch", Const.INTENT_KEY_APIKEY, "(ZZZZZ)Z", "", "TAG", "Ljava/lang/String;", "", "AUTH_UI_SOFT_PAUSE_MS", "J", "AUTH_UI_END_GRACE_MS", "SCENE_WATCH_MS", "EXPANDED_WATCH_MS", "ENTER_DEDUPE_MS", "LEAVE_CONFIRM_MS", "EXPRESS_APP_SWITCH_SUPPRESS_MS", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.service.ExpressServiceImpl$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(boolean gesture, boolean appOn, boolean prereq, boolean newUser, boolean expressSwitch) {
            if (!gesture || !appOn || !prereq) {
                return false;
            }
            if (newUser) {
                return true;
            }
            return expressSwitch;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/express/service/ExpressServiceImpl$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "ctx", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        public b() {
        }

        public static final void b(ExpressServiceImpl expressServiceImpl, String str) {
            expressServiceImpl.U(str, TriggerType.ON_DESTROY);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context ctx, Intent intent) {
            final String schemeSpecificPart;
            kotlin.jvm.internal.p.i(ctx, "ctx");
            kotlin.jvm.internal.p.i(intent, "intent");
            Uri data = intent.getData();
            if (data == null || (schemeSpecificPart = data.getSchemeSpecificPart()) == null || !kotlin.jvm.internal.p.d(schemeSpecificPart, L5.b.INSTANCE.c())) {
                return;
            }
            Log.i(ExpressServiceImpl.TAG, "package removed=" + schemeSpecificPart + " while in scene, force leave");
            Handler handler = ExpressServiceImpl.this.main;
            final ExpressServiceImpl expressServiceImpl = ExpressServiceImpl.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.p
                @Override // java.lang.Runnable
                public final void run() {
                    ExpressServiceImpl.b.b(expressServiceImpl, schemeSpecificPart);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/express/service/ExpressServiceImpl$c", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L5.b bVar = L5.b.INSTANCE;
            String strC = bVar.c();
            if (strC == null) {
                return;
            }
            boolean zR = ExpressServiceImpl.this.R();
            String strB = bVar.b();
            boolean zP = ExpressServiceImpl.this.P();
            com.stepos.ailauncher.express.capsule.h hVar = ExpressServiceImpl.this.capsule;
            Boolean boolValueOf = hVar != null ? Boolean.valueOf(hVar.D()) : null;
            com.stepos.ailauncher.express.capsule.h hVar2 = ExpressServiceImpl.this.capsule;
            Log.d(ExpressServiceImpl.TAG, "sceneWatch: check pkg=" + strC + " activity=" + strB + " sceneOnTop=" + zR + " authWindowActive=" + zP + " showing=" + boolValueOf + " expanded=" + (hVar2 != null ? Boolean.valueOf(hVar2.C()) : null));
            if (zR) {
                com.stepos.ailauncher.express.capsule.h hVar3 = ExpressServiceImpl.this.capsule;
                ExpressServiceImpl.this.main.postDelayed(this, (hVar3 == null || !hVar3.C()) ? 200L : 50L);
                return;
            }
            com.stepos.ailauncher.express.capsule.h hVar4 = ExpressServiceImpl.this.capsule;
            if (hVar4 == null || !hVar4.C()) {
                ExpressServiceImpl.this.g0(strC, "scene-watch");
            } else {
                ExpressServiceImpl.this.I(strC, "expanded-scene-left");
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0017\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/stepos/ailauncher/express/service/ExpressServiceImpl$d", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "", "text", "LY8/t;", "onPartialResult", "(Ljava/lang/String;)V", "onFinalResult", "", "code", "message", "onError", "(ILjava/lang/String;)V", "onRecordingStarted", "()V", "onSpeechDetected", "onRecordingStopped", "", "data", "onAudioFrame", "([S)V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements AsrCallback {
        public d() {
        }

        public static final void e(int i10, String str, ExpressServiceImpl expressServiceImpl) {
            Log.w(ExpressServiceImpl.TAG, "asr error " + i10 + ": " + str + " (listening=" + expressServiceImpl.listening + ")");
            if (expressServiceImpl.listening) {
                expressServiceImpl.listening = false;
                Context context = expressServiceImpl.appContext;
                Context context2 = null;
                if (context == null) {
                    kotlin.jvm.internal.p.A("appContext");
                    context = null;
                }
                Context context3 = expressServiceImpl.appContext;
                if (context3 == null) {
                    kotlin.jvm.internal.p.A("appContext");
                } else {
                    context2 = context3;
                }
                Toast.makeText(context, context2.getString(R$string.express_error_asr, Integer.valueOf(i10)), 0).show();
                com.stepos.ailauncher.express.capsule.h hVar = expressServiceImpl.capsule;
                if (hVar != null) {
                    hVar.t();
                }
            }
        }

        public static final void f(ExpressServiceImpl expressServiceImpl, String str) {
            if (expressServiceImpl.listening) {
                expressServiceImpl.listening = false;
                if (H.x0(str)) {
                    com.stepos.ailauncher.express.capsule.h hVar = expressServiceImpl.capsule;
                    if (hVar != null) {
                        hVar.t();
                        return;
                    }
                    return;
                }
                J5.a.INSTANCE.i(str.length());
                ExpressOrchestrator expressOrchestrator = expressServiceImpl.orchestrator;
                if (expressOrchestrator != null) {
                    expressOrchestrator.j(str);
                }
            }
        }

        public static final void g(ExpressServiceImpl expressServiceImpl) {
            com.stepos.ailauncher.express.capsule.h hVar;
            if (expressServiceImpl.listening && (hVar = expressServiceImpl.capsule) != null) {
                hVar.w();
            }
        }

        public static final void h(ExpressServiceImpl expressServiceImpl) {
            com.stepos.ailauncher.express.capsule.h hVar;
            if (expressServiceImpl.listening && (hVar = expressServiceImpl.capsule) != null) {
                hVar.v();
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onAudioFrame(short[] data) {
            kotlin.jvm.internal.p.i(data, "data");
            com.stepos.ailauncher.express.capsule.h hVar = ExpressServiceImpl.this.capsule;
            if (hVar != null) {
                hVar.x(data);
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onError(final int code, final String message) {
            kotlin.jvm.internal.p.i(message, "message");
            Handler handler = ExpressServiceImpl.this.main;
            final ExpressServiceImpl expressServiceImpl = ExpressServiceImpl.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.t
                @Override // java.lang.Runnable
                public final void run() {
                    ExpressServiceImpl.d.e(code, message, expressServiceImpl);
                }
            });
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onFinalResult(final String text) {
            kotlin.jvm.internal.p.i(text, "text");
            Handler handler = ExpressServiceImpl.this.main;
            final ExpressServiceImpl expressServiceImpl = ExpressServiceImpl.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.r
                @Override // java.lang.Runnable
                public final void run() {
                    ExpressServiceImpl.d.f(expressServiceImpl, text);
                }
            });
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onPartialResult(String text) {
            kotlin.jvm.internal.p.i(text, "text");
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onRecordingStarted() {
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onRecordingStopped() {
            Handler handler = ExpressServiceImpl.this.main;
            final ExpressServiceImpl expressServiceImpl = ExpressServiceImpl.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.s
                @Override // java.lang.Runnable
                public final void run() {
                    ExpressServiceImpl.d.g(expressServiceImpl);
                }
            });
        }

        @Override // com.stepos.ailauncher.contract.api.speech.AsrCallback
        public void onSpeechDetected() {
            Handler handler = ExpressServiceImpl.this.main;
            final ExpressServiceImpl expressServiceImpl = ExpressServiceImpl.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.q
                @Override // java.lang.Runnable
                public final void run() {
                    ExpressServiceImpl.d.h(expressServiceImpl);
                }
            });
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.service.ExpressServiceImpl$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements p9.p<String, String, Y8.t> {
        public AnonymousClass2(Object obj) {
            super(2, obj, ExpressServiceImpl.class, "onEnterScene", "onEnterScene(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Y8.t invoke(String str, String str2) {
            l(str, str2);
            return Y8.t.f7040a;
        }

        public final void l(String p02, String str) {
            kotlin.jvm.internal.p.i(p02, "p0");
            ((ExpressServiceImpl) this.receiver).S(p02, str);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.service.ExpressServiceImpl$init$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements p9.p<String, TriggerType, Y8.t> {
        public AnonymousClass3(Object obj) {
            super(2, obj, ExpressServiceImpl.class, "onLeaveScene", "onLeaveScene(Ljava/lang/String;Lcom/stepos/ability/screenops/TriggerType;)V", 0);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Y8.t invoke(String str, TriggerType triggerType) {
            l(str, triggerType);
            return Y8.t.f7040a;
        }

        public final void l(String p02, TriggerType p12) {
            kotlin.jvm.internal.p.i(p02, "p0");
            kotlin.jvm.internal.p.i(p12, "p1");
            ((ExpressServiceImpl) this.receiver).U(p02, p12);
        }
    }

    public static final Y8.t K() {
        G.INSTANCE.s0(false);
        return Y8.t.f7040a;
    }

    public static final boolean L(ExpressServiceImpl expressServiceImpl) {
        return expressServiceImpl.R();
    }

    public static final Y8.t M(final ExpressServiceImpl expressServiceImpl) {
        expressServiceImpl.main.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.o
            @Override // java.lang.Runnable
            public final void run() {
                ExpressServiceImpl.N(this.f27140a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void N(ExpressServiceImpl expressServiceImpl) {
        expressServiceImpl.H();
    }

    public static final Y8.t O(final ExpressServiceImpl expressServiceImpl) {
        expressServiceImpl.main.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f27122a.f0();
            }
        });
        return Y8.t.f7040a;
    }

    public static final void T(ExpressServiceImpl expressServiceImpl) {
        expressServiceImpl.o0();
    }

    public static final void V(ExpressServiceImpl expressServiceImpl, String str, boolean z10) {
        if (expressServiceImpl.i0(str, z10)) {
            com.stepos.ailauncher.express.capsule.h hVar = expressServiceImpl.capsule;
            if (hVar != null) {
                hVar.H();
                return;
            }
            return;
        }
        expressServiceImpl.pendingListenAfterEnter = false;
        com.stepos.ailauncher.express.capsule.h hVar2 = expressServiceImpl.capsule;
        if (hVar2 == null || !hVar2.D()) {
            G.INSTANCE.s0(false);
        } else {
            expressServiceImpl.J();
        }
    }

    public static final Y8.t a0(final ExpressServiceImpl expressServiceImpl, final boolean z10) {
        expressServiceImpl.main.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.f
            @Override // java.lang.Runnable
            public final void run() {
                ExpressServiceImpl.b0(z10, expressServiceImpl);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void b0(boolean z10, ExpressServiceImpl expressServiceImpl) {
        if (z10) {
            expressServiceImpl.H();
        }
        com.stepos.ailauncher.express.capsule.h hVar = expressServiceImpl.capsule;
        if (hVar == null || !hVar.D()) {
            expressServiceImpl.pendingListenAfterEnter = true;
        } else {
            expressServiceImpl.o0();
        }
    }

    public static /* synthetic */ boolean d0(ExpressServiceImpl expressServiceImpl, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = AuthManager.INSTANCE.S();
        }
        return expressServiceImpl.c0(z10);
    }

    public static final void h0(ExpressServiceImpl expressServiceImpl, long j10, String str) {
        expressServiceImpl.leaveConfirmation = null;
        if (j10 != expressServiceImpl.sceneGeneration) {
            Log.d(TAG, "sceneWatch: stale leave confirmation generation=" + j10);
            return;
        }
        expressServiceImpl.pendingLeavePkg = null;
        if (kotlin.jvm.internal.p.d(L5.b.INSTANCE.c(), str)) {
            boolean zR = expressServiceImpl.R();
            Log.i(TAG, "sceneWatch: leave confirmation pkg=" + str + " sceneOnTop=" + zR);
            if (zR) {
                expressServiceImpl.l0();
            } else {
                expressServiceImpl.I(str, "leave-confirmed");
            }
        }
    }

    public static /* synthetic */ boolean j0(ExpressServiceImpl expressServiceImpl, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = AuthManager.INSTANCE.S();
        }
        return expressServiceImpl.i0(str, z10);
    }

    public static final Y8.t p0(final ExpressServiceImpl expressServiceImpl) {
        expressServiceImpl.main.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.g
            @Override // java.lang.Runnable
            public final void run() {
                ExpressServiceImpl.q0(this.f27129a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void q0(ExpressServiceImpl expressServiceImpl) {
        expressServiceImpl.H();
        com.stepos.ailauncher.express.capsule.h hVar = expressServiceImpl.capsule;
        if (hVar != null && hVar.D()) {
            expressServiceImpl.o0();
        } else {
            G.INSTANCE.s0(true);
            expressServiceImpl.pendingListenAfterEnter = true;
        }
    }

    public static final Y8.t r0(final ExpressServiceImpl expressServiceImpl, final boolean z10) {
        expressServiceImpl.main.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.a
            @Override // java.lang.Runnable
            public final void run() {
                ExpressServiceImpl.s0(this.f27120a, z10);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void s0(ExpressServiceImpl expressServiceImpl, boolean z10) {
        Context context;
        com.stepos.ailauncher.express.capsule.h hVar;
        expressServiceImpl.H();
        expressServiceImpl.G();
        String strC = L5.b.INSTANCE.c();
        if (strC != null && j0(expressServiceImpl, strC, false, 2, null) && (hVar = expressServiceImpl.capsule) != null) {
            hVar.H();
        }
        if (z10) {
            G g10 = G.INSTANCE;
            Context context2 = expressServiceImpl.appContext;
            if (context2 == null) {
                kotlin.jvm.internal.p.A("appContext");
                context = null;
            } else {
                context = context2;
            }
            G.z0(g10, context, PermScene.MICROPHONE, null, 4, null);
        }
    }

    public final void E() {
        this.softPauseUntilElapsed = SystemClock.elapsedRealtime() + 8000;
        com.stepos.ailauncher.common.utils.r.INSTANCE.O(8000L, "express-auth-begin");
    }

    public final void F() {
        String str = this.pendingLeavePkg;
        if (str != null) {
            Log.d(TAG, "sceneWatch: cancel leave confirmation pkg=" + str);
        }
        Runnable runnable = this.leaveConfirmation;
        if (runnable != null) {
            this.main.removeCallbacks(runnable);
        }
        this.leaveConfirmation = null;
        this.pendingLeavePkg = null;
    }

    public final void G() {
        this.pendingListenAfterEnter = false;
        G.INSTANCE.s0(false);
    }

    public final void H() {
        this.softPauseUntilElapsed = SystemClock.elapsedRealtime() + 800;
        com.stepos.ailauncher.common.utils.r.INSTANCE.O(2500L, "express-auth-end");
    }

    public final void I(String pkg, String reason) {
        L5.b bVar = L5.b.INSTANCE;
        if (kotlin.jvm.internal.p.d(pkg, bVar.c())) {
            n0();
            L5.a aVar = null;
            G.x(G.INSTANCE, "express-hard-leave:" + reason, false, 2, null);
            J();
            bVar.a();
            L5.a aVar2 = this.sceneRecoveryStore;
            if (aVar2 == null) {
                kotlin.jvm.internal.p.A("sceneRecoveryStore");
            } else {
                aVar = aVar2;
            }
            aVar.a();
            this.softPauseUntilElapsed = 0L;
            Log.i(TAG, "hardLeaveScene: pkg=" + pkg + " reason=" + reason);
        }
    }

    public final void J() {
        com.stepos.ailauncher.express.capsule.h hVar = this.capsule;
        if (hVar != null) {
            hVar.z();
        }
        m0();
        ExpressOrchestrator expressOrchestrator = this.orchestrator;
        if (expressOrchestrator != null) {
            expressOrchestrator.f();
        }
    }

    public final boolean P() {
        return SystemClock.elapsedRealtime() < this.softPauseUntilElapsed;
    }

    public final boolean Q() {
        Context context = this.appContext;
        if (context == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 2) == 2;
    }

    public final boolean R() {
        L5.b bVar = L5.b.INSTANCE;
        String strC = bVar.c();
        if (strC == null) {
            return false;
        }
        com.stepos.ailauncher.express.scene.d dVar = com.stepos.ailauncher.express.scene.d.INSTANCE;
        Context context = this.appContext;
        Context context2 = null;
        if (context == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        }
        Context context3 = this.appContext;
        if (context3 == null) {
            kotlin.jvm.internal.p.A("appContext");
        } else {
            context2 = context3;
        }
        String packageName = context2.getPackageName();
        kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
        return dVar.a(context, strC, packageName, P(), bVar.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.express.service.ExpressServiceImpl.S(java.lang.String, java.lang.String):void");
    }

    public final void U(String pkg, TriggerType trigger) {
        L5.b bVar = L5.b.INSTANCE;
        if (!kotlin.jvm.internal.p.d(pkg, bVar.c())) {
            Log.d(TAG, "onLeaveScene: stale pkg=" + pkg + " current=" + bVar.c() + " trigger=" + trigger);
            return;
        }
        boolean zP = P();
        com.stepos.ailauncher.express.capsule.h hVar = this.capsule;
        boolean z10 = false;
        if (hVar != null && hVar.C()) {
            z10 = true;
        }
        boolean zR = R();
        boolean zK0 = k0(trigger, zR);
        com.stepos.ailauncher.express.capsule.h hVar2 = this.capsule;
        Boolean boolValueOf = hVar2 != null ? Boolean.valueOf(hVar2.D()) : null;
        Log.i(TAG, "onLeaveScene: pkg=" + pkg + " trigger=" + trigger + " softPause=" + zK0 + " authWindowActive=" + zP + " expanded=" + z10 + " sceneOnTop=" + zR + " showing=" + boolValueOf + " pending=" + this.pendingListenAfterEnter);
        if (zK0) {
            l0();
            return;
        }
        I(pkg, "lifecycle-" + trigger);
    }

    public final void W() {
        m0();
        ExpressOrchestrator expressOrchestrator = this.orchestrator;
        if (expressOrchestrator != null) {
            expressOrchestrator.f();
        }
    }

    public final void X() {
        ISpeechService iSpeechService;
        if (this.listening && (iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class)) != null) {
            iSpeechService.stopAndFinalize();
        }
    }

    public final void Y() {
        J5.a.INSTANCE.a();
        U0.INSTANCE.y(true);
        Z();
    }

    public final void Z() {
        AuthManager authManager = AuthManager.INSTANCE;
        final boolean z10 = (authManager.S() && U0.INSTANCE.l()) ? false : true;
        if (z10) {
            E();
        }
        Context context = this.appContext;
        if (context == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        }
        authManager.Q(context, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.service.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExpressServiceImpl.a0(this.f27123a, z10);
            }
        });
    }

    public final boolean c0(boolean prereq) {
        U0 u02 = U0.INSTANCE;
        if (!u02.m() || prereq) {
            return false;
        }
        Log.i(TAG, "reconcileSwitch: prereq lost, auto-disable express switch");
        u02.v(false);
        return true;
    }

    public final void e0() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        b bVar = new b();
        Context context = this.appContext;
        if (context == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        }
        context.registerReceiver(bVar, intentFilter, 4);
    }

    public final void f0() {
        L5.a aVar = this.sceneRecoveryStore;
        L5.a aVar2 = null;
        if (aVar == null) {
            kotlin.jvm.internal.p.A("sceneRecoveryStore");
            aVar = null;
        }
        a.Scene sceneB = aVar.b();
        if (sceneB == null) {
            return;
        }
        com.stepos.ailauncher.express.scene.d dVar = com.stepos.ailauncher.express.scene.d.INSTANCE;
        Context context = this.appContext;
        if (context == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        }
        if (!dVar.b(context, sceneB.getPackageName(), sceneB.getActivityName())) {
            Log.i(TAG, "restoreCapsule: skip and clear, top is no longer scene pkg=" + sceneB.getPackageName() + " activity=" + sceneB.getActivityName());
            L5.a aVar3 = this.sceneRecoveryStore;
            if (aVar3 == null) {
                kotlin.jvm.internal.p.A("sceneRecoveryStore");
            } else {
                aVar2 = aVar3;
            }
            aVar2.a();
            return;
        }
        if (!j0(this, sceneB.getPackageName(), false, 2, null)) {
            Log.i(TAG, "restoreCapsule: skip and clear, capsule is disabled pkg=" + sceneB.getPackageName());
            L5.a aVar4 = this.sceneRecoveryStore;
            if (aVar4 == null) {
                kotlin.jvm.internal.p.A("sceneRecoveryStore");
            } else {
                aVar2 = aVar4;
            }
            aVar2.a();
            return;
        }
        L5.b.INSTANCE.e(sceneB.getPackageName(), sceneB.getActivityName());
        this.lastEnterPkg = sceneB.getPackageName();
        this.lastEnterAtElapsed = SystemClock.elapsedRealtime();
        com.stepos.ailauncher.express.capsule.h hVar = this.capsule;
        if (hVar != null) {
            hVar.G();
        }
        l0();
        Log.i(TAG, "restoreCapsule: restored idle capsule pkg=" + sceneB.getPackageName() + " activity=" + sceneB.getActivityName());
    }

    public final void g0(final String pkg, String reason) {
        if (kotlin.jvm.internal.p.d(this.pendingLeavePkg, pkg)) {
            Log.d(TAG, "sceneWatch: leave confirmation already pending pkg=" + pkg + " reason=" + reason);
            return;
        }
        Runnable runnable = this.leaveConfirmation;
        if (runnable != null) {
            this.main.removeCallbacks(runnable);
        }
        this.pendingLeavePkg = pkg;
        final long j10 = this.sceneGeneration;
        Log.i(TAG, "sceneWatch: leave candidate pkg=" + pkg + " reason=" + reason + " confirmAfterMs=150");
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.express.service.n
            @Override // java.lang.Runnable
            public final void run() {
                ExpressServiceImpl.h0(this.f27137a, j10, pkg);
            }
        };
        this.main.postDelayed(runnable2, 150L);
        this.leaveConfirmation = runnable2;
    }

    @Override // com.stepos.ailauncher.contract.api.express.IExpressService
    public List<String> getSupportedPackages() {
        return K5.b.INSTANCE.c();
    }

    public final boolean i0(String pkg, boolean prereq) {
        boolean zQ = Q();
        U0 u02 = U0.INSTANCE;
        boolean zN = u02.n(pkg);
        boolean z10 = !u02.o();
        boolean zM = u02.m();
        boolean zA = INSTANCE.a(zQ, zN, prereq, z10, zM);
        Log.d(TAG, "shouldShowCapsule=" + zA + " pkg=" + pkg + " (gesture=" + zQ + " appOn=" + zN + " prereq=" + prereq + " newUser=" + z10 + " expressSwitch=" + zM + ")");
        return zA;
    }

    @Override // com.stepos.ailauncher.contract.api.express.IExpressService
    public void init(Context context) {
        Context context2;
        kotlin.jvm.internal.p.i(context, "context");
        Log.d(TAG, "init: express service initializing");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        Context context3 = this.appContext;
        if (context3 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context3 = null;
        }
        this.sceneRecoveryStore = new L5.a(context3);
        W3.f fVar = W3.f.f6652a;
        Context context4 = this.appContext;
        if (context4 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context4 = null;
        }
        fVar.b(context4);
        Context context5 = this.appContext;
        if (context5 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context2 = null;
        } else {
            context2 = context5;
        }
        com.stepos.ailauncher.express.capsule.h hVar = new com.stepos.ailauncher.express.capsule.h(context2, new ExpressServiceImpl$init$cap$1(this), new ExpressServiceImpl$init$cap$2(this), new ExpressServiceImpl$init$cap$3(this), new ExpressServiceImpl$init$cap$4(this), new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.service.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExpressServiceImpl.K();
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.service.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ExpressServiceImpl.L(this.f27130a));
            }
        });
        this.capsule = hVar;
        Context context6 = this.appContext;
        if (context6 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context6 = null;
        }
        this.orchestrator = new ExpressOrchestrator(context6, hVar);
        AuthManager.INSTANCE.O0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.service.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExpressServiceImpl.M(this.f27131a);
            }
        });
        d0(this, false, 1, null);
        com.stepos.ailauncher.express.scene.a aVar = new com.stepos.ailauncher.express.scene.a(new AnonymousClass2(this), new AnonymousClass3(this));
        Log.d(TAG, "start");
        aVar.g();
        this.monitor = aVar;
        IHomeBarSysUiService iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class);
        if (iHomeBarSysUiService != null) {
            iHomeBarSysUiService.setOnHomeBarSysUiConnectedListener(new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.service.k
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ExpressServiceImpl.O(this.f27132a);
                }
            });
        }
        e0();
    }

    @Override // com.stepos.ailauncher.contract.api.express.IExpressService
    public boolean isEnabled() {
        return U0.INSTANCE.m();
    }

    public final boolean k0(TriggerType trigger, boolean sceneOnTop) {
        boolean z10 = trigger == TriggerType.ON_TOP_RESUMED_LOST || trigger == TriggerType.ON_PAUSE;
        com.stepos.ailauncher.express.scene.d dVar = com.stepos.ailauncher.express.scene.d.INSTANCE;
        boolean zP = P();
        com.stepos.ailauncher.express.capsule.h hVar = this.capsule;
        return dVar.e(z10, zP, hVar != null && hVar.C(), sceneOnTop, trigger == TriggerType.ON_STOP);
    }

    public final void l0() {
        this.main.removeCallbacks(this.sceneWatch);
        com.stepos.ailauncher.express.capsule.h hVar = this.capsule;
        long j10 = (hVar == null || !hVar.C()) ? 200L : 50L;
        this.main.postDelayed(this.sceneWatch, j10);
        Log.d(TAG, "sceneWatch: scheduled pkg=" + L5.b.INSTANCE.c() + " delayMs=" + j10);
    }

    public final void m0() {
        if (this.listening) {
            this.listening = false;
            ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
            if (iSpeechService != null) {
                iSpeechService.cancelAsr();
            }
        }
    }

    public final void n0() {
        this.main.removeCallbacks(this.sceneWatch);
        Runnable runnable = this.leaveConfirmation;
        if (runnable != null) {
            this.main.removeCallbacks(runnable);
        }
        this.leaveConfirmation = null;
        this.pendingLeavePkg = null;
    }

    public final void o0() {
        Context context;
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService == null) {
            G();
            return;
        }
        if (this.listening) {
            iSpeechService.stopAndFinalize();
            return;
        }
        I i10 = I.INSTANCE;
        Context context2 = this.appContext;
        Context context3 = null;
        if (context2 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context2 = null;
        }
        if (!i10.b(context2)) {
            Context context4 = this.appContext;
            if (context4 == null) {
                kotlin.jvm.internal.p.A("appContext");
            } else {
                context3 = context4;
            }
            Toast.makeText(context3, R$string.express_error_network, 0).show();
            G();
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        Context context5 = this.appContext;
        if (context5 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context5 = null;
        }
        if (!authManager.p0(context5)) {
            G();
            return;
        }
        if (C3185b.INSTANCE.a(PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
            this.listening = true;
            com.stepos.ailauncher.express.capsule.h hVar = this.capsule;
            if (hVar != null && hVar.N()) {
                G.INSTANCE.s0(true);
                l0();
            }
            J5.a.INSTANCE.h();
            iSpeechService.startListening(new d());
            return;
        }
        E();
        G g10 = G.INSTANCE;
        g10.u0(true);
        Context context6 = this.appContext;
        if (context6 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        } else {
            context = context6;
        }
        G.F(g10, context, PermScene.MICROPHONE, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.service.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExpressServiceImpl.p0(this.f27125a);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.express.service.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ExpressServiceImpl.r0(this.f27126a, ((Boolean) obj).booleanValue());
            }
        }, 4, null);
    }

    @Override // com.stepos.ailauncher.contract.api.express.IExpressService
    public void onSettingsChanged() {
        final boolean zS = AuthManager.INSTANCE.S();
        if (c0(zS)) {
            return;
        }
        com.stepos.ailauncher.express.scene.a aVar = this.monitor;
        if (aVar != null) {
            aVar.f(zS);
        }
        final String strC = L5.b.INSTANCE.c();
        if (strC == null) {
            return;
        }
        this.main.post(new Runnable() { // from class: com.stepos.ailauncher.express.service.l
            @Override // java.lang.Runnable
            public final void run() {
                ExpressServiceImpl.V(this.f27133a, strC, zS);
            }
        });
    }

    @Override // com.stepos.ailauncher.contract.api.express.IExpressService
    public boolean shouldSuppressAiKeyWake() {
        return this.listening && L5.b.INSTANCE.c() != null;
    }
}
