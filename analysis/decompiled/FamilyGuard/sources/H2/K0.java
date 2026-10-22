package H2;

import H2.K0;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ActivityC0516k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.BaseFragment;
import com.stepos.minor.Minor;
import com.stepos.minor.ui.MinorEditActivity;
import com.stepos.minor.ui.MinorMainActivity;
import f2.C0702g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import z3.C1347a;

/* loaded from: classes.dex */
public class K0 extends BaseFragment {

    /* renamed from: f0, reason: collision with root package name */
    private F2.y f2725f0;

    /* renamed from: g0, reason: collision with root package name */
    private j2.q f2726g0;

    /* renamed from: h0, reason: collision with root package name */
    private a f2727h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f2728i0 = 1;

    /* renamed from: j0, reason: collision with root package name */
    private stepos.support.v7.app.c f2729j0;

    /* renamed from: k0, reason: collision with root package name */
    private stepos.support.v7.app.c f2730k0;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends x2.c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2731a;

        /* renamed from: b, reason: collision with root package name */
        private final f f2732b;

        /* renamed from: c, reason: collision with root package name */
        private final e f2733c;

        /* renamed from: d, reason: collision with root package name */
        private final d f2734d;

        /* renamed from: e, reason: collision with root package name */
        private List<Minor> f2735e;

        /* renamed from: H2.K0$a$a, reason: collision with other inner class name */
        protected static class C0035a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            j2.k f2736a;

