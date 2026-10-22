package com.stepos.ailauncher.task.chat;

import Y8.t;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.ActionView;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.task.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/task/chat/TaskInputView;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/Function1;", "", "LY8/t;", "listener", "setOnTextSentListener", "(Lp9/l;)V", "onAttachedToWindow", "()V", "message", "f", "(Ljava/lang/String;)V", "onDetachedFromWindow", "res", "setMainInputBg", "(I)V", "textSentListener", "Lp9/l;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInputView extends BaseInputView {
    private InterfaceC5074l<? super String, t> textSentListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, y4.InterfaceC5940b
    public void f(String message) {
        InterfaceC5074l<? super String, t> interfaceC5074l;
        super.f(message);
        if (message == null || (interfaceC5074l = this.textSentListener) == null) {
            return;
        }
        interfaceC5074l.invoke(message);
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        inputViewManager.P0(this);
        inputViewManager.L(this);
        ActionView actionView = getActionView();
        if (actionView != null) {
            actionView.setVisibility(8);
        }
        setCameraClickListener(null);
        setFileClickListener(null);
        setImageClickListener(null);
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InputViewManager.INSTANCE.V0(this);
    }

    public final void setMainInputBg(int res) {
        ViewGroup mainInput = getMainInput();
        if (mainInput != null) {
            mainInput.setBackgroundResource(res);
        }
    }

    public final void setOnTextSentListener(InterfaceC5074l<? super String, t> listener) {
        p.i(listener, "listener");
        this.textSentListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInputView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        p.i(context, "context");
        setLayoutId(R$layout.task_layout_input);
        setEnableActionView(false);
        c(context, attributeSet, null);
    }

    public /* synthetic */ TaskInputView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
