package rc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* renamed from: rc.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5286i {

    /* renamed from: rc.i$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f39316a;

        /* renamed from: b, reason: collision with root package name */
        public Q f39317b;

        public a(int i10, Q q10) {
            this.f39316a = i10;
            this.f39317b = q10;
        }
    }

    public static float a(Stack<a> stack, Q q10, float f10) {
        LinkedList<AbstractC5284h> linkedList = q10.f39310i;
        float[] fArr = new float[linkedList.size() + 1];
        int i10 = 0;
        fArr[0] = 0.0f;
        while (i10 < linkedList.size()) {
            AbstractC5284h abstractC5284h = linkedList.get(i10);
            int i11 = i10 + 1;
            float f11 = fArr[i10] + abstractC5284h.f39305d;
            fArr[i11] = f11;
            if (f11 > f10) {
                int iB = b(q10, i10);
                if (abstractC5284h instanceof Q) {
                    Stack stack2 = new Stack();
                    float fA = a(stack2, (Q) abstractC5284h, f10 - fArr[i10]);
                    if (fA != abstractC5284h.f39305d && (fArr[i10] + fA <= f10 || iB == -1)) {
                        stack.push(new a(i10 - 1, q10));
                        stack.addAll(stack2);
                        return fArr[i10] + fA;
                    }
                }
                if (iB != -1) {
                    stack.push(new a(iB, q10));
                    return fArr[iB];
                }
            }
            i10 = i11;
        }
        return q10.f39305d;
    }

    public static int b(Q q10, int i10) {
        List<Integer> list = q10.f39147o;
        if (list == null) {
            return -1;
        }
        int i11 = 0;
        if (list.size() == 1 && q10.f39147o.get(0).intValue() <= i10) {
            return q10.f39147o.get(0).intValue();
        }
        while (i11 < q10.f39147o.size()) {
            if (q10.f39147o.get(i11).intValue() > i10) {
                if (i11 == 0) {
                    return -1;
                }
                return q10.f39147o.get(i11 - 1).intValue();
            }
            i11++;
        }
        return q10.f39147o.get(i11 - 1).intValue();
    }

    public static AbstractC5284h c(AbstractC5284h abstractC5284h, float f10, float f11) {
        return abstractC5284h instanceof Q ? d((Q) abstractC5284h, f10, f11) : abstractC5284h instanceof q1 ? e((q1) abstractC5284h, f10, f11) : abstractC5284h;
    }

    public static AbstractC5284h d(Q q10, float f10, float f11) {
        q1 q1Var = new q1();
        Stack stack = new Stack();
        AbstractC5284h abstractC5284h = null;
        Q q11 = q10;
        while (q11.f39305d > f10 && a(stack, q11, f10) != q11.f39305d) {
            a aVar = (a) stack.pop();
            Q[] qArrU = aVar.f39317b.u(aVar.f39316a - 1);
            Q q12 = qArrU[0];
            Q q13 = qArrU[1];
            while (!stack.isEmpty()) {
                a aVar2 = (a) stack.pop();
                Q[] qArrW = aVar2.f39317b.w(aVar2.f39316a);
                qArrW[0].b(q12);
                qArrW[1].a(0, q13);
                q12 = qArrW[0];
                q13 = qArrW[1];
            }
            q1Var.r(q12, f11);
            abstractC5284h = q13;
            q11 = q13;
        }
        if (abstractC5284h == null) {
            return q11;
        }
        q1Var.r(abstractC5284h, f11);
        return q1Var;
    }

    public static AbstractC5284h e(q1 q1Var, float f10, float f11) {
        q1 q1Var2 = new q1();
        Iterator<AbstractC5284h> it = q1Var.f39310i.iterator();
        while (it.hasNext()) {
            q1Var2.b(c(it.next(), f10, f11));
        }
        return q1Var2;
    }
}
