package com.bytedance.android.shopping.anchorv3.activities.quick.base;

import c53.d;
import com.bytedance.android.shopping.anchorv3.activities.quick.base.event.DefaultEventAction;
import com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J@\u0010\u0010\u001a\u00020\u00042.\u0010\u000f\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r0\f\"\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000e2.\u0010\u000f\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r0\f\"\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J@\u0010\u0015\u001a\u00020\u00042.\u0010\u000f\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r0\f\"\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/activities/quick/base/BaseViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lc53/d;", "Lcom/bytedance/android/shopping/anchorv3/activities/quick/base/event/b;", "", "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "doClear", "ignore", "remove", "", "Lkotlin/Pair;", "", "params", "appendEventParams", "([Lkotlin/Pair;)V", "actionName", "doEventAction", "(Ljava/lang/String;[Lkotlin/Pair;)V", "initEventContext", "disposableContext", "Lc53/d;", "eventAction", "Lcom/bytedance/android/shopping/anchorv3/activities/quick/base/event/b;", "<init>", "(Lc53/d;Lcom/bytedance/android/shopping/anchorv3/activities/quick/base/event/b;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseViewModel extends QViewModel implements d, b {
    private final d disposableContext;
    private final b eventAction;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // c53.d
    public Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.disposableContext.add(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b
    public void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.eventAction.appendEventParams(r100);
    }

    @Override // c53.d
    public void doClear() {
        this.disposableContext.doClear();
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b
    public void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.eventAction.doEventAction(r100, r101);
    }

    @Override // c53.d
    public Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.disposableContext.ignore(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv3.activities.quick.base.event.b
    public void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.eventAction.initEventContext(r100);
    }

    @Override // c53.d
    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.disposableContext.remove(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        doClear();
    }

    public BaseViewModel(d r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        Intrinsics.checkNotNullParameter(r101, "eventAction");
        this.disposableContext = r100;
        this.eventAction = r101;
    }

    public /* synthetic */ BaseViewModel(d r100, b r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new c53.b();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new DefaultEventAction(r100);
    L8:
        this(r100, r101);
    }
}
