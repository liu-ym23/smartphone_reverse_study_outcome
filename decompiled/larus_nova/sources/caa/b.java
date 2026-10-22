package caa;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements z9a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f22973a;

    public static final class a {
    }

    /* JADX INFO: renamed from: caa.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0421b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22974a = null;

        static {
            int[] r100 = new int[FeedbackType.values().length];
            r100[FeedbackType.WAKE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[FeedbackType.LONG_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[FeedbackType.TICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[FeedbackType.WARNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[FeedbackType.CONFIRM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[FeedbackType.RIGID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[FeedbackType.SOFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f22974a = r100;
        }
    }

    static {
    }

    public b() {
        this.f22973a = LazyKt.lazy(new caa.a());
    }

    @Override // z9a.a
    public final void a(FeedbackType r100) {
        Intrinsics.checkNotNullParameter(r100, "feedbackType");
        if (((Vibrator) this.f22973a.getValue()) != null) goto L6;
        ISysLogDepend.f384998c.w("CommonVibrateFeedback", "vibrator is null");
        return;
    L6:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 29) goto L9;
        ISysLogDepend.f384998c.w("CommonVibrateFeedback", "api level is too low. " + r101);
        return;
    L9:
        switch(C0421b.f22974a[r100.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        VibrationEffect r102 = VibrationEffect.createPredefined(2);
    L19:
        if (r102 != null) goto L22;
        ISysLogDepend.f384998c.w("CommonVibrateFeedback", "not found effect for " + r100.getTypeName());
        return;
    L22:
        Vibrator r103 = (Vibrator) this.f22973a.getValue();
        if (r103 == null) goto L27;
        r103.vibrate(r102);
        return;
    L27:
        return;
    L13:
        r102 = VibrationEffect.createPredefined(0);
        goto L19
    L14:
        r102 = VibrationEffect.createPredefined(1);
        goto L19
    L15:
        r102 = VibrationEffect.createPredefined(1);
        goto L19
    L16:
        r102 = VibrationEffect.createPredefined(2);
        goto L19
    L17:
        r102 = VibrationEffect.createPredefined(5);
        goto L19
    L18:
        r102 = VibrationEffect.createPredefined(5);
        goto L19
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
