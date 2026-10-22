package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f3828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f3829c;

    public b(int r10, k r11, Bundle r12) {
        this.f3827a = r10;
        this.f3828b = r11;
        this.f3829c = r12;
    }

    public final Bundle a() {
        return this.f3829c;
    }

    public final int b() {
        return this.f3827a;
    }

    public final k c() {
        return this.f3828b;
    }

    public final void d(Bundle r10) {
        this.f3829c = r10;
    }

    public final void e(k r10) {
        this.f3828b = r10;
    }

    public /* synthetic */ b(int r10, k r11, Bundle r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }
}
