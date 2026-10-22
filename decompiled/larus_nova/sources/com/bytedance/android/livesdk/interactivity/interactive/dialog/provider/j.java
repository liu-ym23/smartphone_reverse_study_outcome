package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements k82.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k82.a f137299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k82.c f137300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f137301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VSInputSectionType f137302d;

    public static final class a {
    }

    public final class b extends k82.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f137303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f137304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f137305e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ImageView f137306f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ImageView f137307g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TextView f137308h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ImageView f137309i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ImageView f137310j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f137311k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f137312l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Map<VSInputSectionType, ImageView> f137313m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ j f137314n;

        public final void b(boolean r100) {
            if (nq1.b.f520090a.getValue().booleanValue() == false) goto L22;
            if (r100 == true) goto L6;
        L13:
            TextView r101 = this.f137308h;
            if (r101 == null) goto L16;
            r101.setEnabled(false);
        L16:
            TextView r102 = this.f137308h;
            if (r102 == null) goto L19;
            r102.setAlpha(0.34f);
        L19:
            k82.a r103 = this.f137314n.f137299a;
            if (r103 == null) goto L37;
            r103.g(r100);
        L37:
            this.f137312l = r100;
            return;
        L6:
            if (this.f137311k == true) goto L13;
            TextView r104 = this.f137308h;
            if (r104 == null) goto L10;
            r104.setEnabled(true);
        L10:
            TextView r105 = this.f137308h;
            if (r105 == null) goto L19;
            r105.setAlpha(1.0f);
            goto L19
        L22:
            if (r100 == true) goto L24;
        L31:
            ImageView r106 = this.f137309i;
            if (r106 == null) goto L34;
            r106.setImageResource(R.drawable.ttlive_input_v3_send_off);
        L34:
            ImageView r107 = this.f137309i;
            if (r107 == null) goto L37;
            r107.setClickable(false);
            goto L37
        L24:
            if (this.f137311k == true) goto L31;
            ImageView r108 = this.f137309i;
            if (r108 == null) goto L28;
            r108.setImageResource(R.drawable.ttlive_input_v3_send_on);
        L28:
            ImageView r109 = this.f137309i;
            if (r109 == null) goto L37;
            r109.setClickable(true);
            goto L37
        }

        public final void c(VSInputSectionType r100) {
            Iterator r101 = ((LinkedHashMap) this.f137313m).entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L12;
            Map.Entry r102 = (Map.Entry) r101.next();
            ImageView r103 = (ImageView) r102.getValue();
            if (r103 == null) goto L4;
            if (((VSInputSectionType) r102.getKey()) != r100) goto L10;
            boolean r104 = true;
        L11:
            r103.setSelected(r104);
            goto L4
        L10:
            r104 = false;
            goto L11
        }

        public b(j r100, View r101, h82.b r102) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "panelBridge");
            this.f137314n = r100;
            super(r101, r102);
            this.f137313m = new LinkedHashMap();
        }
    }

    public static final class c implements j82.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f137315a;

        @Override // j82.c
        public final void k() {
            k82.c r100 = this.f137315a.f137300b;
            if ((r100 instanceof b) == true) goto L5;
            r100 = null;
        L5:
            b r101 = (b) r100;
            if (r101 == null) goto L9;
            r101.c(null);
            return;
        }

        public c(j r100) {
            this.f137315a = r100;
        }

        @Override // j82.c
        public final void d(boolean r100) {
            k82.c r101 = this.f137315a.f137300b;
            if ((r101 instanceof b) == true) goto L5;
            r101 = null;
        L5:
            b r102 = (b) r101;
            if (r102 == null) goto L9;
            r102.b(r100);
            return;
        }

        @Override // j82.c
        public final void n(SkinSelection r100) {
            j r101 = this.f137315a;
            k82.c r102 = r101.f137300b;
            DataCenter r103 = null;
            if ((r102 instanceof b) == true) goto L5;
            r102 = null;
        L5:
            b r104 = (b) r102;
            if (r104 == null) goto L19;
            if (r100 == null) goto L16;
            k82.a r105 = r101.f137299a;
            if (r105 == null) goto L13;
            t9 r106 = r105.s();
            if (r106 == null) goto L13;
            r103 = r106.f114228l;
        L13:
            boolean r107 = true;
            if (r100.a(r103) != true) goto L16;
        L17:
            r104.f137311k = r107;
            r104.b(r104.f137312l);
            return;
        L16:
            r107 = false;
            goto L17
        }
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    public j() {
        this.f137301c = new c(this);
        this.f137302d = VSInputSectionType.CONTROL_PORTRAIT;
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.f137302d;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.f137300b;
    }

    @Override // k82.d
    public final View g(h82.b r110) {
        Intrinsics.checkNotNullParameter(r110, "panelBridge");
        Activity r100 = r110.getActivity();
        Map<String, String> r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        this.f137299a = r110;
        LayoutInflater r102 = LayoutInflater.from(r100);
        t9 r103 = r110.f484061h.f137180d;
        if (r103 != null) goto L8;
    L9:
        if (r103 != null) goto L11;
    L13:
        int r104 = R.layout.ttlive_view_input_control_vs_landscape;
    L14:
        View r105 = r102.inflate(r104, null);
        final b r106 = new b(this, r105, r110);
        r106.f137304d = r106.f502090a.findViewById(R.id.control_skin_container);
        r106.f137305e = r106.f502090a.findViewById(R.id.control_emoji_container);
        r106.f137303c = (ImageView) r106.f502090a.findViewById(R.id.control_emoji);
        r106.f137309i = (ImageView) r106.f502090a.findViewById(R.id.input_control_send_iv);
        r106.f137308h = (TextView) r106.f502090a.findViewById(R.id.input_control_send_tv);
        r106.f137310j = (ImageView) r106.f502090a.findViewById(R.id.input_control_delete);
        r106.f137307g = (ImageView) r106.f502090a.findViewById(R.id.red_dot_skin);
        r106.f137306f = (ImageView) r106.f502090a.findViewById(R.id.control_skin);
        Map<VSInputSectionType, ImageView> r111 = r106.f137313m;
        r111.put(VSInputSectionType.EMOJI, r106.f137303c);
        r111.put(VSInputSectionType.PAID_LIVE_PACKAGE, r106.f137306f);
        Rect r112 = new Rect();
        r112.top -= UtilityKotlinExtentionsKt.i(5);
        r112.left -= UtilityKotlinExtentionsKt.i(5);
        r112.right += UtilityKotlinExtentionsKt.i(5);
        r112.bottom += UtilityKotlinExtentionsKt.i(5);
        View r107 = r106.f137305e;
        if (r107 == null) goto L21;
        View r108 = r106.f137305e;
        if (r108 == null) goto L19;
        ViewGroup r109 = UtilityKotlinExtentionsKt.p(r108);
    L20:
        r107.setTouchDelegate(new TouchDelegate(r112, r109));
        goto L21
    L19:
        r109 = null;
    L21:
        View r113 = r106.f137304d;
        if (r113 == null) goto L29;
        View r114 = r106.f137304d;
        if (r114 == null) goto L26;
        ViewGroup r115 = UtilityKotlinExtentionsKt.p(r114);
    L27:
        r113.setTouchDelegate(new TouchDelegate(r112, r115));
        goto L29
    L26:
        r115 = null;
    L29:
        if (nq1.b.f520090a.getValue().booleanValue() == false) goto L46;
        TextView r116 = r106.f137308h;
        if (r116 == null) goto L37;
        TextView r117 = r106.f137308h;
        if (r117 == null) goto L35;
        ViewGroup r118 = UtilityKotlinExtentionsKt.p(r117);
    L36:
        r116.setTouchDelegate(new TouchDelegate(r112, r118));
        goto L37
    L35:
        r118 = null;
    L37:
        TextView r119 = r106.f137308h;
        if (r119 == null) goto L40;
        r119.setOnClickListener(x0.a(new VSMsgBoardPortraitControlSectionProvider$ControlSectionController$init$2(r106)));
    L40:
        TextView r120 = r106.f137308h;
        if (r120 == null) goto L43;
        r120.setVisibility(0);
    L43:
        ImageView r121 = r106.f137309i;
        if (r121 == null) goto L62;
        r121.setVisibility(8);
    L62:
        View r122 = r106.f137305e;
        if (r122 == null) goto L65;
        r122.setOnClickListener(new k(r106));
    L65:
        int r123 = n82.c.f518247a;
        k82.a r124 = r106.f137314n.f137299a;
        if (r124 == null) goto L70;
        t9 r125 = r124.s();
        if (r125 == null) goto L70;
        DataCenter r126 = r125.f114228l;
    L72:
        if (n82.c.d(r126) == false) goto L166;
        View r127 = r106.f137304d;
        if (r127 == null) goto L76;
        UtilityKotlinExtentionsKt.z(r127, true);
    L76:
        k82.a r128 = r106.f137314n.f137299a;
        if (r128 == null) goto L81;
        t9 r129 = r128.s();
        if (r129 == null) goto L81;
        DataCenter r130 = r129.f114228l;
    L82:
        nm1.e r131 = pm1.f.c();
        if (r131 == null) goto L87;
        ReplayDataContext r132 = r131.h(null);
        if (r132 == null) goto L87;
        com.bytedance.live.datacontext.j<Object> r133 = r132.getVsMsgBoardDataContext();
    L89:
        if ((r133 instanceof com.bytedance.live.datacontext.j) == true) goto L91;
        r133 = null;
    L91:
        if (r133 == null) goto L94;
        com.bytedance.android.livesdk.chatroom.msgboard.a r134 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r133.getValue();
        if (r134 == null) goto L94;
    L102:
        if (r134 == null) goto L106;
        IRoom r135 = r134.getRoom();
        if (r135 == null) goto L106;
        String r136 = r135.getIdStr();
    L108:
        if (TextUtils.isEmpty(r136) == true) goto L125;
        if (r134 == null) goto L113;
        IRoom r137 = r134.getRoom();
        if (r137 == null) goto L113;
        String r138 = r137.getIdStr();
    L115:
        if (TextUtils.isEmpty(r138) == true) goto L149;
        HashSet<Object> r139 = nq1.d.f520115x.getValue();
        if (r139 == null) goto L125;
        if (r134 == null) goto L122;
        IRoom r140 = r134.getRoom();
        if (r140 == null) goto L122;
        String r141 = r140.getIdStr();
    L124:
        if (r139.contains(r141) == true) goto L149;
    L122:
        r141 = null;
    L149:
        boolean r142 = false;
    L151:
        if (r142 == false) goto L159;
        ImageView r143 = r106.f137307g;
        if (r143 == null) goto L155;
        UtilityKotlinExtentionsKt.z(r143, true);
    L155:
        int r144 = l82.a.f507909a;
        k82.a r145 = r106.f137314n.f137299a;
        if (r145 == null) goto L158;
        r101 = r145.o();
    L158:
        l82.a.b(true, r101);
    L172:
        k82.a r146 = r106.f137314n.f137299a;
        if (r146 == null) goto L187;
        t9 r147 = r146.s();
        if (r147 == null) goto L187;
        if (r147.f114232p != true) goto L187;
        ImageView r148 = r106.f137307g;
        if (r148 == null) goto L181;
        UtilityKotlinExtentionsKt.z(r148, false);
    L181:
        ImageView r149 = r106.f137306f;
        if (r149 == null) goto L184;
        r149.setAlpha(0.5f);
    L184:
        View r150 = r106.f137304d;
        if (r150 == null) goto L196;
        r150.setOnClickListener(l.f137317a);
    L196:
        ImageView r151 = r106.f137310j;
        if (r151 == null) goto L199;
        r151.setOnClickListener(new n(r106));
    L199:
        k82.a r152 = r106.f137314n.f137299a;
        if (r152 == null) goto L202;
        r152.y(new o(r106));
    L202:
        r3.a(r106.f137303c, s1.B(R.string.ttlive_a11y_keyboard_emoji));
        r3.a(r106.f137309i, s1.B(R.string.ttlive_a11y_keyboard_send));
        r3.a(r106.f137308h, s1.B(R.string.ttlive_a11y_keyboard_send));
        r3.a(r106.f137310j, s1.B(R.string.ttlive_a11y_delete));
        Unit r153 = Unit.INSTANCE;
        this.f137300b = r106;
        return r105;
    L187:
        ImageView r154 = r106.f137307g;
        if (r154 == null) goto L190;
        r154.setBackgroundResource(R.drawable.ttlive_ic_red_point_tip_skin);
    L190:
        View r155 = r106.f137304d;
        if (r155 == null) goto L193;
        r155.setOnClickListener(new m(r106));
    L193:
        ImageView r156 = r106.f137306f;
        if (r156 == null) goto L196;
        r156.setAlpha(1.0f);
        goto L196
    L159:
        ImageView r157 = r106.f137307g;
        if (r157 == null) goto L162;
        UtilityKotlinExtentionsKt.z(r157, false);
    L162:
        int r158 = l82.a.f507909a;
        k82.a r159 = r106.f137314n.f137299a;
        if (r159 == null) goto L165;
        r101 = r159.o();
    L165:
        l82.a.b(false, r101);
    L113:
        r138 = null;
    L125:
        if (r134 == null) goto L129;
        Episode r160 = r134.getEpisode();
        if (r160 == null) goto L129;
        String r161 = r160.idStr;
    L131:
        if (TextUtils.isEmpty(r161) == true) goto L150;
        if (r134 == null) goto L136;
        Episode r162 = r134.getEpisode();
        if (r162 == null) goto L136;
        String r163 = r162.idStr;
    L138:
        if (TextUtils.isEmpty(r163) == true) goto L149;
        HashSet<Object> r164 = nq1.d.f520115x.getValue();
        if (r164 == null) goto L150;
        if (r134 == null) goto L145;
        Episode r165 = r134.getEpisode();
        if (r165 == null) goto L145;
        String r166 = r165.idStr;
    L147:
        if (r164.contains(r166) == true) goto L149;
    L145:
        r166 = null;
    L136:
        r163 = null;
    L150:
        r142 = true;
    L129:
        r161 = null;
    L106:
        r136 = null;
    L94:
        vr1.u r167 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r130, null, 2);
        if (r167 == null) goto L97;
        com.bytedance.android.livesdk.chatroom.msgboard.a r168 = r167.L0();
    L99:
        if ((r168 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L101;
        r134 = null;
        goto L102
    L101:
        r134 = r168;
        goto L102
    L97:
        r168 = null;
    L87:
        r133 = null;
    L81:
        r130 = null;
        goto L82
    L166:
        View r169 = r106.f137304d;
        if (r169 == null) goto L169;
        UtilityKotlinExtentionsKt.z(r169, false);
    L169:
        ImageView r170 = r106.f137307g;
        if (r170 == null) goto L172;
        UtilityKotlinExtentionsKt.z(r170, false);
    L70:
        r126 = null;
        goto L72
    L46:
        ImageView r171 = r106.f137309i;
        if (r171 == null) goto L53;
        ImageView r172 = r106.f137309i;
        if (r172 == null) goto L51;
        ViewGroup r173 = UtilityKotlinExtentionsKt.p(r172);
    L52:
        r171.setTouchDelegate(new TouchDelegate(r112, r173));
        goto L53
    L51:
        r173 = null;
    L53:
        ImageView r174 = r106.f137309i;
        if (r174 == null) goto L56;
        r174.setOnClickListener(x0.a(new VSMsgBoardPortraitControlSectionProvider$ControlSectionController$init$3(r106)));
    L56:
        TextView r175 = r106.f137308h;
        if (r175 == null) goto L59;
        r175.setVisibility(8);
    L59:
        ImageView r176 = r106.f137309i;
        if (r176 == null) goto L62;
        r176.setVisibility(0);
        goto L62
    L11:
        if (r103.f114224h != true) goto L13;
    L12:
        r104 = R.layout.ttlive_view_input_control_vs;
        goto L14
    L8:
        if (r103.f114223g == true) goto L12;
        goto L9
    }

    @Override // k82.d
    public final void h(VSInputSectionType r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionType");
        Intrinsics.checkNotNullParameter(r101, "view");
        k82.d.a.a(r100, r101);
        int r102 = p.f137321a[r100.ordinal()];
        if (r102 != 1) goto L5;
        FrameLayout r103 = (FrameLayout) r101.findViewById(R.id.control_emoji_container);
        if (r103 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r103);
        return;
    L16:
        return;
    L5:
        if (r102 != 2) goto L17;
        FrameLayout r104 = (FrameLayout) r101.findViewById(R.id.control_skin_container);
        if (r104 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r104);
        return;
    L14:
        return;
    }
}
