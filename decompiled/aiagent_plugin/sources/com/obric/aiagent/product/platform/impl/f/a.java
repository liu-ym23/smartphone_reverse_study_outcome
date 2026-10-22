package com.obric.aiagent.product.platform.impl.f;

import android.app.Application;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: CommonVibrateFeedback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IVibrateFeedback {
    private static final String TAG = "CommonVibrateFeedback";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0405a f18843a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f18844b;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CommonVibrateFeedback.kt */
    public static final class C0405a {
        public /* synthetic */ C0405a(h r1) {
            this();
        }

        private C0405a() {
        }
    }

    /* JADX INFO: compiled from: CommonVibrateFeedback.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18845a = null;

        static {
            int[] r0 = new int[FeedbackType.values().length];
            r0[FeedbackType.WAKE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[FeedbackType.LONG_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[FeedbackType.TICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[FeedbackType.WARNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[FeedbackType.CONFIRM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[FeedbackType.RIGID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[FeedbackType.SOFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f18845a = r0;
        }
    }

    static {
        f18843a = new C0405a(null);
    }

    /* JADX INFO: renamed from: lambda$beAkE58UcQ8_eHNTf-pulqpnbeU, reason: not valid java name */
    public static /* synthetic */ Vibrator m227lambda$beAkE58UcQ8_eHNTfpulqpnbeU() {
        return b();
    }

    public a() {
        this.f18844b = g.a($$Lambda$a$beAkE58UcQ8_eHNTfpulqpnbeU.INSTANCE);
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(String r1) {
        IVibrateFeedback.DefaultImpls.performVibratorSmtFeedback(this, r1);
    }

    private final Vibrator a() {
        return (Vibrator) ZeusTransformUtils.preCheckCast(this.f18844b.b(), Vibrator.class, "com.obric.aiagent.plugin");
    }

    private static final Vibrator b() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("vibrator");
        if (ZeusTransformUtils.instanceOf(r0, Vibrator.class) == true) goto L7;
        return null;
    L7:
        return (Vibrator) ZeusTransformUtils.preCheckCast(r0, Vibrator.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(FeedbackType r4) {
        o.e(r4, "feedbackType");
        if (a() != null) goto L7;
        ISysLogDepend.Companion.w(TAG, "vibrator is null");
        return;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        VibrationEffect r0 = a(r4);
        if (r0 != null) goto L12;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        ISysLogDepend.Companion.w(TAG, "not found effect for " + r4.getTypeName());
        return;
    L12:
        Vibrator r5 = a();
        if (r5 == null) goto L17;
        r5.vibrate(r0);
        return;
    L17:
        return;
    L15:
        ISysLogDepend.Companion.w(TAG, "api level is too low. " + Build.VERSION.SDK_INT);
    }

    private final VibrationEffect a(FeedbackType r3) {
        switch(b.f18845a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new k();
    L14:
        return VibrationEffect.createPredefined(2);
    L15:
        return VibrationEffect.createPredefined(0);
    L16:
        return VibrationEffect.createPredefined(1);
    L17:
        return VibrationEffect.createPredefined(1);
    L18:
        return VibrationEffect.createPredefined(2);
    L19:
        return VibrationEffect.createPredefined(5);
    L13:
        return VibrationEffect.createPredefined(5);
    }
}
