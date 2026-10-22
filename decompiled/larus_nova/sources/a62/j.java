package a62;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.VSLiveLandscapeBarrageSettingDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSLiveLandscapeBarrageSettingDialog f1949a;

    public j(VSLiveLandscapeBarrageSettingDialog r100) {
        this.f1949a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        VSLiveLandscapeBarrageSettingDialog r101 = this.f1949a;
        BarrageSetting r102 = ((q22.b) r100).f531405a;
        int r103 = VSLiveLandscapeBarrageSettingDialog.f133948m;
        r101.getClass();
        boolean r104 = VSLiveLandscapeBarrageSettingDialog.S90(r102, BarrageSetting.getDefaultVSLiveSetting());
        View r105 = r101.f133951g;
        if (r105 == null) goto L8;
        if (r104 == false) goto L6;
        float r106 = 0.5f;
    L7:
        r105.setAlpha(r106);
        goto L8
    L6:
        r106 = 1.0f;
    L8:
        View r107 = r101.f133951g;
        if (r107 == null) goto L12;
        r107.setClickable(!r104);
        return;
    }
}
