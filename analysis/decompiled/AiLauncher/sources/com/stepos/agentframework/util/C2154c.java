package com.stepos.agentframework.util;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\t\u001a\u00020\u0007*\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"", "spaceTime", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Long;)Z", "Landroid/view/View;", "Lkotlin/Function1;", "LY8/t;", "c", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;Lp9/l;)V", "lastClickTime", "J", "globalPaddingClickTime", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.util.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2154c {
    private static final long globalPaddingClickTime = 120;
    private static long lastClickTime;

    public static final boolean a(Long l10) {
        long jLongValue = l10 != null ? l10.longValue() : 120L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime < jLongValue) {
            return false;
        }
        lastClickTime = jCurrentTimeMillis;
        return true;
    }

    public static final void b(View view, InterfaceC5074l<? super View, Y8.t> c10) {
        kotlin.jvm.internal.p.i(view, "<this>");
        kotlin.jvm.internal.p.i(c10, "c");
        view.setOnClickListener(new B(120L, c10));
    }
}
