package l2;

import android.database.Cursor;
import java.util.Map;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class p implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f36930a;

    public p(Map map) {
        this.f36930a = map;
    }

    public static B.b a(Map map) {
        return new p(map);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.T0(this.f36930a, (Cursor) obj);
    }
}
