package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u00028\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0080\u0004¢\u0006\u0002\u0010\nR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006@\u0006X\u0087\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/internal/MutableSoftReference;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "reference", "Ljava/lang/ref/SoftReference;", "getOrSetWithLock", "factory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
final class MutableSoftReference<T> {
    public volatile SoftReference<T> reference = new SoftReference<>(null);

    public final synchronized T getOrSetWithLock(p5.a factory) {
        p.e(factory, "factory");
        T t8 = this.reference.get();
        if (t8 != null) {
            return t8;
        }
        T t9 = (T) factory.invoke();
        this.reference = new SoftReference<>(t9);
        return t9;
    }
}
