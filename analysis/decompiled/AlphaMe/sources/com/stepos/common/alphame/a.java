package com.stepos.common.alphame;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public int f11222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11223b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f fVar, Looper looper) {
        super(looper);
        this.f11223b = fVar;
        this.f11222a = 0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        synchronized (this) {
            if (message.what == 0) {
                synchronized (this.f11223b.f11229c) {
                    if (this.f11223b.f11229c.size() == 0) {
                        return;
                    }
                    Log.w("AlphaMe", "Client handle binder died ");
                    for (int i4 = 0; i4 < this.f11223b.f11229c.size(); i4++) {
                        f fVar = this.f11223b;
                        fVar.f((b) fVar.f11229c.valueAt(i4));
                    }
                    f fVar2 = this.f11223b;
                    if (fVar2.f11232f) {
                        this.f11222a = 0;
                        fVar2.f11229c.clear();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mRetryCount = ");
                        int i5 = this.f11222a + 1;
                        this.f11222a = i5;
                        sb.append(i5);
                        Log.w("AlphaMe", sb.toString());
                        if (this.f11222a <= 30) {
                            this.f11223b.f11233g.removeMessages(0);
                            this.f11223b.f11233g.sendEmptyMessageDelayed(0, 500L);
                        } else {
                            Log.e("AlphaMe", "Restore actions fail, size = " + this.f11223b.f11229c.size());
                            this.f11223b.f11229c.clear();
                            this.f11222a = 0;
                        }
                    }
                }
            }
        }
    }
}
