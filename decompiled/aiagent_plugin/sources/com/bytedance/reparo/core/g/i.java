package com.bytedance.reparo.core.g;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: SoFile.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f9241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9242e;
    public boolean f;

    public i() {
        this.f = true;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L11;
        return false;
    L11:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(this.f9239b, r6.f9239b) == false) goto L19;
        if (TextUtils.equals(this.f9240c, r6.f9240c) == false) goto L19;
        if (TextUtils.equals(this.f9238a, r6.f9238a) == false) goto L19;
        return true;
    L19:
        return false;
    }
}
