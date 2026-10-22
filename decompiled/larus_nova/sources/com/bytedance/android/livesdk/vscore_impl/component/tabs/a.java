package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f159939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f159940e;

    public a(long r100, String r101, Uri r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "uri");
        super(TabType.IS_WEB_TAB, r100, r101);
        this.f159939d = r102;
        this.f159940e = r103;
    }
}
