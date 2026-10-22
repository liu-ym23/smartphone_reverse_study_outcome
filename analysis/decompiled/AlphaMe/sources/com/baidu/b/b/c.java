package com.baidu.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private a f4751a;

    /* renamed from: b, reason: collision with root package name */
    private Map f4752b = new HashMap();

    public interface a {
        List a();
    }

    public c(a aVar) {
        this.f4751a = aVar;
        for (com.baidu.b.b.a aVar2 : aVar.a()) {
            this.f4752b.put(aVar2.a(), aVar2);
        }
    }

    public List a() {
        return new ArrayList(this.f4752b.values());
    }
}
