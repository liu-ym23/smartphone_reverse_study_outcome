package com.bytedance.bdtracker;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsSeekBar;
import android.widget.AdapterView;
import com.bytedance.applog.R;
import com.bytedance.applog.log.LoggerImpl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class u5 {
    public static final SparseArray<String> a = new SparseArray<>(4);
    public static final Set<Integer> b = new HashSet(4);
    public static final LruCache<Class, String> c = new LruCache<>(100);

    public static int a(View view) {
        Display display;
        if (view == null || (display = view.getDisplay()) == null) {
            return 0;
        }
        return display.getDisplayId();
    }

    public static String a(View view, boolean z) {
        int id;
        Object tag = view.getTag(84159242);
        if (tag != null && (tag instanceof String)) {
            return (String) tag;
        }
        if (!z && (id = view.getId()) > 2130706432 && !b.contains(Integer.valueOf(id))) {
            SparseArray<String> sparseArray = a;
            String str = sparseArray.get(id);
            if (str != null) {
                return str;
            }
            try {
                String resourceEntryName = view.getResources().getResourceEntryName(id);
                sparseArray.put(id, resourceEntryName);
                return resourceEntryName;
            } catch (Exception unused) {
                b.add(Integer.valueOf(id));
            }
        }
        return null;
    }

    public static String a(Class cls) {
        LruCache<Class, String> lruCache = c;
        String simpleName = lruCache.get(cls);
        if (TextUtils.isEmpty(simpleName)) {
            simpleName = cls.getSimpleName();
            if (TextUtils.isEmpty(simpleName)) {
                simpleName = "Anonymous";
            }
            lruCache.put(cls, simpleName);
            if (!b5.h && !b5.e && !b5.a && simpleName.contains("RecyclerView")) {
                try {
                    if (b5.a((Class<?>) cls) != null && b5.c != null) {
                        b5.b = cls;
                        b5.a = true;
                    }
                } catch (Exception e) {
                    LoggerImpl.global().error("checkCustomRecyclerView failed", e, new Object[0]);
                }
            }
        }
        return simpleName;
    }

    public static String a(String str) {
        return str == null ? "" : (TextUtils.isEmpty(str) || str.length() <= 20) ? str : str.substring(0, 20);
    }

    public static boolean a(Context context, int i) {
        try {
            return ((DisplayManager) context.getSystemService("display")).getDisplays()[0].getDisplayId() == i;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean b(View view) {
        return view == null || view.getTag(R.id.applog_tag_ignore) != null;
    }

    public static boolean c(View view) {
        boolean z = view.isClickable() || (view instanceof AbsSeekBar);
        if (!(view.getParent() instanceof AdapterView)) {
            return z;
        }
        AdapterView adapterView = (AdapterView) view.getParent();
        return z | ((!adapterView.isClickable() && adapterView.getOnItemClickListener() == null && adapterView.getOnItemSelectedListener() == null) ? false : true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:
    
        if (r0.getText() != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0107, code lost:
    
        if (r0.getText() != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0109, code lost:
    
        r0 = r0.getText();
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.String> a(android.view.View r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.u5.a(android.view.View, java.lang.String):java.util.ArrayList");
    }

    public static boolean a(WebView webView) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        try {
            Field declaredField = WebView.class.getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            obj = declaredField.get(webView);
        } catch (Exception e) {
            LoggerImpl.global().error(Collections.singletonList("ViewUtils"), "Check isDestroyed failed", e, new Object[0]);
        }
        if ("android.webkit.WebViewClassic".equals(obj)) {
            Field declaredField2 = obj.getClass().getDeclaredField("mWebViewCore");
            declaredField2.setAccessible(true);
            return declaredField2.get(obj) == null;
        }
        Field declaredField3 = obj.getClass().getDeclaredField("mAwContents");
        declaredField3.setAccessible(true);
        Object obj2 = declaredField3.get(obj);
        Method declaredMethod = obj2.getClass().getDeclaredMethod("isDestroyed", Integer.TYPE);
        declaredMethod.setAccessible(true);
        Object objInvoke = declaredMethod.invoke(obj2, 0);
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }
}
