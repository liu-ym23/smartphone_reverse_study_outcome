package com.stepos.agentframework.chatcore.utils;

import La.H;
import La.K;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.r;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.common.FunctionCall;
import com.stepos.common.RequiredAction;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.AbstractC0913i;
import kotlin.C0914j;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.FunctionCallContentResource;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0012\u001a\u00020\u000b*\u00020\n2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\u0014\u0010\r\u001a'\u0010\u0015\u001a\u00020\u000b*\u00020\n2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0011\u0010\u0016\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\u0016\u0010\r\u001a'\u0010\u0017\u001a\u00020\u000b*\u00020\n2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0017\u0010\u0013\u001a5\u0010\u001e\u001a\u00020\u001a*\u00020\u00182\"\b\u0002\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u0019¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010 \u001a\u00020\u001a*\u00020\u0018¢\u0006\u0004\b \u0010!\u001a\u0011\u0010\"\u001a\u00020\u001a*\u00020\u0018¢\u0006\u0004\b\"\u0010!\u001a\u0011\u0010$\u001a\u00020#*\u00020\u0018¢\u0006\u0004\b$\u0010%\u001a\u0011\u0010&\u001a\u00020\u001a*\u00020\u0018¢\u0006\u0004\b&\u0010!\u001a!\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b*\u00020\u00182\u0006\u0010'\u001a\u00020\u001a¢\u0006\u0004\b(\u0010)\u001a!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b*\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-\u001a\u001b\u0010.\u001a\u00020\u001c*\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/\u001a\u001b\u00104\u001a\u000203*\u0002002\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b4\u00105\u001a\u0019\u00107\u001a\u00020\u001a*\u00020\u001a2\u0006\u00106\u001a\u00020\u0018¢\u0006\u0004\b7\u00108\u001a\u0019\u00109\u001a\u00020\u001a*\u00020\u001a2\u0006\u00106\u001a\u00020\u0018¢\u0006\u0004\b9\u00108\u001a\u0011\u0010<\u001a\u00020;*\u00020:¢\u0006\u0004\b<\u0010=\u001a\u0011\u0010>\u001a\u00020;*\u00020\u0018¢\u0006\u0004\b>\u0010?\"\u0014\u0010A\u001a\u00020@8\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010B\"\u0017\u0010D\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006H"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "", UxipConstants.f30643G, Const.INTENT_KEY_BACKGROUND_COMMAND, "(LXa/b;J)LXa/b;", "Landroid/content/Context;", "Landroidx/fragment/app/r;", "e", "(Landroid/content/Context;)Landroidx/fragment/app/r;", "Landroid/view/View;", "LY8/t;", "C", "(Landroid/view/View;)V", "Lkotlin/Function1;", "", "", "block", "D", "(Landroid/view/View;Lp9/l;)V", "m", "n", "p", "q", "LK6/m;", "Lkotlin/Function2;", "Lu4/d;", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "toolformat", "t", "(LK6/m;Lp9/p;)Lu4/d;", "s", "(LK6/m;)Lu4/d;", "f", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "k", "(LK6/m;)Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "B", "agentResponse", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LK6/m;Lu4/d;)Ljava/util/List;", "Lcom/stepos/common/FunctionCall;", "isResult", "x", "(Lcom/stepos/common/FunctionCall;Z)Ljava/util/List;", "w", "(Lcom/stepos/common/FunctionCall;Z)Lcom/stepos/agentframework/chatcore/intent/e;", "LK6/v;", "", "_structuredContent", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "y", "(LK6/v;Ljava/lang/Object;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "chatReplyInfo", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lu4/d;LK6/m;)Lu4/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/stepos/agentframework/chatcore/agents/y;", "LK6/n;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/agentframework/chatcore/agents/y;)LK6/n;", "z", "(LK6/m;)LK6/n;", "", "TAG", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "l", "()Lcom/google/gson/Gson;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExtKt {
    public static final String TAG = " [ext] ";
    private static final Gson gson = new Gson();

    public static final C0918n A(RequestParameter requestParameter) {
        p.i(requestParameter, "<this>");
        C0918n c0918n = new C0918n(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null);
        c0918n.d(requestParameter.getAgentId());
        c0918n.e(requestParameter.getDeviceId());
        c0918n.A(requestParameter.d());
        c0918n.f(requestParameter.getSecretkey());
        c0918n.B(requestParameter.getSessionId());
        c0918n.C(kotlin.collections.a.i());
        c0918n.G(requestParameter.getIsDeepThink());
        c0918n.y(requestParameter.getAudio());
        c0918n.F(requestParameter.i());
        c0918n.D(requestParameter.getGuiAgentModelName());
        c0918n.I(requestParameter.getTraceId());
        String messageId = requestParameter.getMessageId();
        if (messageId == null) {
            messageId = UUID.randomUUID().toString();
            p.h(messageId, "toString(...)");
        }
        c0918n.E(messageId);
        return c0918n;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0113 A[PHI: r1
      0x0113: PHI (r1v6 java.lang.String) = (r1v5 java.lang.String), (r1v7 java.lang.String) binds: [B:69:0x011d, B:65:0x0110] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final u4.AgentResponse B(kotlin.C0917m r18) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.ExtKt.B(K6.m):u4.d");
    }

    public static final void C(final View view) {
        p.i(view, "<this>");
        D(view, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.utils.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ExtKt.E(view, ((Integer) obj).intValue()));
            }
        });
    }

    public static final void D(View view, InterfaceC5074l<? super Integer, Boolean> block) {
        p.i(view, "<this>");
        p.i(block, "block");
        int visibility = view.getVisibility();
        if (!block.invoke(Integer.valueOf(visibility)).booleanValue() || visibility == 0) {
            return;
        }
        view.setVisibility(0);
    }

    public static final boolean E(View view, int i10) {
        return view.getVisibility() != 0;
    }

    public static final r e(Context context) {
        Context baseContext;
        p.i(context, "<this>");
        if (context instanceof r) {
            return (r) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == null) {
            return null;
        }
        return e(baseContext);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        return u(r5, null, 1, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final u4.AgentResponse f(kotlin.C0917m r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r5, r0)
            java.lang.Integer r0 = r5.getEvent()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Le
            goto L1a
        Le:
            int r3 = r0.intValue()
            r4 = 2
            if (r3 != r4) goto L1a
            u4.d r5 = u(r5, r2, r1, r2)
            return r5
        L1a:
            if (r0 != 0) goto L1d
            goto L66
        L1d:
            int r0 = r0.intValue()
            if (r0 != 0) goto L66
            java.lang.String r0 = r5.getAnswerType()
            if (r0 == 0) goto L61
            int r3 = r0.hashCode()
            r4 = -2016287450(0xffffffff87d1e526, float:-3.1581506E-34)
            if (r3 == r4) goto L53
            r4 = -123263224(0xfffffffff8a72708, float:-2.7122038E34)
            if (r3 == r4) goto L46
            r4 = 2053138021(0x7a606665, float:2.9128783E35)
            if (r3 == r4) goto L3d
            goto L61
        L3d:
            java.lang.String r3 = "function_call"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L4e
            goto L61
        L46:
            java.lang.String r3 = "tool_response"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L61
        L4e:
            u4.d r5 = u(r5, r2, r1, r2)
            return r5
        L53:
            java.lang.String r1 = "moderation"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5c
            goto L61
        L5c:
            u4.d r5 = B(r5)
            return r5
        L61:
            u4.d r5 = s(r5)
            return r5
        L66:
            u4.d r5 = s(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.ExtKt.f(K6.m):u4.d");
    }

    public static final <T> Xa.b<T> g(Xa.b<? extends T> bVar, long j10) {
        p.i(bVar, "<this>");
        return Xa.d.B(new ExtKt$fixInterval$1(bVar, j10, null));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final u4.AgentResponse h(u4.AgentResponse r16, kotlin.C0917m r17) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.ExtKt.h(u4.d, K6.m):u4.d");
    }

    public static final AgentResponse i(AgentResponse agentResponse, C0917m chatReplyInfo) {
        p.i(agentResponse, "<this>");
        p.i(chatReplyInfo, "chatReplyInfo");
        if (!TextUtils.isEmpty(chatReplyInfo.getReasoning_content())) {
            if (agentResponse.getType() == AgentMessageType.TEXT) {
                String reasoning_content = chatReplyInfo.getReasoning_content();
                p.f(reasoning_content);
                agentResponse.H(reasoning_content);
                agentResponse.F("");
                agentResponse.W(AgentMessageType.THINKING_TEXT);
                return agentResponse;
            }
            AgentMessageType type = agentResponse.getType();
            String reasoning_content2 = chatReplyInfo.getReasoning_content();
            C4148a.k(TAG, "接收到深度思考内容，但类型不为TEXT,type:" + type + ",reasoningLen=" + (reasoning_content2 != null ? reasoning_content2.length() : 0), false, 4, null);
        }
        return agentResponse;
    }

    public static final List<AgentTool> j(C0917m c0917m, AgentResponse agentResponse) {
        RequiredAction.SubmitToolOutputs submit_tool_outputs;
        List<RequiredAction.SubmitToolOutputs.ToolCall> tool_calls;
        p.i(c0917m, "<this>");
        p.i(agentResponse, "agentResponse");
        if (agentResponse.getType() == AgentMessageType.TOOL_SHOW || agentResponse.getType() == AgentMessageType.TOOL_RESULT) {
            FunctionCall functionCall = c0917m.getFunctionCall();
            if (functionCall != null) {
                return x(functionCall, agentResponse.getType() == AgentMessageType.TOOL_RESULT);
            }
            return null;
        }
        RequiredAction required_action = c0917m.getRequired_action();
        if (required_action == null || (submit_tool_outputs = required_action.getSubmit_tool_outputs()) == null || (tool_calls = submit_tool_outputs.getTool_calls()) == null) {
            return null;
        }
        List<RequiredAction.SubmitToolOutputs.ToolCall> list = tool_calls;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (RequiredAction.SubmitToolOutputs.ToolCall toolCall : list) {
            AgentTool agentTool = new AgentTool(null, null, null, null, null, null, null, false, null, null, null, null, null, 0, false, null, 0, 0L, false, 524287, null);
            agentTool.E(toolCall.getFunction().getName());
            agentTool.G(toolCall.getFunction().getArguments());
            agentTool.L(toolCall.getId());
            agentTool.M(toolCall.getFunction().getId());
            agentTool.w(toolCall.getFunction().getName());
            arrayList.add(agentTool);
        }
        return F.p1(arrayList);
    }

    public static final AgentMessageType k(C0917m c0917m) {
        p.i(c0917m, "<this>");
        Integer event = c0917m.getEvent();
        if (event != null && event.intValue() == 2) {
            return AgentMessageType.TOOL;
        }
        String answerType = c0917m.getAnswerType();
        if (answerType != null) {
            int iHashCode = answerType.hashCode();
            if (iHashCode != -2016287450) {
                if (iHashCode != -123263224) {
                    if (iHashCode == 2053138021 && answerType.equals("function_call")) {
                        return AgentMessageType.TOOL_SHOW;
                    }
                } else if (answerType.equals("tool_response")) {
                    return AgentMessageType.TOOL_RESULT;
                }
            } else if (answerType.equals("moderation")) {
                return AgentMessageType.MODERATION;
            }
        }
        return AgentMessageType.TEXT;
    }

    public static final Gson l() {
        return gson;
    }

    public static final void m(final View view) {
        p.i(view, "<this>");
        n(view, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.utils.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ExtKt.o(view, ((Integer) obj).intValue()));
            }
        });
    }

    public static final void n(View view, InterfaceC5074l<? super Integer, Boolean> block) {
        p.i(view, "<this>");
        p.i(block, "block");
        int visibility = view.getVisibility();
        if (!block.invoke(Integer.valueOf(visibility)).booleanValue() || visibility == 8) {
            return;
        }
        view.setVisibility(8);
    }

    public static final boolean o(View view, int i10) {
        return view.getVisibility() != 8;
    }

    public static final void p(final View view) {
        p.i(view, "<this>");
        q(view, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.utils.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ExtKt.r(view, ((Integer) obj).intValue()));
            }
        });
    }

    public static final void q(View view, InterfaceC5074l<? super Integer, Boolean> block) {
        p.i(view, "<this>");
        p.i(block, "block");
        int visibility = view.getVisibility();
        if (!block.invoke(Integer.valueOf(visibility)).booleanValue() || visibility == 4) {
            return;
        }
        view.setVisibility(4);
    }

    public static final boolean r(View view, int i10) {
        return view.getVisibility() != 4;
    }

    public static final AgentResponse s(C0917m c0917m) {
        Character chO1;
        p.i(c0917m, "<this>");
        AgentResponse agentResponseU = u(c0917m, null, 1, null);
        String strB = C0914j.b(c0917m.n());
        if (strB == null) {
            strB = "";
        }
        return (H.x0(strB) || (chO1 = K.O1(H.H1(strB).toString())) == null || chO1.charValue() != '{') ? i(agentResponseU, c0917m) : i(h(agentResponseU, c0917m), c0917m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AgentResponse t(C0917m c0917m, p9.p<? super C0917m, ? super AgentResponse, ? extends List<AgentTool>> toolformat) {
        List listM;
        String str;
        p.i(c0917m, "<this>");
        p.i(toolformat, "toolformat");
        AgentResponse agentResponse = new AgentResponse(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        agentResponse.D(c0917m.getAgentId());
        String strB = C0914j.b(c0917m.n());
        String str2 = "";
        if (strB == null) {
            strB = "";
        }
        agentResponse.F(strB);
        String messageId = c0917m.getMessageId();
        if (messageId == null) {
            messageId = "";
        }
        agentResponse.N(messageId);
        agentResponse.R(c0917m.getIsFinish() ? EReplyStatus.COMPLETED : EReplyStatus.REPLYING);
        String conversationId = c0917m.getConversationId();
        if (conversationId == null) {
            conversationId = "";
        }
        agentResponse.Q(conversationId);
        agentResponse.S(c0917m.D());
        agentResponse.W(k(c0917m));
        agentResponse.P(c0917m.getServerItemId());
        agentResponse.V(toolformat.invoke(c0917m, agentResponse));
        agentResponse.I(c0917m);
        agentResponse.E(c0917m.getAudio());
        List<AbstractC0913i> listN = c0917m.n();
        AbstractC0913i.Folder folder = null;
        if (listN != null) {
            listM = new ArrayList();
            for (Object obj : listN) {
                if (obj instanceof AbstractC0913i.File) {
                    listM.add(obj);
                }
            }
        } else {
            listM = null;
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        agentResponse.K(listM);
        List<AbstractC0913i> listN2 = c0917m.n();
        if (listN2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listN2) {
                if (obj2 instanceof AbstractC0913i.Folder) {
                    arrayList.add(obj2);
                }
            }
            folder = (AbstractC0913i.Folder) F.s0(arrayList);
        }
        agentResponse.M(folder);
        Map<String, String> mapS = c0917m.s();
        if (mapS != null && (str = mapS.get("finish_reason")) != null) {
            str2 = str;
        }
        agentResponse.L(str2);
        return agentResponse;
    }

    public static /* synthetic */ AgentResponse u(C0917m c0917m, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            pVar = new p9.p() { // from class: com.stepos.agentframework.chatcore.utils.f
                @Override // p9.p
                public final Object invoke(Object obj2, Object obj3) {
                    return ExtKt.v((C0917m) obj2, (AgentResponse) obj3);
                }
            };
        }
        return t(c0917m, pVar);
    }

    public static final List v(C0917m chatReplyInfo, AgentResponse agentResponse) {
        p.i(chatReplyInfo, "chatReplyInfo");
        p.i(agentResponse, "agentResponse");
        return j(chatReplyInfo, agentResponse);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Type inference failed for: r0v45, types: [com.google.gson.Gson] */
    /* JADX WARN: Type inference failed for: r2v32, types: [com.google.gson.Gson] */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v39, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.agentframework.chatcore.intent.AgentTool w(com.stepos.common.FunctionCall r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.utils.ExtKt.w(com.stepos.common.FunctionCall, boolean):com.stepos.agentframework.chatcore.intent.e");
    }

    public static final List<AgentTool> x(FunctionCall functionCall, boolean z10) {
        String json;
        p.i(functionCall, "<this>");
        AgentTool agentToolW = w(functionCall, z10);
        if (!z10) {
            return C1173v.s(agentToolW);
        }
        q4.i iVar = q4.i.INSTANCE;
        String name = functionCall.getName();
        if (name == null) {
            name = functionCall.getApi_name();
        }
        String content = functionCall.getContent();
        Object arguments = functionCall.getArguments();
        if (arguments == null) {
            json = null;
        } else if (arguments instanceof String) {
            json = (String) arguments;
        } else {
            json = l().toJson(arguments);
            p.h(json, "toJson(...)");
        }
        AppUIData appUIDataD = iVar.D(name, content, json);
        if (appUIDataD == null) {
            return C1173v.s(agentToolW);
        }
        return C1173v.s(agentToolW, new AgentTool(agentToolW.getToolCallId() + "#image_appui", null, null, null, null, null, null, true, null, null, appUIDataD, null, null, 0, true, null, 0, 0L, false, 506750, null));
    }

    public static final AppUIData y(FunctionCallContentResource functionCallContentResource, Object obj) {
        p.i(functionCallContentResource, "<this>");
        int iD = AppUIData.INSTANCE.d();
        String text = functionCallContentResource.getText();
        if (text == null) {
            text = "";
        }
        return new AppUIData(null, iD, null, false, null, null, null, obj, null, text, null, null, null, null, false, false, 64893, null);
    }

    public static final C0918n z(C0917m c0917m) {
        p.i(c0917m, "<this>");
        C0918n c0918n = new C0918n(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null);
        c0918n.B(c0917m.getConversationId());
        c0918n.z(c0917m.getMessageId());
        c0918n.d(c0917m.getAgentId());
        c0918n.e(c0917m.getDeviceId());
        c0918n.f(c0917m.getSecretkey());
        c0918n.C(c0917m.s());
        c0918n.I(c0917m.getTraceId());
        C4148a.k(TAG, "msgId: " + c0917m.getChatId() + " traceId: " + c0917m.getTraceId(), false, 4, null);
        return c0918n;
    }
}
