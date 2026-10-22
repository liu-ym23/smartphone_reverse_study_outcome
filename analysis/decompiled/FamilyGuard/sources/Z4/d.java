package Z4;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class d implements Comparable<d> {

    /* renamed from: a, reason: collision with root package name */
    private final b f6665a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6666b;

    /* renamed from: c, reason: collision with root package name */
    private final a f6667c;

    /* renamed from: d, reason: collision with root package name */
    private final List<c> f6668d = new ArrayList();

    public d(String str, a aVar, b bVar) {
        this.f6666b = str;
        this.f6667c = aVar;
        this.f6665a = bVar;
    }

    public void b(c cVar) {
        this.f6668d.add(cVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        a aVar = this.f6667c;
        if (aVar != null && dVar.f6667c != null) {
            return aVar.b() - dVar.f6667c.b();
        }
        if (aVar != null) {
            return -1;
        }
        return dVar.f6667c != null ? 1 : 0;
    }

    public String e(Context context) {
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f6667c) != null && !TextUtils.isEmpty(aVar.a(context))) {
            return this.f6667c.a(context);
        }
        String strC = this.f6665a.c(context, this.f6666b);
        return TextUtils.isEmpty(strC) ? this.f6666b : strC;
    }

    public String g() {
        return this.f6666b;
    }

    public c h(String str) {
        for (c cVar : this.f6668d) {
            if (cVar.e().equals(str)) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> i() {
        return this.f6668d;
    }
}
