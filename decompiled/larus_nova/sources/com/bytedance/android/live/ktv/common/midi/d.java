package com.bytedance.android.live.ktv.common.midi;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f69846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f69847b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f69848a;

        public a(d r100) {
            this.f69848a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f69848a.f69847b.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d(View r100, Function0 r101) {
        this.f69846a = r100;
        this.f69847b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        this.f69846a.post(new a(this));
    }
}
