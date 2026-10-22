package ar3;

import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowHybridTabDataListResponseDTO f16006a;

    public e(WindowHybridTabDataListResponseDTO r100) {
        this.f16006a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<WindowHybridTabDataListResponseDTO> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.onNext(this.f16006a);
        r100.onComplete();
    }
}
