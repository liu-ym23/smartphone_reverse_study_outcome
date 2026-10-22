package com.bytedance.android.livesdk.rank.widget;

import androidx.lifecycle.ViewModel;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0014R@\u0010\t\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR@\u0010\r\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/rank/widget/HourEntranceState;", "Landroidx/lifecycle/ViewModel;", "Lav0/a$b;", "", "onCleared", "Lio/reactivex/subjects/BehaviorSubject;", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "fromLynx", "Lio/reactivex/subjects/BehaviorSubject;", "getFromLynx", "()Lio/reactivex/subjects/BehaviorSubject;", "fromClient", "getFromClient", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HourEntranceState extends ViewModel implements av0.a.b {
    private final BehaviorSubject<Pair<Boolean, Boolean>> fromClient;
    private final BehaviorSubject<Pair<Boolean, Boolean>> fromLynx;

    public HourEntranceState() {
        this.fromLynx = BehaviorSubject.create();
        this.fromClient = BehaviorSubject.create();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        getFromLynx().onComplete();
        getFromClient().onComplete();
    }

    @Override // av0.a.b
    public BehaviorSubject<Pair<Boolean, Boolean>> getFromClient() {
        return this.fromClient;
    }

    @Override // av0.a.b
    public BehaviorSubject<Pair<Boolean, Boolean>> getFromLynx() {
        return this.fromLynx;
    }
}
