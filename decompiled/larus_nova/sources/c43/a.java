package c43;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import l33.c;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22381a = null;

    public a() {
    }

    static {
        f22381a = new a();
    }

    public static String a(c r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Object r103 = r100.Lw();
        BtmSDK r104 = BtmSDK.INSTANCE;
        PageFinder r105 = PageFinder.via(r103);
        BcmParams.Companion.getClass();
        return r104.createJumpSourceBtmToken(r101, r105, BcmParams.a.a(r102));
    }

    public final void b(c r100, String r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, "targetPageBtm");
        Object r103 = r100.Lw();
        BtmSDK.INSTANCE.willJumpToNextPage(new BtmItemBuilder(r101, null, 2, null).withPageFinder(PageFinder.via(r103)).setTargetPagesBtm(r102).build());
    }
}
