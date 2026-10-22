package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002!\"J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0017H\u0007J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0017H\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0017H\u0007¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LynxLottieView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/d;", "", "status", "", "setPlay", "", "enable", "setAutoPlay", "", "speed", "setSpeed", "progress", "setProgress", "objectFit", "setObjectFit", "setKeepLastFrame", "json", "setJson", "loop", "setLoop", "", "setRepeat", "src", "setSrc", "rate", "setUpdateRate", "startFrame", "setStartFrame", "endFrame", "setEndFrame", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxLottieView extends LynxUI<LottieAnimationView> implements com.airbnb.lottie.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f82711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f82712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f82713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<String> f82714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f82715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f82716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f82717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f82718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f82719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f82720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f82721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f82722l;

    public interface a {
        void onFailed();

        void onSuccess(Bitmap r100);
    }

    public static final class b {
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxLottieView f82723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f82724b;

        @Override // com.bytedance.android.live.lynx.ui.LynxLottieView.a
        public final void onFailed() {
            String r100 = this.f82723a.f82722l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.lynx.ui.LynxLottieView.a
        public final void onSuccess(Bitmap r100) {
            Ref.ObjectRef r101 = this.f82724b;
            if (r100 == null) goto L5;
            T r102 = Bitmap.createBitmap(r100);
        L6:
            r101.element = r102;
            return;
        L5:
            r102 = 0;
            goto L6
        }

        public c(LynxLottieView r100, Ref.ObjectRef r101, String r102) {
            this.f82723a = r100;
            this.f82724b = r101;
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        ((LottieAnimationView) this.mView).removeAllAnimatorListeners();
        ((LottieAnimationView) this.mView).removeAllUpdateListeners();
        ((LottieAnimationView) this.mView).cancelAnimation();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f82712b == true) goto L5;
    L9:
        this.f82719i = false;
        return;
    L5:
        if (this.f82713c == true) goto L9;
        if (this.f82719i == true) goto L9;
        ((LottieAnimationView) this.mView).playAnimation();
        goto L9
    }

    public LynxLottieView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f82711a = true;
        this.f82712b = true;
        this.f82715e = 6;
        this.f82717g = -1;
        this.f82720j = -1;
        this.f82721k = -1;
    }

    public static final /* synthetic */ LottieAnimationView M(LynxLottieView r100) {
        return (LottieAnimationView) r100.mView;
    }

    public final void O(String r100) {
        int r101 = StringsKt.lastIndexOf$default(r100, '/', 0, false, 6, null);
        if (r101 <= 0) goto L6;
        this.f82722l = r100.substring(0, r101);
        ((LottieAnimationView) this.mView).setImageAssetDelegate(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        LottieAnimationView r101 = new LottieAnimationView(r100);
        r101.useHardwareAcceleration(true);
        r101.enableMergePathsForKitKatAndAbove(true);
        r101.addAnimatorListener(new j(this));
        r101.addAnimatorUpdateListener(new k(this));
        Field r102 = LottieAnimationView.class.getDeclaredField("autoPlay");     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r102.set(r101, Boolean.TRUE);     // Catch: Exception -> L5
    L4:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, android.graphics.Bitmap] */
    @Override // com.airbnb.lottie.d
    public final Bitmap q(com.airbnb.lottie.h r110) {
        if (TextUtils.isEmpty(this.f82722l) == true) goto L46;
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = null;
        String r101 = HTTP.URL_DEFAULT + r110.f24782e + HTTP.URL_DEFAULT + r110.f24781d;
        String r102 = this.f82722l;
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(r102, "file:/", false, 2, null) == false) goto L15;
        StringBuilder r103 = new StringBuilder();
        String r104 = this.f82722l;
        Intrinsics.checkNotNull(r104);
        String r105 = this.f82722l;
        Intrinsics.checkNotNull(r105);
        int r106 = r105.length();
        if (r104 == null) goto L14;
        r103.append(r104.substring(6, r106));
        r103.append(r101);
        String r107 = r103.toString();
        if (new PolarisFileWrapper(r107).exists() == false) goto L11;
        r100.element = BitmapFactory.decodeFile(r107);
    L28:
        T r108 = r100.element;
        if (((Bitmap) r108) != null) goto L49;
        return null;
    L49:
        Bitmap r109 = (Bitmap) r108;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r109);     // Catch: Exception -> L42
        if (r109.getWidth() != r110.f24778a) goto L36;
        Bitmap r111 = (Bitmap) r100.element;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L42
        if (r111.getHeight() != r110.f24779b) goto L36;
        return (Bitmap) r100.element;
    L36:
        Bitmap r112 = (Bitmap) r100.element;     // Catch: Exception -> L42
        if (r112 == null) goto L39;
        Bitmap r113 = Bitmap.createScaledBitmap(r112, r110.f24778a, r110.f24779b, false);     // Catch: Exception -> L42
    L40:
        Bitmap r114 = (Bitmap) r100.element;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r114);     // Catch: Exception -> L42
        r114.recycle();     // Catch: Exception -> L42
        return r113;
    L39:
        r113 = null;
    L42:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return null;
    L11:
        return null;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L15:
        String r115 = this.f82722l;
        Intrinsics.checkNotNull(r115);
        if (StringsKt.startsWith$default(r115, "http://", false, 2, null) == true) goto L19;
        String r116 = this.f82722l;
        Intrinsics.checkNotNull(r116);
        if (StringsKt.startsWith$default(r116, "https://", false, 2, null) == false) goto L28;
    L19:
        String r117 = Intrinsics.stringPlus(this.f82722l, r101);
        c r118 = new c(this, r100, r117);
        Intrinsics.checkNotNullParameter(r117, "url");
        Intrinsics.checkNotNullParameter(r118, "callback");
        DataSource<CloseableReference<CloseableImage>> r119 = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(getLynxContext(), r117, false))).build(), "tt-lottie");
        if (r119 != null) goto L22;
        r118.onFailed();
        goto L28
    L22:
        CountDownLatch r120 = new CountDownLatch(1);
        l r121 = new l(r118, r120, r119);
        r119.subscribe(r121, CallerThreadExecutor.getInstance());
    L27:
        r121.onFailure(null);
        goto L28
    L24:
        if (r120.await(3, TimeUnit.SECONDS) == true) goto L28;
        r121.onFailure(null);     // Catch: InterruptedException -> L27
        goto L28
    L46:
        return null;
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public final void setAutoPlay(boolean r100) {
        this.f82712b = r100;
    }

    @LynxProp(defaultInt = -1, name = "endframe")
    public final void setEndFrame(int r100) {
        if (r100 >= 0) goto L4;
        ((LottieAnimationView) this.mView).setMaxFrame(Integer.MAX_VALUE);
    L4:
        ((LottieAnimationView) this.mView).setMaxFrame(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L5;
        Set<String> r101 = r100.keySet();
    L6:
        this.f82714d = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @LynxProp(name = "json")
    public final void setJson(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L19;
        ((LottieAnimationView) this.mView).setAnimationFromJson(r100, null);
        if (this.f82713c == false) goto L13;
    L16:
        ((LottieAnimationView) this.mView).cancelAnimation();
    L17:
        this.f82713c = false;
        this.f82712b = true;
        return;
    L13:
        if (this.f82712b == false) goto L16;
        ((LottieAnimationView) this.mView).playAnimation();
        goto L17
    L19:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @LynxProp(defaultBoolean = true, name = "keeplastframe")
    public final void setKeepLastFrame(boolean r100) {
        this.f82711a = r100;
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public final void setLoop(boolean r100) {
        if (r100 == false) goto L4;
        ((LottieAnimationView) this.mView).setRepeatCount(-1);
        return;
    L4:
        ((LottieAnimationView) this.mView).setRepeatCount(0);
    }

    @LynxProp(name = "objectfit")
    public final void setObjectFit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objectFit");
        int r101 = r100.hashCode();
        if (r101 == 94852023) goto L11;
        if (r101 == 951526612) goto L8;
    L13:
        ImageView.ScaleType r102 = ImageView.ScaleType.CENTER;
    L14:
        ((LottieAnimationView) this.mView).setScaleType(r102);
        return;
    L8:
        if (r100.equals(LynxVideoManagerLite.CONTAIN) == false) goto L13;
        r102 = ImageView.ScaleType.FIT_CENTER;
        goto L14
    L11:
        if (r100.equals("cover") == false) goto L13;
        r102 = ImageView.ScaleType.CENTER_CROP;
        goto L14
    }

    @LynxProp(name = "playstatus")
    public final void setPlay(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (Intrinsics.areEqual("play", r100) == false) goto L6;
        ((LottieAnimationView) this.mView).playAnimation();
        this.f82719i = true;
        this.f82713c = false;
        return;
    L6:
        if (Intrinsics.areEqual("pause", r100) == false) goto L10;
        ((LottieAnimationView) this.mView).cancelAnimation();
        this.f82713c = true;
        return;
    }

    @LynxProp(name = "progress")
    public final void setProgress(float r100) {
        ((LottieAnimationView) this.mView).setProgress(r100);
    }

    @LynxProp(defaultInt = -1, name = "repetcount")
    public final void setRepeat(int r100) {
        if (r100 >= 0) goto L4;
        r100 = -1;
    L4:
        ((LottieAnimationView) this.mView).setRepeatCount(r100);
    }

    @LynxProp(name = "speed")
    public final void setSpeed(float r100) {
        ((LottieAnimationView) this.mView).setSpeed(r100);
    }

    @LynxProp(name = "src")
    public final void setSrc(String r110) {
        this.f82722l = null;
        ((LottieAnimationView) this.mView).setImageAssetDelegate(null);
        if (TextUtils.isEmpty(r110) == false) goto L46;
        return;
    L46:
        String r100 = d7a.a.b(getLynxContext(), r110, false);     // Catch: Exception -> L43
        if (r100 == null) goto L41;
        Uri r111 = UriProtector.parse(r100);     // Catch: Exception -> L43
        String r101 = r111.getScheme();     // Catch: Exception -> L43
        if (r101 != null) goto L12;
        return;
    L12:
        switch(r101.hashCode()) {
            case -1408207997: goto L30;
            case 3143036: goto L27;
            case 3213448: goto L21;
            case 93121264: goto L18;
            case 99617003: goto L15;
            default: goto L56;
        };
    L56:
        return;
    L15:
        if (r101.equals("https") == true) goto L23;
        return;
    L23:
        if (StringsKt.endsWith$default(r100, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L25;
        O(r100);     // Catch: Exception -> L43
    L25:
        ((LottieAnimationView) this.mView).setAnimationFromUrl(Uri.decode(r100));     // Catch: Exception -> L43
        return;
    L18:
        if (r101.equals(UriUtil.LOCAL_ASSET_SCHEME) == true) goto L31;
        return;
    L31:
        String r112 = r111.getPath();     // Catch: Exception -> L43
        if (r112 != null) goto L35;
        return;
    L35:
        if (StringsKt.startsWith$default(r112, HTTP.URL_DEFAULT, false, 2, null) != true) goto L37;
        r112 = r112.substring(1);     // Catch: Exception -> L43
    L37:
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L43
        if (StringsKt.endsWith$default(r112, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L40;
        ((LottieAnimationView) this.mView).setImageAssetsFolder(r112.substring(0, StringsKt.lastIndexOf$default(r112, '/', 0, false, 6, null)) + "/images/");     // Catch: Exception -> L43
    L40:
        ((LottieAnimationView) this.mView).setAnimation(r112);     // Catch: Exception -> L43
        return;
    L21:
        if (r101.equals("http") == true) goto L23;
        return;
    L27:
        if (r101.equals("file") == false) goto L52;
        O(r100);     // Catch: Exception -> L43
        ((LottieAnimationView) this.mView).setAnimation(new JsonReader(new PolarisFileReaderWrapper(r111.getPath())), r100);     // Catch: Exception -> L43
        return;
    L52:
        return;
    L30:
        if (r101.equals(ChameleonAssertResManager.ASSET_FOLDER) == true) goto L31;
        return;
    L41:
        ((LottieAnimationView) this.mView).setAnimationFromUrl(r110);     // Catch: Exception -> L43
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        e.toString();
    }

    @LynxProp(defaultInt = 0, name = "startframe")
    public final void setStartFrame(int r100) {
        ((LottieAnimationView) this.mView).setMinFrame(r100);
    }

    @LynxProp(defaultInt = 6, name = "rate")
    public final void setUpdateRate(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f82715e = r100;
    }

    @LynxProp(defaultBoolean = false, name = "play")
    public final void setPlay(boolean r100) {
        if (r100 == false) goto L5;
        this.f82719i = true;
        this.f82713c = false;
        return;
    L5:
        ((LottieAnimationView) this.mView).cancelAnimation();
        this.f82713c = true;
    }

    public static final void N(LynxLottieView r100, String r101, int r110, int r111, int r112) {
        Set<String> r102 = r100.f82714d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.contains(r101) != true) goto L16;
        LynxContext r103 = r100.getLynxContext();
        if (r103 == null) goto L14;
        EventEmitter r104 = r103.getEventEmitter();
        if (r104 == null) goto L15;
        r104.sendCustomEvent(new m(r110, r111, r112, r100.getSign(), r101));
        return;
    L15:
        return;
    L14:
        return;
    }
}
