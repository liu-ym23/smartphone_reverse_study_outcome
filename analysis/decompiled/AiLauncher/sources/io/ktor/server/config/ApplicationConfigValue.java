package io.ktor.server.config;

import h9.InterfaceC4149a;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\f\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/server/config/ApplicationConfigValue;", "", "", "getString", "()Ljava/lang/String;", "", "getList", "()Ljava/util/List;", "", "getMap", "()Ljava/util/Map;", "Lio/ktor/util/reflect/TypeInfo;", "type", "getAs", "(Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "Lio/ktor/server/config/ApplicationConfigValue$Type;", "getType", "()Lio/ktor/server/config/ApplicationConfigValue$Type;", "Type", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ApplicationConfigValue {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/ktor/server/config/ApplicationConfigValue$Type;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "SINGLE", "LIST", "OBJECT", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type NULL = new Type("NULL", 0);
        public static final Type SINGLE = new Type("SINGLE", 1);
        public static final Type LIST = new Type("LIST", 2);
        public static final Type OBJECT = new Type("OBJECT", 3);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{NULL, SINGLE, LIST, OBJECT};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = kotlin.enums.a.a(typeArr$values);
        }

        private Type(String str, int i10) {
        }

        public static InterfaceC4149a<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    Object getAs(TypeInfo type);

    List<String> getList();

    Map<String, Object> getMap();

    String getString();

    Type getType();
}
