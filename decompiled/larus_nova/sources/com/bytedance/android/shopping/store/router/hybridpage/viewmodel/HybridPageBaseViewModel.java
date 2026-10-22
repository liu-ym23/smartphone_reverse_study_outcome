package com.bytedance.android.shopping.store.router.hybridpage.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.core.event.c;
import com.bytedance.android.ec.store.product.EventActionImplOpt;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\b\b\u0002\u0010-\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\t\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J@\u0010\u0011\u001a\u00020\u00042.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013H\u0096\u0001J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0004H\u0096\u0001J`\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00132.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000eH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJp\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00132.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000eH\u0096\u0001¢\u0006\u0004\b!\u0010\"JH\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b#\u0010$J\\\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b#\u0010%J;\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013H\u0096\u0001J`\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00132.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013H\u0096\u0001J\t\u0010(\u001a\u00020\u000fH\u0096\u0001J@\u0010)\u001a\u00020\u00042.\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\r\"\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b)\u0010\u0012J\u001f\u0010)\u001a\u00020\u00042\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013H\u0096\u0001R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageBaseViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/ec/core/event/c;", "", "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "", "Lkotlin/Pair;", "", "params", "appendEventParams", "([Lkotlin/Pair;)V", "", "paramsMap", "", "monitorId", "bindMonitorId", "(Ljava/lang/Long;)V", "clearEventParams", "actionName", "", "doAnyEventAction", "(Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "btm", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "doAnyEventActionWithBtm", "(Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "doEventAction", "(Ljava/lang/String;[Lkotlin/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;[Lkotlin/Pair;)V", "paramMap", "getBaseParams", "getBaseParamsJson", "initEventContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "disposableContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "eventAction", "Lcom/bytedance/android/ec/core/event/c;", "<init>", "(Lcom/bytedance/android/ec/core/async/DisposableScope;Lcom/bytedance/android/ec/core/event/c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HybridPageBaseViewModel extends QViewModel implements b, c {
    private final DisposableScope disposableContext;
    private final c eventAction;

    /* JADX WARN: Multi-variable type inference failed */
    public HybridPageBaseViewModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.android.ec.core.async.b, fa3.d
    public Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.disposableContext.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void appendEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.eventAction.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.eventAction.appendEventParams(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void bindMonitorId(Long r100) {
        this.eventAction.bindMonitorId(r100);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public void clearDisposable() {
        this.disposableContext.clearDisposable();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void clearEventParams() {
        this.eventAction.clearEventParams();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.eventAction.doAnyEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doAnyEventActionWithBtm(String r100, PageFinder r101, String r110, Map<String, ? extends Object> r111, Pair<String, ? extends Object>... r112) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        Intrinsics.checkNotNullParameter(r110, "actionName");
        Intrinsics.checkNotNullParameter(r112, "params");
        this.eventAction.doAnyEventActionWithBtm(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doEventAction(String r100, String r101, PageFinder r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "paramMap");
        this.eventAction.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.eventAction.doEventAction(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.eventAction.doEventAction(r100, r101, r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.eventAction.doEventAction(r100, r101);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public Map<String, String> getBaseParams() {
        return this.eventAction.getBaseParams();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public String getBaseParamsJson() {
        return this.eventAction.getBaseParamsJson();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void initEventContext(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.eventAction.initEventContext(r100);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.eventAction.initEventContext(r100);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.disposableContext.remove(r100);
    }

    @Override // com.bytedance.android.ec.core.async.b
    public CompositeDisposable compositeDisposable() {
        return this.disposableContext.a();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        clearDisposable();
    }

    public HybridPageBaseViewModel(DisposableScope r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        Intrinsics.checkNotNullParameter(r101, "eventAction");
        this.disposableContext = r100;
        this.eventAction = r101;
    }

    public /* synthetic */ HybridPageBaseViewModel(DisposableScope r100, c r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new DisposableScope();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new EventActionImplOpt();
    L8:
        this(r100, r101);
    }
}
