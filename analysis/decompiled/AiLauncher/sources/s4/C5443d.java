package s4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.common.FunctionCall;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.List;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0010\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ls4/d;", "", "<init>", "()V", "", x5.d.EXTRA_ENABLED, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Z)V", "LK6/m;", "chatReplyInfo", "e", "(LK6/m;)V", "f", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/m;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", UxipConstants.f30680s, "enableRawPayloadDump", "Z", "getEnableRawPayloadDump", "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: s4.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5443d {
    public static final C5443d INSTANCE = new C5443d();
    private static final String TAG = "PushMessageCenter";
    private static volatile boolean enableRawPayloadDump;

    public static final void a(boolean enabled) {
        enableRawPayloadDump = enabled;
        C4148a.k(TAG, "configureRawPayloadDump enabled=" + enabled, false, 4, null);
    }

    public static final void b(C0917m chatReplyInfo) {
        p.i(chatReplyInfo, "chatReplyInfo");
        if (!enableRawPayloadDump) {
            C4148a.k("ChatCoreSdk", "onToolCall -> " + INSTANCE.g(chatReplyInfo), false, 4, null);
            return;
        }
        String json = ExtKt.l().toJson(chatReplyInfo);
        p.h(json, "toJson(...)");
        C4148a.k("ChatCoreSdk", "onToolCall -> chatReplyInfo:" + json, false, 4, null);
    }

    public static final void c(C0917m chatReplyInfo) {
        p.i(chatReplyInfo, "chatReplyInfo");
        if (!enableRawPayloadDump) {
            C4148a.k(TAG, "handlePushMessage: " + INSTANCE.g(chatReplyInfo), false, 4, null);
            return;
        }
        String json = ExtKt.l().toJson(chatReplyInfo);
        p.h(json, "toJson(...)");
        C4148a.k(TAG, "handlePushMessage: " + json, false, 4, null);
    }

    public static final void d(C0917m chatReplyInfo) {
        p.i(chatReplyInfo, "chatReplyInfo");
        if (!enableRawPayloadDump) {
            C4148a.u(TAG, "ignore push message. response is null " + INSTANCE.g(chatReplyInfo), false, 4, null);
            return;
        }
        String json = ExtKt.l().toJson(chatReplyInfo);
        p.h(json, "toJson(...)");
        C4148a.u(TAG, "ignore push message. response is null chatReplyInfo:" + json, false, 4, null);
    }

    public static final void e(C0917m chatReplyInfo) {
        p.i(chatReplyInfo, "chatReplyInfo");
        if (!enableRawPayloadDump) {
            C4148a.k(TAG, "handlePushToolCall: " + INSTANCE.g(chatReplyInfo), false, 4, null);
            return;
        }
        String json = ExtKt.l().toJson(chatReplyInfo);
        p.h(json, "toJson(...)");
        C4148a.k(TAG, "handlePushToolCall: " + json, false, 4, null);
    }

    public static final void f(C0917m chatReplyInfo) {
        p.i(chatReplyInfo, "chatReplyInfo");
        if (!enableRawPayloadDump) {
            C4148a.u(TAG, "ignore push toolCall. response is null " + INSTANCE.g(chatReplyInfo), false, 4, null);
            return;
        }
        String json = ExtKt.l().toJson(chatReplyInfo);
        p.h(json, "toJson(...)");
        C4148a.u(TAG, "ignore push toolCall. response is null chatReplyInfo:" + json, false, 4, null);
    }

    public final String g(C0917m c0917m) {
        Object objB;
        String string;
        FunctionCall functionCall = c0917m.getFunctionCall();
        try {
            Result.Companion companion = Result.INSTANCE;
            List<AbstractC0913i> listN = c0917m.n();
            objB = Result.b(Integer.valueOf((listN == null || (string = listN.toString()) == null) ? 0 : string.length()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        int iIntValue = ((Number) objB).intValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("messageId=");
        sb2.append(c0917m.getMessageId());
        sb2.append(" traceId=");
        sb2.append(c0917m.getTraceId());
        sb2.append(" conversationId=");
        sb2.append(c0917m.getConversationId());
        sb2.append(" answerType=");
        sb2.append(c0917m.getAnswerType());
        sb2.append(" event=");
        sb2.append(c0917m.getEvent());
        sb2.append(" role=");
        sb2.append(c0917m.getRole());
        sb2.append(" contentLen=");
        sb2.append(iIntValue);
        if (functionCall != null) {
            sb2.append(" toolCallId=");
            sb2.append(functionCall.getToolId());
            sb2.append(" toolName=");
            sb2.append(functionCall.getName());
            sb2.append(" apiName=");
            sb2.append(functionCall.getApi_name());
            Object arguments = functionCall.getArguments();
            String string2 = arguments != null ? arguments.toString() : null;
            sb2.append(" argsLen=");
            sb2.append(string2 != null ? string2.length() : 0);
            sb2.append(" resultLen=");
            String content = functionCall.getContent();
            sb2.append(content != null ? content.length() : 0);
        }
        return sb2.toString();
    }
}
