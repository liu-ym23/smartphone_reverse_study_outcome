package com.bytedance.android.livesdkapi.util;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/PlayModeStatisticsItem;", "Lcom/bytedance/android/livesdkapi/util/StatisticsItem;", "playmode", "", "type", "", "concernList", "", "Lio/reactivex/subjects/BehaviorSubject;", "", "diposable", "Lio/reactivex/disposables/CompositeDisposable;", "(ILjava/lang/String;Ljava/util/List;Lio/reactivex/disposables/CompositeDisposable;)V", "getPlaymode", "()I", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayModeStatisticsItem extends StatisticsItem {
    private final int playmode;

    public final int getPlaymode() {
        return this.playmode;
    }

    public PlayModeStatisticsItem(int r100, String r101, List<BehaviorSubject<Long>> r102, CompositeDisposable r103) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "concernList");
        Intrinsics.checkNotNullParameter(r103, "diposable");
        super(r101, r102, r103);
        this.playmode = r100;
    }
}
