package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: classes8.dex */
public final class SmallWindowItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f116744a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f116749a = 0;

        static {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f116750a = 0;

        static {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f116751a = 0;

        static {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f116752a = null;

        public d() {
        }

        static {
            f116752a = new d();
        }

        public static final void a(d r100, View r101, TextView r102, LiveSwitchButton r103, boolean r104) {
            r100.getClass();
            r3.n(r103);
            if (r101 == null) goto L5;
            r101.setOnClickListener(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.b(r103));
        L5:
            r101.setImportantForAccessibility(1);
            StringBuilder r105 = new StringBuilder();
            if (r102 == null) goto L11;
            CharSequence r106 = r102.getText();
            if (r106 == null) goto L11;
            String r107 = r106.toString();
            if (r107 == null) goto L11;
        L12:
            r105.append(r107);
            r105.append(" ");
            if (r104 == false) goto L15;
            String r108 = "开启";
        L16:
            r105.append(r108);
            r101.setContentDescription(r105.toString());
            return;
        L15:
            r108 = "关闭";
        L11:
            r107 = s1.B(R.string.ttlive_float_window_setting_scene_desc);
            goto L12
        }
    }

    static {
    }

    public static np1.b a(final np1.c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        DataCenter r101 = r100.getDataCenter();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L11:
        if (r102 == true) goto L14;
        return null;
    L14:
        np1.b.a r103 = np1.b.f520007a;
        Function0<g> r104 = new SmallWindowItem$provide$1(r100);
        SmallWindowItem$provide$2 r105 = SmallWindowItem$provide$2.INSTANCE;
        r103.getClass();
        return np1.b.a.a(r104, r105);
    L5:
        if (z.e(r101, false) == true) goto L11;
        if (z.m(r101, true) == false) goto L11;
        if (p.c() == false) goto L11;
        r102 = true;
        goto L11
    }
}
