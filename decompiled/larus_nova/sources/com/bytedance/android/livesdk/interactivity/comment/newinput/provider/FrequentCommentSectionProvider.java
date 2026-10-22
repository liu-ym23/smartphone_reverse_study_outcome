package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.FrequentChatABHelper;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class FrequentCommentSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<FrequentChatController, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputSectionType f135615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrequentChatController f135617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f135618d;

    public final class FrequentChatController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j implements FrequentChatPresenter.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RecyclerView f135619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f135620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f135621e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f135622f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f135623g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final FrequentChatPresenter f135624h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final CardView f135625i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final View f135626j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final TextView f135627k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final TextView f135628l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final TextView f135629m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ FrequentCommentSectionProvider f135630n;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FrequentChatController f135631a;

            public a(FrequentChatController r100) {
                this.f135631a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f135631a.f135624h.d0();
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter.a
        public final void Cg() {
            this.f135620d.setText(com.bytedance.android.live.core.utils.s1.C(R.string.frequent_chat_num, new Object[]{String.valueOf(this.f135624h.c0()), String.valueOf(this.f135624h.f134901j)}));
            h();
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter.a
        public final void Ih() {
            this.f135624h.e0(FrequentChatShowMode.READ);
            Cg();
            UtilityKotlinExtentionsKt.w(this.f135625i);
            com.bytedance.android.live.core.utils.a1.k(this.f135619c, -2);
            UtilityKotlinExtentionsKt.w(this.f135619c);
            UtilityKotlinExtentionsKt.t(this.f135622f);
            UtilityKotlinExtentionsKt.t(this.f135629m);
            UtilityKotlinExtentionsKt.w(this.f135627k);
            UtilityKotlinExtentionsKt.w(this.f135628l);
            if (this.f135624h.c0() <= 0) goto L5;
            UtilityKotlinExtentionsKt.t(this.f135621e);
        L7:
            if (this.f135624h.c0() != 0) goto L9;
            int r100 = com.bytedance.android.live.liveinteract.f.a(R.color.ttlive_color_57_161823, FrequentCommentSectionProvider$FrequentChatController$updateBtnColor$color$1.INSTANCE);
        L10:
            this.f135627k.setTextColor(r100);
            this.f135628l.setTextColor(r100);
            if (this.f135624h.c0() <= 0) goto L13;
            this.f135627k.setOnClickListener(new b0(this));
            this.f135628l.setOnClickListener(new c0(this));
            return;
        L13:
            this.f135627k.setOnClickListener(null);
            this.f135628l.setOnClickListener(null);
            return;
        L9:
            r100 = com.bytedance.android.live.liveinteract.f.a(R.color.ttlive_color_161823, FrequentCommentSectionProvider$FrequentChatController$updateBtnColor$color$2.INSTANCE);
            goto L10
        L5:
            UtilityKotlinExtentionsKt.w(this.f135621e);
            goto L7
        }

        public final void h() {
            if (this.f135619c.computeVerticalScrollOffset() <= 0) goto L5;
            this.f135625i.setCardElevation(20.0f);
            int r100 = InteractivityOpt.b(R.color.white, FrequentCommentSectionProvider$FrequentChatController$updateHeaderElevationAndColor$color$1.INSTANCE);
            this.f135625i.setCardBackgroundColor(r100);
            return;
        L5:
            this.f135625i.setCardElevation(0.0f);
            int r101 = InteractivityOpt.b(R.color.ttlive_color_f8f8f8, FrequentCommentSectionProvider$FrequentChatController$updateHeaderElevationAndColor$color$2.INSTANCE);
            this.f135625i.setCardBackgroundColor(r101);
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatPresenter.a
        public final void iP() {
            UtilityKotlinExtentionsKt.t(this.f135619c);
            UtilityKotlinExtentionsKt.t(this.f135625i);
            UtilityKotlinExtentionsKt.t(this.f135619c);
            UtilityKotlinExtentionsKt.w(this.f135622f);
            this.f135623g.setOnClickListener(new a(this));
        }

        public static final void g(FrequentChatController r100, FrequentChatShowMode r101) {
            r100.getClass();
            if (r101 != FrequentChatShowMode.READ) goto L6;
            r100.f135624h.f0();
            return;
        L6:
            if (r101 != FrequentChatShowMode.SORT) goto L8;
            com.bytedance.android.live.core.utils.a1.k(r100.f135619c, -1);
        L8:
            UtilityKotlinExtentionsKt.t(r100.f135628l);
            UtilityKotlinExtentionsKt.t(r100.f135627k);
            UtilityKotlinExtentionsKt.w(r100.f135629m);
            r100.f135629m.setOnClickListener(new a0(r100));
            r100.f135624h.e0(r101);
        }

        public FrequentChatController(FrequentCommentSectionProvider r100, View r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridge");
            this.f135630n = r100;
            super(r101, r102);
            this.f135619c = (RecyclerView) r101.findViewById(R.id.frequent_chat_list);
            this.f135620d = (TextView) r101.findViewById(R.id.frequent_chat_num);
            this.f135621e = r101.findViewById(R.id.frequent_chat_intro);
            View r103 = r101.findViewById(R.id.frequent_chat_api_error_hint);
            this.f135622f = r103;
            this.f135623g = r103.findViewById(R.id.frequent_chat_refresh_btn);
            this.f135624h = new FrequentChatPresenter();
            this.f135625i = (CardView) r101.findViewById(R.id.frequent_chat_header_container);
            View r104 = r101.findViewById(R.id.frequent_chat_header);
            this.f135626j = r104;
            this.f135627k = (TextView) r104.findViewById(R.id.frequent_chat_list_edit_btn);
            this.f135628l = (TextView) r104.findViewById(R.id.frequent_chat_list_sort_btn);
            this.f135629m = (TextView) r104.findViewById(R.id.edit_or_sort_finish_btn);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        FrequentChatController r100 = this.f135617c;
        if (r100 == null) goto L6;
        FrequentChatPresenter r101 = r100.f135624h;
        int r102 = ((ArrayList) r101.f134894c).size();
        r101.f134893b.clear();
        ((ArrayList) r101.f134894c).clear();
        r101.f134895d.notifyItemRangeRemoved(0, r102);
        UtilityKotlinExtentionsKt.t(r100.f135625i);
        UtilityKotlinExtentionsKt.t(r100.f135619c);
        UtilityKotlinExtentionsKt.t(r100.f135621e);
        UtilityKotlinExtentionsKt.t(r100.f135622f);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        FrequentChatController r100 = this.f135617c;
        if (r100 == null) goto L6;
        FrequentChatPresenter r101 = r100.f135624h;
        int r102 = ((ArrayList) r101.f134894c).size();
        r101.f134893b.clear();
        ((ArrayList) r101.f134894c).clear();
        r101.f134895d.notifyItemRangeRemoved(0, r102);
        FrequentChatPresenter r103 = r100.f135624h;
        RecyclerView r104 = r100.f135619c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "view");
        r103.f134896e.attachToRecyclerView(null);
        r104.setAdapter(null);
        r100.f135624h.detachView();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r100 = this.f135618d;
        if (r100 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f135616b;
        if (r101 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f135616b;
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
        FrequentChatController r105 = this.f135617c;
        if (r105 == null) goto L18;
        r105.f135624h.d0();
        return;
    }

    public FrequentCommentSectionProvider() {
        this.f135615a = InputSectionType.FREQUENT_CHAT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135615a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135617c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        Context r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f135616b = r100;
        View r103 = LayoutInflater.from(r101).inflate(R.layout.ttlive_view_input_frequent_chat, null);
        this.f135618d = r103;
        final FrequentChatController r104 = new FrequentChatController(this, r103, r100);
        FrequentChatPresenter r105 = r104.f135624h;
        r105.getClass();
        r105.f531633a = r104;
        r105.f134899h = r104.f135513b;
        FrequentChatPresenter r106 = r104.f135624h;
        RecyclerView r107 = r104.f135619c;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "view");
        r106.f134896e.attachToRecyclerView(r107);
        r107.setAdapter(r106.f134895d);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r108 = r104.f135630n.f135616b;
        if (r108 == null) goto L8;
        DataCenter r109 = r108.R();
    L9:
        com.bytedance.android.livesdk.interactivity.api.h r110 = com.bytedance.android.livesdk.interactivity.api.i.b(r109, 1);
        if (r110 == null) goto L14;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g> r111 = r110.getFrequentChatInfo();
        if (r111 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g r112 = r111.getValue();
    L15:
        Lazy r113 = FrequentChatABHelper.f134924a;
        String r114 = ((ss1.d) r113.getValue()).introTitle;
        if (r114 != null) goto L18;
        r114 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_frequent_chat_intro_title);
    L18:
        String r115 = ((ss1.d) r113.getValue()).anchorAndAdminIntroText;
        if (r115 != null) goto L21;
        r115 = com.bytedance.android.live.core.utils.s1.C(R.string.ttlive_frequent_chat_intro_text, new Object[]{com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_frequent_chat_anchor_and_admin)});
    L21:
        if (r112 == null) goto L40;
        String r116 = r112.title;
        if (r116 != null) goto L25;
    L28:
        boolean r117 = true;
    L29:
        if (r117 == true) goto L31;
        r114 = r112.title;
    L31:
        String r118 = r112.text;
        if (r118 != null) goto L34;
    L37:
        boolean r119 = true;
    L38:
        if (r119 == true) goto L40;
        r115 = r112.text;
        goto L40
    L34:
        if (StringsKt.isBlank(r118) == true) goto L37;
        r119 = false;
        goto L38
    L25:
        if (StringsKt.isBlank(r116) == true) goto L28;
        r117 = false;
    L40:
        ((TextView) r104.f135621e.findViewById(R.id.title)).setText(r114);
        ((TextView) r104.f135621e.findViewById(R.id.describe_text)).setText(r115);
        RecyclerView r120 = r104.f135619c;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r121 = r104.f135630n.f135616b;
        if (r121 == null) goto L43;
        r102 = r121.getContext();
    L43:
        r120.setLayoutManager(new LinearLayoutManager(r102, 1, false));
        RecyclerView.ItemAnimator r122 = r104.f135619c.getItemAnimator();
        if (r122 == null) goto L46;
        r122.setMoveDuration(100);
        r122.setAddDuration(0);
        r122.setChangeDuration(0);
        r122.setRemoveDuration(0);
    L46:
        r104.f135619c.addItemDecoration(new SpaceItemDecoration(1, com.bytedance.android.live.core.utils.s1.f(12.0f), true));
        r104.f135619c.addOnScrollListener(new FrequentCommentSectionProvider$FrequentChatController$init$2(r104));
        Unit r123 = Unit.INSTANCE;
        this.f135617c = r104;
        return r103;
    L14:
        r112 = null;
        goto L15
    L8:
        r109 = null;
        goto L9
    }
}
