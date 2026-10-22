package com.stepos.agentframework.chatui;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import kotlin.AskUserConversation;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\fJ\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0007H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010&J/\u0010)\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H&¢\u0006\u0004\b)\u0010*J'\u0010-\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\t2\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b-\u0010.J'\u00100\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010&J\u000f\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010&J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u0010&J\u000f\u00105\u001a\u00020\u001bH\u0016¢\u0006\u0004\b5\u0010\u001f¨\u00066À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/U1;", "", "", "question", "LY8/t;", "L", "(Ljava/lang/String;)V", "", "position", "Lcom/stepos/agentframework/chatui/N1;", "item", "z", "(ILcom/stepos/agentframework/chatui/N1;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "D", "t", "Q", "e", "P", Const.INTENT_KEY_UMID, "J", "(I)V", "text", "setInputLayoutText", "Lcom/stepos/agentframework/AgentUIConfig;", "getAgentUIConfig", "()Lcom/stepos/agentframework/AgentUIConfig;", "", Const.INTENT_KEY_PKGNAME, "(I)Z", "Y", "()Z", "message", "toolCallId", "toolActionBarClickedIcon", "u", "(ILcom/stepos/agentframework/chatui/N1;Ljava/lang/String;I)V", "x", "()V", "messageId", "action", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(ILcom/stepos/agentframework/chatui/N1;Ljava/lang/String;Ljava/lang/String;)V", "LK6/d;", "conversation", "c", "(ILcom/stepos/agentframework/chatui/N1;LK6/d;)V", "delta", "f", "(ILcom/stepos/agentframework/chatui/N1;I)V", "o", "p", "y", "v", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface U1 {
    void D(int position, DisplayMessage item);

    void J(int position);

    void L(String question);

    void P(int position, DisplayMessage item);

    void Q(int position, DisplayMessage item);

    void V(int position, DisplayMessage message, String messageId, String action);

    default boolean Y() {
        return false;
    }

    boolean b(int position);

    void c(int position, DisplayMessage message, AskUserConversation conversation);

    void d(int position, DisplayMessage item);

    void e(int position, DisplayMessage item);

    default void f(int position, DisplayMessage item, int delta) {
        kotlin.jvm.internal.p.i(item, "item");
    }

    AgentUIConfig getAgentUIConfig();

    void i(int position, DisplayMessage item);

    default void o() {
    }

    default void p() {
        o();
    }

    void setInputLayoutText(String text);

    void t(int position, DisplayMessage item);

    void u(int position, DisplayMessage message, String toolCallId, int toolActionBarClickedIcon);

    default boolean v() {
        return false;
    }

    default void x() {
    }

    default void y() {
    }

    void z(int position, DisplayMessage item);
}
