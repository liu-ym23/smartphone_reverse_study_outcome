package h3;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n3.InterfaceC4938b;

/* renamed from: h3.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4130f<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f32907a;

    /* renamed from: b, reason: collision with root package name */
    public final c<T> f32908b;

    /* renamed from: h3.f$b */
    public static class b implements c<Context> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends Service> f32909a;

        public final Bundle b(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f32909a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f32909a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // h3.C4130f.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) throws PackageManager.NameNotFoundException {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleB.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleB.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        public b(Class<? extends Service> cls) {
            this.f32909a = cls;
        }
    }

    /* renamed from: h3.f$c */
    public interface c<T> {
        List<String> a(T t10);
    }

    public C4130f(T t10, c<T> cVar) {
        this.f32907a = t10;
        this.f32908b = cVar;
    }

    public static C4130f<Context> b(Context context, Class<? extends Service> cls) {
        return new C4130f<>(context, new b(cls));
    }

    public static InterfaceC4132h c(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName(str);
            if (InterfaceC4132h.class.isAssignableFrom(cls)) {
                return (InterfaceC4132h) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e10) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e10);
        } catch (InstantiationException e11) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e11);
        } catch (NoSuchMethodException e12) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e12);
        } catch (InvocationTargetException e13) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e13);
        }
    }

    public List<InterfaceC4938b<InterfaceC4132h>> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f32908b.a(this.f32907a).iterator();
        while (it.hasNext()) {
            arrayList.add(C4129e.a(it.next()));
        }
        return arrayList;
    }
}
