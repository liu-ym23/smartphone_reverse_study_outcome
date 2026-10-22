package com.obric.autogui.platforms.miui.a;

import com.obric.autogui.platforms.miui.a.a.c;
import com.obric.autogui.platforms.tools.security.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;

/* JADX INFO: compiled from: MiuiSecurityApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    private static final String TAG = "GRSecurityApi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0783a f29957a = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.miui.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MiuiSecurityApiImpl.kt */
    public static final class C0783a {
        public /* synthetic */ C0783a(h r1) {
            this();
        }

        private C0783a() {
        }
    }

    static {
        f29957a = new C0783a(null);
    }

    public a() {
    }

    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public Object checkVirus(String r2, d<? super Boolean> r3) {
        d<? super Boolean> r1 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return c.f30002a.a(r2, r1);
    }
}
