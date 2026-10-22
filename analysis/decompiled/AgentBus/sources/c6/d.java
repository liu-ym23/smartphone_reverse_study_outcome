package c6;

import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import com.stepos.probe.SysfsProbe;
import d7.h0;
import ga.r;
import ia.x;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1925f;

    public /* synthetic */ d(int i2) {
        this.f1925f = i2;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // p7.k
    public final Object invoke(Object obj) {
        String strConcat;
        switch (this.f1925f) {
            case 0:
                return Boolean.valueOf(((c) obj).f1917j.get());
            case 1:
                return SysfsProbe.diagnosePowerSupplyAccess$lambda$0((File) obj);
            case 2:
                ga.g gVar = (ga.g) obj;
                q7.k.e(gVar, "m");
                Set set = e5.b.f3054a;
                return e5.b.h(gVar, e5.b.f((String) ((h0) ((ga.h) gVar).a()).get(5)));
            case 3:
                ga.g gVar2 = (ga.g) obj;
                q7.k.e(gVar2, "m");
                Set set2 = e5.b.f3054a;
                return e5.b.h(gVar2, e5.b.f((String) ((h0) ((ga.h) gVar2).a()).get(5)));
            case 4:
                ga.g gVar3 = (ga.g) obj;
                q7.k.e(gVar3, "m");
                Set set3 = e5.b.f3054a;
                return e5.b.h(gVar3, e5.b.f((String) ((h0) ((ga.h) gVar3).a()).get(5)));
            case 5:
                ga.g gVar4 = (ga.g) obj;
                q7.k.e(gVar4, "m");
                ga.h hVar = (ga.h) gVar4;
                Object obj2 = ((h0) hVar.a()).get(1);
                Set set4 = e5.b.f3054a;
                return obj2 + e5.b.f((String) ((h0) hVar.a()).get(2));
            case 6:
                ga.g gVar5 = (ga.g) obj;
                q7.k.e(gVar5, "it");
                Set set5 = e5.b.f3054a;
                return a1.a.j("(", e5.b.f((String) ((h0) ((ga.h) gVar5).a()).get(1)), ")");
            case 7:
                ga.g gVar6 = (ga.g) obj;
                q7.k.e(gVar6, "it");
                String strGroup = ((ga.h) gVar6).f4023a.group();
                q7.k.d(strGroup, "group(...)");
                String strSubstring = strGroup.substring(0, 6);
                q7.k.d(strSubstring, "substring(...)");
                return a1.a.i(strSubstring, r.c0(strGroup.length() - 6, "*"));
            case 8:
                ga.g gVar7 = (ga.g) obj;
                q7.k.e(gVar7, "it");
                String strGroup2 = ((ga.h) gVar7).f4023a.group();
                q7.k.d(strGroup2, "group(...)");
                String strSubstring2 = strGroup2.substring(0, 6);
                q7.k.d(strSubstring2, "substring(...)");
                return a1.a.x(strSubstring2, r.c0(strGroup2.length() - 10, "*"), ga.k.M0(4, strGroup2));
            case 9:
                ga.g gVar8 = (ga.g) obj;
                q7.k.e(gVar8, "it");
                String strGroup3 = ((ga.h) gVar8).f4023a.group();
                q7.k.d(strGroup3, "group(...)");
                String strSubstring3 = strGroup3.substring(0, 3);
                q7.k.d(strSubstring3, "substring(...)");
                return a1.a.x(strSubstring3, "****", ga.k.M0(4, strGroup3));
            case 10:
                ga.g gVar9 = (ga.g) obj;
                q7.k.e(gVar9, "it");
                ga.h hVar2 = (ga.h) gVar9;
                String str = (String) ((h0) hVar2.a()).get(1);
                String str2 = (String) ((h0) hVar2.a()).get(2);
                if (str.length() <= 2) {
                    strConcat = r.c0(str.length(), "*");
                } else {
                    String strSubstring4 = str.substring(2);
                    q7.k.d(strSubstring4, "substring(...)");
                    strConcat = "**".concat(strSubstring4);
                }
                return a1.a.x(strConcat, "@", str2);
            case 11:
                ga.g gVar10 = (ga.g) obj;
                q7.k.e(gVar10, "m");
                ga.h hVar3 = (ga.h) gVar10;
                return ((h0) hVar3.a()).get(1) + "redacted " + ((String) ((h0) hVar3.a()).get(2)).length() + ((h0) hVar3.a()).get(3);
            case 12:
                Byte b10 = (Byte) obj;
                b10.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b10}, 1));
            case 13:
                fa.j jVar = (fa.j) obj;
                q7.k.e(jVar, "it");
                return jVar.iterator();
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return obj;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return Boolean.valueOf(obj == null);
            case 16:
                q7.k.e((String) obj, "it");
                return new LinkedHashSet();
            case 17:
                q7.k.e((String) obj, "it");
                return new LinkedHashSet();
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                g7.j jVar2 = (g7.j) obj;
                if (jVar2 instanceof x) {
                    return (x) jVar2;
                }
                return null;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
                q7.k.e((String) obj, "it");
                return ConcurrentHashMap.newKeySet();
            case 20:
                Map.Entry entry = (Map.Entry) obj;
                q7.k.e(entry, "<destruct>");
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                q7.k.b(str4);
                return a1.a.x(str3, "=", a1.a.j("\"", r.e0(r.e0(str4, "\\", "\\\\"), "\"", "\\\""), "\""));
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
                synchronized (l0.m.f5774c) {
                    ?? r02 = l0.m.f5780i;
                    int size = r02.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((p7.k) r02.get(i2)).invoke(obj);
                    }
                }
                return c7.r.f1986a;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                d dVar = l0.m.f5772a;
                return c7.r.f1986a;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                q7.k.e((String) obj, "it");
                return Boolean.valueOf(!ga.k.t0(r10));
            case 24:
                Map.Entry entry2 = (Map.Entry) obj;
                q7.k.e(entry2, "it");
                return entry2.getKey() + "=" + entry2.getValue();
            case 25:
                Map.Entry entry3 = (Map.Entry) obj;
                q7.k.e(entry3, "it");
                return entry3.getKey() + "=" + entry3.getValue();
            case 26:
                q7.k.e((String) obj, "it");
                return new AtomicLong(0L);
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                q7.k.e((String) obj, "it");
                return new AtomicLong(0L);
            case 28:
                q7.k.e((String) obj, "it");
                return new m5.k();
            default:
                Map.Entry entry4 = (Map.Entry) obj;
                q7.k.e(entry4, "it");
                return entry4.getKey() + "=" + entry4.getValue();
        }
    }

    public /* synthetic */ d(i5.l lVar) {
        this.f1925f = 28;
    }
}
