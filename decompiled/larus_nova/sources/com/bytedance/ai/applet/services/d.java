package com.bytedance.ai.applet.services;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f35206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35208d;

    public d(String r100, String r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "snapshotId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r102, "imageBase64");
        this.f35205a = r101;
        this.f35206b = r102;
        this.f35207c = r103;
        this.f35208d = r104;
    }
}
