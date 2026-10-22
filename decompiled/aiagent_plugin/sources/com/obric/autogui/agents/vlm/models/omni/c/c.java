package com.obric.autogui.agents.vlm.models.omni.c;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppPredictionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f28243b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28242a, r6.f28242a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28243b, r6.f28243b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f28242a.hashCode() * 31) + this.f28243b.hashCode();
    }

    public String toString() {
        return "AppPredictionInput(query=" + this.f28242a + ", candidates=" + this.f28243b + ')';
    }

    public c(String r3, List<a> r4) {
        List<a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DownloadConstants.QUERY_KEY);
        d.h.b.o.e(r5, "candidates");
        this.f28242a = r3;
        this.f28243b = r5;
    }

    public final String a() {
        return this.f28242a;
    }

    public final List<a> b() {
        return this.f28243b;
    }
}
