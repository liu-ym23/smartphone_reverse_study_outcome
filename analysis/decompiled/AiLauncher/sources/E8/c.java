package E8;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f2417a;

    static {
        Map<String, String> map;
        try {
            Field declaredField = Xb.b.class.getDeclaredField(Const.INTENT_KEY_APIKEY);
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(null);
        } catch (Throwable th) {
            Map<String, String> map2 = Collections.EMPTY_MAP;
            th.printStackTrace();
            map = map2;
        }
        f2417a = map;
    }

    public static int a(String str, int[] iArr) {
        String str2 = f2417a.get(str);
        if (str2 == null) {
            return 0;
        }
        int length = str2.length();
        if (length == 1) {
            iArr[0] = str2.charAt(0);
            return length;
        }
        iArr[0] = str2.charAt(0);
        iArr[1] = str2.charAt(1);
        return length;
    }

    public static boolean b(String str) {
        return f2417a.containsKey(str);
    }
}
