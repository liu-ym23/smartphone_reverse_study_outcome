package com.bytedance.android.live.wallet;

import android.app.Activity;
import com.bytedance.android.live.recharge.platform.service.w;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public interface e extends com.bytedance.android.live.recharge.core.c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f102664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f102665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f102666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f102667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f102668e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public HashMap<String, String> f102669f;

        public a() {
        }
    }

    public interface b {
        void a(c r100);

        void b(int r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f102670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f102671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f102672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f102673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f102674e;

        public static final class a {
        }

        static {
        }

        public c() {
        }
    }

    void Y(Activity r100, DetailChargeDeal r101, w r102);
}
