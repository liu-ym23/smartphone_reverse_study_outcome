package stepos.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.i0;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.view.menu.ActionMenuItemView;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.ActionMenuView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class ActionMenuPresenter extends stepos.support.v7.view.menu.a {
    public Drawable A;
    public final SparseBooleanArray B;
    public View C;
    public h D;
    public c E;
    public f F;
    public d G;
    public final i H;
    public boolean I;

    /* renamed from: l, reason: collision with root package name */
    public g f12499l;

    /* renamed from: m, reason: collision with root package name */
    public TouchDelegate f12500m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f12501n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12502o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12503p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12504q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f12505s;

    /* renamed from: t, reason: collision with root package name */
    public int f12506t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12507u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12508v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f12509w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12510x;

    /* renamed from: y, reason: collision with root package name */
    public int f12511y;
    public int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12512a;

        public a(View view) {
            this.f12512a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this.f12512a;
            if (view == null || view.getWindowToken() == null || !ActionMenuPresenter.this.E.i()) {
                return;
            }
            view.setAlpha(0.2f);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12514a;

        public b(View view) {
            this.f12514a = view;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.f12514a.setAlpha(1.0f);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends stepos.support.v7.view.menu.f {
        public c(Context context, stepos.support.v7.view.menu.i iVar) {
            super(context, iVar, null, false, ActionMenuPresenter.this.I ? R.attr.steposActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
            if ((iVar.B.A & 32) != 32) {
                View view = ActionMenuPresenter.this.f12499l;
                this.f12424k = view == null ? (View) ActionMenuPresenter.this.f12366k : view;
            }
            this.f12427n = ActionMenuPresenter.this.H;
            int size = iVar.f12378e.size();
            boolean z = false;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                MenuItem item = iVar.getItem(i10);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i10++;
            }
            this.f12428o = z;
        }

        @Override // stepos.support.v7.view.menu.f, android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.E = null;
            actionMenuPresenter.getClass();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends ActionMenuItemView.c {
        public d() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends de.d {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final h f12517a;

        public f(h hVar) {
            this.f12517a = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            stepos.support.v7.view.menu.c cVar = actionMenuPresenter.f12362c;
            c.a aVar = cVar.f12377d;
            if (aVar != null) {
                aVar.a(cVar);
            }
            View view = (View) actionMenuPresenter.f12366k;
            if (view != null && view.getWindowToken() != null) {
                h hVar = this.f12517a;
                if (hVar.j()) {
                    actionMenuPresenter.D = hVar;
                    actionMenuPresenter.f12499l.setAlpha(0.2f);
                }
            }
            actionMenuPresenter.F = null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends androidx.appcompat.widget.p implements ActionMenuView.a {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends i0 {
            public a(g gVar) {
                super(gVar);
            }

            @Override // androidx.appcompat.widget.i0
            public final l.f b() {
                h hVar = ActionMenuPresenter.this.D;
                if (hVar == null) {
                    return null;
                }
                return hVar.f12425l;
            }

            @Override // androidx.appcompat.widget.i0
            public final boolean c() {
                ActionMenuPresenter.this.o();
                return true;
            }

            @Override // androidx.appcompat.widget.i0
            public final boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.F != null) {
                    return false;
                }
                actionMenuPresenter.j();
                return true;
            }
        }

        public g(Context context) throws Resources.NotFoundException {
            super(context, null, ActionMenuPresenter.this.I ? R.attr.steposActionOverflowButtonSplitStyle : R.attr.actionOverflowButtonStyle);
            setId(R.id.stepos_action_overflow_button);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new a(this));
            if (ActionMenuPresenter.this.I) {
                e eVar = new e();
                eVar.f8501g = 0;
                eVar.f8503j = 0;
                eVar.f8504k = 0;
                eVar.f8507n = false;
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, ce.a.h, R.attr.steposActionButtonRippleSplitStyle, 0);
                int color = typedArrayObtainStyledAttributes.getColor(4, -16777216);
                eVar.f8505l = Color.alpha(color);
                eVar.f8499e = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
                eVar.f8501g = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
                eVar.f8506m = typedArrayObtainStyledAttributes.getBoolean(8, false);
                eVar.f8509p = typedArrayObtainStyledAttributes.getBoolean(0, true);
                eVar.f8510q = typedArrayObtainStyledAttributes.getBoolean(5, true);
                eVar.f8503j = typedArrayObtainStyledAttributes.getInt(1, 160);
                eVar.f8504k = typedArrayObtainStyledAttributes.getInt(3, 320);
                eVar.r = typedArrayObtainStyledAttributes.getBoolean(6, true);
                typedArrayObtainStyledAttributes.recycle();
                Paint paint = new Paint();
                eVar.f8496b = paint;
                paint.setColor(color);
                paint.setAlpha(eVar.f8505l);
                paint.setAntiAlias(true);
                Paint paint2 = new Paint();
                eVar.f8497c = paint2;
                paint2.setColor(color);
                paint2.setAlpha(eVar.f8505l / 2);
                paint2.setAntiAlias(true);
                WeakReference<View> weakReference = new WeakReference<>(this);
                eVar.f8495a = weakReference;
                eVar.f8498d = eVar.f8499e;
                weakReference.get().setClickable(true);
                weakReference.get().addOnLayoutChangeListener(new de.b(eVar));
                weakReference.get().post(new com.stepos.common.picker.g(eVar, 2));
                setBackgroundDrawable(eVar);
            }
            Drawable drawable = ActionMenuPresenter.this.A;
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            setContentDescription(getResources().getString(R.string.abc_action_menu_overflow_description));
            context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
            Paint paint3 = new Paint();
            paint3.setAntiAlias(true);
            paint3.setColor(-65536);
            paint3.setStyle(Paint.Style.FILL);
        }

        @Override // stepos.support.v7.widget.ActionMenuView.a
        public final boolean a() {
            return false;
        }

        @Override // stepos.support.v7.widget.ActionMenuView.a
        public final boolean b() {
            return false;
        }

        @Override // android.widget.ImageView, android.view.View
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }

        @Override // android.view.View
        public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
            super.onLayout(z, i10, i11, i12, i13);
            int i14 = (int) (getResources().getDisplayMetrics().density * 52.0f);
            int i15 = i12 - i10;
            if (i15 < i14) {
                int i16 = (i14 - i15) / 2;
                Rect rect = new Rect(i10 - i16, i11, i12 + i16, i13);
                View view = (View) getParent();
                TouchDelegate touchDelegate = new TouchDelegate(rect, this);
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                actionMenuPresenter.f12500m = touchDelegate;
                view.setTouchDelegate(actionMenuPresenter.f12500m);
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.o();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int i10, int i11, int i12, int i13) {
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
                background.setHotspotBounds(i16 - i14, i17 - i15, i16 + i14, i17 + i15);
            }
            return frame;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h extends stepos.support.v7.view.menu.f {
        public h(Context context, stepos.support.v7.view.menu.c cVar, View view) {
            super(context, cVar, view, true, ActionMenuPresenter.this.I ? R.attr.steposActionOverflowMenuSplitStyle : R.attr.actionOverflowMenuStyle);
            this.f12433u = ActionMenuPresenter.this.I ? 4 : 3;
            this.f12431s = 8388613;
            this.f12427n = ActionMenuPresenter.this.H;
        }

        @Override // stepos.support.v7.view.menu.f, android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            super.onDismiss();
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            stepos.support.v7.view.menu.c cVar = actionMenuPresenter.f12362c;
            if (cVar != null) {
                cVar.c(true);
            }
            actionMenuPresenter.D = null;
            actionMenuPresenter.f12499l.setAlpha(1.0f);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class i implements g.a {
        public i() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
            if (cVar instanceof stepos.support.v7.view.menu.i) {
                ((stepos.support.v7.view.menu.i) cVar).A.c(false);
            }
            g.a aVar = ActionMenuPresenter.this.f12364e;
            if (aVar != null) {
                aVar.a(cVar, z);
            }
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final boolean b(stepos.support.v7.view.menu.c cVar) {
            if (cVar == null) {
                return false;
            }
            ((stepos.support.v7.view.menu.i) cVar).B.getClass();
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.getClass();
            g.a aVar = actionMenuPresenter.f12364e;
            return aVar != null && aVar.b(cVar);
        }
    }

    public ActionMenuPresenter(Context context) {
        this.f12360a = context;
        this.f12363d = LayoutInflater.from(context);
        this.h = R.layout.stepos_abc_action_menu_layout;
        this.f12365j = R.layout.stepos_action_menu_item_layout;
        this.B = new SparseBooleanArray();
        this.H = new i();
    }

    @Override // stepos.support.v7.view.menu.g
    public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
        j();
        c cVar2 = this.E;
        if (cVar2 != null) {
            cVar2.h();
        }
        g.a aVar = this.f12364e;
        if (aVar != null) {
            aVar.a(cVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    @Override // stepos.support.v7.view.menu.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.widget.ActionMenuPresenter.b():void");
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean c() {
        int iO;
        int i10;
        ArrayList<stepos.support.v7.view.menu.e> arrayList;
        int i11;
        ArrayList<stepos.support.v7.view.menu.e> arrayList2;
        ActionMenuPresenter actionMenuPresenter = this;
        boolean z = actionMenuPresenter.I;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.B;
        boolean z3 = true;
        if (z) {
            ArrayList<stepos.support.v7.view.menu.e> arrayListL = actionMenuPresenter.f12362c.l();
            int size = arrayListL.size();
            int i12 = actionMenuPresenter.r;
            boolean z10 = false;
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < size; i15++) {
                stepos.support.v7.view.menu.e eVar = arrayListL.get(i15);
                if (eVar.requiresActionButton()) {
                    i13++;
                } else if ((eVar.B & 1) == 1) {
                    i14++;
                } else {
                    z10 = true;
                }
            }
            boolean z11 = actionMenuPresenter.f12503p && z10;
            sparseBooleanArray.clear();
            int i16 = actionMenuPresenter.f12508v ? i12 / actionMenuPresenter.z : 0;
            int i17 = i13 + i14;
            if ((i17 > i16) | z11) {
                i16--;
            }
            if (i17 >= i16) {
                i17 = i16;
            }
            int i18 = 0;
            while (i18 < size && i17 > 0) {
                stepos.support.v7.view.menu.e eVar2 = arrayListL.get(i18);
                if (eVar2.requiresActionButton() || (eVar2.B & 1) == 1) {
                    i17--;
                    eVar2.e(true);
                    int i19 = eVar2.f12398b;
                    if (i19 != 0) {
                        sparseBooleanArray.put(i19, true);
                    }
                } else {
                    eVar2.e(false);
                }
                i18++;
            }
            for (int i20 = i18; i20 < size; i20++) {
                arrayListL.get(i18).e(false);
            }
        } else {
            ArrayList<stepos.support.v7.view.menu.e> arrayListL2 = actionMenuPresenter.f12362c.l();
            int size2 = arrayListL2.size();
            int i21 = actionMenuPresenter.f12506t;
            int i22 = actionMenuPresenter.f12505s;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f12366k;
            boolean z12 = false;
            int i23 = 0;
            int i24 = 0;
            for (int i25 = 0; i25 < size2; i25++) {
                stepos.support.v7.view.menu.e eVar3 = arrayListL2.get(i25);
                if (eVar3.requiresActionButton()) {
                    i23++;
                } else if ((eVar3.B & 1) == 1) {
                    i24++;
                } else {
                    z12 = true;
                }
                if (actionMenuPresenter.f12510x && eVar3.F) {
                    i21 = 0;
                }
            }
            if (actionMenuPresenter.f12503p && (z12 || i24 + i23 > i21)) {
                i21--;
            }
            int i26 = i21 - i23;
            sparseBooleanArray.clear();
            if (actionMenuPresenter.f12508v) {
                int i27 = actionMenuPresenter.f12511y;
                iO = i22 / i27;
                i10 = ((i22 % i27) / iO) + i27;
            } else {
                iO = 0;
                i10 = 0;
            }
            int i28 = 0;
            int i29 = 0;
            while (i28 < size2) {
                stepos.support.v7.view.menu.e eVar4 = arrayListL2.get(i28);
                boolean zRequiresActionButton = eVar4.requiresActionButton();
                int i30 = eVar4.f12398b;
                if (zRequiresActionButton) {
                    View viewH = actionMenuPresenter.h(eVar4, actionMenuPresenter.C, viewGroup);
                    if (actionMenuPresenter.C == null) {
                        actionMenuPresenter.C = viewH;
                    }
                    if (actionMenuPresenter.f12508v) {
                        iO -= ActionMenuView.o(viewH, i10, iO, iMakeMeasureSpec, 0);
                    } else {
                        viewH.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth = viewH.getMeasuredWidth();
                    i22 -= measuredWidth;
                    if (i29 == 0) {
                        i29 = measuredWidth;
                    }
                    if (i30 != 0) {
                        sparseBooleanArray.put(i30, true);
                    }
                    eVar4.e(true);
                    arrayList = arrayListL2;
                    i11 = size2;
                } else if ((eVar4.B & 1) == 1) {
                    boolean z13 = sparseBooleanArray.get(i30);
                    boolean z14 = (i26 > 0 || z13) && i22 > 0 && (!actionMenuPresenter.f12508v || iO > 0);
                    if (z14) {
                        View viewH2 = actionMenuPresenter.h(eVar4, actionMenuPresenter.C, viewGroup);
                        i11 = size2;
                        if (actionMenuPresenter.C == null) {
                            actionMenuPresenter.C = viewH2;
                        }
                        if (actionMenuPresenter.f12508v) {
                            int iO2 = ActionMenuView.o(viewH2, i10, iO, iMakeMeasureSpec, 0);
                            iO -= iO2;
                            if (iO2 == 0) {
                                z14 = false;
                            }
                        } else {
                            viewH2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        }
                        int measuredWidth2 = viewH2.getMeasuredWidth();
                        i22 -= measuredWidth2;
                        if (i29 == 0) {
                            i29 = measuredWidth2;
                        }
                        z14 &= !actionMenuPresenter.f12508v ? i28 != 0 ? i22 < 0 : i22 + i29 <= 0 : i22 < 0;
                    } else {
                        i11 = size2;
                    }
                    if (z14 && i30 != 0) {
                        sparseBooleanArray.put(i30, true);
                    } else if (z13) {
                        sparseBooleanArray.put(i30, false);
                        int i31 = 0;
                        while (i31 < i28) {
                            stepos.support.v7.view.menu.e eVar5 = arrayListL2.get(i31);
                            if (eVar5.f12398b == i30) {
                                arrayList2 = arrayListL2;
                                if ((eVar5.A & 32) == 32) {
                                    i26++;
                                }
                                eVar5.e(false);
                            } else {
                                arrayList2 = arrayListL2;
                            }
                            i31++;
                            arrayListL2 = arrayList2;
                        }
                    }
                    arrayList = arrayListL2;
                    if (z14) {
                        i26--;
                    }
                    eVar4.e(z14);
                } else {
                    arrayList = arrayListL2;
                    i11 = size2;
                    eVar4.e(false);
                    i28++;
                    actionMenuPresenter = this;
                    size2 = i11;
                    arrayListL2 = arrayList;
                    z3 = true;
                }
                i28++;
                actionMenuPresenter = this;
                size2 = i11;
                arrayListL2 = arrayList;
                z3 = true;
            }
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View] */
    @Override // stepos.support.v7.view.menu.g
    public final boolean e(stepos.support.v7.view.menu.i iVar) {
        if (iVar.hasVisibleItems()) {
            stepos.support.v7.view.menu.i iVar2 = iVar;
            while (true) {
                stepos.support.v7.view.menu.c cVar = iVar2.A;
                if (cVar == this.f12362c) {
                    break;
                }
                iVar2 = (stepos.support.v7.view.menu.i) cVar;
            }
            stepos.support.v7.view.menu.e eVar = iVar2.B;
            ViewGroup viewGroup = (ViewGroup) this.f12366k;
            g gVar = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i10 = 0;
                while (true) {
                    if (i10 >= childCount) {
                        break;
                    }
                    ?? childAt = viewGroup.getChildAt(i10);
                    if ((childAt instanceof h.a) && ((h.a) childAt).getItemData() == eVar) {
                        gVar = childAt;
                        break;
                    }
                    i10++;
                }
            }
            if (gVar != null || (gVar = this.f12499l) != null) {
                iVar.B.getClass();
                c cVar2 = new c(this.f12361b, iVar);
                this.E = cVar2;
                cVar2.f12431s = 8388613;
                cVar2.f12433u = 4;
                cVar2.f12424k = gVar;
                if (!cVar2.j()) {
                    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                }
                gVar.post(new a(gVar));
                this.E.f12425l.C.setOnDismissListener(new b(gVar));
                g.a aVar = this.f12364e;
                if (aVar != null) {
                    aVar.b(iVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final void g(Context context, stepos.support.v7.view.menu.c cVar) {
        this.f12361b = context;
        LayoutInflater.from(context);
        this.f12362c = cVar;
        Resources resources = context.getResources();
        Context context2 = fe.a.a(context).f8850a;
        if (!this.f12504q) {
            this.f12503p = true;
        }
        if (!this.f12509w) {
            this.r = context2.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.f12507u) {
            this.f12506t = context2.getResources().getInteger(R.integer.abc_max_action_buttons);
        }
        int measuredWidth = this.r;
        if (this.f12503p) {
            if (this.f12499l == null) {
                g gVar = new g(this.f12360a);
                this.f12499l = gVar;
                if (this.f12502o) {
                    gVar.setImageDrawable(this.f12501n);
                    this.f12501n = null;
                    this.f12502o = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f12499l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f12499l.getMeasuredWidth();
        } else {
            this.f12499l = null;
        }
        this.f12505s = measuredWidth;
        this.f12511y = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.C = null;
        this.z = (int) (resources.getDisplayMetrics().density * 60.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v3, types: [stepos.support.v7.view.menu.h$a] */
    /* JADX WARN: Type inference failed for: r5v5, types: [stepos.support.v7.view.menu.h$a] */
    public final View h(stepos.support.v7.view.menu.e eVar, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        ActionMenuItemView actionView = eVar.getActionView();
        if (actionView == null || eVar.d()) {
            if (view instanceof h.a) {
                actionMenuItemView = (h.a) view;
            } else {
                ?? r52 = (h.a) this.f12363d.inflate(this.f12365j, viewGroup, false);
                boolean z = r52 instanceof View;
                actionMenuItemView = r52;
                if (z) {
                    actionMenuItemView = r52;
                }
            }
            actionMenuItemView.setIsInSplit(this.I);
            actionMenuItemView.c(eVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f12366k);
            if (this.G == null) {
                this.G = new d();
            }
            actionMenuItemView2.setPopupCallback(this.G);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(eVar.F ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.m(layoutParams));
            return actionView;
        }
        if ((layoutParams instanceof ActionMenuView.c) && (actionView instanceof ActionMenuItemView)) {
            ((ActionMenuView.c) layoutParams).f12530a = ((ActionMenuItemView) actionView).f12336x;
        }
        return actionView;
    }

    public final stepos.support.v7.view.menu.h i(ViewGroup viewGroup) {
        if (this.f12366k == null) {
            stepos.support.v7.view.menu.h hVar = (stepos.support.v7.view.menu.h) this.f12363d.inflate(this.h, viewGroup, false);
            this.f12366k = hVar;
            hVar.a(this.f12362c);
            b();
        }
        stepos.support.v7.view.menu.h hVar2 = this.f12366k;
        ((ActionMenuView) hVar2).setPresenter(this);
        return hVar2;
    }

    public final boolean j() {
        Object obj;
        f fVar = this.F;
        if (fVar != null && (obj = this.f12366k) != null) {
            ((View) obj).removeCallbacks(fVar);
            this.F = null;
            return true;
        }
        h hVar = this.D;
        if (hVar == null) {
            return false;
        }
        hVar.h();
        return true;
    }

    public final boolean k() {
        h hVar = this.D;
        return hVar != null && hVar.i();
    }

    public final void l(boolean z) {
        if (this.I != z) {
            this.I = z;
            this.f12365j = z ? R.layout.stepos_action_menu_item_split_layout : R.layout.stepos_action_menu_item_layout;
            Object obj = this.f12366k;
            if (obj != null) {
                ((ViewGroup) obj).removeAllViews();
            }
            if (z) {
                return;
            }
            this.f12504q = false;
            this.f12509w = false;
            this.f12507u = false;
            g(this.f12361b, this.f12362c);
        }
    }

    public final void m() {
        this.f12506t = Integer.MAX_VALUE;
        this.f12507u = true;
    }

    public final void n(int i10) {
        this.r = i10;
        this.f12508v = true;
        this.f12509w = true;
    }

    public final boolean o() {
        stepos.support.v7.view.menu.c cVar;
        if (!this.f12503p || k() || (cVar = this.f12362c) == null || this.f12366k == null || this.F != null) {
            return false;
        }
        cVar.i();
        if (cVar.f12381l.isEmpty()) {
            return false;
        }
        f fVar = new f(new h(this.f12361b, this.f12362c, this.f12499l));
        this.F = fVar;
        ((View) this.f12366k).post(fVar);
        g.a aVar = this.f12364e;
        if (aVar == null) {
            return true;
        }
        aVar.b(null);
        return true;
    }
}
