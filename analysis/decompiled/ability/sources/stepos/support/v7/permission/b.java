package stepos.support.v7.permission;

import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import java.util.Locale;
import w0.C2086g;

/* loaded from: classes4.dex */
public final class b implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final C2086g f6371a;
    public final String b;
    public final a c;

    public b(String str, a aVar, C2086g c2086g) {
        this.b = str;
        this.c = aVar;
        this.f6371a = c2086g;
    }

    public final String a() {
        a aVar;
        String str = this.b;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.c) != null && !TextUtils.isEmpty(aVar.b)) {
            return aVar.b;
        }
        PackageManager packageManager = (PackageManager) this.f6371a.f6811a;
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
        a aVar2 = this.c;
        if (aVar2 != null && (aVar = bVar.c) != null) {
            return aVar2.f6370a - aVar.f6370a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return bVar.c != null ? 1 : 0;
    }
}
