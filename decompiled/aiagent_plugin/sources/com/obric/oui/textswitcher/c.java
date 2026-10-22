package com.obric.oui.textswitcher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f36481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36482b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36481a, r6.f36481a) == true) goto L12;
        return false;
    L12:
        if (this.f36482b == r6.f36482b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f36481a.hashCode() * 31) + Integer.hashCode(this.f36482b);
    }

    public String toString() {
        return "TextSwitcherDataSpec(textList=" + this.f36481a + ", fromIndex=" + this.f36482b + ')';
    }

    public final ArrayList<String> a() {
        return this.f36481a;
    }
}
