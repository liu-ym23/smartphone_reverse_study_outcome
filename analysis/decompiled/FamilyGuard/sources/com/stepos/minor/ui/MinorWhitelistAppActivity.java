package com.stepos.minor.ui;

import D2.v;
import D2.w;
import D2.z;
import D3.h;
import F2.y;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.lifecycle.B;
import androidx.lifecycle.C;
import androidx.lifecycle.U;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import com.stepos.minor.WhitelistApp;
import com.stepos.minor.ui.MinorWhitelistAppActivity;
import f2.C0702g;
import j2.C0790g;
import j2.s;
import j2.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.libpag.BuildConfig;
import z3.C1347a;

/* loaded from: classes.dex */
public class MinorWhitelistAppActivity extends com.stepos.familyguard.ui.base.a {

    /* renamed from: c, reason: collision with root package name */
    private C0790g f15404c;

    /* renamed from: e, reason: collision with root package name */
    private y f15406e;

    /* renamed from: f, reason: collision with root package name */
    private long f15407f;

    /* renamed from: d, reason: collision with root package name */
    private final B<List<c>> f15405d = new B<>();

    /* renamed from: g, reason: collision with root package name */
    private int f15408g = -1;

    private static class a extends x2.c {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f15409a;

        /* renamed from: b, reason: collision with root package name */
        private int f15410b;

        /* renamed from: c, reason: collision with root package name */
        private int f15411c;

        /* renamed from: d, reason: collision with root package name */
        private int f15412d;

        /* renamed from: e, reason: collision with root package name */
        private int f15413e;

        /* renamed from: f, reason: collision with root package name */
        private int f15414f;

        /* renamed from: g, reason: collision with root package name */
        private int f15415g;

        /* renamed from: h, reason: collision with root package name */
        private int f15416h;

        /* renamed from: i, reason: collision with root package name */
        private int f15417i;

        /* JADX INFO: Access modifiers changed from: private */
        public int p(int i5) {
            int i6;
            if (this.f15410b > 0 && i5 == this.f15412d) {
                return -1;
            }
            int i7 = this.f15413e;
            if (i5 >= i7 && i5 <= this.f15414f) {
                return i5 - i7;
            }
            if ((this.f15411c <= 0 || i5 != this.f15415g) && i5 >= (i6 = this.f15416h) && i5 <= this.f15417i) {
                return (i5 - i6) + this.f15414f;
            }
            return -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i5 = this.f15410b;
            int i6 = i5 == 0 ? 0 : i5 + 1;
            int i7 = this.f15411c;
            return i6 + (i7 != 0 ? i7 + 1 : 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i5) {
            if (i5 == this.f15412d) {
                return 0;
            }
            if (i5 == this.f15415g) {
                return 1;
            }
            if (i5 < this.f15413e || i5 > this.f15414f) {
                return (i5 < this.f15416h || i5 > this.f15417i) ? 4 : 3;
            }
            return 2;
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.c
        public int immersiveItemType(int i5) {
            if (i5 == this.f15412d || i5 == this.f15415g) {
                return 4;
            }
            return i5 == this.f15413e ? this.f15410b == 1 ? 3 : 0 : i5 == this.f15416h ? this.f15411c == 1 ? 3 : 0 : (i5 == this.f15414f || i5 == this.f15417i) ? 2 : 1;
        }

        public void n() {
            if (this.f15409a.isEmpty()) {
                this.f15410b = 0;
                this.f15411c = 0;
                this.f15412d = -1;
                this.f15413e = -1;
                this.f15414f = -1;
                this.f15415g = -1;
                this.f15416h = -1;
                this.f15417i = -1;
                return;
            }
            this.f15410b = MinorWhitelistAppActivity.b0(this.f15409a);
            int size = this.f15409a.size();
            int i5 = this.f15410b;
            int i6 = size - i5;
            this.f15411c = i6;
            if (i5 <= 0) {
                if (i6 > 0) {
                    this.f15415g = 0;
                    this.f15416h = 1;
                    this.f15417i = i6;
                    return;
                }
                return;
            }
            this.f15412d = 0;
            this.f15413e = 1;
            this.f15414f = i5;
            if (i6 > 0) {
                this.f15415g = i5 + 1;
                this.f15416h = i5 + 2;
                this.f15417i = i5 + i6 + 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
            return null;
        }

        public void q(List<c> list) {
            this.f15409a.clear();
            this.f15409a.addAll(list);
            n();
        }

        private a() {
            this.f15409a = new ArrayList();
            this.f15410b = 0;
            this.f15411c = 0;
            this.f15412d = -1;
            this.f15413e = -1;
            this.f15414f = -1;
            this.f15415g = -1;
            this.f15416h = -1;
            this.f15417i = -1;
        }
    }

    private static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final x f15418a;

        public b(View view) {
            super(view);
            this.f15418a = x.a(view);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f15419a;

        /* renamed from: b, reason: collision with root package name */
        public String f15420b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15421c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f15422d;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f15421c == cVar.f15421c && this.f15422d == cVar.f15422d && TextUtils.equals(this.f15419a, cVar.f15419a) && TextUtils.equals(this.f15420b, cVar.f15420b);
        }

        public int hashCode() {
            return Objects.hash(this.f15419a, this.f15420b, Boolean.valueOf(this.f15421c), Boolean.valueOf(this.f15422d));
        }
    }

    public static class d extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final s f15423a;

        /* renamed from: b, reason: collision with root package name */
        private a f15424b;

        static class a implements z<Drawable> {

            /* renamed from: a, reason: collision with root package name */
            ImageView f15425a;

            a() {
            }

            @Override // D2.z
            public void b() {
                this.f15425a.setBackgroundResource(R.drawable.us_ic_default_app);
            }

            @Override // D2.z
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Drawable drawable) {
                if (drawable == null) {
                    this.f15425a.setBackgroundResource(R.drawable.us_ic_default_app);
                } else {
                    this.f15425a.setBackground(drawable);
                }
            }
        }

