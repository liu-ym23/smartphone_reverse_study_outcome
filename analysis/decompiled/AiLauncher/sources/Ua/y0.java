package Ua;

import ab.C1278a;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"LUa/y0;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/S;", "Lkotlin/coroutines/d;", "parentContext", "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "", "block", "<init>", "(Lkotlin/coroutines/d;Lp9/p;)V", "LY8/t;", "z0", "()V", Const.INTENT_KEY_UMID, "Le9/c;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class y0<T> extends S<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4014c<Y8.t> continuation;

    public y0(kotlin.coroutines.d dVar, p9.p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) {
        super(dVar, false);
        this.continuation = IntrinsicsKt__IntrinsicsJvmKt.b(pVar, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void z0() throws Throwable {
        C1278a.b(this.continuation, this);
    }
}
