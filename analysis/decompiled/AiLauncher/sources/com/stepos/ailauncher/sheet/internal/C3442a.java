package com.stepos.ailauncher.sheet.internal;

import android.app.Activity;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/a;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", x5.d.EXTRA_ENABLED, Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;Z)Z", "", "TAG", "Ljava/lang/String;", "Ljava/lang/reflect/Method;", "method", "Ljava/lang/reflect/Method;", "methodResolved", "Z", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.internal.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3442a {
    public static final C3442a INSTANCE = new C3442a();
    private static final String TAG = "ActivityInputSink";
    private static volatile Method method;
    private static volatile boolean methodResolved;

    public final boolean a(Activity activity, boolean enabled) {
        Object objB;
        kotlin.jvm.internal.p.i(activity, "activity");
        if (!methodResolved) {
            methodResolved = true;
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Activity.class.getMethod("setActivityRecordInputSinkEnabled", Boolean.TYPE));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            method = (Method) objB;
            if (method == null) {
                Log.w(TAG, "setActivityRecordInputSinkEnabled not found on this platform");
            }
        }
        Method method2 = method;
        if (method2 == null) {
            return false;
        }
        try {
            method2.invoke(activity, Boolean.valueOf(enabled));
            Log.i(TAG, "setActivityRecordInputSinkEnabled(" + enabled + ") ok");
            return true;
        } catch (Throwable th2) {
            Log.w(TAG, "setActivityRecordInputSinkEnabled(" + enabled + ") failed: " + th2.getMessage());
            return false;
        }
    }
}
