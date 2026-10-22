package k;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0;
import androidx.appcompat.widget.C0200f0;
import androidx.appcompat.widget.C0205i;
import androidx.appcompat.widget.C0207j;
import stepos.support.v7.widget.C0891k;
import stepos.support.v7.widget.C0892l;
import stepos.support.v7.widget.K;

/* renamed from: k.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0648b extends AbstractViewOnTouchListenerC0235x0 {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f13179j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0200f0 f13180k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0648b(C0200f0 c0200f0, int i4) {
        super(c0200f0);
        this.f13179j = i4;
        this.f13180k = c0200f0;
    }

    @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0
    public final InterfaceC0644E b() {
        C0205i c0205i;
        C0891k c0891k;
        int i4 = this.f13179j;
        C0200f0 c0200f0 = this.f13180k;
        switch (i4) {
            case 0:
                AbstractC0649c abstractC0649c = ((ActionMenuItemView) c0200f0).f2696l;
                if (abstractC0649c == null || (c0205i = ((C0207j) abstractC0649c).f3105a.f3145t) == null) {
                    return null;
                }
                return c0205i.a();
            default:
                L3.d dVar = ((stepos.support.v7.view.menu.ActionMenuItemView) c0200f0).f14667l;
                if (dVar == null || (c0891k = ((C0892l) dVar).f15100a.f15111B) == null) {
                    return null;
                }
                return c0891k.f1350j;
        }
    }

    @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0
    public final boolean c() {
        K k4;
        C0891k c0891k;
        int i4 = this.f13179j;
        C0200f0 c0200f0 = this.f13180k;
        switch (i4) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0200f0;
                InterfaceC0660n interfaceC0660n = actionMenuItemView.f2694j;
                if (interfaceC0660n != null && interfaceC0660n.a(actionMenuItemView.f2691g)) {
                    InterfaceC0644E interfaceC0644EB = b();
                    break;
                }
                break;
            default:
                stepos.support.v7.view.menu.ActionMenuItemView actionMenuItemView2 = (stepos.support.v7.view.menu.ActionMenuItemView) c0200f0;
                L3.j jVar = actionMenuItemView2.f14665j;
                if (jVar != null && jVar.d(actionMenuItemView2.f14662g)) {
                    L3.d dVar = ((stepos.support.v7.view.menu.ActionMenuItemView) c0200f0).f14667l;
                    k4 = null;
                    if (dVar != null && (c0891k = ((C0892l) dVar).f15100a.f15111B) != null) {
                        k4 = c0891k.f1350j;
                    }
                    break;
                }
                break;
        }
        return k4 != null && k4.f2846z.isShowing();
    }
}
