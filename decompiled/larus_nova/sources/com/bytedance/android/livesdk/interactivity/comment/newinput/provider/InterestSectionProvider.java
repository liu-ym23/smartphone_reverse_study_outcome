package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.api.InterestChatApi;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
public final class InterestSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<InterestPanelController, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f135647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterestPanelController f135649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f135650d;

    public final class InterestPanelController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinearLayout f135651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RecyclerView f135652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f135653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f135654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final LinearLayout f135655g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f135656h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Disposable f135657i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f135658j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Integer f135659k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final List<Integer> f135660l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final List<Long> f135661m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f135662n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f135663o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f135664p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final GridLayoutManager f135665q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final MultiTypeAdapter f135666r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f135667s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final InterestSectionProvider$InterestPanelController$itemDecoration$1 f135668t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135669u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ InterestSectionProvider f135670v;

        public final class InterestKpViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.interactivity.comment.model.a, InterestKpViewHolder> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function1<com.bytedance.android.livesdk.interactivity.comment.model.a, Unit> f135671b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ InterestPanelController f135672c;

            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/InterestSectionProvider$InterestPanelController$InterestKpViewBinder$InterestKpViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
            public final class InterestKpViewHolder extends RecyclerView.ViewHolder {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final TextView f135673a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ InterestKpViewBinder f135674b;

                public InterestKpViewHolder(InterestKpViewBinder r100, View r101) {
                    Intrinsics.checkNotNullParameter(r101, "itemView");
                    this.f135674b = r100;
                    super(r101);
                    this.f135673a = (TextView) r101.findViewById(R.id.item_name);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public InterestKpViewBinder(InterestPanelController r100, Function1<? super com.bytedance.android.livesdk.interactivity.comment.model.a, Unit> r101) {
                Intrinsics.checkNotNullParameter(r101, "onItemSelect");
                this.f135672c = r100;
                this.f135671b = r101;
            }

            @Override // me.drakeet.multitype.b
            public final void b(RecyclerView.ViewHolder r100, com.bytedance.android.livesdk.interactivity.comment.model.a r101) {
                InterestKpViewHolder r102 = (InterestKpViewHolder) r100;
                com.bytedance.android.livesdk.interactivity.comment.model.a r103 = r101;
                Intrinsics.checkNotNullParameter(r102, "vh");
                Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
                int r104 = r102.getAdapterPosition();
                Intrinsics.checkNotNullParameter(r103, "kpMeta");
                r102.f135673a.setText(r103.b());
                r102.f135673a.setSelected(((ArrayList) r102.f135674b.f135672c.f135660l).contains(Integer.valueOf(r104)));
                if (((ArrayList) r102.f135674b.f135672c.f135661m).contains(Long.valueOf(r103.a())) == true) goto L5;
                int r105 = com.bytedance.android.livesdk.interactivity.comment.utils.i.f136260a;
                Intrinsics.checkNotNullParameter(r103, "kp");
                HashMap r106 = new HashMap();
                r106.put("module_name", "comment_expansion");
                r106.put("element_name", "interest_tag");
                r106.put("tag_id", String.valueOf(r103.a()));
                r106.put("tag_text", String.valueOf(r103.b()));
                com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_interest_card_show", r106, new Object[]{IRoom.class, new am2.x()});
                ((ArrayList) r102.f135674b.f135672c.f135661m).add(Long.valueOf(r103.a()));
            L5:
                r102.itemView.setOnClickListener(new g0(r102, r104, r103));
            }

            @Override // me.drakeet.multitype.b
            public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
                Intrinsics.checkNotNullParameter(r100, "inflater");
                Intrinsics.checkNotNullParameter(r101, "parent");
                return new InterestKpViewHolder(this, r100.inflate(R.layout.ttlive_comment_panel_interest_item, r101, false));
            }
        }

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterestPanelController f135675a;

            public a(InterestPanelController r100) {
                this.f135675a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                com.bytedance.android.livesdk.interactivity.comment.model.b r101 = (com.bytedance.android.livesdk.interactivity.comment.model.b) ((Response) r100).data;
                if (r101 == null) goto L8;
                this.f135675a.f135654f.setText(r101.b());
                List<com.bytedance.android.livesdk.interactivity.comment.model.a> r102 = r101.a();
                if (r102 == null) goto L7;
                MultiTypeAdapter r103 = this.f135675a.f135666r;
                r103.f513437a = r102;
                r103.notifyDataSetChanged();
                InterestPanelController.g(this.f135675a, false);
            L9:
                this.f135675a.f135667s = false;
                return;
            L7:
                InterestPanelController.g(this.f135675a, true);
                goto L9
            L8:
                InterestPanelController.g(this.f135675a, true);
                goto L9
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterestPanelController f135676a;

            public b(InterestPanelController r100) {
                this.f135676a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                if (r101 == null) goto L15;
                String r102 = ga2.e.a(r101);
                if (r102 == null) goto L15;
                if (r102.length() <= 0) goto L9;
                boolean r103 = true;
            L10:
                if (r103 == true) goto L13;
                r102 = null;
            L13:
                if (r102 == null) goto L15;
                com.bytedance.android.live.core.utils.f2.c(r102, 0);
                goto L15
            L9:
                r103 = false;
            L15:
                InterestPanelController.g(this.f135676a, true);
                this.f135676a.f135667s = false;
            }
        }

        public final Set<com.bytedance.android.livesdk.interactivity.comment.model.a> h() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r100 = this.f135669u.V();
            if (r100 == null) goto L7;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r101 = r100.f135419g;
            if (r101 == null) goto L7;
            return r101.f135389y;
        L7:
            return null;
        }

        public final void i() {
            if (this.f135667s == false) goto L5;
            return;
        L5:
            ((ArrayList) this.f135660l).clear();
            ((ArrayList) this.f135661m).clear();
            Disposable r100 = this.f135657i;
            if (r100 == null) goto L8;
            r100.dispose();
        L8:
            this.f135667s = true;
            InterestChatApi.f134799a.getClass();
            InterestChatApi r101 = (InterestChatApi) com.bytedance.android.live.network.c.b().e(InterestChatApi.class);
            if (r101 == null) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135670v.f135648b;
            if (r102 == null) goto L13;
            long r103 = r102.Z();
        L14:
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.b>> r104 = r101.getInterestWord(r103);
            if (r104 == null) goto L21;
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.b>> r105 = r104.subscribeOn(Schedulers.io());
            if (r105 == null) goto L21;
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.b>> r106 = r105.observeOn(AndroidSchedulers.mainThread());
            if (r106 == null) goto L21;
            Disposable r107 = r106.subscribe(new a(this), new b(this));
        L22:
            this.f135657i = r107;
            return;
        L13:
            r103 = 0;
        L21:
            r107 = null;
            goto L22
        }

        public static final void g(InterestPanelController r100, boolean r101) {
            if (r101 == false) goto L4;
            UtilityKotlinExtentionsKt.t(r100.f135651c);
            UtilityKotlinExtentionsKt.w(r100.f135655g);
            return;
        L4:
            UtilityKotlinExtentionsKt.w(r100.f135651c);
            UtilityKotlinExtentionsKt.t(r100.f135655g);
        }

        /* JADX WARN: Type inference failed for: r3v21, types: [com.bytedance.android.livesdk.interactivity.comment.newinput.provider.InterestSectionProvider$InterestPanelController$itemDecoration$1] */
        public InterestPanelController(InterestSectionProvider r100, View r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            Intrinsics.checkNotNullParameter(r102, "panelBridges");
            this.f135670v = r100;
            super(r101, r102);
            this.f135669u = r102;
            this.f135651c = (LinearLayout) this.f135512a.findViewById(R.id.content);
            this.f135652d = (RecyclerView) this.f135512a.findViewById(R.id.interest_list);
            this.f135653e = (TextView) this.f135512a.findViewById(R.id.refresh_btn);
            this.f135654f = (TextView) this.f135512a.findViewById(R.id.tips);
            this.f135655g = (LinearLayout) this.f135512a.findViewById(R.id.error_hint);
            this.f135656h = (TextView) this.f135512a.findViewById(R.id.error_button);
            this.f135658j = 3;
            this.f135659k = ec2.q.f472048a.getValue();
            this.f135660l = new ArrayList();
            this.f135661m = new ArrayList();
            this.f135662n = "、";
            this.f135663o = UtilityKotlinExtentionsKt.i(8);
            this.f135664p = UtilityKotlinExtentionsKt.i(12);
            this.f135665q = new GridLayoutManager(this.f135512a.getContext(), 3, 1, false);
            this.f135666r = new MultiTypeAdapter();
            this.f135668t = new InterestSectionProvider$InterestPanelController$itemDecoration$1(this);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        InterestPanelController r100 = this.f135649c;
        if (r100 == null) goto L9;
        Disposable r101 = r100.f135657i;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        r100.f135657i = null;
        ((ArrayList) r100.f135660l).clear();
        ((ArrayList) r100.f135661m).clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r100 = this.f135650d;
        if (r100 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f135648b;
        if (r101 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135648b;
        if (r102 == null) goto L12;
        int r103 = r102.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r100, r103);
        goto L14
    L12:
        r103 = 0;
        goto L13
    L7:
        if (r101.W() != 0) goto L9;
        int r104 = InputPanelSectionContainer.f135430m;
        r103 = InputPanelSectionContainer.f135430m;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r105 = this.f135648b;
        if (r105 == null) goto L21;
        Context r106 = r105.getContext();
        if (r106 == null) goto L21;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r107 = this.f135648b;
        if (r107 == null) goto L21;
        r107.t(r106);
    L21:
        InterestPanelController r108 = this.f135649c;
        if (r108 == null) goto L28;
        ((ArrayList) r108.f135660l).clear();
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r109 = r108.h();
        if (r109 == null) goto L26;
        r109.clear();
    L26:
        ((ArrayList) r108.f135661m).clear();
        r108.f135666r.notifyDataSetChanged();
        return;
    }

    public InterestSectionProvider() {
        this.f135647a = InputSectionType.INTEREST;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135647a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135649c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f135648b = r100;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_fragment_interest_panel, null);
        this.f135650d = r102;
        final InterestPanelController r103 = new InterestPanelController(this, r102, r100);
        r103.f135652d.setLayoutManager(r103.f135665q);
        r103.f135652d.addItemDecoration(r103.f135668t);
        r103.f135666r.z2(com.bytedance.android.livesdk.interactivity.comment.model.a.class, new InterestPanelController.InterestKpViewBinder(r103, new InterestSectionProvider$InterestPanelController$init$1(r103)));
        r103.f135652d.setAdapter(r103.f135666r);
        r103.f135653e.setOnClickListener(new h0(r103));
        r103.f135656h.setOnClickListener(new i0(r103));
        r103.i();
        Unit r104 = Unit.INSTANCE;
        this.f135649c = r103;
        return r102;
    }
}
