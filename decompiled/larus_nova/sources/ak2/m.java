package ak2;

import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements be.b, ILivePromotionActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3991a;

    public m(be.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f3991a = r100;
    }

    @Override // be.b
    public final void onClickPromotion(String r100, String r101, String r102, JSONObject r103) {
        Object r104 = this.f3991a;
        if ((r104 instanceof be.b) == false) goto L6;
        ((be.b) r104).onClickPromotion(r100, r101, r102, r103);
        return;
    L6:
        if ((r104 instanceof ILivePromotionActionListener) == false) goto L10;
        ((ILivePromotionActionListener) r104).onClickPromotion(r100, r101, r102, r103);
        return;
    }
}
