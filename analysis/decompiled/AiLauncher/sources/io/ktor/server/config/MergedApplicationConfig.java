package io.ktor.server.config;

import La.D;
import Y8.h;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.Z;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.server.config.MapApplicationConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005JE\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\n\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\n\u0010\rJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b \u0010\u001fR!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001aR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010\u001a¨\u0006("}, d2 = {"Lio/ktor/server/config/MergedApplicationConfig;", "Lio/ktor/server/config/ApplicationConfig;", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "<init>", "(Lio/ktor/server/config/ApplicationConfig;Lio/ktor/server/config/ApplicationConfig;)V", "", "", "", "other", "merge", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "Lio/ktor/server/config/ApplicationConfigValue;", "(Lio/ktor/server/config/ApplicationConfigValue;Lio/ktor/server/config/ApplicationConfigValue;)Lio/ktor/server/config/ApplicationConfigValue;", "mergeMapConfigValues", "path", "property", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfigValue;", "propertyOrNull", "config", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "", "configList", "(Ljava/lang/String;)Ljava/util/List;", "", "keys", "()Ljava/util/Set;", "toMap", "()Ljava/util/Map;", "Lio/ktor/server/config/ApplicationConfig;", "getFirst", "()Lio/ktor/server/config/ApplicationConfig;", "getSecond", "firstKeys$delegate", "LY8/h;", "getFirstKeys", "firstKeys", "secondKeys$delegate", "getSecondKeys", "secondKeys", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MergedApplicationConfig implements ApplicationConfig {
    private final ApplicationConfig first;

    /* renamed from: firstKeys$delegate, reason: from kotlin metadata */
    private final h firstKeys;
    private final ApplicationConfig second;

    /* renamed from: secondKeys$delegate, reason: from kotlin metadata */
    private final h secondKeys;

    public MergedApplicationConfig(ApplicationConfig first, ApplicationConfig second) {
        p.i(first, "first");
        p.i(second, "second");
        this.first = first;
        this.second = second;
        this.firstKeys = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.config.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MergedApplicationConfig.firstKeys_delegate$lambda$0(this.f33362a);
            }
        });
        this.secondKeys = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.config.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MergedApplicationConfig.secondKeys_delegate$lambda$1(this.f33363a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set firstKeys_delegate$lambda$0(MergedApplicationConfig mergedApplicationConfig) {
        return mergedApplicationConfig.first.keys();
    }

    private final Set<String> getFirstKeys() {
        return (Set) this.firstKeys.getValue();
    }

    private final Set<String> getSecondKeys() {
        return (Set) this.secondKeys.getValue();
    }

    private final Map<String, Object> merge(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        Set setO = Z.o(map.keySet(), map2.keySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(setO, 10)), 16));
        for (Object obj : setO) {
            String str = (String) obj;
            Object objMerge = map.get(str);
            Object obj2 = map2.get(str);
            if ((objMerge instanceof Map) && (obj2 instanceof Map)) {
                objMerge = merge((Map<String, ? extends Object>) objMerge, (Map<String, ? extends Object>) obj2);
            } else if (obj2 != null) {
                objMerge = obj2;
            }
            linkedHashMap.put(obj, objMerge);
        }
        return linkedHashMap;
    }

    private final ApplicationConfigValue mergeMapConfigValues(ApplicationConfigValue first, ApplicationConfigValue second) {
        return new MapApplicationConfigValue(kotlin.collections.a.C(kotlin.collections.a.w(MapApplicationConfig.Companion.flatten$ktor_server_core$default(MapApplicationConfig.INSTANCE, merge((Map<String, ? extends Object>) second.getMap(), (Map<String, ? extends Object>) first.getMap()), null, 1, null))), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set secondKeys_delegate$lambda$1(MergedApplicationConfig mergedApplicationConfig) {
        return mergedApplicationConfig.second.keys();
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfig config(String path) {
        p.i(path, "path");
        Set<String> firstKeys = getFirstKeys();
        if (!(firstKeys instanceof Collection) || !firstKeys.isEmpty()) {
            Iterator<T> it = firstKeys.iterator();
            while (it.hasNext()) {
                if (D.X((String) it.next(), path + '.', false, 2, null)) {
                    Set<String> secondKeys = getSecondKeys();
                    if (!(secondKeys instanceof Collection) || !secondKeys.isEmpty()) {
                        Iterator<T> it2 = secondKeys.iterator();
                        while (it2.hasNext()) {
                            if (D.X((String) it2.next(), path + '.', false, 2, null)) {
                                return new MergedApplicationConfig(this.first.config(path), this.second.config(path));
                            }
                        }
                    }
                    return this.first.config(path);
                }
            }
        }
        return this.second.config(path);
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public List<ApplicationConfig> configList(String path) {
        p.i(path, "path");
        return F.S0(getFirstKeys().contains(path) ? this.first.configList(path) : C1173v.m(), getSecondKeys().contains(path) ? this.second.configList(path) : C1173v.m());
    }

    public final ApplicationConfig getFirst() {
        return this.first;
    }

    public final ApplicationConfig getSecond() {
        return this.second;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public Set<String> keys() {
        return Z.o(getFirstKeys(), getSecondKeys());
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfigValue property(String path) {
        p.i(path, "path");
        ApplicationConfigValue applicationConfigValueMerge = merge(this.first.propertyOrNull(path), this.second.propertyOrNull(path));
        return applicationConfigValueMerge == null ? this.second.property(path) : applicationConfigValueMerge;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfigValue propertyOrNull(String path) {
        p.i(path, "path");
        return merge(this.first.propertyOrNull(path), this.second.propertyOrNull(path));
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public Map<String, Object> toMap() {
        return merge((Map<String, ? extends Object>) this.second.toMap(), (Map<String, ? extends Object>) this.first.toMap());
    }

    private final ApplicationConfigValue merge(ApplicationConfigValue first, ApplicationConfigValue second) {
        if (first == null) {
            return second;
        }
        if (second != null) {
            ApplicationConfigValue.Type type = first.getType();
            ApplicationConfigValue.Type type2 = ApplicationConfigValue.Type.OBJECT;
            if (type == type2 && second.getType() == type2) {
                return mergeMapConfigValues(first, second);
            }
        }
        return first;
    }
}
