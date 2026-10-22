package io.ktor.utils.io;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0005\u001a\u00020\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006*\u0010\b\u0007\u0010\t\"\u00020\u00072\u00020\u0007B\u0002\b\b¨\u0006\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/utils/io/JvmSerializer;", "serializer", UxipConstants.f30680s, "JvmSerializerReplacement", "(Lio/ktor/utils/io/JvmSerializer;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/io/Serializable;", "Lio/ktor/utils/io/InternalAPI;", "JvmSerializable", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JvmSerializable_jvmKt {
    @InternalAPI
    public static /* synthetic */ void JvmSerializable$annotations() {
    }

    @InternalAPI
    public static final <T> Object JvmSerializerReplacement(JvmSerializer<T> serializer, T value) {
        p.i(serializer, "serializer");
        p.i(value, "value");
        return new DefaultJvmSerializerReplacement(serializer, value);
    }
}
