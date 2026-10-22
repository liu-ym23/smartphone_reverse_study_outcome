package com.obric.autogui.platforms.obric.d.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: VirusCheckProviderClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "O-VirusCheck-Provider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30084a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Uri f30085c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f30086b;

    /* JADX INFO: compiled from: VirusCheckProviderClient.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f30086b = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    static {
        f30084a = new a(null);
        Uri r0 = Uri.parse("content://com.oceanos.security.viruscheck/apk");
        o.c(r0, "parse(...)");
        f30085c = r0;
    }

    public final com.obric.autogui.platforms.obric.d.a.a a(String r8) {
        o.e(r8, "packageName");
        Bundle r5 = new Bundle();
        r5.putString("pkg", r8);
        return a(ZeusProviderTransform.call(this.f30086b.getContentResolver(), f30085c, "checkApk", null, r5, "com.obric.aiagent.plugin"), "result bundle is null");
    L5:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "checkApk failed: " + e.getMessage());
        return new com.obric.autogui.platforms.obric.d.a.a(-1, null, null, "exception: " + e.getMessage());
    }

    private final com.obric.autogui.platforms.obric.d.a.a a(Bundle r9, String r10) {
        Integer r0 = null;
        if (r9 == null) goto L5;
        int r2 = r9.getInt("result", -1);
        if (r2 != 0) goto L9;
        String r3 = r9.getString("virusType");
        if (r9.containsKey("virusTypeCode") == false) goto L14;
        r0 = Integer.valueOf(r9.getInt("virusTypeCode"));
    L14:
        return new com.obric.autogui.platforms.obric.d.a.a(r2, r3, r0, null, 8, null);
    L9:
        return new com.obric.autogui.platforms.obric.d.a.a(r2, null, null, "provider resultCode=" + r2);
    L5:
        return new com.obric.autogui.platforms.obric.d.a.a(-1, null, null, r10);
    }
}
