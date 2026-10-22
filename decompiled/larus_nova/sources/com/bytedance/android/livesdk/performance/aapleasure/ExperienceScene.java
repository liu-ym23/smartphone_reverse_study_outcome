package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/performance/aapleasure/ExperienceScene;", "", "", BuyNowCloseMethod.MASK, "Ljava/lang/String;", "getMask", "()Ljava/lang/String;", "sleep", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExperienceScene extends Enum<ExperienceScene> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExperienceScene[] f154410a = null;
    public static final ExperienceScene sleep = null;
    private final String mask;

    static {
        ExperienceScene r100 = new ExperienceScene();
        sleep = r100;
        f154410a = new ExperienceScene[]{r100};
    }

    public static ExperienceScene valueOf(String r100) {
        return (ExperienceScene) r27.a.a(ExperienceScene.class, r100);
    }

    public static ExperienceScene[] values() {
        return (ExperienceScene[]) f154410a.clone();
    }

    public ExperienceScene() {
        super("sleep", 0);
        this.mask = "experience_scene_sleep_mode";
    }

    public final String getMask() {
        return this.mask;
    }
}
