package com.stepos.agentframework.chatui.viewholder;

import E4.FloatCardAction;
import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.d;
import E4.g;
import E4.n;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.ApprovalFrameRegistry;
import com.stepos.agentframework.chatui.CotTracker;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.task.view.C2054d;
import com.stepos.agentframework.chatui.view.ChatLoadingView;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import com.stepos.agentframework.floatcard.api.FloatCardActionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.api.FloatCardSkipMode;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.agentframework.util.E;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.AskUserConversation;
import kotlin.AskUserOption;
import kotlin.AskUserQuestion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z4.C6358d;
import z4.C6360f;
import z4.LongTextCandidate;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 x2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\f¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0015H\u0002¢\u0006\u0004\b&\u0010%J7\u0010(\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0015H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010!J\u001f\u0010+\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010\u001bJ\u001f\u0010,\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\u001bJ\u0019\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u0010!J\u0017\u00101\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u0010!J%\u00105\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020302H\u0002¢\u0006\u0004\b5\u00106J#\u0010:\u001a\u0002092\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020307\"\u000203H\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010>\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J3\u0010E\u001a\u00020\f2\u0006\u0010@\u001a\u0002032\u0006\u0010B\u001a\u00020A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\f0CH\u0002¢\u0006\u0004\bE\u0010FJc\u0010K\u001a\u00020\f2\u0006\u0010@\u001a\u0002032\u0006\u0010B\u001a\u00020A2\"\b\u0002\u0010I\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020H0G\u0012\u0004\u0012\u00020\f\u0018\u00010C2\u001e\u0010J\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020H0G\u0012\u0004\u0012\u00020\f0CH\u0002¢\u0006\u0004\bK\u0010LJ]\u0010Q\u001a\u00020\f2\u0006\u0010@\u001a\u0002032\u0006\u0010B\u001a\u00020A2\"\b\u0002\u0010I\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020H0G\u0012\u0004\u0012\u00020\f\u0018\u00010C2\u0018\u0010P\u001a\u0014\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\f0MH\u0002¢\u0006\u0004\bQ\u0010RR\u001c\u0010T\u001a\n S*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010V\u001a\n S*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010UR\u0014\u0010W\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010.R\u0014\u0010X\u001a\u0002038\u0002X\u0082D¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010[\u001a\n S*\u0004\u0018\u00010Z0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001c\u0010^\u001a\n S*\u0004\u0018\u00010]0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010eR\u0014\u0010j\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010_R\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010hR\u0018\u0010o\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010YR\u0018\u0010p\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006y"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/F;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/N1;", "original", "bodyPartIndex", "y", "(Lcom/stepos/agentframework/chatui/N1;II)V", "message", "", "isUpdate", "interactionMessage", "z", "(Lcom/stepos/agentframework/chatui/N1;ZILcom/stepos/agentframework/chatui/N1;)V", "e0", "(Lcom/stepos/agentframework/chatui/N1;I)V", "displayMessage", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "()V", "f", "(Lcom/stepos/agentframework/chatui/N1;)V", "G", "x", "a0", "()Z", "b0", "reuseHeaderContent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/agentframework/chatui/N1;ZILcom/stepos/agentframework/chatui/N1;Z)V", "w", "f0", "F", "", "I", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/CharSequence;", "K", "N", "", "", "suggestions", "Y", "(Lcom/stepos/agentframework/chatui/N1;Ljava/util/List;)V", "", "options", "LE4/g$b;", "J", "([Ljava/lang/String;)LE4/g$b;", "LK6/d;", "conversation", "P", "(Lcom/stepos/agentframework/chatui/N1;LK6/d;)V", "key", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lkotlin/Function1;", "onChosen", "L", "(Ljava/lang/String;LE4/c;Lp9/l;)V", "", "LE4/n;", "onDismissed", "onSubmit", "c0", "(Ljava/lang/String;LE4/c;Lp9/l;Lp9/l;)V", "Lkotlin/Function2;", "LE4/d;", "Lcom/stepos/agentframework/floatcard/ext/c;", "handleEvent", "U", "(Ljava/lang/String;LE4/c;Lp9/l;Lp9/p;)V", "kotlin.jvm.PlatformType", "rootLayout", "Landroid/view/View;", "contentLayout", "rootPaddingBottomPx", "TAG", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "messageContainer", "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "Landroid/widget/TextView;", "errorText", "Landroid/widget/TextView;", "Lcom/stepos/agentframework/chatui/view/ChatLoadingView;", "loadingView", "Lcom/stepos/agentframework/chatui/view/ChatLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clPlaySound", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/ImageView;", "ivPlaySound", "Landroid/widget/ImageView;", "clDeepThinkResult", "tvDeepThinkResult", "Landroid/widget/LinearLayout;", "llDeepThinking", "Landroid/widget/LinearLayout;", "ivExpand", "approvalCardKey", "currentPopupHandle", "Lcom/stepos/agentframework/floatcard/ext/c;", "Lz4/d;", "headerSnapshot", "Lz4/d;", "Lz4/f;", "headerLogLimiter", "Lz4/f;", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class F extends AbstractC2106k {
    private static final String ASK_USER_SUBMIT_ID = "ask_user_submit";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SELECTION_BUSINESS_TYPE = "receive_text_selection";
    private static final String SELECTION_ID = "selection";
    private final String TAG;
    private String approvalCardKey;
    private final ConstraintLayout clDeepThinkResult;
    private final ConstraintLayout clPlaySound;
    private final View contentLayout;
    private com.stepos.agentframework.floatcard.ext.c currentPopupHandle;
    private final TextView errorText;
    private final C6360f headerLogLimiter;
    private C6358d headerSnapshot;
    private final ImageView ivExpand;
    private final ImageView ivPlaySound;
    private final LinearLayout llDeepThinking;
    private final ChatLoadingView loadingView;
    private final MessageContentContainer messageContainer;
    private final View rootLayout;
    private final int rootPaddingBottomPx;
    private final TextView tvDeepThinkResult;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/F$a;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "Lcom/stepos/agentframework/chatui/viewholder/F;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;Lcom/stepos/agentframework/chatui/U1;)Lcom/stepos/agentframework/chatui/viewholder/F;", "", "SELECTION_ID", "Ljava/lang/String;", "ASK_USER_SUBMIT_ID", "SELECTION_BUSINESS_TYPE", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.viewholder.F$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final F a(ViewGroup parent, U1 chatView) {
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(chatView, "chatView");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_message_receive, parent, false);
            AgentUIConfig agentUiConfig = chatView.getAgentUiConfig();
            if (agentUiConfig != null && agentUiConfig.getReceiveItemBg() != -1) {
                viewInflate.setBackgroundResource(agentUiConfig.getReceiveItemBg());
            }
            kotlin.jvm.internal.p.f(viewInflate);
            return new F(viewInflate, chatView);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChatHintType.values().length];
            try {
                iArr[ChatHintType.RISK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatHintType.PRIVACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatHintType.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChatHintType.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChatHintType.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ChatHintType.AGENT_OFFLINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(View itemView, final U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.receive_root_layout);
        this.rootLayout = viewFindViewById;
        this.contentLayout = itemView.findViewById(R$id.content_layout);
        this.rootPaddingBottomPx = viewFindViewById.getPaddingBottom();
        this.TAG = " [ReceiveTextViewHolder] ";
        MessageContentContainer messageContentContainer = (MessageContentContainer) itemView.findViewById(R$id.message_container);
        messageContentContainer.setShowToolActionLayout(a0());
        messageContentContainer.setShowToolExecuteView(b0());
        messageContentContainer.setAllowTextSelection(false);
        messageContentContainer.setOnToolGroupHeaderClick(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.viewholder.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return F.H(chatView);
            }
        });
        this.messageContainer = messageContentContainer;
        this.errorText = (TextView) itemView.findViewById(R$id.error_message);
        View viewFindViewById2 = itemView.findViewById(R$id.loading_animation_view);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.loadingView = (ChatLoadingView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.clPlaySound);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.clPlaySound = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.ivPlaySound);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.ivPlaySound = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.cl_deep_think_result);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.clDeepThinkResult = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R$id.tv_deepthink_result);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        this.tvDeepThinkResult = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R$id.ll_deep_thinking);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        this.llDeepThinking = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R$id.iv_expand);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        this.ivExpand = (ImageView) viewFindViewById8;
        this.headerLogLimiter = new C6360f(4, 0L, 2, null);
        x();
        AgentUIConfig agentUiConfig = chatView.getAgentUiConfig();
        if (agentUiConfig != null) {
            if (agentUiConfig.getReceiveItemBg() != -1) {
                viewFindViewById.setBackgroundResource(agentUiConfig.getReceiveItemBg());
            }
            messageContentContainer.setReceiveMessageTextColor(agentUiConfig.getMessageTextStyle().getReceive().getTextColor());
            messageContentContainer.setReceiveMessageTextSizeSp(agentUiConfig.getMessageTextStyle().getReceive().getTextSizeSp());
            messageContentContainer.setReceiveMessageLineSpacingMultiplier(agentUiConfig.getMessageTextStyle().getReceive().getLineSpacingMultiplier());
            messageContentContainer.setSentItemBg(agentUiConfig.getSendItemBg());
            messageContentContainer.setSentTextStyle(agentUiConfig.getMessageTextStyle().getSent());
        }
    }

    public static /* synthetic */ void B(F f10, DisplayMessage displayMessage, boolean z10, int i10, DisplayMessage displayMessage2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            displayMessage2 = displayMessage;
        }
        f10.z(displayMessage, z10, i10, displayMessage2);
    }

    public static final void C(F f10, int i10, DisplayMessage displayMessage, View view) {
        E.Companion companion = com.stepos.agentframework.util.E.INSTANCE;
        com.stepos.agentframework.util.E eA = companion.a();
        Context context = f10.itemView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        com.stepos.agentframework.util.C c10 = com.stepos.agentframework.util.C.INSTANCE;
        boolean zE = com.stepos.agentframework.util.E.e(eA, context, c10.b(), false, null, 12, null);
        if (zE) {
            f10.getChatView().d(i10, displayMessage);
        }
        com.stepos.agentframework.util.E eA2 = companion.a();
        Context context2 = f10.itemView.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        com.stepos.agentframework.util.E.k(eA2, context2, c10.b(), !zE, null, 8, null);
        f10.ivPlaySound.setSelected(!r0.isSelected());
    }

    public static final void D(DisplayMessage displayMessage, F f10, View view) {
        CotTracker.INSTANCE.a().d(displayMessage, CotTracker.Section.REASONING, !(f10.tvDeepThinkResult.getVisibility() == 0));
        if (f10.tvDeepThinkResult.getVisibility() == 0) {
            ExtKt.m(f10.tvDeepThinkResult);
            f10.ivExpand.setImageResource(R$drawable.ic_mcp_collapsed);
        } else {
            ExtKt.C(f10.tvDeepThinkResult);
            f10.ivExpand.setImageResource(R$drawable.ic_mcp_expanded);
        }
    }

    public static final Y8.t E(F f10, int i10, DisplayMessage displayMessage, DisplayMessage displayMessage2, String toolCallId, int i11) {
        kotlin.jvm.internal.p.i(displayMessage2, "<unused var>");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        f10.getChatView().u(i10, displayMessage, toolCallId, i11);
        return Y8.t.f7040a;
    }

    public static final Y8.t H(U1 u12) {
        u12.x();
        return Y8.t.f7040a;
    }

    public static final Y8.t M(InterfaceC5074l interfaceC5074l, E4.d event, com.stepos.agentframework.floatcard.ext.c handle) {
        List<String> listA;
        String str;
        kotlin.jvm.internal.p.i(event, "event");
        kotlin.jvm.internal.p.i(handle, "handle");
        if (!(event instanceof d.Submit)) {
            return Y8.t.f7040a;
        }
        E4.n nVar = ((d.Submit) event).a().get(SELECTION_ID);
        n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
        if (selected == null || (listA = selected.a()) == null || (str = (String) Z8.F.s0(listA)) == null) {
            return Y8.t.f7040a;
        }
        com.stepos.agentframework.floatcard.ext.c.d(handle, null, 1, null);
        interfaceC5074l.invoke(str);
        return Y8.t.f7040a;
    }

    public static final Y8.t O(F f10, int i10, DisplayMessage displayMessage, String chosen) {
        kotlin.jvm.internal.p.i(chosen, "chosen");
        f10.getChatView().V(i10, displayMessage, displayMessage.getMessageId(), chosen);
        return Y8.t.f7040a;
    }

    public static final void Q(Ref$BooleanRef ref$BooleanRef, List<AskUserQuestion> list, AskUserConversation askUserConversation, DisplayMessage displayMessage, F f10, int i10, Map<String, ? extends E4.n> map, String str) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String question = ((AskUserQuestion) it.next()).getQuestion();
            if (question == null) {
                question = "";
            }
            E4.n nVar = map.get(question);
            n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
            List<String> listA = selected != null ? selected.a() : null;
            if (listA == null) {
                listA = C1173v.m();
            }
            if (!listA.isEmpty()) {
                linkedHashMap.put(question, Z8.F.A0(listA, ", ", null, null, 0, null, null, 62, null));
            }
        }
        askUserConversation.d(linkedHashMap);
        displayMessage.S(null);
        String approvalRequestId = displayMessage.getApprovalRequestId();
        if (approvalRequestId == null || La.H.x0(approvalRequestId)) {
            String strF = ApprovalFrameRegistry.INSTANCE.f(displayMessage.getMessageId());
            C4148a.k("ReceiveTextViewHolder", "showAskUserQuestionCard#0 refill requestId from registry: messageId=" + displayMessage.getMessageId() + " requestId=" + strF, false, 4, null);
            displayMessage.R(strF);
        }
        ApprovalFrameRegistry.INSTANCE.d(displayMessage.getMessageId());
        C4148a.k("ReceiveTextViewHolder", "showAskUserQuestionCard#1 submit reason=" + str + " messageId=" + displayMessage.getMessageId() + " approvalRequestId=" + displayMessage.getApprovalRequestId() + " sessionId=" + displayMessage.getSessionId() + " answers=" + linkedHashMap + " rawValues=" + map, false, 4, null);
        f10.getChatView().c(i10, displayMessage, askUserConversation);
    }

    public static final String R(AskUserQuestion askUserQuestion, String str) {
        if (!askUserQuestion.getMultiSelect() || La.H.g0(La.K.S1(str, 6), "多选", false, 2, null)) {
            return str;
        }
        return str + "（多选）";
    }

    public static final Y8.t S(Ref$BooleanRef ref$BooleanRef, List list, AskUserConversation askUserConversation, DisplayMessage displayMessage, F f10, int i10, Map pending) {
        kotlin.jvm.internal.p.i(pending, "pending");
        Q(ref$BooleanRef, list, askUserConversation, displayMessage, f10, i10, pending, DidiCardProvider.ACTION_DISMISS);
        return Y8.t.f7040a;
    }

    public static final Y8.t T(Ref$BooleanRef ref$BooleanRef, List list, AskUserConversation askUserConversation, DisplayMessage displayMessage, F f10, int i10, Map values) {
        kotlin.jvm.internal.p.i(values, "values");
        Q(ref$BooleanRef, list, askUserConversation, displayMessage, f10, i10, values, "submit");
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V(F f10, String str, FloatCardContent floatCardContent, InterfaceC5074l interfaceC5074l, p9.p pVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = null;
        }
        f10.U(str, floatCardContent, interfaceC5074l, pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Y8.t W(p9.p pVar, Ref$ObjectRef ref$ObjectRef, E4.d event) {
        com.stepos.agentframework.floatcard.ext.c cVar;
        kotlin.jvm.internal.p.i(event, "event");
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("handle");
            cVar = null;
        } else {
            cVar = (com.stepos.agentframework.floatcard.ext.c) t10;
        }
        pVar.invoke(event, cVar);
        return Y8.t.f7040a;
    }

    public static final Y8.t X(com.stepos.agentframework.floatcard.ext.c cVar, F f10, String str, InterfaceC5074l interfaceC5074l) {
        Map<String, E4.n> mapH = cVar.h();
        if (kotlin.jvm.internal.p.d(f10.approvalCardKey, str)) {
            f10.approvalCardKey = null;
        }
        if (f10.currentPopupHandle == cVar) {
            f10.currentPopupHandle = null;
        }
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(mapH);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Z(DisplayMessage displayMessage, F f10, String chosen) {
        kotlin.jvm.internal.p.i(chosen, "chosen");
        displayMessage.l0(null);
        f10.getChatView().L(chosen);
        return Y8.t.f7040a;
    }

    public static final Y8.t d0(InterfaceC5074l interfaceC5074l, E4.d event, com.stepos.agentframework.floatcard.ext.c handle) {
        kotlin.jvm.internal.p.i(event, "event");
        kotlin.jvm.internal.p.i(handle, "handle");
        if (!(event instanceof d.Submit)) {
            return Y8.t.f7040a;
        }
        com.stepos.agentframework.floatcard.ext.c.d(handle, null, 1, null);
        interfaceC5074l.invoke(((d.Submit) event).a());
        return Y8.t.f7040a;
    }

    public final void A(final DisplayMessage message, boolean isUpdate, final int position, final DisplayMessage interactionMessage, boolean reuseHeaderContent) {
        String errorMessage;
        this.headerSnapshot = null;
        TextView errorText = this.errorText;
        kotlin.jvm.internal.p.h(errorText, "errorText");
        ExtKt.m(errorText);
        if (!reuseHeaderContent) {
            if (isUpdate) {
                this.messageContainer.S0(message);
            } else {
                this.messageContainer.setMessage(message);
            }
        }
        if (!reuseHeaderContent) {
            AgentUIConfig agentUiConfig = getChatView().getAgentUiConfig();
            w((agentUiConfig == null || !agentUiConfig.getShowMsgTopSoundController()) ? message : interactionMessage);
        }
        if (message.getStatus() == EReplyStatus.COMPLETED) {
            C4148a.k(this.TAG, "bindMessage message: " + message.getStatus(), false, 4, null);
            this.ivPlaySound.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    F.C(this.f23209a, position, interactionMessage, view);
                }
            });
        } else if (message.getStatus() == EReplyStatus.ERROR) {
            TextView errorText2 = this.errorText;
            kotlin.jvm.internal.p.h(errorText2, "errorText");
            ExtKt.C(errorText2);
            TextView textView = this.errorText;
            int errorCode = message.getErrorCode();
            if (errorCode == 10107) {
                errorMessage = "阶跃 AI 未绑定账号";
            } else if (errorCode != 10108) {
                errorMessage = message.getErrorMessage();
                if (La.H.x0(errorMessage)) {
                    errorMessage = "网络错误，请检查网络后重试。";
                }
            } else {
                errorMessage = "积分不足";
            }
            textView.setText(errorMessage);
            G();
        } else {
            G();
        }
        this.llDeepThinking.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                F.D(message, this, view);
            }
        });
        if (message.getStatus() == EReplyStatus.START) {
            this.tvDeepThinkResult.setText("");
        }
        K(interactionMessage);
        e0(message, position);
        if (!reuseHeaderContent) {
            F(message, position);
        }
        f0(interactionMessage, position);
        C2054d.Companion companion = C2054d.INSTANCE;
        MessageContentContainer messageContainer = this.messageContainer;
        kotlin.jvm.internal.p.h(messageContainer, "messageContainer");
        companion.e(messageContainer, 2, interactionMessage, getChatView(), position);
        int childCount = this.messageContainer.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.messageContainer.getChildAt(i10);
            if (childAt instanceof AIMDTextView) {
                C2054d.INSTANCE.e(childAt, 2, interactionMessage, getChatView(), position);
            }
        }
        this.messageContainer.setOnToolLikeStatusChangedListener(new p9.q() { // from class: com.stepos.agentframework.chatui.viewholder.y
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return F.E(this.f23214a, position, interactionMessage, (DisplayMessage) obj, (String) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    public final void F(DisplayMessage message, int position) {
        List<DisplayChatMessage> listM = message.m();
        if (!(listM instanceof Collection) || !listM.isEmpty()) {
            Iterator<T> it = listM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((DisplayChatMessage) it.next()).getType() == AgentMessageType.THINKING_TEXT) {
                    if (!this.messageContainer.d0()) {
                        ExtKt.C(this.clDeepThinkResult);
                        String str = "";
                        for (DisplayChatMessage displayChatMessage : message.m()) {
                            if (displayChatMessage.getType() == AgentMessageType.THINKING_TEXT) {
                                str = ((Object) str) + displayChatMessage.getDeepThinkText();
                            }
                        }
                        this.tvDeepThinkResult.setText(str);
                        return;
                    }
                }
            }
        }
        ExtKt.m(this.clDeepThinkResult);
    }

    public final void G() {
        ExtKt.m(this.clPlaySound);
    }

    public final CharSequence I(DisplayMessage message) {
        int i10;
        if (message.getStatus() != EReplyStatus.COMPLETED && message.getStatus() != EReplyStatus.CANCELED) {
            return null;
        }
        switch (b.$EnumSwitchMapping$0[message.getHint().ordinal()]) {
            case 1:
                i10 = R$string.chat_safety_hint;
                break;
            case 2:
                i10 = R$string.chat_privacy_blocked_hint;
                break;
            case 3:
                i10 = R$string.chat_stopped_hint;
                break;
            case 4:
            case 5:
            case 6:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return this.itemView.getContext().getString(i10);
    }

    public final g.Selection J(String... options) {
        ArrayList arrayList = new ArrayList(options.length);
        for (String str : options) {
            arrayList.add(new FloatCardOption(str, str, false, false, false, 28, null));
        }
        return new g.Selection(SELECTION_ID, null, arrayList, SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null);
    }

    public final void K(DisplayMessage message) {
        String messageId = message.getMessageId();
        ApprovalFrameRegistry approvalFrameRegistry = ApprovalFrameRegistry.INSTANCE;
        approvalFrameRegistry.e(messageId, message.getApprovalRequestId(), message.getAskUserConversation());
        if (approvalFrameRegistry.c(messageId)) {
            this.approvalCardKey = null;
            return;
        }
        AskUserConversation askUserConversation = message.getAskUserConversation();
        if (askUserConversation == null) {
            askUserConversation = approvalFrameRegistry.a(messageId);
            if (askUserConversation != null) {
                C4148a.k(this.TAG, "setupSuggestions: refill askUserConversation from registry, messageId=" + messageId, false, 4, null);
                message.S(askUserConversation);
            } else {
                askUserConversation = null;
            }
        }
        if (askUserConversation != null) {
            P(message, askUserConversation);
            return;
        }
        if (approvalFrameRegistry.b(messageId)) {
            C4148a.k(this.TAG, "setupSuggestions: ask-user frame without payload, skip approval card, messageId=" + messageId, false, 4, null);
            return;
        }
        String approvalRequestId = message.getApprovalRequestId();
        if (approvalRequestId == null || La.H.x0(approvalRequestId)) {
            List<String> listZ = message.z();
            List<String> list = listZ;
            if (list == null || list.isEmpty()) {
                this.approvalCardKey = null;
                return;
            } else {
                Y(message, listZ);
                return;
            }
        }
        if (!getChatView().v()) {
            N(message);
            return;
        }
        C4148a.k(this.TAG, "setupSuggestions: host handles approval card, skip popup, messageId=" + messageId, false, 4, null);
    }

    public final void L(String key, FloatCardContent content, final InterfaceC5074l<? super String, Y8.t> onChosen) {
        V(this, key, content, null, new p9.p() { // from class: com.stepos.agentframework.chatui.viewholder.E
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return F.M(onChosen, (E4.d) obj, (com.stepos.agentframework.floatcard.ext.c) obj2);
            }
        }, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(final com.stepos.agentframework.chatui.DisplayMessage r19) {
        /*
            r18 = this;
            r0 = r18
            android.view.View r1 = r0.itemView
            android.content.Context r1 = r1.getContext()
            android.content.Context r1 = r1.getApplicationContext()
            int r2 = r0.d()
            java.lang.String r3 = r19.getApprovalRequestId()
            if (r3 == 0) goto L20
            boolean r4 = La.H.x0(r3)
            if (r4 != 0) goto L1d
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 != 0) goto L2a
        L20:
            com.stepos.agentframework.chatui.ApprovalFrameRegistry r3 = com.stepos.agentframework.chatui.ApprovalFrameRegistry.INSTANCE
            java.lang.String r4 = r19.getMessageId()
            java.lang.String r3 = r3.f(r4)
        L2a:
            java.lang.String r4 = r19.getMessageId()
            if (r3 != 0) goto L32
            java.lang.String r3 = ""
        L32:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "approval:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = ":"
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            E4.c r4 = new E4.c
            E4.j r5 = new E4.j
            java.lang.CharSequence r6 = r18.I(r19)
            java.lang.String r7 = "getString(...)"
            if (r6 == 0) goto L5d
            java.lang.String r6 = r6.toString()
            if (r6 != 0) goto L66
        L5d:
            int r6 = com.stepos.agentframework.R$string.approval_request_title
            java.lang.String r6 = r1.getString(r6)
            kotlin.jvm.internal.p.h(r6, r7)
        L66:
            int r8 = com.stepos.agentframework.R$string.approval_allow
            java.lang.String r8 = r1.getString(r8)
            kotlin.jvm.internal.p.h(r8, r7)
            int r9 = com.stepos.agentframework.R$string.approval_allow_always
            java.lang.String r9 = r1.getString(r9)
            kotlin.jvm.internal.p.h(r9, r7)
            int r10 = com.stepos.agentframework.R$string.approval_deny
            java.lang.String r10 = r1.getString(r10)
            kotlin.jvm.internal.p.h(r10, r7)
            int r11 = com.stepos.agentframework.R$string.approval_abort
            java.lang.String r1 = r1.getString(r11)
            kotlin.jvm.internal.p.h(r1, r7)
            java.lang.String[] r1 = new java.lang.String[]{r8, r9, r10, r1}
            E4.g$b r1 = r0.J(r1)
            java.util.List r10 = Z8.C1172u.e(r1)
            com.stepos.agentframework.floatcard.api.FloatCardSkipMode r11 = com.stepos.agentframework.floatcard.api.FloatCardSkipMode.Hidden
            r16 = 974(0x3ce, float:1.365E-42)
            r17 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.util.List r5 = Z8.C1172u.e(r5)
            r10 = 30
            r11 = 0
            r6 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            com.stepos.agentframework.chatui.viewholder.z r1 = new com.stepos.agentframework.chatui.viewholder.z
            r5 = r19
            r1.<init>()
            r0.L(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.F.N(com.stepos.agentframework.chatui.N1):void");
    }

    public final void P(final DisplayMessage message, final AskUserConversation conversation) {
        List<AskUserQuestion> listB = conversation.b();
        final ArrayList<AskUserQuestion> arrayList = new ArrayList();
        for (Object obj : listB) {
            List<AskUserOption> listC = ((AskUserQuestion) obj).c();
            if (!(listC == null || listC.isEmpty())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        final int iD = d();
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (AskUserQuestion askUserQuestion : arrayList) {
            String header = askUserQuestion.getHeader();
            if (header == null) {
                header = "";
            }
            String question = askUserQuestion.getQuestion();
            String str = question == null ? "" : question;
            String strR = header.length() == 0 ? str : header;
            String str2 = header.length() > 0 ? str : null;
            if (str2 == null) {
                strR = R(askUserQuestion, strR);
            }
            String strR2 = str2 != null ? R(askUserQuestion, str2) : null;
            List<AskUserOption> listC2 = askUserQuestion.c();
            if (listC2 == null) {
                listC2 = C1173v.m();
            }
            List<AskUserOption> list = listC2;
            ArrayList arrayList3 = new ArrayList(C1174w.x(list, 10));
            for (AskUserOption askUserOption : list) {
                String label = askUserOption.getLabel();
                String str3 = label == null ? "" : label;
                String label2 = askUserOption.getLabel();
                arrayList3.add(new FloatCardOption(str3, label2 == null ? "" : label2, false, false, false, 28, null));
            }
            arrayList2.add(new FloatCardPage(strR, strR2, null, null, C1172u.e(new g.Selection(str, null, arrayList3, askUserQuestion.getMultiSelect() ? SelectionMode.Multiple : SelectionMode.Single, FloatCardOptionStyle.Checkmark, false, 34, null)), FloatCardSkipMode.Enabled, null, null, null, null, 972, null));
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        c0("ask_user:" + message.getMessageId(), new FloatCardContent(arrayList2, null, null, new FloatCardAction(ASK_USER_SUBMIT_ID, "确定", FloatCardActionStyle.Primary, null, 8, null), null, 22, null), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.viewholder.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return F.S(ref$BooleanRef, arrayList, conversation, message, this, iD, (Map) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.viewholder.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return F.T(ref$BooleanRef, arrayList, conversation, message, this, iD, (Map) obj2);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, com.stepos.agentframework.floatcard.ext.c] */
    public final void U(final String key, FloatCardContent content, final InterfaceC5074l<? super Map<String, ? extends E4.n>, Y8.t> onDismissed, final p9.p<? super E4.d, ? super com.stepos.agentframework.floatcard.ext.c, Y8.t> handleEvent) {
        if (kotlin.jvm.internal.p.d(this.approvalCardKey, key)) {
            C4148a.d(this.TAG, "show dialog: same key=" + key + ", skip", false, 4, null);
            return;
        }
        if (!this.itemView.isAttachedToWindow()) {
            C4148a.u(this.TAG, "show dialog: itemView not attached, skip key=" + key, false, 4, null);
            return;
        }
        String str = this.approvalCardKey;
        this.approvalCardKey = null;
        com.stepos.agentframework.floatcard.ext.c cVar = this.currentPopupHandle;
        if (cVar != null) {
            com.stepos.agentframework.floatcard.ext.c.d(cVar, null, 1, null);
        }
        this.currentPopupHandle = null;
        if (str != null) {
            C4148a.d(this.TAG, "show dialog: replace previous, oldKey=" + str + " newKey=" + key, false, 4, null);
        }
        FloatCardRequest floatCardRequest = new FloatCardRequest("receive_text_" + key, null, SELECTION_BUSINESS_TYPE, FloatCardScene.Any, content, null, null, 98, null);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        View itemView = this.itemView;
        kotlin.jvm.internal.p.h(itemView, "itemView");
        final ?? E10 = com.stepos.agentframework.floatcard.ext.i.e(itemView, floatCardRequest, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.viewholder.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return F.W(handleEvent, ref$ObjectRef, (E4.d) obj);
            }
        });
        ref$ObjectRef.f34820a = E10;
        this.approvalCardKey = key;
        this.currentPopupHandle = E10;
        E10.f(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.viewholder.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return F.X(E10, this, key, onDismissed);
            }
        });
        C4148a.d(this.TAG, "show dialog success", false, 4, null);
    }

    public final void Y(final DisplayMessage message, List<String> suggestions) {
        String str = "suggestions:" + message.getMessageId();
        CharSequence charSequenceI = I(message);
        String string = charSequenceI != null ? charSequenceI.toString() : null;
        if (string == null) {
            string = "";
        }
        String[] strArr = (String[]) suggestions.toArray(new String[0]);
        L(str, new FloatCardContent(C1172u.e(new FloatCardPage(string, null, null, null, C1172u.e(J((String[]) Arrays.copyOf(strArr, strArr.length))), FloatCardSkipMode.Hidden, null, null, null, null, 974, null)), null, null, null, null, 30, null), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.viewholder.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return F.Z(message, this, (String) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void a() {
        if (this.clDeepThinkResult.getVisibility() == 0 && this.tvDeepThinkResult.getVisibility() == 0) {
            ExtKt.m(this.tvDeepThinkResult);
            this.ivExpand.setImageResource(R$drawable.ic_mcp_collapsed);
        }
    }

    public final boolean a0() {
        AgentUIConfig agentUiConfig = getChatView().getAgentUiConfig();
        if (agentUiConfig != null) {
            return agentUiConfig.getWithToolActionLayout();
        }
        return false;
    }

    public final boolean b0() {
        AgentUIConfig agentUiConfig = getChatView().getAgentUiConfig();
        if (agentUiConfig != null) {
            return agentUiConfig.getWithToolExecuteView();
        }
        return true;
    }

    public final void c0(String key, FloatCardContent content, InterfaceC5074l<? super Map<String, ? extends E4.n>, Y8.t> onDismissed, final InterfaceC5074l<? super Map<String, ? extends E4.n>, Y8.t> onSubmit) {
        U(key, content, onDismissed, new p9.p() { // from class: com.stepos.agentframework.chatui.viewholder.D
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return F.d0(onSubmit, (E4.d) obj, (com.stepos.agentframework.floatcard.ext.c) obj2);
            }
        });
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    @SuppressLint({"SetTextI18n"})
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
        DisplayMessage displayMessage = (DisplayMessage) item;
        String str = this.TAG;
        String messageId = displayMessage.getMessageId();
        AgentRole role = displayMessage.getRole();
        EReplyStatus status = displayMessage.getStatus();
        int size = displayMessage.m().size();
        Iterator<T> it = displayMessage.m().iterator();
        int size2 = 0;
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            size2 += listF != null ? listF.size() : 0;
        }
        C4148a.d(str, "onBind position=" + position + " messageId=" + messageId + " role=" + role + " status=" + status + " partCount=" + size + " toolCount=" + size2, false, 4, null);
        B(this, displayMessage, false, position, null, 8, null);
    }

    public final void e0(DisplayMessage message, int position) {
        kotlin.jvm.internal.p.i(message, "message");
        boolean z10 = true;
        boolean z11 = message.getStatus() == EReplyStatus.START || message.getStatus() == EReplyStatus.REPLYING || message.getStatus() == EReplyStatus.TOOL_EXECUTING;
        boolean z12 = message.getVariantCount() > 1;
        boolean zY = getChatView().Y();
        if (!z11 || zY || (!getChatView().b(position) && !z12)) {
            this.loadingView.setProcessingStartTime(0L);
            this.loadingView.i();
            ExtKt.m(this.loadingView);
            return;
        }
        List<DisplayChatMessage> listM = message.m();
        if ((listM instanceof Collection) && listM.isEmpty()) {
            z10 = false;
        } else {
            for (DisplayChatMessage displayChatMessage : listM) {
                if (displayChatMessage.getType() == AgentMessageType.TEXT && displayChatMessage.getContent().h().length() > 0) {
                    break;
                }
            }
            z10 = false;
        }
        if (message.F()) {
            long jM = message.M();
            this.loadingView.setProcessingStartTime(jM);
            if (jM <= 0) {
                this.loadingView.setStatusText(this.itemView.getContext().getString(R$string.chat_processing));
            }
        } else {
            this.loadingView.setProcessingStartTime(0L);
            this.loadingView.setStatusText(this.itemView.getContext().getString(z10 ? R$string.chat_status_replying : R$string.chat_status_thinking));
        }
        ExtKt.C(this.loadingView);
        this.loadingView.m();
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void f(DisplayMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        K(message);
        G();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(com.stepos.agentframework.chatui.DisplayMessage r8, int r9) {
        /*
            r7 = this;
            com.stepos.agentframework.chatui.U1 r0 = r7.getChatView()
            com.stepos.agentframework.AgentUIConfig r0 = r0.getAgentUiConfig()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L13
            boolean r0 = r0.getShowMsgTopSoundController()
            if (r0 != r1) goto L13
            goto L14
        L13:
            r8 = r2
        L14:
            if (r8 == 0) goto L96
            com.stepos.agentframework.chatui.U1 r0 = r7.getChatView()
            boolean r9 = r0.b(r9)
            if (r9 == 0) goto L21
            goto L22
        L21:
            r8 = r2
        L22:
            if (r8 == 0) goto L96
            java.util.List r8 = r8.m()
            if (r8 == 0) goto L96
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r9 = r8 instanceof java.util.Collection
            r0 = 0
            if (r9 == 0) goto L3c
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L3c
        L3a:
            r1 = r0
            goto L62
        L3c:
            java.util.Iterator r8 = r8.iterator()
        L40:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L3a
            java.lang.Object r9 = r8.next()
            com.stepos.agentframework.chatui.J1 r9 = (com.stepos.agentframework.chatui.DisplayChatMessage) r9
            com.stepos.agentframework.chatcore.session.AgentMessageType r3 = r9.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r4 = com.stepos.agentframework.chatcore.session.AgentMessageType.TEXT
            if (r3 != r4) goto L40
            u4.m r9 = r9.getContent()
            java.lang.String r9 = r9.h()
            int r9 = r9.length()
            if (r9 <= 0) goto L40
        L62:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r1)
            if (r1 == 0) goto L69
            r2 = r8
        L69:
            if (r2 == 0) goto L96
            androidx.constraintlayout.widget.ConstraintLayout r8 = r7.clPlaySound
            com.stepos.agentframework.chatcore.utils.ExtKt.C(r8)
            android.widget.ImageView r8 = r7.ivPlaySound
            com.stepos.agentframework.util.E$a r9 = com.stepos.agentframework.util.E.INSTANCE
            com.stepos.agentframework.util.E r0 = r9.a()
            android.view.View r7 = r7.itemView
            android.content.Context r1 = r7.getContext()
            java.lang.String r7 = "getContext(...)"
            kotlin.jvm.internal.p.h(r1, r7)
            com.stepos.agentframework.util.C r7 = com.stepos.agentframework.util.C.INSTANCE
            java.lang.String r2 = r7.b()
            r5 = 12
            r6 = 0
            r3 = 0
            r4 = 0
            boolean r7 = com.stepos.agentframework.util.E.e(r0, r1, r2, r3, r4, r5, r6)
            r8.setSelected(r7)
            return
        L96:
            r7.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.F.f0(com.stepos.agentframework.chatui.N1, int):void");
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void h(DisplayMessage displayMessage, int position) {
        kotlin.jvm.internal.p.i(displayMessage, "displayMessage");
        B(this, displayMessage, true, position, null, 8, null);
    }

    public final void w(DisplayMessage message) {
        boolean zO = message.O();
        if (zO) {
            C4148a.k(this.TAG, "collapse blank bubble messageId=" + message.getMessageId() + " status=" + message.getStatus() + " partCount=" + message.m().size(), false, 4, null);
        }
        View contentLayout = this.contentLayout;
        kotlin.jvm.internal.p.h(contentLayout, "contentLayout");
        contentLayout.setVisibility(!zO ? 0 : 8);
        this.rootLayout.setPadding(0, 0, 0, zO ? 0 : this.rootPaddingBottomPx);
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        int i10 = zO ? 0 : -2;
        if (layoutParams == null || layoutParams.height == i10) {
            return;
        }
        layoutParams.height = i10;
        this.itemView.setLayoutParams(layoutParams);
    }

    public final void x() {
        U1 chatView = getChatView();
        AgentChatLayout agentChatLayout = chatView instanceof AgentChatLayout ? (AgentChatLayout) chatView : null;
        int messageHorizontalContentInsetPx = agentChatLayout != null ? agentChatLayout.getMessageHorizontalContentInsetPx() : 0;
        this.messageContainer.setHorizontalContentInsetPx(messageHorizontalContentInsetPx);
        for (View view : C1173v.p(this.clPlaySound, this.clDeepThinkResult, this.loadingView, this.errorText)) {
            kotlin.jvm.internal.p.f(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart(messageHorizontalContentInsetPx);
            marginLayoutParams.setMarginEnd(messageHorizontalContentInsetPx);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public final void y(DisplayMessage original, int position, int bodyPartIndex) {
        kotlin.jvm.internal.p.i(original, "original");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        CotTracker.j(CotTracker.INSTANCE.a(), original, null, 2, null);
        C6358d c6358dA = C6358d.INSTANCE.a(original, bodyPartIndex);
        C6358d c6358d = this.headerSnapshot;
        boolean z10 = c6358d != null && c6358d.a(c6358dA);
        DisplayMessage displayMessageG = LongTextCandidate.INSTANCE.g(original, bodyPartIndex);
        Trace.beginSection(z10 ? "Chat.longText.reuseHeader" : "Chat.longText.rebuildHeader");
        try {
            A(displayMessageG, false, position, original, z10);
            this.headerSnapshot = c6358dA;
            Trace.endSection();
            this.rootLayout.setPadding(0, 0, 0, 0);
            String str = z10 ? "reuse" : "rebuild";
            C6360f.Sample sampleA = this.headerLogLimiter.a("header", original.getSessionId() + "/" + original.getMessageId() + "/" + str, jElapsedRealtime);
            if (sampleA != null) {
                C4148a.d(this.TAG, "long text header mode=" + str + " messageId=" + original.getMessageId() + " logicalPos=" + position + " bindMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " count=" + sampleA.getCount() + " suppressed=" + sampleA.getSuppressed(), false, 4, null);
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void z(DisplayMessage message, boolean isUpdate, int position, DisplayMessage interactionMessage) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(interactionMessage, "interactionMessage");
        A(message, isUpdate, position, interactionMessage, false);
    }
}
