package com.android.server.location.countrydetector;

import android.content.Context;
import android.location.Country;
import android.location.CountryListener;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CountryDetectorBase {
    private static final String ATTRIBUTION_TAG = "CountryDetector";
    protected final Context mContext;
    protected Country mDetectedCountry;
    protected final Handler mHandler;
    protected CountryListener mListener;

    public abstract Country detectCountry();

    public abstract void stop();

    public CountryDetectorBase(Context context) {
        this.mContext = context.createAttributionContext(ATTRIBUTION_TAG);
        this.mHandler = new Handler();
    }

    public void setCountryListener(CountryListener listener) {
        this.mListener = listener;
    }

    protected void notifyListener(Country country) {
        if (this.mListener == null) goto L6;
        this.mListener.onCountryDetected(country);
        return;
    }
}
