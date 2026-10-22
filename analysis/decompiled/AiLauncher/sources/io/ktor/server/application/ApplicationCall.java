package io.ktor.server.application;

import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import io.ktor.http.Parameters;
import io.ktor.server.request.ApplicationRequest;
import io.ktor.server.response.ApplicationResponse;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "LUa/M;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "receiveNullable", "(Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "", "message", "LY8/t;", "respond", "(Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/server/request/ApplicationRequest;", "getRequest", "()Lio/ktor/server/request/ApplicationRequest;", "request", "Lio/ktor/server/response/ApplicationResponse;", "getResponse", "()Lio/ktor/server/response/ApplicationResponse;", UxipConstants.f30685x, "Lio/ktor/server/application/Application;", "getApplication", "()Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "parameters", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ApplicationCall extends M {
    Application getApplication();

    Attributes getAttributes();

    @Override // Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    Parameters getParameters();

    ApplicationRequest getRequest();

    ApplicationResponse getResponse();

    <T> Object receiveNullable(TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c);

    Object respond(Object obj, TypeInfo typeInfo, InterfaceC4014c<? super t> interfaceC4014c);
}
