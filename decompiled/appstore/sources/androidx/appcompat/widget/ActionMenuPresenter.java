package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements ActionProvider.SubUiVisibilityListener {
    public c A;
    public b B;
    public final f C;
    public int D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f698l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f699m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f700n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f701o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f702p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f703q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f705s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f706t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f707u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f708v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f709w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SparseBooleanArray f710x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f711y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f712z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel r10) {
            this.openSubMenuId = r10.readInt();
        }
    }

    public class a extends androidx.appcompat.view.menu.j {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f713m;

        public a(ActionMenuPresenter r10, Context r11, androidx.appcompat.view.menu.m r12, View r13) {
            this.f713m = r10;
            super(r11, r12, r13, false, R$attr.actionOverflowMenuStyle);
            if (((androidx.appcompat.view.menu.g) r12.getItem()).j() == true) goto L8;
            View r14 = r10.f697k;
            if (r14 != null) goto L7;
            r14 = (View) ActionMenuPresenter.k(r10);
        L7:
            e(r14);
        L8:
            setPresenterCallback(r10.C);
        }

        @Override // androidx.appcompat.view.menu.j
        public void d() {
            ActionMenuPresenter r10 = this.f713m;
            r10.f712z = null;
            r10.D = 0;
            super.d();
        }
    }

    public class b extends ActionMenuItemView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f714a;

        public b(ActionMenuPresenter r10) {
            this.f714a = r10;
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public ShowableListMenu a() {
            a r10 = this.f714a.f712z;
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.b();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f716b;

        public c(ActionMenuPresenter r10, e r11) {
            this.f716b = r10;
            this.f715a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.m(this.f716b) == null) goto L5;
            ActionMenuPresenter.n(this.f716b).changeMenuMode();
        L5:
            View r10 = (View) ActionMenuPresenter.o(this.f716b);
            if (r10 != null) goto L8;
        L12:
            this.f716b.A = null;
            return;
        L8:
            if (r10.getWindowToken() == null) goto L12;
            if (this.f715a.j() == false) goto L12;
            ActionMenuPresenter r11 = this.f716b;
            r11.f711y = this.f715a;
            goto L12
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f717a;

        public class a extends t {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f718j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ d f719k;

            public a(d r10, View r11, ActionMenuPresenter r12) {
                this.f719k = r10;
                this.f718j = r12;
                super(r11);
            }

            @Override // androidx.appcompat.widget.t
            public ShowableListMenu b() {
                e r10 = this.f719k.f717a.f711y;
                if (r10 != null) goto L7;
                return null;
            L7:
                return r10.b();
            }

            @Override // androidx.appcompat.widget.t
            public boolean c() {
                this.f719k.f717a.B();
                return true;
            }

            @Override // androidx.appcompat.widget.t
            public boolean d() {
                ActionMenuPresenter r10 = this.f719k.f717a;
                if (r10.A == null) goto L6;
                return false;
            L6:
                r10.s();
                return true;
            }
        }

        public d(ActionMenuPresenter r10, Context r11) {
            this.f717a = r10;
            super(r11, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            g0.a(this, getContentDescription());
            setOnTouchListener(new a(this, this, r10));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick() == false) goto L5;
            return true;
        L5:
            playSoundEffect(0);
            this.f717a.B();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int r10, int r11, int r12, int r13) {
            boolean r14 = super.setFrame(r10, r11, r12, r13);
            Drawable r15 = getDrawable();
            Drawable r16 = getBackground();
            if (r15 == null) goto L6;
            if (r16 == null) goto L6;
            int r17 = getWidth();
            int r18 = getHeight();
            int r19 = Math.max(r17, r18) / 2;
            int r20 = getPaddingLeft() - getPaddingRight();
            int r21 = (r17 + r20) / 2;
            int r22 = (r18 + (getPaddingTop() - getPaddingBottom())) / 2;
            o.a.f(r16, r21 - r19, r22 - r19, r21 + r19, r22 + r19);
        L6:
            return r14;
        }
    }

    public class e extends androidx.appcompat.view.menu.j {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f720m;

        public e(ActionMenuPresenter r10, Context r11, MenuBuilder r12, View r13, boolean r14) {
            this.f720m = r10;
            super(r11, r12, r13, r14, R$attr.actionOverflowMenuStyle);
            g(8388613);
            setPresenterCallback(r10.C);
        }

        @Override // androidx.appcompat.view.menu.j
        public void d() {
            if (ActionMenuPresenter.i(this.f720m) == null) goto L5;
            ActionMenuPresenter.j(this.f720m).close();
        L5:
            this.f720m.f711y = null;
            super.d();
        }
    }

    public class f implements MenuPresenter.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuPresenter f721a;

        public f(ActionMenuPresenter r10) {
            this.f721a = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r10, boolean r11) {
            if ((r10 instanceof androidx.appcompat.view.menu.m) == false) goto L5;
            r10.getRootMenu().close(false);
        L5:
            MenuPresenter.Callback r12 = this.f721a.e();
            if (r12 == null) goto L9;
            r12.onCloseMenu(r10, r11);
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r10) {
            if (r10 != ActionMenuPresenter.l(this.f721a)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r11 = this.f721a;
            r11.D = ((androidx.appcompat.view.menu.m) r10).getItem().getItemId();
            MenuPresenter.Callback r12 = this.f721a.e();
            if (r12 != null) goto L8;
            return false;
        L8:
            return r12.onOpenSubMenu(r10);
        }
    }

    public ActionMenuPresenter(Context r10) {
        super(r10, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f710x = new SparseBooleanArray();
        this.C = new f(this);
    }

    public static /* synthetic */ MenuBuilder i(ActionMenuPresenter r10) {
        return r10.f534c;
    }

    public static /* synthetic */ MenuBuilder j(ActionMenuPresenter r10) {
        return r10.f534c;
    }

    public static /* synthetic */ MenuView k(ActionMenuPresenter r10) {
        return r10.f540i;
    }

    public static /* synthetic */ MenuBuilder l(ActionMenuPresenter r10) {
        return r10.f534c;
    }

    public static /* synthetic */ MenuBuilder m(ActionMenuPresenter r10) {
        return r10.f534c;
    }

    public static /* synthetic */ MenuBuilder n(ActionMenuPresenter r10) {
        return r10.f534c;
    }

    public static /* synthetic */ MenuView o(ActionMenuPresenter r10) {
        return r10.f540i;
    }

    public void A(boolean r10) {
        this.f700n = r10;
        this.f701o = true;
    }

    public boolean B() {
        if (this.f700n == true) goto L5;
        return false;
    L5:
        if (v() == true) goto L18;
        MenuBuilder r10 = this.f534c;
        if (r10 != null) goto L9;
        return false;
    L9:
        if (this.f540i != null) goto L11;
        return false;
    L11:
        if (this.A == null) goto L13;
        return false;
    L13:
        if (r10.getNonActionItems().isEmpty() == true) goto L22;
        c r11 = new c(this, new e(this, this.f533b, this.f534c, this.f697k, true));
        this.A = r11;
        ((View) this.f540i).post(r11);
        return true;
    L22:
        return false;
    L18:
        return false;
    }

    @Override // androidx.appcompat.view.menu.b
    public void b(androidx.appcompat.view.menu.g r10, MenuView.ItemView r11) {
        r11.initialize(r10, 0);
        ActionMenuItemView r12 = (ActionMenuItemView) r11;
        r12.setItemInvoker((ActionMenuView) this.f540i);
        if (this.B != null) goto L5;
        this.B = new b(this);
    L5:
        r12.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean d(ViewGroup r10, int r11) {
        if (r10.getChildAt(r11) != this.f697k) goto L7;
        return false;
    L7:
        return super.d(r10, r11);
    }

    @Override // androidx.appcompat.view.menu.b
    public View f(androidx.appcompat.view.menu.g r10, View r11, ViewGroup r12) {
        View r13 = r10.getActionView();
        if (r13 != null) goto L5;
    L6:
        r13 = super.f(r10, r11, r12);
    L8:
        if (r10.isActionViewExpanded() == false) goto L10;
        int r14 = 8;
    L11:
        r13.setVisibility(r14);
        ActionMenuView r15 = (ActionMenuView) r12;
        ViewGroup.LayoutParams r16 = r13.getLayoutParams();
        if (r15.checkLayoutParams(r16) == true) goto L14;
        r13.setLayoutParams(r15.g(r16));
    L14:
        return r13;
    L10:
        r14 = 0;
        goto L11
    L5:
        if (r10.h() == false) goto L8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.g] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ActionMenuPresenter r10 = this;
        MenuBuilder r11 = r10.f534c;
        View r12 = null;
        ?? r13 = 0;
        if (r11 == null) goto L5;
        ArrayList<androidx.appcompat.view.menu.g> r14 = r11.getVisibleItems();
        int r15 = r14.size();
    L6:
        int r16 = r10.f704r;
        int r17 = r10.f703q;
        int r18 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r19 = (ViewGroup) r10.f540i;
        int r20 = 0;
        boolean r110 = false;
        int r111 = 0;
        int r112 = 0;
    L7:
        if (r20 >= r15) goto L22;
        androidx.appcompat.view.menu.g r113 = r14.get(r20);
        if (r113.requiresActionButton() == false) goto L12;
        r111 = r111 + 1;
    L16:
        if (r10.f708v == false) goto L20;
        if (r113.isActionViewExpanded() == false) goto L20;
        r16 = 0;
    L20:
        r20 = r20 + 1;
        goto L7
    L12:
        if (r113.l() == false) goto L14;
        r112 = r112 + 1;
        goto L16
    L14:
        r110 = true;
        goto L16
    L22:
        if (r10.f700n == false) goto L27;
        if (r110 == false) goto L25;
    L26:
        r16 = r16 - 1;
        goto L27
    L25:
        if ((r112 + r111) > r16) goto L26;
    L27:
        int r21 = r16 - r111;
        SparseBooleanArray r22 = r10.f710x;
        r22.clear();
        if (r10.f706t == false) goto L30;
        int r114 = r10.f709w;
        int r115 = r17 / r114;
        int r116 = r114 + ((r17 % r114) / r115);
    L31:
        int r117 = 0;
        int r118 = 0;
        ?? r23 = r10;
    L32:
        if (r117 >= r15) goto L96;
        androidx.appcompat.view.menu.g r119 = r14.get(r117);
        if (r119.requiresActionButton() == false) goto L47;
        View r120 = r23.f(r119, r12, r19);
        if (r23.f706t == false) goto L38;
        r115 = r115 - ActionMenuView.n(r120, r116, r115, r18, r13);
    L39:
        int r24 = r120.getMeasuredWidth();
        r17 = r17 - r24;
        if (r118 != 0) goto L42;
        r118 = r24;
    L42:
        int r25 = r119.getGroupId();
        if (r25 == 0) goto L45;
        r22.put(r25, true);
    L45:
        r119.r(true);
        ?? r26 = r13;
    L95:
        r117 = r117 + 1;
        r13 = r26;
        r15 = r15;
        r12 = null;
        r23 = this;
        goto L32
    L38:
        r120.measure(r18, r18);
        goto L39
    L47:
        if (r119.l() == false) goto L94;
        int r27 = r119.getGroupId();
        boolean r121 = r22.get(r27);
        if (r21 > 0) goto L51;
        if (r121 == true) goto L51;
    L56:
        boolean r28 = false;
    L57:
        boolean r122 = r28;
        if (r28 == false) goto L78;
        View r29 = r23.f(r119, null, r19);
        if (r23.f706t == false) goto L65;
        int r123 = ActionMenuView.n(r29, r116, r115, r18, 0);
        r115 = r115 - r123;
        if (r123 != 0) goto L64;
        r122 = false;
    L64:
        boolean r30 = r122;
        int r31 = r29.getMeasuredWidth();
        r17 = r17 - r31;
        if (r118 != 0) goto L70;
        r118 = r31;
    L70:
        if (r23.f706t == false) goto L76;
        if (r17 < 0) goto L73;
    L72:
        boolean r32 = true;
    L74:
        r28 = r30 & r32;
    L73:
        r32 = false;
        goto L74
    L76:
        if ((r17 + r118) <= 0) goto L73;
    L65:
        r29.measure(r18, r18);
    L78:
        if (r28 == false) goto L81;
        if (r27 == 0) goto L81;
        r22.put(r27, true);
    L91:
        if (r28 == false) goto L93;
        r21 = r21 - 1;
    L93:
        r119.r(r28);
        r26 = 0;
    L81:
        if (r121 == false) goto L91;
        r22.put(r27, false);
        int r33 = 0;
    L83:
        if (r33 >= r117) goto L91;
        androidx.appcompat.view.menu.g r124 = r14.get(r33);
        if (r124.getGroupId() != r27) goto L90;
        if (r124.j() == false) goto L89;
        r21 = r21 + 1;
    L89:
        r124.r(false);
    L90:
        r33 = r33 + 1;
    L51:
        if (r17 <= 0) goto L56;
        if (r23.f706t == false) goto L55;
        if (r115 <= 0) goto L56;
    L55:
        r28 = true;
        goto L57
    L94:
        r26 = r13;
        r119.r(r26);
        goto L95
    L96:
        return true;
    L30:
        r116 = 0;
        r115 = 0;
        goto L31
    L5:
        r14 = null;
        r15 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        MenuView r11 = this.f540i;
        MenuView r12 = super.getMenuView(r10);
        if (r11 == r12) goto L5;
        ((ActionMenuView) r12).setPresenter(this);
    L5:
        return r12;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean h(int r10, androidx.appcompat.view.menu.g r11) {
        return r11.j();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r10, MenuBuilder r11) {
        super.initForMenu(r10, r11);
        Resources r12 = r10.getResources();
        g.a r13 = g.a.b(r10);
        if (this.f701o == true) goto L6;
        this.f700n = r13.h();
    L6:
        if (this.f707u == true) goto L9;
        this.f702p = r13.c();
    L9:
        if (this.f705s == true) goto L11;
        this.f704r = r13.d();
    L11:
        int r14 = this.f702p;
        if (this.f700n == true) goto L14;
        this.f697k = null;
    L21:
        this.f703q = r14;
        this.f709w = (int) (r12.getDisplayMetrics().density * 56.0f);
        return;
    L14:
        if (this.f697k != null) goto L19;
        d r15 = new d(this, this.f532a);
        this.f697k = r15;
        if (this.f699m == false) goto L18;
        r15.setImageDrawable(this.f698l);
        this.f698l = null;
        this.f699m = false;
    L18:
        int r16 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f697k.measure(r16, r16);
    L19:
        r14 = r14 - this.f697k.getMeasuredWidth();
        goto L21
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        p();
        super.onCloseMenu(r10, r11);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L5;
        return;
    L5:
        int r11 = ((SavedState) r10).openSubMenuId;
        if (r11 <= 0) goto L11;
        MenuItem r12 = this.f534c.findItem(r11);
        if (r12 == null) goto L12;
        onSubMenuSelected((androidx.appcompat.view.menu.m) r12.getSubMenu());
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState();
        r10.openSubMenuId = this.D;
        return r10;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.m r10) {
        boolean r11 = false;
        if (r10.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        androidx.appcompat.view.menu.m r12 = r10;
    L7:
        if (r12.getParentMenu() == this.f534c) goto L9;
        r12 = (androidx.appcompat.view.menu.m) r12.getParentMenu();
        goto L7
    L9:
        View r13 = q(r12.getItem());
        if (r13 != null) goto L12;
        return false;
    L12:
        this.D = r10.getItem().getItemId();
        int r14 = r10.size();
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L21;
        MenuItem r16 = r10.getItem(r15);
        if (r16.isVisible() == false) goto L20;
        if (r16.getIcon() == null) goto L20;
        r11 = true;
    L20:
        r15 = r15 + 1;
    L21:
        a r17 = new a(this, this.f533b, r10, r13);
        this.f712z = r17;
        r17.f(r11);
        this.f712z.h();
        super.onSubMenuSelected(r10);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean r10) {
        if (r10 == false) goto L4;
        super.onSubMenuSelected(null);
        return;
    L4:
        MenuBuilder r11 = this.f534c;
        if (r11 == null) goto L9;
        r11.close(false);
        return;
    }

    public boolean p() {
        boolean r10 = s();
        return t() | r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View q(MenuItem r10) {
        ViewGroup r11 = (ViewGroup) this.f540i;
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = r11.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L13;
        View r14 = r11.getChildAt(r13);
        if ((r14 instanceof MenuView.ItemView) == false) goto L12;
        if (((MenuView.ItemView) r14).getItemData() != r10) goto L12;
        return r14;
    L12:
        r13 = r13 + 1;
        goto L6
    L13:
        return null;
    }

    public Drawable r() {
        d r10 = this.f697k;
        if (r10 == null) goto L7;
        return r10.getDrawable();
    L7:
        if (this.f699m == true) goto L9;
        return null;
    L9:
        return this.f698l;
    }

    public boolean s() {
        c r10 = this.A;
        if (r10 == null) goto L8;
        Object r11 = this.f540i;
        if (r11 == null) goto L8;
        ((View) r11).removeCallbacks(r10);
        this.A = null;
        return true;
    L8:
        e r12 = this.f711y;
        if (r12 == null) goto L12;
        r12.dismiss();
        return true;
    L12:
        return false;
    }

    public boolean t() {
        a r10 = this.f712z;
        if (r10 == null) goto L6;
        r10.dismiss();
        return true;
    L6:
        return false;
    }

    public boolean u() {
        if (this.A == null) goto L5;
    L8:
        return true;
    L5:
        if (v() == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        super.updateMenuView(r10);
        ((View) this.f540i).requestLayout();
        MenuBuilder r11 = this.f534c;
        boolean r12 = false;
        if (r11 == null) goto L10;
        ArrayList<androidx.appcompat.view.menu.g> r13 = r11.getActionItems();
        int r14 = r13.size();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        ActionProvider r16 = r13.get(r15).getSupportActionProvider();
        if (r16 == null) goto L9;
        r16.h(this);
    L9:
        r15 = r15 + 1;
    L10:
        MenuBuilder r17 = this.f534c;
        if (r17 == null) goto L13;
        ArrayList<androidx.appcompat.view.menu.g> r18 = r17.getNonActionItems();
    L15:
        if (this.f700n == false) goto L22;
        if (r18 == null) goto L22;
        int r19 = r18.size();
        if (r19 != 1) goto L20;
        r12 = !r18.get(0).isActionViewExpanded();
        goto L22
    L20:
        if (r19 <= 0) goto L22;
        r12 = true;
    L22:
        if (r12 == true) goto L24;
        d r20 = this.f697k;
        if (r20 == null) goto L36;
        Object r21 = r20.getParent();
        Object r22 = this.f540i;
        if (r21 != r22) goto L36;
        ((ViewGroup) r22).removeView(this.f697k);
    L36:
        ((ActionMenuView) this.f540i).setOverflowReserved(this.f700n);
        return;
    L24:
        if (this.f697k != null) goto L26;
        this.f697k = new d(this, this.f532a);
    L26:
        ViewGroup r23 = (ViewGroup) this.f697k.getParent();
        if (r23 == this.f540i) goto L36;
        if (r23 == null) goto L30;
        r23.removeView(this.f697k);
    L30:
        ActionMenuView r24 = (ActionMenuView) this.f540i;
        r24.addView(this.f697k, r24.h());
        goto L36
    L13:
        r18 = null;
        goto L15
    }

    public boolean v() {
        e r10 = this.f711y;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.c() == false) goto L7;
        return true;
    }

    public void w(Configuration r10) {
        if (this.f705s == true) goto L5;
        this.f704r = g.a.b(this.f533b).d();
    L5:
        MenuBuilder r11 = this.f534c;
        if (r11 == null) goto L9;
        r11.onItemsChanged(true);
        return;
    }

    public void x(boolean r10) {
        this.f708v = r10;
    }

    public void y(ActionMenuView r10) {
        this.f540i = r10;
        r10.initialize(this.f534c);
    }

    public void z(Drawable r10) {
        d r11 = this.f697k;
        if (r11 == null) goto L5;
        r11.setImageDrawable(r10);
        return;
    L5:
        this.f699m = true;
        this.f698l = r10;
    }
}
