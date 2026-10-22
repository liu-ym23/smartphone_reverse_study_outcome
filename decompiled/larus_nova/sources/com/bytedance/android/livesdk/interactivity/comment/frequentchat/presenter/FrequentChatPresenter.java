package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.api.FrequentChatApi;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatSubPanelSource;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.m;
import com.bytedance.android.livesdk.interactivity.comment.newinput.LivePortraitInputDialogV3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class FrequentChatPresenter extends q46.b<a> implements FrequentChatListAdapter.b, FrequentChatSecondaryFragment.b, t62.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f134893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> f134894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrequentChatListAdapter f134895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemTouchHelper f134896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c f134897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrequentChatShowMode f134898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f134899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f134900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f134901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f134902k;

    public interface a extends q46.a {
        void Cg();

        void Ih();

        void iP();
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatPresenter f134903a;

        public b(FrequentChatPresenter r100) {
            this.f134903a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            if (r101.statusCode != 0) goto L31;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d r102 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d) r101.data;
            List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.b> r103 = r102.a();
            if (r103 == null) goto L28;
            int r104 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.f134928a;
            Intrinsics.checkNotNullParameter(r103, "chatDataList");
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r103.iterator();
        L8:
            if (r106.hasNext() == false) goto L17;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.b r107 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.b) r106.next();
            if (r107.a() == 0) goto L8;
            if (TextUtils.isEmpty(r107.b()) == true) goto L8;
            String r108 = r107.b();
            if (r108 != null) goto L16;
            r108 = "";
        L16:
            r105.add(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(r108, r107.a(), 1));
            goto L8
        L17:
            ((ArrayList) this.f134903a.f134894c).clear();
            ((ArrayList) this.f134903a.f134894c).addAll(r105);
            FrequentChatPresenter r109 = this.f134903a;
            if (r109.f134898g != FrequentChatShowMode.READ) goto L20;
            ((ArrayList) r109.f134894c).add(r109.f134897f);
        L20:
            this.f134903a.f134895d.notifyDataSetChanged();
            this.f134903a.f134901j = RangesKt.coerceAtLeast(r102.b(), r105.size());
            a r110 = (a) this.f134903a.f531633a;
            if (r110 == null) goto L23;
            r110.Ih();
        L23:
            int r111 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r112 = this.f134903a.f134899h;
            if (r112 == null) goto L26;
            Boolean r113 = Boolean.valueOf(r112.k0());
        L27:
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_panel_show", r113, MapsKt.mapOf(TuplesKt.to("common_comment_num", String.valueOf(this.f134903a.c0()))));
            return;
        L26:
            r113 = null;
            goto L27
        L28:
            a r114 = (a) this.f134903a.f531633a;
            if (r114 == null) goto L41;
            r114.iP();
            return;
        L41:
            return;
        L31:
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.b("query", r101);
            ((a) this.f134903a.f531633a).iP();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatPresenter f134904a;

        public c(FrequentChatPresenter r100) {
            this.f134904a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a((Throwable) r100, "query", "");
            ((a) this.f134904a.f531633a).iP();
        }
    }

    public final void d0() {
        this.f134902k = false;
        FrequentChatApi.f134874a.getClass();
        FrequentChatApi r100 = FrequentChatApi.a.a();
        if (r100 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f134899h;
        if (r101 == null) goto L7;
        long r102 = r101.Z();
    L8:
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.d>> r103 = r100.queryFrequentChatList(r102);
        if (r103 == null) goto L17;
        Observable<R> r104 = r103.compose(RxUtil.rxSchedulerHelper());
        if (r104 == 0) goto L18;
        Disposable r105 = r104.subscribe(new b(this), new c(this));
        if (r105 == null) goto L19;
        RxUtilKt.c(r105, this.f134893b);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f134899h = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void R() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100 = this.f134899h;
        if (r100 != null) goto L5;
        return;
    L5:
        FrequentChatSecondaryFragment r101 = new FrequentChatSecondaryFragment(r100, this, FrequentChatSubPanelSource.ADD, -1, "");
        r100.o0(InputDialogFragmentSwitchType.NONE, r101);
        int r102 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_add", Boolean.valueOf(r100.k0()), null);
    }

    public final int c0() {
        FrequentChatShowMode r100 = this.f134898g;
        int r101 = f.f134916b[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    L14:
        return ((ArrayList) this.f134894c).size();
    L13:
        return ((ArrayList) this.f134894c).size() - 1;
    }

    public final void f0() {
        FrequentChatShowMode r100 = this.f134898g;
        int r101 = f.f134915a[r100.ordinal()];
        if (r101 != 1) goto L5;
        a r102 = (a) this.f531633a;
        if (r102 == null) goto L32;
        r102.Ih();
        return;
    L32:
        return;
    L5:
        if (r101 == 2) goto L8;
        return;
    L8:
        if (this.f134902k == true) goto L34;
        String r103 = CollectionsKt.joinToString$default(this.f134894c, ",", null, null, 0, null, FrequentChatPresenter$trySaveSortResult$sortedSeq$1.INSTANCE, 30, null);
        FrequentChatApi.f134874a.getClass();
        FrequentChatApi r104 = FrequentChatApi.a.a();
        if (r104 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r105 = this.f134899h;
        if (r105 == null) goto L15;
        long r106 = r105.Z();
    L16:
        Observable<Response<Object>> r107 = r104.sortFrequentChatList(r106, r103);
        if (r107 == null) goto L28;
        Observable<R> r108 = r107.compose(RxUtil.rxSchedulerHelper());
        if (r108 == 0) goto L29;
        Disposable r109 = r108.subscribe(new i(this, r103), new j(this));
        if (r109 == null) goto L30;
        RxUtilKt.c(r109, this.f134893b);
        this.f134902k = true;
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L15:
        r106 = 0;
        goto L16
    L27:
        return;
    }

    public FrequentChatPresenter() {
        this.f134893b = new CompositeDisposable();
        ArrayList r100 = new ArrayList();
        this.f134894c = r100;
        this.f134895d = new FrequentChatListAdapter(r100, this);
        this.f134896e = new ItemTouchHelper(new FrequentChatDragCallback(this));
        this.f134897f = new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c("", -1, 2);
        this.f134898g = FrequentChatShowMode.READ;
        this.f134900i = "";
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final boolean j() {
        if (c0() < this.f134901j) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final FrequentChatShowMode L() {
        return this.f134898g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final boolean S() {
        return this.f134902k;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final long o() {
        return this.f134901j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final boolean F(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Iterator r101 = ((ArrayList) this.f134894c).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r103 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) r102;
        if (r103.getType() == 1) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        if (r102 == null) goto L22;
        return true;
    L22:
        return false;
    L8:
        if (Intrinsics.areEqual(r103.f134883a, r100) == false) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void O(FrequentChatViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f134896e.startDrag(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void U(com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r110) {
        Intrinsics.checkNotNullParameter(r110, "chatItem");
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100 = this.f134899h;
        if (r100 != null) goto L5;
        return;
    L5:
        FrequentChatSecondaryFragment r101 = new FrequentChatSecondaryFragment(r100, this, FrequentChatSubPanelSource.EDIT, r110.f134884b, r110.f134883a);
        r100.o0(InputDialogFragmentSwitchType.NONE, r101);
        int r111 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_edit_button_click", Boolean.valueOf(r100.k0()), null);
    }

    public final void e0(FrequentChatShowMode r110) {
        Intrinsics.checkNotNullParameter(r110, "newMode");
        if (this.f134898g == r110) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L40;
        this.f134898g = r110;
        if (r110 != FrequentChatShowMode.READ) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r101 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) CollectionsKt.lastOrNull(this.f134894c);
        if (r101 != null) goto L12;
    L13:
        ((ArrayList) this.f134894c).add(this.f134897f);
    L20:
        if (r110 != FrequentChatShowMode.SORT) goto L22;
        this.f134900i = CollectionsKt.joinToString$default(this.f134894c, ",", null, null, 0, null, FrequentChatPresenter$setShowMode$1.INSTANCE, 30, null);
    L22:
        this.f134895d.notifyDataSetChanged();
        int r111 = f.f134917c[r110.ordinal()];
        if (r111 == 1) goto L31;
        if (r111 != 2) goto L26;
        String r112 = "livesdk_common_comment_rank_status_enter";
    L32:
        if (r112 == null) goto L41;
        int r102 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r103 = this.f134899h;
        if (r103 == null) goto L37;
        Boolean r104 = Boolean.valueOf(r103.k0());
    L38:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a(r112, r104, null);
        return;
    L37:
        r104 = null;
        goto L38
    L41:
        return;
    L26:
        if (r111 != 3) goto L29;
        r112 = "livesdk_common_comment_edit_status_enter";
        goto L32
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        r112 = null;
        goto L32
    L12:
        if (r101.getType() == 2) goto L20;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r105 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) CollectionsKt.lastOrNull(this.f134894c);
        if (r105 == null) goto L20;
        if (r105.getType() != 2) goto L20;
        List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> r106 = this.f134894c;
        ListProtector.remove(r106, ((ArrayList) r106).size() - 1);
        goto L20
    L40:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final void p(boolean r100) {
        this.f134902k = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void u(final com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101 = this.f134899h;
        if (r101 == null) goto L23;
        Context r102 = r101.getContext();
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f134902k == false) goto L10;
        return;
    L10:
        int r103 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r104 = this.f134899h;
        if (r104 == null) goto L13;
        Boolean r105 = Boolean.valueOf(r104.k0());
    L14:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_delete_button_click", r105, null);
        m r106 = new m(r102, new FrequentChatPresenter$showRemoveConfirmDialog$cancelOperation$1(this), new FrequentChatPresenter$showRemoveConfirmDialog$confirmOperation$1(this, r100));
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        return;
    L13:
        r105 = null;
        goto L14
    }

    @Override // t62.a
    public final void J(int r100, int r101) {
        Collections.swap(this.f134894c, r100, r101);
        this.f134895d.notifyItemMoved(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final void g(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
        int r102 = c0();
        ListProtector.add(this.f134894c, r102, new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(r101, r100, 1));
        this.f134895d.notifyItemInserted(r102);
        this.f134895d.notifyItemChanged(((ArrayList) this.f134894c).size() - 1);
        a r103 = (a) this.f531633a;
        if (r103 == null) goto L6;
        r103.Ih();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.FrequentChatListAdapter.b
    public final void k(CharSequence r100, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102 = this.f134899h;
        if (r102 != null) goto L5;
        return;
    L5:
        EditText r103 = r102.f135496a;
        if (r103 != null) goto L8;
        return;
    L8:
        int r104 = r103.getSelectionStart();
        r102.f135499d = 11;     // Catch: Exception -> L15
        int r105 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.f134928a;     // Catch: Exception -> L15
        int r106 = LivePortraitInputDialogV3.L;     // Catch: Exception -> L15
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a(r103, r100, LivePortraitInputDialogV3.a.a(), false);     // Catch: Exception -> L15
        int r107 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;     // Catch: Exception -> L15
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r108 = this.f134899h;     // Catch: Exception -> L15
        if (r108 == null) goto L12;
        Boolean r109 = Boolean.valueOf(r108.k0());     // Catch: Exception -> L15
    L13:
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_click", r109, MapsKt.mapOf(TuplesKt.to("common_comment_id", r101.toString())));     // Catch: Exception -> L15
        return;
    L12:
        r109 = null;
    L15:
        e = move-exception;
        r102.f135499d = 0;
        SafetyGuard.a(null, e, "input frequent comment failed,startpos:" + r104 + "，content:" + r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment.b
    public final void n(long r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "newContent");
        Iterator r101 = ((ArrayList) this.f134894c).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        if (((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) r101.next()).f134884b != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        r102 = r102 + 1;
    L13:
        if (r102 >= 0) goto L15;
        return;
    L15:
        if (r102 >= ((ArrayList) this.f134894c).size()) goto L22;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r104 = new com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c(r110, ((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) ListProtector.get(this.f134894c, r102)).f134884b, 1);
        ListProtector.set(this.f134894c, r102, r104);
        this.f134895d.notifyItemChanged(r102);
        return;
    L22:
        return;
    L8:
        r103 = false;
        goto L9
    L12:
        r102 = -1;
        goto L13
    }
}
