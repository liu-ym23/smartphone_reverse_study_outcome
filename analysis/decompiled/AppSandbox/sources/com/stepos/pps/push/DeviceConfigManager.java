package com.stepos.pps.push;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.stepos.perf.utils.PerfReflectUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class DeviceConfigManager {
    private static String TAG = "DeviceConfigUtil";
    private Context mContext;
    Set<Object> mOnPropertiesChangedListeneObject = new HashSet();
    Handler mHandler = new Handler();
    MainExecutor mainExecutor = null;

    public interface OnPropertiesChangedListener {
        void onPropertiesChanged(Set<String> set, HashMap<String, String> map);
    }

    public DeviceConfigManager(Context context) {
        this.mContext = context;
    }

    private class MainExecutor implements Executor {
        private MainExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (DeviceConfigManager.this.mHandler != null) {
                DeviceConfigManager.this.mHandler.post(runnable);
            }
        }
    }

    public void registerPropertiesChangedListener(String str, final OnPropertiesChangedListener onPropertiesChangedListener) throws NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        try {
            Class<?> cls = Class.forName("android.provider.DeviceConfig$OnPropertiesChangedListener");
            Method reflectMethod = PerfReflectUtil.getReflectMethod("android.provider.DeviceConfig", "addOnPropertiesChangedListener", (Class<?>[]) new Class[]{String.class, Executor.class, cls});
            Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler(this) { // from class: com.stepos.pps.push.DeviceConfigManager.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
                    String str2;
                    String name = method.getName();
                    if ("hashCode".equals(name)) {
                        int iIdentityHashCode = System.identityHashCode(obj);
                        Integer.valueOf(iIdentityHashCode).getClass();
                        return Integer.valueOf(iIdentityHashCode);
                    }
                    if ("equals".equals(name)) {
                        return obj == objArr[0] ? Boolean.TRUE : Boolean.FALSE;
                    }
                    if ("toString".equals(name)) {
                        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
                    }
                    if ("onPropertiesChanged".equals(name)) {
                        Log.d(DeviceConfigManager.TAG, "onPropertiesChanged call ");
                        Method reflectMethod2 = com.stepos.pps.reflect.PerfReflectUtil.getReflectMethod("android.provider.DeviceConfig$Properties", "getKeyset", (Class<?>[]) new Class[0]);
                        Object obj2 = objArr[0];
                        Set<String> set = (Set) com.stepos.pps.reflect.PerfReflectUtil.invokeMethod(obj2, reflectMethod2, null);
                        HashMap<String, String> map = new HashMap<>();
                        for (String str3 : set) {
                            String str4 = (String) com.stepos.pps.reflect.PerfReflectUtil.invokeMethod(obj2, com.stepos.pps.reflect.PerfReflectUtil.getReflectMethod("android.provider.DeviceConfig$Properties", "getString", (Class<?>[]) new Class[]{String.class, String.class}), new Object[]{str3, ""});
                            if (str4 == null) {
                                str2 = "null";
                            } else {
                                str2 = str4.isEmpty() ? "empty" : str4;
                            }
                            map.put(str3, str4);
                            Log.d(DeviceConfigManager.TAG, "    key :[" + str3 + "] " + str2);
                        }
                        onPropertiesChangedListener.onPropertiesChanged(set, map);
                        return null;
                    }
                    return new Object();
                }
            });
            PerfReflectUtil.invokeStaticMethod(reflectMethod, new Object[]{str, this.mContext.getMainExecutor(), objNewProxyInstance});
            this.mOnPropertiesChangedListeneObject.add(objNewProxyInstance);
        } catch (ClassNotFoundException e) {
            Log.d(TAG, "registerPropertiesChangedListener exception ", e);
            e.printStackTrace();
        }
    }
}
