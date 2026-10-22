package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.State;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f166766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f166767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f166768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final State f166769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f166770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LynxElementVO f166771f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f166766a, r101.f166766a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f166767b, r101.f166767b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f166768c, r101.f166768c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f166769d, r101.f166769d) == true) goto L14;
        return false;
    L14:
        if (this.f166770e == r101.f166770e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f166771f, r101.f166771f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        View r100 = this.f166766a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        l r104 = this.f166767b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f166768c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        State r110 = this.f166769d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f166770e;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        LynxElementVO r116 = this.f166771f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
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
        return "LynxComponent(lynxView=" + this.f166766a + ", component=" + this.f166767b + ", lynxId=" + this.f166768c + ", state=" + this.f166769d + ", lastVisibleStatue=" + this.f166770e + ", vo=" + this.f166771f + ")";
    }

    public c(View r100, l r101, String r102, State r103, LynxElementVO r104) {
        this.f166766a = r100;
        this.f166767b = r101;
        this.f166768c = r102;
        this.f166769d = r103;
        this.f166770e = false;
        this.f166771f = r104;
    }
}
