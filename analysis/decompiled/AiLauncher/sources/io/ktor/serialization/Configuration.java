package io.ktor.serialization;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J?\u0010\n\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lio/ktor/serialization/Configuration;", "", "Lio/ktor/serialization/ContentConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/http/ContentType;", "contentType", "converter", "Lkotlin/Function1;", "LY8/t;", "configuration", "register", "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lp9/l;)V", "ktor-serialization"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Configuration {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void register$default(Configuration configuration, ContentType contentType, ContentConverter contentConverter, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.serialization.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return Configuration.register$lambda$0((ContentConverter) obj2);
                }
            };
        }
        configuration.register(contentType, contentConverter, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static t register$lambda$0(ContentConverter contentConverter) {
        p.i(contentConverter, "<this>");
        return t.f7040a;
    }

    <T extends ContentConverter> void register(ContentType contentType, T converter, InterfaceC5074l<? super T, t> configuration);
}
