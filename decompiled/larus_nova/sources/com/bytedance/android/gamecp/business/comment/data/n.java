package com.bytedance.android.gamecp.business.comment.data;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommentLabelMarkSpan f52053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, String> f52054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f52055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f52056d;

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f52055c = r100;
        this.f52056d = false;
    }
}
