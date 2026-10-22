package X;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.reflect.ReflectionCache;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class r implements q, G1.p, m3.h {

    /* renamed from: c, reason: collision with root package name */
    public static HashMap f2075c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2076a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2077b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i4) {
        this();
        this.f2076a = 3;
    }

    public static Class e(String str) throws ClassNotFoundException {
        U2.a aVar = (U2.a) f2075c.get(str);
        if (aVar != null) {
            return aVar.f1911a;
        }
        Class<?> cls = Class.forName(str);
        f2075c.put(str, new U2.a(cls));
        return cls;
    }

    public static Method f(Class cls, Class... clsArr) throws NoSuchMethodException, SecurityException {
        if (((U2.a) f2075c.get(cls.getName())) == null) {
            try {
                e(cls.getName());
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            }
        }
        U2.a aVar = (U2.a) f2075c.get(cls.getName());
        if (aVar == null) {
            return null;
        }
        String string = "get";
        for (Class cls2 : clsArr) {
            StringBuilder sbS = B0.g.s(string);
            sbS.append(cls2.toString());
            string = sbS.toString();
        }
        HashMap map = aVar.f1912b;
        Method method = (Method) map.get(string);
        if (method != null) {
            return method;
        }
        Method method2 = cls.getMethod("get", clsArr);
        map.put(string, method2);
        return method2;
    }

    public static int g(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }

    @Override // m3.h
    public final void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(g(level), this.f2077b, str);
        }
    }

    @Override // X.q
    public final Object b() {
        return this;
    }

    @Override // X.q
    public final boolean c(CharSequence charSequence, int i4, int i5, B b4) {
        if (!TextUtils.equals(charSequence.subSequence(i4, i5), this.f2077b)) {
            return true;
        }
        b4.f2036c = (b4.f2036c & 3) | 4;
        return false;
    }

    @Override // m3.h
    public final void d(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int iG = g(level);
            StringBuilder sbV = B0.g.v(str, "\n");
            sbV.append(Log.getStackTraceString(th));
            Log.println(iG, this.f2077b, sbV.toString());
        }
    }

    @Override // G1.p
    public final Object i() {
        int i4 = this.f2076a;
        String str = this.f2077b;
        switch (i4) {
            case 1:
                throw new F1.q(str, 5);
            default:
                throw new F1.q(str, 5);
        }
    }

    public final String toString() {
        switch (this.f2076a) {
            case 4:
                return B0.g.q(new StringBuilder("<"), this.f2077b, Typography.greater);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ r(String str, int i4) {
        this.f2076a = i4;
        this.f2077b = str;
    }

    public r() {
        this.f2076a = 3;
        this.f2077b = ReflectionCache.TAG;
        f2075c = new HashMap();
    }
}
