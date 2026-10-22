package d0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import q9.InterfaceC5163b;
import q9.InterfaceC5165d;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001bJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\u0006J#\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&¢\u0006\u0004\b\f\u0010\nJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0015J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Ld0/e;", ExifInterface.LONGITUDE_EAST, "Ld0/c;", "", "element", "add", "(Ljava/lang/Object;)Ld0/e;", "", "elements", "addAll", "(Ljava/util/Collection;)Ld0/e;", "remove", "removeAll", "Lkotlin/Function1;", "", "predicate", "M", "(Lp9/l;)Ld0/e;", "", "index", "set", "(ILjava/lang/Object;)Ld0/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ld0/e;", "Ld0/e$a;", "builder", "()Ld0/e$a;", Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface e<E> extends c<E>, b {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ld0/e$a;", ExifInterface.LONGITUDE_EAST, "", "", "Ld0/e;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ld0/e;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a<E> extends List<E>, Collection, InterfaceC5163b, InterfaceC5165d {
        e<E> build();
    }

    e<E> M(InterfaceC5074l<? super E, Boolean> predicate);

    @Override // java.util.List
    e<E> add(int index, E element);

    @Override // java.util.List, java.util.Collection
    e<E> add(E element);

    @Override // java.util.List, java.util.Collection
    e<E> addAll(Collection<? extends E> elements);

    a<E> builder();

    e<E> h(int index);

    @Override // java.util.List, java.util.Collection
    e<E> remove(E element);

    @Override // java.util.List, java.util.Collection
    e<E> removeAll(Collection<? extends E> elements);

    @Override // java.util.List
    e<E> set(int index, E element);
}
