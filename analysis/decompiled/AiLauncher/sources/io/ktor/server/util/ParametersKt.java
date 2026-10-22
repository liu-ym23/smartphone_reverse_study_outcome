package io.ktor.server.util;

import io.ktor.http.Parameters;
import io.ktor.server.plugins.MissingRequestParameterException;
import io.ktor.server.plugins.ParameterConversionException;
import io.ktor.util.converters.DefaultConversionService;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a(\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\n\u0010\f\u001a-\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "R", "Lio/ktor/http/Parameters;", "thisRef", "Lw9/k;", "property", "getValue", "(Lio/ktor/http/Parameters;Ljava/lang/Object;Lw9/k;)Ljava/lang/Object;", "", "name", "getOrFail", "(Lio/ktor/http/Parameters;Ljava/lang/String;)Ljava/lang/String;", "(Lio/ktor/http/Parameters;Ljava/lang/String;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "getOrFailImpl", "(Lio/ktor/http/Parameters;Ljava/lang/String;Lio/ktor/util/reflect/TypeInfo;)Ljava/lang/Object;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ParametersKt {
    /* renamed from: getOrFail, reason: collision with other method in class */
    public static final String m180getOrFail(Parameters parameters, String name) throws MissingRequestParameterException {
        p.i(parameters, "<this>");
        p.i(name, "name");
        String str = parameters.get(name);
        if (str != null) {
            return str;
        }
        throw new MissingRequestParameterException(name);
    }

    public static final <R> R getOrFailImpl(Parameters parameters, String name, TypeInfo typeInfo) throws MissingRequestParameterException, ParameterConversionException {
        p.i(parameters, "<this>");
        p.i(name, "name");
        p.i(typeInfo, "typeInfo");
        List<String> all = parameters.getAll(name);
        if (all == null) {
            throw new MissingRequestParameterException(name);
        }
        try {
            R r10 = (R) DefaultConversionService.INSTANCE.fromValues(all, typeInfo);
            p.g(r10, "null cannot be cast to non-null type R of io.ktor.server.util.ParametersKt.getOrFailImpl");
            return r10;
        } catch (Exception e10) {
            String strT = typeInfo.getType().t();
            if (strT == null) {
                strT = typeInfo.getType().toString();
            }
            throw new ParameterConversionException(name, strT, e10);
        }
    }

    public static final /* synthetic */ <R> R getValue(Parameters parameters, Object obj, InterfaceC5752k<?> property) {
        p.i(parameters, "<this>");
        p.i(property, "property");
        String name = property.getName();
        p.o(4, "R");
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, "R");
        } catch (Throwable unused) {
        }
        return (R) getOrFailImpl(parameters, name, new TypeInfo(interfaceC5745dB, null));
    }

    public static final /* synthetic */ <R> R getOrFail(Parameters parameters, String name) {
        p.i(parameters, "<this>");
        p.i(name, "name");
        p.o(4, "R");
        InterfaceC5745d interfaceC5745dB = t.b(Object.class);
        try {
            p.o(6, "R");
        } catch (Throwable unused) {
        }
        return (R) getOrFailImpl(parameters, name, new TypeInfo(interfaceC5745dB, null));
    }
}
