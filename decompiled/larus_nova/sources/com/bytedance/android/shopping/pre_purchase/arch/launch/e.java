package com.bytedance.android.shopping.pre_purchase.arch.launch;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f180660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f180662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f180663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f180664e;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f180660a, r101.f180660a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180661b, r101.f180661b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180662c, r101.f180662c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180663d, r101.f180663d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180664e, r101.f180664e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Context r100 = this.f180660a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f180661b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Activity r107 = this.f180662c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f180663d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f180664e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LaunchContext(context=" + this.f180660a + ", sessionId=" + this.f180661b + ", activity=" + this.f180662c + ", handlerBlackList=" + this.f180663d + ", startTimestamp=" + this.f180664e + ")";
    }

    public final Activity getActivity() {
        return this.f180662c;
    }

    public final Context getContext() {
        return this.f180660a;
    }

    public e(Context r100, String r101, Activity r102, List r103, Long r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        this.f180660a = r100;
        this.f180661b = r101;
        this.f180662c = r102;
        this.f180663d = r103;
        this.f180664e = r104;
    }
}
