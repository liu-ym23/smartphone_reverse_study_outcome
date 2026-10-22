package com.stepos.agentframework.chatcore;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ReconnectReason;
import com.stepos.agentframework.chatcore.session.TalkPhase;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import java.util.List;
import kotlin.Metadata;
import w4.C5732a;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000fH&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH&¢\u0006\u0004\b\u001e\u0010\u0016J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H&¢\u0006\u0004\b#\u0010\u0018J\u001f\u0010&\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010\u0016J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u0018J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0018J%\u0010.\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\u0018J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b5\u0010\u0018J\u0017\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u000206H\u0016¢\u0006\u0004\b;\u00109J\u001f\u0010?\u001a\u00020\u00052\u0006\u0010<\u001a\u0002062\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J#\u0010D\u001a\u00020\u00052\b\b\u0002\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0005H\u0016¢\u0006\u0004\bF\u0010\u0018J\u001b\u0010G\u001a\u00020\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\bI\u0010\u0016¨\u0006JÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/c;", "", "", "Lw4/c;", "messages", "LY8/t;", "setMessages", "(Ljava/util/List;)V", "message", "r", "(Lw4/c;)V", "", "playTts", "n", "(Lw4/c;Z)V", "", "oldMessageId", "I", "(Lw4/c;Ljava/lang/String;)V", "R", "messageId", "K", "(Ljava/lang/String;)V", "O", "()V", "Lw4/e;", "title", "F", "(Lw4/e;Ljava/util/List;)V", "sessionId", "m", "Lw4/a;", "agentInfo", "w", "(Lw4/a;)V", "l", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", Const.INTENT_KEY_APIKEY, "(Lw4/c;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "text", "B", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "messageIds", "success", ExifInterface.LONGITUDE_WEST, "(Ljava/util/List;Z)V", ExifInterface.LONGITUDE_EAST, "Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "phase", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatcore/session/TalkPhase;)V", "q", "", "startAtMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(J)V", "elapsedMs", "C", "durationMs", "", "toolCount", "G", "(JI)V", "roundAlive", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "reason", "s", "(ZLcom/stepos/agentframework/chatcore/session/ReconnectReason;)V", "N", "U", "(Lcom/stepos/agentframework/chatcore/session/ReconnectReason;)V", "X", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC1848c {
    static /* synthetic */ void j(InterfaceC1848c interfaceC1848c, ReconnectReason reconnectReason, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideReconnectPrompt");
        }
        if ((i10 & 1) != 0) {
            reconnectReason = null;
        }
        interfaceC1848c.U(reconnectReason);
    }

    default void B(String text) {
        kotlin.jvm.internal.p.i(text, "text");
    }

    default void C(long elapsedMs) {
    }

    default void E() {
    }

    void F(w4.e title, List<ChatMessage> messages);

    default void G(long durationMs, int toolCount) {
    }

    void I(ChatMessage message, String oldMessageId);

    void K(String messageId);

    default void N() {
    }

    void O();

    default void R(ChatMessage message, String oldMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        I(message, oldMessageId);
    }

    default void S() {
    }

    default void T() {
    }

    default void U(ReconnectReason reason) {
    }

    default void W(List<String> messageIds, boolean success) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
    }

    default void X(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
    }

    void a(ChatMessage message, AppUIData appUIData);

    default void g(TalkPhase phase) {
        kotlin.jvm.internal.p.i(phase, "phase");
    }

    default void h(long startAtMs) {
    }

    void l();

    void m(String sessionId);

    void n(ChatMessage message, boolean playTts);

    default void q() {
    }

    default void r(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        n(message, true);
    }

    default void s(boolean roundAlive, ReconnectReason reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
    }

    void setMessages(List<ChatMessage> messages);

    void w(C5732a agentInfo);
}
