package com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a;

import android.net.Uri;
import com.obric.aiagent.platform.depend.ILogDepend;
import d.h.b.o;

/* JADX INFO: compiled from: SharingRecordChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18416a;

    public c() {
        this.f18416a = "SharingRecordChecker";
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.a.a
    public boolean a(d r4, String r5, Uri r6) {
        o.e(r4, "requester");
        o.e(r5, "sharerPackage");
        o.e(r6, "uri");
        if (com.obric.aiagent.executionengine.utils.c.a(r4.a()) == false) goto L6;
        boolean r7 = com.obric.aiagent.executionengine.scheduler.impl.execution.b.c.f18403a.c(new com.obric.aiagent.executionengine.scheduler.impl.execution.b.a(r5, r6, r4.a()));
        ILogDepend.Companion.i(this.f18416a, "SharingRecordChecker whitelist: [" + r4.a() + "] --> " + r6 + " (" + r7 + ')');
        return r7;
    L6:
        return false;
    }
}
