package com.stepos.ailauncher.chat.manager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.blankj.utilcode.util.ToastUtils;
import com.stepos.agentframework.adapter.bff.AuthInfo;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.TransferActivity;
import com.stepos.ailauncher.chat.api.VMApi;
import com.stepos.ailauncher.chat.manager.ClawVMManager;
import com.stepos.ailauncher.chat.model.ReInstallVMResult;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.common.ReInstallMode;
import kotlin.C4848b;
import kotlin.Function2;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001G\u0018\u0000 K2\u00020\u0001:\u0002LMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b$\u0010 J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b%\u0010 J=\u0010+\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\r2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0004\b+\u0010,J\"\u0010.\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\rH\u0086@¢\u0006\u0004\b.\u0010/J(\u00101\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\r2\u0006\u00100\u001a\u00020\rH\u0086@¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u00104¨\u0006N"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/ClawVMManager;", "", "<init>", "()V", "", "w", "()Z", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/chat/manager/ClawVMManager$b;", "outerCallback", "n", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/manager/ClawVMManager$b;)Z", "", M5.b.CREDENTIAL_TOKEN, "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;)V", "Landroid/app/Activity;", "activity", "x", "(Landroid/app/Activity;)V", "m", "(Landroid/content/Context;)Z", "Lkotlin/Function1;", "callback", "z", "(Lp9/l;)V", "inviteCode", "q", "(Ljava/lang/String;Ljava/lang/String;)V", "D", "(Landroid/content/Context;)V", "action", "y", "(Landroid/content/Context;Ljava/lang/String;)V", "s", "t", "Lcom/stepos/common/ReInstallMode;", "mode", "deleteMemory", "Lcom/stepos/ailauncher/chat/model/ReInstallVMResult;", "onResult", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/content/Context;Lcom/stepos/common/ReInstallMode;Ljava/lang/String;Lp9/l;)V", "fileType", "C", "(Landroid/content/Context;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "G", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/manager/ClawVMManager$b;", "Lcom/stepos/ailauncher/chat/api/VMApi;", "vmapi$delegate", "LY8/h;", "u", "()Lcom/stepos/ailauncher/chat/api/VMApi;", "vmapi", "", "lastLoginLaunchAt", "J", "Lcom/stepos/ailauncher/foundation/account/i;", "accountCallBack", "Lcom/stepos/ailauncher/foundation/account/i;", "Landroid/os/Handler;", "foregroundGateHandler", "Landroid/os/Handler;", "isLoggingIn", "Z", "com/stepos/ailauncher/chat/manager/ClawVMManager$d", "accountListener", "Lcom/stepos/ailauncher/chat/manager/ClawVMManager$d;", "lastChatToken", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClawVMManager {
    private static final long FOREGROUND_SETTLE_MS = 500;
    private static final long LOGIN_LAUNCH_MIN_INTERVAL_MS = 3000;
    private boolean isLoggingIn;
    private String lastChatToken;
    private volatile long lastLoginLaunchAt;
    private b outerCallback;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<ClawVMManager> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.d0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ClawVMManager.v();
        }
    });
    private final String TAG = "VMManager";

    /* renamed from: vmapi$delegate, reason: from kotlin metadata */
    private final Y8.h vmapi = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.f0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ClawVMManager.F();
        }
    });
    private final com.stepos.ailauncher.foundation.account.i accountCallBack = new c();
    private final Handler foregroundGateHandler = new Handler(Looper.getMainLooper());
    private final d accountListener = new d();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/ClawVMManager$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/manager/ClawVMManager;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/manager/ClawVMManager;", "instance", "", "FOREGROUND_SETTLE_MS", "J", "LOGIN_LAUNCH_MIN_INTERVAL_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.ClawVMManager$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ClawVMManager a() {
            return (ClawVMManager) ClawVMManager.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/ClawVMManager$b;", "", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/manager/ClawVMManager$c", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements com.stepos.ailauncher.foundation.account.i {
        public c() {
        }

        public static final void c(ClawVMManager clawVMManager, b bVar) {
            if (S0.INSTANCE.c() || clawVMManager.w()) {
                bVar.a();
            } else {
                Log.d(clawVMManager.TAG, "skip onLoginSuccess: app not foreground (out-of-app login)");
            }
        }

        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            String token;
            Log.d(ClawVMManager.this.TAG, "accountStateChanged: " + (accountInfo != null ? accountInfo.getAccountId() : null) + ", " + (accountInfo != null ? accountInfo.getToken() : null));
            if (accountInfo == null || (token = accountInfo.getToken()) == null) {
                return;
            }
            ClawVMManager.r(ClawVMManager.this, token, null, 2, null);
            ClawVMManager.this.E(token);
            final b bVar = ClawVMManager.this.outerCallback;
            if (bVar == null) {
                return;
            }
            ClawVMManager.this.outerCallback = null;
            Handler handler = ClawVMManager.this.foregroundGateHandler;
            final ClawVMManager clawVMManager = ClawVMManager.this;
            handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.h0
                @Override // java.lang.Runnable
                public final void run() {
                    ClawVMManager.c.c(clawVMManager, bVar);
                }
            }, 500L);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/chat/manager/ClawVMManager$d", "Lcom/stepos/ailauncher/foundation/account/j;", "Landroid/content/Intent;", "intent", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Intent;)V", "", "code", "", C3081a.ERROR_MSG, "accountName", "c", "(ILjava/lang/String;Ljava/lang/String;)V", M5.b.CREDENTIAL_TOKEN, "secret", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements com.stepos.ailauncher.foundation.account.j {
        public d() {
        }

        @Override // com.stepos.ailauncher.foundation.account.j
        public void a(String token, String secret) {
            ClawVMManager.this.isLoggingIn = false;
            if (token != null && token.length() != 0) {
                com.stepos.ailauncher.foundation.account.f.INSTANCE.a(token, secret);
                return;
            }
            Log.d(ClawVMManager.this.TAG, "onSuccess: token is null");
            ClawVMManager.this.outerCallback = null;
            S0.INSTANCE.a("login_success_without_token");
            ToastUtils.w(com.blankj.utilcode.util.o.b(R$string.login_failed_token), new Object[0]);
        }

        @Override // com.stepos.ailauncher.foundation.account.j
        public void b(Intent intent) {
            com.stepos.ailauncher.foundation.account.f.INSTANCE.b(intent);
        }

        @Override // com.stepos.ailauncher.foundation.account.j
        public void c(int code, String errorMsg, String accountName) {
            ClawVMManager.this.isLoggingIn = false;
            ClawVMManager.this.outerCallback = null;
            S0.INSTANCE.a("login_failed_" + code);
            com.stepos.ailauncher.foundation.account.f.INSTANCE.c(code, errorMsg, accountName);
        }
    }

    public static final void B(InterfaceC5074l interfaceC5074l, Context context) {
        interfaceC5074l.invoke(new ReInstallVMResult(0, null, context.getString(R$string.logging_in), 3, null));
    }

    public static final VMApi F() {
        return new VMApi();
    }

    public static /* synthetic */ boolean o(ClawVMManager clawVMManager, Context context, b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        return clawVMManager.n(context, bVar);
    }

    public static final Y8.t p(ClawVMManager clawVMManager, Context context, Activity it) {
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(clawVMManager.accountCallBack);
        clawVMManager.x(it);
        WakeService.Companion.a0(WakeService.INSTANCE, context, false, 2, null);
        it.finish();
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void r(ClawVMManager clawVMManager, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        clawVMManager.q(str, str2);
    }

    public static final ClawVMManager v() {
        return new ClawVMManager();
    }

    public final void A(final Context context, ReInstallMode mode, String deleteMemory, final InterfaceC5074l<? super ReInstallVMResult, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(deleteMemory, "deleteMemory");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        if (o(this, context, null, 2, null)) {
            Function2.a(new ClawVMManager$reInstallVM$2(mode, this, deleteMemory, onResult, null));
        } else {
            this.foregroundGateHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.manager.g0
                @Override // java.lang.Runnable
                public final void run() {
                    ClawVMManager.B(onResult, context);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(android.content.Context r6, java.lang.String r7, e9.InterfaceC4014c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.chat.manager.ClawVMManager$readCoreFile$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.chat.manager.ClawVMManager$readCoreFile$1 r0 = (com.stepos.ailauncher.chat.manager.ClawVMManager$readCoreFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ClawVMManager$readCoreFile$1 r0 = new com.stepos.ailauncher.chat.manager.ClawVMManager$readCoreFile$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            android.content.Context r6 = (android.content.Context) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Exception -> L33
            goto L69
        L33:
            r6 = move-exception
            goto L8b
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.C4849c.b(r8)
            r8 = 2
            boolean r8 = o(r5, r6, r4, r8, r4)
            if (r8 != 0) goto L54
            int r5 = com.stepos.ailauncher.chat.R$string.logging_in
            java.lang.String r5 = com.blankj.utilcode.util.o.b(r5)
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.blankj.utilcode.util.ToastUtils.w(r5, r6)
            return r4
        L54:
            com.stepos.agentframework.adapter.ApiManager r8 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Exception -> L33
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Exception -> L33
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Exception -> L33
            r0.L$0 = r6     // Catch: java.lang.Exception -> L33
            r0.L$1 = r7     // Catch: java.lang.Exception -> L33
            r0.label = r3     // Catch: java.lang.Exception -> L33
            java.lang.Object r8 = r8.Y(r2, r7, r0)     // Catch: java.lang.Exception -> L33
            if (r8 != r1) goto L69
            return r1
        L69:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L33
            java.lang.String r6 = r5.TAG     // Catch: java.lang.Exception -> L33
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r0.<init>()     // Catch: java.lang.Exception -> L33
            java.lang.String r1 = "readCoreFile("
            r0.append(r1)     // Catch: java.lang.Exception -> L33
            r0.append(r7)     // Catch: java.lang.Exception -> L33
            java.lang.String r7 = ") result: "
            r0.append(r7)     // Catch: java.lang.Exception -> L33
            r0.append(r8)     // Catch: java.lang.Exception -> L33
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Exception -> L33
            android.util.Log.d(r6, r7)     // Catch: java.lang.Exception -> L33
            return r8
        L8b:
            java.lang.String r5 = r5.TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "readCoreFile error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.w(r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ClawVMManager.C(android.content.Context, java.lang.String, e9.c):java.lang.Object");
    }

    public final void D(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (o(this, context, null, 2, null)) {
            Function2.a(new ClawVMManager$restartVM$1(this, null));
        } else {
            ToastUtils.w(com.blankj.utilcode.util.o.b(R$string.logging_in), new Object[0]);
        }
    }

    public final void E(String token) {
        kotlin.jvm.internal.p.i(token, "token");
        if (kotlin.jvm.internal.p.d(this.lastChatToken, token)) {
            return;
        }
        Log.d(this.TAG, "updateChatToken: hasToken=" + (token.length() > 0));
        this.lastChatToken = token;
        new AuthInfo(token, "", null, null, 0, null, null, null, null, null, 1020, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(android.content.Context r6, java.lang.String r7, java.lang.String r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.chat.manager.ClawVMManager$writeCoreFile$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.chat.manager.ClawVMManager$writeCoreFile$1 r0 = (com.stepos.ailauncher.chat.manager.ClawVMManager$writeCoreFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ClawVMManager$writeCoreFile$1 r0 = new com.stepos.ailauncher.chat.manager.ClawVMManager$writeCoreFile$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r6 = r0.L$2
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            android.content.Context r6 = (android.content.Context) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Exception -> L38
            goto L74
        L38:
            r6 = move-exception
            goto La7
        L3a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L42:
            kotlin.C4849c.b(r9)
            r9 = 2
            r2 = 0
            boolean r9 = o(r5, r6, r2, r9, r2)
            if (r9 != 0) goto L5d
            int r5 = com.stepos.ailauncher.chat.R$string.logging_in
            java.lang.String r5 = com.blankj.utilcode.util.o.b(r5)
            java.lang.Object[] r6 = new java.lang.Object[r4]
            com.blankj.utilcode.util.ToastUtils.w(r5, r6)
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            return r5
        L5d:
            com.stepos.agentframework.adapter.ApiManager r9 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Exception -> L38
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Exception -> L38
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Exception -> L38
            r0.L$0 = r6     // Catch: java.lang.Exception -> L38
            r0.L$1 = r7     // Catch: java.lang.Exception -> L38
            r0.L$2 = r8     // Catch: java.lang.Exception -> L38
            r0.label = r3     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = r9.t0(r2, r7, r8, r0)     // Catch: java.lang.Exception -> L38
            if (r9 != r1) goto L74
            return r1
        L74:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Exception -> L38
            boolean r6 = r9.booleanValue()     // Catch: java.lang.Exception -> L38
            java.lang.String r9 = r5.TAG     // Catch: java.lang.Exception -> L38
            int r8 = r8.length()     // Catch: java.lang.Exception -> L38
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r0.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = "writeCoreFile("
            r0.append(r1)     // Catch: java.lang.Exception -> L38
            r0.append(r7)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = ") contentLen="
            r0.append(r7)     // Catch: java.lang.Exception -> L38
            r0.append(r8)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = " result="
            r0.append(r7)     // Catch: java.lang.Exception -> L38
            r0.append(r6)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Exception -> L38
            android.util.Log.d(r9, r7)     // Catch: java.lang.Exception -> L38
            r4 = r6
            goto Lbe
        La7:
            java.lang.String r5 = r5.TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "writeCoreFile error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.w(r5, r6)
        Lbe:
            java.lang.Boolean r5 = g9.C4109a.a(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ClawVMManager.G(android.content.Context, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final boolean m(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        boolean zO = o(this, context, null, 2, null);
        Boolean boolValueOf = Boolean.valueOf(zO);
        if (!zO) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            Function2.a(new ClawVMManager$checkAndCreateVM$2$1(this, null));
        }
        return com.stepos.ailauncher.foundation.account.f.INSTANCE.v();
    }

    public final boolean n(final Context context, b outerCallback) {
        kotlin.jvm.internal.p.i(context, "context");
        if (outerCallback != null) {
            this.outerCallback = outerCallback;
        }
        com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
        if (fVar.v()) {
            Log.d(this.TAG, "checkAccount: has logged, uid: " + fVar.k());
            return true;
        }
        Log.d(this.TAG, "checkAccount: no logged");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = jElapsedRealtime - this.lastLoginLaunchAt;
        if (this.lastLoginLaunchAt == 0 || j10 >= 3000) {
            this.lastLoginLaunchAt = jElapsedRealtime;
            TransferActivity.INSTANCE.h(context, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.e0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ClawVMManager.p(this.f25585a, context, (Activity) obj);
                }
            });
            return false;
        }
        Log.d(this.TAG, "checkAccount: skip login page, launched " + j10 + "ms ago");
        return false;
    }

    public final void q(String token, String inviteCode) {
        kotlin.jvm.internal.p.i(token, "token");
        Function2.a(new ClawVMManager$createVM$1(this, token, inviteCode, null));
    }

    public final void s(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (o(this, context, null, 2, null)) {
            Function2.a(new ClawVMManager$deleteVM$1(this, null));
        } else {
            ToastUtils.w(com.blankj.utilcode.util.o.b(R$string.logging_in), new Object[0]);
        }
    }

    public final void t(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (o(this, context, null, 2, null)) {
            Function2.a(new ClawVMManager$doctorFixVM$1(this, null));
        } else {
            ToastUtils.w(com.blankj.utilcode.util.o.b(R$string.logging_in), new Object[0]);
        }
    }

    public final VMApi u() {
        return (VMApi) this.vmapi.getValue();
    }

    public final boolean w() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo.importance == 100;
        } catch (Throwable th) {
            Log.w(this.TAG, "isSelfProcessForeground error: " + th);
            return false;
        }
    }

    public final void x(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
        if (fVar.v()) {
            Log.d(this.TAG, "checkAccount: has logged");
            return;
        }
        Log.d(this.TAG, "checkAccount: no logged");
        this.isLoggingIn = true;
        fVar.m(null, this.accountListener);
    }

    public final void y(Context context, String action) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(action, "action");
        if (o(this, context, null, 2, null)) {
            Function2.a(new ClawVMManager$powerVM$1(this, action, null));
        } else {
            ToastUtils.w(com.blankj.utilcode.util.o.b(R$string.logging_in), new Object[0]);
        }
    }

    public final void z(InterfaceC5074l<? super String, Y8.t> callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        Function2.a(new ClawVMManager$queryVMStatus$1(this, callback, null));
    }
}
