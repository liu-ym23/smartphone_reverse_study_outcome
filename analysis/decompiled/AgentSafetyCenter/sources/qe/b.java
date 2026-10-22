package qe;

import a2.i;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public i f10220c;

    /* renamed from: f, reason: collision with root package name */
    public String f10221f;

    /* renamed from: g, reason: collision with root package name */
    public a f10222g;

    public final String a() {
        String str = this.f10221f;
        a aVar = this.f10222g;
        if ("zh_CN".equals(Locale.getDefault().toString()) && aVar != null) {
            String str2 = aVar.f10219b;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        PackageManager packageManager = (PackageManager) this.f10220c.f49f;
        String string = null;
        try {
            PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, 128);
            if (permissionInfo.labelRes != 0) {
                string = permissionInfo.loadLabel(packageManager).toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar;
        b bVar = (b) obj;
        a aVar2 = this.f10222g;
        if (aVar2 != null && (aVar = bVar.f10222g) != null) {
            return aVar2.f10218a - aVar.f10218a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return bVar.f10222g != null ? 1 : 0;
    }
}
