package com.obric.oui.textswitcher;

import android.view.animation.Animation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Animation f36476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Animation f36477b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36476a, r6.f36476a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36477b, r6.f36477b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Animation r0 = this.f36476a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Animation r4 = this.f36477b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AnimationSpec(inAnimation=" + this.f36476a + ", outAnimation=" + this.f36477b + ')';
    }

    public a(Animation r1, Animation r2) {
        this.f36476a = r1;
        this.f36477b = r2;
    }

    public /* synthetic */ a(Animation r2, Animation r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
