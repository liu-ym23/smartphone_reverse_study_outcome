package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.MotionEvent;
import android.view.View;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublishSubject f106575a;

    public f(PublishSubject r100) {
        this.f106575a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L7;
        this.f106575a.onNext(Unit.INSTANCE);
        return false;
    L7:
        return false;
    }
}
