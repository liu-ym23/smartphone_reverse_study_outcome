package com.bytedance.android.livesdk.commonpop;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f119729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f119730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f119731c;

    public f(Ref.FloatRef r100, Function0 r101, View r102) {
        this.f119729a = r100;
        this.f119730b = r101;
        this.f119731c = r102;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r100.getHeight() / 3;
        float r103 = r101.getRawY() - this.f119729a.element;
        int r104 = r101.getAction();
        if (r104 == 0) goto L15;
        if (r104 == 1) goto L12;
        if (r104 == 2) goto L9;
    L16:
        return true;
    L9:
        if (r103 >= 0) goto L16;
        this.f119731c.setTranslationY(r103);
        goto L16
    L12:
        if (r103 >= (-r102)) goto L14;
        this.f119730b.invoke();
        goto L16
    L14:
        this.f119731c.animate().translationY(0.0f).start();
        goto L16
    L15:
        this.f119729a.element = r101.getRawY();
        goto L16
    }
}
