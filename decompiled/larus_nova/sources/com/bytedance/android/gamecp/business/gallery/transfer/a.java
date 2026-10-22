package com.bytedance.android.gamecp.business.gallery.transfer;

import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f53224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VelocityTracker f53225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f53226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f53227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f53228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53229f;

    public a(e r100) {
        this.f53224a = r100;
        this.f53229f = ViewConfiguration.get(r100.getContext()).getScaledEdgeSlop();
    }
}
