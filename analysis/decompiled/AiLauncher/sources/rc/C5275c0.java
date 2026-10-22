package rc;

import io.ktor.sse.ServerSentEventKt;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.scilab.forge.jlatexmath.ParseException;

/* renamed from: rc.c0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5275c0 {

    /* renamed from: f, reason: collision with root package name */
    public static HashMap<String, C5275c0> f39233f = new HashMap<>(300);

    /* renamed from: g, reason: collision with root package name */
    public static HashMap<String, Object> f39234g = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public Object f39235a;

    /* renamed from: b, reason: collision with root package name */
    public Method f39236b;

    /* renamed from: c, reason: collision with root package name */
    public int f39237c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39238d;

    /* renamed from: e, reason: collision with root package name */
    public int f39239e;

    public C5275c0(Object obj, Method method, int i10) {
        this.f39238d = false;
        this.f39235a = obj;
        this.f39236b = method;
        this.f39237c = i10;
    }

    public Object a(d1 d1Var, String[] strArr) throws ParseException {
        try {
            return this.f39236b.invoke(this.f39235a, d1Var, strArr);
        } catch (IllegalAccessException e10) {
            throw new ParseException("Problem with command " + strArr[0] + " at position " + d1Var.r() + ServerSentEventKt.COLON + d1Var.h() + "\n", e10);
        } catch (IllegalArgumentException e11) {
            throw new ParseException("Problem with command " + strArr[0] + " at position " + d1Var.r() + ServerSentEventKt.COLON + d1Var.h() + "\n", e11);
        } catch (InvocationTargetException e12) {
            throw new ParseException("Problem with command " + strArr[0] + " at position " + d1Var.r() + ServerSentEventKt.COLON + d1Var.h() + "\n" + e12.getCause().getMessage());
        }
    }

    public C5275c0(int i10, int i11) {
        this((Object) null, (Method) null, i10);
        this.f39238d = true;
        this.f39239e = i11;
    }

    public C5275c0(int i10) {
        this((Object) null, (Method) null, i10);
    }

    public C5275c0(String str, String str2, float f10) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        this.f39238d = false;
        int i10 = (int) f10;
        Class<?>[] clsArr = {d1.class, String[].class};
        try {
            Object objNewInstance = f39234g.get(str);
            if (objNewInstance == null) {
                objNewInstance = Class.forName(str).getConstructor(null).newInstance(null);
                f39234g.put(str, objNewInstance);
            }
            this.f39235a = objNewInstance;
            this.f39236b = objNewInstance.getClass().getDeclaredMethod(str2, clsArr);
            this.f39237c = i10;
        } catch (Exception e10) {
            System.err.println("Cannot load package " + str + ServerSentEventKt.COLON);
            System.err.println(e10.toString());
        }
    }

    public C5275c0(String str, String str2, float f10, float f11) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        this.f39238d = false;
        int i10 = (int) f10;
        Class<?>[] clsArr = {d1.class, String[].class};
        try {
            Object objNewInstance = f39234g.get(str);
            if (objNewInstance == null) {
                objNewInstance = Class.forName(str).getConstructor(null).newInstance(null);
                f39234g.put(str, objNewInstance);
            }
            this.f39235a = objNewInstance;
            this.f39236b = objNewInstance.getClass().getDeclaredMethod(str2, clsArr);
            this.f39237c = i10;
            this.f39238d = true;
            this.f39239e = (int) f11;
        } catch (Exception e10) {
            System.err.println("Cannot load package " + str + ServerSentEventKt.COLON);
            System.err.println(e10.toString());
        }
    }
}
