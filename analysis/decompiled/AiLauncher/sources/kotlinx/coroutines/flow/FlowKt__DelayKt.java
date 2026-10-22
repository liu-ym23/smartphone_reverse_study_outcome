package kotlinx.coroutines.flow;

import Xa.b;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "", "timeoutMillis", Const.INTENT_KEY_PKGNAME, "(LXa/b;J)LXa/b;", "Lkotlin/Function1;", "timeoutMillisSelector", Const.INTENT_KEY_UMID, "(LXa/b;Lp9/l;)LXa/b;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> b(b<? extends T> bVar, final long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? bVar : d(bVar, new InterfaceC5074l() { // from class: Xa.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Long.valueOf(FlowKt__DelayKt.c(j10, obj));
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    public static final long c(long j10, Object obj) {
        return j10;
    }

    public static final <T> b<T> d(b<? extends T> bVar, InterfaceC5074l<? super T, Long> interfaceC5074l) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(interfaceC5074l, bVar, null));
    }
}
