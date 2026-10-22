package y6;

import com.stepos.base.inference.data.BackendType;
import java.util.Comparator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t8, T t10) {
        return ob.b.a(Integer.valueOf(((BackendType) t8).f6259a), Integer.valueOf(((BackendType) t10).f6259a));
    }
}
