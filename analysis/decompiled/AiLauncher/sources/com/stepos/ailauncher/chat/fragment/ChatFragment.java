package com.stepos.ailauncher.chat.fragment;

import O6.ExternalDeviceInfo;
import Ua.C1060i;
import V0.CreationExtras;
import Z8.C1173v;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.C1398p;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import android.view.U;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.controller.TopBarNewSessionTarget;
import com.stepos.ailauncher.chat.fragment.ChatFragment;
import com.stepos.ailauncher.chat.input.ChatStopActions;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2706l;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.AskUserInquiryBinder;
import com.stepos.ailauncher.chat.view.AskUserRequest;
import com.stepos.ailauncher.chat.view.FloatInputView;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.SidebarDataSource;
import com.stepos.ailauncher.chat.view.ToolApprovalRequest;
import com.stepos.ailauncher.chat.view.UnifiedChatHostView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.sheet.SheetSettleState;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 k2\u00020\u0001:\u0001lB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J%\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J!\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u0014¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0014¢\u0006\u0004\b1\u0010/J\u0015\u00102\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0014¢\u0006\u0004\b2\u0010/J\u0017\u00103\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b3\u0010(J\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u0010\u0003J\u0013\u00106\u001a\b\u0012\u0004\u0012\u00020\u000605¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u0014¢\u0006\u0004\b8\u0010*J\r\u00109\u001a\u00020\u000b¢\u0006\u0004\b9\u0010\u0003J\u0015\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0014¢\u0006\u0004\b;\u0010/J\u001d\u0010?\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0014¢\u0006\u0004\b?\u0010@J9\u0010C\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0014H\u0016¢\u0006\u0004\bI\u0010/J\u0017\u0010J\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0014H\u0016¢\u0006\u0004\bJ\u0010/J\u000f\u0010K\u001a\u00020\u000bH\u0016¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u000bH\u0016¢\u0006\u0004\bL\u0010\u0003J\r\u0010M\u001a\u00020\u000b¢\u0006\u0004\bM\u0010\u0003J\u0015\u0010O\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020<¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u0006¢\u0006\u0004\bR\u0010(J\u000f\u0010S\u001a\u00020\u000bH\u0016¢\u0006\u0004\bS\u0010\u0003R\u0018\u0010T\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010VR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010UR\u0018\u0010`\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010UR\u0016\u0010a\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010\u0015R\u0016\u0010c\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010,R\u0016\u0010e\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010,R\u0016\u0010g\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010,R\u0016\u0010i\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010,R\u0013\u0010&\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\bj\u0010,¨\u0006m"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "", "B0", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;", "host", "LY8/t;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;)V", ExifInterface.LONGITUDE_WEST, "z0", "I0", "M0", "agentId", "deviceId", "", "Z", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "O0", "U", "(Ljava/lang/String;Ljava/lang/String;)V", "provided", "A0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "sessionId", "L0", "(Ljava/lang/String;)V", "g0", "()Z", "X", "()Ljava/lang/String;", "sampleVisible", "C0", "(Z)V", "visible", "Q0", "E0", "x0", "w0", "", "Y", "()Ljava/util/List;", "y0", "N0", "keyboardVisible", "h0", "", "imeBottomPx", "showing", "i0", "(IZ)V", "agentDisplayName", "target", "F0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;)V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "onResume", "onStop", "J0", "level", "P0", "(I)V", "reason", "K0", "onDestroyView", "restoredSessionId", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;", "Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel$delegate", "LY8/h;", "a0", "()Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel", "boundHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "currentAgentDisplayName", "currentAgentId", "initialPromptSent", "b0", "initialPrompt", "d0", "launchAgentId", "e0", "launchDeviceId", "c0", "launchAgentDisplayName", "f0", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_AGENT_DISPLAY_NAME = "agent_display_name";
    private static final String ARG_AGENT_ID = "agent_id";
    private static final String ARG_DEVICE_ID = "device_id";
    private static final String ARG_INITIAL_PROMPT = "initial_prompt";
    private static final String ARG_SESSION_ID = "session_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STATE_INITIAL_PROMPT_SENT = "initial_prompt_sent";
    private static final String STATE_SESSION_ID = "restored_session_id";
    private SessionHandler boundHandler;

    /* renamed from: coreViewModel$delegate, reason: from kotlin metadata */
    private final Y8.h coreViewModel;
    private String currentAgentDisplayName;
    private String currentAgentId;
    private UnifiedChatHostView host;
    private boolean initialPromptSent;
    private String restoredSessionId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatFragment$a;", "", "<init>", "()V", "", "sessionId", "initialPrompt", "agentId", "deviceId", "agentDisplayName", "Lcom/stepos/ailauncher/chat/fragment/ChatFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/chat/fragment/ChatFragment;", "ARG_SESSION_ID", "Ljava/lang/String;", "ARG_INITIAL_PROMPT", "ARG_AGENT_ID", "ARG_DEVICE_ID", "ARG_AGENT_DISPLAY_NAME", "STATE_INITIAL_PROMPT_SENT", "STATE_SESSION_ID", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ChatFragment a(String sessionId, String initialPrompt, String agentId, String deviceId, String agentDisplayName) {
            ChatFragment chatFragment = new ChatFragment();
            Bundle bundle = new Bundle();
            if (sessionId != null && sessionId.length() != 0) {
                bundle.putString("session_id", sessionId);
            }
            if (initialPrompt != null && !La.H.x0(initialPrompt)) {
                bundle.putString(ChatFragment.ARG_INITIAL_PROMPT, initialPrompt);
            }
            if (agentId != null && !La.H.x0(agentId)) {
                bundle.putString(ChatFragment.ARG_AGENT_ID, agentId);
            }
            if (deviceId != null && !La.H.x0(deviceId)) {
                bundle.putString("device_id", deviceId);
            }
            if (agentDisplayName != null && !La.H.x0(agentDisplayName)) {
                bundle.putString(ChatFragment.ARG_AGENT_DISPLAY_NAME, agentDisplayName);
            }
            chatFragment.setArguments(bundle);
            return chatFragment;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TopBarNewSessionTarget.values().length];
            try {
                iArr[TopBarNewSessionTarget.AMOO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TopBarNewSessionTarget.CURRENT_EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TopBarNewSessionTarget.CURRENT_INSTALLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$15", f = "ChatFragment.kt", l = {276}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$15, reason: invalid class name */
    public static final class AnonymousClass15 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ View $view;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$15$1", f = "ChatFragment.kt", l = {277}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$15$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ View $view;
            int label;
            final /* synthetic */ ChatFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$15$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ View $view;
                final /* synthetic */ ChatFragment this$0;

                public a(ChatFragment chatFragment, View view) {
                    this.this$0 = chatFragment;
                    this.$view = view;
                }

                public static final void g(ChatFragment chatFragment) {
                    chatFragment.N0();
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return f(((Boolean) obj).booleanValue(), interfaceC4014c);
                }

                public final Object f(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    UnifiedChatHostView unifiedChatHostView = this.this$0.host;
                    if (unifiedChatHostView != null) {
                        unifiedChatHostView.setContentHiddenForWakeFloating(z10);
                    }
                    if (!z10) {
                        View view = this.$view;
                        final ChatFragment chatFragment = this.this$0;
                        view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.Z0
                            @Override // java.lang.Runnable
                            public final void run() {
                                ChatFragment.AnonymousClass15.AnonymousClass1.a.g(chatFragment);
                            }
                        });
                    }
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ChatFragment chatFragment, View view, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = chatFragment;
                this.$view = view;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, this.$view, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Boolean> tVarW = this.this$0.a0().w();
                    a aVar = new a(this.this$0, this.$view);
                    this.label = 1;
                    if (tVarW.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass15(View view, InterfaceC4014c<? super AnonymousClass15> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$view = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ChatFragment.this.new AnonymousClass15(this.$view, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass15) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                LifecycleOwner viewLifecycleOwner = ChatFragment.this.getViewLifecycleOwner();
                kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ChatFragment.this, this.$view, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatFragment$onViewCreated$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements InterfaceC5063a<String> {
        public AnonymousClass6(Object obj) {
            super(0, obj, ChatFragment.class, "currentLiveSessionId", "currentLiveSessionId()Ljava/lang/String;", 0);
        }

        @Override // p9.InterfaceC5063a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return ((ChatFragment) this.receiver).X();
        }
    }

    public ChatFragment() {
        super(R$layout.fragment_chat_sheet);
        final InterfaceC5063a interfaceC5063a = null;
        this.coreViewModel = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.t.b(I0.class), new InterfaceC5063a<android.view.V>() { // from class: com.stepos.ailauncher.chat.fragment.ChatFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final android.view.V invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new InterfaceC5063a<CreationExtras>() { // from class: com.stepos.ailauncher.chat.fragment.ChatFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                InterfaceC5063a interfaceC5063a2 = interfaceC5063a;
                return (interfaceC5063a2 == null || (creationExtras = (CreationExtras) interfaceC5063a2.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new InterfaceC5063a<U.c>() { // from class: com.stepos.ailauncher.chat.fragment.ChatFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final U.c invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    public static /* synthetic */ void D0(ChatFragment chatFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        chatFragment.C0(z10);
    }

    public static /* synthetic */ void G0(ChatFragment chatFragment, String str, String str2, String str3, UnifiedChatHostView unifiedChatHostView, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 8) != 0) {
            unifiedChatHostView = chatFragment.host;
        }
        chatFragment.F0(str, str2, str3, unifiedChatHostView);
    }

    public static final void H0(UnifiedChatHostView unifiedChatHostView, String str, String str2, String str3) {
        String str4;
        unifiedChatHostView.getChatLayout().d8();
        unifiedChatHostView.getChatLayout().J3(false, str, str2);
        if (str3 != null) {
            str4 = "< " + str3 + " >";
        } else {
            str4 = null;
        }
        unifiedChatHostView.p1(str4);
    }

    public static final Y8.t T(ChatFragment chatFragment) throws Resources.NotFoundException {
        androidx.fragment.app.r activity = chatFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.Z8();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t V(String str, String str2, ChatFragment chatFragment, Result result) {
        UnifiedChatHostView unifiedChatHostView;
        Object value = result.getValue();
        if (Result.g(value)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool == null) {
            return Y8.t.f7040a;
        }
        SidebarDataSource.INSTANCE.e(str, str2, bool.booleanValue());
        String str3 = chatFragment.currentAgentId;
        if (La.D.L(str3 != null ? La.H.D1(str3).toString() : null, La.H.D1(str2).toString(), true) && (unifiedChatHostView = chatFragment.host) != null) {
            unifiedChatHostView.n1(chatFragment.currentAgentDisplayName, bool);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I0 a0() {
        return (I0) this.coreViewModel.getValue();
    }

    private final String c0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_AGENT_DISPLAY_NAME)) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    private final String d0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_AGENT_ID)) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    private final String e0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("device_id")) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    public static final void j0(ChatFragment chatFragment) {
        if (chatFragment.isAdded()) {
            chatFragment.N0();
        }
    }

    public static final void k0(ChatFragment chatFragment) {
        chatFragment.N0();
    }

    public static final void l0(ChatFragment chatFragment, SheetSettleState sheetSettleState) {
        UnifiedChatHostView unifiedChatHostView;
        LauncherChatLayout chatLayout;
        chatFragment.N0();
        if (sheetSettleState != SheetSettleState.HALF || (unifiedChatHostView = chatFragment.host) == null || (chatLayout = unifiedChatHostView.getChatLayout()) == null) {
            return;
        }
        chatLayout.H8();
    }

    public static final Y8.t m0(ChatFragment chatFragment) throws Resources.NotFoundException {
        androidx.fragment.app.r activity = chatFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.g8();
        }
        androidx.fragment.app.r activity2 = chatFragment.getActivity();
        ChatActivity chatActivity2 = activity2 instanceof ChatActivity ? (ChatActivity) activity2 : null;
        if (chatActivity2 != null) {
            chatActivity2.g1();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t n0(ChatFragment chatFragment, List artifacts) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        ChatTracker.INSTANCE.c(chatFragment.X());
        androidx.fragment.app.r activity = chatFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.o8(chatFragment.X(), new ArrayList<>(artifacts));
        }
        return Y8.t.f7040a;
    }

    public static final void o0(ChatFragment chatFragment) {
        chatFragment.N0();
    }

    public static final Y8.t p0(ChatFragment chatFragment, boolean z10) {
        chatFragment.a0().F(z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t q0(ChatFragment chatFragment, String str) {
        androidx.fragment.app.r activity = chatFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.ea(str);
        }
        chatFragment.M0();
        return Y8.t.f7040a;
    }

    public static final boolean r0(ChatFragment chatFragment, AskUserRequest req) {
        kotlin.jvm.internal.p.i(req, "req");
        chatFragment.a0().B(req);
        return true;
    }

    public static final boolean s0(ChatFragment chatFragment, ToolApprovalRequest req) {
        kotlin.jvm.internal.p.i(req, "req");
        chatFragment.a0().D(req);
        return true;
    }

    public static final Y8.t t0(ChatFragment chatFragment, String str) {
        chatFragment.a0().y(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t u0(ChatFragment chatFragment) throws Resources.NotFoundException {
        ChatTracker.INSTANCE.E(chatFragment.X(), ChatTracker.TOPBAR_SIDEBAR);
        androidx.fragment.app.r activity = chatFragment.getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.Z8();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t v0(ChatFragment chatFragment) {
        ChatTracker.INSTANCE.E(chatFragment.X(), ChatTracker.TOPBAR_NEW_CHAT);
        chatFragment.I0();
        return Y8.t.f7040a;
    }

    public final String A0(String agentId, String provided, String deviceId) {
        String displayName;
        Object next;
        String displayName2;
        List<ExternalDeviceInfo> listA;
        Object next2;
        String deviceName;
        String str;
        if (provided != null) {
            if (La.H.x0(provided)) {
                provided = null;
            }
            if (provided != null) {
                return provided;
            }
        }
        String string = agentId != null ? La.H.D1(agentId).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return null;
        }
        String str2 = this.currentAgentId;
        if (La.D.L(string, str2 != null ? La.H.D1(str2).toString() : null, true) && (str = this.currentAgentDisplayName) != null) {
            return str;
        }
        if (deviceId != null && !La.H.x0(deviceId)) {
            O6.i iVarC = O6.a.INSTANCE.c();
            if (iVarC != null && (listA = iVarC.a()) != null) {
                Iterator<T> it = listA.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    ExternalDeviceInfo externalDeviceInfo = (ExternalDeviceInfo) next2;
                    if (La.D.L(La.H.D1(externalDeviceInfo.getDeviceId()).toString(), La.H.D1(deviceId).toString(), true) && La.D.L(La.H.D1(externalDeviceInfo.getAgent()).toString(), string, true)) {
                        break;
                    }
                }
                ExternalDeviceInfo externalDeviceInfo2 = (ExternalDeviceInfo) next2;
                if (externalDeviceInfo2 != null && (deviceName = externalDeviceInfo2.getDeviceName()) != null) {
                    if (La.H.x0(deviceName)) {
                        deviceName = null;
                    }
                    if (deviceName != null) {
                        return deviceName;
                    }
                }
            }
            Iterator<T> it2 = SidebarDataSource.INSTANCE.a().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                IExternalAgentBindService.SidebarAgent sidebarAgent = (IExternalAgentBindService.SidebarAgent) next;
                if (La.D.L(La.H.D1(sidebarAgent.getDeviceId()).toString(), La.H.D1(deviceId).toString(), true) && La.D.L(La.H.D1(sidebarAgent.getAgentType()).toString(), string, true)) {
                    break;
                }
            }
            IExternalAgentBindService.SidebarAgent sidebarAgent2 = (IExternalAgentBindService.SidebarAgent) next;
            if (sidebarAgent2 != null && (displayName2 = sidebarAgent2.getDisplayName()) != null) {
                String str3 = La.H.x0(displayName2) ? null : displayName2;
                if (str3 != null) {
                    return str3;
                }
            }
        }
        ExternalAgent externalAgentB = ExternalAgent.INSTANCE.b(string);
        return (externalAgentB == null || (displayName = externalAgentB.getDisplayName()) == null) ? com.stepos.ailauncher.chat.wake.L.INSTANCE.a(string) : displayName;
    }

    public final String B0(SessionHandler handler) {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        String strF0 = f0();
        if (strF0 != null) {
            return strF0;
        }
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if ((chatActivity != null && chatActivity.getLockScreenMode()) || d0() != null) {
            return null;
        }
        if ((b0() == null || this.initialPromptSent) && (agentConversationR1 = handler.R1()) != null && (strB = agentConversationR1.B()) != null) {
            if (strB.length() <= 0) {
                strB = null;
            }
            if (strB != null) {
                C4148a.k("ChatFragment", "no session arg, adopt handler session " + strB, false, 4, null);
                return strB;
            }
        }
        return null;
    }

    public final void C0(boolean sampleVisible) {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.h1(sampleVisible);
        }
    }

    public final void E0(boolean visible) {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.setConversationPageVisible(visible);
        }
    }

    public final void F0(final String agentId, final String deviceId, String agentDisplayName, final UnifiedChatHostView target) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        if (target == null) {
            return;
        }
        UnifiedChatHostView.i1(target, false, 1, null);
        boolean z10 = agentId == null || La.H.x0(agentId);
        boolean z11 = !z10;
        final String strA0 = !z10 ? A0(agentId, agentDisplayName, deviceId) : null;
        this.currentAgentId = (agentId == null || z10) ? null : agentId;
        this.currentAgentDisplayName = strA0;
        a0().G(z11);
        target.setExternalSessionHome(z11);
        target.n1(strA0, O0(agentId, deviceId));
        U(agentId, deviceId);
        a0().y(null);
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.h8();
        }
        target.post(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.P0
            @Override // java.lang.Runnable
            public final void run() {
                ChatFragment.H0(target, agentId, deviceId, strA0);
            }
        });
    }

    public final void I0() {
        SessionHandler sessionHandler = this.boundHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String agentId = agentConversationR1 != null ? agentConversationR1.getAgentId() : null;
        String deviceId = agentConversationR1 != null ? agentConversationR1.getDeviceId() : null;
        String string = agentId != null ? La.H.D1(agentId).toString() : null;
        String str = string == null ? "" : string;
        boolean zB = com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId);
        TopBarNewSessionTarget topBarNewSessionTargetA = com.stepos.ailauncher.chat.controller.J0.a(zB, deviceId, (deviceId == null || La.H.x0(deviceId)) && str.length() > 0 && !PrimaryAgent.INSTANCE.a(str) && !zB);
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null && unifiedChatHostView.I0()) {
            com.stepos.agentframework.chatui.util.d dVar = com.stepos.agentframework.chatui.util.d.INSTANCE;
            Context contextRequireContext = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
            dVar.v(contextRequireContext, R$string.toast_already_new_chat, this.host);
            return;
        }
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.e7();
        }
        int i10 = b.$EnumSwitchMapping$0[topBarNewSessionTargetA.ordinal()];
        if (i10 == 1) {
            G0(this, null, null, null, null, 14, null);
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            G0(this, str, null, null, null, 14, null);
        } else {
            if (deviceId == null) {
                deviceId = "";
            }
            G0(this, agentId, deviceId, null, null, 12, null);
        }
    }

    public final void J0() {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.u1();
        }
    }

    public final void K0(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        SessionHandler sessionHandler = this.boundHandler;
        if (sessionHandler == null || !ChatStopActions.INSTANCE.j(sessionHandler)) {
            return;
        }
        C4148a.k("ChatFragment", "suppressInFlightRoundTts: " + reason, false, 4, null);
        com.stepos.ailauncher.chat.tts.a.INSTANCE.a();
        J0();
    }

    public final void L0(String sessionId) {
        ChatInputFragment residentInput;
        FloatInputView floatInputViewY0;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        com.stepos.ailauncher.common.utils.v.INSTANCE.c();
        SessionHandler sessionHandler = this.boundHandler;
        if (sessionHandler == null) {
            return;
        }
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null && (residentInput = chatActivity.getResidentInput()) != null && (floatInputViewY0 = residentInput.getInputView()) != null) {
            floatInputViewY0.d();
        }
        a0().y(sessionId);
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null) {
            C2739j.d(sessionId);
            sessionHandler.N0(sessionId);
            return;
        }
        if (unifiedChatHostView.v1(sessionId) || unifiedChatHostView.M0()) {
            return;
        }
        C4148a.k("ChatFragment", "AIOSBUG-13471 already on session " + sessionId + " active=" + sessionHandler.i2(sessionId), false, 4, null);
        unifiedChatHostView.g1("already-on-session");
    }

    public final void M0() {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null) {
            return;
        }
        SessionHandler sessionHandler = this.boundHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String agentId = agentConversationR1 != null ? agentConversationR1.getAgentId() : null;
        String deviceId = agentConversationR1 != null ? agentConversationR1.getDeviceId() : null;
        if (deviceId == null) {
            deviceId = "";
        }
        String string = agentId != null ? La.H.D1(agentId).toString() : null;
        String str = string != null ? string : "";
        if (str.length() <= 0 || PrimaryAgent.INSTANCE.a(str)) {
            this.currentAgentId = null;
            this.currentAgentDisplayName = null;
            unifiedChatHostView.setExternalSessionHome(false);
            UnifiedChatHostView.o1(unifiedChatHostView, null, null, 2, null);
            a0().G(false);
            return;
        }
        String strA0 = A0(agentId, null, deviceId);
        this.currentAgentId = str;
        this.currentAgentDisplayName = strA0;
        unifiedChatHostView.setExternalSessionHome(true);
        unifiedChatHostView.n1(strA0, O0(agentId, deviceId));
        U(agentId, deviceId);
        a0().G(true);
    }

    public final void N0() {
        LauncherChatLayout chatLayout;
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null || (chatLayout = unifiedChatHostView.getChatLayout()) == null) {
            return;
        }
        chatLayout.c9();
    }

    public final Boolean O0(String agentId, String deviceId) {
        if (!com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId) || La.H.x0(deviceId)) {
            return null;
        }
        Boolean boolZ = Z(agentId, deviceId);
        return Boolean.valueOf(boolZ != null ? boolZ.booleanValue() : false);
    }

    public final void P0(int level) {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.B1(level);
        }
    }

    public final void Q0(boolean visible) {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.E1(visible);
        }
    }

    public final void S(UnifiedChatHostView host) {
        host.setOnSidebarClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.M0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatFragment.T(this.f25192a);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ChatFragment$bindSidebarKey$2(this, null), 3, null);
    }

    public final void U(final String agentId, final String deviceId) {
        IExternalAgentBindService iExternalAgentBindService;
        if (agentId != null) {
            if (!com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId)) {
                agentId = null;
            }
            if (agentId == null || La.H.x0(deviceId) || (iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class)) == null) {
                return;
            }
            iExternalAgentBindService.queryDeviceAgentOnline(deviceId, agentId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.L0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatFragment.V(deviceId, agentId, this, (Result) obj);
                }
            });
        }
    }

    public final void W(UnifiedChatHostView host) {
        String strD0 = d0();
        if (strD0 == null) {
            return;
        }
        String strE0 = e0();
        if (strE0 == null) {
            strE0 = "";
        }
        F0(strD0, strE0, c0(), host);
    }

    public final String X() {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        SessionHandler sessionHandler = this.boundHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (strB = agentConversationR1.B()) == null || strB.length() <= 0) {
            return null;
        }
        return strB;
    }

    public final List<String> Y() {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = this.boundHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return C1173v.m();
        }
        List listR = C1173v.r(agentConversationR1.B(), agentConversationR1.getSessionId(), agentConversationR1.getTempSessionId());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return Z8.F.g0(arrayList);
    }

    public final Boolean Z(String agentId, String deviceId) {
        O6.i iVarC;
        List<ExternalDeviceInfo> listA;
        Object next;
        if (com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId) && deviceId != null && !La.H.x0(deviceId) && (iVarC = O6.a.INSTANCE.c()) != null && (listA = iVarC.a()) != null) {
            Iterator<T> it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ExternalDeviceInfo externalDeviceInfo = (ExternalDeviceInfo) next;
                if (La.D.L(La.H.D1(externalDeviceInfo.getDeviceId()).toString(), La.H.D1(deviceId).toString(), true)) {
                    if (La.D.L(La.H.D1(externalDeviceInfo.getAgent()).toString(), agentId != null ? La.H.D1(agentId).toString() : null, true)) {
                        break;
                    }
                }
            }
            ExternalDeviceInfo externalDeviceInfo2 = (ExternalDeviceInfo) next;
            if (externalDeviceInfo2 != null) {
                return Boolean.valueOf(externalDeviceInfo2.getOnline());
            }
        }
        return null;
    }

    public final String b0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_INITIAL_PROMPT)) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    public final String f0() {
        String string;
        String str = this.restoredSessionId;
        if (str == null) {
            Bundle arguments = getArguments();
            str = null;
            if (arguments != null && (string = arguments.getString("session_id")) != null && string.length() > 0) {
                return string;
            }
        }
        return str;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void g(boolean visible) {
        LauncherChatLayout chatLayout;
        if (visible) {
            N0();
            View view = getView();
            if (view != null) {
                view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.N0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatFragment.k0(this.f25194a);
                    }
                });
            }
            UnifiedChatHostView unifiedChatHostView = this.host;
            if (unifiedChatHostView == null || (chatLayout = unifiedChatHostView.getChatLayout()) == null) {
                return;
            }
            chatLayout.M8();
        }
    }

    public final boolean g0() {
        UnifiedChatHostView unifiedChatHostView = this.host;
        return unifiedChatHostView != null && unifiedChatHostView.M0();
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void h(boolean keyboardVisible) {
        LauncherChatLayout chatLayout;
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null && (chatLayout = unifiedChatHostView.getChatLayout()) != null) {
            chatLayout.q5(keyboardVisible);
        }
        N0();
        View view = getView();
        if (view != null) {
            view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.J0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatFragment.j0(this.f25182a);
                }
            });
        }
    }

    public final void h0(boolean keyboardVisible) {
        LauncherChatLayout chatLayout;
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null || (chatLayout = unifiedChatHostView.getChatLayout()) == null) {
            return;
        }
        chatLayout.p5(keyboardVisible);
    }

    public final void i0(int imeBottomPx, boolean showing) {
        LauncherChatLayout chatLayout;
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null || (chatLayout = unifiedChatHostView.getChatLayout()) == null) {
            return;
        }
        chatLayout.C8(imeBottomPx, showing);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void k(final SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.n0(state);
        }
        a0().L(state);
        View view = getView();
        if (view != null) {
            view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.O0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatFragment.l0(this.f25198a, state);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SessionHandler sessionHandler = this.boundHandler;
        String strX = X();
        this.restoredSessionId = strX;
        if (sessionHandler != null && strX != null && sessionHandler.i2(strX)) {
            AgentConfig.INSTANCE.a().y(strX, sessionHandler);
            C4148a.k("ChatFragment", "stash in-flight handler sessionId=" + strX + " handler=" + sessionHandler.hashCode() + " pending=" + sessionHandler.Q2(), false, 4, null);
        }
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.Z0();
        }
        a0().e();
        this.host = null;
        this.boundHandler = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        UnifiedChatHostView unifiedChatHostView;
        super.onResume();
        UnifiedChatHostView unifiedChatHostView2 = this.host;
        if (unifiedChatHostView2 != null) {
            unifiedChatHostView2.e1();
        }
        UnifiedChatHostView unifiedChatHostView3 = this.host;
        if ((unifiedChatHostView3 == null || !unifiedChatHostView3.M0()) && (unifiedChatHostView = this.host) != null) {
            unifiedChatHostView.E0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        outState.putBoolean(STATE_INITIAL_PROMPT_SENT, this.initialPromptSent);
        String strX = X();
        if (strX == null) {
            strX = this.restoredSessionId;
        }
        outState.putString(STATE_SESSION_ID, strX);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (com.stepos.ailauncher.chat.tts.f.INSTANCE.q()) {
            return;
        }
        J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Object objB;
        Intent intent;
        Intent intent2;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        boolean z10 = chatActivity != null && chatActivity.getLockScreenMode();
        if (z10) {
            string = null;
        } else if (savedInstanceState == null || (string = savedInstanceState.getString(STATE_SESSION_ID)) == null) {
            string = this.restoredSessionId;
        }
        this.restoredSessionId = string;
        this.initialPromptSent = savedInstanceState != null ? savedInstanceState.getBoolean(STATE_INITIAL_PROMPT_SENT, false) : false;
        UnifiedChatHostView unifiedChatHostView = (UnifiedChatHostView) view.findViewById(R$id.unifiedChatHost);
        this.host = unifiedChatHostView;
        unifiedChatHostView.getChatLayout().setKeyboardScrollManagedExternally(true);
        com.stepos.ailauncher.sheet.S sT = t();
        if (sT != null) {
            unifiedChatHostView.getChatLayout().setAutomaticBottomScrollPaused(sT.V1().getValue().booleanValue());
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ChatFragment$onViewCreated$1$1(sT, unifiedChatHostView, null), 3, null);
        }
        androidx.fragment.app.r activity2 = getActivity();
        boolean zA = P1.a(z10, (activity2 == null || (intent2 = activity2.getIntent()) == null || !intent2.getBooleanExtra("com.stepos.ailauncher.chat.sheet.IS_WAKE", false)) ? false : true, f0() != null, (d0() == null && b0() == null) ? false : true);
        AgentConfig.Companion companion = AgentConfig.INSTANCE;
        SessionHandler sessionHandlerI = companion.a().i(zA, f0());
        if (sessionHandlerI == null) {
            String strF0 = f0();
            sessionHandlerI = strF0 != null ? C2706l.INSTANCE.a().e(strF0) : null;
            if (sessionHandlerI == null) {
                sessionHandlerI = companion.a().q();
            }
        }
        SessionHandler sessionHandler = sessionHandlerI;
        this.boundHandler = sessionHandler;
        String strB0 = B0(sessionHandler);
        unifiedChatHostView.setOnEmptyStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.Q0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatFragment.p0(this.f25208a, ((Boolean) obj).booleanValue());
            }
        });
        unifiedChatHostView.setOnConversationChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.R0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatFragment.q0(this.f25209a, (String) obj);
            }
        });
        AskUserInquiryBinder askUserInquiryBinder = AskUserInquiryBinder.INSTANCE;
        askUserInquiryBinder.g(unifiedChatHostView.getChatLayout(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.S0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatFragment.r0(this.f25211a, (AskUserRequest) obj));
            }
        });
        askUserInquiryBinder.e(unifiedChatHostView.getChatLayout(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.T0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ChatFragment.s0(this.f25215a, (ToolApprovalRequest) obj));
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        unifiedChatHostView.o0(sessionHandler, viewLifecycleOwner2, strB0 != null);
        askUserInquiryBinder.n(unifiedChatHostView.getChatLayout(), new AnonymousClass6(this), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.U0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatFragment.t0(this.f25219a, (String) obj);
            }
        });
        androidx.fragment.app.r activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null && intent.getBooleanExtra("com.stepos.ailauncher.chat.sheet.RESTORE_LAST_SESSION", false)) {
            unifiedChatHostView.U0(strB0);
        }
        if (strB0 != null) {
            if (unifiedChatHostView.J0(strB0)) {
                C4148a.k("ChatFragment", "reuse in-flight session " + strB0 + " active=" + sessionHandler.i2(strB0) + " handler=" + sessionHandler.hashCode(), false, 4, null);
                unifiedChatHostView.g1("reuse-in-flight");
            } else {
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    unifiedChatHostView.getChatLayout().U4(strB0);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t("ChatFragment", "loadConversation failed", thE, false, 8, null);
                }
                Result.a(objB);
            }
        }
        androidx.fragment.app.r activity4 = getActivity();
        ChatActivity chatActivity2 = activity4 instanceof ChatActivity ? (ChatActivity) activity4 : null;
        if (chatActivity2 != null) {
            ChatActivity.fa(chatActivity2, null, 1, null);
        }
        kotlin.jvm.internal.p.f(unifiedChatHostView);
        S(unifiedChatHostView);
        unifiedChatHostView.setOnSidebarClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.V0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatFragment.u0(this.f25221a);
            }
        });
        unifiedChatHostView.setOnNewSessionClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.W0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatFragment.v0(this.f25224a);
            }
        });
        unifiedChatHostView.setOnCloseClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.X0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatFragment.m0(this.f25226a);
            }
        });
        unifiedChatHostView.setOnOpenArtifacts(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.Y0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatFragment.n0(this.f25229a, (List) obj);
            }
        });
        W(unifiedChatHostView);
        z0();
        a0().A(unifiedChatHostView.getChatLayout(), sessionHandler);
        view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.K0
            @Override // java.lang.Runnable
            public final void run() {
                ChatFragment.o0(this.f25184a);
            }
        });
        SheetSettleState sheetSettleStateS = s();
        if (sheetSettleStateS != null) {
            a0().L(sheetSettleStateS);
            unifiedChatHostView.n0(sheetSettleStateS);
        }
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner3), null, null, new AnonymousClass15(view, null), 3, null);
    }

    public final void w0() {
        LauncherChatLayout chatLayout;
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null || (chatLayout = unifiedChatHostView.getChatLayout()) == null) {
            return;
        }
        chatLayout.I8();
    }

    public final void x0(String sessionId) {
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView != null) {
            unifiedChatHostView.U0(sessionId);
        }
        w0();
    }

    public final boolean y0() {
        Object objB;
        UnifiedChatHostView unifiedChatHostView = this.host;
        if (unifiedChatHostView == null) {
            return false;
        }
        List<String> listY = Y();
        com.stepos.ailauncher.chat.manager.Q0 q02 = com.stepos.ailauncher.chat.manager.Q0.INSTANCE;
        List<String> list = listY;
        Long lG = q02.g(list);
        if (!q02.h(list) && lG == null) {
            return false;
        }
        C4148a.k("ChatFragment", "external edit hit -> reload messages", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            unifiedChatHostView.getChatLayout().T();
            if (lG != null) {
                unifiedChatHostView.getChatLayout().X7(lG.longValue());
            }
            unifiedChatHostView.getChatLayout().Y5(false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE == null) {
            return true;
        }
        C4148a.t("ChatFragment", "reload after external edit failed", thE, false, 8, null);
        return true;
    }

    public final void z0() {
        String strB0 = b0();
        if (strB0 == null || this.initialPromptSent) {
            return;
        }
        this.initialPromptSent = true;
        a0().C(strB0);
    }
}
