package com.bytedance.android.livesdk.chatroom.tetris.vr;

import android.view.MotionEvent;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrAudienceCursorView f111943a;

    public q(VrAudienceCursorView r100) {
        this.f111943a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MotionEvent r101 = (MotionEvent) r100;
        float r102 = r101.getX();
        float r103 = r101.getY();
        int r104 = r101.getAction();
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L16;
        if (r104 == 2) goto L9;
        return;
    L9:
        if (this.f111943a.getCursorFocused() == false) goto L23;
        VrAudienceCursorView.a(this.f111943a);
        VrAudienceCursorView r105 = this.f111943a;
        r105.getClass();
        a r106 = new a(r102, r103, r105.f111878m);
        Iterator<Map.Entry<String, Function1<a, Unit>>> r107 = r105.f111868c.entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r107.next().getValue().invoke(r106);
        goto L12
    L14:
        r105.d(r106);
        return;
    L23:
        return;
    L16:
        if (this.f111943a.getCursorFocused() == false) goto L25;
        this.f111943a.setCursorFocused(false);
        this.f111943a.setCursorPosChanged(true);
        this.f111943a.e(r102, r103);
        return;
    L25:
        return;
    L19:
        if (VrAudienceCursorView.b(this.f111943a, r102, r103) == false) goto L27;
        this.f111943a.setCursorFocused(true);
        this.f111943a.setCursorMoved(true);
        return;
    }
}
