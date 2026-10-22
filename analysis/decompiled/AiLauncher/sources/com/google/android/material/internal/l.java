package com.google.android.material.internal;

import C0.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class l implements androidx.appcompat.view.menu.i {

    /* renamed from: A, reason: collision with root package name */
    public int f21088A;

    /* renamed from: B, reason: collision with root package name */
    public int f21089B;

    /* renamed from: a, reason: collision with root package name */
    public NavigationMenuView f21092a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f21093b;

    /* renamed from: c, reason: collision with root package name */
    public i.a f21094c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f21095d;

    /* renamed from: e, reason: collision with root package name */
    public int f21096e;

    /* renamed from: f, reason: collision with root package name */
    public c f21097f;

    /* renamed from: g, reason: collision with root package name */
    public LayoutInflater f21098g;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f21100i;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f21103l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f21104m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f21105n;

    /* renamed from: o, reason: collision with root package name */
    public RippleDrawable f21106o;

    /* renamed from: p, reason: collision with root package name */
    public int f21107p;

    /* renamed from: q, reason: collision with root package name */
    public int f21108q;

    /* renamed from: r, reason: collision with root package name */
    public int f21109r;

    /* renamed from: s, reason: collision with root package name */
    public int f21110s;

    /* renamed from: t, reason: collision with root package name */
    public int f21111t;

    /* renamed from: u, reason: collision with root package name */
    public int f21112u;

    /* renamed from: v, reason: collision with root package name */
    public int f21113v;

    /* renamed from: w, reason: collision with root package name */
    public int f21114w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f21115x;

    /* renamed from: z, reason: collision with root package name */
    public int f21117z;

    /* renamed from: h, reason: collision with root package name */
    public int f21099h = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f21101j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21102k = true;

    /* renamed from: y, reason: collision with root package name */
    public boolean f21116y = true;

    /* renamed from: C, reason: collision with root package name */
    public int f21090C = -1;

    /* renamed from: D, reason: collision with root package name */
    public final View.OnClickListener f21091D = new a();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10 = true;
            l.this.Y(true);
            androidx.appcompat.view.menu.g itemData = ((NavigationMenuItemView) view).getItemData();
            l lVar = l.this;
            boolean zP = lVar.f21095d.P(itemData, lVar, 0);
            if (itemData != null && itemData.isCheckable() && zP) {
                l.this.f21097f.r(itemData);
            } else {
                z10 = false;
            }
            l.this.Y(false);
            if (z10) {
                l.this.b(false);
            }
        }
    }

    public static class b extends AbstractC0235l {
        public b(View view) {
            super(view);
        }
    }

    public class c extends RecyclerView.Adapter<AbstractC0235l> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<e> f21119a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f21120b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21121c;

        public class a extends C1313a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f21123a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f21124b;

            public a(int i10, boolean z10) {
                this.f21123a = i10;
                this.f21124b = z10;
            }

            @Override // androidx.core.view.C1313a
            public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.p0(c.g.a(c.this.g(this.f21123a), 1, 1, 1, this.f21124b, view.isSelected()));
            }
        }

        public c() {
            o();
        }

        public final int g(int i10) {
            int i11 = i10;
            for (int i12 = 0; i12 < i10; i12++) {
                if (l.this.f21097f.getItemViewType(i12) == 2 || l.this.f21097f.getItemViewType(i12) == 3) {
                    i11--;
                }
            }
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f21119a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            e eVar = this.f21119a.get(i10);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public final void h(int i10, int i11) {
            while (i10 < i11) {
                ((g) this.f21119a.get(i10)).f21129b = true;
                i10++;
            }
        }

        public Bundle i() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.g gVar = this.f21120b;
            if (gVar != null) {
                bundle.putInt("android:menu:checked", gVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f21119a.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = this.f21119a.get(i10);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.g gVarA = ((g) eVar).a();
                    View actionView = gVarA != null ? gVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(gVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.g j() {
            return this.f21120b;
        }

        public int k() {
            int i10 = 0;
            for (int i11 = 0; i11 < l.this.f21097f.getItemCount(); i11++) {
                int itemViewType = l.this.f21097f.getItemViewType(i11);
                if (itemViewType == 0 || itemViewType == 1) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(AbstractC0235l abstractC0235l, int i10) throws Resources.NotFoundException {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) this.f21119a.get(i10);
                    abstractC0235l.itemView.setPaddingRelative(l.this.f21111t, fVar.b(), l.this.f21112u, fVar.a());
                    return;
                }
                TextView textView = (TextView) abstractC0235l.itemView;
                textView.setText(((g) this.f21119a.get(i10)).a().getTitle());
                androidx.core.widget.i.m(textView, l.this.f21099h);
                textView.setPaddingRelative(l.this.f21113v, textView.getPaddingTop(), l.this.f21114w, textView.getPaddingBottom());
                ColorStateList colorStateList = l.this.f21100i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                q(textView, i10, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) abstractC0235l.itemView;
            navigationMenuItemView.setIconTintList(l.this.f21104m);
            navigationMenuItemView.setTextAppearance(l.this.f21101j);
            ColorStateList colorStateList2 = l.this.f21103l;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = l.this.f21105n;
            navigationMenuItemView.setBackground(drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = l.this.f21106o;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f21119a.get(i10);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f21129b);
            l lVar = l.this;
            int i11 = lVar.f21107p;
            int i12 = lVar.f21108q;
            navigationMenuItemView.setPadding(i11, i12, i11, i12);
            navigationMenuItemView.setIconPadding(l.this.f21109r);
            l lVar2 = l.this;
            if (lVar2.f21115x) {
                navigationMenuItemView.setIconSize(lVar2.f21110s);
            }
            navigationMenuItemView.setMaxLines(l.this.f21117z);
            navigationMenuItemView.i(gVar.a(), l.this.f21102k);
            q(navigationMenuItemView, i10, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public AbstractC0235l onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 0) {
                l lVar = l.this;
                return new i(lVar.f21098g, viewGroup, lVar.f21091D);
            }
            if (i10 == 1) {
                return new k(l.this.f21098g, viewGroup);
            }
            if (i10 == 2) {
                return new j(l.this.f21098g, viewGroup);
            }
            if (i10 != 3) {
                return null;
            }
            return new b(l.this.f21093b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(AbstractC0235l abstractC0235l) {
            if (abstractC0235l instanceof i) {
                ((NavigationMenuItemView) abstractC0235l.itemView).j();
            }
        }

        public final void o() {
            if (this.f21121c) {
                return;
            }
            this.f21121c = true;
            this.f21119a.clear();
            this.f21119a.add(new d());
            int size = l.this.f21095d.G().size();
            int i10 = -1;
            boolean z10 = false;
            int size2 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                androidx.appcompat.view.menu.g gVar = l.this.f21095d.G().get(i11);
                if (gVar.isChecked()) {
                    r(gVar);
                }
                if (gVar.isCheckable()) {
                    gVar.t(false);
                }
                if (gVar.hasSubMenu()) {
                    SubMenu subMenu = gVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i11 != 0) {
                            this.f21119a.add(new f(l.this.f21089B, 0));
                        }
                        this.f21119a.add(new g(gVar));
                        int size3 = this.f21119a.size();
                        int size4 = subMenu.size();
                        boolean z11 = false;
                        for (int i12 = 0; i12 < size4; i12++) {
                            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) subMenu.getItem(i12);
                            if (gVar2.isVisible()) {
                                if (!z11 && gVar2.getIcon() != null) {
                                    z11 = true;
                                }
                                if (gVar2.isCheckable()) {
                                    gVar2.t(false);
                                }
                                if (gVar2.isChecked()) {
                                    r(gVar2);
                                }
                                this.f21119a.add(new g(gVar2));
                            }
                        }
                        if (z11) {
                            h(size3, this.f21119a.size());
                        }
                    }
                } else {
                    int groupId = gVar.getGroupId();
                    if (groupId != i10) {
                        size2 = this.f21119a.size();
                        z10 = gVar.getIcon() != null;
                        if (i11 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.f21119a;
                            int i13 = l.this.f21089B;
                            arrayList.add(new f(i13, i13));
                        }
                    } else if (!z10 && gVar.getIcon() != null) {
                        h(size2, this.f21119a.size());
                        z10 = true;
                    }
                    g gVar3 = new g(gVar);
                    gVar3.f21129b = z10;
                    this.f21119a.add(gVar3);
                    i10 = groupId;
                }
            }
            this.f21121c = false;
        }

        public void p(Bundle bundle) {
            androidx.appcompat.view.menu.g gVarA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.g gVarA2;
            int i10 = bundle.getInt("android:menu:checked", 0);
            if (i10 != 0) {
                this.f21121c = true;
                int size = this.f21119a.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    e eVar = this.f21119a.get(i11);
                    if ((eVar instanceof g) && (gVarA2 = ((g) eVar).a()) != null && gVarA2.getItemId() == i10) {
                        r(gVarA2);
                        break;
                    }
                    i11++;
                }
                this.f21121c = false;
                o();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f21119a.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e eVar2 = this.f21119a.get(i12);
                    if ((eVar2 instanceof g) && (gVarA = ((g) eVar2).a()) != null && (actionView = gVarA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(gVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public final void q(View view, int i10, boolean z10) {
            N.i0(view, new a(i10, z10));
        }

        public void r(androidx.appcompat.view.menu.g gVar) {
            if (this.f21120b == gVar || !gVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.g gVar2 = this.f21120b;
            if (gVar2 != null) {
                gVar2.setChecked(false);
            }
            this.f21120b = gVar;
            gVar.setChecked(true);
        }

        public void s(boolean z10) {
            this.f21121c = z10;
        }

        public void t() {
            int size = this.f21119a.size();
            o();
            notifyDataSetChanged();
            if (size == this.f21119a.size()) {
                notifyItemRangeChanged(0, this.f21119a.size());
            }
        }

        public final void u() {
            for (int i10 = 0; i10 < this.f21119a.size(); i10++) {
                if (this.f21119a.get(i10) instanceof f) {
                    notifyItemChanged(i10);
                }
            }
        }

        public final void v() {
            for (int i10 = 0; i10 < this.f21119a.size(); i10++) {
                if ((this.f21119a.get(i10) instanceof g) && getItemViewType(i10) == 1) {
                    notifyItemChanged(i10);
                }
            }
        }

        public final void w() {
            for (int i10 = 0; i10 < this.f21119a.size(); i10++) {
                if ((this.f21119a.get(i10) instanceof g) && getItemViewType(i10) == 0) {
                    notifyItemChanged(i10);
                }
            }
        }
    }

    public static class d implements e {
    }

    public interface e {
    }

    public static class f implements e {

        /* renamed from: a, reason: collision with root package name */
        public final int f21126a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21127b;

        public f(int i10, int i11) {
            this.f21126a = i10;
            this.f21127b = i11;
        }

        public int a() {
            return this.f21127b;
        }

        public int b() {
            return this.f21126a;
        }
    }

    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.g f21128a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21129b;

        public g(androidx.appcompat.view.menu.g gVar) {
            this.f21128a = gVar;
        }

        public androidx.appcompat.view.menu.g a() {
            return this.f21128a;
        }
    }

    public class h extends RecyclerViewAccessibilityDelegate {
        public h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.o0(c.f.a(l.this.f21097f.k(), 1, false));
        }
    }

    public static class i extends AbstractC0235l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class j extends AbstractC0235l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class k extends AbstractC0235l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* renamed from: com.google.android.material.internal.l$l, reason: collision with other inner class name */
    public static abstract class AbstractC0235l extends RecyclerView.ViewHolder {
        public AbstractC0235l(View view) {
            super(view);
        }
    }

    public int A() {
        return this.f21113v;
    }

    public final boolean B() {
        return q() > 0;
    }

    public View C(int i10) {
        View viewInflate = this.f21098g.inflate(i10, (ViewGroup) this.f21093b, false);
        l(viewInflate);
        return viewInflate;
    }

    public void D(boolean z10) {
        if (this.f21116y != z10) {
            this.f21116y = z10;
            c0();
        }
    }

    public void E(androidx.appcompat.view.menu.g gVar) {
        this.f21097f.r(gVar);
    }

    public void F(int i10) {
        this.f21112u = i10;
        Z();
    }

    public void G(int i10) {
        this.f21111t = i10;
        Z();
    }

    public void H(int i10) {
        this.f21096e = i10;
    }

    public void I(Drawable drawable) {
        this.f21105n = drawable;
        b0();
    }

    public void J(RippleDrawable rippleDrawable) {
        this.f21106o = rippleDrawable;
        b0();
    }

    public void K(int i10) {
        this.f21107p = i10;
        b0();
    }

    public void L(int i10) {
        this.f21109r = i10;
        b0();
    }

    public void M(int i10) {
        if (this.f21110s != i10) {
            this.f21110s = i10;
            this.f21115x = true;
            b0();
        }
    }

    public void N(ColorStateList colorStateList) {
        this.f21104m = colorStateList;
        b0();
    }

    public void O(int i10) {
        this.f21117z = i10;
        b0();
    }

    public void P(int i10) {
        this.f21101j = i10;
        b0();
    }

    public void Q(boolean z10) {
        this.f21102k = z10;
        b0();
    }

    public void R(ColorStateList colorStateList) {
        this.f21103l = colorStateList;
        b0();
    }

    public void S(int i10) {
        this.f21108q = i10;
        b0();
    }

    public void T(int i10) {
        this.f21090C = i10;
        NavigationMenuView navigationMenuView = this.f21092a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i10);
        }
    }

    public void U(ColorStateList colorStateList) {
        this.f21100i = colorStateList;
        a0();
    }

    public void V(int i10) {
        this.f21114w = i10;
        a0();
    }

    public void W(int i10) {
        this.f21113v = i10;
        a0();
    }

    public void X(int i10) {
        this.f21099h = i10;
        a0();
    }

    public void Y(boolean z10) {
        c cVar = this.f21097f;
        if (cVar != null) {
            cVar.s(z10);
        }
    }

    public final void Z() {
        c cVar = this.f21097f;
        if (cVar != null) {
            cVar.u();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
        i.a aVar = this.f21094c;
        if (aVar != null) {
            aVar.a(eVar, z10);
        }
    }

    public final void a0() {
        c cVar = this.f21097f;
        if (cVar != null) {
            cVar.v();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z10) {
        c cVar = this.f21097f;
        if (cVar != null) {
            cVar.t();
        }
    }

    public final void b0() {
        c cVar = this.f21097f;
        if (cVar != null) {
            cVar.w();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean c() {
        return false;
    }

    public final void c0() {
        int i10 = (B() || !this.f21116y) ? 0 : this.f21088A;
        NavigationMenuView navigationMenuView = this.f21092a;
        navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean d(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void f(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f21092a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f21097f.p(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f21093b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean g(androidx.appcompat.view.menu.l lVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return this.f21096e;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable h() {
        Bundle bundle = new Bundle();
        if (this.f21092a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f21092a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f21097f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.i());
        }
        if (this.f21093b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f21093b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean i(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(Context context, androidx.appcompat.view.menu.e eVar) {
        this.f21098g = LayoutInflater.from(context);
        this.f21095d = eVar;
        this.f21089B = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public void l(View view) {
        this.f21093b.addView(view);
        NavigationMenuView navigationMenuView = this.f21092a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void m(a0 a0Var) {
        int iM = a0Var.m();
        if (this.f21088A != iM) {
            this.f21088A = iM;
            c0();
        }
        NavigationMenuView navigationMenuView = this.f21092a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, a0Var.j());
        N.f(this.f21093b, a0Var);
    }

    public androidx.appcompat.view.menu.g n() {
        return this.f21097f.j();
    }

    public int o() {
        return this.f21112u;
    }

    public int p() {
        return this.f21111t;
    }

    public int q() {
        return this.f21093b.getChildCount();
    }

    public Drawable r() {
        return this.f21105n;
    }

    public int s() {
        return this.f21107p;
    }

    public int t() {
        return this.f21109r;
    }

    public int u() {
        return this.f21117z;
    }

    public ColorStateList v() {
        return this.f21103l;
    }

    public ColorStateList w() {
        return this.f21104m;
    }

    public int x() {
        return this.f21108q;
    }

    public androidx.appcompat.view.menu.j y(ViewGroup viewGroup) {
        if (this.f21092a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f21098g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.f21092a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f21092a));
            if (this.f21097f == null) {
                c cVar = new c();
                this.f21097f = cVar;
                cVar.setHasStableIds(true);
            }
            int i10 = this.f21090C;
            if (i10 != -1) {
                this.f21092a.setOverScrollMode(i10);
            }
            LinearLayout linearLayout = (LinearLayout) this.f21098g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f21092a, false);
            this.f21093b = linearLayout;
            linearLayout.setImportantForAccessibility(2);
            this.f21092a.setAdapter(this.f21097f);
        }
        return this.f21092a;
    }

    public int z() {
        return this.f21114w;
    }
}
