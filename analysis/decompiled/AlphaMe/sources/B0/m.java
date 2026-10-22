package B0;

import K.InterfaceC0088u;
import android.content.Context;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.room.A;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Property;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import l1.C0758c;
import l1.InterfaceC0757b;
import p1.C0814a;
import stepos.support.v7.app.U;

/* loaded from: classes.dex */
public final class m implements InterfaceC0757b, InterfaceC0088u, G1.p, x3.e, stepos.support.v7.permission.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f154a;

    /* renamed from: b, reason: collision with root package name */
    public Object f155b;

    /* renamed from: c, reason: collision with root package name */
    public Object f156c;

    public m(int i4) {
        com.google.android.gms.common.b bVar = com.google.android.gms.common.b.f9701c;
        this.f154a = 6;
        this.f155b = new SparseIntArray();
        this.f156c = bVar;
    }

    @Override // l1.InterfaceC0757b
    public final void a(l1.h hVar) {
        ((Map) ((m3.i) this.f156c).f13621b).remove((C0758c) this.f155b);
    }

    public final void b(int i4, int i5, int i6, int i7) {
        ((CardView) this.f156c).f3225d.set(i4, i5, i6, i7);
        Object obj = this.f156c;
        super/*android.view.View*/.setPadding(i4 + ((CardView) obj).f3224c.left, i5 + ((CardView) obj).f3224c.top, i6 + ((CardView) obj).f3224c.right, i7 + ((CardView) obj).f3224c.bottom);
    }

    public final int c(Context context, com.google.android.gms.common.internal.e eVar) {
        com.stepos.statsrpk.c.l(context);
        com.stepos.statsrpk.c.l(eVar);
        int iE = eVar.e();
        int iB = ((SparseIntArray) this.f155b).get(iE, -1);
        if (iB == -1) {
            iB = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= ((SparseIntArray) this.f155b).size()) {
                    iB = -1;
                    break;
                }
                int iKeyAt = ((SparseIntArray) this.f155b).keyAt(i4);
                if (iKeyAt > iE && ((SparseIntArray) this.f155b).get(iKeyAt) == 0) {
                    break;
                }
                i4++;
            }
            if (iB == -1) {
                iB = ((com.google.android.gms.common.c) this.f156c).b(iE, context);
            }
            ((SparseIntArray) this.f155b).put(iE, iB);
        }
        return iB;
    }

    @Override // x3.e
    public final Object call(Object obj) {
        A3.g gVar;
        x3.a aVar = (x3.a) obj;
        A3.f fVar = (A3.f) ((A3.h) this.f155b).f95a.get();
        int i4 = fVar.f89a;
        if (i4 == 0) {
            gVar = A3.h.f93c;
        } else {
            long j4 = fVar.f91c;
            fVar.f91c = 1 + j4;
            gVar = fVar.f90b[(int) (j4 % i4)];
        }
        return gVar.g(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    @Override // K.InterfaceC0088u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final K.z0 e(android.view.View r17, K.z0 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.Object r3 = r0.f155b
            p1.a r3 = (p1.C0814a) r3
            java.lang.Object r0 = r0.f156c
            com.google.android.material.internal.o r0 = (com.google.android.material.internal.o) r0
            int r4 = r0.f10865a
            r3.getClass()
            K.x0 r5 = r2.f1023a
            r6 = 7
            D.c r6 = r5.f(r6)
            r7 = 32
            D.c r5 = r5.f(r7)
            java.lang.Object r7 = r3.f13924b
            com.google.android.material.bottomsheet.BottomSheetBehavior r7 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r7
            int r8 = r6.f358b
            r7.f10459w = r8
            int r8 = r17.getLayoutDirection()
            r10 = 1
            if (r8 != r10) goto L31
            r8 = r10
            goto L32
        L31:
            r8 = 0
        L32:
            int r11 = r17.getPaddingBottom()
            int r12 = r17.getPaddingLeft()
            int r13 = r17.getPaddingRight()
            boolean r14 = r7.f10451o
            if (r14 == 0) goto L4b
            int r11 = r18.a()
            r7.f10458v = r11
            int r14 = r0.f10867c
            int r11 = r11 + r14
        L4b:
            boolean r14 = r7.f10452p
            int r0 = r0.f10866b
            int r15 = r6.f357a
            if (r14 == 0) goto L59
            if (r8 == 0) goto L57
            r12 = r0
            goto L58
        L57:
            r12 = r4
        L58:
            int r12 = r12 + r15
        L59:
            boolean r14 = r7.f10453q
            int r9 = r6.f359c
            if (r14 == 0) goto L65
            if (r8 == 0) goto L62
            goto L63
        L62:
            r4 = r0
        L63:
            int r13 = r4 + r9
        L65:
            android.view.ViewGroup$LayoutParams r0 = r17.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            boolean r4 = r7.f10455s
            if (r4 == 0) goto L77
            int r4 = r0.leftMargin
            if (r4 == r15) goto L77
            r0.leftMargin = r15
            r4 = r10
            goto L78
        L77:
            r4 = 0
        L78:
            boolean r8 = r7.f10456t
            if (r8 == 0) goto L83
            int r8 = r0.rightMargin
            if (r8 == r9) goto L83
            r0.rightMargin = r9
            goto L84
        L83:
            r10 = r4
        L84:
            boolean r4 = r7.f10457u
            if (r4 == 0) goto L91
            int r4 = r0.topMargin
            int r6 = r6.f358b
            if (r4 == r6) goto L91
            r0.topMargin = r6
            goto L93
        L91:
            if (r10 == 0) goto L96
        L93:
            r1.setLayoutParams(r0)
        L96:
            int r0 = r17.getPaddingTop()
            r1.setPadding(r12, r0, r13, r11)
            boolean r0 = r3.f13923a
            if (r0 == 0) goto La5
            int r1 = r5.f360d
            r7.f10449m = r1
        La5:
            boolean r1 = r7.f10451o
            if (r1 != 0) goto Lab
            if (r0 == 0) goto Lae
        Lab:
            r7.t()
        Lae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.m.e(android.view.View, K.z0):K.z0");
    }

    public final boolean equals(Object obj) {
        switch (this.f154a) {
            case 4:
                if (!(obj instanceof J.b)) {
                    return false;
                }
                J.b bVar = (J.b) obj;
                Object obj2 = bVar.f848a;
                Object obj3 = this.f155b;
                if (obj2 != obj3 && (obj2 == null || !obj2.equals(obj3))) {
                    return false;
                }
                Object obj4 = this.f156c;
                Object obj5 = bVar.f849b;
                return obj5 == obj4 || (obj5 != null && obj5.equals(obj4));
            default:
                return super.equals(obj);
        }
    }

    public final int hashCode() {
        switch (this.f154a) {
            case 4:
                Object obj = this.f155b;
                int iHashCode = obj == null ? 0 : obj.hashCode();
                Object obj2 = this.f156c;
                return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            default:
                return super.hashCode();
        }
    }

    @Override // G1.p
    public final Object i() {
        throw new F1.q((String) this.f155b, 5);
    }

    @Override // stepos.support.v7.permission.e
    public final void onPrivacyPolicyClick(Context context) {
        Object obj = this.f156c;
        if (((U) obj).f14342f != null) {
            ((U) obj).f14342f.onClick((TextView) this.f155b);
        }
    }

    @Override // stepos.support.v7.permission.e
    public final void onUserAgreementClick(Context context) {
        Object obj = this.f156c;
        if (((U) obj).f14343g != null) {
            ((U) obj).f14343g.onClick((TextView) this.f155b);
        }
    }

    public final String toString() {
        switch (this.f154a) {
            case 4:
                return "Pair{" + String.valueOf(this.f155b) + AwarenessDataItem.PERMISSION_SPLITTER + String.valueOf(this.f156c) + "}";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(int i4, int i5) {
        this();
        this.f154a = i4;
        if (i4 != 9) {
            return;
        }
    }

    public /* synthetic */ m(int i4, Object obj, Object obj2) {
        this.f154a = i4;
        this.f156c = obj;
        this.f155b = obj2;
    }

    public m(A a4) {
        this.f154a = 0;
        this.f155b = a4;
        this.f156c = new b(this, a4, 3);
    }

    public m(C0814a c0814a, com.google.android.material.internal.o oVar) {
        this.f154a = 7;
        this.f155b = c0814a;
        this.f156c = oVar;
    }

    public m() {
        this.f154a = 9;
        this.f155b = new W.h(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        this.f156c = new W.h(1.0f, Property.DEFAULT_FLOAT_VALUE);
    }

    public m(CardView cardView) {
        this.f154a = 1;
        this.f156c = cardView;
    }
}
