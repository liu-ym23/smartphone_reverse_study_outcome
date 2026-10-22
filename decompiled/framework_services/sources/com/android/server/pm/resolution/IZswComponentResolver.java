package com.android.server.pm.resolution;

import android.content.Intent;
import android.util.Pair;
import com.android.server.pm.pkg.PackageStateInternal;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswComponentResolver {

    public interface IZswMimeGroupsAwareIntentResolverInner {
        Pair<Boolean, Boolean> extraStopCheck(PackageStateInternal r1, String r2, int r3, Intent r4);
    }
}
