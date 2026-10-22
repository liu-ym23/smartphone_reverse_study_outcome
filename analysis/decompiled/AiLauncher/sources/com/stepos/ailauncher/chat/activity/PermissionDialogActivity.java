package com.stepos.ailauncher.chat.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$bool;
import com.stepos.ailauncher.chat.activity.PermissionDialogActivity;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.sheet.C2733d;
import com.stepos.ailauncher.chat.sheet.C2740k;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.common.permission.C3185b;
import com.stepos.ailauncher.common.permission.C3193j;
import com.stepos.ailauncher.common.permission.PermScene;
import com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 92\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010'R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u000bR\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u000bR\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010\u000bR \u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0006058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PermissionDialogActivity;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Q", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Z", "Landroid/content/Intent;", "intent", "a0", "(Landroid/content/Intent;)V", "I", "P", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "hasFocus", "onWindowFocusChanged", "(Z)V", "isTopResumedActivity", "onTopResumedActivityChanged", "onResume", "onPause", "onDestroy", "c0", "H", "g0", "()Z", "", "reason", "f0", "(Ljava/lang/String;)V", "J", "e0", "M", "K", "N", "", "createdAtElapsed", "userInteracted", "awaitingExternalUi", "Ljava/lang/Runnable;", "focusLostFinish", "Ljava/lang/Runnable;", "emptyShellFinish", "recentsArmed", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "recentsListener", "Lp9/l;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class PermissionDialogActivity extends b.q {
    private static final long EMPTY_SHELL_CHECK_MS = 400;
    private static final long EPHEMERAL_PAUSE_MS = 400;
    private static final long FOCUS_GUARD_WINDOW_MS = 5000;
    private static final long FOCUS_LOST_GRACE_MS = 1200;
    public static final String INTENT_KEY_EXPRESS_REQUIRE_MIC = "express_require_mic";
    public static final String INTENT_KEY_HOST_TASK_ID = "host_task_id";
    public static final String INTENT_KEY_OPEN_CHAT_AFTER_AUTH = "open_chat_after_auth";
    private static final String TAG = "PermissionDialog";
    private static PermissionDialogActivity instance;
    private static int isStart;
    private boolean awaitingExternalUi;
    private long createdAtElapsed;
    private boolean recentsArmed;
    private boolean userInteracted;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_KEY_SOURCE = "page_source";
    private static final String SOURCE_HOME = "source_home";
    private static final String SOURCE_INIT = "source_init";
    private static final String SOURCE_EXPRESS_AUTH = "source_express_auth";
    private final Runnable focusLostFinish = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.j1
        @Override // java.lang.Runnable
        public final void run() {
            PermissionDialogActivity.O(this.f24837a);
        }
    };
    private final Runnable emptyShellFinish = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.k1
        @Override // java.lang.Runnable
        public final void run() {
            PermissionDialogActivity.L(this.f24840a);
        }
    };
    private final InterfaceC5074l<RecentsWindowMonitor.RecentsState, Y8.t> recentsListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.l1
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return PermissionDialogActivity.b0(this.f24844a, (RecentsWindowMonitor.RecentsState) obj);
        }
    };

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0086D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00178\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u00178\u0006X\u0086D¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0014\u0010.\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\u0019R\u0014\u0010/\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\u0019R\u0014\u00100\u001a\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\u0019R\u0014\u00102\u001a\u0002018\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u0002018\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u0002018\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00106\u001a\u0002018\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00103¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/PermissionDialogActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Landroid/content/Intent;", "LY8/t;", "configure", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Lp9/l;)V", "", "instanceUsable", "dialogShowing", "m", "(ZZ)Z", "intent", "n", "(Landroid/content/Context;Landroid/content/Intent;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)I", "", "INTENT_KEY_SOURCE", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "SOURCE_HOME", "e", "SOURCE_EXPRESS_AUTH", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/chat/activity/PermissionDialogActivity;", "instance", "Lcom/stepos/ailauncher/chat/activity/PermissionDialogActivity;", "c", "()Lcom/stepos/ailauncher/chat/activity/PermissionDialogActivity;", "k", "(Lcom/stepos/ailauncher/chat/activity/PermissionDialogActivity;)V", "isStart", "I", "f", "()I", "l", "(I)V", "TAG", "INTENT_KEY_EXPRESS_REQUIRE_MIC", "INTENT_KEY_HOST_TASK_ID", "INTENT_KEY_OPEN_CHAT_AFTER_AUTH", "", "EPHEMERAL_PAUSE_MS", "J", "FOCUS_LOST_GRACE_MS", "FOCUS_GUARD_WINDOW_MS", "EMPTY_SHELL_CHECK_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.PermissionDialogActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void h(Companion companion, Context context, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.q1
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return PermissionDialogActivity.Companion.i((Intent) obj2);
                    }
                };
            }
            companion.g(context, interfaceC5074l);
        }

        public static final Y8.t i(Intent intent) {
            kotlin.jvm.internal.p.i(intent, "<this>");
            return Y8.t.f7040a;
        }

        public final String b() {
            return PermissionDialogActivity.INTENT_KEY_SOURCE;
        }

        public final PermissionDialogActivity c() {
            return PermissionDialogActivity.instance;
        }

        public final String d() {
            return PermissionDialogActivity.SOURCE_EXPRESS_AUTH;
        }

        public final String e() {
            return PermissionDialogActivity.SOURCE_HOME;
        }

        public final int f() {
            return PermissionDialogActivity.isStart;
        }

        public final void g(Context context, InterfaceC5074l<? super Intent, Y8.t> configure) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(configure, "configure");
            PermissionDialogActivity permissionDialogActivityC = c();
            boolean z10 = (permissionDialogActivityC == null || permissionDialogActivityC.isFinishing() || permissionDialogActivityC.isDestroyed()) ? false : true;
            if (m(z10, AuthManager.INSTANCE.w0())) {
                C4148a.d(PermissionDialogActivity.TAG, "launch skipped: auth dialog already showing", false, 4, null);
                return;
            }
            if (z10) {
                C4148a.u(PermissionDialogActivity.TAG, "launch: finishing empty permission shell", false, 4, null);
                kotlin.jvm.internal.p.f(permissionDialogActivityC);
                permissionDialogActivityC.overridePendingTransition(0, 0);
                permissionDialogActivityC.finish();
            } else if (f() != 0) {
                C4148a.u(PermissionDialogActivity.TAG, "launch: reset stale isStart instance=" + permissionDialogActivityC, false, 4, null);
            }
            l(1);
            k(null);
            Intent intent = new Intent(context, (Class<?>) PermissionDialogActivity.class);
            configure.invoke(intent);
            if (kotlin.jvm.internal.p.d(intent.getStringExtra(b()), d())) {
                intent.setClass(context, ExpressAuthDialogActivity.class);
                C4148a.k(PermissionDialogActivity.TAG, "launch express translucent shell", false, 4, null);
            }
            n(context, intent);
        }

        public final int j(Context context) {
            C3193j c3193j = C3193j.INSTANCE;
            Activity activityM = c3193j.m(context);
            if (activityM != null) {
                Integer numValueOf = Integer.valueOf(activityM.getTaskId());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
            }
            if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
                return -1;
            }
            Integer numValueOf2 = Integer.valueOf(c3193j.d(context));
            Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
            return num != null ? num.intValue() : C2740k.INSTANCE.d(context);
        }

        public final void k(PermissionDialogActivity permissionDialogActivity) {
            PermissionDialogActivity.instance = permissionDialogActivity;
        }

        public final void l(int i10) {
            PermissionDialogActivity.isStart = i10;
        }

        public final boolean m(boolean instanceUsable, boolean dialogShowing) {
            return instanceUsable && dialogShowing;
        }

        public final void n(Context context, Intent intent) {
            intent.addFlags(8388608);
            Integer numValueOf = Integer.valueOf(intent.getIntExtra(PermissionDialogActivity.INTENT_KEY_HOST_TASK_ID, -1));
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : j(context);
            Bundle bundleE = C2733d.e(C2733d.INSTANCE, iIntValue, false, false, 6, null);
            try {
                if (bundleE != null) {
                    if (!(context instanceof Activity)) {
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    context.startActivity(intent, bundleE);
                    C4148a.k(PermissionDialogActivity.TAG, "launch overlay hostTask=" + iIntValue + " source=" + (numValueOf != null ? "explicit" : "fallback"), false, 4, null);
                } else {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    context.startActivity(intent);
                    C4148a.u(PermissionDialogActivity.TAG, "launch overlay fallback NEW_TASK hostTask=" + iIntValue, false, 4, null);
                }
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    activity.overridePendingTransition(0, 0);
                }
            } catch (Throwable th) {
                C4148a.t(PermissionDialogActivity.TAG, "launch overlay failed, fallback NEW_TASK", th, false, 8, null);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$b", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AuthManager.a {
        public b() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            AuthManager.INSTANCE.f0();
            PermissionDialogActivity.this.finish();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() throws Resources.NotFoundException {
            PermissionDialogActivity.this.Q();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$c", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements AuthManager.a {
        public c() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            AuthManager.INSTANCE.f0();
            PermissionDialogActivity.this.finish();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() throws Resources.NotFoundException {
            PermissionDialogActivity.this.Q();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$d", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements AuthManager.a {
        public d() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            PermissionDialogActivity.this.finish();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() {
            PermissionDialogActivity.this.finish();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$e", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements AuthManager.a {
        public e() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            PermissionDialogActivity.this.finish();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() throws Resources.NotFoundException {
            IHomeBarSysUiService iHomeBarSysUiService;
            AuthManager authManager = AuthManager.INSTANCE;
            Context applicationContext = PermissionDialogActivity.this.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            boolean zO = AuthManager.O(authManager, applicationContext, false, false, 6, null);
            if (PermissionDialogActivity.this.getIntent().getBooleanExtra(PermissionDialogActivity.INTENT_KEY_OPEN_CHAT_AFTER_AUTH, false) && zO && (iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class)) != null) {
                iHomeBarSysUiService.openChatViewAfterAgentAuth();
            }
            PermissionDialogActivity.this.finish();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$f", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements AuthManager.a {
        public f() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            PermissionDialogActivity.this.c0();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() {
            PermissionDialogActivity.this.c0();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$g", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements AuthManager.a {
        public g() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            com.stepos.ailauncher.chat.manager.S0.INSTANCE.a("privacy_refused");
            PermissionDialogActivity.this.finish();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() {
            PermissionDialogActivity.this.P();
            PermissionDialogActivity.this.finish();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/activity/PermissionDialogActivity$h", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements AuthManager.a {
        public h() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
            com.stepos.ailauncher.chat.manager.S0.INSTANCE.a("agent_refused");
            PermissionDialogActivity.this.N();
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() {
            PermissionDialogActivity.this.I();
            PermissionDialogActivity.this.P();
            PermissionDialogActivity.this.finish();
        }
    }

    private final void J() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(this.focusLostFinish);
    }

    public static final void L(PermissionDialogActivity permissionDialogActivity) {
        if (permissionDialogActivity.isFinishing() || permissionDialogActivity.awaitingExternalUi || AuthManager.INSTANCE.w0()) {
            return;
        }
        C4148a.k(TAG, "empty-shell finish (no auth dialog showing)", false, 4, null);
        permissionDialogActivity.M();
    }

    public static final void O(PermissionDialogActivity permissionDialogActivity) {
        if (permissionDialogActivity.isFinishing() || permissionDialogActivity.isChangingConfigurations() || permissionDialogActivity.userInteracted || permissionDialogActivity.g0() || permissionDialogActivity.hasWindowFocus()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - permissionDialogActivity.createdAtElapsed;
        if (jElapsedRealtime > 5000) {
            return;
        }
        C4148a.k(TAG, "focus-lost finish aliveMs=" + jElapsedRealtime + " (no-focus ANR guard)", false, 4, null);
        permissionDialogActivity.M();
    }

    public static final Y8.t R(PermissionDialogActivity permissionDialogActivity) throws Resources.NotFoundException {
        permissionDialogActivity.awaitingExternalUi = false;
        if (!permissionDialogActivity.isFinishing()) {
            permissionDialogActivity.Q();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t S(PermissionDialogActivity permissionDialogActivity) throws Resources.NotFoundException {
        permissionDialogActivity.Q();
        return Y8.t.f7040a;
    }

    public static final Y8.t T(PermissionDialogActivity permissionDialogActivity) {
        AuthManager.INSTANCE.f0();
        permissionDialogActivity.finish();
        return Y8.t.f7040a;
    }

    public static final Y8.t U(PermissionDialogActivity permissionDialogActivity, boolean z10) {
        permissionDialogActivity.awaitingExternalUi = false;
        if (permissionDialogActivity.isFinishing()) {
            return Y8.t.f7040a;
        }
        if (z10) {
            InterfaceC5063a<Y8.t> interfaceC5063aI0 = AuthManager.INSTANCE.i0();
            if (interfaceC5063aI0 != null) {
                interfaceC5063aI0.invoke();
            }
        } else {
            AuthManager.INSTANCE.f0();
        }
        permissionDialogActivity.finish();
        return Y8.t.f7040a;
    }

    public static final Y8.t W(boolean z10, PermissionDialogActivity permissionDialogActivity) throws Resources.NotFoundException {
        if (z10) {
            IHomeBarSysUiService iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class);
            if (iHomeBarSysUiService != null) {
                iHomeBarSysUiService.openChatViewAfterAgentAuth();
            }
        } else {
            AuthManager authManager = AuthManager.INSTANCE;
            Context applicationContext = permissionDialogActivity.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            AuthManager.O(authManager, applicationContext, false, false, 6, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t X(PermissionDialogActivity permissionDialogActivity) {
        if (!permissionDialogActivity.isFinishing()) {
            permissionDialogActivity.finish();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Y(PermissionDialogActivity permissionDialogActivity) {
        if (!permissionDialogActivity.isFinishing()) {
            permissionDialogActivity.finish();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(PermissionDialogActivity permissionDialogActivity, RecentsWindowMonitor.RecentsState state) {
        kotlin.jvm.internal.p.i(state, "state");
        if (permissionDialogActivity.recentsArmed && (state == RecentsWindowMonitor.RecentsState.PEEK || state == RecentsWindowMonitor.RecentsState.OVERVIEW)) {
            permissionDialogActivity.K();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t d0(PermissionDialogActivity permissionDialogActivity, boolean z10) {
        permissionDialogActivity.awaitingExternalUi = false;
        if (!permissionDialogActivity.isFinishing()) {
            permissionDialogActivity.finish();
        }
        return Y8.t.f7040a;
    }

    private final void f0(String reason) {
        Window window;
        View decorView;
        if (isFinishing() || isChangingConfigurations() || this.userInteracted || g0()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.createdAtElapsed;
        if (jElapsedRealtime > 5000 || (window = getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(this.focusLostFinish);
        decorView.postDelayed(this.focusLostFinish, 1200L);
        C4148a.d(TAG, "schedule focus-lost finish reason=" + reason + " aliveMs=" + jElapsedRealtime, false, 4, null);
    }

    private final boolean g0() {
        AuthManager authManager = AuthManager.INSTANCE;
        return authManager.z0() || this.awaitingExternalUi || authManager.w0();
    }

    public final void H() throws Resources.NotFoundException {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setNavigationBarColor(0);
        boolean z10 = getResources().getBoolean(R$bool.chat_light_status_bar);
        new androidx.core.view.b0(getWindow(), getWindow().getDecorView()).d(z10);
        com.stepos.ailauncher.common.utils.H.c(getWindow(), z10);
    }

    public final void I() {
        sendBroadcast(new Intent(StepAssistantActivity.ACTION_AGENT_OPENED_FROM_DIALOG).setPackage(getPackageName()));
    }

    public final void K() {
        if (isFinishing()) {
            return;
        }
        C4148a.k(TAG, "recents gesture → finish overlay", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        AuthManager.INSTANCE.m0();
        N();
    }

    public final void M() {
        AuthManager.INSTANCE.m0();
        N();
    }

    public final void N() {
        if (isFinishing()) {
            return;
        }
        overridePendingTransition(0, 0);
        finish();
    }

    public final void P() {
        AuthManager authManager = AuthManager.INSTANCE;
        if (!authManager.e0()) {
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            authManager.t0(applicationContext);
            return;
        }
        com.stepos.ailauncher.chat.manager.S0 s02 = com.stepos.ailauncher.chat.manager.S0.INSTANCE;
        if (s02.c()) {
            s02.d(this);
            s02.a("permission_done");
        } else {
            WakeService.Companion companion = WakeService.INSTANCE;
            Intent intent = getIntent();
            kotlin.jvm.internal.p.h(intent, "getIntent(...)");
            companion.J1(this, intent);
        }
    }

    public final void Q() throws Resources.NotFoundException {
        if (!com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            this.awaitingExternalUi = true;
            J();
            AuthManager.INSTANCE.E1(this, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.m1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PermissionDialogActivity.R(this.f24852a);
                }
            });
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        if (!authManager.K()) {
            authManager.L(this, new b(), true);
            return;
        }
        if (!authManager.Y()) {
            authManager.b0(this, false, false, new c());
            return;
        }
        if (!com.stepos.ailauncher.chat.manager.U0.INSTANCE.l()) {
            AuthManager.k1(authManager, this, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.n1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PermissionDialogActivity.S(this.f24856a);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.o1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PermissionDialogActivity.T(this.f24860a);
                }
            }, null, 8, null);
            return;
        }
        if (getIntent().getBooleanExtra(INTENT_KEY_EXPRESS_REQUIRE_MIC, true)) {
            C3185b c3185b = C3185b.INSTANCE;
            if (!c3185b.a(PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
                this.awaitingExternalUi = true;
                J();
                c3185b.b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.p1
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return PermissionDialogActivity.U(this.f24864a, ((Boolean) obj).booleanValue());
                    }
                });
                return;
            }
        }
        InterfaceC5063a<Y8.t> interfaceC5063aI0 = authManager.i0();
        if (interfaceC5063aI0 != null) {
            interfaceC5063aI0.invoke();
        }
        finish();
    }

    public final void V() throws Resources.NotFoundException {
        IHomeBarSysUiService iHomeBarSysUiService;
        if (!com.stepos.ailauncher.foundation.account.f.INSTANCE.v()) {
            final boolean booleanExtra = getIntent().getBooleanExtra(INTENT_KEY_OPEN_CHAT_AFTER_AUTH, false);
            AuthManager.INSTANCE.q1(this, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.f1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PermissionDialogActivity.W(booleanExtra, this);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.h1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PermissionDialogActivity.X(this.f24826a);
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.i1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return PermissionDialogActivity.Y(this.f24833a);
                }
            });
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        if (!authManager.Y()) {
            authManager.b0(this, true, false, new d());
            return;
        }
        if (!authManager.K()) {
            authManager.L(this, new e(), getIntent().getBooleanExtra(INTENT_KEY_OPEN_CHAT_AFTER_AUTH, false));
            return;
        }
        if (getIntent().getBooleanExtra(INTENT_KEY_OPEN_CHAT_AFTER_AUTH, false) && (iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class)) != null) {
            iHomeBarSysUiService.openChatViewAfterAgentAuth();
        }
        finish();
    }

    public final void Z() throws Resources.NotFoundException {
        AuthManager authManager = AuthManager.INSTANCE;
        if (authManager.Y()) {
            finish();
        } else {
            authManager.b0(this, true, false, new f());
        }
    }

    public final void a0(Intent intent) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(intent, "intent");
        AuthManager authManager = AuthManager.INSTANCE;
        if (!authManager.Y()) {
            authManager.b0(this, false, false, new g());
        } else if (!authManager.K()) {
            authManager.L(this, new h(), true);
        } else {
            P();
            finish();
        }
    }

    public final void c0() {
        this.awaitingExternalUi = true;
        J();
        com.stepos.ailauncher.common.permission.G.k0(com.stepos.ailauncher.common.permission.G.INSTANCE, this, PermScene.NOTIFICATION, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.g1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PermissionDialogActivity.d0(this.f24822a, ((Boolean) obj).booleanValue());
            }
        }, 4, null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            this.userInteracted = true;
            J();
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void e0() {
        Window window;
        View decorView;
        if (isFinishing() || this.awaitingExternalUi || (window = getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(this.emptyShellFinish);
        decorView.postDelayed(this.emptyShellFinish, 400L);
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(C2436g.INSTANCE.b(getWindow().getAttributes().softInputMode));
        this.createdAtElapsed = SystemClock.elapsedRealtime();
        H();
        try {
            Result.Companion companion = Result.INSTANCE;
            setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
        recentsWindowMonitor.c(this.recentsListener);
        this.recentsArmed = true;
        isStart = 1;
        instance = this;
        if (recentsWindowMonitor.h() == RecentsWindowMonitor.RecentsState.OVERVIEW) {
            K();
            return;
        }
        String stringExtra = getIntent().getStringExtra(INTENT_KEY_SOURCE);
        if (kotlin.jvm.internal.p.d(stringExtra, SOURCE_HOME)) {
            V();
        } else if (kotlin.jvm.internal.p.d(stringExtra, SOURCE_INIT)) {
            Z();
        } else if (kotlin.jvm.internal.p.d(stringExtra, SOURCE_EXPRESS_AUTH)) {
            Q();
        } else {
            Intent intent = getIntent();
            kotlin.jvm.internal.p.h(intent, "getIntent(...)");
            a0(intent);
        }
        e0();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        View decorView;
        RecentsWindowMonitor.INSTANCE.q(this.recentsListener);
        J();
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.removeCallbacks(this.emptyShellFinish);
        }
        if (kotlin.jvm.internal.p.d(getIntent().getStringExtra(INTENT_KEY_SOURCE), SOURCE_EXPRESS_AUTH)) {
            AuthManager authManager = AuthManager.INSTANCE;
            authManager.f0();
            authManager.m0();
        }
        if (instance == this) {
            instance = null;
            isStart = 0;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        AuthManager authManager = AuthManager.INSTANCE;
        if (authManager.z0()) {
            authManager.Q0(false);
            super.onPause();
            return;
        }
        if (this.awaitingExternalUi) {
            super.onPause();
            return;
        }
        if (authManager.w0()) {
            super.onPause();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.createdAtElapsed;
        if (isFinishing() || isChangingConfigurations() || this.userInteracted || this.awaitingExternalUi || jElapsedRealtime >= 400) {
            if (!kotlin.jvm.internal.p.d(getIntent().getStringExtra(INTENT_KEY_SOURCE), SOURCE_EXPRESS_AUTH)) {
                J();
                authManager.m0();
                if (!isFinishing()) {
                    N();
                }
            }
            super.onPause();
            return;
        }
        C4148a.k(TAG, "ephemeral finish aliveMs=" + jElapsedRealtime + " (no-focus guard)", false, 4, null);
        J();
        M();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        AuthManager.INSTANCE.Q0(false);
        J();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);
        if (isTopResumedActivity) {
            J();
        } else {
            f0("topResumedLost");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            J();
        } else {
            f0("windowFocusLost");
        }
    }
}
