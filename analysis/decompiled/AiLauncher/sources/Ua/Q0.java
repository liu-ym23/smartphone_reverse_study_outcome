package Ua;

import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LUa/Q0;", "U", ExifInterface.GPS_DIRECTION_TRUE, "LZa/y;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "time", "Le9/c;", "uCont", "<init>", "(JLe9/c;)V", "LY8/t;", "run", "()V", "", "r0", "()Ljava/lang/String;", "e", "J", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Q0<U, T extends U> extends Za.y<T> implements Runnable {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final long time;

    public Q0(long j10, InterfaceC4014c<? super U> interfaceC4014c) {
        super(interfaceC4014c.getContext(), interfaceC4014c);
        this.time = j10;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport
    public String r0() {
        return super.r0() + "(timeMillis=" + this.time + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        T tC = U.c(getContext());
        CoroutineName coroutineName = (CoroutineName) getContext().get(CoroutineName.INSTANCE);
        F(TimeoutKt.a(this.time, tC, this, coroutineName != null ? coroutineName.getName() : null));
    }
}
