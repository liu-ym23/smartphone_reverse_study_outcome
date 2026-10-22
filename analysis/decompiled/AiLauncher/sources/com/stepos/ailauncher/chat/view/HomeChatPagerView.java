package com.stepos.ailauncher.chat.view;

import O6.ExternalDeviceInfo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.chat.controller.InterfaceC2538f;
import com.stepos.ailauncher.chat.controller.TopBarNewSessionTarget;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.sheet.SheetSettleState;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0004\u009a\u0001 \u0001\u0018\u0000 £\u00012\u00020\u0001:\u0006¤\u0001¥\u0001¦\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u0018J\r\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010\u0018J\r\u0010#\u001a\u00020\u0015¢\u0006\u0004\b#\u0010 J\u0017\u0010%\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0015¢\u0006\u0004\b(\u0010\u0018J\r\u0010)\u001a\u00020\u0015¢\u0006\u0004\b)\u0010 J\u0017\u0010,\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u0015¢\u0006\u0004\b2\u0010&J\r\u00103\u001a\u00020\u0012¢\u0006\u0004\b3\u0010\u001dJ)\u00107\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010*2\u0006\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u00010*¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u00122\u0006\u00109\u001a\u00020*¢\u0006\u0004\b:\u0010-J\u000f\u0010;\u001a\u00020\u0012H\u0002¢\u0006\u0004\b;\u0010\u001dJ\u001f\u0010=\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0012H\u0002¢\u0006\u0004\b?\u0010\u001dJ\u000f\u0010@\u001a\u00020\u0012H\u0002¢\u0006\u0004\b@\u0010\u001dJ\u001d\u0010D\u001a\u00020\u00122\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002¢\u0006\u0004\bD\u0010EJ\u0011\u0010F\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u00122\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bH\u0010-J\u000f\u0010I\u001a\u00020\u0012H\u0002¢\u0006\u0004\bI\u0010\u001dJ/\u0010J\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010*2\b\b\u0002\u00105\u001a\u00020*2\n\b\u0002\u00106\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\bJ\u00108J\u000f\u0010K\u001a\u00020\u0012H\u0002¢\u0006\u0004\bK\u0010\u001dJ#\u0010L\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010*2\u0006\u00105\u001a\u00020*H\u0002¢\u0006\u0004\bL\u0010MJ%\u0010N\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u00010*2\b\u00105\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\bN\u0010MJ!\u0010O\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010*2\u0006\u00105\u001a\u00020*H\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0012H\u0002¢\u0006\u0004\bQ\u0010\u001dJ'\u0010R\u001a\u0004\u0018\u00010*2\b\u00104\u001a\u0004\u0018\u00010*2\n\b\u0002\u00105\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R\u0017\u0010^\u001a\u00020]8\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0017\u0010c\u001a\u00020b8\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0018\u0010g\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010kR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR0\u0010t\u001a\u0010\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020\u0012\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR+\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R/\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0081\u0001\u0010|\u001a\u0005\b\u0082\u0001\u0010~\"\u0006\b\u0083\u0001\u0010\u0080\u0001R6\u0010\u0084\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020\u0012\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010u\u001a\u0005\b\u0085\u0001\u0010w\"\u0005\b\u0086\u0001\u0010yR4\u0010\u0087\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010u\u001a\u0005\b\u0088\u0001\u0010w\"\u0005\b\u0089\u0001\u0010yR4\u0010\u008a\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010u\u001a\u0005\b\u008b\u0001\u0010w\"\u0005\b\u008c\u0001\u0010yR4\u0010\u008d\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010u\u001a\u0005\b\u008e\u0001\u0010w\"\u0005\b\u008f\u0001\u0010yR4\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010u\u001a\u0005\b\u0091\u0001\u0010w\"\u0005\b\u0092\u0001\u0010yR/\u0010\u0093\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0093\u0001\u0010|\u001a\u0005\b\u0094\u0001\u0010~\"\u0006\b\u0095\u0001\u0010\u0080\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010\u001fR\u0018\u0010\u0097\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010\u001fR\u0018\u0010\u0098\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010\u001fR\u0018\u0010\u0099\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010\u001fR\u0018\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001¨\u0006§\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/view/HomeChatPagerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "inquiryInput", "Landroid/view/View;", "overlaySlot", "LY8/t;", "C", "(Landroidx/lifecycle/LifecycleOwner;Lcom/stepos/agentframework/chatcore/SessionHandler;Lcom/stepos/ailauncher/chat/view/BaseInputView;Landroid/view/View;)V", "", "shown", "setPanelShown", "(Z)V", "smooth", "q0", "n0", "e0", "()V", "U", "Z", "()Z", "visible", "setConversationPageVisible", "a0", "animate", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Z)Z", "imeVisible", "z", "B", "", "sessionId", "i0", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "c0", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "R", "g0", "agentId", "deviceId", "agentDisplayName", "O", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", HighlightArgsBundle.KEY_PROMPT, "P", "z0", "page", "p0", "(IZ)V", "Y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifacts", "j0", "(Ljava/util/List;)V", "b0", "()Ljava/lang/String;", "x0", "v0", "s0", "w0", "A0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "X", "M", "(Ljava/lang/String;Ljava/lang/String;)V", "y0", "h0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroidx/viewpager2/widget/ViewPager2;", "pager", "Landroidx/viewpager2/widget/ViewPager2;", "Lcom/stepos/ailauncher/chat/view/D5;", "scrollHost", "Lcom/stepos/ailauncher/chat/view/D5;", "currentAgentDisplayName", "Ljava/lang/String;", "currentAgentId", "Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;", "chatHost", "Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;", "getChatHost", "()Lcom/stepos/ailauncher/chat/view/UnifiedChatHostView;", "Lcom/stepos/ailauncher/chat/view/SessionCenterView;", "sessionCenter", "Lcom/stepos/ailauncher/chat/view/SessionCenterView;", "getSessionCenter", "()Lcom/stepos/ailauncher/chat/view/SessionCenterView;", "boundHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Ljava/lang/Runnable;", "recheckAskUserRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/ailauncher/chat/view/ArtifactsView;", "artifactsView", "Lcom/stepos/ailauncher/chat/view/ArtifactsView;", "Lkotlin/Function1;", "", "onPagerFraction", "Lp9/l;", "getOnPagerFraction", "()Lp9/l;", "setOnPagerFraction", "(Lp9/l;)V", "Lkotlin/Function0;", "onCloseRequested", "Lp9/a;", "getOnCloseRequested", "()Lp9/a;", "setOnCloseRequested", "(Lp9/a;)V", "onConversationSwitch", "getOnConversationSwitch", "setOnConversationSwitch", "onConversationChanged", "getOnConversationChanged", "setOnConversationChanged", "onExternalSessionChanged", "getOnExternalSessionChanged", "setOnExternalSessionChanged", "onArtifactsModeChanged", "getOnArtifactsModeChanged", "setOnArtifactsModeChanged", "onSettledPageChanged", "getOnSettledPageChanged", "setOnSettledPageChanged", "onSessionSearchActiveChanged", "getOnSessionSearchActiveChanged", "setOnSessionSearchActiveChanged", "onLeaveChatPage", "getOnLeaveChatPage", "setOnLeaveChatPage", "searchMode", "collapsedNow", "panelShown", "sessionCenterRevealed", "com/stepos/ailauncher/chat/view/HomeChatPagerView$e", "pageChangeCallback", "Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$e;", "Lcom/stepos/ailauncher/chat/view/e4;", "pagerSpring", "Lcom/stepos/ailauncher/chat/view/e4;", "com/stepos/ailauncher/chat/view/HomeChatPagerView$f", "sessionCenterHost", "Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$f;", "Companion", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeChatPagerView extends FrameLayout {
    public static final int PAGE_CHAT = 1;
    private static final int PAGE_COUNT = 2;
    public static final int PAGE_SESSION_CENTER = 0;
    private static final String TAG = "RestoreTrace";
    private ArtifactsView artifactsView;
    private SessionHandler boundHandler;
    private final UnifiedChatHostView chatHost;
    private boolean collapsedNow;
    private String currentAgentDisplayName;
    private String currentAgentId;
    private BaseInputView inquiryInput;
    private LifecycleOwner lifecycleOwner;
    private InterfaceC5074l<? super Boolean, Y8.t> onArtifactsModeChanged;
    private InterfaceC5063a<Y8.t> onCloseRequested;
    private InterfaceC5074l<? super String, Y8.t> onConversationChanged;
    private InterfaceC5063a<Y8.t> onConversationSwitch;
    private InterfaceC5074l<? super Boolean, Y8.t> onExternalSessionChanged;
    private InterfaceC5063a<Y8.t> onLeaveChatPage;
    private InterfaceC5074l<? super Float, Y8.t> onPagerFraction;
    private InterfaceC5074l<? super Boolean, Y8.t> onSessionSearchActiveChanged;
    private InterfaceC5074l<? super Boolean, Y8.t> onSettledPageChanged;
    private final e pageChangeCallback;
    private final ViewPager2 pager;
    private final C2804e4 pagerSpring;
    private boolean panelShown;
    private final Runnable recheckAskUserRunnable;
    private final D5 scrollHost;
    private boolean searchMode;
    private final SessionCenterView sessionCenter;
    private final f sessionCenterHost;
    private boolean sessionCenterRevealed;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.jvm.internal.p.i(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$b;", "<init>", "(Lcom/stepos/ailauncher/chat/view/HomeChatPagerView;)V", "", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$b;", "holder", "LY8/t;", "c", "(Lcom/stepos/ailauncher/chat/view/HomeChatPagerView$b;I)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class c extends RecyclerView.Adapter<b> {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b holder, int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            HomeChatPagerView homeChatPagerView = HomeChatPagerView.this;
            View sessionCenter = viewType == 0 ? homeChatPagerView.getSessionCenter() : homeChatPagerView.getChatHost();
            ViewParent parent2 = sessionCenter.getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup != null) {
                viewGroup.removeView(sessionCenter);
            }
            sessionCenter.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            return new b(sessionCenter);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
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

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/view/HomeChatPagerView$e", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "", "positionOffset", "positionOffsetPixels", "LY8/t;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "onPageScrollStateChanged", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends ViewPager2.i {
        public e() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int state) {
            if (state == 1) {
                HomeChatPagerView.this.Y();
            }
            if (state == 0) {
                HomeChatPagerView.this.z0();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            InterfaceC5074l<Float, Y8.t> onPagerFraction = HomeChatPagerView.this.getOnPagerFraction();
            if (onPagerFraction != null) {
                onPagerFraction.invoke(Float.valueOf(C5685n.m(position + positionOffset, 0.0f, 1.0f)));
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            InterfaceC5074l<Boolean, Y8.t> onSettledPageChanged = HomeChatPagerView.this.getOnSettledPageChanged();
            if (onSettledPageChanged != null) {
                onSettledPageChanged.invoke(Boolean.valueOf(position == 1));
            }
            if (position == 1) {
                HomeChatPagerView.this.getChatHost().M0();
            }
            HomeChatPagerView.this.z0();
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"com/stepos/ailauncher/chat/view/HomeChatPagerView$f", "Lcom/stepos/ailauncher/chat/view/P7;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "session", "LY8/t;", "f", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)V", "", "sessionId", "c", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/controller/f;", "target", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/controller/f;)V", Const.INTENT_KEY_PKGNAME, "()V", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "active", Const.INTENT_KEY_UMID, "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements P7 {
        public f() {
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void a(InterfaceC2538f target) {
            kotlin.jvm.internal.p.i(target, "target");
            HomeChatPagerView.this.s0(target.getAgentId(), target.getDeviceId(), target.getDisplayName());
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void b() {
            HomeChatPagerView.t0(HomeChatPagerView.this, null, null, null, 6, null);
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void c(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            HomeChatPagerView.this.x0(sessionId);
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void d(boolean active) {
            HomeChatPagerView.this.searchMode = active;
            HomeChatPagerView.this.A();
            HomeChatPagerView.this.getChatHost().setSidebarAsBack(active);
            InterfaceC5074l<Boolean, Y8.t> onSessionSearchActiveChanged = HomeChatPagerView.this.getOnSessionSearchActiveChanged();
            if (onSessionSearchActiveChanged != null) {
                onSessionSearchActiveChanged.invoke(Boolean.valueOf(active));
            }
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void e() {
            InterfaceC5063a<Y8.t> onCloseRequested = HomeChatPagerView.this.getOnCloseRequested();
            if (onCloseRequested != null) {
                onCloseRequested.invoke();
            }
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void f(SidebarSession session) {
            kotlin.jvm.internal.p.i(session, "session");
            HomeChatPagerView.this.x0(session.getSessionId());
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void g() {
            HomeChatPagerView.this.getSessionCenter().b0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeChatPagerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        ViewPager2 viewPager2 = new ViewPager2(context);
        View childAt = viewPager2.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setOverScrollMode(2);
        }
        this.pager = viewPager2;
        D5 d52 = new D5(context, null, 2, null);
        this.scrollHost = d52;
        int i11 = 6;
        kotlin.jvm.internal.i iVar = null;
        AttributeSet attributeSet2 = null;
        int i12 = 0;
        UnifiedChatHostView unifiedChatHostView = new UnifiedChatHostView(context, attributeSet2, i12, i11, iVar);
        this.chatHost = unifiedChatHostView;
        this.sessionCenter = new SessionCenterView(context, attributeSet2, i12, i11, iVar);
        this.recheckAskUserRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.view.j6
            @Override // java.lang.Runnable
            public final void run() {
                HomeChatPagerView.f0(this.f26204a);
            }
        };
        e eVar = new e();
        this.pageChangeCallback = eVar;
        C2804e4 c2804e4 = new C2804e4(viewPager2, eVar);
        this.pagerSpring = c2804e4;
        unifiedChatHostView.getChatLayout().setKeyboardScrollManagedExternally(true);
        d52.addView(viewPager2, new FrameLayout.LayoutParams(-1, -1));
        addView(d52, new FrameLayout.LayoutParams(-1, -1));
        viewPager2.setAdapter(new c());
        viewPager2.setOffscreenPageLimit(1);
        c2804e4.H(1, false);
        this.sessionCenterHost = new f();
    }

    public static final Y8.t D(HomeChatPagerView homeChatPagerView, boolean z10, boolean z11) {
        homeChatPagerView.chatHost.getChatLayout().r8(z10, z11);
        return Y8.t.f7040a;
    }

    public static final boolean E(BaseInputView baseInputView, AskUserRequest req) {
        kotlin.jvm.internal.p.i(req, "req");
        return AskUserInquiryBinder.k(AskUserInquiryBinder.INSTANCE, baseInputView, req, null, 4, null);
    }

    public static final boolean F(BaseInputView baseInputView, HomeChatPagerView homeChatPagerView, ToolApprovalRequest req) {
        kotlin.jvm.internal.p.i(req, "req");
        return AskUserInquiryBinder.INSTANCE.l(baseInputView, homeChatPagerView.chatHost.getChatLayout(), req);
    }

    public static final Y8.t G(BaseInputView baseInputView, String str) {
        baseInputView.m6(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t H(HomeChatPagerView homeChatPagerView) {
        r0(homeChatPagerView, false, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t I(HomeChatPagerView homeChatPagerView) {
        homeChatPagerView.v0();
        return Y8.t.f7040a;
    }

    public static final Y8.t J(HomeChatPagerView homeChatPagerView) {
        InterfaceC5063a<Y8.t> interfaceC5063a = homeChatPagerView.onCloseRequested;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t K(HomeChatPagerView homeChatPagerView, String str) {
        homeChatPagerView.y0();
        C4148a.k(TAG, "onConversationChanged: sid=" + str + " panelShown=" + homeChatPagerView.panelShown, false, 4, null);
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = homeChatPagerView.onConversationChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(str);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t L(HomeChatPagerView homeChatPagerView, List artifacts) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        homeChatPagerView.j0(artifacts);
        return Y8.t.f7040a;
    }

    public static final Y8.t N(String str, String str2, HomeChatPagerView homeChatPagerView, Result result) {
        Object value = result.getValue();
        if (Result.g(value)) {
            value = null;
        }
        Boolean bool = (Boolean) value;
        if (bool == null) {
            return Y8.t.f7040a;
        }
        SidebarDataSource.INSTANCE.e(str, str2, bool.booleanValue());
        String str3 = homeChatPagerView.currentAgentId;
        if (La.D.L(str3 != null ? La.H.D1(str3).toString() : null, La.H.D1(str2).toString(), true)) {
            UnifiedChatHostView unifiedChatHostView = homeChatPagerView.chatHost;
            String strH0 = homeChatPagerView.currentAgentDisplayName;
            if (strH0 == null) {
                strH0 = homeChatPagerView.h0(str2, str);
            }
            unifiedChatHostView.n1(strH0, bool);
        }
        return Y8.t.f7040a;
    }

    public static final void Q(HomeChatPagerView homeChatPagerView, String str) {
        homeChatPagerView.chatHost.getChatLayout().L(str);
    }

    public static /* synthetic */ boolean S(HomeChatPagerView homeChatPagerView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return homeChatPagerView.R(z10);
    }

    public static final Y8.t T(ArtifactsView artifactsView, HomeChatPagerView homeChatPagerView) {
        K.INSTANCE.l(artifactsView);
        homeChatPagerView.removeView(artifactsView);
        artifactsView.o();
        return Y8.t.f7040a;
    }

    public static /* synthetic */ boolean W(HomeChatPagerView homeChatPagerView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return homeChatPagerView.V(z10);
    }

    public static final void d0(HomeChatPagerView homeChatPagerView, SheetSettleState sheetSettleState) {
        homeChatPagerView.chatHost.getChatLayout().c9();
        if (sheetSettleState == SheetSettleState.HALF) {
            homeChatPagerView.chatHost.getChatLayout().H8();
        }
    }

    public static final void f0(HomeChatPagerView homeChatPagerView) {
        homeChatPagerView.chatHost.getChatLayout().M8();
        homeChatPagerView.chatHost.getChatLayout().L8();
        homeChatPagerView.chatHost.getChatLayout().c9();
    }

    public static final Y8.t k0(HomeChatPagerView homeChatPagerView) {
        S(homeChatPagerView, false, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t l0(ArtifactsView artifactsView, HomeChatPagerView homeChatPagerView, SessionArtifact artifact) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        Context context = artifactsView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.ailauncher.foundation.task.a.a(context, artifact, M5.c.SOURCE_ARTIFACT_SHEET, homeChatPagerView.b0());
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(HomeChatPagerView homeChatPagerView) {
        if (homeChatPagerView.artifactsView != null) {
            homeChatPagerView.scrollHost.setVisibility(4);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void o0(HomeChatPagerView homeChatPagerView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        homeChatPagerView.n0(z10);
    }

    public static /* synthetic */ void r0(HomeChatPagerView homeChatPagerView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        homeChatPagerView.q0(z10);
    }

    public static /* synthetic */ void t0(HomeChatPagerView homeChatPagerView, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        homeChatPagerView.s0(str, str2, str3);
    }

    public static final void u0(HomeChatPagerView homeChatPagerView, String str, String str2, String str3, boolean z10) {
        homeChatPagerView.chatHost.getChatLayout().d8();
        homeChatPagerView.chatHost.getChatLayout().J3(false, str, str2);
        UnifiedChatHostView unifiedChatHostView = homeChatPagerView.chatHost;
        String str4 = null;
        if (str3 != null) {
            if (!z10 || La.H.x0(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                str4 = "< " + str3 + " >";
            }
        }
        unifiedChatHostView.p1(str4);
    }

    public final void A() {
        this.pager.setUserInputEnabled((this.collapsedNow || this.searchMode || this.artifactsView != null) ? false : true);
    }

    public final Boolean A0(String agentId, String deviceId) {
        if (!com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId) || La.H.x0(deviceId)) {
            return null;
        }
        Boolean boolX = X(agentId, deviceId);
        return Boolean.valueOf(boolX != null ? boolX.booleanValue() : false);
    }

    public final boolean B() {
        if (!this.searchMode) {
            return false;
        }
        if (this.pagerSpring.z() != 1) {
            return SessionCenterView.H(this.sessionCenter, false, 1, null);
        }
        r0(this, false, 1, null);
        return true;
    }

    public final void C(LifecycleOwner owner, SessionHandler handler, final BaseInputView inquiryInput, View overlaySlot) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(handler, "handler");
        kotlin.jvm.internal.p.i(inquiryInput, "inquiryInput");
        kotlin.jvm.internal.p.i(overlaySlot, "overlaySlot");
        this.boundHandler = handler;
        this.lifecycleOwner = owner;
        this.inquiryInput = inquiryInput;
        inquiryInput.setOverlayReserveFreezeAction(new p9.p() { // from class: com.stepos.ailauncher.chat.view.c6
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return HomeChatPagerView.D(this.f26095a, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        });
        AskUserInquiryBinder askUserInquiryBinder = AskUserInquiryBinder.INSTANCE;
        askUserInquiryBinder.g(this.chatHost.getChatLayout(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.l6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HomeChatPagerView.E(inquiryInput, (AskUserRequest) obj));
            }
        });
        askUserInquiryBinder.e(this.chatHost.getChatLayout(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.m6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(HomeChatPagerView.F(inquiryInput, this, (ToolApprovalRequest) obj));
            }
        });
        this.chatHost.o0(handler, owner, false);
        askUserInquiryBinder.n(this.chatHost.getChatLayout(), new HomeChatPagerView$bind$4(this), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.n6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HomeChatPagerView.G(inquiryInput, (String) obj);
            }
        });
        this.chatHost.getChatLayout().q8(overlaySlot);
        this.chatHost.n0(SheetSettleState.FULL);
        this.chatHost.setOnSidebarClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.o6
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeChatPagerView.H(this.f26282a);
            }
        });
        this.chatHost.setOnNewSessionClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.p6
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeChatPagerView.I(this.f26292a);
            }
        });
        this.chatHost.setOnCloseClick(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.q6
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeChatPagerView.J(this.f26303a);
            }
        });
        this.chatHost.setOnConversationChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.r6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HomeChatPagerView.K(this.f26317a, (String) obj);
            }
        });
        this.chatHost.setOnOpenArtifacts(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.s6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HomeChatPagerView.L(this.f26329a, (List) obj);
            }
        });
        this.sessionCenter.p(owner, this.sessionCenterHost);
        this.sessionCenter.setLiveSessionHandler(handler);
    }

    public final void M(final String agentId, final String deviceId) {
        IExternalAgentBindService iExternalAgentBindService;
        if (agentId != null) {
            if (!com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId)) {
                agentId = null;
            }
            if (agentId == null || La.H.x0(deviceId) || (iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class)) == null) {
                return;
            }
            iExternalAgentBindService.queryDeviceAgentOnline(deviceId, agentId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.i6
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return HomeChatPagerView.N(deviceId, agentId, this, (Result) obj);
                }
            });
        }
    }

    public final void O(String agentId, String deviceId, String agentDisplayName) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        s0(agentId, deviceId, agentDisplayName);
    }

    public final void P(final String prompt) {
        kotlin.jvm.internal.p.i(prompt, "prompt");
        if (La.H.x0(prompt)) {
            return;
        }
        t0(this, null, null, null, 6, null);
        this.chatHost.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.f6
            @Override // java.lang.Runnable
            public final void run() {
                HomeChatPagerView.Q(this.f26130a, prompt);
            }
        });
    }

    public final boolean R(boolean animate) {
        final ArtifactsView artifactsView = this.artifactsView;
        if (artifactsView == null) {
            return false;
        }
        this.artifactsView = null;
        A();
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onArtifactsModeChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.FALSE);
        }
        this.scrollHost.setVisibility(0);
        InterfaceC5074l<? super Float, Y8.t> interfaceC5074l2 = this.onPagerFraction;
        if (interfaceC5074l2 != null) {
            interfaceC5074l2.invoke(Float.valueOf(Z() ? 1.0f : 0.0f));
        }
        if (animate) {
            K.INSTANCE.h(artifactsView, this.scrollHost, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.h6
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return HomeChatPagerView.T(artifactsView, this);
                }
            });
            return true;
        }
        K.INSTANCE.l(artifactsView, this.scrollHost);
        removeView(artifactsView);
        artifactsView.o();
        return true;
    }

    public final void U() {
        BaseInputView baseInputView = this.inquiryInput;
        if (baseInputView != null) {
            BaseInputView.k6(baseInputView, false, false, 2, null);
        }
        this.chatHost.getChatLayout().T8();
        this.chatHost.getChatLayout().S8();
    }

    public final boolean V(boolean animate) {
        return this.sessionCenter.G(animate);
    }

    public final Boolean X(String agentId, String deviceId) {
        O6.i iVarC;
        List<ExternalDeviceInfo> listA;
        Object next;
        if (agentId == null || La.H.x0(agentId) || deviceId == null || La.H.x0(deviceId) || (iVarC = O6.a.INSTANCE.c()) == null || (listA = iVarC.a()) == null) {
            return null;
        }
        Iterator<T> it = listA.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ExternalDeviceInfo externalDeviceInfo = (ExternalDeviceInfo) next;
            if (La.D.L(La.H.D1(externalDeviceInfo.getDeviceId()).toString(), La.H.D1(deviceId).toString(), true) && La.D.L(La.H.D1(externalDeviceInfo.getAgent()).toString(), La.H.D1(agentId).toString(), true)) {
                break;
            }
        }
        ExternalDeviceInfo externalDeviceInfo2 = (ExternalDeviceInfo) next;
        if (externalDeviceInfo2 != null) {
            return Boolean.valueOf(externalDeviceInfo2.getOnline());
        }
        return null;
    }

    public final void Y() {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        int iZ = this.pagerSpring.z();
        if (iZ == 0) {
            this.sessionCenter.M();
        } else if (iZ == 1 && (interfaceC5063a = this.onLeaveChatPage) != null) {
            interfaceC5063a.invoke();
        }
    }

    public final boolean Z() {
        return this.pagerSpring.z() == 1;
    }

    /* renamed from: a0, reason: from getter */
    public final boolean getSearchMode() {
        return this.searchMode;
    }

    public final String b0() {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        SessionHandler sessionHandler = this.boundHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (strB = agentConversationR1.B()) == null || strB.length() <= 0) {
            return null;
        }
        return strB;
    }

    public final void c0(final SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        this.chatHost.n0(state);
        this.sessionCenter.S(state);
        this.collapsedNow = com.stepos.ailauncher.chat.util.u.a(state);
        A();
        this.chatHost.getChatLayout().postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.view.k6
            @Override // java.lang.Runnable
            public final void run() {
                HomeChatPagerView.d0(this.f26220a, state);
            }
        });
    }

    public final void e0() {
        this.chatHost.removeCallbacks(this.recheckAskUserRunnable);
        this.chatHost.post(this.recheckAskUserRunnable);
    }

    public final void g0() {
        this.chatHost.removeCallbacks(this.recheckAskUserRunnable);
        this.chatHost.getChatLayout().setOnAskUserInquiry(null);
        this.chatHost.getChatLayout().setOnToolApproval(null);
        this.chatHost.getChatLayout().setOnCurrentConversationChanged(null);
        BaseInputView baseInputView = this.inquiryInput;
        if (baseInputView != null) {
            baseInputView.setOverlayReserveFreezeAction(null);
        }
        this.chatHost.getChatLayout().e9();
        this.chatHost.Z0();
        U();
        this.inquiryInput = null;
        R(false);
        this.sessionCenter.W();
        this.pagerSpring.E();
        this.panelShown = false;
        this.sessionCenterRevealed = false;
    }

    public final UnifiedChatHostView getChatHost() {
        return this.chatHost;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnArtifactsModeChanged() {
        return this.onArtifactsModeChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnCloseRequested() {
        return this.onCloseRequested;
    }

    public final InterfaceC5074l<String, Y8.t> getOnConversationChanged() {
        return this.onConversationChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnConversationSwitch() {
        return this.onConversationSwitch;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnExternalSessionChanged() {
        return this.onExternalSessionChanged;
    }

    public final InterfaceC5063a<Y8.t> getOnLeaveChatPage() {
        return this.onLeaveChatPage;
    }

    public final InterfaceC5074l<Float, Y8.t> getOnPagerFraction() {
        return this.onPagerFraction;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnSessionSearchActiveChanged() {
        return this.onSessionSearchActiveChanged;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnSettledPageChanged() {
        return this.onSettledPageChanged;
    }

    public final SessionCenterView getSessionCenter() {
        return this.sessionCenter;
    }

    public final String h0(String agentId, String deviceId) {
        String displayName;
        Object next;
        String displayName2;
        List<ExternalDeviceInfo> listA;
        Object next2;
        String deviceName;
        String str;
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

    public final void i0(String sessionId) {
        if (sessionId == null || sessionId.length() == 0) {
            o0(this, false, 1, null);
        } else {
            x0(sessionId);
        }
    }

    public final void j0(List<SessionArtifact> artifacts) {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            return;
        }
        if (this.artifactsView != null) {
            R(false);
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final ArtifactsView artifactsView = new ArtifactsView(context, null, 0, 6, null);
        artifactsView.setOnExit(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.t6
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeChatPagerView.k0(this.f26368a);
            }
        });
        artifactsView.setOnArtifactClick(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.d6
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HomeChatPagerView.l0(artifactsView, this, (SessionArtifact) obj);
            }
        });
        addView(artifactsView, new FrameLayout.LayoutParams(-1, -1));
        artifactsView.j(lifecycleOwner, b0(), artifacts);
        this.artifactsView = artifactsView;
        A();
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onArtifactsModeChanged;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.TRUE);
        }
        InterfaceC5074l<? super Float, Y8.t> interfaceC5074l2 = this.onPagerFraction;
        if (interfaceC5074l2 != null) {
            interfaceC5074l2.invoke(Float.valueOf(0.0f));
        }
        K.INSTANCE.j(artifactsView, this.scrollHost, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.e6
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeChatPagerView.m0(this.f26117a);
            }
        });
    }

    public final void n0(boolean smooth) {
        p0(1, smooth);
    }

    public final void p0(int page, boolean smooth) {
        if (this.pagerSpring.z() == page) {
            return;
        }
        Y();
        this.pagerSpring.H(page, smooth);
    }

    public final void q0(boolean smooth) {
        p0(0, smooth);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s0(final java.lang.String r11, final java.lang.String r12, final java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.HomeChatPagerView.s0(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void setConversationPageVisible(boolean visible) {
        this.chatHost.setConversationPageVisible(visible);
    }

    public final void setOnArtifactsModeChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onArtifactsModeChanged = interfaceC5074l;
    }

    public final void setOnCloseRequested(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onCloseRequested = interfaceC5063a;
    }

    public final void setOnConversationChanged(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onConversationChanged = interfaceC5074l;
    }

    public final void setOnConversationSwitch(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onConversationSwitch = interfaceC5063a;
    }

    public final void setOnExternalSessionChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onExternalSessionChanged = interfaceC5074l;
    }

    public final void setOnLeaveChatPage(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onLeaveChatPage = interfaceC5063a;
    }

    public final void setOnPagerFraction(InterfaceC5074l<? super Float, Y8.t> interfaceC5074l) {
        this.onPagerFraction = interfaceC5074l;
    }

    public final void setOnSessionSearchActiveChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onSessionSearchActiveChanged = interfaceC5074l;
    }

    public final void setOnSettledPageChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onSettledPageChanged = interfaceC5074l;
    }

    public final void setPanelShown(boolean shown) {
        if (this.panelShown == shown) {
            return;
        }
        this.panelShown = shown;
        if (shown) {
            this.chatHost.getChatLayout().d9();
        }
        z0();
    }

    public final void v0() {
        if (!this.chatHost.I0()) {
            V(false);
            w0();
        } else {
            com.stepos.agentframework.chatui.util.d dVar = com.stepos.agentframework.chatui.util.d.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            dVar.v(context, R$string.toast_already_new_chat, this.chatHost);
        }
    }

    public final void w0() {
        SessionHandler sessionHandler = this.boundHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String agentId = agentConversationR1 != null ? agentConversationR1.getAgentId() : null;
        String deviceId = agentConversationR1 != null ? agentConversationR1.getDeviceId() : null;
        String string = agentId != null ? La.H.D1(agentId).toString() : null;
        String str = string == null ? "" : string;
        boolean zB = com.stepos.agentframework.adapter.agentbus.bff.j.b(agentId);
        boolean z10 = (deviceId == null || La.H.x0(deviceId)) && str.length() > 0 && !PrimaryAgent.INSTANCE.a(str) && !zB;
        String str2 = this.currentAgentDisplayName;
        int i10 = d.$EnumSwitchMapping$0[com.stepos.ailauncher.chat.controller.J0.a(zB, deviceId, z10).ordinal()];
        if (i10 == 1) {
            t0(this, null, null, null, 6, null);
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            t0(this, str, null, str2, 2, null);
        } else {
            if (deviceId == null) {
                deviceId = "";
            }
            s0(agentId, deviceId, str2);
        }
    }

    public final void x0(String sessionId) {
        if (sessionId.length() == 0 || this.boundHandler == null) {
            return;
        }
        com.stepos.ailauncher.common.utils.v.INSTANCE.c();
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onConversationSwitch;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        BaseInputView baseInputView = this.inquiryInput;
        if (baseInputView != null) {
            baseInputView.m6(sessionId);
        }
        if (!this.chatHost.v1(sessionId) && !this.chatHost.M0()) {
            this.chatHost.a1();
        }
        C4148a.k(TAG, "switchConversation: " + sessionId, false, 4, null);
        o0(this, false, 1, null);
    }

    public final void y0() {
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
            this.chatHost.setExternalSessionHome(false);
            UnifiedChatHostView.o1(this.chatHost, null, null, 2, null);
            InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onExternalSessionChanged;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String strH0 = h0(agentId, deviceId);
        this.currentAgentId = str;
        this.currentAgentDisplayName = strH0;
        this.chatHost.setExternalSessionHome(true);
        this.chatHost.n1(strH0, A0(agentId, deviceId));
        M(agentId, deviceId);
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l2 = this.onExternalSessionChanged;
        if (interfaceC5074l2 != null) {
            interfaceC5074l2.invoke(Boolean.TRUE);
        }
    }

    public final void z(boolean imeVisible) {
        this.sessionCenter.o(imeVisible);
    }

    public final void z0() {
        boolean z10 = this.pagerSpring.z() == 0;
        boolean z11 = this.pager.getScrollState() == 0;
        boolean z12 = this.panelShown;
        boolean z13 = z12 && z11 && z10;
        boolean z14 = !z12 || (z11 && !z10);
        if (z13 && !this.sessionCenterRevealed) {
            this.sessionCenterRevealed = true;
            this.sessionCenter.R();
        } else if (z14 && this.sessionCenterRevealed) {
            this.sessionCenterRevealed = false;
            this.sessionCenter.Q();
        }
    }

    public /* synthetic */ HomeChatPagerView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
