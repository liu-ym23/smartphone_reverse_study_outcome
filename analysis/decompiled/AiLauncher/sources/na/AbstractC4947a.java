package na;

import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue;

/* renamed from: na.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4947a implements Comparable<AbstractC4947a> {
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC4947a other) {
        p.i(other, "other");
        int iCompareTo = b().compareTo(other.b());
        if (iCompareTo == 0 && !c() && other.c()) {
            return 1;
        }
        return iCompareTo;
    }

    public abstract DeprecationLevelValue b();

    public abstract boolean c();
}
