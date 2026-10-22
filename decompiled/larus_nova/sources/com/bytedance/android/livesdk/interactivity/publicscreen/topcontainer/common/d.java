package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements f52.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f139798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f139799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f139800c;

    public final int hashCode() {
        String r100 = this.f139798a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CommonTrayType(desc=" + this.f139800c + ", priority=" + this.f139799b + ')';
    }

    @Override // f52.f
    public final int getPriority() {
        return this.f139799b;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof d) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((d) r100).f139798a, this.f139798a) == false) goto L7;
        return true;
    }

    public d(String r100, String r101, int r102) {
        String r103 = r100 + '-' + r101;
        Intrinsics.checkNotNullParameter(r103, SocialConstants.PARAM_APP_DESC);
        this.f139798a = r100;
        this.f139799b = r102;
        this.f139800c = r103;
    }
}
