package r2;

import android.os.Parcelable;
import android.util.SparseArray;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10385c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q f10386f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(q qVar, int i) {
        super(0);
        this.f10385c = i;
        this.f10386f = qVar;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f10385c) {
            case 0:
                this.f10386f.getLayoutNode().A();
                break;
            case 1:
                q qVar = this.f10386f;
                if (qVar.i && qVar.isAttachedToWindow() && qVar.getView().getParent() == qVar) {
                    qVar.getSnapshotObserver().a(qVar, c.f10370f, qVar.getUpdate());
                }
                break;
            case 2:
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                this.f10386f.D.saveHierarchyState(sparseArray);
                break;
            case 3:
                q qVar2 = this.f10386f;
                qVar2.getReleaseBlock().invoke(qVar2.D);
                q.g(qVar2);
                break;
            case 4:
                q qVar3 = this.f10386f;
                qVar3.getResetBlock().invoke(qVar3.D);
                break;
            default:
                q qVar4 = this.f10386f;
                qVar4.getUpdateBlock().invoke(qVar4.D);
                break;
        }
        return v.f6774a;
    }
}
