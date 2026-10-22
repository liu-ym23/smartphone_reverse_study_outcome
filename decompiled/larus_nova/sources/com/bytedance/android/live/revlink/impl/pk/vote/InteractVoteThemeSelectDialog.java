package com.bytedance.android.live.revlink.impl.pk.vote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteThemeSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteThemeBinder$b;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractVoteThemeSelectDialog extends LiveDialogFragment implements InteractVoteThemeBinder.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f97339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends aa> f97340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InteractVoteStartDialog.b f97341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InteractVoteStartDialog.b f97342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<InteractVoteThemeBinder.a> f97343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InteractVoteThemeBinder.b f97344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MultiTypeAdapter f97345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f97346k;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractVoteThemeSelectDialog f97347a;

        public a(InteractVoteThemeSelectDialog r100) {
            this.f97347a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            PkBaseStateMachine.c r101 = (PkBaseStateMachine.c) r100;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r102 = com.bytedance.android.live.revlink.impl.global.b.R();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.isInVote() == true) goto L7;
            return;
        L7:
            if (r101.a() == true) goto L16;
            return;
        L16:
            this.f97347a.dismiss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L21;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public InteractVoteThemeSelectDialog() {
        this.f97339d = new LinkedHashMap();
        this.f97343h = new ArrayList();
        this.f97346k = new a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r100 == null) goto L8;
        LiveData<PkBaseStateMachine.c> r101 = r100.getPkBaseState();
        if (r101 == null) goto L9;
        r101.removeObserver(this.f97346k);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f97339d.clear();
    }

    public final View S90(int r100) {
        if (this.f97339d != null) goto L5;
        this.f97339d = new LinkedHashMap();
    L5:
        View r101 = this.f97339d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f97339d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonBottomDialog);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteThemeBinder.b
    public final void s80(InteractVoteStartDialog.b r100) {
        Intrinsics.checkNotNullParameter(r100, "themeData");
        this.f97342g = r100;
        ArrayList<InteractVoteThemeBinder.a> r101 = this.f97343h;
        if (r101 == null) goto L14;
        Iterator<InteractVoteThemeBinder.a> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        InteractVoteThemeBinder.a r103 = r102.next();
        long r104 = r103.f97335a;
        InteractVoteStartDialog.b r105 = this.f97342g;
        if (r105 != null) goto L10;
    L12:
        boolean r106 = false;
    L13:
        r103.f97337c = r106;
        goto L6
    L10:
        if (r104 != r105.f97328a) goto L12;
        r106 = true;
    L14:
        ArrayList<InteractVoteThemeBinder.a> r107 = this.f97343h;
        if (r107 == null) goto L25;
        MultiTypeAdapter r108 = this.f97345j;
        if (r108 == null) goto L19;
        r108.f513437a = r107;
    L19:
        if (r108 == null) goto L26;
        r108.notifyDataSetChanged();
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        this.f97342g = this.f97341f;
        MultiTypeAdapter r101 = new MultiTypeAdapter();
        this.f97345j = r101;
        r101.z2(InteractVoteThemeBinder.a.class, new InteractVoteThemeBinder());
        ((PkItemExposeRecyclerView) S90(R.id.rv_theme_list)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((PkItemExposeRecyclerView) S90(R.id.rv_theme_list)).setAdapter(this.f97345j);
        this.f97343h.clear();
        InteractVoteStartDialog.b r102 = this.f97341f;
        if (r102 == null) goto L5;
        this.f97343h.add(new InteractVoteThemeBinder.a(r102.f97328a, r102.f97329b, true, this));
    L5:
        List<? extends aa> r103 = this.f97340e;
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        aa r111 = (aa) r104.next();
        long r105 = r111.getVoteType();
        InteractVoteStartDialog.b r106 = this.f97341f;
        if (r106 == null) goto L14;
        if (r105 == r106.f97328a) goto L9;
    L14:
        ArrayList<InteractVoteThemeBinder.a> r107 = this.f97343h;
        if (r107 == null) goto L9;
        r107.add(new InteractVoteThemeBinder.a(r111.getVoteType(), r111.getVoteDes(), false, this));
    L17:
        ArrayList<InteractVoteThemeBinder.a> r108 = this.f97343h;
        if (r108 == null) goto L24;
        MultiTypeAdapter r112 = this.f97345j;
        if (r112 == null) goto L22;
        r112.f513437a = r108;
    L22:
        if (r112 == null) goto L24;
        r112.notifyDataSetChanged();
    L24:
        ((TextView) S90(R.id.tv_confirm)).setOnClickListener(new h(this));
        ((FrameLayout) S90(R.id.iv_back)).setOnClickListener(new i(this));
        HashMap r109 = new HashMap();
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L27;
        String r113 = "2";
    L36:
        r109.put("anchor_connect_status", r113);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L39;
        String r114 = "pk_participate";
    L40:
        r109.put("source", r114);
        int r115 = UserListInviteType.f70864a;
        LinkCrossRoomDataHolder r116 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r116 == null) goto L43;
        int r117 = r116.f();
    L44:
        r109.put("invitee_list", UserListInviteType.a(r117, null));
        n r118 = new n();
        Map<String, String> r119 = r118.f516447a;
        Intrinsics.checkNotNullParameter(r119, "map");
        Intrinsics.checkNotNullParameter(r109, "map");
        r119.putAll(r109);
        m r120 = new m();
        LinkCrossRoomDataHolder.a r121 = LinkCrossRoomDataHolder.f92004c;
        com.bytedance.android.live.revlink.impl.a.b(r120);
        r120.b(LogCommon.ROOM);
        List<Object> r122 = r118.f516448b;
        ArrayList r123 = (ArrayList) r122;
        r123.addAll(r120.f516446a);
        cy0.e.f465759a.getClass();
        j r124 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r125 = com.bytedance.android.scope.m.b(r124).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r125);
        ((mz0.i) ((f80.a) r125)).w3("livesdk_vote_theme_setting_panel_show", r118.f516447a, r118.f516448b);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r126 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r126 == null) goto L58;
        LiveData<PkBaseStateMachine.c> r127 = r126.getPkBaseState();
        if (r127 == null) goto L59;
        r127.observeForever(this.f97346k);
        return;
    L59:
        return;
    L58:
        return;
    L43:
        r117 = 0;
        goto L44
    L39:
        r114 = "link_participate";
        goto L40
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r128 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r128 == null) goto L35;
        i11.b r129 = r128.getLinkUserCenter();
        if (r129 == null) goto L35;
        List<p> r130 = r129.getOnlineUserList();
        if (r130 == null) goto L35;
        r113 = String.valueOf(r130.size());
        if (r113 != null) goto L36;
    L35:
        r113 = "";
        goto L36
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_interact_vote_theme_select, r101, false);
    }
}
