package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Xa.d;
import Y8.t;
import Z8.r;
import Za.D;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0005\"\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a[\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u00022.\u0010\u000f\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aO\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\" \u0010\u001b\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Iterable;)LXa/b;", "", "flows", "c", "([LXa/b;)LXa/b;", "R", "Lkotlin/Function3;", "LXa/c;", "Le9/c;", "LY8/t;", "", "transform", Const.INTENT_KEY_UMID, "(LXa/b;Lp9/q;)LXa/b;", "Lkotlin/Function2;", Const.INTENT_KEY_APIKEY, "(LXa/b;Lp9/p;)LXa/b;", "", "I", "getDEFAULT_CONCURRENCY", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36487a = D.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    public static final <T, R> b<R> a(b<? extends T> bVar, p<? super T, ? super InterfaceC4014c<? super R>, ? extends Object> pVar) {
        return d.N(bVar, new FlowKt__MergeKt$mapLatest$1(pVar, null));
    }

    public static final <T> b<T> b(Iterable<? extends b<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    public static final <T> b<T> c(b<? extends T>... bVarArr) {
        return d.H(r.L(bVarArr));
    }

    public static final <T, R> b<R> d(b<? extends T> bVar, q<? super c<? super R>, ? super T, ? super InterfaceC4014c<? super t>, ? extends Object> qVar) {
        return new ChannelFlowTransformLatest(qVar, bVar, null, 0, null, 28, null);
    }
}
