package com.stepos.ailauncher.chat.sheet;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.activity.ChatEntry;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.chat.activity.ChatScene;
import com.stepos.ailauncher.chat.activity.LockScreenChatSheetActivity;
import com.stepos.ailauncher.chat.controller.C2536e;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.container.l0;
import com.stepos.ailauncher.container.m0;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import com.stepos.ailauncher.sheet.s0;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ_\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJy\u0010!\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J]\u0010'\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b'\u0010(J)\u0010+\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b+\u0010,Ja\u00100\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006H\u0007¢\u0006\u0004\b0\u00101J1\u00103\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00104J9\u00106\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b8\u00109J!\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b:\u00109J\u0017\u0010;\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b;\u0010<J?\u0010@\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0006H\u0007¢\u0006\u0004\b@\u0010AJ1\u0010B\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bD\u0010\bJM\u0010F\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010E\u001a\u00020\u0006H\u0007¢\u0006\u0004\bF\u0010GJ3\u0010H\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bH\u0010IJ÷\u0001\u0010T\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010K\u001a\u00020J2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010N\u001a\u00020\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010O\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010P\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00062\b\b\u0002\u0010Q\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010S\u001a\u00020RH\u0002¢\u0006\u0004\bT\u0010UJ\u0015\u0010W\u001a\u0004\u0018\u00010V*\u00020\u0004H\u0002¢\u0006\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006]"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/j;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "G", "(Landroid/content/Context;)Z", "f", "Lcom/stepos/ailauncher/chat/activity/ChatEntry;", "entry", "", "sessionId", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "heightMode", "taskAlwaysOnTop", "", "launcherTaskId", "homeMode", "restoreLast", "LY8/t;", "k", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/activity/ChatEntry;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;ZIZZ)V", "residentStillAlive", "o", "(Landroid/content/Context;Ljava/lang/String;ZZ)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Ljava/lang/String;Z)V", "clearStack", "visualStackRoot", "inheritStackScrim", "handoffEmbeddedScrim", "m", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/activity/ChatEntry;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;ZIZZZLjava/lang/String;ZZ)V", "initialPrompt", "agentId", "deviceId", "agentDisplayName", "y", "(Landroid/content/Context;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "B", "(Landroid/content/Context;Landroid/content/Intent;Lcom/stepos/ailauncher/sheet/SheetHeightMode;)V", "wakeSource", "isWake", "clearTask", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/activity/ChatEntry;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;Ljava/lang/String;ZZZ)V", "coveredTaskId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;ILjava/lang/String;Z)V", "source", "D", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;)Ljava/lang/String;", "x", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "v", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "allowRecentFallback", "fromNotification", "prewarm", "s", "(Landroid/content/Context;Ljava/lang/String;ZZZ)Ljava/lang/String;", "u", "(Landroid/content/Context;Ljava/lang/String;ZZ)Ljava/lang/String;", "c", "forceNewInstance", "q", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;ZZ)V", "F", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;)V", "Lcom/stepos/ailauncher/chat/activity/ChatScene;", HomeGestureEligibilityContract.EXTRA_SCENE, "Landroid/os/Bundle;", "optionsBundle", "forceNewTask", "layer", "prepareStack", "multipleTask", "", "embeddedScrimHandoff", "H", "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/activity/ChatEntry;Lcom/stepos/ailauncher/chat/activity/ChatScene;Ljava/lang/String;Lcom/stepos/ailauncher/sheet/SheetHeightMode;Landroid/os/Bundle;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZZZZLjava/lang/String;ZJ)V", "Landroid/app/Activity;", "e", "(Landroid/content/Context;)Landroid/app/Activity;", "TAG", "Ljava/lang/String;", "launchingHomeBarPrewarm", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2739j {
    public static final C2739j INSTANCE = new C2739j();
    private static final String TAG = "ChatLaunchRouter";
    private static volatile boolean launchingHomeBarPrewarm;

    public static final boolean A(Activity activity, String str, Activity activity2) {
        kotlin.jvm.internal.p.i(activity2, "activity");
        if (!(activity2 instanceof ChatActivity) || activity2 == activity) {
            return false;
        }
        ChatScene.Companion companion = ChatScene.INSTANCE;
        ChatActivity chatActivity = (ChatActivity) activity2;
        if ((companion.a(chatActivity.getIntent()) != ChatScene.DESKTOP && companion.a(chatActivity.getIntent()) != ChatScene.HOME_OVERLAY) || !kotlin.jvm.internal.p.d(C2735f.INSTANCE.e(activity2), str)) {
            return false;
        }
        ChatEntry.Companion companion2 = ChatEntry.INSTANCE;
        return companion2.a(chatActivity.getIntent()) == ChatEntry.CHAT || companion2.a(chatActivity.getIntent()) == ChatEntry.SESSION_CENTER;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void B(android.content.Context r19, android.content.Intent r20, com.stepos.ailauncher.sheet.SheetHeightMode r21) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.sheet.C2739j.B(android.content.Context, android.content.Intent, com.stepos.ailauncher.sheet.SheetHeightMode):void");
    }

    public static /* synthetic */ void C(Context context, Intent intent, SheetHeightMode sheetHeightMode, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sheetHeightMode = SheetHeightMode.FULL_9;
        }
        B(context, intent, sheetHeightMode);
    }

    public static final String D(Context context, String source, String sessionId, SheetHeightMode heightMode) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(heightMode, "heightMode");
        if (com.stepos.ailauncher.chat.lockscreen.I.INSTANCE.j(context)) {
            r(context, source, sessionId, null, false, false, 56, null);
            C4148a.k(TAG, "openWake → lockScreen sheet", false, 4, null);
            return com.stepos.ailauncher.chat.util.g.REASON_LOCKSCREEN;
        }
        if (source == null && sessionId != null && sessionId.length() != 0) {
            WakeService.Companion companion = WakeService.INSTANCE;
            if (companion.B0() == null && companion.z0() == null && companion.y0() == null) {
                return INSTANCE.x(context, sessionId);
            }
        }
        String strA = g0.a(m0.INSTANCE.h(), s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).R(), f(context), false);
        if (kotlin.jvm.internal.p.d(strA, "minus_one_stack")) {
            DesktopChatResidentController.l3("wake");
            C4148a.k(TAG, "openWake → minus_one_stack", false, 4, null);
            return "minus_one_stack";
        }
        if (kotlin.jvm.internal.p.d(strA, "minus_one_covered_cold")) {
            l0.INSTANCE.f();
            INSTANCE.F(context, source, sessionId, heightMode);
            C4148a.k(TAG, "openWake → minus_one_covered_cold", false, 4, null);
            return "minus_one_covered_cold";
        }
        if (!f(context)) {
            DesktopChatResidentController.q1();
            i(context, ChatEntry.CHAT, sessionId, heightMode, source, true, false, false, 192, null);
            C4148a.k(TAG, "openWake → chatBoard (third-party)", false, 4, null);
            return "board";
        }
        if (DesktopChatResidentController.S1()) {
            INSTANCE.F(context, source, sessionId, heightMode);
            C4148a.k(TAG, "openWake → desktop overlay on top (resident covered by stacked sheet)", false, 4, null);
            return "desktop_top";
        }
        if (DesktopChatResidentController.U0(source)) {
            C4148a.k(TAG, "openWake → deliver resident (desktop)", false, 4, null);
            return "deliver";
        }
        INSTANCE.F(context, source, sessionId, heightMode);
        C4148a.k(TAG, "openWake → desktop overlay", false, 4, null);
        return "desktop";
    }

    public static /* synthetic */ String E(Context context, String str, String str2, SheetHeightMode sheetHeightMode, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            sheetHeightMode = SheetHeightMode.MINIFY_EXPANDABLE;
        }
        return D(context, str, str2, sheetHeightMode);
    }

    public static /* synthetic */ void I(C2739j c2739j, Context context, ChatEntry chatEntry, ChatScene chatScene, String str, SheetHeightMode sheetHeightMode, Bundle bundle, boolean z10, String str2, String str3, String str4, String str5, String str6, int i10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, String str7, boolean z18, long j10, int i11, Object obj) {
        boolean z19;
        long j11;
        C2739j c2739j2;
        Context context2;
        ChatEntry chatEntry2;
        String str8;
        SheetHeightMode sheetHeightMode2;
        Bundle bundle2;
        boolean z20;
        String str9 = (i11 & 128) != 0 ? null : str2;
        String str10 = (i11 & 256) != 0 ? null : str3;
        String str11 = (i11 & 512) != 0 ? null : str4;
        String str12 = (i11 & 1024) != 0 ? null : str5;
        String str13 = (i11 & 2048) != 0 ? null : str6;
        boolean z21 = true;
        int i12 = (i11 & 4096) != 0 ? 1 : i10;
        if ((i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0) {
            if (chatScene != ChatScene.DESKTOP && chatScene != ChatScene.HOME_OVERLAY) {
                z21 = false;
            }
            z19 = z21;
        } else {
            z19 = z11;
        }
        boolean z22 = (i11 & 16384) != 0 ? false : z12;
        boolean z23 = (32768 & i11) != 0 ? false : z13;
        boolean z24 = (65536 & i11) != 0 ? false : z14;
        boolean z25 = (131072 & i11) != 0 ? false : z15;
        boolean z26 = (262144 & i11) != 0 ? false : z16;
        boolean z27 = (524288 & i11) != 0 ? false : z17;
        String str14 = (1048576 & i11) != 0 ? null : str7;
        boolean z28 = (2097152 & i11) != 0 ? false : z18;
        if ((i11 & 4194304) != 0) {
            j11 = 0;
            chatEntry2 = chatEntry;
            str8 = str;
            sheetHeightMode2 = sheetHeightMode;
            bundle2 = bundle;
            z20 = z10;
            c2739j2 = c2739j;
            context2 = context;
        } else {
            j11 = j10;
            c2739j2 = c2739j;
            context2 = context;
            chatEntry2 = chatEntry;
            str8 = str;
            sheetHeightMode2 = sheetHeightMode;
            bundle2 = bundle;
            z20 = z10;
        }
        c2739j2.H(context2, chatEntry2, chatScene, str8, sheetHeightMode2, bundle2, z20, str9, str10, str11, str12, str13, i12, z19, z22, z23, z24, z25, z26, z27, str14, z28, j11);
    }

    public static final void d(String sessionId) {
        ILiveNotificationService iLiveNotificationService;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId)) {
            return;
        }
        String strK = ConversationSessionIds.INSTANCE.k(sessionId);
        D5.a aVar = D5.a.INSTANCE;
        ILiveNotificationService iLiveNotificationService2 = (ILiveNotificationService) aVar.a(ILiveNotificationService.class);
        if (iLiveNotificationService2 != null) {
            ILiveNotificationService.dismissFailedAfterView$default(iLiveNotificationService2, sessionId, null, 2, null);
        }
        if (kotlin.jvm.internal.p.d(strK, sessionId) || (iLiveNotificationService = (ILiveNotificationService) aVar.a(ILiveNotificationService.class)) == null) {
            return;
        }
        ILiveNotificationService.dismissFailedAfterView$default(iLiveNotificationService, strK, null, 2, null);
    }

    public static final boolean f(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            if (activityManager != null) {
                boolean z10 = true;
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    String packageName = componentName != null ? componentName.getPackageName() : null;
                    if (packageName == null) {
                        packageName = "";
                    }
                    String strB = i0.INSTANCE.b(context);
                    if (strB == null) {
                        strB = "com.android.launcher3";
                    }
                    if (!kotlin.jvm.internal.p.d(packageName, strB) && !kotlin.jvm.internal.p.d(packageName, "com.android.launcher3")) {
                        int iD = C2740k.INSTANCE.d(context);
                        if (iD <= 0 || runningTaskInfo.taskId != iD || !kotlin.jvm.internal.p.d(packageName, context.getPackageName())) {
                            z10 = false;
                        }
                        C4148a.d(TAG, "isLauncherInForeground=" + z10 + " topPkg=" + packageName + " topTask=" + runningTaskInfo.taskId + " launcherId=" + iD, false, 4, null);
                        return z10;
                    }
                    C4148a.d(TAG, "isLauncherInForeground=true (top=" + packageName + ")", false, 4, null);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            C4148a.u(TAG, "isLauncherInForeground failed: " + th.getMessage(), false, 4, null);
            return false;
        }
    }

    public static final void h(Context context, ChatEntry entry, String sessionId, SheetHeightMode heightMode, String wakeSource, boolean isWake, boolean restoreLast, boolean clearTask) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(entry, "entry");
        kotlin.jvm.internal.p.i(heightMode, "heightMode");
        I(INSTANCE, context, entry, ChatScene.BOARD, sessionId, heightMode, null, true, wakeSource, null, null, null, null, 0, false, false, isWake, false, restoreLast, clearTask, false, null, false, 0L, 7962368, null);
    }

    public static /* synthetic */ void i(Context context, ChatEntry chatEntry, String str, SheetHeightMode sheetHeightMode, String str2, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        boolean z13;
        boolean z14;
        String str3;
        boolean z15;
        String str4;
        SheetHeightMode sheetHeightMode2;
        Context context2;
        ChatEntry chatEntry2;
        if ((i10 & 2) != 0) {
            chatEntry = ChatEntry.SESSION_CENTER;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            sheetHeightMode = SheetHeightMode.HALF_EXPANDABLE;
        }
        if ((i10 & 16) != 0) {
            str2 = null;
        }
        if ((i10 & 32) != 0) {
            z10 = false;
        }
        if ((i10 & 64) != 0) {
            z11 = false;
        }
        if ((i10 & 128) != 0) {
            z13 = false;
            z15 = z10;
            z14 = z11;
            sheetHeightMode2 = sheetHeightMode;
            str3 = str2;
            chatEntry2 = chatEntry;
            str4 = str;
            context2 = context;
        } else {
            z13 = z12;
            z14 = z11;
            str3 = str2;
            z15 = z10;
            str4 = str;
            sheetHeightMode2 = sheetHeightMode;
            context2 = context;
            chatEntry2 = chatEntry;
        }
        h(context2, chatEntry2, str4, sheetHeightMode2, str3, z15, z14, z13);
    }

    public static final void k(Context context, ChatEntry entry, String sessionId, SheetHeightMode heightMode, boolean taskAlwaysOnTop, int launcherTaskId, boolean homeMode, boolean restoreLast) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(entry, "entry");
        kotlin.jvm.internal.p.i(heightMode, "heightMode");
        n(INSTANCE, context, entry, sessionId, heightMode, taskAlwaysOnTop, launcherTaskId, homeMode, restoreLast, true, null, false, false, 3584, null);
    }

    public static /* synthetic */ void l(Context context, ChatEntry chatEntry, String str, SheetHeightMode sheetHeightMode, boolean z10, int i10, boolean z11, boolean z12, int i11, Object obj) {
        boolean z13;
        boolean z14;
        boolean z15;
        int i12;
        String str2;
        SheetHeightMode sheetHeightMode2;
        Context context2;
        ChatEntry chatEntry2;
        if ((i11 & 2) != 0) {
            chatEntry = ChatEntry.SESSION_CENTER;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            sheetHeightMode = SheetHeightMode.HALF_EXPANDABLE;
        }
        if ((i11 & 16) != 0) {
            z10 = false;
        }
        if ((i11 & 32) != 0) {
            i10 = -1;
        }
        if ((i11 & 64) != 0) {
            z11 = false;
        }
        if ((i11 & 128) != 0) {
            z13 = false;
            i12 = i10;
            z14 = z11;
            sheetHeightMode2 = sheetHeightMode;
            z15 = z10;
            chatEntry2 = chatEntry;
            str2 = str;
            context2 = context;
        } else {
            z13 = z12;
            z14 = z11;
            z15 = z10;
            i12 = i10;
            str2 = str;
            sheetHeightMode2 = sheetHeightMode;
            context2 = context;
            chatEntry2 = chatEntry;
        }
        k(context2, chatEntry2, str2, sheetHeightMode2, z15, i12, z14, z13);
    }

    public static /* synthetic */ void n(C2739j c2739j, Context context, ChatEntry chatEntry, String str, SheetHeightMode sheetHeightMode, boolean z10, int i10, boolean z11, boolean z12, boolean z13, String str2, boolean z14, boolean z15, int i11, Object obj) {
        boolean z16;
        C2739j c2739j2;
        Context context2;
        ChatEntry chatEntry2;
        String str3;
        SheetHeightMode sheetHeightMode2;
        boolean z17;
        int i12;
        boolean z18;
        boolean z19;
        boolean z20;
        String str4 = (i11 & 512) != 0 ? null : str2;
        boolean z21 = (i11 & 1024) != 0 ? false : z14;
        if ((i11 & 2048) != 0) {
            z16 = false;
            context2 = context;
            chatEntry2 = chatEntry;
            str3 = str;
            sheetHeightMode2 = sheetHeightMode;
            z17 = z10;
            i12 = i10;
            z18 = z11;
            z19 = z12;
            z20 = z13;
            c2739j2 = c2739j;
        } else {
            z16 = z15;
            c2739j2 = c2739j;
            context2 = context;
            chatEntry2 = chatEntry;
            str3 = str;
            sheetHeightMode2 = sheetHeightMode;
            z17 = z10;
            i12 = i10;
            z18 = z11;
            z19 = z12;
            z20 = z13;
        }
        c2739j2.m(context2, chatEntry2, str3, sheetHeightMode2, z17, i12, z18, z19, z20, str4, z21, z16);
    }

    public static /* synthetic */ void p(C2739j c2739j, Context context, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        c2739j.o(context, str, z10, z11);
    }

    public static final void q(Context context, String source, String sessionId, SheetHeightMode heightMode, boolean restoreLast, boolean forceNewInstance) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(heightMode, "heightMode");
        Intent intent = new Intent(context, (Class<?>) LockScreenChatSheetActivity.class);
        intent.putExtra("com.stepos.ailauncher.chat.sheet.ENTRY", ChatEntry.CHAT.getWireValue());
        intent.putExtra("com.stepos.ailauncher.chat.sheet.SCENE", ChatScene.LOCK_SCREEN.getWireValue());
        if (sessionId != null && sessionId.length() != 0) {
            intent.putExtra(ChatMainActivity.EXTRA_CHAT_SESSION_ID, sessionId);
        }
        if (restoreLast) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.RESTORE_LAST_SESSION", true);
        }
        if (source != null && source.length() != 0) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.WAKE_SOURCE", source);
            intent.putExtra("com.stepos.ailauncher.chat.sheet.IS_WAKE", true);
        }
        if (launchingHomeBarPrewarm) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.HOMEBAR_PREWARM", true);
        }
        new SheetLaunchOptions(heightMode, 1, false, "lock", true, null, 36, null).a(intent);
        intent.addFlags(813694976);
        if (forceNewInstance) {
            intent.addFlags(32768);
        }
        C4148a.k(TAG, "openLockScreen source=" + source + " forceNewInstance=" + forceNewInstance, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "openLockScreen failed", thE, false, 8, null);
        }
    }

    public static /* synthetic */ void r(Context context, String str, String str2, SheetHeightMode sheetHeightMode, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            sheetHeightMode = com.stepos.ailauncher.chat.lockscreen.I.INSTANCE.c(str);
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        if ((i10 & 32) != 0) {
            z11 = false;
        }
        q(context, str, str2, sheetHeightMode, z10, z11);
    }

    public static final String s(Context context, String sessionId, boolean allowRecentFallback, boolean fromNotification, boolean prewarm) {
        kotlin.jvm.internal.p.i(context, "context");
        launchingHomeBarPrewarm = prewarm;
        try {
            return INSTANCE.u(context, sessionId, allowRecentFallback, fromNotification);
        } finally {
            launchingHomeBarPrewarm = false;
        }
    }

    public static /* synthetic */ String t(Context context, String str, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        if ((i10 & 16) != 0) {
            z12 = false;
        }
        return s(context, str, z10, z11, z12);
    }

    public static final String v(Context context, String sessionId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0 || !INSTANCE.c(context)) {
            return null;
        }
        String strK = ConversationSessionIds.INSTANCE.k(sessionId);
        d(sessionId);
        if (!f(context)) {
            C2536e.INSTANCE.c(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.sheet.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C2739j.w((Activity) obj));
                }
            });
        }
        return t(context, strK, false, true, false, 20, null);
    }

    public static final boolean w(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        String name = activity.getClass().getName();
        kotlin.jvm.internal.p.f(name);
        return La.D.K(name, ".TaskDetailActivity", false, 2, null) || La.D.K(name, ".ArtifactDetailActivity", false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void y(android.content.Context r27, java.lang.String r28, com.stepos.ailauncher.sheet.SheetHeightMode r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.sheet.C2739j.y(android.content.Context, java.lang.String, com.stepos.ailauncher.sheet.SheetHeightMode, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static /* synthetic */ void z(Context context, String str, SheetHeightMode sheetHeightMode, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            sheetHeightMode = SheetHeightMode.FULL_9;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        if ((i10 & 16) != 0) {
            str3 = null;
        }
        if ((i10 & 32) != 0) {
            str4 = null;
        }
        if ((i10 & 64) != 0) {
            str5 = null;
        }
        y(context, str, sheetHeightMode, str2, str3, str4, str5);
    }

    public final void F(Context context, String source, String sessionId, SheetHeightMode heightMode) {
        int iD = C2740k.INSTANCE.d(context);
        Bundle bundleE = C2733d.e(C2733d.INSTANCE, iD, false, false, 2, null);
        if (bundleE != null) {
            I(this, context, ChatEntry.CHAT, ChatScene.DESKTOP, sessionId, heightMode, bundleE, !(context instanceof Activity), source, null, null, null, null, 0, false, false, true, false, false, false, false, null, false, 0L, 8355584, null);
            return;
        }
        C4148a.h(TAG, "openWakeDesktopOverlay aborted: no setLaunchTaskId (taskId=" + iD + ")", false, 4, null);
    }

    public final boolean G(Context context) {
        Object objB;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        kotlin.jvm.internal.p.i(context, "context");
        if (com.stepos.ailauncher.chat.lockscreen.I.INSTANCE.j(context)) {
            return false;
        }
        boolean zF = f(context);
        try {
            Result.Companion companion = Result.INSTANCE;
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            objB = Result.b((activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) == null) ? null : Integer.valueOf(runningTaskInfo.taskId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        int iIntValue = num != null ? num.intValue() : -1;
        s0.Companion aVar = s0.INSTANCE;
        boolean zA = c0.a(zF, aVar.b("desktop").v(iIntValue), aVar.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).v(iIntValue), !zF && DesktopChatResidentController.L0() > 0);
        C4148a.k(TAG, "homebar prewarm defer=" + zA + " launcher=" + zF + " task=" + iIntValue, false, 4, null);
        return zA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9 */
    public final void H(Context context, ChatEntry entry, ChatScene scene, String sessionId, SheetHeightMode heightMode, Bundle optionsBundle, boolean forceNewTask, String wakeSource, String initialPrompt, String agentId, String deviceId, String agentDisplayName, int layer, boolean clearStack, boolean prepareStack, boolean isWake, boolean homeMode, boolean restoreLast, boolean clearTask, boolean multipleTask, String visualStackRoot, boolean inheritStackScrim, long embeddedScrimHandoff) {
        ?? r12;
        if (scene != ChatScene.LOCK_SCREEN && com.stepos.ailauncher.chat.lockscreen.I.INSTANCE.j(context)) {
            l0.INSTANCE.g(embeddedScrimHandoff);
            C4148a.h(TAG, "start() on secure keyguard with scene=" + scene + " — redirecting to lock screen sheet. 调用方应改走 openLockScreen()", false, 4, null);
            r(context, wakeSource, sessionId, null, restoreLast, false, 40, null);
            return;
        }
        String strE = layer > 1 ? C2735f.INSTANCE.e(context) : C2735f.INSTANCE.f(scene);
        s0 s0VarB = s0.INSTANCE.b(visualStackRoot == null ? strE : visualStackRoot);
        if (clearStack) {
            s0VarB.p();
        } else if (prepareStack) {
            s0VarB.G();
        }
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        String str = strE;
        intent.putExtra("com.stepos.ailauncher.chat.sheet.ENTRY", entry.getWireValue());
        intent.putExtra("com.stepos.ailauncher.chat.sheet.SCENE", scene.getWireValue());
        if (sessionId != null && sessionId.length() != 0) {
            intent.putExtra(ChatMainActivity.EXTRA_CHAT_SESSION_ID, sessionId);
        }
        if (restoreLast) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.RESTORE_LAST_SESSION", true);
        }
        if (wakeSource != null && wakeSource.length() != 0) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.WAKE_SOURCE", wakeSource);
        }
        if (initialPrompt != null && !La.H.x0(initialPrompt)) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.INITIAL_PROMPT", initialPrompt);
        }
        if (agentId != null && !La.H.x0(agentId)) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.AGENT_ID", agentId);
        }
        if (deviceId != null && !La.H.x0(deviceId)) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.DEVICE_ID", deviceId);
        }
        if (agentDisplayName != null && !La.H.x0(agentDisplayName)) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.AGENT_DISPLAY_NAME", agentDisplayName);
        }
        if (isWake) {
            r12 = 1;
            intent.putExtra("com.stepos.ailauncher.chat.sheet.IS_WAKE", true);
        } else {
            r12 = 1;
        }
        if (homeMode) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.HOME_MODE", (boolean) r12);
        }
        if (launchingHomeBarPrewarm) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.HOMEBAR_PREWARM", (boolean) r12);
        }
        if (inheritStackScrim) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.INHERIT_STACK_SCRIM", (boolean) r12);
        }
        if (embeddedScrimHandoff != 0) {
            intent.putExtra("com.stepos.ailauncher.chat.sheet.EMBEDDED_SCRIM_HANDOFF", embeddedScrimHandoff);
        }
        new SheetLaunchOptions(heightMode, layer, false, str, (layer > r12 || entry == ChatEntry.SHEET_DEMO || entry == ChatEntry.AMOO_STORE) ? false : r12, visualStackRoot, 4, null).a(intent);
        if (forceNewTask || multipleTask) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (multipleTask) {
            intent.addFlags(134217728);
        }
        if (clearTask) {
            intent.addFlags(268468224);
        }
        if (scene.isStandaloneTask()) {
            intent.addFlags(8388608);
        }
        try {
            if (optionsBundle != null) {
                context.startActivity(intent, optionsBundle);
            } else {
                context.startActivity(intent);
            }
        } catch (SecurityException e10) {
            C4148a.g(TAG, "startActivity SecurityException (need START_TASKS_FROM_RECENTS / platform?). scene=" + scene + " taskId=" + C2740k.INSTANCE.a(), e10, false, 8, null);
            if (optionsBundle == null) {
                throw e10;
            }
            Intent intent2 = new Intent(intent);
            intent2.removeExtra("com.stepos.ailauncher.sheet.extra.VISUAL_STACK_ROOT");
            intent2.removeExtra("com.stepos.ailauncher.chat.sheet.INHERIT_STACK_SCRIM");
            intent2.removeExtra("com.stepos.ailauncher.chat.sheet.EMBEDDED_SCRIM_HANDOFF");
            l0.INSTANCE.g(embeddedScrimHandoff);
            if (!(context instanceof Activity)) {
                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            intent2.addFlags(8388608);
            try {
                context.startActivity(intent2);
            } catch (Throwable th) {
                C4148a.g(TAG, "fallback startActivity failed", th, false, 8, null);
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.content.Context r10) {
        /*
            r9 = this;
            com.stepos.ailauncher.chat.minor.a r9 = com.stepos.ailauncher.chat.minor.a.INSTANCE
            boolean r9 = r9.c()
            r0 = 0
            if (r9 == 0) goto L11
            int r9 = com.stepos.ailauncher.chat.R$string.minor_mode_ai_disabled
            java.lang.String r9 = r10.getString(r9)
        Lf:
            r3 = r9
            goto L27
        L11:
            com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker r9 = com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker.INSTANCE
            boolean r1 = r9.f()
            if (r1 == 0) goto L26
            com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker$a r1 = r9.c()
            int r9 = r9.j(r1)
            java.lang.String r9 = r10.getString(r9)
            goto Lf
        L26:
            r3 = r0
        L27:
            if (r3 != 0) goto L2b
            r9 = 1
            return r9
        L2b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "openSessionNineSplit blocked: "
            r9.append(r1)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            r1 = 4
            java.lang.String r2 = "ChatLaunchRouter"
            r8 = 0
            h8.C4148a.k(r2, r9, r8, r1, r0)
            com.stepos.ailauncher.chat.lockscreen.H r1 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE
            r6 = 4
            r7 = 0
            r4 = 0
            r2 = r10
            com.stepos.ailauncher.chat.lockscreen.H.k(r1, r2, r3, r4, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.sheet.C2739j.c(android.content.Context):boolean");
    }

    public final Activity e(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void g(Context context, int coveredTaskId, String sessionId, boolean restoreLast) {
        I(this, context, ChatEntry.CHAT, ChatScene.BOARD, sessionId, SheetHeightMode.FULL_9, null, true, null, null, null, null, null, 0, false, false, false, false, restoreLast, false, true, null, false, 0L, 7733120, null);
    }

    public final void j(Context context, String sessionId, boolean restoreLast) {
        int iD = C2740k.INSTANCE.d(context);
        s0.Companion aVar = s0.INSTANCE;
        if (aVar.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).v(iD)) {
            C4148a.k(TAG, "openChatOverMinusOneCoveredSheets visualRoot=minus_one homeRoot=desktop task=" + iD, false, 4, null);
            m(context, ChatEntry.CHAT, sessionId, SheetHeightMode.FULL_9, false, iD, false, restoreLast, false, com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE, launchingHomeBarPrewarm ^ true, launchingHomeBarPrewarm ^ true);
            return;
        }
        if (!launchingHomeBarPrewarm) {
            l0.INSTANCE.f();
        }
        if (DesktopChatResidentController.S1()) {
            o(context, sessionId, restoreLast, true);
        } else if (aVar.b("desktop").R() > 0) {
            o(context, sessionId, restoreLast, false);
        } else {
            l(context, ChatEntry.CHAT, sessionId, SheetHeightMode.FULL_9, false, 0, false, restoreLast, 112, null);
        }
    }

    public final void m(Context context, ChatEntry entry, String sessionId, SheetHeightMode heightMode, boolean taskAlwaysOnTop, int launcherTaskId, boolean homeMode, boolean restoreLast, boolean clearStack, String visualStackRoot, boolean inheritStackScrim, boolean handoffEmbeddedScrim) {
        Integer numValueOf = Integer.valueOf(launcherTaskId);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : C2740k.INSTANCE.d(context);
        Bundle bundleE = C2733d.e(C2733d.INSTANCE, iIntValue, false, taskAlwaysOnTop, 2, null);
        if (bundleE == null) {
            C4148a.h(TAG, "openDesktop aborted: no setLaunchTaskId (taskId=" + iIntValue + "). Avoid creating standalone board task for DESKTOP.", false, 4, null);
            return;
        }
        long jC = handoffEmbeddedScrim ? l0.INSTANCE.c() : 0L;
        try {
            I(this, context, entry, ChatScene.DESKTOP, sessionId, heightMode, bundleE, !(context instanceof Activity), null, null, null, null, null, 0, clearStack, false, false, homeMode, restoreLast, false, false, visualStackRoot, inheritStackScrim, jC, 843648, null);
        } catch (Throwable th) {
            l0.INSTANCE.g(jC);
            throw th;
        }
    }

    public final void o(Context context, String sessionId, boolean restoreLast, boolean residentStillAlive) {
        int iR = s0.INSTANCE.b("desktop").R();
        boolean z10 = !residentStillAlive ? iR <= 0 : iR <= 1;
        C4148a.k(TAG, "openDesktopOverCoveredStack stackSize=" + iR + " residentStillAlive=" + residentStillAlive + " preserve=" + z10, false, 4, null);
        n(this, context, ChatEntry.CHAT, sessionId, SheetHeightMode.FULL_9, false, -1, false, restoreLast, !z10, null, z10 && !launchingHomeBarPrewarm, false, 2560, null);
    }

    public final String u(Context context, String sessionId, boolean allowRecentFallback, boolean fromNotification) {
        C4148a.k(TAG, "openRestoreNineSplit ← sessionId=" + sessionId + " allowRecentFallback=" + allowRecentFallback, false, 4, null);
        if (com.stepos.ailauncher.chat.lockscreen.I.INSTANCE.j(context)) {
            r(context, null, sessionId, SheetHeightMode.FULL_9, allowRecentFallback, false, 32, null);
            C4148a.k(TAG, "openRestoreNineSplit → lockScreen sheet", false, 4, null);
            return com.stepos.ailauncher.chat.util.g.REASON_LOCKSCREEN;
        }
        boolean zH = m0.INSTANCE.h();
        s0.Companion aVar = s0.INSTANCE;
        int iR = aVar.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).R();
        if (zH && !launchingHomeBarPrewarm && l0.INSTANCE.k(sessionId, allowRecentFallback)) {
            C4148a.k(TAG, "openRestoreNineSplit → home embedded restore", false, 4, null);
            return "home_embedded";
        }
        String strA = g0.a(zH, iR, f(context), false);
        if (kotlin.jvm.internal.p.d(strA, "minus_one_stack")) {
            DesktopChatResidentController.l3("long-press");
            C4148a.k(TAG, "openRestoreNineSplit → minus_one_stack", false, 4, null);
            return "minus_one_stack";
        }
        if (kotlin.jvm.internal.p.d(strA, "minus_one_covered_cold")) {
            j(context, sessionId, allowRecentFallback);
            C4148a.k(TAG, "openRestoreNineSplit → minus_one_covered_cold", false, 4, null);
            return "minus_one_covered_cold";
        }
        if (zH) {
            C4148a.u(TAG, "openRestoreNineSplit → overlay open but embedded restore not registered, fall through", false, 4, null);
        }
        if (f(context)) {
            if (DesktopChatResidentController.S1()) {
                p(this, context, sessionId, allowRecentFallback, false, 8, null);
                C4148a.k(TAG, "openRestoreNineSplit → desktop overlay on top (resident covered by stacked sheet)", false, 4, null);
                return "desktop_top";
            }
            if (!launchingHomeBarPrewarm && DesktopChatResidentController.Q0(sessionId, allowRecentFallback)) {
                C4148a.k(TAG, "openRestoreNineSplit → deliver resident (desktop)", false, 4, null);
                return "deliver";
            }
            if (aVar.b("desktop").R() > 0) {
                o(context, sessionId, allowRecentFallback, false);
                C4148a.k(TAG, "openRestoreNineSplit → desktop overlay on top (stale stacked sheet, no resident)", false, 4, null);
                return "desktop_top";
            }
            l(context, ChatEntry.CHAT, sessionId, SheetHeightMode.FULL_9, false, 0, false, allowRecentFallback, 112, null);
            C4148a.k(TAG, "openRestoreNineSplit → desktop overlay", false, 4, null);
            return "desktop";
        }
        int iL0 = DesktopChatResidentController.L0();
        if (iL0 > 0) {
            g(context, iL0, sessionId, allowRecentFallback);
            C4148a.k(TAG, "openRestoreNineSplit → cold board fresh-task over covered task=" + iL0 + " (standalone board covered by stacked sheet)", false, 4, null);
            return "board_covered_cold";
        }
        if (!launchingHomeBarPrewarm && DesktopChatResidentController.O0(sessionId, allowRecentFallback)) {
            C4148a.k(TAG, "openRestoreNineSplit → deliver board", false, 4, null);
            return "board_deliver";
        }
        i(context, ChatEntry.CHAT, sessionId, SheetHeightMode.FULL_9, null, false, allowRecentFallback, fromNotification, 16, null);
        C4148a.k(TAG, "openRestoreNineSplit → chatBoard (third-party)", false, 4, null);
        return "board";
    }

    public final String x(Context context, String sessionId) {
        if (!f(context)) {
            i(context, ChatEntry.CHAT, sessionId, SheetHeightMode.HALF_EXPANDABLE, null, false, false, false, 208, null);
            C4148a.k(TAG, "openWake → chatBoard restore-half (third-party)", false, 4, null);
            return "board";
        }
        if (DesktopChatResidentController.S1()) {
            l(context, ChatEntry.CHAT, sessionId, SheetHeightMode.HALF_EXPANDABLE, false, 0, false, false, 240, null);
            C4148a.k(TAG, "openWake → desktop overlay restore-half on top (resident covered by stacked sheet)", false, 4, null);
            return "desktop_top";
        }
        if (DesktopChatResidentController.S0(sessionId)) {
            C4148a.k(TAG, "openWake → deliver resident restore-half (desktop)", false, 4, null);
            return "deliver";
        }
        l(context, ChatEntry.CHAT, sessionId, SheetHeightMode.HALF_EXPANDABLE, false, 0, false, false, 240, null);
        C4148a.k(TAG, "openWake → desktop overlay restore-half", false, 4, null);
        return "desktop";
    }
}
