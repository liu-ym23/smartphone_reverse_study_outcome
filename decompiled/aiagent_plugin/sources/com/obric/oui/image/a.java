package com.obric.oui.image;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OImageStyleHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum a extends Enum<a> {
    private static final String TAG = "OImageStyleHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0956a f35288a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f35289b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f35290c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ a[] f35291e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35292d;

    /* JADX INFO: renamed from: com.obric.oui.image.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OImageStyleHelper.kt */
    public static final class C0956a {
        public /* synthetic */ C0956a(h r1) {
            this();
        }

        private C0956a() {
        }

        public final a a(int r7) {
            a[] r0 = a.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            a r4 = r0[r3];
            if (r4.a() != r7) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 != null) goto L17;
            C0956a r6 = (C0956a) ZeusTransformUtils.preCheckCast(this, C0956a.class, "com.obric.aiagent.plugin");
            a(a.TAG, "Unknown oui_imageShape value=" + r7 + ", fallback to STANDARD");
            return a.f35289b;
        L17:
            return r4;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    private static final /* synthetic */ a[] b() {
        return new a[]{f35289b, f35290c};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f35291e.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f35292d = r3;
    }

    public final int a() {
        return this.f35292d;
    }

    static {
        f35289b = new a("STANDARD", 0, 0);
        f35290c = new a("ROUNDED", 1, 1);
        f35291e = b();
        f35288a = new C0956a(null);
    }
}
