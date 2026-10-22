package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a?\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "hostRoot", "", "hostLayer", "targetRoot", "targetLayer", "", "samePackage", "startsNewTask", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ILjava/lang/String;IZZ)Z", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u0 {
    public static final boolean a(String hostRoot, int i10, String targetRoot, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(hostRoot, "hostRoot");
        kotlin.jvm.internal.p.i(targetRoot, "targetRoot");
        return z10 && !z11 && kotlin.jvm.internal.p.d(hostRoot, targetRoot) && i11 > i10;
    }
}
