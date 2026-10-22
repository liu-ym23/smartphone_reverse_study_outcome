package io.ktor.client.call;

import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086H¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0004H\u0086H¢\u0006\u0004\b\u0002\u0010\u0005\u001a\"\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/call/HttpClientCall;", "body", "(Lio/ktor/client/call/HttpClientCall;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "(Lio/ktor/client/statement/HttpResponse;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientCallKt {
    public static final /* synthetic */ <T> Object body(HttpResponse httpResponse, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        HttpClientCall call = httpResponse.getCall();
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objBodyNullable = call.bodyNullable(typeInfo, interfaceC4014c);
        n.c(1);
        p.o(1, ExifInterface.GPS_DIRECTION_TRUE);
        return objBodyNullable;
    }

    public static final <T> Object body(HttpResponse httpResponse, TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        Object objBodyNullable = httpResponse.getCall().bodyNullable(typeInfo, interfaceC4014c);
        C4063a.g();
        return objBodyNullable;
    }

    public static final /* synthetic */ <T> Object body(HttpClientCall httpClientCall, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        Object objBodyNullable = httpClientCall.bodyNullable(typeInfo, interfaceC4014c);
        n.c(1);
        p.o(1, ExifInterface.GPS_DIRECTION_TRUE);
        return objBodyNullable;
    }
}
