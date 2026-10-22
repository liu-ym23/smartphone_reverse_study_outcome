package K;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class E0 {

    /* renamed from: b, reason: collision with root package name */
    public static final E0 f3879b = new E0(new ArrayMap());

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f3880a;

    public E0(Map<String, Object> map) {
        this.f3880a = map;
    }

    public static E0 a(Pair<String, Object> pair) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put((String) pair.first, pair.second);
        return new E0(arrayMap);
    }

    public static E0 b() {
        return f3879b;
    }

    public static E0 c(E0 e02) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : e02.e()) {
            arrayMap.put(str, e02.d(str));
        }
        return new E0(arrayMap);
    }

    public Object d(String str) {
        return this.f3880a.get(str);
    }

    public Set<String> e() {
        return this.f3880a.keySet();
    }

    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
