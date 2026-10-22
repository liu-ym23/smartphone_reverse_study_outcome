package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class WelfareProjectCardAnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q4.b f117593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f117594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f117595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f117596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f117597e;

    public static final class a {
    }

    static {
    }

    public WelfareProjectCardAnimController(View r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onShow);
        Intrinsics.checkNotNullParameter(r102, "onDismiss");
        this.f117595c = r100;
        this.f117596d = r101;
        this.f117597e = r102;
    }

    public final void a(boolean r100, final int[] r101, final int r102) {
        Intrinsics.checkNotNullParameter(r101, "anchorViewPosition");
        final View r103 = this.f117595c;
        if (r103 != null) goto L5;
        return;
    L5:
        q4.b r104 = this.f117593a;
        if (r104 != null) goto L8;
    L13:
        if (r100 == false) goto L15;
        q4.b r105 = u4.c(new WelfareProjectCardAnimController$dismiss$1(this, r101, r103, r102));
        r105.c();
        this.f117593a = r105;
        return;
    L15:
        UtilityKotlinExtentionsKt.t(r103);
        this.f117597e.invoke();
        return;
    L8:
        if (r104.b() != true) goto L13;
        q4.b r106 = this.f117593a;
        if (r106 == null) goto L12;
        r106.a();
    L12:
        this.f117593a = null;
        goto L13
    }

    public final void b(boolean r100, final int[] r101, final int r102) {
        Intrinsics.checkNotNullParameter(r101, "anchorViewPosition");
        final View r103 = this.f117595c;
        if (r103 != null) goto L5;
        return;
    L5:
        q4.b r104 = this.f117593a;
        if (r104 != null) goto L8;
    L13:
        UtilityKotlinExtentionsKt.w(r103);
        if (r100 == false) goto L16;
        q4.b r105 = u4.c(new WelfareProjectCardAnimController$show$controller$1(this, r101, r103, r102));
        this.f117593a = r105;
        ConcurrentHashMap<String, q4.b> r106 = q4.c.f159141a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        Intrinsics.checkNotNullParameter(r105, "controller");
        q4.c.f159141a.put("WelfareCardShow", r105);
        this.f117596d.invoke();
        return;
    L16:
        ConcurrentHashMap<String, q4.b> r107 = q4.c.f159141a;
        Intrinsics.checkNotNullParameter("WelfareCardShow", "key");
        q4.c.f159141a.remove("WelfareCardShow");
        r103.setScaleX(1.0f);
        r103.setScaleY(1.0f);
        r103.setAlpha(1.0f);
        this.f117596d.invoke();
        return;
    L8:
        if (r104.b() != true) goto L13;
        q4.b r108 = this.f117593a;
        if (r108 == null) goto L12;
        r108.a();
    L12:
        this.f117593a = null;
        goto L13
    }
}
