package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.view.HomeInputView;
import kotlin.Metadata;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0018H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u001bH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\"\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001f*\u00020\u001e2\b\b\u0001\u0010!\u001a\u00020 H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b$\u0010\bJ\u0010\u0010%\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b%\u0010\bJ\u0018\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0096\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010&H\u0096\u0001¢\u0006\u0004\b+\u0010)J\u001a\u0010-\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010,H\u0096\u0001¢\u0006\u0004\b-\u0010.J\u0018\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b0\u0010\rJ\u0010\u00101\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b1\u00102J\u001a\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000103H\u0096\u0001¢\u0006\u0004\b5\u00106J,\u0010=\u001a\u00020\u00062\u0006\u00108\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010<\u001a\u0004\u0018\u00010;H\u0096\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b?\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010@R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010B¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/task/space/C;", "Ly4/b;", "Lcom/stepos/ailauncher/chat/view/HomeInputView;", "delegate", "<init>", "(Lcom/stepos/ailauncher/chat/view/HomeInputView;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "isReplying", "setReplyingStatus", "(Z)V", "Ly4/b$f;", "listener", "setOnSendMessageListener", "(Ly4/b$f;)V", "Ly4/b$d;", "setOnImageClickListener", "(Ly4/b$d;)V", "Ly4/b$c;", "setOnFileClickListener", "(Ly4/b$c;)V", "Ly4/b$b;", "setOnCancelListener", "(Ly4/b$b;)V", "Ly4/b$a;", "setOnBtnPlusClickListener", "(Ly4/b$a;)V", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "id", Const.INTENT_KEY_APIKEY, "(I)Landroid/view/View;", Const.INTENT_KEY_UMID, "e", "", "text", "setInputTxt", "(Ljava/lang/String;)V", "message", "f", "Ly4/b$e;", "setOnLoadingBubbleListener", "(Ly4/b$e;)V", "enable", "setInputMoreBtnEnable", "getView", "()Landroid/view/View;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lcom/stepos/agentframework/AgentUIConfig;", "agentUIConfig", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/stepos/agentframework/AgentUIConfig;)V", "destroy", "Lcom/stepos/ailauncher/chat/view/HomeInputView;", "panelExpanded", "Z", "deferredReplyingStatus", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class C implements InterfaceC5940b {
    private boolean deferredReplyingStatus;
    private final HomeInputView delegate;
    private boolean panelExpanded;

    public C(HomeInputView delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // y4.InterfaceC5940b, y4.InterfaceC5939a
    public <T extends View> T a(int id) {
        return (T) this.delegate.a(id);
    }

    @Override // y4.InterfaceC5939a
    public void b(SessionHandler handler) {
        this.delegate.b(handler);
    }

    @Override // y4.InterfaceC5939a
    public void c(Context context, AttributeSet attrs, AgentUIConfig agentUIConfig) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        this.delegate.c(context, attrs, agentUIConfig);
    }

    @Override // y4.InterfaceC5940b
    public void d() {
        this.delegate.d();
    }

    @Override // y4.InterfaceC5939a
    public void destroy() {
        this.delegate.destroy();
    }

    @Override // y4.InterfaceC5940b
    public void e() {
        this.delegate.e();
    }

    @Override // y4.InterfaceC5940b
    public void f(String message) {
        this.delegate.f(message);
    }

    public final void g() {
        if (this.panelExpanded) {
            this.deferredReplyingStatus = this.delegate.getIsSysReplying();
        }
        this.panelExpanded = false;
        this.delegate.setReplyingStatus(false);
    }

    @Override // y4.InterfaceC5939a
    public View getView() {
        return this.delegate.getView();
    }

    public final void h() {
        if (this.panelExpanded) {
            return;
        }
        this.panelExpanded = true;
        this.delegate.setReplyingStatus(this.deferredReplyingStatus);
    }

    @Override // y4.InterfaceC5940b
    public void setInputMoreBtnEnable(boolean enable) {
        this.delegate.setInputMoreBtnEnable(enable);
    }

    @Override // y4.InterfaceC5940b
    public void setInputTxt(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        this.delegate.setInputTxt(text);
    }

    @Override // y4.InterfaceC5940b
    public void setOnBtnPlusClickListener(InterfaceC5940b.a listener) {
        this.delegate.setOnBtnPlusClickListener(listener);
    }

    @Override // y4.InterfaceC5940b
    public void setOnCancelListener(InterfaceC5940b.InterfaceC0556b listener) {
        this.delegate.setOnCancelListener(listener);
    }

    @Override // y4.InterfaceC5940b
    public void setOnFileClickListener(InterfaceC5940b.c listener) {
        this.delegate.setOnFileClickListener(listener);
    }

    @Override // y4.InterfaceC5940b
    public void setOnImageClickListener(InterfaceC5940b.d listener) {
        this.delegate.setOnImageClickListener(listener);
    }

    @Override // y4.InterfaceC5940b
    public void setOnLoadingBubbleListener(InterfaceC5940b.e listener) {
        this.delegate.setOnLoadingBubbleListener(listener);
    }

    @Override // y4.InterfaceC5940b
    public void setOnSendMessageListener(InterfaceC5940b.f listener) {
        this.delegate.setOnSendMessageListener(listener);
    }

    @Override // y4.InterfaceC5940b
    public void setReplyingStatus(boolean isReplying) {
        this.deferredReplyingStatus = isReplying;
        if (this.panelExpanded) {
            this.delegate.setReplyingStatus(isReplying);
        }
    }
}
