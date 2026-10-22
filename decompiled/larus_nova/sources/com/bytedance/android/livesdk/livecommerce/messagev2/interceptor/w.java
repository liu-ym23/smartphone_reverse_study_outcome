package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f149450a;

    public w(File r100) {
        this.f149450a = r100;
    }

    @Override // java.util.Observer
    public final void update(Observable r100, Object r101) {
        this.f149450a.delete();
    }
}
