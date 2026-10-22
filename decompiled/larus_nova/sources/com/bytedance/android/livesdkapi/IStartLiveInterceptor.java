package com.bytedance.android.livesdkapi;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public interface IStartLiveInterceptor {

    public interface Chain {
        void notifyInterceptDestroy();

        void notifyInterceptFinish();

        void notifyInterceptStart();

        void process();

        StartLiveParams request();
    }

    public static class StartLiveParams {
        public static final String KEY_COMMERCE_LIVE_ENABLED = "has_commerce_goods";
        public Context context;
        public FastStartLiveConfig fastStartLiveConfig;
        public Fragment fragment;
        public HashMap<String, String> urlParams;

        public StartLiveParams(Context r100, Fragment r101) {
            this(r100, r101, null);
        }

        public StartLiveParams(Context r100, Fragment r101, FastStartLiveConfig r102) {
            this.urlParams = new HashMap();
            this.context = r100;
            this.fragment = r101;
            this.fastStartLiveConfig = r102;
        }
    }

    void intercept(Chain r100);

    void onInterceptDestroy();

    void onInterceptFinish();

    void onInterceptStart();

    void onSetupComplete();
}
