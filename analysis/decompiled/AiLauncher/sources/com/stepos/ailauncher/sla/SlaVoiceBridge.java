package com.stepos.ailauncher.sla;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.ailauncher.sla.SlaRouter;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005RSTUVB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\"\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b\"\u0010#J%\u0010$\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b$\u0010#JS\u0010,\u001a\u00020)2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001c¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u001c¢\u0006\u0004\b7\u0010\u001eJ\u0013\u00109\u001a\u00020\f*\u000208H\u0002¢\u0006\u0004\b9\u0010:J/\u0010=\u001a\u00020\f2\n\u0010<\u001a\u00060;R\u00020\u00042\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\u0013H\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001cH\u0002¢\u0006\u0004\b@\u00104R\u0014\u0010A\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u001c8\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010D\u001a\u00020\u001c8\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010BR\u0018\u0010E\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010KR$\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006W"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sla/SlaGate;", "p", "()Lcom/stepos/ailauncher/sla/SlaGate;", "gate", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;", "priority", "Landroid/view/View;", "liveView", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/sla/SlaGate;Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;Landroid/view/View;)Z", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/ailauncher/sla/SlaGate;)Z", "t", "()Z", "Lkotlin/Function1;", "Landroid/content/Context;", "LY8/t;", "handler", "l", "(Lp9/l;)V", "context", "u", "(Landroid/content/Context;)Z", "", "w", "()Ljava/lang/String;", "", "pcm", DidiCardProvider.KEY_TRACE_ID, "x", "(Landroid/content/Context;[BLjava/lang/String;)V", "z", "expectedTraceId", "text", "Lkotlin/Function0;", "proceed", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "onLedgerSettled", "onExecutionSettled", "m", "(Ljava/lang/String;Ljava/lang/String;Lp9/a;Lp9/l;Lp9/l;)Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "o", "(Ljava/lang/String;)V", "k", "(Ljava/lang/String;Ljava/lang/String;)Z", "messageId", "C", "(Ljava/lang/String;Ljava/lang/String;)V", "D", "(Ljava/lang/String;)Ljava/lang/String;", "q", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$a;", "v", "(Lcom/stepos/ailauncher/sla/SlaVoiceBridge$a;)Z", "Lcom/stepos/ailauncher/sla/SlaGate$e;", "ticket", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/sla/SlaGate$e;Lp9/l;)Z", "reason", "r", "TAG", "Ljava/lang/String;", "META_KEY_INPUT_CHANNEL", "INPUT_CHANNEL_VOICE", "gateBinding", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$a;", "voiceRoundLock", "Ljava/lang/Object;", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$b;", "activeVoiceRound", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$b;", "Lkotlin/Pair;", "shownUserBubble", "Lkotlin/Pair;", "lateAsrRound", "slaOnlyProceedFallback", "Lp9/l;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "GateBindPriority", "VoiceSendBind", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaVoiceBridge {
    public static final String INPUT_CHANNEL_VOICE = "voice";
    public static final String META_KEY_INPUT_CHANNEL = "input_channel";
    private static final String TAG = "SLA";
    private static VoiceRound activeVoiceRound;
    private static volatile GateBinding gateBinding;
    private static VoiceRound lateAsrRound;
    private static Pair<String, String> shownUserBubble;
    private static volatile InterfaceC5074l<? super Context, Y8.t> slaOnlyProceedFallback;
    public static final SlaVoiceBridge INSTANCE = new SlaVoiceBridge();
    private static final Object voiceRoundLock = new Object();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;", "", "<init>", "(Ljava/lang/String;I)V", "VOICE_ONLY", "CHAT", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GateBindPriority {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ GateBindPriority[] $VALUES;
        public static final GateBindPriority VOICE_ONLY = new GateBindPriority("VOICE_ONLY", 0);
        public static final GateBindPriority CHAT = new GateBindPriority("CHAT", 1);

        private static final /* synthetic */ GateBindPriority[] $values() {
            return new GateBindPriority[]{VOICE_ONLY, CHAT};
        }

        static {
            GateBindPriority[] gateBindPriorityArr$values = $values();
            $VALUES = gateBindPriorityArr$values;
            $ENTRIES = kotlin.enums.a.a(gateBindPriorityArr$values);
        }

        private GateBindPriority(String str, int i10) {
        }

        public static InterfaceC4149a<GateBindPriority> getEntries() {
            return $ENTRIES;
        }

        public static GateBindPriority valueOf(String str) {
            return (GateBindPriority) Enum.valueOf(GateBindPriority.class, str);
        }

        public static GateBindPriority[] values() {
            return (GateBindPriority[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "", "<init>", "(Ljava/lang/String;I)V", "NO_ROUND", "BOUND", "LOCAL_WON", "EXEC_FAILED", "RESULT_PENDING", "LEDGER_PENDING", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class VoiceSendBind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ VoiceSendBind[] $VALUES;
        public static final VoiceSendBind NO_ROUND = new VoiceSendBind("NO_ROUND", 0);
        public static final VoiceSendBind BOUND = new VoiceSendBind("BOUND", 1);
        public static final VoiceSendBind LOCAL_WON = new VoiceSendBind("LOCAL_WON", 2);
        public static final VoiceSendBind EXEC_FAILED = new VoiceSendBind("EXEC_FAILED", 3);
        public static final VoiceSendBind RESULT_PENDING = new VoiceSendBind("RESULT_PENDING", 4);
        public static final VoiceSendBind LEDGER_PENDING = new VoiceSendBind("LEDGER_PENDING", 5);

        private static final /* synthetic */ VoiceSendBind[] $values() {
            return new VoiceSendBind[]{NO_ROUND, BOUND, LOCAL_WON, EXEC_FAILED, RESULT_PENDING, LEDGER_PENDING};
        }

        static {
            VoiceSendBind[] voiceSendBindArr$values = $values();
            $VALUES = voiceSendBindArr$values;
            $ENTRIES = kotlin.enums.a.a(voiceSendBindArr$values);
        }

        private VoiceSendBind(String str, int i10) {
        }

        public static InterfaceC4149a<VoiceSendBind> getEntries() {
            return $ENTRIES;
        }

        public static VoiceSendBind valueOf(String str) {
            return (VoiceSendBind) Enum.valueOf(VoiceSendBind.class, str);
        }

        public static VoiceSendBind[] values() {
            return (VoiceSendBind[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge$a;", "", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/sla/SlaGate;", "gate", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;", "priority", "Landroid/view/View;", "liveView", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;Ljava/lang/ref/WeakReference;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;", "c", "()Lcom/stepos/ailauncher/sla/SlaVoiceBridge$GateBindPriority;", Const.INTENT_KEY_PKGNAME, "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.SlaVoiceBridge$a, reason: from toString */
    public static final /* data */ class GateBinding {
        private final WeakReference<SlaGate> gate;
        private final WeakReference<View> liveView;
        private final GateBindPriority priority;

        public GateBinding(WeakReference<SlaGate> gate, GateBindPriority priority, WeakReference<View> weakReference) {
            kotlin.jvm.internal.p.i(gate, "gate");
            kotlin.jvm.internal.p.i(priority, "priority");
            this.gate = gate;
            this.priority = priority;
            this.liveView = weakReference;
        }

        public final WeakReference<SlaGate> a() {
            return this.gate;
        }

        public final WeakReference<View> b() {
            return this.liveView;
        }

        /* renamed from: c, reason: from getter */
        public final GateBindPriority getPriority() {
            return this.priority;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GateBinding)) {
                return false;
            }
            GateBinding gateBinding = (GateBinding) other;
            return kotlin.jvm.internal.p.d(this.gate, gateBinding.gate) && this.priority == gateBinding.priority && kotlin.jvm.internal.p.d(this.liveView, gateBinding.liveView);
        }

        public int hashCode() {
            int iHashCode = ((this.gate.hashCode() * 31) + this.priority.hashCode()) * 31;
            WeakReference<View> weakReference = this.liveView;
            return iHashCode + (weakReference == null ? 0 : weakReference.hashCode());
        }

        public String toString() {
            return "GateBinding(gate=" + this.gate + ", priority=" + this.priority + ", liveView=" + this.liveView + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge$c;", "", "", "text", "Lkotlin/Function0;", "LY8/t;", "proceed", "<init>", "(Ljava/lang/String;Lp9/a;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lp9/a;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.SlaVoiceBridge$c, reason: from toString */
    public static final /* data */ class VoiceSendBinding {
        private final InterfaceC5063a<Y8.t> proceed;
        private final String text;

        public VoiceSendBinding(String text, InterfaceC5063a<Y8.t> proceed) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(proceed, "proceed");
            this.text = text;
            this.proceed = proceed;
        }

        public final InterfaceC5063a<Y8.t> a() {
            return this.proceed;
        }

        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceSendBinding)) {
                return false;
            }
            VoiceSendBinding voiceSendBinding = (VoiceSendBinding) other;
            return kotlin.jvm.internal.p.d(this.text, voiceSendBinding.text) && kotlin.jvm.internal.p.d(this.proceed, voiceSendBinding.proceed);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.proceed.hashCode();
        }

        public String toString() {
            return "VoiceSendBinding(text=" + this.text + ", proceed=" + this.proceed + ")";
        }
    }

    public static final SlaRouter.a A(Context context, byte[] bArr, String str, SlaListener listener, boolean z10, String sessionId) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return SlaRouter.INSTANCE.H(context, bArr, sessionId, str, listener, z10);
    }

    public static final Y8.t B(Context context) {
        InterfaceC5074l<? super Context, Y8.t> interfaceC5074l = slaOnlyProceedFallback;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(context);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t h(InterfaceC5074l interfaceC5074l, SlaGate.e eVar) {
        interfaceC5074l.invoke(eVar.g());
        return Y8.t.f7040a;
    }

    public static /* synthetic */ boolean j(SlaVoiceBridge slaVoiceBridge, SlaGate slaGate, GateBindPriority gateBindPriority, View view, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gateBindPriority = GateBindPriority.CHAT;
        }
        if ((i10 & 4) != 0) {
            view = null;
        }
        return slaVoiceBridge.i(slaGate, gateBindPriority, view);
    }

    public static final Y8.t n(SlaGate.e eVar, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2) {
        VoiceSendBind voiceSendBindG = eVar.g();
        if (voiceSendBindG != VoiceSendBind.RESULT_PENDING) {
            interfaceC5074l2.invoke(voiceSendBindG);
        } else if (!INSTANCE.g(eVar, interfaceC5074l)) {
            interfaceC5074l.invoke(eVar.g());
        }
        return Y8.t.f7040a;
    }

    public static final void s(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final SlaRouter.a y(Context context, byte[] bArr, String str, SlaListener listener, boolean z10, String sessionId) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return SlaRouter.INSTANCE.H(context, bArr, sessionId, str, listener, z10);
    }

    public final void C(String traceId, String messageId) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        if (traceId.length() == 0 || messageId.length() == 0) {
            return;
        }
        synchronized (voiceRoundLock) {
            shownUserBubble = Y8.j.a(traceId, messageId);
            Y8.t tVar = Y8.t.f7040a;
        }
        C4148a.k("SLA", "publishShownUserBubble traceId=" + traceId, false, 4, null);
    }

    public final String D(String traceId) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        String strF = null;
        if (traceId.length() == 0) {
            return null;
        }
        synchronized (voiceRoundLock) {
            Pair<String, String> pair = shownUserBubble;
            if (pair != null && kotlin.jvm.internal.p.d(pair.e(), traceId)) {
                shownUserBubble = null;
                strF = pair.f();
            }
        }
        return strF;
    }

    public final boolean E(SlaGate gate) {
        Pair pairA;
        kotlin.jvm.internal.p.i(gate, "gate");
        if (p() != gate) {
            C4148a.k("SLA", "unbindGate skip: not the owner", false, 4, null);
            return false;
        }
        C4148a.k("SLA", "unbindGate", false, 4, null);
        gateBinding = null;
        synchronized (voiceRoundLock) {
            try {
                VoiceRound voiceRound = activeVoiceRound;
                SlaGate.e ticket = voiceRound != null ? voiceRound.getTicket() : null;
                VoiceRound voiceRound2 = lateAsrRound;
                pairA = Y8.j.a(ticket, voiceRound2 != null ? voiceRound2.getTicket() : null);
                activeVoiceRound = null;
                lateAsrRound = null;
                shownUserBubble = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        SlaGate.e eVar = (SlaGate.e) pairA.a();
        SlaGate.e eVar2 = (SlaGate.e) pairA.b();
        if (eVar != null) {
            SlaGate.e.d(eVar, null, 1, null);
        }
        if (eVar != null) {
            eVar.f();
        }
        if (eVar2 != null) {
            eVar2.f();
        }
        return true;
    }

    public final boolean g(final SlaGate.e ticket, final InterfaceC5074l<? super VoiceSendBind, Y8.t> onExecutionSettled) {
        return ticket.h(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.M
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaVoiceBridge.h(onExecutionSettled, ticket);
            }
        });
    }

    public final boolean i(SlaGate gate, GateBindPriority priority, View liveView) {
        WeakReference<SlaGate> weakReferenceA;
        kotlin.jvm.internal.p.i(gate, "gate");
        kotlin.jvm.internal.p.i(priority, "priority");
        GateBinding gateBinding2 = gateBinding;
        SlaGate slaGate = (gateBinding2 == null || (weakReferenceA = gateBinding2.a()) == null) ? null : weakReferenceA.get();
        if (N.a(gateBinding2 != null ? gateBinding2.getPriority() : null, slaGate, slaGate != null && v(gateBinding2), gate, priority)) {
            C4148a.k("SLA", "bindGate skip: chat layout holds gate", false, 4, null);
            return false;
        }
        C4148a.k("SLA", "bindGate priority=" + priority, false, 4, null);
        gateBinding = new GateBinding(new WeakReference(gate), priority, liveView != null ? new WeakReference(liveView) : null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:10:0x001e, B:12:0x0023, B:17:0x0031, B:22:0x003b, B:24:0x003f, B:29:0x004d), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r7 = "traceId"
            kotlin.jvm.internal.p.i(r8, r7)
            java.lang.String r7 = "text"
            kotlin.jvm.internal.p.i(r9, r7)
            int r7 = r8.length()
            r0 = 0
            if (r7 != 0) goto L14
            goto L1a
        L14:
            int r7 = r9.length()
            if (r7 != 0) goto L1b
        L1a:
            return r0
        L1b:
            java.lang.Object r7 = com.stepos.ailauncher.sla.SlaVoiceBridge.voiceRoundLock
            monitor-enter(r7)
            com.stepos.ailauncher.sla.SlaVoiceBridge$b r1 = com.stepos.ailauncher.sla.SlaVoiceBridge.lateAsrRound     // Catch: java.lang.Throwable -> L38
            r2 = 0
            if (r1 == 0) goto L3b
            java.lang.String r3 = r1.getTraceId()     // Catch: java.lang.Throwable -> L38
            boolean r3 = kotlin.jvm.internal.p.d(r3, r8)     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L2e
            goto L2f
        L2e:
            r1 = r2
        L2f:
            if (r1 == 0) goto L3b
            com.stepos.ailauncher.sla.SlaGate$e r1 = r1.getTicket()     // Catch: java.lang.Throwable -> L38
            if (r1 != 0) goto L53
            goto L3b
        L38:
            r8 = move-exception
            goto Lbc
        L3b:
            com.stepos.ailauncher.sla.SlaVoiceBridge$b r1 = com.stepos.ailauncher.sla.SlaVoiceBridge.activeVoiceRound     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L52
            java.lang.String r3 = r1.getTraceId()     // Catch: java.lang.Throwable -> L38
            boolean r3 = kotlin.jvm.internal.p.d(r3, r8)     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L4a
            goto L4b
        L4a:
            r1 = r2
        L4b:
            if (r1 == 0) goto L52
            com.stepos.ailauncher.sla.SlaGate$e r1 = r1.getTicket()     // Catch: java.lang.Throwable -> L38
            goto L53
        L52:
            r1 = r2
        L53:
            monitor-exit(r7)
            r3 = 4
            if (r1 != 0) goto L73
            java.lang.String r7 = "SLA"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "bindLateAsrText traceId="
            r9.append(r1)
            r9.append(r8)
            java.lang.String r8 = " 无匹配 round -> 丢弃"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            h8.C4148a.k(r7, r8, r0, r3, r2)
            return r0
        L73:
            boolean r1 = r1.b(r9)
            java.lang.String r4 = "SLA"
            int r9 = r9.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "bindLateAsrText traceId="
            r5.append(r6)
            r5.append(r8)
            java.lang.String r6 = " textLen="
            r5.append(r6)
            r5.append(r9)
            java.lang.String r9 = " bound="
            r5.append(r9)
            r5.append(r1)
            java.lang.String r9 = r5.toString()
            h8.C4148a.k(r4, r9, r0, r3, r2)
            monitor-enter(r7)
            com.stepos.ailauncher.sla.SlaVoiceBridge$b r9 = com.stepos.ailauncher.sla.SlaVoiceBridge.lateAsrRound     // Catch: java.lang.Throwable -> Lab
            if (r9 == 0) goto Lad
            java.lang.String r9 = r9.getTraceId()     // Catch: java.lang.Throwable -> Lab
            goto Lae
        Lab:
            r8 = move-exception
            goto Lba
        Lad:
            r9 = r2
        Lae:
            boolean r8 = kotlin.jvm.internal.p.d(r9, r8)     // Catch: java.lang.Throwable -> Lab
            if (r8 == 0) goto Lb6
            com.stepos.ailauncher.sla.SlaVoiceBridge.lateAsrRound = r2     // Catch: java.lang.Throwable -> Lab
        Lb6:
            Y8.t r8 = Y8.t.f7040a     // Catch: java.lang.Throwable -> Lab
            monitor-exit(r7)
            return r1
        Lba:
            monitor-exit(r7)
            throw r8
        Lbc:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaVoiceBridge.k(java.lang.String, java.lang.String):boolean");
    }

    public final void l(InterfaceC5074l<? super Context, Y8.t> handler) {
        slaOnlyProceedFallback = handler;
    }

    public final VoiceSendBind m(String expectedTraceId, String text, InterfaceC5063a<Y8.t> proceed, final InterfaceC5074l<? super VoiceSendBind, Y8.t> onLedgerSettled, final InterfaceC5074l<? super VoiceSendBind, Y8.t> onExecutionSettled) {
        final SlaGate.e ticket;
        boolean z10;
        boolean z11;
        kotlin.jvm.internal.p.i(expectedTraceId, "expectedTraceId");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(proceed, "proceed");
        kotlin.jvm.internal.p.i(onLedgerSettled, "onLedgerSettled");
        kotlin.jvm.internal.p.i(onExecutionSettled, "onExecutionSettled");
        if (expectedTraceId.length() == 0) {
            E5.a.b("[SLA][traceId=empty] bindVoiceSend missingTraceId");
            return VoiceSendBind.NO_ROUND;
        }
        synchronized (voiceRoundLock) {
            VoiceRound voiceRound = activeVoiceRound;
            if (voiceRound == null || !kotlin.jvm.internal.p.d(voiceRound.getTraceId(), expectedTraceId)) {
                ticket = null;
                z10 = false;
            } else if (voiceRound.getBinding() != null) {
                ticket = null;
                z10 = true;
            } else {
                voiceRound.d(new VoiceSendBinding(text, proceed));
                ticket = voiceRound.getTicket();
                if (ticket != null) {
                    activeVoiceRound = null;
                }
                z10 = true;
                z11 = false;
            }
            z11 = z10;
        }
        if (!z10) {
            E5.a.b("[SLA][traceId=" + expectedTraceId + "] bindVoiceSend noMatchingVoiceRound");
            return VoiceSendBind.NO_ROUND;
        }
        E5.a.a("[SLA][traceId=" + expectedTraceId + "] asrSendBound waitForAudioTicket=" + (ticket == null));
        if (!z11 && ticket != null) {
            ticket.e(text, proceed);
            VoiceSendBind voiceSendBindG = ticket.g();
            if (voiceSendBindG == VoiceSendBind.LEDGER_PENDING && !ticket.i(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.L
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SlaVoiceBridge.n(ticket, onExecutionSettled, onLedgerSettled);
                }
            })) {
                voiceSendBindG = ticket.g();
            }
            if (voiceSendBindG == VoiceSendBind.RESULT_PENDING && !g(ticket, onExecutionSettled)) {
                voiceSendBindG = ticket.g();
            }
            C4148a.k("SLA", "bindVoiceSend disposition=" + voiceSendBindG + " traceId=" + expectedTraceId, false, 4, null);
            return voiceSendBindG;
        }
        return VoiceSendBind.BOUND;
    }

    public final void o(String traceId) {
        VoiceRound voiceRound;
        kotlin.jvm.internal.p.i(traceId, "traceId");
        if (traceId.length() == 0) {
            return;
        }
        Object obj = voiceRoundLock;
        synchronized (obj) {
            voiceRound = activeVoiceRound;
            if (voiceRound == null || !kotlin.jvm.internal.p.d(voiceRound.getTraceId(), traceId)) {
                voiceRound = null;
            } else {
                activeVoiceRound = null;
            }
        }
        SlaGate.e ticket = voiceRound != null ? voiceRound.getTicket() : null;
        C4148a.k("SLA", "cancelPendingTicket traceId=" + traceId + " hasTicket=" + (ticket != null), false, 4, null);
        boolean z10 = ticket != null && ticket.a();
        synchronized (obj) {
            if (!z10) {
                voiceRound = null;
            }
            lateAsrRound = voiceRound;
            Y8.t tVar = Y8.t.f7040a;
        }
        if (z10) {
            C4148a.k("SLA", "cancelPendingTicket traceId=" + traceId + " -> 留槽等迟到 ASR 文案", false, 4, null);
            E5.a.a("[SLA][traceId=" + traceId + "] lateAsrRoundRetained");
        }
        if (ticket != null) {
            SlaGate.e.d(ticket, null, 1, null);
        }
    }

    public final SlaGate p() {
        WeakReference<SlaGate> weakReferenceA;
        GateBinding gateBinding2 = gateBinding;
        if (gateBinding2 == null || (weakReferenceA = gateBinding2.a()) == null) {
            return null;
        }
        return weakReferenceA.get();
    }

    public final String q() {
        String traceId;
        synchronized (voiceRoundLock) {
            try {
                VoiceRound voiceRound = activeVoiceRound;
                traceId = voiceRound != null ? voiceRound.getTraceId() : null;
                if (traceId == null) {
                    traceId = "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return traceId;
    }

    public final void r(String traceId, String reason) {
        VoiceSendBinding binding;
        final InterfaceC5063a<Y8.t> interfaceC5063aA;
        synchronized (voiceRoundLock) {
            VoiceRound voiceRound = activeVoiceRound;
            binding = null;
            if (voiceRound != null && kotlin.jvm.internal.p.d(voiceRound.getTraceId(), traceId)) {
                activeVoiceRound = null;
                binding = voiceRound.getBinding();
            }
        }
        E5.a.b("[SLA][traceId=" + traceId + "] voiceRoundDiscarded reason=" + reason + " asrBound=" + (binding != null));
        if (binding == null || (interfaceC5063aA = binding.a()) == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.ailauncher.sla.K
            @Override // java.lang.Runnable
            public final void run() {
                SlaVoiceBridge.s(interfaceC5063aA);
            }
        });
    }

    public final boolean t() {
        GateBinding gateBinding2 = gateBinding;
        return gateBinding2 != null && gateBinding2.getPriority() == GateBindPriority.CHAT && gateBinding2.a().get() != null && v(gateBinding2);
    }

    public final boolean u(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return p() != null && SlaRouter.INSTANCE.v(context);
    }

    public final boolean v(GateBinding gateBinding2) {
        WeakReference<View> weakReferenceB = gateBinding2.b();
        return weakReferenceB == null || weakReferenceB.get() != null;
    }

    public final String w() {
        SlaGate.e ticket;
        SlaGate.e ticket2;
        SlaGate slaGateP = p();
        String strM = slaGateP != null ? slaGateP.M() : null;
        if (strM == null) {
            strM = "";
        }
        synchronized (voiceRoundLock) {
            try {
                VoiceRound voiceRound = lateAsrRound;
                ticket = voiceRound != null ? voiceRound.getTicket() : null;
                lateAsrRound = null;
                Pair<String, String> pair = shownUserBubble;
                if (!kotlin.jvm.internal.p.d(pair != null ? pair.e() : null, strM)) {
                    shownUserBubble = null;
                }
                VoiceRound voiceRound2 = activeVoiceRound;
                ticket2 = voiceRound2 != null ? voiceRound2.getTicket() : null;
                String str = strM.length() > 0 ? strM : null;
                activeVoiceRound = str != null ? new VoiceRound(str, null, null, 6, null) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (ticket != null) {
            ticket.f();
        }
        if (ticket2 != null) {
            ticket2.c(SlaGate.CancelReason.SUPERSEDED);
        }
        E5.a.a("[VOICE][traceId=" + strM + "] traceCreated");
        return strM;
    }

    public final void x(final Context context, final byte[] pcm, final String traceId) {
        boolean z10;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(pcm, "pcm");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        SlaGate slaGateP = p();
        VoiceSendBinding voiceSendBinding = null;
        if (slaGateP == null) {
            C4148a.d("SLA", "onAudioCaptured skip: no gate", false, 4, null);
            r(traceId, "noGate");
            return;
        }
        if (pcm.length == 0 || !SlaRouter.INSTANCE.v(context)) {
            C4148a.k("SLA", "onAudioCaptured skip: pcmBytes=" + pcm.length + " unavailable", false, 4, null);
            r(traceId, "unavailable");
            return;
        }
        if (C3474c.INSTANCE.a() && com.stepos.ailauncher.common.utils.I.INSTANCE.a(context)) {
            C4148a.k("SLA", "onAudioCaptured skip: cloudFirstWhenOnline traceId=" + traceId, false, 4, null);
            r(traceId, "cloudFirstWhenOnline");
            return;
        }
        C4148a.k("SLA", "onAudioCaptured: start voice race pcmBytes=" + pcm.length + " traceId=" + traceId, false, 4, null);
        if (traceId.length() == 0) {
            E5.a.b("[SLA][traceId=empty] audioCaptured missing traceId");
        }
        E5.b.INSTANCE.a(traceId, "audio_sla.start", "语音SLA调用开始");
        SlaGate.e eVarB = slaGateP.B(traceId, new p9.q() { // from class: com.stepos.ailauncher.sla.H
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SlaVoiceBridge.y(context, pcm, traceId, (SlaListener) obj, ((Boolean) obj2).booleanValue(), (String) obj3);
            }
        });
        if (eVarB == null) {
            r(traceId, "ticketNotCreated");
            return;
        }
        synchronized (voiceRoundLock) {
            VoiceRound voiceRound = activeVoiceRound;
            if (voiceRound == null || !kotlin.jvm.internal.p.d(voiceRound.getTraceId(), traceId)) {
                z10 = false;
            } else {
                voiceRound.e(eVarB);
                VoiceSendBinding binding = voiceRound.getBinding();
                if (binding != null) {
                    activeVoiceRound = null;
                }
                voiceSendBinding = binding;
                z10 = true;
            }
        }
        if (!z10) {
            E5.a.b("[SLA][traceId=" + traceId + "] audioTicketDiscarded reason=noMatchingVoiceRound");
            eVarB.c(SlaGate.CancelReason.SUPERSEDED);
            return;
        }
        E5.a.a("[SLA][traceId=" + traceId + "] audioTicketReady waitForAsr=" + (voiceSendBinding == null));
        if (voiceSendBinding != null) {
            eVarB.e(voiceSendBinding.getText(), voiceSendBinding.a());
        }
    }

    public final void z(final Context context, final byte[] pcm, final String traceId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(pcm, "pcm");
        kotlin.jvm.internal.p.i(traceId, "traceId");
        SlaGate slaGateP = p();
        if (slaGateP == null) {
            C4148a.d("SLA", "onSlaOnlyAudioCaptured skip: no gate", false, 4, null);
            return;
        }
        if (pcm.length == 0 || !SlaRouter.INSTANCE.v(context)) {
            C4148a.k("SLA", "onSlaOnlyAudioCaptured skip: pcmBytes=" + pcm.length + " unavailable", false, 4, null);
            return;
        }
        C4148a.k("SLA", "onSlaOnlyAudioCaptured: start voice race(sla-only) pcmBytes=" + pcm.length + " traceId=" + traceId, false, 4, null);
        o(traceId);
        if (traceId.length() == 0) {
            E5.a.b("[SLA][traceId=empty] slaOnlyAudioCaptured missing traceId");
        }
        E5.b.INSTANCE.a(traceId, "audio_sla.start", "语音SLA调用开始(SLA-only)");
        SlaGate.e eVarB = slaGateP.B(traceId, new p9.q() { // from class: com.stepos.ailauncher.sla.I
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SlaVoiceBridge.A(context, pcm, traceId, (SlaListener) obj, ((Boolean) obj2).booleanValue(), (String) obj3);
            }
        });
        if (eVarB == null) {
            return;
        }
        eVarB.e("", new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaVoiceBridge.B(context);
            }
        });
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR(\u0010\u0006\u001a\b\u0018\u00010\u0004R\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/sla/SlaVoiceBridge$b;", "", "", DidiCardProvider.KEY_TRACE_ID, "Lcom/stepos/ailauncher/sla/SlaGate$e;", "Lcom/stepos/ailauncher/sla/SlaGate;", "ticket", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$c;", "binding", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/sla/SlaGate$e;Lcom/stepos/ailauncher/sla/SlaVoiceBridge$c;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "Lcom/stepos/ailauncher/sla/SlaGate$e;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/sla/SlaGate$e;", "e", "(Lcom/stepos/ailauncher/sla/SlaGate$e;)V", "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$c;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/sla/SlaVoiceBridge$c;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/sla/SlaVoiceBridge$c;)V", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.SlaVoiceBridge$b, reason: from toString */
    public static final /* data */ class VoiceRound {
        private VoiceSendBinding binding;
        private SlaGate.e ticket;
        private final String traceId;

        public VoiceRound(String traceId, SlaGate.e eVar, VoiceSendBinding voiceSendBinding) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.traceId = traceId;
            this.ticket = eVar;
            this.binding = voiceSendBinding;
        }

        /* renamed from: a, reason: from getter */
        public final VoiceSendBinding getBinding() {
            return this.binding;
        }

        /* renamed from: b, reason: from getter */
        public final SlaGate.e getTicket() {
            return this.ticket;
        }

        /* renamed from: c, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public final void d(VoiceSendBinding voiceSendBinding) {
            this.binding = voiceSendBinding;
        }

        public final void e(SlaGate.e eVar) {
            this.ticket = eVar;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceRound)) {
                return false;
            }
            VoiceRound voiceRound = (VoiceRound) other;
            return kotlin.jvm.internal.p.d(this.traceId, voiceRound.traceId) && kotlin.jvm.internal.p.d(this.ticket, voiceRound.ticket) && kotlin.jvm.internal.p.d(this.binding, voiceRound.binding);
        }

        public int hashCode() {
            int iHashCode = this.traceId.hashCode() * 31;
            SlaGate.e eVar = this.ticket;
            int iHashCode2 = (iHashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
            VoiceSendBinding voiceSendBinding = this.binding;
            return iHashCode2 + (voiceSendBinding != null ? voiceSendBinding.hashCode() : 0);
        }

        public String toString() {
            return "VoiceRound(traceId=" + this.traceId + ", ticket=" + this.ticket + ", binding=" + this.binding + ")";
        }

        public /* synthetic */ VoiceRound(String str, SlaGate.e eVar, VoiceSendBinding voiceSendBinding, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? null : eVar, (i10 & 4) != 0 ? null : voiceSendBinding);
        }
    }
}
