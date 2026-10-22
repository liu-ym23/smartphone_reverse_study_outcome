package com.bytedance.android.livesdk.chatroom.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r5 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f113932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f113933b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f113933b.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(this.f113932a);
        r100.setUnderlineText(false);
    }

    public r5(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f113932a = r100;
        this.f113933b = r101;
    }
}
