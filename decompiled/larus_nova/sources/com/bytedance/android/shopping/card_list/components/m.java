package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f171472a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f171473a;

        public a(m r100) {
            this.f171473a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f171473a.f171472a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public m(View r100) {
        this.f171472a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f171472a.postOnAnimation(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
