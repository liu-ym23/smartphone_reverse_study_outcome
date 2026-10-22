package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LKa/c;", ExifInterface.GPS_DIRECTION_TRUE, "K", "LKa/j;", "source", "Lkotlin/Function1;", "keySelector", "<init>", "(LKa/j;Lp9/l;)V", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "LKa/j;", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c<T, K> implements j<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final j<T> source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<T, K> keySelector;

    /* JADX WARN: Multi-variable type inference failed */
    public c(j<? extends T> source, InterfaceC5074l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(keySelector, "keySelector");
        this.source = source;
        this.keySelector = keySelector;
    }

    @Override // Ka.j
    public Iterator<T> iterator() {
        return new b(this.source.iterator(), this.keySelector);
    }
}
