package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes39.dex */
class ApplicationLifecycle implements Lifecycle {
    public ApplicationLifecycle() {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener r100) {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener r100) {
        r100.onStart();
    }
}
