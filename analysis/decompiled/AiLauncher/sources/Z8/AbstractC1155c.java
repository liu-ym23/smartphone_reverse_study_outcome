package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014¨\u0006\u0016"}, d2 = {"LZ8/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_APIKEY, UxipConstants.f30680s, "c", "(Ljava/lang/Object;)V", Const.INTENT_KEY_PKGNAME, "e", "", "I", VoiceWakeupReceiver.EXTRA_STATE, "Ljava/lang/Object;", "nextValue", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Z8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1155c<T> implements Iterator<T>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public T nextValue;

    public abstract void a();

    public final void b() {
        this.state = 2;
    }

    public final void c(T value) {
        this.nextValue = value;
        this.state = 1;
    }

    public final boolean e() {
        this.state = 3;
        a();
        return this.state == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i10 = this.state;
        if (i10 == 0) {
            return e();
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public T next() {
        int i10 = this.state;
        if (i10 == 1) {
            this.state = 0;
            return this.nextValue;
        }
        if (i10 == 2 || !e()) {
            throw new NoSuchElementException();
        }
        this.state = 0;
        return this.nextValue;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
