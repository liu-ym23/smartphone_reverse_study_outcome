package com.bytedance.android.live.openplatform.impl.minigameanchor.preview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import cr0.c;
import cr0.d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/preview/PreviewMiniGameDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMiniGameDialogFragment extends LiveDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f85273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OpenPlatformContext f85274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OpenPlatformMgInfoModel f85275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public vo0.a f85276g;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewMiniGameDialogFragment f85277a;

        public b(PreviewMiniGameDialogFragment r100) {
            this.f85277a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.k
        public final void a(boolean r100) {
            if (r100 == false) goto L9;
            OpenPlatformContext r101 = this.f85277a.f85274e;
            if (r101 == null) goto L10;
            AnchorMiniGameAppLogContextService r102 = (AnchorMiniGameAppLogContextService) r101.getService(AnchorMiniGameAppLogContextService.class);
            if (r102 == null) goto L11;
            HashMap<String, String> r103 = new HashMap();
            r103.put("screen_split_rate", "0.3");
            r103.put("click_type", "others");
            Unit r104 = Unit.INSTANCE;
            r102.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_click", r103);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    static {
    }

    public PreviewMiniGameDialogFragment() {
        this.f85273d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f85273d).clear();
    }

    public final View S90(int r100) {
        if (this.f85273d != null) goto L5;
        this.f85273d = new LinkedHashMap();
    L5:
        View r101 = this.f85273d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f85273d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        Dialog r101 = getDialog();
        super.onActivityCreated(r100);
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.getAttributes().windowAnimations = R.style.ttlive_bottom_dialog_anim;
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L6:
        if (r101 != null) goto L9;
    L21:
        if (r101 != null) goto L24;
        return;
    L24:
        if (r101.intValue() != R.id.exit_mount) goto L41;
        x0.b r102 = new x0.b(getContext(), 4);
        x0.d r103 = r102.f162238a;
        r103.f162252k = false;
        r103.f162253l = false;
        r102.m(R.string.ttlive_open_platform_mg_exit_mount_title);
        r102.l(R.string.ttlive_open_platform_mg_exit_mount_content);
        r102.i(0, R.string.ttlive_open_platform_mg_exit_mount_exit, new c(this));
        r102.i(1, R.string.ttlive_open_platform_mg_exit_mount_cancel, new d(this));
        r102.k(0, true);
        r102.n();
        OpenPlatformContext r104 = this.f85274e;
        if (r104 == null) goto L30;
        AnchorMiniGameAppLogContextService r105 = (AnchorMiniGameAppLogContextService) r104.getService(AnchorMiniGameAppLogContextService.class);
        if (r105 == null) goto L30;
        HashMap<String, String> r106 = new HashMap();
        r106.put("screen_split_rate", "0.3");
        Unit r107 = Unit.INSTANCE;
        r105.reportPreviewMgAppLog("livesdk_takepage_mg_remove_pop_show", r106);
    L30:
        OpenPlatformContext r108 = this.f85274e;
        if (r108 == null) goto L42;
        AnchorMiniGameAppLogContextService r109 = (AnchorMiniGameAppLogContextService) r108.getService(AnchorMiniGameAppLogContextService.class);
        if (r109 == null) goto L43;
        HashMap<String, String> r110 = new HashMap();
        r110.put("screen_split_rate", "0.3");
        r110.put("click_type", "remove");
        Unit r111 = Unit.INSTANCE;
        r109.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_click", r110);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L9:
        if (r101.intValue() != R.id.close_dialog_ic) goto L21;
        dismissAllowingStateLoss();     // Catch: Exception -> L12
    L16:
        OpenPlatformContext r112 = this.f85274e;
        if (r112 == null) goto L38;
        AnchorMiniGameAppLogContextService r113 = (AnchorMiniGameAppLogContextService) r112.getService(AnchorMiniGameAppLogContextService.class);
        if (r113 == null) goto L39;
        HashMap<String, String> r114 = new HashMap();
        r114.put("screen_split_rate", "0.3");
        r114.put("click_type", "close");
        Unit r115 = Unit.INSTANCE;
        r113.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_click", r114);
        return;
    L39:
        return;
    L38:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r116 = DialogFragmentLancet.sLastShowStack;
        if (r116 == null) goto L16;
        com.bytedance.crash.d.d(r116, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L16
    L4:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Context r101 = getContext();
        if (r101 == null) goto L13;
        LiveBottomSheetDialog r102 = new LiveBottomSheetDialog(r101, getTheme());
        Window r103 = r102.getWindow();
        if (r103 == null) goto L7;
        r103.setGravity(80);
    L7:
        Window r104 = r102.getWindow();
        if (r104 == null) goto L10;
        r104.setDimAmount(0.0f);
    L10:
        r102.setCanceledOnTouchOutside(true);
        r102.setNeedHookBottomSheetInterceptEvent(true);
        r102.setLiveBottomSheetOutsideListener(new b(this));
        return r102;
    L13:
        return super.onCreateDialog(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ImageView r102 = (ImageView) S90(R.id.close_dialog_ic);
        if (r102 == null) goto L5;
        r102.setOnClickListener(this);
    L5:
        TextView r103 = (TextView) S90(R.id.exit_mount);
        if (r103 == null) goto L8;
        r103.setOnClickListener(this);
    L8:
        OpenPlatformMgInfoModel r104 = this.f85275f;
        OpenPlatformContext r105 = null;
        if (r104 == null) goto L11;
        String r106 = r104.getTaskSource();
    L13:
        if (Intrinsics.areEqual(r106, ScoreTags.SCORE_TYPE_STAR) == false) goto L17;
        Context r107 = getContext();
        if (r107 == null) goto L21;
        int r108 = R.string.ttlive_open_platform_mg_preview_star_task;
    L20:
        String r109 = r107.getString(r108);
    L22:
        TextView r110 = (TextView) S90(R.id.task_source);
        if (r110 == null) goto L29;
        Context r111 = getContext();
        if (r111 == null) goto L27;
        String r112 = r111.getString(R.string.ttlive_open_platform_mg_preview_dialog_task, new Object[]{r109});
    L28:
        r110.setText(r112);
        goto L29
    L27:
        r112 = null;
    L29:
        HSImageView r113 = (HSImageView) S90(R.id.game_info_icon);
        if (r113 == null) goto L36;
        OpenPlatformMgInfoModel r114 = this.f85275f;
        if (r114 == null) goto L34;
        String r115 = r114.getAppIcon();
    L35:
        r113.setImageURI(r115);
        goto L36
    L34:
        r115 = null;
    L36:
        TextView r116 = (TextView) S90(R.id.game_info_name);
        if (r116 == null) goto L43;
        OpenPlatformMgInfoModel r117 = this.f85275f;
        if (r117 == null) goto L41;
        String r118 = r117.getAppName();
    L42:
        r116.setText(r118);
        goto L43
    L41:
        r118 = null;
    L43:
        TextView r119 = (TextView) S90(R.id.game_info_summary);
        if (r119 == null) goto L50;
        OpenPlatformMgInfoModel r120 = this.f85275f;
        if (r120 == null) goto L48;
        String r121 = r120.getGameSummary();
    L49:
        r119.setText(r121);
        goto L50
    L48:
        r121 = null;
    L50:
        OpenPlatformMgAnchorServiceImpl.Companion.getClass();
        po0.a.b r122 = (po0.a.b) OpenPlatformMgAnchorServiceImpl.access$getDiComponent$cp();
        r122.getClass();
        vo0.a r123 = r122.f530020a.f530024e.get();
        this.f85276g = r123;
        if (r123 == null) goto L53;
        r105 = r123.a();
    L53:
        this.f85274e = r105;
        OpenPlatformContext r124 = this.f85274e;
        if (r124 == null) goto L59;
        AnchorMiniGameAppLogContextService r125 = (AnchorMiniGameAppLogContextService) r124.getService(AnchorMiniGameAppLogContextService.class);
        if (r125 == null) goto L60;
        HashMap<String, String> r126 = new HashMap();
        r126.put("screen_split_rate", "0.3");
        Unit r127 = Unit.INSTANCE;
        r125.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_show", r126);
        return;
    L60:
        return;
    L59:
        return;
    L21:
        r109 = null;
        goto L22
    L17:
        r107 = getContext();
        if (r107 == null) goto L21;
        r108 = R.string.ttlive_open_platform_mg_preview_pop_task;
        goto L20
    L11:
        r106 = null;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_preview_mg_bottom_dialog_layout, r101, false);
    }
}
