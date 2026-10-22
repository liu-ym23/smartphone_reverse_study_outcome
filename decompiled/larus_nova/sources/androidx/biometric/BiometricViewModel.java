package androidx.biometric;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class BiometricViewModel extends ViewModel {
    private AuthenticationCallbackProvider mAuthenticationCallbackProvider;
    private MutableLiveData<BiometricErrorData> mAuthenticationError;
    private MutableLiveData<CharSequence> mAuthenticationHelpMessage;
    private MutableLiveData<BiometricPrompt.AuthenticationResult> mAuthenticationResult;
    private int mCanceledFrom;
    private CancellationSignalProvider mCancellationSignalProvider;
    private BiometricPrompt.AuthenticationCallback mClientCallback;
    private Executor mClientExecutor;
    private BiometricPrompt.CryptoObject mCryptoObject;
    private MutableLiveData<CharSequence> mFingerprintDialogHelpMessage;
    private int mFingerprintDialogPreviousState;
    private MutableLiveData<Integer> mFingerprintDialogState;
    private MutableLiveData<Boolean> mIsAuthenticationFailurePending;
    private boolean mIsAwaitingResult;
    private boolean mIsConfirmingDeviceCredential;
    private boolean mIsDelayingPrompt;
    private MutableLiveData<Boolean> mIsFingerprintDialogCancelPending;
    private boolean mIsFingerprintDialogDismissedInstantly;
    private boolean mIsIgnoringCancel;
    private MutableLiveData<Boolean> mIsNegativeButtonPressPending;
    private boolean mIsPromptShowing;
    private DialogInterface.OnClickListener mNegativeButtonListener;
    private CharSequence mNegativeButtonTextOverride;
    private BiometricPrompt.PromptInfo mPromptInfo;

    public static final class CallbackListener extends AuthenticationCallbackProvider.Listener {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        public void onFailure() {
            if (this.mViewModelRef.get() != null) goto L5;
            return;
        L5:
            if (this.mViewModelRef.get().isAwaitingResult() == false) goto L9;
            this.mViewModelRef.get().setAuthenticationFailurePending(true);
            return;
        }

        public CallbackListener(BiometricViewModel r100) {
            this.mViewModelRef = new WeakReference(r100);
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        public void onHelp(CharSequence r100) {
            if (this.mViewModelRef.get() == null) goto L6;
            this.mViewModelRef.get().setAuthenticationHelpMessage(r100);
            return;
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        public void onSuccess(BiometricPrompt.AuthenticationResult r100) {
            if (this.mViewModelRef.get() != null) goto L5;
            return;
        L5:
            if (this.mViewModelRef.get().isAwaitingResult() == true) goto L7;
            return;
        L7:
            if (r100.getAuthenticationType() != (-1)) goto L9;
            r100 = new BiometricPrompt.AuthenticationResult(r100.getCryptoObject(), this.mViewModelRef.get().getInferredAuthenticationResultType());
        L9:
            this.mViewModelRef.get().setAuthenticationResult(r100);
        }

        @Override // androidx.biometric.AuthenticationCallbackProvider.Listener
        public void onError(int r100, CharSequence r101) {
            if (this.mViewModelRef.get() != null) goto L5;
            return;
        L5:
            if (this.mViewModelRef.get().isConfirmingDeviceCredential() == false) goto L7;
            return;
        L7:
            if (this.mViewModelRef.get().isAwaitingResult() == false) goto L12;
            this.mViewModelRef.get().setAuthenticationError(new BiometricErrorData(r100, r101));
            return;
        }
    }

    public static class DefaultExecutor implements Executor {
        private final Handler mHandler;

        public DefaultExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mHandler.post(r100);
        }
    }

    public static class NegativeButtonListener implements DialogInterface.OnClickListener {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        public NegativeButtonListener(BiometricViewModel r100) {
            this.mViewModelRef = new WeakReference(r100);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r100, int r101) {
            if (this.mViewModelRef.get() == null) goto L6;
            this.mViewModelRef.get().setNegativeButtonPressPending(true);
            return;
        }
    }

    public void resetClientCallback() {
        this.mClientCallback = null;
    }

    public int getAllowedAuthenticators() {
        BiometricPrompt.PromptInfo r100 = this.mPromptInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return AuthenticatorUtils.getConsolidatedAuthenticators(r100, this.mCryptoObject);
    }

    public AuthenticationCallbackProvider getAuthenticationCallbackProvider() {
        if (this.mAuthenticationCallbackProvider != null) goto L6;
        this.mAuthenticationCallbackProvider = new AuthenticationCallbackProvider(new CallbackListener(this));
    L6:
        return this.mAuthenticationCallbackProvider;
    }

    public MutableLiveData<BiometricErrorData> getAuthenticationError() {
        if (this.mAuthenticationError != null) goto L6;
        this.mAuthenticationError = new MutableLiveData();
    L6:
        return this.mAuthenticationError;
    }

    public LiveData<CharSequence> getAuthenticationHelpMessage() {
        if (this.mAuthenticationHelpMessage != null) goto L6;
        this.mAuthenticationHelpMessage = new MutableLiveData();
    L6:
        return this.mAuthenticationHelpMessage;
    }

    public LiveData<BiometricPrompt.AuthenticationResult> getAuthenticationResult() {
        if (this.mAuthenticationResult != null) goto L6;
        this.mAuthenticationResult = new MutableLiveData();
    L6:
        return this.mAuthenticationResult;
    }

    public CancellationSignalProvider getCancellationSignalProvider() {
        if (this.mCancellationSignalProvider != null) goto L6;
        this.mCancellationSignalProvider = new CancellationSignalProvider();
    L6:
        return this.mCancellationSignalProvider;
    }

    public BiometricPrompt.AuthenticationCallback getClientCallback() {
        if (this.mClientCallback != null) goto L6;
        this.mClientCallback = new AnonymousClass1(this);
    L6:
        return this.mClientCallback;
    }

    public Executor getClientExecutor() {
        Executor r100 = this.mClientExecutor;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new DefaultExecutor();
    }

    public CharSequence getDescription() {
        BiometricPrompt.PromptInfo r100 = this.mPromptInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDescription();
    }

    public LiveData<CharSequence> getFingerprintDialogHelpMessage() {
        if (this.mFingerprintDialogHelpMessage != null) goto L6;
        this.mFingerprintDialogHelpMessage = new MutableLiveData();
    L6:
        return this.mFingerprintDialogHelpMessage;
    }

    public LiveData<Integer> getFingerprintDialogState() {
        if (this.mFingerprintDialogState != null) goto L6;
        this.mFingerprintDialogState = new MutableLiveData();
    L6:
        return this.mFingerprintDialogState;
    }

    public DialogInterface.OnClickListener getNegativeButtonListener() {
        if (this.mNegativeButtonListener != null) goto L6;
        this.mNegativeButtonListener = new NegativeButtonListener(this);
    L6:
        return this.mNegativeButtonListener;
    }

    public CharSequence getNegativeButtonText() {
        CharSequence r100 = this.mNegativeButtonTextOverride;
        if (r100 == null) goto L5;
        return r100;
    L5:
        BiometricPrompt.PromptInfo r101 = this.mPromptInfo;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getNegativeButtonText();
    }

    public CharSequence getSubtitle() {
        BiometricPrompt.PromptInfo r100 = this.mPromptInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSubtitle();
    }

    public CharSequence getTitle() {
        BiometricPrompt.PromptInfo r100 = this.mPromptInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTitle();
    }

    public LiveData<Boolean> isAuthenticationFailurePending() {
        if (this.mIsAuthenticationFailurePending != null) goto L6;
        this.mIsAuthenticationFailurePending = new MutableLiveData();
    L6:
        return this.mIsAuthenticationFailurePending;
    }

    public boolean isConfirmationRequired() {
        BiometricPrompt.PromptInfo r100 = this.mPromptInfo;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isConfirmationRequired() == true) goto L8;
        return false;
    }

    public LiveData<Boolean> isFingerprintDialogCancelPending() {
        if (this.mIsFingerprintDialogCancelPending != null) goto L6;
        this.mIsFingerprintDialogCancelPending = new MutableLiveData();
    L6:
        return this.mIsFingerprintDialogCancelPending;
    }

    public LiveData<Boolean> isNegativeButtonPressPending() {
        if (this.mIsNegativeButtonPressPending != null) goto L6;
        this.mIsNegativeButtonPressPending = new MutableLiveData();
    L6:
        return this.mIsNegativeButtonPressPending;
    }

    public BiometricViewModel() {
        this.mCanceledFrom = 0;
        this.mIsFingerprintDialogDismissedInstantly = true;
        this.mFingerprintDialogPreviousState = 0;
    }

    public int getInferredAuthenticationResultType() {
        int r100 = getAllowedAuthenticators();
        if (AuthenticatorUtils.isSomeBiometricAllowed(r100) == true) goto L5;
        return -1;
    L5:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(r100) == true) goto L10;
        return 2;
    L10:
        return -1;
    }

    public int getCanceledFrom() {
        return this.mCanceledFrom;
    }

    public BiometricPrompt.CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }

    public int getFingerprintDialogPreviousState() {
        return this.mFingerprintDialogPreviousState;
    }

    public boolean isAwaitingResult() {
        return this.mIsAwaitingResult;
    }

    public boolean isConfirmingDeviceCredential() {
        return this.mIsConfirmingDeviceCredential;
    }

    public boolean isDelayingPrompt() {
        return this.mIsDelayingPrompt;
    }

    public boolean isFingerprintDialogDismissedInstantly() {
        return this.mIsFingerprintDialogDismissedInstantly;
    }

    public boolean isIgnoringCancel() {
        return this.mIsIgnoringCancel;
    }

    public boolean isPromptShowing() {
        return this.mIsPromptShowing;
    }

    public void setAuthenticationError(BiometricErrorData r100) {
        if (this.mAuthenticationError != null) goto L5;
        this.mAuthenticationError = new MutableLiveData();
    L5:
        updateValue(this.mAuthenticationError, r100);
    }

    public void setAuthenticationFailurePending(boolean r100) {
        if (this.mIsAuthenticationFailurePending != null) goto L5;
        this.mIsAuthenticationFailurePending = new MutableLiveData();
    L5:
        updateValue(this.mIsAuthenticationFailurePending, Boolean.valueOf(r100));
    }

    public void setAuthenticationHelpMessage(CharSequence r100) {
        if (this.mAuthenticationHelpMessage != null) goto L5;
        this.mAuthenticationHelpMessage = new MutableLiveData();
    L5:
        updateValue(this.mAuthenticationHelpMessage, r100);
    }

    public void setAuthenticationResult(BiometricPrompt.AuthenticationResult r100) {
        if (this.mAuthenticationResult != null) goto L5;
        this.mAuthenticationResult = new MutableLiveData();
    L5:
        updateValue(this.mAuthenticationResult, r100);
    }

    public void setAwaitingResult(boolean r100) {
        this.mIsAwaitingResult = r100;
    }

    public void setCanceledFrom(int r100) {
        this.mCanceledFrom = r100;
    }

    public void setClientCallback(BiometricPrompt.AuthenticationCallback r100) {
        this.mClientCallback = r100;
    }

    public void setClientExecutor(Executor r100) {
        this.mClientExecutor = r100;
    }

    public void setConfirmingDeviceCredential(boolean r100) {
        this.mIsConfirmingDeviceCredential = r100;
    }

    public void setCryptoObject(BiometricPrompt.CryptoObject r100) {
        this.mCryptoObject = r100;
    }

    public void setDelayingPrompt(boolean r100) {
        this.mIsDelayingPrompt = r100;
    }

    public void setFingerprintDialogCancelPending(boolean r100) {
        if (this.mIsFingerprintDialogCancelPending != null) goto L5;
        this.mIsFingerprintDialogCancelPending = new MutableLiveData();
    L5:
        updateValue(this.mIsFingerprintDialogCancelPending, Boolean.valueOf(r100));
    }

    public void setFingerprintDialogDismissedInstantly(boolean r100) {
        this.mIsFingerprintDialogDismissedInstantly = r100;
    }

    public void setFingerprintDialogHelpMessage(CharSequence r100) {
        if (this.mFingerprintDialogHelpMessage != null) goto L5;
        this.mFingerprintDialogHelpMessage = new MutableLiveData();
    L5:
        updateValue(this.mFingerprintDialogHelpMessage, r100);
    }

    public void setFingerprintDialogPreviousState(int r100) {
        this.mFingerprintDialogPreviousState = r100;
    }

    public void setFingerprintDialogState(int r100) {
        if (this.mFingerprintDialogState != null) goto L5;
        this.mFingerprintDialogState = new MutableLiveData();
    L5:
        updateValue(this.mFingerprintDialogState, Integer.valueOf(r100));
    }

    public void setIgnoringCancel(boolean r100) {
        this.mIsIgnoringCancel = r100;
    }

    public void setNegativeButtonPressPending(boolean r100) {
        if (this.mIsNegativeButtonPressPending != null) goto L5;
        this.mIsNegativeButtonPressPending = new MutableLiveData();
    L5:
        updateValue(this.mIsNegativeButtonPressPending, Boolean.valueOf(r100));
    }

    public void setNegativeButtonTextOverride(CharSequence r100) {
        this.mNegativeButtonTextOverride = r100;
    }

    public void setPromptInfo(BiometricPrompt.PromptInfo r100) {
        this.mPromptInfo = r100;
    }

    public void setPromptShowing(boolean r100) {
        this.mIsPromptShowing = r100;
    }

    private static <T> void updateValue(MutableLiveData<T> r100, T r101) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        r100.setValue(r101);
        return;
    L5:
        r100.postValue(r101);
    }
}
