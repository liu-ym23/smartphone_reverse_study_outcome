package ap0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton;
import com.bytedance.android.live.openplatform.impl.base.view.RotatingDrawable;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements LiveSwitchButton.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPlatformSwitchButton f15834a;

    public static final class a implements OpenPlatformSwitchButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformSwitchButton.a f15835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f15836b;

        @Override // com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformSwitchButton.b
        public final void a(boolean r100) {
            this.f15835a.b();
            OpenPlatformSwitchButton r101 = this.f15836b.f15834a;
            r101.f84089c = false;
            ((LiveSwitchButton) r101.a(R.id.switch_button)).setVisibility(0);
            ((ImageView) this.f15836b.f15834a.a(R.id.loading_img)).setVisibility(8);
            Drawable r102 = ((ImageView) this.f15836b.f15834a.a(R.id.loading_img)).getDrawable();
            if (r102 == null) goto L9;
            ((RotatingDrawable) r102).stop();
            if (r100 == false) goto L10;
            ((LiveSwitchButton) this.f15836b.f15834a.a(R.id.switch_button)).f(true, false);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.base.view.RotatingDrawable");
        }

        public a(OpenPlatformSwitchButton.a r100, b r101) {
            this.f15835a = r100;
            this.f15836b = r101;
        }
    }

    public b(OpenPlatformSwitchButton r100) {
        this.f15834a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.f
    public final Boolean a(boolean r100) {
        OpenPlatformSwitchButton r101 = this.f15834a;
        OpenPlatformSwitchButton.a r102 = r101.f84088b;
        if (r102 == null) goto L15;
        if (r101.f84089c == true) goto L7;
        r102.b();
        OpenPlatformSwitchButton r103 = this.f15834a;
        r103.f84089c = true;
        ((LiveSwitchButton) r103.a(R.id.switch_button)).setVisibility(4);
        ((ImageView) this.f15834a.a(R.id.loading_img)).setVisibility(0);
        Drawable r104 = ((ImageView) this.f15834a.a(R.id.loading_img)).getDrawable();
        if (r104 == null) goto L13;
        ((RotatingDrawable) r104).start();
        r102.a(this.f15834a, r100, new a(r102, this));
        return Boolean.TRUE;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.base.view.RotatingDrawable");
    L7:
        return Boolean.TRUE;
    L15:
        return Boolean.FALSE;
    }
}
