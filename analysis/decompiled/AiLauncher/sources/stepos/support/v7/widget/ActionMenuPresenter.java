package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.R$string;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.E;
import androidx.core.view.AbstractC1314b;
import com.stepos.common.R$dimen;
import java.util.ArrayList;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$integer;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.ActionMenuView;
import u0.C5566a;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class ActionMenuPresenter extends stepos.support.v7.view.menu.a implements AbstractC1314b.a {

    /* renamed from: A, reason: collision with root package name */
    public final SparseBooleanArray f41153A;

    /* renamed from: B, reason: collision with root package name */
    public View f41154B;

    /* renamed from: C, reason: collision with root package name */
    public h f41155C;

    /* renamed from: D, reason: collision with root package name */
    public c f41156D;

    /* renamed from: E, reason: collision with root package name */
    public f f41157E;

    /* renamed from: F, reason: collision with root package name */
    public d f41158F;

    /* renamed from: G, reason: collision with root package name */
    public final i f41159G;

    /* renamed from: H, reason: collision with root package name */
    public int f41160H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f41161I;

    /* renamed from: k, reason: collision with root package name */
    public g f41162k;

    /* renamed from: l, reason: collision with root package name */
    public TouchDelegate f41163l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f41164m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f41165n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f41166o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f41167p;

    /* renamed from: q, reason: collision with root package name */
    public int f41168q;

    /* renamed from: r, reason: collision with root package name */
    public int f41169r;

    /* renamed from: s, reason: collision with root package name */
    public int f41170s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f41171t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f41172u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f41173v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f41174w;

    /* renamed from: x, reason: collision with root package name */
    public int f41175x;

    /* renamed from: y, reason: collision with root package name */
    public int f41176y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f41177z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41178a;

        public a(View view) {
            this.f41178a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f41178a;
            if (view == null || view.getWindowToken() == null || !ActionMenuPresenter.this.f41156D.r()) {
                return;
            }
            this.f41178a.setAlpha(0.2f);
        }
    }

    public class b implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41180a;

        public b(View view) {
            this.f41180a = view;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            this.f41180a.setAlpha(1.0f);
        }
    }

    public class c extends stepos.support.v7.view.menu.f {

        /* renamed from: w, reason: collision with root package name */
        public stepos.support.v7.view.menu.i f41182w;

        public c(Context context, stepos.support.v7.view.menu.i iVar) {
            super(context, iVar, null, false, ActionMenuPresenter.this.Q() ? R$attr.steposActionOverflowMenuSplitStyle : androidx.appcompat.R$attr.actionOverflowMenuStyle);
            this.f41182w = iVar;
            if (!((stepos.support.v7.view.menu.e) iVar.getItem()).m()) {
                t(ActionMenuPresenter.this.f41162k == null ? (View) ActionMenuPresenter.this.f40915i : ActionMenuPresenter.this.f41162k);
            }
            u(ActionMenuPresenter.this.f41159G);
            int size = iVar.size();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                MenuItem item = iVar.getItem(i10);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            v(z10);
        }

        @Override // stepos.support.v7.view.menu.f, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter.this.f41156D = null;
            ActionMenuPresenter.this.f41160H = 0;
        }
    }

    public class d extends ActionMenuItemView.c {
        public d() {
        }

        @Override // stepos.support.v7.view.menu.ActionMenuItemView.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public o a() {
            if (ActionMenuPresenter.this.f41156D != null) {
                return ActionMenuPresenter.this.f41156D.p();
            }
            return null;
        }

        public /* synthetic */ d(ActionMenuPresenter actionMenuPresenter, a aVar) {
            this();
        }
    }

    public class e extends Gc.b {
        public e(View view) {
            super(view, R$attr.steposActionButtonRippleSplitStyle);
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public h f41186a;

        public f(h hVar) {
            this.f41186a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuPresenter.this.f40909c.d();
            View view = (View) ActionMenuPresenter.this.f40915i;
            if (view != null && view.getWindowToken() != null && this.f41186a.y()) {
                ActionMenuPresenter.this.f41155C = this.f41186a;
                ActionMenuPresenter.this.f41162k.setAlpha(0.2f);
            }
            ActionMenuPresenter.this.f41157E = null;
        }
    }

    public class g extends AppCompatImageView implements ActionMenuView.b {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f41188a;

        /* renamed from: b, reason: collision with root package name */
        public final int f41189b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f41190c;

        /* renamed from: d, reason: collision with root package name */
        public final float f41191d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f41192e;

        public class a extends E {

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f41194j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f41194j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.E
            public boolean c() {
                ActionMenuPresenter.this.a0();
                return true;
            }

            @Override // androidx.appcompat.widget.E
            public boolean d() {
                if (ActionMenuPresenter.this.f41157E != null) {
                    return false;
                }
                ActionMenuPresenter.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.E
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public o b() {
                if (ActionMenuPresenter.this.f41155C == null) {
                    return null;
                }
                return ActionMenuPresenter.this.f41155C.p();
            }
        }

        public g(Context context) {
            super(context, null, ActionMenuPresenter.this.f41161I ? R$attr.steposActionOverflowButtonSplitStyle : androidx.appcompat.R$attr.actionOverflowButtonStyle);
            this.f41188a = new float[2];
            this.f41189b = -65536;
            setId(R$id.stepos_action_overflow_button);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
            if (ActionMenuPresenter.this.Q()) {
                setBackgroundDrawable(ActionMenuPresenter.this.new e(this));
            }
            if (ActionMenuPresenter.this.f41177z != null) {
                setImageDrawable(ActionMenuPresenter.this.f41177z);
            }
            setContentDescription(getResources().getString(R$string.abc_action_menu_overflow_description));
            this.f41191d = context.getResources().getDimension(R$dimen.mc_new_message_view_radius);
            Paint paint = new Paint();
            this.f41190c = paint;
            paint.setAntiAlias(true);
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.FILL);
        }

        @Override // stepos.support.v7.widget.ActionMenuView.b
        public boolean a() {
            return false;
        }

        @Override // stepos.support.v7.widget.ActionMenuView.b
        public boolean b() {
            return false;
        }

        public void f(boolean z10) {
            if (this.f41192e != z10) {
                this.f41192e = z10;
                invalidate();
            }
        }

        @Override // android.widget.ImageView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f41192e) {
                try {
                    Matrix matrix = (Matrix) O6.r.b(this).b("mDrawMatrix").get(this);
                    canvas.save();
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                    if (matrix != null) {
                        canvas.concat(matrix);
                    }
                    float f10 = getDrawable().getBounds().right;
                    float f11 = this.f41191d;
                    canvas.drawCircle(f10 + f11, r0.top + f11, f11, this.f41190c);
                    canvas.restore();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            int i14 = (int) (getResources().getDisplayMetrics().density * 52.0f);
            int i15 = i12 - i10;
            if (i15 < i14) {
                int i16 = (i14 - i15) / 2;
                Rect rect = new Rect(i10 - i16, i11, i12 + i16, i13);
                View view = (View) getParent();
                ActionMenuPresenter.this.f41163l = new TouchDelegate(rect, this);
                view.setTouchDelegate(ActionMenuPresenter.this.f41163l);
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.a0();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            int paddingLeft = getPaddingLeft() - getPaddingRight();
            int paddingTop = getPaddingTop() - getPaddingBottom();
            if (drawable != null && background != null && (paddingLeft != 0 || paddingTop != 0)) {
                int width = getWidth();
                int height = getHeight();
                int i14 = width / 2;
                int i15 = height / 2;
                int i16 = (width + paddingLeft) / 2;
                int i17 = (height + paddingTop) / 2;
                C5566a.l(background, i16 - i14, i17 - i15, i16 + i14, i17 + i15);
            }
            return frame;
        }
    }

    public class h extends stepos.support.v7.view.menu.f {
        public h(Context context, stepos.support.v7.view.menu.c cVar, View view, boolean z10) {
            super(context, cVar, view, z10, ActionMenuPresenter.this.Q() ? R$attr.steposActionOverflowMenuSplitStyle : androidx.appcompat.R$attr.actionOverflowMenuStyle);
            n(ActionMenuPresenter.this.Q() ? 4 : 3);
            w(8388613);
            u(ActionMenuPresenter.this.f41159G);
        }

        @Override // stepos.support.v7.view.menu.f, android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.f40909c != null) {
                ActionMenuPresenter.this.f40909c.close();
            }
            ActionMenuPresenter.this.f41155C = null;
            ActionMenuPresenter.this.f41162k.setAlpha(1.0f);
        }
    }

    public class i implements g.a {
        public i() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
            if (cVar instanceof stepos.support.v7.view.menu.i) {
                cVar.D().e(false);
            }
            g.a aVarL = ActionMenuPresenter.this.l();
            if (aVarL != null) {
                aVarL.a(cVar, z10);
            }
        }

        @Override // stepos.support.v7.view.menu.g.a
        public boolean b(stepos.support.v7.view.menu.c cVar) {
            if (cVar == null) {
                return false;
            }
            ActionMenuPresenter.this.f41160H = ((stepos.support.v7.view.menu.i) cVar).getItem().getItemId();
            g.a aVarL = ActionMenuPresenter.this.l();
            return aVarL != null && aVarL.b(cVar);
        }

        public /* synthetic */ i(ActionMenuPresenter actionMenuPresenter, a aVar) {
            this();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.stepos_abc_action_menu_layout, R$layout.stepos_action_menu_item_layout);
        this.f41153A = new SparseBooleanArray();
        this.f41159G = new i(this, null);
    }

    public boolean I() {
        return N() | M();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View J(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f40915i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof h.a) && ((h.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean K() {
        ArrayList<stepos.support.v7.view.menu.e> arrayListE = this.f40909c.E();
        int size = arrayListE.size();
        int i10 = this.f41168q;
        boolean z10 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            stepos.support.v7.view.menu.e eVar = arrayListE.get(i13);
            if (eVar.s()) {
                i11++;
            } else if (eVar.r()) {
                i12++;
            } else {
                z10 = true;
            }
        }
        boolean z11 = this.f41166o && z10;
        SparseBooleanArray sparseBooleanArray = this.f41153A;
        sparseBooleanArray.clear();
        int i14 = this.f41172u ? i10 / this.f41176y : 0;
        int i15 = i11 + i12;
        if ((i15 > i14) | z11) {
            i14--;
        }
        if (i15 >= i14) {
            i15 = i14;
        }
        int i16 = 0;
        while (i16 < size && i15 > 0) {
            stepos.support.v7.view.menu.e eVar2 = arrayListE.get(i16);
            if (eVar2.s() || eVar2.r()) {
                i15--;
                eVar2.y(true);
                int groupId = eVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
            } else {
                eVar2.y(false);
            }
            i16++;
        }
        for (int i17 = i16; i17 < size; i17++) {
            arrayListE.get(i16).y(false);
        }
        return true;
    }

    public Drawable L() {
        g gVar = this.f41162k;
        if (gVar != null) {
            return gVar.getDrawable();
        }
        if (this.f41165n) {
            return this.f41164m;
        }
        return null;
    }

    public boolean M() {
        Object obj;
        f fVar = this.f41157E;
        if (fVar != null && (obj = this.f40915i) != null) {
            ((View) obj).removeCallbacks(fVar);
            this.f41157E = null;
            return true;
        }
        h hVar = this.f41155C;
        if (hVar == null) {
            return false;
        }
        hVar.o();
        return true;
    }

    public boolean N() {
        c cVar = this.f41156D;
        if (cVar == null) {
            return false;
        }
        cVar.o();
        return true;
    }

    public boolean O() {
        return this.f41157E != null || P();
    }

    public boolean P() {
        h hVar = this.f41155C;
        return hVar != null && hVar.r();
    }

    public boolean Q() {
        return this.f41161I;
    }

    public void R(Configuration configuration) {
        if (!this.f41171t) {
            this.f41170s = this.f40908b.getResources().getInteger(R$integer.abc_max_action_buttons);
        }
        stepos.support.v7.view.menu.c cVar = this.f40909c;
        if (cVar != null) {
            cVar.J(true);
        }
    }

    public void S(boolean z10) {
        this.f41174w = z10;
    }

    public void T(boolean z10) {
        if (this.f41161I != z10) {
            this.f41161I = z10;
            q(z10 ? R$layout.stepos_action_menu_item_split_layout : R$layout.stepos_action_menu_item_layout);
            Object obj = this.f40915i;
            if (obj != null) {
                ((ViewGroup) obj).removeAllViews();
            }
            if (z10) {
                return;
            }
            this.f41167p = false;
            this.f41173v = false;
            this.f41171t = false;
            g(this.f40908b, this.f40909c);
        }
    }

    public void U(int i10) {
        this.f41170s = i10;
        this.f41171t = true;
    }

    public void V(ActionMenuView actionMenuView) {
        this.f40915i = actionMenuView;
        actionMenuView.a(this.f40909c);
    }

    public void W(Drawable drawable) {
        this.f41177z = drawable;
        g gVar = this.f41162k;
        if (gVar != null) {
            gVar.setImageDrawable(drawable);
        }
    }

    public void X(Drawable drawable) {
        g gVar = this.f41162k;
        if (gVar != null) {
            gVar.setImageDrawable(drawable);
        } else {
            this.f41165n = true;
            this.f41164m = drawable;
        }
    }

    public void Y(boolean z10) {
        this.f41166o = z10;
        this.f41167p = true;
    }

    public void Z(int i10, boolean z10) {
        this.f41168q = i10;
        this.f41172u = z10;
        this.f41173v = true;
    }

    @Override // stepos.support.v7.view.menu.a, stepos.support.v7.view.menu.g
    public void a(stepos.support.v7.view.menu.c cVar, boolean z10) {
        I();
        super.a(cVar, z10);
    }

    public boolean a0() {
        stepos.support.v7.view.menu.c cVar;
        if (!this.f41166o || P() || (cVar = this.f40909c) == null || this.f40915i == null || this.f41157E != null || cVar.z().isEmpty()) {
            return false;
        }
        f fVar = new f(new h(this.f40908b, this.f40909c, this.f41162k, true));
        this.f41157E = fVar;
        ((View) this.f40915i).post(fVar);
        super.e(null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // stepos.support.v7.view.menu.a, stepos.support.v7.view.menu.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r8) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuPresenter.b(boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    @Override // stepos.support.v7.view.menu.g
    public boolean c() {
        int i10;
        int iT;
        int i11;
        int i12;
        boolean z10;
        int i13;
        if (this.f41161I) {
            return K();
        }
        ArrayList<stepos.support.v7.view.menu.e> arrayListE = this.f40909c.E();
        int size = arrayListE.size();
        int i14 = this.f41170s;
        int i15 = this.f41169r;
        ?? r52 = 0;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f40915i;
        boolean z11 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            stepos.support.v7.view.menu.e eVar = arrayListE.get(i18);
            if (eVar.s()) {
                i16++;
            } else if (eVar.r()) {
                i17++;
            } else {
                z11 = true;
            }
            if (this.f41174w && eVar.isActionViewExpanded()) {
                i14 = 0;
            }
        }
        if (this.f41166o && (z11 || i17 + i16 > i14)) {
            i14--;
        }
        int i19 = i14 - i16;
        SparseBooleanArray sparseBooleanArray = this.f41153A;
        sparseBooleanArray.clear();
        if (this.f41172u) {
            int i20 = this.f41175x;
            iT = i15 / i20;
            i10 = i20 + ((i15 % i20) / iT);
        } else {
            i10 = 0;
            iT = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < size) {
            stepos.support.v7.view.menu.e eVar2 = arrayListE.get(i21);
            if (eVar2.s()) {
                View viewM = m(eVar2, this.f41154B, viewGroup);
                if (this.f41154B == null) {
                    this.f41154B = viewM;
                }
                if (this.f41172u) {
                    iT -= ActionMenuView.t(viewM, i10, iT, iMakeMeasureSpec, r52);
                } else {
                    viewM.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewM.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = eVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                eVar2.y(true);
                i11 = size;
                i12 = i19;
                z10 = r52;
            } else if (eVar2.r()) {
                int groupId2 = eVar2.getGroupId();
                boolean z12 = sparseBooleanArray.get(groupId2);
                boolean z13 = (i19 > 0 || z12) && i15 > 0 && (!this.f41172u || iT > 0);
                i11 = size;
                if (z13) {
                    View viewM2 = m(eVar2, this.f41154B, viewGroup);
                    i13 = i19;
                    if (this.f41154B == null) {
                        this.f41154B = viewM2;
                    }
                    if (this.f41172u) {
                        int iT2 = ActionMenuView.t(viewM2, i10, iT, iMakeMeasureSpec, 0);
                        iT -= iT2;
                        if (iT2 == 0) {
                            z13 = false;
                        }
                    } else {
                        viewM2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewM2.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i22 == 0) {
                        i22 = measuredWidth2;
                    }
                    z13 &= !this.f41172u ? i21 != 0 ? i15 < 0 : i15 + i22 <= 0 : i15 < 0;
                } else {
                    i13 = i19;
                }
                if (z13 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z12) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i23 = 0; i23 < i21; i23++) {
                        stepos.support.v7.view.menu.e eVar3 = arrayListE.get(i23);
                        if (eVar3.getGroupId() == groupId2) {
                            if (eVar3.m()) {
                                i13++;
                            }
                            eVar3.y(false);
                        }
                    }
                }
                int i24 = i13;
                if (z13) {
                    i24--;
                }
                eVar2.y(z13);
                i12 = i24;
                z10 = false;
            } else {
                i11 = size;
                i12 = i19;
                z10 = r52;
                eVar2.y(z10);
            }
            i21++;
            r52 = z10;
            size = i11;
            i19 = i12;
        }
        return true;
    }

    @Override // stepos.support.v7.view.menu.a, stepos.support.v7.view.menu.g
    public boolean e(stepos.support.v7.view.menu.i iVar) {
        if (!iVar.hasVisibleItems()) {
            return false;
        }
        stepos.support.v7.view.menu.i iVar2 = iVar;
        while (iVar2.c0() != this.f40909c) {
            iVar2 = (stepos.support.v7.view.menu.i) iVar2.c0();
        }
        View viewJ = J(iVar2.getItem());
        if (viewJ == null && (viewJ = this.f41162k) == null) {
            return false;
        }
        this.f41160H = iVar.getItem().getItemId();
        c cVar = new c(this.f40908b, iVar);
        this.f41156D = cVar;
        cVar.w(8388613);
        this.f41156D.n(4);
        this.f41156D.t(viewJ);
        this.f41156D.x();
        viewJ.post(new a(viewJ));
        this.f41156D.p().I(new b(viewJ));
        super.e(iVar);
        return true;
    }

    @Override // stepos.support.v7.view.menu.a, stepos.support.v7.view.menu.g
    public void g(Context context, stepos.support.v7.view.menu.c cVar) {
        super.g(context, cVar);
        Resources resources = context.getResources();
        Ic.a aVarB = Ic.a.b(context);
        if (!this.f41167p) {
            this.f41166o = aVarB.j();
        }
        if (!this.f41173v) {
            this.f41168q = aVarB.d();
        }
        if (!this.f41171t) {
            this.f41170s = aVarB.e();
        }
        int measuredWidth = this.f41168q;
        if (this.f41166o) {
            if (this.f41162k == null) {
                g gVar = new g(this.f40907a);
                this.f41162k = gVar;
                if (this.f41165n) {
                    gVar.setImageDrawable(this.f41164m);
                    this.f41164m = null;
                    this.f41165n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f41162k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f41162k.getMeasuredWidth();
        } else {
            this.f41162k = null;
        }
        this.f41169r = measuredWidth;
        this.f41175x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f41154B = null;
        this.f41176y = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    @Override // stepos.support.v7.view.menu.a
    public void h(View view, int i10) {
        super.h(view, i10);
        if ((this.f40915i instanceof ActionMenuView) && (view instanceof ActionMenuItemView)) {
            ((ActionMenuView.d) view.getLayoutParams()).f41212a = ((ActionMenuItemView) view).j();
        }
    }

    @Override // stepos.support.v7.view.menu.a
    public void i(stepos.support.v7.view.menu.e eVar, h.a aVar) {
        ((ActionMenuItemView) aVar).setIsInSplit(this.f41161I);
        aVar.d(eVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f40915i);
        if (this.f41158F == null) {
            this.f41158F = new d(this, null);
        }
        actionMenuItemView.setPopupCallback(this.f41158F);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // stepos.support.v7.view.menu.a
    public h.a j(ViewGroup viewGroup) {
        h.a aVarJ = super.j(viewGroup);
        if (aVarJ instanceof View) {
        }
        return aVarJ;
    }

    @Override // stepos.support.v7.view.menu.a
    public boolean k(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f41162k) {
            return false;
        }
        return super.k(viewGroup, i10);
    }

    @Override // stepos.support.v7.view.menu.a
    public View m(stepos.support.v7.view.menu.e eVar, View view, ViewGroup viewGroup) {
        View actionView = eVar.getActionView();
        if (actionView == null || eVar.k()) {
            actionView = super.m(eVar, view, viewGroup);
        }
        actionView.setVisibility(eVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
            return actionView;
        }
        if ((layoutParams instanceof ActionMenuView.d) && (actionView instanceof ActionMenuItemView)) {
            ((ActionMenuView.d) layoutParams).f41212a = ((ActionMenuItemView) actionView).j();
        }
        return actionView;
    }

    @Override // stepos.support.v7.view.menu.a
    public stepos.support.v7.view.menu.h n(ViewGroup viewGroup) {
        stepos.support.v7.view.menu.h hVarN = super.n(viewGroup);
        ((ActionMenuView) hVarN).setPresenter(this);
        return hVarN;
    }

    @Override // stepos.support.v7.view.menu.a
    public boolean r(int i10, stepos.support.v7.view.menu.e eVar) {
        return eVar.m();
    }
}
