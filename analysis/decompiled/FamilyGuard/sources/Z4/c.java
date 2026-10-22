package Z4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class c implements Comparable<c> {

    /* renamed from: a, reason: collision with root package name */
    private final b f6662a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6663b;

    /* renamed from: c, reason: collision with root package name */
    private final a f6664c;

    public c(String str, a aVar, b bVar) {
        this.f6663b = str;
        this.f6664c = aVar;
        this.f6662a = bVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        a aVar = this.f6664c;
        if (aVar != null && cVar.f6664c != null) {
            return aVar.b() - cVar.f6664c.b();
        }
        if (aVar != null) {
            return -1;
        }
        return cVar.f6664c != null ? 1 : 0;
    }

    public String d(Context context) throws PackageManager.NameNotFoundException {
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f6664c) != null && !TextUtils.isEmpty(aVar.a(context))) {
            return this.f6664c.a(context);
        }
        String strD = this.f6662a.d(this.f6663b);
        return TextUtils.isEmpty(strD) ? this.f6663b : strD;
    }

    public String e() {
        return this.f6663b;
    }
}
