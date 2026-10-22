package com.stepos.ailauncher.agent.aispace.connect;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/w;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "host", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lkotlin/Function0;", "LY8/t;", "onRename", "onRefresh", "onDisconnect", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/ViewGroup;Landroid/view/View;Lp9/a;Lp9/a;Lp9/a;)Lp9/a;", "view", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;I)I", "", "MENU_CORNER_DP", "F", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2236w {
    public static final C2236w INSTANCE = new C2236w();
    private static final float MENU_CORNER_DP = 16.0f;

    public static final void k(GlassAttachment glassAttachment, ViewGroup viewGroup, FrameLayout frameLayout) {
        glassAttachment.n();
        viewGroup.removeView(frameLayout);
    }

    public static final float l(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return 16.0f;
    }

    public static final void m(GlassAttachment glassAttachment, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        k(glassAttachment, viewGroup, frameLayout);
    }

    public static final void n(View view) {
    }

    public static final void o(InterfaceC5063a interfaceC5063a, GlassAttachment glassAttachment, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        k(glassAttachment, viewGroup, frameLayout);
        interfaceC5063a.invoke();
    }

    public static final void p(InterfaceC5063a interfaceC5063a, GlassAttachment glassAttachment, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        k(glassAttachment, viewGroup, frameLayout);
        interfaceC5063a.invoke();
    }

    public static final void q(InterfaceC5063a interfaceC5063a, GlassAttachment glassAttachment, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        k(glassAttachment, viewGroup, frameLayout);
        interfaceC5063a.invoke();
    }

    public static final void r(View view, ViewGroup viewGroup, Y4.F f10) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        viewGroup.getGlobalVisibleRect(rect2);
        LinearLayout menuCard = f10.menuCard;
        kotlin.jvm.internal.p.h(menuCard, "menuCard");
        int i10 = rect.right - rect2.left;
        int i11 = rect.bottom - rect2.top;
        menuCard.setTranslationX(i10 - menuCard.getWidth());
        menuCard.setTranslationY(C5685n.e(C5685n.i(i11 + r3.i(viewGroup, 6), (viewGroup.getHeight() - menuCard.getHeight()) - r1), INSTANCE.i(viewGroup, 8)));
        menuCard.setVisibility(0);
    }

    public static final Y8.t s(GlassAttachment glassAttachment, ViewGroup viewGroup, FrameLayout frameLayout) {
        k(glassAttachment, viewGroup, frameLayout);
        return Y8.t.f7040a;
    }

    public final int i(View view, int value) {
        return (int) (value * view.getResources().getDisplayMetrics().density);
    }

    public final InterfaceC5063a<Y8.t> j(final ViewGroup host, final View anchor, final InterfaceC5063a<Y8.t> onRename, final InterfaceC5063a<Y8.t> onRefresh, final InterfaceC5063a<Y8.t> onDisconnect) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(onRename, "onRename");
        kotlin.jvm.internal.p.i(onRefresh, "onRefresh");
        kotlin.jvm.internal.p.i(onDisconnect, "onDisconnect");
        final Y4.F fC = Y4.F.c(LayoutInflater.from(host.getContext()), host, false);
        kotlin.jvm.internal.p.h(fC, "inflate(...)");
        final FrameLayout frameLayoutB = fC.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        LinearLayout menuCard = fC.menuCard;
        kotlin.jvm.internal.p.h(menuCard, "menuCard");
        final GlassAttachment glassAttachmentT = new GlassAttachment(menuCard, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(C2236w.l((View) obj));
            }
        }, null, null, null, 56, null).t();
        frameLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2236w.m(glassAttachmentT, host, frameLayoutB, view);
            }
        });
        fC.menuCard.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2236w.n(view);
            }
        });
        fC.menuItemRename.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2236w.o(onRename, glassAttachmentT, host, frameLayoutB, view);
            }
        });
        fC.menuItemRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2236w.p(onRefresh, glassAttachmentT, host, frameLayoutB, view);
            }
        });
        fC.menuItemDisconnect.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2236w.q(onDisconnect, glassAttachmentT, host, frameLayoutB, view);
            }
        });
        host.addView(frameLayoutB);
        fC.menuCard.setVisibility(4);
        fC.menuCard.post(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.u
            @Override // java.lang.Runnable
            public final void run() {
                C2236w.r(anchor, host, fC);
            }
        });
        return new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C2236w.s(glassAttachmentT, host, frameLayoutB);
            }
        };
    }
}
