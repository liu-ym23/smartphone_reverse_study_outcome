package stepos.support.v7.permission;

import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import java.util.Locale;
import stepos.support.v7.app.C0872q;

/* loaded from: classes2.dex */
public final class b implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final C0872q f14642a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14643b;

    /* renamed from: c, reason: collision with root package name */
    public final a f14644c;

    public b(String str, a aVar, C0872q c0872q) {
        this.f14643b = str;
        this.f14644c = aVar;
        this.f14642a = c0872q;
    }

    public final String a() {
        a aVar;
        String str = this.f14643b;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f14644c) != null && !TextUtils.isEmpty(aVar.f14641b)) {
            return aVar.f14641b;
        }
        Object obj = this.f14642a.f14583b;
        String string = null;
        try {
            PermissionInfo permissionInfo = ((PackageManager) obj).getPermissionInfo(str, 128);
            if (permissionInfo.labelRes != 0) {
                string = permissionInfo.loadLabel((PackageManager) obj).toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar;
        b bVar = (b) obj;
        a aVar2 = this.f14644c;
        if (aVar2 != null && (aVar = bVar.f14644c) != null) {
            return aVar2.f14640a - aVar.f14640a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return bVar.f14644c != null ? 1 : 0;
    }
}
