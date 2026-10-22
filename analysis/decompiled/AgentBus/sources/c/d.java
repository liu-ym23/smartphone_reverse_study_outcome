package c;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.p0;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1671f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1672g;

    public /* synthetic */ d(int i2, Object obj) {
        this.f1671f = i2;
        this.f1672g = obj;
    }

    @Override // androidx.lifecycle.t
    public final void b(v vVar, androidx.lifecycle.p pVar) {
        Window window;
        View viewPeekDecorView;
        int i2 = this.f1671f;
        Object obj = this.f1672g;
        switch (i2) {
            case 0:
                i iVar = (i) obj;
                if (pVar == androidx.lifecycle.p.ON_STOP && (window = iVar.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                i iVar2 = (i) obj;
                if (pVar == androidx.lifecycle.p.ON_DESTROY) {
                    iVar2.f1685g.f3325b = null;
                    if (!iVar2.isChangingConfigurations()) {
                        LinkedHashMap linkedHashMap = iVar2.c().f1030a;
                        Iterator it = linkedHashMap.values().iterator();
                        while (it.hasNext()) {
                            ((p0) it.next()).a();
                        }
                        linkedHashMap.clear();
                    }
                    g gVar = iVar2.f1689k;
                    i iVar3 = gVar.f1678i;
                    iVar3.getWindow().getDecorView().removeCallbacks(gVar);
                    iVar3.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(gVar);
                    break;
                }
                break;
            default:
                k3.a aVar = (k3.a) obj;
                if (pVar != androidx.lifecycle.p.ON_START) {
                    if (pVar == androidx.lifecycle.p.ON_STOP) {
                        aVar.f5588h = false;
                        break;
                    }
                } else {
                    aVar.f5588h = true;
                    break;
                }
                break;
        }
    }
}
