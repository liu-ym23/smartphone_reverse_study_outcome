package bg1;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.brightness.LiveBrightnessService;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowManager.LayoutParams f18856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveBrightnessService.b f18857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f18858c;

    public a(WindowManager.LayoutParams r100, LiveBrightnessService.b r101, Map r102) {
        this.f18856a = r100;
        this.f18857b = r101;
        this.f18858c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L17;
        float r102 = ((Float) r101).floatValue();
        WindowManager.LayoutParams r103 = this.f18856a;
        if (r103 == null) goto L7;
        r103.screenBrightness = r102;
    L7:
        WeakReference r104 = LiveBrightnessService.access$getActivityContext$p(this.f18857b.f105242a);
        if (r104 == null) goto L14;
        Activity r105 = (Activity) r104.get();
        if (r105 == null) goto L14;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L14;
        r106.setAttributes(this.f18856a);
    L14:
        LiveBrightnessService.access$setHaveChanged$p(this.f18857b.f105242a, true);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
