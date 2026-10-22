package com.stepos.ailauncher.chat.voice.longpress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/r;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "canCancel", "Lkotlin/Function2;", "", "isInsideInput", "LY8/t;", "cancelListening", "<init>", "(Landroid/content/Context;Lp9/a;Lp9/p;Lp9/a;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lp9/a;", "Lp9/p;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor", "ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public final class r extends View {
    private final InterfaceC5063a<Boolean> canCancel;
    private final InterfaceC5063a<Y8.t> cancelListening;
    private final p9.p<Float, Float, Boolean> isInsideInput;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public r(Context context, InterfaceC5063a<Boolean> canCancel, p9.p<? super Float, ? super Float, Boolean> isInsideInput, InterfaceC5063a<Y8.t> cancelListening) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(canCancel, "canCancel");
        kotlin.jvm.internal.p.i(isInsideInput, "isInsideInput");
        kotlin.jvm.internal.p.i(cancelListening, "cancelListening");
        this.canCancel = canCancel;
        this.isInsideInput = isInsideInput;
        this.cancelListening = cancelListening;
        setWillNotDraw(true);
        setFocusable(false);
        setImportantForAccessibility(2);
        setOutlineProvider(null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (event.getActionMasked() != 0 || !this.canCancel.invoke().booleanValue() || this.isInsideInput.invoke(Float.valueOf(event.getX()), Float.valueOf(event.getY())).booleanValue()) {
            return false;
        }
        this.cancelListening.invoke();
        return false;
    }
}
