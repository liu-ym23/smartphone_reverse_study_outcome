package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.app.Dialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements uu.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f57222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f57223d;

    public static final class a {
    }

    static {
    }

    public h() {
        Intrinsics.checkNotNullParameter("开启存储权限", "title");
        Intrinsics.checkNotNullParameter("你还没有开启存储权限，开启后即可保存图片", "content");
        Intrinsics.checkNotNullParameter("继续", "positiveTxt");
        Intrinsics.checkNotNullParameter("以后再说", "negativeText");
        this.f57220a = "开启存储权限";
        this.f57221b = "你还没有开启存储权限，开启后即可保存图片";
        this.f57222c = "继续";
        this.f57223d = "以后再说";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, android.app.Dialog] */
    @Override // uu.a
    public final void a(Activity r110, uu.b r111, String[] r112) {
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        r113.element = null;
        ?? r114 = com.bytedance.android.gamecp.host_api.a.b().getHostBusiness().i0(r110, this.f57220a, this.f57221b, this.f57222c, new i(r111, r113), this.f57223d, new j(r111, r113));
        r113.element = r114;
        if (r114 == 0) goto L5;
        r114.setOnCancelListener(new k(r111));
    L5:
        Dialog r115 = (Dialog) r113.element;
        if (r115 == null) goto L8;
        r115.setCancelable(true);
    L8:
        Dialog r116 = (Dialog) r113.element;
        if (r116 != null) goto L11;
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r116);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r116);
        r116.show();
        DialogLancet.afterDialogShow(r116);
    }
}
