package com.baidu.a;

import android.content.Context;
import com.baidu.a.a;
import com.baidu.a.f;
import com.baidu.a.g;
import java.util.Map;

/* loaded from: classes.dex */
public class i implements g.a {

    /* renamed from: a, reason: collision with root package name */
    private final f f4701a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4702b;

    /* renamed from: c, reason: collision with root package name */
    private final a.EnumC0003a f4703c;

    /* renamed from: d, reason: collision with root package name */
    private final g f4704d;

    public i(Context context) {
        a aVarA = a.a(context);
        this.f4702b = aVarA;
        this.f4701a = aVarA.a();
        this.f4703c = aVarA.c();
        this.f4704d = aVarA.d();
    }

    @Override // com.baidu.a.g.a
    public void a(int i4, g.d dVar, Map<String, g.e> map, String str) {
        if (i4 != -1) {
            if (i4 != 0) {
                j.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i4));
            } else {
                for (Map.Entry<String, g.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    g.e value = entry.getValue();
                    if (value != null) {
                        f.a aVar = new f.a();
                        aVar.a(value.c());
                        aVar.b(System.currentTimeMillis() / 1000);
                        aVar.a(value.a());
                        aVar.b(value.b());
                        this.f4701a.a(key, aVar);
                    } else if (this.f4703c == a.EnumC0003a.POLICY_TOLERANT) {
                        this.f4701a.b(key);
                    }
                }
            }
        } else if (dVar.equals(g.d.DNLIST_HOSTS) && this.f4703c == a.EnumC0003a.POLICY_TOLERANT) {
            for (String str2 : str.split(",")) {
                this.f4701a.b(str2);
            }
        }
        if (this.f4702b.e() <= 0 || this.f4704d.f()) {
            return;
        }
        this.f4704d.b(true);
        j.a("preResolve has finished", new Object[0]);
    }
}
