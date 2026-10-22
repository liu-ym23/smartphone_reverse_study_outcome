package m4;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Map;

/* loaded from: classes.dex */
public final class i0 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6226a;

    public /* synthetic */ i0(int i2) {
        this.f6226a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6226a) {
            case 0:
                return ib.k.q(Long.valueOf(((a6.e) obj2).f305a), Long.valueOf(((a6.e) obj).f305a));
            case 1:
                return ib.k.q(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
            case 2:
                return ib.k.q((String) ((Map.Entry) obj).getKey(), (String) ((Map.Entry) obj2).getKey());
            case 3:
                return ib.k.q(((pb.g) obj).f8592a, ((pb.g) obj2).f8592a);
            case 4:
                return ib.k.q(((Method) obj).getName(), ((Method) obj2).getName());
            case 5:
                return ib.k.q(((z7.u0) ((w7.m) obj)).getName(), ((z7.u0) ((w7.m) obj2)).getName());
            default:
                Integer numB = f8.o.b((f8.n) obj, (f8.n) obj2);
                if (numB == null) {
                    return 0;
                }
                return numB.intValue();
        }
    }
}
