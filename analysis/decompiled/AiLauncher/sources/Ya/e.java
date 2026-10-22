package Ya;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0003¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0012\u001a\u00028\u0000\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00028\u00002\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0096\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"LYa/e;", "Lkotlin/coroutines/d;", "", "e", "originalContext", "<init>", "(Ljava/lang/Throwable;Lkotlin/coroutines/d;)V", "Lkotlin/coroutines/d$b;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/d$c;", "key", "get", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d$b;", "", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lp9/p;)Ljava/lang/Object;", "context", "plus", "(Lkotlin/coroutines/d;)Lkotlin/coroutines/d;", "minusKey", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e implements kotlin.coroutines.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.coroutines.d f7046a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Throwable e;

    public e(Throwable th, kotlin.coroutines.d dVar) {
        this.f7046a = dVar;
        this.e = th;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R initial, p9.p<? super R, ? super d.b, ? extends R> operation) {
        return (R) this.f7046a.fold(initial, operation);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> key) {
        return (E) this.f7046a.get(key);
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d minusKey(d.c<?> key) {
        return this.f7046a.minusKey(key);
    }

    @Override // kotlin.coroutines.d
    public kotlin.coroutines.d plus(kotlin.coroutines.d context) {
        return this.f7046a.plus(context);
    }
}
