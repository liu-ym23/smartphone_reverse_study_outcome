package com.stepos.ailauncher.agent.aispace.skill.feishu;

import Ua.C1060i;
import Y4.C1121e;
import Z8.C1173v;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.C1398p;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.a0;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u008b\u00012\u00020\u0001:\u0004\u008c\u0001\u008d\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u001b\u0010(\u001a\u0004\u0018\u00010\f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J!\u0010/\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u0017\u00106\u001a\u00020\u00062\u0006\u0010'\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003J\u001f\u0010;\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010:\u001a\u00020\u0014H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010\u001fJ\u0017\u0010?\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010\u001fJ\u000f\u0010@\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0003J\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\u0003J\u0017\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010\u0003J\u000f\u0010H\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010\u0003J\u000f\u0010I\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\u0003J\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bL\u0010\u0003J\u0017\u0010N\u001a\u00020\u00062\u0006\u0010'\u001a\u00020MH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010\u0003J3\u0010V\u001a\u00020U2\u0006\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020\u00142\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060SH\u0002¢\u0006\u0004\bV\u0010WJ\u001f\u0010Z\u001a\u00020\u00062\u0006\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020\u0014H\u0002¢\u0006\u0004\bZ\u0010[J\u001d\u0010^\u001a\u00020\u00062\f\u0010]\u001a\b\u0012\u0004\u0012\u00020C0\\H\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020`H\u0002¢\u0006\u0004\bb\u0010cJ\u0019\u0010f\u001a\u00020\u00062\b\u0010e\u001a\u0004\u0018\u00010dH\u0014¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0006H\u0014¢\u0006\u0004\bh\u0010\u0003J\u0017\u0010j\u001a\u00020\u00062\u0006\u0010i\u001a\u00020dH\u0014¢\u0006\u0004\bj\u0010gJ\u000f\u0010k\u001a\u00020\u0006H\u0014¢\u0006\u0004\bk\u0010\u0003R\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bm\u0010nR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020&0o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bp\u0010qR\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020&0o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\br\u0010qR\u0016\u0010s\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010y\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010{\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010}\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010zR\u0019\u0010\u0080\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R\u0019\u0010\u0083\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity;", "Lz5/a;", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity$PendingReturn;", UxipConstants.f30680s, "LY8/t;", "h1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity$PendingReturn;)V", "g0", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity$PendingReturn;", "x0", "", "serverStatus", "t1", "(Ljava/lang/String;)V", "w0", "t0", "v0", "u0", "", "cancelling", "d0", "(Z)V", "s1", "o1", "p0", "n1", "o0", "url", "s0", "(Ljava/lang/String;)Z", "i1", "p1", "l1", "m1", "k0", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", VoiceWakeupReceiver.EXTRA_STATE, "l0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;", "stage", "m0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;)Ljava/lang/String;", "prev", "u1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;)V", "S0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;)V", "f1", "c0", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$h;", "b1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$h;)V", "T0", "c1", "timeout", "j0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;Z)Ljava/lang/String;", "callerTag", "q0", "r0", "O0", "y0", "P0", "", "stepBase", "e1", "(I)V", "d1", "W0", "U0", "V0", "g1", SdCardDbCreator.FIELD_LASTLOC_ID, "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$e;", "X0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$e;)V", "Y0", "checked", x5.d.EXTRA_ENABLED, "Lkotlin/Function1;", "onCheckChange", "Landroid/widget/FrameLayout;", "h0", "(ZZLp9/l;)Landroid/widget/FrameLayout;", "stepIndex", "completed", "f0", "(IZ)V", "", "dotStates", "e0", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "task", "M0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "outState", "onSaveInstanceState", "onResume", "LY4/e;", "binding", "LY4/e;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/PollingManager;", "authorizePoller", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/PollingManager;", "reviewPoller", "pendingReturn", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity$PendingReturn;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "recommendedAdapter", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "Lkotlinx/coroutines/g;", "statusPollingJob", "Lkotlinx/coroutines/g;", "lastRenderedState", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "checkingAuthJob", "checkingCreateJob", "", "connectingTransitionEndAtMs", "J", "currentStepStartMs", "enteredFromInitialConnected", "Z", "lastStep", "Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "n0", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "connector", "Companion", "PendingReturn", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeishuConnectActivity extends ActivityC6361a {
    private static final long CHECKING_AUTH_TIMEOUT_MS = 30000;
    private static final long CHECKING_CREATE_TIMEOUT_MS = 15000;
    private static final long CONNECTING_TRANSITION_MS = 3000;
    private static final String KEY_PENDING_RETURN = "ailauncher.feishu.pending_return";
    private static final String REC_ID_SUMMARY_MSG = "rec_summary_msg";
    private static final int SEG_ACTIVE_CHECK = 0;
    private static final int SEG_PENDING_FILLED = 1;
    private static final int SEG_PENDING_HOLLOW = 2;
    private static final int SEG_PENDING_LOADING = 3;
    private static final long STATUS_POLL_INTERVAL_MS = 5000;
    private static final String TAG = "AILauncher-FeishuConn";
    private PollingManager<AbstractC2306b> authorizePoller;
    private C1121e binding;
    private kotlinx.coroutines.g checkingAuthJob;
    private kotlinx.coroutines.g checkingCreateJob;
    private long connectingTransitionEndAtMs;
    private long currentStepStartMs;
    private boolean enteredFromInitialConnected;
    private AbstractC2306b lastRenderedState;
    private String lastStep;
    private volatile PendingReturn pendingReturn = PendingReturn.NONE;
    private final r0 recommendedAdapter = new r0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.s
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return FeishuConnectActivity.R0(this.f24275a, (RecommendedTask) obj);
        }
    });
    private PollingManager<AbstractC2306b> reviewPoller;
    private kotlinx.coroutines.g statusPollingJob;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile PendingReturn pendingReturnGlobal = PendingReturn.NONE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity$PendingReturn;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "CREATE_BOT", "AUTHORIZE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PendingReturn {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ PendingReturn[] $VALUES;
        public static final PendingReturn NONE = new PendingReturn(ModelFlowMeta.PLAN_NONE, 0);
        public static final PendingReturn CREATE_BOT = new PendingReturn("CREATE_BOT", 1);
        public static final PendingReturn AUTHORIZE = new PendingReturn("AUTHORIZE", 2);

        private static final /* synthetic */ PendingReturn[] $values() {
            return new PendingReturn[]{NONE, CREATE_BOT, AUTHORIZE};
        }

        static {
            PendingReturn[] pendingReturnArr$values = $values();
            $VALUES = pendingReturnArr$values;
            $ENTRIES = kotlin.enums.a.a(pendingReturnArr$values);
        }

        private PendingReturn(String str, int i10) {
        }

        public static InterfaceC4149a<PendingReturn> getEntries() {
            return $ENTRIES;
        }

        public static PendingReturn valueOf(String str) {
            return (PendingReturn) Enum.valueOf(PendingReturn.class, str);
        }

        public static PendingReturn[] values() {
            return (PendingReturn[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "", "STATUS_POLL_INTERVAL_MS", "J", "CONNECTING_TRANSITION_MS", "CHECKING_AUTH_TIMEOUT_MS", "CHECKING_CREATE_TIMEOUT_MS", "KEY_PENDING_RETURN", "REC_ID_SUMMARY_MSG", "", "SEG_ACTIVE_CHECK", "I", "SEG_PENDING_FILLED", "SEG_PENDING_HOLLOW", "SEG_PENDING_LOADING", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            b5.i.INSTANCE.a(context, new Intent(context, (Class<?>) FeishuConnectActivity.class));
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FailStage.values().length];
            try {
                iArr[FailStage.Install.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FailStage.CreateBot.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FailStage.Authorize.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FailStage.Review.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "<anonymous>", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onCreate$4", f = "FeishuConnectActivity.kt", l = {102}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onCreate$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super o0<AbstractC2306b>>, Object> {
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(1, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return FeishuConnectActivity.this.new AnonymousClass4(interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super o0<AbstractC2306b>> interfaceC4014c) {
            return ((AnonymousClass4) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            h0 h0VarN0 = FeishuConnectActivity.this.n0();
            this.label = 1;
            Object objF = h0VarN0.f(this);
            return objF == objG ? objG : objF;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "<anonymous>", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onCreate$5", f = "FeishuConnectActivity.kt", l = {108}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onCreate$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super o0<AbstractC2306b>>, Object> {
        int label;

        public AnonymousClass5(InterfaceC4014c<? super AnonymousClass5> interfaceC4014c) {
            super(1, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return FeishuConnectActivity.this.new AnonymousClass5(interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super o0<AbstractC2306b>> interfaceC4014c) {
            return ((AnonymousClass5) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            h0 h0VarN0 = FeishuConnectActivity.this.n0();
            this.label = 1;
            Object objC = h0VarN0.c(this);
            return objC == objG ? objG : objC;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onResume$1", f = "FeishuConnectActivity.kt", l = {345}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ PendingReturn $pending;
        int label;
        final /* synthetic */ FeishuConnectActivity this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$onResume$1$a */
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PendingReturn.values().length];
                try {
                    iArr[PendingReturn.CREATE_BOT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PendingReturn.AUTHORIZE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PendingReturn.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PendingReturn pendingReturn, FeishuConnectActivity feishuConnectActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$pending = pendingReturn;
            this.this$0 = feishuConnectActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$pending, this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 252
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.core.view.a0 A0(View v10, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        v10.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, eVarF.f41980d);
        return insets;
    }

    public static final void B0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.P0();
    }

    public static final void C0(FeishuConnectActivity feishuConnectActivity, View view) {
        C1121e c1121e = feishuConnectActivity.binding;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.flDebugLogContainer.setVisibility(8);
    }

    public static final void D0(View view) {
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.k.INSTANCE.c();
    }

    public static final void E0(FeishuConnectActivity feishuConnectActivity, View view) {
        C1121e c1121e = feishuConnectActivity.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        FrameLayout frameLayout = c1121e.flDebugLogContainer;
        C1121e c1121e3 = feishuConnectActivity.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e3;
        }
        frameLayout.setVisibility(c1121e2.flDebugLogContainer.getVisibility() == 0 ? 8 : 0);
    }

    public static final void F0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.finish();
    }

    public static final void G0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.o1();
    }

    public static final void H0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.O0();
    }

    public static final void I0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.p0();
    }

    public static final void J0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.o0();
    }

    public static final void K0(FeishuConnectActivity feishuConnectActivity, View view) {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_FEISHU, feishuConnectActivity.k0(), "done", null, 8, null);
        feishuConnectActivity.finish();
    }

    public static final void L0(FeishuConnectActivity feishuConnectActivity, View view) {
        feishuConnectActivity.y0();
    }

    public static final Y8.t N0(FeishuConnectActivity feishuConnectActivity) {
        C4148a.d(TAG, "summary task confirmed, wake with default prompt", false, 4, null);
        WakeService.INSTANCE.M1(feishuConnectActivity, feishuConnectActivity.getString(R$string.feishu_cli_auto_summary_send_msg), true);
        return Y8.t.f7040a;
    }

    public static final void Q0(DialogInterface dialogInterface) {
        FeishuCliRepository.l(FeishuCliRepository.INSTANCE, null, null, 3, null);
    }

    public static final Y8.t R0(FeishuConnectActivity feishuConnectActivity, RecommendedTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("clicked recommended task=%s", Arrays.copyOf(new Object[]{task.getId()}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        feishuConnectActivity.M0(task);
        return Y8.t.f7040a;
    }

    public static final Y8.t Z0(boolean z10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("connected switch click desired=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(z10)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (z10) {
            FeishuCliRepository.q(FeishuCliRepository.INSTANCE, null, 1, null);
        } else {
            FeishuCliRepository.o(FeishuCliRepository.INSTANCE, null, 1, null);
        }
        return Y8.t.f7040a;
    }

    public static final void i0(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    public static final Y8.t j1(FeishuConnectActivity feishuConnectActivity, AbstractC2306b state) {
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("authorize poll update=%s", Arrays.copyOf(new Object[]{state}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (state instanceof AbstractC2306b.m) {
            feishuConnectActivity.S0(state);
            feishuConnectActivity.p1();
        } else if (state instanceof AbstractC2306b.Failed) {
            feishuConnectActivity.S0(state);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t k1(FeishuConnectActivity feishuConnectActivity) {
        C4148a.u(TAG, "authorize poll timeout", false, 4, null);
        Toast.makeText(feishuConnectActivity, feishuConnectActivity.getString(R$string.feishu_cli_toast_authorize_timeout), 0).show();
        return Y8.t.f7040a;
    }

    public static final Y8.t q1(FeishuConnectActivity feishuConnectActivity, AbstractC2306b state) {
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("review poll update=%s", Arrays.copyOf(new Object[]{state}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if ((state instanceof AbstractC2306b.Connected) || (state instanceof AbstractC2306b.Failed)) {
            feishuConnectActivity.S0(state);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t r1(FeishuConnectActivity feishuConnectActivity) {
        C4148a.u(TAG, "review poll timeout", false, 4, null);
        Toast.makeText(feishuConnectActivity, feishuConnectActivity.getString(R$string.feishu_cli_toast_review_timeout), 0).show();
        return Y8.t.f7040a;
    }

    public static final Long v1(FeishuConnectActivity feishuConnectActivity) {
        if (feishuConnectActivity.currentStepStartMs > 0) {
            return Long.valueOf(SystemClock.elapsedRealtime() - feishuConnectActivity.currentStepStartMs);
        }
        return null;
    }

    public static final void z0(DialogInterface dialogInterface) {
        FeishuCliRepository.l(FeishuCliRepository.INSTANCE, null, null, 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M0(com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getId()
            java.lang.String r1 = "vipcase_"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = La.D.X(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L33
            W4.b r0 = W4.b.INSTANCE
            java.lang.String r3 = r8.getId()
            java.lang.String r5 = r8.getTitle()
            java.lang.String r6 = r8.getId()
            java.lang.String r1 = La.H.R0(r6, r1)
            java.lang.Integer r1 = La.C.w(r1)
            if (r1 == 0) goto L2d
            int r1 = r1.intValue()
            goto L2e
        L2d:
            r1 = -1
        L2e:
            java.lang.String r6 = "feishu"
            r0.i(r6, r3, r5, r1)
        L33:
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.j r0 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE
            Xa.t r1 = r0.i()
            java.lang.Object r1 = r1.getValue()
            java.lang.String r3 = "connected"
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            java.lang.String r3 = "format(...)"
            java.lang.String r5 = "AILauncher-FeishuConn"
            r6 = 1
            if (r1 != 0) goto L78
            kotlin.jvm.internal.y r8 = kotlin.jvm.internal.y.f34840a
            Xa.t r8 = r0.i()
            java.lang.Object r8 = r8.getValue()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r6)
            java.lang.String r0 = "recommended task blocked: feishu cli not enabled, status=%s"
            java.lang.String r8 = java.lang.String.format(r0, r8)
            kotlin.jvm.internal.p.h(r8, r3)
            r0 = 4
            h8.C4148a.d(r5, r8, r2, r0, r4)
            int r8 = com.stepos.ailauncher.agent.R$string.feishu_cli_disabled_chat_blocked
            java.lang.String r8 = r7.getString(r8)
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r8, r2)
            r7.show()
            return
        L78:
            java.lang.String r0 = r8.getId()
            java.lang.String r1 = "rec_summary_msg"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto L93
            com.stepos.ailauncher.agent.aispace.skill.feishu.f r8 = new com.stepos.ailauncher.agent.aispace.skill.feishu.f
            com.stepos.ailauncher.agent.aispace.skill.feishu.t r0 = new com.stepos.ailauncher.agent.aispace.skill.feishu.t
            r0.<init>()
            r8.<init>(r7, r0)
            r8.show()
            return
        L93:
            java.lang.String r0 = r8.getPrompt()
            if (r0 == 0) goto La2
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto La0
            r4 = r0
        La0:
            if (r4 != 0) goto La6
        La2:
            java.lang.String r4 = r8.getTitle()
        La6:
            kotlin.jvm.internal.y r8 = kotlin.jvm.internal.y.f34840a
            java.lang.Object[] r8 = new java.lang.Object[]{r4}
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r6)
            java.lang.String r0 = "onRecommendedTaskClicked wake with prompt=%s"
            java.lang.String r8 = java.lang.String.format(r0, r8)
            kotlin.jvm.internal.p.h(r8, r3)
            h8.C4148a.c(r5, r8, r6)
            com.stepos.ailauncher.chat.wake.WakeService$Companion r8 = com.stepos.ailauncher.chat.wake.WakeService.INSTANCE
            r8.M1(r7, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity.M0(com.stepos.ailauncher.agent.aispace.skill.feishu.p0):void");
    }

    public final void O0() {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_FEISHU, k0(), "reconnect", null, 8, null);
        if (kotlin.jvm.internal.p.d(this.lastRenderedState, AbstractC2306b.a.INSTANCE)) {
            C4148a.d(TAG, "retry -> AuthCheckLocalFailed, re-launch authorize url", false, 4, null);
            o0();
            return;
        }
        AbstractC2306b state = n0().getState();
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j jVar = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE;
        String value = jVar.j().getValue();
        String value2 = jVar.f().getValue();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onRetryClicked state=%s taskId=%s nextActionType=%s", Arrays.copyOf(new Object[]{state, value, value2}, 3));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (kotlin.jvm.internal.p.d(this.lastRenderedState, AbstractC2306b.j.INSTANCE)) {
            if (!com.stepos.ailauncher.common.utils.I.INSTANCE.b(this)) {
                Toast.makeText(this, getString(R$string.feishu_cli_toast_network_unavailable), 0).show();
                return;
            } else if (value == null || La.H.x0(value)) {
                o1();
                return;
            } else {
                S0(AbstractC2306b.l.INSTANCE);
                FeishuCliRepository.C(FeishuCliRepository.INSTANCE, null, 1, null);
                return;
            }
        }
        if (value == null || La.H.x0(value)) {
            C4148a.d(TAG, "retry -> no taskId yet, fall back to startInstall", false, 4, null);
            o1();
        } else {
            String str2 = String.format("retry -> POST /connect action=retry taskId=%s", Arrays.copyOf(new Object[]{value}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.d(TAG, str2, false, 4, null);
            FeishuCliRepository.C(FeishuCliRepository.INSTANCE, null, 1, null);
        }
    }

    public final void P0() {
        W4.b.INSTANCE.c(W4.b.TOOL_FEISHU, k0(), "terminate", com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.i().getValue());
        com.stepos.ailauncher.container.dialog.f.r(this, getString(R$string.feishu_cli_uninstall_dialog_title), getString(R$string.feishu_cli_uninstall_dialog_desc), getString(R$string.feishu_cli_abort_dialog_cancel), getString(R$string.feishu_cli_abort_dialog_confirm), 0, new Consumer() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.v
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FeishuConnectActivity.Q0((DialogInterface) obj);
            }
        }, null);
    }

    public final void S0(AbstractC2306b state) {
        AbstractC2306b abstractC2306b;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("render state=%s lastRendered=%s", Arrays.copyOf(new Object[]{state, this.lastRenderedState}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        boolean z10 = state instanceof AbstractC2306b.Connected;
        if (z10 && com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.l() && (abstractC2306b = this.lastRenderedState) != null && !kotlin.jvm.internal.p.d(abstractC2306b, AbstractC2306b.i.INSTANCE)) {
            AbstractC2306b abstractC2306b2 = this.lastRenderedState;
            if (!(abstractC2306b2 instanceof AbstractC2306b.Connected)) {
                AbstractC2306b.f fVar = AbstractC2306b.f.INSTANCE;
                if (!kotlin.jvm.internal.p.d(abstractC2306b2, fVar)) {
                    C4148a.d(TAG, "render Connected first time → insert Connecting transition", false, 4, null);
                    f1(fVar);
                    this.connectingTransitionEndAtMs = System.currentTimeMillis() + 3000;
                    C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$render$1(this, state, null), 3, null);
                    return;
                }
            }
        }
        if (!z10 || System.currentTimeMillis() >= this.connectingTransitionEndAtMs) {
            f1(state);
        } else {
            C4148a.d(TAG, "render Connected within transition window, swallow", false, 4, null);
        }
    }

    public final void T0() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupFailed.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnRetry.setVisibility(0);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnAbortLink.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.badgeFailRed.setVisibility(0);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.badgeFailWarn.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvFailTitle.setText(getString(R$string.feishu_cli_auth_local_fail_title));
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.tvFailReason.setText(getString(R$string.feishu_cli_auth_local_fail_reason));
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e9;
        }
        c1121e2.btnRetry.setText(getString(R$string.feishu_cli_auth_local_fail_retry_cta));
    }

    public final void U0() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupInstalling.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnAuthorize.setVisibility(0);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnAbortLink.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.installHero.setVisibility(8);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.ivAuthorizeHero.setVisibility(0);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.ivInstallLogo.setVisibility(8);
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.ivAuthorizeBadge.setVisibility(8);
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        c1121e9.tvInstallDoneBadge.setVisibility(8);
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e10 = null;
        }
        c1121e10.tvInstallTitle.setText(getString(R$string.feishu_cli_authorize_title));
        C1121e c1121e11 = this.binding;
        if (c1121e11 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e11;
        }
        c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_authorize_subtitle));
        e0(C1173v.p(0, 0, 2, 2));
    }

    public final void V0() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupInstalling.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnAuthorize.setVisibility(8);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnAbortLink.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.ivInstallLogo.setVisibility(0);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.ivAuthorizeBadge.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvInstallDoneBadge.setVisibility(8);
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.tvInstallTitle.setText(getString(R$string.feishu_cli_checking_auth_title));
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e9;
        }
        c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_checking_auth_subtitle));
        e0(C1173v.p(0, 0, 3, 2));
    }

    public final void W0() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupInstalling.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnInstallNext.setVisibility(8);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnAbortLink.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.ivInstallLogo.setVisibility(0);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.ivAuthorizeBadge.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvInstallDoneBadge.setVisibility(8);
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.tvInstallTitle.setText(getString(R$string.feishu_cli_checking_create_title));
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e9;
        }
        c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_checking_create_subtitle));
        e0(C1173v.p(0, 3, 2, 2));
    }

    public final void X0(AbstractC2306b.Connected state) {
        C1121e c1121e = this.binding;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupConnected.setVisibility(0);
        C1121e c1121e2 = this.binding;
        if (c1121e2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e2 = null;
        }
        c1121e2.btnTopUninstall.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.tvConnectedTitle.setText(getString(R$string.feishu_cli_connected_title));
        Y0();
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$renderConnected$1(this, null), 3, null);
    }

    public final void Y0() {
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j jVar = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE;
        boolean zD = kotlin.jvm.internal.p.d(jVar.i().getValue(), "connected");
        boolean zBooleanValue = jVar.n().getValue().booleanValue();
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.connectedActionArea.removeAllViews();
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e3;
        }
        c1121e2.connectedActionArea.addView(h0(zD, !zBooleanValue, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectActivity.Z0(((Boolean) obj).booleanValue());
            }
        }));
    }

    public final void a1() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupInstalling.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnAbortLink.setVisibility(0);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.ivInstallLogo.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.ivAuthorizeBadge.setVisibility(8);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.tvInstallDoneBadge.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvInstallTitle.setText(getString(R$string.feishu_cli_connecting_title));
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e8;
        }
        c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_connecting_subtitle));
        e0(C1173v.p(0, 0, 0, 3));
    }

    public final void b1(AbstractC2306b.Failed state) {
        String string;
        String string2;
        C1121e c1121e = this.binding;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupFailed.setVisibility(0);
        C1121e c1121e2 = this.binding;
        if (c1121e2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e2 = null;
        }
        c1121e2.btnRetry.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnAbortLink.setVisibility(0);
        boolean z10 = state.getKind() == FailKind.Timeout;
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.badgeFailRed.setVisibility(z10 ? 8 : 0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.badgeFailWarn.setVisibility(z10 ? 0 : 8);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        TextView textView = c1121e6.tvFailTitle;
        if (z10) {
            int i10 = b.$EnumSwitchMapping$0[state.getStage().ordinal()];
            if (i10 == 1) {
                string = getString(R$string.feishu_cli_fail_install_timeout_title);
            } else if (i10 == 2) {
                string = getString(R$string.feishu_cli_fail_create_bot_timeout_title);
            } else if (i10 == 3) {
                string = getString(R$string.feishu_cli_fail_authorize_timeout_title);
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                string = getString(R$string.feishu_cli_fail_review_timeout_title);
            }
        } else {
            int i11 = b.$EnumSwitchMapping$0[state.getStage().ordinal()];
            if (i11 == 1) {
                string = getString(R$string.feishu_cli_fail_install_title);
            } else if (i11 == 2) {
                string = getString(R$string.feishu_cli_fail_create_bot_title);
            } else if (i11 == 3) {
                string = getString(R$string.feishu_cli_fail_authorize_title);
            } else {
                if (i11 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                string = getString(R$string.feishu_cli_fail_review_title);
            }
        }
        textView.setText(string);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvFailReason.setText(j0(state.getStage(), z10));
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        TextView textView2 = c1121e8.btnRetry;
        int i12 = b.$EnumSwitchMapping$0[state.getStage().ordinal()];
        if (i12 == 1) {
            string2 = getString(R$string.feishu_cli_retry_install);
        } else if (i12 == 2) {
            string2 = getString(R$string.feishu_cli_retry_create_bot);
        } else {
            if (i12 != 3 && i12 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            string2 = getString(R$string.feishu_cli_retry_authorize);
        }
        textView2.setText(string2);
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("renderFailed stage=%s kind=%s code=%s", Arrays.copyOf(new Object[]{state.getStage(), state.getKind(), state.getCode()}, 3));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void c0() {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (44 * f10);
        int i11 = (int) (102 * f10);
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        if (c1121e.btnAbortLink.getVisibility() == 0) {
            i10 = i11;
        }
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        TextView textView = c1121e3.btnConnect;
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        TextView textView2 = c1121e4.btnInstallNext;
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        TextView textView3 = c1121e5.btnAuthorize;
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        TextView textView4 = c1121e6.btnBackToAiSpace;
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e7;
        }
        for (TextView textView5 : C1173v.p(textView, textView2, textView3, textView4, c1121e2.btnRetry)) {
            ViewGroup.LayoutParams layoutParams = textView5.getLayoutParams();
            kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (layoutParams2.bottomMargin != i10) {
                layoutParams2.bottomMargin = i10;
                textView5.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void c1() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupFailed.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnRetry.setVisibility(0);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        FrameLayout frameLayout = c1121e4.btnAbortLink;
        String value = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.j().getValue();
        frameLayout.setVisibility((value == null || La.H.x0(value)) ? 8 : 0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.badgeFailRed.setVisibility(0);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.badgeFailWarn.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvFailTitle.setText(getString(R$string.feishu_cli_install_network_fail_title));
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.tvFailReason.setText(getString(R$string.feishu_cli_install_network_fail_reason));
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e9;
        }
        c1121e2.btnRetry.setText(getString(R$string.feishu_cli_retry_install));
    }

    public final void d0(boolean cancelling) {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.tvAbortLink.setVisibility(cancelling ? 8 : 0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.pbAbortLink.setVisibility(cancelling ? 0 : 8);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnAbortLink.setEnabled(!cancelling);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.btnAbortLink.setClickable(!cancelling);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.ivTopUninstall.setVisibility(cancelling ? 8 : 0);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.pbTopUninstall.setVisibility(cancelling ? 0 : 8);
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.btnTopUninstall.setBackground(cancelling ? null : androidx.core.content.a.e(this, R$drawable.bg_new_session_circle));
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        c1121e9.btnTopUninstall.setEnabled(!cancelling);
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e10;
        }
        c1121e2.btnTopUninstall.setClickable(!cancelling);
    }

    public final void d1() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupInstalling.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnInstallNext.setVisibility(0);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnAbortLink.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.tvInstallDoneBadge.setVisibility(0);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.ivInstallLogo.setVisibility(0);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvInstallTitle.setText(getString(R$string.feishu_cli_install_done_title));
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e8;
        }
        c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_install_done_subtitle));
        e0(C1173v.p(0, 2, 2, 2));
    }

    public final void e0(List<Integer> dotStates) {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        View view = c1121e.dotStep1Bg;
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        View view2 = c1121e3.dotStep2Bg;
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        View view3 = c1121e4.dotStep3Bg;
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        List listP = C1173v.p(view, view2, view3, c1121e5.dotStep4Bg);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        ImageView imageView = c1121e6.dotStep1Check;
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        ImageView imageView2 = c1121e7.dotStep2Check;
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        ImageView imageView3 = c1121e8.dotStep3Check;
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        List listP2 = C1173v.p(imageView, imageView2, imageView3, c1121e9.dotStep4Check);
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e10 = null;
        }
        IndeterminateSpinnerView indeterminateSpinnerView = c1121e10.dotStep1Loading;
        C1121e c1121e11 = this.binding;
        if (c1121e11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e11 = null;
        }
        IndeterminateSpinnerView indeterminateSpinnerView2 = c1121e11.dotStep2Loading;
        C1121e c1121e12 = this.binding;
        if (c1121e12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e12 = null;
        }
        IndeterminateSpinnerView indeterminateSpinnerView3 = c1121e12.dotStep3Loading;
        C1121e c1121e13 = this.binding;
        if (c1121e13 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e13;
        }
        List listP3 = C1173v.p(indeterminateSpinnerView, indeterminateSpinnerView2, indeterminateSpinnerView3, c1121e2.dotStep4Loading);
        int i10 = 0;
        for (Object obj : listP) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            View view4 = (View) obj;
            Integer num = (Integer) Z8.F.t0(dotStates, i10);
            if (num != null && num.intValue() == 0) {
                view4.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_finished);
            } else if (num != null && num.intValue() == 1) {
                view4.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_finished);
            } else if (num != null && num.intValue() == 3) {
                view4.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_current);
            } else {
                view4.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_pending);
            }
            i10 = i11;
        }
        Iterator it = listP2.iterator();
        int i12 = 0;
        while (true) {
            int i13 = 8;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i14 = i12 + 1;
            if (i12 < 0) {
                C1173v.w();
            }
            ImageView imageView4 = (ImageView) next;
            Integer num2 = (Integer) Z8.F.t0(dotStates, i12);
            if ((num2 != null && num2.intValue() == 0) || (num2 != null && num2.intValue() == 1)) {
                i13 = 0;
            }
            imageView4.setVisibility(i13);
            i12 = i14;
        }
        int i15 = 0;
        for (Object obj2 : listP3) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                C1173v.w();
            }
            IndeterminateSpinnerView indeterminateSpinnerView4 = (IndeterminateSpinnerView) obj2;
            Integer num3 = (Integer) Z8.F.t0(dotStates, i15);
            indeterminateSpinnerView4.setVisibility((num3 != null && num3.intValue() == 3) ? 0 : 8);
            i15 = i16;
        }
    }

    public final void e1(int stepBase) {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupIdle.setVisibility(8);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnConnect.setVisibility(8);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.groupConnected.setVisibility(8);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.groupFailed.setVisibility(8);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.btnInstallNext.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.btnAuthorize.setVisibility(8);
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.btnBackToAiSpace.setVisibility(8);
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        c1121e9.btnRetry.setVisibility(8);
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e10 = null;
        }
        c1121e10.tvInstallDoneBadge.setVisibility(8);
        C1121e c1121e11 = this.binding;
        if (c1121e11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e11 = null;
        }
        c1121e11.ivAuthorizeBadge.setVisibility(8);
        C1121e c1121e12 = this.binding;
        if (c1121e12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e12 = null;
        }
        c1121e12.ivAuthorizeHero.setVisibility(8);
        C1121e c1121e13 = this.binding;
        if (c1121e13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e13 = null;
        }
        c1121e13.installHero.setVisibility(0);
        C1121e c1121e14 = this.binding;
        if (c1121e14 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e14 = null;
        }
        c1121e14.ivInstallLogo.setVisibility(0);
        C1121e c1121e15 = this.binding;
        if (c1121e15 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e15 = null;
        }
        c1121e15.dotStep1Loading.setVisibility(8);
        C1121e c1121e16 = this.binding;
        if (c1121e16 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e16 = null;
        }
        c1121e16.dotStep2Loading.setVisibility(8);
        C1121e c1121e17 = this.binding;
        if (c1121e17 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e17 = null;
        }
        c1121e17.dotStep3Loading.setVisibility(8);
        C1121e c1121e18 = this.binding;
        if (c1121e18 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e18 = null;
        }
        c1121e18.dotStep4Loading.setVisibility(8);
        C1121e c1121e19 = this.binding;
        if (c1121e19 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e19 = null;
        }
        c1121e19.groupInstalling.setVisibility(0);
        if (stepBase == 0) {
            C1121e c1121e20 = this.binding;
            if (c1121e20 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1121e20 = null;
            }
            c1121e20.tvInstallTitle.setText(getString(R$string.feishu_cli_install_title));
            C1121e c1121e21 = this.binding;
            if (c1121e21 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1121e2 = c1121e21;
            }
            c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_install_subtitle));
        } else if (stepBase == 1) {
            C1121e c1121e22 = this.binding;
            if (c1121e22 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1121e22 = null;
            }
            c1121e22.tvInstallTitle.setText(getString(R$string.feishu_cli_bot_creating_title));
            C1121e c1121e23 = this.binding;
            if (c1121e23 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1121e23 = null;
            }
            c1121e23.tvInstallSubtitle.setText(getString(R$string.feishu_cli_bot_creating_subtitle));
            C1121e c1121e24 = this.binding;
            if (c1121e24 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1121e2 = c1121e24;
            }
            c1121e2.btnAbortLink.setVisibility(0);
        }
        f0(stepBase, false);
    }

    public final void f0(int stepIndex, boolean completed) {
        ArrayList arrayList = new ArrayList(4);
        for (int i10 = 0; i10 < 4; i10++) {
            arrayList.add(2);
        }
        for (int i11 = 0; i11 < stepIndex; i11++) {
            arrayList.set(i11, 0);
        }
        if (stepIndex >= 0 && stepIndex < 4) {
            arrayList.set(stepIndex, 3);
        }
        e0(arrayList);
    }

    public final void f1(AbstractC2306b state) {
        AbstractC2306b abstractC2306b = this.lastRenderedState;
        this.lastRenderedState = state;
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupIdle.setVisibility(8);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnConnect.setVisibility(8);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.groupInstalling.setVisibility(8);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.btnInstallNext.setVisibility(8);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.btnAuthorize.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.btnBackToAiSpace.setVisibility(8);
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.btnRetry.setVisibility(8);
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        c1121e9.btnAbortLink.setVisibility(8);
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e10 = null;
        }
        c1121e10.btnTopUninstall.setVisibility(8);
        C1121e c1121e11 = this.binding;
        if (c1121e11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e11 = null;
        }
        c1121e11.groupConnected.setVisibility(8);
        C1121e c1121e12 = this.binding;
        if (c1121e12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e12 = null;
        }
        c1121e12.groupFailed.setVisibility(8);
        C1121e c1121e13 = this.binding;
        if (c1121e13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e13 = null;
        }
        c1121e13.dotStep1Loading.setVisibility(8);
        C1121e c1121e14 = this.binding;
        if (c1121e14 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e14 = null;
        }
        c1121e14.dotStep2Loading.setVisibility(8);
        C1121e c1121e15 = this.binding;
        if (c1121e15 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e15 = null;
        }
        c1121e15.dotStep3Loading.setVisibility(8);
        C1121e c1121e16 = this.binding;
        if (c1121e16 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e16 = null;
        }
        c1121e16.dotStep4Loading.setVisibility(8);
        if (kotlin.jvm.internal.p.d(state, AbstractC2306b.i.INSTANCE)) {
            C1121e c1121e17 = this.binding;
            if (c1121e17 == null) {
                kotlin.jvm.internal.p.A("binding");
                c1121e17 = null;
            }
            c1121e17.groupIdle.setVisibility(0);
            C1121e c1121e18 = this.binding;
            if (c1121e18 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1121e2 = c1121e18;
            }
            c1121e2.btnConnect.setVisibility(0);
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.l.INSTANCE)) {
            e1(0);
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.j.INSTANCE)) {
            c1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.k.INSTANCE)) {
            d1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.d.INSTANCE)) {
            W0();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.g.INSTANCE)) {
            e1(1);
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.C0262b.INSTANCE)) {
            U0();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.c.INSTANCE)) {
            V0();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.a.INSTANCE)) {
            T0();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.m.INSTANCE)) {
            g1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.f.INSTANCE)) {
            a1();
        } else if (state instanceof AbstractC2306b.Connected) {
            X0((AbstractC2306b.Connected) state);
        } else {
            if (!(state instanceof AbstractC2306b.Failed)) {
                throw new NoWhenBranchMatchedException();
            }
            b1((AbstractC2306b.Failed) state);
        }
        c0();
        u1(abstractC2306b, state);
    }

    public final PendingReturn g0() {
        PendingReturn pendingReturn = this.pendingReturn;
        PendingReturn pendingReturn2 = PendingReturn.NONE;
        PendingReturn pendingReturn3 = pendingReturn != pendingReturn2 ? this.pendingReturn : pendingReturnGlobal;
        if (pendingReturn3 != pendingReturn2) {
            this.pendingReturn = pendingReturn2;
            pendingReturnGlobal = pendingReturn2;
        }
        return pendingReturn3;
    }

    public final void g1() {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.groupInstalling.setVisibility(0);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnAbortLink.setVisibility(0);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.ivInstallLogo.setVisibility(0);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.ivAuthorizeBadge.setVisibility(8);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.tvInstallDoneBadge.setVisibility(8);
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.tvInstallTitle.setText(getString(R$string.feishu_cli_review_title));
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e8;
        }
        c1121e2.tvInstallSubtitle.setText(getString(R$string.feishu_cli_review_subtitle));
        e0(C1173v.p(0, 0, 3, 2));
    }

    public final FrameLayout h0(final boolean checked, boolean enabled, final InterfaceC5074l<? super Boolean, Y8.t> onCheckChange) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(this, R$color.feishu_brand);
        int iC2 = androidx.core.content.a.c(this, R$color.feishu_step_dot_pending);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        if (!enabled) {
            IndeterminateSpinnerView indeterminateSpinnerView = new IndeterminateSpinnerView(this, null, 0, 6, null);
            indeterminateSpinnerView.setColor(b5.m.INSTANCE.i(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i11);
            layoutParams.gravity = 17;
            Y8.t tVar = Y8.t.f7040a;
            frameLayout.addView(indeterminateSpinnerView, layoutParams);
            frameLayout.setClickable(false);
            return frameLayout;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i11 / 2.0f);
        if (!checked) {
            iC = iC2;
        }
        gradientDrawable.setColor(iC);
        frameLayout.setBackground(gradientDrawable);
        View view = new View(this);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(-1);
        view.setBackground(gradientDrawable2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i12, i12);
        layoutParams2.gravity = (checked ? 8388613 : 8388611) | 16;
        layoutParams2.setMarginStart(i13);
        layoutParams2.setMarginEnd(i13);
        Y8.t tVar2 = Y8.t.f7040a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectActivity.i0(onCheckChange, checked, view2);
            }
        });
        return frameLayout;
    }

    public final void h1(PendingReturn value) {
        this.pendingReturn = value;
        pendingReturnGlobal = value;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("setPendingReturn(%s)", Arrays.copyOf(new Object[]{value}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void i1() {
        PollingManager<AbstractC2306b> pollingManager = this.authorizePoller;
        if (pollingManager == null) {
            kotlin.jvm.internal.p.A("authorizePoller");
            pollingManager = null;
        }
        pollingManager.d(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectActivity.j1(this.f24271a, (AbstractC2306b) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FeishuConnectActivity.k1(this.f24274a);
            }
        });
    }

    public final String j0(FailStage stage, boolean timeout) {
        int i10 = b.$EnumSwitchMapping$0[stage.ordinal()];
        if (i10 == 1) {
            String string = getString(timeout ? R$string.feishu_cli_fail_install_reason_timeout : R$string.feishu_cli_fail_install_reason);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (i10 == 2) {
            String string2 = getString(timeout ? R$string.feishu_cli_fail_create_bot_reason_timeout : R$string.feishu_cli_fail_create_bot_reason);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        if (i10 == 3) {
            String string3 = getString(timeout ? R$string.feishu_cli_fail_authorize_reason_timeout : R$string.feishu_cli_fail_authorize_reason);
            kotlin.jvm.internal.p.h(string3, "getString(...)");
            return string3;
        }
        if (i10 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        String string4 = getString(timeout ? R$string.feishu_cli_fail_review_reason_timeout : R$string.feishu_cli_fail_review_reason);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        return string4;
    }

    public final String k0() {
        String strL0 = l0(this.lastRenderedState);
        if (strL0 != null) {
            return strL0;
        }
        String str = this.lastStep;
        return str == null ? W4.b.STEP_INSTALL : str;
    }

    public final String l0(AbstractC2306b state) {
        if (kotlin.jvm.internal.p.d(state, AbstractC2306b.l.INSTANCE) || kotlin.jvm.internal.p.d(state, AbstractC2306b.k.INSTANCE)) {
            return W4.b.STEP_INSTALL;
        }
        if (kotlin.jvm.internal.p.d(state, AbstractC2306b.d.INSTANCE) || kotlin.jvm.internal.p.d(state, AbstractC2306b.g.INSTANCE)) {
            return W4.b.STEP_CREATE_APP;
        }
        if (kotlin.jvm.internal.p.d(state, AbstractC2306b.C0262b.INSTANCE) || kotlin.jvm.internal.p.d(state, AbstractC2306b.c.INSTANCE)) {
            return "authorize";
        }
        if (kotlin.jvm.internal.p.d(state, AbstractC2306b.m.INSTANCE)) {
            return W4.b.STEP_ADMIN_REVIEW;
        }
        if (kotlin.jvm.internal.p.d(state, AbstractC2306b.f.INSTANCE)) {
            return W4.b.STEP_CONNECT_CHECK;
        }
        return null;
    }

    public final void l1() {
        kotlinx.coroutines.g gVar = this.checkingAuthJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.checkingAuthJob = C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$startCheckingAuthTimeout$1(this, null), 3, null);
    }

    public final String m0(FailStage stage) {
        int i10 = b.$EnumSwitchMapping$0[stage.ordinal()];
        if (i10 == 1) {
            return W4.b.STEP_INSTALL;
        }
        if (i10 == 2) {
            return W4.b.STEP_CREATE_APP;
        }
        if (i10 == 3) {
            return "authorize";
        }
        if (i10 == 4) {
            return W4.b.STEP_ADMIN_REVIEW;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void m1() {
        kotlinx.coroutines.g gVar = this.checkingCreateJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.checkingCreateJob = C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$startCheckingCreateTimeout$1(this, null), 3, null);
    }

    public final h0 n0() {
        return i0.INSTANCE.a();
    }

    public final void n1() {
        e1(1);
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$startCreateBotProgress$1(this, null), 3, null);
    }

    public final void o0() {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_FEISHU, "authorize", "authorize", null, 8, null);
        C4148a.d(TAG, "goAuthorize clicked", false, 4, null);
        if (q0("goAuthorize") || r0("goAuthorize")) {
            return;
        }
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$goAuthorize$1(this, null), 3, null);
    }

    public final void o1() {
        W4.b.INSTANCE.b(W4.b.TOOL_FEISHU);
        this.enteredFromInitialConnected = false;
        this.lastStep = null;
        if (!com.stepos.ailauncher.common.utils.I.INSTANCE.b(this)) {
            C4148a.d(TAG, "startInstall blocked: no network", false, 4, null);
            Toast.makeText(this, getString(R$string.feishu_cli_toast_network_unavailable), 0).show();
        } else {
            if (q0("startInstall")) {
                return;
            }
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.q();
            s1();
            if (r0("startInstall")) {
                return;
            }
            e1(0);
            C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$startInstall$1(this, null), 3, null);
        }
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String string;
        Object objB;
        super.onCreate(savedInstanceState);
        C1121e c1121eB = C1121e.b(getLayoutInflater());
        kotlin.jvm.internal.p.h(c1121eB, "inflate(...)");
        this.binding = c1121eB;
        C1121e c1121e = null;
        if (c1121eB == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121eB = null;
        }
        setContentView(c1121eB.root);
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onCreate savedInstanceState=%s pendingReturnGlobal=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(savedInstanceState != null), pendingReturnGlobal}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        androidx.core.view.Y.b(getWindow(), true);
        androidx.core.view.Y.a(getWindow(), getWindow().getDecorView()).e(false);
        C1121e c1121e2 = this.binding;
        if (c1121e2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e2 = null;
        }
        androidx.core.view.N.u0(c1121e2.root, new androidx.core.view.A() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.x
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return FeishuConnectActivity.A0(view, a0Var);
            }
        });
        if (savedInstanceState != null && (string = savedInstanceState.getString(KEY_PENDING_RETURN)) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(PendingReturn.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            PendingReturn pendingReturn = (PendingReturn) objB;
            if (pendingReturn != null) {
                this.pendingReturn = pendingReturn;
            }
        }
        this.authorizePoller = new PollingManager<>(C1398p.a(this), 1500L, 60, new AnonymousClass4(null));
        this.reviewPoller = new PollingManager<>(C1398p.a(this), 500L, 120, new AnonymousClass5(null));
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.F0(this.f24234a, view);
            }
        });
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnConnect.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.G0(this.f24235a, view);
            }
        });
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.btnRetry.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.H0(this.f24236a, view);
            }
        });
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.btnInstallNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.F
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.I0(this.f24237a, view);
            }
        });
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.J0(this.f24238a, view);
            }
        });
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.btnBackToAiSpace.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.K0(this.f24239a, view);
            }
        });
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        c1121e9.btnAbortLink.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.L0(this.f24268a, view);
            }
        });
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e10 = null;
        }
        c1121e10.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.B0(this.f24269a, view);
            }
        });
        C1121e c1121e11 = this.binding;
        if (c1121e11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e11 = null;
        }
        c1121e11.pbTopUninstall.setColor(-1);
        C1121e c1121e12 = this.binding;
        if (c1121e12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e12 = null;
        }
        c1121e12.pbAbortLink.setColor(-1);
        C1121e c1121e13 = this.binding;
        if (c1121e13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e13 = null;
        }
        c1121e13.dotStep1Loading.setColor(-1);
        C1121e c1121e14 = this.binding;
        if (c1121e14 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e14 = null;
        }
        c1121e14.dotStep2Loading.setColor(-1);
        C1121e c1121e15 = this.binding;
        if (c1121e15 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e15 = null;
        }
        c1121e15.dotStep3Loading.setColor(-1);
        C1121e c1121e16 = this.binding;
        if (c1121e16 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e16 = null;
        }
        c1121e16.dotStep4Loading.setColor(-1);
        C1121e c1121e17 = this.binding;
        if (c1121e17 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e17 = null;
        }
        c1121e17.btnDebugLogClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.C0(this.f24270a, view);
            }
        });
        C1121e c1121e18 = this.binding;
        if (c1121e18 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e18 = null;
        }
        c1121e18.btnDebugLogClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.D0(view);
            }
        });
        C1121e c1121e19 = this.binding;
        if (c1121e19 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e19 = null;
        }
        c1121e19.btnDebugLogToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.B
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeishuConnectActivity.E0(this.f24233a, view);
            }
        });
        C1121e c1121e20 = this.binding;
        if (c1121e20 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e20 = null;
        }
        c1121e20.rvRecommendedTasks.setLayoutManager(new LinearLayoutManager(this));
        C1121e c1121e21 = this.binding;
        if (c1121e21 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e = c1121e21;
        }
        c1121e.rvRecommendedTasks.setAdapter(this.recommendedAdapter);
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.q();
        AbstractC2306b state = n0().getState();
        if (state instanceof AbstractC2306b.Connected) {
            this.lastRenderedState = state;
            this.enteredFromInitialConnected = true;
        }
        S0(state);
        x0();
        w0();
        t0();
        v0();
        u0();
        s1();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PollingManager<AbstractC2306b> pollingManager = this.authorizePoller;
        PollingManager<AbstractC2306b> pollingManager2 = null;
        if (pollingManager == null) {
            kotlin.jvm.internal.p.A("authorizePoller");
            pollingManager = null;
        }
        pollingManager.e();
        PollingManager<AbstractC2306b> pollingManager3 = this.reviewPoller;
        if (pollingManager3 == null) {
            kotlin.jvm.internal.p.A("reviewPoller");
        } else {
            pollingManager2 = pollingManager3;
        }
        pollingManager2.e();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        PendingReturn pendingReturnG0 = g0();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onResume pending=%s currentState=%s", Arrays.copyOf(new Object[]{pendingReturnG0, n0().getState()}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (pendingReturnG0 == PendingReturn.NONE) {
            return;
        }
        if (pendingReturnG0 == PendingReturn.AUTHORIZE) {
            S0(AbstractC2306b.c.INSTANCE);
            l1();
        }
        if (pendingReturnG0 == PendingReturn.CREATE_BOT) {
            S0(AbstractC2306b.d.INSTANCE);
            m1();
        }
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass1(pendingReturnG0, this, null), 3, null);
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(KEY_PENDING_RETURN, this.pendingReturn.name());
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onSaveInstanceState pendingReturn=%s", Arrays.copyOf(new Object[]{this.pendingReturn}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void p0() {
        if (q0("goCreateBot") || r0("goCreateBot")) {
            return;
        }
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$goCreateBot$1(this, null), 3, null);
    }

    public final void p1() {
        PollingManager<AbstractC2306b> pollingManager = this.reviewPoller;
        if (pollingManager == null) {
            kotlin.jvm.internal.p.A("reviewPoller");
            pollingManager = null;
        }
        pollingManager.d(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectActivity.q1(this.f24279a, (AbstractC2306b) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FeishuConnectActivity.r1(this.f24280a);
            }
        });
    }

    public final boolean q0(String callerTag) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean z10 = false;
            if (!C2309e.INSTANCE.a(this)) {
                if (isFinishing() || isDestroyed()) {
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                    String str = String.format("%s skip dialog: activity finishing/destroyed", Arrays.copyOf(new Object[]{callerTag}, 1));
                    kotlin.jvm.internal.p.h(str, "format(...)");
                    C4148a.d(TAG, str, false, 4, null);
                } else {
                    kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                    String str2 = String.format("%s intercepted: feishu app not installed", Arrays.copyOf(new Object[]{callerTag}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    C4148a.d(TAG, str2, false, 4, null);
                    new m0(this).show();
                    z10 = true;
                }
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            kotlin.jvm.internal.y yVar3 = kotlin.jvm.internal.y.f34840a;
            String str3 = String.format("%s interceptByFeishuNotInstalled failed, fall through", Arrays.copyOf(new Object[]{callerTag}, 1));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.t(TAG, str3, thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean r0(String callerTag) {
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j jVar = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE;
        String value = jVar.f().getValue();
        if (value != null) {
            int iHashCode = value.hashCode();
            if (iHashCode != 3089282) {
                if (iHashCode != 3387192) {
                    if (iHashCode == 108405416 && value.equals("retry")) {
                        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                        String str = String.format("%s intercepted: server.nextAction.type=retry, force /connect retry", Arrays.copyOf(new Object[]{callerTag}, 1));
                        kotlin.jvm.internal.p.h(str, "format(...)");
                        C4148a.d(TAG, str, false, 4, null);
                        FeishuCliRepository.C(FeishuCliRepository.INSTANCE, null, 1, null);
                        return true;
                    }
                } else if (value.equals("none")) {
                    String value2 = jVar.i().getValue();
                    if (value2 == null || La.H.x0(value2) || kotlin.jvm.internal.p.d(value2, "idle") || kotlin.jvm.internal.p.d(value2, "logout")) {
                        kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                        String str2 = String.format("%s pass-through: status=%s + type=none, treat as fresh start", Arrays.copyOf(new Object[]{callerTag, value2}, 2));
                        kotlin.jvm.internal.p.h(str2, "format(...)");
                        C4148a.d(TAG, str2, false, 4, null);
                        return false;
                    }
                    kotlin.jvm.internal.y yVar3 = kotlin.jvm.internal.y.f34840a;
                    String str3 = String.format("%s intercepted: server.nextAction.type=none status=%s, just poll status and wait", Arrays.copyOf(new Object[]{callerTag, value2}, 2));
                    kotlin.jvm.internal.p.h(str3, "format(...)");
                    C4148a.d(TAG, str3, false, 4, null);
                    FeishuCliRepository.G(FeishuCliRepository.INSTANCE, null, null, 3, null);
                    return true;
                }
            } else if (value.equals("done")) {
                kotlin.jvm.internal.y yVar4 = kotlin.jvm.internal.y.f34840a;
                String str4 = String.format("%s intercepted: server.nextAction.type=done, nothing to do", Arrays.copyOf(new Object[]{callerTag}, 1));
                kotlin.jvm.internal.p.h(str4, "format(...)");
                C4148a.d(TAG, str4, false, 4, null);
                return true;
            }
        }
        return false;
    }

    public final boolean s0(String url) {
        Object objB;
        Object objB2;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        PackageManager packageManager = getPackageManager();
        for (String str : C1173v.p(C2309e.PKG_FEISHU, C2309e.PKG_LARK)) {
            Intent intent2 = new Intent(intent).setPackage(str);
            kotlin.jvm.internal.p.h(intent2, "setPackage(...)");
            if (packageManager.resolveActivity(intent2, 0) != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    startActivity(intent2);
                    objB2 = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB2);
                if (thE != null) {
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                    String str2 = String.format("launchUrlInFeishu pkg=%s failed", Arrays.copyOf(new Object[]{str}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    C4148a.g(TAG, str2, thE, false, 8, null);
                }
                return Result.h(objB2);
            }
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
            String str3 = String.format("launchUrlInFeishu pkg=%s cannot resolve url, try next", Arrays.copyOf(new Object[]{str}, 1));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.d(TAG, str3, false, 4, null);
        }
        C4148a.u(TAG, "launchUrlInFeishu no feishu/lark handler, fallback to ACTION_VIEW (browser)", false, 4, null);
        try {
            Result.Companion companion3 = Result.INSTANCE;
            startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        return Result.h(objB);
    }

    public final void s1() {
        kotlinx.coroutines.g gVar = this.statusPollingJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.statusPollingJob = C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$startStatusPolling$1(this, null), 3, null);
    }

    public final void t0() {
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$observeDebugLog$1(this, null), 3, null);
    }

    public final void t1(String serverStatus) {
        h0 h0VarN0 = n0();
        FakeFeishuConnector fakeFeishuConnector = h0VarN0 instanceof FakeFeishuConnector ? (FakeFeishuConnector) h0VarN0 : null;
        if (fakeFeishuConnector == null) {
            return;
        }
        if (!fakeFeishuConnector.n(serverStatus)) {
            if (this.lastRenderedState instanceof AbstractC2306b.Connected) {
                Y0();
            }
        } else {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("syncFromServerStatus changed state -> %s, re-render", Arrays.copyOf(new Object[]{fakeFeishuConnector.getState()}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            S0(fakeFeishuConnector.getState());
        }
    }

    public final void u0() {
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$observeFeishuCancelling$1(this, null), 3, null);
    }

    public final void u1(AbstractC2306b prev, AbstractC2306b state) {
        if (kotlin.jvm.internal.p.d(prev, state)) {
            return;
        }
        Pair pairA = state instanceof AbstractC2306b.Failed ? Y8.j.a(m0(((AbstractC2306b.Failed) state).getStage()), com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.c().getValue()) : kotlin.jvm.internal.p.d(state, AbstractC2306b.a.INSTANCE) ? Y8.j.a("authorize", "local.checking_auth_timeout") : kotlin.jvm.internal.p.d(state, AbstractC2306b.j.INSTANCE) ? Y8.j.a(W4.b.STEP_INSTALL, "local.install_network_unavailable") : null;
        if (pairA != null) {
            W4.b bVar = W4.b.INSTANCE;
            bVar.e(W4.b.TOOL_FEISHU, (String) pairA.e(), W4.b.PAGE_FAIL_PAGE);
            bVar.f(W4.b.TOOL_FEISHU, (String) pairA.e(), "fail", (String) pairA.f(), v1(this));
            return;
        }
        if (state instanceof AbstractC2306b.Connected) {
            String str = this.lastStep;
            if (str != null) {
                W4.b.INSTANCE.f(W4.b.TOOL_FEISHU, str, "success", null, v1(this));
            }
            this.lastStep = null;
            W4.b.INSTANCE.g(W4.b.TOOL_FEISHU, this.enteredFromInitialConnected ? W4.b.ENTRY_MARKET_CLICK : W4.b.ENTRY_CONNECTION_SUCCESS);
            return;
        }
        String strL0 = l0(state);
        if (strL0 == null || kotlin.jvm.internal.p.d(strL0, this.lastStep)) {
            return;
        }
        String str2 = this.lastStep;
        if (str2 != null) {
            W4.b.INSTANCE.f(W4.b.TOOL_FEISHU, str2, "success", null, v1(this));
        }
        this.lastStep = strL0;
        this.currentStepStartMs = SystemClock.elapsedRealtime();
        W4.b.INSTANCE.e(W4.b.TOOL_FEISHU, strL0, "normal");
    }

    public final void v0() {
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$observeFeishuToggling$1(this, null), 3, null);
    }

    public final void w0() {
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$observeNetworkFailure$1(this, null), 3, null);
    }

    public final void x0() {
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$observeServerStatus$1(this, null), 3, null);
        C1060i.d(C1398p.a(this), null, null, new FeishuConnectActivity$observeServerStatus$2(this, null), 3, null);
    }

    public final void y0() {
        W4.b bVar = W4.b.INSTANCE;
        String strK0 = k0();
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j jVar = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE;
        bVar.c(W4.b.TOOL_FEISHU, strK0, "terminate", jVar.i().getValue());
        String value = jVar.j().getValue();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onAbortLinkClicked taskId=%s state=%s", Arrays.copyOf(new Object[]{value, n0().getState()}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (value == null || La.H.x0(value)) {
            C4148a.u(TAG, "abort skipped: no taskId yet", false, 4, null);
        } else {
            com.stepos.ailauncher.container.dialog.f.r(this, getString(R$string.feishu_cli_abort_dialog_title), getString(R$string.feishu_cli_abort_dialog_desc), getString(R$string.feishu_cli_abort_dialog_cancel), getString(R$string.feishu_cli_abort_dialog_confirm), 0, new Consumer() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.w
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    FeishuConnectActivity.z0((DialogInterface) obj);
                }
            }, null);
        }
    }
}
