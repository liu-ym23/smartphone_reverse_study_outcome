package io.ktor.server.config;

import Z8.C1174w;
import Z8.F;
import b8.InterfaceC1455a;
import com.typesafe.config.ConfigValueType;
import io.ktor.server.config.ApplicationConfigValue;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/ktor/server/config/HoconApplicationConfig;", "Lio/ktor/server/config/ApplicationConfig;", "Lb8/a;", "config", "<init>", "(Lb8/a;)V", "", "path", "Lio/ktor/server/config/ApplicationConfigValue;", "property", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfigValue;", "propertyOrNull", "", "configList", "(Ljava/lang/String;)Ljava/util/List;", "(Ljava/lang/String;)Lio/ktor/server/config/ApplicationConfig;", "", "keys", "()Ljava/util/Set;", "", "", "toMap", "()Ljava/util/Map;", "Lb8/a;", "HoconApplicationConfigValue", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class HoconApplicationConfig implements ApplicationConfig {
    private final InterfaceC1455a config;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u001a\u0010\u0012\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/server/config/HoconApplicationConfig$HoconApplicationConfigValue;", "Lio/ktor/server/config/ApplicationConfigValue;", "Lb8/a;", "config", "", "path", "<init>", "(Lb8/a;Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "", "getList", "()Ljava/util/List;", "", "", "getMap", "()Ljava/util/Map;", "Lio/ktor/util/reflect/TypeInfo;", "type", "getAs", "(Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "Lb8/a;", "getConfig", "()Lb8/a;", "Ljava/lang/String;", "getPath", "Lio/ktor/server/config/ApplicationConfigValue$Type;", "Lio/ktor/server/config/ApplicationConfigValue$Type;", "getType", "()Lio/ktor/server/config/ApplicationConfigValue$Type;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HoconApplicationConfigValue implements ApplicationConfigValue {
        private final InterfaceC1455a config;
        private final String path;
        private final ApplicationConfigValue.Type type;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ConfigValueType.values().length];
                try {
                    iArr[ConfigValueType.STRING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ConfigValueType.NUMBER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ConfigValueType.BOOLEAN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ConfigValueType.NULL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ConfigValueType.LIST.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ConfigValueType.OBJECT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public HoconApplicationConfigValue(InterfaceC1455a config, String path) {
            ApplicationConfigValue.Type type;
            p.i(config, "config");
            p.i(path, "path");
            this.config = config;
            this.path = path;
            ConfigValueType configValueTypeC = config.getValue(path).c();
            switch (configValueTypeC == null ? -1 : WhenMappings.$EnumSwitchMapping$0[configValueTypeC.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    type = ApplicationConfigValue.Type.SINGLE;
                    break;
                case 4:
                    type = ApplicationConfigValue.Type.NULL;
                    break;
                case 5:
                    type = ApplicationConfigValue.Type.LIST;
                    break;
                case 6:
                    type = ApplicationConfigValue.Type.OBJECT;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.type = type;
        }

        @Override // io.ktor.server.config.ApplicationConfigValue
        public Object getAs(TypeInfo type) {
            p.i(type, "type");
            return TypeKt.serializer(type).deserialize(new HoconDecoder(this.config, this.path, null, 4, null));
        }

        public final InterfaceC1455a getConfig() {
            return this.config;
        }

        @Override // io.ktor.server.config.ApplicationConfigValue
        public List<String> getList() {
            List<String> listM = this.config.m(this.path);
            p.h(listM, "getStringList(...)");
            return listM;
        }

        @Override // io.ktor.server.config.ApplicationConfigValue
        public Map<String, Object> getMap() {
            Map<String, Object> mapA = this.config.z(this.path).a();
            p.h(mapA, "unwrapped(...)");
            return mapA;
        }

        public final String getPath() {
            return this.path;
        }

        @Override // io.ktor.server.config.ApplicationConfigValue
        public String getString() {
            String strT = this.config.t(this.path);
            p.h(strT, "getString(...)");
            return strT;
        }

        @Override // io.ktor.server.config.ApplicationConfigValue
        public ApplicationConfigValue.Type getType() {
            return this.type;
        }
    }

    public HoconApplicationConfig(InterfaceC1455a config) {
        p.i(config, "config");
        this.config = config;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfig config(String path) {
        p.i(path, "path");
        InterfaceC1455a interfaceC1455aL = this.config.l(path);
        p.h(interfaceC1455aL, "getConfig(...)");
        return new HoconApplicationConfig(interfaceC1455aL);
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public List<ApplicationConfig> configList(String path) {
        p.i(path, "path");
        List<? extends InterfaceC1455a> listY = this.config.y(path);
        p.h(listY, "getConfigList(...)");
        List<? extends InterfaceC1455a> list = listY;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (InterfaceC1455a interfaceC1455a : list) {
            p.f(interfaceC1455a);
            arrayList.add(new HoconApplicationConfig(interfaceC1455a));
        }
        return arrayList;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public Set<String> keys() {
        Set<Map.Entry<String, b8.p>> setEntrySet = this.config.entrySet();
        p.h(setEntrySet, "entrySet(...)");
        Set<Map.Entry<String, b8.p>> set = setEntrySet;
        ArrayList arrayList = new ArrayList(C1174w.x(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        return F.r1(arrayList);
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfigValue property(String path) throws ApplicationConfigurationException {
        p.i(path, "path");
        if (this.config.H(path)) {
            return new HoconApplicationConfigValue(this.config, path);
        }
        throw new ApplicationConfigurationException("Property " + path + " not found.");
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public ApplicationConfigValue propertyOrNull(String path) {
        p.i(path, "path");
        if (this.config.H(path)) {
            return new HoconApplicationConfigValue(this.config, path);
        }
        return null;
    }

    @Override // io.ktor.server.config.ApplicationConfig
    public Map<String, Object> toMap() {
        Map<String, Object> mapA = this.config.K().a();
        p.h(mapA, "unwrapped(...)");
        return mapA;
    }
}
