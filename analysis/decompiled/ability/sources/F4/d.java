package F4;

import C7.f;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f543a;
    public Object l;
    public Object m;
    public UUID n;
    public boolean o;

    /* renamed from: t, reason: collision with root package name */
    public S7.a f548t;
    public S7.a u;
    public final f b = kotlin.a.a(new Ba.a(12));
    public final f c = kotlin.a.a(new Ba.a(13));
    public final f d = kotlin.a.a(new Ba.a(14));
    public final f e = kotlin.a.a(new Ba.a(15));
    public final f f = kotlin.a.a(new Ba.a(16));
    public final f g = kotlin.a.a(new Ba.a(17));
    public final f h = kotlin.a.a(new Ba.a(18));
    public final f i = kotlin.a.a(new Ba.a(19));

    /* renamed from: j, reason: collision with root package name */
    public final f f544j = kotlin.a.a(new Ba.a(20));
    public final f k = kotlin.a.a(new Ba.a(21));
    public int p = -1;

    /* renamed from: q, reason: collision with root package name */
    public int f545q = -1;

    /* renamed from: r, reason: collision with root package name */
    public final LinkedHashMap f546r = new LinkedHashMap();

    /* renamed from: s, reason: collision with root package name */
    public final HashMap f547s = new HashMap();

    public d(Context context) {
        this.f543a = context;
    }

    public static int e(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField.getInt(obj);
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException(str + " not found in " + obj.getClass());
    }

    public static int f(Object obj, String str, String str2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            try {
                Object objInvoke = obj.getClass().getMethod(str, null).invoke(obj, null);
                k.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            } catch (Exception unused) {
                return obj.getClass().getField(str2).getInt(obj);
            }
        } catch (Exception unused2) {
            return -1;
        }
    }

    public final boolean a() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        boolean z10;
        UUID uuid;
        boolean zBooleanValue;
        int iIntValue;
        Object objInvoke;
        f fVar = this.f544j;
        f fVar2 = this.b;
        f fVar3 = this.k;
        Context context = this.f543a;
        if (this.l != null) {
            return true;
        }
        try {
            Object objNewInstance = ((Class) fVar3.getF4884a()).getDeclaredConstructor(null).newInstance(null);
            ((Class) fVar3.getF4884a()).getField("packageName").set(objNewInstance, context.getPackageName());
            ArrayList arrayList = new ArrayList();
            z10 = false;
            try {
                ((Class) fVar2.getF4884a()).getMethod("listModulesAsOriginator", ArrayList.class, (Class) fVar3.getF4884a()).invoke(null, arrayList, objNewInstance);
                Log.d("SimpleWakeupSession", "attachModule: listModulesAsOriginator count=" + arrayList.size());
                if (arrayList.isEmpty()) {
                    Log.e("SimpleWakeupSession", "attachModule: no available modules");
                    return false;
                }
                try {
                    Object obj = arrayList.get(0);
                    k.e(obj, "get(...)");
                    try {
                        objInvoke = obj.getClass().getMethod("getUuid", null).invoke(obj, null);
                    } catch (NoSuchMethodException unused) {
                        Object obj2 = obj.getClass().getField("uuid").get(obj);
                        if (obj2 instanceof UUID) {
                            uuid = (UUID) obj2;
                        }
                    }
                    uuid = objInvoke instanceof UUID ? (UUID) objInvoke : null;
                    this.n = uuid;
                    try {
                        try {
                            Object objInvoke2 = obj.getClass().getMethod("isConcurrentCaptureSupported", null).invoke(obj, null);
                            k.d(objInvoke2, "null cannot be cast to non-null type kotlin.Boolean");
                            zBooleanValue = ((Boolean) objInvoke2).booleanValue();
                        } catch (NoSuchMethodException unused2) {
                            zBooleanValue = obj.getClass().getField("supportsConcurrentCapture").getBoolean(obj);
                        }
                    } catch (Exception unused3) {
                        zBooleanValue = false;
                    }
                    this.o = zBooleanValue;
                    try {
                        Object objInvoke3 = obj.getClass().getMethod("getId", null).invoke(obj, null);
                        k.d(objInvoke3, "null cannot be cast to non-null type kotlin.Int");
                        iIntValue = ((Integer) objInvoke3).intValue();
                    } catch (NoSuchMethodException unused4) {
                        iIntValue = obj.getClass().getField("id").getInt(obj);
                    }
                    this.p = f(obj, "getMaxSoundModels", "maxSoundModels");
                    this.f545q = f(obj, "getMaxKeyPhrases", "maxKeyphrases");
                    int iF = f(obj, "getMaxUsers", "maxUsers");
                    Log.i("SimpleWakeupSession", "DSP caps: concurrent=" + this.o + " maxSoundModels=" + this.p + " maxKeyphrases=" + this.f545q + " maxUsers=" + iF);
                    Object objNewProxyInstance = Proxy.newProxyInstance(context.getClassLoader(), new Class[]{(Class) fVar.getF4884a()}, new a(this, 0));
                    k.e(objNewProxyInstance, "newProxyInstance(...)");
                    this.m = objNewProxyInstance;
                    Object objInvoke4 = ((Class) fVar2.getF4884a()).getMethod("attachModuleAsOriginator", Integer.TYPE, (Class) fVar.getF4884a(), Handler.class, (Class) fVar3.getF4884a()).invoke(null, Integer.valueOf(iIntValue), this.m, null, objNewInstance);
                    this.l = objInvoke4;
                    if (objInvoke4 == null) {
                        Log.e("SimpleWakeupSession", "attachModule: low layer error, module is null");
                        return false;
                    }
                    Log.d("SimpleWakeupSession", "attachModule: success moduleId=" + iIntValue + " vendorUuid=" + this.n);
                    return true;
                } catch (Exception e) {
                    e = e;
                    z10 = false;
                    Log.e("SimpleWakeupSession", "attachModule: exception", e);
                    return z10;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Exception e9) {
            e = e9;
            z10 = false;
        }
    }

    public final Object b(String str, int i, int[] iArr, int i6) {
        f fVar = this.e;
        Class cls = Integer.TYPE;
        try {
            try {
                return ((Class) fVar.getF4884a()).getConstructor(cls, cls, Locale.class, String.class, int[].class).newInstance(Integer.valueOf(i), Integer.valueOf(i6), Locale.forLanguageTag("en-US"), str, iArr);
            } catch (Exception e) {
                Log.e("SimpleWakeupSession", "createKeyphrase: no matching constructor", e);
                return null;
            }
        } catch (NoSuchMethodException unused) {
            return ((Class) fVar.getF4884a()).getConstructor(cls, cls, String.class, String.class, int[].class).newInstance(Integer.valueOf(i), Integer.valueOf(i6), "en-US", str, iArr);
        }
    }

    public final Object c(byte[] bArr, int[] iArr, String str, int i) {
        try {
            Object objB = b(str, i, iArr, iArr.length == 0 ? 1 : 3);
            if (objB == null) {
                return null;
            }
            Object objNewInstance = Array.newInstance((Class<?>) this.e.getF4884a(), 1);
            Array.set(objNewInstance, 0, objB);
            return ((Class) this.f.getF4884a()).getConstructor(UUID.class, UUID.class, byte[].class, objNewInstance.getClass()).newInstance(UUID.randomUUID(), this.n, bArr, objNewInstance);
        } catch (Exception e) {
            Log.e("SimpleWakeupSession", "createKeyphraseSoundModel: exception", e);
            return null;
        }
    }

    public final Class d() {
        return (Class) this.c.getF4884a();
    }

    public final void g(String str) {
        c cVar = (c) this.f546r.remove(str);
        if (cVar == null) {
            return;
        }
        int i = cVar.f542a;
        this.f547s.remove(Integer.valueOf(i));
        try {
            try {
                d().getMethod("stopRecognition", Integer.TYPE).invoke(this.l, Integer.valueOf(i));
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
            h(i);
        } catch (Exception e) {
            Log.e("SimpleWakeupSession", "stopAndUnload wordId=" + str + " exception", e);
        }
    }

    public final int h(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.l;
        if (obj == null) {
            return 0;
        }
        try {
            Object objInvoke = d().getMethod("unloadSoundModel", Integer.TYPE).invoke(obj, Integer.valueOf(i));
            k.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue();
        } catch (Exception e) {
            Log.e("SimpleWakeupSession", "unloadHandle " + i + " exception", e);
            return Integer.MIN_VALUE;
        }
    }
}
