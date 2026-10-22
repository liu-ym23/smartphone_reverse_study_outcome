package com.stepos.policy.sdk.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.ArrayMap;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class ReadClipboardUtils {
    public static int READ_CLIPBOARD_PERMISSION_AGREE = 1;
    public static int READ_CLIPBOARD_PERMISSION_DISAGREE;
    private static int sReadClipBoardPermissionValue;

    public static void injectClipboardManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (READ_CLIPBOARD_PERMISSION_AGREE == PolicyManager.INSTANCE.getReadClipboardStatus(applicationContext)) {
            return;
        }
        final ClipboardManager clipboardManager = (ClipboardManager) applicationContext.getSystemService("clipboard");
        try {
            PolicySdkLogUtils.INSTANCE.d("injectClipboardManager", " start injectClipboardManager");
            Field declaredField = Class.forName("android.app.SystemServiceRegistry").getDeclaredField("SYSTEM_SERVICE_FETCHERS");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(null);
            final Object obj = arrayMap.get("clipboard");
            arrayMap.put("clipboard", Proxy.newProxyInstance(applicationContext.getClassLoader(), new Class[]{Class.forName("android.app.SystemServiceRegistry$ServiceFetcher")}, new InvocationHandler() { // from class: com.stepos.policy.sdk.util.e
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj2, Method method, Object[] objArr) {
                    return ReadClipboardUtils.lambda$injectClipboardManager$0(clipboardManager, obj, obj2, method, objArr);
                }
            }));
        } catch (Exception e4) {
            e4.printStackTrace();
            PolicySdkLogUtils.INSTANCE.d("injectClipboardManager", "e =" + e4);
        }
        try {
            Field declaredField2 = ClipboardManager.class.getDeclaredField("mService");
            PolicySdkLogUtils.INSTANCE.d("injectClipboardManager", " start mServiceField");
            declaredField2.setAccessible(true);
            final Object obj2 = declaredField2.get(clipboardManager);
            Object objNewProxyInstance = Proxy.newProxyInstance(applicationContext.getClassLoader(), new Class[]{Class.forName("android.content.IClipboard")}, new InvocationHandler() { // from class: com.stepos.policy.sdk.util.f
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj3, Method method, Object[] objArr) {
                    return ReadClipboardUtils.lambda$injectClipboardManager$1(obj2, obj3, method, objArr);
                }
            });
            Field declaredField3 = ClipboardManager.class.getDeclaredField("mService");
            declaredField3.setAccessible(true);
            declaredField3.set(clipboardManager, objNewProxyInstance);
        } catch (Exception e5) {
            e5.printStackTrace();
            PolicySdkLogUtils.INSTANCE.d("injectClipboardManager", "e1 =" + e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$injectClipboardManager$0(ClipboardManager clipboardManager, Object obj, Object obj2, Method method, Object[] objArr) throws Throwable {
        return method.getName().equals("getService") ? clipboardManager : method.invoke(obj, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$injectClipboardManager$1(Object obj, Object obj2, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        if (name.equals("getCanPaste")) {
            PolicySdkLogUtils.INSTANCE.d("injectClipboardManager", "getCanPaste");
            return sReadClipBoardPermissionValue == READ_CLIPBOARD_PERMISSION_AGREE ? method.invoke(obj, objArr) : Boolean.FALSE;
        }
        if (!name.equals("getPrimaryClip") && !name.equals("getPrimaryClipMz") && !name.equals("getPrimaryClipDescription") && !name.equals("getPrimaryClipDescriptionMz") && !name.equals("getPrimaryClipSource") && !name.equals("getPrimaryClipSourceMz")) {
            return method.invoke(obj, objArr);
        }
        PolicySdkLogUtils.INSTANCE.d("injectClipboardManager", "getPrimaryClip");
        if (sReadClipBoardPermissionValue == READ_CLIPBOARD_PERMISSION_AGREE) {
            return method.invoke(obj, objArr);
        }
        return null;
    }

    public static void setAgreeReadClipBoard(int i4) {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("setAgreeReadClipBoard", "value: " + i4);
        if (i4 < READ_CLIPBOARD_PERMISSION_DISAGREE || i4 > READ_CLIPBOARD_PERMISSION_AGREE) {
            return;
        }
        sReadClipBoardPermissionValue = i4;
        companion.d("setAgreeReadClipBoard", "sReadClipBoardPermissionValue: " + sReadClipBoardPermissionValue);
    }

    public static void testAgreeReadClipBoard(Context context) {
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            PolicySdkLogUtils.INSTANCE.d("testAgreeReadClipBoard", "primaryClip is null .");
            return;
        }
        String string = primaryClip.getItemAt(0).getText().toString();
        PolicySdkLogUtils.INSTANCE.d("testAgreeReadClipBoard", "textString: " + string);
    }
}
