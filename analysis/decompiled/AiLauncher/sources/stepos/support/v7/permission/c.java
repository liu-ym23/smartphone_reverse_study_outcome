package stepos.support.v7.permission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes5.dex */
public class c implements Comparable<c> {

    /* renamed from: a, reason: collision with root package name */
    public final b f40846a;

    /* renamed from: b, reason: collision with root package name */
    public final String f40847b;

    /* renamed from: c, reason: collision with root package name */
    public final a f40848c;

    public c(String str, a aVar, b bVar) {
        this.f40847b = str;
        this.f40848c = aVar;
        this.f40846a = bVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        a aVar = this.f40848c;
        if (aVar != null && cVar.f40848c != null) {
            return aVar.b() - cVar.f40848c.b();
        }
        if (aVar != null) {
            return -1;
        }
        return cVar.f40848c != null ? 1 : 0;
    }

    public String b(Context context) throws PackageManager.NameNotFoundException {
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f40848c) != null && !TextUtils.isEmpty(aVar.a(context))) {
            return this.f40848c.a(context);
        }
        String strD = this.f40846a.d(this.f40847b);
        return TextUtils.isEmpty(strD) ? this.f40847b : strD;
    }

    public String c() {
        return this.f40847b;
    }
}
