package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.core.widget.LiveEditText;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.OGCFixedCommentSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/OGCFixedInputDialog;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/LiveInputDialogV3;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedInputDialog extends LiveInputDialogV3 {
    public static final /* synthetic */ int D = 0;
    public HSImageView A;
    public HSImageView B;
    public boolean C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public QuickCommentView f135358u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f135359v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public InputPanelSectionContainer f135360w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f135361x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HSImageView f135362y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LiveEditText f135363z;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OGCFixedInputDialog f135364a;

        public b(OGCFixedInputDialog r100) {
            this.f135364a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f135364a.aa0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_ogc_fixed_input;
    }

    public final void aa0() {
        if (PadConfigUtils.c() == false) goto L6;
        ALogger.i("OGCFixedInputDialog", "sendLiveInputEvent: pad,skip send sendLiveInputEvent");
        return;
    L6:
        int r100 = UtilityKotlinExtentionsKt.i(400);
        QuickCommentView r101 = this.f135358u;
        if (r101 == null) goto L19;
        if (r101 == null) goto L19;
        if (r101.getVisibility() != 0) goto L19;
        QuickCommentView r102 = this.f135358u;
        int r103 = 0;
        if (r102 == null) goto L14;
        int r104 = r102.getHeight();
    L15:
        r100 = r100 + r104;
        StringBuilder r105 = new StringBuilder("sendLiveInputEvent: height diff add quickCommentView: ");
        QuickCommentView r106 = this.f135358u;
        if (r106 == null) goto L18;
        r103 = r106.getHeight();
    L18:
        r105.append(r103);
        ALogger.i("OGCFixedInputDialog", r105.toString());
        goto L19
    L14:
        r104 = 0;
    L19:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r107 = this.f135448g;
        if (r107 == null) goto L22;
        r107.u0(r100);
    L22:
        ALogger.i("OGCFixedInputDialog", "sendLiveInputEvent: height diff = " + r100);
        xs2.b.a().post(new i1(r100, this.f135361x));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f135361x = true;
        InputPanelSectionContainer r100 = this.f135360w;
        if (r100 == null) goto L6;
        r100.post(new b(this));
        return;
    }

    public OGCFixedInputDialog() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void U90(MeasureLinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        this.f135362y = (HSImageView) r100.findViewById(R.id.dialog_close);
        this.f135359v = r100.findViewById(R.id.dialog_content);
        HSImageView r101 = this.f135362y;
        if (r101 == null) goto L5;
        r101.setOnClickListener(new k(this));
    L5:
        this.A = (HSImageView) r100.findViewById(R.id.bg_dialog);
        this.B = (HSImageView) r100.findViewById(R.id.bg_header);
        this.f135363z = new LiveEditText(getContext());
        this.f135358u = (QuickCommentView) r100.findViewById(R.id.view_quick_comment);
        InputPanelSectionContainer r102 = (InputPanelSectionContainer) r100.findViewById(R.id.fixed_input_panel_container);
        this.f135360w = r102;
        if (r102 == null) goto L8;
        ((ArrayList) this.f135450i).add(r102);
    L8:
        InputPanelSectionContainer r103 = (InputPanelSectionContainer) r100.findViewById(R.id.input_panel_shadow_view);
        if (r103 == null) goto L11;
        r103.setOnClickListener(new l(this));
    L11:
        View r104 = this.f135359v;
        if (r104 == null) goto L14;
        r104.post(new m(this));
    L14:
        LinkedList<IQuickCommentShowWord> r105 = null;
        if (PadConfigUtils.c() == false) goto L52;
        View r106 = this.f135359v;
        if (r106 == null) goto L19;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
    L21:
        if ((r107 instanceof LinearLayout.LayoutParams) == true) goto L23;
        r107 = null;
    L23:
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
        if (r108 == null) goto L26;
        r108.width = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        r108.rightMargin = UtilityKotlinExtentionsKt.i(20);
        r108.bottomMargin = UtilityKotlinExtentionsKt.i(20);
        r108.gravity = GravityCompat.END;
    L27:
        if (r108 == null) goto L31;
        View r109 = this.f135359v;
        if (r109 == null) goto L31;
        r109.setLayoutParams(r108);
    L31:
        QuickCommentView r110 = this.f135358u;
        if (r110 == null) goto L34;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
    L36:
        if ((r111 instanceof LinearLayout.LayoutParams) == true) goto L38;
        r111 = null;
    L38:
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r111;
        if (r112 == null) goto L41;
        r112.width = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        r112.rightMargin = UtilityKotlinExtentionsKt.i(20);
        r112.gravity = GravityCompat.END;
    L42:
        if (r112 == null) goto L46;
        QuickCommentView r113 = this.f135358u;
        if (r113 == null) goto L46;
        r113.setLayoutParams(r112);
    L46:
        MeasureLinearLayout r114 = this.f135447f;
        if (r114 == null) goto L49;
        r114.setOnClickListener(new n(this));
    L49:
        View r115 = this.f135359v;
        if (r115 == null) goto L52;
        r115.setOnClickListener(o.f135533a);
        goto L52
    L41:
        r112 = null;
        goto L42
    L34:
        r111 = null;
        goto L36
    L26:
        r108 = null;
        goto L27
    L19:
        r107 = null;
    L52:
        DataCenter r116 = this.f135451j;
        if (r116 == null) goto L55;
        IRoom r117 = a0.n(r116);
    L57:
        if (ht2.g.f(r117, 22, true) == false) goto L63;
        HSImageView r118 = this.A;
        if (r118 == null) goto L61;
        r118.setBackground(null);
    L61:
        HSImageView r119 = this.A;
        OGCFixedInputDialog$loadSkin$1 r120 = OGCFixedInputDialog$loadSkin$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r120, WidgetCostModule.TYPE_ON_START);
        ht2.g.d(22, r117, r119, r120);
    L63:
        if (ht2.g.f(r117, 23, true) == false) goto L65;
        HSImageView r121 = this.B;
        OGCFixedInputDialog$loadSkin$2 r122 = OGCFixedInputDialog$loadSkin$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r122, WidgetCostModule.TYPE_ON_START);
        ht2.g.d(23, r117, r121, r122);
    L65:
        com.bytedance.android.livesdk.interactivity.api.h r123 = com.bytedance.android.livesdk.interactivity.api.i.b(this.f135451j, 1);
        if (r123 == null) goto L72;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r124 = r123.getQuickCommentManager();
        if (r124 == null) goto L72;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r125 = r124.getValue();
        if (r125 == null) goto L72;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.c r126 = r125.getOGCFixedChatInfo();
    L73:
        if (r126 == null) goto L79;
        py.k r127 = r126.cancelIcon;
        if (r127 == null) goto L79;
        if ((!r127.getUrls().isEmpty()) == false) goto L79;
        ImageUtil.loadImage(this.f135362y, r127, 0);
    L79:
        c r128 = this.f135445d;
        if (r128 == null) goto L84;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r129 = r128.f135419g;
        if (r129 == null) goto L84;
        r105 = r129.f135379o;
    L84:
        if (r105 != null) goto L86;
    L101:
        QuickCommentView r130 = this.f135358u;
        if (r130 == null) goto L107;
        UtilityKotlinExtentionsKt.t(r130);
        return;
    L107:
        return;
    L86:
        if (r105.isEmpty() == true) goto L101;
        nm1.m r131 = pm1.f.l();
        if (r131 != null) goto L90;
    L92:
        QuickCommentView r132 = this.f135358u;
        if (r132 == null) goto L95;
        UtilityKotlinExtentionsKt.w(r132);
    L95:
        QuickCommentView r133 = this.f135358u;
        if (r133 == null) goto L98;
        r133.setQuickComment(r105);
    L98:
        QuickCommentView r134 = this.f135358u;
        if (r134 == null) goto L105;
        r134.setListener(new q(this));
        return;
    L105:
        return;
    L90:
        if (r131.y(this.f135451j) != true) goto L92;
    L72:
        r126 = null;
        goto L73
    L55:
        r117 = null;
        goto L57
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final HashMap<String, Object> V90(com.bytedance.android.live.profit.privilege.model.danmu.b r100) {
        HashMap<String, Object> r101 = super.V90(r100);
        r101.put("scene", 1);
        String r102 = "0";
        if (this.C == false) goto L5;
        Object r103 = "0";
    L6:
        r101.put("is_settled", r103);
        if (this.C == false) goto L9;
        r102 = "1";
    L9:
        r101.put("is_shortcut_message", r102);
        return r101;
    L5:
        r103 = "1";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3
    public final void W90(MeasureLinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        OGCFixedCommentSectionProvider r101 = new OGCFixedCommentSectionProvider(this.f135451j);
        x r102 = new x();
        DanmakuSectionProvider r103 = new DanmakuSectionProvider();
        x.a r104 = r102.f136007c;
        if (r104 == null) goto L15;
        DanmakuSectionProvider.c r105 = r103.f135601h;
        p r106 = new p(this, r104, r105, r104, r105);
        this.f135448g = r106;
        r106.f135496a = this.f135363z;
        HashSet r107 = new HashSet();
        InputSectionType r108 = InputSectionType.OGC_FIXED_INPUT;
        r107.add(r108);
        InputPanelSectionContainer r109 = this.f135360w;
        if (r109 == null) goto L7;
        r109.setSupportSections(r107);
    L7:
        InputPanelSectionContainer r110 = this.f135360w;
        if (r110 == null) goto L10;
        r110.a(r106, r101);
    L10:
        InputPanelSectionContainer r111 = this.f135360w;
        if (r111 == null) goto L16;
        InputPanelSectionContainer.e(r111, r108, null, false, 6);
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.comment.newinput.bridge.EmojiSectionBridge");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.LiveInputDialogV3, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        this.f135361x = false;     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        aa0();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}
