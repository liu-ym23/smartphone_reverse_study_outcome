package com.android.server.credentials.metrics;

import com.android.server.credentials.metrics.shared.ResponseCollective;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BrowsedAuthenticationMetric {
    private static final String TAG = "AuthenticationMetric";
    private ResponseCollective mAuthEntryCollective;
    private boolean mAuthReturned;
    private String mFrameworkException;
    private boolean mHasException;
    private int mProviderStatus;
    private int mProviderUid;
    private final int mSessionIdProvider;

    public BrowsedAuthenticationMetric(int sessionIdProvider) {
        this.mProviderUid = -1;
        this.mAuthEntryCollective = new ResponseCollective(Map.of(), Map.of());
        this.mHasException = false;
        this.mFrameworkException = "";
        this.mProviderStatus = -1;
        this.mAuthReturned = false;
        this.mSessionIdProvider = sessionIdProvider;
    }

    public int getSessionIdProvider() {
        return this.mSessionIdProvider;
    }

    public void setProviderUid(int providerUid) {
        this.mProviderUid = providerUid;
    }

    public int getProviderUid() {
        return this.mProviderUid;
    }

    public void setAuthEntryCollective(ResponseCollective authEntryCollective) {
        this.mAuthEntryCollective = authEntryCollective;
    }

    public ResponseCollective getAuthEntryCollective() {
        return this.mAuthEntryCollective;
    }

    public void setHasException(boolean hasException) {
        this.mHasException = hasException;
    }

    public void setFrameworkException(String frameworkException) {
        this.mFrameworkException = frameworkException;
    }

    public void setProviderStatus(int providerStatus) {
        this.mProviderStatus = providerStatus;
    }

    public void setAuthReturned(boolean authReturned) {
        this.mAuthReturned = authReturned;
    }

    public boolean isAuthReturned() {
        return this.mAuthReturned;
    }

    public int getProviderStatus() {
        return this.mProviderStatus;
    }

    public String getFrameworkException() {
        return this.mFrameworkException;
    }

    public boolean isHasException() {
        return this.mHasException;
    }
}
