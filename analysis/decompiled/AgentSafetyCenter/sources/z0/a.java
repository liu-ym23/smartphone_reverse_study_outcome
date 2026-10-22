package z0;

import android.view.DragEvent;
import android.view.View;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager$modifier$1;
import java.lang.invoke.VarHandle;
import o1.e;
import p.f;
import u1.z1;
import y.a0;
import yb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements View.OnDragListener, b {

    /* renamed from: a, reason: collision with root package name */
    public d f16138a;

    /* renamed from: b, reason: collision with root package name */
    public f f16139b;

    /* renamed from: c, reason: collision with root package name */
    public AndroidDragAndDropManager$modifier$1 f16140c;

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        f fVar = this.f16139b;
        d dVar = this.f16138a;
        sa.c cVar = new sa.c(15, false);
        cVar.f12170f = dragEvent;
        VarHandle.storeStoreFence();
        switch (dragEvent.getAction()) {
            case 1:
                dVar.getClass();
                q qVar = new q();
                e eVar = new e(cVar, dVar, qVar);
                if (eVar.invoke(dVar) == z1.f13977c) {
                    u1.f.y(dVar, eVar);
                }
                boolean z10 = qVar.f16094c;
                fVar.getClass();
                p.a aVar = new p.a(fVar);
                while (aVar.hasNext()) {
                    ((d) aVar.next()).F0();
                }
                break;
            case 2:
                dVar.E0(cVar);
                break;
            case 4:
                dVar.getClass();
                a0 a0Var = new a0(cVar, 1);
                if (a0Var.invoke(dVar) == z1.f13977c) {
                    u1.f.y(dVar, a0Var);
                }
                fVar.clear();
                break;
            case 5:
                dVar.C0();
                break;
            case 6:
                dVar.D0();
                break;
        }
        return false;
    }
}
