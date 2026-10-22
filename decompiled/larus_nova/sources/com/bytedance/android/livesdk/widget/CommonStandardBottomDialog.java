package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Lcom/bytedance/android/livesdk/widget/LiveStandardSheetDialog;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CommonStandardBottomDialog extends LiveStandardSheetDialog {
    public boolean A;

    public static final class a implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonStandardBottomDialog f160796a;

        public a(CommonStandardBottomDialog r100) {
            this.f160796a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return this.f160796a.V0();
        }
    }

    public /* synthetic */ CommonStandardBottomDialog() {
        throw null;
    }

    public abstract int getLayoutId();

    public boolean V0() {
        if (this.f154353r == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A = true;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A = false;
    }

    @Override // com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(getLayoutId());
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -1);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(80);
    L8:
        setBottomSheetSlideProcessor(new a(this));
    }

    public CommonStandardBottomDialog(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, false, false);
    }

    public CommonStandardBottomDialog(Context r100, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111, r112, false, 16);
    }

    public /* synthetic */ CommonStandardBottomDialog(Context r100, boolean r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        this(r100, r101, r102, r103);
    }
}
