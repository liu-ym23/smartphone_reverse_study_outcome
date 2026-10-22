package kotlin.enums;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u0010*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00060\u0003j\u0002`\u0004:\u0001\rB\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/enums/EnumEntriesSerializationProxy;", "", ExifInterface.LONGITUDE_EAST, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "entries", "<init>", "([Ljava/lang/Enum;)V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/lang/Class;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Class;", "c", Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Class<E> c;

    public EnumEntriesSerializationProxy(E[] entries) {
        p.i(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        p.f(cls);
        this.c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.c.getEnumConstants();
        p.h(enumConstants, "getEnumConstants(...)");
        return a.a(enumConstants);
    }
}