            public C0035a(View view) {
                super(view);
                this.f2736a = j2.k.a(view);
            }
        }

        protected static class b extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            j2.x f2737a;

            public b(View view) {
                super(view);
                this.f2737a = j2.x.a(view);
            }
        }

        protected static class c extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            j2.r f2738a;

            public c(View view) {
                super(view);
                this.f2738a = j2.r.a(view);
            }

            public static /* synthetic */ void a(e eVar, Minor minor, View view) {
                if (eVar != null) {
                    eVar.a(minor);
                }
            }

            public static /* synthetic */ void b(f fVar, Minor minor, View view) {
                if (fVar != null) {
                    fVar.a(minor);
                }
            }

            void c(final Minor minor, boolean z5, final f fVar, final e eVar) {
                if (minor == null) {
                    return;
                }
                if (minor.getIcon() == null) {
                    this.f2738a.f17783c.setImageResource(R.drawable.stepos_avastar_person_00);
                } else {
                    this.f2738a.f17783c.setImageBitmap(C2.h.i(minor.getIcon()));
                }
                this.f2738a.f17784d.setText(minor.getName());
                this.f2738a.f17784d.setVisibility(0);
                j2.r rVar = this.f2738a;
                rVar.f17785e.setText(minor.getAgeDesc(rVar.b().getContext()));
                this.f2738a.f17785e.setVisibility(0);
                this.f2738a.f17786f.setVisibility(8);
                if (z5) {
                    this.f2738a.f17782b.setImageResource(R.drawable.stepos_btn_list_attachment_delete);
                    this.f2738a.f17782b.setEnabled(!minor.isActivated());
                    this.f2738a.f17782b.setOnClickListener(new View.OnClickListener() { // from class: H2.L0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            K0.a.c.a(eVar, minor, view);
                        }
                    });
                } else {
                    this.f2738a.f17782b.setImageResource(R.drawable.stepos_btn_check_buttonless_on_normal_color_blue);
                    this.f2738a.b().setOnClickListener(new View.OnClickListener() { // from class: H2.M0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            K0.a.c.b(fVar, minor, view);
                        }
                    });
                }
                this.f2738a.f17782b.setVisibility(0);
                if (z5 || minor.isSelected() || minor.isActivated()) {
                    return;
                }
                this.f2738a.f17782b.setVisibility(4);
            }
        }

        public interface d {
            void a();
        }

        public interface e {
            void a(Minor minor);
        }

        public interface f {
            void a(Minor minor);
        }

        public a(boolean z5, f fVar, e eVar, d dVar) {
            this.f2731a = z5;
            this.f2732b = fVar;
            this.f2733c = eVar;
            this.f2734d = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(View view) {
            if (q()) {
                p();
            } else {
                n();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(View view) {
            d dVar = this.f2734d;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Minor> list = this.f2735e;
            if (list == null) {
                return 2;
            }
            int size = list.size();
            int i5 = size + 1;
            return size < 3 ? i5 + (!q() ? 1 : 0) : i5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i5) {
            List<Minor> list = this.f2735e;
            int size = list == null ? 0 : list.size();
            if (i5 == 0) {
                return 0;
            }
            return i5 <= size ? 1 : 2;
        }

        @Override // stepos.support.v7.widget.StepOSRecyclerView.c
        public int immersiveItemType(int i5) {
            int itemCount = getItemCount();
            if (i5 == 0) {
                return 4;
            }
            return i5 == 1 ? itemCount == 2 ? 3 : 0 : i5 == itemCount - 1 ? 2 : 1;
        }

        public void n() {
            this.f2731a = true;
            notifyDataSetChanged();
        }

        @Override // x2.c, stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
            super.onBindViewHolder(viewHolder, i5);
            int itemViewType = getItemViewType(i5);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((c) viewHolder).c(this.f2735e.get(i5 - 1), q(), this.f2732b, this.f2733c);
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    ((C0035a) viewHolder).f2736a.b().setOnClickListener(new View.OnClickListener() { // from class: H2.J0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f2723a.t(view);
                        }
                    });
                    return;
                }
            }
            b bVar = (b) viewHolder;
            bVar.f2737a.f17800c.setText(R.string.mm_desc_minor);
            bVar.f2737a.f17799b.setText(q() ? R.string.mm_complete : R.string.mm_edit);
            List<Minor> list = this.f2735e;
            if (list == null || (list.isEmpty() && !q())) {
                bVar.f2737a.f17799b.setEnabled(false);
            } else {
                bVar.f2737a.f17799b.setEnabled(true);
                bVar.f2737a.f17799b.setOnClickListener(new View.OnClickListener() { // from class: H2.I0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2721a.s(view);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
            return i5 != 0 ? i5 != 1 ? new C0035a(layoutInflaterFrom.inflate(R.layout.add_minor_item, viewGroup, false)) : new c(layoutInflaterFrom.inflate(R.layout.minor_item, viewGroup, false)) : new b(layoutInflaterFrom.inflate(R.layout.us_category_item, viewGroup, false));
        }

        public void p() {
            this.f2731a = false;
            notifyDataSetChanged();
        }

        public boolean q() {
            return this.f2731a;
        }

        public void v(List<Minor> list) {
            this.f2735e = list;
            notifyDataSetChanged();
        }
    }

    private String h2() {
        boolean z5;
        String strW = W(R.string.mm_minor_name_default);
        int i5 = 0;
        do {
            if (i5 > 0) {
                strW = X(R.string.mm_minor_name, Integer.valueOf(i5));
            }
            List<Minor> listE = this.f2725f0.i0().e();
            if (listE == null || listE.isEmpty()) {
                break;
            }
            Iterator<Minor> it = listE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z5 = false;
                    break;
                }
                if (TextUtils.equals(it.next().getName(), strW)) {
                    z5 = true;
                    break;
                }
            }
            i5++;
        } while (z5);
        return strW;
    }

    private boolean i2(List<Minor> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (Minor minor : list) {
            if (minor != null && minor.isSelected()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(Minor minor) {
        C0702g.b("MinorSelectFragment", "item select minor = " + minor);
        this.f2725f0.D0(minor.getId());
        if (this.f2728i0 == 1) {
            C0702g.b("MinorSelectFragment", "item select finish");
            y1().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(Minor minor) {
        t2(A1(), minor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2() {
        MinorEditActivity.K(y1(), h2(), this.f2728i0 == 1 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(View view) {
        if (p2.g.v(A1())) {
            v2();
        } else {
            u2(A1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(Minor minor, DialogInterface dialogInterface, int i5) {
        this.f2725f0.c0(minor.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(Minor minor, DialogInterface dialogInterface, int i5) {
        this.f2725f0.c0(minor.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p2(DialogInterface dialogInterface, int i5) {
        p2.g.s(q(), "android.permission.QUERY_ALL_PACKAGES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer q2() {
        return Integer.valueOf(this.f2725f0.F0(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(Integer num) {
        ActivityC0516k activityC0516kY1 = y1();
        if (activityC0516kY1 instanceof MinorMainActivity) {
            ((MinorMainActivity) activityC0516kY1).j0().j(4);
        }
    }

    private void t2(Context context, final Minor minor) {
        stepos.support.v7.app.c cVar = this.f2729j0;
        if (cVar == null) {
            this.f2729j0 = new C2.b(context).y(W(R.string.fg_common_delete) + minor.getName()).m(R.string.mm_desc_del_minor).u(R.string.fg_common_delete, new DialogInterface.OnClickListener() { // from class: H2.H0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    this.f2718a.n2(minor, dialogInterface, i5);
                }
            }).o(R.string.fg_common_cancel, new DialogInterface.OnClickListener() { // from class: H2.x0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    dialogInterface.dismiss();
                }
            }).i(-1, 2).c();
        } else {
            cVar.setTitle(W(R.string.fg_common_delete) + minor.getName());
            this.f2729j0.setMessage(context.getString(R.string.mm_desc_del_minor));
            this.f2729j0.setButton(-1, context.getString(R.string.fg_common_delete), new DialogInterface.OnClickListener() { // from class: H2.y0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    this.f2826a.o2(minor, dialogInterface, i5);
                }
            });
        }
        this.f2729j0.show();
    }

    private void u2(Context context) {
        Log.d("MinorSelectFragment", "APP_LIST_DIALOG_FROM_MINOR_SELECT");
        if (this.f2730k0 == null) {
            this.f2730k0 = new C2.b(context).x(R.string.us_request_app_list_permission_title).m(R.string.mm_minors_mode_need_this_permission).u(R.string.fg_to_open, new DialogInterface.OnClickListener() { // from class: H2.D0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    this.f2711a.p2(dialogInterface, i5);
                }
            }).o(R.string.fg_relation_manager_logout, new DialogInterface.OnClickListener() { // from class: H2.E0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    dialogInterface.dismiss();
                }
            }).g(false).c();
        }
        this.f2730k0.show();
    }

    private void v2() {
        x3.f.x(new Callable() { // from class: H2.F0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2714a.q2();
            }
        }).X(T3.a.c()).G(C1347a.a()).T(new D3.c() { // from class: H2.G0
            @Override // D3.c
            public final void accept(Object obj) {
                this.f2716a.r2((Integer) obj);
            }
        }, S1.a.b());
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super.U0(view, bundle);
        this.f2727h0 = new a(false, new a.f() { // from class: H2.w0
            @Override // H2.K0.a.f
            public final void a(Minor minor) {
                this.f2823a.j2(minor);
            }
        }, new a.e() { // from class: H2.z0
            @Override // H2.K0.a.e
            public final void a(Minor minor) {
                this.f2853a.k2(minor);
            }
        }, new a.d() { // from class: H2.A0
            @Override // H2.K0.a.d
            public final void a() {
                this.f2703a.l2();
            }
        });
        this.f2726g0.f17778c.setLayoutManager(new LinearLayoutManager(A1()));
        this.f2726g0.f17778c.X0();
        this.f2726g0.f17778c.setOverScrollEnable(false);
        this.f2726g0.f17778c.setAdapter(this.f2727h0);
        this.f2725f0.i0().g(y1(), new androidx.lifecycle.C() { // from class: H2.B0
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2707a.s2((List) obj);
            }
        });
        if (this.f2728i0 != 2) {
            this.f2726g0.f17780e.setVisibility(8);
            this.f2726g0.f17777b.setVisibility(8);
            return;
        }
        this.f2726g0.f17780e.setVisibility(0);
        this.f2726g0.f17777b.setVisibility(0);
        this.f2726g0.f17777b.setOnClickListener(new View.OnClickListener() { // from class: H2.C0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2709a.m2(view2);
            }
        });
        if (y1() instanceof MinorMainActivity) {
            ((MinorMainActivity) y1()).A0();
        }
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment
    protected void U1(stepos.support.v7.app.a aVar) {
        super.U1(aVar);
    }

    public void s2(List<Minor> list) {
        C0702g.b("MinorSelectFragment", "onMinorsChanged() called with: minors = " + C0702g.k(list));
        this.f2727h0.v(list);
        this.f2726g0.f17777b.setEnabled(i2(list));
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.f2725f0 = (F2.y) new androidx.lifecycle.U(y1()).a(F2.y.class);
        Bundle bundleU = u();
        if (bundleU != null) {
            this.f2728i0 = bundleU.getInt("select", 1);
        }
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2726g0 = j2.q.c(layoutInflater, viewGroup, false);
        if (TextUtils.equals("CN", Q().getConfiguration().locale.getCountry())) {
            T1.g.e(1.18f, this.f2726g0.b());
        } else {
            T1.g.e(1.06f, this.f2726g0.b());
        }
        return this.f2726g0.b();
    }
}
