package com.android.ttcjpaysdk.ocr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0002J3\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bR+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/view/CJOCRTakePhotoPreview;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirm", "", "confirmBtn", "Landroid/widget/Button;", "preview", "Landroid/widget/ImageView;", "retryBtn", "initAction", "initViews", "setPreviewPhoto", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "listener", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRTakePhotoPreview extends LinearLayout {
    private Function1<? super Boolean, Unit> checkListener;
    private final Button confirmBtn;
    private final ImageView preview;
    private final Button retryBtn;

    private final void initViews() {
        ViewGroup.LayoutParams r100 = this.preview.getLayoutParams();
        if ((r100 instanceof LinearLayout.LayoutParams) == false) goto L5;
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) r100;
    L6:
        if (r101 == null) goto L10;
        r101.topMargin = CJPayImmersedStatusBarUtils.getStatusBarHeight(getContext());
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void initAction() {
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.retryBtn, new AnonymousClass1(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.confirmBtn, new AnonymousClass2(this));
    }

    public static final /* synthetic */ Function1 access$getCheckListener$p(CJOCRTakePhotoPreview r100) {
        return r100.checkListener;
    }

    public CJOCRTakePhotoPreview(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_take_photo_check_layout, this, true);
        this.retryBtn = (Button) findViewById(R.id.btn_take_photo_retry);
        this.confirmBtn = (Button) findViewById(R.id.btn_take_photo_confirm);
        this.preview = (ImageView) findViewById(R.id.iv_photo_preview);
        initViews();
        initAction();
    }

    public final void setPreviewPhoto(Bitmap r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.preview.setImageBitmap(r100);
        this.checkListener = r101;
    }
}
