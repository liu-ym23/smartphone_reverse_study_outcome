package stepos.support.v7.permission;

import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.text.TextUtils;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements Comparable<c> {

    /* renamed from: a, reason: collision with root package name */
    public final b f12312a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12313b;

    /* renamed from: c, reason: collision with root package name */
    public final a f12314c;

    public c(String str, a aVar, b bVar) {
        this.f12313b = str;
        this.f12314c = aVar;
        this.f12312a = bVar;
    }

    public final String a() throws PackageManager.NameNotFoundException {
        a aVar;
        String str = this.f12313b;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f12314c) != null) {
            String str2 = aVar.f12310b;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        PackageManager packageManager = this.f12312a.f12311a;
        String string = null;
        try {
            PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, TraceIdKeys.MAX_LENGTH);
            if (permissionInfo.labelRes != 0) {
                string = permissionInfo.loadLabel(packageManager).toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return TextUtils.isEmpty(string) ? str : string;
    }

    @Override // java.lang.Comparable
    public final int compareTo(c cVar) {
        a aVar;
        c cVar2 = cVar;
        a aVar2 = this.f12314c;
        if (aVar2 != null && (aVar = cVar2.f12314c) != null) {
            return aVar2.f12309a - aVar.f12309a;
        }
        if (aVar2 != null) {
            return -1;
        }
        return cVar2.f12314c != null ? 1 : 0;
    }
}
