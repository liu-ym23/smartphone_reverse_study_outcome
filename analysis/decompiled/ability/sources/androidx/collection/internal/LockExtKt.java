package androidx.collection.internal;

import S7.a;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/internal/Lock;", "Lkotlin/Function0;", "block", "synchronized", "(Landroidx/collection/internal/Lock;LS7/a;)Ljava/lang/Object;", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LockExtKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m34synchronized(Lock lock, a block) {
        T t9;
        k.f(lock, "<this>");
        k.f(block, "block");
        synchronized (lock) {
            t9 = (T) block.invoke();
        }
        return t9;
    }
}
