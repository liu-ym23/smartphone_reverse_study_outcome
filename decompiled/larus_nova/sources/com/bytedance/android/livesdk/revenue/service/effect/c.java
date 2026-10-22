package com.bytedance.android.livesdk.revenue.service.effect;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.k3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.w3;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public interface c extends dy0.a, com.bytedance.live.kmp.core.c {

    public static final class a {
        public static /* synthetic */ void a(c r100, RevStickerPanel r101, yp2.b r102, f r103, int r104) {
            IRevEffectService$tryDownloadSticker$1 r105 = null;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            if ((r104 & 8) == 0) goto L8;
            r105 = IRevEffectService$tryDownloadSticker$1.INSTANCE;
        L8:
            r100.wd(r101, r102, r103, r105);
        }
    }

    void Bj(List<String> r100, Map<String, ? extends List<String>> r101, yp2.a r102);

    void Bn(yp2.b r100, RevStickerPanel r101);

    void D8();

    yp2.c Hk(com.bytedance.android.livesdk.gift.platform.core.preview.e r100);

    boolean N2();

    void U9(List r100, k3 r101);

    Single Y7(i r100);

    List<yp2.b> f4(RevStickerPanel r100);

    void h2(String r100, w3 r101);

    boolean he(com.bytedance.android.live.core.resources.e r100);

    List<yp2.b> lk(List<? extends b> r100);

    void nm(yp2.b r100, String r101, RevStickerPanel r102);

    void providerResourceFinder();

    void wd(RevStickerPanel r100, yp2.b r101, f r102, Function1<? super Integer, Unit> r103);
}
