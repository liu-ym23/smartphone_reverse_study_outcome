package com.bytedance.android.livesdk.drawer.relax;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.relax.relaxframework.LongPressEvent;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends FeedItem> f122653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<? extends LiveDrawerManageStatus> f122654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<? extends ArrayList<Long>> f122655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> f122656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<? super Long, Unit> f122657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super LongPressEvent, Unit> f122658f;

    public i(Function0<? extends FeedItem> r100, Function0<? extends LiveDrawerManageStatus> r101, Function0<? extends ArrayList<Long>> r102, Function1<? super Function1<? super ArrayList<Long>, ? extends ArrayList<Long>>, Unit> r103, Function1<? super Long, Unit> r104, Function1<? super LongPressEvent, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "manageStatus");
        Intrinsics.checkNotNullParameter(r102, "deleteList");
        Intrinsics.checkNotNullParameter(r103, "setDeleteList");
        Intrinsics.checkNotNullParameter(r104, "toDelete");
        Intrinsics.checkNotNullParameter(r105, "handleLongPress");
        this.f122653a = r100;
        this.f122654b = r101;
        this.f122655c = r102;
        this.f122656d = r103;
        this.f122657e = r104;
        this.f122658f = r105;
    }
}
