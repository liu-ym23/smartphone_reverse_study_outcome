package m5;

import d7.a0;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class o {
    public static /* synthetic */ void counter$default(p pVar, String str, Map map, long j2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: counter");
        }
        if ((i2 & 2) != 0) {
            map = a0.f2944f;
        }
        if ((i2 & 4) != 0) {
            j2 = 1;
        }
        ((i5.l) pVar).v(str, map, j2);
    }

    public static /* synthetic */ void gauge$default(p pVar, String str, Map map, long j2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gauge");
        }
        if ((i2 & 2) != 0) {
            map = a0.f2944f;
        }
        ((i5.l) pVar).y(str, map, j2);
    }

    public static /* synthetic */ void histogram$default(p pVar, String str, Map map, long j2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: histogram");
        }
        if ((i2 & 2) != 0) {
            map = a0.f2944f;
        }
        ((i5.l) pVar).D(str, map, j2);
    }
}
