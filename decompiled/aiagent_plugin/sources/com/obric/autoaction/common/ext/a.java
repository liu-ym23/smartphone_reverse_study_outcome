package com.obric.autoaction.common.ext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: DarkModeExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autoaction.common.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f24638a;

    public a() {
        this(false, 1, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f24638a == r6.f24638a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f24638a);
    }

    public String toString() {
        return "DarkModeConfig(enable=" + this.f24638a + ')';
    }

    public a(boolean r1) {
        this.f24638a = r1;
    }

    public /* synthetic */ a(boolean r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }

    @Override // com.obric.autoaction.common.base.b
    public boolean a() {
        return this.f24638a;
    }
}
