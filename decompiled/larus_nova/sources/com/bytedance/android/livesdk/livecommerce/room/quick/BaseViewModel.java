package com.bytedance.android.livesdk.livecommerce.room.quick;

import bk2.b;
import bk2.d;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\t\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/quick/BaseViewModel;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Lbk2/d;", "", LiveCommonConstants.REASON_ON_DEDTROY, "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "ignore", "remove", "disposableContext", "Lbk2/d;", "<init>", "(Lbk2/d;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseViewModel extends QViewModel implements d {
    private final d disposableContext;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // bk2.d
    public Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.disposableContext.add(r100);
    }

    @Override // bk2.d
    public void clearDisposable() {
        this.disposableContext.clearDisposable();
    }

    @Override // bk2.d
    public Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.disposableContext.ignore(r100);
    }

    @Override // bk2.d
    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.disposableContext.remove(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        clearDisposable();
    }

    public final void onDestroy() {
        onCleared();
    }

    public BaseViewModel(d r100) {
        Intrinsics.checkNotNullParameter(r100, "disposableContext");
        this.disposableContext = r100;
    }

    public /* synthetic */ BaseViewModel(d r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new b();
    L5:
        this(r100);
    }
}
