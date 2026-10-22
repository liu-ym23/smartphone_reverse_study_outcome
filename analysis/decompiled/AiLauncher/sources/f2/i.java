package f2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class i implements InterfaceC4049d {

    /* renamed from: a, reason: collision with root package name */
    public final a f32544a;

    /* renamed from: b, reason: collision with root package name */
    public final g f32545b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, k> f32546c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f32547a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f32548b = null;

        public a(Context context) {
            this.f32547a = context;
        }

        public static Bundle d(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) l.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        public final Map<String, String> a(Context context) throws PackageManager.NameNotFoundException {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(Const.STR_MART_COMMA, -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        public InterfaceC4048c b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (InterfaceC4048c) Class.forName(str2).asSubclass(InterfaceC4048c.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e10) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e10);
                return null;
            } catch (IllegalAccessException e11) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e11);
                return null;
            } catch (InstantiationException e12) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e12);
                return null;
            } catch (NoSuchMethodException e13) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e13);
                return null;
            } catch (InvocationTargetException e14) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e14);
                return null;
            }
        }

        public final Map<String, String> c() {
            if (this.f32548b == null) {
                this.f32548b = a(this.f32547a);
            }
            return this.f32548b;
        }
    }

    public i(Context context, g gVar) {
        this(new a(context), gVar);
    }

    @Override // f2.InterfaceC4049d
    public synchronized k get(String str) {
        if (this.f32546c.containsKey(str)) {
            return this.f32546c.get(str);
        }
        InterfaceC4048c interfaceC4048cB = this.f32544a.b(str);
        if (interfaceC4048cB == null) {
            return null;
        }
        k kVarCreate = interfaceC4048cB.create(this.f32545b.a(str));
        this.f32546c.put(str, kVarCreate);
        return kVarCreate;
    }

    public i(a aVar, g gVar) {
        this.f32546c = new HashMap();
        this.f32544a = aVar;
        this.f32545b = gVar;
    }
}
