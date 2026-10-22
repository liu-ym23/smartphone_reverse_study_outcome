package com.stepos.ailauncher.agent.aispace.skill.wecom;

import Ua.C1060i;
import Z8.C1173v;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ActionMode;
import android.view.C1398p;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.google.zxing.WriterException;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask;
import com.stepos.ailauncher.agent.aispace.skill.feishu.r0;
import com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectActivity;
import com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.zyql.ai.selector.config.PictureMimeType;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 l2\u00020\u0001:\u0002mnB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u001b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u001bH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u0017\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0011H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0011H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0003J\u0019\u00103\u001a\u0004\u0018\u00010\u00112\u0006\u00102\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0011H\u0002¢\u0006\u0004\b7\u0010,J\u001f\u0010:\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u000bH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b?\u0010>J\u0017\u0010@\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b@\u0010>J/\u0010H\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020C2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010\u0003J5\u0010P\u001a\u00020O2\u0006\u0010K\u001a\u00020\u001b2\b\b\u0002\u0010L\u001a\u00020\u001b2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060MH\u0002¢\u0006\u0004\bP\u0010QJ\u0015\u0010T\u001a\b\u0012\u0004\u0012\u00020S0RH\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0006H\u0002¢\u0006\u0004\bV\u0010\u0003J\u0017\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020SH\u0002¢\u0006\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010f\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010bR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010HR\u0018\u0010k\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010_¨\u0006o"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "L0", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "R0", "()Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "q0", "j0", "T0", "", "newText", "X", "(Ljava/lang/String;)V", "V0", "l0", "k0", "U0", "W0", "Y", "", "f0", "()Z", "m0", "n0", "serverStatus", "h0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "i0", "cancelling", ExifInterface.LONGITUDE_WEST, "(Z)V", "P0", "callerTag", "e0", "(Ljava/lang/String;)Z", "b0", "()Ljava/lang/String;", "t0", "r0", "s0", "o0", "u0", "s", "b1", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;)Ljava/lang/String;", SdCardDbCreator.FIELD_LASTLOC_ID, "(Ljava/lang/String;)Ljava/lang/String;", "Z0", "prev", VoiceWakeupReceiver.EXTRA_STATE, "X0", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;)V", "newState", "S0", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;)V", "M0", "Q0", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectActivity$StepDot;", "dot", "Landroid/view/View;", "bg", "check", "Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;", ChatTracker.PREVIEW_LOADING, "Z", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectActivity$StepDot;Landroid/view/View;Landroid/view/View;Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;)V", "N0", "checked", x5.d.EXTRA_ENABLED, "Lkotlin/Function1;", "onCheckChange", "Landroid/widget/FrameLayout;", "c0", "(ZZLp9/l;)Landroid/widget/FrameLayout;", "", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "a0", "()Ljava/util/List;", "g0", "task", "J0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;)V", "LY4/k;", "binding", "LY4/k;", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "pendingDebugLogText", "Ljava/lang/String;", "Lkotlinx/coroutines/g;", "autoTransitionJob", "Lkotlinx/coroutines/g;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "recommendedAdapter", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "qrExpireTickJob", "", "currentStepStartMs", "J", "enteredConnectedFromInitial", "lastStep", "Companion", "StepDot", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WecomConnectActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_INITIAL_STATUS = "extra_initial_status";
    private static final long STATUS_POLL_INTERVAL_MS = 5000;
    private static final String TAG = "AILauncher-WecomConn";
    private kotlinx.coroutines.g autoTransitionJob;
    private Y4.k binding;
    private long currentStepStartMs;
    private boolean enteredConnectedFromInitial;
    private String lastStep;
    private String pendingDebugLogText;
    private kotlinx.coroutines.g qrExpireTickJob;
    private WecomConnectState state = WecomConnectState.Idle;
    private final r0 recommendedAdapter = new r0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.g
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return WecomConnectActivity.K0(this.f24307a, (RecommendedTask) obj);
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectActivity$StepDot;", "", "<init>", "(Ljava/lang/String;I)V", "DONE", "LOADING", "PENDING", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class StepDot {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ StepDot[] $VALUES;
        public static final StepDot DONE = new StepDot("DONE", 0);
        public static final StepDot LOADING = new StepDot("LOADING", 1);
        public static final StepDot PENDING = new StepDot("PENDING", 2);

        private static final /* synthetic */ StepDot[] $values() {
            return new StepDot[]{DONE, LOADING, PENDING};
        }

        static {
            StepDot[] stepDotArr$values = $values();
            $VALUES = stepDotArr$values;
            $ENTRIES = kotlin.enums.a.a(stepDotArr$values);
        }

        private StepDot(String str, int i10) {
        }

        public static InterfaceC4149a<StepDot> getEntries() {
            return $ENTRIES;
        }

        public static StepDot valueOf(String str) {
            return (StepDot) Enum.valueOf(StepDot.class, str);
        }

        public static StepDot[] values() {
            return (StepDot[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "initialStatus", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/agent/skill/SkillStatus;)V", "", "TAG", "Ljava/lang/String;", "", "STATUS_POLL_INTERVAL_MS", "J", "EXTRA_INITIAL_STATUS", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context, SkillStatus initialStatus) {
            kotlin.jvm.internal.p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) WecomConnectActivity.class);
            if (initialStatus != null) {
                intent.putExtra(WecomConnectActivity.EXTRA_INITIAL_STATUS, initialStatus.name());
            }
            b5.i.INSTANCE.a(context, intent);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.INSTALLED_ENABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.INSTALLED_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WecomConnectState.values().length];
            try {
                iArr2[WecomConnectState.Installing.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[WecomConnectState.InstallFailedNetwork.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[WecomConnectState.Qr.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[WecomConnectState.WaitingScan.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[WecomConnectState.WaitingOperation.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[WecomConnectState.Reviewing.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[WecomConnectState.Connecting.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[WecomConnectState.InstallFailedGeneric.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[WecomConnectState.Idle.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[WecomConnectState.Connected.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[StepDot.values().length];
            try {
                iArr3[StepDot.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[StepDot.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[StepDot.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ#\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectActivity$c", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", ChatTracker.TOPBAR_MENU, "", "onCreateActionMode", "(Landroid/view/ActionMode;Landroid/view/Menu;)Z", "onPrepareActionMode", "Landroid/view/MenuItem;", "item", "onActionItemClicked", "(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z", "LY8/t;", "onDestroyActionMode", "(Landroid/view/ActionMode;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements ActionMode.Callback {
        final /* synthetic */ TextView $tv;

        public c(TextView textView) {
            this.$tv = textView;
        }

        public static final void b(TextView textView, String str) {
            textView.setText(str);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            final String str = WecomConnectActivity.this.pendingDebugLogText;
            if (str == null) {
                return;
            }
            WecomConnectActivity.this.pendingDebugLogText = null;
            final TextView textView = this.$tv;
            textView.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.u
                @Override // java.lang.Runnable
                public final void run() {
                    WecomConnectActivity.c.b(textView, str);
                }
            });
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(View view) {
        com.stepos.ailauncher.agent.aispace.skill.wecom.net.i.INSTANCE.c();
    }

    public static final void B0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.q0();
    }

    public static final void C0(WecomConnectActivity wecomConnectActivity, View view) throws WriterException {
        wecomConnectActivity.t0();
    }

    public static final void D0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.r0();
    }

    public static final void E0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.S0(WecomConnectState.Qr);
    }

    public static final void F0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.s0();
    }

    public static final void G0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.o0();
    }

    public static final void H0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.u0();
    }

    public static final void I0(View view) {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_WECOM, W4.b.STEP_SCAN_QR, "reconnect", null, 8, null);
        C4148a.d(TAG, "click QR refresh -> retry", false, 4, null);
        WecomCliRepository.E(WecomCliRepository.INSTANCE, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void J0(com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getId()
            java.lang.String r1 = "wecom_vipcase_"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = La.D.X(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L34
            W4.b r0 = W4.b.INSTANCE
            java.lang.String r5 = r9.getId()
            java.lang.String r6 = r9.getTitle()
            java.lang.String r7 = r9.getId()
            java.lang.String r1 = La.H.R0(r7, r1)
            java.lang.Integer r1 = La.C.w(r1)
            if (r1 == 0) goto L2d
            int r1 = r1.intValue()
            goto L2e
        L2d:
            r1 = -1
        L2e:
            java.lang.String r7 = "wecom"
            r0.i(r7, r5, r6, r1)
        L34:
            com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository r0 = com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository.INSTANCE
            Xa.t r0 = r0.y()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "connected"
            boolean r1 = kotlin.jvm.internal.p.d(r0, r1)
            java.lang.String r5 = "format(...)"
            java.lang.String r6 = "AILauncher-WecomConn"
            if (r1 != 0) goto L74
            kotlin.jvm.internal.y r9 = kotlin.jvm.internal.y.f34840a
            com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState r9 = r8.state
            java.lang.Object[] r9 = new java.lang.Object[]{r0, r9}
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r3)
            java.lang.String r0 = "recommended task blocked: serverStatus=%s state=%s"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            kotlin.jvm.internal.p.h(r9, r5)
            r0 = 4
            h8.C4148a.d(r6, r9, r2, r0, r4)
            int r9 = com.stepos.ailauncher.agent.R$string.wecom_cli_disabled_chat_blocked
            java.lang.String r9 = r8.getString(r9)
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r9, r2)
            r8.show()
            return
        L74:
            java.lang.String r0 = r9.getPrompt()
            if (r0 == 0) goto L83
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L81
            r4 = r0
        L81:
            if (r4 != 0) goto L87
        L83:
            java.lang.String r4 = r9.getTitle()
        L87:
            kotlin.jvm.internal.y r9 = kotlin.jvm.internal.y.f34840a
            java.lang.Object[] r9 = new java.lang.Object[]{r4}
            r0 = 1
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            java.lang.String r1 = "onRecommendedTaskClicked wake prompt=%s"
            java.lang.String r9 = java.lang.String.format(r1, r9)
            kotlin.jvm.internal.p.h(r9, r5)
            h8.C4148a.c(r6, r9, r0)
            com.stepos.ailauncher.chat.wake.WakeService$Companion r9 = com.stepos.ailauncher.chat.wake.WakeService.INSTANCE
            r9.M1(r8, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectActivity.J0(com.stepos.ailauncher.agent.aispace.skill.feishu.p0):void");
    }

    public static final Y8.t K0(WecomConnectActivity wecomConnectActivity, RecommendedTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("recommended task clicked id=%s title=%s", Arrays.copyOf(new Object[]{task.getId(), task.getTitle()}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        wecomConnectActivity.J0(task);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0() {
        WecomCliRepository wecomCliRepository = WecomCliRepository.INSTANCE;
        boolean zBooleanValue = wecomCliRepository.A().getValue().booleanValue();
        boolean zBooleanValue2 = wecomCliRepository.B().getValue().booleanValue();
        boolean zD = (zBooleanValue || zBooleanValue2) ? true : kotlin.jvm.internal.p.d(wecomCliRepository.y().getValue(), "connected");
        boolean z10 = (zBooleanValue || zBooleanValue2) ? false : true;
        Y4.k kVar = this.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.connectedActionArea.removeAllViews();
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            kVar2 = kVar3;
        }
        kVar2.connectedActionArea.addView(c0(zD, z10, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WecomConnectActivity.O0(((Boolean) obj).booleanValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t O0(boolean z10) {
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("connected switch click desired=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(z10)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (z10) {
            WecomCliRepository.t(WecomCliRepository.INSTANCE, null, 1, null);
        } else {
            WecomCliRepository.r(WecomCliRepository.INSTANCE, null, 1, null);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(boolean cancelling) {
        Y4.k kVar = this.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.ivTopUninstall.setVisibility(cancelling ? 8 : 0);
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.pbTopUninstall.setVisibility(cancelling ? 0 : 8);
        Y4.k kVar4 = this.binding;
        if (kVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar4 = null;
        }
        kVar4.btnTopUninstall.setBackground(cancelling ? null : androidx.core.content.a.e(this, R$drawable.bg_skill_detail_uninstall_top));
        Y4.k kVar5 = this.binding;
        if (kVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar5 = null;
        }
        kVar5.btnTopUninstall.setEnabled(!cancelling);
        Y4.k kVar6 = this.binding;
        if (kVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar6 = null;
        }
        kVar6.btnTopUninstall.setClickable(!cancelling);
        Y4.k kVar7 = this.binding;
        if (kVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar7 = null;
        }
        kVar7.tvAbortLink.setVisibility(cancelling ? 8 : 0);
        Y4.k kVar8 = this.binding;
        if (kVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar8 = null;
        }
        kVar8.pbAbortLink.setVisibility(cancelling ? 0 : 8);
        Y4.k kVar9 = this.binding;
        if (kVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar9 = null;
        }
        kVar9.btnAbortLink.setEnabled(!cancelling);
        Y4.k kVar10 = this.binding;
        if (kVar10 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            kVar2 = kVar10;
        }
        kVar2.btnAbortLink.setClickable(!cancelling);
    }

    public static final Long Y0(WecomConnectActivity wecomConnectActivity) {
        if (wecomConnectActivity.currentStepStartMs > 0) {
            return Long.valueOf(SystemClock.elapsedRealtime() - wecomConnectActivity.currentStepStartMs);
        }
        return null;
    }

    private final FrameLayout c0(final boolean checked, boolean enabled, final InterfaceC5074l<? super Boolean, Y8.t> onCheckChange) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(this, R$color.feishu_brand);
        int iC2 = androidx.core.content.a.c(this, R$color.feishu_step_dot_pending);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i12, i12);
        layoutParams.gravity = (checked ? 8388613 : 8388611) | 16;
        layoutParams.setMarginStart(i13);
        layoutParams.setMarginEnd(i13);
        Y8.t tVar = Y8.t.f7040a;
        frameLayout.addView(view, layoutParams);
        frameLayout.setClickable(enabled);
        frameLayout.setAlpha(enabled ? 1.0f : 0.4f);
        if (enabled) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WecomConnectActivity.d0(onCheckChange, checked, view2);
                }
            });
        }
        return frameLayout;
    }

    public static final void d0(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    public static final void p0(DialogInterface dialogInterface) {
        WecomCliRepository.m(WecomCliRepository.INSTANCE, null, null, 3, null);
    }

    public static final void v0(DialogInterface dialogInterface) {
        WecomCliRepository.m(WecomCliRepository.INSTANCE, null, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 w0(View v10, a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        v10.setPadding(eVarF.f41977a, eVarF.f41978b, eVarF.f41979c, eVarF.f41980d);
        return insets;
    }

    public static final void x0(WecomConnectActivity wecomConnectActivity, View view) {
        wecomConnectActivity.finish();
    }

    public static final void y0(WecomConnectActivity wecomConnectActivity, View view) {
        Y4.k kVar = wecomConnectActivity.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        FrameLayout frameLayout = kVar.flWecomDebugLogContainer;
        Y4.k kVar3 = wecomConnectActivity.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            kVar2 = kVar3;
        }
        frameLayout.setVisibility(kVar2.flWecomDebugLogContainer.getVisibility() == 0 ? 8 : 0);
    }

    public static final void z0(WecomConnectActivity wecomConnectActivity, View view) {
        Y4.k kVar = wecomConnectActivity.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.flWecomDebugLogContainer.setVisibility(8);
    }

    public final void L0() {
        WecomConnectState wecomConnectState;
        String value = WecomCliRepository.INSTANCE.y().getValue();
        WecomConnectState wecomConnectStateH0 = h0(value);
        if (wecomConnectStateH0 == null || (wecomConnectState = this.state) == wecomConnectStateH0) {
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("reconcile cached status=%s → setState %s (was %s)", Arrays.copyOf(new Object[]{value, wecomConnectStateH0, wecomConnectState}, 3));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        S0(wecomConnectStateH0);
    }

    public final void M0(WecomConnectState state) {
        Y4.k kVar = this.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.groupIdle.setVisibility(8);
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.groupInstalling.setVisibility(8);
        Y4.k kVar4 = this.binding;
        if (kVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar4 = null;
        }
        kVar4.groupQr.setVisibility(8);
        Y4.k kVar5 = this.binding;
        if (kVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar5 = null;
        }
        kVar5.groupConnected.setVisibility(8);
        Y4.k kVar6 = this.binding;
        if (kVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar6 = null;
        }
        kVar6.groupFailed.setVisibility(8);
        Y4.k kVar7 = this.binding;
        if (kVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar7 = null;
        }
        kVar7.btnConnect.setVisibility(8);
        Y4.k kVar8 = this.binding;
        if (kVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar8 = null;
        }
        kVar8.btnSaveQr.setVisibility(8);
        Y4.k kVar9 = this.binding;
        if (kVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar9 = null;
        }
        kVar9.btnICompleted.setVisibility(8);
        Y4.k kVar10 = this.binding;
        if (kVar10 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar10 = null;
        }
        kVar10.btnBackToScan.setVisibility(8);
        Y4.k kVar11 = this.binding;
        if (kVar11 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar11 = null;
        }
        kVar11.btnRetry.setVisibility(8);
        Y4.k kVar12 = this.binding;
        if (kVar12 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar12 = null;
        }
        kVar12.btnAbortLink.setVisibility(8);
        Y4.k kVar13 = this.binding;
        if (kVar13 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar13 = null;
        }
        kVar13.btnTopUninstall.setVisibility(8);
        Y4.k kVar14 = this.binding;
        if (kVar14 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar14 = null;
        }
        kVar14.tvInstallDoneBadge.setVisibility(8);
        W0();
        Y4.k kVar15 = this.binding;
        if (kVar15 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar15 = null;
        }
        kVar15.ivQr.setAlpha(1.0f);
        Y4.k kVar16 = this.binding;
        if (kVar16 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar16 = null;
        }
        kVar16.btnQrRefresh.setVisibility(8);
        Q0(state);
        switch (b.$EnumSwitchMapping$1[state.ordinal()]) {
            case 1:
                Y4.k kVar17 = this.binding;
                if (kVar17 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar17 = null;
                }
                kVar17.groupInstalling.setVisibility(0);
                Y4.k kVar18 = this.binding;
                if (kVar18 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar18 = null;
                }
                kVar18.tvInstallingTitle.setText(getString(R$string.wecom_cli_installing_title));
                Y4.k kVar19 = this.binding;
                if (kVar19 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar19;
                }
                kVar2.tvInstallingSubtitle.setText(getString(R$string.wecom_cli_installing_subtitle));
                return;
            case 2:
                Y4.k kVar20 = this.binding;
                if (kVar20 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar20 = null;
                }
                kVar20.groupFailed.setVisibility(0);
                Y4.k kVar21 = this.binding;
                if (kVar21 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar21 = null;
                }
                kVar21.tvFailTitle.setText(getString(R$string.wecom_cli_fail_network_title));
                Y4.k kVar22 = this.binding;
                if (kVar22 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar22 = null;
                }
                kVar22.tvFailReason.setText(getString(R$string.wecom_cli_fail_network_reason));
                Y4.k kVar23 = this.binding;
                if (kVar23 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar23 = null;
                }
                kVar23.btnRetry.setText(getString(R$string.wecom_cli_retry_install));
                Y4.k kVar24 = this.binding;
                if (kVar24 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar24 = null;
                }
                kVar24.btnRetry.setVisibility(0);
                Y4.k kVar25 = this.binding;
                if (kVar25 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar25;
                }
                kVar2.btnAbortLink.setVisibility(0);
                return;
            case 3:
                Y4.k kVar26 = this.binding;
                if (kVar26 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar26 = null;
                }
                kVar26.groupQr.setVisibility(0);
                Y4.k kVar27 = this.binding;
                if (kVar27 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar27 = null;
                }
                kVar27.btnSaveQr.setVisibility(0);
                Y4.k kVar28 = this.binding;
                if (kVar28 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar28 = null;
                }
                kVar28.btnICompleted.setVisibility(0);
                Y4.k kVar29 = this.binding;
                if (kVar29 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar29;
                }
                kVar2.btnAbortLink.setVisibility(0);
                P0();
                Y();
                U0();
                return;
            case 4:
                Y4.k kVar30 = this.binding;
                if (kVar30 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar30 = null;
                }
                kVar30.groupInstalling.setVisibility(0);
                Y4.k kVar31 = this.binding;
                if (kVar31 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar31 = null;
                }
                kVar31.tvInstallingTitle.setText(getString(R$string.wecom_cli_waiting_scan_title));
                Y4.k kVar32 = this.binding;
                if (kVar32 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar32 = null;
                }
                kVar32.tvInstallingSubtitle.setText(getString(R$string.wecom_cli_waiting_scan_subtitle));
                Y4.k kVar33 = this.binding;
                if (kVar33 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar33 = null;
                }
                kVar33.btnBackToScan.setVisibility(0);
                Y4.k kVar34 = this.binding;
                if (kVar34 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar34;
                }
                kVar2.btnAbortLink.setVisibility(0);
                return;
            case 5:
                Y4.k kVar35 = this.binding;
                if (kVar35 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar35 = null;
                }
                kVar35.groupInstalling.setVisibility(0);
                Y4.k kVar36 = this.binding;
                if (kVar36 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar36 = null;
                }
                kVar36.tvInstallingTitle.setText(getString(R$string.wecom_cli_waiting_operation_title));
                Y4.k kVar37 = this.binding;
                if (kVar37 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar37 = null;
                }
                kVar37.tvInstallingSubtitle.setText(getString(R$string.wecom_cli_waiting_operation_subtitle));
                Y4.k kVar38 = this.binding;
                if (kVar38 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar38;
                }
                kVar2.btnAbortLink.setVisibility(0);
                return;
            case 6:
                Y4.k kVar39 = this.binding;
                if (kVar39 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar39 = null;
                }
                kVar39.groupInstalling.setVisibility(0);
                Y4.k kVar40 = this.binding;
                if (kVar40 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar40 = null;
                }
                kVar40.tvInstallingTitle.setText(getString(R$string.wecom_cli_reviewing_title));
                Y4.k kVar41 = this.binding;
                if (kVar41 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar41 = null;
                }
                kVar41.tvInstallingSubtitle.setText(getString(R$string.wecom_cli_reviewing_subtitle));
                Y4.k kVar42 = this.binding;
                if (kVar42 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar42;
                }
                kVar2.btnAbortLink.setVisibility(0);
                return;
            case 7:
                Y4.k kVar43 = this.binding;
                if (kVar43 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar43 = null;
                }
                kVar43.groupInstalling.setVisibility(0);
                Y4.k kVar44 = this.binding;
                if (kVar44 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar44 = null;
                }
                kVar44.tvInstallingTitle.setText(getString(R$string.wecom_cli_connecting_title));
                Y4.k kVar45 = this.binding;
                if (kVar45 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar45 = null;
                }
                kVar45.tvInstallingSubtitle.setText(getString(R$string.wecom_cli_connecting_subtitle));
                Y4.k kVar46 = this.binding;
                if (kVar46 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar46;
                }
                kVar2.btnAbortLink.setVisibility(0);
                return;
            case 8:
                Y4.k kVar47 = this.binding;
                if (kVar47 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar47 = null;
                }
                kVar47.groupFailed.setVisibility(0);
                String value = WecomCliRepository.INSTANCE.y().getValue();
                Pair pairA = kotlin.jvm.internal.p.d(value, "scan_failed") ? Y8.j.a(Integer.valueOf(R$string.wecom_cli_fail_scan_title), Integer.valueOf(R$string.wecom_cli_fail_scan_reason)) : kotlin.jvm.internal.p.d(value, "connect_failed") ? Y8.j.a(Integer.valueOf(R$string.wecom_cli_fail_connect_title), Integer.valueOf(R$string.wecom_cli_fail_connect_reason)) : Y8.j.a(Integer.valueOf(R$string.wecom_cli_fail_install_title), Integer.valueOf(R$string.wecom_cli_fail_install_reason));
                int iIntValue = ((Number) pairA.a()).intValue();
                int iIntValue2 = ((Number) pairA.b()).intValue();
                Y4.k kVar48 = this.binding;
                if (kVar48 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar48 = null;
                }
                kVar48.tvFailTitle.setText(getString(iIntValue));
                Y4.k kVar49 = this.binding;
                if (kVar49 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar49 = null;
                }
                kVar49.tvFailReason.setText(getString(iIntValue2));
                Y4.k kVar50 = this.binding;
                if (kVar50 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar50 = null;
                }
                kVar50.btnRetry.setText(getString(R$string.wecom_cli_retry_install));
                Y4.k kVar51 = this.binding;
                if (kVar51 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar51 = null;
                }
                kVar51.btnRetry.setVisibility(0);
                Y4.k kVar52 = this.binding;
                if (kVar52 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar52;
                }
                kVar2.btnAbortLink.setVisibility(0);
                return;
            case 9:
                Y4.k kVar53 = this.binding;
                if (kVar53 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar53 = null;
                }
                kVar53.groupIdle.setVisibility(0);
                Y4.k kVar54 = this.binding;
                if (kVar54 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar54;
                }
                kVar2.btnConnect.setVisibility(0);
                return;
            case 10:
                Y4.k kVar55 = this.binding;
                if (kVar55 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    kVar55 = null;
                }
                kVar55.groupConnected.setVisibility(0);
                Y4.k kVar56 = this.binding;
                if (kVar56 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    kVar2 = kVar56;
                }
                kVar2.btnTopUninstall.setVisibility(0);
                N0();
                g0();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void P0() {
        String value = WecomCliRepository.INSTANCE.x().getValue();
        Y4.k kVar = null;
        if (value == null || La.H.x0(value)) {
            Y4.k kVar2 = this.binding;
            if (kVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar2 = null;
            }
            kVar2.ivQr.setImageDrawable(null);
            return;
        }
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            kVar = kVar3;
        }
        kVar.ivQr.setImageBitmap(W.INSTANCE.h(this, value, 660));
    }

    public final void Q0(WecomConnectState state) {
        Triple triple;
        boolean zContains = Z8.Y.j(WecomConnectState.Installing, WecomConnectState.Qr, WecomConnectState.WaitingScan, WecomConnectState.WaitingOperation, WecomConnectState.Reviewing, WecomConnectState.Connecting).contains(state);
        Y4.k kVar = this.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.groupSteps.setVisibility(zContains ? 0 : 8);
        if (zContains) {
            int i10 = b.$EnumSwitchMapping$1[state.ordinal()];
            if (i10 == 1) {
                StepDot stepDot = StepDot.LOADING;
                StepDot stepDot2 = StepDot.PENDING;
                triple = new Triple(stepDot, stepDot2, stepDot2);
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                triple = new Triple(StepDot.DONE, StepDot.LOADING, StepDot.PENDING);
            } else if (i10 == 6 || i10 == 7) {
                StepDot stepDot3 = StepDot.DONE;
                triple = new Triple(stepDot3, stepDot3, StepDot.LOADING);
            } else {
                StepDot stepDot4 = StepDot.PENDING;
                triple = new Triple(stepDot4, stepDot4, stepDot4);
            }
            StepDot stepDot5 = (StepDot) triple.a();
            StepDot stepDot6 = (StepDot) triple.b();
            StepDot stepDot7 = (StepDot) triple.c();
            Y4.k kVar3 = this.binding;
            if (kVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar3 = null;
            }
            View wecomDotStep1Bg = kVar3.wecomDotStep1Bg;
            kotlin.jvm.internal.p.h(wecomDotStep1Bg, "wecomDotStep1Bg");
            Y4.k kVar4 = this.binding;
            if (kVar4 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar4 = null;
            }
            ImageView wecomDotStep1Check = kVar4.wecomDotStep1Check;
            kotlin.jvm.internal.p.h(wecomDotStep1Check, "wecomDotStep1Check");
            Y4.k kVar5 = this.binding;
            if (kVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar5 = null;
            }
            IndeterminateSpinnerView wecomDotStep1Loading = kVar5.wecomDotStep1Loading;
            kotlin.jvm.internal.p.h(wecomDotStep1Loading, "wecomDotStep1Loading");
            Z(stepDot5, wecomDotStep1Bg, wecomDotStep1Check, wecomDotStep1Loading);
            Y4.k kVar6 = this.binding;
            if (kVar6 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar6 = null;
            }
            View wecomDotStep2Bg = kVar6.wecomDotStep2Bg;
            kotlin.jvm.internal.p.h(wecomDotStep2Bg, "wecomDotStep2Bg");
            Y4.k kVar7 = this.binding;
            if (kVar7 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar7 = null;
            }
            ImageView wecomDotStep2Check = kVar7.wecomDotStep2Check;
            kotlin.jvm.internal.p.h(wecomDotStep2Check, "wecomDotStep2Check");
            Y4.k kVar8 = this.binding;
            if (kVar8 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar8 = null;
            }
            IndeterminateSpinnerView wecomDotStep2Loading = kVar8.wecomDotStep2Loading;
            kotlin.jvm.internal.p.h(wecomDotStep2Loading, "wecomDotStep2Loading");
            Z(stepDot6, wecomDotStep2Bg, wecomDotStep2Check, wecomDotStep2Loading);
            Y4.k kVar9 = this.binding;
            if (kVar9 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar9 = null;
            }
            View wecomDotStep3Bg = kVar9.wecomDotStep3Bg;
            kotlin.jvm.internal.p.h(wecomDotStep3Bg, "wecomDotStep3Bg");
            Y4.k kVar10 = this.binding;
            if (kVar10 == null) {
                kotlin.jvm.internal.p.A("binding");
                kVar10 = null;
            }
            ImageView wecomDotStep3Check = kVar10.wecomDotStep3Check;
            kotlin.jvm.internal.p.h(wecomDotStep3Check, "wecomDotStep3Check");
            Y4.k kVar11 = this.binding;
            if (kVar11 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                kVar2 = kVar11;
            }
            IndeterminateSpinnerView wecomDotStep3Loading = kVar2.wecomDotStep3Loading;
            kotlin.jvm.internal.p.h(wecomDotStep3Loading, "wecomDotStep3Loading");
            Z(stepDot7, wecomDotStep3Bg, wecomDotStep3Check, wecomDotStep3Loading);
        }
    }

    public final WecomConnectState R0() {
        String stringExtra;
        Object objB;
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra(EXTRA_INITIAL_STATUS)) == null) {
            return WecomConnectState.Idle;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(SkillStatus.valueOf(stringExtra));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        SkillStatus skillStatus = (SkillStatus) objB;
        if (skillStatus == null) {
            return WecomConnectState.Idle;
        }
        int i10 = b.$EnumSwitchMapping$0[skillStatus.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? WecomConnectState.Connected : WecomConnectState.Idle;
    }

    public final void S0(WecomConnectState newState) {
        WecomConnectState wecomConnectState = this.state;
        kotlinx.coroutines.g gVar = this.autoTransitionJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.autoTransitionJob = null;
        this.state = newState;
        M0(newState);
        X0(wecomConnectState, newState);
    }

    public final void T0() {
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        TextView tvWecomDebugLog = kVar.tvWecomDebugLog;
        kotlin.jvm.internal.p.h(tvWecomDebugLog, "tvWecomDebugLog");
        tvWecomDebugLog.setCustomSelectionActionModeCallback(new c(tvWecomDebugLog));
    }

    public final void U0() {
        kotlinx.coroutines.g gVar = this.qrExpireTickJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.qrExpireTickJob = C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$startQrExpireTick$1(this, null), 3, null);
    }

    public final void V0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$startWecomStatusPolling$1(this, null), 3, null);
    }

    public final void W0() {
        kotlinx.coroutines.g gVar = this.qrExpireTickJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.qrExpireTickJob = null;
    }

    public final void X(String newText) {
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        TextView tvWecomDebugLog = kVar.tvWecomDebugLog;
        kotlin.jvm.internal.p.h(tvWecomDebugLog, "tvWecomDebugLog");
        if (tvWecomDebugLog.hasSelection()) {
            this.pendingDebugLogText = newText;
        } else {
            this.pendingDebugLogText = null;
            tvWecomDebugLog.setText(newText);
        }
    }

    public final void X0(WecomConnectState prev, WecomConnectState state) {
        Pair pairA;
        if (prev == state) {
            return;
        }
        int i10 = b.$EnumSwitchMapping$1[state.ordinal()];
        if (i10 == 2) {
            pairA = Y8.j.a(W4.b.STEP_INSTALL, "network");
        } else if (i10 != 8) {
            pairA = null;
        } else {
            String value = WecomCliRepository.INSTANCE.y().getValue();
            pairA = Y8.j.a(a1(value), value);
        }
        String str = W4.b.PAGE_FAIL_PAGE;
        if (pairA != null) {
            W4.b bVar = W4.b.INSTANCE;
            bVar.e(W4.b.TOOL_WECOM, (String) pairA.e(), W4.b.PAGE_FAIL_PAGE);
            bVar.f(W4.b.TOOL_WECOM, (String) pairA.e(), "fail", (String) pairA.f(), Y0(this));
            return;
        }
        if (state == WecomConnectState.Connected) {
            String str2 = this.lastStep;
            if (str2 != null) {
                W4.b.INSTANCE.f(W4.b.TOOL_WECOM, str2, "success", null, Y0(this));
            }
            this.lastStep = null;
            W4.b.INSTANCE.g(W4.b.TOOL_WECOM, this.enteredConnectedFromInitial ? W4.b.ENTRY_MARKET_CLICK : W4.b.ENTRY_CONNECTION_SUCCESS);
            return;
        }
        String strB1 = b1(state);
        if (strB1 == null || kotlin.jvm.internal.p.d(strB1, this.lastStep)) {
            return;
        }
        String str3 = this.lastStep;
        if (str3 != null) {
            W4.b.INSTANCE.f(W4.b.TOOL_WECOM, str3, "success", null, Y0(this));
        }
        this.lastStep = strB1;
        this.currentStepStartMs = SystemClock.elapsedRealtime();
        if (state != WecomConnectState.Qr || !f0()) {
            str = "normal";
        }
        W4.b.INSTANCE.e(W4.b.TOOL_WECOM, strB1, str);
    }

    public final void Y() {
        boolean zF0 = f0();
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.ivQr.setAlpha(zF0 ? 0.3f : 1.0f);
        Y4.k kVar2 = this.binding;
        if (kVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar2 = null;
        }
        kVar2.btnQrRefresh.setVisibility(zF0 ? 0 : 8);
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.ivQr.setContentDescription(zF0 ? getString(R$string.wecom_cli_qr_expired_hint) : null);
    }

    public final void Z(StepDot dot, View bg, View check, IndeterminateSpinnerView loading) {
        int i10 = b.$EnumSwitchMapping$2[dot.ordinal()];
        if (i10 == 1) {
            bg.setBackgroundResource(R$drawable.bg_feishu_step_dot_finished);
            check.setVisibility(0);
            loading.setVisibility(8);
        } else if (i10 == 2) {
            bg.setBackgroundResource(R$drawable.bg_feishu_step_dot_current);
            check.setVisibility(8);
            loading.setVisibility(0);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            bg.setBackgroundResource(R$drawable.bg_feishu_step_dot_pending);
            check.setVisibility(8);
            loading.setVisibility(8);
        }
    }

    public final String Z0() {
        String strB1 = b1(this.state);
        return strB1 == null ? W4.b.STEP_INSTALL : strB1;
    }

    public final List<RecommendedTask> a0() {
        String string = getString(R$string.wecom_cli_rec_task_1_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        RecommendedTask recommendedTask = new RecommendedTask("wecom_rec_1", string, null, false, null);
        String string2 = getString(R$string.wecom_cli_rec_task_2_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        RecommendedTask recommendedTask2 = new RecommendedTask("wecom_rec_2", string2, null, false, null);
        String string3 = getString(R$string.wecom_cli_rec_task_3_title);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        return C1173v.p(recommendedTask, recommendedTask2, new RecommendedTask("wecom_rec_3", string3, null, false, null));
    }

    public final String a1(String serverStatus) {
        return kotlin.jvm.internal.p.d(serverStatus, "scan_failed") ? W4.b.STEP_SCAN_QR : kotlin.jvm.internal.p.d(serverStatus, "connect_failed") ? W4.b.STEP_CONNECT_CHECK : W4.b.STEP_INSTALL;
    }

    public final String b0() {
        Long value = WecomCliRepository.INSTANCE.w().getValue();
        if (value == null) {
            String string = getString(R$string.wecom_cli_qr_expire_unknown_hint);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        long jLongValue = value.longValue() - SystemClock.elapsedRealtime();
        if (jLongValue <= 0) {
            String string2 = getString(R$string.wecom_cli_qr_expired_hint);
            kotlin.jvm.internal.p.h(string2, "getString(...)");
            return string2;
        }
        int i10 = (int) (jLongValue / 1000);
        int i11 = i10 / 60;
        int i12 = i10 % 60;
        if (i11 >= 1 && i12 == 0) {
            String string3 = getString(R$string.wecom_cli_qr_expire_in_minutes_hint, Integer.valueOf(i11));
            kotlin.jvm.internal.p.h(string3, "getString(...)");
            return string3;
        }
        if (i11 >= 1) {
            String string4 = getString(R$string.wecom_cli_qr_expire_in_min_sec_hint, Integer.valueOf(i11), Integer.valueOf(i12));
            kotlin.jvm.internal.p.h(string4, "getString(...)");
            return string4;
        }
        String string5 = getString(R$string.wecom_cli_qr_expire_in_seconds_hint, Integer.valueOf(i12));
        kotlin.jvm.internal.p.h(string5, "getString(...)");
        return string5;
    }

    public final String b1(WecomConnectState s10) {
        switch (b.$EnumSwitchMapping$1[s10.ordinal()]) {
            case 1:
            case 2:
                return W4.b.STEP_INSTALL;
            case 3:
            case 4:
                return W4.b.STEP_SCAN_QR;
            case 5:
                return "authorize";
            case 6:
                return W4.b.STEP_ADMIN_REVIEW;
            case 7:
                return W4.b.STEP_CONNECT_CHECK;
            case 8:
                return a1(WecomCliRepository.INSTANCE.y().getValue());
            case 9:
            case 10:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean e0(String callerTag) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean z10 = false;
            if (!C2330a.INSTANCE.b(this)) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("%s intercepted: wecom app not installed", Arrays.copyOf(new Object[]{callerTag}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d(TAG, str, false, 4, null);
                new V(this).show();
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
            String str2 = String.format("%s interceptByWecomNotInstalled failed, fall through", Arrays.copyOf(new Object[]{callerTag}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            C4148a.t(TAG, str2, thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean f0() {
        Long value = WecomCliRepository.INSTANCE.w().getValue();
        if (value != null) {
            if (SystemClock.elapsedRealtime() >= value.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final void g0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$loadRecommendedTasks$1(this, null), 3, null);
    }

    public final WecomConnectState h0(String serverStatus) {
        if (serverStatus == null) {
            return null;
        }
        switch (serverStatus.hashCode()) {
            case -2133265345:
                if (!serverStatus.equals("scan_failed")) {
                    return null;
                }
                return WecomConnectState.InstallFailedGeneric;
            case -1695870775:
                if (!serverStatus.equals("verifying")) {
                    return null;
                }
                return WecomConnectState.Connecting;
            case -1381388741:
                if (serverStatus.equals("disconnected")) {
                    return WecomConnectState.Connected;
                }
                return null;
            case -1097329270:
                serverStatus.equals("logout");
                return null;
            case -897628144:
                if (serverStatus.equals("awaiting_scan")) {
                    return WecomConnectState.Qr;
                }
                return null;
            case -775651656:
                if (!serverStatus.equals("connecting")) {
                    return null;
                }
                return WecomConnectState.Connecting;
            case -579210487:
                if (serverStatus.equals("connected")) {
                    return WecomConnectState.Connected;
                }
                return null;
            case 3227604:
                if (serverStatus.equals("idle")) {
                    return WecomConnectState.Idle;
                }
                return null;
            case 716053810:
                if (!serverStatus.equals("connect_failed")) {
                    return null;
                }
                return WecomConnectState.InstallFailedGeneric;
            case 900450407:
                if (serverStatus.equals("installing")) {
                    return WecomConnectState.Installing;
                }
                return null;
            case 1365964641:
                if (!serverStatus.equals("install_failed")) {
                    return null;
                }
                return WecomConnectState.InstallFailedGeneric;
            default:
                return null;
        }
    }

    public final void i0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$observeWecomCancelling$1(this, null), 3, null);
    }

    public final void j0() {
        T0();
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$observeWecomDebugLog$1(this, null), 3, null);
    }

    public final void k0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$observeWecomQrExpire$1(this, null), 3, null);
    }

    public final void l0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$observeWecomQrUrl$1(this, null), 3, null);
    }

    public final void m0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$observeWecomStatus$1(this, null), 3, null);
    }

    public final void n0() {
        C1060i.d(C1398p.a(this), null, null, new WecomConnectActivity$observeWecomToggling$1(this, null), 3, null);
    }

    public final void o0() {
        W4.b.INSTANCE.c(W4.b.TOOL_WECOM, Z0(), "terminate", WecomCliRepository.INSTANCE.y().getValue());
        C4148a.d(TAG, "click 终止连接 / 卸载 -> connect cancel", false, 4, null);
        com.stepos.ailauncher.container.dialog.f.r(this, getString(R$string.wecom_cli_abort_dialog_title), getString(R$string.wecom_cli_abort_dialog_desc), getString(R$string.wecom_cli_abort_dialog_cancel), getString(R$string.wecom_cli_abort_dialog_confirm), 0, new Consumer() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                WecomConnectActivity.p0((DialogInterface) obj);
            }
        }, null);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Y4.k kVarB = Y4.k.b(getLayoutInflater());
        kotlin.jvm.internal.p.h(kVarB, "inflate(...)");
        this.binding = kVarB;
        if (kVarB == null) {
            kotlin.jvm.internal.p.A("binding");
            kVarB = null;
        }
        setContentView(kVarB.root);
        androidx.core.view.Y.b(getWindow(), true);
        androidx.core.view.Y.a(getWindow(), getWindow().getDecorView()).e(false);
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        androidx.core.view.N.u0(kVar.root, new androidx.core.view.A() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.c
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return WecomConnectActivity.w0(view, a0Var);
            }
        });
        Y4.k kVar2 = this.binding;
        if (kVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar2 = null;
        }
        kVar2.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.x0(this.f24312a, view);
            }
        });
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.btnConnect.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.B0(this.f24313a, view);
            }
        });
        Y4.k kVar4 = this.binding;
        if (kVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar4 = null;
        }
        kVar4.btnSaveQr.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws WriterException {
                WecomConnectActivity.C0(this.f24314a, view);
            }
        });
        Y4.k kVar5 = this.binding;
        if (kVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar5 = null;
        }
        kVar5.btnICompleted.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.D0(this.f24315a, view);
            }
        });
        Y4.k kVar6 = this.binding;
        if (kVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar6 = null;
        }
        kVar6.btnBackToScan.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.E0(this.f24316a, view);
            }
        });
        Y4.k kVar7 = this.binding;
        if (kVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar7 = null;
        }
        kVar7.btnRetry.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.F0(this.f24317a, view);
            }
        });
        Y4.k kVar8 = this.binding;
        if (kVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar8 = null;
        }
        kVar8.btnAbortLink.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.G0(this.f24305a, view);
            }
        });
        Y4.k kVar9 = this.binding;
        if (kVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar9 = null;
        }
        kVar9.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.H0(this.f24306a, view);
            }
        });
        Y4.k kVar10 = this.binding;
        if (kVar10 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar10 = null;
        }
        kVar10.btnQrRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.I0(view);
            }
        });
        Y4.k kVar11 = this.binding;
        if (kVar11 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar11 = null;
        }
        kVar11.btnWecomDebugLogToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.y0(this.f24310a, view);
            }
        });
        Y4.k kVar12 = this.binding;
        if (kVar12 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar12 = null;
        }
        kVar12.btnWecomDebugLogClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.z0(this.f24311a, view);
            }
        });
        Y4.k kVar13 = this.binding;
        if (kVar13 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar13 = null;
        }
        kVar13.btnWecomDebugLogClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WecomConnectActivity.A0(view);
            }
        });
        j0();
        l0();
        k0();
        m0();
        n0();
        i0();
        V0();
        Y4.k kVar14 = this.binding;
        if (kVar14 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar14 = null;
        }
        kVar14.wecomDotStep1Loading.setColor(-1);
        Y4.k kVar15 = this.binding;
        if (kVar15 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar15 = null;
        }
        kVar15.wecomDotStep2Loading.setColor(-1);
        Y4.k kVar16 = this.binding;
        if (kVar16 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar16 = null;
        }
        kVar16.wecomDotStep3Loading.setColor(-1);
        Y4.k kVar17 = this.binding;
        if (kVar17 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar17 = null;
        }
        kVar17.pbTopUninstall.setColor(-1);
        Y4.k kVar18 = this.binding;
        if (kVar18 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar18 = null;
        }
        kVar18.pbAbortLink.setColor(-1);
        Y4.k kVar19 = this.binding;
        if (kVar19 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar19 = null;
        }
        kVar19.rvRecommendedTasks.setLayoutManager(new LinearLayoutManager(this));
        Y4.k kVar20 = this.binding;
        if (kVar20 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar20 = null;
        }
        kVar20.rvRecommendedTasks.setAdapter(this.recommendedAdapter);
        WecomConnectState wecomConnectStateR0 = R0();
        this.state = wecomConnectStateR0;
        this.enteredConnectedFromInitial = wecomConnectStateR0 == WecomConnectState.Connected;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onCreate initialState=%s", Arrays.copyOf(new Object[]{wecomConnectStateR0}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        M0(this.state);
        X0(WecomConnectState.Idle, this.state);
        L0();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        kotlinx.coroutines.g gVar = this.autoTransitionJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
    }

    public final void q0() {
        C4148a.d(TAG, "click 开始连接", false, 4, null);
        W4.b.INSTANCE.b(W4.b.TOOL_WECOM);
        this.enteredConnectedFromInitial = false;
        this.lastStep = null;
        if (e0("onClickConnect")) {
            return;
        }
        WecomCliRepository.G(WecomCliRepository.INSTANCE, null, 1, null);
        S0(WecomConnectState.Installing);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        if (r0.equals("connecting") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        if (r0.equals("verifying") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        S0(com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState.Connecting);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r0() {
        /*
            r7 = this;
            W4.b r0 = W4.b.INSTANCE
            r5 = 8
            r6 = 0
            java.lang.String r1 = "wecom"
            java.lang.String r2 = "scan_qr"
            java.lang.String r3 = "done"
            r4 = 0
            W4.b.d(r0, r1, r2, r3, r4, r5, r6)
            com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository r0 = com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository.INSTANCE
            Xa.t r0 = r0.y()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            kotlin.jvm.internal.y r1 = kotlin.jvm.internal.y.f34840a
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[]{r0}
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r2, r1)
            java.lang.String r2 = "click 我已完成 status=%s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            java.lang.String r2 = "format(...)"
            kotlin.jvm.internal.p.h(r1, r2)
            r2 = 4
            r3 = 0
            java.lang.String r4 = "AILauncher-WecomConn"
            r5 = 0
            h8.C4148a.d(r4, r1, r5, r2, r3)
            if (r0 == 0) goto L79
            int r1 = r0.hashCode()
            r2 = -1695870775(0xffffffff9aeb10c9, float:-9.722084E-23)
            if (r1 == r2) goto L69
            r2 = -775651656(0xffffffffd1c47eb8, float:-1.0549245E11)
            if (r1 == r2) goto L60
            r2 = -579210487(0xffffffffdd79f309, float:-1.1256718E18)
            if (r1 == r2) goto L51
            goto L79
        L51:
            java.lang.String r1 = "connected"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L79
        L5a:
            com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState r0 = com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState.Connected
            r7.S0(r0)
            return
        L60:
            java.lang.String r1 = "connecting"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L73
            goto L79
        L69:
            java.lang.String r1 = "verifying"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L73
            goto L79
        L73:
            com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState r0 = com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState.Connecting
            r7.S0(r0)
            return
        L79:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L8a
            com.stepos.ailauncher.agent.aispace.skill.wecom.Y r0 = new com.stepos.ailauncher.agent.aispace.skill.wecom.Y     // Catch: java.lang.Throwable -> L8a
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L8a
            r0.show()     // Catch: java.lang.Throwable -> L8a
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L8a
            goto L96
        L8a:
            r0 = move-exception
            r7 = r0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L96:
            java.lang.Throwable r2 = kotlin.Result.e(r7)
            if (r2 == 0) goto La8
            r4 = 8
            r5 = 0
            java.lang.String r0 = "AILauncher-WecomConn"
            java.lang.String r1 = "show WecomScanNoResultDialog failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        La8:
            kotlin.Result.a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectActivity.r0():void");
    }

    public final void s0() {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_WECOM, Z0(), "reconnect", null, 8, null);
        C4148a.d(TAG, "click 重试 -> connect retry", false, 4, null);
        WecomCliRepository.E(WecomCliRepository.INSTANCE, null, 1, null);
    }

    public final void t0() throws WriterException {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_WECOM, W4.b.STEP_SCAN_QR, W4.b.BTN_SAVE_ALBUM, null, 8, null);
        String value = WecomCliRepository.INSTANCE.x().getValue();
        if (value == null || La.H.x0(value)) {
            Toast.makeText(this, "二维码还没生成，请稍候", 0).show();
            return;
        }
        W w10 = W.INSTANCE;
        String string = getString(R$string.wecom_cli_connected_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.wecom_cli_qr_subtitle);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        Bitmap bitmapC = w10.c(this, value, string, La.D.T(string2, "\n", "", false, 4, null), b0());
        Uri uriI = w10.i(this, bitmapC, "wecom_cli_qr_" + System.currentTimeMillis() + PictureMimeType.PNG);
        bitmapC.recycle();
        String string3 = uriI != null ? getString(R$string.wecom_cli_qr_save_done_toast) : "保存失败";
        kotlin.jvm.internal.p.f(string3);
        Toast.makeText(this, string3, 0).show();
    }

    public final void u0() {
        W4.b.INSTANCE.c(W4.b.TOOL_WECOM, Z0(), "terminate", WecomCliRepository.INSTANCE.y().getValue());
        com.stepos.ailauncher.container.dialog.f.r(this, getString(R$string.wecom_cli_uninstall_dialog_title), getString(R$string.wecom_cli_uninstall_dialog_desc), getString(R$string.wecom_cli_abort_dialog_cancel), getString(R$string.wecom_cli_abort_dialog_confirm), 0, new Consumer() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                WecomConnectActivity.v0((DialogInterface) obj);
            }
        }, null);
    }
}
