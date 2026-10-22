package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"LKa/k;", ExifInterface.GPS_DIRECTION_TRUE, "LKa/l;", "", "Le9/c;", "LY8/t;", "<init>", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "iterator", "e", "(Ljava/util/Iterator;Le9/c;)Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "f", "()Ljava/lang/Throwable;", "", "Lkotlin/sequences/State;", "I", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "nextValue", "c", "Ljava/util/Iterator;", "nextIterator", Const.INTENT_KEY_UMID, "Le9/c;", "getNextStep", "()Le9/c;", "m", "(Le9/c;)V", "nextStep", "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k<T> extends l<T> implements Iterator<T>, InterfaceC4014c<Y8.t>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public T nextValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Iterator<? extends T> nextIterator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4014c<? super Y8.t> nextStep;

    @Override // Ka.l
    public Object a(T t10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        this.nextValue = t10;
        this.state = 3;
        this.nextStep = interfaceC4014c;
        Object objG = C4063a.g();
        if (objG == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objG == C4063a.g() ? objG : Y8.t.f7040a;
    }

    @Override // Ka.l
    public Object e(Iterator<? extends T> it, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!it.hasNext()) {
            return Y8.t.f7040a;
        }
        this.nextIterator = it;
        this.state = 2;
        this.nextStep = interfaceC4014c;
        Object objG = C4063a.g();
        if (objG == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objG == C4063a.g() ? objG : Y8.t.f7040a;
    }

    public final Throwable f() {
        int i10 = this.state;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.state);
    }

    @Override // e9.InterfaceC4014c
    public kotlin.coroutines.d getContext() {
        return EmptyCoroutineContext.f34779a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.state;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator<? extends T> it = this.nextIterator;
                kotlin.jvm.internal.p.f(it);
                if (it.hasNext()) {
                    this.state = 2;
                    return true;
                }
                this.nextIterator = null;
            }
            this.state = 5;
            InterfaceC4014c<? super Y8.t> interfaceC4014c = this.nextStep;
            kotlin.jvm.internal.p.f(interfaceC4014c);
            this.nextStep = null;
            interfaceC4014c.resumeWith(Result.b(Y8.t.f7040a));
        }
    }

    public final T i() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void m(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        this.nextStep = interfaceC4014c;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i10 = this.state;
        if (i10 == 0 || i10 == 1) {
            return i();
        }
        if (i10 == 2) {
            this.state = 1;
            Iterator<? extends T> it = this.nextIterator;
            kotlin.jvm.internal.p.f(it);
            return it.next();
        }
        if (i10 != 3) {
            throw f();
        }
        this.state = 0;
        T t10 = this.nextValue;
        this.nextValue = null;
        return t10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) throws Throwable {
        C4849c.b(result);
        this.state = 4;
    }
}
