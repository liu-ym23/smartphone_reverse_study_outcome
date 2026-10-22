package com.android.server.contentprotection;

import android.app.admin.DevicePolicyCache;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Slog;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes.dex */
public class ContentProtectionConsentManager {
    private static final String KEY_CONTENT_PROTECTION_USER_CONSENT = "content_protection_user_consent";
    private static final String KEY_PACKAGE_VERIFIER_USER_CONSENT = "package_verifier_user_consent";
    private static final String TAG = "ContentProtectionConsentManager";
    private volatile boolean mCachedContentProtectionUserConsent;
    private volatile boolean mCachedPackageVerifierConsent;
    public final ContentObserver mContentObserver;
    private final ContentResolver mContentResolver;
    private final DevicePolicyCache mDevicePolicyCache;
    private final DevicePolicyManagerInternal mDevicePolicyManagerInternal;

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ ContentProtectionConsentManager this$0;

        SettingsObserver(ContentProtectionConsentManager r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (uri != null) goto L4;
            return;
        L4:
            String property = uri.getLastPathSegment();
            if (property != null) goto L8;
            return;
        L8:
            switch(property.hashCode()) {
                case 480463670: goto L14;
                case 802188678: goto L11;
                default: goto L16;
            };
        L16:
            byte r1 = -1;
        L17:
            switch(r1) {
                case 0: goto L22;
                case 1: goto L20;
                default: goto L18;
            };
        L18:
            Slog.w(ContentProtectionConsentManager.TAG, "Ignoring unexpected property: " + property);
            return;
        L20:
            ContentProtectionConsentManager.m3235$$Nest$mreadContentProtectionUserConsentGranted(this.this$0);
            return;
        L22:
            ContentProtectionConsentManager.m3236$$Nest$mreadPackageVerifierConsentGranted(this.this$0);
            return;
        L11:
            if (property.equals(ContentProtectionConsentManager.KEY_CONTENT_PROTECTION_USER_CONSENT) == false) goto L16;
            r1 = 1;
            goto L17
        L14:
            if (property.equals(ContentProtectionConsentManager.KEY_PACKAGE_VERIFIER_USER_CONSENT) == false) goto L16;
            r1 = 0;
            goto L17
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mreadContentProtectionUserConsentGranted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3235$$Nest$mreadContentProtectionUserConsentGranted(ContentProtectionConsentManager r0) {
        r0.readContentProtectionUserConsentGranted();
    }

    /* JADX INFO: renamed from: -$$Nest$mreadPackageVerifierConsentGranted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3236$$Nest$mreadPackageVerifierConsentGranted(ContentProtectionConsentManager r0) {
        r0.readPackageVerifierConsentGranted();
    }

    public ContentProtectionConsentManager(Handler handler, ContentResolver contentResolver, DevicePolicyCache devicePolicyCache) {
        this.mContentResolver = contentResolver;
        this.mDevicePolicyCache = devicePolicyCache;
        this.mDevicePolicyManagerInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        this.mContentObserver = new SettingsObserver(this, handler);
        registerSettingsGlobalObserver(KEY_PACKAGE_VERIFIER_USER_CONSENT);
        registerSettingsGlobalObserver(KEY_CONTENT_PROTECTION_USER_CONSENT);
        readPackageVerifierConsentGranted();
        readContentProtectionUserConsentGranted();
    }

    public boolean isConsentGranted(int userId) {
        if (this.mCachedPackageVerifierConsent == true) goto L5;
    L7:
        return false;
    L5:
        if (isContentProtectionConsentGranted(userId) == false) goto L7;
        return true;
    }

    private boolean isPackageVerifierConsentGranted() {
        if (Settings.Global.getInt(this.mContentResolver, KEY_PACKAGE_VERIFIER_USER_CONSENT, 0) >= 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isContentProtectionUserConsentGranted() {
        if (Settings.Global.getInt(this.mContentResolver, KEY_CONTENT_PROTECTION_USER_CONSENT, 0) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void readPackageVerifierConsentGranted() {
        this.mCachedPackageVerifierConsent = isPackageVerifierConsentGranted();
    }

    private void readContentProtectionUserConsentGranted() {
        this.mCachedContentProtectionUserConsent = isContentProtectionUserConsentGranted();
    }

    private boolean isUserOrganizationManaged(int userId) {
        return this.mDevicePolicyManagerInternal.isUserOrganizationManaged(userId);
    }

    private boolean isContentProtectionPolicyGranted(int userId) {
        int policy = this.mDevicePolicyCache.getContentProtectionPolicy(userId);
        switch(policy) {
            case 0: goto L7;
            case 1: goto L4;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        return true;
    L7:
        return this.mCachedContentProtectionUserConsent;
    }

    private boolean isContentProtectionConsentGranted(int userId) {
        if (isUserOrganizationManaged(userId) == false) goto L6;
        return isContentProtectionPolicyGranted(userId);
    L6:
        return this.mCachedContentProtectionUserConsent;
    }

    private void registerSettingsGlobalObserver(String key) {
        registerSettingsObserver(Settings.Global.getUriFor(key));
    }

    private void registerSettingsObserver(Uri uri) {
        this.mContentResolver.registerContentObserver(uri, false, this.mContentObserver, -1);
    }
}
