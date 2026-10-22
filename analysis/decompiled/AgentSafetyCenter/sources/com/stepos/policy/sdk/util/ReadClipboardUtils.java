package com.stepos.policy.sdk.util;

import aa.k;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.ArrayMap;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ReadClipboardUtils {
    public static int READ_CLIPBOARD_PERMISSION_AGREE = 1;
    public static int READ_CLIPBOARD_PERMISSION_DISAGREE;
    private static int sReadClipBoardPermissionValue;

    public static void injectClipboardManager(Context context) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        Context applicationContext = context.getApplicationContext();
        if (READ_CLIPBOARD_PERMISSION_AGREE == PolicyManager.INSTANCE.getReadClipboardStatus(applicationContext)) {
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) applicationContext.getSystemService("clipboard");
        int i = 1;
        try {
            PolicySdkLogUtils.Companion.d("injectClipboardManager", " start injectClipboardManager");
            Field declaredField = Class.forName("android.app.SystemServiceRegistry").getDeclaredField("SYSTEM_SERVICE_FETCHERS");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(null);
            Object obj = arrayMap.get("clipboard");
            Class<?> cls = Class.forName("android.app.SystemServiceRegistry$ServiceFetcher");
            d dVar = new d();
            dVar.f2801a = clipboardManager;
            dVar.f2802b = obj;
            VarHandle.storeStoreFence();
            arrayMap.put("clipboard", Proxy.newProxyInstance(applicationContext.getClassLoader(), new Class[]{cls}, dVar));
        } catch (Exception e10) {
            e10.printStackTrace();
            PolicySdkLogUtils.Companion.d("injectClipboardManager", "e =" + e10);
        }
        try {
            Field declaredField2 = ClipboardManager.class.getDeclaredField("mService");
            PolicySdkLogUtils.Companion.d("injectClipboardManager", " start mServiceField");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(clipboardManager);
            Class<?> cls2 = Class.forName("android.content.IClipboard");
            k kVar = new k(i);
            kVar.f330b = obj2;
            VarHandle.storeStoreFence();
            Object objNewProxyInstance = Proxy.newProxyInstance(applicationContext.getClassLoader(), new Class[]{cls2}, kVar);
            Field declaredField3 = ClipboardManager.class.getDeclaredField("mService");
            declaredField3.setAccessible(true);
            declaredField3.set(clipboardManager, objNewProxyInstance);
        } catch (Exception e11) {
            e11.printStackTrace();
            PolicySdkLogUtils.Companion.d("injectClipboardManager", "e1 =" + e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$injectClipboardManager$0(ClipboardManager clipboardManager, Object obj, Object obj2, Method method, Object[] objArr) {
        return method.getName().equals("getService") ? clipboardManager : method.invoke(obj, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$injectClipboardManager$1(Object obj, Object obj2, Method method, Object[] objArr) {
        String name = method.getName();
        if (name.equals("getCanPaste")) {
            PolicySdkLogUtils.Companion.d("injectClipboardManager", "getCanPaste");
            return sReadClipBoardPermissionValue == READ_CLIPBOARD_PERMISSION_AGREE ? method.invoke(obj, objArr) : Boolean.FALSE;
        }
        if (!name.equals("getPrimaryClip") && !name.equals("getPrimaryClipMz") && !name.equals("getPrimaryClipDescription") && !name.equals("getPrimaryClipDescriptionMz") && !name.equals("getPrimaryClipSource") && !name.equals("getPrimaryClipSourceMz")) {
            return method.invoke(obj, objArr);
        }
        PolicySdkLogUtils.Companion.d("injectClipboardManager", "getPrimaryClip");
        if (sReadClipBoardPermissionValue == READ_CLIPBOARD_PERMISSION_AGREE) {
            return method.invoke(obj, objArr);
        }
        return null;
    }

    public static void setAgreeReadClipBoard(int i) {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
        companion.d("setAgreeReadClipBoard", "value: " + i);
        if (i < READ_CLIPBOARD_PERMISSION_DISAGREE || i > READ_CLIPBOARD_PERMISSION_AGREE) {
            return;
        }
        sReadClipBoardPermissionValue = i;
        companion.d("setAgreeReadClipBoard", "sReadClipBoardPermissionValue: " + sReadClipBoardPermissionValue);
    }

    public static void testAgreeReadClipBoard(Context context) {
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            PolicySdkLogUtils.Companion.d("testAgreeReadClipBoard", "primaryClip is null .");
            return;
        }
        String string = primaryClip.getItemAt(0).getText().toString();
        PolicySdkLogUtils.Companion.d("testAgreeReadClipBoard", "textString: " + string);
    }
}
