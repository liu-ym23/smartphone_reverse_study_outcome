package com.obric.oui.common;

import com.obric.oui.OUISdk;
import com.obric.oui.d.a.b;
import d.h.b.h;

/* JADX INFO: compiled from: SdkInit.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0936a f34510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f34511b;

    /* JADX INFO: renamed from: com.obric.oui.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SdkInit.kt */
    public static final class C0936a {
        public /* synthetic */ C0936a(h r1) {
            this();
        }

        private C0936a() {
        }
    }

    static {
        f34510a = new C0936a(null);
    }

    public a() {
        if (f34511b != 0) goto L5;
        b.b("SDK_INIT", "BUILD_NO: [20260902-17:21:09|release|2.0.1|ca138430|20260902-17:15:44_feature: update OUI_Bg_Ring effect]");
        OUISdk.INSTANCE.init();
    L5:
        f34511b++;
    }
}
