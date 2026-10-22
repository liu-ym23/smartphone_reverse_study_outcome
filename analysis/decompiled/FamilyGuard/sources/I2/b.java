package I2;

import G2.v;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.stepos.minor.ui.MinorMainActivity;
import f2.C0702g;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2955a = "stepos.intent.action.ENTER_".concat(b());

    /* renamed from: b, reason: collision with root package name */
    private static final String f2956b = "stepos.intent.action.CONFIRM_".concat(b());

    public static boolean a(Context context) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            Object objNewInstance = declaredConstructor.newInstance(context.getApplicationContext());
            Method declaredMethod = cls.getDeclaredMethod("hasStepOSPassword", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(objNewInstance, 5);
            if (objInvoke != null && (objInvoke instanceof Boolean)) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private static String b() {
        return "PASSWORD";
    }

    public static void c(Activity activity, int i5) {
        v vVarJ0;
        if (activity == null) {
            return;
        }
        if (activity instanceof MinorMainActivity) {
            vVarJ0 = ((MinorMainActivity) activity).j0();
            if (vVarJ0 != null && !vVarJ0.s(i5)) {
                return;
            }
        } else {
            vVarJ0 = null;
        }
        C0702g.b("PasswordUtils", "startConfirmPasswordActivity() called");
        Intent intent = new Intent(f2956b);
        intent.addFlags(65536);
        Bundle bundle = new Bundle();
        bundle.putInt("password_from", 9);
        intent.putExtras(bundle);
        try {
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivityForResult(intent, i5);
                return;
            }
            C0702g.p("PasswordUtils", "startConfirmPasswordActivity: target activity not found");
            if (vVarJ0 != null) {
                vVarJ0.c(i5);
            }
        } catch (Exception e6) {
            if (vVarJ0 != null) {
                vVarJ0.c(i5);
            }
            C0702g.r("PasswordUtils", e6);
        }
    }

    public static void d(Activity activity, int i5) {
        if (activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("password_from", 9);
        Intent intent = new Intent(f2955a);
        intent.putExtra("create_password_bundle", bundle);
        try {
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                C0702g.p("PasswordUtils", "startEnterPasswordActivityForResult: target activity not found");
            } else {
                activity.startActivityForResult(intent, i5);
            }
        } catch (Exception e6) {
            C0702g.r("PasswordUtils", e6);
        }
    }
}
