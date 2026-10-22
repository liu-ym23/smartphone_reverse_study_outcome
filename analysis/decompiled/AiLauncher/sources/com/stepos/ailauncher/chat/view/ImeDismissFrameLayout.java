package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ImeDismissFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "Lkotlin/Function1;", "shouldSwallow", "Lp9/l;", "getShouldSwallow", "()Lp9/l;", "setShouldSwallow", "(Lp9/l;)V", "Lkotlin/Function0;", "LY8/t;", "onSwallowed", "Lp9/a;", "getOnSwallowed", "()Lp9/a;", "setOnSwallowed", "(Lp9/a;)V", "swallowing", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImeDismissFrameLayout extends FrameLayout {
    private InterfaceC5063a<Y8.t> onSwallowed;
    private InterfaceC5074l<? super MotionEvent, Boolean> shouldSwallow;
    private boolean swallowing;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImeDismissFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final InterfaceC5063a<Y8.t> getOnSwallowed() {
        return this.onSwallowed;
    }

    public final InterfaceC5074l<MotionEvent, Boolean> getShouldSwallow() {
        return this.shouldSwallow;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            InterfaceC5074l<? super MotionEvent, Boolean> interfaceC5074l = this.shouldSwallow;
            boolean z10 = interfaceC5074l != null && interfaceC5074l.invoke(ev).booleanValue();
            this.swallowing = z10;
            if (z10 && (interfaceC5063a = this.onSwallowed) != null) {
                interfaceC5063a.invoke();
            }
        }
        return this.swallowing || super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (!this.swallowing) {
            return super.onTouchEvent(ev);
        }
        if (ev.getActionMasked() == 1 || ev.getActionMasked() == 3) {
            this.swallowing = false;
        }
        return true;
    }

    public final void setOnSwallowed(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onSwallowed = interfaceC5063a;
    }

    public final void setShouldSwallow(InterfaceC5074l<? super MotionEvent, Boolean> interfaceC5074l) {
        this.shouldSwallow = interfaceC5074l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImeDismissFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ ImeDismissFrameLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
