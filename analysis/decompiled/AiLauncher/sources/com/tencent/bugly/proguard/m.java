package com.tencent.bugly.proguard;

import Z7.K;
import Z7.L;
import java.io.Serializable;

/* loaded from: classes4.dex */
public abstract class m implements Serializable {
    public abstract void a(K k10);

    public abstract void d(L l10);

    public abstract void f(StringBuilder sb2, int i10);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 0);
        return sb2.toString();
    }
}
