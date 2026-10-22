package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u0001H\u0011H\u00110\u0010\"\b\b\u0000\u0010\u0011*\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogNativeV2Base;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "themeResId", "", "(Landroid/app/Activity;I)V", "getActivity", "()Landroid/app/Activity;", "questionerListener", "Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogQuestionerListener;", "getQuestionerListener", "()Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogQuestionerListener;", "setQuestionerListener", "(Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogQuestionerListener;)V", "id", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "Landroid/view/View;", "updateQuestionerListener", "", "newQuestionerInterface", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJPayKeepDialogNativeV2Base extends Dialog {
    private final Activity activity;
    private CJPayKeepDialogQuestionerListener questionerListener;

    public final Activity getActivity() {
        return this.activity;
    }

    public final CJPayKeepDialogQuestionerListener getQuestionerListener() {
        return this.questionerListener;
    }

    public final <T extends View> Lazy<T> id(final int r100) {
        return LazyKt.lazy(new AnonymousClass1(this, r100));
    }

    public final void setQuestionerListener(CJPayKeepDialogQuestionerListener r100) {
        this.questionerListener = r100;
    }

    public final void updateQuestionerListener(CJPayKeepDialogQuestionerListener r100) {
        Intrinsics.checkNotNullParameter(r100, "newQuestionerInterface");
        this.questionerListener = r100;
    }

    public CJPayKeepDialogNativeV2Base(Activity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, r101);
        this.activity = r100;
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.setLayout(-1, -1);
    L5:
        Window r103 = getWindow();
        if (r103 == null) goto L8;
        r103.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L8:
        CJPayImmersedStatusBarUtils.adjustMaterialTheme(r100);
    }

    public /* synthetic */ CJPayKeepDialogNativeV2Base(Activity r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = R.style.CJ_Pay_Full_Dialog_Fragment_Style;
    L5:
        this(r100, r101);
    }
}
