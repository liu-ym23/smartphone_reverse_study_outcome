package io.ktor.http.cio.internals;

import A.h;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.cio.internals.AsciiCharTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0018\u0017B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006JS\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", Parameters.ROOT, "<init>", "(Lio/ktor/http/cio/internals/AsciiCharTree$Node;)V", "", "sequence", "", "fromIdx", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "", "lowerCase", "Lkotlin/Function2;", "", "stopPredicate", "", "search", "(Ljava/lang/CharSequence;IIZLp9/p;)Ljava/util/List;", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "getRoot", "()Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "Companion", "Node", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AsciiCharTree<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Node<T> root;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jy\u0010\u0013\u001a\u00020\u0012\"\b\b\u0001\u0010\u0004*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\r2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016\"\b\b\u0001\u0010\u0004*\u00020\u00152\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u0013\u0010\u0017JY\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\r2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0013\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "resultList", "", "from", "", "maxLength", "idx", "Lkotlin/Function1;", "length", "Lkotlin/Function2;", "", "charAt", "LY8/t;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(Ljava/util/List;Ljava/util/List;IILp9/l;Lp9/p;)V", "", "Lio/ktor/http/cio/internals/AsciiCharTree;", "(Ljava/util/List;)Lio/ktor/http/cio/internals/AsciiCharTree;", "(Ljava/util/List;Lp9/l;Lp9/p;)Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int build$lambda$0(CharSequence it) {
            p.i(it, "it");
            return it.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final char build$lambda$1(CharSequence s10, int i10) {
            p.i(s10, "s");
            return s10.charAt(i10);
        }

        public final <T extends CharSequence> AsciiCharTree<T> build(List<? extends T> from) {
            p.i(from, "from");
            return build(from, new InterfaceC5074l() { // from class: io.ktor.http.cio.internals.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Integer.valueOf(AsciiCharTree.Companion.build$lambda$0((CharSequence) obj));
                }
            }, new p9.p() { // from class: io.ktor.http.cio.internals.b
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return Character.valueOf(AsciiCharTree.Companion.build$lambda$1((CharSequence) obj, ((Integer) obj2).intValue()));
                }
            });
        }

        private Companion() {
        }

        public final <T> AsciiCharTree<T> build(List<? extends T> from, InterfaceC5074l<? super T, Integer> length, p9.p<? super T, ? super Integer, Character> charAt) {
            h.b bVar;
            p.i(from, "from");
            p.i(length, "length");
            p.i(charAt, "charAt");
            List<? extends T> list = from;
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                T next = it.next();
                if (it.hasNext()) {
                    Integer numInvoke = length.invoke(next);
                    do {
                        T next2 = it.next();
                        Integer numInvoke2 = length.invoke(next2);
                        if (numInvoke.compareTo(numInvoke2) < 0) {
                            next = next2;
                            numInvoke = numInvoke2;
                        }
                    } while (it.hasNext());
                }
                bVar = next;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                throw new NoSuchElementException("Unable to build char tree from an empty list");
            }
            int iIntValue = length.invoke(bVar).intValue();
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (length.invoke(it2.next()).intValue() == 0) {
                        throw new IllegalArgumentException("There should be no empty entries");
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            build(arrayList, from, iIntValue, 0, length, charAt);
            arrayList.trimToSize();
            return new AsciiCharTree<>(new Node((char) 0, C1173v.m(), arrayList));
        }

        private final <T> void build(List<Node<T>> resultList, List<? extends T> from, int maxLength, int idx, InterfaceC5074l<? super T, Integer> length, p9.p<? super T, ? super Integer, Character> charAt) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t10 : from) {
                Character chInvoke = charAt.invoke(t10, Integer.valueOf(idx));
                chInvoke.charValue();
                Object arrayList = linkedHashMap.get(chInvoke);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(chInvoke, arrayList);
                }
                ((List) arrayList).add(t10);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                char cCharValue = ((Character) entry.getKey()).charValue();
                List list = (List) entry.getValue();
                int i10 = idx + 1;
                ArrayList arrayList2 = new ArrayList();
                Companion companion = AsciiCharTree.INSTANCE;
                List list2 = list;
                ArrayList arrayList3 = new ArrayList();
                for (T t11 : list2) {
                    if (length.invoke(t11).intValue() > i10) {
                        arrayList3.add(t11);
                    }
                }
                int i11 = maxLength;
                InterfaceC5074l<? super T, Integer> interfaceC5074l = length;
                p9.p<? super T, ? super Integer, Character> pVar = charAt;
                companion.build(arrayList2, arrayList3, i11, i10, interfaceC5074l, pVar);
                arrayList2.trimToSize();
                ArrayList arrayList4 = new ArrayList();
                for (T t12 : list2) {
                    if (interfaceC5074l.invoke(t12).intValue() == i10) {
                        arrayList4.add(t12);
                    }
                }
                resultList.add(new Node<>(cCharValue, arrayList4, arrayList2));
                maxLength = i11;
                length = interfaceC5074l;
                charAt = pVar;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000fR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00000\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree$Node;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "ch", "", "exact", "children", "<init>", "(CLjava/util/List;Ljava/util/List;)V", "C", "getCh", "()C", "Ljava/util/List;", "getExact", "()Ljava/util/List;", "getChildren", "", "array", "[Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "getArray", "()[Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node<T> {
        private final Node<T>[] array;
        private final char ch;
        private final List<Node<T>> children;
        private final List<T> exact;

        /* JADX WARN: Multi-variable type inference failed */
        public Node(char c10, List<? extends T> exact, List<Node<T>> children) {
            p.i(exact, "exact");
            p.i(children, "children");
            this.ch = c10;
            this.exact = exact;
            this.children = children;
            Node<T>[] nodeArr = new Node[256];
            for (int i10 = 0; i10 < 256; i10++) {
                Iterator<T> it = this.children.iterator();
                Node<T> node = null;
                boolean z10 = false;
                Node<T> node2 = null;
                while (true) {
                    if (it.hasNext()) {
                        T next = it.next();
                        if (((Node) next).ch == i10) {
                            if (z10) {
                                break;
                            }
                            z10 = true;
                            node2 = next;
                        }
                    } else if (z10) {
                        node = node2;
                    }
                }
                nodeArr[i10] = node;
            }
            this.array = nodeArr;
        }

        public final Node<T>[] getArray() {
            return this.array;
        }

        public final char getCh() {
            return this.ch;
        }

        public final List<Node<T>> getChildren() {
            return this.children;
        }

        public final List<T> getExact() {
            return this.exact;
        }
    }

    public AsciiCharTree(Node<T> root) {
        p.i(root, "root");
        this.root = root;
    }

    public static /* synthetic */ List search$default(AsciiCharTree asciiCharTree, CharSequence charSequence, int i10, int i11, boolean z10, p9.p pVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        return asciiCharTree.search(charSequence, i10, i11, z10, pVar);
    }

    public final Node<T> getRoot() {
        return this.root;
    }

    public final List<T> search(CharSequence sequence, int fromIdx, int end, boolean lowerCase, p9.p<? super Character, ? super Integer, Boolean> stopPredicate) {
        p.i(sequence, "sequence");
        p.i(stopPredicate, "stopPredicate");
        if (sequence.length() == 0) {
            throw new IllegalArgumentException("Couldn't search in char tree for empty string");
        }
        Node<T> node = this.root;
        while (fromIdx < end) {
            char cCharAt = sequence.charAt(fromIdx);
            if (stopPredicate.invoke(Character.valueOf(cCharAt), Integer.valueOf(cCharAt)).booleanValue()) {
                break;
            }
            Node<T> node2 = node.getArray()[cCharAt];
            if (node2 == null) {
                node = lowerCase ? node.getArray()[Character.toLowerCase(cCharAt)] : null;
                if (node == null) {
                    return C1173v.m();
                }
            } else {
                node = node2;
            }
            fromIdx++;
        }
        return node.getExact();
    }
}
