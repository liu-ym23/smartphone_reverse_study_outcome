package com.bytedance.perf.collector;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.block.trace.MethodItem;
import com.bytedance.apm.logging.MethodLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class TraceDataUtils {
    private static final String TAG = "TraceDataUtils";

    public interface IStructuredDataFilter {
        void fallback(List<MethodItem> r1, int r2);

        int getFilterMaxCount();

        boolean isFilter(long r1, int r3);
    }

    public static final class TreeNode {
        TreeNode father;
        MethodItem item;
        LinkedList<TreeNode> nextNode;

        static /* synthetic */ int access$000(TreeNode r0) {
            return r0.depth();
        }

        static /* synthetic */ void access$100(TreeNode r0, TreeNode r1) {
            r0.add(r1);
        }

        TreeNode(MethodItem r2, TreeNode r3) {
            this.nextNode = new LinkedList();
            this.item = r2;
            this.father = r3;
        }

        private int depth() {
            MethodItem r0 = this.item;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.depth;
        }

        private void add(TreeNode r1) {
            this.nextNode.addFirst(r1);
        }

        private boolean isLeaf() {
            return this.nextNode.isEmpty();
        }
    }

    public static int getMethodId(long r2) {
        return (int) ((r2 >> 43) & 1048575);
    }

    private static long getTime(long r2) {
        return r2 & 8796093022207L;
    }

    private static boolean isIn(long r2) {
        if (((r2 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public TraceDataUtils() {
    }

    public static void structuredDataToStack(long[] r7, LinkedList<MethodItem> r8, long r9, int r11) {
        structuredDataToStack(MethodCollector.METHOD_ID_DISPATCH, r7, r8, true, r9, r11);
    }

    public static void structuredDataToStack(long[] r7, LinkedList<MethodItem> r8, boolean r9, long r10) {
        structuredDataToStack(MethodCollector.METHOD_ID_DISPATCH, r7, r8, r9, r10, -1);
    }

    public static void structuredDataToStack(int r24, long[] r25, LinkedList<MethodItem> r26, boolean r27, long r28, int r30) {
        if (r25 != null) goto L5;
        return;
    L5:
        if (r25.length == 0) goto L117;
        int r4 = 1;
        long r7 = 0;
        if (r25[r25.length - 1] == 0) goto L10;
        long r5 = getTime(r25[r25.length - 1]);
    L11:
        int r3 = 0;
        int r9 = 0;
    L13:
        if (r9 >= r25.length) goto L18;
        if (getTime(r25[r9]) < r5) goto L18;
        r9 = r9 + 1;
    L18:
        if (r24 > 0) goto L20;
        int r6 = MethodCollector.METHOD_ID_DISPATCH;
    L21:
        LinkedList r8 = new LinkedList();
        int r10 = 0;
        int r11 = 0;
    L23:
        if (r9 >= r25.length) goto L73;
        long r16 = r25[r9];
        if (r7 != r16) goto L27;
    L26:
        long r22 = r7;
    L72:
        r9 = r9 + 1;
        r7 = r22;
        r3 = 0;
        r4 = 1;
        goto L23
    L27:
        if (r27 == false) goto L38;
        if (isIn(r16) == true) goto L31;
    L33:
        if (r11 != 0) goto L38;
        if (getMethodId(r16) <= 1048000) goto L26;
        Object[] r12 = new Object[2];
        r12[r3] = Integer.valueOf(getMethodId(r16));
        r12[r4] = Boolean.valueOf(isIn(r16));
        MethodLogger.i("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", r12);
        goto L26
    L31:
        if (r6 != getMethodId(r16)) goto L33;
        r11 = r4;
    L38:
        if (isIn(r16) == true) goto L40;
        int r13 = getMethodId(r16);
        if (r8.isEmpty() == true) goto L69;
        long r18 = ((Long) r8.pop()).longValue();
        r10 = r10 - 1;
        LinkedList r14 = new LinkedList();
        r14.push(Long.valueOf(r18));
    L46:
        int r15 = getMethodId(r18);
        if (r15 == r13) goto L54;
        if (r8.isEmpty() == true) goto L54;
        if (ApmContext.isDebugMode() == false) goto L53;
        Object[] r17 = new Object[2];
        r17[r3] = Integer.valueOf(r15);
        r17[r4] = Integer.valueOf(r13);
        MethodLogger.w(TAG, "pop inMethodId[%s] to continue match ouMethodId[%s]", r17);
    L53:
        r18 = ((Long) r8.pop()).longValue();
        r10 = r10 - 1;
        r14.push(Long.valueOf(r18));
    L54:
        if (r15 == r13) goto L57;
        if (r15 != r6) goto L57;
        ApmContext.isDebugMode();
        r8.addAll(r14);
        r10 = r10 + r8.size();
    L68:
        r22 = 0;
    L57:
        long r19 = getTime(r16) + MethodCollector.getDiffTime();
    L59:
        if (r14.size() == 0) goto L68;
        long r110 = getTime(((Long) r14.pop()).longValue()) + MethodCollector.getDiffTime();
        long r20 = r19 - r110;
        if (r20 < 0) goto L63;
        addMethodItem(r26, new MethodItem(r13, (int) r20, r110, r10));
        goto L59
    L63:
        if (ApmContext.isDebugMode() == false) goto L65;
        MethodLogger.e(TAG, "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r20)});
    L65:
        r8.clear();
        r26.clear();
        return;
    L69:
        r22 = r7;
        if (ApmContext.isDebugMode() == false) goto L72;
        MethodLogger.w(TAG, "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r13)});
        goto L72
    L40:
        if (getMethodId(r16) != r6) goto L42;
        r8.clear();
        r10 = r3;
    L42:
        r10 = r10 + r4;
        r8.push(Long.valueOf(r16));
        goto L26
    L73:
        MethodLogger.i("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r26.size() + ", " + r8.size(), new Object[0]);
    L75:
        if (r8.isEmpty() == true) goto L90;
        long r21 = ((Long) r8.pop()).longValue();
        int r111 = getMethodId(r21);
        boolean r0 = isIn(r21);
        long r112 = getTime(r21) + MethodCollector.getDiffTime();
        if (ApmContext.isDebugMode() == false) goto L79;
        MethodLogger.w(TAG, "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r111), Boolean.valueOf(r0), Long.valueOf(r112), Long.valueOf(r28), Integer.valueOf(r8.size())});
    L79:
        if (r0 == false) goto L81;
        if (r30 <= 0) goto L86;
        boolean r23 = true;
    L87:
        if (r23 == false) goto L89;
        if (r10 > r30) goto L75;
    L89:
        addMethodItem(r26, new MethodItem(r111, (int) (r28 - r112), r112, r8.size()));
        goto L75
    L86:
        r23 = false;
        goto L87
    L81:
        if (ApmContext.isDebugMode() == false) goto L75;
        MethodLogger.e(TAG, "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r111)});
        goto L75
    L90:
        TreeNode r1 = new TreeNode(null, null);
        stackToTree(r26, r1);
        r26.clear();
        treeToStack(r1, r26);
        return;
    L20:
        r6 = r24;
        goto L21
    L10:
        r5 = Long.MAX_VALUE;
        goto L11
    }

    private static int addMethodItem(LinkedList<MethodItem> r3, MethodItem r4) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Log.v(TAG, "method:" + r4);
    L6:
        if (r3.isEmpty() == true) goto L8;
        MethodItem r0 = r3.peek();
    L9:
        if (r0 != null) goto L11;
    L22:
        r3.push(r4);
        return r4.durTime;
    L11:
        if (r0.methodId != r4.methodId) goto L22;
        if (r0.depth != r4.depth) goto L22;
        if (r4.depth == 0) goto L22;
        if (r4.durTime != 5000) goto L19;
        int r5 = r0.durTime;
    L20:
        r4.durTime = r5;
        r0.mergeMore(r4.durTime);
        return r0.durTime;
    L19:
        r5 = r4.durTime;
        goto L20
    L8:
        r0 = null;
        goto L9
    }

    private static void rechange(TreeNode r5) {
        if (r5.nextNode.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = r5.nextNode.size();
        TreeNode[] r1 = new TreeNode[r0];
        r5.nextNode.toArray(r1);
        r5.nextNode.clear();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        TreeNode r3 = r1[r2];
        r5.nextNode.addFirst(r3);
        rechange(r3);
        r2 = r2 + 1;
        goto L6
    }

    private static void treeToStack(TreeNode r3, LinkedList<MethodItem> r4) {
        LinkedList r0 = new LinkedList();
    L3:
        if (r3 == null) goto L13;
        if (r3.item == null) goto L7;
        r4.add(r3.item);
    L7:
        LinkedList<TreeNode> r5 = r3.nextNode;
        if (r5.isEmpty() == true) goto L12;
        int r1 = r5.size() - 1;
    L10:
        if (r1 < 0) goto L12;
        r0.add(r5.get(r1));
        r1 = r1 - 1;
    L12:
        r3 = (TreeNode) r0.pollLast();
        goto L3
    }

    public static int stackToTree(LinkedList<MethodItem> r6, TreeNode r7) {
        ListIterator<MethodItem> r8 = r6.listIterator(0);
        TreeNode r1 = null;
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L31;
        TreeNode r3 = new TreeNode(r8.next(), r1);
        r2 = r2 + 1;
        if (r1 == null) goto L8;
    L13:
        int r4 = TreeNode.access$000(r3);
        if (r1 == null) goto L29;
        if (r4 == 0) goto L29;
        if (TreeNode.access$000(r1) < r4) goto L28;
    L19:
        if (r1 == null) goto L23;
        if (TreeNode.access$000(r1) <= r4) goto L23;
        r1 = r1.father;
    L23:
        if (r1 == null) goto L4;
        if (r1.father == null) goto L30;
        r3.father = r1.father;
        TreeNode.access$100(r1.father, r3);
    L30:
        r1 = r3;
        goto L4
    L28:
        TreeNode.access$100(r1, r3);
    L29:
        TreeNode.access$100(r7, r3);
        goto L30
    L8:
        if (TreeNode.access$000(r3) == 0) goto L13;
        if (ApmContext.isDebugMode() == false) goto L12;
        MethodLogger.e(TAG, "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L12:
        return 0;
    L31:
        MethodLogger.i("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r2)});
        return r2;
    }

    public static long stackToString(LinkedList<MethodItem> r5, StringBuilder r6) {
        Iterator<MethodItem> r7 = r5.iterator();
        long r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        MethodItem r2 = r7.next();
        r6.append(r2.toString()).append('\n');
        if (r0 >= r2.durTime) goto L4;
        r0 = r2.durTime;
        goto L4
    L8:
        return r0;
    }

    public static int countTreeNode(TreeNode r2) {
        int r0 = r2.nextNode.size();
        Iterator<TreeNode> r3 = r2.nextNode.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 + countTreeNode(r3.next());
        goto L4
    L6:
        return r0;
    }

    public static void printTree(TreeNode r2, StringBuilder r3) {
        r3.append("|*   TraceStack: ").append("\n");
        printTree(r2, 0, r3, "|*        ");
    }

    public static void printTree(TreeNode r5, int r6, StringBuilder r7, String r8) {
        StringBuilder r0 = new StringBuilder(r8);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 > r6) goto L6;
        r0.append("    ");
        r2 = r2 + 1;
    L6:
        if (r1 >= r5.nextNode.size()) goto L11;
        TreeNode r3 = r5.nextNode.get(r1);
        r7.append(r0.toString()).append(r3.item.methodId).append("[").append(r3.item.durTime).append("]").append("\n");
        if (r3.nextNode.isEmpty() == true) goto L10;
        printTree(r3, r6 + 1, r7, r8);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    public static void trimStack(List<MethodItem> r1, int r2) {
        ListIterator<MethodItem> r3 = r1.listIterator(r1.size());
    L4:
        if (r3.hasPrevious() == false) goto L10;
        MethodItem r0 = r3.previous();
        if (r0 == null) goto L4;
        if (r0.durTime >= r2) goto L4;
        r3.remove();
        goto L4
    }

    public static void trimStack(List<MethodItem> r5, int r6, IStructuredDataFilter r7) {
        if (r6 >= 0) goto L5;
        r5.clear();
        return;
    L5:
        int r0 = r5.size();
        int r1 = 1;
    L6:
        if (r0 <= r6) goto L17;
        ListIterator<MethodItem> r2 = r5.listIterator(r5.size());
    L9:
        if (r2.hasPrevious() == false) goto L15;
        if (r7.isFilter(r2.previous().durTime, r1) == false) goto L9;
        r2.remove();
        r0 = r0 - 1;
        if (r0 > r6) goto L9;
        return;
    L15:
        r0 = r5.size();
        r1 = r1 + 1;
        if (r7.getFilterMaxCount() >= r1) goto L6;
    L17:
        int r3 = r5.size();
        if (r3 <= r6) goto L30;
        r7.fallback(r5, r3);
        return;
    }

    public static void simplyTrimStack(List<MethodItem> r1, int r2) {
        if (r2 >= 0) goto L5;
        r1.clear();
        return;
    L5:
        ListIterator<MethodItem> r3 = r1.listIterator(r1.size());
    L7:
        if (r3.hasPrevious() == false) goto L11;
        if (r3.previous().durTime >= r2) goto L7;
        r3.remove();
        goto L7
    }

    @Deprecated
    public static String getTreeKey(List<MethodItem> r2, final int r3) {
        StringBuilder r0 = new StringBuilder();
        LinkedList r1 = new LinkedList(r2);
        trimStack(r1, r3, new AnonymousClass1(r3));
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.append(((MethodItem) r4.next()).methodId + "|");
        goto L4
    L7:
        return r0.toString();
    }

    public static String getTreeKey(List<MethodItem> r6, long r7) {
        StringBuilder r0 = new StringBuilder();
        long r8 = (long) (r7 * 0.3f);
        LinkedList r1 = new LinkedList();
        Iterator<MethodItem> r2 = r6.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        MethodItem r3 = r2.next();
        if (r3.durTime < r8) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Collections.sort(r1, new AnonymousClass2());
        if (r1.isEmpty() == false) goto L14;
        if (r6.isEmpty() == true) goto L14;
        r1.add(r6.get(0));
    L18:
        Iterator r9 = r1.iterator();
        if (r9.hasNext() == false) goto L22;
        r0.append(((MethodItem) r9.next()).methodId + "\n");
    L22:
        return r0.toString();
    L14:
        if (r1.size() <= 1) goto L18;
        if (((MethodItem) r1.peek()).methodId != 1048574) goto L18;
        r1.removeFirst();
        goto L18
    }
}
