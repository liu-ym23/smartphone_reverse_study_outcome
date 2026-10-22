package Qa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u00020\r2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\r2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0006J\r\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0014J\u001d\u0010\u001a\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0006J\u0010\u0010\u001d\u001a\u00020\u0012H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u0014R4\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\"R\"\u0010\f\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"LQa/u;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "", "buffer", "", "dataSize", "index", "LY8/t;", "l", "([Ljava/lang/Object;II)V", "k", "([Ljava/lang/Object;I)V", "", "f", "()Z", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, "LQa/t;", Const.INTENT_KEY_PKGNAME, "()LQa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "hasNext", UxipConstants.f30680s, "[Ljava/lang/Object;", "c", "()[Ljava/lang/Object;", "I", "e", "()I", "m", "(I)V", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class u<K, V, T> implements Iterator<T>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Object[] buffer = t.INSTANCE.a().getBuffer();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int dataSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int index;

    public final K a() {
        Ta.a.a(f());
        return (K) this.buffer[this.index];
    }

    public final t<? extends K, ? extends V> b() {
        Ta.a.a(g());
        Object obj = this.buffer[this.index];
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (t) obj;
    }

    /* renamed from: c, reason: from getter */
    public final Object[] getBuffer() {
        return this.buffer;
    }

    /* renamed from: e, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final boolean f() {
        return this.index < this.dataSize;
    }

    public final boolean g() {
        Ta.a.a(this.index >= this.dataSize);
        return this.index < this.buffer.length;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return f();
    }

    public final void i() {
        Ta.a.a(f());
        this.index += 2;
    }

    public final void j() {
        Ta.a.a(g());
        this.index++;
    }

    public final void k(Object[] buffer, int dataSize) {
        kotlin.jvm.internal.p.i(buffer, "buffer");
        l(buffer, dataSize, 0);
    }

    public final void l(Object[] buffer, int dataSize, int index) {
        kotlin.jvm.internal.p.i(buffer, "buffer");
        this.buffer = buffer;
        this.dataSize = dataSize;
        this.index = index;
    }

    public final void m(int i10) {
        this.index = i10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
