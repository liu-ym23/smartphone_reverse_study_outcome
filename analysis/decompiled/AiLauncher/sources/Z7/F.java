package Z7;

import com.autonavi.aps.amapapi.config.Const;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class F {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, HashMap<String, byte[]>> f7312a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f7313b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f7314c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public String f7315d = Const.STR_APS_ENCODE;

    /* renamed from: e, reason: collision with root package name */
    public K f7316e = new K();

    public static void c(ArrayList<String> arrayList, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        while (true) {
            if (obj.getClass().isArray()) {
                if (!obj.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
                if (Array.getLength(obj) <= 0) {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                } else {
                    arrayList.add("java.util.List");
                    obj = Array.get(obj, 0);
                }
            } else {
                if (obj instanceof Array) {
                    throw new IllegalArgumentException("can not support Array, please use List");
                }
                if (obj instanceof List) {
                    arrayList.add("java.util.List");
                    List list = (List) obj;
                    if (list.size() <= 0) {
                        arrayList.add("?");
                        return;
                    }
                    obj = list.get(0);
                } else {
                    if (!(obj instanceof Map)) {
                        arrayList.add(obj.getClass().getName());
                        return;
                    }
                    arrayList.add("java.util.Map");
                    Map map = (Map) obj;
                    if (map.size() <= 0) {
                        arrayList.add("?");
                        arrayList.add("?");
                        return;
                    } else {
                        Object next = map.keySet().iterator().next();
                        obj = map.get(next);
                        arrayList.add(next.getClass().getName());
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.f7315d = str;
    }

    public <T> void b(String str, T t10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, UnsupportedEncodingException {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t10 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t10 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        L l10 = new L();
        l10.a(this.f7315d);
        l10.i(t10, 0);
        byte[] bArrE = M.e(l10.f7332a);
        HashMap<String, byte[]> map = new HashMap<>(1);
        ArrayList arrayList = new ArrayList(1);
        c(arrayList, t10);
        map.put(C1129a.a(arrayList), bArrE);
        this.f7314c.remove(str);
        this.f7312a.put(str, map);
    }
}
