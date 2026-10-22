package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"LZ8/K;", ExifInterface.GPS_DIRECTION_TRUE, "", "LZ8/J;", "Lkotlin/Function0;", "", "iteratorFactory", "<init>", "(Lp9/a;)V", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "Lp9/a;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class K<T> implements Iterable<IndexedValue<? extends T>>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<Iterator<T>> iteratorFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public K(InterfaceC5063a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.p.i(iteratorFactory, "iteratorFactory");
        this.iteratorFactory = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<IndexedValue<T>> iterator() {
        return new L(this.iteratorFactory.invoke());
    }
}
