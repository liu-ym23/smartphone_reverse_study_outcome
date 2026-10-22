package Z0;

import Ba.g;
import F.b;
import M9.f;
import X8.w;
import aa.InterfaceC0315b;
import android.content.Context;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.SpecificationVersion;
import h8.C1531n;
import h8.InterfaceC1527j;
import h8.InterfaceC1535r;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import k8.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import org.json.JSONObject;
import stepos.support.v7.app.DialogInterfaceC1961j;
import stepos.support.v7.app.InterfaceC1959h;
import stepos.support.v7.app.P;
import stepos.support.v7.app.Q;
import stepos.support.v7.app.S;
import u3.C2036b;
import u3.i;
import u3.j;
import u3.k;
import v.c;
import w3.C2097b;
import z8.n;
import z8.o;

/* loaded from: classes2.dex */
public class a implements n, b, InterfaceC1535r, InterfaceC1959h, c {
    public static volatile a b;

    /* renamed from: a, reason: collision with root package name */
    public Object f1582a;

    public /* synthetic */ a(Object obj) {
        this.f1582a = obj;
    }

    public static a C() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        a aVar = new a();
                        aVar.f1582a = new CopyOnWriteArraySet();
                        b = aVar;
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static f G(String str, k kVar) {
        JsonNode jsonNode;
        i iVarE = kVar.e(j.c(str));
        kVar.g.getClass();
        try {
            iVarE.h();
        } catch (Exception unused) {
        }
        C2097b c2097b = (C2097b) iVarE.f6703j.c;
        InterfaceC0315b interfaceC0315b = C2097b.g;
        HashMap map = new HashMap(c2097b.d);
        f fVar = new f(c2097b.f6840a);
        HashMap map2 = (HashMap) fVar.f;
        fVar.f981a = c2097b.b;
        f fVar2 = c2097b.f;
        fVar.f(((HashMap) fVar2.d).values());
        fVar.e(((HashMap) fVar2.e).values());
        fVar.b = c2097b.e;
        map2.putAll(map);
        fVar.c = str;
        SpecificationVersion specificationVersion = ((C2097b) iVarE.f6703j.c).e;
        if (specificationVersion != null && specificationVersion.f3013a >= 8 && (jsonNode = iVarE.g.get("$vocabulary")) != null) {
            map2.clear();
            for (Map.Entry<String, JsonNode> entry : jsonNode.properties()) {
                map2.put(entry.getKey(), Boolean.valueOf(entry.getValue().booleanValue()));
            }
        }
        return fVar;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r A(w type) {
        kotlin.jvm.internal.k.f(type, "type");
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r B() {
        return this;
    }

    public void D(Object obj) {
        ((ArrayList) this.f1582a).add(obj);
    }

    public void E(Object obj) {
        ArrayList arrayList = (ArrayList) this.f1582a;
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(arrayList, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            arrayList.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else {
            if (!(obj instanceof Iterator)) {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
    }

    public C2097b F(String str, k kVar) {
        C2097b c2097b = (C2097b) ((g) this.f1582a).apply(str);
        if (c2097b != null) {
            return c2097b;
        }
        C2036b c2036b = new C2036b();
        c2036b.g = "Unknown dialect ''{0}''. Only dialects that are explicitly configured can be used.";
        c2036b.e = new Object[]{str};
        throw new InvalidSchemaException(c2036b.a());
    }

    @Override // v.c
    public String a() {
        return ((A8.b) this.f1582a).M0("openudid");
    }

    @Override // v.c
    public boolean b(Object obj) {
        return U7.a.q((String) obj);
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1536s build() {
        return (Z8.b) this.f1582a;
    }

    @Override // F.b
    public void c(JSONObject jSONObject) {
        b bVar = (b) this.f1582a;
        if (bVar != null) {
            bVar.c(jSONObject);
        }
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r d(u uVar) {
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r e(List parameters) {
        kotlin.jvm.internal.k.f(parameters, "parameters");
        return this;
    }

    @Override // v.c
    public String f(Object obj, Object obj2, A8.b bVar) {
        String str = (String) obj;
        return bVar == null ? str : (String) bVar.E0(str, (String) obj2, new a(bVar));
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r g(InterfaceC1527j owner) {
        kotlin.jvm.internal.k.f(owner, "owner");
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r h(G8.f name) {
        kotlin.jvm.internal.k.f(name, "name");
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r i() {
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r j() {
        return this;
    }

    @Override // z8.n
    public void k() {
    }

    @Override // z8.n
    public n l(G8.b bVar, G8.f fVar) {
        return null;
    }

    @Override // z8.n
    public void m(G8.f fVar, L8.f fVar2) {
    }

    @Override // z8.n
    public o n(G8.f fVar) {
        if ("b".equals(fVar.b())) {
            return new A8.c(this, 2);
        }
        return null;
    }

    @Override // stepos.support.v7.app.InterfaceC1959h
    public DialogInterfaceC1961j newDialog(Context context, int i) {
        P p = ((S) this.f1582a).f6235j;
        Q q5 = new Q(context, i);
        q5.f6232a = p;
        return q5;
    }

    @Override // v.c
    public boolean o(Object obj, Object obj2) {
        return U7.a.m((String) obj, (String) obj2);
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r p() {
        return this;
    }

    @Override // v.c
    public void q(Object obj) {
        ((A8.b) this.f1582a).J0("openudid", (String) obj);
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r r(C1531n visibility) {
        kotlin.jvm.internal.k.f(visibility, "visibility");
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r s(Modality modality) {
        return this;
    }

    @Override // z8.n
    public void t(G8.f fVar, Object obj) {
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r u() {
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r v() {
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r w(List parameters) {
        kotlin.jvm.internal.k.f(parameters, "parameters");
        return this;
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r x(InterfaceC1561g additionalAnnotations) {
        kotlin.jvm.internal.k.f(additionalAnnotations, "additionalAnnotations");
        return this;
    }

    @Override // z8.n
    public void y(G8.f fVar, G8.b bVar, G8.f fVar2) {
    }

    @Override // h8.InterfaceC1535r
    public InterfaceC1535r z(CallableMemberDescriptor$Kind callableMemberDescriptor$Kind) {
        return this;
    }

    public a(int i) {
        this.f1582a = new ArrayList(i);
    }
}
