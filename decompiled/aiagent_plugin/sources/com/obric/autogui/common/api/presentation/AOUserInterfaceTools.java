package com.obric.autogui.common.api.presentation;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AOUserInterfaceTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOUserInterfaceTools {
    public static final AOUserInterfaceTools INSTANCE = null;

    /* JADX INFO: compiled from: AOUserInterfaceTools.kt */
    public static class TitlelessDialog extends Dialog {
        private final int slop;

        public /* synthetic */ TitlelessDialog(Context r2, int r3, int r4, h r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r3 = 0;
        L5:
            this(r6, r3);
        }

        public final int getSlop() {
            return this.slop;
        }

        public TitlelessDialog(Context r3, int r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            super(r5);
            this.slop = r4;
            requestWindowFeature(1);
        }

        @Override // android.app.Dialog
        public boolean onTouchEvent(MotionEvent r5) {
            o.e(r5, "event");
            if (this.slop < 0) goto L5;
            Window r0 = getWindow();
            if (r0 == null) goto L17;
            if (r5.getAction() != 1) goto L17;
            if (isShowing() == false) goto L17;
            if (AOUserInterfaceTools.INSTANCE.isOutsideWindowSlopped(r0, r5, this.slop) == false) goto L17;
            cancel();
            return true;
        L17:
            return super.onTouchEvent(r5);
        L5:
            return super.onTouchEvent(r5);
        }
    }

    static {
        INSTANCE = new AOUserInterfaceTools();
    }

    private AOUserInterfaceTools() {
    }

    public final void showAppToast(Context r2, CharSequence r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r4, "text");
        AOPlatformTools.INSTANCE.ui().showToast(r4, r1);
    }

    public static /* synthetic */ void showAppToast$default(AOUserInterfaceTools r1, Context r2, int r3, boolean r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        r1.showAppToast(r7, r3, r4);
    }

    public final void showAppToast(Context r2, int r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        AOPlatformTools.INSTANCE.ui().showToast(r3, r4, r1);
    }

    public static /* synthetic */ boolean isOutsideWindowSlopped$default(AOUserInterfaceTools r0, Window r1, MotionEvent r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = -1;
    L6:
        return r0.isOutsideWindowSlopped(r1, r2, r3);
    }

    public final boolean isOutsideWindowSlopped(Window r3, MotionEvent r4, int r5) {
        o.e(r3, "window");
        o.e(r4, "event");
        int r2 = (int) r4.getX();
        int r6 = (int) r4.getY();
        if (r5 >= 0) goto L5;
        r5 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getScaledWindowTouchSlop();
    L5:
        View r7 = r3.getDecorView();
        o.c(r7, "getDecorView(...)");
        int r0 = -r5;
        if (r2 < r0) goto L14;
        if (r6 < r0) goto L14;
        if (r2 > (r7.getWidth() + r5)) goto L14;
        if (r6 > (r7.getHeight() + r5)) goto L14;
        return false;
    L14:
        return true;
    }
}
