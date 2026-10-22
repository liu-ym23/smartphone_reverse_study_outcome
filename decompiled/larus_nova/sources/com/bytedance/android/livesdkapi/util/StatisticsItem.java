package com.bytedance.android.livesdkapi.util;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/StatisticsItem;", "", "type", "", "concernList", "", "Lio/reactivex/subjects/BehaviorSubject;", "", "diposable", "Lio/reactivex/disposables/CompositeDisposable;", "(Ljava/lang/String;Ljava/util/List;Lio/reactivex/disposables/CompositeDisposable;)V", "getConcernList", "()Ljava/util/List;", "getDiposable", "()Lio/reactivex/disposables/CompositeDisposable;", "getType", "()Ljava/lang/String;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StatisticsItem {
    private final List<BehaviorSubject<Long>> concernList;
    private final CompositeDisposable diposable;
    private final String type;

    public final List<BehaviorSubject<Long>> getConcernList() {
        return this.concernList;
    }

    public final CompositeDisposable getDiposable() {
        return this.diposable;
    }

    public final String getType() {
        return this.type;
    }

    public StatisticsItem(String r100, List<BehaviorSubject<Long>> r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "concernList");
        Intrinsics.checkNotNullParameter(r102, "diposable");
        this.type = r100;
        this.concernList = r101;
        this.diposable = r102;
    }
}
