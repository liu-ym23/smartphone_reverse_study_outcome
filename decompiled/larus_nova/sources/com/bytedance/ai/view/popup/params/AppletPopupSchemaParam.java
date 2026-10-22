package com.bytedance.ai.view.popup.params;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.ai.utils.l;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u0013\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/view/popup/params/AppletPopupSchemaParam;", "Lcom/bytedance/ai/view/popup/params/AbsAppletPopupSchemaParam;", "<init>", "()V", "resizeDurationInMillSeconds", "", "getResizeDurationInMillSeconds", "()J", "setResizeDurationInMillSeconds", "(J)V", "isLandscape", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getRealGravity", "", "getRealWidth", "", "getRealHeight", "getRealTransitionAnimation", "isIn", "adjustValues", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPopupSchemaParam extends AbsAppletPopupSchemaParam {
    private long resizeDurationInMillSeconds;

    public AppletPopupSchemaParam() {
        this.resizeDurationInMillSeconds = 300;
    }

    public final void adjustValues() {
        if (getSelfAdaptiveHeight() == false) goto L6;
        setHeight(-1);
    L6:
        if (getHeight() != (-1)) goto L14;
        String r100 = getGravity();
        if (Intrinsics.areEqual(r100, "bottom") == false) goto L11;
        setHeight(l.b(null));
        goto L14
    L11:
        if (Intrinsics.areEqual(r100, "center") == false) goto L14;
        setHeight(o.a(400.0f));
    L14:
        if (getWidth() != (-1)) goto L22;
        String r101 = getGravity();
        if (Intrinsics.areEqual(r101, "bottom") == false) goto L19;
        setWidth(l.c(null));
        goto L22
    L19:
        if (Intrinsics.areEqual(r101, "center") == false) goto L22;
        setWidth(o.a(300.0f));
    L22:
        if (getSelfAdaptiveHeight() == true) goto L27;
        if (getVariableHeight() <= getHeight()) goto L27;
        setDragHeight(getVariableHeight());
        setDragBack(true);
        setDragByGesture(true);
        setEnablePullDownClose(true);
        setTransitionAnimationIn(AnimationStyle.SLIDE.getValue());
        setGravity("bottom");
    L27:
        if (getMinMarginTop() <= 0) goto L30;
        setKeyboardAdjust(2);
    L30:
        if (getTransStatusBar() == false) goto L40;
        setKeyboardCompat(true);
    L40:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L37
        long r103 = (long) (CastFloatProtector.parseFloat(getResizeDuration()) * 1000);     // Catch: Throwable -> L37
        this.resizeDurationInMillSeconds = r103;     // Catch: Throwable -> L37
        if (r103 >= 0) goto L35;
        this.resizeDurationInMillSeconds = 300;     // Catch: Throwable -> L37
    L35:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final long getResizeDurationInMillSeconds() {
        return this.resizeDurationInMillSeconds;
    }

    public static boolean a(Context r100) {
        if (r100 == null) goto L10;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L10;
        Configuration r102 = r101.getConfiguration();
        if (r102 == null) goto L10;
        if (r102.orientation != 2) goto L10;
        return true;
    L10:
        return false;
    }

    public final String getRealGravity(Context r100) {
        String r101 = getGravity();
        if (a(r100) == true) goto L5;
        return r101;
    L5:
        if (getLandscapeGravity().length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return r101;
    L10:
        return getLandscapeGravity();
    L7:
        r102 = false;
        goto L8
    }

    public final int getRealHeight(Context r100) {
        int r101 = getHeight();
        if (a(r100) == true) goto L5;
        return r101;
    L5:
        if (getLandscapeHeight() > 0) goto L7;
        return r101;
    L7:
        return getLandscapeHeight();
    }

    public final int getRealWidth(Context r100) {
        int r101 = getWidth();
        if (a(r100) == true) goto L5;
        return r101;
    L5:
        if (getLandscapeWidth() > 0) goto L7;
        return r101;
    L7:
        return getLandscapeWidth();
    }

    public final void setResizeDurationInMillSeconds(long r100) {
        this.resizeDurationInMillSeconds = r100;
    }

    public final String getRealTransitionAnimation(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = getTransitionAnimationIn();
    L6:
        if (a(r100) == true) goto L8;
        return r102;
    L8:
        if (getLandscapeTransitionAnimation().length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        return r102;
    L13:
        return getLandscapeTransitionAnimation();
    L10:
        r103 = false;
        goto L11
    L4:
        r102 = getTransitionAnimationOut();
        goto L6
    }

    public static /* synthetic */ String getRealTransitionAnimation$default(AppletPopupSchemaParam r100, Context r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return r100.getRealTransitionAnimation(r101, r102);
    }
}
