package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f62173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f62174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f62175d;

    public static final class a {
    }

    public interface b {
        void a(CommonStandardBottomDialog r100, View r101, i r102);
    }

    static {
    }

    public i(int r100, String r101, int r102, r0 r103) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "itemClickListener");
        this.f62172a = r100;
        this.f62173b = r101;
        this.f62174c = r102;
        this.f62175d = r103;
    }
}
