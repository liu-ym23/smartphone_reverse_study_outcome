package com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a;

import android.app.Application;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: WhiteListChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f18421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Integer> f18422c;

    public e() {
        this.f18420a = "WhiteListChecker";
        this.f18421b = ax.a("com.larus.nova");
        this.f18422c = p.a(1000);
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a.a
    public boolean a(d r10, String r11, Uri r12) {
        o.e(r10, "requester");
        o.e(r11, "sharerPackage");
        o.e(r12, "uri");
        boolean r0 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        boolean r13 = this.f18421b.contains(r10.a());
        ILogDepend.Companion.i(this.f18420a, "package-name whitelist: [" + r10.a() + "] --> " + r12 + " (" + r13 + ')');
        return r13;
    L7:
        if (r10.b() < 0) goto L23;
        PackageManager r14 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.f18422c, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L11;
    L13:
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L12;
        if (r14.checkSignatures(((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.aiagent.plugin")).intValue(), r10.b()) != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
    L21:
        ILogDepend.Companion.i(this.f18420a, "UID whitelist: [uid:" + r10.b() + "] --> " + r12 + " (" + r0 + ')');
        return r0;
    L19:
        r8 = false;
    L12:
        r0 = false;
        goto L21
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
    L23:
        return false;
    }
}
