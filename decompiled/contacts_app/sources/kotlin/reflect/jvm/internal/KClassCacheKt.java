package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;

/* JADX INFO: compiled from: kClassCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0000\"*\u0010\u0000\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", ExifInterface.GPS_DIRECTION_TRUE, "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KClassCacheKt {
    private static HashPMap<String, Object> K_CLASS_CACHE;

    static {
        HashPMap<String, Object> r0 = HashPMap.empty();
        Intrinsics.checkNotNullExpressionValue(r0, "empty<String, Any>()");
        K_CLASS_CACHE = r0;
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> r9) {
        Intrinsics.checkNotNullParameter(r9, "jClass");
        String r0 = r9.getName();
        Object r1 = K_CLASS_CACHE.get(r0);
        Class<T> r3 = null;
        if ((r1 instanceof WeakReference) == false) goto L10;
        KClassImpl<T> r2 = (KClassImpl) ((WeakReference) r1).get();
        if (r2 == null) goto L8;
        r3 = r2.getJClass();
    L8:
        if (Intrinsics.areEqual(r3, r9) == false) goto L23;
        return r2;
    L23:
        KClassImpl<T> r4 = new KClassImpl(r9);
        HashPMap<String, Object> r10 = K_CLASS_CACHE.plus(r0, new WeakReference(r4));
        Intrinsics.checkNotNullExpressionValue(r10, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        K_CLASS_CACHE = r10;
        return r4;
    L10:
        if (r1 == null) goto L23;
        WeakReference[] r5 = (WeakReference[]) r1;
        int r6 = r5.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L21;
        KClassImpl<T> r8 = (KClassImpl) r5[r7].get();
        if (r8 == null) goto L16;
        Class<T> r11 = r8.getJClass();
    L18:
        if (Intrinsics.areEqual(r11, r9) == true) goto L19;
        r7 = r7 + 1;
        goto L12
    L19:
        return r8;
    L16:
        r11 = null;
        goto L18
    L21:
        int r12 = ((Object[]) r1).length;
        WeakReference[] r13 = new WeakReference[r12 + 1];
        System.arraycopy(r1, 0, r13, 0, r12);
        KClassImpl<T> r14 = new KClassImpl(r9);
        r13[r12] = new WeakReference(r14);
        HashPMap<String, Object> r15 = K_CLASS_CACHE.plus(r0, r13);
        Intrinsics.checkNotNullExpressionValue(r15, "K_CLASS_CACHE.plus(name, newArray)");
        K_CLASS_CACHE = r15;
        return r14;
    }

    public static final void clearKClassCache() {
        HashPMap<String, Object> r0 = HashPMap.empty();
        Intrinsics.checkNotNullExpressionValue(r0, "empty()");
        K_CLASS_CACHE = r0;
    }
}
