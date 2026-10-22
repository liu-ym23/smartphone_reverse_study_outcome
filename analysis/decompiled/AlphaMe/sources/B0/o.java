package B0;

import androidx.room.A;
import androidx.room.G;

/* loaded from: classes.dex */
public final class o extends G {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f159a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(A a4, int i4) {
        super(a4);
        this.f159a = i4;
    }

    @Override // androidx.room.G
    public final String createQuery() {
        switch (this.f159a) {
            case 0:
                return "DELETE from WorkProgress where work_spec_id=?";
            default:
                return "DELETE FROM WorkProgress";
        }
    }
}
