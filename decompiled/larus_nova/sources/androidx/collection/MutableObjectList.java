package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003<=>B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u001d\u0010\f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u001e\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0019\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u001c\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002J\u0006\u0010 \u001a\u00020\u0010J\u0010\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u0004J\u0011\u0010#\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0004H\u0086\bJ%\u0010$\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0015H\u0001¢\u0006\u0002\u0010'J\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010(J\u0013\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ/\u0010+\u001a\u00020\u00102!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0-H\u0086\bø\u0001\u0000J\u0019\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u001aJ\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\u001c\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002J\u0015\u00101\u001a\u00028\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0004¢\u0006\u0002\u00102J\u001a\u00103\u001a\u00020\u00102\b\b\u0001\u00104\u001a\u00020\u00042\b\b\u0001\u00105\u001a\u00020\u0004J\u0019\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u001aJ\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ \u00107\u001a\u00028\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00108J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006?"}, d2 = {"Landroidx/collection/MutableObjectList;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ObjectList;", "initialCapacity", "", "<init>", "(I)V", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "capacity", "getCapacity", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", SlcElement.KEY_ELEMENTS, "", "(I[Ljava/lang/Object;)Z", "", "throwIndexOutOfBoundsInclusiveException", "Landroidx/collection/ScatterSet;", "([Ljava/lang/Object;)Z", "", "", "Lkotlin/sequences/Sequence;", "plusAssign", "([Ljava/lang/Object;)V", "clear", "trim", "minCapacity", "ensureCapacity", "resizeStorage", "oldContent", "", "(I[Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "minusAssign", "remove", "removeIf", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeRange", "start", "end", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "asList", "asMutableList", "", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "", "index", "", "<init>", "(Ljava/util/List;I)V", "prevIndex", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "", "hasPrevious", "nextIndex", "previous", "previousIndex", "add", "element", "(Ljava/lang/Object;)V", "set", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private final List<T> list;
        private int prevIndex;

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.prevIndex < (this.list.size() - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.prevIndex < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> r100 = this.list;
            int r101 = this.prevIndex + 1;
            this.prevIndex = r101;
            return (T) ListProtector.get(r100, r101);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> r100 = this.list;
            int r101 = this.prevIndex;
            this.prevIndex = r101 - 1;
            return (T) ListProtector.get(r100, r101);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            ListProtector.remove(this.list, this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator
        public void add(T r100) {
            List<T> r101 = this.list;
            int r102 = this.prevIndex + 1;
            this.prevIndex = r102;
            ListProtector.add(r101, r102, r100);
        }

        @Override // java.util.ListIterator
        public void set(T r100) {
            ListProtector.set(this.list, this.prevIndex, r100);
        }

        public MutableObjectListIterator(List<T> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.list = r100;
            this.prevIndex = r101 - 1;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0096\u0002J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u001e\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", ExifInterface.GPS_DIRECTION_TRUE, "", "objectList", "Landroidx/collection/MutableObjectList;", "<init>", "(Landroidx/collection/MutableObjectList;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ObjectListMutableList<T> implements List<T>, KMutableList {
        private final MutableObjectList<T> objectList;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            return (T[]) CollectionToArray.toArray(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public ObjectListMutableList(MutableObjectList<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "objectList");
            this.objectList = r100;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r100) {
            return this.objectList.add(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            return this.objectList.addAll(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r100) {
            return this.objectList.contains(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            return this.objectList.containsAll(r100);
        }

        @Override // java.util.List
        public T get(int r100) {
            ObjectListKt.access$checkIndex(this, r100);
            return this.objectList.get(r100);
        }

        @Override // java.util.List
        public int indexOf(Object r100) {
            return this.objectList.indexOf(r100);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r100) {
            return this.objectList.lastIndexOf(r100);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r100) {
            return new MutableObjectListIterator(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r100) {
            return this.objectList.remove(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            return this.objectList.removeAll(r100);
        }

        public T removeAt(int r100) {
            ObjectListKt.access$checkIndex(this, r100);
            return this.objectList.removeAt(r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            return this.objectList.retainAll(r100);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r100) {
            return removeAt(r100);
        }

        @Override // java.util.List
        public void add(int r100, T r101) {
            this.objectList.add(r100, r101);
        }

        @Override // java.util.List
        public boolean addAll(int r100, Collection<? extends T> r101) {
            Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
            return this.objectList.addAll(r100, r101);
        }

        @Override // java.util.List
        public T set(int r100, T r101) {
            ObjectListKt.access$checkIndex(this, r100);
            return this.objectList.set(r100, r101);
        }

        @Override // java.util.List
        public List<T> subList(int r100, int r101) {
            ObjectListKt.access$checkSubIndex(this, r100, r101);
            return new SubList(this, r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aH\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u001f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0015\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010$\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0015\u0010%\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010&\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u001e\u0010'\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006,"}, d2 = {"Landroidx/collection/MutableObjectList$SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "start", "", "end", "<init>", "(Ljava/util/List;II)V", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", SlcElement.KEY_ELEMENTS, "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            return (T[]) CollectionToArray.toArray(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int r100 = this.end - 1;
            int r101 = this.start;
            if (r101 > r100) goto L7;
        L4:
            ListProtector.remove(this.list, r100);
            if (r100 == r101) goto L7;
            r100 = r100 - 1;
        L7:
            this.end = this.start;
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            if (this.end != this.start) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r100) {
            List<T> r101 = this.list;
            int r102 = this.end;
            this.end = r102 + 1;
            ListProtector.add(r101, r102, r100);
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            this.list.addAll(this.end, r100);
            this.end += r100.size();
            if (r100.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r100) {
            int r101 = this.start;
            int r102 = this.end;
        L3:
            if (r101 >= r102) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            Iterator<T> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (contains(r101.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.List
        public T get(int r100) {
            ObjectListKt.access$checkIndex(this, r100);
            return (T) ListProtector.get(this.list, r100 + this.start);
        }

        @Override // java.util.List
        public int indexOf(Object r100) {
            int r101 = this.start;
            int r102 = this.end;
        L3:
            if (r101 >= r102) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L7;
            r101 = r101 + 1;
            goto L3
        L7:
            return r101 - this.start;
        L9:
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object r100) {
            int r101 = this.end - 1;
            int r102 = this.start;
            if (r102 <= r101) goto L5;
            return -1;
        L5:
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L7;
            if (r101 == r102) goto L14;
            r101 = r101 - 1;
            goto L5
        L14:
            return -1;
        L7:
            return r101 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r100) {
            return new MutableObjectListIterator(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r100) {
            int r101 = this.start;
            int r102 = this.end;
        L3:
            if (r101 >= r102) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r101), r100) == true) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            ListProtector.remove(this.list, r101);
            this.end--;
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            int r101 = this.end;
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            remove(r102.next());
            goto L4
        L7:
            if (r101 == this.end) goto L9;
            return true;
        L9:
            return false;
        }

        public T removeAt(int r100) {
            ObjectListKt.access$checkIndex(this, r100);
            T r101 = (T) ListProtector.remove(this.list, r100 + this.start);
            this.end--;
            return r101;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            int r101 = this.end;
            int r102 = r101 - 1;
            int r103 = this.start;
            if (r103 > r102) goto L10;
        L5:
            if (r100.contains(ListProtector.get(this.list, r102)) == true) goto L7;
            ListProtector.remove(this.list, r102);
            this.end--;
        L7:
            if (r102 == r103) goto L10;
            r102 = r102 - 1;
        L10:
            if (r101 == this.end) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r100) {
            return removeAt(r100);
        }

        @Override // java.util.List
        public void add(int r100, T r101) {
            ListProtector.add(this.list, r100 + this.start, r101);
            this.end++;
        }

        @Override // java.util.List
        public boolean addAll(int r100, Collection<? extends T> r101) {
            Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
            this.list.addAll(r100 + this.start, r101);
            this.end += r101.size();
            if (r101.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List
        public T set(int r100, T r101) {
            ObjectListKt.access$checkIndex(this, r100);
            return (T) ListProtector.set(this.list, r100 + this.start, r101);
        }

        @Override // java.util.List
        public List<T> subList(int r100, int r101) {
            ObjectListKt.access$checkSubIndex(this, r100, r101);
            return new SubList(this, r100, r101);
        }

        public SubList(List<T> r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.list = r100;
            this.start = r101;
            this.end = r102;
        }
    }

    public MutableObjectList() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> r100 = this.list;
        if (r100 != null) goto L7;
        ObjectListMutableList<E> r101 = new ObjectListMutableList(this);
        this.list = r101;
        return r101;
    L7:
        return r100;
    }

    public final void clear() {
        ArraysKt.fill(this.content, null, 0, this._size);
        this._size = 0;
    }

    public final int getCapacity() {
        return this.content.length;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public MutableObjectList(int r100) {
        super(r100, null);
    }

    private final void throwIndexOutOfBoundsInclusiveException(int r100) {
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index " + r100 + " must be in 0.." + this._size);
    }

    public final boolean add(E r100) {
        int r101 = this._size + 1;
        Object[] r102 = this.content;
        if (r102.length >= r101) goto L5;
        resizeStorage(r101, r102);
    L5:
        Object[] r103 = this.content;
        int r104 = this._size;
        r103[r104] = r100;
        this._size = r104 + 1;
        return true;
    }

    public final boolean addAll(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void ensureCapacity(int r100) {
        Object[] r101 = this.content;
        if (r101.length >= r100) goto L6;
        resizeStorage(r100, r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        Object[] r100 = r110.elements;
        long[] r111 = r110.metadata;
        int r101 = r111.length - 2;
        if (r101 < 0) goto L19;
        int r102 = 0;
    L5:
        long r103 = r111[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        remove(r100[(r102 << 3) + r105]);
    L15:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L16:
        if (r104 == 8) goto L17;
        return;
    L17:
        if (r102 == r101) goto L26;
        r102 = r102 + 1;
        goto L5
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = this._size + r110.getSize();
        Object[] r101 = this.content;
        if (r101.length >= r100) goto L8;
        resizeStorage(r100, r101);
    L8:
        Object[] r102 = r110.elements;
        long[] r111 = r110.metadata;
        int r103 = r111.length - 2;
        if (r103 < 0) goto L25;
        int r104 = 0;
    L11:
        long r105 = r111[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L22;
        if ((255 & r105) >= 128) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        add(r102[(r104 << 3) + r107]);
    L21:
        r105 = r105 >> 8;
        r107 = r107 + 1;
        goto L14
    L18:
        r108 = false;
        goto L19
    L22:
        if (r106 == 8) goto L23;
        return;
    L23:
        if (r104 == r103) goto L32;
        r104 = r104 + 1;
        goto L11
    L32:
        return;
    }

    public final boolean remove(E r100) {
        int r101 = indexOf(r100);
        if (r101 < 0) goto L6;
        removeAt(r101);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        remove(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L6:
        if (r101 == this._size) goto L10;
        return true;
    L10:
        return false;
    }

    public final E removeAt(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L9;
        throwIndexOutOfBoundsExclusiveException$collection(r100);
    L9:
        Object[] r102 = this.content;
        E r103 = (E) r102[r100];
        int r104 = this._size;
        if (r100 == (r104 - 1)) goto L12;
        ArraysKt.copyInto(r102, r102, r100, r100 + 1, r104);
    L12:
        int r105 = this._size - 1;
        this._size = r105;
        r102[r105] = null;
        return r103;
    L5:
        if (r100 >= this._size) goto L7;
        r101 = true;
        goto L7
    }

    public final void removeIf(Function1<? super E, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        int r101 = this._size;
        Object[] r102 = this.content;
        int r103 = 0;
        IntRange r104 = RangesKt.until(0, r101);
        int r105 = r104.getFirst();
        int r106 = r104.getLast();
        if (r105 > r106) goto L9;
    L4:
        r102[r105 - r103] = r102[r105];
        if (r100.invoke(r102[r105]).booleanValue() == false) goto L7;
        r103 = r103 + 1;
    L7:
        if (r105 == r106) goto L9;
        r105 = r105 + 1;
    L9:
        ArraysKt.fill(r102, null, r101 - r103, r101);
        this._size -= r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        Object[] r102 = this.content;
        int r103 = r101 - 1;
    L4:
        if ((-1) >= r103) goto L10;
        if (r100.contains(r102[r103]) == true) goto L8;
        removeAt(r103);
    L8:
        r103 = r103 - 1;
        goto L4
    L10:
        if (r101 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final void trim(int r100) {
        int r101 = Math.max(r100, this._size);
        Object[] r102 = this.content;
        if (r102.length <= r101) goto L6;
        this.content = Arrays.copyOf(r102, r101);
        return;
    }

    public final boolean addAll(ScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        remove(ListProtector.get(r100, r102));
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        int r101 = this._size;
        int r102 = r100.size() + r101;
        Object[] r103 = this.content;
        if (r103.length >= r102) goto L8;
        resizeStorage(r102, r103);
    L8:
        Object[] r104 = this.content;
        int r105 = r100.size();
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        r104[r106 + r101] = ListProtector.get(r100, r106);
        r106 = r106 + 1;
        goto L9
    L11:
        this._size += r100.size();
    }

    public final boolean removeAll(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        Object[] r102 = this.content;
        int r103 = r101 - 1;
    L4:
        if ((-1) >= r103) goto L10;
        if (CollectionsKt.contains(r100, r102[r103]) == true) goto L8;
        removeAt(r103);
    L8:
        r103 = r103 - 1;
        goto L4
    L10:
        if (r101 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public final void plusAssign(E[] r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        if (r110.length != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        int r101 = this._size + r110.length;
        Object[] r102 = this.content;
        if (r102.length >= r101) goto L11;
        resizeStorage(r101, r102);
    L11:
        ArraysKt.copyInto$default(r110, this.content, this._size, 0, 0, 12, null);
        this._size += r110.length;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean removeAll(ScatterSet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        Object[] r102 = this.content;
        int r103 = r101 - 1;
    L4:
        if ((-1) >= r103) goto L10;
        if (r100.contains(r102[r103]) == true) goto L8;
        removeAt(r103);
    L8:
        r103 = r103 - 1;
        goto L4
    L10:
        if (r101 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public final void plusAssign(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        int r101 = this._size + r100._size;
        Object[] r102 = this.content;
        if (r102.length >= r101) goto L8;
        resizeStorage(r101, r102);
    L8:
        ArraysKt.copyInto(r100.content, this.content, this._size, 0, r100._size);
        this._size += r100._size;
    }

    public final boolean removeAll(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        Object[] r102 = this.content;
        int r103 = r101 - 1;
    L4:
        if ((-1) >= r103) goto L10;
        if (SequencesKt.contains(r100, r102[r103]) == true) goto L8;
        removeAt(r103);
    L8:
        r103 = r103 - 1;
        goto L4
    L10:
        if (r101 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Object[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        remove(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void plusAssign(Iterable<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        add(r101.next());
        goto L4
    }

    public final boolean removeAll(List<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        Object[] r102 = this.content;
        int r103 = r101 - 1;
    L4:
        if ((-1) >= r103) goto L10;
        if (ArraysKt.indexOf(r100, r102[r103]) >= 0) goto L8;
        removeAt(r103);
    L8:
        r103 = r103 - 1;
        goto L4
    L10:
        if (r101 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        plusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E[] r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        remove(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        add(r101.next());
        goto L4
    }

    public final boolean removeAll(Sequence<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        int r101 = this._size;
        minusAssign(r100);
        if (r101 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E r100) {
        remove(r100);
    }

    public final void plusAssign(E r100) {
        add(r100);
    }

    public final void add(int r100, E r101) {
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L9;
        throwIndexOutOfBoundsInclusiveException(r100);
    L9:
        int r103 = this._size + 1;
        Object[] r104 = this.content;
        if (r104.length >= r103) goto L12;
        resizeStorage(r103, r104);
    L12:
        Object[] r105 = this.content;
        int r106 = this._size;
        if (r100 == r106) goto L15;
        ArraysKt.copyInto(r105, r105, r100 + 1, r100, r106);
    L15:
        r105[r100] = r101;
        this._size++;
        return;
    L5:
        if (r100 > this._size) goto L7;
        r102 = true;
        goto L7
    }

    public final boolean addAll(int r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        int r102 = 0;
        if (r100 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L11;
        throwIndexOutOfBoundsInclusiveException(r100);
    L11:
        if (r101.isEmpty() == false) goto L13;
        return false;
    L13:
        int r104 = this._size + r101.size();
        Object[] r105 = this.content;
        if (r105.length >= r104) goto L16;
        resizeStorage(r104, r105);
    L16:
        Object[] r106 = this.content;
        if (r100 == this._size) goto L19;
        ArraysKt.copyInto(r106, r106, r101.size() + r100, r100, this._size);
    L19:
        Iterator<T> r107 = r101.iterator();
    L21:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        int r109 = r102 + 1;
        if (r102 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r106[r102 + r100] = r108;
        r102 = r109;
        goto L21
    L26:
        this._size += r101.size();
        return true;
    L5:
        if (r100 > this._size) goto L7;
        r103 = true;
        goto L8
    }

    public final void removeRange(int r100, int r101) {
        boolean r102 = true;
        if (r100 >= 0) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L16;
        if (r101 >= 0) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == false) goto L16;
    L17:
        if (r101 >= r100) goto L19;
        RuntimeHelpersKt.throwIllegalArgumentException("Start (" + r100 + ") is more than end (" + r101 + ')');
    L19:
        if (r101 == r100) goto L25;
        int r104 = this._size;
        if (r101 >= r104) goto L23;
        Object[] r105 = this.content;
        ArraysKt.copyInto(r105, r105, r100, r101, r104);
    L23:
        int r106 = this._size;
        int r107 = r106 - (r101 - r100);
        ArraysKt.fill(this.content, null, r107, r106);
        this._size = r107;
        return;
    L25:
        return;
    L12:
        if (r101 > this._size) goto L14;
    L16:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Start (" + r100 + ") and end (" + r101 + ") must be in 0.." + this._size);
        goto L17
    L5:
        if (r100 > this._size) goto L7;
        r103 = true;
        goto L9
    }

    public final void resizeStorage(int r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r101, "oldContent");
        int r102 = r101.length;
        this.content = ArraysKt.copyInto(r101, new Object[Math.max(r100, (r102 * 3) / 2)], 0, 0, r102);
    }

    public final E set(int r100, E r101) {
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L9;
        throwIndexOutOfBoundsExclusiveException$collection(r100);
    L9:
        Object[] r103 = this.content;
        E r104 = (E) r103[r100];
        r103[r100] = r101;
        return r104;
    L5:
        if (r100 >= this._size) goto L7;
        r102 = true;
        goto L7
    }

    public final boolean addAll(int r110, E[] r111) {
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_ELEMENTS);
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L11;
        throwIndexOutOfBoundsInclusiveException(r110);
    L11:
        if (r111.length != 0) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L16;
        return false;
    L16:
        int r102 = this._size + r111.length;
        Object[] r103 = this.content;
        if (r103.length >= r102) goto L19;
        resizeStorage(r102, r103);
    L19:
        Object[] r104 = this.content;
        int r105 = this._size;
        if (r110 == r105) goto L22;
        ArraysKt.copyInto(r104, r104, r111.length + r110, r110, r105);
    L22:
        ArraysKt.copyInto$default(r111, r104, r110, 0, 0, 12, null);
        this._size += r111.length;
        return true;
    L13:
        r101 = false;
        goto L14
    L5:
        if (r110 > this._size) goto L7;
        r100 = true;
        goto L8
    }

    public final boolean addAll(int r100, ObjectList<E> r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        throwIndexOutOfBoundsInclusiveException(r100);
    L11:
        if (r101.isEmpty() == false) goto L13;
        return false;
    L13:
        int r103 = this._size + r101._size;
        Object[] r104 = this.content;
        if (r104.length >= r103) goto L16;
        resizeStorage(r103, r104);
    L16:
        Object[] r105 = this.content;
        int r106 = this._size;
        if (r100 == r106) goto L19;
        ArraysKt.copyInto(r105, r105, r101._size + r100, r100, r106);
    L19:
        ArraysKt.copyInto(r101.content, r105, r100, 0, r101._size);
        this._size += r101._size;
        return true;
    L5:
        if (r100 > this._size) goto L7;
        r102 = true;
        goto L8
    }

    public /* synthetic */ MutableObjectList(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 16;
    L5:
        this(r100);
    }

    public static /* synthetic */ void trim$default(MutableObjectList r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100._size;
    L5:
        r100.trim(r101);
    }
}
