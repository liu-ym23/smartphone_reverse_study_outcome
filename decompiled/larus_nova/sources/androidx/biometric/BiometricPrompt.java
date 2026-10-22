package androidx.biometric;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes6.dex */
public class BiometricPrompt {
    public static final int AUTHENTICATION_RESULT_TYPE_BIOMETRIC = 2;
    public static final int AUTHENTICATION_RESULT_TYPE_DEVICE_CREDENTIAL = 1;
    public static final int AUTHENTICATION_RESULT_TYPE_UNKNOWN = -1;
    private static final String BIOMETRIC_FRAGMENT_TAG = "androidx.biometric.BiometricFragment";
    static final int BIOMETRIC_SUCCESS = 0;
    public static final int ERROR_CANCELED = 5;
    public static final int ERROR_HW_NOT_PRESENT = 12;
    public static final int ERROR_HW_UNAVAILABLE = 1;
    public static final int ERROR_LOCKOUT = 7;
    public static final int ERROR_LOCKOUT_PERMANENT = 9;
    public static final int ERROR_NEGATIVE_BUTTON = 13;
    public static final int ERROR_NO_BIOMETRICS = 11;
    public static final int ERROR_NO_DEVICE_CREDENTIAL = 14;
    public static final int ERROR_NO_SPACE = 4;
    public static final int ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int ERROR_TIMEOUT = 3;
    public static final int ERROR_UNABLE_TO_PROCESS = 2;
    public static final int ERROR_USER_CANCELED = 10;
    public static final int ERROR_VENDOR = 8;
    private static final String TAG = "BiometricPromptCompat";
    private FragmentManager mClientFragmentManager;

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r100, CharSequence r101) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r100) {
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class AuthenticationResult {
        private final int mAuthenticationType;
        private final CryptoObject mCryptoObject;

        public int getAuthenticationType() {
            return this.mAuthenticationType;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }

        public AuthenticationResult(CryptoObject r100, int r101) {
            this.mCryptoObject = r100;
            this.mAuthenticationType = r101;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class CryptoObject {
        private final Cipher mCipher;
        private final IdentityCredential mIdentityCredential;
        private final Mac mMac;
        private final Signature mSignature;

        public Cipher getCipher() {
            return this.mCipher;
        }

        public IdentityCredential getIdentityCredential() {
            return this.mIdentityCredential;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(IdentityCredential r100) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = r100;
        }

        public CryptoObject(Signature r100) {
            this.mSignature = r100;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = null;
        }

        public CryptoObject(Cipher r100) {
            this.mSignature = null;
            this.mCipher = r100;
            this.mMac = null;
            this.mIdentityCredential = null;
        }

        public CryptoObject(Mac r100) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = r100;
            this.mIdentityCredential = null;
        }
    }

    public static class PromptInfo {
        private final int mAllowedAuthenticators;
        private final CharSequence mDescription;
        private final boolean mIsConfirmationRequired;
        private final boolean mIsDeviceCredentialAllowed;
        private final CharSequence mNegativeButtonText;
        private final CharSequence mSubtitle;
        private final CharSequence mTitle;

        public static class Builder {
            private int mAllowedAuthenticators;
            private CharSequence mDescription;
            private boolean mIsConfirmationRequired;
            private boolean mIsDeviceCredentialAllowed;
            private CharSequence mNegativeButtonText;
            private CharSequence mSubtitle;
            private CharSequence mTitle;

            public PromptInfo build() {
                if (TextUtils.isEmpty(this.mTitle) == true) goto L27;
                if (AuthenticatorUtils.isSupportedCombination(this.mAllowedAuthenticators) == false) goto L25;
                int r100 = this.mAllowedAuthenticators;
                if (r100 == 0) goto L9;
                boolean r101 = AuthenticatorUtils.isDeviceCredentialAllowed(r100);
            L11:
                if (TextUtils.isEmpty(this.mNegativeButtonText) == false) goto L17;
                if (r101 == true) goto L17;
                throw new IllegalArgumentException("Negative text must be set and non-empty.");
            L17:
                if (TextUtils.isEmpty(this.mNegativeButtonText) == true) goto L23;
                if (r101 == false) goto L23;
                throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
            L23:
                return new PromptInfo(this.mTitle, this.mSubtitle, this.mDescription, this.mNegativeButtonText, this.mIsConfirmationRequired, this.mIsDeviceCredentialAllowed, this.mAllowedAuthenticators);
            L9:
                r101 = this.mIsDeviceCredentialAllowed;
                goto L11
            L25:
                throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + AuthenticatorUtils.convertToString(this.mAllowedAuthenticators));
            L27:
                throw new IllegalArgumentException("Title must be set and non-empty.");
            }

            public Builder() {
                this.mTitle = null;
                this.mSubtitle = null;
                this.mDescription = null;
                this.mNegativeButtonText = null;
                this.mIsConfirmationRequired = true;
                this.mIsDeviceCredentialAllowed = false;
                this.mAllowedAuthenticators = 0;
            }

            public Builder setAllowedAuthenticators(int r100) {
                this.mAllowedAuthenticators = r100;
                return this;
            }

            public Builder setConfirmationRequired(boolean r100) {
                this.mIsConfirmationRequired = r100;
                return this;
            }

            public Builder setDescription(CharSequence r100) {
                this.mDescription = r100;
                return this;
            }

            public Builder setDeviceCredentialAllowed(boolean r100) {
                this.mIsDeviceCredentialAllowed = r100;
                return this;
            }

            public Builder setNegativeButtonText(CharSequence r100) {
                this.mNegativeButtonText = r100;
                return this;
            }

            public Builder setSubtitle(CharSequence r100) {
                this.mSubtitle = r100;
                return this;
            }

            public Builder setTitle(CharSequence r100) {
                this.mTitle = r100;
                return this;
            }
        }

        public CharSequence getNegativeButtonText() {
            CharSequence r100 = this.mNegativeButtonText;
            if (r100 != null) goto L7;
            return "";
        L7:
            return r100;
        }

        public int getAllowedAuthenticators() {
            return this.mAllowedAuthenticators;
        }

        public CharSequence getDescription() {
            return this.mDescription;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public boolean isConfirmationRequired() {
            return this.mIsConfirmationRequired;
        }

        public boolean isDeviceCredentialAllowed() {
            return this.mIsDeviceCredentialAllowed;
        }

        public PromptInfo(CharSequence r100, CharSequence r101, CharSequence r102, CharSequence r103, boolean r104, boolean r105, int r106) {
            this.mTitle = r100;
            this.mSubtitle = r101;
            this.mDescription = r102;
            this.mNegativeButtonText = r103;
            this.mIsConfirmationRequired = r104;
            this.mIsDeviceCredentialAllowed = r105;
            this.mAllowedAuthenticators = r106;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class ResetCallbackObserver implements LifecycleObserver {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void resetCallback() {
            if (this.mViewModelRef.get() == null) goto L6;
            this.mViewModelRef.get().resetClientCallback();
            return;
        }

        public ResetCallbackObserver(BiometricViewModel r100) {
            this.mViewModelRef = new WeakReference(r100);
        }
    }

    public void cancelAuthentication() {
        FragmentManager r100 = this.mClientFragmentManager;
        if (r100 != null) goto L5;
        return;
    L5:
        BiometricFragment r101 = findBiometricFragment(r100);
        if (r101 != null) goto L8;
        return;
    L8:
        r101.cancelAuthentication(3);
    }

    private static BiometricFragment findBiometricFragment(FragmentManager r100) {
        return (BiometricFragment) r100.findFragmentByTag(BIOMETRIC_FRAGMENT_TAG);
    }

    private static BiometricFragment findOrAddBiometricFragment(FragmentManager r100) {
        BiometricFragment r101 = findBiometricFragment(r100);
        if (r101 != null) goto L6;
        BiometricFragment r102 = BiometricFragment.newInstance();
        INVOKEVIRTUAL_androidx_biometric_BiometricPrompt_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100.beginTransaction(), r102, BIOMETRIC_FRAGMENT_TAG).commitAllowingStateLoss();
        r100.executePendingTransactions();
        return r102;
    L6:
        return r101;
    }

    private static BiometricViewModel getViewModel(FragmentActivity r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (BiometricViewModel) new ViewModelProvider(r100).get(BiometricViewModel.class);
    }

    public void authenticate(PromptInfo r100) {
        if (r100 == null) goto L6;
        authenticateInternal(r100, null);
        return;
    L6:
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    public BiometricPrompt(Fragment r100, AuthenticationCallback r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        FragmentActivity r102 = r100.getActivity();
        FragmentManager r103 = r100.getChildFragmentManager();
        BiometricViewModel r104 = getViewModel(r102);
        addObservers(r100, r104);
        init(r103, r104, null, r101);
        return;
    L8:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L10:
        throw new IllegalArgumentException("Fragment must not be null.");
    }

    private static void addObservers(Fragment r100, BiometricViewModel r101) {
        if (r101 == null) goto L5;
        r100.getLifecycle().addObserver(new ResetCallbackObserver(r101));
        return;
    }

    private void authenticateInternal(PromptInfo r100, CryptoObject r101) {
        FragmentManager r102 = this.mClientFragmentManager;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.isStateSaved() == false) goto L8;
        return;
    L8:
        findOrAddBiometricFragment(this.mClientFragmentManager).authenticate(r100, r101);
    }

    public void authenticate(PromptInfo r100, CryptoObject r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L18;
        int r102 = AuthenticatorUtils.getConsolidatedAuthenticators(r100, r101);
        if (AuthenticatorUtils.isWeakBiometricAllowed(r102) == true) goto L16;
        if (Build.VERSION.SDK_INT < 30) goto L9;
    L13:
        authenticateInternal(r100, r101);
        return;
    L9:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r102) == false) goto L13;
        throw new IllegalArgumentException("Crypto-based authentication is not supported for device credential prior to API 30.");
    L16:
        throw new IllegalArgumentException("Crypto-based authentication is not supported for Class 2 (Weak) biometrics.");
    L18:
        throw new IllegalArgumentException("CryptoObject cannot be null.");
    L20:
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    public BiometricPrompt(FragmentActivity r100, AuthenticationCallback r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        init(r100.getSupportFragmentManager(), getViewModel(r100), null, r101);
        return;
    L8:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L10:
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    public BiometricPrompt(Fragment r100, Executor r101, AuthenticationCallback r102) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        FragmentActivity r103 = r100.getActivity();
        FragmentManager r104 = r100.getChildFragmentManager();
        BiometricViewModel r105 = getViewModel(r103);
        addObservers(r100, r105);
        init(r104, r105, r101, r102);
        return;
    L9:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L11:
        throw new IllegalArgumentException("Executor must not be null.");
    L13:
        throw new IllegalArgumentException("Fragment must not be null.");
    }

    public static FragmentTransaction INVOKEVIRTUAL_androidx_biometric_BiometricPrompt_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    public BiometricPrompt(FragmentActivity r100, Executor r101, AuthenticationCallback r102) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        init(r100.getSupportFragmentManager(), getViewModel(r100), r101, r102);
        return;
    L9:
        throw new IllegalArgumentException("AuthenticationCallback must not be null.");
    L11:
        throw new IllegalArgumentException("Executor must not be null.");
    L13:
        throw new IllegalArgumentException("FragmentActivity must not be null.");
    }

    private void init(FragmentManager r100, BiometricViewModel r101, Executor r102, AuthenticationCallback r103) {
        this.mClientFragmentManager = r100;
        if (r101 == null) goto L8;
        if (r102 == null) goto L6;
        r101.setClientExecutor(r102);
    L6:
        r101.setClientCallback(r103);
        return;
    }
}
