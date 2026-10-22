package com.bytedance.android.livesdk.chatroom.brightness;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.LiveData;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J%\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0017\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001e\u0010\u001d\u001a\u00020\u00102\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\tH\u0016R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R*\u0010+\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0%\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010!R&\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0%0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010)¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/brightness/LiveBrightnessService;", "Lcom/bytedance/android/livesdkapi/brightness/ILiveBrightnessService;", "Lcom/bytedance/android/livesdkapi/service/LevelAbility;", "Landroid/app/Activity;", "activity", "", "getBrightRate", "getMinValue", "getMaxValue", "", "getSystemMaxBrightnessRaw", "getSystemValue", "getEnvBrightnessValue", "getAutoBrightnessStatus", "", "isSearchScene", "", "autoBrightnessSet", BasicTestActionHandler.TEST_ACTION_RESET, "scale", "adjustWindowBright", "(Landroid/app/Activity;F)Ljava/lang/Float;", "bright", "setBright", "resetSystemBright", "", "", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "onPropertyChange", "level", "onLevelChange", "systemMaxBrightnessRawCache", "I", "Ljava/lang/ref/WeakReference;", "activityContext", "Ljava/lang/ref/WeakReference;", "", "noStrategyMark", "Ljava/util/Map;", "haveChanged", "Z", "Landroidx/lifecycle/LiveData;", "brightnessStrategy", "Landroidx/lifecycle/LiveData;", "adjustTimes", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "brightnessStrategyObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "forbid", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveBrightnessService implements ILiveBrightnessService, LevelAbility {
    private static final float BRIGHTNESS_MAX_VALUE = 1.0f;
    private static final float BRIGHTNESS_MIN_VALUE = 0.0f;
    public static final a Companion = null;
    private static final int OFFICAL_MAX_RAW = 255;
    public static final String TAG = "LiveBrightnessUtil";
    private static final int XIAOMI_MAX_RAW = 1024;
    private WeakReference<Activity> activityContext;
    private int adjustTimes;
    private LiveData<Map<String, String>> brightnessStrategy;
    private final Observer<Map<String, String>> brightnessStrategyObserver;
    private boolean forbid;
    private boolean haveChanged;
    private final Map<String, String> noStrategyMark;
    private int systemMaxBrightnessRawCache;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBrightnessService f105242a;

        public b(LiveBrightnessService r100) {
            this.f105242a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Map r101 = (Map) r100;
            if (Intrinsics.areEqual(r101, LiveBrightnessService.access$getNoStrategyMark$p(this.f105242a)) == true) goto L89;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L78
            WeakReference r103 = LiveBrightnessService.access$getActivityContext$p(this.f105242a);     // Catch: Throwable -> L78
            Boolean r104 = null;
            if (r103 == null) goto L12;
            Activity r105 = (Activity) r103.get();     // Catch: Throwable -> L78
            if (r105 == null) goto L12;
            Window r106 = r105.getWindow();     // Catch: Throwable -> L78
            if (r106 == null) goto L12;
            WindowManager.LayoutParams r107 = r106.getAttributes();     // Catch: Throwable -> L78
        L14:
            if (r101.isEmpty() == true) goto L16;
            String r108 = (String) r101.get(PickerReporterConstants.KEY.TARGET);     // Catch: Throwable -> L78
            if (r108 == null) goto L33;
            Float r109 = Float.valueOf(CastFloatProtector.parseFloat(r108));     // Catch: Throwable -> L78
        L34:
            String r110 = (String) r101.get("smooth");     // Catch: Throwable -> L78
            if (r110 == null) goto L37;
            r104 = Boolean.valueOf(Boolean.parseBoolean(r110));     // Catch: Throwable -> L78
        L37:
            String r111 = (String) r101.get(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT);     // Catch: Throwable -> L78
            if (r111 == null) goto L40;
            int r112 = CastIntegerProtector.parseInt(r111);     // Catch: Throwable -> L78
        L41:
            if (r109 == null) goto L86;
            if (r112 != (-1)) goto L44;
        L46:
            WeakReference r113 = LiveBrightnessService.access$getActivityContext$p(this.f105242a);     // Catch: Throwable -> L78
            if (r113 == null) goto L55;
            Activity r114 = (Activity) r113.get();     // Catch: Throwable -> L78
            if (r114 == null) goto L55;
            Window r115 = r114.getWindow();     // Catch: Throwable -> L78
            if (r115 == null) goto L55;
            WindowManager.LayoutParams r116 = r115.getAttributes();     // Catch: Throwable -> L78
            if (r116 == null) goto L55;
            float r117 = r116.screenBrightness;     // Catch: Throwable -> L78
        L57:
            if (r117 != (-1.0f)) goto L59;
            r117 = r109.floatValue();     // Catch: Throwable -> L78
        L59:
            LiveBrightnessService r118 = this.f105242a;     // Catch: Throwable -> L78
            LiveBrightnessService.access$setAdjustTimes$p(r118, LiveBrightnessService.access$getAdjustTimes$p(r118) + 1);     // Catch: Throwable -> L78
            if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L66;
            ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{r117, r109.floatValue()});     // Catch: Throwable -> L78
            String r120 = (String) r101.get("duration");     // Catch: Throwable -> L78
            if (r120 == null) goto L64;
            long r121 = CastLongProtector.parseLong(r120);     // Catch: Throwable -> L78
        L65:
            ValueAnimator r122 = r119.setDuration(r121);     // Catch: Throwable -> L78
            r122.addUpdateListener(new bg1.a(r107, this, r101));     // Catch: Throwable -> L78
            r122.start();     // Catch: Throwable -> L78
        L76:
            Object r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L78
        L81:
            if (Result.m9452exceptionOrNullimpl(r123) == null) goto L88;
            ALogger.i(LiveBrightnessService.TAG, "Brightness changed fail");
            return;
        L88:
            return;
        L64:
            r121 = 1000;
            goto L65
        L66:
            if (r107 == null) goto L68;
            r107.screenBrightness = r109.floatValue();     // Catch: Throwable -> L78
        L68:
            WeakReference r124 = LiveBrightnessService.access$getActivityContext$p(this.f105242a);     // Catch: Throwable -> L78
            if (r124 == null) goto L75;
            Activity r125 = (Activity) r124.get();     // Catch: Throwable -> L78
            if (r125 == null) goto L75;
            Window r126 = r125.getWindow();     // Catch: Throwable -> L78
            if (r126 == null) goto L75;
            r126.setAttributes(r107);     // Catch: Throwable -> L78
        L75:
            LiveBrightnessService.access$setHaveChanged$p(this.f105242a, true);     // Catch: Throwable -> L78
        L55:
            r117 = -1.0f;
            goto L57
        L44:
            if (LiveBrightnessService.access$getAdjustTimes$p(this.f105242a) < r112) goto L46;
            return;
        L86:
            return;
        L40:
            r112 = -1;
            goto L41
        L33:
            r109 = null;
            goto L34
        L16:
            if (LiveBrightnessService.access$getHaveChanged$p(this.f105242a) == false) goto L76;
            IMiddlewareHostApp r127 = (IMiddlewareHostApp) k.f(IMiddlewareHostApp.class);     // Catch: Throwable -> L78
            if (r127 == null) goto L76;
            if (r127.getMainActivity() == null) goto L76;
            if (r107 == null) goto L23;
            r107.screenBrightness = -1.0f;     // Catch: Throwable -> L78
        L23:
            WeakReference r128 = LiveBrightnessService.access$getActivityContext$p(this.f105242a);     // Catch: Throwable -> L78
            if (r128 == null) goto L76;
            Activity r129 = (Activity) r128.get();     // Catch: Throwable -> L78
            if (r129 == null) goto L76;
            Window r130 = r129.getWindow();     // Catch: Throwable -> L78
            if (r130 == null) goto L76;
            r130.setAttributes(r107);     // Catch: Throwable -> L78
        L12:
            r107 = null;
        L78:
            th = move-exception;
            Result.Companion r131 = Result.Companion;
            r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L81
        }
    }

    static {
        Companion = new a();
    }

    private final float getMaxValue() {
        return 1.0f;
    }

    private final float getMinValue() {
        return 0.0f;
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public void reset() {
        this.adjustTimes = 0;
        this.activityContext = null;
        LiveData<Map<String, String>> r100 = this.brightnessStrategy;
        if (r100 == null) goto L5;
        r100.removeObserver(this.brightnessStrategyObserver);
    L5:
        this.brightnessStrategy = null;
    }

    private final int getSystemMaxBrightnessRaw() {
        int r100 = this.systemMaxBrightnessRawCache;
        if (r100 <= 0) goto L13;
        return r100;
    L13:
        Resources r101 = Resources.getSystem();     // Catch: Exception -> L12
        int r102 = r101.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");     // Catch: Exception -> L12
        if (r102 == 0) goto L9;
        int r103 = r101.getInteger(r102);     // Catch: Exception -> L12
    L10:
        this.systemMaxBrightnessRawCache = r103;
        return r103;
    L9:
        r103 = 255;
        goto L10
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public int getAutoBrightnessStatus() {
        IFeatureService r100 = (IFeatureService) k.f(IFeatureService.class);
        if (r100 == null) goto L10;
        z90.a r101 = r100.getFeatureManager();
        if (r101 == null) goto L11;
        Integer r102 = (Integer) r101.getFeature("auto_brightness_enable", -1);
        if (r102 != null) goto L9;
        return -1;
    L9:
        return r102.intValue();
    L11:
        return -1;
    L10:
        return -1;
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public int getEnvBrightnessValue() {
        IFeatureService r100 = (IFeatureService) k.f(IFeatureService.class);
        if (r100 == null) goto L10;
        z90.a r101 = r100.getFeatureManager();
        if (r101 == null) goto L11;
        Integer r102 = (Integer) r101.getFeature("cur_environment_brightness", -1);
        if (r102 != null) goto L9;
        return -1;
    L9:
        return r102.intValue();
    L11:
        return -1;
    L10:
        return -1;
    }

    public LiveBrightnessService() {
        k.l(ILiveBrightnessService.class, this);
        this.noStrategyMark = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("start", "-1"), TuplesKt.to("end", "-1"), TuplesKt.to("smooth", "false")});
        this.brightnessStrategyObserver = new b(this);
    }

    public static final /* synthetic */ WeakReference access$getActivityContext$p(LiveBrightnessService r100) {
        return r100.activityContext;
    }

    public static final /* synthetic */ int access$getAdjustTimes$p(LiveBrightnessService r100) {
        return r100.adjustTimes;
    }

    public static final /* synthetic */ boolean access$getHaveChanged$p(LiveBrightnessService r100) {
        return r100.haveChanged;
    }

    public static final /* synthetic */ Map access$getNoStrategyMark$p(LiveBrightnessService r100) {
        return r100.noStrategyMark;
    }

    private final float getBrightRate(Activity r100) {
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r102 == null) goto L7;
        float r103 = r102.screenBrightness;
    L9:
        if (r103 != (-1.0f)) goto L19;
        int r104 = Settings.System.getInt(r100.getContentResolver(), "screen_brightness");     // Catch: Throwable -> L16
        int r105 = getSystemMaxBrightnessRaw();     // Catch: Throwable -> L16
        if (Math.abs(r104) <= r105) goto L15;
        r105 = 1024;
    L15:
        return r104 / r105;
    L20:
        return r103;
    L19:
        return r103;
    L7:
        r103 = getMinValue();
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public int getSystemValue(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return (int) (getBrightRate(r100) * 100);
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L4;
        this.forbid = true;
    L6:
        return this.forbid;
    L4:
        this.forbid = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public void resetSystemBright(Activity r100) {
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L8;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.screenBrightness = -1.0f;
        r101.setAttributes(r102);
        return;
    L8:
        return;
    }

    public static final /* synthetic */ void access$setActivityContext$p(LiveBrightnessService r100, WeakReference r101) {
        r100.activityContext = r101;
    }

    public static final /* synthetic */ void access$setAdjustTimes$p(LiveBrightnessService r100, int r101) {
        r100.adjustTimes = r101;
    }

    public static final /* synthetic */ void access$setHaveChanged$p(LiveBrightnessService r100, boolean r101) {
        r100.haveChanged = r101;
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public Float adjustWindowBright(Activity r100, float r101) {
        float r102 = -1.0f;
        if (this.forbid == true) goto L5;
        if (r100 == null) goto L23;
        Window r103 = r100.getWindow();
        if (r103 == null) goto L23;
        float r104 = getBrightRate(r100);
        WindowManager.LayoutParams r105 = r103.getAttributes();
        float r106 = 0;
        if (r104 < r106) goto L25;
        if (r104 > 1) goto L25;
        if (r101 <= r106) goto L18;
        float r107 = ((1.0f - r104) * r101) + r104;
    L21:
        r105.screenBrightness = r107;
        r103.setAttributes(r105);
        ALogger.e(TAG, "bright:" + r104 + ",adjustBright:" + r107);
        r102 = r104;
        goto L25
    L18:
        if (r101 >= r106) goto L20;
        r107 = (r101 * r104) + r104;
        goto L21
    L20:
        r107 = 0.0f;
    L25:
        return Float.valueOf(r102);
    L23:
        return null;
    L5:
        return Float.valueOf(-1.0f);
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public void autoBrightnessSet(Activity r100, boolean r101) {
        if (r100 == null) goto L13;
        if (r101 == true) goto L15;
        this.activityContext = new WeakReference(r100);
        IStrategyService r102 = (IStrategyService) k.f(IStrategyService.class);
        if (r102 == null) goto L8;
        LiveData<Map<String, String>> r103 = IStrategyService.a.a(r102, "live_auto_brightness", this.noStrategyMark, false, 12);
    L9:
        this.brightnessStrategy = r103;
        if (r103 == null) goto L14;
        r103.observeForever(this.brightnessStrategyObserver);
        return;
    L14:
        return;
    L8:
        r103 = null;
        goto L9
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.brightness.ILiveBrightnessService
    public void setBright(Activity r100, float r101) {
        if (r100 == null) goto L7;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L8;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.screenBrightness = r101;
        r102.setAttributes(r103);
        return;
    L8:
        return;
    }
}
