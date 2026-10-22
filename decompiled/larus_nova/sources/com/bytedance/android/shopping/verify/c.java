package com.bytedance.android.shopping.verify;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class c extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f187184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187185b;

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Activity r101 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r101 == null) goto L6;
        jj.a.C6443a.b(p.f48130a, this.f187184a, r101, null, 28);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(this.f187185b);
        r100.setUnderlineText(false);
    }

    public c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "mUrl");
        this.f187184a = r100;
        this.f187185b = r101;
    }
}
