package b8;

import h8.AbstractC1532o;
import h8.C1531n;
import java.lang.reflect.Method;
import java.util.Comparator;
import kotlin.text.Regex;

/* renamed from: b8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0845f implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2041a;

    public /* synthetic */ C0845f(int i) {
        this.f2041a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2041a) {
            case 0:
                return N9.j.m(((Method) obj).getName(), ((Method) obj2).getName());
            case 1:
                return N9.j.m(((S) ((Z7.n) obj)).getName(), ((S) ((Z7.n) obj2)).getName());
            default:
                Regex regex = AbstractC0830C.f2017a;
                Integer numB = AbstractC1532o.b((C1531n) obj, (C1531n) obj2);
                if (numB != null) {
                    return numB.intValue();
                }
                return 0;
        }
    }
}
