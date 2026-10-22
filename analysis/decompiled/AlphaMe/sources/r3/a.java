package r3;

import B0.g;
import org.tensorflow.TensorFlow;

/* loaded from: classes2.dex */
public enum a {
    FLOAT(1),
    /* JADX INFO: Fake field, exist only in values array */
    DOUBLE(2),
    /* JADX INFO: Fake field, exist only in values array */
    INT32(3),
    /* JADX INFO: Fake field, exist only in values array */
    UINT8(4),
    /* JADX INFO: Fake field, exist only in values array */
    STRING(7),
    /* JADX INFO: Fake field, exist only in values array */
    INT64(9),
    /* JADX INFO: Fake field, exist only in values array */
    BOOL(10);


    /* renamed from: a, reason: collision with root package name */
    public final int f14087a;

    a(int i4) {
        this.f14087a = i4;
    }

    public static a a(int i4) {
        for (a aVar : values()) {
            if (aVar.f14087a == i4) {
                return aVar;
            }
        }
        StringBuilder sbT = g.t("DataType ", i4, " is not recognized in Java (version ");
        sbT.append(TensorFlow.version());
        sbT.append(")");
        throw new IllegalArgumentException(sbT.toString());
    }
}
