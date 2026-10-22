package com.stepos.ailauncher.chat.activity;

import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.ailauncher.chat.R$anim;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.lockscreen.C2670c;
import com.stepos.ailauncher.chat.lockscreen.C2682o;
import com.stepos.ailauncher.chat.lockscreen.ChatMainLockRoute;
import com.stepos.ailauncher.chat.lockscreen.LockScreenChatAction;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.view.C2996w;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.chat.wake.DialogC3116e0;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.common.memory.e;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherRedirectActivity;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import o5.C5006a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001Y\u0018\u0000 c2\u00020\u0001:\u0003defB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0003J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0003J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0014¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\bH\u0014¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\bH\u0014¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\bH\u0014¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0014¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\u0003J\u0019\u0010,\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010/\u001a\u00020\u0011H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0011H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\u0003J\u000f\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u0010\u0003J\u0019\u00108\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b8\u0010\u001eJ\u0019\u00109\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b9\u0010\u001eJ\u000f\u0010:\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010\u0006J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b;\u0010-J\u0017\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0011H\u0002¢\u0006\u0004\b=\u00104J\u000f\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010\u0003J\u0017\u0010?\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0011H\u0002¢\u0006\u0004\b?\u00104J\u001f\u0010A\u001a\u00020\b2\u0006\u00102\u001a\u00020\u00112\u0006\u0010@\u001a\u00020&H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\bC\u0010\u001eJ\u000f\u0010D\u001a\u00020\bH\u0002¢\u0006\u0004\bD\u0010\u0003J\u0017\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u001bH\u0002¢\u0006\u0004\bF\u0010\u001eJ\u000f\u0010G\u001a\u00020\bH\u0002¢\u0006\u0004\bG\u0010\u0003J\u000f\u0010H\u001a\u00020\bH\u0002¢\u0006\u0004\bH\u0010\u0003J\u0017\u0010I\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\bI\u0010)R\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010Q\u001a\b\u0018\u00010PR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010>R\u0014\u0010Z\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010?R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\u0006¨\u0006g"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatMainActivity;", "Lz5/a;", "<init>", "()V", "", "c0", "()Z", "Lkotlin/Function1;", "LY8/t;", "onResult", "j0", "(Lp9/l;)V", "h0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "deviceId", "agentType", "deviceName", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "M", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "k0", "p0", "e0", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "hasFocus", "onWindowFocusChanged", "(Z)V", "onResume", UxipConstants.f30640D, "onPause", "onStop", "", "level", "onTrimMemory", "(I)V", "onDestroy", "finish", "d0", "(Landroid/content/Intent;)Z", "incoming", "from", "n0", "(Landroid/content/Intent;Ljava/lang/String;)Z", "sessionId", "L", "(Ljava/lang/String;)V", "g0", ExifInterface.GPS_DIRECTION_TRUE, "x0", ExifInterface.LONGITUDE_WEST, "N", "R", "o0", "source", "q0", "Z", "J", "attempt", "s0", "(Ljava/lang/String;I)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "l0", "incomingIntent", "O", "Q", ExifInterface.LATITUDE_SOUTH, "r0", "Lcom/stepos/ailauncher/chat/lockscreen/c;", "host", "Lcom/stepos/ailauncher/chat/lockscreen/c;", "Lcom/stepos/ailauncher/common/memory/e$a;", "heapPageTrimListener", "Lcom/stepos/ailauncher/common/memory/e$a;", "Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$c;", "lockFlagsController", "Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$c;", "pendingUnlockSessionId", "Ljava/lang/String;", "Landroid/content/BroadcastReceiver;", "unlockSessionReceiver", "Landroid/content/BroadcastReceiver;", "isLockedFullChat", "com/stepos/ailauncher/chat/activity/ChatMainActivity$e", "accountCallback", "Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$e;", "", "foregroundAt", "Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$b;", "lastExternalSessionArgs", "Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$b;", "U", "seamlessLockHandoff", "Companion", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatMainActivity extends ActivityC6361a {
    private static final long BACK_DEBOUNCE_AFTER_FOREGROUND_MS = 300;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_CHAT_SESSION_ID = "chat_session_id";
    public static final String EXTRA_FORCE_NEW_SESSION = "extra_force_new_session";
    public static final String EXTRA_FROM_LOCKSCREEN_WAKE = "chat_from_lockscreen_wake";
    public static final String EXTRA_NEW_CHAT = "chat_new_chat";
    private static final String EXTRA_RESTORE_LOCK_CHAT = "chat_restore_lock_chat";
    public static final String EXTRA_SEAMLESS_LOCK_HANDOFF = "chat_seamless_lock_handoff";
    public static final String EXTRA_SKIP_KEYGUARD_ROUTE = "chat_skip_keyguard_route";
    private static final int MAX_SESSION_SWITCH_ATTEMPTS = 10;
    private static final long SESSION_SWITCH_RETRY_INTERVAL_MS = 200;
    private static final long SESSION_SWITCH_VERIFY_DELAY_MS = 500;
    private static final String TAG = "ChatMainActivity";
    private long foregroundAt;
    private C2670c host;
    private boolean isLockedFullChat;
    private ExternalSessionArgs lastExternalSessionArgs;
    private c lockFlagsController;
    private String pendingUnlockSessionId;
    private BroadcastReceiver unlockSessionReceiver;
    private final e.a heapPageTrimListener = new e.a() { // from class: com.stepos.ailauncher.chat.activity.x0
        @Override // com.stepos.ailauncher.common.memory.e.a
        public final void a(int i10) {
            ChatMainActivity.Y(this.f24895a, i10);
        }
    };
    private final e accountCallback = new e();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "EXTRA_NEW_CHAT", "EXTRA_FORCE_NEW_SESSION", "", "BACK_DEBOUNCE_AFTER_FOREGROUND_MS", "J", "EXTRA_RESTORE_LOCK_CHAT", "EXTRA_SKIP_KEYGUARD_ROUTE", "EXTRA_SEAMLESS_LOCK_HANDOFF", "EXTRA_FROM_LOCKSCREEN_WAKE", "EXTRA_CHAT_SESSION_ID", "SESSION_SWITCH_RETRY_INTERVAL_MS", "SESSION_SWITCH_VERIFY_DELAY_MS", "", "MAX_SESSION_SWITCH_ATTEMPTS", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.ChatMainActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) ChatMainActivity.class);
            intent.addFlags(805306368);
            intent.putExtra(ChatMainActivity.EXTRA_RESTORE_LOCK_CHAT, true);
            intent.putExtra(ChatMainActivity.EXTRA_SKIP_KEYGUARD_ROUTE, true);
            intent.putExtra(ChatMainActivity.EXTRA_SEAMLESS_LOCK_HANDOFF, true);
            C2682o.INSTANCE.f(intent);
            context.startActivity(intent, ActivityOptions.makeCustomAnimation(context, 0, 0).toBundle());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$b;", "", "", "deviceId", "agentType", "deviceName", "", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgentType", "getDeviceName", "Z", "getOnline", "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.ChatMainActivity$b, reason: from toString */
    public static final /* data */ class ExternalSessionArgs {
        private final String agentType;
        private final String deviceId;
        private final String deviceName;
        private final boolean online;

        public ExternalSessionArgs(String deviceId, String agentType, String deviceName, boolean z10) {
            kotlin.jvm.internal.p.i(deviceId, "deviceId");
            kotlin.jvm.internal.p.i(agentType, "agentType");
            kotlin.jvm.internal.p.i(deviceName, "deviceName");
            this.deviceId = deviceId;
            this.agentType = agentType;
            this.deviceName = deviceName;
            this.online = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExternalSessionArgs)) {
                return false;
            }
            ExternalSessionArgs externalSessionArgs = (ExternalSessionArgs) other;
            return kotlin.jvm.internal.p.d(this.deviceId, externalSessionArgs.deviceId) && kotlin.jvm.internal.p.d(this.agentType, externalSessionArgs.agentType) && kotlin.jvm.internal.p.d(this.deviceName, externalSessionArgs.deviceName) && this.online == externalSessionArgs.online;
        }

        public int hashCode() {
            return (((((this.deviceId.hashCode() * 31) + this.agentType.hashCode()) * 31) + this.deviceName.hashCode()) * 31) + Boolean.hashCode(this.online);
        }

        public String toString() {
            return "ExternalSessionArgs(deviceId=" + this.deviceId + ", agentType=" + this.agentType + ", deviceName=" + this.deviceName + ", online=" + this.online + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/ChatMainActivity$c;", "", "<init>", "(Lcom/stepos/ailauncher/chat/activity/ChatMainActivity;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "Landroid/content/BroadcastReceiver;", "userPresentReceiver", "Landroid/content/BroadcastReceiver;", "screenOffReceiver", "", "cleared", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class c {
        private boolean cleared;
        private BroadcastReceiver screenOffReceiver;
        private BroadcastReceiver userPresentReceiver;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/activity/ChatMainActivity$c$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                kotlin.jvm.internal.p.i(context, "context");
                kotlin.jvm.internal.p.i(intent, "intent");
                if (kotlin.jvm.internal.p.d(intent.getAction(), "android.intent.action.USER_PRESENT")) {
                    C4148a.k(ChatMainActivity.TAG, "LockFlagsController: USER_PRESENT, clearing lock flags -> FullUnlocked", false, 4, null);
                    c.this.b();
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/activity/ChatMainActivity$c$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class b extends BroadcastReceiver {
            final /* synthetic */ ChatMainActivity this$0;

            public b(ChatMainActivity chatMainActivity) {
                this.this$0 = chatMainActivity;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                kotlin.jvm.internal.p.i(context, "context");
                kotlin.jvm.internal.p.i(intent, "intent");
                if (kotlin.jvm.internal.p.d(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    C4148a.k(ChatMainActivity.TAG, "LockFlagsController: SCREEN_OFF, finishing locked chat", false, 4, null);
                    if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                        return;
                    }
                    this.this$0.finish();
                }
            }
        }

        public c() {
        }

        public final void a() {
            ChatMainActivity.this.setShowWhenLocked(true);
            ChatMainActivity.this.setTurnScreenOn(true);
            a aVar = new a();
            this.userPresentReceiver = aVar;
            ChatMainActivity.this.registerReceiver(aVar, new IntentFilter("android.intent.action.USER_PRESENT"));
            b bVar = new b(ChatMainActivity.this);
            this.screenOffReceiver = bVar;
            ChatMainActivity.this.registerReceiver(bVar, new IntentFilter("android.intent.action.SCREEN_OFF"));
        }

        public final void b() {
            Object objB;
            Object objB2;
            if (this.cleared) {
                return;
            }
            this.cleared = true;
            ChatMainActivity.this.setShowWhenLocked(false);
            ChatMainActivity.this.setTurnScreenOn(false);
            ChatMainActivity.this.isLockedFullChat = false;
            if (ChatMainActivity.this.host != null) {
                ChatMainActivity chatMainActivity = ChatMainActivity.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    C2670c c2670c = chatMainActivity.host;
                    if (c2670c == null) {
                        kotlin.jvm.internal.p.A("host");
                        c2670c = null;
                    }
                    c2670c.d().setLockScreenMode(false);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
            BroadcastReceiver broadcastReceiver = this.userPresentReceiver;
            if (broadcastReceiver != null) {
                ChatMainActivity chatMainActivity2 = ChatMainActivity.this;
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    chatMainActivity2.unregisterReceiver(broadcastReceiver);
                    objB2 = Result.b(Y8.t.f7040a);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th2));
                }
                Result.a(objB2);
            }
            this.userPresentReceiver = null;
            BroadcastReceiver broadcastReceiver2 = this.screenOffReceiver;
            if (broadcastReceiver2 != null) {
                ChatMainActivity chatMainActivity3 = ChatMainActivity.this;
                try {
                    Result.Companion companion5 = Result.INSTANCE;
                    chatMainActivity3.unregisterReceiver(broadcastReceiver2);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th3) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th3));
                }
                Result.a(objB);
            }
            this.screenOffReceiver = null;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChatMainLockRoute.values().length];
            try {
                iArr[ChatMainLockRoute.REDIRECT_TO_LOCK_SCREEN_CHAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatMainLockRoute.LOCKED_FULL_CHAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatMainLockRoute.CONTINUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/activity/ChatMainActivity$e", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements com.stepos.ailauncher.foundation.account.i {
        public e() {
        }

        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            if (accountInfo != null || ChatMainActivity.this.isFinishing() || ChatMainActivity.this.isDestroyed()) {
                return;
            }
            C4148a.k(ChatMainActivity.TAG, "accountStateChanged: logged out, finishAndRemoveTask to drop task snapshot", false, 4, null);
            ChatMainActivity.this.finishAndRemoveTask();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/activity/ChatMainActivity$f", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(intent, "intent");
            if (kotlin.jvm.internal.p.d(intent.getAction(), "android.intent.action.USER_PRESENT")) {
                ChatMainActivity.this.T();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/activity/ChatMainActivity$g", "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "LY8/t;", "onDismissSucceeded", "()V", "onDismissCancelled", "onDismissError", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends KeyguardManager.KeyguardDismissCallback {
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;

        /* JADX WARN: Multi-variable type inference failed */
        public g(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
            this.$onResult = interfaceC5074l;
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissCancelled() {
            C4148a.u(ChatMainActivity.TAG, "requestUnlockForLockedAction: cancelled", false, 4, null);
            this.$onResult.invoke(Boolean.FALSE);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissError() {
            C4148a.u(ChatMainActivity.TAG, "requestUnlockForLockedAction: error", false, 4, null);
            this.$onResult.invoke(Boolean.FALSE);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissSucceeded() {
            C4148a.k(ChatMainActivity.TAG, "requestUnlockForLockedAction: success", false, 4, null);
            c cVar = ChatMainActivity.this.lockFlagsController;
            if (cVar != null) {
                cVar.b();
            }
            this.$onResult.invoke(Boolean.TRUE);
        }
    }

    public static final void K(ChatMainActivity chatMainActivity, String str) {
        chatMainActivity.s0(str, 0);
    }

    public static final void P(ChatMainActivity chatMainActivity) {
        LockScreenChatAction lockScreenChatActionE = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.e();
        if (lockScreenChatActionE != null) {
            C2670c c2670c = chatMainActivity.host;
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            c2670c.d().k0(lockScreenChatActionE);
        }
    }

    public static final void X(ChatMainActivity chatMainActivity, String str, String str2) {
        Object objB;
        Object objValueOf;
        try {
            Result.Companion companion = Result.INSTANCE;
            C2670c c2670c = chatMainActivity.host;
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            ChatView chatView = (ChatView) c2670c.d().findViewById(R$id.agentChatView);
            C4148a.k(TAG, "handleNewChatIntentIfAny.post: chatView=" + (chatView != null) + " calling createNewChat(agent=" + str + ", device=" + str2 + ")", false, 4, null);
            if (chatView == null) {
                objValueOf = Integer.valueOf(C4148a.u(TAG, "EXTRA_NEW_CHAT: ChatView not found, stale session may remain", false, 4, null));
            } else {
                ChatView.L1(chatView, str, str2, false, 4, null);
                objValueOf = Y8.t.f7040a;
            }
            objB = Result.b(objValueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "EXTRA_NEW_CHAT: createNewChat failed", thE, false, 8, null);
        }
    }

    public static final void Y(ChatMainActivity chatMainActivity, int i10) {
        if (chatMainActivity.host != null) {
            chatMainActivity.r0(i10);
        }
    }

    public static final Y8.t a0(ChatMainActivity chatMainActivity) {
        chatMainActivity.finish();
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(ChatMainActivity chatMainActivity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - chatMainActivity.foregroundAt;
        if (0 > jElapsedRealtime || jElapsedRealtime >= 300) {
            chatMainActivity.getOnBackPressedDispatcher().q();
        } else {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("ignore back leaked right after foreground: %dms", Arrays.copyOf(new Object[]{Long.valueOf(jElapsedRealtime)}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t f0(ChatMainActivity chatMainActivity, int i10) {
        chatMainActivity.r0(i10);
        return Y8.t.f7040a;
    }

    public static final void i0(ChatMainActivity chatMainActivity, LockScreenChatAction lockScreenChatAction) {
        C2670c c2670c = chatMainActivity.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.d().k0(lockScreenChatAction);
    }

    public static final void m0(ChatMainActivity chatMainActivity) {
        LockScreenChatAction lockScreenChatActionE = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.e();
        if (lockScreenChatActionE != null) {
            C2670c c2670c = chatMainActivity.host;
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            c2670c.d().k0(lockScreenChatActionE);
        }
    }

    public static final void t0(ChatMainActivity chatMainActivity, String str, int i10) {
        chatMainActivity.s0(str, i10 + 1);
    }

    public static final Y8.t u0(final ChatMainActivity chatMainActivity, final int i10, final String str, final ChatView chatView, boolean z10) {
        if (chatMainActivity.host == null) {
            return Y8.t.f7040a;
        }
        C2670c c2670c = null;
        if (z10) {
            chatView.w1(str);
            C2670c c2670c2 = chatMainActivity.host;
            if (c2670c2 == null) {
                kotlin.jvm.internal.p.A("host");
            } else {
                c2670c = c2670c2;
            }
            c2670c.d().postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.u0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatMainActivity.w0(chatView, str, i10, chatMainActivity);
                }
            }, 500L);
            return Y8.t.f7040a;
        }
        if (i10 < 10) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str2 = String.format("trySwitchToSession: session not found locally, retry attempt=%d sessionId=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i10), str}, 2));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.u(TAG, str2, false, 4, null);
            C2670c c2670c3 = chatMainActivity.host;
            if (c2670c3 == null) {
                kotlin.jvm.internal.p.A("host");
            } else {
                c2670c = c2670c3;
            }
            c2670c.d().postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.F0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatMainActivity.v0(this.f24724a, str, i10);
                }
            }, 500L);
        } else {
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
            String str3 = String.format("trySwitchToSession: session not found after %d attempts, give up sessionId=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i10), str}, 2));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.u(TAG, str3, false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final void v0(ChatMainActivity chatMainActivity, String str, int i10) {
        chatMainActivity.s0(str, i10 + 1);
    }

    public static final void w0(ChatView chatView, String str, int i10, ChatMainActivity chatMainActivity) {
        boolean z10 = kotlin.jvm.internal.p.d(chatView.getCurrentSessionId(), str) || chatView.P1().contains(str);
        if (z10 || i10 >= 10) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str2 = String.format("trySwitchToSession: landed=%s attempt=%d sessionId=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(z10), Integer.valueOf(i10), str}, 3));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.k(TAG, str2, false, 4, null);
            return;
        }
        kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
        String str3 = String.format("trySwitchToSession: not landed (top=%s), retry attempt=%d sessionId=%s", Arrays.copyOf(new Object[]{chatView.getCurrentSessionId(), Integer.valueOf(i10), str}, 3));
        kotlin.jvm.internal.p.h(str3, "format(...)");
        C4148a.u(TAG, str3, false, 4, null);
        chatMainActivity.s0(str, i10 + 1);
    }

    public final void J(final String sessionId) {
        C2670c c2670c = this.host;
        C2670c c2670c2 = null;
        if (c2670c == null) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("applyChatSessionId: host not initialized, skip sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.u(TAG, str, false, 4, null);
            return;
        }
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        ChatView chatView = (ChatView) c2670c.d().findViewById(R$id.agentChatView);
        if (chatView != null) {
            chatView.N2(sessionId);
        }
        C2670c c2670c3 = this.host;
        if (c2670c3 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c2 = c2670c3;
        }
        c2670c2.d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.A0
            @Override // java.lang.Runnable
            public final void run() {
                ChatMainActivity.K(this.f24698a, sessionId);
            }
        });
    }

    public final void L(String sessionId) {
        Object systemService = getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            J(sessionId);
            return;
        }
        C4148a.k(TAG, "applyChatSessionIdWhenUnlocked: keyguard locked, defer session switch", false, 4, null);
        this.pendingUnlockSessionId = sessionId;
        g0();
    }

    public final void M(String deviceId, String agentType, String deviceName, boolean online) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(deviceName, "deviceName");
        if (La.H.x0(deviceId) || La.H.x0(deviceName)) {
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("external session top bar: device=%s agent=%s name=%s online=%s", Arrays.copyOf(new Object[]{deviceId, agentType, deviceName, Boolean.valueOf(online)}, 4));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C2670c c2670c = null;
        C4148a.d(TAG, str, false, 4, null);
        this.lastExternalSessionArgs = new ExternalSessionArgs(deviceId, agentType, deviceName, online);
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        C2996w.c(c2670c.d(), deviceId, agentType, deviceName, online);
    }

    public final void N(Intent intent) {
        String stringExtra = intent != null ? intent.getStringExtra(WakeDialogImpl.EXTRA_EXTERNAL_DEVICE_ID) : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = intent != null ? intent.getStringExtra(WakeDialogImpl.EXTRA_EXTERNAL_DEVICE_NAME) : null;
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        if (La.H.x0(stringExtra) || La.H.x0(stringExtra2)) {
            k0();
            return;
        }
        String stringExtra3 = intent != null ? intent.getStringExtra(WakeDialogImpl.EXTRA_EXTERNAL_AGENT_TYPE) : null;
        String str = stringExtra3 != null ? stringExtra3 : "";
        boolean z10 = false;
        if (intent != null && intent.getBooleanExtra(WakeDialogImpl.EXTRA_EXTERNAL_DEVICE_ONLINE, false)) {
            z10 = true;
        }
        M(stringExtra, str, stringExtra2, z10);
    }

    public final void O(Intent incomingIntent) {
        AgentConfig.Companion companion = AgentConfig.INSTANCE;
        C2670c c2670c = null;
        SessionHandler sessionHandlerJ = AgentConfig.j(companion.a(), false, null, 3, null);
        if (sessionHandlerJ != null) {
            companion.a().x(sessionHandlerJ);
        }
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            return;
        }
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c2 = null;
        }
        ChatView chatView = (ChatView) c2670c2.d().findViewById(R$id.agentChatView);
        if (chatView != null) {
            chatView.a3();
        }
        if (incomingIntent.getBooleanExtra(EXTRA_RESTORE_LOCK_CHAT, false)) {
            C2670c c2670c3 = this.host;
            if (c2670c3 == null) {
                kotlin.jvm.internal.p.A("host");
            } else {
                c2670c = c2670c3;
            }
            c2670c.d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.z0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatMainActivity.P(this.f24904a);
                }
            });
        }
    }

    public final void Q() {
        C2670c c2670c = this.host;
        if (c2670c == null) {
            return;
        }
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        ChatView chatView = (ChatView) c2670c.d().findViewById(R$id.agentChatView);
        if (chatView != null) {
            chatView.setActivity(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean R() {
        /*
            r10 = this;
            com.stepos.ailauncher.chat.minor.a r0 = com.stepos.ailauncher.chat.minor.a.INSTANCE
            boolean r0 = r0.c()
            r1 = 0
            if (r0 == 0) goto L11
            int r0 = com.stepos.ailauncher.chat.R$string.minor_mode_ai_disabled
            java.lang.String r0 = r10.getString(r0)
        Lf:
            r4 = r0
            goto L27
        L11:
            com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker r0 = com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker.INSTANCE
            boolean r2 = r0.f()
            if (r2 == 0) goto L26
            com.stepos.ailauncher.chat.lowpower.TempPowerLowChecker$a r2 = r0.c()
            int r0 = r0.j(r2)
            java.lang.String r0 = r10.getString(r0)
            goto Lf
        L26:
            r4 = r1
        L27:
            r0 = 1
            java.lang.String r2 = "getApplicationContext(...)"
            r3 = 4
            java.lang.String r5 = "ChatMainActivity"
            r9 = 0
            if (r4 == 0) goto L4e
            java.lang.String r6 = "restricted lock-screen entry -> block and finish"
            h8.C4148a.k(r5, r6, r9, r3, r1)
            r6 = r2
            com.stepos.ailauncher.chat.lockscreen.H r2 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE
            android.content.Context r3 = r10.getApplicationContext()
            kotlin.jvm.internal.p.h(r3, r6)
            r7 = 4
            r8 = 0
            r5 = 0
            com.stepos.ailauncher.chat.lockscreen.H.f(r2, r3, r4, r5, r7, r8)
            r10.finish()
            r10.overridePendingTransition(r9, r9)
            return r0
        L4e:
            r6 = r2
            com.stepos.ailauncher.chat.wake.A r2 = com.stepos.ailauncher.chat.wake.A.INSTANCE
            android.content.Context r4 = r10.getApplicationContext()
            kotlin.jvm.internal.p.h(r4, r6)
            boolean r2 = r2.d(r4)
            if (r2 == 0) goto L5f
            return r9
        L5f:
            java.lang.String r2 = "account gate denied direct lock-screen entry -> finish"
            h8.C4148a.k(r5, r2, r9, r3, r1)
            r10.finish()
            r10.overridePendingTransition(r9, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.activity.ChatMainActivity.R():boolean");
    }

    public final void S() {
        DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
        WakeDialogImpl wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
        if (wakeDialogImpl == null || !wakeDialogImpl.isShowing()) {
            return;
        }
        WakeService.Companion.a0(WakeService.INSTANCE, this, false, 2, null);
    }

    public final void T() {
        String str = this.pendingUnlockSessionId;
        if (str == null) {
            return;
        }
        Object systemService = getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            this.pendingUnlockSessionId = null;
            x0();
            if (isFinishing() || isDestroyed()) {
                return;
            }
            C4148a.k(TAG, "flushPendingUnlockSession: keyguard cleared, applying deferred session switch", false, 4, null);
            J(str);
        }
    }

    public final boolean U() {
        Intent intent = getIntent();
        return intent != null && intent.getBooleanExtra(EXTRA_SEAMLESS_LOCK_HANDOFF, false);
    }

    public final void V(Intent intent) {
        C2670c c2670c = this.host;
        if (c2670c == null) {
            return;
        }
        C5006a c5006a = C5006a.INSTANCE;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c5006a.b(this, intent, c2670c.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(android.content.Intent r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto Ld
            java.lang.String r1 = "chat_new_chat"
            boolean r1 = r8.getBooleanExtra(r1, r0)
            r2 = 1
            if (r1 != r2) goto Ld
            goto Le
        Ld:
            r2 = r0
        Le:
            r1 = 0
            if (r8 == 0) goto L19
            java.lang.String r3 = "wake_external_agent_type"
            java.lang.String r3 = r8.getStringExtra(r3)
            goto L1a
        L19:
            r3 = r1
        L1a:
            if (r8 == 0) goto L24
            java.lang.String r4 = "wake_external_device_id"
            java.lang.String r8 = r8.getStringExtra(r4)
            goto L25
        L24:
            r8 = r1
        L25:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleNewChatIntentIfAny: flag="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " agentType="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r5 = " deviceId="
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            r5 = 4
            java.lang.String r6 = "ChatMainActivity"
            h8.C4148a.k(r6, r4, r0, r5, r1)
            if (r2 != 0) goto L4f
            return
        L4f:
            com.stepos.ailauncher.chat.manager.AgentConfig$a r0 = com.stepos.ailauncher.chat.manager.AgentConfig.INSTANCE
            com.stepos.ailauncher.chat.manager.AgentConfig r0 = r0.a()
            r0.v()
            com.stepos.ailauncher.chat.lockscreen.c r0 = r7.host
            if (r0 != 0) goto L62
            java.lang.String r0 = "host"
            kotlin.jvm.internal.p.A(r0)
            goto L63
        L62:
            r1 = r0
        L63:
            com.stepos.ailauncher.chat.view.y r0 = r1.d()
            com.stepos.ailauncher.chat.activity.y0 r1 = new com.stepos.ailauncher.chat.activity.y0
            r1.<init>()
            r0.post(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.activity.ChatMainActivity.W(android.content.Intent):void");
    }

    public final void Z() {
        String stringExtra;
        AgentConfig.Companion companion = AgentConfig.INSTANCE;
        SessionHandler sessionHandlerJ = AgentConfig.j(companion.a(), false, null, 3, null);
        if (sessionHandlerJ != null) {
            companion.a().x(sessionHandlerJ);
        }
        C2670c c2670c = new C2670c(this, new C2670c.Config(this.isLockedFullChat, "chat_main_activity_float_card", Z8.Y.j(FloatCardScene.Any, FloatCardScene.Chat, FloatCardScene.ChatMainActivity), new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.B0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatMainActivity.a0(this.f24704a);
            }
        }));
        this.host = c2670c;
        c2670c.f();
        Q();
        if (d0(getIntent())) {
            C2670c c2670c2 = this.host;
            if (c2670c2 == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c2 = null;
            }
            ChatView chatView = (ChatView) c2670c2.d().findViewById(R$id.agentChatView);
            if (chatView != null) {
                chatView.M2();
            }
        }
        C4148a.k("OpenTrace", "ChatMainActivity.setContentView t=" + SystemClock.elapsedRealtime(), false, 4, null);
        C2670c c2670c3 = this.host;
        if (c2670c3 == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c3 = null;
        }
        c2670c3.m(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.activity.C0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatMainActivity.b0(this.f24707a);
            }
        });
        S();
        V(getIntent());
        l0();
        Intent intent = getIntent();
        kotlin.jvm.internal.p.h(intent, "getIntent(...)");
        if (o0(intent)) {
            q0("coldStart");
        }
        Intent intent2 = getIntent();
        if (intent2 == null || (stringExtra = intent2.getStringExtra(EXTRA_CHAT_SESSION_ID)) == null) {
            return;
        }
        String str = stringExtra.length() > 0 ? stringExtra : null;
        if (str != null) {
            L(str);
        }
    }

    /* renamed from: c0, reason: from getter */
    public final boolean getIsLockedFullChat() {
        return this.isLockedFullChat;
    }

    public final boolean d0(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra(WakeDialogImpl.EXTRA_REBIND_SESSION, false) || intent.getBooleanExtra(EXTRA_SEAMLESS_LOCK_HANDOFF, false);
    }

    public final void e0() {
        C2670c c2670c = this.host;
        C2670c c2670c2 = null;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        View viewFindViewById = c2670c.d().findViewById(R$id.title_dropdown_area);
        if (viewFindViewById == null || viewFindViewById.getVisibility() != 0) {
            return;
        }
        C2670c c2670c3 = this.host;
        if (c2670c3 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c2 = c2670c3;
        }
        TextView textView = (TextView) c2670c2.d().findViewById(R$id.tv_subtitle);
        if (textView != null) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.dot_status_offline_chat, 0, 0, 0);
            textView.setCompoundDrawablePadding((int) (4 * textView.getResources().getDisplayMetrics().density));
            textView.setText(getString(R$string.chat_external_agent_subtitle_offline));
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (U()) {
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransition(0, R$anim.chat_fade_out);
        }
    }

    public final void g0() {
        Object objB;
        if (this.unlockSessionReceiver != null) {
            return;
        }
        f fVar = new f();
        this.unlockSessionReceiver = fVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(registerReceiver(fVar, new IntentFilter("android.intent.action.USER_PRESENT")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "register USER_PRESENT receiver failed", thE, false, 8, null);
            this.unlockSessionReceiver = null;
        }
    }

    public final void h0() {
        final LockScreenChatAction lockScreenChatActionE = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.e();
        if (lockScreenChatActionE == null) {
            return;
        }
        C2670c c2670c = null;
        if (this.host == null) {
            C4148a.u(TAG, "replayPendingLockScreenAction: host not initialized, action=" + lockScreenChatActionE, false, 4, null);
            return;
        }
        C4148a.k(TAG, "replayPendingLockScreenAction: action=" + lockScreenChatActionE, false, 4, null);
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        c2670c.d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.w0
            @Override // java.lang.Runnable
            public final void run() {
                ChatMainActivity.i0(this.f24889a, lockScreenChatActionE);
            }
        });
    }

    public final void j0(InterfaceC5074l<? super Boolean, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(onResult, "onResult");
        if (!this.isLockedFullChat) {
            onResult.invoke(Boolean.TRUE);
            return;
        }
        Object systemService = getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
            C4148a.k(TAG, "requestUnlockForLockedAction: requestDismissKeyguard", false, 4, null);
            keyguardManager.requestDismissKeyguard(this, new g(onResult));
        } else {
            c cVar = this.lockFlagsController;
            if (cVar != null) {
                cVar.b();
            }
            onResult.invoke(Boolean.TRUE);
        }
    }

    public final void k0() {
        C2670c c2670c = null;
        this.lastExternalSessionArgs = null;
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        C2996w.h(c2670c.d());
    }

    public final void l0() {
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra(EXTRA_RESTORE_LOCK_CHAT, false)) {
            return;
        }
        C2670c c2670c = this.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.v0
            @Override // java.lang.Runnable
            public final void run() {
                ChatMainActivity.m0(this.f24886a);
            }
        });
    }

    public final boolean n0(Intent incoming, String from) {
        C2682o c2682o = C2682o.INSTANCE;
        boolean zC = c2682o.c(incoming);
        if (!zC) {
            c2682o.h(incoming);
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("sanitizeIncomingIntent(%s): internal=%s", Arrays.copyOf(new Object[]{from, Boolean.valueOf(zC)}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
        return zC;
    }

    public final boolean o0(Intent intent) {
        String stringExtra;
        if (intent.getBooleanExtra("extra_force_new_session", false)) {
            C4148a.k(TAG, "shouldForceNewSession: hit via EXTRA_FORCE_NEW_SESSION", false, 4, null);
            return true;
        }
        if (intent.getBooleanExtra(EXTRA_SEAMLESS_LOCK_HANDOFF, false) || intent.getBooleanExtra(WakeDialogImpl.EXTRA_REBIND_SESSION, false) || intent.getBooleanExtra(EXTRA_RESTORE_LOCK_CHAT, false) || intent.getBooleanExtra(EXTRA_NEW_CHAT, false) || (!((stringExtra = intent.getStringExtra(EXTRA_CHAT_SESSION_ID)) == null || stringExtra.length() == 0) || kotlin.jvm.internal.p.d(intent.getAction(), AppAutherRedirectActivity.ACTION_OPEN_CHAT))) {
            C4148a.d(TAG, "shouldForceNewSession: excluded by continue-session/app-internal semantics", false, 4, null);
            return false;
        }
        Object systemService = getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        boolean z10 = keyguardManager != null && keyguardManager.isKeyguardLocked();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("shouldForceNewSession: keyguardLocked=%s -> %s", Arrays.copyOf(new Object[]{Boolean.valueOf(z10), Boolean.valueOf(z10)}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
        return z10;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        C4148a.k("OpenTrace", "ChatMainActivity.onCreate t=" + SystemClock.elapsedRealtime(), false, 4, null);
        setRequestedOrientation(1);
        setTheme(R$style.ChatMainActivityTheme);
        super.onCreate(savedInstanceState);
        try {
            Result.Companion companion = Result.INSTANCE;
            setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        boolean zN0 = n0(getIntent(), "onCreate");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        Intent intent = getIntent();
        Boolean boolValueOf = Boolean.valueOf(intent != null && intent.getBooleanExtra(WakeDialogImpl.EXTRA_REBIND_SESSION, false));
        Intent intent2 = getIntent();
        String str = String.format("onCreate: rebind=%s seamless=%s savedInstanceState=%s taskId=%d", Arrays.copyOf(new Object[]{boolValueOf, Boolean.valueOf(intent2 != null && intent2.getBooleanExtra(EXTRA_SEAMLESS_LOCK_HANDOFF, false)), Boolean.valueOf(savedInstanceState != null), Integer.valueOf(getTaskId())}, 4));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
        com.stepos.ailauncher.chat.lockscreen.C c10 = com.stepos.ailauncher.chat.lockscreen.C.INSTANCE;
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        int i10 = d.$EnumSwitchMapping$0[c10.j(applicationContext, getIntent(), zN0).ordinal()];
        if (i10 == 1) {
            if (R()) {
                return;
            }
            C4148a.k(TAG, "onCreate: redirect to lock screen sheet", false, 4, null);
            Context applicationContext2 = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext2, "getApplicationContext(...)");
            Intent intent3 = getIntent();
            C2739j.r(applicationContext2, null, intent3 != null ? intent3.getStringExtra(EXTRA_CHAT_SESSION_ID) : null, SheetHeightMode.FULL_9, false, false, 50, null);
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        if (i10 == 2) {
            C4148a.k(TAG, "onCreate: locked full chat (dynamic setShowWhenLocked)", false, 4, null);
            this.isLockedFullChat = true;
            c cVar = new c();
            cVar.a();
            this.lockFlagsController = cVar;
        } else if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (U()) {
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransition(R$anim.chat_fade_in, 0);
        }
        Z();
        if (d0(getIntent())) {
            C4148a.k(TAG, "onCreate: REBIND/seamless -> applySeamlessLockScreenHandoff", false, 4, null);
            Intent intent4 = getIntent();
            kotlin.jvm.internal.p.h(intent4, "getIntent(...)");
            O(intent4);
        }
        N(getIntent());
        W(getIntent());
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(this.accountCallback);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        com.stepos.ailauncher.common.memory.e.INSTANCE.o(this.heapPageTrimListener);
        com.stepos.ailauncher.foundation.account.f.INSTANCE.C(this.accountCallback);
        c cVar = this.lockFlagsController;
        if (cVar != null) {
            cVar.b();
        }
        C2670c c2670c = null;
        this.lockFlagsController = null;
        this.pendingUnlockSessionId = null;
        x0();
        com.stepos.ailauncher.chat.lockscreen.x.INSTANCE.d();
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            super.onDestroy();
            return;
        }
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        c2670c.g(isChangingConfigurations());
        super.onDestroy();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        setIntent(intent);
        boolean zN0 = n0(intent, "onNewIntent");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onNewIntent: rebind=%s seamless=%s newChat=%s restoreLock=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(intent.getBooleanExtra(WakeDialogImpl.EXTRA_REBIND_SESSION, false)), Boolean.valueOf(intent.getBooleanExtra(EXTRA_SEAMLESS_LOCK_HANDOFF, false)), Boolean.valueOf(intent.getBooleanExtra(EXTRA_NEW_CHAT, false)), Boolean.valueOf(intent.getBooleanExtra(EXTRA_RESTORE_LOCK_CHAT, false))}, 4));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.k(TAG, str, false, 4, null);
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context applicationContext = getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        ChatMainLockRoute chatMainLockRouteQ = xVar.q(applicationContext, intent, zN0);
        if (chatMainLockRouteQ == ChatMainLockRoute.REDIRECT_TO_LOCK_SCREEN_CHAT && R()) {
            return;
        }
        if (o0(intent)) {
            q0("onNewIntent");
        }
        int i10 = d.$EnumSwitchMapping$0[chatMainLockRouteQ.ordinal()];
        if (i10 == 1) {
            C4148a.k(TAG, "onNewIntent: redirect to lock screen sheet", false, 4, null);
            Context applicationContext2 = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext2, "getApplicationContext(...)");
            C2739j.r(applicationContext2, null, intent.getStringExtra(EXTRA_CHAT_SESSION_ID), SheetHeightMode.FULL_9, false, false, 50, null);
            finish();
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (this.lockFlagsController == null) {
            C4148a.k(TAG, "onNewIntent: LOCKED_FULL_CHAT, applying lock flags", false, 4, null);
            this.isLockedFullChat = true;
            c cVar = new c();
            cVar.a();
            this.lockFlagsController = cVar;
            C2670c c2670c = this.host;
            if (c2670c != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (c2670c == null) {
                        kotlin.jvm.internal.p.A("host");
                        c2670c = null;
                    }
                    c2670c.d().setLockScreenMode(true);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
        if (intent.getBooleanExtra(EXTRA_SEAMLESS_LOCK_HANDOFF, false)) {
            O(intent);
            overridePendingTransition(0, 0);
            return;
        }
        super.onNewIntent(intent);
        S();
        if (intent.getBooleanExtra(WakeDialogImpl.EXTRA_REBIND_SESSION, false)) {
            C4148a.k(TAG, "onNewIntent: REBIND -> seamless rebind (no recreate)", false, 4, null);
            O(intent);
            return;
        }
        if (intent.getBooleanExtra(EXTRA_NEW_CHAT, false)) {
            W(intent);
            N(intent);
            return;
        }
        String stringExtra = intent.getStringExtra(EXTRA_CHAT_SESSION_ID);
        if (stringExtra != null && stringExtra.length() != 0) {
            L(stringExtra);
        } else {
            V(intent);
            N(intent);
        }
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        super.onPause();
        C2670c c2670c = this.host;
        if (c2670c == null) {
            return;
        }
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.h();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.host == null) {
            return;
        }
        this.foregroundAt = SystemClock.elapsedRealtime();
        C2670c c2670c = null;
        C4148a.k("OpenTrace", "ChatMainActivity.onResume t=" + SystemClock.elapsedRealtime(), false, 4, null);
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        c2670c.i();
        Q();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStart() {
        super.onStart();
        com.stepos.ailauncher.common.memory.e.INSTANCE.c(this.heapPageTrimListener);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        super.onStop();
        C2670c c2670c = this.host;
        if (c2670c == null) {
            return;
        }
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.j();
        if (isChangingConfigurations()) {
            return;
        }
        r0(20);
        com.stepos.ailauncher.common.memory.e.INSTANCE.q(this, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.t0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatMainActivity.f0(this.f24876a, ((Integer) obj).intValue());
            }
        });
    }

    @Override // b.q, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        int iF;
        super.onTrimMemory(level);
        if (this.host != null && (iF = com.stepos.ailauncher.common.memory.e.f(com.stepos.ailauncher.common.memory.e.INSTANCE, level, null, 2, null)) >= 20) {
            r0(iF);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            T();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p0() {
        C2670c c2670c = this.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        TextView textView = (TextView) c2670c.d().findViewById(R$id.tv_subtitle);
        if (textView == null) {
            return;
        }
        Drawable drawableE = androidx.core.content.a.e(this, R$drawable.ic_chat_status_connecting);
        int i10 = (int) (12 * getResources().getDisplayMetrics().density);
        if (drawableE != 0) {
            drawableE.setBounds(0, 0, i10, i10);
        }
        textView.setCompoundDrawablesRelative(drawableE, null, null, null);
        textView.setCompoundDrawablePadding((int) (4 * getResources().getDisplayMetrics().density));
        textView.setText(getString(R$string.chat_external_agent_subtitle_connecting));
        Animatable animatable = drawableE instanceof Animatable ? (Animatable) drawableE : null;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void q0(String source) {
        if (this.host == null) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("force-new-chat(%s): host not initialized yet, skip", Arrays.copyOf(new Object[]{source}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.u(TAG, str, false, 4, null);
            return;
        }
        kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
        String str2 = String.format("force-new-chat(%s): startFreshSession", Arrays.copyOf(new Object[]{source}, 1));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.k(TAG, str2, false, 4, null);
        C2670c c2670c = this.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        C2670c.o(c2670c, false, 1, null);
    }

    public final void r0(int level) {
        Object objB;
        C2670c c2670c = this.host;
        if (c2670c == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            c2670c.d().onTrimMemory(level);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "onTrimMemory failed level=" + level, thE, false, 8, null);
        }
    }

    public final void s0(final String sessionId, final int attempt) {
        C2670c c2670c = this.host;
        if (c2670c == null) {
            return;
        }
        C2670c c2670c2 = null;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        final ChatView chatView = (ChatView) c2670c.d().findViewById(R$id.agentChatView);
        if (chatView == null) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("trySwitchToSession: ChatView not found for sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.u(TAG, str, false, 4, null);
            return;
        }
        if (chatView.getInputView().X7()) {
            chatView.J1(sessionId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.E0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatMainActivity.u0(this.f24716a, attempt, sessionId, chatView, ((Boolean) obj).booleanValue());
                }
            });
            return;
        }
        if (attempt >= 10) {
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
            String str2 = String.format("trySwitchToSession: inputView not ready, give up sessionId=%s", Arrays.copyOf(new Object[]{sessionId}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.u(TAG, str2, false, 4, null);
            return;
        }
        C2670c c2670c3 = this.host;
        if (c2670c3 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c2 = c2670c3;
        }
        c2670c2.d().postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.D0
            @Override // java.lang.Runnable
            public final void run() {
                ChatMainActivity.t0(this.f24711a, sessionId, attempt);
            }
        }, 200L);
    }

    public final void x0() {
        Object objB;
        BroadcastReceiver broadcastReceiver = this.unlockSessionReceiver;
        if (broadcastReceiver != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                unregisterReceiver(broadcastReceiver);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result.a(objB);
        }
        this.unlockSessionReceiver = null;
    }
}
