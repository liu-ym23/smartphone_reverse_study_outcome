package z5;

import d7.a0;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ void reportEvent$default(e eVar, String str, String str2, Map map, Map map2, String str3, String str4, int i2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEvent");
        }
        if ((i10 & 8) != 0) {
            map2 = a0.f2944f;
        }
        eVar.h(str, str2, map, map2, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? 200 : i2);
    }

    public static /* synthetic */ void reportLog$default(e eVar, String str, String str2, h hVar, String str3, String str4, String str5, int i2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportLog");
        }
        if ((i10 & 32) != 0) {
            str5 = null;
        }
        eVar.e(str, str2, hVar, str3, str4, str5, (i10 & 64) != 0 ? 200 : i2);
    }
}
