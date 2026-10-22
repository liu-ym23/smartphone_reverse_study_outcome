package i9;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5848c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ PackageManager f5849f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f5848c;
        PackageManager packageManager = this.f5849f;
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        switch (i) {
            case 0:
                return Boolean.valueOf(packageManager.getLaunchIntentForPackage(applicationInfo.packageName) != null);
            default:
                String string = applicationInfo.loadLabel(packageManager).toString();
                if (hc.h.g0(string)) {
                    string = applicationInfo.packageName;
                }
                String str = applicationInfo.packageName;
                str.getClass();
                string.getClass();
                c cVar = new c();
                cVar.f5844a = str;
                cVar.f5845b = string;
                VarHandle.storeStoreFence();
                return cVar;
        }
    }
}
