package com.stepos.ailauncher.chat.wake;

import Ua.CoroutineName;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.RobotManager;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.common.utils.E;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p5.C5054e;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0004GJ\\_\b\u0016\u0018\u0000 b2\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u0018J\u000f\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010#\u001a\u00020\tH\u0004¢\u0006\u0004\b#\u0010\u0018J\u001b\u0010$\u001a\u00020\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\u0010H\u0016¢\u0006\u0004\b%\u0010\u001cJ\u000f\u0010&\u001a\u00020\tH\u0014¢\u0006\u0004\b&\u0010\u0018J\u0019\u0010)\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010'H\u0014¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0010H\u0014¢\u0006\u0004\b.\u0010\u001cJ\u000f\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0004\b/\u0010\u001cJ\u000f\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010\u001cJ\u0017\u00102\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u000101H\u0014¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0017¢\u0006\u0004\b4\u0010\u001cJ\u000f\u00105\u001a\u00020\u0006H\u0014¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0010H\u0016¢\u0006\u0004\b7\u0010\u001cJ\u001f\u0010;\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00132\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\t2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0010H\u0016¢\u0006\u0004\b?\u0010\u001cR\u001a\u0010A\u001a\u00020@8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010SR\u0016\u0010U\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010\u001aR\u0016\u0010V\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010\u001aR\u0016\u0010W\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010\u001aR\u0016\u0010X\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010\u001aR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006d"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/e0;", "Lb/v;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "action", "reason", "", "M", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "D", "()J", "from", "LY8/t;", "s", "(Ljava/lang/String;)V", "", "K", "()I", "u", "y", "()Z", "stopReason", "I", "v", "()V", "H", "x", "F", "P", "G", "Q", "z", ExifInterface.LONGITUDE_EAST, DidiCardProvider.ACTION_DISMISS, "N", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "isKeyguardLocked", "r", "(Z)V", UxipConstants.f30640D, "onAttachedToWindow", "onDetachedFromWindow", "Lkotlin/Function0;", "R", "()Lp9/a;", "B", "t", "()Ljava/lang/String;", "O", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "C", "LUa/M;", "dialogCoroutineScope", "LUa/M;", "w", "()LUa/M;", "conversationHostTag", "Ljava/lang/String;", "com/stepos/ailauncher/chat/wake/e0$b", "imagePreviewBackCallback", "Lcom/stepos/ailauncher/chat/wake/e0$b;", "com/stepos/ailauncher/chat/wake/e0$d", "screenOffReceiver", "Lcom/stepos/ailauncher/chat/wake/e0$d;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "screenshotPassthrough", "Z", "screenshotPassthroughStartedAt", "J", "screenshotPassthroughEndedAt", "screenshotRestoreGravity", "screenshotRestoreWidth", "screenshotRestoreHeight", "screenshotRestoreFlags", "Ljava/lang/Runnable;", "screenshotPassthroughTimeout", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/wake/e0$e", "screenshotStoreObserver", "Lcom/stepos/ailauncher/chat/wake/e0$e;", "com/stepos/ailauncher/chat/wake/e0$c", "recentEventReceiver", "Lcom/stepos/ailauncher/chat/wake/e0$c;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.e0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class DialogC3116e0 extends b.v {
    public static final String ACTION_BACK_TO_HOME = "com.stepos.ACTION_BACK_TO_HOME";
    public static final String ACTION_CANCEL_GESTURE_VIEW = "com.android.systemui.recents.action.CANCEL_GESTURE_VIEW";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "com.stepos.launcher.action.HOME_WITHOUT_FOCUS";
    public static final String ACTION_ENTER_RECENTS = "com.stepos.ACTION_ENTER_RECENTS";
    public static final String ACTION_SHOW_GESTURE_VIEW = "com.android.systemui.recents.action.SHOW_GESTURE_VIEW";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long SCREENSHOT_PASSTHROUGH_COOLDOWN_MS = 8000;
    private static final long SCREENSHOT_PASSTHROUGH_GRACE_MS = 1000;
    private static final long SCREENSHOT_PASSTHROUGH_TIMEOUT_MS = 45000;
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    private static final String SYSTEM_DIALOG_REASON_SCREENSHOT = "screenshot";
    private static final String TAG = "WakeDialog";
    private static boolean dialogExisted;
    private final String conversationHostTag;
    private final Ua.M dialogCoroutineScope;
    private final b imagePreviewBackCallback;
    private final Handler mainHandler;
    private final c recentEventReceiver;
    private final d screenOffReceiver;
    private boolean screenshotPassthrough;
    private long screenshotPassthroughEndedAt;
    private long screenshotPassthroughStartedAt;
    private final Runnable screenshotPassthroughTimeout;
    private int screenshotRestoreFlags;
    private int screenshotRestoreGravity;
    private int screenshotRestoreHeight;
    private int screenshotRestoreWidth;
    private final e screenshotStoreObserver;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/e0$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "dialogExisted", "Z", Const.INTENT_KEY_APIKEY, "()Z", "getDialogExisted$annotations", "", "TAG", "Ljava/lang/String;", "ACTION_SHOW_GESTURE_VIEW", "ACTION_CANCEL_GESTURE_VIEW", "ACTION_ENTER_RECENTS", "ACTION_BACK_TO_HOME", "ACTION_CLOSE_SYSTEM_DIALOGS", "SYSTEM_DIALOG_REASON_KEY", "SYSTEM_DIALOG_REASON_SCREENSHOT", "SYSTEM_DIALOG_REASON_HOME_KEY", "SYSTEM_DIALOG_REASON_RECENT_APPS", "", "SCREENSHOT_PASSTHROUGH_TIMEOUT_MS", "J", "SCREENSHOT_PASSTHROUGH_GRACE_MS", "SCREENSHOT_PASSTHROUGH_COOLDOWN_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.e0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a() {
            return DialogC3116e0.dialogExisted;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/wake/e0$b", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.e0$b */
    public static final class b extends AbstractC1417G {
        public b() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            if (com.stepos.agentframework.util.u.INSTANCE.d()) {
                return;
            }
            setEnabled(false);
            DialogC3116e0.this.getOnBackPressedDispatcher().q();
            setEnabled(true);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/e0$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.e0$c */
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(android.content.Context r10, android.content.Intent r11) {
            /*
                r9 = this;
                r10 = 0
                if (r11 == 0) goto L8
                java.lang.String r0 = r11.getAction()
                goto L9
            L8:
                r0 = r10
            L9:
                if (r11 == 0) goto L13
                java.lang.String r1 = "reason"
                java.lang.String r11 = r11.getStringExtra(r1)
                goto L14
            L13:
                r11 = r10
            L14:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "recentEvent: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r2 = " reason="
                r1.append(r2)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "WakeDialog"
                r3 = 0
                r4 = 4
                h8.C4148a.d(r2, r1, r3, r4, r10)
                if (r0 == 0) goto Lcc
                int r1 = r0.hashCode()
                switch(r1) {
                    case -731730151: goto Lbc;
                    case -403228793: goto L5d;
                    case -374769766: goto L54;
                    case 97934780: goto L4a;
                    case 1538159491: goto L40;
                    default: goto L3e;
                }
            L3e:
                goto Lcc
            L40:
                java.lang.String r10 = "com.stepos.ACTION_BACK_TO_HOME"
                boolean r10 = r0.equals(r10)
                if (r10 == 0) goto Lcc
                goto Lc5
            L4a:
                java.lang.String r1 = "com.stepos.launcher.action.HOME_WITHOUT_FOCUS"
                boolean r1 = r0.equals(r1)
                if (r1 != 0) goto L66
                goto Lcc
            L54:
                java.lang.String r10 = "com.android.systemui.recents.action.SHOW_GESTURE_VIEW"
                boolean r10 = r0.equals(r10)
                if (r10 != 0) goto Lc5
                goto Lcc
            L5d:
                java.lang.String r1 = "android.intent.action.CLOSE_SYSTEM_DIALOGS"
                boolean r1 = r0.equals(r1)
                if (r1 != 0) goto L66
                goto Lcc
            L66:
                com.stepos.ailauncher.chat.wake.e0 r1 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                boolean r1 = com.stepos.ailauncher.chat.wake.DialogC3116e0.q(r1, r0, r11)
                r5 = 1
                if (r1 == 0) goto Lb6
                java.lang.String r1 = "screenshot"
                boolean r11 = La.D.L(r1, r11, r5)
                com.stepos.ailauncher.chat.wake.e0 r1 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                boolean r1 = com.stepos.ailauncher.chat.wake.DialogC3116e0.m(r1)
                if (r1 == 0) goto L90
                com.stepos.ailauncher.chat.wake.e0 r11 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                long r5 = com.stepos.ailauncher.chat.wake.DialogC3116e0.o(r11)
                r7 = 1000(0x3e8, double:4.94E-321)
                int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r11 < 0) goto L9a
                com.stepos.ailauncher.chat.wake.e0 r11 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                com.stepos.ailauncher.chat.wake.DialogC3116e0.k(r11, r0)
                goto L9a
            L90:
                if (r11 == 0) goto L9a
                com.stepos.ailauncher.chat.wake.e0 r11 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                java.lang.String r0 = "reason=screenshot"
                com.stepos.ailauncher.chat.wake.DialogC3116e0.j(r11, r0)
            L9a:
                com.stepos.ailauncher.chat.wake.e0 r9 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                boolean r9 = com.stepos.ailauncher.chat.wake.DialogC3116e0.m(r9)
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r0 = "recentEvent: keep showing screenshotPassthrough="
                r11.append(r0)
                r11.append(r9)
                java.lang.String r9 = r11.toString()
                h8.C4148a.d(r2, r9, r3, r4, r10)
                return
            Lb6:
                com.stepos.ailauncher.chat.wake.e0 r9 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                com.stepos.ailauncher.chat.wake.DialogC3116e0.J(r9, r10, r5, r10)
                return
            Lbc:
                java.lang.String r10 = "com.stepos.ACTION_ENTER_RECENTS"
                boolean r10 = r0.equals(r10)
                if (r10 != 0) goto Lc5
                goto Lcc
            Lc5:
                com.stepos.ailauncher.chat.wake.e0 r9 = com.stepos.ailauncher.chat.wake.DialogC3116e0.this
                java.lang.String r10 = "nav_key_click"
                com.stepos.ailauncher.chat.wake.DialogC3116e0.p(r9, r10)
            Lcc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.DialogC3116e0.c.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/e0$d", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.e0$d */
    public static final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_OFF")) {
                DialogC3116e0.this.C();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/e0$e", "Landroid/database/ContentObserver;", "", "selfChange", "Landroid/net/Uri;", "uri", "LY8/t;", "onChange", "(ZLandroid/net/Uri;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.e0$e */
    public static final class e extends ContentObserver {
        public e(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (DialogC3116e0.this.y()) {
                if (!DialogC3116e0.this.screenshotPassthrough) {
                    DialogC3116e0.this.s("mediastore");
                } else {
                    if (DialogC3116e0.this.D() < 1000) {
                        return;
                    }
                    DialogC3116e0.this.u("mediastore-save");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC3116e0(Context context) {
        super(context, R$style.WakeDialogTheme);
        kotlin.jvm.internal.p.i(context, "context");
        this.dialogCoroutineScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()).plus(new CoroutineName("WakeDialogCoroutine")));
        this.conversationHostTag = "WakeDialog@" + System.identityHashCode(this);
        this.imagePreviewBackCallback = new b();
        this.screenOffReceiver = new d();
        Handler handler = new Handler(Looper.getMainLooper());
        this.mainHandler = handler;
        this.screenshotPassthroughTimeout = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.b0
            @Override // java.lang.Runnable
            public final void run() {
                DialogC3116e0.L(this.f26695a);
            }
        };
        this.screenshotStoreObserver = new e(handler);
        this.recentEventReceiver = new c();
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.ailauncher.chat.wake.c0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogC3116e0.i(this.f26698a, dialogInterface);
            }
        });
    }

    public static final InterfaceC5063a A(DialogC3116e0 dialogC3116e0) {
        return dialogC3116e0.R();
    }

    public static /* synthetic */ void J(DialogC3116e0 dialogC3116e0, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: safeDismissFromBroadcast");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        dialogC3116e0.I(str);
    }

    public static final void L(DialogC3116e0 dialogC3116e0) {
        dialogC3116e0.u("timeout");
    }

    public static final Y8.t S(DialogC3116e0 dialogC3116e0) {
        Object objB;
        C4148a.k(TAG, "yieldForKeyguardUnlock: show back after unlock", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            dialogC3116e0.show();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "restore show failed", thE, false, 8, null);
        }
        return Y8.t.f7040a;
    }

    public static final void i(DialogC3116e0 dialogC3116e0, DialogInterface dialogInterface) {
        dialogC3116e0.B();
    }

    public void B() {
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.agentframework.util.u.INSTANCE.h();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            O();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        u(DidiCardProvider.ACTION_DISMISS);
        dialogExisted = false;
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        if (inputViewManager.y0() == this) {
            inputViewManager.Z0(null);
        }
        kotlinx.coroutines.d.e(this.dialogCoroutineScope, null, 1, null);
        getContext().sendBroadcast(new Intent("com.stepos.ailauncher.chat.action.ACTION_ASSISTANT_DISMISS_FLOAT_WINDOW"));
        WakeService.INSTANCE.m1(false);
        try {
            C5054e.INSTANCE.i(t());
            RobotManager.INSTANCE.a().w(t());
            Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
    }

    public void C() {
        C4148a.d(TAG, "onScreenOff → dismiss", false, 4, null);
        dismiss();
    }

    public final long D() {
        return SystemClock.elapsedRealtime() - this.screenshotPassthroughStartedAt;
    }

    public void E(String stopReason) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            dismiss();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "performBroadcastDismiss: dismiss threw, swallowed", thE, false, 8, null);
            v();
        }
    }

    public final void F() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_ENTER_RECENTS);
        intentFilter.addAction(ACTION_SHOW_GESTURE_VIEW);
        intentFilter.addAction(ACTION_CANCEL_GESTURE_VIEW);
        intentFilter.addAction(ACTION_BACK_TO_HOME);
        intentFilter.addAction(ACTION_CLOSE_SYSTEM_DIALOGS);
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        getContext().registerReceiver(this.recentEventReceiver, intentFilter, 2);
    }

    public final void G() {
        Object objB;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            C4148a.k(TAG, "skip screenshot store observer: privacy not granted", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.screenshotStoreObserver);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerScreenshotStoreObserver failed", thE, false, 8, null);
        }
    }

    public final int H() {
        return x() ? 2009 : 2008;
    }

    public final void I(String stopReason) {
        View decorView;
        if (isShowing()) {
            Window window = getWindow();
            if (window == null || (decorView = window.getDecorView()) == null || !decorView.isAttachedToWindow()) {
                C4148a.d(TAG, "safeDismissFromBroadcast: decor not attached, skip", false, 4, null);
            } else if (N()) {
                C4148a.d(TAG, "safeDismissFromBroadcast: suppressed by subclass", false, 4, null);
            } else {
                E(stopReason);
            }
        }
    }

    public final int K() {
        View viewFindViewById = findViewById(R$id.wake_panel);
        if (viewFindViewById == null || viewFindViewById.getHeight() <= 0) {
            return -2;
        }
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int i10 = getContext().getResources().getDisplayMetrics().heightPixels - iArr[1];
        return i10 > 0 ? i10 : viewFindViewById.getHeight();
    }

    public final boolean M(String action, String reason) {
        if (kotlin.jvm.internal.p.d(action, ACTION_CLOSE_SYSTEM_DIALOGS)) {
            return true;
        }
        return (!kotlin.jvm.internal.p.d(action, "android.intent.action.CLOSE_SYSTEM_DIALOGS") || La.D.L(SYSTEM_DIALOG_REASON_HOME_KEY, reason, true) || La.D.L(SYSTEM_DIALOG_REASON_RECENT_APPS, reason, true)) ? false : true;
    }

    public boolean N() {
        return false;
    }

    public void O() {
    }

    public final void P() {
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().unregisterReceiver(this.recentEventReceiver);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void Q() {
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().getContentResolver().unregisterContentObserver(this.screenshotStoreObserver);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public InterfaceC5063a<Y8.t> R() {
        Object objB;
        C4148a.k(TAG, "yieldForKeyguardUnlock: hide to release window focus", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            hide();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE == null) {
            return new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.d0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return DialogC3116e0.S(this.f26739a);
                }
            };
        }
        C4148a.t(TAG, "yieldForKeyguardUnlock hide failed", thE, false, 8, null);
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            super.dismiss();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "dismiss threw, forcibly removing decor", thE, false, 8, null);
            v();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (HeadsetMediaKeyGuard.INSTANCE.b(event)) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        F();
        G();
        com.stepos.ailauncher.common.utils.E.INSTANCE.i(this.conversationHostTag, new E.a() { // from class: com.stepos.ailauncher.chat.wake.a0
            @Override // com.stepos.ailauncher.common.utils.E.a
            public final InterfaceC5063a a() {
                return DialogC3116e0.A(this.f26691a);
            }
        });
    }

    @Override // b.v, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams attributes2;
        super.onCreate(savedInstanceState);
        dialogExisted = true;
        InputViewManager.INSTANCE.Z0(this);
        getOnBackPressedDispatcher().n(this.imagePreviewBackCallback);
        Window window = getWindow();
        if (window != null && (attributes2 = window.getAttributes()) != null) {
            attributes2.type = H();
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(16777216);
        }
        Window window3 = getWindow();
        if (window3 != null && (attributes = window3.getAttributes()) != null) {
            attributes.screenOrientation = 1;
        }
        r(x());
        RobotManager.INSTANCE.a().o(t());
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        P();
        Q();
        u("detach");
        com.stepos.ailauncher.common.utils.E.INSTANCE.l(this.conversationHostTag);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        return super.onKeyDown(keyCode, event);
    }

    @Override // b.v, android.app.Dialog
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setFlags(768, 768);
        }
    }

    public void r(boolean isKeyguardLocked) {
    }

    public final void s(String from) {
        if (!isShowing() || this.screenshotPassthrough) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.screenshotPassthroughEndedAt;
        long j11 = jElapsedRealtime - j10;
        if (j10 > 0 && j11 < 8000) {
            C4148a.d(TAG, "beginScreenshotTouchPassthrough: cooldown " + j11 + "ms, ignore " + from, false, 4, null);
            return;
        }
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.screenshotRestoreGravity = attributes.gravity;
        this.screenshotRestoreWidth = attributes.width;
        this.screenshotRestoreHeight = attributes.height;
        this.screenshotRestoreFlags = attributes.flags;
        int iK = K();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = iK;
        attributes.flags |= 32;
        window.setAttributes(attributes);
        this.screenshotPassthrough = true;
        this.screenshotPassthroughStartedAt = SystemClock.elapsedRealtime();
        this.mainHandler.removeCallbacks(this.screenshotPassthroughTimeout);
        this.mainHandler.postDelayed(this.screenshotPassthroughTimeout, 45000L);
        C4148a.d(TAG, "beginScreenshotTouchPassthrough from=" + from + " height=" + iK, false, 4, null);
    }

    public String t() {
        return "";
    }

    public final void u(String from) {
        this.mainHandler.removeCallbacks(this.screenshotPassthroughTimeout);
        if (this.screenshotPassthrough) {
            this.screenshotPassthrough = false;
            this.screenshotPassthroughEndedAt = SystemClock.elapsedRealtime();
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = this.screenshotRestoreGravity;
                attributes.width = this.screenshotRestoreWidth;
                attributes.height = this.screenshotRestoreHeight;
                attributes.flags = this.screenshotRestoreFlags;
                window.setAttributes(attributes);
            }
            C4148a.d(TAG, "endScreenshotTouchPassthrough from=" + from, false, 4, null);
        }
    }

    public final void v() {
        View decorView;
        Object objB;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = getContext().getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null) {
                windowManager.removeViewImmediate(decorView);
                C4148a.u(TAG, "forciblyRemoveDecor: decor removed via WindowManager", false, 4, null);
            }
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "forciblyRemoveDecor: removeViewImmediate threw, swallowed", thE, false, 8, null);
        }
    }

    /* renamed from: w, reason: from getter */
    public final Ua.M getDialogCoroutineScope() {
        return this.dialogCoroutineScope;
    }

    public final boolean x() {
        Object systemService = getContext().getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        return keyguardManager != null && keyguardManager.isKeyguardLocked();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y() {
        /*
            r13 = this;
            java.lang.String r0 = "screenshot"
            java.lang.String r1 = "date_added"
            com.stepos.ailauncher.common.privacy.b r2 = com.stepos.ailauncher.common.privacy.b.INSTANCE
            boolean r2 = r2.b()
            r3 = 0
            if (r2 != 0) goto Lf
            return r3
        Lf:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La5
            java.lang.String r2 = "relative_path"
            java.lang.String r4 = "_display_name"
            java.lang.String[] r2 = new java.lang.String[]{r2, r4, r1}     // Catch: java.lang.Throwable -> La5
            android.os.Bundle r4 = new android.os.Bundle     // Catch: java.lang.Throwable -> La5
            r4.<init>()     // Catch: java.lang.Throwable -> La5
            java.lang.String r5 = "android:query-arg-sort-columns"
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> La5
            r4.putStringArray(r5, r1)     // Catch: java.lang.Throwable -> La5
            java.lang.String r1 = "android:query-arg-sort-direction"
            r5 = 1
            r4.putInt(r1, r5)     // Catch: java.lang.Throwable -> La5
            java.lang.String r1 = "android:query-arg-limit"
            r4.putInt(r1, r5)     // Catch: java.lang.Throwable -> La5
            android.content.Context r13 = r13.getContext()     // Catch: java.lang.Throwable -> La5
            android.content.ContentResolver r13 = r13.getContentResolver()     // Catch: java.lang.Throwable -> La5
            android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> La5
            r6 = 0
            android.database.Cursor r13 = r13.query(r1, r2, r4, r6)     // Catch: java.lang.Throwable -> La5
            if (r13 == 0) goto L9c
            java.io.Closeable r13 = (java.io.Closeable) r13     // Catch: java.lang.Throwable -> La5
            r1 = r13
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch: java.lang.Throwable -> L8a
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L8a
            if (r2 != 0) goto L50
            goto L92
        L50:
            java.lang.String r2 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = ""
            if (r2 != 0) goto L59
            r2 = r4
        L59:
            java.lang.String r7 = r1.getString(r5)     // Catch: java.lang.Throwable -> L8a
            if (r7 != 0) goto L60
            goto L61
        L60:
            r4 = r7
        L61:
            r7 = 2
            long r7 = r1.getLong(r7)     // Catch: java.lang.Throwable -> L8a
            long r9 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8a
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r11
            long r9 = r9 - r7
            long r7 = java.lang.Math.abs(r9)     // Catch: java.lang.Throwable -> L8a
            r9 = 8
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 > 0) goto L7a
            r1 = r5
            goto L7b
        L7a:
            r1 = r3
        L7b:
            boolean r2 = La.H.e0(r2, r0, r5)     // Catch: java.lang.Throwable -> L8a
            if (r2 != 0) goto L8c
            boolean r0 = La.H.e0(r4, r0, r5)     // Catch: java.lang.Throwable -> L8a
            if (r0 == 0) goto L88
            goto L8c
        L88:
            r0 = r3
            goto L8d
        L8a:
            r0 = move-exception
            goto L96
        L8c:
            r0 = r5
        L8d:
            if (r1 == 0) goto L92
            if (r0 == 0) goto L92
            r3 = r5
        L92:
            l9.b.a(r13, r6)     // Catch: java.lang.Throwable -> La5
            goto L9c
        L96:
            throw r0     // Catch: java.lang.Throwable -> L97
        L97:
            r1 = move-exception
            l9.b.a(r13, r0)     // Catch: java.lang.Throwable -> La5
            throw r1     // Catch: java.lang.Throwable -> La5
        L9c:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> La5
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> La5
            goto Lb0
        La5:
            r13 = move-exception
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        Lb0:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.Result.g(r13)
            if (r1 == 0) goto Lb9
            r13 = r0
        Lb9:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.DialogC3116e0.y():boolean");
    }

    /* renamed from: z, reason: from getter */
    public final boolean getScreenshotPassthrough() {
        return this.screenshotPassthrough;
    }
}
