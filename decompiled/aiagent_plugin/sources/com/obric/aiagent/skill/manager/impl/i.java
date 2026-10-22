package com.obric.aiagent.skill.manager.impl;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricSkillPackageMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f20120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f20121b = null;

    private i() {
    }

    static {
        f20120a = new i();
        f20121b = new d.o.k("[A-Za-z0-9][A-Za-z0-9._-]{0,63}");
    }

    public final void a(String r3) {
        d.h.b.o.e(r3, "name");
        if (f20121b.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("Invalid CLI name.".toString());
    L5:
        if (d.h.b.o.a(r3, ".") == true) goto L9;
        if (d.h.b.o.a(r3, DownloadConstants.VULNERABILITY_PATH) == true) goto L9;
        r2 = true;
        goto L10
    }
}
