package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ViewModelProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class an {
    public static final androidx.lifecycle.a.a a(ap r2) {
        ap r3 = (ap) ZeusTransformUtils.wrapperContextForParams(r2, ap.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "owner");
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L6;
        return ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).getDefaultViewModelCreationExtras();
    L6:
        return (androidx.lifecycle.a.a) ZeusTransformUtils.preCheckCast(androidx.lifecycle.a.a.C0057a.f1967a, androidx.lifecycle.a.a.class, "com.obric.aiagent.plugin");
    }
}
