package com.bytedance.android.shopping.anchorv4.containers.page;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelStore;

/* JADX INFO: loaded from: classes12.dex */
public interface n {

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final a f166297j1 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f166298a = null;

        public a() {
        }

        static {
            f166298a = new a();
        }
    }

    static {
        f166297j1 = a.f166298a;
    }

    View N();

    String f();

    PageLifeCycleOwner getLifecycleOwner();

    String getSessionId();

    ViewModelStore getViewModelStore();

    void j();

    p k();

    boolean onBackPressed();

    void onConfigurationChanged(Configuration r100);

    void onSaveInstanceState(Bundle r100);

    String s();
}
