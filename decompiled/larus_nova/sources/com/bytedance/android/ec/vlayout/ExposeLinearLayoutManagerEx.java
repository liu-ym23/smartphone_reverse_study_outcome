package com.bytedance.android.ec.vlayout;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import vn.g;

/* JADX INFO: loaded from: classes44.dex */
public class ExposeLinearLayoutManagerEx extends LinearLayoutManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Field f49028o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Method f49029p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f49030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public un.e f49031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f49034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f49036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f49037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f49038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Method f49039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseArray<b> f49040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f49041l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object[] f49042m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g f49043n;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f49044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f49045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ExposeLinearLayoutManagerEx f49047d;

        public final void a() {
            if (this.f49046c == false) goto L5;
            int r100 = this.f49047d.f49031b.g();
        L6:
            this.f49045b = r100;
            return;
        L5:
            r100 = this.f49047d.f49031b.i();
            goto L6
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f49044a + ", mCoordinate=" + this.f49045b + ", mLayoutFromEnd=" + this.f49046c + '}';
        }

        public a(VirtualLayoutManager r100) {
            this.f49047d = r100;
        }

        public final void b(View r100) {
            toString();
            if (this.f49046c == false) goto L9;
            this.f49047d.f49031b.b(r100);
            this.f49047d.p(r100, this.f49046c, true);
            int r101 = this.f49047d.f49031b.b(r100) + this.f49047d.p(r100, this.f49046c, true);
            un.e r102 = this.f49047d.f49031b;
            if (Integer.MIN_VALUE != r102.f550756b) goto L7;
            int r103 = 0;
        L8:
            this.f49045b = r101 + r103;
        L10:
            this.f49044a = this.f49047d.getPosition(r100);
            return;
        L7:
            r103 = r102.j() - r102.f550756b;
            goto L8
        L9:
            this.f49047d.getPosition(r100);
            ExposeLinearLayoutManagerEx r104 = this.f49047d;
            int r105 = r104.f49034e;
            r104.f49031b.e(r100);
            this.f49047d.p(r100, this.f49046c, true);
            this.f49045b = this.f49047d.f49031b.e(r100) + this.f49047d.p(r100, this.f49046c, true);
            goto L10
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f49048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f49049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f49050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f49051d;

        public b() {
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f49052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f49053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Field f49054c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f49055d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Method f49056e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Field f49057f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f49058g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RecyclerView.LayoutManager f49059h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Object[] f49060i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ExposeLinearLayoutManagerEx f49061j;

        public final void a() {
        L15:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            if (this.f49052a != null) goto L22;
            Object r100 = this.f49057f.get(this.f49059h);     // Catch: Exception -> L15
            this.f49052a = r100;     // Catch: Exception -> L15
            if (r100 != null) goto L8;
            return;
        L8:
            Class<?> r101 = r100.getClass();     // Catch: Exception -> L15
            Method r102 = r101.getDeclaredMethod("hide", new Class[]{View.class});     // Catch: Exception -> L15
            this.f49053b = r102;     // Catch: Exception -> L15
            r102.setAccessible(true);     // Catch: Exception -> L15
            Class<?> r103 = Integer.TYPE;     // Catch: NoSuchMethodException -> L12 Exception -> L15
            r101.getDeclaredMethod("findHiddenNonRemovedView", new Class[]{r103, r103}).setAccessible(true);     // Catch: NoSuchMethodException -> L12 Exception -> L15
        L13:
            r101.getDeclaredMethod("isHidden", new Class[]{View.class}).setAccessible(true);     // Catch: Exception -> L15
            Field r104 = r101.getDeclaredField("mBucket");     // Catch: Exception -> L15
            r104.setAccessible(true);     // Catch: Exception -> L15
            Object r105 = r104.get(this.f49052a);     // Catch: Exception -> L15
            this.f49055d = r105;     // Catch: Exception -> L15
            Method r106 = r105.getClass().getDeclaredMethod("clear", new Class[]{Integer.TYPE});     // Catch: Exception -> L15
            this.f49056e = r106;     // Catch: Exception -> L15
            r106.setAccessible(true);     // Catch: Exception -> L15
            Field r107 = r101.getDeclaredField("mHiddenViews");     // Catch: Exception -> L15
            this.f49054c = r107;     // Catch: Exception -> L15
            r107.setAccessible(true);     // Catch: Exception -> L15
            this.f49058g = (List) this.f49054c.get(this.f49052a);     // Catch: Exception -> L15
            return;
        L12:
            r101.getDeclaredMethod("findHiddenNonRemovedView", new Class[]{Integer.TYPE}).setAccessible(true);     // Catch: Exception -> L15
            goto L13
        }

        public final void b(View r100) {
            a();     // Catch: Exception -> L7
            if (this.f49058g.indexOf(r100) >= 0) goto L5;
            Object[] r101 = this.f49060i;     // Catch: Exception -> L7
            r101[0] = r100;     // Catch: Exception -> L7
            this.f49053b.invoke(this.f49052a, r101);     // Catch: Exception -> L7
        L5:
            Objects.toString(r100);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }

        public c(VirtualLayoutManager r100, VirtualLayoutManager r101) {
            this.f49061j = r100;
            this.f49060i = new Object[1];
            this.f49059h = r101;
            Field r102 = RecyclerView.LayoutManager.class.getDeclaredField("mChildHelper");     // Catch: Exception -> L5
            this.f49057f = r102;     // Catch: Exception -> L5
            r102.setAccessible(true);     // Catch: Exception -> L5
            a();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f49062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f49065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f49066e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f49067f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f49068g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f49069h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f49070i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f49071j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f49072k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<RecyclerView.ViewHolder> f49073l;

        public final String toString() {
            return "LayoutState{vhIsRemoved=" + this.f49062a + ", mOnRefresLayout=" + this.f49063b + ", mRecycle=" + this.f49064c + ", mOffset=" + this.f49065d + ", mAvailable=" + this.f49066e + ", mCurrentPosition=" + this.f49067f + ", mItemDirection=" + this.f49068g + ", mLayoutDirection=" + this.f49069h + ", mScrollingOffset=" + this.f49070i + ", mExtra=" + this.f49071j + ", mFixOffset=0, mIsPreLayout=" + this.f49072k + ", mScrapList=" + this.f49073l + '}';
        }

        public d() {
            this.f49062a = null;
            this.f49063b = false;
            this.f49064c = true;
            this.f49071j = 0;
            this.f49072k = false;
            this.f49073l = null;
            Method r100 = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", new Class[0]);     // Catch: NoSuchMethodException -> L5
            this.f49062a = r100;     // Catch: NoSuchMethodException -> L5
            r100.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        public final View a(RecyclerView.Recycler r100) {
            List<RecyclerView.ViewHolder> r101 = this.f49073l;
            if (r101 == null) goto L31;
            int r102 = r101.size();
            int r103 = Integer.MAX_VALUE;
            RecyclerView.ViewHolder r104 = null;
            int r105 = 0;
        L5:
            if (r105 >= r102) goto L28;
            RecyclerView.ViewHolder r106 = (RecyclerView.ViewHolder) ListProtector.get(this.f49073l, r105);
            if (this.f49072k == false) goto L33;
        L19:
            int r107 = (r106.getPosition() - this.f49067f) * this.f49068g;
            if (r107 < 0) goto L27;
            if (r107 >= r103) goto L27;
            r104 = r106;
            if (r107 == 0) goto L28;
            r103 = r107;
        L27:
            r105 = r105 + 1;
            goto L5
        L33:
            boolean r108 = ((Boolean) this.f49062a.invoke(r106, new Object[0])).booleanValue();     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12
        L16:
            if (this.f49072k == true) goto L19;
            if (r108 == false) goto L19;
        L12:
            e = move-exception;
            e.printStackTrace();
        L14:
            r108 = false;
        L10:
            e = move-exception;
            e.printStackTrace();
        L28:
            if (r104 == null) goto L41;
            this.f49067f = r104.getPosition() + this.f49068g;
            return r104.itemView;
        L41:
            return null;
        L31:
            View r109 = r100.getViewForPosition(this.f49067f);
            this.f49067f += this.f49068g;
            return r109;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f49074b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f49075c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Method f49076d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Method f49077e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ViewHolder f49078a;

        static {
            RecyclerView.ViewHolder.class.getDeclaredMethod("shouldIgnore", new Class[0]).setAccessible(true);     // Catch: NoSuchMethodException -> L8
            Method r100 = RecyclerView.ViewHolder.class.getDeclaredMethod("isInvalid", new Class[0]);     // Catch: NoSuchMethodException -> L8
            f49074b = r100;     // Catch: NoSuchMethodException -> L8
            r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
            Method r101 = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", new Class[0]);     // Catch: NoSuchMethodException -> L8
            f49075c = r101;     // Catch: NoSuchMethodException -> L8
            r101.setAccessible(true);     // Catch: NoSuchMethodException -> L8
            Class r102 = Integer.TYPE;     // Catch: NoSuchMethodException -> L8
            Method r103 = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", new Class[]{r102, r102});     // Catch: NoSuchMethodException -> L8
            f49077e = r103;     // Catch: NoSuchMethodException -> L8
            r103.setAccessible(true);     // Catch: NoSuchMethodException -> L8
            f49076d = RecyclerView.ViewHolder.class.getDeclaredMethod("isChanged", new Class[0]);     // Catch: NoSuchMethodException -> L5
        L6:
            f49076d.setAccessible(true);     // Catch: NoSuchMethodException -> L8
            return;
        L5:
            f49076d = RecyclerView.ViewHolder.class.getDeclaredMethod("isUpdated", new Class[0]);     // Catch: NoSuchMethodException -> L8
        L8:
            e = move-exception;
            e.printStackTrace();
        }

        public e(RecyclerView.ViewHolder r100) {
            this.f49078a = r100;
        }

        public static void a(RecyclerView.ViewHolder r100, int r101) {
            f49077e.invoke(r100, new Object[]{0, Integer.valueOf(r101)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
        L12:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public void D(RecyclerView.State r100, a r101) {
    }

    public int p(View r100, boolean r101, boolean r102) {
        return 0;
    }

    public void y() {
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        if (this.f49036g != null) goto L5;
        Bundle r100 = new Bundle();
        if (getChildCount() <= 0) goto L12;
        boolean r101 = this.f49032c ^ this.f49033d;
        r100.putBoolean("AnchorLayoutFromEnd", r101);
        if (r101 == false) goto L11;
        View r102 = v();
        r100.putInt("AnchorOffset", this.f49031b.g() - this.f49031b.b(r102));
        r100.putInt("AnchorPosition", getPosition(r102));
    L13:
        return r100;
    L11:
        View r103 = w();
        r100.putInt("AnchorPosition", getPosition(r103));
        r100.putInt("AnchorOffset", this.f49031b.e(r103) - this.f49031b.i());
        goto L13
    L12:
        r100.putInt("AnchorPosition", -1);
        goto L13
    L5:
        return new Bundle(this.f49036g);
    }

    public final void q() {
        if (this.f49030a != null) goto L6;
        this.f49030a = new d();
    L6:
        if (this.f49031b != null) goto L15;
        this.f49031b = un.e.a(this, getOrientation());
    L15:
        this.f49039j.invoke(this, this.f49042m);     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.f49036g == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f49032c != getStackFromEnd()) goto L7;
        return true;
    }

    public final View v() {
        getChildCount();
        if (this.f49033d == false) goto L5;
        int r100 = 0;
    L7:
        return getChildAt(r100);
    L5:
        r100 = getChildCount() - 1;
        goto L7
    }

    public final View w() {
        if (this.f49033d == false) goto L5;
        int r100 = getChildCount() - 1;
    L7:
        return getChildAt(r100);
    L5:
        r100 = 0;
        goto L7
    }

    public final void C() {
        if (getOrientation() != 1) goto L5;
    L8:
        this.f49033d = getReverseLayout();
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.f49033d = !getReverseLayout();
    }

    public final void G() {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        if (getChildCount() == 0) goto L74;
        int r100 = 0;
        View r101 = getChildAt(0);
        if (r101 != null) goto L10;
        return;
    L10:
        int r102 = getPosition(r101);
        int r103 = getDecoratedTop(getChildAt(0));
        if ((r101.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        r103 = r103 - ((ViewGroup.MarginLayoutParams) r101.getLayoutParams()).topMargin;
    L13:
        SparseIntArray r104 = new SparseIntArray();
        int r105 = r102 - 1;
        b r106 = this.f49040k.get(r105);
        if (r102 == 0) goto L29;
        if (r106 != null) goto L17;
    L18:
        int r107 = 0;
    L19:
        if (r107 >= r102) goto L29;
        b r108 = this.f49040k.get(r107);
        if (r108 != null) goto L23;
    L24:
        r108 = new b();
        r108.f49051d = true;
        this.f49040k.put(r107, r108);
    L25:
        int r109 = r104.get(r108.f49049b);
        int r110 = r108.f49050c - r108.f49048a;
        r108.f49048a = r109;
        int r111 = r110 + r109;
        r108.f49050c = r111;
        if (r111 <= r109) goto L28;
        r104.put(r108.f49049b, r111);
    L28:
        r107 = r107 + 1;
        goto L19
    L23:
        if (r108.f49051d == true) goto L25;
    L17:
        if (r106.f49051d == false) goto L18;
    L29:
        b r112 = this.f49040k.get(r105);
        if (r112 == null) goto L32;
        int r113 = r112.f49050c;
    L33:
        SparseIntArray r114 = new SparseIntArray();
        int r115 = 0;
    L35:
        if (r100 >= getChildCount()) goto L56;
        View r116 = getChildAt(r100);
        if (r116 == null) goto L54;
        r115 = getPosition(r116);
        int r117 = getDecoratedTop(r116);
        int r118 = getDecoratedLeft(r116);
        getDecoratedRight(r116);
        int r119 = getDecoratedBottom(r116);
        if ((r116.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L42;
        r117 = r117 - ((ViewGroup.MarginLayoutParams) r116.getLayoutParams()).topMargin;
        r119 = r119 + ((ViewGroup.MarginLayoutParams) r116.getLayoutParams()).bottomMargin;
    L42:
        b r120 = this.f49040k.get(r115);
        if (r120 != null) goto L45;
        r120 = new b();
        r120.f49051d = true;
        this.f49040k.put(r115, r120);
    L45:
        int r121 = r119 - r117;
        int r122 = (r117 - r103) + r113;
        int r123 = r122 + r121;
        if (r120.f49050c == r123) goto L51;
        if (r104.get(r118) >= r119) goto L51;
        r114.put(r118, r123 - r120.f49050c);
    L51:
        if (r104.get(r118) >= r119) goto L53;
        r104.put(r118, r119);
    L53:
        r120.f49048a = r122;
        r120.f49050c = r122 + r121;
        r120.f49049b = r118;
        r120.f49051d = true;
    L54:
        r100 = r100 + 1;
        goto L35
    L56:
        if (r114.size() != 0) goto L58;
        return;
    L58:
        int r124 = r115 + 1;
        b r125 = this.f49040k.get(r124);
    L59:
        if (r125 == null) goto L75;
        int r126 = r114.get(r125.f49049b, -1);
        if (r126 == (-1)) goto L63;
        r125.f49048a += r126;
        r125.f49050c += r126;
    L63:
        r124 = r124 + 1;
        r125 = this.f49040k.get(r124);
        goto L59
    L75:
        return;
    L32:
        r113 = 0;
        goto L33
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findFirstVisibleItemPosition() {
        q();
        return super.findFirstVisibleItemPosition();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastVisibleItemPosition() {
        q();
        return super.findLastVisibleItemPosition();
    L5:
        e = move-exception;
        getItemCount();
        getChildCount();
        Objects.toString(getChildAt(getChildCount() - 1));
        this.f49041l.getChildCount();
        Objects.toString(this.f49041l.getChildAt(this.f49041l.getChildCount() - 1));
        throw e;
    }

    public final int x() {
        if (getItemCount() != 0) goto L5;
        return 0;
    L5:
        View r100 = getChildAt(0);
        int r101 = getPosition(r100);
        b r102 = this.f49040k.get(r101);
        if (r102 != null) goto L8;
        return 0;
    L8:
        int r103 = getDecoratedTop(r100);
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        r103 = r103 - ((ViewGroup.MarginLayoutParams) r100.getLayoutParams()).topMargin;
    L12:
        return r103 - r102.f49048a;
    }

    public ExposeLinearLayoutManagerEx(Context r100) {
        super(r100, 1, false);
        this.f49033d = false;
        this.f49034e = -1;
        this.f49035f = Integer.MIN_VALUE;
        this.f49036g = null;
        this.f49040k = new SparseArray(20);
        this.f49042m = new Object[0];
        this.f49043n = new g();
        VirtualLayoutManager r101 = (VirtualLayoutManager) this;
        this.f49037h = new a(r101);
        setOrientation(1);
        setReverseLayout(false);
        this.f49038i = new c(r101, r101);
        Method r102 = LinearLayoutManager.class.getDeclaredMethod("ensureLayoutState", new Class[0]);     // Catch: NoSuchMethodException -> L8
        this.f49039j = r102;     // Catch: NoSuchMethodException -> L8
        r102.setAccessible(true);     // Catch: NoSuchMethodException -> L8
        Method r103 = RecyclerView.LayoutManager.class.getDeclaredMethod("setItemPrefetchEnabled", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L11
        if (r103 == null) goto L16;
        r103.invoke(this, new Object[]{Boolean.FALSE});     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L17:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        throw new RuntimeException(e);
    }

    public final View A(RecyclerView.State r100) {
        boolean r101 = this.f49033d;
        int r102 = r100.getItemCount();
        if (r101 == false) goto L6;
        getChildCount();
        return s(0, getChildCount(), r102);
    L6:
        return s(getChildCount() - 1, -1, r102);
    }

    public final View B(RecyclerView.State r100) {
        boolean r101 = this.f49033d;
        int r102 = r100.getItemCount();
        if (r101 == true) goto L7;
        getChildCount();
        return s(0, getChildCount(), r102);
    L7:
        return s(getChildCount() - 1, -1, r102);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void assertNotInLayoutOrScroll(String r100) {
        if (this.f49036g != null) goto L6;
        super.assertNotInLayoutOrScroll(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int r100) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r101 = false;
        int r102 = 1;
        if (r100 >= getPosition(getChildAt(0))) goto L10;
        r101 = true;
    L10:
        if (r101 == this.f49033d) goto L13;
        r102 = -1;
    L13:
        if (getOrientation() != 0) goto L17;
        return new PointF(r102, 0.0f);
    L17:
        return new PointF(0.0f, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView r100) {
        super.onAttachedToWindow(r100);
        this.f49041l = r100;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        G();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L6;
        this.f49036g = (Bundle) r100;
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void removeView(View r100) {
        super.removeView(r100);
        Objects.toString(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void removeViewAt(int r100) {
        super.removeViewAt(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r100) {
        this.f49034e = r100;
        this.f49035f = Integer.MIN_VALUE;
        Bundle r101 = this.f49036g;
        if (r101 == null) goto L5;
        r101.putInt("AnchorPosition", -1);
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int r100) {
        super.setOrientation(r100);
        this.f49031b = null;
    }

    public final void E(RecyclerView.Recycler r100, d r101) {
        if (r101.f49064c == true) goto L6;
        return;
    L6:
        if (r101.f49069h != (-1)) goto L24;
        int r102 = r101.f49070i;
        int r103 = getChildCount();
        if (r102 < 0) goto L53;
        int r104 = this.f49031b.f() - r102;
        if (this.f49033d == false) goto L18;
        int r105 = 0;
    L13:
        if (r105 >= r103) goto L55;
        if ((this.f49031b.e(getChildAt(r105)) - 0) < r104) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        recycleChildren(r100, 0, r105);
        return;
    L55:
        return;
    L18:
        int r106 = r103 - 1;
        int r107 = r106;
    L19:
        if (r107 < 0) goto L56;
        if ((this.f49031b.e(getChildAt(r107)) - 0) < r104) goto L22;
        r107 = r107 - 1;
        goto L19
    L22:
        recycleChildren(r100, r106, r107);
        return;
    L56:
        return;
    L53:
        return;
    L24:
        int r108 = r101.f49070i;
        if (r108 < 0) goto L54;
        int r109 = getChildCount();
        if (this.f49033d == false) goto L35;
        int r110 = r109 - 1;
        int r111 = r110;
    L30:
        if (r111 < 0) goto L57;
        if ((this.f49031b.b(getChildAt(r111)) + 0) > r108) goto L33;
        r111 = r111 - 1;
        goto L30
    L33:
        recycleChildren(r100, r110, r111);
        return;
    L57:
        return;
    L35:
        int r112 = 0;
    L36:
        if (r112 >= r109) goto L58;
        View r113 = getChildAt(r112);
        if ((this.f49031b.b(r113) + 0) > r108) goto L39;
        r112 = r112 + 1;
        goto L36
    L39:
        this.f49031b.b(r113);
        getPosition(r113);
        recycleChildren(r100, 0, r112);
        return;
    L58:
        return;
    }

    public final void I(int r100, int r101) {
        d r102 = this.f49030a;
        r102.f49066e = this.f49031b.g() - r101;
        d r103 = this.f49030a;
        if (this.f49033d == false) goto L5;
        int r104 = -1;
    L6:
        r103.f49068g = r104;
        r103.f49067f = r100;
        r103.f49069h = 1;
        r103.f49065d = r101;
        r103.f49070i = Integer.MIN_VALUE;
        r103.toString();
        return;
    L5:
        r104 = 1;
        goto L6
    }

    public final void J(int r100, int r101) {
        d r102 = this.f49030a;
        r102.f49066e = r101 - this.f49031b.i();
        d r103 = this.f49030a;
        r103.f49067f = r100;
        if (this.f49033d == false) goto L5;
        int r104 = 1;
    L6:
        r103.f49068g = r104;
        r103.f49069h = -1;
        r103.f49065d = r101;
        r103.f49070i = Integer.MIN_VALUE;
        r103.toString();
        return;
    L5:
        r104 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
        this.f49041l = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r110, RecyclerView.State r210) {
        Bundle r100 = this.f49036g;
        if (r100 != null) goto L5;
    L7:
        q();
        this.f49030a.f49064c = false;
        C();
        a r101 = this.f49037h;
        r101.f49044a = -1;
        r101.f49045b = Integer.MIN_VALUE;
        r101.f49046c = false;
        r101.f49046c = this.f49033d ^ getStackFromEnd();
        Objects.toString(this.f49037h);
        a r102 = this.f49037h;
        r210.isPreLayout();
        int r103 = r102.f49044a;
        if (r210.isPreLayout() == true) goto L64;
        int r104 = this.f49034e;
        if (r104 == (-1)) goto L64;
        if (r104 >= 0) goto L14;
    L63:
        this.f49034e = -1;
        this.f49035f = Integer.MIN_VALUE;
        goto L64
    L14:
        if (r104 >= r210.getItemCount()) goto L63;
        r102.f49044a = this.f49034e;
        Bundle r105 = this.f49036g;
        if (r105 == null) goto L25;
        if (r105.getInt("AnchorPosition") < 0) goto L25;
        boolean r106 = this.f49036g.getBoolean("AnchorLayoutFromEnd");
        r102.f49046c = r106;
        if (r106 == false) goto L23;
        r102.f49045b = this.f49031b.g() - this.f49036g.getInt("AnchorOffset");
    L62:
        boolean r107 = true;
    L65:
        if (r107 == false) goto L68;
    L121:
        Objects.toString(this.f49037h);
        int r108 = getExtraLayoutSpace(r210);
        if (r210.getTargetScrollPosition() >= this.f49037h.f49044a) goto L124;
        boolean r109 = true;
    L126:
        if (r109 != this.f49033d) goto L128;
        int r111 = r108;
        r108 = 0;
    L129:
        int r112 = r108 + this.f49031b.i();
        int r113 = r111 + this.f49031b.h();
        if (r210.isPreLayout() == false) goto L145;
        int r114 = this.f49034e;
        if (r114 == (-1)) goto L145;
        if (this.f49035f == Integer.MIN_VALUE) goto L145;
        View r115 = findViewByPosition(r114);
        if (r115 == null) goto L145;
        if (this.f49033d == false) goto L140;
        int r116 = this.f49031b.g() - this.f49031b.b(r115);
        int r117 = this.f49035f;
    L141:
        int r118 = r116 - r117;
        if (r118 <= 0) goto L144;
        r112 = r112 + r118;
        goto L145
    L144:
        r113 = r113 - r118;
        goto L145
    L140:
        r117 = this.f49031b.e(r115) - this.f49031b.i();
        r116 = this.f49035f;
    L145:
        D(r210, this.f49037h);
        Objects.toString(this.f49037h);
        detachAndScrapAttachedViews(r110);
        this.f49030a.f49072k = r210.isPreLayout();
        this.f49030a.f49063b = true;
        a r119 = this.f49037h;
        if (r119.f49046c == false) goto L151;
        J(r119.f49044a, r119.f49045b);
        d r120 = this.f49030a;
        r120.f49071j = r112;
        r(r110, r120, r210, false);
        d r121 = this.f49030a;
        int r122 = r121.f49065d;
        int r123 = r121.f49066e;
        if (r123 <= 0) goto L150;
        r113 = r113 + r123;
    L150:
        a r124 = this.f49037h;
        I(r124.f49044a, r124.f49045b);
        d r125 = this.f49030a;
        r125.f49071j = r113;
        r125.f49067f += r125.f49068g;
        r(r110, r125, r210, false);
        int r126 = this.f49030a.f49065d;
    L156:
        if (getChildCount() <= 0) goto L163;
        if ((this.f49033d ^ getStackFromEnd()) == false) goto L160;
        int r127 = t(r126, r110, r210, true);
        int r128 = r122 + r127;
        int r129 = r126 + r127;
        int r130 = u(r128, r110, r210, false);
    L161:
        r122 = r128 + r130;
        r126 = r129 + r130;
        goto L163
    L160:
        int r131 = u(r122, r110, r210, true);
        r128 = r122 + r131;
        r129 = r126 + r131;
        r130 = t(r129, r110, r210, false);
    L163:
        if (r210.willRunPredictiveAnimations() == false) goto L200;
        if (getChildCount() == 0) goto L200;
        if (r210.isPreLayout() == true) goto L200;
        if (supportsPredictiveItemAnimations() == false) goto L200;
        List<RecyclerView.ViewHolder> r132 = r110.getScrapList();
        int r133 = r132.size();
        int r134 = getPosition(getChildAt(0));
        int r135 = 0;
        int r136 = 0;
        int r137 = 0;
    L172:
        if (r135 >= r133) goto L185;
        RecyclerView.ViewHolder r138 = (RecyclerView.ViewHolder) ListProtector.get(r132, r135);
        if (r138.getPosition() >= r134) goto L176;
        boolean r139 = true;
    L178:
        if (r139 == this.f49033d) goto L180;
        byte r140 = -1;
    L181:
        if (r140 != (-1)) goto L183;
        r136 = r136 + this.f49031b.c(r138.itemView);
    L184:
        r135 = r135 + 1;
        goto L172
    L183:
        r137 = r137 + this.f49031b.c(r138.itemView);
        goto L184
    L180:
        r140 = 1;
        goto L181
    L176:
        r139 = false;
        goto L178
    L185:
        this.f49030a.f49073l = r132;
        if (r136 <= 0) goto L192;
        J(getPosition(w()), r122);
        d r141 = this.f49030a;
        r141.f49071j = r136;
        r141.f49066e = 0;
        int r142 = r141.f49067f;
        if (this.f49033d == false) goto L190;
        int r143 = 1;
    L191:
        r141.f49067f = r142 + r143;
        r141.f49063b = true;
        r(r110, r141, r210, false);
        goto L192
    L190:
        r143 = -1;
    L192:
        if (r137 <= 0) goto L198;
        I(getPosition(v()), r126);
        d r144 = this.f49030a;
        r144.f49071j = r137;
        r144.f49066e = 0;
        int r145 = r144.f49067f;
        if (this.f49033d == false) goto L196;
        int r146 = -1;
    L197:
        r144.f49067f = r145 + r146;
        r144.f49063b = true;
        r(r110, r144, r210, false);
        goto L198
    L196:
        r146 = 1;
    L198:
        this.f49030a.f49073l = null;
    L200:
        if (r210.isPreLayout() == true) goto L202;
        this.f49034e = -1;
        this.f49035f = Integer.MIN_VALUE;
        un.e r147 = this.f49031b;
        r147.f550756b = r147.j();
    L202:
        this.f49032c = getStackFromEnd();
        this.f49036g = null;
        return;
    L151:
        I(r119.f49044a, r119.f49045b);
        d r148 = this.f49030a;
        r148.f49071j = r113;
        r(r110, r148, r210, false);
        d r149 = this.f49030a;
        int r150 = r149.f49065d;
        int r151 = r149.f49066e;
        if (r151 <= 0) goto L154;
        r112 = r112 + r151;
    L154:
        a r152 = this.f49037h;
        J(r152.f49044a, r152.f49045b);
        d r153 = this.f49030a;
        r153.f49071j = r112;
        r153.f49067f += r153.f49068g;
        r(r110, r153, r210, false);
        r122 = this.f49030a.f49065d;
        r126 = r150;
        goto L156
    L128:
        r111 = 0;
        goto L129
    L124:
        r109 = false;
        goto L126
    L68:
        if (getChildCount() == 0) goto L113;
        View r154 = getFocusedChild();
        if (r154 == null) goto L83;
        RecyclerView.LayoutParams r155 = (RecyclerView.LayoutParams) r154.getLayoutParams();
        if (r155.isItemRemoved() == false) goto L75;
    L79:
        boolean r156 = false;
    L80:
        if (r156 == false) goto L83;
    L112:
        boolean r157 = true;
    L114:
        if (r157 == true) goto L121;
        r102.a();
        if (getStackFromEnd() == false) goto L119;
        int r158 = r210.getItemCount() - 1;
    L120:
        r102.f49044a = r158;
        goto L121
    L119:
        r158 = 0;
        goto L120
    L75:
        if (r155.getViewPosition() < 0) goto L79;
        if (r155.getViewPosition() >= r210.getItemCount()) goto L79;
        r102.b(r154);
        r156 = true;
    L83:
        if (this.f49032c != getStackFromEnd()) goto L113;
        Objects.toString(r102);
        View r159 = A(r210);
        View r160 = B(r210);
        if (r159 == null) goto L89;
        if (r160 == null) goto L89;
        getPosition(r159);
        getPosition(r160);
    L91:
        if (r102.f49046c == false) goto L93;
        View r161 = A(r210);
    L94:
        if (r161 == null) goto L113;
        r102.b(r161);
        if (r210.isPreLayout() == true) goto L112;
        if (supportsPredictiveItemAnimations() == false) goto L112;
        if (this.f49031b.e(r161) < this.f49031b.g()) goto L102;
    L105:
        boolean r162 = true;
    L106:
        if (r162 == false) goto L112;
        if (r102.f49046c == false) goto L110;
        int r163 = this.f49031b.g();
    L111:
        r102.f49045b = r163;
        goto L112
    L110:
        r163 = this.f49031b.i();
        goto L111
    L102:
        if (this.f49031b.b(r161) < this.f49031b.i()) goto L105;
        r162 = false;
        goto L106
    L93:
        r161 = B(r210);
    L89:
        Objects.toString(r159);
        Objects.toString(r160);
    L113:
        r157 = false;
        goto L114
    L23:
        r102.f49045b = this.f49031b.i() + this.f49036g.getInt("AnchorOffset");
    L25:
        if (this.f49035f != Integer.MIN_VALUE) goto L58;
        View r164 = findViewByPosition(this.f49034e);
        if (r164 == null) goto L47;
        if (this.f49031b.c(r164) <= this.f49031b.j()) goto L32;
        r102.a();
        goto L62
    L32:
        if ((this.f49031b.e(r164) - this.f49031b.i()) >= 0) goto L35;
        r102.f49045b = this.f49031b.i();
        r102.f49046c = false;
        goto L62
    L35:
        if ((this.f49031b.g() - this.f49031b.b(r164)) >= 0) goto L38;
        r102.f49045b = this.f49031b.g();
        r102.f49046c = true;
        goto L62
    L38:
        if (r102.f49046c == false) goto L44;
        int r165 = this.f49031b.b(r164);
        un.e r166 = this.f49031b;
        if (Integer.MIN_VALUE != r166.f550756b) goto L42;
        int r167 = 0;
    L43:
        int r168 = r165 + r167;
    L45:
        r102.f49045b = r168;
        goto L62
    L42:
        r167 = r166.j() - r166.f550756b;
        goto L43
    L44:
        r168 = this.f49031b.e(r164);
        goto L45
    L47:
        if (getChildCount() > 0) goto L49;
    L57:
        r102.a();
        goto L62
    L49:
        if (this.f49034e >= getPosition(getChildAt(0))) goto L51;
        boolean r169 = true;
    L53:
        if (r169 != this.f49033d) goto L55;
        boolean r170 = true;
    L56:
        r102.f49046c = r170;
        goto L57
    L55:
        r170 = false;
        goto L56
    L51:
        r169 = false;
        goto L53
    L58:
        boolean r171 = this.f49033d;
        r102.f49046c = r171;
        if (r171 == false) goto L61;
        r102.f49045b = this.f49031b.g() - this.f49035f;
        goto L62
    L61:
        r102.f49045b = this.f49031b.i() + this.f49035f;
    L64:
        r107 = false;
        goto L65
    L5:
        if (r100.getInt("AnchorPosition") < 0) goto L7;
        this.f49036g.getInt("AnchorPosition");
        this.f49034e = this.f49036g.getInt("AnchorPosition");
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int r100, int r101) {
        this.f49034e = r100;
        this.f49035f = r101;
        Bundle r102 = this.f49036g;
        if (r102 == null) goto L5;
        r102.putInt("AnchorPosition", -1);
    L5:
        requestLayout();
    }

    public int F(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getChildCount() == 0) goto L17;
        if (r100 == 0) goto L17;
        this.f49030a.f49064c = true;
        q();
        if (r100 <= 0) goto L9;
        int r103 = 1;
    L10:
        int r104 = Math.abs(r100);
        H(r103, r104, true, r102);
        d r105 = this.f49030a;
        int r106 = r105.f49070i;
        r105.f49063b = false;
        int r107 = r106 + r(r101, r105, r102, false);
        if (r107 >= 0) goto L13;
        return 0;
    L13:
        if (r104 <= r107) goto L15;
        r100 = r103 * r107;
    L15:
        this.f49031b.k(-r100);
        return r100;
    L9:
        r103 = -1;
    L17:
        return 0;
    }

    public void recycleChildren(RecyclerView.Recycler r100, int r101, int r102) {
        if (r101 != r102) goto L4;
        return;
    L4:
        if (r102 <= r101) goto L8;
        int r103 = r102 - 1;
    L6:
        if (r103 < r101) goto L10;
        removeAndRecycleViewAt(r103, r100);
        r103 = r103 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r101 <= r102) goto L13;
        removeAndRecycleViewAt(r101, r100);
        r101 = r101 - 1;
        goto L8
    }

    public final View s(int r100, int r101, int r110) {
        q();
        int r102 = this.f49031b.i();
        int r103 = this.f49031b.g();
        if (r101 <= r100) goto L5;
        int r104 = 1;
    L6:
        View r105 = null;
        View r106 = null;
    L7:
        if (r100 == r101) goto L23;
        View r107 = getChildAt(r100);
        int r108 = getPosition(r107);
        if (r108 < 0) goto L22;
        if (r108 >= r110) goto L22;
        if (((RecyclerView.LayoutParams) r107.getLayoutParams()).isItemRemoved() == false) goto L16;
        if (r106 != null) goto L22;
        r106 = r107;
        goto L22
    L16:
        if (this.f49031b.e(r107) < r103) goto L18;
    L20:
        if (r105 != null) goto L22;
        r105 = r107;
        goto L22
    L18:
        if (this.f49031b.b(r107) < r102) goto L20;
        return r107;
    L22:
        r100 = r100 + r104;
        goto L7
    L23:
        if (r105 == null) goto L26;
        return r105;
    L26:
        return r106;
    L5:
        r104 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getOrientation() != 1) goto L7;
        return 0;
    L7:
        return F(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getOrientation() != 0) goto L7;
        return 0;
    L7:
        return F(r100, r101, r102);
    }

    public final void H(int r100, int r101, boolean r102, RecyclerView.State r103) {
        this.f49030a.f49071j = getExtraLayoutSpace(r103);
        d r104 = this.f49030a;
        r104.f49069h = r100;
        int r105 = -1;
        if (r100 != 1) goto L9;
        r104.f49071j += this.f49031b.h();
        View r106 = v();
        d r107 = this.f49030a;
        if (this.f49033d == true) goto L8;
        r105 = 1;
    L8:
        r107.f49068g = r105;
        int r108 = r107.f49067f;
        int r109 = getPosition(r106);
        d r110 = this.f49030a;
        r107.f49067f = r109 + r110.f49068g;
        int r111 = r110.f49067f;
        r110.f49065d = this.f49031b.b(r106) + p(r106, true, false);
        int r112 = this.f49030a.f49065d - this.f49031b.g();
    L13:
        d r113 = this.f49030a;
        r113.f49066e = r101;
        if (r102 == false) goto L16;
        r113.f49066e = r101 - r112;
    L16:
        r113.f49070i = r112;
        r113.toString();
        return;
    L9:
        View r114 = w();
        this.f49030a.f49071j += this.f49031b.i();
        d r115 = this.f49030a;
        if (this.f49033d == false) goto L12;
        r105 = 1;
    L12:
        r115.f49068g = r105;
        int r116 = r115.f49067f;
        int r117 = getPosition(r114);
        d r118 = this.f49030a;
        r115.f49067f = r117 + r118.f49068g;
        int r119 = r118.f49067f;
        r118.f49065d = this.f49031b.e(r114) + p(r114, false, false);
        r112 = (-this.f49030a.f49065d) + this.f49031b.i();
        goto L13
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View onFocusSearchFailed(View r100, int r101, RecyclerView.Recycler r102, RecyclerView.State r110) {
        C();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r103 = getOrientation();
        if (r101 != 1) goto L8;
    L24:
        int r104 = -1;
    L27:
        if (r104 != Integer.MIN_VALUE) goto L29;
        return null;
    L29:
        if (r104 != (-1)) goto L31;
        View r105 = B(r110);
    L32:
        if (r105 != null) goto L34;
        return null;
    L34:
        q();
        H(r104, (int) (this.f49031b.j() * 0.33f), false, r110);
        d r106 = this.f49030a;
        r106.f49070i = Integer.MIN_VALUE;
        r106.f49064c = false;
        r106.f49063b = false;
        r(r102, r106, r110, true);
        if (r104 != (-1)) goto L37;
        View r107 = w();
    L38:
        if (r107 != r105) goto L40;
    L43:
        return null;
    L40:
        if (r107.isFocusable() == false) goto L43;
        return r107;
    L37:
        r107 = v();
        goto L38
    L31:
        r105 = A(r110);
        goto L32
    L8:
        if (r101 != 2) goto L10;
    L19:
        r104 = 1;
        goto L27
    L10:
        if (r101 != 17) goto L12;
        if (r103 == 0) goto L24;
    L20:
        r104 = Integer.MIN_VALUE;
        goto L27
    L12:
        if (r101 != 33) goto L14;
        if (r103 != 1) goto L20;
    L14:
        if (r101 != 66) goto L16;
        if (r103 != 0) goto L20;
    L16:
        if (r101 != 130) goto L20;
        if (r103 != 1) goto L20;
        goto L19
    }

    public final int r(RecyclerView.Recycler r110, d r111, RecyclerView.State r112, boolean r113) {
        int r100 = r111.f49066e;
        int r101 = r111.f49070i;
        if (r101 == Integer.MIN_VALUE) goto L7;
        if (r100 >= 0) goto L6;
        r111.f49070i = r101 + r100;
    L6:
        E(r110, r111);
    L7:
        int r102 = (r111.f49066e + r111.f49071j) + 0;
        r111.toString();
        getChildCount();
        boolean r103 = false;
    L8:
        if (r102 <= 0) goto L37;
        int r104 = r111.f49067f;
        if (r104 >= 0) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L37;
        g r106 = this.f49043n;
        r106.f556369a = 0;
        r106.f556370b = false;
        r106.f556371c = false;
        r106.f556372d = false;
        z(r110, r112, r111, r106);
        g r107 = this.f49043n;
        if (r107.f556370b == true) goto L37;
        r111.f49065d += r107.f556369a * r111.f49069h;
        if (r107.f556371c == true) goto L22;
    L25:
        int r108 = r111.f49066e;
        int r109 = this.f49043n.f556369a;
        r111.f49066e = r108 - r109;
        r102 = r102 - r109;
    L26:
        int r114 = r111.f49070i;
        if (r114 == Integer.MIN_VALUE) goto L32;
        int r115 = r114 + this.f49043n.f556369a;
        r111.f49070i = r115;
        int r116 = r111.f49066e;
        if (r116 >= 0) goto L31;
        r111.f49070i = r115 + r116;
    L31:
        E(r110, r111);
    L32:
        if (r113 == false) goto L36;
        if (this.f49043n.f556372d == true) goto L37;
    L36:
        r111.toString();
        this.f49043n.toString();
        getChildCount();
        r103 = true;
        goto L8
    L22:
        if (this.f49030a.f49073l != null) goto L25;
        if (r112.isPreLayout() == true) goto L26;
    L12:
        if (r104 >= r112.getItemCount()) goto L14;
        r105 = true;
    L37:
        getChildCount();
        if (r103 == false) goto L41;
        G();
    L41:
        return r100 - r111.f49066e;
    }

    public final int t(int r100, RecyclerView.Recycler r101, RecyclerView.State r102, boolean r103) {
        int r104 = this.f49031b.g() - r100;
        if (r104 <= 0) goto L11;
        int r105 = -F(-r104, r101, r102);
        int r106 = r100 + r105;
        if (r103 == false) goto L10;
        int r107 = this.f49031b.g() - r106;
        if (r107 <= 0) goto L10;
        this.f49031b.k(r107);
        return r107 + r105;
    L10:
        return r105;
    L11:
        return 0;
    }

    public final int u(int r100, RecyclerView.Recycler r101, RecyclerView.State r102, boolean r103) {
        int r104 = r100 - this.f49031b.i();
        if (r104 <= 0) goto L10;
        int r105 = -F(r104, r101, r102);
        int r106 = r100 + r105;
        if (r103 == false) goto L12;
        int r107 = r106 - this.f49031b.i();
        if (r107 <= 0) goto L13;
        this.f49031b.k(-r107);
        return r105 - r107;
    L13:
        return r105;
    L12:
        return r105;
    L10:
        return 0;
    }

    public void z(RecyclerView.Recycler r110, RecyclerView.State r111, d r112, g r113) {
        View r114 = r112.a(r110);
        if (r114 != null) goto L6;
        r113.f556370b = true;
        return;
    L6:
        RecyclerView.LayoutParams r100 = (RecyclerView.LayoutParams) r114.getLayoutParams();
        if (r112.f49073l != null) goto L15;
        boolean r101 = this.f49033d;
        if (r112.f49069h != (-1)) goto L11;
        boolean r102 = true;
    L12:
        if (r101 != r102) goto L14;
        addView(r114);
    L22:
        measureChildWithMargins(r114, 0, 0);
        r113.f556369a = this.f49031b.c(r114);
        if (getOrientation() == 1) goto L25;
        int r103 = getPaddingTop();
        int r104 = this.f49031b.d(r114) + r103;
        if (r112.f49069h != (-1)) goto L35;
        int r115 = r112.f49065d;
        int r105 = r115 - r113.f556369a;
        int r106 = r115;
        int r116 = r104;
        int r107 = r105;
        int r108 = r103;
    L36:
        layoutDecorated(r114, r107 + ((ViewGroup.MarginLayoutParams) r100).leftMargin, ((ViewGroup.MarginLayoutParams) r100).topMargin + r108, r106 - ((ViewGroup.MarginLayoutParams) r100).rightMargin, r116 - ((ViewGroup.MarginLayoutParams) r100).bottomMargin);
        if (r100.isItemRemoved() == false) goto L39;
    L40:
        r113.f556371c = true;
    L41:
        r113.f556372d = r114.isFocusable();
        r113.toString();
        return;
    L39:
        if (r100.isItemChanged() == false) goto L41;
    L35:
        int r117 = r112.f49065d;
        int r109 = r113.f556369a + r117;
        r107 = r117;
        r116 = r104;
        r108 = r103;
        r106 = r109;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        r106 = getWidth() - getPaddingRight();
        r107 = r106 - this.f49031b.d(r114);
    L29:
        if (r112.f49069h != (-1)) goto L31;
        r116 = r112.f49065d;
        r108 = r116 - r113.f556369a;
        goto L36
    L31:
        r108 = r112.f49065d;
        r116 = r113.f556369a + r108;
        goto L36
    L27:
        r107 = getPaddingLeft();
        r106 = this.f49031b.d(r114) + r107;
        goto L29
    L14:
        addView(r114, 0);
        goto L22
    L11:
        r102 = false;
        goto L12
    L15:
        boolean r118 = this.f49033d;
        if (r112.f49069h != (-1)) goto L18;
        boolean r119 = true;
    L19:
        if (r118 != r119) goto L21;
        addDisappearingView(r114);
        goto L22
    L21:
        addDisappearingView(r114, 0);
        goto L22
    L18:
        r119 = false;
        goto L19
    }
}
