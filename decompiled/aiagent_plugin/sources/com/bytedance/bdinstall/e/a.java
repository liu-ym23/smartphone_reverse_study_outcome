package com.bytedance.bdinstall.e;

import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TTResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Pair<String, String>> f6240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6241d;

    public a(String r3, int r4, List<Pair<String, String>> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f6238a = r3;
        this.f6239b = r4;
        if (r7 != null) goto L5;
        this.f6240c = new ArrayList();
    L6:
        this.f6241d = r6;
        return;
    L5:
        this.f6240c = Collections.unmodifiableList(new ArrayList(r7));
        goto L6
    }

    public List<Pair<String, String>> a() {
        return this.f6240c;
    }

    public String b() {
        return this.f6241d;
    }

    public String toString() {
        return "DeviceResponse{\n body=" + this.f6241d + "\n headers=" + this.f6240c + "\n code=" + this.f6239b + "\n url='" + this.f6238a + "'}";
    }
}
