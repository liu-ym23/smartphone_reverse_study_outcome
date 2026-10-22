package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.message.model.va;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f136787a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(k32.a r100) {
        va.a r101 = r100.f501694k;
        if (r101 == null) goto L18;
        py.k r102 = r101.getTextIcon();
        if (r102 == null) goto L21;
        va.a r103 = r100.f501694k;
        if (r103 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L19;
        int r105 = t72.a.f544877a;
        if (TextUtils.isEmpty(t72.a.C7692a.a(r102)) == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L10:
        if (r103.getType() != 3) goto L12;
        r104 = true;
        goto L13
    L21:
        return false;
    L18:
        return false;
    }
}
