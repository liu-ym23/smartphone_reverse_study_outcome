package io.ktor.server.config;

import Ka.j;
import Ka.m;
import La.D;
import La.H;
import La.K;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.M;
import Z8.Q;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0010\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\b¢\u0006\u0004\b\u0006\u0010\u000bB5\b\u0016\u0012*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t0\f\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u0006\u0010\rB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0004\b\u0011\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\"0!H\u0016¢\u0006\u0004\b#\u0010$R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010$R\u001a\u0010\u0005\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lio/ktor/server/config/MapApplicationConfig;", "Lio/ktor/server/config/ApplicationConfig;", "", "", C3081a.FOCUS_MAP_NAME, "path", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", "", "Lkotlin/Pair;", "values", "(Ljava/util/Collection;)V", "", "([Lkotlin/Pair;)V", "()V", UxipConstants.f30680s, "LY8/t;", "put", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "Lio/ktor/server/config/ApplicationConfigValue;", "property", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfigValue;", "", "configList", "(Ljava/lang/String;)Ljava/util/List;", "propertyOrNull", "config", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "", "keys", "()Ljava/util/Set;", "", "", "toMap", "()Ljava/util/Map;", "Ljava/util/Map;", "getMap", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class MapApplicationConfig implements ApplicationConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, String> map;
    private final String path;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\nJ5\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b0\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/server/config/MapApplicationConfig$Companion;", "", "<init>", "()V", "", "", "prefix", "LKa/j;", "Lkotlin/Pair;", "flatten$ktor_server_core", "(Ljava/util/Map;Ljava/lang/String;)LKa/j;", "flatten", "", "(Ljava/util/List;Ljava/lang/String;)LKa/j;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ j flatten$ktor_server_core$default(Companion companion, Map map, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "";
            }
            return companion.flatten$ktor_server_core((Map<String, ? extends Object>) map, str);
        }

        public final j<Pair<String, String>> flatten$ktor_server_core(Map<String, ? extends Object> map, String prefix) {
            p.i(map, "<this>");
            p.i(prefix, "prefix");
            return m.b(new MapApplicationConfig$Companion$flatten$1(map, prefix, null));
        }

        private Companion() {
        }

        public final j<Pair<String, String>> flatten$ktor_server_core(List<? extends Object> list, String prefix) {
            p.i(list, "<this>");
            p.i(prefix, "prefix");
            return m.b(new MapApplicationConfig$Companion$flatten$2(list, prefix, null));
        }
    }

    public MapApplicationConfig(Map<String, String> map, String path) {
        p.i(map, "map");
        p.i(path, "path");
        this.map = map;
        this.path = path;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfig config(String path) {
        p.i(path, "path");
        return new MapApplicationConfig(this.map, MapApplicationConfigKt.combine(this.path, path));
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public List<ApplicationConfig> configList(String path) throws ApplicationConfigurationException {
        p.i(path, "path");
        String strCombine = MapApplicationConfigKt.combine(this.path, path);
        String str = this.map.get(MapApplicationConfigKt.combine(strCombine, ContentDisposition.Parameters.Size));
        if (str == null) {
            throw new ApplicationConfigurationException("Property " + strCombine + ".size not found.");
        }
        C5680i c5680iS = C5685n.s(0, Integer.parseInt(str));
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            arrayList.add(new MapApplicationConfig(this.map, MapApplicationConfigKt.combine(strCombine, ((M) it).nextInt())));
        }
        return arrayList;
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public Set<String> keys() {
        Set<String> set;
        Object next;
        boolean z10 = this.path.length() == 0;
        Set<String> setKeySet = this.map.keySet();
        if (z10) {
            set = setKeySet;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : setKeySet) {
                if (D.X((String) obj, this.path + '.', false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            set = arrayList;
        }
        Iterable<String> iterable = set;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : iterable) {
            if (H.g0((String) obj2, ".size", false, 2, null)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(H.x1((String) it.next(), ".size", null, 2, null));
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList4 = new ArrayList();
        for (String strP1 : iterable) {
            Iterator it2 = arrayList3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (D.X(strP1, (String) next, false, 2, null)) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null && !linkedHashSet.contains(str)) {
                linkedHashSet.add(str);
                strP1 = str;
            } else if (str != null) {
                strP1 = null;
            }
            if (!z10) {
                strP1 = strP1 != null ? H.p1(strP1, this.path + '.', null, 2, null) : null;
            }
            if (strP1 != null) {
                arrayList4.add(strP1);
            }
        }
        return F.r1(arrayList4);
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfigValue property(String path) throws ApplicationConfigurationException {
        p.i(path, "path");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = propertyOrNull(path);
        if (applicationConfigValuePropertyOrNull != null) {
            return applicationConfigValuePropertyOrNull;
        }
        throw new ApplicationConfigurationException("Property " + MapApplicationConfigKt.combine(this.path, path) + " not found.");
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfigValue propertyOrNull(String path) {
        p.i(path, "path");
        String strCombine = MapApplicationConfigKt.combine(this.path, path);
        if (MapConfigDecoderKt.containsPrefix(this.map, strCombine)) {
            return new MapApplicationConfigValue(this.map, strCombine);
        }
        return null;
    }

    public final void put(String path, String value) {
        p.i(path, "path");
        p.i(value, "value");
        this.map.put(MapApplicationConfigKt.combine(this.path, path), value);
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public Map<String, Object> toMap() throws ApplicationConfigurationException {
        Pair pairA;
        Set<String> setKeySet = this.map.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (D.X((String) obj, this.path, false, 2, null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) F.q0(H.a1(K.L1((String) it.next(), this.path.length() == 0 ? 0 : this.path.length() + 1), new char[]{'.'}, false, 0, 6, null)));
        }
        List<String> listG0 = F.g0(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listG0, 10)), 16));
        for (String str : listG0) {
            String strCombine = MapApplicationConfigKt.combine(this.path, str);
            if (this.map.containsKey(strCombine)) {
                pairA = Y8.j.a(str, this.map.get(strCombine));
            } else if (!this.map.containsKey(MapApplicationConfigKt.combine(strCombine, ContentDisposition.Parameters.Size))) {
                pairA = Y8.j.a(str, config(str).toMap());
            } else if (this.map.containsKey(MapApplicationConfigKt.combine(strCombine, "0"))) {
                pairA = Y8.j.a(str, property(strCombine).getList());
            } else {
                List<ApplicationConfig> listConfigList = configList(str);
                ArrayList arrayList3 = new ArrayList(C1174w.x(listConfigList, 10));
                Iterator<T> it2 = listConfigList.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((ApplicationConfig) it2.next()).toMap());
                }
                pairA = Y8.j.a(str, arrayList3);
            }
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public final void put(String path, Iterable<String> values) {
        p.i(path, "path");
        p.i(values, "values");
        int i10 = 0;
        int i11 = 0;
        for (String str : values) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            put(MapApplicationConfigKt.combine(path, i11), str);
            i10++;
            i11 = i12;
        }
        put(MapApplicationConfigKt.combine(path, ContentDisposition.Parameters.Size), String.valueOf(i10));
    }

    public /* synthetic */ MapApplicationConfig(Map map, String str, int i10, i iVar) {
        this(map, (i10 & 2) != 0 ? "" : str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MapApplicationConfig(Collection<Pair<String, String>> values) {
        p.i(values, "values");
        Collection<Pair<String, String>> collection = values;
        this(kotlin.collections.a.C(kotlin.collections.a.y(collection)), "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            MapApplicationConfigKt.findListElements((String) ((Pair) it.next()).e(), linkedHashMap);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            this.map.put(str + ".size", String.valueOf(iIntValue));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MapApplicationConfig(Pair<String, String>... values) {
        this(kotlin.collections.a.p((Pair[]) Arrays.copyOf(values, values.length)), "");
        p.i(values, "values");
    }

    public MapApplicationConfig() {
        this(new LinkedHashMap(), "");
    }
}
