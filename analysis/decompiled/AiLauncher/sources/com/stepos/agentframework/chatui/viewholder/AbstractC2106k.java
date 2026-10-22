package com.stepos.agentframework.chatui.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.ChatMessageAdapter;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.SendState;
import com.stepos.agentframework.chatui.U1;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH\u0016¢\u0006\u0004\b#\u0010\u001eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/N1;", "displayMessage", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatui/N1;I)V", "isLike", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "message", "f", "(Lcom/stepos/agentframework/chatui/N1;)V", "", "errorMessage", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "()V", "Lcom/stepos/agentframework/chatui/SendState;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/chatui/SendState;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/chatui/U1;", "c", "()Lcom/stepos/agentframework/chatui/U1;", "setChatView", "(Lcom/stepos/agentframework/chatui/U1;)V", Const.INTENT_KEY_UMID, "()I", "logicalBindingPosition", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.viewholder.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2106k extends RecyclerView.ViewHolder {
    private U1 chatView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2106k(View itemView, U1 chatView) {
        super(itemView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        this.chatView = chatView;
    }

    public void a() {
    }

    public void b() {
    }

    /* renamed from: c, reason: from getter */
    public final U1 getChatView() {
        return this.chatView;
    }

    public final int d() {
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = getBindingAdapter();
        ChatMessageAdapter chatMessageAdapter = bindingAdapter instanceof ChatMessageAdapter ? (ChatMessageAdapter) bindingAdapter : null;
        int bindingAdapterPosition = getBindingAdapterPosition();
        return chatMessageAdapter != null ? chatMessageAdapter.V(bindingAdapterPosition) : bindingAdapterPosition;
    }

    public abstract void e(S1 item, int position);

    public void f(DisplayMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
    }

    public void g(String errorMessage) {
        kotlin.jvm.internal.p.i(errorMessage, "errorMessage");
    }

    public void h(DisplayMessage displayMessage, int position) {
        kotlin.jvm.internal.p.i(displayMessage, "displayMessage");
    }

    public void i(int isLike) {
    }

    public void j(SendState state) {
        kotlin.jvm.internal.p.i(state, "state");
    }
}
