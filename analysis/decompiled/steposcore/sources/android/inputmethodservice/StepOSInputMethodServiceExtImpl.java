package android.inputmethodservice;

import android.R;
import android.content.Context;
import android.content.IntentExt;
import android.os.BuildExt;
import android.permission.StepOSHipsServiceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodInfo;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import stepos.app.StepOSWindowManager;
import stepos.inputmethod.QsActionManager;
import stepos.inputmethod.sms.SmsOtpCapsuleController;

/* loaded from: classes.dex */
public class StepOSInputMethodServiceExtImpl implements IStepOSInputMethodServiceExt {
    private static final List<String> IME_BLACK_PACKAGES = new ArrayList();
    private static final String TAG = "StepOSImsExt";
    private SmsOtpCapsuleController mSmsOtpController;

    static {
        IME_BLACK_PACKAGES.add("com.google.android.voicesearch.ime");
        IME_BLACK_PACKAGES.add("com.google.android.tts");
        IME_BLACK_PACKAGES.add("com.stepos.linkpc");
        IME_BLACK_PACKAGES.add("com.upuphone.star.launcher");
        IME_BLACK_PACKAGES.add("com.stepos.secureinput");
    }

    public boolean isInPasswordMode() {
        try {
            return StepOSHipsServiceManager.getInstance().isInPasswordMode();
        } catch (Exception e) {
            Log.e(TAG, "isInPasswordMode: cannot get password mode state", e);
            return false;
        }
    }

    public boolean isSecurityKbSwitchOn() {
        try {
            return StepOSHipsServiceManager.getInstance().isSecurityKBSwitchOn();
        } catch (Exception e) {
            Log.e(TAG, "isSecurityKbSwitchOn: cannot get security KB state", e);
            return false;
        }
    }

    public boolean shouldShowInInputMethodPicker(InputMethodInfo info) {
        return BuildExt.isProductInternational() || !IME_BLACK_PACKAGES.contains(info.getServiceInfo().packageName);
    }

    public void onFinishInflate(FrameLayout navigationBarInflaterView, LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.media_controller, (ViewGroup) navigationBarInflaterView, false);
        navigationBarInflaterView.addView(view);
    }

    public int updateNavButtonIcons(int flags, Context context) {
        if (QsActionManager.getInstance(context).isEnable(context.getDisplayId())) {
            return 0;
        }
        return flags;
    }

    public boolean isQsEnable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return StepOSWindowManager.getInstance().isInputMethodQsEnable(context.getDisplayId());
        } catch (Throwable t) {
            Log.w(TAG, "isQsEnable: bridge to StepOSWindowManager failed", t);
            return false;
        }
    }

    public void onSmsOtpAreaInflated(InputMethodService ims, View rootView, LayoutInflater inflater) {
        if (this.mSmsOtpController != null) {
            this.mSmsOtpController.detach();
            this.mSmsOtpController = null;
        }
        this.mSmsOtpController = SmsOtpCapsuleController.attach(ims, rootView, inflater);
    }

    public void onWindowVisibilityChanged(InputMethodService ims, boolean visible) {
        if (this.mSmsOtpController != null) {
            this.mSmsOtpController.onImeWindowVisibilityChanged(visible);
        }
    }

    public boolean shouldDisableFullscreenMode(EditorInfo editorInfo) {
        return (editorInfo == null || (editorInfo.internalImeOptions & IntentExt.STEPOS_FLAG_DISABLE_SNAPSHOT) == 0) ? false : true;
    }
}
