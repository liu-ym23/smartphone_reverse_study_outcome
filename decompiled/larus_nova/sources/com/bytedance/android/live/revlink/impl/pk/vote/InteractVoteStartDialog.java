package com.bytedance.android.live.revlink.impl.pk.vote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.z0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;
import yz0.l;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteStartDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "BattleSelfDataType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractVoteStartDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f97317m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f97318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f97319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends aa> f97320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f97321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f97322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f97323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f97324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f97325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f97326l;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vote/InteractVoteStartDialog$BattleSelfDataType;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "BattleSelfDataType_Custom", "BattleSelfDataType_Vote", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleSelfDataType extends Enum<BattleSelfDataType> {
        public static final BattleSelfDataType BattleSelfDataType_Custom = null;
        public static final BattleSelfDataType BattleSelfDataType_Vote = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BattleSelfDataType[] f97327a = null;
        private int type;

        static {
            BattleSelfDataType r100 = new BattleSelfDataType("BattleSelfDataType_Custom", 0, 0);
            BattleSelfDataType_Custom = r100;
            BattleSelfDataType r101 = new BattleSelfDataType("BattleSelfDataType_Vote", 1, 1);
            BattleSelfDataType_Vote = r101;
            f97327a = new BattleSelfDataType[]{r100, r101};
        }

        public static BattleSelfDataType valueOf(String r100) {
            return (BattleSelfDataType) r27.a.a(BattleSelfDataType.class, r100);
        }

        public static BattleSelfDataType[] values() {
            return (BattleSelfDataType[]) f97327a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int r100) {
            this.type = r100;
        }

        public BattleSelfDataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f97328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f97329b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f97328a == r101.f97328a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f97329b, r101.f97329b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f97328a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f97329b;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public final String toString() {
            return "VoteSelectData(voteType=" + this.f97328a + ", voteDes=" + this.f97329b + ")";
        }

        public b() {
            this(0, "");
        }

        public b(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "voteDes");
            this.f97328a = r100;
            this.f97329b = r101;
        }
    }

    public interface c {
        void a(long r100, aa r101);
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractVoteStartDialog f97330a;

        public d(InteractVoteStartDialog r100) {
            this.f97330a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = r100.getId();
            if (r101 != R.id.tv_duration_300) goto L10;
            InteractVoteStartDialog r102 = this.f97330a;
            if (r102.f97324j == false) goto L7;
            long r103 = 30;
        L8:
            r102.W90(r103);
            return;
        L7:
            r103 = 300;
            goto L8
        L10:
            if (r101 != R.id.tv_duration_600) goto L13;
            InteractVoteStartDialog r104 = this.f97330a;
            int r105 = InteractVoteStartDialog.f97317m;
            r104.W90(600);
            return;
        L13:
            if (r101 != R.id.tv_duration_900) goto L18;
            InteractVoteStartDialog r106 = this.f97330a;
            int r107 = InteractVoteStartDialog.f97317m;
            r106.W90(900);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractVoteStartDialog f97331a;

        public e(InteractVoteStartDialog r100) {
            this.f97331a = r100;
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
            this.f97331a.dismiss();     // Catch: Exception -> L11
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

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteStartDialog$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(InteractVoteStartDialog r100) {
            super(1, r100, InteractVoteStartDialog.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(yh6.c r100) {
            InteractVoteStartDialog r101 = (InteractVoteStartDialog) this.receiver;
            r101.getClass();
            if (r100 != null) goto L6;
            return;
        L6:
            if ((r100 instanceof r0) == false) goto L16;
            r101.dismiss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L17;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L17:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(yh6.c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public InteractVoteStartDialog() {
        this.f97318d = new LinkedHashMap();
        this.f97319e = new CompositeDisposable();
        this.f97322h = 300;
        k51.a r100 = k51.a.f501824h;
        r100.getClass();
        this.f97324j = ((Boolean) k51.a.f501820d.getValue(r100, k51.a.f501817a[2])).booleanValue();
        this.f97325k = new e(this);
        this.f97326l = new d(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f97319e.dispose();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r100 == null) goto L8;
        LiveData<PkBaseStateMachine.c> r101 = r100.getPkBaseState();
        if (r101 == null) goto L9;
        r101.removeObserver(this.f97325k);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f97318d.clear();
    }

    public static void U90(TextView r100) {
        if (r100 == null) goto L5;
        r100.setBackground(s1.m(R.drawable.ttlive_vote_start_dialog_duration_select));
        r100.setTextColor(s1.h(R.color.ttlive_interact_vote_start_dialog_select_color));
        return;
    }

    public static void V90(TextView r100) {
        if (r100 == null) goto L5;
        r100.setBackground(s1.m(R.drawable.ttlive_vote_start_dialog_duration_unselect));
        r100.setTextColor(ColorProtector.parseColor("#161823"));
        return;
    }

    public final View S90(int r100) {
        if (this.f97318d != null) goto L5;
        this.f97318d = new LinkedHashMap();
    L5:
        View r101 = this.f97318d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f97318d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void W90(long r100) {
        if (r100 != 30) goto L6;
        U90((TextView) S90(R.id.tv_duration_300));
        V90((TextView) S90(R.id.tv_duration_600));
        V90((TextView) S90(R.id.tv_duration_900));
    L15:
        if (r100 == 0) goto L18;
        this.f97322h = r100;
        return;
    L18:
        return;
    L6:
        if (r100 != 300) goto L9;
        U90((TextView) S90(R.id.tv_duration_300));
        V90((TextView) S90(R.id.tv_duration_600));
        V90((TextView) S90(R.id.tv_duration_900));
        goto L15
    L9:
        if (r100 != 600) goto L12;
        U90((TextView) S90(R.id.tv_duration_600));
        V90((TextView) S90(R.id.tv_duration_300));
        V90((TextView) S90(R.id.tv_duration_900));
        goto L15
    L12:
        if (r100 != 900) goto L15;
        U90((TextView) S90(R.id.tv_duration_900));
        V90((TextView) S90(R.id.tv_duration_300));
        V90((TextView) S90(R.id.tv_duration_600));
        goto L15
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonBottomDialog);
        l r101 = (l) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), l.class);
        if (r101 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r102 = yz0.h.a.a(r101, com.bytedance.android.live.revenue.common.message.b.f90888e, false, 6);
        if (r102 == null) goto L11;
        final AnonymousClass1 r103 = new AnonymousClass1(this);
        Disposable r104 = r102.subscribe(new f(r103));
        if (r104 == null) goto L12;
        RxUtilKt.c(r104, this.f97319e);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void T90(InteractVoteStartDialog r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        String r103 = "";
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L5;
        String r104 = "2";
    L14:
        r102.put("anchor_connect_status", r104);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L17;
        String r105 = "pk_participate";
    L18:
        r102.put("source", r105);
        b r106 = r100.f97321g;
        if (r106 == null) goto L24;
        String r107 = r106.f97329b;
        if (r107 == null) goto L24;
        r103 = r107;
    L24:
        r102.put("theme", r103);
        r102.put("time_set", String.valueOf(r100.f97322h));
        int r108 = UserListInviteType.f70864a;
        LinkCrossRoomDataHolder r109 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r109 == null) goto L27;
        int r110 = r109.f();
    L28:
        Long r111 = null;
        r102.put("invitee_list", UserListInviteType.a(r110, null));
        w31.c r112 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r112 == null) goto L31;
        r111 = Long.valueOf(r112.i());
    L31:
        r102.put("pk_id", String.valueOf(r111));
        r102.put("click_type", r101);
        n r113 = new n();
        Map<String, String> r114 = r113.f516447a;
        Intrinsics.checkNotNullParameter(r114, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r114.putAll(r102);
        m r115 = new m();
        LinkCrossRoomDataHolder.a r116 = LinkCrossRoomDataHolder.f92004c;
        com.bytedance.android.live.revlink.impl.a.b(r115);
        r115.b(LogCommon.ROOM);
        List<Object> r117 = r113.f516448b;
        ArrayList r118 = (ArrayList) r117;
        r118.addAll(r115.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r119 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r120 = com.bytedance.android.scope.m.b(r119).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3("livesdk_vote_setting_panel_click", r113.f516447a, r113.f516448b);
        return;
    L27:
        r110 = 0;
        goto L28
    L17:
        r105 = "link_participate";
        goto L18
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r121 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r121 == null) goto L13;
        i11.b r122 = r121.getLinkUserCenter();
        if (r122 == null) goto L13;
        List<p> r123 = r122.getOnlineUserList();
        if (r123 == null) goto L13;
        r104 = String.valueOf(r123.size());
        if (r104 != null) goto L14;
    L13:
        r104 = "";
        goto L14
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        W90(l51.a.f());
        if (this.f97324j == false) goto L5;
        ((TextView) S90(R.id.tv_duration_300)).setText("30s");
    L5:
        ((TextView) S90(R.id.tv_duration_300)).setOnClickListener(this.f97326l);
        ((TextView) S90(R.id.tv_duration_600)).setOnClickListener(this.f97326l);
        ((TextView) S90(R.id.tv_duration_900)).setOnClickListener(this.f97326l);
        ((LinearLayout) S90(R.id.ll_select_theme)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.c(this));
        ((FrameLayout) S90(R.id.iv_back)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.d(this));
        ((TextView) S90(R.id.tv_start_vote)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.e(this));
        ((TextView) S90(R.id.tv_save_vote)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.vote.f(this));
        Observable<ExtraResponse<z0, Extra>> r102 = r31.b.a(r31.a.f535859a).q(BattleSelfDataType.BattleSelfDataType_Vote.getType());
        if (r102 == null) goto L12;
        Observable<R> r103 = r102.compose(RxUtil.rxSchedulerHelper());
        if (r103 == 0) goto L12;
        Disposable r104 = r103.subscribe(new com.bytedance.android.live.revlink.impl.pk.vote.a(this), com.bytedance.android.live.revlink.impl.pk.vote.b.f97349a);
        if (r104 == null) goto L12;
        RxUtilKt.c(r104, this.f97319e);
    L12:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r105 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r105 == null) goto L18;
        LiveData<PkBaseStateMachine.c> r106 = r105.getPkBaseState();
        if (r106 == null) goto L19;
        r106.observeForever(this.f97325k);
        return;
    L19:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_interact_vote_start, r101, false);
    }
}
