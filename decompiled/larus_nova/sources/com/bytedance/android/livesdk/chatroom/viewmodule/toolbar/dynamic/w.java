package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;

/* JADX INFO: loaded from: classes8.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ToolbarButton f116209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ToolbarButton f116210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ToolbarButton f116211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ToolbarButton f116212d;

    public w() {
        ToolbarButton r100 = null;
        this(r100, r100, 15);
    }

    public /* synthetic */ w(ToolbarButton r100, ToolbarButton r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null, null);
    }

    public w(ToolbarButton r100, ToolbarButton r101, ToolbarButton r102, ToolbarButton r103) {
        this.f116209a = r100;
        this.f116210b = r101;
        this.f116211c = r102;
        this.f116212d = r103;
    }
}
