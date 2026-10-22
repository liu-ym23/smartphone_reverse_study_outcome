package com.stepos.ailauncher.agent.aispace.skill.feishu;

import Ua.C1060i;
import Y4.C1121e;
import Z8.C1173v;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.agent.R$color;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b;
import com.stepos.ailauncher.agent.aispace.skill.feishu.net.FeishuCliRepository;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.SheetHeightMode;
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
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ¤\u00012\u00020\u0001:\u0004¥\u0001¦\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u0017\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010/J\u001b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J!\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000b2\u0006\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b<\u0010;J\u000f\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010\u0003J\u0017\u0010?\u001a\u00020\u00062\u0006\u00100\u001a\u00020>H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\u0003J\u001f\u0010D\u001a\u00020\u000f2\u0006\u00104\u001a\u0002032\u0006\u0010C\u001a\u00020\u0017H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u000fH\u0002¢\u0006\u0004\bG\u0010)J\u0017\u0010H\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u000fH\u0002¢\u0006\u0004\bH\u0010)J\u000f\u0010I\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\u0003J\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\u0003J/\u0010P\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u001eH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0006H\u0002¢\u0006\u0004\bU\u0010\u0003J\u000f\u0010V\u001a\u00020\u0006H\u0002¢\u0006\u0004\bV\u0010\u0003J\u000f\u0010W\u001a\u00020\u0006H\u0002¢\u0006\u0004\bW\u0010\u0003J\u000f\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0004\bX\u0010\u0003J\u000f\u0010Y\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010\u0003J\u000f\u0010Z\u001a\u00020\u0006H\u0002¢\u0006\u0004\bZ\u0010\u0003J\u0017\u0010\\\u001a\u00020\u00062\u0006\u00100\u001a\u00020[H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0006H\u0002¢\u0006\u0004\b^\u0010\u0003J3\u0010d\u001a\u00020c2\u0006\u0010_\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u00172\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060aH\u0002¢\u0006\u0004\bd\u0010eJ\u001f\u0010h\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u0017H\u0002¢\u0006\u0004\bh\u0010iJ\u001d\u0010l\u001a\u00020\u00062\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001e0jH\u0002¢\u0006\u0004\bl\u0010mJ\u0017\u0010p\u001a\u00020\u00062\u0006\u0010o\u001a\u00020nH\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010s\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u000fH\u0002¢\u0006\u0004\bs\u0010\u0012J!\u0010v\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010u\u001a\u0004\u0018\u00010tH\u0016¢\u0006\u0004\bv\u0010wJ\u000f\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0004\bx\u0010\u0003J\u0017\u0010z\u001a\u00020\u00062\u0006\u0010y\u001a\u00020tH\u0016¢\u0006\u0004\bz\u0010{J\u000f\u0010|\u001a\u00020\u0006H\u0016¢\u0006\u0004\b|\u0010\u0003R\u0016\u0010~\u001a\u00020}8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0080\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u0082\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u0082\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0084\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008d\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008d\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0094\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0081\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u0099\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009f\u0001\u001a\u00020\u00178BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0017\u0010¡\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u009e\u0001R\u0017\u0010£\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u009e\u0001¨\u0006§\u0001"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment$PendingReturn;", UxipConstants.f30680s, "LY8/t;", "p1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment$PendingReturn;)V", "o0", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment$PendingReturn;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "o1", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "G0", "", "serverStatus", "D1", "(Ljava/lang/String;)V", "F0", "C0", "E0", "D0", "", "cancelling", "j0", "(Z)V", "m0", "Landroid/view/View;", "view", "", "horizontalPadding", "k0", "(Landroid/view/View;I)V", "C1", "y1", "y0", "x1", "x0", "url", "B0", "(Ljava/lang/String;)Z", "s1", "z1", "v1", "w1", "s0", "()Ljava/lang/String;", VoiceWakeupReceiver.EXTRA_STATE, "t0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;)Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;", "stage", "u0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;)Ljava/lang/String;", "prev", "E1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;)V", "Z0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;)V", "m1", "i0", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$h;", "i1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$h;)V", SdCardDbCreator.FIELD_LASTLOC_ID, "j1", "timeout", "r0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FailStage;Z)Ljava/lang/String;", "callerTag", "z0", "A0", "K0", "H0", "L0", "title", "description", "cancelText", "confirmText", "q1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "stepBase", "l1", "(I)V", "k1", "d1", "b1", "c1", "n1", "h1", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$e;", "e1", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b$e;)V", "f1", "checked", x5.d.EXTRA_ENABLED, "Lkotlin/Function1;", "onCheckChange", "Landroid/widget/FrameLayout;", "p0", "(ZZLp9/l;)Landroid/widget/FrameLayout;", "stepIndex", "completed", "n0", "(IZ)V", "", "dotStates", "l0", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;", "task", "I0", "(Lcom/stepos/ailauncher/agent/aispace/skill/feishu/p0;)V", HighlightArgsBundle.KEY_PROMPT, "X0", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onResume", "LY4/e;", "binding", "LY4/e;", "awaitingFirstSnapshot", "Z", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/PollingManager;", "authorizePoller", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/PollingManager;", "reviewPoller", "pendingReturn", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment$PendingReturn;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "recommendedAdapter", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/r0;", "Lkotlinx/coroutines/g;", "statusPollingJob", "Lkotlinx/coroutines/g;", "lastRenderedState", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "checkingAuthJob", "checkingCreateJob", "", "connectingTransitionEndAtMs", "J", "currentStepStartMs", "enteredFromInitialConnected", "lastStep", "Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "v0", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "connector", "w0", "()Z", "initiallyConnected", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", "PendingReturn", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeishuConnectFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_CONNECTED = "ailauncher.feishu.initially_connected";
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
    private boolean awaitingFirstSnapshot;
    private C1121e binding;
    private kotlinx.coroutines.g checkingAuthJob;
    private kotlinx.coroutines.g checkingCreateJob;
    private long connectingTransitionEndAtMs;
    private long currentStepStartMs;
    private boolean enteredFromInitialConnected;
    private AbstractC2306b lastRenderedState;
    private String lastStep;
    private volatile PendingReturn pendingReturn;
    private final r0 recommendedAdapter;
    private PollingManager<AbstractC2306b> reviewPoller;
    private kotlinx.coroutines.g statusPollingJob;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile PendingReturn pendingReturnGlobal = PendingReturn.NONE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment$PendingReturn;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "CREATE_BOT", "AUTHORIZE", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment$a;", "", "<init>", "()V", "", "connected", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment;", Const.INTENT_KEY_APIKEY, "(Z)Lcom/stepos/ailauncher/agent/aispace/skill/feishu/FeishuConnectFragment;", "", "TAG", "Ljava/lang/String;", "", "STATUS_POLL_INTERVAL_MS", "J", "CONNECTING_TRANSITION_MS", "CHECKING_AUTH_TIMEOUT_MS", "CHECKING_CREATE_TIMEOUT_MS", "KEY_PENDING_RETURN", "ARG_CONNECTED", "REC_ID_SUMMARY_MSG", "", "SEG_ACTIVE_CHECK", "I", "SEG_PENDING_FILLED", "SEG_PENDING_HOLLOW", "SEG_PENDING_LOADING", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final FeishuConnectFragment a(boolean connected) {
            FeishuConnectFragment feishuConnectFragment = new FeishuConnectFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FeishuConnectFragment.ARG_CONNECTED, connected);
            feishuConnectFragment.setArguments(bundle);
            return feishuConnectFragment;
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onResume$1", f = "FeishuConnectFragment.kt", l = {396}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ PendingReturn $pending;
        int label;
        final /* synthetic */ FeishuConnectFragment this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onResume$1$a */
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
        public AnonymousClass1(PendingReturn pendingReturn, FeishuConnectFragment feishuConnectFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$pending = pendingReturn;
            this.this$0 = feishuConnectFragment;
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
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "<anonymous>", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onViewCreated$3", f = "FeishuConnectFragment.kt", l = {106}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super o0<AbstractC2306b>>, Object> {
        int label;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(1, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return FeishuConnectFragment.this.new AnonymousClass3(interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super o0<AbstractC2306b>> interfaceC4014c) {
            return ((AnonymousClass3) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
            h0 h0VarV0 = FeishuConnectFragment.this.v0();
            this.label = 1;
            Object objF = h0VarV0.f(this);
            return objF == objG ? objG : objF;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/b;", "<anonymous>", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/o0;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onViewCreated$4", f = "FeishuConnectFragment.kt", l = {112}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super o0<AbstractC2306b>>, Object> {
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(1, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return FeishuConnectFragment.this.new AnonymousClass4(interfaceC4014c);
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
            h0 h0VarV0 = FeishuConnectFragment.this.v0();
            this.label = 1;
            Object objC = h0VarV0.c(this);
            return objC == objG ? objG : objC;
        }
    }

    public FeishuConnectFragment() {
        super(R$layout.activity_feishu_connect);
        this.pendingReturn = PendingReturn.NONE;
        this.recommendedAdapter = new r0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.M
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectFragment.Y0(this.f24243a, (RecommendedTask) obj);
            }
        });
    }

    private final boolean A0(String callerTag) {
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

    public static final Y8.t A1(FeishuConnectFragment feishuConnectFragment, AbstractC2306b state) {
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("review poll update=%s", Arrays.copyOf(new Object[]{state}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if ((state instanceof AbstractC2306b.Connected) || (state instanceof AbstractC2306b.Failed)) {
            feishuConnectFragment.Z0(state);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B0(String url) {
        Object objB;
        Object objB2;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        PackageManager packageManager = requireContext().getPackageManager();
        for (String str : C1173v.p(C2309e.PKG_FEISHU, C2309e.PKG_LARK)) {
            Intent intent2 = new Intent(intent).setPackage(str);
            kotlin.jvm.internal.p.h(intent2, "setPackage(...)");
            if (packageManager.resolveActivity(intent2, 0) != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    requireContext().startActivity(intent2);
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
            requireContext().startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        return Result.h(objB);
    }

    public static final Y8.t B1(FeishuConnectFragment feishuConnectFragment) {
        C4148a.u(TAG, "review poll timeout", false, 4, null);
        Toast.makeText(feishuConnectFragment.requireContext(), feishuConnectFragment.getString(R$string.feishu_cli_toast_review_timeout), 0).show();
        return Y8.t.f7040a;
    }

    private final void C0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$observeDebugLog$1(this, null), 3, null);
    }

    private final void C1() {
        kotlinx.coroutines.g gVar = this.statusPollingJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.statusPollingJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$startStatusPolling$1(this, null), 3, null);
    }

    private final void D0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$observeFeishuCancelling$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(String serverStatus) {
        h0 h0VarV0 = v0();
        FakeFeishuConnector fakeFeishuConnector = h0VarV0 instanceof FakeFeishuConnector ? (FakeFeishuConnector) h0VarV0 : null;
        if (fakeFeishuConnector == null) {
            return;
        }
        if (serverStatus == null && this.awaitingFirstSnapshot) {
            C4148a.d(TAG, "syncAndRender: swallow null status before first snapshot", false, 4, null);
            return;
        }
        this.awaitingFirstSnapshot = false;
        if (!fakeFeishuConnector.n(serverStatus)) {
            if (this.lastRenderedState instanceof AbstractC2306b.Connected) {
                f1();
            }
        } else {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format("syncFromServerStatus changed state -> %s, re-render", Arrays.copyOf(new Object[]{fakeFeishuConnector.getState()}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            Z0(fakeFeishuConnector.getState());
        }
    }

    private final void E0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$observeFeishuToggling$1(this, null), 3, null);
    }

    private final void E1(AbstractC2306b prev, AbstractC2306b state) {
        if (kotlin.jvm.internal.p.d(prev, state)) {
            return;
        }
        Pair pairA = state instanceof AbstractC2306b.Failed ? Y8.j.a(u0(((AbstractC2306b.Failed) state).getStage()), com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.c().getValue()) : kotlin.jvm.internal.p.d(state, AbstractC2306b.a.INSTANCE) ? Y8.j.a("authorize", "local.checking_auth_timeout") : kotlin.jvm.internal.p.d(state, AbstractC2306b.j.INSTANCE) ? Y8.j.a(W4.b.STEP_INSTALL, "local.install_network_unavailable") : null;
        if (pairA != null) {
            W4.b bVar = W4.b.INSTANCE;
            bVar.e(W4.b.TOOL_FEISHU, (String) pairA.e(), W4.b.PAGE_FAIL_PAGE);
            bVar.f(W4.b.TOOL_FEISHU, (String) pairA.e(), "fail", (String) pairA.f(), F1(this));
            return;
        }
        if (state instanceof AbstractC2306b.Connected) {
            String str = this.lastStep;
            if (str != null) {
                W4.b.INSTANCE.f(W4.b.TOOL_FEISHU, str, "success", null, F1(this));
            }
            this.lastStep = null;
            W4.b.INSTANCE.g(W4.b.TOOL_FEISHU, this.enteredFromInitialConnected ? W4.b.ENTRY_MARKET_CLICK : W4.b.ENTRY_CONNECTION_SUCCESS);
            return;
        }
        String strT0 = t0(state);
        if (strT0 == null || kotlin.jvm.internal.p.d(strT0, this.lastStep)) {
            return;
        }
        String str2 = this.lastStep;
        if (str2 != null) {
            W4.b.INSTANCE.f(W4.b.TOOL_FEISHU, str2, "success", null, F1(this));
        }
        this.lastStep = strT0;
        this.currentStepStartMs = SystemClock.elapsedRealtime();
        W4.b.INSTANCE.e(W4.b.TOOL_FEISHU, strT0, "normal");
    }

    private final void F0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$observeNetworkFailure$1(this, null), 3, null);
    }

    public static final Long F1(FeishuConnectFragment feishuConnectFragment) {
        if (feishuConnectFragment.currentStepStartMs > 0) {
            return Long.valueOf(SystemClock.elapsedRealtime() - feishuConnectFragment.currentStepStartMs);
        }
        return null;
    }

    private final void G0() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$observeServerStatus$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner2), null, null, new FeishuConnectFragment$observeServerStatus$2(this, null), 3, null);
    }

    private final void H0() {
        W4.b bVar = W4.b.INSTANCE;
        String strS0 = s0();
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j jVar = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE;
        bVar.c(W4.b.TOOL_FEISHU, strS0, "terminate", jVar.i().getValue());
        String value = jVar.j().getValue();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onAbortLinkClicked taskId=%s state=%s", Arrays.copyOf(new Object[]{value, v0().getState()}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (value == null || La.H.x0(value)) {
            C4148a.u(TAG, "abort skipped: no taskId yet", false, 4, null);
            Toast.makeText(requireContext(), "正在同步连接状态，请稍后重试", 0).show();
            FeishuCliRepository.G(FeishuCliRepository.INSTANCE, null, null, 3, null);
            return;
        }
        String string = getString(R$string.feishu_cli_abort_dialog_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.feishu_cli_abort_dialog_desc);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.feishu_cli_abort_dialog_cancel);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.feishu_cli_abort_dialog_confirm);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        q1(string, string2, string3, string4);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I0(com.stepos.ailauncher.agent.aispace.skill.feishu.RecommendedTask r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getId()
            java.lang.String r1 = "vipcase_"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = La.D.X(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L33
            W4.b r0 = W4.b.INSTANCE
            java.lang.String r3 = r9.getId()
            java.lang.String r5 = r9.getTitle()
            java.lang.String r6 = r9.getId()
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
            r3 = 4
            java.lang.String r5 = "format(...)"
            r6 = 1
            java.lang.String r7 = "AILauncher-FeishuConn"
            if (r1 != 0) goto L7c
            kotlin.jvm.internal.y r9 = kotlin.jvm.internal.y.f34840a
            Xa.t r9 = r0.i()
            java.lang.Object r9 = r9.getValue()
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r6)
            java.lang.String r0 = "recommended task blocked: feishu cli not enabled, status=%s"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            kotlin.jvm.internal.p.h(r9, r5)
            h8.C4148a.d(r7, r9, r2, r3, r4)
            android.content.Context r9 = r8.requireContext()
            int r0 = com.stepos.ailauncher.agent.R$string.feishu_cli_disabled_chat_blocked
            java.lang.String r8 = r8.getString(r0)
            android.widget.Toast r8 = android.widget.Toast.makeText(r9, r8, r2)
            r8.show()
            return
        L7c:
            java.lang.String r0 = r9.getId()
            java.lang.String r1 = "rec_summary_msg"
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 == 0) goto La1
            com.stepos.ailauncher.agent.aispace.skill.feishu.f r9 = new com.stepos.ailauncher.agent.aispace.skill.feishu.f
            android.content.Context r0 = r8.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            com.stepos.ailauncher.agent.aispace.skill.feishu.U r1 = new com.stepos.ailauncher.agent.aispace.skill.feishu.U
            r1.<init>()
            r9.<init>(r0, r1)
            r9.show()
            return
        La1:
            java.lang.String r0 = r9.getPrompt()
            if (r0 == 0) goto Lb1
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto Lae
            goto Laf
        Lae:
            r0 = r4
        Laf:
            if (r0 != 0) goto Lb5
        Lb1:
            java.lang.String r0 = r9.getTitle()
        Lb5:
            kotlin.jvm.internal.y r9 = kotlin.jvm.internal.y.f34840a
            java.lang.Object[] r9 = new java.lang.Object[]{r0}
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r6)
            java.lang.String r1 = "onRecommendedTaskClicked open stacked chat with prompt=%s"
            java.lang.String r9 = java.lang.String.format(r1, r9)
            kotlin.jvm.internal.p.h(r9, r5)
            h8.C4148a.d(r7, r9, r2, r3, r4)
            r8.X0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment.I0(com.stepos.ailauncher.agent.aispace.skill.feishu.p0):void");
    }

    public static final Y8.t J0(FeishuConnectFragment feishuConnectFragment) {
        C4148a.d(TAG, "summary task confirmed, open stacked chat with default prompt", false, 4, null);
        String string = feishuConnectFragment.getString(R$string.feishu_cli_auto_summary_send_msg);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        feishuConnectFragment.X0(string);
        return Y8.t.f7040a;
    }

    private final void K0() {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_FEISHU, s0(), "reconnect", null, 8, null);
        if (kotlin.jvm.internal.p.d(this.lastRenderedState, AbstractC2306b.a.INSTANCE)) {
            C4148a.d(TAG, "retry -> AuthCheckLocalFailed, re-launch authorize url", false, 4, null);
            x0();
            return;
        }
        AbstractC2306b state = v0().getState();
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j jVar = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE;
        String value = jVar.j().getValue();
        String value2 = jVar.f().getValue();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onRetryClicked state=%s taskId=%s nextActionType=%s", Arrays.copyOf(new Object[]{state, value, value2}, 3));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (!kotlin.jvm.internal.p.d(this.lastRenderedState, AbstractC2306b.j.INSTANCE)) {
            if (value == null || La.H.x0(value)) {
                C4148a.d(TAG, "retry -> no taskId yet, fall back to startInstall", false, 4, null);
                y1();
                return;
            } else {
                String str2 = String.format("retry -> POST /connect action=retry taskId=%s", Arrays.copyOf(new Object[]{value}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                C4148a.d(TAG, str2, false, 4, null);
                FeishuCliRepository.C(FeishuCliRepository.INSTANCE, null, 1, null);
                return;
            }
        }
        com.stepos.ailauncher.common.utils.I i10 = com.stepos.ailauncher.common.utils.I.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        if (!i10.b(contextRequireContext)) {
            Toast.makeText(requireContext(), getString(R$string.feishu_cli_toast_network_unavailable), 0).show();
        } else if (value == null || La.H.x0(value)) {
            y1();
        } else {
            Z0(AbstractC2306b.l.INSTANCE);
            FeishuCliRepository.C(FeishuCliRepository.INSTANCE, null, 1, null);
        }
    }

    private final void L0() {
        W4.b.INSTANCE.c(W4.b.TOOL_FEISHU, s0(), "terminate", com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.i().getValue());
        String string = getString(R$string.feishu_cli_uninstall_dialog_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.feishu_cli_uninstall_dialog_desc);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.feishu_cli_abort_dialog_cancel);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = getString(R$string.feishu_cli_abort_dialog_confirm);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        q1(string, string2, string3, string4);
    }

    public static final void M0(FeishuConnectFragment feishuConnectFragment, View view) {
        C1121e c1121e = feishuConnectFragment.binding;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.flDebugLogContainer.setVisibility(8);
    }

    public static final void N0(View view) {
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.k.INSTANCE.c();
    }

    public static final void O0(FeishuConnectFragment feishuConnectFragment, View view) {
        C1121e c1121e = feishuConnectFragment.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        FrameLayout frameLayout = c1121e.flDebugLogContainer;
        C1121e c1121e3 = feishuConnectFragment.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e3;
        }
        frameLayout.setVisibility(c1121e2.flDebugLogContainer.getVisibility() == 0 ? 8 : 0);
    }

    public static final void P0(FeishuConnectFragment feishuConnectFragment, View view) {
        if (feishuConnectFragment.x()) {
            return;
        }
        feishuConnectFragment.o();
    }

    public static final void Q0(FeishuConnectFragment feishuConnectFragment, View view) {
        feishuConnectFragment.y1();
    }

    public static final void R0(FeishuConnectFragment feishuConnectFragment, View view) {
        feishuConnectFragment.K0();
    }

    public static final void S0(FeishuConnectFragment feishuConnectFragment, View view) {
        feishuConnectFragment.y0();
    }

    public static final void T0(FeishuConnectFragment feishuConnectFragment, View view) {
        feishuConnectFragment.x0();
    }

    public static final void U0(FeishuConnectFragment feishuConnectFragment, View view) {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_FEISHU, feishuConnectFragment.s0(), "done", null, 8, null);
        feishuConnectFragment.o();
    }

    public static final void V0(FeishuConnectFragment feishuConnectFragment, View view) {
        feishuConnectFragment.H0();
    }

    public static final void W0(FeishuConnectFragment feishuConnectFragment, View view) {
        feishuConnectFragment.L0();
    }

    public static final Y8.t Y0(FeishuConnectFragment feishuConnectFragment, RecommendedTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("clicked recommended task=%s", Arrays.copyOf(new Object[]{task.getId()}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        feishuConnectFragment.I0(task);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(AbstractC2306b state) {
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
                    m1(fVar);
                    this.connectingTransitionEndAtMs = System.currentTimeMillis() + 3000;
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$render$1(this, state, null), 3, null);
                    return;
                }
            }
        }
        if (!z10 || System.currentTimeMillis() >= this.connectingTransitionEndAtMs) {
            m1(state);
        } else {
            C4148a.d(TAG, "render Connected within transition window, swallow", false, 4, null);
        }
    }

    private final void a1() {
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

    private final void b1() {
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
        l0(C1173v.p(0, 0, 2, 2));
    }

    private final void c1() {
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
        l0(C1173v.p(0, 0, 3, 2));
    }

    private final void d1() {
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
        l0(C1173v.p(0, 3, 2, 2));
    }

    private final void e1(AbstractC2306b.Connected state) {
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
        f1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$renderConnected$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
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
        c1121e2.connectedActionArea.addView(p0(zD, !zBooleanValue, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.P
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectFragment.g1(((Boolean) obj).booleanValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t g1(boolean z10) {
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

    private final void h1() {
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
        l0(C1173v.p(0, 0, 0, 3));
    }

    private final void i0() {
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

    private final void i1(AbstractC2306b.Failed state) {
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
        c1121e7.tvFailReason.setText(r0(state.getStage(), z10));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(boolean cancelling) {
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
        c1121e8.btnTopUninstall.setBackground(cancelling ? null : androidx.core.content.a.e(requireContext(), R$drawable.bg_new_session_circle));
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

    private final void j1() {
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

    private final void k1() {
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
        l0(C1173v.p(0, 2, 2, 2));
    }

    private final void l0(List<Integer> dotStates) {
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

    private final void l1(int stepBase) {
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
        n0(stepBase, false);
    }

    private final void m0() throws Resources.NotFoundException {
        C1121e c1121e = this.binding;
        C1121e c1121e2 = null;
        if (c1121e == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e = null;
        }
        c1121e.root.setBackgroundColor(-15658735);
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        c1121e3.root.setFitsSystemWindows(false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_padding_h);
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        LinearLayout groupInstalling = c1121e4.groupInstalling;
        kotlin.jvm.internal.p.h(groupInstalling, "groupInstalling");
        k0(groupInstalling, dimensionPixelSize);
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        ScrollView groupConnected = c1121e5.groupConnected;
        kotlin.jvm.internal.p.h(groupConnected, "groupConnected");
        k0(groupConnected, dimensionPixelSize);
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e2 = c1121e6;
        }
        LinearLayout groupFailed = c1121e2.groupFailed;
        kotlin.jvm.internal.p.h(groupFailed, "groupFailed");
        k0(groupFailed, dimensionPixelSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(AbstractC2306b state) {
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
            l1(0);
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.k.INSTANCE)) {
            k1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.d.INSTANCE)) {
            d1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.g.INSTANCE)) {
            l1(1);
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.C0262b.INSTANCE)) {
            b1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.c.INSTANCE)) {
            c1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.a.INSTANCE)) {
            a1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.j.INSTANCE)) {
            j1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.m.INSTANCE)) {
            n1();
        } else if (kotlin.jvm.internal.p.d(state, AbstractC2306b.f.INSTANCE)) {
            h1();
        } else if (state instanceof AbstractC2306b.Connected) {
            e1((AbstractC2306b.Connected) state);
        } else {
            if (!(state instanceof AbstractC2306b.Failed)) {
                throw new NoWhenBranchMatchedException();
            }
            i1((AbstractC2306b.Failed) state);
        }
        i0();
        E1(abstractC2306b, state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(int stepIndex, boolean completed) {
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
        l0(arrayList);
    }

    private final void n1() {
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
        l0(C1173v.p(0, 0, 3, 2));
    }

    private final FrameLayout p0(final boolean checked, boolean enabled, final InterfaceC5074l<? super Boolean, Y8.t> onCheckChange) {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(requireContext(), R$color.feishu_brand);
        int iC2 = androidx.core.content.a.c(requireContext(), R$color.feishu_step_dot_pending);
        FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        if (!enabled) {
            Context contextRequireContext = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
            IndeterminateSpinnerView indeterminateSpinnerView = new IndeterminateSpinnerView(contextRequireContext, null, 0, 6, null);
            b5.m mVar = b5.m.INSTANCE;
            Context contextRequireContext2 = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
            indeterminateSpinnerView.setColor(mVar.i(contextRequireContext2));
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
        View view = new View(requireContext());
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
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.V
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.q0(onCheckChange, checked, view2);
            }
        });
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    private final String r0(FailStage stage, boolean timeout) {
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

    public static final Y8.t r1() {
        FeishuCliRepository.l(FeishuCliRepository.INSTANCE, null, null, 3, null);
        return Y8.t.f7040a;
    }

    private final String s0() {
        String strT0 = t0(this.lastRenderedState);
        if (strT0 != null) {
            return strT0;
        }
        String str = this.lastStep;
        return str == null ? W4.b.STEP_INSTALL : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1() {
        PollingManager<AbstractC2306b> pollingManager = this.authorizePoller;
        if (pollingManager == null) {
            kotlin.jvm.internal.p.A("authorizePoller");
            pollingManager = null;
        }
        pollingManager.d(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.N
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectFragment.t1(this.f24244a, (AbstractC2306b) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.O
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FeishuConnectFragment.u1(this.f24245a);
            }
        });
    }

    private final String t0(AbstractC2306b state) {
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

    public static final Y8.t t1(FeishuConnectFragment feishuConnectFragment, AbstractC2306b state) {
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("authorize poll update=%s", Arrays.copyOf(new Object[]{state}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (state instanceof AbstractC2306b.m) {
            feishuConnectFragment.Z0(state);
            feishuConnectFragment.z1();
        } else if (state instanceof AbstractC2306b.Failed) {
            feishuConnectFragment.Z0(state);
        }
        return Y8.t.f7040a;
    }

    private final String u0(FailStage stage) {
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

    public static final Y8.t u1(FeishuConnectFragment feishuConnectFragment) {
        C4148a.u(TAG, "authorize poll timeout", false, 4, null);
        Toast.makeText(feishuConnectFragment.requireContext(), feishuConnectFragment.getString(R$string.feishu_cli_toast_authorize_timeout), 0).show();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h0 v0() {
        return i0.INSTANCE.a();
    }

    private final void v1() {
        kotlinx.coroutines.g gVar = this.checkingAuthJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.checkingAuthJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$startCheckingAuthTimeout$1(this, null), 3, null);
    }

    private final void w1() {
        kotlinx.coroutines.g gVar = this.checkingCreateJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.checkingCreateJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$startCheckingCreateTimeout$1(this, null), 3, null);
    }

    private final void x0() {
        W4.b.d(W4.b.INSTANCE, W4.b.TOOL_FEISHU, "authorize", "authorize", null, 8, null);
        C4148a.d(TAG, "goAuthorize clicked", false, 4, null);
        if (z0("goAuthorize") || A0("goAuthorize")) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$goAuthorize$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        l1(1);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$startCreateBotProgress$1(this, null), 3, null);
    }

    private final void y0() {
        if (z0("goCreateBot") || A0("goCreateBot")) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$goCreateBot$1(this, null), 3, null);
    }

    private final void y1() {
        W4.b.INSTANCE.b(W4.b.TOOL_FEISHU);
        this.enteredFromInitialConnected = false;
        this.lastStep = null;
        com.stepos.ailauncher.common.utils.I i10 = com.stepos.ailauncher.common.utils.I.INSTANCE;
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        if (!i10.b(contextRequireContext)) {
            C4148a.d(TAG, "startInstall blocked: no network", false, 4, null);
            Toast.makeText(requireContext(), getString(R$string.feishu_cli_toast_network_unavailable), 0).show();
        } else {
            if (z0("startInstall")) {
                return;
            }
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.q();
            C1();
            if (A0("startInstall")) {
                return;
            }
            l1(0);
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new FeishuConnectFragment$startInstall$1(this, null), 3, null);
        }
    }

    private final boolean z0(String callerTag) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            C2309e c2309e = C2309e.INSTANCE;
            Context contextRequireContext = requireContext();
            kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
            boolean zA = c2309e.a(contextRequireContext);
            boolean z10 = false;
            if (!zA) {
                if (!isAdded() || getView() == null) {
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                    String str = String.format("%s skip dialog: fragment not attached", Arrays.copyOf(new Object[]{callerTag}, 1));
                    kotlin.jvm.internal.p.h(str, "format(...)");
                    C4148a.d(TAG, str, false, 4, null);
                } else {
                    kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                    String str2 = String.format("%s intercepted: feishu app not installed", Arrays.copyOf(new Object[]{callerTag}, 1));
                    kotlin.jvm.internal.p.h(str2, "format(...)");
                    C4148a.d(TAG, str2, false, 4, null);
                    Context contextRequireContext2 = requireContext();
                    kotlin.jvm.internal.p.h(contextRequireContext2, "requireContext(...)");
                    new m0(contextRequireContext2).show();
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

    private final void z1() {
        PollingManager<AbstractC2306b> pollingManager = this.reviewPoller;
        if (pollingManager == null) {
            kotlin.jvm.internal.p.A("reviewPoller");
            pollingManager = null;
        }
        pollingManager.d(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.S
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return FeishuConnectFragment.A1(this.f24246a, (AbstractC2306b) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.T
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FeishuConnectFragment.B1(this.f24247a);
            }
        });
    }

    public final void X0(String prompt) {
        if (t() != null && com.stepos.ailauncher.container.l0.INSTANCE.m(prompt)) {
            o();
            return;
        }
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        C2739j.z(contextRequireContext, prompt, SheetHeightMode.FULL_9, null, null, null, null, 120, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    public final void k0(View view, int horizontalPadding) {
        view.setPadding(horizontalPadding, view.getPaddingTop(), horizontalPadding, view.getPaddingBottom());
    }

    public final PendingReturn o0() {
        PendingReturn pendingReturn = this.pendingReturn;
        PendingReturn pendingReturn2 = PendingReturn.NONE;
        PendingReturn pendingReturn3 = pendingReturn != pendingReturn2 ? this.pendingReturn : pendingReturnGlobal;
        if (pendingReturn3 != pendingReturn2) {
            this.pendingReturn = pendingReturn2;
            pendingReturnGlobal = pendingReturn2;
        }
        return pendingReturn3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r2 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b o1() {
        /*
            r5 = this;
            com.stepos.ailauncher.agent.aispace.skill.feishu.h0 r0 = r5.v0()
            com.stepos.ailauncher.agent.aispace.skill.feishu.b r0 = r0.getState()
            com.stepos.ailauncher.agent.aispace.skill.feishu.b$i r1 = com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b.i.INSTANCE
            boolean r1 = kotlin.jvm.internal.p.d(r0, r1)
            if (r1 != 0) goto L11
            goto L47
        L11:
            com.stepos.ailauncher.agent.aispace.skill.feishu.h0 r1 = r5.v0()
            boolean r2 = r1 instanceof com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector
            r3 = 0
            if (r2 == 0) goto L1d
            com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector r1 = (com.stepos.ailauncher.agent.aispace.skill.feishu.FakeFeishuConnector) r1
            goto L1e
        L1d:
            r1 = r3
        L1e:
            if (r1 != 0) goto L21
            goto L47
        L21:
            com.stepos.ailauncher.agent.aispace.skill.feishu.net.j r2 = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE
            Xa.t r2 = r2.i()
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L38
            boolean r4 = r5.w0()
            if (r4 == 0) goto L38
            r4 = 1
            r5.awaitingFirstSnapshot = r4
        L38:
            if (r2 != 0) goto L48
            boolean r5 = r5.w0()
            if (r5 == 0) goto L44
            java.lang.String r5 = "connected"
            r2 = r5
            goto L45
        L44:
            r2 = r3
        L45:
            if (r2 != 0) goto L48
        L47:
            return r0
        L48:
            r1.n(r2)
            kotlin.jvm.internal.y r5 = kotlin.jvm.internal.y.f34840a
            com.stepos.ailauncher.agent.aispace.skill.feishu.b r5 = r1.getState()
            java.lang.Object[] r5 = new java.lang.Object[]{r2, r5}
            r0 = 2
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r0)
            java.lang.String r0 = "resolveInitialState seed=%s → %s"
            java.lang.String r5 = java.lang.String.format(r0, r5)
            java.lang.String r0 = "format(...)"
            kotlin.jvm.internal.p.h(r5, r0)
            r0 = 0
            r2 = 4
            java.lang.String r4 = "AILauncher-FeishuConn"
            h8.C4148a.d(r4, r5, r0, r2, r3)
            com.stepos.ailauncher.agent.aispace.skill.feishu.b r5 = r1.getState()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment.o1():com.stepos.ailauncher.agent.aispace.skill.feishu.b");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PendingReturn pendingReturnO0 = o0();
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onResume pending=%s currentState=%s", Arrays.copyOf(new Object[]{pendingReturnO0, v0().getState()}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (pendingReturnO0 == PendingReturn.NONE) {
            return;
        }
        if (pendingReturnO0 == PendingReturn.AUTHORIZE) {
            Z0(AbstractC2306b.c.INSTANCE);
            v1();
        }
        if (pendingReturnO0 == PendingReturn.CREATE_BOT) {
            Z0(AbstractC2306b.d.INSTANCE);
            w1();
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AnonymousClass1(pendingReturnO0, this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.p.i(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(KEY_PENDING_RETURN, this.pendingReturn.name());
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onSaveInstanceState pendingReturn=%s", Arrays.copyOf(new Object[]{this.pendingReturn}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        String string;
        Object objB;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        C1121e c1121eA = C1121e.a(view);
        kotlin.jvm.internal.p.h(c1121eA, "bind(...)");
        this.binding = c1121eA;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("onViewCreated savedInstanceState=%s pendingReturnGlobal=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(savedInstanceState != null), pendingReturnGlobal}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C1121e c1121e = null;
        C4148a.d(TAG, str, false, 4, null);
        m0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        C1121e c1121e2 = this.binding;
        if (c1121e2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e2 = null;
        }
        ImageView btnBack = c1121e2.btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        C1121e c1121e3 = this.binding;
        if (c1121e3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e3 = null;
        }
        FrameLayout btnTopUninstall = c1121e3.btnTopUninstall;
        kotlin.jvm.internal.p.h(btnTopUninstall, "btnTopUninstall");
        C2773b6.p(c2773b6, new View[]{btnBack, btnTopUninstall}, null, false, 6, null);
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
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        this.authorizePoller = new PollingManager<>(C1398p.a(viewLifecycleOwner2), 1500L, 60, new AnonymousClass3(null));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        this.reviewPoller = new PollingManager<>(C1398p.a(viewLifecycleOwner3), 500L, 120, new AnonymousClass4(null));
        C1121e c1121e4 = this.binding;
        if (c1121e4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e4 = null;
        }
        c1121e4.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.K
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.P0(this.f24242a, view2);
            }
        });
        C1121e c1121e5 = this.binding;
        if (c1121e5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e5 = null;
        }
        c1121e5.btnConnect.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.X
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.Q0(this.f24252a, view2);
            }
        });
        C1121e c1121e6 = this.binding;
        if (c1121e6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e6 = null;
        }
        c1121e6.btnRetry.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.R0(this.f24253a, view2);
            }
        });
        C1121e c1121e7 = this.binding;
        if (c1121e7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e7 = null;
        }
        c1121e7.btnInstallNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.S0(this.f24254a, view2);
            }
        });
        C1121e c1121e8 = this.binding;
        if (c1121e8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e8 = null;
        }
        c1121e8.btnAuthorize.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.T0(this.f24255a, view2);
            }
        });
        C1121e c1121e9 = this.binding;
        if (c1121e9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e9 = null;
        }
        c1121e9.btnBackToAiSpace.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.U0(this.f24256a, view2);
            }
        });
        C1121e c1121e10 = this.binding;
        if (c1121e10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e10 = null;
        }
        c1121e10.btnAbortLink.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.V0(this.f24257a, view2);
            }
        });
        C1121e c1121e11 = this.binding;
        if (c1121e11 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e11 = null;
        }
        c1121e11.btnTopUninstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.W0(this.f24258a, view2);
            }
        });
        C1121e c1121e12 = this.binding;
        if (c1121e12 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e12 = null;
        }
        c1121e12.pbTopUninstall.setColor(-1);
        C1121e c1121e13 = this.binding;
        if (c1121e13 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e13 = null;
        }
        c1121e13.pbAbortLink.setColor(-1);
        C1121e c1121e14 = this.binding;
        if (c1121e14 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e14 = null;
        }
        c1121e14.dotStep1Loading.setColor(-1);
        C1121e c1121e15 = this.binding;
        if (c1121e15 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e15 = null;
        }
        c1121e15.dotStep2Loading.setColor(-1);
        C1121e c1121e16 = this.binding;
        if (c1121e16 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e16 = null;
        }
        c1121e16.dotStep3Loading.setColor(-1);
        C1121e c1121e17 = this.binding;
        if (c1121e17 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e17 = null;
        }
        c1121e17.dotStep4Loading.setColor(-1);
        C1121e c1121e18 = this.binding;
        if (c1121e18 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e18 = null;
        }
        c1121e18.btnDebugLogClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.M0(this.f24259a, view2);
            }
        });
        C1121e c1121e19 = this.binding;
        if (c1121e19 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e19 = null;
        }
        c1121e19.btnDebugLogClear.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.L
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.N0(view2);
            }
        });
        C1121e c1121e20 = this.binding;
        if (c1121e20 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e20 = null;
        }
        c1121e20.btnDebugLogToggle.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.W
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeishuConnectFragment.O0(this.f24251a, view2);
            }
        });
        C1121e c1121e21 = this.binding;
        if (c1121e21 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1121e21 = null;
        }
        c1121e21.rvRecommendedTasks.setLayoutManager(new LinearLayoutManager(requireContext()));
        C1121e c1121e22 = this.binding;
        if (c1121e22 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c1121e = c1121e22;
        }
        c1121e.rvRecommendedTasks.setAdapter(this.recommendedAdapter);
        com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.q();
        AbstractC2306b abstractC2306bO1 = o1();
        if (abstractC2306bO1 instanceof AbstractC2306b.Connected) {
            this.lastRenderedState = abstractC2306bO1;
            this.enteredFromInitialConnected = true;
        }
        Z0(abstractC2306bO1);
        G0();
        F0();
        C0();
        E0();
        D0();
        C1();
    }

    public final void p1(PendingReturn value) {
        this.pendingReturn = value;
        pendingReturnGlobal = value;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("setPendingReturn(%s)", Arrays.copyOf(new Object[]{value}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
    }

    public final void q1(String title, String description, String cancelText, String confirmText) {
        androidx.fragment.app.r rVarRequireActivity = requireActivity();
        kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
        if (com.stepos.ailauncher.container.dialog.f.q(new S4.d(rVarRequireActivity, title, description, cancelText, confirmText, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.Q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return FeishuConnectFragment.r1();
            }
        }, 32, null), "feishuCancel")) {
            return;
        }
        C4148a.u(TAG, "show cancel confirm dialog failed", false, 4, null);
    }

    public final boolean w0() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean(ARG_CONNECTED, false);
    }
}
