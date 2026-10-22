package kotlin.enums;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/enums/EnumEntriesSerializationProxy;", "", ExifInterface.LONGITUDE_EAST, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class f4913a;

    public EnumEntriesSerializationProxy(Enum[] entries) {
        k.f(entries, "entries");
        Class<?> componentType = entries.getClass().getComponentType();
        k.c(componentType);
        this.f4913a = componentType;
    }

    private final Object readResolve() {
        Object[] enumConstants = this.f4913a.getEnumConstants();
        k.e(enumConstants, "getEnumConstants(...)");
        return a.a((Enum[]) enumConstants);
    }
}
