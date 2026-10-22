package com.bytedance.bdinstall.appstate;

/* JADX INFO: compiled from: AppStateListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.bdinstall.appstate.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppStateListener.java */
    public interface InterfaceC0144a {
        void a();
    }

    boolean isActive();

    boolean isForeground();

    void setOnResumeListener(InterfaceC0144a r1);
}
