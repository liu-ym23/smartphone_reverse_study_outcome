package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ViewportFadeRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "topPx", "bottomPx", "topHoldPx", "bottomHoldPx", "LY8/t;", "e", "(FFFF)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Lcom/stepos/agentframework/chatui/view/I0;", "viewportFade", "Lcom/stepos/agentframework/chatui/view/I0;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewportFadeRecyclerView extends RecyclerView {
    private final com.stepos.agentframework.chatui.view.I0 viewportFade;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewportFadeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final Y8.t c(ViewportFadeRecyclerView viewportFadeRecyclerView, Canvas it) {
        kotlin.jvm.internal.p.i(it, "it");
        super.dispatchDraw(it);
        return Y8.t.f7040a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        this.viewportFade.a(this, canvas, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.U9
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ViewportFadeRecyclerView.c(this.f25997a, (Canvas) obj);
            }
        });
    }

    public final void e(float topPx, float bottomPx, float topHoldPx, float bottomHoldPx) {
        if (this.viewportFade.c(topPx, bottomPx, topHoldPx, bottomHoldPx)) {
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewportFadeRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.viewportFade = new com.stepos.agentframework.chatui.view.I0();
    }

    public /* synthetic */ ViewportFadeRecyclerView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
