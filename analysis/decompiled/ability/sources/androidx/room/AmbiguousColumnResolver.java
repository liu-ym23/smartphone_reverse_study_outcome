package androidx.room;

import B9.Q;
import C7.r;
import D7.A;
import D7.F;
import D7.N;
import D7.v;
import D7.w;
import H4.o;
import Y7.f;
import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0007H\u0007¢\u0006\u0004\b\n\u0010\fJQ\u0010\u0014\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0004\u0012\u00020\u00120\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J]\u0010\u001c\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00162\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00042\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00112\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00120\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/room/AmbiguousColumnResolver;", "", AppAgent.CONSTRUCT, "()V", "", "", "resultColumns", "", "mappings", "", "resolve", "(Ljava/util/List;[[Ljava/lang/String;)[[I", "([Ljava/lang/String;[[Ljava/lang/String;)[[I", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "content", "pattern", "Lkotlin/Function3;", "", "LC7/r;", "onHashMatch", "rabinKarpSearch", "(Ljava/util/List;[Ljava/lang/String;LS7/o;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "current", "depth", "Lkotlin/Function1;", "block", "dfs", "(Ljava/util/List;Ljava/util/List;ILS7/k;)V", "ResultColumn", "Match", "Solution", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Match;", "", "LY7/f;", "resultRange", "", "", "resultIndices", AppAgent.CONSTRUCT, "(LY7/f;Ljava/util/List;)V", "LY7/f;", "getResultRange", "()LY7/f;", "Ljava/util/List;", "getResultIndices", "()Ljava/util/List;", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Match {
        private final List<Integer> resultIndices;
        private final f resultRange;

        public Match(f resultRange, List<Integer> resultIndices) {
            k.f(resultRange, "resultRange");
            k.f(resultIndices, "resultIndices");
            this.resultRange = resultRange;
            this.resultIndices = resultIndices;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final f getResultRange() {
            return this.resultRange;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "", HintConstants.AUTOFILL_HINT_NAME, "", "index", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String name, int i) {
            k.f(name, "name");
            this.name = name;
            this.index = i;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i6 & 2) != 0) {
                i = resultColumn.index;
            }
            return resultColumn.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public final ResultColumn copy(String name, int index) {
            k.f(name, "name");
            return new ResultColumn(name, index);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) other;
            return k.b(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return Integer.hashCode(this.index) + (this.name.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ResultColumn(name=");
            sb.append(this.name);
            sb.append(", index=");
            return B7.a.o(sb, this.index, ')');
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution;", "", "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "coverageOffset", "", "overlaps", AppAgent.CONSTRUCT, "(Ljava/util/List;II)V", "getMatches", "()Ljava/util/List;", "getCoverageOffset", "()I", "getOverlaps", "compareTo", "other", "Companion", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Solution implements Comparable<Solution> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Solution NO_SOLUTION = new Solution(EmptyList.f4893a, Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/room/AmbiguousColumnResolver$Solution$Companion;", "", AppAgent.CONSTRUCT, "()V", "NO_SOLUTION", "Landroidx/room/AmbiguousColumnResolver$Solution;", "getNO_SOLUTION", "()Landroidx/room/AmbiguousColumnResolver$Solution;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "matches", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            public final Solution build(List<Match> matches) {
                k.f(matches, "matches");
                List<Match> list = matches;
                int i = 0;
                int size = 0;
                for (Match match : list) {
                    size += ((match.getResultRange().b - match.getResultRange().f1569a) + 1) - match.getResultIndices().size();
                }
                Iterator<T> it = list.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i6 = ((Match) it.next()).getResultRange().f1569a;
                while (it.hasNext()) {
                    int i10 = ((Match) it.next()).getResultRange().f1569a;
                    if (i6 > i10) {
                        i6 = i10;
                    }
                }
                Iterator<T> it2 = list.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                int i11 = ((Match) it2.next()).getResultRange().b;
                while (it2.hasNext()) {
                    int i12 = ((Match) it2.next()).getResultRange().b;
                    if (i11 < i12) {
                        i11 = i12;
                    }
                }
                Iterable fVar = new f(i6, i11, 1);
                if (!(fVar instanceof Collection) || !((Collection) fVar).isEmpty()) {
                    Iterator it3 = fVar.iterator();
                    int i13 = 0;
                    while (it3.hasNext()) {
                        int iNextInt = ((F) it3).nextInt();
                        Iterator<T> it4 = list.iterator();
                        int i14 = 0;
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            if (((Match) it4.next()).getResultRange().e(iNextInt)) {
                                i14++;
                            }
                            if (i14 > 1) {
                                i13++;
                                if (i13 < 0) {
                                    o.W();
                                    throw null;
                                }
                            }
                        }
                    }
                    i = i13;
                }
                return new Solution(matches, size, i);
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(List<Match> matches, int i, int i6) {
            k.f(matches, "matches");
            this.matches = matches;
            this.coverageOffset = i;
            this.overlaps = i6;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        @Override // java.lang.Comparable
        public int compareTo(Solution other) {
            k.f(other, "other");
            int iG = k.g(this.overlaps, other.overlaps);
            return iG != 0 ? iG : k.g(this.coverageOffset, other.coverageOffset);
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> content, List<T> current, int depth, S7.k block) {
        if (depth == content.size()) {
            block.invoke(v.f1(current));
            return;
        }
        Iterator<T> it = content.get(depth).iterator();
        while (it.hasNext()) {
            current.add(it.next());
            INSTANCE.dfs(content, current, depth + 1, block);
            current.remove(o.H(current));
        }
    }

    public static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i, S7.k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i6 & 4) != 0) {
            i = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i, kVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> content, String[] pattern, S7.o onHashMatch) {
        int i = 0;
        int iHashCode = 0;
        for (String str : pattern) {
            iHashCode += str.hashCode();
        }
        int length = pattern.length;
        Iterator<T> it = content.subList(0, length).iterator();
        int iHashCode2 = 0;
        while (it.hasNext()) {
            iHashCode2 += ((ResultColumn) it.next()).getName().hashCode();
        }
        while (true) {
            if (iHashCode == iHashCode2) {
                onHashMatch.invoke(Integer.valueOf(i), Integer.valueOf(length), content.subList(i, length));
            }
            int i6 = i + 1;
            int i10 = length + 1;
            if (i10 > content.size()) {
                return;
            }
            iHashCode2 = (iHashCode2 - content.get(i).getName().hashCode()) + content.get(length).getName().hashCode();
            i = i6;
            length = i10;
        }
    }

    public static final int[][] resolve(List<String> resultColumns, String[][] mappings) {
        k.f(resultColumns, "resultColumns");
        k.f(mappings, "mappings");
        return resolve((String[]) resultColumns.toArray(new String[0]), mappings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r resolve$lambda$16$lambda$15(List list, int i, List indices) {
        k.f(indices, "indices");
        List list2 = indices;
        Iterator it = list2.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        int iIntValue = ((Number) it.next()).intValue();
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            if (iIntValue > iIntValue2) {
                iIntValue = iIntValue2;
            }
        }
        Iterator it2 = list2.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        int iIntValue3 = ((Number) it2.next()).intValue();
        while (it2.hasNext()) {
            int iIntValue4 = ((Number) it2.next()).intValue();
            if (iIntValue3 < iIntValue4) {
                iIntValue3 = iIntValue4;
            }
        }
        ((List) list.get(i)).add(new Match(new f(iIntValue, iIntValue3, 1), indices));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r resolve$lambda$16$lambda$7(String[] strArr, List list, int i, int i6, int i10, List resultColumnsSublist) {
        Object next;
        k.f(resultColumnsSublist, "resultColumnsSublist");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            r rVar = r.f317a;
            if (i11 >= length) {
                ((List) list.get(i)).add(new Match(new f(i6, i10 - 1, 1), arrayList));
                return rVar;
            }
            String str = strArr[i11];
            Iterator it = resultColumnsSublist.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (k.b(str, ((ResultColumn) next).getName())) {
                    break;
                }
            }
            ResultColumn resultColumn = (ResultColumn) next;
            if (resultColumn == null) {
                return rVar;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r resolve$lambda$19(Ref$ObjectRef ref$ObjectRef, List it) {
        k.f(it, "it");
        Solution solutionBuild = Solution.INSTANCE.build(it);
        if (solutionBuild.compareTo((Solution) ref$ObjectRef.f4920a) < 0) {
            ref$ObjectRef.f4920a = solutionBuild;
        }
        return r.f317a;
    }

    public static final int[][] resolve(String[] resultColumns, String[][] mappings) {
        k.f(resultColumns, "resultColumns");
        k.f(mappings, "mappings");
        int length = resultColumns.length;
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            String strSubstring = resultColumns[i6];
            if (strSubstring.charAt(0) == '`' && strSubstring.charAt(strSubstring.length() - 1) == '`') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                k.e(strSubstring, "substring(...)");
            }
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            k.e(lowerCase, "toLowerCase(...)");
            resultColumns[i6] = lowerCase;
        }
        int length2 = mappings.length;
        for (int i10 = 0; i10 < length2; i10++) {
            int length3 = mappings[i10].length;
            for (int i11 = 0; i11 < length3; i11++) {
                String[] strArr = mappings[i10];
                String lowerCase2 = strArr[i11].toLowerCase(Locale.ROOT);
                k.e(lowerCase2, "toLowerCase(...)");
                strArr[i11] = lowerCase2;
            }
        }
        SetBuilder setBuilder = new SetBuilder();
        for (String[] strArr2 : mappings) {
            A.g0(setBuilder, strArr2);
        }
        SetBuilder setBuilderM = N.m(setBuilder);
        ListBuilder listBuilderY = o.y();
        int length4 = resultColumns.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length4) {
            String str = resultColumns[i12];
            int i14 = i13 + 1;
            if (setBuilderM.f4904a.containsKey(str)) {
                listBuilderY.add(new ResultColumn(str, i13));
            }
            i12++;
            i13 = i14;
        }
        ListBuilder listBuilderQ = o.q(listBuilderY);
        int length5 = mappings.length;
        final ArrayList arrayList = new ArrayList(length5);
        for (int i15 = 0; i15 < length5; i15++) {
            arrayList.add(new ArrayList());
        }
        int length6 = mappings.length;
        int i16 = 0;
        final int i17 = 0;
        while (i16 < length6) {
            final String[] strArr3 = mappings[i16];
            int i18 = i17 + 1;
            INSTANCE.rabinKarpSearch(listBuilderQ, strArr3, new S7.o() { // from class: androidx.room.a
                @Override // S7.o
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AmbiguousColumnResolver.resolve$lambda$16$lambda$7(strArr3, arrayList, i17, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (List) obj3);
                }
            });
            if (((List) arrayList.get(i17)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr3.length);
                int length7 = strArr3.length;
                int i19 = i;
                while (i19 < length7) {
                    String str2 = strArr3[i19];
                    ListBuilder listBuilderY2 = o.y();
                    ListIterator listIterator = listBuilderQ.listIterator(i);
                    while (true) {
                        E7.a aVar = (E7.a) listIterator;
                        if (!aVar.hasNext()) {
                            break;
                        }
                        ResultColumn resultColumn = (ResultColumn) aVar.next();
                        if (k.b(str2, resultColumn.getName())) {
                            listBuilderY2.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    ListBuilder listBuilderQ2 = o.q(listBuilderY2);
                    if (!listBuilderQ2.isEmpty()) {
                        arrayList2.add(listBuilderQ2);
                        i19++;
                        i = 0;
                    } else {
                        throw new IllegalStateException(B7.a.m("Column ", str2, " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, arrayList2, null, 0, new androidx.compose.runtime.snapshots.e(arrayList, i17), 6, null);
            }
            i16++;
            i17 = i18;
            i = 0;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((List) it.next()).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f4920a = Solution.INSTANCE.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, null, 0, new Q(ref$ObjectRef, 16), 6, null);
        List<Match> matches = ((Solution) ref$ObjectRef.f4920a).getMatches();
        ArrayList arrayList3 = new ArrayList(w.c0(matches, 10));
        Iterator<T> it2 = matches.iterator();
        while (it2.hasNext()) {
            arrayList3.add(v.e1(((Match) it2.next()).getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }
}
