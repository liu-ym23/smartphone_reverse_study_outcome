package com.obric.oui.badge;

import android.graphics.Rect;
import android.view.View;
import bg.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ OBadgeDrawable $badge;
    final /* synthetic */ View $host;

    public OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1(OBadgeDrawable r10, View r11, View r12) {
        this.$badge = r10;
        this.$anchor = r11;
        this.$host = r12;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$badge.r(this.$anchor, this.$host);
        Rect r10 = this.$badge.getBounds();
        q.f(r10, "badge.bounds");
        int r11 = this.$host.getHeight();
        int r12 = Math.max(h.d(-r10.top, 0), h.d(r10.bottom - r11, 0));
        if (r12 <= 0) goto L6;
        OBadgeDrawable r13 = this.$badge;
        r13.p(r13.d() + r12);
        this.$badge.r(this.$anchor, this.$host);
        return;
    }
}
