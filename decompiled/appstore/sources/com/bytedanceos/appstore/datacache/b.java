package com.bytedanceos.appstore.datacache;

import android.os.Bundle;
import androidx.core.os.c;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final Bundle a(com.smt.obric.appstore.domain.app.entity.a r12) {
        q.g(r12, "<this>");
        return c.a(new Pair[]{d.a("auto_update_progress", Integer.valueOf((int) r12.q())), d.a("auto_update_install_mode", Integer.valueOf(r12.C().getOrdinal())), d.a("auto_update_model", Integer.valueOf(r12.I())), d.a("useMobile", Boolean.valueOf(!r12.w())), d.a("auto_update_md5", r12.x()), d.a("auto_update_pkg", r12.E()), d.a("auto_update_version_code", Long.valueOf(r12.J())), d.a("auto_update_url", r12.t()), d.a("auto_update_name", r12.f()), d.a("auto_update_size", Long.valueOf(r12.H()))});
    }
}
