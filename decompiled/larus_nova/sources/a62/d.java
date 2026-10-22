package a62;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingBlockWidget;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BarrageSettingBlockWidget f1942a;

    public d(BarrageSettingBlockWidget r100) {
        this.f1942a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ImageView r101 = this.f1942a.f133943f;
        if (r101 == null) goto L6;
        boolean r102 = !r101.isSelected();
        r101.setSelected(r102);
        this.f1942a.f133928a.setCarnivalBarrageOpen(r102);
        BarrageSettingBlockWidget r103 = this.f1942a;
        r103.f133929b.X50(r103.f133928a);
        this.f1942a.wq();
        return;
    }
}
