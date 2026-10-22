package com.stepos.agentframework.floatcard.ext;

import E4.n;
import Y8.t;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.agentframework.floatcard.view.p;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/floatcard/ext/c;", "", "Landroid/widget/PopupWindow;", "popup", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "container", "Lcom/stepos/agentframework/floatcard/view/p;", "cardView", "<init>", "(Landroid/widget/PopupWindow;Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;Lcom/stepos/agentframework/floatcard/view/p;)V", "", "", "LE4/n;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/Map;", "Lkotlin/Function0;", "LY8/t;", "onEnd", "c", "(Lp9/a;)V", "f", "Landroid/widget/PopupWindow;", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "Lcom/stepos/agentframework/floatcard/view/p;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c {
    private final p cardView;
    private final FloatCardContainerView container;
    private final PopupWindow popup;

    public c(PopupWindow popup, FloatCardContainerView container, p cardView) {
        kotlin.jvm.internal.p.i(popup, "popup");
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(cardView, "cardView");
        this.popup = popup;
        this.container = container;
        this.cardView = cardView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(c cVar, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        cVar.c(interfaceC5063a);
    }

    public static final t e(c cVar, InterfaceC5063a interfaceC5063a) {
        try {
            Result.Companion companion = Result.INSTANCE;
            cVar.popup.dismiss();
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return t.f7040a;
    }

    public static final void g(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public final void c(final InterfaceC5063a<t> onEnd) {
        FloatCardContainerView.g(this.container, null, new InterfaceC5063a() { // from class: com.stepos.agentframework.floatcard.ext.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return c.e(this.f23244a, onEnd);
            }
        }, 1, null);
    }

    public final void f(final InterfaceC5063a<t> onEnd) {
        kotlin.jvm.internal.p.i(onEnd, "onEnd");
        this.popup.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.stepos.agentframework.floatcard.ext.b
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                c.g(onEnd);
            }
        });
    }

    public final Map<String, n> h() {
        return this.cardView.T0();
    }
}
