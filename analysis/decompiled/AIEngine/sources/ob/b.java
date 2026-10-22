package ob;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b {
    public static <T extends Comparable<?>> int a(T t8, T t10) {
        if (t8 == t10) {
            return 0;
        }
        if (t8 == null) {
            return -1;
        }
        if (t10 == null) {
            return 1;
        }
        return t8.compareTo(t10);
    }
}
