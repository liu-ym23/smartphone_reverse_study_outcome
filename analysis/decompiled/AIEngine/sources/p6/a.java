package p6;

import androidx.datastore.preferences.protobuf.b1;
import b7.k;
import b7.p;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.common.util.TraceIdKeys;
import gc.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptyList;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static final int r;

    /* renamed from: a, reason: collision with root package name */
    public final String f11416a;

    /* renamed from: b, reason: collision with root package name */
    public final b f11417b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11418c;

    /* renamed from: d, reason: collision with root package name */
    public final List<k> f11419d;

    /* renamed from: e, reason: collision with root package name */
    public final List<p> f11420e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11421f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11422g;
    public final h h;

    /* renamed from: i, reason: collision with root package name */
    public final long f11423i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11424j;

    /* renamed from: k, reason: collision with root package name */
    public final c f11425k;

    /* renamed from: l, reason: collision with root package name */
    public final Map<String, c> f11426l;

    /* renamed from: m, reason: collision with root package name */
    public final Map<String, Map<String, String>> f11427m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11428n;

    /* renamed from: o, reason: collision with root package name */
    public final c f11429o;

    /* renamed from: p, reason: collision with root package name */
    public final i f11430p;

    /* renamed from: q, reason: collision with root package name */
    public final j f11431q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: p6.a$a, reason: collision with other inner class name */
    public static final class C0126a {
        public static a a(String id2, b bVar, String description, k modelConfig, Set set, h hVar) {
            kotlin.jvm.internal.g.f(id2, "id");
            kotlin.jvm.internal.g.f(description, "description");
            kotlin.jvm.internal.g.f(modelConfig, "modelConfig");
            String str = modelConfig.f3090a;
            Set<ProtocolType> set2 = modelConfig.f3095f;
            if (set == null || set.isEmpty()) {
                set = !set2.isEmpty() ? set2 : y.M(ProtocolType.f6378a);
            }
            if (!set2.isEmpty()) {
                for (ProtocolType protocolType : set) {
                    if (!modelConfig.c(protocolType)) {
                        throw new IllegalArgumentException(("模型 " + str + " 不支持协议类型 " + protocolType + "，支持的协议: " + set2).toString());
                    }
                }
            }
            return new a(id2, bVar, description, b1.P(modelConfig), b1.P(new p(str, set)), hVar, 130880);
        }

        public static /* synthetic */ a b(String str, b bVar, String str2, k kVar, h hVar, int i10) {
            if ((i10 & 64) != 0) {
                hVar = null;
            }
            return a(str, bVar, str2, kVar, null, hVar);
        }
    }

    static {
        new a(null, null, null, null, null, null, 131071);
        r = 7200;
    }

    public a() {
        this(null, null, null, null, null, null, 131071);
    }

    public final String a() {
        return this.f11416a;
    }

    public final k b() {
        ProtocolType protocolType = ProtocolType.f6378a;
        Iterator<p> it = this.f11420e.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            ProtocolType protocolType2 = (ProtocolType) kotlin.collections.a.u0(it.next().f3116c);
            if (protocolType2 == null) {
                protocolType2 = ProtocolType.f6378a;
            }
            if (protocolType2 == protocolType) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return null;
        }
        List<k> list = this.f11419d;
        if (i10 < list.size()) {
            return list.get(i10);
        }
        return null;
    }

    public final boolean c() {
        List<k> list = this.f11419d;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((k) it.next()).f3102n) {
                return true;
            }
        }
        return false;
    }

    public final String d(String str, String mode) {
        Map<String, String> map;
        String str2;
        kotlin.jvm.internal.g.f(mode, "mode");
        if (str != null) {
            if (q.t0(str) || str.equals("unknown")) {
                str = null;
            }
            if (str != null && (map = this.f11427m.get(str)) != null && (str2 = map.get(mode)) != null && !q.t0(str2)) {
                return str2;
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.g.b(this.f11416a, aVar.f11416a) && kotlin.jvm.internal.g.b(this.f11417b, aVar.f11417b) && kotlin.jvm.internal.g.b(this.f11418c, aVar.f11418c) && kotlin.jvm.internal.g.b(this.f11419d, aVar.f11419d) && kotlin.jvm.internal.g.b(this.f11420e, aVar.f11420e) && this.f11421f == aVar.f11421f && this.f11422g == aVar.f11422g && kotlin.jvm.internal.g.b(this.h, aVar.h) && this.f11423i == aVar.f11423i && this.f11424j == aVar.f11424j && kotlin.jvm.internal.g.b(this.f11425k, aVar.f11425k) && kotlin.jvm.internal.g.b(this.f11426l, aVar.f11426l) && kotlin.jvm.internal.g.b(this.f11427m, aVar.f11427m) && this.f11428n == aVar.f11428n && kotlin.jvm.internal.g.b(this.f11429o, aVar.f11429o) && kotlin.jvm.internal.g.b(this.f11430p, aVar.f11430p) && kotlin.jvm.internal.g.b(this.f11431q, aVar.f11431q);
    }

    public final int hashCode() {
        int iF = ai.onnxruntime.a.f(ai.onnxruntime.a.f(h0.e.b(this.f11420e, h0.e.b(this.f11419d, v1.d.a((this.f11417b.hashCode() + (this.f11416a.hashCode() * 31)) * 31, 31, this.f11418c), 31), 31), 31, this.f11421f), 31, this.f11422g);
        h hVar = this.h;
        int iHashCode = (this.f11429o.hashCode() + ai.onnxruntime.a.d(this.f11428n, (this.f11427m.hashCode() + ((this.f11426l.hashCode() + ((this.f11425k.hashCode() + ai.onnxruntime.a.f(a0.a.c((iF + (hVar == null ? 0 : Integer.hashCode(hVar.f11441a))) * 31, this.f11423i, 31), 31, this.f11424j)) * 31)) * 31)) * 31, 31)) * 31;
        i iVar = this.f11430p;
        int iHashCode2 = (iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        j jVar = this.f11431q;
        return iHashCode2 + (jVar != null ? jVar.hashCode() : 0);
    }

    public final String toString() {
        return "AbilityConfig(id=" + this.f11416a + ", abilityType=" + this.f11417b + ", description=" + this.f11418c + ", modelConfigs=" + this.f11419d + ", modelProtocols=" + this.f11420e + ", warmupOnPrepare=" + this.f11421f + ", keepAlive=" + this.f11422g + ", quota=" + this.h + ", cloudTimeoutMs=" + this.f11423i + ", cloudEnable=" + this.f11424j + ", cloudParams=" + this.f11425k + ", cloudParamsByPackage=" + this.f11426l + ", cloudSceneTypeByPackage=" + this.f11427m + ", downloadUrlExpiresSeconds=" + this.f11428n + ", cloudPolicy=" + this.f11429o + ", segmentation=" + this.f11430p + ", vad=" + this.f11431q + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(String str, b bVar, String str2, List list, List list2, h hVar, int i10) {
        String str3 = (i10 & 1) != 0 ? "" : str;
        b bVar2 = (i10 & 2) != 0 ? b.f11432e : bVar;
        String str4 = (i10 & 4) != 0 ? "" : str2;
        List list3 = (i10 & 8) != 0 ? EmptyList.f10001a : list;
        List list4 = (i10 & 16) != 0 ? EmptyList.f10001a : list2;
        h hVar2 = (i10 & TraceIdKeys.MAX_LENGTH) != 0 ? null : hVar;
        c cVar = c.f11438b;
        this(str3, bVar2, str4, list3, list4, true, false, hVar2, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, false, cVar, kotlin.collections.b.d0(), kotlin.collections.b.d0(), r, cVar, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String id2, b abilityType, String description, List<k> modelConfigs, List<p> modelProtocols, boolean z, boolean z3, h hVar, long j10, boolean z10, c cloudParams, Map<String, c> map, Map<String, ? extends Map<String, String>> map2, int i10, c cloudPolicy, i iVar, j jVar) {
        kotlin.jvm.internal.g.f(id2, "id");
        kotlin.jvm.internal.g.f(abilityType, "abilityType");
        kotlin.jvm.internal.g.f(description, "description");
        kotlin.jvm.internal.g.f(modelConfigs, "modelConfigs");
        kotlin.jvm.internal.g.f(modelProtocols, "modelProtocols");
        kotlin.jvm.internal.g.f(cloudParams, "cloudParams");
        kotlin.jvm.internal.g.f(cloudPolicy, "cloudPolicy");
        this.f11416a = id2;
        this.f11417b = abilityType;
        this.f11418c = description;
        this.f11419d = modelConfigs;
        this.f11420e = modelProtocols;
        this.f11421f = z;
        this.f11422g = z3;
        this.h = hVar;
        this.f11423i = j10;
        this.f11424j = z10;
        this.f11425k = cloudParams;
        this.f11426l = map;
        this.f11427m = map2;
        this.f11428n = i10;
        this.f11429o = cloudPolicy;
        this.f11430p = iVar;
        this.f11431q = jVar;
    }
}
