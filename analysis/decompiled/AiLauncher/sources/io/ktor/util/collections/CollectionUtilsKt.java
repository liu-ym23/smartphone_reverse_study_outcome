package io.ktor.util.collections;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0006\"\b\b\u0001\u0010\b*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "values", "", "sharedListOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "initialCapacity", "", "sharedMap", "(I)Ljava/util/Map;", "sharedList", "()Ljava/util/List;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CollectionUtilsKt {
    public static final <V> List<V> sharedList() {
        return new ArrayList();
    }

    public static final <T> List<T> sharedListOf(T... values) {
        p.i(values, "values");
        return C1173v.s(Arrays.copyOf(values, values.length));
    }

    public static final <K, V> Map<K, V> sharedMap(int i10) {
        return new LinkedHashMap(i10);
    }

    public static /* synthetic */ Map sharedMap$default(int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8;
        }
        return sharedMap(i10);
    }
}
