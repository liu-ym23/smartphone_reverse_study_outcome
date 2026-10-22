package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import e9.InterfaceC4014c;
import k5.C4814a;
import kotlin.Function2;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011R:\u0010\u0017\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/chat/view/FloatInputView;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "source", "hd", "(Ljava/lang/String;)V", "sd", "Lkotlin/Function1;", "Le9/c;", "", "", "onWaked", "Lp9/l;", "getOnWaked", "()Lp9/l;", "setOnWaked", "(Lp9/l;)V", "Lkotlin/Function0;", "isWait", "Lp9/a;", "()Lp9/a;", "setWait", "(Lp9/a;)V", "registerAsAgentInputView", "Z", "getRegisterAsAgentInputView", "()Z", "setRegisterAsAgentInputView", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatInputView extends BaseInputView {
    private InterfaceC5063a<Boolean> isWait;
    private InterfaceC5074l<? super InterfaceC4014c<? super Boolean>, ? extends Object> onWaked;
    private boolean registerAsAgentInputView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final InterfaceC5074l<InterfaceC4014c<? super Boolean>, Object> getOnWaked() {
        return this.onWaked;
    }

    public final boolean getRegisterAsAgentInputView() {
        return this.registerAsAgentInputView;
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public void hd(String source) {
        InterfaceC5063a<Boolean> interfaceC5063a = this.isWait;
        if (interfaceC5063a != null && interfaceC5063a.invoke().booleanValue() && Z8.F.f0(C1173v.p(C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK), source)) {
            Function2.b(new FloatInputView$wake$1(this, source, null));
        } else {
            sd(source);
        }
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.registerAsAgentInputView) {
            InputViewManager.INSTANCE.N0(this);
        }
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.registerAsAgentInputView) {
            InputViewManager.INSTANCE.b0(this);
        }
    }

    public final void sd(String source) {
        super.hd(source);
    }

    public final void setOnWaked(InterfaceC5074l<? super InterfaceC4014c<? super Boolean>, ? extends Object> interfaceC5074l) {
        this.onWaked = interfaceC5074l;
    }

    public final void setRegisterAsAgentInputView(boolean z10) {
        this.registerAsAgentInputView = z10;
    }

    public final void setWait(InterfaceC5063a<Boolean> interfaceC5063a) {
        this.isWait = interfaceC5063a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatInputView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        setLayoutId(R$layout.layout_input_float);
        c(context, attributeSet, null);
    }

    public /* synthetic */ FloatInputView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
