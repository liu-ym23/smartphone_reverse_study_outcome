package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes9.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.publicscreen.a$a, reason: collision with other inner class name */
    public interface InterfaceC2106a {
        void a(Integer r100, Integer r101);

        void onCancel();
    }

    void V4(FragmentManager r100);

    void dismissDialog();

    void fP(InterfaceC2106a r100);
}
