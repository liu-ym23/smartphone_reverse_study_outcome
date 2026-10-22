package com.android.ttcjpaysdk.ocr.wrapper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0011H&J\b\u0010\u001f\u001a\u00020\u0011H&J\b\u0010 \u001a\u00020\u0011H&J\b\u0010!\u001a\u00020\u0011H&J\b\u0010\"\u001a\u00020\u0011H&J[\u0010#\u001a\u00020\u00112S\u0010$\u001aO\u0012C\u0012A\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nJ]\u0010%\u001a\u00020\u00112U\u0010$\u001aQ\u0012E\u0012C\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRg\u0010\t\u001aO\u0012C\u0012A\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016Ri\u0010\u0017\u001aQ\u0012E\u0012C\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/wrapper/CJOCRBaseWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;)V", "getActivity", "()Landroid/app/Activity;", "checkCameraPermission", "Lkotlin/Function1;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "granted", "hitOpt", "", "callback", "getCheckCameraPermission", "()Lkotlin/jvm/functions/Function1;", "setCheckCameraPermission", "(Lkotlin/jvm/functions/Function1;)V", "openAlbum", "", "resultCode", "Landroid/content/Intent;", "data", "getOpenAlbum", "setOpenAlbum", VideoEventOneOutSync.END_TYPE_FINISH, WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onPause", "onResume", "setCameraPermissionAction", "action", "setOpenAlbumAction", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJOCRBaseWrapper extends BaseWrapper {
    private final Activity activity;
    private Function1<? super Function2<? super Boolean, ? super Boolean, Unit>, Unit> checkCameraPermission;
    private Function1<? super Function2<? super Integer, ? super Intent, Unit>, Unit> openAlbum;

    public abstract void finish();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public final Activity getActivity() {
        return this.activity;
    }

    public final Function1<Function2<? super Boolean, ? super Boolean, Unit>, Unit> getCheckCameraPermission() {
        return this.checkCameraPermission;
    }

    public final Function1<Function2<? super Integer, ? super Intent, Unit>, Unit> getOpenAlbum() {
        return this.openAlbum;
    }

    public final void setCameraPermissionAction(Function1<? super Function2<? super Boolean, ? super Boolean, Unit>, Unit> r100) {
        this.checkCameraPermission = r100;
    }

    public final void setCheckCameraPermission(Function1<? super Function2<? super Boolean, ? super Boolean, Unit>, Unit> r100) {
        this.checkCameraPermission = r100;
    }

    public final void setOpenAlbum(Function1<? super Function2<? super Integer, ? super Intent, Unit>, Unit> r100) {
        this.openAlbum = r100;
    }

    public final void setOpenAlbumAction(Function1<? super Function2<? super Integer, ? super Intent, Unit>, Unit> r100) {
        this.openAlbum = r100;
    }

    public CJOCRBaseWrapper(Activity r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r101);
        this.activity = r100;
    }
}
