package com.obric.autogui.operator.a.b.a.b.b;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.common.api.virtualdisplay.VDTrackingApp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AlreadyOpenedPreCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {
    private static final String TAG = "PreChk/AlreadyOpened";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0760a f29478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29480c;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a.b.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlreadyOpenedPreCheck.kt */
    public static final class C0760a {
        public /* synthetic */ C0760a(h r1) {
            this();
        }

        private C0760a() {
        }
    }

    static {
        f29478a = new C0760a(null);
    }

    public a(String r1, String r2) {
        this.f29479b = r1;
        this.f29480c = r2;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b.b
    public com.obric.autogui.operator.a.b.a.c a(Context r13) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin"), "context");
        String r7 = this.f29479b;
        if (r7 == null) goto L15;
        com.obric.autogui.common.d<VDTrackingApp> r0 = AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp();
        if (r0.g() == true) goto L7;
        Loog.INSTANCE.w(TAG, "ignored opening-check for `" + r7 + '/' + this.f29480c + "` - current VD component is null or not fetchable (" + r0 + ").");
        goto L15
    L7:
        VDTrackingApp r12 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(r0.a(), VDTrackingApp.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L10;
        String r14 = r12.getPackageName();
    L12:
        if (o.a(r14, r7) == false) goto L15;
        Loog.INSTANCE.w(TAG, "ignored opening `" + r7 + "` as its package is already opened.");
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.k, null, null, null, r7, false, null, 110, null);
    L10:
        r14 = null;
    L15:
        return null;
    }
}
