package co1;

import com.bytedance.android.livesdk.chatroom.tetris.vr.ui.RecenterGuideView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecenterGuideView f24606a;

    public a(RecenterGuideView r100) {
        this.f24606a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f24606a.a();
    }
}
