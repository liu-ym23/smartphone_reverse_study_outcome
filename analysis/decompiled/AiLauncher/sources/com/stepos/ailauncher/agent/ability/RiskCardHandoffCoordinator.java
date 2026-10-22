package com.stepos.ailauncher.agent.ability;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.risk.RiskInlineHostPolicy;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.common.utils.E;
import com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService;
import com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementButton;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementParams;
import com.stepos.ailauncher.mcpservice.risk.UnlockSceneResult;
import com.stepos.ailauncher.mcpservice.risk.q;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002UVB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0003J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b)\u0010!J\u0017\u0010*\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b*\u0010!J\u0017\u0010+\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b+\u0010!J\u0017\u0010,\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010!J\u0017\u0010-\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b-\u0010!J\u0017\u0010/\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b3\u0010(J\u001f\u00105\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b7\u0010(J\u0017\u00108\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b8\u0010(J\u0017\u00109\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b9\u0010!J+\u0010<\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000eH\u0002¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010;\u001a\u00020\u000eH\u0002¢\u0006\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u00101R\u0014\u0010E\u001a\u00020D8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010)R\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR \u0010J\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001e0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "", "sessionId", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "LY8/t;", "onResult", "", ExifInterface.LONGITUDE_EAST, "(Landroid/content/Context;Lcom/stepos/ailauncher/mcpservice/risk/p;Ljava/lang/String;Lp9/l;)Z", "reason", "p", "(Ljava/lang/String;Ljava/lang/String;)V", "G", "incomingRequestId", "U", "requestId", "result", "u", "(Ljava/lang/String;Lcom/stepos/ailauncher/mcpservice/risk/q;)V", "t", ExifInterface.GPS_DIRECTION_TRUE, "y", "Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;", "active", "z", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;)V", "M", "(Ljava/lang/String;)Z", ExifInterface.LATITUDE_SOUTH, "o", "()Z", "x", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;)Z", "I", "L", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "K", "Lcom/stepos/ailauncher/chat/risk/RiskInlineHostPolicy$RetryTick;", "w", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;)Lcom/stepos/ailauncher/chat/risk/RiskInlineHostPolicy$RetryTick;", "J", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;)Ljava/lang/String;", "N", "buttonId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;Ljava/lang/String;)V", "Q", "H", "R", "forHandoff", "skipAfterglow", "r", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;ZZ)V", "X", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;Z)V", "TAG", "Ljava/lang/String;", "", "INLINE_RETRY_DELAY_MS", "", "INLINE_RETRY_MAX", "LUa/M;", "scope", "LUa/M;", "Ljava/util/concurrent/ConcurrentHashMap;", "actives", "Ljava/util/concurrent/ConcurrentHashMap;", "Lx4/e;", "conversationTitles$delegate", "LY8/h;", "v", "()Lx4/e;", "conversationTitles", "Lkotlinx/coroutines/g;", "foregroundJob", "Lkotlinx/coroutines/g;", "Mode", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RiskCardHandoffCoordinator {
    private static final long INLINE_RETRY_DELAY_MS = 250;
    private static final int INLINE_RETRY_MAX = 8;
    private static final String TAG = "RiskCardHandoff";
    private static volatile kotlinx.coroutines.g foregroundJob;
    public static final RiskCardHandoffCoordinator INSTANCE = new RiskCardHandoffCoordinator();
    private static final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
    private static final ConcurrentHashMap<String, a> actives = new ConcurrentHashMap<>();

    /* renamed from: conversationTitles$delegate, reason: from kotlin metadata */
    private static final Y8.h conversationTitles = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.ability.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return RiskCardHandoffCoordinator.q();
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "INLINE", "LIVE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode INLINE = new Mode("INLINE", 0);
        public static final Mode LIVE = new Mode("LIVE", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{INLINE, LIVE};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = kotlin.enums.a.a(modeArr$values);
        }

        private Mode(String str, int i10) {
        }

        public static InterfaceC4149a<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010+\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R\"\u0010:\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010+\u001a\u0004\b;\u0010-\"\u0004\b<\u0010/¨\u0006="}, d2 = {"Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$a;", "", "Landroid/content/Context;", "appContext", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "", "sessionId", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "LY8/t;", "onResult", "Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$Mode;", "mode", "<init>", "(Landroid/content/Context;Lcom/stepos/ailauncher/mcpservice/risk/p;Ljava/lang/String;Lp9/l;Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$Mode;)V", "Landroid/content/Context;", Const.INTENT_KEY_APIKEY, "()Landroid/content/Context;", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "f", "()Lcom/stepos/ailauncher/mcpservice/risk/p;", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "Lp9/l;", "e", "()Lp9/l;", "Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$Mode;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$Mode;", "m", "(Lcom/stepos/ailauncher/agent/ability/RiskCardHandoffCoordinator$Mode;)V", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "inputViewRef", "Ljava/lang/ref/WeakReference;", "c", "()Ljava/lang/ref/WeakReference;", "l", "(Ljava/lang/ref/WeakReference;)V", "", "suppressInlineCancel", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "o", "(Z)V", "", "inlineRetry", "I", Const.INTENT_KEY_PKGNAME, "()I", "k", "(I)V", "unlockPending", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "p", "skipAfterglowOnFinish", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final Context appContext;
        private int inlineRetry;
        private WeakReference<BaseInputView> inputViewRef;
        private Mode mode;
        private final InterfaceC5074l<com.stepos.ailauncher.mcpservice.risk.q, Y8.t> onResult;
        private final RiskStatementParams params;
        private final String sessionId;
        private boolean skipAfterglowOnFinish;
        private boolean suppressInlineCancel;
        private boolean unlockPending;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Context appContext, RiskStatementParams params, String sessionId, InterfaceC5074l<? super com.stepos.ailauncher.mcpservice.risk.q, Y8.t> onResult, Mode mode) {
            kotlin.jvm.internal.p.i(appContext, "appContext");
            kotlin.jvm.internal.p.i(params, "params");
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(onResult, "onResult");
            kotlin.jvm.internal.p.i(mode, "mode");
            this.appContext = appContext;
            this.params = params;
            this.sessionId = sessionId;
            this.onResult = onResult;
            this.mode = mode;
        }

        /* renamed from: a, reason: from getter */
        public final Context getAppContext() {
            return this.appContext;
        }

        /* renamed from: b, reason: from getter */
        public final int getInlineRetry() {
            return this.inlineRetry;
        }

        public final WeakReference<BaseInputView> c() {
            return this.inputViewRef;
        }

        /* renamed from: d, reason: from getter */
        public final Mode getMode() {
            return this.mode;
        }

        public final InterfaceC5074l<com.stepos.ailauncher.mcpservice.risk.q, Y8.t> e() {
            return this.onResult;
        }

        /* renamed from: f, reason: from getter */
        public final RiskStatementParams getParams() {
            return this.params;
        }

        /* renamed from: g, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getSkipAfterglowOnFinish() {
            return this.skipAfterglowOnFinish;
        }

        /* renamed from: i, reason: from getter */
        public final boolean getSuppressInlineCancel() {
            return this.suppressInlineCancel;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getUnlockPending() {
            return this.unlockPending;
        }

        public final void k(int i10) {
            this.inlineRetry = i10;
        }

        public final void l(WeakReference<BaseInputView> weakReference) {
            this.inputViewRef = weakReference;
        }

        public final void m(Mode mode) {
            kotlin.jvm.internal.p.i(mode, "<set-?>");
            this.mode = mode;
        }

        public final void n(boolean z10) {
            this.skipAfterglowOnFinish = z10;
        }

        public final void o(boolean z10) {
            this.suppressInlineCancel = z10;
        }

        public final void p(boolean z10) {
            this.unlockPending = z10;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RiskInlineHostPolicy.RetryTick.values().length];
            try {
                iArr[RiskInlineHostPolicy.RetryTick.SwitchToInline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RiskInlineHostPolicy.RetryTick.KeepRetrying.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RiskInlineHostPolicy.RetryTick.Stop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Mode.values().length];
            try {
                iArr2[Mode.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Mode.LIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final Y8.t B(a aVar, UnlockSceneResult unlockResult) {
        kotlin.jvm.internal.p.i(unlockResult, "unlockResult");
        aVar.p(false);
        com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(aVar.getParams().getRequestId(), new q.Unlock(unlockResult));
        return Y8.t.f7040a;
    }

    public static final Y8.t C(a aVar) {
        if (aVar.getUnlockPending()) {
            C4148a.k(TAG, "dismiss inline + yield hosts after unlock activity started | req=" + aVar.getParams().getRequestId(), false, 4, null);
            INSTANCE.R(aVar);
            E.INSTANCE.m();
        }
        return Y8.t.f7040a;
    }

    public static final void D(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final Y8.t F(String str, com.stepos.ailauncher.mcpservice.risk.q result) {
        kotlin.jvm.internal.p.i(result, "result");
        INSTANCE.u(str, result);
        return Y8.t.f7040a;
    }

    public static final Y8.t O(RiskStatementParams riskStatementParams, RiskCardHandoffCoordinator riskCardHandoffCoordinator, a aVar, String str, String buttonId) {
        kotlin.jvm.internal.p.i(buttonId, "buttonId");
        if (riskStatementParams.i()) {
            riskCardHandoffCoordinator.A(aVar, buttonId);
        } else {
            com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(str, new q.Chosen(buttonId));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t P(a aVar, String str) {
        if (aVar.getSuppressInlineCancel()) {
            aVar.o(false);
        } else if (aVar.getUnlockPending()) {
            C4148a.u(TAG, "inline cancel ignored during unlock | req=" + str, false, 4, null);
        } else {
            com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(str, q.a.INSTANCE);
        }
        return Y8.t.f7040a;
    }

    public static final x4.d q() {
        return new x4.d();
    }

    public static /* synthetic */ void s(RiskCardHandoffCoordinator riskCardHandoffCoordinator, a aVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        riskCardHandoffCoordinator.r(aVar, z10, z11);
    }

    public final void A(final a active, String buttonId) {
        boolean zG = com.stepos.ailauncher.mcpservice.risk.a.INSTANCE.g(active.getAppContext());
        com.stepos.ailauncher.mcpservice.risk.s sVar = com.stepos.ailauncher.mcpservice.risk.s.INSTANCE;
        q.Unlock unlockB = sVar.b(active.getParams(), buttonId, zG);
        if (unlockB != null) {
            com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(active.getParams().getRequestId(), unlockB);
            return;
        }
        active.p(true);
        active.o(true);
        sVar.c(active.getAppContext(), active.getParams().getRequestId(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.ability.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RiskCardHandoffCoordinator.B(active, (UnlockSceneResult) obj);
            }
        });
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.ability.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return RiskCardHandoffCoordinator.C(active);
            }
        };
        WeakReference<BaseInputView> weakReferenceC = active.c();
        BaseInputView baseInputView = weakReferenceC != null ? weakReferenceC.get() : null;
        if (baseInputView != null) {
            baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.agent.ability.g
                @Override // java.lang.Runnable
                public final void run() {
                    RiskCardHandoffCoordinator.D(interfaceC5063a);
                }
            });
        } else {
            interfaceC5063a.invoke();
        }
    }

    public final boolean E(Context context, RiskStatementParams params, String sessionId, InterfaceC5074l<? super com.stepos.ailauncher.mcpservice.risk.q, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        final String requestId = params.getRequestId();
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        if (!kotlin.jvm.internal.p.d(strM, sessionId)) {
            C4148a.k(TAG, "present: remap session " + sessionId + " → " + strM + " | req=" + requestId, false, 4, null);
        }
        U(strM, requestId);
        boolean zI = params.i();
        boolean zO = zI ? o() : M(strM);
        if (zI && !zO) {
            C4148a.k(TAG, "present: unlock scene no chat host, give back | req=" + requestId, false, 4, null);
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        a aVar = new a(applicationContext, params, strM, onResult, zO ? Mode.INLINE : Mode.LIVE);
        ConcurrentHashMap<String, a> concurrentHashMap = actives;
        concurrentHashMap.put(requestId, aVar);
        com.stepos.ailauncher.mcpservice.risk.f fVar = com.stepos.ailauncher.mcpservice.risk.f.INSTANCE;
        fVar.g(requestId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.ability.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return RiskCardHandoffCoordinator.F(requestId, (com.stepos.ailauncher.mcpservice.risk.q) obj);
            }
        });
        Mode mode = aVar.getMode();
        Mode mode2 = Mode.INLINE;
        boolean zN = mode == mode2 ? N(aVar) : Q(aVar);
        if (!zN && !zI) {
            aVar.m(aVar.getMode() == mode2 ? Mode.LIVE : mode2);
            zN = aVar.getMode() == mode2 ? N(aVar) : Q(aVar);
        }
        if (!zN) {
            fVar.l(requestId);
            concurrentHashMap.remove(requestId);
            C4148a.k(TAG, "present: neither inline nor live shown, give back to caller | req=" + requestId, false, 4, null);
            return false;
        }
        t();
        if (!zI) {
            if (RiskInlineHostPolicy.INSTANCE.b(aVar.getMode() == Mode.LIVE, com.stepos.ailauncher.common.utils.v.INSTANCE.j())) {
                C4148a.k(TAG, "present: live while conversation body, retry inline | req=" + requestId, false, 4, null);
                K(aVar);
            }
        }
        C4148a.k(TAG, "present: took over | req=" + requestId + " session=" + strM + " initialInline=" + zO + " mode=" + aVar.getMode(), false, 4, null);
        return true;
    }

    public final void G() {
        y();
    }

    public final boolean H(a active) {
        Object objB;
        IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
        if (iRiskLiveNotificationService == null) {
            C4148a.k(TAG, "registerLive skip: no IRiskLiveNotificationService | req=" + active.getParams().getRequestId(), false, 4, null);
            return false;
        }
        RiskStatementParams params = active.getParams();
        try {
            Result.Companion companion = Result.INSTANCE;
            String sessionId = active.getSessionId();
            String requestId = params.getRequestId();
            String title = params.getTitle();
            String body = params.getBody();
            String riskLevel = params.getRiskLevel();
            List<RiskStatementButton> listB = params.b();
            ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
            for (RiskStatementButton riskStatementButton : listB) {
                arrayList.add(new RiskLiveButton(riskStatementButton.getId(), riskStatementButton.getText(), riskStatementButton.getStyle().name()));
            }
            Long timeoutMs = params.getTimeoutMs();
            objB = Result.b(Boolean.valueOf(iRiskLiveNotificationService.showSessionRiskCard(sessionId, requestId, title, body, riskLevel, arrayList, timeoutMs != null ? timeoutMs.longValue() : 0L)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "registerLive error | req=" + params.getRequestId(), thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void I(a active) {
        BaseInputView baseInputViewS0 = InputViewManager.INSTANCE.s0(active.getSessionId());
        WeakReference<BaseInputView> weakReferenceC = active.c();
        BaseInputView baseInputView = weakReferenceC != null ? weakReferenceC.get() : null;
        if (baseInputViewS0 != null && baseInputView == baseInputViewS0 && kotlin.jvm.internal.p.d(baseInputView.W5(), active.getParams().getRequestId()) && baseInputView.U6()) {
            active.k(0);
            return;
        }
        if (baseInputView != null && baseInputView != baseInputViewS0) {
            R(active);
        }
        if (!N(active)) {
            L(active);
            return;
        }
        active.k(0);
        C4148a.k(TAG, "rehost inline | req=" + active.getParams().getRequestId() + " session=" + active.getSessionId(), false, 4, null);
    }

    public final String J(a active) {
        Object objB;
        String str = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            w4.e eVarG = v().g(active.getSessionId());
            objB = Result.b(eVarG != null ? eVarG.getTitle() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str2 = (String) objB;
        if (str2 != null && !H.x0(str2)) {
            str = str2;
        }
        return str == null ? active.getParams().getTitle() : str;
    }

    public final void K(a active) {
        RiskInlineHostPolicy.RetryTick retryTickW = w(active);
        if (active.getInlineRetry() < 8) {
            active.k(active.getInlineRetry() + 1);
            C1060i.d(scope, null, null, new RiskCardHandoffCoordinator$scheduleInlineRetry$2(active, null), 3, null);
            return;
        }
        active.k(0);
        int i10 = b.$EnumSwitchMapping$0[retryTickW.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            C4148a.u(TAG, "handoff live->inline give up after 8 retries | req=" + active.getParams().getRequestId(), false, 4, null);
            return;
        }
        C4148a.u(TAG, "handoff live->inline keep retrying | req=" + active.getParams().getRequestId() + " tick=" + retryTickW, false, 4, null);
        C1060i.d(scope, null, null, new RiskCardHandoffCoordinator$scheduleInlineRetry$1(active, null), 3, null);
    }

    public final void L(a active) {
        if (active.getInlineRetry() < 8) {
            active.k(active.getInlineRetry() + 1);
            C1060i.d(scope, null, null, new RiskCardHandoffCoordinator$scheduleRehostRetry$2(active, null), 3, null);
            return;
        }
        active.k(0);
        if (active.getMode() == Mode.INLINE && M(active.getSessionId())) {
            C1060i.d(scope, null, null, new RiskCardHandoffCoordinator$scheduleRehostRetry$1(active, null), 3, null);
        }
    }

    public final boolean M(String sessionId) {
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        RiskInlineHostPolicy riskInlineHostPolicy = RiskInlineHostPolicy.INSTANCE;
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        boolean z10 = true;
        boolean z11 = vVar.m(sessionId) || vVar.m(strM);
        boolean z12 = vVar.t(sessionId) || vVar.t(strM);
        boolean zJ = vVar.j();
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        if (!inputViewManager.L0(sessionId) && !inputViewManager.L0(strM)) {
            z10 = false;
        }
        return riskInlineHostPolicy.c(z11, z12, zJ, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean N(final com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.a r14) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.N(com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a):boolean");
    }

    public final boolean Q(a active) {
        C4148a.k(TAG, "showLive | req=" + active.getParams().getRequestId() + " session=" + active.getSessionId(), false, 4, null);
        IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
        if (iRiskLiveNotificationService != null) {
            iRiskLiveNotificationService.setRiskIslandFallback(active.getParams().getRequestId(), true);
        }
        return H(active);
    }

    public final void R(a active) {
        Object objB;
        Y8.t tVar;
        BaseInputView baseInputView;
        active.o(true);
        try {
            Result.Companion companion = Result.INSTANCE;
            WeakReference<BaseInputView> weakReferenceC = active.c();
            if (weakReferenceC == null || (baseInputView = weakReferenceC.get()) == null) {
                tVar = null;
            } else {
                baseInputView.o6(active.getParams().getRequestId(), false, false);
                tVar = Y8.t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "silentDismissInline error | req=" + active.getParams().getRequestId(), thE, false, 8, null);
        }
        active.o(false);
        active.l(null);
    }

    public final boolean S(String sessionId) {
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        if (vVar.m(sessionId) || vVar.m(strM)) {
            return false;
        }
        if (vVar.t(sessionId) || vVar.t(strM)) {
            return true;
        }
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        return inputViewManager.L0(sessionId) || inputViewManager.L0(strM);
    }

    public final void T() {
        kotlinx.coroutines.g gVar = foregroundJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        foregroundJob = null;
        C4148a.d(TAG, "foreground observer stopped", false, 4, null);
    }

    public final void U(String sessionId, String incomingRequestId) {
        Collection<a> collectionValues = actives.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            a aVar = (a) obj;
            if (kotlin.jvm.internal.p.d(aVar.getSessionId(), sessionId) && !kotlin.jvm.internal.p.d(aVar.getParams().getRequestId(), incomingRequestId)) {
                arrayList.add(obj);
            }
        }
        for (Object obj2 : arrayList) {
            kotlin.jvm.internal.p.h(obj2, "next(...)");
            a aVar2 = (a) obj2;
            C4148a.u(TAG, "supersede: session=" + sessionId + " old req=" + aVar2.getParams().getRequestId() + " mode=" + aVar2.getMode() + " → cancelled by new req=" + incomingRequestId, false, 4, null);
            com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(aVar2.getParams().getRequestId(), q.a.INSTANCE);
        }
    }

    public final void V(a active) {
        active.m(Mode.INLINE);
        if (!N(active)) {
            active.m(Mode.LIVE);
            K(active);
            return;
        }
        active.k(0);
        s(this, active, true, false, 4, null);
        C4148a.k(TAG, "handoff live->inline | req=" + active.getParams().getRequestId() + " session=" + active.getSessionId(), false, 4, null);
    }

    public final void W(a active) {
        active.m(Mode.LIVE);
        if (!Q(active)) {
            active.m(Mode.INLINE);
            C4148a.u(TAG, "handoff inline->live failed to show live, cancel | req=" + active.getParams().getRequestId(), false, 4, null);
            R(active);
            com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d(active.getParams().getRequestId(), q.a.INSTANCE);
            return;
        }
        R(active);
        C4148a.k(TAG, "handoff inline->live | req=" + active.getParams().getRequestId() + " session=" + active.getSessionId(), false, 4, null);
    }

    public final void X(a active, boolean skipAfterglow) {
        int i10 = b.$EnumSwitchMapping$1[active.getMode().ordinal()];
        if (i10 == 1) {
            R(active);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            s(this, active, false, skipAfterglow, 2, null);
        }
    }

    public final boolean o() {
        return InputViewManager.INSTANCE.r0() != null;
    }

    public final void p(String sessionId, String reason) {
        List<String> listM;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (H.x0(sessionId)) {
            return;
        }
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        Set setJ = Z8.Y.j(sessionId, strM);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : setJ) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        Collection<a> collectionValues = actives.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues) {
            if (arrayList.contains(((a) obj2).getSessionId())) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((a) it.next()).getParams().getRequestId());
        }
        IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
        if (iRiskLiveNotificationService != null) {
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            listM = iRiskLiveNotificationService.pendingRiskRequestIds((String[]) Arrays.copyOf(strArr, strArr.length));
        } else {
            listM = null;
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        List listG0 = F.g0(F.S0(arrayList3, listM));
        if (listG0.isEmpty()) {
            C4148a.d(TAG, "cancelForSession no-op reason=" + reason + " session=" + sessionId, false, 4, null);
            return;
        }
        C4148a.k(TAG, "cancelForSession reason=" + reason + " session=" + sessionId + " visible=" + strM + " reqs=" + listG0, false, 4, null);
        Iterator it2 = listG0.iterator();
        while (it2.hasNext()) {
            a aVar = actives.get((String) it2.next());
            if (aVar != null) {
                aVar.n(true);
            }
        }
        for (String str : arrayList) {
            IRiskLiveNotificationService iRiskLiveNotificationService2 = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
            if (iRiskLiveNotificationService2 != null) {
                IRiskLiveNotificationService.dismissSessionRiskCard$default(iRiskLiveNotificationService2, str, false, null, true, 6, null);
            }
        }
        Iterator it3 = listG0.iterator();
        while (it3.hasNext()) {
            com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.d((String) it3.next(), q.a.INSTANCE);
        }
    }

    public final void r(a active, boolean forHandoff, boolean skipAfterglow) {
        Object objB;
        IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
        if (iRiskLiveNotificationService != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                iRiskLiveNotificationService.dismissSessionRiskCard(active.getSessionId(), forHandoff, active.getParams().getRequestId(), skipAfterglow);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "dismissLive error | session=" + active.getSessionId(), thE, false, 8, null);
            }
            Result.a(objB);
        }
    }

    public final void t() {
        kotlinx.coroutines.g gVar = foregroundJob;
        if (gVar == null || !gVar.b()) {
            foregroundJob = C1060i.d(scope, null, null, new RiskCardHandoffCoordinator$ensureForegroundObserver$1(null), 3, null);
            C4148a.d(TAG, "foreground observer started", false, 4, null);
        }
    }

    public final void u(String requestId, com.stepos.ailauncher.mcpservice.risk.q result) {
        IRiskLiveNotificationService iRiskLiveNotificationService;
        ConcurrentHashMap<String, a> concurrentHashMap = actives;
        a aVarRemove = concurrentHashMap.remove(requestId);
        if (aVarRemove == null) {
            return;
        }
        boolean z10 = true;
        if (!aVarRemove.getSkipAfterglowOnFinish() && (aVarRemove.getParams().i() || (iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class)) == null || !iRiskLiveNotificationService.sessionTasksAllTerminal(aVarRemove.getSessionId()))) {
            z10 = false;
        }
        X(aVarRemove, z10);
        com.stepos.ailauncher.mcpservice.risk.f.INSTANCE.l(requestId);
        if (concurrentHashMap.isEmpty()) {
            T();
        }
        C4148a.k(TAG, "finish | req=" + requestId + " result=" + result + " mode=" + aVarRemove.getMode() + " skipAfterglow=" + z10, false, 4, null);
        aVarRemove.e().invoke(result);
    }

    public final x4.e v() {
        return (x4.e) conversationTitles.getValue();
    }

    public final RiskInlineHostPolicy.RetryTick w(a active) {
        return RiskInlineHostPolicy.INSTANCE.a(active.getMode() == Mode.LIVE, M(active.getSessionId()), com.stepos.ailauncher.common.utils.v.INSTANCE.j());
    }

    public final boolean x(a active) {
        BaseInputView baseInputView;
        BaseInputView baseInputViewR0;
        WeakReference<BaseInputView> weakReferenceC = active.c();
        if (weakReferenceC == null || (baseInputView = weakReferenceC.get()) == null || !baseInputView.isAttachedToWindow() || !kotlin.jvm.internal.p.d(baseInputView.W5(), active.getParams().getRequestId()) || !baseInputView.U6() || (baseInputViewR0 = InputViewManager.INSTANCE.r0()) == null) {
            return false;
        }
        return baseInputViewR0 == baseInputView || kotlin.jvm.internal.p.d(baseInputViewR0.W5(), active.getParams().getRequestId());
    }

    public final void y() {
        ConcurrentHashMap<String, a> concurrentHashMap = actives;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        Collection<a> collectionValues = concurrentHashMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        for (Object obj : F.m1(collectionValues)) {
            kotlin.jvm.internal.p.h(obj, "next(...)");
            a aVar = (a) obj;
            if (aVar.getParams().i()) {
                z(aVar);
            } else {
                boolean zM = M(aVar.getSessionId());
                Mode mode = aVar.getMode();
                Mode mode2 = Mode.INLINE;
                if (zM != (mode == mode2)) {
                    C4148a.k(TAG, "fg mismatch | req=" + aVar.getParams().getRequestId() + " session=" + aVar.getSessionId() + " mode=" + aVar.getMode() + " shouldInline=" + zM, false, 4, null);
                } else {
                    C4148a.d(TAG, "fg | req=" + aVar.getParams().getRequestId() + " session=" + aVar.getSessionId() + " mode=" + aVar.getMode() + " shouldInline=" + zM, false, 4, null);
                }
                if (zM && aVar.getMode() == Mode.LIVE) {
                    V(aVar);
                } else if (zM && aVar.getMode() == mode2) {
                    I(aVar);
                } else if (!zM && aVar.getMode() == mode2) {
                    if (com.stepos.ailauncher.common.utils.v.INSTANCE.j() && x(aVar) && S(aVar.getSessionId())) {
                        C4148a.d(TAG, "keep inline, floating card still on screen | req=" + aVar.getParams().getRequestId(), false, 4, null);
                    } else {
                        W(aVar);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.a r8) {
        /*
            r7 = this;
            boolean r0 = r8.getUnlockPending()
            if (r0 == 0) goto L7
            goto L6a
        L7:
            boolean r0 = r7.o()
            java.lang.ref.WeakReference r1 = r8.c()
            r2 = 0
            if (r1 == 0) goto L19
            java.lang.Object r1 = r1.get()
            com.stepos.ailauncher.chat.view.BaseInputView r1 = (com.stepos.ailauncher.chat.view.BaseInputView) r1
            goto L1a
        L19:
            r1 = r2
        L1a:
            r3 = 0
            if (r1 == 0) goto L25
            boolean r1 = r1.isAttachedToWindow()
            r4 = 1
            if (r1 != r4) goto L25
            goto L26
        L25:
            r4 = r3
        L26:
            com.stepos.ailauncher.mcpservice.risk.p r1 = r8.getParams()
            java.lang.String r1 = r1.getRequestId()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "fg unlock | req="
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = " canInline="
            r5.append(r1)
            r5.append(r0)
            java.lang.String r1 = " attached="
            r5.append(r1)
            r5.append(r4)
            java.lang.String r1 = r5.toString()
            r5 = 4
            java.lang.String r6 = "RiskCardHandoff"
            h8.C4148a.d(r6, r1, r3, r5, r2)
            if (r0 == 0) goto L5d
            if (r4 != 0) goto L5d
            r7.N(r8)
            return
        L5d:
            if (r0 != 0) goto L6a
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$Mode r0 = r8.getMode()
            com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$Mode r1 = com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.Mode.INLINE
            if (r0 != r1) goto L6a
            r7.R(r8)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator.z(com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$a):void");
    }
}
