package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, String> f68364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f68365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f68366c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f68367a;

        public a(r r100) {
            this.f68367a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f68367a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public r() {
        new CompositeDisposable();
        this.f68364a = new LinkedHashMap();
        this.f68365b = new ArrayList();
        Long r100 = LiveEffectSettings.LIVE_EFFECT_POLLING_INTERACT_INFO_INTERVAL.getValue();
        this.f68366c = "";
        new a(this);
    }
}
