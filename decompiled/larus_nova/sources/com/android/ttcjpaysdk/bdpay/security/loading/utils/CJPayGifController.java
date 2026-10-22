package com.android.ttcjpaysdk.bdpay.security.loading.utils;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.caijing.sdk.infra.base.api.fresco.FrescoGifService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/utils/CJPayGifController;", "", "()V", "anim", "Landroid/graphics/drawable/Animatable;", "currentCount", "", "gifView", "Landroid/widget/ImageView;", "listener", "Lcom/android/ttcjpaysdk/bdpay/security/loading/utils/CJPayGifController$CJPayGifListener;", "loopCount", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "uri", "Landroid/net/Uri;", "setGif", "url", "", "setListener", "setLoopCount", "setPlaceholderDrawable", "", "res", "setView", "view", "startGif", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "stopGif", "CJPayGifListener", "Companion", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayGifController {
    public static final Companion Companion = null;
    private Animatable anim;
    private int currentCount;
    private ImageView gifView;
    private CJPayGifListener listener;
    private int loopCount;
    private Drawable placeholderDrawable;
    private Uri uri;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/utils/CJPayGifController$CJPayGifListener;", "", "onFrame", "", "anim", "Landroid/graphics/drawable/Animatable;", "frameNumber", "", "onLoadFail", "onRepeat", "currentCount", WidgetCostModule.TYPE_ON_START, "onStop", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPayGifListener {
        void onFrame(Animatable r100, int r101);

        void onLoadFail();

        void onRepeat(Animatable r100, int r101);

        void onStart(Animatable r100);

        void onStop(Animatable r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/security/loading/utils/CJPayGifController$Companion;", "", "()V", "preLoad", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "bdpay-security-loading_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void preLoad(Context r100, String r101) {
            a.f554342a.getClass();
            FrescoGifService r102 = (FrescoGifService) a.a(FrescoGifService.class);
            if (r102 == null) goto L6;
            r102.preLoad(r100, r101);
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void stopGif() {
        Animatable r100 = this.anim;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public CJPayGifController() {
        this.loopCount = 1;
    }

    public static final /* synthetic */ Animatable access$getAnim$p(CJPayGifController r100) {
        return r100.anim;
    }

    public static final /* synthetic */ int access$getCurrentCount$p(CJPayGifController r100) {
        return r100.currentCount;
    }

    public static final /* synthetic */ CJPayGifListener access$getListener$p(CJPayGifController r100) {
        return r100.listener;
    }

    public final CJPayGifController setGif(String r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L9;
        this.uri = UriProtector.parse(r100);
        goto L9
    }

    public final CJPayGifController setListener(CJPayGifListener r100) {
        this.listener = r100;
        return this;
    }

    public final CJPayGifController setLoopCount(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L7;
        CJPayGifController r102 = this;
    L8:
        if (r102 == null) goto L10;
        this.loopCount = r100;
    L10:
        return this;
    L7:
        r102 = null;
        goto L8
    L4:
        r101 = false;
        goto L5
    }

    public final void setPlaceholderDrawable(Drawable r100) {
        this.placeholderDrawable = r100;
    }

    public final CJPayGifController setView(ImageView r100) {
        if (r100 == null) goto L4;
        this.gifView = r100;
    L4:
        return this;
    }

    public final void startGif(Context r100) {
        a.f554342a.getClass();
        FrescoGifService r101 = (FrescoGifService) a.a(FrescoGifService.class);
        if (r101 == null) goto L6;
        r101.startGif(r100, this.gifView, this.uri, this.placeholderDrawable, this.loopCount, new AnonymousClass1(this));
        return;
    }

    public static final /* synthetic */ void access$setAnim$p(CJPayGifController r100, Animatable r101) {
        r100.anim = r101;
    }

    public static final /* synthetic */ void access$setCurrentCount$p(CJPayGifController r100, int r101) {
        r100.currentCount = r101;
    }
}
