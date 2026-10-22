package t9;

import android.content.Context;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import b0.f1;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import d7.i0;
import i8.l0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ob.z;
import v9.e0;
import v9.v;
import z7.h0;
import z7.j0;
import z7.k0;
import z7.m0;
import z7.m1;
import z7.n1;
import z7.p1;
import z8.f0;
import z8.x;

/* loaded from: classes.dex */
public final class h extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9800g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f9801h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i2, Object obj) {
        super(0);
        this.f9800g = i2;
        this.f9801h = obj;
    }

    @Override // p7.a
    public final Object c() {
        int i2 = this.f9800g;
        c7.r rVar = c7.r.f1986a;
        Object obj = this.f9801h;
        switch (i2) {
            case 0:
                HashSet hashSet = new HashSet();
                i iVar = (i) ((i5.f) obj).f4656j;
                s8.h hVar = iVar.f9811s;
                r9.k kVar = iVar.f9809q;
                z8.i iVar2 = iVar.f9802j;
                Iterator it = hVar.d().iterator();
                while (it.hasNext()) {
                    for (f8.j jVar : o9.p.getContributedDescriptors$default(((v) it.next()).v0(), null, null, 3, null)) {
                        if ((jVar instanceof l0) || (jVar instanceof f8.l0)) {
                            hashSet.add(jVar.getName());
                        }
                    }
                }
                List list = iVar2.f12201v;
                q7.k.d(list, "classProto.functionList");
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    hashSet.add(nb.i.y((b9.f) kVar.f9071g, ((x) it2.next()).f12448k));
                }
                List list2 = iVar2.f12202w;
                q7.k.d(list2, "classProto.propertyList");
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    hashSet.add(nb.i.y((b9.f) kVar.f9071g, ((f0) it3.next()).f12137k));
                }
                return i0.Y(hashSet, hashSet);
            case 1:
                o oVar = (o) obj;
                Set setN = oVar.n();
                if (setN == null) {
                    return null;
                }
                return i0.Y(i0.Y(oVar.m(), oVar.f9836c.f9827c.keySet()), setN);
            case 2:
                t tVar = (t) obj;
                r9.k kVar2 = tVar.f9856p;
                return d7.r.m1(((r9.i) kVar2.f9070f).f9051e.g(tVar.f9857q, (b9.f) kVar2.f9071g));
            case 3:
                v.g gVar = (v.g) obj;
                gVar.D = null;
                i1.l.n(gVar);
                i1.l.m(gVar);
                i1.l.l(gVar);
                return Boolean.TRUE;
            case 4:
                String strConcat = "stepos_cloud_secure_data".concat(".preferences_pb");
                q7.k.e(strConcat, "fileName");
                return new File(((Context) obj).getApplicationContext().getFilesDir(), "datastore/".concat(strConcat));
            case 5:
                return new v9.e(((v9.f) obj).e());
            case 6:
                return v9.c.r(((e0) obj).f10545a);
            case 7:
                return x9.i.c(x9.h.D, ((nb.f) obj).toString());
            case 8:
                Object systemService = ((w1.c) obj).f10643a.getContext().getSystemService("input_method");
                q7.k.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager) systemService;
            case 9:
                return new BaseInputConnection(((w1.c) obj).f10643a, false);
            case 10:
                File file = (File) ((h) obj).c();
                String name = file.getName();
                q7.k.d(name, "getName(...)");
                if (ga.k.G0('.', name, "").equals("preferences_pb")) {
                    String str = z.f8042g;
                    File absoluteFile = file.getAbsoluteFile();
                    q7.k.d(absoluteFile, "file.absoluteFile");
                    return h4.n.m(absoluteFile);
                }
                throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
            case 11:
                p7.a aVar = ((w9.j) obj).f10942b;
                if (aVar != null) {
                    return (List) aVar.c();
                }
                return null;
            case 12:
                ((x.a) obj).f11000n.setValue(Boolean.valueOf(!((Boolean) r7.getValue()).booleanValue()));
                return rVar;
            case 13:
                i1.l.l((x.b) obj);
                return rVar;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return (x.f) ((f1) obj).getValue();
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return p1.a(((z7.e0) obj).c());
            case 16:
                return new h0((z7.i0) obj);
            case 17:
                return new j0((k0) obj);
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                return new z7.l0((m0) obj);
            default:
                List upperBounds = ((n1) obj).f11921f.getUpperBounds();
                q7.k.d(upperBounds, "descriptor.upperBounds");
                ArrayList arrayList = new ArrayList(d7.t.A0(upperBounds, 10));
                Iterator it4 = upperBounds.iterator();
                while (it4.hasNext()) {
                    arrayList.add(new m1((v) it4.next(), null));
                }
                return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, v2.b bVar) {
        super(0);
        this.f9800g = 4;
        this.f9801h = context;
    }
}
