package com.bytedance.android.live.soloktv.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.ktv.common.view.CommomKtvButton;
import com.bytedance.android.live.ktv.common.view.adapter.SoloMvListAdapter;
import com.bytedance.android.live.soloktv.activity.SoloKtvTemplateActivity;
import com.bytedance.android.live.soloktv.viewmodel.SoloTemplateViewModel;
import com.bytedance.android.livesdk.message.model.KtvTypetv;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class MvControlTabWrapper extends com.bytedance.android.live.soloktv.view.a {
    public final Function3<ArrayList<String>, String, String, Unit> A;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<String> f101722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<od> f101723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<od> f101724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Integer, ? super od, Unit> f101725i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f101726j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f101727k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f101728l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView f101729m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f101730n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o f101731o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o f101732p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f101733q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f101734r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f101735s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SoloMvListAdapter f101736t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function0<Unit> f101737u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Pair<Integer, ? extends com.bytedance.android.live.ktv.common.view.adapter.a> f101738v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f101739w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewStub f101740x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<String> f101741y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f101742z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvControlTabWrapper f101743a;

        public b(MvControlTabWrapper r100) {
            this.f101743a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f101743a.h(0);
            cb1.a.T("recommend", "recommend", 1);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MvControlTabWrapper f101744a;

        public c(MvControlTabWrapper r100) {
            this.f101744a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f101744a.h(1);
            cb1.a.T("user", "user", 1);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.soloktv.view.a
    public final int b() {
        return R.layout.ttliive_solo_mv_selected_container;
    }

    @Override // com.bytedance.android.live.soloktv.view.a
    public final void c() {
        this.f101740x = (ViewStub) a().findViewById(R.id.error_view_stub);
        this.f101733q = (ViewGroup) a().findViewById(R.id.offical_mv_container);
        final RecyclerView r100 = (RecyclerView) a().findViewById(R.id.personal_mv_list);
        r100.addOnScrollListener(new MvControlTabWrapper$initView$$inlined$apply$lambda$1(r100, this));
        Unit r101 = Unit.INSTANCE;
        this.f101729m = r100;
        final RecyclerView r102 = (RecyclerView) a().findViewById(R.id.official_mv_list);
        r102.addOnScrollListener(new MvControlTabWrapper$initView$$inlined$apply$lambda$2(r102, this));
        this.f101730n = r102;
        TextView r103 = (TextView) a().findViewById(R.id.tv_official);
        this.f101734r = r103;
        r103.setOnClickListener(new b(this));
        TextView r104 = (TextView) a().findViewById(R.id.tv_personal);
        this.f101735s = r104;
        r104.setOnClickListener(new c(this));
        this.f101824e.setMvDownLoadSuccessListener(new MvControlTabWrapper$initView$7(this));
    }

    @Override // com.bytedance.android.live.soloktv.view.a
    public final void d() {
        super.d();
        if (this.f101728l != (-1)) goto L6;
        h(0);
        return;
    }

    public static final void g(MvControlTabWrapper r100) {
        if (r100.f101739w != null) goto L12;
        ViewStub r101 = r100.f101740x;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("errorViewStub");
    L7:
        View r102 = r101.inflate();
        if (r102 == null) goto L10;
        CommomKtvButton r103 = (CommomKtvButton) r102.findViewById(R.id.btn_update);
        r103.setBgColor(ColorProtector.parseColor("#393B43"));
        r103.setOnClickListener(new n(r100));
        Unit r104 = Unit.INSTANCE;
    L11:
        r100.f101739w = r102;
        goto L12
    L10:
        r102 = null;
    L12:
        View r105 = r100.f101739w;
        if (r105 == null) goto L16;
        r105.setVisibility(0);
        return;
    }

    public final void h(int r100) {
        this.f101728l = r100;
        View r101 = this.f101739w;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
    L6:
        if (this.f101728l != 0) goto L28;
        ArrayList<od> r102 = this.f101723g;
        if (r102 != null) goto L10;
    L11:
        this.f101731o.a();
    L12:
        ViewGroup r103 = this.f101733q;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("officialMvContainer");
    L15:
        r103.setVisibility(0);
        RecyclerView r104 = this.f101729m;
        if (r104 == null) goto L18;
        r104.setVisibility(8);
    L18:
        TextView r105 = this.f101734r;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTvOfficialTab");
    L21:
        if (r105 == null) goto L23;
        r105.setTextColor(-1);
    L23:
        TextView r106 = this.f101735s;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mTvPersonalTab");
    L26:
        if (r106 == null) goto L47;
        r106.setTextColor(FakePickerAvatarCreator.GRAY);
        return;
    L47:
        return;
    L10:
        if (r102.isEmpty() == false) goto L12;
    L28:
        ArrayList<od> r107 = this.f101724h;
        if (r107 != null) goto L31;
    L32:
        this.f101732p.a();
    L33:
        ViewGroup r108 = this.f101733q;
        if (r108 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("officialMvContainer");
    L36:
        r108.setVisibility(8);
        RecyclerView r109 = this.f101729m;
        if (r109 == null) goto L39;
        r109.setVisibility(0);
    L39:
        TextView r110 = this.f101735s;
        if (r110 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mTvPersonalTab");
    L42:
        r110.setTextColor(-1);
        TextView r111 = this.f101734r;
        if (r111 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mTvOfficialTab");
    L45:
        r111.setTextColor(FakePickerAvatarCreator.GRAY);
        return;
    L31:
        if (r107.isEmpty() == false) goto L33;
        goto L32
    }

    public static final void f(MvControlTabWrapper r100, od r101, int r102) {
        r100.getClass();
        if (r101.g() == false) goto L9;
        RecyclerView r103 = r100.f101730n;
        if (r103 == null) goto L15;
        RecyclerView.Adapter r104 = r103.getAdapter();
        if (r104 == null) goto L16;
        r104.notifyItemChanged(r102);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        RecyclerView r105 = r100.f101729m;
        if (r105 == null) goto L18;
        RecyclerView.Adapter r106 = r105.getAdapter();
        if (r106 == null) goto L19;
        r106.notifyItemChanged(r102);
        return;
    L19:
        return;
    }

    public static final void e(MvControlTabWrapper r100, ArrayList r101, RecyclerView r110, String r111) {
        r100.getClass();
        if (r110.getAdapter() != null) goto L5;
        SoloMvListAdapter r102 = new SoloMvListAdapter(new MvControlTabWrapper$onMvListUpdate$1(r100, r111));
        r100.f101736t = r102;
        Unit r103 = Unit.INSTANCE;
        r110.setAdapter(r102);
        r110.setLayoutManager(new LinearLayoutManager(r110.getContext(), 0, false));
    L5:
        Pair<Integer, ? extends com.bytedance.android.live.ktv.common.view.adapter.a> r104 = r100.f101738v;
        RecyclerView.Adapter r105 = null;
        if (r104 == null) goto L8;
        com.bytedance.android.live.ktv.common.view.adapter.a r106 = r104.getSecond();
    L9:
        ArrayList r107 = new ArrayList();
        if (Intrinsics.areEqual(r111, "recommend") == true) goto L12;
    L18:
        Iterator r108 = r101.iterator();
    L20:
        if (r108.hasNext() == false) goto L40;
        od r112 = (od) r108.next();
        if ((r106 instanceof com.bytedance.android.live.ktv.common.view.adapter.c) == true) goto L24;
    L26:
        boolean r109 = false;
    L28:
        if (r100.f101738v == null) goto L30;
    L32:
        boolean r113 = false;
    L34:
        if (r109 == true) goto L38;
        if (r113 == true) goto L38;
        boolean r114 = false;
    L39:
        r107.add(new com.bytedance.android.live.ktv.common.view.adapter.c(r112, r114));
    L38:
        r114 = true;
        goto L39
    L30:
        if (Intrinsics.areEqual(r112.f(), r100.f101742z) == false) goto L32;
        r113 = true;
        goto L34
    L24:
        if (Intrinsics.areEqual(((com.bytedance.android.live.ktv.common.view.adapter.c) r106).f70803a.f(), r112.f()) == false) goto L26;
        r109 = true;
        goto L28
    L40:
        RecyclerView.Adapter r115 = r110.getAdapter();
        if ((r115 instanceof SoloMvListAdapter) == false) goto L44;
        r105 = r115;
    L44:
        SoloMvListAdapter r116 = (SoloMvListAdapter) r105;
        if (r116 == null) goto L47;
        r116.f70784a = r107;
    L47:
        SoloMvListAdapter r117 = r100.f101736t;
        if (r117 == null) goto L54;
        r117.notifyDataSetChanged();
        return;
    L54:
        return;
    L12:
        if ((r106 instanceof com.bytedance.android.live.ktv.common.view.adapter.d) == true) goto L14;
    L16:
        boolean r118 = false;
    L17:
        ListProtector.add(r107, 0, new com.bytedance.android.live.ktv.common.view.adapter.d(r100.f101727k, r118));
        goto L18
    L14:
        if (r106.isSelected() == false) goto L16;
        r118 = true;
        goto L17
    L8:
        r106 = null;
        goto L9
    }

    public MvControlTabWrapper(SoloKtvTemplateActivity r100, ViewGroup r101, SoloTemplateViewModel r102, String r103, Function3 r104) {
        Intrinsics.checkNotNullParameter(r100, TTVideoEngineInterface.PLAY_API_KEY_AC);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "vm");
        Intrinsics.checkNotNullParameter(r104, "mvPrepareCallback");
        super(r100, r101, r102);
        this.f101742z = r103;
        this.A = r104;
        this.f101722f = new ArrayList();
        this.f101728l = -1;
        this.f101731o = new o(KtvTypetv.KTVMVType_OFFICIAl.ordinal(), r103, new MvControlTabWrapper$officeMvModel$1(this));
        this.f101732p = new o(KtvTypetv.KTVMVType_PERSONAL.ordinal(), null, new MvControlTabWrapper$personalMvModel$1(this));
        this.f101741y = new ArrayList();
    }
}
