package com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.f60;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/OpenLiveVideoTalkFragmentNew;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LayoutType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpenLiveVideoTalkFragmentNew extends LiveDialogFragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f73683w = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f73684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f73685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f73686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f73687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f73688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qd0.g f73689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f73690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f73691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f73692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f73693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f73694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f73695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f73696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f73697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f73698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f73699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f73700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Switch f73701u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f73702v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/dialog/fragment/OpenLiveVideoTalkFragmentNew$LayoutType;", "", "BigWindow", "Dynamic", "Fixed", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LayoutType extends Enum<LayoutType> {
        public static final LayoutType BigWindow = null;
        public static final LayoutType Dynamic = null;
        public static final LayoutType Fixed = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LayoutType[] f73703a = null;

        static {
            LayoutType r100 = new LayoutType("BigWindow", 0);
            BigWindow = r100;
            LayoutType r101 = new LayoutType("Dynamic", 1);
            Dynamic = r101;
            LayoutType r102 = new LayoutType("Fixed", 2);
            Fixed = r102;
            f73703a = new LayoutType[]{r100, r101, r102};
        }

        public static LayoutType valueOf(String r100) {
            return (LayoutType) r27.a.a(LayoutType.class, r100);
        }

        public static LayoutType[] values() {
            return (LayoutType[]) f73703a.clone();
        }

        public LayoutType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew f73704a;

        public b(OpenLiveVideoTalkFragmentNew r100) {
            this.f73704a = r100;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            OpenLiveVideoTalkFragmentNew r102 = this.f73704a;
            if (r101 == false) goto L14;
            r102.f73686f = true;
            if (r102.f73687g != 0) goto L8;
            r102.f73687g = 12;
        L8:
            if (r102.f73688h != 0) goto L10;
            r102.f73688h = 2;
        L10:
            qd0.g r103 = r102.f73689i;
            if (r103 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L13:
            r103.update(r102.f73686f, r102.f73687g, r102.f73688h);
        L18:
            r102.updateView();
            if (r101 == false) goto L21;
            String r104 = "on";
        L22:
            HashMap<String, String> r105 = new HashMap();
            r102.T90(r105);
            boolean r106 = r102.f73686f;
            if (r106 == true) goto L25;
        L27:
            if (r106 == true) goto L29;
        L31:
            String r107 = "live";
        L32:
            r105.put("function_type", r107);
            r105.put("action_type", r104);
            j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_setting_switch", r105, new Object[0]);
            return;
        L29:
            if (r102.f73687g != 8) goto L31;
            r107 = "radio";
            goto L32
        L25:
            if (r102.f73687g != 12) goto L27;
            r107 = "party";
            goto L32
        L21:
            r104 = "off";
            goto L22
        L14:
            r102.f73686f = false;
            qd0.g r108 = r102.f73689i;
            if (r108 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L17:
            r108.update(r102.f73686f, 0, 0);
            goto L18
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew f73705a;

        public c(OpenLiveVideoTalkFragmentNew r100) {
            this.f73705a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OpenLiveVideoTalkFragmentNew r101 = this.f73705a;
            if (r101.f73687g != 8) goto L5;
            return;
        L5:
            ImageView r102 = r101.f73690j;
            if (r102 == null) goto L8;
            r102.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
        L8:
            ImageView r103 = this.f73705a.f73691k;
            if (r103 == null) goto L11;
            r103.setBackground(null);
        L11:
            ImageView r104 = this.f73705a.f73690j;
            int r105 = 1;
            if (r104 == null) goto L14;
            r104.setSelected(true);
        L14:
            ImageView r106 = this.f73705a.f73691k;
            if (r106 == null) goto L17;
            r106.setSelected(false);
        L17:
            OpenLiveVideoTalkFragmentNew r107 = this.f73705a;
            r107.f73687g = 8;
            if (r107.f73688h != 2) goto L20;
            r105 = 7;
        L20:
            r107.f73688h = r105;
            r107.X90();
            OpenLiveVideoTalkFragmentNew r108 = this.f73705a;
            r108.V90(r108.f73688h);
            qd0.g r109 = this.f73705a.f73689i;
            if (r109 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L23:
            OpenLiveVideoTalkFragmentNew r110 = this.f73705a;
            r109.update(r110.f73686f, r110.f73687g, r110.f73688h);
            OpenLiveVideoTalkFragmentNew.S90(this.f73705a, "layout");
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew f73706a;

        public d(OpenLiveVideoTalkFragmentNew r100) {
            this.f73706a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OpenLiveVideoTalkFragmentNew r101 = this.f73706a;
            if (r101.f73687g != 12) goto L5;
            return;
        L5:
            ImageView r102 = r101.f73690j;
            if (r102 == null) goto L8;
            r102.setBackground(null);
        L8:
            ImageView r103 = this.f73706a.f73691k;
            if (r103 == null) goto L11;
            r103.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
        L11:
            ImageView r104 = this.f73706a.f73690j;
            if (r104 == null) goto L14;
            r104.setSelected(false);
        L14:
            ImageView r105 = this.f73706a.f73691k;
            if (r105 == null) goto L17;
            r105.setSelected(true);
        L17:
            OpenLiveVideoTalkFragmentNew r106 = this.f73706a;
            r106.f73687g = 12;
            if (r106.f73688h != 1) goto L20;
            int r107 = 5;
        L21:
            r106.f73688h = r107;
            r106.X90();
            OpenLiveVideoTalkFragmentNew r108 = this.f73706a;
            r108.V90(r108.f73688h);
            qd0.g r109 = this.f73706a.f73689i;
            if (r109 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L24:
            OpenLiveVideoTalkFragmentNew r110 = this.f73706a;
            r109.update(r110.f73686f, r110.f73687g, r110.f73688h);
            OpenLiveVideoTalkFragmentNew.S90(this.f73706a, "layout");
            return;
        L20:
            r107 = 2;
            goto L21
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew f73707a;

        public e(OpenLiveVideoTalkFragmentNew r100) {
            this.f73707a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OpenLiveVideoTalkFragmentNew r101 = this.f73707a;
            r101.f73688h = 102;
            r101.V90(102);
            qd0.g r102 = this.f73707a.f73689i;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L5:
            OpenLiveVideoTalkFragmentNew r103 = this.f73707a;
            r102.update(r103.f73686f, r103.f73687g, r103.f73688h);
            OpenLiveVideoTalkFragmentNew.S90(this.f73707a, "seat_fit");
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew f73708a;

        public f(OpenLiveVideoTalkFragmentNew r100) {
            this.f73708a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OpenLiveVideoTalkFragmentNew r101 = this.f73708a;
            int r102 = r101.f73687g;
            if (r102 != 8) goto L5;
            r101.f73688h = 7;
        L9:
            r101.V90(r101.f73688h);
            qd0.g r103 = this.f73708a.f73689i;
            if (r103 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L12:
            OpenLiveVideoTalkFragmentNew r104 = this.f73708a;
            r103.update(r104.f73686f, r104.f73687g, r104.f73688h);
            OpenLiveVideoTalkFragmentNew.S90(this.f73708a, "seat_fit");
            return;
        L5:
            if (r102 != 12) goto L9;
            r101.f73688h = 2;
            goto L9
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenLiveVideoTalkFragmentNew f73709a;

        public g(OpenLiveVideoTalkFragmentNew r100) {
            this.f73709a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OpenLiveVideoTalkFragmentNew r101 = this.f73709a;
            int r102 = r101.f73687g;
            if (r102 != 8) goto L5;
            r101.f73688h = 1;
        L9:
            r101.V90(r101.f73688h);
            qd0.g r103 = this.f73709a.f73689i;
            if (r103 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        L12:
            OpenLiveVideoTalkFragmentNew r104 = this.f73709a;
            r103.update(r104.f73686f, r104.f73687g, r104.f73688h);
            OpenLiveVideoTalkFragmentNew.S90(this.f73709a, "seat_fit");
            return;
        L5:
            if (r102 != 12) goto L9;
            r101.f73688h = 5;
            goto L9
        }
    }

    static {
    }

    public final void X90() {
        if (this.f73687g != 8) goto L17;
        ImageView r100 = this.f73695o;
        if (r100 == null) goto L7;
        r100.setImageResource(R.drawable.ttlive_video_guestlink_dynamic_layout_icon);
    L7:
        ImageView r101 = this.f73697q;
        if (r101 == null) goto L10;
        r101.setImageResource(R.drawable.ttlive_video_guestlink_fixed_layout_icon);
    L10:
        TextView r102 = this.f73696p;
        if (r102 == null) goto L13;
        r102.setText(R.string.ttlive_interact_guestlink_dynamic_layout);
    L13:
        TextView r103 = this.f73698r;
        if (r103 == null) goto L16;
        r103.setText(R.string.ttlive_interact_guestlink_fixed_layout);
    L16:
        W90(this.f73687g);
        return;
    L17:
        ImageView r104 = this.f73695o;
        if (r104 == null) goto L20;
        r104.setImageResource(R.drawable.ttlive_video_talkroom_dynamic_layout_icon);
    L20:
        ImageView r105 = this.f73697q;
        if (r105 == null) goto L23;
        r105.setImageResource(R.drawable.ttlive_video_talkroom_fixed_layout_icon);
    L23:
        TextView r106 = this.f73696p;
        if (r106 == null) goto L26;
        r106.setText(R.string.ttlive_interact_talkroom_dynamic_layout);
    L26:
        TextView r107 = this.f73698r;
        if (r107 == null) goto L29;
        r107.setText(R.string.ttlive_interact_talkroom_fixed_layout);
    L29:
        W90(this.f73687g);
    }

    public final void show() {
        Context r100 = this.f73684d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
    L5:
        if (r100 == null) goto L13;
        FragmentManager r101 = ((FragmentActivity) r100).getSupportFragmentManager();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "OpenLiveVideoTalkFragment", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, this, r102) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L10:
        super.show(r101, "OpenLiveVideoTalkFragment");
        return;
    L17:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void updateView() {
        boolean r100 = this.f73686f;
        boolean r101 = false;
        if (r100 == true) goto L5;
    L31:
        if (r100 == true) goto L33;
    L59:
        Switch r102 = this.f73701u;
        if (r102 == null) goto L62;
        r102.setChecked(false);
    L62:
        TextView r103 = this.f73699s;
        if (r103 == null) goto L65;
        UtilityKotlinExtentionsKt.u(r103);
    L65:
        View r104 = this.f73700t;
        if (r104 == null) goto L71;
        UtilityKotlinExtentionsKt.u(r104);
        return;
    L71:
        return;
    L33:
        if (this.f73687g != 12) goto L59;
        Switch r105 = this.f73701u;
        if (r105 == null) goto L37;
        r105.setChecked(true);
    L37:
        ImageView r106 = this.f73690j;
        if (r106 == null) goto L40;
        r106.setBackground(null);
    L40:
        ImageView r107 = this.f73691k;
        if (r107 == null) goto L43;
        r107.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
    L43:
        ImageView r108 = this.f73691k;
        if (r108 == null) goto L46;
        r108.setSelected(true);
    L46:
        ImageView r109 = this.f73690j;
        if (r109 == null) goto L49;
        r109.setSelected(false);
    L49:
        X90();
        V90(this.f73688h);
        TextView r110 = this.f73699s;
        if (r110 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r110);
    L52:
        View r111 = this.f73700t;
        if (r111 == null) goto L56;
        UtilityKotlinExtentionsKt.w(r111);
    L56:
        if (this.f73688h != 2) goto L58;
        r101 = true;
    L58:
        U90(r101);
        return;
    L5:
        if (this.f73687g != 8) goto L31;
        Switch r112 = this.f73701u;
        if (r112 == null) goto L9;
        r112.setChecked(true);
    L9:
        ImageView r113 = this.f73690j;
        if (r113 == null) goto L12;
        r113.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
    L12:
        ImageView r114 = this.f73691k;
        if (r114 == null) goto L15;
        r114.setBackground(null);
    L15:
        ImageView r115 = this.f73690j;
        if (r115 == null) goto L18;
        r115.setSelected(true);
    L18:
        ImageView r116 = this.f73691k;
        if (r116 == null) goto L21;
        r116.setSelected(false);
    L21:
        X90();
        V90(this.f73688h);
        TextView r117 = this.f73699s;
        if (r117 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r117);
    L24:
        View r118 = this.f73700t;
        if (r118 == null) goto L28;
        UtilityKotlinExtentionsKt.w(r118);
    L28:
        if (this.f73688h != 7) goto L30;
        r101 = true;
    L30:
        U90(r101);
    }

    public OpenLiveVideoTalkFragmentNew() {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    public final void T90(HashMap<String, String> r100) {
        r100.put("live_type", "video_live");
        r100.put("anchor_id", je0.d.b0().toString());
        String r101 = this.f73685e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("source");
    L5:
        r100.put("request_page", r101);
    }

    public final void U90(boolean r100) {
        HashMap<String, String> r101 = new HashMap();
        T90(r101);
        boolean r102 = this.f73686f;
        if (r102 == true) goto L5;
    L7:
        if (r102 == true) goto L9;
    L11:
        String r103 = "live";
    L12:
        r101.put("layout_type", r103);
        int r104 = this.f73688h;
        if (r104 != 1) goto L15;
    L18:
        String r105 = "1";
    L19:
        r101.put("empty_seat_show", r105);
        if (r100 == false) goto L22;
        String r106 = "seat_fit";
    L23:
        r101.put("default_layout_type", r106);
        j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_setting_show", r101, new Object[0]);
        return;
    L22:
        r106 = "normal";
        goto L23
    L15:
        if (r104 == 5) goto L18;
        r105 = "0";
        goto L19
    L9:
        if (this.f73687g != 8) goto L11;
        r103 = "radio";
        goto L12
    L5:
        if (this.f73687g != 12) goto L7;
        r103 = "party";
        goto L12
    }

    public final void V90(int r100) {
        if (r100 != 2) goto L5;
    L10:
        LayoutType r101 = LayoutType.Dynamic;
    L11:
        int r102 = if0.a.f489539a[r101.ordinal()];
        if (r102 == 1) goto L50;
        if (r102 == 2) goto L32;
        ImageView r103 = this.f73692l;
        if (r103 == null) goto L17;
        r103.setSelected(false);
    L17:
        ImageView r104 = this.f73692l;
        if (r104 == null) goto L20;
        r104.setBackground(null);
    L20:
        ImageView r105 = this.f73693m;
        if (r105 == null) goto L23;
        r105.setSelected(false);
    L23:
        ImageView r106 = this.f73693m;
        if (r106 == null) goto L26;
        r106.setBackground(null);
    L26:
        ImageView r107 = this.f73694n;
        if (r107 == null) goto L29;
        r107.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
    L29:
        ImageView r108 = this.f73694n;
        if (r108 == null) goto L69;
        r108.setSelected(true);
        return;
    L69:
        return;
    L32:
        ImageView r109 = this.f73692l;
        if (r109 == null) goto L35;
        r109.setSelected(false);
    L35:
        ImageView r110 = this.f73692l;
        if (r110 == null) goto L38;
        r110.setBackground(null);
    L38:
        ImageView r111 = this.f73693m;
        if (r111 == null) goto L41;
        r111.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
    L41:
        ImageView r112 = this.f73693m;
        if (r112 == null) goto L44;
        r112.setSelected(true);
    L44:
        ImageView r113 = this.f73694n;
        if (r113 == null) goto L47;
        r113.setSelected(false);
    L47:
        ImageView r114 = this.f73694n;
        if (r114 == null) goto L71;
        r114.setBackground(null);
        return;
    L71:
        return;
    L50:
        ImageView r115 = this.f73692l;
        if (r115 == null) goto L53;
        r115.setBackgroundResource(R.drawable.ttlive_video_talk_switch_scene_selected_bg);
    L53:
        ImageView r116 = this.f73692l;
        if (r116 == null) goto L56;
        r116.setSelected(true);
    L56:
        ImageView r117 = this.f73693m;
        if (r117 == null) goto L59;
        r117.setSelected(false);
    L59:
        ImageView r118 = this.f73693m;
        if (r118 == null) goto L62;
        r118.setBackground(null);
    L62:
        ImageView r119 = this.f73694n;
        if (r119 == null) goto L65;
        r119.setSelected(false);
    L65:
        ImageView r120 = this.f73694n;
        if (r120 == null) goto L73;
        r120.setBackground(null);
        return;
    L73:
        return;
    L5:
        if (r100 == 7) goto L10;
        if (r100 == 102) goto L9;
        r101 = LayoutType.Fixed;
        goto L11
    L9:
        r101 = LayoutType.BigWindow;
        goto L11
    }

    public final void W90(int r100) {
        Long r101 = f60.f120178a.getValue();
        ViewGroup.LayoutParams r102 = null;
        if (r101 != null) goto L6;
    L62:
        ImageView r103 = this.f73692l;
        if (r103 == null) goto L65;
        UtilityKotlinExtentionsKt.t(r103);
    L65:
        View r104 = this.f73702v;
        if (r104 == null) goto L68;
        UtilityKotlinExtentionsKt.t(r104);
    L68:
        ImageView r105 = this.f73693m;
        if (r105 == null) goto L71;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
    L73:
        if ((r106 instanceof ConstraintLayout.LayoutParams) == true) goto L75;
        r106 = null;
    L75:
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        if (r107 == null) goto L78;
        ((ViewGroup.MarginLayoutParams) r107).leftMargin = s1.f(0.0f);
    L78:
        TextView r108 = this.f73696p;
        if (r108 == null) goto L81;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L83:
        if ((r109 instanceof LinearLayout.LayoutParams) == true) goto L85;
        r109 = null;
    L85:
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r109;
        if (r110 == null) goto L88;
        r110.leftMargin = s1.f(8.0f);
    L88:
        ImageView r111 = this.f73694n;
        if (r111 == null) goto L91;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L93:
        if ((r112 instanceof ConstraintLayout.LayoutParams) == true) goto L95;
        r112 = null;
    L95:
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
        if (r113 == null) goto L98;
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = s1.f(14.0f);
    L98:
        TextView r114 = this.f73698r;
        if (r114 == null) goto L101;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
    L103:
        if ((r115 instanceof LinearLayout.LayoutParams) == false) goto L106;
        r102 = r115;
    L106:
        LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r102;
        if (r116 == null) goto L109;
        r116.leftMargin = s1.f(8.0f);
    L109:
        TextView r117 = this.f73696p;
        if (r117 == null) goto L112;
        r117.setTextSize(14.0f);
    L112:
        TextView r118 = this.f73698r;
        if (r118 == null) goto L118;
        r118.setTextSize(14.0f);
        return;
    L118:
        return;
    L101:
        r115 = null;
        goto L103
    L91:
        r112 = null;
        goto L93
    L81:
        r109 = null;
        goto L83
    L71:
        r106 = null;
        goto L73
    L6:
        if (r101.longValue() != 2) goto L62;
        if (r100 != 8) goto L62;
        ImageView r119 = this.f73692l;
        if (r119 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r119);
    L12:
        View r120 = this.f73702v;
        if (r120 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r120);
    L15:
        ImageView r121 = this.f73693m;
        if (r121 == null) goto L18;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L20:
        if ((r122 instanceof ConstraintLayout.LayoutParams) == true) goto L22;
        r122 = null;
    L22:
        ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        if (r123 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r123).leftMargin = s1.f(2.0f);
    L25:
        ImageView r124 = this.f73694n;
        if (r124 == null) goto L28;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
    L30:
        if ((r125 instanceof ConstraintLayout.LayoutParams) == true) goto L32;
        r125 = null;
    L32:
        ConstraintLayout.LayoutParams r126 = (ConstraintLayout.LayoutParams) r125;
        if (r126 == null) goto L35;
        ((ViewGroup.MarginLayoutParams) r126).leftMargin = s1.f(2.0f);
    L35:
        TextView r127 = this.f73696p;
        if (r127 == null) goto L38;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
    L40:
        if ((r128 instanceof LinearLayout.LayoutParams) == true) goto L42;
        r128 = null;
    L42:
        LinearLayout.LayoutParams r129 = (LinearLayout.LayoutParams) r128;
        if (r129 == null) goto L45;
        r129.leftMargin = s1.f(4.0f);
    L45:
        TextView r130 = this.f73698r;
        if (r130 == null) goto L48;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
    L50:
        if ((r131 instanceof LinearLayout.LayoutParams) == false) goto L53;
        r102 = r131;
    L53:
        LinearLayout.LayoutParams r132 = (LinearLayout.LayoutParams) r102;
        if (r132 == null) goto L56;
        r132.leftMargin = s1.f(4.0f);
    L56:
        TextView r133 = this.f73696p;
        if (r133 == null) goto L59;
        r133.setTextSize(11.0f);
    L59:
        TextView r134 = this.f73698r;
        if (r134 == null) goto L116;
        r134.setTextSize(11.0f);
        return;
    L116:
        return;
    L48:
        r131 = null;
        goto L50
    L38:
        r128 = null;
        goto L40
    L28:
        r125 = null;
        goto L30
    L18:
        r122 = null;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L8;
        String r102 = r101.getString("source");
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        this.f73685e = r102;
        this.f73686f = r101.getBoolean("autoOpen");
        this.f73687g = r101.getInt("scene");
        this.f73688h = r101.getInt("uiLayout");
    L8:
        setStyle(1, R.style.ttlive_CommonBottomDialogFast_DimDisable);
    }

    public static final void S90(OpenLiveVideoTalkFragmentNew r100, String r101) {
        r100.getClass();
        HashMap<String, String> r102 = new HashMap();
        r100.T90(r102);
        boolean r103 = r100.f73686f;
        if (r103 == true) goto L5;
    L7:
        if (r103 == true) goto L9;
    L14:
        String r104 = "live";
    L15:
        r102.put("layout_type", r104);
        int r105 = r100.f73688h;
        if (r105 != 1) goto L18;
    L21:
        String r106 = "1";
    L22:
        r102.put("empty_seat_show", r106);
        r102.put("switch_type", r101);
        j0.l().sendLog("livesdk_anchor_livetakepage_chatroom_layout_switch", r102, new Object[]{IRoom.class, x.class});
        return;
    L18:
        if (r105 == 5) goto L21;
        r106 = "0";
        goto L22
    L9:
        if (r100.f73687g != 8) goto L14;
        if (r100.f73688h != 102) goto L13;
        r104 = "big_frame";
        goto L15
    L13:
        r104 = "radio";
        goto L15
    L5:
        if (r100.f73687g != 12) goto L7;
        r104 = "party";
        goto L15
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f73690j = (ImageView) r100.findViewById(R.id.iv_playmode_guest_link_layout);
        this.f73691k = (ImageView) r100.findViewById(R.id.iv_playmode_talkroom_layout);
        this.f73692l = (ImageView) r100.findViewById(R.id.iv_layout_big_window_layout);
        this.f73693m = (ImageView) r100.findViewById(R.id.iv_layout_dynamic_layout);
        this.f73694n = (ImageView) r100.findViewById(R.id.iv_layout_fixed_layout);
        this.f73702v = r100.findViewById(R.id.ll_layout_big_window_layout);
        this.f73695o = (ImageView) r100.findViewById(R.id.layout_dynamic_layout_iv);
        this.f73696p = (TextView) r100.findViewById(R.id.layout_dynamic_layout_tv);
        this.f73697q = (ImageView) r100.findViewById(R.id.layout_fixed_layout_iv);
        this.f73698r = (TextView) r100.findViewById(R.id.layout_fixed_layout_tv);
        this.f73701u = (Switch) r100.findViewById(R.id.switch_open_talk_room);
        this.f73699s = (TextView) r100.findViewById(R.id.tv_layout_setting_linkmode);
        this.f73700t = r100.findViewById(R.id.cl_linkmode_switch);
        updateView();
        Switch r102 = this.f73701u;
        if (r102 == null) goto L5;
        r102.setOnCheckedChangeListener(new b(this));
    L5:
        r3.c(this.f73690j, s1.B(R.string.ttlive_interact_guest_link_playmode), true);
        r3.c(this.f73691k, s1.B(R.string.ttlive_interact_talk_room_playmode), true);
        r3.c(this.f73693m, s1.B(R.string.ttlive_interact_dynamic_talk_layout), true);
        r3.c(this.f73694n, s1.B(R.string.ttlive_interact_fixed_talk_layout), true);
        ImageView r103 = this.f73690j;
        if (r103 == null) goto L8;
        r103.setOnClickListener(new c(this));
    L8:
        ImageView r104 = this.f73691k;
        if (r104 == null) goto L11;
        r104.setOnClickListener(new d(this));
    L11:
        ImageView r105 = this.f73692l;
        if (r105 == null) goto L14;
        r105.setOnClickListener(new e(this));
    L14:
        ImageView r106 = this.f73693m;
        if (r106 == null) goto L17;
        r106.setOnClickListener(new f(this));
    L17:
        ImageView r107 = this.f73694n;
        if (r107 == null) goto L21;
        r107.setOnClickListener(new g(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_open_live_video_talk_setting_v2, r101, false);
    }
}
