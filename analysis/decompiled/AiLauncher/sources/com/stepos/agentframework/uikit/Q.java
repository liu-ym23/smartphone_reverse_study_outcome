package com.stepos.agentframework.uikit;

import La.C0951a;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u001a\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/uikit/Q;", "", "<init>", "()V", "", "markdown", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", "line", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "c", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "lines", "Lcom/stepos/agentframework/uikit/Q$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Lcom/stepos/agentframework/uikit/Q$b;", "Lcom/stepos/agentframework/uikit/Q$a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/uikit/Q$a;", "Lkotlin/text/Regex;", "separatorCellPattern", "Lkotlin/text/Regex;", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Q {
    public static final Q INSTANCE = new Q();
    private static final Regex separatorCellPattern = new Regex(":?-+:?");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/uikit/Q$a;", "", "", "marker", "", "length", "<init>", "(CI)V", "opening", "", "line", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/uikit/Q$a;Ljava/lang/String;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "C", "getMarker", "()C", "I", "getLength", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.Q$a, reason: from toString */
    public static final /* data */ class Fence {
        private final int length;
        private final char marker;

        public Fence(char c10, int i10) {
            this.marker = c10;
            this.length = i10;
        }

        public final boolean a(Fence opening, String line) {
            kotlin.jvm.internal.p.i(opening, "opening");
            kotlin.jvm.internal.p.i(line, "line");
            if (this.marker != opening.marker || this.length < opening.length) {
                return false;
            }
            return La.H.x0(La.K.L1(La.H.H1(line).toString(), this.length));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fence)) {
                return false;
            }
            Fence fence = (Fence) other;
            return this.marker == fence.marker && this.length == fence.length;
        }

        public int hashCode() {
            return (Character.hashCode(this.marker) * 31) + Integer.hashCode(this.length);
        }

        public String toString() {
            return "Fence(marker=" + this.marker + ", length=" + this.length + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010*\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0096\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u0019J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001eJ&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\tR\u0014\u0010(\u001a\u00020\u00148\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/uikit/Q$b;", "", "", "delegate", "", "changed", "<init>", "(Ljava/util/List;Z)V", "isEmpty", "()Z", "element", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "", "iterator", "()Ljava/util/Iterator;", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "index", "c", "(I)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Ljava/util/List;", "Z", "e", "f", "()I", ContentDisposition.Parameters.Size, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements List<String>, InterfaceC5162a {
        private final boolean changed;
        private final List<String> delegate;

        public b(List<String> delegate, boolean z10) {
            kotlin.jvm.internal.p.i(delegate, "delegate");
            this.delegate = delegate;
            this.changed = z10;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i10, String str) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends String> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void addFirst(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void addLast(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean b(String element) {
            kotlin.jvm.internal.p.i(element, "element");
            return this.delegate.contains(element);
        }

        @Override // java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String get(int index) {
            return this.delegate.get(index);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> elements) {
            kotlin.jvm.internal.p.i(elements, "elements");
            return this.delegate.containsAll(elements);
        }

        /* renamed from: e, reason: from getter */
        public final boolean getChanged() {
            return this.changed;
        }

        public int f() {
            return this.delegate.size();
        }

        public int i(String element) {
            kotlin.jvm.internal.p.i(element, "element");
            return this.delegate.indexOf(element);
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return i((String) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<String> iterator() {
            return this.delegate.iterator();
        }

        public int j(String element) {
            kotlin.jvm.internal.p.i(element, "element");
            return this.delegate.lastIndexOf(element);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return j((String) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator<String> listIterator() {
            return this.delegate.listIterator();
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ String remove(int i10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<String> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ String set(int i10, String str) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return f();
        }

        @Override // java.util.List
        public void sort(Comparator<? super String> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List<String> subList(int fromIndex, int toIndex) {
            return this.delegate.subList(fromIndex, toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return kotlin.jvm.internal.h.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends String> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public ListIterator<String> listIterator(int index) {
            return this.delegate.listIterator(index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            kotlin.jvm.internal.p.i(array, "array");
            return (T[]) kotlin.jvm.internal.h.b(this, array);
        }
    }

    public static final String f(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return La.H.D1(it).toString();
    }

    public final Fence b(String line) {
        int length = line.length();
        int length2 = 0;
        while (true) {
            if (length2 >= length) {
                length2 = -1;
                break;
            }
            if (!C0951a.c(line.charAt(length2))) {
                break;
            }
            length2++;
        }
        if (length2 == -1) {
            length2 = line.length();
        }
        if (length2 > 3) {
            return null;
        }
        String strSubstring = line.substring(length2);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        Character chO1 = La.K.O1(strSubstring);
        if (chO1 != null) {
            char cCharValue = chO1.charValue();
            if (cCharValue != '`' && cCharValue != '~') {
                chO1 = null;
            }
            if (chO1 != null) {
                char cCharValue2 = chO1.charValue();
                int length3 = strSubstring.length();
                int i10 = 0;
                while (true) {
                    if (i10 < length3) {
                        if (strSubstring.charAt(i10) != cCharValue2) {
                            strSubstring = strSubstring.substring(0, i10);
                            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                            break;
                        }
                        i10++;
                    } else {
                        break;
                    }
                }
                int length4 = strSubstring.length();
                if (length4 >= 3) {
                    return new Fence(cCharValue2, length4);
                }
            }
        }
        return null;
    }

    public final boolean c(String markdown) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        if (La.H.f0(markdown, '|', false, 2, null)) {
            Iterator<String> it = La.H.E0(markdown).iterator();
            while (it.hasNext()) {
                if (INSTANCE.d(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean d(String line) {
        kotlin.jvm.internal.p.i(line, "line");
        String strT = La.D.T(La.D.T(line, " ", "", false, 4, null), "\t", "", false, 4, null);
        if (!La.H.f0(strT, '|', false, 2, null)) {
            return false;
        }
        List listA1 = La.H.a1(La.H.E1(strT, '|'), new char[]{'|'}, false, 0, 6, null);
        if (listA1.isEmpty()) {
            return false;
        }
        List list = listA1;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!separatorCellPattern.k((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(String markdown) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        if (La.H.f0(markdown, '|', false, 2, null) && !c(markdown)) {
            Object obj = null;
            for (Object obj2 : SequencesKt___SequencesKt.R(La.H.E0(markdown), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.P
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return Q.f((String) obj3);
                }
            })) {
                if (((String) obj2).length() > 0) {
                    obj = obj2;
                }
            }
            String str = (String) obj;
            if (str != null && La.D.X(str, "|", false, 2, null)) {
                int i10 = 0;
                for (int i11 = 0; i11 < str.length(); i11++) {
                    if (str.charAt(i11) == '|') {
                        i10++;
                    }
                }
                if (i10 >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean g(String line) {
        String string = La.H.D1(line).toString();
        return (kotlin.jvm.internal.p.d(string, "|") || !La.H.f0(string, '|', false, 2, null) || d(string)) ? false : true;
    }

    public final String h(String markdown) {
        String str;
        String str2;
        kotlin.jvm.internal.p.i(markdown, "markdown");
        boolean z10 = false;
        if (La.H.f0(markdown, '|', false, 2, null)) {
            b bVarI = i(La.H.b1(markdown, new String[]{"\n"}, false, 0, 6, null));
            markdown = markdown;
            ArrayList arrayList = new ArrayList(bVarI.size() + 1);
            int i10 = 0;
            Fence fence = null;
            for (String str3 : bVarI) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                String str4 = str3;
                Q q10 = INSTANCE;
                Fence fenceB = q10.b(str4);
                if (fence == null) {
                    if (fenceB != null) {
                        fence = fenceB;
                    } else if (q10.g(str4) && (str = (String) Z8.F.t0(bVarI, i11)) != null && q10.d(str) && (str2 = (String) Z8.F.E0(arrayList)) != null && (!La.H.x0(str2))) {
                        arrayList.add("");
                        z10 = true;
                    }
                } else if (fenceB != null && fenceB.a(fence, str4)) {
                    fence = null;
                }
                arrayList.add(str4);
                i10 = i11;
            }
            if (z10 || bVarI.getChanged()) {
                return Z8.F.A0(arrayList, "\n", null, null, 0, null, null, 62, null);
            }
        }
        return markdown;
    }

    public final b i(List<String> lines) {
        ArrayList arrayList = new ArrayList(lines.size());
        int i10 = 0;
        boolean z10 = false;
        Fence fence = null;
        while (i10 < lines.size()) {
            String str = lines.get(i10);
            Fence fenceB = b(str);
            if (fence == null && fenceB != null) {
                fence = fenceB;
            } else if (fence != null && fenceB != null && fenceB.a(fence, str)) {
                fence = null;
            }
            int i11 = i10 + 1;
            String str2 = (String) Z8.F.t0(lines, i11);
            if (fence != null || !kotlin.jvm.internal.p.d(La.H.D1(str).toString(), "|") || str2 == null || !La.H.j0(La.H.F1(str2).toString(), '|', false, 2, null) || d(str2) || kotlin.jvm.internal.p.d(La.H.D1(str2).toString(), "|")) {
                arrayList.add(str);
                i10 = i11;
            } else {
                arrayList.add("| " + La.H.H1(La.H.R0(La.H.H1(str2).toString(), "|")).toString());
                i10 += 2;
                z10 = true;
            }
        }
        return new b(arrayList, z10);
    }
}
