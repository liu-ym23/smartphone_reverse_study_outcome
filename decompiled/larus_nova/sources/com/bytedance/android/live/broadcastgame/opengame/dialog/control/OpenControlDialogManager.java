package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class OpenControlDialogManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, String> f60105c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.dialog.control.a f60106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f60107b;

    public static final class a {
    }

    static {
        f60105c = MapsKt.mapOf(new Pair[]{TuplesKt.to(3L, "adult"), TuplesKt.to(2L, "teen_within_regulated_time"), TuplesKt.to(1L, "")});
    }

    public void a() {
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r100 = this.f60106a;
        if (r100 == null) goto L6;
        r100.dismiss();
        return;
    }

    public void b() {
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r100 = this.f60106a;
        if (r100 == null) goto L6;
        r100.dismiss();
        return;
    }

    public final Context getContext() {
        return this.f60107b;
    }

    public OpenControlDialogManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f60107b = r100;
    }

    public final void c(com.bytedance.android.livesdk.wrds.interact.a.b r100, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "popBoxContent");
        if (r110 != null) goto L5;
        r110 = this.f60107b;
    L5:
        Integer r101 = r100.largeType;
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        String r103 = r100.f162524a;
        Integer r104 = null;
        if (r103 != null) goto L14;
    L22:
        Integer r105 = r100.largeType;
        if (r105 != null) goto L26;
    L28:
        if (r105 != null) goto L31;
        return;
    L31:
        if (r105.intValue() != 2) goto L100;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r106 = new OpenControlBottomDialog(r110);
    L33:
        this.f60106a = r106;
        Integer r111 = r100.iconType;
        if (r111 != null) goto L37;
    L39:
        if (r111 != null) goto L42;
    L44:
        if (r111 != null) goto L47;
    L49:
        Drawable r112 = null;
    L50:
        if (r112 == null) goto L54;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r107 = this.f60106a;
        if (r107 == null) goto L54;
        r107.setIcon(r112);
    L54:
        String r113 = r100.title;
        if (r113 == null) goto L59;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r108 = this.f60106a;
        if (r108 == null) goto L59;
        r108.setTitle(r113);
    L59:
        String r114 = r100.description;
        if (r114 == null) goto L64;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r109 = this.f60106a;
        if (r109 == null) goto L64;
        r109.setContent(r114);
    L64:
        String r115 = r100.url;
        if (r115 != null) goto L67;
    L77:
        Integer r116 = r100.countDownSec;
        if (r116 != null) goto L80;
    L88:
        String r117 = r100.buttonDesc;
        if (r117 == null) goto L93;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r118 = this.f60106a;
        if (r118 == null) goto L93;
        r118.y(r117);
    L93:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r119 = this.f60106a;
        if (r119 == null) goto L96;
        r119.v(new OpenControlDialogManager$processPopBoxContentAndShow$$inlined$apply$lambda$2(this));
    L96:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r120 = this.f60106a;
        if (r120 == null) goto L101;
        r120.show();
        return;
    L101:
        return;
    L80:
        if (r116.intValue() <= 0) goto L82;
        r102 = true;
    L82:
        if (r102 == false) goto L84;
        r104 = r116;
    L84:
        if (r104 == null) goto L88;
        int r121 = r104.intValue();
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r122 = this.f60106a;
        if (r122 == null) goto L88;
        r122.n0(r121, new OpenControlDialogManager$processPopBoxContentAndShow$$inlined$apply$lambda$1(this));
        goto L88
    L67:
        if (r115.length() <= 0) goto L69;
        boolean r123 = true;
    L70:
        if (r123 == true) goto L73;
        r115 = null;
    L73:
        if (r115 == null) goto L77;
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r124 = this.f60106a;
        if (r124 == null) goto L77;
        r124.F0(r115);
        goto L77
    L69:
        r123 = false;
        goto L70
    L47:
        if (r111.intValue() != 4) goto L49;
        r112 = s1.m(R.drawable.ttlive_icon_control_remind);
        goto L50
    L42:
        if (r111.intValue() != 3) goto L44;
        r112 = s1.m(R.drawable.ttlive_icon_control_alert);
        goto L50
    L37:
        if (r111.intValue() != 2) goto L39;
        r112 = s1.m(R.drawable.ttlive_ic_notice);
        goto L50
    L100:
        return;
    L26:
        if (r105.intValue() != 3) goto L28;
        r106 = new b(r110);
        goto L33
    L14:
        if (r103.length() <= 0) goto L16;
        boolean r125 = true;
    L17:
        if (r125 == true) goto L20;
        r103 = null;
    L20:
        if (r103 == null) goto L22;
        f2.c(r103, 0);
        goto L22
    L16:
        r125 = false;
        goto L17
    L9:
        if (r101.intValue() != 4) goto L11;
        f2.c(r100.description, 0);
        goto L11
    }
}
