package com.obric.oui.badge;

import android.view.View;

/* JADX INFO: compiled from: OBadgeAttachUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34011a = null;

    static {
        f34011a = new a();
    }

    private a() {
    }

    public static final /* synthetic */ boolean a(a r0, View r1) {
        return r0.a(r1);
    }

    private final boolean a(View r1) {
        if (r1.getWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.getHeight() <= 0) goto L7;
        return true;
    }
}
