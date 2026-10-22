package com.stepos.ailauncher.task.detail;

import V0.CreationExtras;
import Z8.C1173v;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.U;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.Configuration;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.C1963x;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator;
import com.stepos.ailauncher.chat.fragment.ChatInputFragment;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2712o;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.view.AskUserInquiryBinder;
import com.stepos.ailauncher.chat.view.AskUserRequest;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.C6;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.ToolApprovalRequest;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.ailauncher.task.R$dimen;
import com.stepos.ailauncher.task.R$drawable;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 o2\u00020\u0001:\u0001pB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J!\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001fH\u0014¢\u0006\u0004\b%\u0010!J\u000f\u0010&\u001a\u00020\u000bH\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b/\u0010.J\u0013\u00101\u001a\b\u0012\u0004\u0012\u00020\u000600¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0014H\u0014¢\u0006\u0004\b4\u0010\u0019J\u000f\u00105\u001a\u00020\u0004H\u0014¢\u0006\u0004\b5\u0010\u0003J\u0017\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0014¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b:\u0010\u0003J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u001fH\u0014¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020(H\u0014¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0004H\u0014¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0004H\u0014¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\u0004H\u0014¢\u0006\u0004\bC\u0010\u0003J\u0017\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\bD\u0010\u000eJ\u000f\u0010E\u001a\u00020\u0004H\u0014¢\u0006\u0004\bE\u0010\u0003R\u001d\u0010K\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010R\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010H\u001a\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010\\\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010`R\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\bR\u0014\u0010n\u001a\u00020\u001f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bm\u0010!¨\u0006q"}, d2 = {"Lcom/stepos/ailauncher/task/detail/ArtifactDetailActivity;", "Lcom/stepos/ailauncher/sheet/S;", "<init>", "()V", "LY8/t;", "N4", "", "f5", "()Ljava/lang/String;", "g5", "X4", "", "level", "h5", "(I)V", "d5", "e5", "", "Landroid/view/View;", "views", "Landroid/widget/FrameLayout;", "M4", "([Landroid/view/View;)Landroid/widget/FrameLayout;", "host", "S4", "(Landroid/widget/FrameLayout;)V", "f4", "Landroidx/fragment/app/Fragment;", "s4", "()Landroidx/fragment/app/Fragment;", "z4", "", "Z3", "()Z", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "i1", "j2", "()I", "", "T2", "()F", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "y4", "", "T4", "()Ljava/util/List;", "slot", AMapLocationStaticsEntity.IPV4, "G2", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "S2", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "u4", "inPreview", "L2", "(Z)V", "fraction", "R2", "(F)V", "onResume", "onPause", "onStop", "onTrimMemory", "onDestroy", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact$delegate", "LY8/h;", "U4", "()Lcom/stepos/ailauncher/contract/model/SessionArtifact;", ArtifactDetailActivity.EXTRA_ARTIFACT, "pinnedSessionKey", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel$delegate", "V4", "()Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel", "Lcom/stepos/ailauncher/chat/fragment/ChatInputFragment;", "residentInput", "Lcom/stepos/ailauncher/chat/fragment/ChatInputFragment;", "Lcom/stepos/ailauncher/task/detail/n;", "inputMotion", "Lcom/stepos/ailauncher/task/detail/n;", "inputSlot", "Landroid/widget/FrameLayout;", "bottomChromeHost", "inputPreviewTransition", "Z", "", "contentLocation", "[I", "slotLocation", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "inputHostPreDraw", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatLayout", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "W4", "seedSessionKey", "U1", "residentSlotPinnedToRoot", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactDetailActivity extends com.stepos.ailauncher.sheet.S {
    private static final String AGENT_ID_AGENT_BUS = "agent_bus";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ARTIFACT = "artifact";
    private static final String EXTRA_SOURCE = "source";
    private static final String TAG = "ArtifactDetailActivity";
    private static final String TAG_RESIDENT_INPUT = "artifact_detail_resident_input";
    private static final String TAG_ROOT = "artifact_detail";
    private FrameLayout bottomChromeHost;
    private LauncherChatLayout chatLayout;
    private C3534n inputMotion;
    private boolean inputPreviewTransition;
    private FrameLayout inputSlot;
    private String pinnedSessionKey;
    private ChatInputFragment residentInput;
    private SessionHandler sessionHandler;

    /* renamed from: artifact$delegate, reason: from kotlin metadata */
    private final Y8.h artifact = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.c
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ArtifactDetailActivity.L4(this.f28511a);
        }
    });

    /* renamed from: coreViewModel$delegate, reason: from kotlin metadata */
    private final Y8.h coreViewModel = new android.view.T(kotlin.jvm.internal.t.b(com.stepos.ailauncher.chat.fragment.I0.class), new c(this), new b(this), new d(null, this));
    private final int[] contentLocation = new int[2];
    private final int[] slotLocation = new int[2];
    private final ViewTreeObserver.OnPreDrawListener inputHostPreDraw = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.ailauncher.task.detail.d
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            return ArtifactDetailActivity.Y4(this.f28535a);
        }
    };

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/task/detail/ArtifactDetailActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", ArtifactDetailActivity.EXTRA_ARTIFACT, "", "source", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "TAG_ROOT", "TAG_RESIDENT_INPUT", "EXTRA_ARTIFACT", "EXTRA_SOURCE", "AGENT_ID_AGENT_BUS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.ArtifactDetailActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context, SessionArtifact artifact, String source) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(artifact, "artifact");
            kotlin.jvm.internal.p.i(source, "source");
            Intent intentPutExtra = new Intent(context, (Class<?>) ArtifactDetailActivity.class).putExtra(ArtifactDetailActivity.EXTRA_ARTIFACT, artifact).putExtra("source", source);
            kotlin.jvm.internal.p.h(intentPutExtra, "putExtra(...)");
            C2739j.C(context, intentPutExtra, null, 4, null);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5063a<U.c> {
        final /* synthetic */ b.q $this_viewModels;

        public b(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final U.c invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5063a<android.view.V> {
        final /* synthetic */ b.q $this_viewModels;

        public c(b.q qVar) {
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final android.view.V invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d implements InterfaceC5063a<CreationExtras> {
        final /* synthetic */ InterfaceC5063a $extrasProducer;
        final /* synthetic */ b.q $this_viewModels;

        public d(InterfaceC5063a interfaceC5063a, b.q qVar) {
            this.$extrasProducer = interfaceC5063a;
            this.$this_viewModels = qVar;
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            InterfaceC5063a interfaceC5063a = this.$extrasProducer;
            return (interfaceC5063a == null || (creationExtras = (CreationExtras) interfaceC5063a.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : creationExtras;
        }
    }

    public static final SessionArtifact L4(ArtifactDetailActivity artifactDetailActivity) {
        Intent intent = artifactDetailActivity.getIntent();
        if (intent != null) {
            return (SessionArtifact) intent.getParcelableExtra(EXTRA_ARTIFACT, SessionArtifact.class);
        }
        return null;
    }

    public static final boolean O4(ArtifactDetailActivity artifactDetailActivity, AskUserRequest req) {
        kotlin.jvm.internal.p.i(req, "req");
        artifactDetailActivity.V4().B(req);
        return true;
    }

    public static final boolean P4(ArtifactDetailActivity artifactDetailActivity, ToolApprovalRequest req) {
        kotlin.jvm.internal.p.i(req, "req");
        artifactDetailActivity.V4().D(req);
        return true;
    }

    public static final String Q4(ArtifactDetailActivity artifactDetailActivity) {
        return artifactDetailActivity.pinnedSessionKey;
    }

    public static final Y8.t R4(ArtifactDetailActivity artifactDetailActivity, String str) {
        artifactDetailActivity.V4().y(str);
        return Y8.t.f7040a;
    }

    private final com.stepos.ailauncher.chat.fragment.I0 V4() {
        return (com.stepos.ailauncher.chat.fragment.I0) this.coreViewModel.getValue();
    }

    private final void X4() {
        Window window;
        View decorView;
        IBinder windowToken;
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        if (inputMethodManager == null || (window = getWindow()) == null || (decorView = window.getDecorView()) == null || (windowToken = decorView.getWindowToken()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
    }

    public static final boolean Y4(ArtifactDetailActivity artifactDetailActivity) {
        float height;
        FrameLayout frameLayout = artifactDetailActivity.inputSlot;
        if (frameLayout != null) {
            if (artifactDetailActivity.getPreviewMode() || artifactDetailActivity.inputPreviewTransition) {
                height = 0.0f;
            } else {
                artifactDetailActivity.M1().getLocationInWindow(artifactDetailActivity.contentLocation);
                frameLayout.getLocationInWindow(artifactDetailActivity.slotLocation);
                height = (((artifactDetailActivity.contentLocation[1] + artifactDetailActivity.M1().getHeight()) - artifactDetailActivity.M1().getPaddingBottom()) - artifactDetailActivity.slotLocation[1]) - frameLayout.getHeight();
            }
            C3534n c3534n = artifactDetailActivity.inputMotion;
            if (c3534n != null) {
                c3534n.g(height);
            }
            FrameLayout frameLayout2 = artifactDetailActivity.bottomChromeHost;
            if (frameLayout2 != null) {
                frameLayout2.setTranslationY(height + frameLayout.getTranslationY());
            }
        }
        return true;
    }

    public static final Y8.t Z4(ArtifactDetailActivity artifactDetailActivity) {
        List<String> listT4 = artifactDetailActivity.T4();
        if (listT4.isEmpty()) {
            Toast.makeText(artifactDetailActivity, R$string.artifact_detail_no_session_send, 0).show();
        } else {
            com.stepos.ailauncher.chat.manager.Q0.l(listT4);
        }
        return Y8.t.f7040a;
    }

    public static final void a5(ArtifactDetailActivity artifactDetailActivity) {
        ChatInputFragment chatInputFragment;
        if (artifactDetailActivity.isDestroyed() || artifactDetailActivity.isFinishing() || (chatInputFragment = artifactDetailActivity.residentInput) == null) {
            return;
        }
        chatInputFragment.z1(false);
    }

    public static final void b5(ArtifactDetailActivity artifactDetailActivity) {
        if (artifactDetailActivity.isDestroyed() || artifactDetailActivity.isFinishing()) {
            return;
        }
        artifactDetailActivity.d5();
        RiskCardHandoffCoordinator.INSTANCE.G();
    }

    public static final Y8.t c5(ArtifactDetailActivity artifactDetailActivity, int i10) {
        artifactDetailActivity.h5(i10);
        return Y8.t.f7040a;
    }

    private final void e5() {
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        vVar.b(this.pinnedSessionKey, com.stepos.ailauncher.common.utils.v.OWNER_DETAIL);
        vVar.q(false, com.stepos.ailauncher.common.utils.v.OWNER_DETAIL);
    }

    private final void g5() {
        C3534n c3534n;
        android.view.W w10 = t4().w();
        com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
        boolean z10 = dVar != null && dVar.m();
        boolean z11 = z10 || getPreviewMode();
        if (z11 && (c3534n = this.inputMotion) != null && c3534n.getIsShown()) {
            X4();
        }
        C3534n c3534n2 = this.inputMotion;
        if (c3534n2 != null) {
            c3534n2.h(!z11, !z10);
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void G2() {
        super.G2();
        Z1().post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.e
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactDetailActivity.a5(this.f28569a);
            }
        });
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void L2(boolean inPreview) {
        super.L2(inPreview);
        this.inputPreviewTransition = inPreview;
        g5();
    }

    public final FrameLayout M4(View... views) {
        kotlin.jvm.internal.p.i(views, "views");
        if (this.bottomChromeHost != null) {
            throw new IllegalStateException("Check failed.");
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setElevation(Y1().getElevation());
        for (View view : views) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            frameLayout.addView(view);
        }
        u0(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.bottomChromeHost = frameLayout;
        return frameLayout;
    }

    public final void N4() {
        String strF5 = this.pinnedSessionKey;
        if (strF5 == null) {
            strF5 = f5();
            this.pinnedSessionKey = strF5;
        }
        if (strF5 == null) {
            C4148a.h(TAG, "no sessionId after resolve — secondary edit disabled", false, 4, null);
            return;
        }
        SessionHandler sessionHandler = new SessionHandler(Configuration.INSTANCE.a(AGENT_ID_AGENT_BUS).a(C1963x.AGENT_TYPE_AGENTBUS).c(false).e(strF5).b());
        this.sessionHandler = sessionHandler;
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.view_artifact_headless_chat, (ViewGroup) M1(), false);
        kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type com.stepos.ailauncher.chat.view.LauncherChatLayout");
        LauncherChatLayout launcherChatLayout = (LauncherChatLayout) viewInflate;
        this.chatLayout = launcherChatLayout;
        launcherChatLayout.k3(sessionHandler);
        launcherChatLayout.setAgentUiConfig(C6.a(this, this));
        launcherChatLayout.setEmptyShowEnable(false);
        com.stepos.ailauncher.chat.tts.a.INSTANCE.n(launcherChatLayout);
        AskUserInquiryBinder askUserInquiryBinder = AskUserInquiryBinder.INSTANCE;
        askUserInquiryBinder.g(launcherChatLayout, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ArtifactDetailActivity.O4(this.f28575a, (AskUserRequest) obj));
            }
        });
        askUserInquiryBinder.e(launcherChatLayout, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ArtifactDetailActivity.P4(this.f28637a, (ToolApprovalRequest) obj));
            }
        });
        askUserInquiryBinder.n(launcherChatLayout, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailActivity.Q4(this.f28639a);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDetailActivity.R4(this.f28643a, (String) obj);
            }
        });
        V4().A(launcherChatLayout, sessionHandler);
        V4().F(false);
        M1().addView(launcherChatLayout, 0);
        launcherChatLayout.b9();
        try {
            Result.Companion companion = Result.INSTANCE;
            launcherChatLayout.U4(strF5);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // com.stepos.ailauncher.sheet.S, com.stepos.ailauncher.sheet.O
    public void R2(float fraction) {
        super.R2(fraction);
        g5();
    }

    @Override // com.stepos.ailauncher.sheet.S, com.stepos.ailauncher.sheet.O
    public void S2(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        super.S2(state);
        ChatInputFragment chatInputFragment = this.residentInput;
        if (chatInputFragment != null) {
            chatInputFragment.t0(state);
        }
    }

    public final void S4(FrameLayout host) {
        kotlin.jvm.internal.p.i(host, "host");
        ViewParent parent = host.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(host);
        }
        if (this.bottomChromeHost == host) {
            this.bottomChromeHost = null;
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public float T2() {
        return getResources().getDimension(R$dimen.artifact_detail_panel_corner) / getResources().getDisplayMetrics().density;
    }

    public final List<String> T4() {
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        List listR = C1173v.r(this.pinnedSessionKey, W4(), agentConversationR1 != null ? agentConversationR1.getSessionId() : null, agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null, agentConversationR1 != null ? agentConversationR1.B() : null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return Z8.F.g0(arrayList);
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean U1() {
        return true;
    }

    public final SessionArtifact U4() {
        return (SessionArtifact) this.artifact.getValue();
    }

    public final String W4() {
        String sessionId;
        SessionArtifact sessionArtifactU4 = U4();
        if (sessionArtifactU4 == null || (sessionId = sessionArtifactU4.getSessionId()) == null || La.H.x0(sessionId)) {
            return null;
        }
        return sessionId;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean Z3() {
        return false;
    }

    public final void d5() {
        String str = this.pinnedSessionKey;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str == null) {
                return;
            }
            com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
            vVar.q(true, com.stepos.ailauncher.common.utils.v.OWNER_DETAIL);
            vVar.s(str, T4(), com.stepos.ailauncher.common.utils.v.OWNER_DETAIL);
            vVar.r(true, com.stepos.ailauncher.common.utils.v.OWNER_DETAIL);
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public String f4() {
        String name = ArtifactDetailActivity.class.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        return name;
    }

    public final String f5() {
        Object objB;
        Object objB2;
        String strB;
        AgentSession.AgentConversation agentConversationR1;
        String strB2;
        AgentSession.AgentConversation agentConversationR12;
        SessionHandler sessionHandler;
        AgentSession.AgentConversation agentConversationR13;
        String strB3;
        String strW4 = W4();
        if (strW4 != null) {
            C4148a.k(TAG, "pinned session from seed=" + strW4, false, 4, null);
            return strW4;
        }
        BaseInputView baseInputViewR0 = InputViewManager.INSTANCE.r0();
        if (baseInputViewR0 != null && (sessionHandler = baseInputViewR0.getSessionHandler()) != null && (agentConversationR13 = sessionHandler.R1()) != null && (strB3 = agentConversationR13.B()) != null) {
            if (strB3.length() <= 0) {
                strB3 = null;
            }
            if (strB3 != null) {
                C4148a.k(TAG, "pinned session from visible input=" + strB3, false, 4, null);
                return strB3;
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            SessionHandler agentSpaceHandler = AgentConfig.INSTANCE.a().getAgentSpaceHandler();
            if (agentSpaceHandler == null || (agentConversationR12 = agentSpaceHandler.R1()) == null || (strB2 = agentConversationR12.B()) == null || strB2.length() <= 0) {
                strB2 = null;
            }
            objB = Result.b(strB2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str != null) {
            C4148a.k(TAG, "pinned session from agent-space handler=" + str, false, 4, null);
            return str;
        }
        try {
            SessionHandler sessionHandler2 = AgentConfig.INSTANCE.a().getSessionHandler();
            if (sessionHandler2 == null || (agentConversationR1 = sessionHandler2.R1()) == null || (strB = agentConversationR1.B()) == null || strB.length() <= 0) {
                strB = null;
            }
            objB2 = Result.b(strB);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        String str2 = (String) objB2;
        if (str2 != null) {
            C4148a.k(TAG, "pinned session from shared handler=" + str2, false, 4, null);
        }
        return str2;
    }

    public final void h5(int level) {
        com.stepos.ailauncher.common.imageloader.g.INSTANCE.F(this, level);
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        ChatRecycleView messageList = launcherChatLayout != null ? launcherChatLayout.getMessageList() : null;
        if (messageList == null || level < 5) {
            return;
        }
        messageList.setItemViewCacheSize(0);
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean i1() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public int j2() {
        if (get_layerIndex() > 1) {
            return 0;
        }
        return super.j2();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        this.pinnedSessionKey = f5();
        super.onCreate(savedInstanceState);
        if (U4() == null) {
            C4148a.u(TAG, "no artifact extra, finish", false, 4, null);
            finish();
        }
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        Z1().getViewTreeObserver().removeOnPreDrawListener(this.inputHostPreDraw);
        this.inputSlot = null;
        C3534n c3534n = this.inputMotion;
        if (c3534n != null) {
            c3534n.d();
        }
        this.inputMotion = null;
        if (!isChangingConfigurations()) {
            InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
        }
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.p7();
        }
        SessionHandler sessionHandler = this.sessionHandler;
        List<String> listT4 = T4();
        LauncherChatLayout launcherChatLayout2 = this.chatLayout;
        if (launcherChatLayout2 != null) {
            launcherChatLayout2.w7();
        }
        this.chatLayout = null;
        this.residentInput = null;
        if (sessionHandler != null) {
            sessionHandler.e3();
        }
        if (isChangingConfigurations() || sessionHandler == null || !C2712o.e(sessionHandler, listT4)) {
            if (!isChangingConfigurations() && com.stepos.ailauncher.chat.manager.Q0.INSTANCE.i()) {
                com.stepos.ailauncher.chat.manager.Q0.n(listT4);
            }
            if (sessionHandler != null) {
                sessionHandler.d3();
            }
        }
        this.sessionHandler = null;
        e5();
        V4().e();
        super.onDestroy();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        e5();
        super.onPause();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        d5();
        Z1().post(new Runnable() { // from class: com.stepos.ailauncher.task.detail.b
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactDetailActivity.b5(this.f28509a);
            }
        });
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        C3534n c3534n = this.inputMotion;
        if (c3534n != null) {
            c3534n.e();
        }
        super.onStop();
        if (isChangingConfigurations()) {
            return;
        }
        h5(20);
        com.stepos.ailauncher.common.memory.e.INSTANCE.q(this, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDetailActivity.c5(this.f28505a, ((Integer) obj).intValue());
            }
        });
    }

    @Override // b.q, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        int iF = com.stepos.ailauncher.common.memory.e.f(com.stepos.ailauncher.common.memory.e.INSTANCE, level, null, 2, null);
        if (iF < 20) {
            return;
        }
        h5(iF);
    }

    @Override // com.stepos.ailauncher.sheet.S
    public Fragment s4() {
        ArtifactDetailFragment artifactDetailFragmentA;
        SessionArtifact sessionArtifactU4 = U4();
        return (sessionArtifactU4 == null || (artifactDetailFragmentA = ArtifactDetailFragment.INSTANCE.a(sessionArtifactU4)) == null) ? new Fragment() : artifactDetailFragmentA;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void u4() {
        g5();
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void v4(FrameLayout slot) {
        kotlin.jvm.internal.p.i(slot, "slot");
        this.inputSlot = slot;
        slot.setClipToPadding(false);
        Z1().getViewTreeObserver().addOnPreDrawListener(this.inputHostPreDraw);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R$id.artifact_input_motion_container);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        slot.addView(frameLayout, new FrameLayout.LayoutParams(-1, -2));
        this.inputMotion = new C3534n(frameLayout);
        Fragment fragmentL0 = getSupportFragmentManager().l0(TAG_RESIDENT_INPUT);
        ChatInputFragment chatInputFragment = fragmentL0 instanceof ChatInputFragment ? (ChatInputFragment) fragmentL0 : null;
        ChatInputFragment chatInputFragmentA = chatInputFragment == null ? ChatInputFragment.INSTANCE.a() : chatInputFragment;
        chatInputFragmentA.z1(true);
        if (chatInputFragment == null) {
            getSupportFragmentManager().q().q(frameLayout.getId(), chatInputFragmentA, TAG_RESIDENT_INPUT).i();
        }
        this.residentInput = chatInputFragmentA;
        chatInputFragmentA.t0(u1());
        chatInputFragmentA.C1(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailActivity.Z4(this.f28646a);
            }
        });
    }

    @Override // com.stepos.ailauncher.sheet.O
    public SheetExitAnim x1() {
        return SheetExitAnim.SLIDE_DOWN;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void y4(Bundle savedInstanceState) {
        M1().setPadding(0, 0, 0, M1().getPaddingBottom());
        Y1().setBackgroundResource(R$drawable.bg_artifact_detail_panel);
        com.stepos.ailauncher.container.glass.h.INSTANCE.k(Y1(), T2());
        Y1().setLayerType(2, null);
        N4();
    }

    @Override // com.stepos.ailauncher.sheet.S
    public String z4() {
        return TAG_ROOT;
    }
}
