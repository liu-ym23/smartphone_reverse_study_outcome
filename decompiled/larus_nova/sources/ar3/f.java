package ar3;

import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f16007a;

    public f(h r100) {
        this.f16007a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Function1<WindowHybridTabDataListResponseDTO, Unit> r101 = this.f16007a.f16010b;
        r101.invoke((WindowHybridTabDataListResponseDTO) r100);
    }
}
