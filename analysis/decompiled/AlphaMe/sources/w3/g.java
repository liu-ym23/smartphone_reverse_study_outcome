package w3;

/* loaded from: classes2.dex */
public final class g extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final Object f15867a;

    public g(Object obj) {
        String strConcat;
        StringBuilder sb = new StringBuilder("OnError while emitting onNext value: ");
        if (obj == null) {
            strConcat = "null";
        } else if (f.f15866a.contains(obj.getClass())) {
            strConcat = obj.toString();
        } else if (obj instanceof String) {
            strConcat = (String) obj;
        } else if (obj instanceof Enum) {
            strConcat = ((Enum) obj).name();
        } else {
            E3.h.f420f.b().getClass();
            strConcat = obj.getClass().getName().concat(".class");
        }
        sb.append(strConcat);
        super(sb.toString());
        this.f15867a = obj;
    }
}
