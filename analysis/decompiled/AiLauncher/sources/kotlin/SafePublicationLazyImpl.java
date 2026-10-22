package kotlin;

import Y8.h;
import Y8.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.MultiFilesBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0002\u0018\u0000 \"*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0017B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u0012\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lkotlin/SafePublicationLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LY8/h;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Lkotlin/Function0;", "initializer", "<init>", "(Lp9/a;)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "", "isInitialized", "()Z", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lp9/a;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "_value", "c", "getFinal$annotations", "()V", MultiFilesBundle.EVENT_FINAL, "getValue", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SafePublicationLazyImpl<T> implements h<T>, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f34694e = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, Const.INTENT_KEY_PKGNAME);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public volatile InterfaceC5063a<? extends T> initializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile Object _value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object final;

    public SafePublicationLazyImpl(InterfaceC5063a<? extends T> initializer) {
        p.i(initializer, "initializer");
        this.initializer = initializer;
        q qVar = q.f7034a;
        this._value = qVar;
        this.final = qVar;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // Y8.h
    public T getValue() {
        T t10 = (T) this._value;
        q qVar = q.f7034a;
        if (t10 != qVar) {
            return t10;
        }
        InterfaceC5063a<? extends T> interfaceC5063a = this.initializer;
        if (interfaceC5063a != null) {
            T tInvoke = interfaceC5063a.invoke();
            if (f34694e.compareAndSet(this, qVar, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
        }
        return (T) this._value;
    }

    @Override // Y8.h
    public boolean isInitialized() {
        return this._value != q.f7034a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
