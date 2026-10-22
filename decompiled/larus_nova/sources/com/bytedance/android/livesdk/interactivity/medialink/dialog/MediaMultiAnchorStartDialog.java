package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.vm.MediaMultiAnchorStartViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/dialog/MediaMultiAnchorStartDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorStartDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f138075h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f138076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f138077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f138078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f138079g;

    public static final class a {
    }

    static {
    }

    public final MediaMultiAnchorStartViewModel T90() {
        return (MediaMultiAnchorStartViewModel) this.f138079g.getValue();
    }

    public final void updateTitle() {
        List<User> r100 = T90().getOnLineList();
        ((TextView) S90(R.id.title_tail)).setText(s1.B(R.string.ttlive_media_anchor_link_at_linking));
        int r101 = s1.y() - UtilityKotlinExtentionsKt.i(142);
        ((TextView) S90(R.id.title)).setMaxWidth(r101);
        List<User> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        String r104 = "";
        if (r103 == true) goto L41;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r100.iterator();
    L13:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        User r108 = (User) r107;
        o0.a r110 = o0.f58946a;
        if (r108 == null) goto L17;
        String r109 = r108.getIdStr();
    L18:
        String r111 = ((IUserService) jc1.k.n(IUserService.class)).user().n();
        r110.getClass();
        if ((!o0.a.a(r109, r111)) == false) goto L13;
        r105.add(r107);
        goto L13
    L17:
        r109 = null;
        goto L18
    L21:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r113 = r105.iterator();
    L23:
        if (r113.hasNext() == false) goto L30;
        User r114 = (User) r113.next();
        if (r114 == null) goto L28;
        String r115 = r114.getNickName();
        if (r115 == null) goto L28;
    L29:
        r112.add(r115);
    L28:
        r115 = "";
        goto L29
    L30:
        String r116 = CollectionsKt.joinToString$default(r112, "、", null, null, 0, null, null, 62, null);
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;
        String r118 = String.format(s1.B(R.string.ttlive_media_anchor_link_window_linking_member_title), Arrays.copyOf(new Object[]{r116}, 1));
        float r119 = ((TextView) S90(R.id.title)).getPaint().measureText(r116);     // Catch: Exception -> L38
        float r120 = ((TextView) S90(R.id.title)).getPaint().measureText(r118);     // Catch: Exception -> L38
        float r121 = r101;
        if (r120 <= r121) goto L40;
        float r122 = r121 - (r120 - r119);     // Catch: Exception -> L38
        float r123 = (this.f138077e * r112.size()) + (this.f138078f * 2);     // Catch: Exception -> L38
        float r124 = r122 - r123;     // Catch: Exception -> L38
        if (r124 <= r123) goto L41;
        final int r125 = (int) (r124 / (r112.size() * UtilityKotlinExtentionsKt.i(13)));     // Catch: Exception -> L38
        r104 = String.format(s1.B(R.string.ttlive_media_anchor_link_window_linking_member_title), Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(r112, "...、", null, "...", 0, null, new AnonymousClass1(r125), 26, null)}, 1));     // Catch: Exception -> L38
    L40:
        r104 = r118;
    L38:
        e = move-exception;
        ALogger.e("MultiAnchorPkStartDialogNew--getTitle error", e);
    L41:
        ((TextView) S90(R.id.title)).setText(r104);
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public MediaMultiAnchorStartDialog() {
        this.f138076d = new LinkedHashMap();
        this.f138077e = UtilityKotlinExtentionsKt.i(20);
        this.f138078f = UtilityKotlinExtentionsKt.i(20);
        System.currentTimeMillis();
        this.f138079g = LazyKt.lazy(new MediaMultiAnchorStartDialog$viewModel$2(this));
    }

    public final void U90() {
        String r100 = null;
        if (MediaMultiAnchorStartViewModel.isOrganizer$default(T90(), null, 1, null) == true) goto L9;
        ((LinearLayout) S90(R.id.ll_go_anchor_list)).setBackgroundResource(R.drawable.ttlive_bg_media_anchor_link_invite_btn_unenable);
        ((ImageView) S90(R.id.iv_anchor_invite)).setVisibility(8);
        TextView r101 = (TextView) S90(R.id.tv_achor_invite);
        Context r102 = getContext();
        if (r102 == null) goto L7;
        r100 = r102.getString(R.string.ttlive_media_multi_link_forbid_others_invite_desc);
    L7:
        r101.setText(r100);
        ((TextView) S90(R.id.tv_achor_invite)).setTextColor(s1.h(R.color.ttlive_std_text_black_3));
        return;
    L9:
        if (T90().isOverLimit() == false) goto L14;
        ((LinearLayout) S90(R.id.ll_go_anchor_list)).setBackgroundResource(R.drawable.ttlive_bg_media_anchor_link_invite_btn_unenable);
        ((ImageView) S90(R.id.iv_anchor_invite)).setVisibility(8);
        TextView r103 = (TextView) S90(R.id.tv_achor_invite);
        Context r104 = getContext();
        if (r104 == null) goto L13;
        r100 = r104.getString(R.string.ttlive_media_anchor_link_window_invite_max_count);
    L13:
        r103.setText(r100);
        ((TextView) S90(R.id.tv_achor_invite)).setTextColor(s1.h(R.color.ttlive_std_text_black_3));
        return;
    L14:
        ((ImageView) S90(R.id.iv_anchor_invite)).setVisibility(0);
        ((LinearLayout) S90(R.id.ll_go_anchor_list)).setBackgroundResource(R.drawable.ttlive_bg_media_anchor_link_invite_btn);
        TextView r105 = (TextView) S90(R.id.tv_achor_invite);
        Context r106 = getContext();
        if (r106 == null) goto L17;
        r100 = r106.getString(R.string.ttlive_media_invite_more_anchor);
    L17:
        r105.setText(r100);
        ((TextView) S90(R.id.tv_achor_invite)).setTextColor(-1);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f138076d.clear();
    }

    public final View S90(int r100) {
        if (this.f138076d != null) goto L5;
        this.f138076d = new LinkedHashMap();
    L5:
        View r101 = this.f138076d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f138076d.put(Integer.valueOf(r100), r103);
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

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ImageView r102 = (ImageView) S90(R.id.quit);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new t(this));
    L5:
        LinearLayout r103 = (LinearLayout) S90(R.id.ll_go_anchor_list);
        if (r103 == null) goto L8;
        r103.setOnClickListener(new u(this));
    L8:
        this.f138078f = (int) ((TextView) S90(R.id.title)).getPaint().measureText(" ");
        this.f138077e = (int) ((TextView) S90(R.id.title)).getPaint().measureText("...、");
        U90();
        updateTitle();
        T90().getFinishState().observe(this, new r(this));
        T90().getOnlineStateNotify().observe(this, new s(this));
        T90().loadData();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_media_multi_anchor_start, r101, false);
    }
}
