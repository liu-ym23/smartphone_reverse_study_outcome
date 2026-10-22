package com.bytedance.android.livesdk.revenue.service.ui;

import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RevCardWindow f157485a;

    @Override // com.bytedance.android.livesdk.revenue.service.ui.b
    public final void dismiss() {
        this.f157485a.dismiss();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.ui.b
    public final void show() {
        this.f157485a.show();
    }

    public f(RevCardWindow r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f157485a = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.ui.b
    public final void a(aq2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "revCardConfig");
        RevCardWindow r101 = this.f157485a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "revCardConfig");
        r101.f157484s = r100;
        aq2.c r102 = r101.f157484s.f15880a;
        CardConstraint r103 = new CardConstraint(r102.f15888a, r102.f15889b);
        aq2.b r104 = r100.f15881b;
        r103.f98975b = r104.f15884a;
        r103.f98976c = r104.f15885b;
        r103.f98977d = r104.f15886c;
        r103.f98978e = r104.f15887d;
        Unit r105 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f157479n = r103;
        r101.s(r103);
    }

    public final void b(uy1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        RevCardWindow r101 = this.f157485a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) r101.f157478m).contains(r100) == true) goto L6;
        ((ArrayList) r101.f157478m).add(r100);
        return;
    }
}
