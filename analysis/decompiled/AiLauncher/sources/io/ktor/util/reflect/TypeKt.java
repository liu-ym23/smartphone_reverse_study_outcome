package io.ktor.util.reflect;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import lb.u;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004*\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001a\u0010\t\u001a\u0004\u0018\u00010\b\"\u0006\b\u0000\u0010\u0000\u0018\u0001H\u0081\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "()Lio/ktor/util/reflect/TypeInfo;", "Lkotlinx/serialization/KSerializer;", "", "serializer", "(Lio/ktor/util/reflect/TypeInfo;)Lkotlinx/serialization/KSerializer;", "Lw9/n;", "typeOfOrNull", "()Lw9/n;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TypeKt {
    @InternalAPI
    public static final KSerializer<? extends Object> serializer(TypeInfo typeInfo) {
        KSerializer<? extends Object> kSerializerD;
        p.i(typeInfo, "<this>");
        InterfaceC5755n kotlinType = typeInfo.getKotlinType();
        return (kotlinType == null || (kSerializerD = u.d(kotlinType)) == null) ? u.c(typeInfo.getType()) : kSerializerD;
    }

    public static final /* synthetic */ <T> TypeInfo typeInfo() {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        return new TypeInfo(interfaceC5745dB, null);
    }

    public static final /* synthetic */ <T> InterfaceC5755n typeOfOrNull() {
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        return null;
    }
}
