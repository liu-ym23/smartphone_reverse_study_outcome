package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.utils.FixedForAppBarLayoutManager;
import com.bytedance.android.live.revlink.impl.pk.utils.w;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.c0;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.v;
import y31.y;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkRandomMatchDialogV2;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lx31/l;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkRandomMatchDialogV2 extends LinkCommonDialogFragment implements x31.l, AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f95446r = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Integer, View> f95447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f95448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f95449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f95450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PkItemExposeRecyclerView f95451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MultiTypeAdapter f95452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Object> f95453k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f95454l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f95455m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DataCenter f95456n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PkAutoMatchDataContext f95457o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f95458p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f95459q;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkRandomMatchDialogV2 f95460a;

        public b(PkRandomMatchDialogV2 r100) {
            this.f95460a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Long r101 = (Long) r100;
            if (r101 == null) goto L6;
            long r102 = r101.longValue();
            this.f95460a.Y90(r102);
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkRandomMatchDialogV2 f95461a;

        public c(PkRandomMatchDialogV2 r100) {
            this.f95461a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            PkRandomMatchDialogV2 r101 = this.f95461a;
            String r102 = PkRandomMatchDialogV2.f95446r;
            Dialog r103 = r101.getDialog();
            Context r104 = r101.getContext();
            if (r103 == null) goto L17;
            if (r104 == null) goto L21;
            Dialog r105 = r101.getDialog();
            if (r105 == null) goto L18;
            View r106 = r105.getCurrentFocus();
            if (r106 == null) goto L22;
            InputMethodManager r107 = (InputMethodManager) r104.getSystemService("input_method");
            if (r107 != null) goto L14;
            return;
        L14:
            if (r107.isActive() == false) goto L20;
            r107.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkRandomMatchDialogV2 f95462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f95463b;

        public d(PkRandomMatchDialogV2 r100, boolean r101) {
            this.f95462a = r100;
            this.f95463b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        L21:
            return;
        L3:
            if (this.f95463b == false) goto L12;
            View r100 = this.f95462a.f95455m;     // Catch: Throwable -> L14
            if (r100 == null) goto L9;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L14
            if (r101 == null) goto L9;
            r101.height = s1.f(300.0f);     // Catch: Throwable -> L14
        L9:
            View r102 = this.f95462a.f95455m;     // Catch: Throwable -> L14
            if (r102 == null) goto L17;
            r102.requestLayout();     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L12:
            PkRandomMatchDialogV2.T90(this.f95462a, s1.f(300.0f));     // Catch: Throwable -> L14
        }
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final String getDegradeTag() {
        return "anchor_link_match_panel";
    }

    @Override // x31.l
    public final boolean isRequesting(IRoom r100) {
        return false;
    }

    static {
        StringBuilder r100 = new StringBuilder("https://");
        String r101 = k0.f90841a;
        r100.append(k0.f90841a);
        r100.append("/obj/live-android/pk_random_guest_avatar.webp");
        f95446r = r100.toString();
    }

    public final b0 U90() {
        PkAutoMatchDataContext r100 = this.f95457o;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAutoMatchInfo();
    }

    public final boolean V90() {
        PkAutoMatchDataContext r100 = this.f95457o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isRankRandom() != true) goto L7;
        return true;
    }

    public final boolean W90() {
        PkAutoMatchDataContext r100 = this.f95457o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getCurrentMatchType() != 12) goto L7;
        return true;
    }

    public PkRandomMatchDialogV2() {
        this.f95447e = new LinkedHashMap();
        this.f95449g = new CompositeDisposable();
        this.f95454l = true;
        this.f95459q = new b(this);
    }

    public final void aa0() {
        if (V90() == false) goto L9;
        TextView r100 = (TextView) S90(R.id.title);
        if (r100 == null) goto L22;
        r100.setText(s1.B(R.string.ttlive_pk_random_dialog_rank_title));
        return;
    L22:
        return;
    L9:
        if (this.f95458p > 0) goto L14;
        TextView r101 = (TextView) S90(R.id.title);
        if (r101 == null) goto L23;
        r101.setText(s1.B(R.string.ttlive_pk_random_dialog_v2_title3));
        return;
    L23:
        return;
    L14:
        if (W90() == false) goto L18;
        TextView r102 = (TextView) S90(R.id.title);
        if (r102 == null) goto L25;
        r102.setText(s1.B(R.string.ttlive_multi_matching_normal_link_title));
        return;
    L25:
        return;
    L18:
        TextView r103 = (TextView) S90(R.id.title);
        if (r103 == null) goto L27;
        r103.setText(s1.B(R.string.ttlive_pk_random_dialog_v2_title1));
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f95447e.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        CompositeDisposable r100 = this.f95449g;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        ValueAnimator r101 = this.f95448f;
        if (r101 == null) goto L8;
        r101.removeAllUpdateListeners();
        r101.removeAllListeners();
        r101.cancel();
    L8:
        PkAutoMatchDataContext r102 = this.f95457o;
        if (r102 == null) goto L14;
        LiveData<Long> r103 = r102.getLeftTime();
        if (r103 == null) goto L15;
        r103.removeObserver(this.f95459q);
        return;
    L15:
        return;
    }

    public final View S90(int r100) {
        if (this.f95447e != null) goto L5;
        this.f95447e = new LinkedHashMap();
    L5:
        View r101 = this.f95447e.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f95447e.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void X90(String r100) {
        HashMap r101 = new HashMap();
        long r102 = this.f95458p;
        long r103 = 0;
        if (r102 <= 0) goto L13;
        b0 r104 = U90();
        if (r104 == null) goto L9;
        c0 r105 = r104.getConfig();
        if (r105 == null) goto L9;
        long r106 = r105.getInviteLimitSec();
    L11:
        if (r102 > r106) goto L13;
        int r107 = 0;
    L14:
        r101.put("speedup_status", String.valueOf(r107));
        b0 r108 = U90();
        if (r108 == null) goto L19;
        c0 r109 = r108.getConfig();
        if (r109 == null) goto L19;
        r103 = r109.getPkAutoMatchIndex();
    L19:
        r101.put("pk_automatch_type", String.valueOf(r103));
        r101.put("action", r100);
        mz0.n r110 = new mz0.n();
        Map<String, String> r111 = r110.f516447a;
        Intrinsics.checkNotNullParameter(r111, "map");
        Intrinsics.checkNotNullParameter(r101, "map");
        r111.putAll(r101);
        mz0.m r112 = new mz0.m();
        r112.b(LogCommon.ROOM);
        List<Object> r113 = r110.f516448b;
        ArrayList r114 = (ArrayList) r113;
        r114.addAll(r112.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r115 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r116 = com.bytedance.android.scope.m.b(r115).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r116);
        ((mz0.i) ((f80.a) r116)).w3("livesdk_pk_match_banner_click", r110.f516447a, r110.f516448b);
        return;
    L9:
        r106 = 10;
    L13:
        r107 = 1;
        goto L14
    }

    public final void Y90(long r110) {
        this.f95458p = r110;
        long r100 = 60;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        String r102 = String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r110 / r100), Long.valueOf(r110 % r100)}, 2));
        ((TextView) S90(R.id.tv_left_sec)).setText(r102);
        ((TextView) S90(R.id.tv_top_left_sec)).setText(r102);
        if (this.f95458p != 0) goto L5;
        ((TextView) S90(R.id.tv_top_left_sec)).setVisibility(8);
        ((TextView) S90(R.id.tv_wait_sec_title)).setVisibility(8);
        ((TextView) S90(R.id.tv_left_sec)).setVisibility(8);
        ((TextView) S90(R.id.tv_waitting)).setVisibility(0);
    L5:
        aa0();
        if (V90() == false) goto L8;
        ((TextView) S90(R.id.tv_pk_about_start)).setText(s1.B(R.string.ttlive_pk_random_dialog_rank_speed_tip));
    L24:
        if (r110 > 0) goto L40;
        if (this.f95454l == true) goto L28;
        return;
    L28:
        this.f95454l = false;
        View r111 = S90(R.id.random_rank_ll);
        if (r111 == null) goto L31;
        r111.setVisibility(0);
    L31:
        View r112 = S90(R.id.random_common_ll);
        if (r112 == null) goto L34;
        r112.setVisibility(8);
    L34:
        w.a((SimpleDraweeView) S90(R.id.random_guest_anim), f95446r);
        IBaseUser r113 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).b();
        ImageView r114 = (ImageView) S90(R.id.random_avatar);
        if (r113 == null) goto L37;
        py.k r115 = r113.getAvatarThumbKt();
    L38:
        ImageUtil.loadRoundImage(r114, r115);
        return;
    L37:
        r115 = null;
        goto L38
    L40:
        if (this.f95454l == false) goto L42;
        return;
    L42:
        this.f95454l = true;
        View r116 = S90(R.id.random_rank_ll);
        if (r116 == null) goto L45;
        r116.setVisibility(8);
    L45:
        View r117 = S90(R.id.random_common_ll);
        if (r117 == null) goto L50;
        r117.setVisibility(0);
        return;
    L50:
        return;
    L8:
        long r103 = this.f95458p;
        b0 r104 = U90();
        if (r104 == null) goto L13;
        c0 r105 = r104.getConfig();
        if (r105 == null) goto L13;
        long r106 = r105.getInviteLimitSec();
    L15:
        if (r103 < r106) goto L17;
    L22:
        ((TextView) S90(R.id.tv_pk_about_start)).setText(s1.B(R.string.ttlive_pk_random_dialog_high_speed_title));
        goto L24
    L17:
        if (this.f95458p <= 0) goto L22;
        if (W90() == false) goto L21;
        ((TextView) S90(R.id.tv_pk_about_start)).setText(s1.B(R.string.ttlive_pk_random_dialog_game_almost_starting));
        goto L24
    L21:
        ((TextView) S90(R.id.tv_pk_about_start)).setText(s1.B(R.string.ttlive_pk_random_dialog_pk_almost_starting));
    L13:
        r106 = 10;
        goto L15
    }

    @Override // x31.l
    public final void onCancel(IRoom r100) {
        PkAutoMatchDataContext r101 = this.f95457o;
        if (r101 == null) goto L6;
        r101.cancelInvite(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new c(this));
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    public static final void T90(PkRandomMatchDialogV2 r100, int r101) {
        ValueAnimator r102 = r100.f95448f;
        if (r102 == null) goto L5;
        r102.removeAllUpdateListeners();
        r102.removeAllListeners();
        r102.cancel();
    L5:
        float r103 = 484.0f;
        if (r101 != s1.f(484.0f)) goto L8;
        r103 = 300.0f;
    L8:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{s1.f(r103), r101});
        r100.f95448f = r104;
        if (r104 == null) goto L11;
        r104.addUpdateListener(new n(r100));
    L11:
        ValueAnimator r105 = r100.f95448f;
        if (r105 == null) goto L17;
        ValueAnimator r106 = r105.setDuration(80);
        if (r106 == null) goto L18;
        r106.start();
        return;
    L18:
        return;
    }

    public final void Z90(y31.k r100, boolean r101) {
        ArrayList r102 = new ArrayList();
        y.a r103 = new y.a();
        r103.f565844a = s1.B(R.string.ttlive_pk_random_dialog_inviting_title);
        r102.add(r103);
        if (r100 == null) goto L5;
        r102.add(r100);
    L5:
        MultiTypeAdapter r104 = this.f95452j;
        if (r104 == null) goto L8;
        r104.f513437a = r102;
    L8:
        View r105 = this.f95455m;
        if (r105 == null) goto L11;
        r105.post(new d(this, r101));
    L11:
        MultiTypeAdapter r106 = this.f95452j;
        if (r106 == null) goto L14;
        r106.notifyDataSetChanged();
    L14:
        ((AppBarLayout) S90(R.id.app_bar_layout)).setExpanded(true);
        PkItemExposeRecyclerView r107 = this.f95451i;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L17:
        r107.scrollToPosition(0);
        final Context r108 = getContext();
        LinearLayoutManager r109 = new PkRandomMatchDialogV2$updateListByInvitingUser$mLinearLayoutManager$1(r108);
        PkItemExposeRecyclerView r110 = this.f95451i;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L20:
        r110.setLayoutManager(r109);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout r100, int r101) {
        if (r100 == null) goto L5;
        int r102 = r100.getTotalScrollRange();
    L7:
        if (Math.abs(r101 / r102) == 1.0f) goto L9;
    L24:
        aa0();
        TextView r103 = (TextView) S90(R.id.tv_top_left_sec);
        if (r103 == null) goto L32;
        r103.setVisibility(8);
        return;
    L32:
        return;
    L9:
        if (V90() == true) goto L24;
        if (this.f95458p != 0) goto L18;
        TextView r104 = (TextView) S90(R.id.tv_top_left_sec);
        if (r104 == null) goto L15;
        r104.setVisibility(8);
    L15:
        TextView r105 = (TextView) S90(R.id.title);
        if (r105 == null) goto L28;
        r105.setText(s1.B(R.string.ttlive_pk_random_dialog_waitting_tips));
        return;
    L28:
        return;
    L18:
        TextView r106 = (TextView) S90(R.id.tv_top_left_sec);
        if (r106 == null) goto L21;
        r106.setVisibility(0);
    L21:
        TextView r107 = (TextView) S90(R.id.title);
        if (r107 == null) goto L30;
        r107.setText(s1.B(R.string.ttlive_pk_random_dialog_v2_title2));
        return;
    L30:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        aa0();
        ((AppBarLayout) S90(R.id.app_bar_layout)).addOnOffsetChangedListener(this);
        PkItemExposeRecyclerView r112 = this.f95451i;
        if (r112 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L5:
        r112.setInviteIconPanelType("random_trans_invite");
        PkItemExposeRecyclerView r113 = this.f95451i;
        if (r113 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L8:
        r113.setLayoutManager(new FixedForAppBarLayoutManager(getContext()));
        MultiTypeAdapter r114 = new MultiTypeAdapter();
        this.f95452j = r114;
        r114.z2(y.a.class, new y());
        DataCenter r100 = this.f95456n;
        if (r100 == null) goto L13;
        MultiTypeAdapter r115 = this.f95452j;
        if (r115 == null) goto L13;
        r115.z2(y31.k.class, new y31.j(null, this, r100, V90(), 24));
    L13:
        MultiTypeAdapter r116 = this.f95452j;
        if (r116 == null) goto L16;
        r116.z2(v.a.class, new v());
    L16:
        PkItemExposeRecyclerView r117 = this.f95451i;
        if (r117 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L19:
        r117.setAdapter(this.f95452j);
        TextView r118 = this.f95450h;
        if (r118 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mQuit");
    L22:
        r118.setOnClickListener(new i(this));
        Context r119 = getContext();
        if (r119 == null) goto L25;
        ((TextView) S90(R.id.tv_left_sec)).setTypeface(Typeface.createFromAsset(r119.getAssets(), "fonts/clarity_mono_bold.otf"));
        ((TextView) S90(R.id.tv_top_left_sec)).setTypeface(Typeface.createFromAsset(r119.getAssets(), "fonts/clarity_mono_bold.otf"));
    L25:
        PkAutoMatchDataContext r120 = this.f95457o;
        long r101 = 0;
        if (r120 == null) goto L31;
        LiveData<Long> r121 = r120.getLeftTime();
        if (r121 == null) goto L31;
        Long r122 = r121.getValue();
        if (r122 == null) goto L31;
    L32:
        Y90(r122.longValue());
        int r102 = 0;
        if (W90() == false) goto L38;
        PkItemExposeRecyclerView r123 = this.f95451i;
        if (r123 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L37:
        r123.setVisibility(8);
        a1.k(S90(R.id.col_random_match), UtilityKotlinExtentionsKt.i(123));
    L75:
        PkAutoMatchDataContext r124 = this.f95457o;
        if (r124 == null) goto L80;
        LiveData<Long> r125 = r124.getLeftTime();
        if (r125 == null) goto L80;
        r125.observeForever(this.f95459q);
    L80:
        HashMap r126 = new HashMap();
        long r103 = this.f95458p;
        if (r103 <= 0) goto L91;
        b0 r127 = U90();
        if (r127 == null) goto L87;
        c0 r128 = r127.getConfig();
        if (r128 == null) goto L87;
        long r104 = r128.getInviteLimitSec();
    L89:
        if (r103 > r104) goto L91;
    L92:
        r126.put("speedup_status", String.valueOf(r102));
        r126.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE, "single");
        b0 r129 = U90();
        if (r129 == null) goto L97;
        c0 r130 = r129.getConfig();
        if (r130 == null) goto L97;
        r101 = r130.getPkAutoMatchIndex();
    L97:
        r126.put("pk_automatch_type", String.valueOf(r101));
        mz0.n r131 = new mz0.n();
        Map<String, String> r105 = r131.f516447a;
        Intrinsics.checkNotNullParameter(r105, "map");
        Intrinsics.checkNotNullParameter(r126, "map");
        r105.putAll(r126);
        mz0.m r132 = new mz0.m();
        r132.b(LogCommon.ROOM);
        ((ArrayList) r131.f516448b).addAll(r132.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r133 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r134 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r134);
        ((mz0.i) ((f80.a) r134)).w3("livesdk_pk_match_banner_show", r131.f516447a, r131.f516448b);
        return;
    L87:
        r104 = 10;
    L91:
        r102 = 1;
        goto L92
    L38:
        a1.k(S90(R.id.col_random_match), UtilityKotlinExtentionsKt.i(420));
        PkItemExposeRecyclerView r135 = this.f95451i;
        if (r135 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L41:
        r135.setVisibility(0);
        if (V90() == false) goto L44;
        int r106 = 6;
    L45:
        PkAutoMatchDataContext r136 = this.f95457o;
        y31.k r137 = null;
        if (r136 == null) goto L50;
        NextLiveData<y31.k> r138 = r136.getMInvitingUserData();
        if (r138 == null) goto L50;
        y31.k r139 = r138.getValue();
    L51:
        if (r139 != null) goto L64;
        r31.a r107 = r31.b.a(r31.a.f535859a);
        PkAutoMatchDataContext r140 = this.f95457o;
        if (r140 == null) goto L56;
        String r141 = r140.getMActivityName();
        if (r141 == null) goto L56;
    L57:
        Observable r142 = r107.c(r106, true, 0, r141, 0, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r142 == null) goto L70;
        Observable r143 = r142.compose(RxUtil.rxSchedulerHelper());
        if (r143 == null) goto L70;
        Disposable r144 = r143.subscribe(new j(this), k.f95979a);
        if (r144 == null) goto L70;
        this.f95449g.add(r144);
    L70:
        PkAutoMatchDataContext r145 = this.f95457o;
        if (r145 == null) goto L75;
        NextLiveData<y31.k> r146 = r145.getMInvitingUserData();
        if (r146 == null) goto L75;
        r146.observe(this, new m(this));
    L56:
        r141 = "";
        goto L57
    L64:
        PkAutoMatchDataContext r147 = this.f95457o;
        if (r147 == null) goto L69;
        NextLiveData<y31.k> r148 = r147.getMInvitingUserData();
        if (r148 == null) goto L69;
        r137 = r148.getValue();
    L69:
        Z90(r137, true);
    L50:
        r139 = null;
        goto L51
    L44:
        r106 = 2;
    L31:
        r122 = 0L;
        goto L32
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_pk_random_match_v3, r101, false);
        this.f95455m = r103;
        if (r103 == null) goto L6;
        TextView r104 = (TextView) r103.findViewById(R.id.title);
        this.f95450h = (TextView) r103.findViewById(R.id.quit);
        this.f95451i = (PkItemExposeRecyclerView) r103.findViewById(R.id.recycler_view);
    L6:
        return this.f95455m;
    }

    @Override // x31.l
    public final void onInvite(IRoom r110, int r111, IRivalExtraInfo r112, int r113, m2 r114, List r115, int r116, int r117, String r118, HashMap r210, Boolean r211) {
        r211.booleanValue();
        Intrinsics.checkNotNullParameter(r210, "logMap");
        X90("invite_recommend");
        long r100 = 10;
        long r101 = this.f95458p;
        if (1 <= r101) goto L6;
    L8:
        PkAutoMatchDataContext r102 = this.f95457o;
        String r103 = null;
        if (r102 == null) goto L13;
        NextLiveData<y31.k> r104 = r102.getMInvitingUserData();
        if (r104 == null) goto L13;
        y31.k r105 = r104.getValue();
    L14:
        if (r105 != null) goto L39;
        com.bytedance.android.live.revlink.impl.pk.utils.j r106 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r106 == null) goto L40;
        IBaseUser r107 = r110.getOwner();
        if (r107 == null) goto L20;
        String r108 = iz.a.a(r107);
    L22:
        if (r106.c(r111, r108, 0) != true) goto L44;
        com.bytedance.android.live.revlink.impl.pk.utils.j r109 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r109 == null) goto L41;
        IBaseUser r119 = r110.getOwner();
        if (r119 == null) goto L30;
        r103 = iz.a.a(r119);
    L30:
        if (r109.a(r103, r111) != true) goto L45;
        List<Object> r120 = this.f95453k;
        if (r120 == null) goto L42;
        PkAutoMatchDataContext r121 = this.f95457o;
        if (r121 == null) goto L43;
        r121.inviteWhenMatching(r110, V90(), r111, r114, r113, r120, r118);
        return;
    L43:
        return;
    L42:
        return;
    L45:
        return;
    L41:
        return;
    L44:
        return;
    L20:
        r108 = null;
        goto L22
    L40:
        return;
    L39:
        return;
    L13:
        r105 = null;
        goto L14
    L6:
        if (r100 < r101) goto L8;
        ToastUtil.a(R.string.ttlive_pk_random_dialog_invite_limit_tips, 0);
        mz0.n r122 = new mz0.n();
        mz0.m r123 = new mz0.m();
        r123.b(LogCommon.ROOM);
        ((ArrayList) r122.f516448b).addAll(r123.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r124 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r125 = com.bytedance.android.scope.m.b(r124).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r125);
        ((mz0.i) ((f80.a) r125)).w3("livesdk_pk_unable_invite_toast_show", r122.f516447a, r122.f516448b);
    }
}
