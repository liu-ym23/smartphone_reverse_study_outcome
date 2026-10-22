package com.bytedance.android.shopping.base.arch.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.base.event.b;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import fa3.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020\u0003¢\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0096\u0001J@\u0010\u0013\u001a\u00020\u00042.\u0010\u0012\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f\"\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0004H\u0096\u0001JR\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192.\u0010\u0012\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f\"\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H\u0096\u0001JH\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2.\u0010\u0012\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f\"\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001dJ'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H\u0096\u0001J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001eH\u0096\u0001J@\u0010 \u001a\u00020\u00042.\u0010\u0012\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f\"\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0096\u0001¢\u0006\u0004\b \u0010\u0014J\u001f\u0010 \u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H\u0096\u0001R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/base/arch/viewmodel/BaseViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lfa3/d;", "Lcom/bytedance/android/shopping/base/event/b;", "", "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "doClear", "remove", "", "key", "value", "appendEventParamToEntranceInfo", "", "Lkotlin/Pair;", "", "params", "appendEventParams", "([Lkotlin/Pair;)V", "", "paramsMap", "clearEventParams", "actionName", "Lcom/bytedance/android/btm/api/model/PageFinder;", "btmPageFinder", "doEventAction", "(Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;[Lkotlin/Pair;)V", "(Ljava/lang/String;[Lkotlin/Pair;)V", "", "getEventParams", "initEventContext", "Lfa3/b;", "disposableContext", "Lfa3/b;", "eventAction", "Lcom/bytedance/android/shopping/base/event/b;", "<init>", "(Lfa3/b;Lcom/bytedance/android/shopping/base/event/b;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseViewModel extends QViewModel implements d, b {
    private final fa3.b disposableContext;
    private final b eventAction;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // fa3.d
    public Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.disposableContext.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void appendEventParamToEntranceInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.eventAction.appendEventParamToEntranceInfo(r100, r101);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void appendEventParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.eventAction.appendEventParams(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void appendEventParams(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.eventAction.appendEventParams(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void clearEventParams() {
        this.eventAction.clearEventParams();
    }

    public void doClear() {
        this.disposableContext.a();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void doEventAction(String r100, PageFinder r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.eventAction.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void doEventAction(String r100, PageFinder r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.eventAction.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void doEventAction(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.eventAction.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void doEventAction(String r100, Pair<String, ? extends Object>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.eventAction.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public Map<String, Object> getEventParams() {
        return this.eventAction.getEventParams();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void initEventContext(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.eventAction.initEventContext(r100);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public void initEventContext(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.eventAction.initEventContext(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        doClear();
    }

    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        fa3.b r101 = this.disposableContext;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "disposable");
        CompositeDisposable r102 = r101.f476020a;
        if (r102 == null) goto L6;
        r102.remove(r100);
        return;
    }

    public BaseViewModel(fa3.b r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        Intrinsics.checkNotNullParameter(r101, "eventAction");
        this.disposableContext = r100;
        this.eventAction = r101;
    }

    public /* synthetic */ BaseViewModel(fa3.b r100, b r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new fa3.b();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new EventActionImpl();
    L8:
        this(r100, r101);
    }
}
