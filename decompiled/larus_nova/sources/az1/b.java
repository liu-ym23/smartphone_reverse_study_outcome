package az1;

import com.bytedance.android.livesdk.gift.guide.view.CommentGiftGuideView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentGiftGuideView f16788a;

    public b(CommentGiftGuideView r100) {
        this.f16788a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        CommentGiftGuideView r102 = this.f16788a;
        int r103 = CommentGiftGuideView.f126343i;
        r102.e("time_up");
    }
}
