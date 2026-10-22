package com.bytedance.applet.aibridge.navigation;

import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements com.larus.navigation.api.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<NavigationCardSessionState.a> f191347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f191348b;

    @Override // com.larus.navigation.api.p
    public final void a() {
        NavigationCardSessionState.a r100 = this.f191347a.invoke();
        if (r100 != null) goto L5;
        return;
    L5:
        NavigationMultitaskCard.f192208a.getClass();
        NavigationMultitaskCard.j("notification_removed", r100);
    }

    @Override // com.larus.navigation.api.p
    public final void c() {
        NavigationCardSessionState.a r100 = this.f191347a.invoke();
        if (r100 != null) goto L5;
        return;
    L5:
        NavigationMultitaskCard r101 = NavigationMultitaskCard.f192208a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "owner");
        if (NavigationMultitaskCard.f192212e.a(r100) == true) goto L8;
        return;
    L8:
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("nav_jsb_helper", "onNotificationClick: from=" + this.f191348b + ", delegating to NavigationMultitaskCard.openNavigationDetail(\"notification\", NOTIFICATION)");
        NavigationPageFrom r103 = NavigationPageFrom.NOTIFICATION;
        r101.getClass();
        NavigationMultitaskCard.e("notification", r103);
    }

    public m(Function0 r100) {
        this.f191347a = r100;
        this.f191348b = "realtime_active";
    }

    @Override // com.larus.navigation.api.p
    public final void b(String r100, String r101, Integer r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "title");
        if (r104 != null) goto L11;
        if (r102 == null) goto L6;
        String r106 = "res:///" + r102.intValue();
    L7:
        if (r106 != null) goto L10;
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        NavigationMultitaskCard r107 = NavigationMultitaskCard.f192208a;
        NavigationCardSessionState.a r108 = this.f191347a.invoke();
        if (r108 != null) goto L15;
        return;
    L15:
        NavigationMultitaskCard.b r109 = new NavigationMultitaskCard.b(r100, r101, r103, r105);
        r107.getClass();
        NavigationMultitaskCard.o(r108, r109, false);
        return;
    L10:
        r103 = r106;
        goto L12
    L6:
        r106 = null;
        goto L7
    L11:
        r103 = r104;
        goto L12
    }
}
