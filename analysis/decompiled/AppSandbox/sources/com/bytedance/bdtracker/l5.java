package com.bytedance.bdtracker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.IPageMeta;
import com.bytedance.applog.annotation.PageMeta;
import com.bytedance.applog.log.LoggerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l5 {
    public static final List<String> a;
    public static final List<String> b;
    public static final List<Class<?>> c;
    public static final List<Class<?>> d;
    public static final List<String> e;

    static {
        List<String> listSingletonList = Collections.singletonList("android.app.Activity");
        a = listSingletonList;
        b = Arrays.asList("android.app.Fragment", "androidx.fragment.app.Fragment", "android.support.v4.app.Fragment");
        c = new ArrayList();
        d = new ArrayList();
        e = Collections.singletonList("PageUtils");
        Iterator<String> it = listSingletonList.iterator();
        while (it.hasNext()) {
            Class<?> clsB = r.b(it.next());
            if (clsB != null) {
                c.add(clsB);
            }
        }
        Iterator<String> it2 = b.iterator();
        while (it2.hasNext()) {
            Class<?> clsB2 = r.b(it2.next());
            if (clsB2 != null) {
                d.add(clsB2);
            }
        }
    }

    public static View a(Object obj) {
        try {
            Class[] clsArr = new Class[0];
            Method method = obj.getClass().getMethod("getView", null);
            if (method != null) {
                Object objInvoke = method.invoke(obj, null);
                if (objInvoke instanceof View) {
                    return (View) objInvoke;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Object b(Object obj) {
        try {
            Class[] clsArr = new Class[0];
            return obj.getClass().getMethod("getParentFragment", null).invoke(obj, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(Object obj) {
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).path();
            } catch (Throwable th) {
                LoggerImpl.global().error(e, "Cannot get path from IPageMeta", th, new Object[0]);
            }
        }
        return (b.b(b.e) || !obj.getClass().isAnnotationPresent(PageMeta.class) || (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) == null || TextUtils.isEmpty(pageMeta.path())) ? obj.getClass().getCanonicalName() : pageMeta.path();
    }

    public static String d(Object obj) {
        PageMeta pageMeta;
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPageMeta) {
            try {
                return ((IPageMeta) obj).title();
            } catch (Throwable th) {
                LoggerImpl.global().error(e, "Cannot get title from IPageMeta", th, new Object[0]);
            }
        }
        if (!b.b(b.e) && obj.getClass().isAnnotationPresent(PageMeta.class) && (pageMeta = (PageMeta) obj.getClass().getAnnotation(PageMeta.class)) != null && !TextUtils.isEmpty(pageMeta.title())) {
            return pageMeta.title();
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (!TextUtils.isEmpty(activity.getTitle())) {
                return activity.getTitle().toString();
            }
            ActionBar actionBar = activity.getActionBar();
            String string = null;
            if (actionBar == null) {
                try {
                    Class<?> clsA = r.a("android.support.v7.app.AppCompatActivity", "androidx.appcompat.app.AppCompatActivity");
                    if (clsA != null && clsA.isInstance(activity)) {
                        Class[] clsArr = new Class[0];
                        Object objInvoke = activity.getClass().getMethod("getSupportActionBar", null).invoke(activity, null);
                        if (objInvoke != null) {
                            Class[] clsArr2 = new Class[0];
                            CharSequence charSequence = (CharSequence) objInvoke.getClass().getMethod("getTitle", null).invoke(objInvoke, null);
                            if (charSequence != null) {
                                string = charSequence.toString();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            } else if (!TextUtils.isEmpty(actionBar.getTitle())) {
                string = actionBar.getTitle().toString();
            }
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            try {
                PackageManager packageManager = ((Activity) obj).getPackageManager();
                if (packageManager != null) {
                    CharSequence charSequenceLoadLabel = packageManager.getActivityInfo(((Activity) obj).getComponentName(), 0).loadLabel(packageManager);
                    if (!TextUtils.isEmpty(charSequenceLoadLabel)) {
                        return charSequenceLoadLabel.toString();
                    }
                }
            } catch (Exception e2) {
                LoggerImpl.global().error(e, "Cannot get title from activity label", e2, new Object[0]);
            }
        }
        return obj.getClass().getName();
    }

    public static JSONObject e(Object obj) {
        if (!(obj instanceof IPageMeta)) {
            return null;
        }
        try {
            return ((IPageMeta) obj).pageProperties();
        } catch (Throwable th) {
            LoggerImpl.global().error(e, "Cannot get track properties from activity", th, new Object[0]);
            return null;
        }
    }

    public static boolean f(Object obj) {
        Iterator<Class<?>> it = d.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(obj)) {
                return true;
            }
        }
        return false;
    }
}
