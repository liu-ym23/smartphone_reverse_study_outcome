package Z;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7093a;

    /* renamed from: b, reason: collision with root package name */
    public g f7094b;

    /* renamed from: c, reason: collision with root package name */
    public g f7095c;

    public f(Context context) {
        this.f7093a = context;
        if (Build.VERSION.SDK_INT >= 35) {
            this.f7095c = new d(context);
        }
        this.f7094b = b();
    }

    public e a(String str) throws CameraAccessException {
        ArrayList arrayList = new ArrayList();
        g gVar = this.f7094b;
        if (gVar != null) {
            arrayList.add(gVar.a(str));
        }
        g gVar2 = this.f7095c;
        if (gVar2 != null) {
            try {
                arrayList.add(gVar2.a(str));
            } catch (UnsupportedOperationException unused) {
            }
        }
        return new a(arrayList);
    }

    public final g b() throws IllegalStateException {
        String string;
        try {
            ServiceInfo[] serviceInfoArr = this.f7093a.getPackageManager().getPackageInfo(this.f7093a.getPackageName(), 132).services;
            if (serviceInfoArr == null) {
                return null;
            }
            String str = null;
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                Bundle bundle = serviceInfo.metaData;
                if (bundle != null && (string = bundle.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY")) != null) {
                    if (str != null) {
                        throw new IllegalStateException("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                    }
                    str = string;
                }
            }
            if (str == null) {
                return null;
            }
            return c(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final g c(String str) {
        try {
            return (g) Class.forName(str).getConstructor(Context.class).newInstance(this.f7093a);
        } catch (Exception e10) {
            throw new IllegalStateException("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e10);
        }
    }
}
