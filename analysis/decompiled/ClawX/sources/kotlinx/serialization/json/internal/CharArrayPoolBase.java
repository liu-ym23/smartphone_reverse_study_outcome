package kotlinx.serialization.json.internal;

import c5.j;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0084\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0084\u0080\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/json/internal/CharArrayPoolBase;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "arrays", "Lkotlin/collections/ArrayDeque;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "charsTotal", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "take", "size", "releaseImpl", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "array", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public class CharArrayPoolBase {
    private final j arrays = new j();
    private int charsTotal;

    public final void releaseImpl(char[] array) {
        p.e(array, "array");
        synchronized (this) {
            if (this.charsTotal + array.length < ArrayPoolsKt.MAX_CHARS_IN_POOL) {
                this.charsTotal += array.length;
                this.arrays.addLast(array);
            }
        }
    }

    public final char[] take(int size) {
        char[] cArr;
        synchronized (this) {
            j jVar = this.arrays;
            cArr = null;
            char[] cArr2 = (char[]) (jVar.isEmpty() ? null : jVar.removeLast());
            if (cArr2 != null) {
                this.charsTotal -= cArr2.length;
                cArr = cArr2;
            }
        }
        return cArr == null ? new char[size] : cArr;
    }
}
