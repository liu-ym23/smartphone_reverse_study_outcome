package io.ktor.server.config;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.server.application.Application;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a$\u0010\u0004\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a&\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\b\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lio/ktor/server/application/Application;", "", "key", "property", "(Lio/ktor/server/application/Application;Ljava/lang/String;)Ljava/lang/Object;", "propertyOrNull", "Lio/ktor/server/config/ApplicationConfigValue;", "getAs", "(Lio/ktor/server/config/ApplicationConfigValue;)Ljava/lang/Object;", "Lio/ktor/server/config/ApplicationConfig;", "tryGetString", "(Lio/ktor/server/config/ApplicationConfig;Ljava/lang/String;)Ljava/lang/String;", "", "tryGetStringList", "(Lio/ktor/server/config/ApplicationConfig;Ljava/lang/String;)Ljava/util/List;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationConfigKt {
    public static final /* synthetic */ <E> E getAs(ApplicationConfigValue applicationConfigValue) {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nN;
        p.i(applicationConfigValue, "<this>");
        p.o(4, ExifInterface.LONGITUDE_EAST);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.LONGITUDE_EAST);
        } catch (Throwable unused) {
        }
        InterfaceC5755n interfaceC5755nO = null;
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        InterfaceC5745d interfaceC5745dB2 = t.b(String.class);
        try {
            interfaceC5755nM = t.m(String.class);
        } catch (Throwable unused2) {
            interfaceC5755nM = null;
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB2, interfaceC5755nM))) {
            E e10 = (E) applicationConfigValue.getString();
            p.o(1, ExifInterface.LONGITUDE_EAST);
            return e10;
        }
        InterfaceC5745d interfaceC5745dB3 = t.b(List.class);
        try {
            interfaceC5755nN = t.n(List.class, C5757p.INSTANCE.d(t.m(String.class)));
        } catch (Throwable unused3) {
            interfaceC5755nN = null;
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB3, interfaceC5755nN))) {
            E e11 = (E) applicationConfigValue.getList();
            p.o(1, ExifInterface.LONGITUDE_EAST);
            return e11;
        }
        InterfaceC5745d interfaceC5745dB4 = t.b(Map.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nO = t.o(Map.class, companion.d(t.m(String.class)), companion.d(t.g(Object.class)));
        } catch (Throwable unused4) {
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB4, interfaceC5755nO))) {
            E e12 = (E) applicationConfigValue.getMap();
            p.o(1, ExifInterface.LONGITUDE_EAST);
            return e12;
        }
        E e13 = (E) applicationConfigValue.getAs(typeInfo);
        p.o(1, ExifInterface.LONGITUDE_EAST);
        return e13;
    }

    public static final /* synthetic */ <E> E property(Application application, String key) {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nN;
        p.i(application, "<this>");
        p.i(key, "key");
        ApplicationConfigValue applicationConfigValueProperty = application.getEnvironment().getConfig().property(key);
        p.o(4, ExifInterface.LONGITUDE_EAST);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.LONGITUDE_EAST);
        } catch (Throwable unused) {
        }
        InterfaceC5755n interfaceC5755nO = null;
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        InterfaceC5745d interfaceC5745dB2 = t.b(String.class);
        try {
            interfaceC5755nM = t.m(String.class);
        } catch (Throwable unused2) {
            interfaceC5755nM = null;
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB2, interfaceC5755nM))) {
            E e10 = (E) applicationConfigValueProperty.getString();
            p.o(1, ExifInterface.LONGITUDE_EAST);
            return e10;
        }
        InterfaceC5745d interfaceC5745dB3 = t.b(List.class);
        try {
            interfaceC5755nN = t.n(List.class, C5757p.INSTANCE.d(t.m(String.class)));
        } catch (Throwable unused3) {
            interfaceC5755nN = null;
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB3, interfaceC5755nN))) {
            E e11 = (E) applicationConfigValueProperty.getList();
            p.o(1, ExifInterface.LONGITUDE_EAST);
            return e11;
        }
        InterfaceC5745d interfaceC5745dB4 = t.b(Map.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nO = t.o(Map.class, companion.d(t.m(String.class)), companion.d(t.g(Object.class)));
        } catch (Throwable unused4) {
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB4, interfaceC5755nO))) {
            E e12 = (E) applicationConfigValueProperty.getMap();
            p.o(1, ExifInterface.LONGITUDE_EAST);
            return e12;
        }
        E e13 = (E) applicationConfigValueProperty.getAs(typeInfo);
        p.o(1, ExifInterface.LONGITUDE_EAST);
        return e13;
    }

    public static final /* synthetic */ <E> E propertyOrNull(Application application, String key) {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nN;
        p.i(application, "<this>");
        p.i(key, "key");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = application.getEnvironment().getConfig().propertyOrNull(key);
        InterfaceC5755n interfaceC5755nO = null;
        if (applicationConfigValuePropertyOrNull == null) {
            return null;
        }
        p.o(4, "E?");
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, "E?");
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        InterfaceC5745d interfaceC5745dB2 = t.b(String.class);
        try {
            interfaceC5755nM = t.m(String.class);
        } catch (Throwable unused2) {
            interfaceC5755nM = null;
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB2, interfaceC5755nM))) {
            E e10 = (E) applicationConfigValuePropertyOrNull.getString();
            p.o(1, "E?");
            return e10;
        }
        InterfaceC5745d interfaceC5745dB3 = t.b(List.class);
        try {
            interfaceC5755nN = t.n(List.class, C5757p.INSTANCE.d(t.m(String.class)));
        } catch (Throwable unused3) {
            interfaceC5755nN = null;
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB3, interfaceC5755nN))) {
            E e11 = (E) applicationConfigValuePropertyOrNull.getList();
            p.o(1, "E?");
            return e11;
        }
        InterfaceC5745d interfaceC5745dB4 = t.b(Map.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nO = t.o(Map.class, companion.d(t.m(String.class)), companion.d(t.g(Object.class)));
        } catch (Throwable unused4) {
        }
        if (p.d(typeInfo, new TypeInfo(interfaceC5745dB4, interfaceC5755nO))) {
            E e12 = (E) applicationConfigValuePropertyOrNull.getMap();
            p.o(1, "E?");
            return e12;
        }
        E e13 = (E) applicationConfigValuePropertyOrNull.getAs(typeInfo);
        p.o(1, "E?");
        return e13;
    }

    public static final String tryGetString(ApplicationConfig applicationConfig, String key) {
        p.i(applicationConfig, "<this>");
        p.i(key, "key");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = applicationConfig.propertyOrNull(key);
        if (applicationConfigValuePropertyOrNull != null) {
            return applicationConfigValuePropertyOrNull.getString();
        }
        return null;
    }

    public static final List<String> tryGetStringList(ApplicationConfig applicationConfig, String key) {
        p.i(applicationConfig, "<this>");
        p.i(key, "key");
        ApplicationConfigValue applicationConfigValuePropertyOrNull = applicationConfig.propertyOrNull(key);
        if (applicationConfigValuePropertyOrNull != null) {
            return applicationConfigValuePropertyOrNull.getList();
        }
        return null;
    }
}
