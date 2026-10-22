package io.ktor.server.config;

import Y8.h;
import Z8.C1174w;
import Z8.M;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u001b\u0010\u0012\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/server/config/MapApplicationConfigValue;", "Lio/ktor/server/config/ApplicationConfigValue;", "", "", C3081a.FOCUS_MAP_NAME, "path", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "", "getList", "()Ljava/util/List;", "", "", "getMap", "()Ljava/util/Map;", "Lio/ktor/util/reflect/TypeInfo;", "type", "getAs", "(Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "Ljava/util/Map;", "Ljava/lang/String;", "Lio/ktor/server/config/ApplicationConfigValue$Type;", "type$delegate", "LY8/h;", "getType", "()Lio/ktor/server/config/ApplicationConfigValue$Type;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapApplicationConfigValue implements ApplicationConfigValue {
    private final Map<String, String> map;
    private final String path;

    /* renamed from: type$delegate, reason: from kotlin metadata */
    private final h type;

    public MapApplicationConfigValue(Map<String, String> map, String path) {
        p.i(map, "map");
        p.i(path, "path");
        this.map = map;
        this.path = path;
        this.type = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.config.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return MapApplicationConfigValue.type_delegate$lambda$0(this.f33361a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApplicationConfigValue.Type type_delegate$lambda$0(MapApplicationConfigValue mapApplicationConfigValue) {
        return mapApplicationConfigValue.map.containsKey(mapApplicationConfigValue.path) ? ApplicationConfigValue.Type.SINGLE : mapApplicationConfigValue.map.containsKey(MapApplicationConfigKt.combine(mapApplicationConfigValue.path, ContentDisposition.Parameters.Size)) ? ApplicationConfigValue.Type.LIST : MapConfigDecoderKt.containsPrefix(mapApplicationConfigValue.map, mapApplicationConfigValue.path) ? ApplicationConfigValue.Type.OBJECT : ApplicationConfigValue.Type.NULL;
    }

    @Override // io.ktor.server.config.ApplicationConfigValue
    public Object getAs(TypeInfo type) {
        p.i(type, "type");
        return TypeKt.serializer(type).deserialize(new MapConfigDecoder(this.map, this.path, null, 4, null));
    }

    @Override // io.ktor.server.config.ApplicationConfigValue
    public List<String> getList() throws ApplicationConfigurationException {
        String str = this.map.get(MapApplicationConfigKt.combine(this.path, ContentDisposition.Parameters.Size));
        if (str == null) {
            throw new ApplicationConfigurationException("Property " + this.path + ".size not found.");
        }
        C5680i c5680iS = C5685n.s(0, Integer.parseInt(str));
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            String str2 = this.map.get(MapApplicationConfigKt.combine(this.path, ((M) it).nextInt()));
            p.f(str2);
            arrayList.add(str2);
        }
        return arrayList;
    }

    @Override // io.ktor.server.config.ApplicationConfigValue
    public Map<String, Object> getMap() {
        return new MapApplicationConfig(this.map, this.path).toMap();
    }

    @Override // io.ktor.server.config.ApplicationConfigValue
    public String getString() {
        String str = this.map.get(this.path);
        p.f(str);
        return str;
    }

    @Override // io.ktor.server.config.ApplicationConfigValue
    public ApplicationConfigValue.Type getType() {
        return (ApplicationConfigValue.Type) this.type.getValue();
    }
}
