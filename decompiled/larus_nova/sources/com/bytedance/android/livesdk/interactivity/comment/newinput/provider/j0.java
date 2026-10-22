package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.DefaultLandingPanel;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j0 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<c, z62.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f135894e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputSectionType f135896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f135897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f135898d;

    public static final class a implements z62.f {
        public a() {
        }

        @Override // z62.f
        public final void r(boolean r100) {
        }
    }

    public static final class b {
    }

    public final class c extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageButton f135899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageButton f135900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ImageView f135901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public FrameLayout f135902f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public FrameLayout f135903g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public LinearLayout f135904h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public LinearLayout f135905i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ImageButton f135906j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ImageButton f135907k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ImageButton f135908l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f135909m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f135910n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ j0 f135911o;

        public final String i() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100 = this.f135911o.f135895a;
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.d0() != true) goto L13;
            EffectiveActivityEmojiGroup r101 = com.bytedance.android.livesdk.interactivity.api.q.c();
            if (r101 == null) goto L14;
            ActivityEmojiGroup r102 = r101.getEmojiGroup();
            if (r102 != null) goto L11;
            return null;
        L11:
            return r102.getIdStr();
        L14:
            return null;
        L13:
            return null;
        }

        public final com.bytedance.android.livesdk.sharedpref.e<Integer> j() {
            return new com.bytedance.android.livesdk.sharedpref.e(this.f135909m, 0);
        }

        public final void h(boolean r100) {
            if (r100 == false) goto L9;
            LinearLayout r101 = this.f135905i;
            if (r101 == null) goto L6;
            UtilityKotlinExtentionsKt.w(r101);
        L6:
            LinearLayout r102 = this.f135904h;
            if (r102 == null) goto L15;
            UtilityKotlinExtentionsKt.t(r102);
        L15:
            com.bytedance.android.livesdk.interactivity.api.quickcomment.f r103 = this.f135513b.Y();
            if (r103 != null) goto L18;
            return;
        L18:
            if (r103.isFixedComment() == true) goto L20;
            return;
        L20:
            if (y22.b.a(this.f135513b.S()) == true) goto L30;
            LinearLayout r104 = this.f135905i;
            if (r104 == null) goto L24;
            UtilityKotlinExtentionsKt.t(r104);
        L24:
            LinearLayout r105 = this.f135904h;
            if (r105 == null) goto L31;
            UtilityKotlinExtentionsKt.t(r105);
            return;
        L31:
            return;
        L30:
            return;
        L9:
            LinearLayout r106 = this.f135905i;
            if (r106 == null) goto L12;
            UtilityKotlinExtentionsKt.t(r106);
        L12:
            LinearLayout r107 = this.f135904h;
            if (r107 == null) goto L15;
            UtilityKotlinExtentionsKt.w(r107);
            goto L15
        }

        public final void k(boolean r100) {
            if (r100 == false) goto L21;
            ImageButton r101 = this.f135908l;
            if (r101 == null) goto L6;
            r101.setImageResource(R.drawable.ttlive_input_v3_send_on);
        L6:
            ImageButton r102 = this.f135907k;
            if (r102 == null) goto L9;
            r102.setImageResource(R.drawable.ttlive_input_v3_emoji_delete_on);
        L9:
            ImageButton r103 = this.f135908l;
            if (r103 == null) goto L12;
            r103.setClickable(true);
        L12:
            ImageButton r104 = this.f135907k;
            if (r104 == null) goto L15;
            r104.setClickable(true);
        L15:
            ImageButton r105 = this.f135908l;
            if (r105 == null) goto L18;
            r105.setEnabled(true);
        L18:
            ImageButton r106 = this.f135907k;
            if (r106 == null) goto L40;
            r106.setEnabled(true);
            return;
        L40:
            return;
        L21:
            ImageButton r107 = this.f135908l;
            if (r107 == null) goto L24;
            r107.setImageResource(R.drawable.ttlive_input_v3_send_off);
        L24:
            ImageButton r108 = this.f135907k;
            if (r108 == null) goto L27;
            r108.setImageResource(R.drawable.ttlive_input_v3_emoji_delete_off);
        L27:
            ImageButton r109 = this.f135907k;
            if (r109 == null) goto L30;
            r109.setClickable(false);
        L30:
            ImageButton r110 = this.f135908l;
            if (r110 == null) goto L33;
            r110.setClickable(false);
        L33:
            ImageButton r111 = this.f135908l;
            if (r111 == null) goto L36;
            r111.setEnabled(false);
        L36:
            ImageButton r112 = this.f135907k;
            if (r112 == null) goto L42;
            r112.setEnabled(false);
            return;
        }

        public static final void g(c r100, String r101) {
            r100.getClass();
            HashMap r102 = new HashMap();
            r102.put("click_icon", r101);
            r102.put("screen_type", "landscape");
            IInteractivityInjectService r103 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r103 == null) goto L5;
            r103.buildVsRoomLog(null, r102);
        L5:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_expansion_module_click", r102, new Object[]{IRoom.class, am2.x.class});
        }

        public c(j0 r100, View r101, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridge");
            this.f135911o = r100;
            super(r101, r102);
            this.f135909m = "portrait_control_emoji_";
        }
    }

    public static final class d implements z62.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f135912a;

        public d(j0 r100) {
            this.f135912a = r100;
        }

        @Override // z62.f
        public final void r(boolean r100) {
            c r101 = this.f135912a.f135897c;
            if (r101 == null) goto L6;
            r101.h(r100);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
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
        f135894e = new a();
    }

    public j0() {
        this.f135896b = InputSectionType.CONTROL_LANDSCAPE;
        this.f135898d = new d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.f135896b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.f135897c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Activity r101 = r100.getActivity();
        if (r101 != null) goto L5;
        return null;
    L5:
        this.f135895a = r100;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.ttlive_view_input_control_land, null);
        c r103 = new c(this, r102, r100);
        r103.f135899c = (ImageButton) r103.f135512a.findViewById(R.id.control_emoji);
        r103.f135901e = (ImageView) r103.f135512a.findViewById(R.id.red_dot);
        r103.f135900d = (ImageButton) r103.f135512a.findViewById(R.id.control_audio2text);
        r103.f135906j = (ImageButton) r103.f135512a.findViewById(R.id.control_keyboard);
        r103.f135907k = (ImageButton) r103.f135512a.findViewById(R.id.control_delete);
        r103.f135908l = (ImageButton) r103.f135512a.findViewById(R.id.control_send);
        r103.f135902f = (FrameLayout) r103.f135512a.findViewById(R.id.container_emoji);
        r103.f135903g = (FrameLayout) r103.f135512a.findViewById(R.id.container_audio2text);
        r103.f135904h = (LinearLayout) r103.f135512a.findViewById(R.id.control_button_group);
        r103.f135905i = (LinearLayout) r103.f135512a.findViewById(R.id.function_button_group);
        r103.h(true);
        if (r103.i() != null) goto L10;
        ImageView r104 = r103.f135901e;
        if (r104 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r104);
    L28:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r105 = r103.f135911o.f135895a;
        if (r105 == null) goto L51;
        EditText r106 = r105.f135496a;
        if (r106 == null) goto L51;
        Editable r107 = r106.getText();
        if (r107 == null) goto L51;
        if (r107.length() != 0) goto L37;
        boolean r108 = true;
    L38:
        if (r108 == false) goto L51;
        ImageButton r109 = r103.f135908l;
        if (r109 == null) goto L42;
        r109.setEnabled(false);
    L42:
        ImageButton r110 = r103.f135908l;
        if (r110 == null) goto L45;
        r110.setClickable(false);
    L45:
        ImageButton r111 = r103.f135907k;
        if (r111 == null) goto L48;
        r111.setEnabled(false);
    L48:
        ImageButton r112 = r103.f135907k;
        if (r112 == null) goto L51;
        r112.setClickable(false);
        goto L51
    L37:
        r108 = false;
    L51:
        ImageButton r113 = r103.f135908l;
        if (r113 == null) goto L54;
        r113.setOnClickListener(new k0(r103));
    L54:
        ImageButton r114 = r103.f135907k;
        if (r114 == null) goto L57;
        r114.setOnClickListener(new l0(r103));
    L57:
        ImageButton r115 = r103.f135899c;
        if (r115 == null) goto L60;
        r115.setOnClickListener(new m0(r103));
    L60:
        ImageButton r116 = r103.f135906j;
        if (r116 == null) goto L63;
        r116.setOnClickListener(new n0(r103));
    L63:
        ImageButton r117 = r103.f135900d;
        if (r117 == null) goto L66;
        r117.setOnClickListener(new o0(r103));
    L66:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r118 = r103.f135911o.f135895a;
        if (r118 == null) goto L69;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r119 = r118.V();
    L71:
        if (r119 != null) goto L73;
    L83:
        r103.f135513b.w(new p0(r103));
        r3.a(r103.f135899c, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_emoji));
        r3.a(r103.f135900d, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_audio2text));
        r3.c(r103.f135908l, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_send), true);
        r3.c(r103.f135907k, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_delete), true);
        r3.a(r103.f135906j, com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_a11y_keyboard_keyboard));
        if (r103.f135910n == false) goto L86;
        String r120 = "emoji|voice_to_text";
    L87:
        HashMap r121 = new HashMap();
        r121.put("show_icon", r120);
        r121.put("screen_type", "landscape");
        IInteractivityInjectService r122 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r122 == null) goto L90;
        r122.buildVsRoomLog(null, r121);
    L90:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_expansion_module_show", r121, new Object[]{IRoom.class, am2.x.class});
        Unit r123 = Unit.INSTANCE;
        this.f135897c = r103;
        return r102;
    L86:
        r120 = "emoji";
        goto L87
    L73:
        if (r119.f135414b != true) goto L83;
        Integer r124 = (Integer) hd0.c.f().f481009b;
        if (r124 != null) goto L78;
    L79:
        FrameLayout r125 = r103.f135903g;
        if (r125 == null) goto L82;
        UtilityKotlinExtentionsKt.w(r125);
    L82:
        r103.f135910n = true;
        goto L83
    L78:
        if (r124.intValue() == 2) goto L83;
    L69:
        r119 = null;
        goto L71
    L10:
        r103.f135909m = r103.f135909m + r103.i();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r126 = r103.f135513b.V();
        if (r126 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r127 = r126.f135419g;
        if (r127 == null) goto L15;
        String r128 = r127.f135380p;
    L17:
        if (Intrinsics.areEqual(r128, DefaultLandingPanel.Emoji.getPanel()) == false) goto L20;
        com.bytedance.android.livesdk.sharedpref.f.d(r103.j(), 3);
    L20:
        if (r103.j().getValue().intValue() >= 3) goto L25;
        ImageView r129 = r103.f135901e;
        if (r129 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r129);
    L24:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r130 = r103.j();
        com.bytedance.android.livesdk.sharedpref.f.d(r130, Integer.valueOf(r130.getValue().intValue() + 1));
        goto L28
    L25:
        ImageView r131 = r103.f135901e;
        if (r131 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r131);
    L15:
        r128 = null;
        goto L17
    }
}
