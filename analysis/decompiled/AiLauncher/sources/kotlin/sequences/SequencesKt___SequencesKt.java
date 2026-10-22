package kotlin.sequences;

import Ka.A;
import Ka.c;
import Ka.d;
import Ka.e;
import Ka.g;
import Ka.h;
import Ka.j;
import Ka.t;
import Ka.u;
import Ka.y;
import Ka.z;
import La.s;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1177z;
import Z8.F;
import Z8.X;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001d\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0003\u001a+\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u000f\u001a)\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\n\u001a7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u000f\u001a?\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0018\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0016j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0017¢\u0006\u0004\b\u0019\u0010\u001a\u001a7\u0010\u001e\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u001c*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010\"\u001a\u0012\u0012\u0004\u0012\u00028\u00000 j\b\u0012\u0004\u0012\u00028\u0000`!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\"\u0010#\u001a#\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b%\u0010&\u001a#\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b(\u0010&\u001a#\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b*\u0010+\u001aC\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010,*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u000b¢\u0006\u0004\b.\u0010\u000f\u001a=\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010,*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b,\u0010\u000f\u001aC\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010,*\u00020\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b¢\u0006\u0004\b/\u0010\u000f\u001a#\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b0\u0010\u0013\u001a=\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b2\u0010\u000f\u001a\u001d\u00103\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b3\u00104\u001a=\u0010\u0000\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0018\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0016j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0017H\u0007¢\u0006\u0004\b\u0000\u00105\u001a=\u00106\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0018\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0016j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0017H\u0007¢\u0006\u0004\b6\u00105\u001a.\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00107\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b8\u00109\u001a4\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0086\u0002¢\u0006\u0004\b<\u0010=\u001a4\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b>\u0010?\u001a}\u0010I\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u00103*\u00060@j\u0002`A*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010B\u001a\u00028\u00012\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020C2\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020C2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020C\u0018\u00010\u000b¢\u0006\u0004\bI\u0010J\u001ag\u0010L\u001a\u00020K\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020C2\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020C2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020C\u0018\u00010\u000b¢\u0006\u0004\bL\u0010M\u001a#\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000:\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bN\u0010O¨\u0006P"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LKa/j;", "J", "(LKa/j;)Ljava/lang/Object;", "K", "P", "Q", "", "n", ExifInterface.LONGITUDE_EAST, "(LKa/j;I)LKa/j;", "Lkotlin/Function1;", "", "predicate", "F", "(LKa/j;Lp9/l;)LKa/j;", "G", "", "H", "(LKa/j;)LKa/j;", "Z", "a0", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "Y", "(LKa/j;Ljava/util/Comparator;)LKa/j;", "", "C", "destination", "b0", "(LKa/j;Ljava/util/Collection;)Ljava/util/Collection;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "c0", "(LKa/j;)Ljava/util/HashSet;", "", "d0", "(LKa/j;)Ljava/util/List;", "", "e0", "", "f0", "(LKa/j;)Ljava/util/Set;", "R", "transform", "L", ExifInterface.LATITUDE_SOUTH, "B", "selector", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LKa/j;)I", "(LKa/j;Ljava/util/Comparator;)Ljava/lang/Object;", "U", "element", "X", "(LKa/j;Ljava/lang/Object;)LKa/j;", "", "elements", ExifInterface.LONGITUDE_WEST, "(LKa/j;Ljava/lang/Iterable;)LKa/j;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(LKa/j;LKa/j;)LKa/j;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "M", "(LKa/j;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/Appendable;", "", "N", "(LKa/j;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lp9/l;)Ljava/lang/String;", "z", "(LKa/j;)Ljava/lang/Iterable;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes5.dex */
public class SequencesKt___SequencesKt extends u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$a", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Iterable<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f36170a;

        public a(j jVar) {
            this.f36170a = jVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f36170a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$b", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements j<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j<T> f36171a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super T> f36172b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(j<? extends T> jVar, Comparator<? super T> comparator) {
            this.f36171a = jVar;
            this.f36172b = comparator;
        }

        @Override // Ka.j
        public Iterator<T> iterator() {
            List listE0 = SequencesKt___SequencesKt.e0(this.f36171a);
            C1177z.C(listE0, this.f36172b);
            return listE0.iterator();
        }
    }

    public static <T> int A(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                C1173v.v();
            }
        }
        return i10;
    }

    public static <T> j<T> B(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        return D(jVar, new InterfaceC5074l() { // from class: Ka.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SequencesKt___SequencesKt.C(obj);
            }
        });
    }

    public static final Object C(Object obj) {
        return obj;
    }

    public static <T, K> j<T> D(j<? extends T> jVar, InterfaceC5074l<? super T, ? extends K> selector) {
        p.i(jVar, "<this>");
        p.i(selector, "selector");
        return new c(jVar, selector);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> j<T> E(j<? extends T> jVar, int i10) {
        p.i(jVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? jVar : jVar instanceof e ? ((e) jVar).a(i10) : new d(jVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> j<T> F(j<? extends T> jVar, InterfaceC5074l<? super T, Boolean> predicate) {
        p.i(jVar, "<this>");
        p.i(predicate, "predicate");
        return new g(jVar, true, predicate);
    }

    public static <T> j<T> G(j<? extends T> jVar, InterfaceC5074l<? super T, Boolean> predicate) {
        p.i(jVar, "<this>");
        p.i(predicate, "predicate");
        return new g(jVar, false, predicate);
    }

    public static <T> j<T> H(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        j<T> jVarG = G(jVar, new InterfaceC5074l() { // from class: Ka.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SequencesKt___SequencesKt.I(obj));
            }
        });
        p.g(jVarG, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return jVarG;
    }

    public static final boolean I(Object obj) {
        return obj == null;
    }

    public static <T> T J(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T> T K(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T, R> j<R> L(j<? extends T> jVar, InterfaceC5074l<? super T, ? extends j<? extends R>> transform) {
        p.i(jVar, "<this>");
        p.i(transform, "transform");
        return new h(jVar, transform, SequencesKt___SequencesKt$flatMap$2.f36173a);
    }

    public static final <T, A extends Appendable> A M(j<? extends T> jVar, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super T, ? extends CharSequence> interfaceC5074l) throws IOException {
        p.i(jVar, "<this>");
        p.i(buffer, "buffer");
        p.i(separator, "separator");
        p.i(prefix, "prefix");
        p.i(postfix, "postfix");
        p.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : jVar) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            s.a(buffer, t10, interfaceC5074l);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String N(j<? extends T> jVar, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, InterfaceC5074l<? super T, ? extends CharSequence> interfaceC5074l) {
        p.i(jVar, "<this>");
        p.i(separator, "separator");
        p.i(prefix, "prefix");
        p.i(postfix, "postfix");
        p.i(truncated, "truncated");
        return ((StringBuilder) M(jVar, new StringBuilder(), separator, prefix, postfix, i10, truncated, interfaceC5074l)).toString();
    }

    public static /* synthetic */ String O(j jVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            interfaceC5074l = null;
        }
        CharSequence charSequence5 = charSequence4;
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        return N(jVar, charSequence, charSequence2, charSequence3, i10, charSequence5, interfaceC5074l2);
    }

    public static <T> T P(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T Q(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T, R> j<R> R(j<? extends T> jVar, InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(jVar, "<this>");
        p.i(transform, "transform");
        return new A(jVar, transform);
    }

    public static <T, R> j<R> S(j<? extends T> jVar, InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(jVar, "<this>");
        p.i(transform, "transform");
        return H(new A(jVar, transform));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T T(j<? extends T> jVar, Comparator<? super T> comparator) {
        p.i(jVar, "<this>");
        p.i(comparator, "comparator");
        Iterator<? extends T> it = jVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T U(j<? extends T> jVar, Comparator<? super T> comparator) {
        p.i(jVar, "<this>");
        p.i(comparator, "comparator");
        Iterator<? extends T> it = jVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    public static <T> j<T> V(j<? extends T> jVar, j<? extends T> elements) {
        p.i(jVar, "<this>");
        p.i(elements, "elements");
        return t.k(t.w(jVar, elements));
    }

    public static <T> j<T> W(j<? extends T> jVar, Iterable<? extends T> elements) {
        p.i(jVar, "<this>");
        p.i(elements, "elements");
        return t.k(t.w(jVar, F.d0(elements)));
    }

    public static <T> j<T> X(j<? extends T> jVar, T t10) {
        p.i(jVar, "<this>");
        return t.k(t.w(jVar, t.v(t10)));
    }

    public static <T> j<T> Y(j<? extends T> jVar, Comparator<? super T> comparator) {
        p.i(jVar, "<this>");
        p.i(comparator, "comparator");
        return new b(jVar, comparator);
    }

    public static <T> j<T> Z(j<? extends T> jVar, int i10) {
        p.i(jVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? t.j() : jVar instanceof e ? ((e) jVar).b(i10) : new y(jVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> j<T> a0(j<? extends T> jVar, InterfaceC5074l<? super T, Boolean> predicate) {
        p.i(jVar, "<this>");
        p.i(predicate, "predicate");
        return new z(jVar, predicate);
    }

    public static <T, C extends Collection<? super T>> C b0(j<? extends T> jVar, C destination) {
        p.i(jVar, "<this>");
        p.i(destination, "destination");
        Iterator<? extends T> it = jVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> HashSet<T> c0(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        return (HashSet) b0(jVar, new HashSet());
    }

    public static <T> List<T> d0(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        if (!it.hasNext()) {
            return C1173v.m();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return C1172u.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> List<T> e0(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        return (List) b0(jVar, new ArrayList());
    }

    public static <T> Set<T> f0(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        Iterator<? extends T> it = jVar.iterator();
        if (!it.hasNext()) {
            return Y.e();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return X.d(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static <T> Iterable<T> z(j<? extends T> jVar) {
        p.i(jVar, "<this>");
        return new a(jVar);
    }
}
