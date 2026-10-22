package com.bytedance.als;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes43.dex */
public class h<T> extends f<T> {
    public h() {
    }

    @Override // com.bytedance.als.f
    public void postValue(T r100) {
        super.postValue(r100);
    }

    @Override // com.bytedance.als.f
    public void setValue(T r100) {
        Handler r101 = ThreadUtility.f38085a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        super.setValue(r100);
        return;
    L6:
        final ThreadUtility.IncorrectThreadException r102 = new ThreadUtility.IncorrectThreadException("This method must call on main thread");
        ThreadUtility.f38085a.post(new i(r102));
        throw r102;
    }
}
