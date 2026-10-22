package kotlin.reflect.jvm.internal.impl.utils;

import com.bytedance.apm.constant.PerfConsts;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public class DFS {

    public static abstract class AbstractNodeHandler<N, R> implements NodeHandler<N, R> {
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public void afterChildren(N r1) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public boolean beforeChildren(N r1) {
            return true;
        }

        public AbstractNodeHandler() {
        }
    }

    public static abstract class CollectingNodeHandler<N, R, C extends Iterable<R>> extends AbstractNodeHandler<N, C> {
        protected final C result;

        private static /* synthetic */ void $$$reportNull$$$0(int r7) {
            if (r7 == 1) goto L5;
            String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r7 == 1) goto L9;
            int r3 = 3;
        L10:
            Object[] r4 = new Object[r3];
            if (r7 == 1) goto L13;
            r4[0] = "result";
        L14:
            if (r7 == 1) goto L16;
            r4[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
        L17:
            if (r7 == 1) goto L19;
            r4[2] = "<init>";
        L19:
            String r2 = String.format(r1, r4);
            if (r7 == 1) goto L23;
            throw new IllegalArgumentException(r2);
        L23:
            throw new IllegalStateException(r2);
        L16:
            r4[1] = "result";
            goto L17
        L13:
            r4[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            goto L14
        L9:
            r3 = 2;
            goto L10
        L5:
            r1 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public /* bridge */ /* synthetic */ Object result() {
            return result();
        }

        protected CollectingNodeHandler(C r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.result = r2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public C result() {
            C r1 = this.result;
            if (r1 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r1;
        }
    }

    public interface Neighbors<N> {
        Iterable<? extends N> getNeighbors(N r1);
    }

    public interface NodeHandler<N, R> {
        void afterChildren(N r1);

        boolean beforeChildren(N r1);

        R result();
    }

    public static abstract class NodeHandlerWithListResult<N, R> extends CollectingNodeHandler<N, R, LinkedList<R>> {
        protected NodeHandlerWithListResult() {
            super(new LinkedList());
        }
    }

    public interface Visited<N> {
        boolean checkAndMarkVisited(N r1);
    }

    public static class VisitedWithSet<N> implements Visited<N> {
        private final Set<N> visited;

        private static /* synthetic */ void $$$reportNull$$$0(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"}));
        }

        public VisitedWithSet() {
            this(new HashSet());
        }

        public VisitedWithSet(Set<N> r2) {
            if (r2 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.visited = r2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Visited
        public boolean checkAndMarkVisited(N r1) {
            return this.visited.add(r1);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r3) {
        Object[] r0 = new Object[3];
        switch(r3) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L4;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L4;
            case 8: goto L10;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L6;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L4;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L4;
            case 21: goto L10;
            case 22: goto L5;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L4;
        };
    L4:
        r0[0] = "nodes";
    L11:
        r0[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch(r3) {
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L16;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            default: goto L13;
        };
    L13:
        r0[2] = "dfs";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L14:
        r0[2] = "doDfs";
        goto L19
    L15:
        r0[2] = "topologicalOrder";
        goto L19
    L16:
        r0[2] = "dfsFromNode";
        goto L19
    L17:
        r0[2] = "ifAny";
        goto L19
    L5:
        r0[0] = PerfConsts.KEY_CURRENT_GALVANIC;
        goto L11
    L6:
        r0[0] = "node";
        goto L11
    L7:
        r0[0] = "predicate";
        goto L11
    L8:
        r0[0] = "handler";
        goto L11
    L9:
        r0[0] = "visited";
        goto L11
    L10:
        r0[0] = "neighbors";
        goto L11
    }

    public static <N, R> R dfs(Collection<N> r1, Neighbors<N> r2, Visited<N> r3, NodeHandler<N, R> r4) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r3 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r4 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        Iterator<N> r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L15;
        doDfs(r5.next(), r2, r3, r4);
        goto L12
    L15:
        return r4.result();
    }

    public static <N, R> R dfs(Collection<N> r1, Neighbors<N> r2, NodeHandler<N, R> r3) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r3 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return (R) dfs(r1, r2, new VisitedWithSet(), r3);
    }

    public static <N> Boolean ifAny(Collection<N> r2, Neighbors<N> r3, final Function1<N, Boolean> r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        final boolean[] r0 = new boolean[1];
        return (Boolean) dfs(r2, r3, new AnonymousClass1(r4, r0));
    }

    public static <N> void doDfs(N r2, Neighbors<N> r3, Visited<N> r4, NodeHandler<N, ?> r5) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(23);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(24);
    L8:
        if (r5 != null) goto L11;
        $$$reportNull$$$0(25);
    L11:
        if (r4.checkAndMarkVisited(r2) == true) goto L14;
        return;
    L14:
        if (r5.beforeChildren(r2) == true) goto L16;
        return;
    L16:
        Iterator<? extends N> r0 = r3.getNeighbors(r2).iterator();
    L18:
        if (r0.hasNext() == false) goto L20;
        doDfs(r0.next(), r3, r4, r5);
        goto L18
    L20:
        r5.afterChildren(r2);
    }
}
