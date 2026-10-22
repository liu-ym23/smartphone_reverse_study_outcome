package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Room> f122749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends ArrayList<String>> f122750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f122751c;

    public t0(Function0<Room> r100, Function0<? extends ArrayList<String>> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "roomIdList");
        this.f122749a = r100;
        this.f122750b = r101;
        this.f122751c = r102;
    }
}
