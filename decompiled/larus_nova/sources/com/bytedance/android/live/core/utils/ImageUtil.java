package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public class ImageUtil {
    private static final String TAG = "ImageUtil";

    public interface LoadImageCallback {
        void onFailed(Exception r100);

        void onSuccess(Bitmap r100);
    }

    public class a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f66066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f66067b;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void e(py.k r100) {
            ALogger.i(ImageUtil.TAG, "[loadAntiFlink] load image stated " + r100.getUri() + " time " + System.currentTimeMillis());
        }

        public a(boolean r100, ImageView r101) {
            this.f66066a = r100;
            this.f66067b = r101;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r100, Exception r101) {
            ALogger.i(ImageUtil.TAG, "[loadAntiFlink] load image fail " + r100.getUri() + " Exception info" + r101.getMessage());
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r100, int r101, int r102, boolean r103) {
            long r104 = System.currentTimeMillis();
            if (this.f66066a == false) goto L5;
            this.f66067b.setTag(R.id.ttlive_tag_image_model_loaded_key, new Pair(r100, Long.valueOf(r104)));
        L5:
            ALogger.i(ImageUtil.TAG, "[loadAntiFlink] load image success " + r100.getUri() + " time " + r104);
        }
    }

    private ImageUtil() {
    }

    public static String getImageUrl(py.k r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (Lists.isEmpty(r100.getUrls()) == false) goto L7;
        return "";
    L7:
        return (String) ListProtector.get(r100.getUrls(), 0);
    }

    public static boolean isActivityOK(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == false) goto L8;
        Activity r101 = (Activity) r100;
        if (r101.isDestroyed() == false) goto L18;
        return false;
    L18:
        return !r101.isFinishing();
    L8:
        if ((r100 instanceof Application) == false) goto L10;
    L13:
        return true;
    L10:
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        return isActivityOK(((ContextWrapper) r100).getBaseContext());
    }

    public static void loadGifImage(ImageView r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r100.getContext()) == false) goto L10;
        FrescoLoader.with(r100.getContext()).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP).autoPlayAnimations(true).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
        return;
    }

    public static void loadImage(ImageView r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r100.getContext()) == false) goto L10;
        FrescoLoader.with(r100.getContext()).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
        return;
    }

    public static void loadRoundImage(ImageView r100, py.k r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r100.getContext()) == false) goto L9;
        FrescoLoader.with(r100.getContext()).load(r101).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
        return;
    }

    public static void loadImage(ImageView r100, Integer r101) {
        if (isActivityOK(r100.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader.with(r100.getContext()).load(r101.intValue()).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
    }

    public static void loadImage(ImageView r100, py.k r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r101.getUrls()) == true) goto L9;
        loadImage(r100, r101, 0);
        return;
    }

    public static void loadGifImage(ImageView r100, String r101, int r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r100.getContext()) == false) goto L10;
        FrescoLoader.with(r100.getContext()).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP).placeholder(r102).autoPlayAnimations(true).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
        return;
    }

    public static void loadImage(ImageView r100, String r101, ImageView.ScaleType r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r100.getContext()) == false) goto L10;
        FrescoLoader.with(r100.getContext()).load(r101).actualScaleType(r102).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
        return;
    }

    public static void loadRoundImageAntiFlink(ImageView r100, py.k r110, long r111) {
        if (r100 == null) goto L24;
        if (r110 != null) goto L5;
        return;
    L5:
        if (isActivityOK(r100.getContext()) == false) goto L26;
        j40.x1 r101 = j40.x1.f497321a;
        boolean r102 = r101.getValue().isAvatarLoadAntiFlink();
        long r103 = r101.getValue().getAntiFlinkDebounce();
        if (r102 == false) goto L22;
        Object r104 = r100.getTag(R.id.ttlive_tag_image_model_loaded_key);
        if ((r104 instanceof Pair) == false) goto L22;
        Pair r105 = (Pair) r104;
        Object r106 = r105.first;
        Object r107 = r105.second;
        if ((r106 instanceof py.k) == false) goto L22;
        if ((r107 instanceof Long) == false) goto L22;
        long r108 = System.currentTimeMillis() - ((Long) r107).longValue();
        ALogger.i(TAG, "[loadAntiFlink] try load image " + r110.getUri() + " old " + ((py.k) r106).getUri() + " duration " + r108);
        boolean r109 = r110.equalsOnlyUri(r106);
        if (r108 >= r103) goto L21;
        ALogger.i(TAG, "[loadAntiFlink] try load image equals " + r109);
        if (r109 == false) goto L22;
        ALogger.e(TAG, "[loadAntiFlink] skip load image " + r110.getUri());
        return;
    L21:
        ALogger.i(TAG, "[loadAntiFlink] try load image equals " + r109 + ", duration = " + r108 + ", stack = " + Log.getStackTraceString(new Exception()));
    L22:
        FrescoLoader.with(r100.getContext()).fadeDuration((int) r111).load(r110).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(r110, new a(r102, r100), false)).into(r100);
        return;
    L26:
        return;
    }

    public static void loadRoundImageWithRadius(ImageView r100, py.k r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r100.getContext()) == false) goto L9;
        FrescoLoader.with(r100.getContext()).load(r101).cornersRadius(r102).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
        return;
    }

    public static void loadImage(ImageView r100, Integer r101, ImageView.ScaleType r102) {
        if (isActivityOK(r100.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader.with(r100.getContext()).load(r101.intValue()).actualScaleType(r102).controllerListener(new ImageLoader.e(null, null, false)).into(r100);
    }

    public static void loadImage(ImageView r100, py.k r101, int r102) {
        loadImage(r100, r101, -1, -1, r102, null);
    }

    public static void loadImage(ImageView r100, py.k r101, p0 r102) {
        loadImage(r100, r101, 0, r102);
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, ImageView.ScaleType r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L7;
        return;
    L7:
        if (CollectionUtils.isEmpty(r101.getUrls()) == false) goto L10;
        return;
    L10:
        if (isActivityOK(r100.getContext()) == true) goto L12;
        return;
    L12:
        FrescoLoader r104 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP).placeholderScaleType(r103);
        if (r102 <= 0) goto L15;
        r104.placeholder(r102);
    L15:
        r104.controllerListener(new ImageLoader.e(r101, null, false));
        r104.into(r100);
    }

    public static void loadImageWithRadius(ImageView r100, py.k r101, int r102, int r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r100.getContext()) == false) goto L12;
        FrescoLoader r104 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).cornersRadius(s1.f(r103)).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r102 == 0) goto L9;
        r104.placeholder(r102);
    L9:
        r104.controllerListener(new ImageLoader.e(r101, null, false));
        r104.into(r100);
        return;
    }

    public static void loadRoundResource(ImageView r100, int r101, int r102, int r103) {
        if (isActivityOK(r100.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r104 = FrescoLoader.with(r100.getContext()).load(r101).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false));
        if (r102 <= 0) goto L9;
        if (r103 <= 0) goto L9;
        r104.resize(r102, r103);
    L9:
        r104.into(r100);
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, p0 r103) {
        loadImage(r100, r101, -1, -1, r102, r103);
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, int r110, p0 r111) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r101.getUrls()) == false) goto L6;
        return;
    L6:
        if (isActivityOK(r100.getContext()) == false) goto L12;
        loadImage(r100, r101, r102, r110, -1, r111);
        return;
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, int r110, int r111, p0 r112) {
        loadImage(r100, r101, r102, r110, false, r111, r112);
    }

    public static void loadRoundImage(ImageView r100, py.k r101, int r102, int r103, int r104, p0 r105) {
        if (isActivityOK(r100.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r106 = FrescoLoader.with(r100.getContext()).load(r101).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r102 <= 0) goto L9;
        if (r103 <= 0) goto L9;
        r106.resize(r102, r103);
    L9:
        if (r104 <= 0) goto L12;
        r106.placeholder(r104);
    L12:
        if (r105 == null) goto L14;
        r106.controllerListener(new ImageLoader.e(r101, r105, false));
    L15:
        r106.into(r100);
        return;
    L14:
        r106.controllerListener(new ImageLoader.e(null, null, false));
        goto L15
    }

    public static void loadRoundImageWithContentDetect(ImageView r100, py.k r101, int r102, int r103, int r104, p0 r105) {
        if (isActivityOK(r100.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r106 = FrescoLoader.with(r100.getContext()).load(r101).roundAsCircle().postProcessor(new rw2.a()).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r102 <= 0) goto L9;
        if (r103 <= 0) goto L9;
        r106.resize(r102, r103);
    L9:
        if (r104 <= 0) goto L12;
        r106.placeholder(r104);
    L12:
        if (r105 == null) goto L14;
        r106.controllerListener(new ImageLoader.e(r101, r105, false));
    L15:
        r106.into(r100);
        return;
    L14:
        r106.controllerListener(new ImageLoader.e(null, null, false));
        goto L15
    }

    public static void loadImage(ImageView r100, py.k r101, int r110, int r111, boolean r112, int r113, p0 r114) {
        loadImage(r100, r101, r110, r111, r112, r113, ImageView.ScaleType.CENTER_CROP, r114);
    }

    public static void loadImageWithRadii(ImageView r100, py.k r101, int r102, float r103, float r104, float r105, float r106) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r100.getContext()) == false) goto L12;
        FrescoLoader r107 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).cornersRadii(s1.f(r103), s1.f(r104), s1.f(r105), s1.f(r106)).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r102 == 0) goto L9;
        r107.placeholder(r102);
    L9:
        r107.controllerListener(new ImageLoader.e(r101, null, false));
        r107.into(r100);
        return;
    }

    public static void loadImage(ImageView r110, py.k r111, int r112, int r113, boolean r114, int r115, boolean r116, p0 r117) {
        loadImage(r110, r111, r112, r113, r114, r115, ImageView.ScaleType.CENTER_CROP, r116, r117, null);
    }

    public static void loadImageWithRadiiAndScaleType(ImageView r100, py.k r101, int r102, float r103, float r104, float r105, float r106, ImageView.ScaleType r107) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r100.getContext()) == false) goto L12;
        FrescoLoader r108 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).cornersRadii(s1.f(r103), s1.f(r104), s1.f(r105), s1.f(r106)).load(r101).actualScaleType(r107);
        if (r102 == 0) goto L9;
        r108.placeholder(r102);
    L9:
        r108.controllerListener(new ImageLoader.e(r101, null, false));
        r108.into(r100);
        return;
    }

    public static void loadImage(ImageView r110, py.k r111, int r112, int r113, boolean r114, int r115, ImageView.ScaleType r116, p0 r117) {
        loadImage(r110, r111, r112, r113, r114, r115, r116, false, r117, null);
    }

    public static void loadRoundImageWithBorder(ImageView r100, py.k r101, int r102, int r103, int r104, int r105, float r106, boolean r107, p0 r108) {
        if (isActivityOK(r100.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r109 = FrescoLoader.with(r100.getContext()).load(r101).roundAsCircle().border(r105, r106, r107).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r102 <= 0) goto L9;
        if (r103 <= 0) goto L9;
        r109.resize(r102, r103);
    L9:
        if (r104 <= 0) goto L12;
        r109.placeholder(r104);
    L12:
        if (r108 == null) goto L14;
        r109.controllerListener(new ImageLoader.e(r101, r108, false));
    L15:
        r109.into(r100);
        return;
    L14:
        r109.controllerListener(new ImageLoader.e(null, null, false));
        goto L15
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, int r103, boolean r104, Drawable r105, ImageView.ScaleType r106, boolean r107, p0 r110, String r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L9;
        if (r110 == null) goto L31;
        r110.b(r101, new IllegalArgumentException("imageModel == null"));
        return;
    L31:
        return;
    L9:
        if (CollectionUtils.isEmpty(r101.getUrls()) == false) goto L14;
        if (r110 == null) goto L32;
        r110.b(r101, new IllegalArgumentException("CollectionUtils.isEmpty(imageModel.urls)"));
        return;
    L32:
        return;
    L14:
        if (isActivityOK(r100.getContext()) == true) goto L18;
        if (r110 == null) goto L33;
        r110.b(r101, new IllegalArgumentException("!isActivityOK(view.getContext())"));
        return;
    L33:
        return;
    L18:
        FrescoLoader r108 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).load(r101).actualScaleType(r106);
        if (r102 <= 0) goto L22;
        if (r103 <= 0) goto L22;
        r108.resize(r102, r103);
    L22:
        if (r105 == null) goto L24;
        r108.placeholder(r105);
        r108.placeholderScaleType(r106);
    L24:
        if (r104 == false) goto L27;
        r108.autoPlayAnimations(true);
    L27:
        if (TextUtils.isEmpty(r111) == true) goto L29;
        r108.customCacheName(r111);
    L29:
        r108.controllerListener(new ImageLoader.e(r101, r110, r107));
        r108.into(r100);
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, int r103, boolean r104, int r105, ImageView.ScaleType r106, boolean r107, p0 r110, String r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L9;
        if (r110 == null) goto L31;
        r110.b(r101, new IllegalArgumentException("imageModel == null"));
        return;
    L31:
        return;
    L9:
        if (CollectionUtils.isEmpty(r101.getUrls()) == false) goto L14;
        if (r110 == null) goto L32;
        r110.b(r101, new IllegalArgumentException("CollectionUtils.isEmpty(imageModel.urls)"));
        return;
    L32:
        return;
    L14:
        if (isActivityOK(r100.getContext()) == true) goto L18;
        if (r110 == null) goto L33;
        r110.b(r101, new IllegalArgumentException("!isActivityOK(view.getContext())"));
        return;
    L33:
        return;
    L18:
        FrescoLoader r108 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).load(r101).actualScaleType(r106);
        if (r102 <= 0) goto L22;
        if (r103 <= 0) goto L22;
        r108.resize(r102, r103);
    L22:
        if (r105 <= 0) goto L24;
        r108.placeholder(r105);
    L24:
        if (r104 == false) goto L27;
        r108.autoPlayAnimations(true);
    L27:
        if (TextUtils.isEmpty(r111) == true) goto L29;
        r108.customCacheName(r111);
    L29:
        r108.controllerListener(new ImageLoader.e(r101, r110, r107));
        r108.into(r100);
    }

    public static void loadImage(ImageView r100, py.k r101, int r102, int r103, boolean r104, Drawable r105, ImageView.ScaleType r106, boolean r107, p0 r110, String r111, int r112) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L9;
        if (r110 == null) goto L31;
        r110.b(r101, new IllegalArgumentException("imageModel == null"));
        return;
    L31:
        return;
    L9:
        if (CollectionUtils.isEmpty(r101.getUrls()) == false) goto L14;
        if (r110 == null) goto L32;
        r110.b(r101, new IllegalArgumentException("CollectionUtils.isEmpty(imageModel.urls)"));
        return;
    L32:
        return;
    L14:
        if (isActivityOK(r100.getContext()) == true) goto L18;
        if (r110 == null) goto L33;
        r110.b(r101, new IllegalArgumentException("!isActivityOK(view.getContext())"));
        return;
    L33:
        return;
    L18:
        FrescoLoader r113 = FrescoLoader.with(r100.getContext()).load(getImageUrl(r101)).load(r101).cornersRadius(r112).actualScaleType(r106);
        if (r102 <= 0) goto L22;
        if (r103 <= 0) goto L22;
        r113.resize(r102, r103);
    L22:
        if (r105 == null) goto L24;
        r113.placeholder(r105);
        r113.placeholderScaleType(r106);
    L24:
        if (r104 == false) goto L27;
        r113.autoPlayAnimations(true);
    L27:
        if (TextUtils.isEmpty(r111) == true) goto L29;
        r113.customCacheName(r111);
    L29:
        r113.controllerListener(new ImageLoader.e(r101, r110, r107));
        r113.into(r100);
    }
}
