package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.comment.wordassociate.WordAssociationApi;
import com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui.LinearDividerDecoration;
import com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.utils.WordAssociationAppLogger;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.larus.nova.R;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
public final class t1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.j> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f135972d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f135973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f135974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f135975c;

    public static final class a implements z62.j {
        public a() {
        }

        @Override // z62.j
        public final int n() {
            return 0;
        }

        @Override // z62.j
        public final long v() {
            return 0;
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f135976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f135977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f135978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f135979f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final FrameLayout f135980g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RecyclerView f135981h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final MultiTypeAdapter f135982i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public x62.c f135983j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Disposable f135984k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f135985l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final List<Integer> f135986m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public q4.b f135987n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public q4.b f135988o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Function0<Boolean> f135989p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f135990q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f135991r;

        public final void h() {
            if (this.f135980g.getVisibility() != 0) goto L9;
            q4.b r100 = this.f135988o;
            if (r100 == null) goto L7;
            r100.a();
        L7:
            q4.b r101 = u4.c(new WordAssociateSectionProvider$WordAssociateController$dismissWithAnimate$1(this));
            r101.c();
            this.f135988o = r101;
            return;
        }

        public final void i(List<? extends c32.d> r110) {
            List<? extends c32.d> r100 = r110;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return;
        L11:
            List<? extends c32.d> r102 = r110;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L13:
            if (r104.hasNext() == false) goto L15;
            r103.add(((c32.d) r104.next()).a());
            goto L13
        L15:
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r106 = r102.iterator();
        L17:
            if (r106.hasNext() == false) goto L26;
            Spannable r107 = ((c32.d) r106.next()).f22267a;
            if (r107 == null) goto L24;
            String r108 = r107.toString();
            if (r108 == null) goto L24;
            String r109 = StringsKt.trim(r108).toString();
            if (r109 == null) goto L24;
        L25:
            r105.add(r109);
        L24:
            r109 = "";
            goto L25
        L26:
            WordAssociationAppLogger.e(r110, r103, r105, ((c32.d) CollectionsKt.first(r110)).f22268b, ((c32.d) CollectionsKt.first(r110)).f22269c, this.f135513b.f135497b, ((c32.d) CollectionsKt.first(r110)).f22270d);
            return;
        L5:
            if (r100.isEmpty() == true) goto L8;
            r101 = false;
            goto L9
        }

        public c(View r100, final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r101, "bridges");
            super(r100, r101);
            this.f135976c = UtilityKotlinExtentionsKt.h(45);
            this.f135978e = ec2.k0.f472031a.getValue();
            IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
            long r103 = 0;
            if (r102 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.o r104 = IRoomContextService.a.a(r102, r101.R(), 0, 2);
            if (r104 == null) goto L11;
            com.bytedance.live.datacontext.m<IRoom> r105 = r104.getRoom();
            if (r105 == null) goto L11;
            IRoom r106 = r105.getValue();
            if (r106 == null) goto L11;
            r103 = r106.getId();
        L11:
            this.f135979f = r103;
            this.f135980g = (FrameLayout) r100.findViewById(R.id.word_association_container);
            this.f135981h = (RecyclerView) r100.findViewById(R.id.word_association_list);
            this.f135982i = new MultiTypeAdapter();
            this.f135986m = (List) ec2.o1.f472044a.getValue();
            this.f135989p = new WordAssociateSectionProvider$WordAssociateController$predicate$1(r101);
            this.f135991r = true;
        }

        public static final Observable g(c r100, String r101, long r102) {
            if (r100.f135989p.invoke().booleanValue() == false) goto L7;
            boolean r103 = true;
            if ((!StringsKt.isBlank(r101)) == false) goto L7;
        L8:
            if (r103 == true) goto L10;
            MainThreadPostUtils.b(new u1(r100));
            return Observable.empty();
        L10:
            c32.b r104 = new c32.b();
            r104.roomId = r100.f135979f;
            Charset r105 = Charsets.UTF_8;
            if (r101 == null) goto L18;
            r104.contentEncode = Base64.encodeToString(r101.getBytes(r105), 2);
            String r106 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new c32.a()).second;
            if (r106 != null) goto L15;
            r106 = "";
        L15:
            WordAssociationApi r107 = (WordAssociationApi) com.bytedance.android.live.network.c.b().e(WordAssociationApi.class);
            HashMap r108 = new HashMap();
            r108.put("room_id", String.valueOf(r104.roomId));
            r108.put("content_encode", r104.contentEncode);
            return r107.association(r108, r106).map(new v1(r102)).doOnError(new x1(r100)).onErrorResumeNext(Observable.empty());
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L7:
            r103 = false;
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void j(List<? extends c32.d> r110, long r111, boolean r112, String r113) {
            List<?> r100 = this.f135982i.f513437a;
            if ((r100 instanceof List) == true) goto L5;
            r100 = null;
        L5:
            List<?> r101 = r100;
            boolean r114 = false;
            if (r101 != null) goto L8;
        L11:
            boolean r102 = true;
        L12:
            if (r102 == true) goto L14;
            i(r100);
        L14:
            Items r103 = new Items();
            r103.addAll(r110);
            MultiTypeAdapter r104 = this.f135982i;
            r104.f513437a = r103;
            r104.notifyDataSetChanged();
            List<? extends c32.d> r115 = r110;
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator<T> r106 = r115.iterator();
        L16:
            if (r106.hasNext() == false) goto L18;
            r105.add(((c32.d) r106.next()).a());
            goto L16
        L18:
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator<T> r108 = r115.iterator();
        L20:
            if (r108.hasNext() == false) goto L29;
            Spannable r109 = ((c32.d) r108.next()).f22267a;
            if (r109 == null) goto L27;
            String r116 = r109.toString();
            if (r116 == null) goto L27;
            String r117 = StringsKt.trim(r116).toString();
            if (r117 == null) goto L27;
        L28:
            r107.add(r117);
        L27:
            r117 = "";
            goto L28
        L29:
            long r118 = 0;
            if (r111 <= 0) goto L32;
            r118 = System.currentTimeMillis() - r111;
        L32:
            WordAssociationAppLogger.f(r110, r105, r107, r118, r112, r113, this.f135513b.f135497b);
            if ((r115 instanceof Collection) == true) goto L35;
        L37:
            Iterator<T> r119 = r115.iterator();
        L39:
            if (r119.hasNext() == false) goto L43;
            if (Intrinsics.areEqual(((c32.d) r119.next()).a(), "member_emoji") == false) goto L39;
            r114 = true;
        L43:
            if (r114 == false) goto L45;
            int r120 = WordAssociationAppLogger.f135226a;
            com.bytedance.android.livesdk.interactivity.common.utils.b.b();
        L45:
            Iterator<? extends c32.d> r121 = r110.iterator();
        L47:
            if (r121.hasNext() == false) goto L50;
            c32.d r122 = r121.next();
            r122.f22270d = System.currentTimeMillis();
            r122.f22271e = true;
            goto L47
        L50:
            if (this.f135980g.getVisibility() == 0) goto L64;
            q4.b r123 = this.f135987n;
            if (r123 == null) goto L54;
            r123.a();
        L54:
            q4.b r124 = u4.c(new WordAssociateSectionProvider$WordAssociateController$showWithAnimate$1(this));
            r124.c();
            this.f135987n = r124;
            return;
        L64:
            return;
        L35:
            if (r115.isEmpty() == false) goto L37;
        L8:
            if (r101.isEmpty() == true) goto L11;
            r102 = false;
            goto L12
        }
    }

    public static final class d implements z62.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1 f135992a;

        @Override // z62.j
        public final int n() {
            c r100 = this.f135992a.f135974b;
            if (r100 != null) goto L5;
            return 0;
        L5:
            if (r100.f135980g.getVisibility() == 0) goto L7;
            return 0;
        L7:
            return (int) r100.f135977d;
        }

        @Override // z62.j
        public final long v() {
            c r100 = this.f135992a.f135974b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.f135990q;
        }

        public d(t1 r100) {
            this.f135992a = r100;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    static {
        f135972d = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        c r100 = this.f135974b;
        if (r100 == 0) goto L18;
        List<?> r101 = r100.f135982i.f513437a;
        if ((r101 instanceof List) == true) goto L7;
        r101 = null;
    L7:
        if (r101 != null) goto L9;
    L13:
        Disposable r102 = r100.f135984k;
        if (r102 == null) goto L16;
        r102.dispose();
    L16:
        r100.f135984k = null;
        return;
    L9:
        if (r101.isEmpty() == true) goto L13;
        if (((c32.d) CollectionsKt.first(r101)).f22271e == false) goto L13;
        r100.i(r101);
        goto L13
    }

    public t1() {
        this.f135973a = InputSectionType.WORD_ASSOCIATE;
        this.f135975c = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135973a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135974b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r110) {
        Intrinsics.checkNotNullParameter(r110, "panelBridge");
        Activity r100 = r110.getActivity();
        if (r100 != null) goto L5;
        return null;
    L5:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_view_input_word_association, null);
        if (r101 != null) goto L8;
        return null;
    L8:
        c r102 = new c(r101, r110);
        Context r111 = r102.f135513b.getContext();
        if (r111 == null) goto L40;
        EditText r103 = r102.f135513b.f135496a;
        if (r103 == null) goto L40;
        r102.f135983j = new x62.c(r103);
        boolean r104 = false;
        r102.f135981h.setLayoutManager(new LinearLayoutManager(r111, 0, false));
        r102.f135981h.setPadding(UtilityKotlinExtentionsKt.i(5), 0, 0, 0);
        r102.f135981h.setClipToPadding(false);
        r102.f135981h.addItemDecoration(new LinearDividerDecoration(r111.getResources(), UtilityKotlinExtentionsKt.i(7)));
        MultiTypeAdapter r112 = r102.f135982i;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r105 = r102.f135513b;
        r112.z2(c32.d.class, new com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui.b(r105, r105.f135497b));
        r102.f135981h.setAdapter(r102.f135982i);
        IRoomContextService r113 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r113 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.o r114 = IRoomContextService.a.a(r113, r102.f135513b.R(), 0, 2);
        if (r114 == null) goto L40;
        com.bytedance.live.datacontext.m<IRoom> r115 = r114.getRoom();
        if (r115 == null) goto L40;
        IRoom r116 = r115.getValue();
        if (r116 == null) goto L40;
        IRoomAuthStatus r117 = r116.getRoomAuthStatus();
        if (r117 == null) goto L40;
        com.bytedance.android.livesdk.interactivity.service.model.c r118 = (com.bytedance.android.livesdk.interactivity.service.model.c) r117.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r118 == null) goto L40;
        if (r118.getWordAssociation() != 0) goto L29;
    L30:
        r104 = true;
    L31:
        if (r104 != true) goto L40;
        r102.f135513b.k(new y1(r102));
        r102.f135513b.p(new z1(r102));
        Disposable r119 = r102.f135984k;
        if (r119 == null) goto L36;
        r119.dispose();
    L36:
        x62.c r120 = r102.f135983j;
        if (r120 == null) goto L40;
        r102.f135984k = r120.map(new a2(r102)).distinctUntilChanged(new b2(r102)).debounce(r102.f135978e.longValue(), TimeUnit.MILLISECONDS).switchMap(new d2(r102)).map(e2.f135874a).compose(RxUtil.rxSchedulerHelper()).subscribe(new f2(r102), new h2(r102));
        goto L40
    L29:
        if (r118.getWordAssociation() != 1) goto L31;
    L40:
        Unit r121 = Unit.INSTANCE;
        this.f135974b = r102;
        return r101;
    }
}
