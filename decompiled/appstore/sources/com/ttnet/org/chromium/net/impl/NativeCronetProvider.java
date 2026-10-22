package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class NativeCronetProvider extends com.ttnet.org.chromium.net.d {
    @UsedByReflection("CronetProvider.java")
    public NativeCronetProvider(Context r10) {
        super(r10);
    }

    @Override // com.ttnet.org.chromium.net.d
    public com.ttnet.org.chromium.net.c.a b() {
        return new com.ttnet.org.chromium.net.f.a(new n(this.f18490a));
    }

    @Override // com.ttnet.org.chromium.net.d
    public String d() {
        return "App-Packaged-Cronet-Provider";
    }

    @Override // com.ttnet.org.chromium.net.d
    public String e() {
        return ImplVersion.a();
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof NativeCronetProvider) == true) goto L6;
    L8:
        return false;
    L6:
        if (this.f18490a.equals(((NativeCronetProvider) r10).f18490a) == false) goto L8;
        goto L8
    }

    @Override // com.ttnet.org.chromium.net.d
    public boolean f() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.f18490a});
    }
}
