package com.stepos.aiengine.deepbinder;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import com.stepos.aiengine.cta.PolicyActivity;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.deepbinder.service.DeepBinderProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIEngineDeepBinderProvider extends DeepBinderProvider {
    public static final a Companion = new a();
    private static final String TAG = "AIEngineDeepBinderProvider";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    @Override // com.stepos.deepbinder.service.DeepBinderProvider, android.content.ContentProvider
    public Bundle call(String method, String str, Bundle bundle) {
        g.f(method, "method");
        if (method.equals("checkCTA")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", CTAPermissionManager.INSTANCE.hasCTAPermission());
            return bundle2;
        }
        if (!method.equals("getCtaDialogIntent")) {
            return super.call(method, str, bundle);
        }
        Context context = getContext();
        if (context == null) {
            return super.call(method, str, bundle);
        }
        int callingUid = Binder.getCallingUid();
        Intent intent = new Intent(context, (Class<?>) PolicyActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(CTADialogGate.EXTRA_FROM_GATE, true);
        intent.putExtra(CTADialogGate.EXTRA_CALLING_UID, callingUid);
        intent.putExtra("android.intent.extra.UID", callingUid);
        List<String> listPeekContinueAlgorithmIdsForIntent = CTADialogGate.INSTANCE.peekContinueAlgorithmIdsForIntent();
        if (!listPeekContinueAlgorithmIdsForIntent.isEmpty()) {
            intent.putStringArrayListExtra(CTADialogGate.EXTRA_CONTINUE_ALGORITHM_IDS, new ArrayList<>(listPeekContinueAlgorithmIdsForIntent));
        }
        Bundle bundle3 = new Bundle();
        bundle3.putParcelable("intent", intent);
        return bundle3;
    }

    @Override // com.stepos.deepbinder.service.DeepBinderProvider, android.content.ContentProvider
    public boolean onCreate() {
        Log.d(TAG, "onCreate *** DeepBinderProvider started ***");
        return super.onCreate();
    }
}
