package bn2;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.notification.notificationsetting.AnchorPushSettingFragment;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorPushSettingFragment f19722a;

    public f(AnchorPushSettingFragment r100) {
        this.f19722a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FragmentActivity r101 = this.f19722a.getActivity();
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }
}
