package com.android.contacts.recommend;

import android.content.Context;
import android.location.Country;
import android.location.CountryDetector;
import android.os.Looper;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class CountryMonitor {
    private static CountryMonitor sInstance;
    private Context mContext;
    private String mCurrentCountryIso;

    static /* synthetic */ String access$002(CountryMonitor r0, String r1) {
        r0.mCurrentCountryIso = r1;
        return r1;
    }

    private CountryMonitor(Context r1) {
        this.mContext = r1;
    }

    public static synchronized CountryMonitor getInstance(Context r2) {
        monitor-enter(CountryMonitor.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CountryMonitor(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        CountryMonitor r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CountryMonitor.class);
        return r3;
    }

    public synchronized String getCountryIso() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentCountryIso != null) goto L14;
        CountryDetector r0 = (CountryDetector) this.mContext.getSystemService("country_detector");     // Catch: Throwable -> L17
        if (r0 == null) goto L8;
        Country r1 = r0.detectCountry();     // Catch: Throwable -> L17
    L9:
        if (r1 != null) goto L13;
        String r2 = Locale.getDefault().getCountry();     // Catch: Throwable -> L17
        monitor-exit(this);
        return r2;
    L13:
        this.mCurrentCountryIso = r1.getCountryIso();     // Catch: Throwable -> L17
        r0.addCountryListener(new AnonymousClass1(this), Looper.getMainLooper());     // Catch: Throwable -> L17
        goto L14
    L8:
        r1 = null;
    L14:
        String r3 = this.mCurrentCountryIso;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r3;
    }
}
