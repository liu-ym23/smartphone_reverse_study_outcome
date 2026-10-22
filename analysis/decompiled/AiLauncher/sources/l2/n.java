package l2;

import android.database.Cursor;
import java.util.List;
import l2.B;

/* loaded from: classes2.dex */
public final /* synthetic */ class n implements B.b {

    /* renamed from: a, reason: collision with root package name */
    public final B f36926a;

    /* renamed from: b, reason: collision with root package name */
    public final List f36927b;

    /* renamed from: c, reason: collision with root package name */
    public final e2.m f36928c;

    public n(B b10, List list, e2.m mVar) {
        this.f36926a = b10;
        this.f36927b = list;
        this.f36928c = mVar;
    }

    public static B.b a(B b10, List list, e2.m mVar) {
        return new n(b10, list, mVar);
    }

    @Override // l2.B.b
    public Object apply(Object obj) {
        return B.R0(this.f36926a, this.f36927b, this.f36928c, (Cursor) obj);
    }
}
