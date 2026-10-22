package com.uxsense.core.parse;

import B9.B;
import C9.d;
import C9.l;
import C9.m;
import C9.r;
import C9.u;
import C9.x;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import v0.C2054a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\u0000*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/uxsense/core/parse/JsonArrayPlusBuilder;", "", "LC9/d;", "original", AppAgent.CONSTRUCT, "(LC9/d;)V", "", "value", "minus", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/uxsense/core/parse/JsonArrayPlusBuilder;", "Lkotlin/Function1;", "Lv0/a;", "LC7/r;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "obj", "(LS7/k;)Lcom/uxsense/core/parse/JsonArrayPlusBuilder;", "LC9/l;", "element", "(LC9/l;)Lcom/uxsense/core/parse/JsonArrayPlusBuilder;", "()LC9/d;", "LC9/d;", "", "newElements", "Ljava/util/List;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonArrayPlusBuilder {
    private final List<l> newElements;
    private final d original;

    public JsonArrayPlusBuilder(d original) {
        k.f(original, "original");
        this.original = original;
        this.newElements = new ArrayList();
    }

    public final d build() {
        ArrayList arrayList = new ArrayList();
        for (l element : this.original) {
            k.f(element, "element");
            arrayList.add(element);
        }
        for (l element2 : this.newElements) {
            k.f(element2, "element");
            arrayList.add(element2);
        }
        return new d(arrayList);
    }

    public final JsonArrayPlusBuilder element(l element) {
        k.f(element, "element");
        this.newElements.add(element);
        return this;
    }

    public final JsonArrayPlusBuilder minus(String str, Object obj) {
        Object objB;
        k.f(str, "<this>");
        if (obj instanceof String) {
            objB = m.b((String) obj);
        } else if (obj instanceof Number) {
            objB = m.a((Number) obj);
        } else if (obj instanceof Boolean) {
            Boolean bool = (Boolean) obj;
            B b = m.f329a;
            objB = bool == null ? u.INSTANCE : new r(bool, false, null);
        } else {
            objB = obj == null ? u.INSTANCE : m.b(obj.toString());
        }
        this.newElements.add(new x(a.Q(new Pair(str, objB))));
        return this;
    }

    public final JsonArrayPlusBuilder obj(S7.k build) {
        k.f(build, "build");
        List<l> list = this.newElements;
        C2054a c2054a = new C2054a(1);
        build.invoke(c2054a);
        list.add(new x((LinkedHashMap) c2054a.f6763a));
        return this;
    }
}
