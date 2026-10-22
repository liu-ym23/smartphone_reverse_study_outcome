package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import e9.InterfaceC4014c;
import k5.C4814a;
import kotlin.Function2;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0015\u0010\u000eR:\u0010\u0019\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\u00128TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0014¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/view/MainInputView;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "source", "LY8/t;", "sd", "(Ljava/lang/String;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "U7", "()Z", "hd", "Lkotlin/Function1;", "Le9/c;", "", "onWaked", "Lp9/l;", "getOnWaked", "()Lp9/l;", "setOnWaked", "(Lp9/l;)V", "Lkotlin/Function0;", "isWait", "Lp9/a;", "()Lp9/a;", "setWait", "(Lp9/a;)V", "getDeliverBeforeKeyboardHide", "deliverBeforeKeyboardHide", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainInputView extends BaseInputView {
    private InterfaceC5063a<Boolean> isWait;
    private InterfaceC5074l<? super InterfaceC4014c<? super Boolean>, ? extends Object> onWaked;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sd(String source) {
        super.hd(source);
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public boolean U7() {
        for (Object parent = getParent(); parent instanceof View; parent = ((View) parent).getParent()) {
            if (parent instanceof C3016y) {
                return true;
            }
        }
        return false;
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public boolean getDeliverBeforeKeyboardHide() {
        return true;
    }

    public final InterfaceC5074l<InterfaceC4014c<? super Boolean>, Object> getOnWaked() {
        return this.onWaked;
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public void hd(String source) {
        InterfaceC5063a<Boolean> interfaceC5063a = this.isWait;
        if (interfaceC5063a != null && interfaceC5063a.invoke().booleanValue() && Z8.F.f0(C1173v.p(C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK, "ai_key_click", C4814a.AI_KEY_CLICK2), source)) {
            Function2.b(new MainInputView$wake$1(this, source, null));
        } else {
            sd(source);
        }
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        InputViewManager.INSTANCE.N0(this);
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InputViewManager.INSTANCE.a0();
    }

    public final void setOnWaked(InterfaceC5074l<? super InterfaceC4014c<? super Boolean>, ? extends Object> interfaceC5074l) {
        this.onWaked = interfaceC5074l;
    }

    public final void setWait(InterfaceC5063a<Boolean> interfaceC5063a) {
        this.isWait = interfaceC5063a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ MainInputView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
