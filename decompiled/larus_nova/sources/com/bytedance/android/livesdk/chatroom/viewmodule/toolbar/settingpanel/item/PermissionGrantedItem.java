package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.e5;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.utils.z2;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: classes8.dex */
public final class PermissionGrantedItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f116720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qk1.a f116721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReceiveGiftOpt f116722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AnchorRelationShipOpt f116723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final np1.c f116724e;

    public final class AnchorRelationShipOpt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f116725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PermissionGrantedItem f116726b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LiveSwitchButton f116727a;

            public a(LiveSwitchButton r100) {
                this.f116727a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                if (r3.l(r100.getContext()) == false) goto L8;
                LiveSwitchButton r101 = this.f116727a;
                if (r101 == null) goto L9;
                r101.performClick();
                return;
            L9:
                return;
            }
        }

        public AnchorRelationShipOpt(PermissionGrantedItem r100) {
            this.f116726b = r100;
        }

        public final void b(long r100) {
            if (this.f116726b.f116720a == true) goto L5;
            return;
        L5:
            View r101 = this.f116725a;
            if (r101 == null) goto L8;
            RelativeLayout r102 = (RelativeLayout) r101.findViewById(R.id.allow_anchor_see_history_about_me);
        L8:
            View r103 = this.f116725a;
            if (r103 == null) goto L11;
            final LiveSwitchButton r104 = (LiveSwitchButton) r103.findViewById(R.id.allow_anchor_see_history_about_me_switch);
        L12:
            int r105 = b1.f158888a;
            boolean r106 = true;
            b1.b(true, new PermissionGrantedItem$AnchorRelationShipOpt$updateAnchorRelation$1(this, r104));
            e<Long> r107 = com.bytedance.android.livesdk.sharedpref.b.f158146f3;
            Long r108 = Long.valueOf(r100);
            r107.getClass();
            f.d(r107, r108);
            if (r100 == 1) goto L16;
            r106 = false;
        L16:
            if (r104 == null) goto L18;
            r104.setChecked(r106);
        L18:
            a(r104, r106);
            if (r104 == null) goto L22;
            r104.setOnClickListener(new PermissionGrantedItem$AnchorRelationShipOpt$updateAnchorRelation$2(this, r104));
            return;
        L22:
            return;
        L11:
            r104 = null;
            goto L12
        }

        public final void a(LiveSwitchButton r100, boolean r101) {
            r3.n(r100);
            View r102 = this.f116725a;
            if (r102 == null) goto L5;
            r102.setOnClickListener(new a(r100));
        L5:
            View r103 = this.f116725a;
            if (r103 == null) goto L8;
            r103.setImportantForAccessibility(1);
        L8:
            View r104 = this.f116725a;
            if (r104 == null) goto L16;
            TextView r105 = (TextView) r104.findViewById(R.id.allow_anchor_see_history_about_me_title);
            if (r105 == null) goto L16;
            CharSequence r106 = r105.getText();
            if (r106 == null) goto L16;
            String r107 = r106.toString();
            if (r107 == null) goto L16;
        L17:
            if (r101 == false) goto L19;
            String r108 = "开启";
        L20:
            View r109 = this.f116725a;
            if (r109 == null) goto L24;
            r109.setContentDescription(r107 + ' ' + r108);
            return;
        L24:
            return;
        L19:
            r108 = "关闭";
        L16:
            r107 = s1.B(R.string.ttlive_anchor_see_history_about_me_title);
            goto L17
        }
    }

    public final class ReceiveGiftOpt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f116731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PermissionGrantedItem f116732b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LiveSwitchButton f116733a;

            public a(LiveSwitchButton r100) {
                this.f116733a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                if (r3.l(r100.getContext()) == false) goto L8;
                LiveSwitchButton r101 = this.f116733a;
                if (r101 == null) goto L9;
                r101.performClick();
                return;
            L9:
                return;
            }
        }

        public static final class b implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ReceiveGiftOpt f116734a;

            public b(ReceiveGiftOpt r100) {
                this.f116734a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f116734a.f116732b.f116724e.closeSettingPanel();
                Context r101 = this.f116734a.f116732b.f116724e.getContext();
                if (r101 == null) goto L6;
                e5.b(r101);
                return;
            }
        }

        public static final class c implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ReceiveGiftOpt f116735a;

            public c(ReceiveGiftOpt r100) {
                this.f116735a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f116735a.f116732b.f116724e.closeSettingPanel();
                Activity r101 = z2.f159233b.getActivity();
                if (r101 == null) goto L6;
                e5.a(r101);
                return;
            }
        }

        public ReceiveGiftOpt(PermissionGrantedItem r100) {
            this.f116732b = r100;
        }

        public final void b(long r110) {
            View r100 = this.f116731a;
            CharSequence r101 = null;
            if (r100 == null) goto L5;
            final LiveSwitchButton r102 = (LiveSwitchButton) r100.findViewById(R.id.allow_receive_gift_switch);
        L6:
            View r103 = this.f116731a;
            if (r103 == null) goto L9;
            TextView r104 = (TextView) r103.findViewById(R.id.allow_receive_gift_desc);
        L10:
            View r105 = this.f116731a;
            if (r105 == null) goto L13;
            RelativeLayout r106 = (RelativeLayout) r105.findViewById(R.id.allow_receive_invalid_layout);
        L14:
            View r107 = this.f116731a;
            if (r107 == null) goto L17;
            LinearLayout r108 = (LinearLayout) r107.findViewById(R.id.verify_layout);
        L18:
            View r109 = this.f116731a;
            if (r109 == null) goto L21;
            TextView r111 = (TextView) r109.findViewById(R.id.allow_receive_invalid_desc);
        L22:
            Boolean r112 = com.bytedance.android.livesdk.sharedpref.b.f158141e3.getValue();
            if (r102 == null) goto L26;
            r102.setChecked(r112.booleanValue());
        L26:
            if (r102 != null) goto L28;
        L33:
            a(r102, r112.booleanValue());
            if (r102 == null) goto L37;
            r102.setOnClickListener(new PermissionGrantedItem$ReceiveGiftOpt$updateUserGiftUI$1(this, r102));
        L37:
            if (r110 != 5) goto L49;
            if (r106 == null) goto L40;
            r106.setVisibility(0);
        L40:
            if (r104 == null) goto L42;
            r104.setVisibility(8);
        L42:
            if (r111 == null) goto L44;
            r111.setVisibility(0);
        L44:
            if (r111 == null) goto L46;
            r111.setText(s1.B(R.string.ttlive_allow_receive_gift_invalid_desc));
        L46:
            if (r108 == null) goto L66;
            r108.setOnClickListener(new b(this));
        L66:
            if (r106 != null) goto L68;
        L71:
            int r113 = b1.f158888a;
            b1.b(true, new PermissionGrantedItem$ReceiveGiftOpt$updateUserGiftUI$4(this));
            return;
        L68:
            if (r111 == null) goto L70;
            r101 = r111.getText();
        L70:
            r106.setContentDescription(String.valueOf(r101).concat("去认证"));
            goto L71
        L49:
            if (r110 != 7) goto L60;
            if (r106 == null) goto L52;
            r106.setVisibility(0);
        L52:
            if (r104 == null) goto L54;
            r104.setVisibility(8);
        L54:
            if (r111 == null) goto L56;
            r111.setVisibility(0);
        L56:
            if (r111 == null) goto L58;
            r111.setText(s1.B(R.string.ttlive_allow_receive_gift_need_face_detect));
        L58:
            if (r108 == null) goto L66;
            r108.setOnClickListener(new c(this));
            goto L66
        L60:
            if (r106 == null) goto L62;
            r106.setVisibility(8);
        L62:
            if (r104 == null) goto L64;
            r104.setVisibility(0);
        L64:
            if (r111 == null) goto L66;
            r111.setVisibility(8);
            goto L66
        L28:
            if (r102.isChecked() != true) goto L33;
            if (r106 == null) goto L31;
            r106.setVisibility(8);
        L31:
            if (r104 == null) goto L33;
            r104.setVisibility(0);
            goto L33
        L21:
            r111 = null;
            goto L22
        L17:
            r108 = null;
            goto L18
        L13:
            r106 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        public final void a(LiveSwitchButton r100, boolean r101) {
            r3.n(r100);
            View r102 = this.f116731a;
            if (r102 == null) goto L5;
            r102.setOnClickListener(new a(r100));
        L5:
            View r103 = this.f116731a;
            if (r103 == null) goto L8;
            r103.setImportantForAccessibility(1);
        L8:
            View r104 = this.f116731a;
            if (r104 == null) goto L16;
            TextView r105 = (TextView) r104.findViewById(R.id.allow_receive_gift_title);
            if (r105 == null) goto L16;
            CharSequence r106 = r105.getText();
            if (r106 == null) goto L16;
            String r107 = r106.toString();
            if (r107 == null) goto L16;
        L17:
            if (r101 == false) goto L19;
            String r108 = "开启";
        L20:
            View r109 = this.f116731a;
            if (r109 == null) goto L24;
            r109.setContentDescription(r107 + ' ' + r108);
            return;
        L24:
            return;
        L19:
            r108 = "关闭";
        L16:
            r107 = s1.B(R.string.ttlive_allow_receive_gift_title);
            goto L17
        }
    }

    public PermissionGrantedItem(np1.c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelCtx");
        this.f116724e = r100;
        this.f116720a = true;
        this.f116722c = new ReceiveGiftOpt(this);
        this.f116723d = new AnchorRelationShipOpt(this);
    }

    public final np1.b a(final np1.c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        if ((!VrUtils.w(r100.getDataCenter())) == true) goto L5;
        return null;
    L5:
        np1.b.a r101 = np1.b.f520007a;
        Function0<g> r102 = new PermissionGrantedItem$provide$1(r100);
        Function1<g, Unit> r103 = new PermissionGrantedItem$provide$2(this);
        r101.getClass();
        return np1.b.a.a(r102, r103);
    }
}
