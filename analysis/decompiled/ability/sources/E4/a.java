package E4;

import C7.r;
import H4.o;
import M0.i;
import android.content.Context;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {
    public static volatile DexClassLoader c;

    /* renamed from: a, reason: collision with root package name */
    public static final a f472a = new a();
    public static final HashMap b = new HashMap();
    public static final List d = o.N("/system/framework/com.qualcomm.qti.sar.jar", "/system_ext/framework/com.qualcomm.qti.sar.jar", "/vendor/framework/com.qualcomm.qti.sar.jar", "/system/framework/listen.jar", "/vendor/framework/listen.jar", "/system/framework/com.qualcomm.listen.jar");

    public static Class b(String str) {
        HashMap map = b;
        Class cls = (Class) map.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            map.put(str, cls2);
            return cls2;
        } catch (Throwable th) {
            kotlin.b.a(th);
            DexClassLoader dexClassLoader = c;
            if (dexClassLoader != null) {
                try {
                    Class<?> cls3 = Class.forName(str, false, dexClassLoader);
                    b.put(str, cls3);
                    return cls3;
                } catch (Throwable th2) {
                    kotlin.b.a(th2);
                    Class<?> cls4 = Class.forName(str, false, ClassLoader.getSystemClassLoader());
                    b.put(str, cls4);
                    return cls4;
                }
            }
            try {
                Class<?> cls42 = Class.forName(str, false, ClassLoader.getSystemClassLoader());
                b.put(str, cls42);
                return cls42;
            } catch (Throwable th3) {
                kotlin.b.a(th3);
                for (String str2 : d) {
                    if (new File(str2).exists()) {
                        try {
                            Class<?> cls5 = Class.forName(str, false, new PathClassLoader(str2, ClassLoader.getSystemClassLoader()));
                            b.put(str, cls5);
                            return cls5;
                        } catch (Throwable th4) {
                            kotlin.b.a(th4);
                        }
                    }
                }
                try {
                    Log.e("ListenModelTrainer", "loadClass failed: " + str + ", hasDexLoader=" + (c != null));
                    return null;
                } catch (Throwable th5) {
                    kotlin.b.a(th5);
                    return null;
                }
            }
        }
    }

    public static Class c(ClassLoader classLoader, String str) {
        HashMap map = b;
        Class cls = (Class) map.get(str);
        if (cls != null) {
            return cls;
        }
        if (classLoader != null) {
            try {
                Class<?> cls2 = Class.forName(str, false, classLoader);
                map.put(str, cls2);
                return cls2;
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
        }
        return b(str);
    }

    public final void a(Context context) {
        Object objA;
        Object objA2;
        InputStream inputStreamOpen;
        if (c != null) {
            return;
        }
        synchronized (this) {
            try {
                if (c != null) {
                    return;
                }
                File file = new File(context.getCacheDir(), "listen.jar");
                try {
                    inputStreamOpen = context.getAssets().open("listen.jar");
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                try {
                    inputStreamOpen.read();
                    inputStreamOpen.close();
                    objA = Boolean.TRUE;
                    Throwable thA = Result.a(objA);
                    if (thA != null) {
                        try {
                            Log.e("ListenModelTrainer", "open assets/listen.jar failed", thA);
                        } catch (Throwable th2) {
                            kotlin.b.a(th2);
                        }
                    }
                    Boolean bool = Boolean.FALSE;
                    if (objA instanceof Result.Failure) {
                        objA = bool;
                    }
                    if (((Boolean) objA).booleanValue()) {
                        try {
                            if (!file.exists() || file.canWrite()) {
                                if (file.exists()) {
                                    file.delete();
                                }
                                inputStreamOpen = context.getAssets().open("listen.jar");
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    try {
                                        k.c(inputStreamOpen);
                                        i.s(inputStreamOpen, fileOutputStream);
                                        fileOutputStream.close();
                                        inputStreamOpen.close();
                                        file.setReadOnly();
                                    } finally {
                                    }
                                } finally {
                                    try {
                                        throw th;
                                    } finally {
                                    }
                                }
                            }
                            File file2 = new File(context.getCacheDir(), "dex_opt");
                            file2.mkdirs();
                            c = new DexClassLoader(file.getAbsolutePath(), file2.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
                            objA2 = r.f317a;
                        } catch (Throwable th3) {
                            objA2 = kotlin.b.a(th3);
                        }
                        Throwable thA2 = Result.a(objA2);
                        if (thA2 != null) {
                            try {
                                Log.e("ListenModelTrainer", "init listen model loader failed: " + file.getAbsolutePath(), thA2);
                            } catch (Throwable th4) {
                                kotlin.b.a(th4);
                            }
                        }
                    }
                } finally {
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }
}
