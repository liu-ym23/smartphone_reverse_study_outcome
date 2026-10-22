package androidx.collection;

import D7.q;
import D7.v;
import H4.o;
import T7.a;
import T7.c;
import Y7.f;
import androidx.annotation.IntRange;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import i9.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003LMNB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\rJ%\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0010\u0010\u0013J%\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0014J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0015J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0010\u0010\u0017J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0018J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u0010\u0010\u001aJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u0010\u0010\u001cJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b\u0010\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\u0002¢\u0006\u0004\b\u001f\u0010!J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\u001f\u0010\"J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002¢\u0006\u0004\b\u001f\u0010#J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002¢\u0006\u0004\b\u001f\u0010$J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002¢\u0006\u0004\b\u001f\u0010%J\r\u0010&\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020\u0003¢\u0006\u0004\b)\u0010\u0006J\u0018\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b+\u0010\u0006J'\u0010.\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u000eH\u0001¢\u0006\u0004\b.\u0010/J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\u001f\u00100J\u0018\u00101\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b1\u00100J\u0015\u00102\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b2\u0010\nJ'\u00105\u001a\u00020\f2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b03H\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b7\u0010\u0018J\u001b\u00107\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b7\u0010\u0015J\u001b\u00107\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b7\u0010\u0017J\u001b\u00107\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b7\u0010\u001aJ\u001b\u00107\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b7\u0010\u001cJ\u001b\u00107\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b7\u0010\u001eJ\u001e\u00101\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b1\u0010\"J\u001e\u00101\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b1\u0010 J\u001e\u00101\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\u0002¢\u0006\u0004\b1\u0010!J\u001e\u00101\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002¢\u0006\u0004\b1\u0010#J\u001e\u00101\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002¢\u0006\u0004\b1\u0010$J\u001e\u00101\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002¢\u0006\u0004\b1\u0010%J\u0017\u00108\u001a\u00028\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b8\u00109J!\u0010<\u001a\u00020\f2\b\b\u0001\u0010:\u001a\u00020\u00032\b\b\u0001\u0010;\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\u001b\u0010>\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b>\u0010\u0018J\u001b\u0010>\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b>\u0010\u0015J\u001b\u0010>\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b>\u0010?J\u001b\u0010>\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b>\u0010\u001cJ\u001b\u0010>\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b>\u0010\u001eJ\"\u0010@\u001a\u00028\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\bB\u0010CJ\u0013\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000D¢\u0006\u0004\bE\u0010CJ\u0017\u0010F\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\bF\u0010\u0006R\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0012\u0010*\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\bJ\u0010K\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006O"}, d2 = {"Landroidx/collection/MutableObjectList;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ObjectList;", "", "initialCapacity", AppAgent.CONSTRUCT, "(I)V", "element", "", "add", "(Ljava/lang/Object;)Z", "index", "LC7/r;", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(I[Ljava/lang/Object;)Z", "", "(ILjava/util/Collection;)Z", "(ILandroidx/collection/ObjectList;)Z", "(Landroidx/collection/ObjectList;)Z", "Landroidx/collection/ScatterSet;", "(Landroidx/collection/ScatterSet;)Z", "([Ljava/lang/Object;)Z", "", "(Ljava/util/List;)Z", "", "(Ljava/lang/Iterable;)Z", "Li9/i;", "(Li9/i;)Z", "plusAssign", "(Landroidx/collection/ObjectList;)V", "(Landroidx/collection/ScatterSet;)V", "([Ljava/lang/Object;)V", "(Ljava/util/List;)V", "(Ljava/lang/Iterable;)V", "(Li9/i;)V", "clear", "()V", "minCapacity", "trim", "capacity", "ensureCapacity", "", "oldContent", "resizeStorage", "(I[Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "minusAssign", "remove", "Lkotlin/Function1;", "predicate", "removeIf", "(LS7/k;)V", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "start", "end", "removeRange", "(II)V", "retainAll", "(Ljava/util/Collection;)Z", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "asList", "()Ljava/util/List;", "", "asMutableList", "throwIndexOutOfBoundsInclusiveException", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "getCapacity", "()I", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "list", "", "index", AppAgent.CONSTRUCT, "(Ljava/util/List;I)V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "LC7/r;", "remove", "()V", "hasPrevious", "nextIndex", "()I", "previous", "previousIndex", "element", "add", "(Ljava/lang/Object;)V", "set", "Ljava/util/List;", "prevIndex", "I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, a {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list, int i) {
            k.f(list, "list");
            this.list = list;
            this.prevIndex = i - 1;
        }

        @Override // java.util.ListIterator
        public void add(T element) {
            List<T> list = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            list.add(i, element);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i = this.prevIndex;
            this.prevIndex = i - 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T element) {
            this.list.set(this.prevIndex, element);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010+\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\nJ\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ%\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u001e\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u000eJ\u000f\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b&\u0010\nJ\u001d\u0010'\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b'\u0010\u000eJ\u0017\u0010(\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b(\u0010\u0012J\u001d\u0010)\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b)\u0010\u000eJ \u0010*\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b*\u0010+J%\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000fH\u0016¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00100R\u0014\u00103\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/collection/MutableObjectList;", "objectList", AppAgent.CONSTRUCT, "(Landroidx/collection/MutableObjectList;)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "add", "LC7/r;", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "()V", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Landroidx/collection/MutableObjectList;", "getSize", "()I", "size", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ObjectListMutableList<T> implements List<T>, c {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> objectList) {
            k.f(objectList, "objectList");
            this.objectList = objectList;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T element) {
            return this.objectList.add(element);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends T> elements) {
            k.f(elements, "elements");
            return this.objectList.addAll(index, elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object element) {
            return this.objectList.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            k.f(elements, "elements");
            return this.objectList.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int index) {
            ObjectListKt.checkIndex(this, index);
            return this.objectList.get(index);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            return this.objectList.indexOf(element);
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
        public int lastIndexOf(Object element) {
            return this.objectList.lastIndexOf(element);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            k.f(elements, "elements");
            return this.objectList.removeAll(elements);
        }

        public T removeAt(int index) {
            ObjectListKt.checkIndex(this, index);
            return this.objectList.removeAt(index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            k.f(elements, "elements");
            return this.objectList.retainAll((Collection<? extends T>) elements);
        }

        @Override // java.util.List
        public T set(int index, T element) {
            ObjectListKt.checkIndex(this, index);
            return this.objectList.set(index, element);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            ObjectListKt.checkSubIndex(this, fromIndex, toIndex);
            return new SubList(this, fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List
        public void add(int index, T element) {
            this.objectList.add(index, element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            k.f(elements, "elements");
            return this.objectList.addAll(elements);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int index) {
            return new MutableObjectListIterator(this, index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object element) {
            return this.objectList.remove(element);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            k.f(array, "array");
            return (T[]) j.b(this, array);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010+\n\u0002\b\u0013\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u001f\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ%\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u001f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010!\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010&J\u0017\u0010'\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b'\u0010\fJ\u001d\u0010(\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b(\u0010\u0010J\u0017\u0010)\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0013J\u001d\u0010*\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¢\u0006\u0004\b*\u0010\u0010J \u0010+\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b+\u0010,J%\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u00100R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00102R\u0014\u00105\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Landroidx/collection/MutableObjectList$SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "list", "", "start", "end", AppAgent.CONSTRUCT, "(Ljava/util/List;II)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "add", "LC7/r;", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "()V", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Ljava/util/List;", "I", "getSize", "()I", "size", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SubList<T> implements List<T>, c {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list, int i, int i6) {
            k.f(list, "list");
            this.list = list;
            this.start = i;
            this.end = i6;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T element) {
            List<T> list = this.list;
            int i = this.end;
            this.end = i + 1;
            list.add(i, element);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends T> elements) {
            k.f(elements, "elements");
            this.list.addAll(index + this.start, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.end - 1;
            int i6 = this.start;
            if (i6 <= i) {
                while (true) {
                    this.list.remove(i);
                    if (i == i6) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object element) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (k.b(this.list.get(i6), element)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            k.f(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int index) {
            ObjectListKt.checkIndex(this, index);
            return this.list.get(index + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (k.b(this.list.get(i6), element)) {
                    return i6 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            int i = this.end - 1;
            int i6 = this.start;
            if (i6 > i) {
                return -1;
            }
            while (!k.b(this.list.get(i), element)) {
                if (i == i6) {
                    return -1;
                }
                i--;
            }
            return i - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            k.f(elements, "elements");
            int i = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i != this.end;
        }

        public T removeAt(int index) {
            ObjectListKt.checkIndex(this, index);
            this.end--;
            return this.list.remove(index + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            k.f(elements, "elements");
            int i = this.end;
            int i6 = i - 1;
            int i10 = this.start;
            if (i10 <= i6) {
                while (true) {
                    if (!elements.contains(this.list.get(i6))) {
                        this.list.remove(i6);
                        this.end--;
                    }
                    if (i6 == i10) {
                        break;
                    }
                    i6--;
                }
            }
            return i != this.end;
        }

        @Override // java.util.List
        public T set(int index, T element) {
            ObjectListKt.checkIndex(this, index);
            return this.list.set(index + this.start, element);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            ObjectListKt.checkSubIndex(this, fromIndex, toIndex);
            return new SubList(this, fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List
        public void add(int index, T element) {
            this.list.add(index + this.start, element);
            this.end++;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int index) {
            return new MutableObjectListIterator(this, index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object element) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (k.b(this.list.get(i6), element)) {
                    this.list.remove(i6);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            k.f(array, "array");
            return (T[]) j.b(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            k.f(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end = elements.size() + this.end;
            return elements.size() > 0;
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    private final void throwIndexOutOfBoundsInclusiveException(int index) {
        StringBuilder sbU = B7.a.u(index, "Index ", " must be in 0..");
        sbU.append(this._size);
        RuntimeHelpersKt.throwIndexOutOfBoundsException(sbU.toString());
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableObjectList._size;
        }
        mutableObjectList.trim(i);
    }

    public final boolean add(E element) {
        int i = this._size + 1;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        Object[] objArr2 = this.content;
        int i6 = this._size;
        objArr2[i6] = element;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, E[] elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            throwIndexOutOfBoundsInclusiveException(index);
        }
        if (elements.length == 0) {
            return false;
        }
        int length = this._size + elements.length;
        Object[] objArr = this.content;
        if (objArr.length < length) {
            resizeStorage(length, objArr);
        }
        Object[] objArr2 = this.content;
        int i = this._size;
        if (index != i) {
            q.X(objArr2, objArr2, elements.length + index, index, i);
        }
        q.b0(elements, objArr2, index, 0, 0, 12);
        this._size += elements.length;
        return true;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        q.f0(null, 0, this.content, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        Object[] objArr = this.content;
        if (objArr.length < capacity) {
            resizeStorage(capacity, objArr);
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(E element) {
        remove(element);
    }

    public final void plusAssign(ObjectList<E> elements) {
        k.f(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i = this._size + elements._size;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        q.X(elements.content, this.content, this._size, 0, elements._size);
        this._size += elements._size;
    }

    public final boolean remove(E element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(E[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        for (E e : elements) {
            remove(e);
        }
        return i != this._size;
    }

    public final E removeAt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        if (index < 0 || index >= this._size) {
            throwIndexOutOfBoundsExclusiveException$collection(index);
        }
        Object[] objArr = this.content;
        E e = (E) objArr[index];
        int i = this._size;
        if (index != i - 1) {
            q.X(objArr, objArr, index, index + 1, i);
        }
        int i6 = this._size - 1;
        this._size = i6;
        objArr[i6] = null;
        return e;
    }

    public final void removeIf(S7.k predicate) {
        k.f(predicate, "predicate");
        int i = this._size;
        Object[] objArr = this.content;
        int i6 = 0;
        f fVarX = AbstractC1451a.X(0, i);
        int i10 = fVarX.f1569a;
        int i11 = fVarX.b;
        if (i10 <= i11) {
            while (true) {
                objArr[i10 - i6] = objArr[i10];
                if (((Boolean) predicate.invoke(objArr[i10])).booleanValue()) {
                    i6++;
                }
                if (i10 == i11) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        q.f0(null, i - i6, objArr, i);
        this._size -= i6;
    }

    public final void removeRange(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int start, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int end) {
        int i;
        if (start < 0 || start > (i = this._size) || end < 0 || end > i) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(start, "Start (", end, ") and end (", ") must be in 0..");
            sbS.append(this._size);
            RuntimeHelpersKt.throwIndexOutOfBoundsException(sbS.toString());
        }
        if (end < start) {
            RuntimeHelpersKt.throwIllegalArgumentException("Start (" + start + ") is more than end (" + end + ')');
        }
        if (end != start) {
            int i6 = this._size;
            if (end < i6) {
                Object[] objArr = this.content;
                q.X(objArr, objArr, start, end, i6);
            }
            int i10 = this._size;
            int i11 = i10 - (end - start);
            q.f0(null, i11, this.content, i10);
            this._size = i11;
        }
    }

    public final void resizeStorage(int capacity, Object[] oldContent) {
        k.f(oldContent, "oldContent");
        int length = oldContent.length;
        Object[] objArr = new Object[Math.max(capacity, (length * 3) / 2)];
        q.X(oldContent, objArr, 0, 0, length);
        this.content = objArr;
    }

    public final boolean retainAll(E[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (q.u0(elements, objArr[i6]) < 0) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final E set(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, E element) {
        if (index < 0 || index >= this._size) {
            throwIndexOutOfBoundsExclusiveException$collection(index);
        }
        Object[] objArr = this.content;
        E e = (E) objArr[index];
        objArr[index] = element;
        return e;
    }

    public final void trim(int minCapacity) {
        int iMax = Math.max(minCapacity, this._size);
        Object[] objArr = this.content;
        if (objArr.length > iMax) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, iMax);
            k.e(objArrCopyOf, "copyOf(...)");
            this.content = objArrCopyOf;
        }
    }

    public MutableObjectList(int i) {
        super(i, null);
    }

    public final void minusAssign(List<? extends E> elements) {
        k.f(elements, "elements");
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            remove(elements.get(i));
        }
    }

    public /* synthetic */ MutableObjectList(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public final void minusAssign(E[] elements) {
        k.f(elements, "elements");
        for (E e : elements) {
            remove(e);
        }
    }

    public final boolean removeAll(ObjectList<E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        minusAssign((ObjectList) elements);
        return i != this._size;
    }

    public final void add(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, E element) {
        if (index < 0 || index > this._size) {
            throwIndexOutOfBoundsInclusiveException(index);
        }
        int i = this._size + 1;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        Object[] objArr2 = this.content;
        int i6 = this._size;
        if (index != i6) {
            q.X(objArr2, objArr2, index + 1, index, i6);
        }
        objArr2[index] = element;
        this._size++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(objArr[i6]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!elements.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean removeAll(ScatterSet<E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        minusAssign((ScatterSet) elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> elements) {
        k.f(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        remove(objArr[(i << 3) + i10]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final boolean removeAll(List<? extends E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        minusAssign((List) elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        k.f(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int size = elements.get_size() + this._size;
        Object[] objArr = this.content;
        if (objArr.length < size) {
            resizeStorage(size, objArr);
        }
        Object[] objArr2 = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        add(objArr2[(i << 3) + i10]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final boolean retainAll(Collection<? extends E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!elements.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, Collection<? extends E> elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            throwIndexOutOfBoundsInclusiveException(index);
        }
        int i = 0;
        if (elements.isEmpty()) {
            return false;
        }
        int size = elements.size() + this._size;
        Object[] objArr = this.content;
        if (objArr.length < size) {
            resizeStorage(size, objArr);
        }
        Object[] objArr2 = this.content;
        if (index != this._size) {
            q.X(objArr2, objArr2, elements.size() + index, index, this._size);
        }
        for (Object obj : elements) {
            int i6 = i + 1;
            if (i >= 0) {
                objArr2[i + index] = obj;
                i = i6;
            } else {
                o.X();
                throw null;
            }
        }
        this._size = elements.size() + this._size;
        return true;
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        minusAssign((Iterable) elements);
        return i != this._size;
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean removeAll(i elements) {
        k.f(elements, "elements");
        int i = this._size;
        minusAssign(elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(i elements) {
        k.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!v.u0(elements, objArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final void plusAssign(E[] elements) {
        k.f(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        int length = this._size + elements.length;
        Object[] objArr = this.content;
        if (objArr.length < length) {
            resizeStorage(length, objArr);
        }
        q.b0(elements, this.content, this._size, 0, 0, 12);
        this._size += elements.length;
    }

    public final boolean retainAll(i elements) {
        k.f(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        int i6 = i - 1;
        while (true) {
            int i10 = -1;
            if (-1 >= i6) {
                return i != this._size;
            }
            Object obj = objArr[i6];
            Iterator it = elements.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (i11 >= 0) {
                    if (k.b(obj, next)) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                } else {
                    o.X();
                    throw null;
                }
            }
            if (!(i10 >= 0)) {
                removeAt(i6);
            }
            i6--;
        }
    }

    public final boolean addAll(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index, ObjectList<E> elements) {
        k.f(elements, "elements");
        if (index < 0 || index > this._size) {
            throwIndexOutOfBoundsInclusiveException(index);
        }
        if (elements.isEmpty()) {
            return false;
        }
        int i = this._size + elements._size;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        Object[] objArr2 = this.content;
        int i6 = this._size;
        if (index != i6) {
            q.X(objArr2, objArr2, elements._size + index, index, i6);
        }
        q.X(elements.content, objArr2, index, 0, elements._size);
        this._size += elements._size;
        return true;
    }

    public final void plusAssign(List<? extends E> elements) {
        k.f(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i = this._size;
        int size = elements.size() + i;
        Object[] objArr = this.content;
        if (objArr.length < size) {
            resizeStorage(size, objArr);
        }
        Object[] objArr2 = this.content;
        int size2 = elements.size();
        for (int i6 = 0; i6 < size2; i6++) {
            objArr2[i6 + i] = elements.get(i6);
        }
        this._size = elements.size() + this._size;
    }

    public final void plusAssign(E element) {
        add(element);
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(i elements) {
        k.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(ObjectList<E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        plusAssign((ObjectList) elements);
        return i != this._size;
    }

    public final boolean addAll(ScatterSet<E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        plusAssign((ScatterSet) elements);
        return i != this._size;
    }

    public final boolean addAll(E[] elements) {
        k.f(elements, "elements");
        int i = this._size;
        plusAssign((Object[]) elements);
        return i != this._size;
    }

    public final boolean addAll(List<? extends E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        plusAssign((List) elements);
        return i != this._size;
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        k.f(elements, "elements");
        int i = this._size;
        plusAssign((Iterable) elements);
        return i != this._size;
    }

    public final boolean addAll(i elements) {
        k.f(elements, "elements");
        int i = this._size;
        plusAssign(elements);
        return i != this._size;
    }
}
