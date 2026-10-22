package com.mdisdk.capability.thirdpart;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.constraintlayout.core.dsl.a;
import com.mdisdk.capability.aidl.IGrabNodeCallback;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.ResultInfo;

/* loaded from: classes3.dex */
public class RequestMain {
    private static final int DEFAULT_WINDOWING_MODE = 1;
    private static final int DEFAULT_WINDOW_TYPE = 1;
    private static final String TAG = "RequestMain";
    private static final RequestHandler sHandler = new RequestHandler();

    @Nullable
    private static IGrabNodeCallback extractCallback(@NonNull Bundle bundle) {
        IBinder binder = bundle.getBinder("targetDexBinder");
        if (binder == null || !binder.isBinderAlive()) {
            Log.e(TAG, "Callback binder is null or died");
            return null;
        }
        IGrabNodeCallback iGrabNodeCallbackAsInterface = IGrabNodeCallback.Stub.asInterface(binder);
        if (iGrabNodeCallbackAsInterface == null) {
            Log.e(TAG, "Failed to create callback interface");
        }
        return iGrabNodeCallbackAsInterface;
    }

    @Nullable
    private static RequestInfo extractRequestInfo(@NonNull Bundle bundle) {
        RequestInfo requestInfo = (RequestInfo) bundle.getParcelable("requestInfo");
        if (requestInfo == null) {
            Log.e(TAG, "RequestInfo is null");
            return null;
        }
        Log.d(TAG, "RequestInfo: " + requestInfo);
        return requestInfo;
    }

    @UiThread
    private static void handleApexRequest(View view, Intent intent) {
        RequestInfo requestInfoExtractRequestInfo;
        if (view == null || intent == null) {
            Log.e(TAG, "Invalid parameters: root=" + view + ", intent=" + intent);
            return;
        }
        intent.setExtrasClassLoader(RequestInfo.class.getClassLoader());
        Log.d(TAG, "Request from package: " + view.getContext().getOpPackageName());
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e(TAG, "Intent extras is null");
            return;
        }
        extras.setClassLoader(RequestInfo.class.getClassLoader());
        IGrabNodeCallback iGrabNodeCallbackExtractCallback = extractCallback(extras);
        if (iGrabNodeCallbackExtractCallback == null || (requestInfoExtractRequestInfo = extractRequestInfo(extras)) == null) {
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("visible_windows");
        int intExtra = intent.getIntExtra("window_count", 1);
        a.p(intExtra, "result window count:", TAG);
        ResultInfo resultInfoProcess = sHandler.process(view, requestInfoExtractRequestInfo, bundleExtra);
        if (resultInfoProcess == null) {
            Log.e(TAG, "Failed to process request");
        } else {
            replyResultToApex(iGrabNodeCallbackExtractCallback, resultInfoProcess, intExtra);
        }
    }

    private static void replyResultToApex(@NonNull IGrabNodeCallback iGrabNodeCallback, @NonNull ResultInfo resultInfo, int i) {
        try {
            Intent intent = new Intent();
            intent.setExtrasClassLoader(ResultInfo.class.getClassLoader());
            Bundle bundle = new Bundle();
            bundle.setClassLoader(ResultInfo.class.getClassLoader());
            bundle.putParcelable("result", resultInfo);
            intent.putExtras(bundle);
            intent.putExtra("window_count", i);
            iGrabNodeCallback.onGrabNodeCallback(resultInfo.getResultCode(), intent);
            Log.d(TAG, "Result sent successfully, windowCount=" + i);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to send result via binder", e);
        }
    }
}
