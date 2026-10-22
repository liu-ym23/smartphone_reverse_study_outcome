package q0;

import android.view.DragEvent;
import android.view.View;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1;
import c1.w;
import i1.w0;
import i1.w1;
import k.f;
import n0.l;
import o4.d0;
import q7.r;

/* loaded from: classes.dex */
public final class a implements View.OnDragListener, b {

    /* renamed from: a, reason: collision with root package name */
    public final d f8618a;

    /* renamed from: b, reason: collision with root package name */
    public final f f8619b;

    /* renamed from: c, reason: collision with root package name */
    public final AndroidDragAndDropManager$modifier$1 f8620c;

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1] */
    public a() {
        d dVar = new d();
        dVar.f8624v = 0L;
        this.f8618a = dVar;
        this.f8619b = new f(0);
        this.f8620c = new w0() { // from class: androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1
            @Override // i1.w0
            public final l d() {
                return this.f754a.f8618a;
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            @Override // i1.w0
            public final /* bridge */ /* synthetic */ void f(l lVar) {
            }

            public final int hashCode() {
                return this.f754a.f8618a.hashCode();
            }
        };
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        d0 d0Var = new d0(4, dragEvent);
        int action = dragEvent.getAction();
        f fVar = this.f8619b;
        d dVar = this.f8618a;
        switch (action) {
            case 1:
                r rVar = new r();
                w wVar = new w(d0Var, dVar, rVar);
                if (wVar.invoke(dVar) == w1.f4626f) {
                    i1.l.y(dVar, wVar);
                }
                boolean z4 = rVar.f8816f;
                fVar.getClass();
                k.a aVar = new k.a(fVar);
                while (aVar.hasNext()) {
                    ((d) aVar.next()).p0(d0Var);
                }
                break;
            case 2:
                dVar.o0(d0Var);
                break;
            case 4:
                w wVar2 = new w(29, d0Var);
                if (wVar2.invoke(dVar) == w1.f4626f) {
                    i1.l.y(dVar, wVar2);
                }
                fVar.clear();
                break;
            case 5:
                dVar.m0(d0Var);
                break;
            case 6:
                dVar.n0(d0Var);
                break;
        }
        return false;
    }
}