        public interface b {
            void a(c cVar);
        }

        static class c implements v<String> {

            /* renamed from: a, reason: collision with root package name */
            String f15426a;

            c() {
            }

            @Override // D2.v
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get() {
                return this.f15426a;
            }
        }

        public d(View view) {
            super(view);
            this.f15423a = s.a(view);
        }

        public static /* synthetic */ void a(b bVar, c cVar, View view) {
            if (bVar != null) {
                bVar.a(cVar);
            }
        }

        public void b(final c cVar, D2.b bVar, final b bVar2) {
            if (this.f15424b == null) {
                a aVar = new a();
                this.f15424b = aVar;
                aVar.f15425a = this.f15423a.f17790d;
            }
            this.f15423a.f17788b.setText(cVar.f15420b);
            this.f15423a.f17789c.setImageResource(cVar.f15421c ? cVar.f15422d ? R.drawable.stepos_list_ic_delete : R.drawable.stepos_list_ic_delete_disable : R.drawable.stepos_list_ic_add);
            this.f15423a.f17789c.setEnabled(cVar.f15422d);
            c cVar2 = new c();
            cVar2.f15426a = cVar.f15419a;
            bVar.d(cVar2, this.f15424b);
            this.f15423a.f17789c.setOnClickListener(new View.OnClickListener() { // from class: H2.V0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MinorWhitelistAppActivity.d.a(bVar2, cVar, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e extends x2.c {

        /* renamed from: a, reason: collision with root package name */
        private a f15427a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final D2.b f15428b;

        /* renamed from: c, reason: collision with root package name */
        private final d.b f15429c;

        public e(D2.b bVar, d.b bVar2) {
            this.f15429c = bVar2;
            this.f15428b = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f15427a.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i5) {
            return this.f15427a.getItemViewType(i5);
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.c
        public int immersiveItemType(int i5) {
            return this.f15427a.immersiveItemType(i5);
        }

        public void k(List<c> list) {
            a aVar = new a();
            this.f15427a = aVar;
            aVar.q(list);
            notifyDataSetChanged();
        }

        @Override // x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
            super.onBindViewHolder(viewHolder, i5);
            if (!(viewHolder instanceof b)) {
                if (viewHolder instanceof d) {
                    ((d) viewHolder).b((c) this.f15427a.f15409a.get(this.f15427a.p(i5)), this.f15428b, this.f15429c);
                }
            } else {
                int i6 = this.f15427a.getItemViewType(i5) == 0 ? R.string.mm_desc_whitelist : R.string.mm_desc_app_list;
                b bVar = (b) viewHolder;
                bVar.f15418a.f17799b.setVisibility(8);
                bVar.f15418a.f17800c.setText(i6);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
            if (i5 == 0 || i5 == 1) {
                return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.us_category_item, viewGroup, false));
            }
            if (i5 == 2 || i5 == 3) {
                return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.minor_wl_item, viewGroup, false));
            }
            throw new IllegalArgumentException("Unsupported view type: " + i5);
        }
    }

