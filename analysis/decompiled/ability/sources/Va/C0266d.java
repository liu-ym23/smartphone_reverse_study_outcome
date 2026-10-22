package Va;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ForwardingListener;
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.widget.C1999n;
import stepos.support.v7.widget.C2000o;
import stepos.support.v7.widget.C2002q;
import stepos.support.v7.widget.C2005u;
import stepos.support.v7.widget.P;

/* renamed from: Va.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0266d extends ForwardingListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1437a = 0;
    public final /* synthetic */ View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0266d(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.b = actionMenuItemView;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final ShowableListMenu getPopup() {
        C1999n c1999n;
        switch (this.f1437a) {
            case 0:
                AbstractC0267e abstractC0267e = ((ActionMenuItemView) this.b).f;
                if (abstractC0267e == null || (c1999n = ((C2000o) abstractC0267e).f6625a.f6632B) == null) {
                    return null;
                }
                return c1999n.i;
            default:
                stepos.support.v7.widget.r rVar = ((C2002q) this.b).f6626a.f6631A;
                if (rVar == null) {
                    return null;
                }
                return rVar.i;
        }
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final boolean onForwardingStarted() {
        C1999n c1999n;
        switch (this.f1437a) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.b;
                m mVar = actionMenuItemView.d;
                if (mVar != null && mVar.b(actionMenuItemView.f6375a)) {
                    AbstractC0267e abstractC0267e = actionMenuItemView.f;
                    P p = null;
                    if (abstractC0267e != null && (c1999n = ((C2000o) abstractC0267e).f6625a.f6632B) != null) {
                        p = c1999n.i;
                    }
                    if (p != null && p.isShowing()) {
                        return true;
                    }
                }
                return false;
            default:
                ((C2002q) this.b).f6626a.m();
                return true;
        }
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStopped() {
        switch (this.f1437a) {
            case 1:
                C2005u c2005u = ((C2002q) this.b).f6626a;
                if (c2005u.f6633C != null) {
                    return false;
                }
                c2005u.h();
                return true;
            default:
                return super.onForwardingStopped();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0266d(C2002q c2002q, C2002q c2002q2) {
        super(c2002q2);
        this.b = c2002q;
    }
}
