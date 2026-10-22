package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.b;

/* JADX INFO: loaded from: classes12.dex */
public final class n<STATE extends v43.b, PROPS extends u33.a> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164259b;

    @Override // m33.a
    public final String d() {
        return this.f164259b;
    }

    public n(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164259b = "selfLoading";
    }

    @Override // m33.a
    public final void e(e43.a r110) {
        Intrinsics.checkNotNullParameter(r110, "eventData");
        Map<String, Object> r100 = r110.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get(ForwardDependency$ForwardLocation.FLAG);
    L7:
        if ((r102 instanceof Boolean) == false) goto L10;
        r101 = r102;
    L10:
        Boolean r103 = (Boolean) r101;
        if (r103 == null) goto L13;
        boolean r104 = r103.booleanValue();
    L14:
        if (r104 == false) goto L16;
        ((v43.b) this.f511708a.f507247a).a().c(new y43.a(true, false, true, true, 18));
    L17:
        r110.d(new m33.c(true, null, false, null, 30));
        return;
    L16:
        ((v43.b) this.f511708a.f507247a).a().c(new y43.a(false, false, false, false, 30));
        goto L17
    L13:
        r104 = false;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
