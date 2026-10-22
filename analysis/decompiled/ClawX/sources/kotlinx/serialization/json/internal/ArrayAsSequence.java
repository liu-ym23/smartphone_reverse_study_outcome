package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0096\u0082\u0004J\u001a\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0086\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0086\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0015H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\tX\u0096\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/ArrayAsSequence;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "buffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "([C)V", "getBuffer$kotlinx_serialization_json", "()[C", "length", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getLength", "()I", "setLength", "(I)V", "get", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "index", "subSequence", "startIndex", "endIndex", "substring", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "trim", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "newSize", "toString", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArrayAsSequence implements CharSequence {
    private final char[] buffer;
    private int length;

    public ArrayAsSequence(char[] buffer) {
        p.e(buffer, "buffer");
        this.buffer = buffer;
        this.length = buffer.length;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i8) {
        return get(i8);
    }

    public char get(int index) {
        return this.buffer[index];
    }

    /* renamed from: getBuffer$kotlinx_serialization_json, reason: from getter */
    public final char[] getBuffer() {
        return this.buffer;
    }

    public int getLength() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public void setLength(int i8) {
        this.length = i8;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return u.U0(this.buffer, startIndex, Math.min(endIndex, length()));
    }

    public final String substring(int startIndex, int endIndex) {
        return u.U0(this.buffer, startIndex, Math.min(endIndex, length()));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return substring(0, length());
    }

    public final void trim(int newSize) {
        setLength(Math.min(this.buffer.length, newSize));
    }
}
