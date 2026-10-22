package com.android.server.policy;

import android.os.IBinder;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class SmtStartingSurface {
    private final View mView;

    public SmtStartingSurface(View view, IBinder appToken) {
        this.mView = view;
    }

    public View getStartingView() {
        return this.mView;
    }
}
