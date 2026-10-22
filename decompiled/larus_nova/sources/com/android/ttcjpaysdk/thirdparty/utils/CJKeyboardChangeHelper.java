package com.android.ttcjpaysdk.thirdparty.utils;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J1\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/CJKeyboardChangeHelper;", "", "keyboardHeight", "", "activity", "Landroid/app/Activity;", "(ILandroid/app/Activity;)V", "TAG", "", "activityRootView", "Landroid/view/View;", "getKeyboardHeight", "()I", "setKeyboardHeight", "(I)V", "setKeyboardListener", "", "keyboardChange", "Lkotlin/Function2;", "needAdaptHeight", "", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Boolean;)V", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJKeyboardChangeHelper {
    private final String TAG;
    private final View activityRootView;
    private int keyboardHeight;

    public final int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public static final /* synthetic */ String access$getTAG$p(CJKeyboardChangeHelper r100) {
        return r100.TAG;
    }

    public final void setKeyboardHeight(int r100) {
        this.keyboardHeight = r100;
    }

    public CJKeyboardChangeHelper(int r100, Activity r101) {
        this.keyboardHeight = r100;
        this.TAG = "CJKeyboardChangeHelper";
        if (r101 == null) goto L7;
        View r102 = r101.findViewById(R.id.content);
        if (r102 == null) goto L7;
        View r103 = r102.getRootView();
    L8:
        this.activityRootView = r103;
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final void setKeyboardListener(final Function2<? super Integer, ? super Integer, Unit> r100, final Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "keyboardChange");
        View r102 = this.activityRootView;
        if (r102 != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L8;
        r102.setOnApplyWindowInsetsListener(new AnonymousClass1(this, r101, r100));
        return;
    L8:
        ViewCompat.setOnApplyWindowInsetsListener(r102, new AnonymousClass2(this, r101, r100));
    }

    public /* synthetic */ CJKeyboardChangeHelper(int r100, Activity r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = CJPayBasicExtensionKt.dp(320);
    L5:
        this(r100, r101);
    }

    public static /* synthetic */ void setKeyboardListener$default(CJKeyboardChangeHelper r100, Function2 r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = Boolean.FALSE;
    L5:
        r100.setKeyboardListener(r101, r102);
    }
}
