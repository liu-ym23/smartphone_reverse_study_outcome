package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.api.TruthQuestionApi;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
public final class TruthSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<TruthPanelController, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f135736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TruthPanelController f135738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f135739d;

    public final class TruthPanelController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinearLayout f135740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RecyclerView f135741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f135742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LinearLayout f135743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f135744g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public a f135745h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f135746i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Disposable f135747j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final LinearLayoutManager f135748k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final MultiTypeAdapter f135749l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final List<Long> f135750m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ TruthSectionProvider f135751n;

        public final class TruthQuestionViewBinder extends me.drakeet.multitype.b<a, TruthQuestionViewHolder> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function1<com.bytedance.android.livesdk.interactivity.comment.model.c, Unit> f135752b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TruthPanelController f135753c;

            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/TruthSectionProvider$TruthPanelController$TruthQuestionViewBinder$TruthQuestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
            public final class TruthQuestionViewHolder extends RecyclerView.ViewHolder {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final TextView f135754a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TruthQuestionViewBinder f135755b;

                public TruthQuestionViewHolder(TruthQuestionViewBinder r100, View r101) {
                    Intrinsics.checkNotNullParameter(r101, "itemView");
                    this.f135755b = r100;
                    super(r101);
                    this.f135754a = (TextView) r101.findViewById(R.id.question_content);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public TruthQuestionViewBinder(TruthPanelController r100, Function1<? super com.bytedance.android.livesdk.interactivity.comment.model.c, Unit> r101) {
                Intrinsics.checkNotNullParameter(r101, "onItemSelect");
                this.f135753c = r100;
                this.f135752b = r101;
            }

            @Override // me.drakeet.multitype.b
            public final void b(RecyclerView.ViewHolder r100, a r101) {
                TruthQuestionViewHolder r102 = (TruthQuestionViewHolder) r100;
                a r103 = r101;
                Intrinsics.checkNotNullParameter(r102, "vh");
                Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
                int r104 = r102.getAdapterPosition();
                Intrinsics.checkNotNullParameter(r103, "questionData");
                r102.f135754a.setText(r103.f135756a.a());
                r102.f135754a.setSelected(r103.f135757b);
                if (((ArrayList) r102.f135755b.f135753c.f135750m).contains(Long.valueOf(r103.f135756a.b())) == true) goto L8;
                int r105 = com.bytedance.android.livesdk.interactivity.comment.utils.i.f136260a;
                com.bytedance.android.livesdk.interactivity.comment.model.c r106 = r103.f135756a;
                Intrinsics.checkNotNullParameter(r106, "questionMeta");
                HashMap r107 = new HashMap();
                r107.put("module_name", "comment_expansion");
                r107.put("element_name", com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
                r107.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, String.valueOf(r106.b()));
                String r108 = r106.a();
                if (r108 != null) goto L7;
                r108 = "";
            L7:
                r107.put("question_text", r108);
                com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_truth_question_show", r107, new Object[]{IRoom.class, new am2.x()});
                ((ArrayList) r102.f135755b.f135753c.f135750m).add(Long.valueOf(r103.f135756a.b()));
            L8:
                r102.itemView.setOnClickListener(new p1(r102, r103, r104));
            }

            @Override // me.drakeet.multitype.b
            public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
                Intrinsics.checkNotNullParameter(r100, "inflater");
                Intrinsics.checkNotNullParameter(r101, "parent");
                return new TruthQuestionViewHolder(this, r100.inflate(R.layout.ttlive_comment_panel_truth_question_item, r101, false));
            }
        }

        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.bytedance.android.livesdk.interactivity.comment.model.c f135756a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f135757b;

            public a(com.bytedance.android.livesdk.interactivity.comment.model.c r100) {
                Intrinsics.checkNotNullParameter(r100, "questionData");
                this.f135756a = r100;
                this.f135757b = false;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TruthPanelController f135758a;

            public b(TruthPanelController r100) {
                this.f135758a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r110) {
                com.bytedance.android.livesdk.interactivity.comment.model.d r111 = (com.bytedance.android.livesdk.interactivity.comment.model.d) ((Response) r110).data;
                if (r111 == null) goto L36;
                List<com.bytedance.android.livesdk.interactivity.comment.model.c> r112 = r111.a();
                if (r112 == null) goto L36;
                if ((!r112.isEmpty()) == true) goto L10;
                r112 = null;
            L10:
                if (r112 == null) goto L36;
                ArrayList r100 = new ArrayList();
                Iterator<T> r113 = r112.iterator();
            L13:
                if (r113.hasNext() == false) goto L27;
                T r101 = r113.next();
                com.bytedance.android.livesdk.interactivity.comment.model.c r102 = (com.bytedance.android.livesdk.interactivity.comment.model.c) r101;
                String r103 = r102.a();
                if (r103 != null) goto L17;
            L24:
                boolean r104 = false;
            L25:
                if (r104 == false) goto L13;
                r100.add(r101);
                goto L13
            L17:
                if (r103.length() <= 0) goto L19;
                boolean r105 = true;
            L20:
                if (r105 != true) goto L24;
                if (r102.b() <= 0) goto L24;
                r104 = true;
                goto L25
            L19:
                r105 = false;
                goto L20
            L27:
                ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
                Iterator r106 = r100.iterator();
            L29:
                if (r106.hasNext() == false) goto L31;
                r114.add(new a((com.bytedance.android.livesdk.interactivity.comment.model.c) r106.next()));
                goto L29
            L31:
                MultiTypeAdapter r107 = this.f135758a.f135749l;
                int r108 = r114.size();
                List<?> r115 = r114;
                if (r108 < 6) goto L35;
                r115 = r114.subList(0, 6);
            L35:
                r107.f513437a = r115;
                this.f135758a.f135749l.notifyDataSetChanged();
                TruthPanelController.g(this.f135758a, false);
            L37:
                this.f135758a.f135746i = false;
                return;
            L36:
                TruthPanelController.g(this.f135758a, true);
                goto L37
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TruthPanelController f135759a;

            public c(TruthPanelController r100) {
                this.f135759a = r100;
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
                TruthPanelController.g(this.f135759a, true);
                this.f135759a.f135746i = false;
            }
        }

        public final void h() {
            if (this.f135746i == false) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r100 = this.f135513b.V();
            Disposable r101 = null;
            if (r100 == null) goto L10;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r102 = r100.f135419g;
            if (r102 == null) goto L10;
            r102.f135390z = null;
        L10:
            this.f135745h = null;
            ((ArrayList) this.f135750m).clear();
            Disposable r103 = this.f135747j;
            if (r103 == null) goto L13;
            r103.dispose();
        L13:
            this.f135746i = true;
            TruthQuestionApi.f134801a.getClass();
            TruthQuestionApi r104 = (TruthQuestionApi) com.bytedance.android.live.network.c.b().e(TruthQuestionApi.class);
            if (r104 == null) goto L26;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r105 = this.f135751n.f135737b;
            if (r105 == null) goto L18;
            long r106 = r105.Z();
        L19:
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.d>> r107 = r104.getTruthQuestionList(r106);
            if (r107 == null) goto L26;
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.d>> r108 = r107.subscribeOn(Schedulers.io());
            if (r108 == null) goto L26;
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.d>> r109 = r108.observeOn(AndroidSchedulers.mainThread());
            if (r109 == null) goto L26;
            r101 = r109.subscribe(new b(this), new c(this));
            goto L26
        L18:
            r106 = 0;
        L26:
            this.f135747j = r101;
        }

        public static final void g(TruthPanelController r100, boolean r101) {
            if (r101 == false) goto L4;
            UtilityKotlinExtentionsKt.t(r100.f135740c);
            UtilityKotlinExtentionsKt.w(r100.f135743f);
            return;
        L4:
            UtilityKotlinExtentionsKt.w(r100.f135740c);
            UtilityKotlinExtentionsKt.t(r100.f135743f);
        }

        public TruthPanelController(TruthSectionProvider r100, View r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridges");
            this.f135751n = r100;
            super(r101, r102);
            this.f135740c = (LinearLayout) r101.findViewById(R.id.content);
            this.f135741d = (RecyclerView) r101.findViewById(R.id.truth_word_list);
            this.f135742e = (TextView) r101.findViewById(R.id.refresh_btn);
            TextView r103 = (TextView) r101.findViewById(R.id.tips);
            this.f135743f = (LinearLayout) r101.findViewById(R.id.error_hint);
            this.f135744g = (TextView) r101.findViewById(R.id.error_button);
            this.f135748k = new LinearLayoutManager(r101.getContext());
            this.f135749l = new MultiTypeAdapter();
            this.f135750m = new ArrayList();
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
        TruthPanelController r100 = this.f135738c;
        if (r100 == null) goto L13;
        Disposable r101 = r100.f135747j;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        r100.f135747j = null;
        r100.f135745h = null;
        ((ArrayList) r100.f135750m).clear();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r102 = r100.f135513b.V();
        if (r102 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r103 = r102.f135419g;
        if (r103 == null) goto L15;
        r103.f135390z = null;
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r100 = this.f135739d;
        if (r100 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f135737b;
        if (r101 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135737b;
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
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r105 = this.f135737b;
        if (r105 == null) goto L19;
        EditText r106 = r105.f135496a;
        if (r106 == null) goto L19;
        r106.setText("");
    L19:
        TruthPanelController r107 = this.f135738c;
        if (r107 == null) goto L30;
        TruthPanelController.a r108 = r107.f135745h;
        if (r108 == null) goto L24;
        r108.f135757b = false;
    L24:
        r107.f135745h = null;
        r107.f135749l.notifyDataSetChanged();
        ((ArrayList) r107.f135750m).clear();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r109 = r107.f135513b.V();
        if (r109 == null) goto L31;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r110 = r109.f135419g;
        if (r110 == null) goto L32;
        r110.f135390z = null;
        return;
    L32:
        return;
    L31:
        return;
    }

    public TruthSectionProvider() {
        this.f135736a = InputSectionType.TRUTH;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135736a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135738c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f135737b = r100;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_fragment_truth_panel, null);
        this.f135739d = r102;
        final TruthPanelController r103 = new TruthPanelController(this, r102, r100);
        r103.f135741d.setLayoutManager(r103.f135748k);
        r103.f135749l.z2(TruthPanelController.a.class, new TruthPanelController.TruthQuestionViewBinder(r103, new TruthSectionProvider$TruthPanelController$init$1(r103)));
        r103.f135741d.setAdapter(r103.f135749l);
        r103.f135742e.setOnClickListener(new q1(r103));
        r103.f135744g.setOnClickListener(new r1(r103));
        r103.h();
        Unit r104 = Unit.INSTANCE;
        this.f135738c = r103;
        return r102;
    }
}
