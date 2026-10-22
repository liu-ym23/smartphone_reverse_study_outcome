package com.obric.aiagent.privacy;

import android.app.Application;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import java.io.File;

/* JADX INFO: compiled from: PrivacyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18762a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f18763b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final File f18764c = null;

    /* JADX INFO: renamed from: lambda$E2l0dfzPkpQEZm42vXRNr-2Uzs4, reason: not valid java name */
    public static /* synthetic */ Application m202lambda$E2l0dfzPkpQEZm42vXRNr2Uzs4() {
        return e();
    }

    private a() {
    }

    static {
        a r0 = new a();
        f18762a = r0;
        f18763b = g.a($$Lambda$a$E2l0dfzPkpQEZm42vXRNr2Uzs4.INSTANCE);
        f18764c = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.d(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "privacy_agreed");
    }

    private final Application d() {
        return (Application) ZeusTransformUtils.preCheckCast(f18763b.b(), Application.class, "com.obric.aiagent.plugin");
    }

    private static final Application e() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    public final void a() {
        File r1 = f18764c;
        if (r1.exists() == true) goto L6;
        r1.createNewFile();
        return;
    }

    public final void b() {
        File r1 = f18764c;
        if (r1.exists() == false) goto L6;
        r1.delete();
        return;
    }

    public final boolean c() {
        return f18764c.exists();
    }
}
