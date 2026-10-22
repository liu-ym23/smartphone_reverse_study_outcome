package kotlin;

import Y8.h;
import Y8.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.Serializable;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B!\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\f¨\u0006\u001b"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", ExifInterface.GPS_DIRECTION_TRUE, "LY8/h;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Lkotlin/Function0;", "initializer", "", "lock", "<init>", "(Lp9/a;Ljava/lang/Object;)V", "writeReplace", "()Ljava/lang/Object;", "", "isInitialized", "()Z", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lp9/a;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "_value", "c", "getValue", UxipConstants.f30680s, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SynchronizedLazyImpl<T> implements h<T>, Serializable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<? extends T> initializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile Object _value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    public SynchronizedLazyImpl(InterfaceC5063a<? extends T> initializer, Object obj) {
        p.i(initializer, "initializer");
        this.initializer = initializer;
        this._value = q.f7034a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // Y8.h
    public T getValue() {
        T tInvoke;
        T t10 = (T) this._value;
        q qVar = q.f7034a;
        if (t10 != qVar) {
            return t10;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == qVar) {
                InterfaceC5063a<? extends T> interfaceC5063a = this.initializer;
                p.f(interfaceC5063a);
                tInvoke = interfaceC5063a.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // Y8.h
    public boolean isInitialized() {
        return this._value != q.f7034a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(InterfaceC5063a interfaceC5063a, Object obj, int i10, i iVar) {
        this(interfaceC5063a, (i10 & 2) != 0 ? null : obj);
    }
}
