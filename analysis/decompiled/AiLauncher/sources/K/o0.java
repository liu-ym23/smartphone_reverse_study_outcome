package K;

import android.util.ArrayMap;
import java.util.Map;

/* loaded from: classes.dex */
public class o0 extends E0 {
    public o0(Map<String, Object> map) {
        super(map);
    }

    public static o0 g() {
        return new o0(new ArrayMap());
    }

    public void f(E0 e02) {
        Map<String, Object> map;
        Map<String, Object> map2 = this.f3880a;
        if (map2 == null || (map = e02.f3880a) == null) {
            return;
        }
        map2.putAll(map);
    }

    public void h(String str, Object obj) {
        this.f3880a.put(str, obj);
    }
}
