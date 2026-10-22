package com.obric.oui.window.permission;

import android.view.View;
import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PrivacyStatementActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ View $targetView;
    final /* synthetic */ PrivacyStatementActivity this$0;

    public static /* synthetic */ void lambda$B2NnpMCn4FnS3EUQPZyene5MIo4(PrivacyStatementActivity r0) {
        m1244onPreDraw$lambda0(r0);
    }

    PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1(PrivacyStatementActivity r3, View r4) {
        this.this$0 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r3, PrivacyStatementActivity.class, "com.obric.aiagent.plugin");
        this.$targetView = r4;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        PrivacyStatementActivity.access$removeFirstFramePreDrawListener(this.this$0);
        if (PrivacyStatementActivity.access$getFirstFrameReported$p(this.this$0) == false) goto L5;
        return true;
    L5:
        PrivacyStatementActivity.access$setFirstFrameReported$p(this.this$0, true);
        View r0 = this.$targetView;
        final PrivacyStatementActivity r3 = this.this$0;
        r0.post(new $$Lambda$PrivacyStatementActivity$reportPrivacySheetFirstFrame$listener$1$B2NnpMCn4FnS3EUQPZyene5MIo4(r3));
        return true;
    }

    /* JADX INFO: renamed from: onPreDraw$lambda-0, reason: not valid java name */
    private static final void m1244onPreDraw$lambda0(PrivacyStatementActivity r2) {
        PrivacyStatementActivity r3 = (PrivacyStatementActivity) ZeusTransformUtils.wrapperContextForParams(r2, PrivacyStatementActivity.class, "com.obric.aiagent.plugin");
        o.e(r3, "this$0");
        PrivacyStatementActivity.access$logPrivacySheetFirstFrame(r3);
    }
}
