package com.bytedance.android.livesdk.dslservice.slice.process;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.i;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f122946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f122947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<Context> f122948f;

    public a(String r100, String r101, String r102, q r103, String r104, WeakReference<Context> r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r103, "key");
        super(r100, r101, r102);
        this.f122946d = r103;
        this.f122947e = r104;
        this.f122948f = r105;
    }
}
