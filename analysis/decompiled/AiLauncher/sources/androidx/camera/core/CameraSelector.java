package androidx.camera.core;

import D.InterfaceC0776m;
import D.InterfaceC0778o;
import K.C0878d0;
import K.InterfaceC0898v;
import androidx.camera.core.impl.CameraInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class CameraSelector {

    /* renamed from: c, reason: collision with root package name */
    public static final CameraSelector f11143c = new a().d(0).b();

    /* renamed from: d, reason: collision with root package name */
    public static final CameraSelector f11144d = new a().d(1).b();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<InterfaceC0776m> f11145a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11146b;

    public CameraSelector(LinkedHashSet<InterfaceC0776m> linkedHashSet, String str) {
        this.f11145a = linkedHashSet;
        this.f11146b = str;
    }

    public LinkedHashSet<CameraInternal> a(LinkedHashSet<CameraInternal> linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<CameraInternal> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        List<InterfaceC0778o> listB = b(arrayList);
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>();
        Iterator<CameraInternal> it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            CameraInternal next = it2.next();
            if (listB.contains(next.a())) {
                linkedHashSet2.add(next);
            }
        }
        return linkedHashSet2;
    }

    public List<InterfaceC0778o> b(List<InterfaceC0778o> list) {
        List<InterfaceC0778o> arrayList = new ArrayList<>(list);
        Iterator<InterfaceC0776m> it = this.f11145a.iterator();
        while (it.hasNext()) {
            arrayList = it.next().b(Collections.unmodifiableList(arrayList));
        }
        arrayList.retainAll(list);
        return arrayList;
    }

    public LinkedHashSet<InterfaceC0776m> c() {
        return this.f11145a;
    }

    public Integer d() {
        Iterator<InterfaceC0776m> it = this.f11145a.iterator();
        Integer num = null;
        while (it.hasNext()) {
            InterfaceC0776m next = it.next();
            if (next instanceof C0878d0) {
                Integer numValueOf = Integer.valueOf(((C0878d0) next).c());
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public final String e(Set<CameraInternal> set) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cams:");
        sb2.append(set.size());
        Iterator<CameraInternal> it = set.iterator();
        while (it.hasNext()) {
            InterfaceC0898v interfaceC0898vI = it.next().i();
            sb2.append(String.format(" Id:%s  Lens:%s", interfaceC0898vI.h(), Integer.valueOf(interfaceC0898vI.k())));
        }
        return sb2.toString();
    }

    public final String f() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("PhyId:%s  Filters:%s", this.f11146b, Integer.valueOf(this.f11145a.size())));
        Iterator<InterfaceC0776m> it = this.f11145a.iterator();
        while (it.hasNext()) {
            InterfaceC0776m next = it.next();
            sb2.append(" Id:");
            sb2.append(next.a());
            if (next instanceof C0878d0) {
                sb2.append(" LensFilter:");
                sb2.append(((C0878d0) next).c());
            }
        }
        return sb2.toString();
    }

    public CameraInternal g(LinkedHashSet<CameraInternal> linkedHashSet) {
        Iterator<CameraInternal> it = a(linkedHashSet).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new IllegalArgumentException(String.format("No available camera can be found. %s %s", e(linkedHashSet), f()));
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet<InterfaceC0776m> f11147a;

        /* renamed from: b, reason: collision with root package name */
        public String f11148b;

        public a() {
            this.f11147a = new LinkedHashSet<>();
        }

        public static a c(CameraSelector cameraSelector) {
            return new a(cameraSelector.c());
        }

        public a a(InterfaceC0776m interfaceC0776m) {
            this.f11147a.add(interfaceC0776m);
            return this;
        }

        public CameraSelector b() {
            return new CameraSelector(this.f11147a, this.f11148b);
        }

        public a d(int i10) {
            B0.h.i(i10 != -1, "The specified lens facing is invalid.");
            this.f11147a.add(new C0878d0(i10));
            return this;
        }

        public a(LinkedHashSet<InterfaceC0776m> linkedHashSet) {
            this.f11147a = new LinkedHashSet<>(linkedHashSet);
        }
    }
}
