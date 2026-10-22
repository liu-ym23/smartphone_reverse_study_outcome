package b9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import h8.c;

/* JADX INFO: loaded from: classes43.dex */
public interface b extends com.bytedance.android.annie.service.a {
    HybridFragment B1(Context r100, Uri r101, b7.b r102, Bundle r103);

    HybridCard J0(Context r100, Uri r101, b7.b r102, Bundle r103);

    void f0(KitType r100, Uri r101, Bundle r102);

    void init();

    HybridDialog o1(Context r100, Uri r101, b7.b r102, Bundle r103);

    boolean p1(Context r100, Uri r101, c r102, Bundle r103);
}
