package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0007J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u001bH\u0086\bJ\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bJ\u0016\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0086\n¢\u0006\u0002\u0010\u0018R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", ExifInterface.GPS_DIRECTION_TRUE, "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "onVectorMutated", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/runtime/collection/MutableVector;Lkotlin/jvm/functions/Function0;)V", "getVector", "()Landroidx/compose/runtime/collection/MutableVector;", "getOnVectorMutated", "()Lkotlin/jvm/functions/Function0;", "size", "", "getSize", "()I", "clear", "add", "index", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "forEach", "block", "Lkotlin/Function1;", "asList", "", MonitorConstants.CONNECT_TYPE_GET, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableVectorWithMutationTracking<T> {
    public static final int $stable = 0;
    private final Function0<Unit> onVectorMutated;
    private final MutableVector<T> vector;

    static {
        $stable = MutableVector.$stable;
    }

    public final void clear() {
        this.vector.clear();
        this.onVectorMutated.invoke();
    }

    public final List<T> asList() {
        return getVector().asMutableList();
    }

    public final int getSize() {
        return getVector().getSize();
    }

    public final Function0<Unit> getOnVectorMutated() {
        return this.onVectorMutated;
    }

    public final MutableVector<T> getVector() {
        return this.vector;
    }

    public final void forEach(Function1<? super T, Unit> r100) {
        MutableVector<T> r101 = getVector();
        T[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.invoke(r102[r104]);
        r104 = r104 + 1;
        goto L3
    }

    public final T get(int r100) {
        return getVector().content[r100];
    }

    public final T removeAt(int r100) {
        T r101 = this.vector.removeAt(r100);
        this.onVectorMutated.invoke();
        return r101;
    }

    public MutableVectorWithMutationTracking(MutableVector<T> r100, Function0<Unit> r101) {
        this.vector = r100;
        this.onVectorMutated = r101;
    }

    public final void add(int r100, T r101) {
        this.vector.add(r100, r101);
        this.onVectorMutated.invoke();
    }
}
