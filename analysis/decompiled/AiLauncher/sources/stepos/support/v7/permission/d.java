package stepos.support.v7.permission;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class d implements Comparable<d> {

    /* renamed from: a, reason: collision with root package name */
    public final b f40849a;

    /* renamed from: b, reason: collision with root package name */
    public final String f40850b;

    /* renamed from: c, reason: collision with root package name */
    public final a f40851c;

    /* renamed from: d, reason: collision with root package name */
    public final List<c> f40852d = new ArrayList();

    public d(String str, a aVar, b bVar) {
        this.f40850b = str;
        this.f40851c = aVar;
        this.f40849a = bVar;
    }

    public void a(c cVar) {
        this.f40852d.add(cVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        a aVar = this.f40851c;
        if (aVar != null && dVar.f40851c != null) {
            return aVar.b() - dVar.f40851c.b();
        }
        if (aVar != null) {
            return -1;
        }
        return dVar.f40851c != null ? 1 : 0;
    }

    public String c(Context context) {
        a aVar;
        if ("zh_CN".equals(Locale.getDefault().toString()) && (aVar = this.f40851c) != null && !TextUtils.isEmpty(aVar.a(context))) {
            return this.f40851c.a(context);
        }
        String strC = this.f40849a.c(context, this.f40850b);
        return TextUtils.isEmpty(strC) ? this.f40850b : strC;
    }

    public String e() {
        return this.f40850b;
    }

    public List<c> i() {
        return this.f40852d;
    }

    public c j(String str) {
        for (c cVar : this.f40852d) {
            if (cVar.c().equals(str)) {
                return cVar;
            }
        }
        return null;
    }
}
