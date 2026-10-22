package io.ktor.util;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.util.reflect.TypeInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b*\u001e\b\u0007\u0010\f\u001a\u0004\b\u0000\u0010\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0004¨\u0006\r"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "Lio/ktor/util/AttributeKey;", "AttributeKey", "(Ljava/lang/String;)Lio/ktor/util/AttributeKey;", "Lio/ktor/util/Attributes;", "other", "LY8/t;", "putAll", "(Lio/ktor/util/Attributes;Lio/ktor/util/Attributes;)V", "EquatableAttributeKey", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttributesKt {
    public static final /* synthetic */ <T> AttributeKey<T> AttributeKey(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        return new AttributeKey<>(name, new TypeInfo(interfaceC5745dB, null));
    }

    public static /* synthetic */ void EquatableAttributeKey$annotations() {
    }

    public static final void putAll(Attributes attributes, Attributes other) {
        kotlin.jvm.internal.p.i(attributes, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        Iterator<T> it = other.getAllKeys().iterator();
        while (it.hasNext()) {
            AttributeKey attributeKey = (AttributeKey) it.next();
            kotlin.jvm.internal.p.g(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            attributes.put(attributeKey, other.get(attributeKey));
        }
    }
}
