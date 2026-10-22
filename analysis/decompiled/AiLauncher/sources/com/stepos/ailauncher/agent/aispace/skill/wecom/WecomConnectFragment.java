package com.stepos.ailauncher.agent.aispace.skill.wecom;

import Ua.C1060i;
import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ActionMode;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.google.zxing.WriterException;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask;
import com.stepos.ailauncher.agent.aispace.skill.feishu.r0;
import com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectFragment;
import com.stepos.ailauncher.agent.aispace.skill.wecom.net.WecomCliRepository;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.container.l0;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import com.zyql.ai.selector.config.PictureMimeType;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.Arrays;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 }2\u00020\u0001:\u0002~\u007fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0003J\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0003J\u001b\u0010(\u001a\u0004\u0018\u00010\u00122\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0003J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\"H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010\u0003J\u0017\u00100\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0018H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0018H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\u0003J\u000f\u00107\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0003J\u001f\u0010;\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u0018H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010>\u001a\u0004\u0018\u00010\u00182\u0006\u0010=\u001a\u00020\u0012H\u0002¢\u0006\u0004\b>\u0010?J\u0019\u0010@\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0018H\u0002¢\u0006\u0004\bB\u00103J\u001f\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0012H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0012H\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u0012H\u0002¢\u0006\u0004\bJ\u0010IJ\u0017\u0010K\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u0012H\u0002¢\u0006\u0004\bK\u0010IJ/\u0010R\u001a\u00020\b2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\bH\u0002¢\u0006\u0004\bT\u0010\u0003J5\u0010Z\u001a\u00020Y2\u0006\u0010U\u001a\u00020\"2\b\b\u0002\u0010V\u001a\u00020\"2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b0WH\u0002¢\u0006\u0004\bZ\u0010[J\u0015\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0002¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\bH\u0002¢\u0006\u0004\b`\u0010\u0003J\u0017\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020]H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u00020\b2\u0006\u0010d\u001a\u00020\u0018H\u0002¢\u0006\u0004\be\u0010\u001bR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010nR\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010kR\u0014\u0010z\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010$R\u0014\u0010|\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b{\u0010$¨\u0006\u0080\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "g0", "", "horizontalPadding", "e0", "(Landroid/view/View;I)V", "R0", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "X0", "()Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "x0", "r0", "Z0", "", "newText", "d0", "(Ljava/lang/String;)V", "d1", "t0", "s0", "c1", "e1", "f0", "", "n0", "()Z", "u0", "v0", "serverStatus", "p0", "(Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "q0", "cancelling", "c0", "(Z)V", "V0", "callerTag", "m0", "(Ljava/lang/String;)Z", "j0", "()Ljava/lang/String;", "A0", "y0", "z0", "w0", "B0", "title", Const.JSON_KEY_DESC, SdCardDbCreator.FIELD_LASTLOC_ID, "(Ljava/lang/String;Ljava/lang/String;)V", "s", "j1", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;)Ljava/lang/String;", "i1", "(Ljava/lang/String;)Ljava/lang/String;", "h1", "prev", VoiceWakeupReceiver.EXTRA_STATE, "f1", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;)V", "newState", "Y0", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;)V", "S0", "W0", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment$StepDot;", "dot", "bg", "check", "Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;", ChatTracker.PREVIEW_LOADING, "h0", "(Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment$StepDot;Landroid/view/View;Landroid/view/View;Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;)V", "T0", "checked", x5.d.EXTRA_ENABLED, "Lkotlin/Function1;", "onCheckChange", "Landroid/widget/FrameLayout;", "k0", "(ZZLp9/l;)Landroid/widget/FrameLayout;", "", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "i0", "()Ljava/util/List;", "o0", "task", "C0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;)V", HighlightArgsBundle.KEY_PROMPT, "P0", "LY4/k;", "binding", "LY4/k;", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectState;", "pendingDebugLogText", "Ljava/lang/String;", "Lkotlinx/coroutines/g;", "autoTransitionJob", "Lkotlinx/coroutines/g;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "recommendedAdapter", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "qrExpireTickJob", "", "currentStepStartMs", "J", "enteredConnectedFromInitial", "Z", "lastStep", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", "StepDot", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WecomConnectFragment extends com.stepos.ailauncher.sheet.nav.a {

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
    private final r0 recommendedAdapter;
    private WecomConnectState state;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment$StepDot;", "", "<init>", "(Ljava/lang/String;I)V", "DONE", "LOADING", "PENDING", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "initialStatus", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Lcom/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment;", "", "TAG", "Ljava/lang/String;", "", "STATUS_POLL_INTERVAL_MS", "J", "EXTRA_INITIAL_STATUS", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final WecomConnectFragment a(SkillStatus initialStatus) {
            WecomConnectFragment wecomConnectFragment = new WecomConnectFragment();
            Bundle bundle = new Bundle();
            if (initialStatus != null) {
                bundle.putString(WecomConnectFragment.EXTRA_INITIAL_STATUS, initialStatus.name());
            }
            wecomConnectFragment.setArguments(bundle);
            return wecomConnectFragment;
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

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ#\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/agent/aispace/skill/wecom/WecomConnectFragment$c", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", ChatTracker.TOPBAR_MENU, "", "onCreateActionMode", "(Landroid/view/ActionMode;Landroid/view/Menu;)Z", "onPrepareActionMode", "Landroid/view/MenuItem;", "item", "onActionItemClicked", "(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z", "LY8/t;", "onDestroyActionMode", "(Landroid/view/ActionMode;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            final String str = WecomConnectFragment.this.pendingDebugLogText;
            if (str == null) {
                return;
            }
            WecomConnectFragment.this.pendingDebugLogText = null;
            final TextView textView = this.$tv;
            textView.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.L
                @Override // java.lang.Runnable
                public final void run() {
                    WecomConnectFragment.c.b(textView, str);
                }
            });
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }
    }

    public WecomConnectFragment() {
        super(R$layout.activity_wecom_connect);
        this.state = WecomConnectState.Idle;
        this.recommendedAdapter = new r0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WecomConnectFragment.Q0(this.f24320a, (RecommendedTask) obj);
            }
        });
    }

    private final void A0() throws WriterException {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_WECOM, W4.b.STEP_SCAN_QR, W4.b.BTN_SAVE_ALBUM, null, 8, null);
        String value = WecomCliRepository.INSTANCE.x().getValue();
        if (value == null || La.H.x0(value)) {
            Toast.makeText(requireContext(), "二维码还没生成，请稍候", 0).show();
            return;
        }
        W w10 = W.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        String string = getString(R$string.wecom_cli_connected_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.wecom_cli_qr_subtitle);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        Bitmap bitmapC = w10.c(contextRequireContext, value, string, La.D.T(string2, "\n", "", false, 4, null), j0());
        String str = "wecom_cli_qr_" + System.currentTimeMillis() + PictureMimeType.PNG;
        Context contextRequireContext2 = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
        Uri uriI = w10.i(contextRequireContext2, bitmapC, str);
        bitmapC.recycle();
        String string3 = uriI != null ? getString(R$string.wecom_cli_qr_save_done_toast) : "保存失败";
        kotlin.jvm.internal.p.f(string3);
        Toast.makeText(requireContext(), string3, 0).show();
    }

    private final void B0() {
        W4.b.INSTANCE.c(W4.b.TOOL_WECOM, h1(), "terminate", WecomCliRepository.INSTANCE.y().getValue());
        String string = getString(R$string.wecom_cli_uninstall_dialog_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.wecom_cli_uninstall_dialog_desc);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        a1(string, string2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void C0(com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask r9) {
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
            r5 = 4
            java.lang.String r6 = "format(...)"
            java.lang.String r7 = "AILauncher-WecomConn"
            if (r1 != 0) goto L78
            kotlin.jvm.internal.y r9 = kotlin.jvm.internal.y.f34840a
            com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState r9 = r8.state
            java.lang.Object[] r9 = new java.lang.Object[]{r0, r9}
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r3)
            java.lang.String r0 = "recommended task blocked: serverStatus=%s state=%s"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            kotlin.jvm.internal.p.h(r9, r6)
            h8.C4148a.d(r7, r9, r2, r5, r4)
            android.content.Context r9 = r8.requireContext()
            int r0 = com.stepos.ailauncher.agent.R$string.wecom_cli_disabled_chat_blocked
            java.lang.String r8 = r8.getString(r0)
            android.widget.Toast r8 = android.widget.Toast.makeText(r9, r8, r2)
            r8.show()
            return
        L78:
            java.lang.String r0 = r9.getPrompt()
            if (r0 == 0) goto L88
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L85
            goto L86
        L85:
            r0 = r4
        L86:
            if (r0 != 0) goto L8c
        L88:
            java.lang.String r0 = r9.getTitle()
        L8c:
            kotlin.jvm.internal.y r9 = kotlin.jvm.internal.y.f34840a
            r9 = 1
            java.lang.Object[] r1 = new java.lang.Object[]{r0}
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r1, r9)
            java.lang.String r1 = "onRecommendedTaskClicked open stacked chat prompt=%s"
            java.lang.String r9 = java.lang.String.format(r1, r9)
            kotlin.jvm.internal.p.h(r9, r6)
            h8.C4148a.d(r7, r9, r2, r5, r4)
            r8.P0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectFragment.C0(com.stepos.ailauncher.agent.aispace.skill.feishu.p0):void");
    }

    public static final void D0(WecomConnectFragment wecomConnectFragment, View view) {
        if (wecomConnectFragment.x()) {
            return;
        }
        wecomConnectFragment.o();
    }

    public static final void E0(WecomConnectFragment wecomConnectFragment, View view) {
        wecomConnectFragment.x0();
    }

    public static final void F0(WecomConnectFragment wecomConnectFragment, View view) {
        Y4.k kVar = wecomConnectFragment.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.flWecomDebugLogContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(View view) {
        com.stepos.ailauncher.agent.aispace.skill.wecom.net.i.INSTANCE.c();
    }

    public static final void H0(WecomConnectFragment wecomConnectFragment, View view) throws WriterException {
        wecomConnectFragment.A0();
    }

    public static final void I0(WecomConnectFragment wecomConnectFragment, View view) {
        wecomConnectFragment.y0();
    }

    public static final void J0(WecomConnectFragment wecomConnectFragment, View view) {
        wecomConnectFragment.Y0(WecomConnectState.Qr);
    }

    public static final void K0(WecomConnectFragment wecomConnectFragment, View view) {
        wecomConnectFragment.z0();
    }

    public static final void L0(WecomConnectFragment wecomConnectFragment, View view) {
        wecomConnectFragment.w0();
    }

    public static final void M0(WecomConnectFragment wecomConnectFragment, View view) {
        wecomConnectFragment.B0();
    }

    public static final void N0(View view) {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_WECOM, W4.b.STEP_SCAN_QR, "reconnect", null, 8, null);
        C4148a.d(TAG, "click QR refresh -> retry", false, 4, null);
        WecomCliRepository.E(WecomCliRepository.INSTANCE, null, 1, null);
    }

    public static final void O0(WecomConnectFragment wecomConnectFragment, View view) {
        Y4.k kVar = wecomConnectFragment.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        FrameLayout frameLayout = kVar.flWecomDebugLogContainer;
        Y4.k kVar3 = wecomConnectFragment.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            kVar2 = kVar3;
        }
        frameLayout.setVisibility(kVar2.flWecomDebugLogContainer.getVisibility() == 0 ? 8 : 0);
    }

    private final void P0(String prompt) {
        if (t() != null && l0.INSTANCE.m(prompt)) {
            o();
            return;
        }
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        C2739j.z(contextRequireContext, prompt, SheetHeightMode.FULL_9, null, null, null, null, 120, null);
    }

    public static final Y8.t Q0(WecomConnectFragment wecomConnectFragment, RecommendedTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("recommended task clicked id=%s title=%s", Arrays.copyOf(new Object[]{task.getId(), task.getTitle()}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        wecomConnectFragment.C0(task);
        return Y8.t.f7040a;
    }

    private final void R0() {
        WecomConnectState wecomConnectState;
        String value = WecomCliRepository.INSTANCE.y().getValue();
        WecomConnectState wecomConnectStateP0 = p0(value);
        if (wecomConnectStateP0 == null || (wecomConnectState = this.state) == wecomConnectStateP0) {
            return;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("reconcile cached status=%s → setState %s (was %s)", Arrays.copyOf(new Object[]{value, wecomConnectStateP0, wecomConnectState}, 3));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        Y0(wecomConnectStateP0);
    }

    private final void S0(WecomConnectState state) {
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
        e1();
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
        W0(state);
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
                V0();
                f0();
                c1();
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
                T0();
                o0();
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0() {
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
        kVar2.connectedActionArea.addView(k0(zD, z10, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WecomConnectFragment.U0(((Boolean) obj).booleanValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t U0(boolean z10) {
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
    public final void V0() {
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
        ImageView imageView = kVar.ivQr;
        W w10 = W.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        imageView.setImageBitmap(w10.h(contextRequireContext, value, 660));
    }

    private final void W0(WecomConnectState state) {
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
            h0(stepDot5, wecomDotStep1Bg, wecomDotStep1Check, wecomDotStep1Loading);
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
            h0(stepDot6, wecomDotStep2Bg, wecomDotStep2Check, wecomDotStep2Loading);
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
            h0(stepDot7, wecomDotStep3Bg, wecomDotStep3Check, wecomDotStep3Loading);
        }
    }

    private final WecomConnectState X0() {
        String string;
        Object objB;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(EXTRA_INITIAL_STATUS)) == null) {
            return WecomConnectState.Idle;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(SkillStatus.valueOf(string));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(WecomConnectState newState) {
        WecomConnectState wecomConnectState = this.state;
        kotlinx.coroutines.g gVar = this.autoTransitionJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.autoTransitionJob = null;
        this.state = newState;
        S0(newState);
        f1(wecomConnectState, newState);
    }

    private final void Z0() {
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        TextView tvWecomDebugLog = kVar.tvWecomDebugLog;
        kotlin.jvm.internal.p.h(tvWecomDebugLog, "tvWecomDebugLog");
        tvWecomDebugLog.setCustomSelectionActionModeCallback(new c(tvWecomDebugLog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t b1() {
        WecomCliRepository.m(WecomCliRepository.INSTANCE, null, null, 3, null);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(boolean cancelling) {
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
        kVar4.btnTopUninstall.setBackground(cancelling ? null : androidx.core.content.a.e(requireContext(), R$drawable.bg_new_session_circle));
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

    private final void c1() {
        kotlinx.coroutines.g gVar = this.qrExpireTickJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.qrExpireTickJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$startQrExpireTick$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(String newText) {
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

    private final void d1() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$startWecomStatusPolling$1(this, null), 3, null);
    }

    private final void e0(View view, int horizontalPadding) {
        view.setPadding(horizontalPadding, view.getPaddingTop(), horizontalPadding, view.getPaddingBottom());
    }

    private final void e1() {
        kotlinx.coroutines.g gVar = this.qrExpireTickJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.qrExpireTickJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        boolean zN0 = n0();
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.ivQr.setAlpha(zN0 ? 0.3f : 1.0f);
        Y4.k kVar2 = this.binding;
        if (kVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar2 = null;
        }
        kVar2.btnQrRefresh.setVisibility(zN0 ? 0 : 8);
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.ivQr.setContentDescription(zN0 ? getString(R$string.wecom_cli_qr_expired_hint) : null);
    }

    private final void f1(WecomConnectState prev, WecomConnectState state) {
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
            pairA = Y8.j.a(i1(value), value);
        }
        String str = W4.b.PAGE_FAIL_PAGE;
        if (pairA != null) {
            W4.b bVar = W4.b.INSTANCE;
            bVar.e(W4.b.TOOL_WECOM, (String) pairA.e(), W4.b.PAGE_FAIL_PAGE);
            bVar.f(W4.b.TOOL_WECOM, (String) pairA.e(), "fail", (String) pairA.f(), g1(this));
            return;
        }
        if (state == WecomConnectState.Connected) {
            String str2 = this.lastStep;
            if (str2 != null) {
                W4.b.INSTANCE.f(W4.b.TOOL_WECOM, str2, "success", null, g1(this));
            }
            this.lastStep = null;
            W4.b.INSTANCE.g(W4.b.TOOL_WECOM, this.enteredConnectedFromInitial ? W4.b.ENTRY_MARKET_CLICK : W4.b.ENTRY_CONNECTION_SUCCESS);
            return;
        }
        String strJ1 = j1(state);
        if (strJ1 == null || kotlin.jvm.internal.p.d(strJ1, this.lastStep)) {
            return;
        }
        String str3 = this.lastStep;
        if (str3 != null) {
            W4.b.INSTANCE.f(W4.b.TOOL_WECOM, str3, "success", null, g1(this));
        }
        this.lastStep = strJ1;
        this.currentStepStartMs = SystemClock.elapsedRealtime();
        if (state != WecomConnectState.Qr || !n0()) {
            str = "normal";
        }
        W4.b.INSTANCE.e(W4.b.TOOL_WECOM, strJ1, str);
    }

    private final void g0() throws Resources.NotFoundException {
        Y4.k kVar = this.binding;
        Y4.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        kVar.root.setBackgroundColor(-15658735);
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.root.setFitsSystemWindows(false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_padding_h);
        Y4.k kVar4 = this.binding;
        if (kVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar4 = null;
        }
        LinearLayout groupInstalling = kVar4.groupInstalling;
        kotlin.jvm.internal.p.h(groupInstalling, "groupInstalling");
        e0(groupInstalling, dimensionPixelSize);
        Y4.k kVar5 = this.binding;
        if (kVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar5 = null;
        }
        LinearLayout groupQr = kVar5.groupQr;
        kotlin.jvm.internal.p.h(groupQr, "groupQr");
        e0(groupQr, dimensionPixelSize);
        Y4.k kVar6 = this.binding;
        if (kVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar6 = null;
        }
        LinearLayout groupConnected = kVar6.groupConnected;
        kotlin.jvm.internal.p.h(groupConnected, "groupConnected");
        e0(groupConnected, dimensionPixelSize);
        Y4.k kVar7 = this.binding;
        if (kVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            kVar2 = kVar7;
        }
        LinearLayout groupFailed = kVar2.groupFailed;
        kotlin.jvm.internal.p.h(groupFailed, "groupFailed");
        e0(groupFailed, dimensionPixelSize);
    }

    public static final Long g1(WecomConnectFragment wecomConnectFragment) {
        if (wecomConnectFragment.currentStepStartMs > 0) {
            return Long.valueOf(SystemClock.elapsedRealtime() - wecomConnectFragment.currentStepStartMs);
        }
        return null;
    }

    private final String h1() {
        String strJ1 = j1(this.state);
        return strJ1 == null ? W4.b.STEP_INSTALL : strJ1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RecommendedTask> i0() {
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

    private final String i1(String serverStatus) {
        return kotlin.jvm.internal.p.d(serverStatus, "scan_failed") ? W4.b.STEP_SCAN_QR : kotlin.jvm.internal.p.d(serverStatus, "connect_failed") ? W4.b.STEP_CONNECT_CHECK : W4.b.STEP_INSTALL;
    }

    private final String j0() {
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

    private final String j1(WecomConnectState s10) {
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
                return i1(WecomCliRepository.INSTANCE.y().getValue());
            case 9:
            case 10:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final FrameLayout k0(final boolean checked, boolean enabled, final InterfaceC5074l<? super Boolean, Y8.t> onCheckChange) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(requireContext(), R$color.feishu_brand);
        int iC2 = androidx.core.content.a.c(requireContext(), R$color.feishu_step_dot_pending);
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i11 / 2.0f);
        if (!checked) {
            iC = iC2;
        }
        gradientDrawable.setColor(iC);
        frameLayout.setBackground(gradientDrawable);
        View view = new View(requireContext());
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
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.B
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WecomConnectFragment.l0(onCheckChange, checked, view2);
                }
            });
        }
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    private final boolean m0(String callerTag) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            C2330a c2330a = C2330a.INSTANCE;
            Context contextRequireContext = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
            boolean zB = c2330a.b(contextRequireContext);
            boolean z10 = false;
            if (!zB) {
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str = String.format("%s intercepted: wecom app not installed", Arrays.copyOf(new Object[]{callerTag}, 1));
                kotlin.jvm.internal.p.h(str, "format(...)");
                C4148a.d(TAG, str, false, 4, null);
                Context contextRequireContext2 = requireContext();
                kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
                new V(contextRequireContext2).show();
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

    private final boolean n0() {
        Long value = WecomCliRepository.INSTANCE.w().getValue();
        if (value != null) {
            if (SystemClock.elapsedRealtime() >= value.longValue()) {
                return true;
            }
        }
        return false;
    }

    private final void o0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$loadRecommendedTasks$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WecomConnectState p0(String serverStatus) {
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

    private final void q0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$observeWecomCancelling$1(this, null), 3, null);
    }

    private final void r0() {
        Z0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$observeWecomDebugLog$1(this, null), 3, null);
    }

    private final void s0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$observeWecomQrExpire$1(this, null), 3, null);
    }

    private final void t0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$observeWecomQrUrl$1(this, null), 3, null);
    }

    private final void u0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$observeWecomStatus$1(this, null), 3, null);
    }

    private final void v0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new WecomConnectFragment$observeWecomToggling$1(this, null), 3, null);
    }

    private final void w0() {
        W4.b.INSTANCE.c(W4.b.TOOL_WECOM, h1(), "terminate", WecomCliRepository.INSTANCE.y().getValue());
        C4148a.d(TAG, "click 终止连接 / 卸载 -> connect cancel", false, 4, null);
        String string = getString(R$string.wecom_cli_abort_dialog_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.wecom_cli_abort_dialog_desc);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        a1(string, string2);
    }

    private final void x0() {
        C4148a.d(TAG, "click 开始连接", false, 4, null);
        W4.b.INSTANCE.b(W4.b.TOOL_WECOM);
        this.enteredConnectedFromInitial = false;
        this.lastStep = null;
        if (m0("onClickConnect")) {
            return;
        }
        WecomCliRepository.G(WecomCliRepository.INSTANCE, null, 1, null);
        Y0(WecomConnectState.Installing);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        if (r0.equals("connecting") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        if (r0.equals("verifying") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        Y0(com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectState.Connecting);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void y0() {
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
            r7.Y0(r0)
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
            r7.Y0(r0)
            return
        L79:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L94
            com.stepos.ailauncher.agent.aispace.skill.wecom.Y r0 = new com.stepos.ailauncher.agent.aispace.skill.wecom.Y     // Catch: java.lang.Throwable -> L94
            android.content.Context r7 = r7.requireContext()     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.p.h(r7, r1)     // Catch: java.lang.Throwable -> L94
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L94
            r0.show()     // Catch: java.lang.Throwable -> L94
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L94
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L94
            goto La0
        L94:
            r0 = move-exception
            r7 = r0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        La0:
            java.lang.Throwable r2 = kotlin.Result.e(r7)
            if (r2 == 0) goto Lb2
            r4 = 8
            r5 = 0
            java.lang.String r0 = "AILauncher-WecomConn"
            java.lang.String r1 = "show WecomScanNoResultDialog failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
        Lb2:
            kotlin.Result.a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.wecom.WecomConnectFragment.y0():void");
    }

    private final void z0() {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_WECOM, h1(), "reconnect", null, 8, null);
        C4148a.d(TAG, "click 重试 -> connect retry", false, 4, null);
        WecomCliRepository.E(WecomCliRepository.INSTANCE, null, 1, null);
    }

    public final void a1(String title, String desc) {
        if (!isAdded() || getView() == null) {
            WecomCliRepository.m(WecomCliRepository.INSTANCE, null, null, 3, null);
            return;
        }
        androidx.fragment.app.r rVarRequireActivity = requireActivity();
        kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
        String string = getString(R$string.wecom_cli_abort_dialog_cancel);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.wecom_cli_abort_dialog_confirm);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        if (com.stepos.ailauncher.container.dialog.f.q(new S4.d(rVarRequireActivity, title, desc, string, string2, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WecomConnectFragment.b1();
            }
        }, 32, null), "wecomCancel")) {
            return;
        }
        C4148a.u(TAG, "show cancel confirm dialog failed", false, 4, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    public final void h0(StepDot dot, View bg, View check, IndeterminateSpinnerView loading) {
        int i10 = b.$EnumSwitchMapping$2[dot.ordinal()];
        if (i10 == 1) {
            bg.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_finished);
            check.setVisibility(0);
            loading.setVisibility(8);
        } else if (i10 == 2) {
            bg.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_current);
            check.setVisibility(8);
            loading.setVisibility(0);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            bg.setBackgroundResource(com.stepos.ailauncher.agent.R$drawable.bg_feishu_step_dot_pending);
            check.setVisibility(8);
            loading.setVisibility(8);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        kotlinx.coroutines.g gVar = this.autoTransitionJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Y4.k kVarA = Y4.k.a(view);
        kotlin.jvm.internal.p.h(kVarA, "bind(...)");
        this.binding = kVarA;
        g0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        Y4.k kVar = this.binding;
        if (kVar == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar = null;
        }
        ImageView btnBack = kVar.btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        Y4.k kVar2 = this.binding;
        if (kVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar2 = null;
        }
        FrameLayout btnTopUninstall = kVar2.btnTopUninstall;
        kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
        C2773b6.p(c2773b6, new View[]{btnBack, btnTopUninstall}, null, false, 6, null);
        Y4.k kVar3 = this.binding;
        if (kVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar3 = null;
        }
        kVar3.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.D0(this.f24283a, view2);
            }
        });
        Y4.k kVar4 = this.binding;
        if (kVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar4 = null;
        }
        kVar4.btnConnect.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.F
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.E0(this.f24285a, view2);
            }
        });
        Y4.k kVar5 = this.binding;
        if (kVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar5 = null;
        }
        kVar5.btnSaveQr.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws WriterException {
                WecomConnectFragment.H0(this.f24286a, view2);
            }
        });
        Y4.k kVar6 = this.binding;
        if (kVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar6 = null;
        }
        kVar6.btnICompleted.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.H
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.I0(this.f24287a, view2);
            }
        });
        Y4.k kVar7 = this.binding;
        if (kVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar7 = null;
        }
        kVar7.btnBackToScan.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.J0(this.f24288a, view2);
            }
        });
        Y4.k kVar8 = this.binding;
        if (kVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar8 = null;
        }
        kVar8.btnRetry.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.J
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.K0(this.f24289a, view2);
            }
        });
        Y4.k kVar9 = this.binding;
        if (kVar9 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar9 = null;
        }
        kVar9.btnAbortLink.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.K
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.L0(this.f24290a, view2);
            }
        });
        Y4.k kVar10 = this.binding;
        if (kVar10 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar10 = null;
        }
        kVar10.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.M0(this.f24321a, view2);
            }
        });
        Y4.k kVar11 = this.binding;
        if (kVar11 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar11 = null;
        }
        kVar11.btnQrRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.N0(view2);
            }
        });
        Y4.k kVar12 = this.binding;
        if (kVar12 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar12 = null;
        }
        kVar12.btnWecomDebugLogToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.O0(this.f24322a, view2);
            }
        });
        Y4.k kVar13 = this.binding;
        if (kVar13 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar13 = null;
        }
        kVar13.btnWecomDebugLogClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.F0(this.f24284a, view2);
            }
        });
        Y4.k kVar14 = this.binding;
        if (kVar14 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar14 = null;
        }
        kVar14.btnWecomDebugLogClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WecomConnectFragment.G0(view2);
            }
        });
        r0();
        t0();
        s0();
        u0();
        v0();
        q0();
        d1();
        Y4.k kVar15 = this.binding;
        if (kVar15 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar15 = null;
        }
        kVar15.wecomDotStep1Loading.setColor(-1);
        Y4.k kVar16 = this.binding;
        if (kVar16 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar16 = null;
        }
        kVar16.wecomDotStep2Loading.setColor(-1);
        Y4.k kVar17 = this.binding;
        if (kVar17 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar17 = null;
        }
        kVar17.wecomDotStep3Loading.setColor(-1);
        Y4.k kVar18 = this.binding;
        if (kVar18 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar18 = null;
        }
        kVar18.pbTopUninstall.setColor(-1);
        Y4.k kVar19 = this.binding;
        if (kVar19 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar19 = null;
        }
        kVar19.pbAbortLink.setColor(-1);
        Y4.k kVar20 = this.binding;
        if (kVar20 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar20 = null;
        }
        kVar20.rvRecommendedTasks.setLayoutManager(new LinearLayoutManager(requireContext()));
        Y4.k kVar21 = this.binding;
        if (kVar21 == null) {
            kotlin.jvm.internal.p.A("binding");
            kVar21 = null;
        }
        kVar21.rvRecommendedTasks.setAdapter(this.recommendedAdapter);
        WecomConnectState wecomConnectStateX0 = X0();
        this.state = wecomConnectStateX0;
        this.enteredConnectedFromInitial = wecomConnectStateX0 == WecomConnectState.Connected;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onCreate initialState=%s", Arrays.copyOf(new Object[]{wecomConnectStateX0}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        S0(this.state);
        f1(WecomConnectState.Idle, this.state);
        R0();
    }
}
