package Xa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0016\u001a\u00020\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096A¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018¨\u0006\u0019"}, d2 = {"LXa/l;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/o;", "", "LYa/h;", "flow", "Lkotlinx/coroutines/g;", "job", "<init>", "(LXa/o;Lkotlinx/coroutines/g;)V", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d;ILkotlinx/coroutines/channels/BufferOverflow;)LXa/b;", "LXa/c;", "collector", "", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/g;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class l<T> implements o<T>, b, Ya.h<T> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o<T> f6897a;
    private final kotlinx.coroutines.g job;

    /* JADX WARN: Multi-variable type inference failed */
    public l(o<? extends T> oVar, kotlinx.coroutines.g gVar) {
        this.f6897a = oVar;
        this.job = gVar;
    }

    @Override // Ya.h
    public b<T> b(kotlin.coroutines.d context, int capacity, BufferOverflow onBufferOverflow) {
        return p.e(this, context, capacity, onBufferOverflow);
    }

    @Override // Xa.o, Xa.b
    public Object collect(c<? super T> cVar, InterfaceC4014c<?> interfaceC4014c) {
        return this.f6897a.collect(cVar, interfaceC4014c);
    }
}
