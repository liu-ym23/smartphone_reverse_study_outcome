package com.bytedance.android.livesdkapi.util;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u0002H\u0003*\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\u001a:\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\u0006*\u0002H\u0007*\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0004\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u0002H\u0003*\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\t\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0003\"\b\b\u0001\u0010\u0002*\u0002H\u0003*\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001¨\u0006\u000b"}, d2 = {"castElementType", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "K", "RV", "V", "castMutableElementType", "", "castToMutableElementType", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class KotlinTypeUtilsKt {
    public static final <T, R extends T> List<R> castElementType(List<? extends T> r100) {
        if ((r100 instanceof List) == true) goto L5;
        r100 = (List<R>) null;
    L5:
        if (r100 == null) goto L7;
        return (List<R>) r100;
    L7:
        return CollectionsKt.emptyList();
    }

    public static final <T, R extends T> List<R> castMutableElementType(List<T> r100) {
        List<R> r101 = TypeIntrinsics.asMutableList(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new ArrayList();
    }

    public static final <T, R extends T> List<R> castToMutableElementType(List<? extends T> r100) {
        if (r100 == null) goto L6;
        List<R> r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new ArrayList();
    }

    public static final <K, V, RV extends V> Map<K, RV> castElementType(Map<K, ? extends V> r100) {
        if ((r100 instanceof Map) == true) goto L5;
        r100 = (Map<K, RV>) null;
    L5:
        if (r100 == null) goto L7;
        return (Map<K, RV>) r100;
    L7:
        return MapsKt.emptyMap();
    }
}
