package com.bytedance.android.shopping.store.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.core.async.DisposableScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010.\u001a\u00020\u0004¢\u0006\u0004\b0\u00101J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J@\u0010\u0012\u001a\u00020\u00052.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J`\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00142.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJp\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00142.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fH\u0096\u0001¢\u0006\u0004\b\"\u0010#JH\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b$\u0010%J\\\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010 2.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b$\u0010&J;\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010 2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001J`\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00142.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b$\u0010\u001eJ\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001J\t\u0010)\u001a\u00020\u0010H\u0096\u0001J@\u0010*\u001a\u00020\u00052.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u001f\u0010*\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/store/viewmodel/ECStoreBaseViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/shopping/store/viewmodel/j;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/ec/core/event/c;", "", "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "", "Lkotlin/Pair;", "", "params", "appendEventParams", "([Lkotlin/Pair;)V", "", "paramsMap", "", "monitorId", "bindMonitorId", "(Ljava/lang/Long;)V", "clearEventParams", "actionName", "", "doAnyEventAction", "(Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "btm", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "doAnyEventActionWithBtm", "(Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "doEventAction", "(Ljava/lang/String;[Lkotlin/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;[Lkotlin/Pair;)V", "paramMap", "getBaseParams", "getBaseParamsJson", "initEventContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "disposableContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "eventAction", "Lcom/bytedance/android/ec/core/event/c;", "<init>", "(Lcom/bytedance/android/ec/core/async/DisposableScope;Lcom/bytedance/android/ec/core/event/c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECStoreBaseViewModel extends QStateViewModel<j> implements com.bytedance.android.ec.core.async.b, com.bytedance.android.ec.core.event.c {
    private final DisposableScope disposableContext;
    private final com.bytedance.android.ec.core.event.c eventAction;

    /* JADX WARN: Multi-variable type inference failed */
    public ECStoreBaseViewModel() {
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

    public ECStoreBaseViewModel(DisposableScope r100, com.bytedance.android.ec.core.event.c r101) {
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        Intrinsics.checkNotNullParameter(r101, "eventAction");
        super(new j());
        this.disposableContext = r100;
        this.eventAction = r101;
    }

    public /* synthetic */ ECStoreBaseViewModel(DisposableScope r100, com.bytedance.android.ec.core.event.c r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new DisposableScope();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ui3.f();
    L8:
        this(r100, r101);
    }
}