    private static class f implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            boolean z5 = cVar.f15421c;
            if (z5 != cVar2.f15421c) {
                return z5 ? -1 : 1;
            }
            boolean z6 = cVar.f15422d;
            if (z6 != cVar2.f15422d) {
                return z6 ? 1 : -1;
            }
            String strE = TextUtils.isEmpty(cVar.f15420b) ? null : Z0.b.e(cVar.f15420b, BuildConfig.FLAVOR);
            String strE2 = TextUtils.isEmpty(cVar2.f15420b) ? null : Z0.b.e(cVar2.f15420b, BuildConfig.FLAVOR);
            if (TextUtils.isEmpty(strE)) {
                return 1;
            }
            if (TextUtils.isEmpty(strE2)) {
                return -1;
            }
            return strE.compareTo(strE2);
        }

        private f() {
        }
    }

    private void a0() {
        MyRecyclerView myRecyclerView = this.f15404c.f17712b;
        myRecyclerView.setClipToPadding(false);
        if (this.f15408g < 0) {
            this.f15408g = myRecyclerView.getPaddingBottom();
        }
        H.w0(myRecyclerView, new InterfaceC0479y() { // from class: H2.S0
            @Override // androidx.core.view.InterfaceC0479y
            public final androidx.core.view.Y a(View view, androidx.core.view.Y y5) {
                return this.f2753a.d0(view, y5);
            }
        });
        myRecyclerView.setPadding(myRecyclerView.getPaddingLeft(), myRecyclerView.getPaddingTop(), myRecyclerView.getPaddingRight(), this.f15408g + h0(myRecyclerView));
        H.g0(myRecyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b0(List<c> list) {
        Iterator<c> it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next().f15421c) {
                i5++;
            }
        }
        return i5;
    }

    private WhitelistApp c0(String str, List<WhitelistApp> list) {
        for (WhitelistApp whitelistApp : list) {
            if (whitelistApp.packageName.equals(str)) {
                return whitelistApp;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Y d0(View view, Y y5) {
        int iH0 = y5.f(Y.l.d()).f9645d;
        if (iH0 <= 0) {
            iH0 = h0(view);
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.f15408g + iH0);
        return y5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(List list) {
        List<String> listK = PackageUtils.h(getApplicationContext()).k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        R1.a.b("ZYY", listK.toString());
        for (String str : listK) {
            ArrayList arrayList3 = new ArrayList(Arrays.asList(PackageUtils.f14711j));
            c cVar = new c();
            WhitelistApp whitelistAppC0 = c0(str, list);
            if (!arrayList3.contains(str)) {
                cVar.f15419a = str;
                R1.a.b("ZYY", "packageName:" + str);
                cVar.f15420b = PackageUtils.h(getApplicationContext()).m(str).label;
                if (whitelistAppC0 == null) {
                    cVar.f15422d = true;
                    cVar.f15421c = false;
                } else {
                    cVar.f15422d = whitelistAppC0.removable;
                    cVar.f15421c = true;
                }
                if (!arrayList2.contains(str)) {
                    arrayList2.add(str);
                    arrayList.add(cVar);
                }
            }
        }
        Collections.sort(arrayList, new f());
        this.f15405d.k(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean f0(c cVar) {
        boolean z5 = true;
        if (!cVar.f15421c) {
            C0702g.b("MinorWhitelistAppActivity", "add whitelist " + cVar.f15419a);
            this.f15406e.Z(this.f15407f, cVar.f15419a);
        } else if (cVar.f15422d) {
            C0702g.b("MinorWhitelistAppActivity", "remove whitelist " + cVar.f15419a);
            this.f15406e.B0(this.f15407f, cVar.f15419a);
        } else {
            z5 = false;
        }
        return Boolean.valueOf(z5);
    }

    private static int h0(View view) {
        int identifier = view.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return identifier > 0 ? view.getResources().getDimensionPixelSize(identifier) : Math.round(view.getResources().getDisplayMetrics().density * 48.0f);
    }

    public static void i0(Activity activity, long j5) {
        Intent intent = new Intent(activity, (Class<?>) MinorWhitelistAppActivity.class);
        intent.putExtra(WhitelistApp.COLUMN_MINOR_ID, j5);
        activity.startActivity(intent);
    }

    public void g0(c cVar) {
        x3.f.D(cVar).E(new h() { // from class: H2.T0
            @Override // D3.h
            public final Object apply(Object obj) {
                return this.f2755a.f0((MinorWhitelistAppActivity.c) obj);
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: H2.U0
            @Override // D3.c
            public final void accept(Object obj) {
                C0702g.b("MinorWhitelistAppActivity", "操作成功");
            }
        }, S1.a.b());
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f15406e = (y) new U(this).a(y.class);
        long longExtra = intent.getLongExtra(WhitelistApp.COLUMN_MINOR_ID, -1L);
        this.f15407f = longExtra;
        if (longExtra > 0) {
            this.f15406e.m0(longExtra).g(this, new C() { // from class: H2.R0
                @Override // androidx.lifecycle.C
                public final void a(Object obj) {
                    this.f2751a.e0((List) obj);
                }
            });
        }
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0790g c0790gC = C0790g.c(getLayoutInflater());
        this.f15404c = c0790gC;
        return c0790gC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.y(view, bundle);
        final e eVar = new e(new D2.b(new w()), new d.b() { // from class: H2.Q0
            @Override // com.stepos.minor.ui.MinorWhitelistAppActivity.d.b
            public final void a(MinorWhitelistAppActivity.c cVar) {
                this.f2750a.g0(cVar);
            }
        });
        this.f15404c.f17712b.setLayoutManager(new LinearLayoutManager(this));
        this.f15404c.f17712b.X0();
        this.f15404c.f17712b.setAdapter(eVar);
        this.f15404c.f17712b.setItemAnimator(null);
        this.f15405d.g(this, new C() { // from class: com.stepos.minor.ui.a
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                eVar.k((List) obj);
            }
        });
        a0();
    }
}
