package bn2;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.notification.notificationsetting.AnchorPushSettingFragment;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorPushSettingFragment f19723a;

    public g(AnchorPushSettingFragment r100) {
        this.f19723a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LinearLayout r101 = this.f19723a.f154101m;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        d r102 = this.f19723a.f154097i;
        if (r102 == null) goto L9;
        r102.c();
        return;
    }
}
