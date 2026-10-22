package B0;

import androidx.room.A;
import androidx.room.G;

/* loaded from: classes.dex */
public final class j extends G {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f149b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, A a4, int i4) {
        super(a4);
        this.f148a = i4;
        this.f149b = obj;
    }

    @Override // androidx.room.G
    public final String createQuery() {
        switch (this.f148a) {
            case 0:
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            case 1:
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            default:
                return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }
}
