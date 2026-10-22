package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends ArrayList<Room>> f122741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends LiveSearchResultPageStatus> f122742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends LiveSearchErrorType> f122743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f122744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Double> f122745e;

    public s0(Function0<? extends ArrayList<Room>> r100, Function0<? extends LiveSearchResultPageStatus> r101, Function0<? extends LiveSearchErrorType> r102, Function0<Boolean> r103, Function0<Double> r104) {
        Intrinsics.checkNotNullParameter(r100, "searchRoomArray");
        Intrinsics.checkNotNullParameter(r101, "resultPageStatus");
        Intrinsics.checkNotNullParameter(r102, "errorType");
        Intrinsics.checkNotNullParameter(r103, "fromRecommend");
        Intrinsics.checkNotNullParameter(r104, "searchResultStartTime");
        this.f122741a = r100;
        this.f122742b = r101;
        this.f122743c = r102;
        this.f122744d = r103;
        this.f122745e = r104;
    }
}
