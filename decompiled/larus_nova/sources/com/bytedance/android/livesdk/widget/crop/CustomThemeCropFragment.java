package com.bytedance.android.livesdk.widget.crop;

import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.q;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.live.ui.t;
import com.bytedance.android.livesdk.utils.d0;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.common.utility.BitmapUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.Callable;
import jv2.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/widget/crop/CustomThemeCropFragment;", "Lcom/bytedance/android/livesdk/widget/crop/AbsCropFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomThemeCropFragment extends AbsCropFragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f161561y = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VideoThemeView f161562o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PreviewBoxViewV2 f161563p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Rect f161564q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f161565r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f161566s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f161567t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f161568u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f161569v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g f161570w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Uri f161571x;

    public static final class a {
        public static void a(CustomThemeCropFragment r100, FragmentManager r101) {
            String r102 = CustomThemeCropFragment.f161561y;
            LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r102, r103);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r103) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.show(r101, r102);
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomThemeCropFragment f161572a;

        public b(CustomThemeCropFragment r100) {
            this.f161572a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            CustomThemeCropFragment r109 = this.f161572a;
            Rect r110 = null;
            if (r109.f161564q != null) goto L32;
            PreviewBoxViewV2 r111 = r109.f161563p;
            if (r111 == null) goto L7;
            Rect r112 = r111.getVisibleRect();
        L8:
            r109.f161564q = r112;
            CustomThemeCropFragment r113 = this.f161572a;
            PinchImageView r114 = r113.f161488f;
            if (r114 == null) goto L11;
            r114.setDisplayWindowRect(r113.f161564q);
        L11:
            PinchImageView r115 = this.f161572a.f161488f;
            if (r115 == null) goto L14;
            r115.setNeedScaleToMin(true);
        L14:
            t r116 = new t();
            Rect r117 = this.f161572a.f161564q;
            float r118 = 0.0f;
            if (r117 == null) goto L17;
            float r119 = r117.left;
        L18:
            r116.f102101a = Float.valueOf(r119);
            Rect r120 = this.f161572a.f161564q;
            if (r120 == null) goto L21;
            float r121 = r120.top;
        L22:
            r116.f102102b = Float.valueOf(r121);
            Rect r122 = this.f161572a.f161564q;
            if (r122 == null) goto L25;
            float r123 = r122.right;
        L26:
            r116.f102103c = Float.valueOf(r123);
            Rect r124 = this.f161572a.f161564q;
            if (r124 == null) goto L29;
            r118 = r124.bottom;
        L29:
            r116.f102104d = Float.valueOf(r118);
            VideoThemeView r125 = this.f161572a.f161562o;
            if (r125 == null) goto L32;
            r125.setDisplayWindowRect(r116);
            goto L32
        L25:
            r123 = 0.0f;
            goto L26
        L21:
            r121 = 0.0f;
            goto L22
        L17:
            r119 = 0.0f;
            goto L18
        L7:
            r112 = null;
        L32:
            CustomThemeCropFragment r126 = this.f161572a;
            PreviewBoxViewV2 r127 = r126.f161563p;
            if (r127 == null) goto L35;
            r110 = r127.getPreviewRect();
        L35:
            r126.f161565r = r110;
        }
    }

    public static final class c extends SwitchModeFrameLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomThemeCropFragment f161573a;

        public c(CustomThemeCropFragment r100) {
            this.f161573a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.crop.SwitchModeFrameLayout.b
        public final void onInterceptTouchEvent(MotionEvent r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.getAction() != 1) goto L20;
            CustomThemeCropFragment r101 = this.f161573a;
            Rect r102 = null;
            if (r101.f161564q != null) goto L12;
            PreviewBoxViewV2 r103 = r101.f161563p;
            if (r103 == null) goto L10;
            Rect r104 = r103.getVisibleRect();
        L11:
            r101.f161564q = r104;
            goto L12
        L10:
            r104 = null;
        L12:
            CustomThemeCropFragment r105 = this.f161573a;
            if (r105.f161565r != null) goto L21;
            PreviewBoxViewV2 r106 = r105.f161563p;
            if (r106 == null) goto L17;
            r102 = r106.getPreviewRect();
        L17:
            r105.f161565r = r102;
            return;
        L21:
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomThemeCropFragment f161574a;

        public d(CustomThemeCropFragment r100) {
            this.f161574a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VideoThemeView r101 = this.f161574a.f161562o;
            if (r101 == null) goto L16;
            r101.c();
        L16:
            this.f161574a.dismiss();     // Catch: Exception -> L8
        L12:
            Dialog r102 = this.f161574a.getDialog();
            if (r102 == null) goto L18;
            r102.cancel();
            return;
        L18:
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L12;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L12
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomThemeCropFragment f161575a;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f161576a;

            public a(e r100) {
                this.f161576a = r100;
            }

            @Override // java.util.concurrent.Callable
            public final jv2.a call() {
                CustomThemeCropFragment r100 = this.f161576a.f161575a;
                String r101 = CustomThemeCropFragment.f161561y;
                r100.getClass();
                System.currentTimeMillis();
                PolarisFileWrapper r102 = new PolarisFileWrapper(q.h(r100.getActivity(), "head"), "liveCoverCrop_" + System.currentTimeMillis() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
                PinchImageView r103 = r100.f161488f;
                Bitmap r104 = r100.f161493k;
                String r105 = CustomThemeCropFragment.f161561y;
                String r106 = null;
                if (r103 == null) goto L18;
                if (r104 == null) goto L18;
                RectF r107 = r103.m(null);
                if (r100.f161564q != null) goto L8;
                ALogger.d(r105, "getCropBitmap mWindowRect is null");
            L8:
                Rect r108 = r100.f161564q;
                if (r108 != null) goto L11;
                Pair r109 = new Pair(r104, Integer.valueOf(R.string.ttlive_live_backtrack_dialog_retry));
            L19:
                Bitmap r110 = (Bitmap) r109.getFirst();
                if (r110 == null) goto L31;
                int r111 = d0.f158926a;
                boolean r112 = d0.b(r110, r102.getParent(), r102.getName(), false, 0);
                r110.recycle();
                StringBuilder r113 = new StringBuilder("saveToFile:");
                if (r112 == false) goto L25;
                String r114 = r102.getAbsolutePath();
            L26:
                r113.append(r114);
                ALogger.d(r105, r113.toString());
                ALogger.d(r105, "saveBitmapToSD status: " + r112 + ' ' + r102.length());
                System.currentTimeMillis();
                if (r112 == false) goto L30;
                r106 = r102.getAbsolutePath();
            L30:
                return new jv2.a(r106, R.string.ttlive_picture_common_failed);
            L25:
                r114 = "null";
                goto L26
            L31:
                return new jv2.a(null, ((Number) r109.getSecond()).intValue());
            L11:
                float r115 = r104.getWidth() / r107.width();
                float r116 = r104.getHeight() / r107.height();
                int r117 = RangesKt.coerceAtLeast((int) ((r108.left - r107.left) * r115), 0);
                int r118 = RangesKt.coerceAtLeast((int) ((r108.top - r107.top) * r116), 0);
                int r119 = RangesKt.coerceAtMost((int) (r108.width() * r115), r104.getWidth() - r117);
                int r120 = RangesKt.coerceAtMost((int) (r108.height() * r116), r104.getHeight() - r118);
                Bitmap r121 = Bitmap.createBitmap(r104, r117, r118, r119, r120);
                if (r121 != null) goto L14;
            L16:
                StringBuilder r122 = new StringBuilder();
                r122.append(r117);
                r122.append(' ');
                r122.append(r118);
                r122.append(' ');
                r122.append(r119);
                r122.append(' ');
                r122.append(r120);
                r122.append(' ');
                r122.append(r104.getWidth());
                r122.append(' ');
                r122.append(r104.getHeight());
                r122.append(' ');
                r122.append(r104.getConfig());
                ALogger.e(r105, r122.toString());
            L17:
                r109 = new Pair(r121, Integer.valueOf(R.string.ttlive_live_backtrack_dialog_retry));
                goto L19
            L14:
                if (d0.a(r104, r117, r118, r121) != true) goto L16;
                ALogger.i(r105, "crop is successful " + r115 + ' ' + r116 + ' ' + r117 + ' ' + r118 + ' ' + r119 + ' ' + r120 + ",croppedBitmap byteCount:" + r121.getByteCount());
            L18:
                r109 = new Pair(null, -1);
                goto L19
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public static final class b<TTaskResult, TContinuationResult> implements Continuation {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f161577a;

            public b(e r100) {
                this.f161577a = r100;
            }

            @Override // bolts.Continuation
            public final Object then(Task r100) {
                this.f161577a.f161575a.U90();
                if (r100.isCompleted() == false) goto L16;
                String r101 = ((jv2.a) r100.getResult()).f500543a;
                if (r101 != null) goto L7;
            L10:
                boolean r102 = true;
            L11:
                if (r102 == true) goto L16;
                jv2.e r103 = this.f161577a.f161575a.f161486d;
                if (r103 == null) goto L24;
                r103.c(new PolarisFileWrapper(((jv2.a) r100.getResult()).f500543a), this.f161577a.f161575a.f161570w, 0);
                return null;
            L24:
                return null;
            L7:
                if (r101.length() == 0) goto L10;
                r102 = false;
            L16:
                if (r100.isCompleted() == false) goto L18;
                f2.b(((jv2.a) r100.getResult()).f500544b, 0);
            L19:
                Exception r104 = new Exception("saveToFile task failed,task complete status:" + r100.isCompleted());
                jv2.e r105 = this.f161577a.f161575a.f161486d;
                if (r105 == null) goto L26;
                r105.e(r104);
                return null;
            L26:
                return null;
            L18:
                ALogger.e(CustomThemeCropFragment.f161561y, "saveToFile task failed");
                goto L19
            }
        }

        public e(CustomThemeCropFragment r100) {
            this.f161575a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            if (this.f161575a.f161496n == false) goto L6;
            f2.c("文件保存中，请耐心等待", 0);
            return;
        L6:
            CustomThemeCropFragment r111 = this.f161575a;
            String r100 = CustomThemeCropFragment.f161561y;
            r111.getClass();
            if (FileUtils.isVideo(new PolarisFileWrapper(r111.f161494l)) == false) goto L9;
        L10:
            TextView r112 = this.f161575a.f161490h;
            if (r112 == null) goto L13;
            r112.setClickable(false);
        L13:
            TextView r113 = this.f161575a.f161491i;
            if (r113 == null) goto L16;
            r113.setClickable(false);
        L16:
            CustomThemeCropFragment r114 = this.f161575a;
            jv2.e r101 = r114.f161486d;
            if (r101 == null) goto L29;
            String r102 = r114.f161494l;
            PreviewBoxViewV2 r103 = r114.f161563p;
            ThemeShowArea r104 = null;
            if (r103 == null) goto L21;
            Rect r105 = r103.getVisibleRect();
        L22:
            if (r105 == null) goto L28;
            r104 = new ThemeShowArea();
            float r106 = r105.right - r105.left;
            VideoThemeView r107 = r114.f161562o;
            Intrinsics.checkNotNull(r107);
            float r108 = r106 / r107.getShowWidth();
            float r109 = 100000;
            r104.setW((long) (r108 * r109));
            float r115 = r105.bottom - r105.top;
            VideoThemeView r116 = r114.f161562o;
            Intrinsics.checkNotNull(r116);
            r104.setH((long) ((r115 / r116.getShowHeight()) * r109));
            VideoThemeView r117 = r114.f161562o;
            Intrinsics.checkNotNull(r117);
            float r118 = r117.getShowWidth() - (r105.right - r105.left);
            float r119 = 2;
            VideoThemeView r120 = r114.f161562o;
            Intrinsics.checkNotNull(r120);
            r104.setX((long) (((r118 / r119) / r120.getShowWidth()) * r109));
            VideoThemeView r121 = r114.f161562o;
            Intrinsics.checkNotNull(r121);
            if (r121.getShowDirection() != 0) goto L27;
            r104.setY(0);
            goto L28
        L27:
            VideoThemeView r122 = r114.f161562o;
            Intrinsics.checkNotNull(r122);
            float r123 = (r122.getShowHeight() - (r105.bottom - r105.top)) / r119;
            VideoThemeView r124 = r114.f161562o;
            Intrinsics.checkNotNull(r124);
            r104.setY((long) ((r123 / r124.getShowHeight()) * r109));
        L28:
            r101.b(r102, r104, this.f161575a.f161570w);
            goto L29
        L21:
            r105 = null;
        L29:
            PinchImageView r125 = this.f161575a.f161488f;
            if (r125 != null) goto L32;
            return;
        L32:
            if (r125.getPinchMode() != 0) goto L36;
            this.f161575a.V90();
            Task.callInBackground(new a(this)).continueWith(new b(this), Task.UI_THREAD_EXECUTOR);
            return;
        L36:
            return;
        L9:
            if (this.f161575a.W90() == false) goto L29;
            goto L10
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreviewBoxViewV2 f161578a;

        public f(PreviewBoxViewV2 r100) {
            this.f161578a = r100;
        }

        public final void a() {
            PreviewBoxViewV2 r100 = this.f161578a;
            if (Math.abs(r100.f161675n - r100.f161676o) >= Float.MIN_NORMAL) goto L5;
            return;
        L5:
            if (r100.f161666e == true) goto L10;
            r100.f161666e = true;
            ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.5f, 0.85f});
            r100.f161667f = r101;
            r101.setEvaluator(new FloatEvaluator());
            r100.f161667f.setDuration(300);
            r100.f161667f.addUpdateListener(new jv2.g(r100));
            r100.f161667f.addListener(new h(r100));
            r100.f161667f.setStartDelay(300);
            r100.f161667f.start();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements ThemeUpLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomThemeCropFragment f161579a;

        @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener
        public final void onUploadFailed() {
            this.f161579a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener
        public final void onUploaded() {
            this.f161579a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public g(CustomThemeCropFragment r100) {
            this.f161579a = r100;
        }
    }

    static {
        f161561y = VoiceLiveTheme.TAG;
    }

    @Override // com.bytedance.android.livesdk.widget.crop.AbsCropFragment
    public final void S90() {
        View r100 = this.f161492j;
        if (r100 == null) goto L6;
        this.f161562o = (VideoThemeView) r100.findViewById(R.id.ttlive_crop_video);
        this.f161563p = (PreviewBoxViewV2) r100.findViewById(R.id.ttlive_iv_cover_window);
        return;
    }

    public final boolean W90() {
        List r100 = StringsKt.split$default(this.f161494l, new String[]{"."}, false, 0, 6, null);
        if ("gif".equals(ListProtector.get(r100, r100.size() - 1)) == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.widget.crop.AbsCropFragment
    public final void initView() {
        Integer r100 = null;
        if (TextUtils.isEmpty(this.f161494l) == false) goto L19;
        Uri r101 = this.f161571x;
        if (r101 == null) goto L7;
        String r102 = r101.toString();
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L19;
        f2.b(R.string.ttlive_photo_error_no_photo, 0);
        dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L89;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L89:
        return;
    L7:
        r102 = null;
    L19:
        if (TextUtils.isEmpty(this.f161494l) == false) goto L21;
    L31:
        System.currentTimeMillis();
        if (this.f161571x == null) goto L41;
        Context r104 = getContext();
        if (r104 == null) goto L36;
        ContentResolver r105 = r104.getContentResolver();
    L37:
        Bitmap r106 = BitmapUtils.decodeBitmap(r105, this.f161571x, 2000, 2000);
        if (r106 == null) goto L40;
        int r107 = q.e(r106);
    L42:
        if (r106 != null) goto L51;
        f2.b(R.string.ttlive_live_profile_action_error, 0);
        dismiss();     // Catch: Exception -> L46
        return;
    L46:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r108 = DialogFragmentLancet.sLastShowStack;
        if (r108 == null) goto L91;
        com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L91:
        return;
    L51:
        System.currentTimeMillis();
        Bitmap r109 = BitmapUtils.rotateBitmap(r106, r107);
        this.f161493k = r109;
        PinchImageView r110 = this.f161488f;
        if (r110 == null) goto L54;
        r110.setImageBitmap(r109);
    L54:
        PinchImageView r111 = this.f161488f;
        if (r111 == null) goto L57;
        r111.setVisibility(0);
    L57:
        VideoThemeView r112 = this.f161562o;
        if (r112 == null) goto L60;
        r112.setVisibility(8);
    L60:
        StringBuilder r113 = new StringBuilder("original bitmap byteCount:");
        Bitmap r114 = this.f161493k;
        if (r114 == null) goto L63;
        r100 = Integer.valueOf(r114.getByteCount());
    L63:
        r113.append(r100);
        ALogger.i(f161561y, r113.toString());
        PreviewBoxViewV2 r115 = this.f161563p;
        if (r115 == null) goto L66;
        r115.addOnLayoutChangeListener(new b(this));
    L66:
        SwitchModeFrameLayout r116 = this.f161487e;
        if (r116 == null) goto L70;
        r116.setInterceptor(new c(this));
    L70:
        if (this.f161566s != 0) goto L73;
        this.f161566s = 250;
    L73:
        if (this.f161567t != 0) goto L75;
        this.f161567t = 250;
    L75:
        TextView r117 = this.f161490h;
        if (r117 == null) goto L78;
        r117.setOnClickListener(new d(this));
    L78:
        TextView r118 = this.f161491i;
        if (r118 == null) goto L81;
        r118.setOnClickListener(new e(this));
    L81:
        PreviewBoxViewV2 r119 = this.f161563p;
        if (r119 == null) goto L93;
        r119.postDelayed(new f(r119), 1000);
        return;
    L93:
        return;
    L40:
        r107 = -1;
        r106 = null;
        goto L42
    L36:
        r105 = null;
        goto L37
    L41:
        r107 = BitmapUtils.readPictureDegree(this.f161494l);
        r106 = BitmapUtils.getBitmapFromSD(this.f161494l, 2000, 2000);
        goto L42
    L21:
        if (FileUtils.isVideo(new PolarisFileWrapper(this.f161494l)) == false) goto L23;
    L24:
        String r120 = this.f161494l;
        if (this.f161562o == null) goto L60;
        PinchImageView r121 = this.f161488f;
        if (r121 == null) goto L30;
        r121.setVisibility(8);
    L30:
        VideoThemeView r122 = this.f161562o;
        Intrinsics.checkNotNull(r122);
        r122.setVisibility(0);
        VideoThemeView r123 = this.f161562o;
        Intrinsics.checkNotNull(r123);
        r123.d(r120, "", null);
        goto L60
    L23:
        if (W90() == false) goto L31;
        goto L24
    }

    public CustomThemeCropFragment() {
        this.f161566s = 750;
        this.f161567t = 750;
        this.f161568u = true;
        this.f161569v = R.layout.ttlive_custom_theme_cover_crop;
        this.f161570w = new g(this);
    }

    @Override // com.bytedance.android.livesdk.widget.crop.AbsCropFragment
    public final int T90() {
        return this.f161569v;
    }

    @Override // com.bytedance.android.livesdk.widget.crop.AbsCropFragment
    public final boolean getMCancelable() {
        return this.f161568u;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setLayout(-1, -1);
    L7:
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r103 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r103.a();
        r103.a();
        Dialog r104 = getDialog();
        if (r104 == null) goto L18;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L18;
        View r106 = r105.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r107 = ThreadMethodProxy.currentThread();
        if (r107 == com.larus.home.impl.utils.c.f346341a) goto L16;
        com.larus.home.impl.utils.c.a(r107, "getDecorView");
    L16:
        if (r106 == null) goto L18;
        r106.setSystemUiVisibility(5894);
    L18:
        Dialog r108 = getDialog();
        if (r108 == null) goto L24;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L25;
        r109.setStatusBarColor(ColorProtector.parseColor("#D90f0f0f"));
        return;
    L25:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        jv2.e r101 = this.f161486d;
        if (r101 == null) goto L6;
        r101.a(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.crop.AbsCropFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L11;
        String r102 = r101.getString("originalUrl");
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f161494l = r102;
        r101.getBoolean("isOval");
        r101.getFloat("rectRatio");
        r101.getInt("rectMargin");
        this.f161566s = r101.getInt("minImageWidth");
        this.f161567t = r101.getInt("minImageHeight");
        r101.getString("enterFrom");
        String r103 = r101.getString("originalUri");
        if (r103 == null) goto L12;
        this.f161571x = UriProtector.parse(r103);
        return;
    L12:
        return;
    }
}
