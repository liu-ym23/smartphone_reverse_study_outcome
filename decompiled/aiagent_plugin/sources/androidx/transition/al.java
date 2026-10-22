package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ViewUtilsBase.java */
/* JADX INFO: loaded from: classes.dex */
class al {
    private static final String TAG = "ViewUtilsBase";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f2802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f2804e;

    al() {
    }

    public void a(View r3, float r4) {
        Float r2 = (Float) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.save_non_transition_alpha, DbHelper.COL_ID, "save_non_transition_alpha")), Float.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        r3.setAlpha(r2.floatValue() * r4);
        return;
    L5:
        r3.setAlpha(r4);
    }

    public float a(View r3) {
        Float r2 = (Float) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.save_non_transition_alpha, DbHelper.COL_ID, "save_non_transition_alpha")), Float.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        return r3.getAlpha() / r2.floatValue();
    L7:
        return r3.getAlpha();
    }

    public void b(View r3) {
        if (r3.getTag(ZeusTransformUtils.mapRes(R.id.save_non_transition_alpha, DbHelper.COL_ID, "save_non_transition_alpha")) != null) goto L6;
        r3.setTag(ZeusTransformUtils.mapRes(R.id.save_non_transition_alpha, DbHelper.COL_ID, "save_non_transition_alpha"), Float.valueOf(r3.getAlpha()));
        return;
    }

    public void c(View r3) {
        if (r3.getVisibility() != 0) goto L6;
        r3.setTag(ZeusTransformUtils.mapRes(R.id.save_non_transition_alpha, DbHelper.COL_ID, "save_non_transition_alpha"), null);
        return;
    }

    public void a(View r4, Matrix r5) {
        ViewParent r0 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        a(r1, r5);
        r5.preTranslate(-r1.getScrollX(), -r1.getScrollY());
    L5:
        r5.preTranslate(r4.getLeft(), r4.getTop());
        Matrix r3 = r4.getMatrix();
        if (r3.isIdentity() == true) goto L9;
        r5.preConcat(r3);
        return;
    }

    public void b(View r4, Matrix r5) {
        ViewParent r0 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        b(r1, r5);
        r5.postTranslate(r1.getScrollX(), r1.getScrollY());
    L5:
        r5.postTranslate(-r4.getLeft(), -r4.getTop());
        Matrix r3 = r4.getMatrix();
        if (r3.isIdentity() == true) goto L11;
        Matrix r6 = new Matrix();
        if (r3.invert(r6) == false) goto L12;
        r5.postConcat(r6);
        return;
    L12:
        return;
    }

    public void c(View r9, Matrix r10) {
        if (r10 != null) goto L5;
    L15:
        r9.setPivotX(r9.getWidth() / 2);
        r9.setPivotY(r9.getHeight() / 2);
        r9.setTranslationX(0.0f);
        r9.setTranslationY(0.0f);
        r9.setScaleX(1.0f);
        r9.setScaleY(1.0f);
        r9.setRotation(0.0f);
        return;
    L5:
        if (r10.isIdentity() == true) goto L15;
        float[] r3 = this.f2804e;
        if (r3 != null) goto L10;
        r3 = new float[9];
        this.f2804e = r3;
    L10:
        r10.getValues(r3);
        float r8 = r3[3];
        float r11 = (float) Math.sqrt(1.0f - (r8 * r8));
        if (r3[0] >= 0.0f) goto L13;
        int r4 = -1;
    L14:
        float r12 = r11 * r4;
        float r13 = (float) Math.toDegrees(Math.atan2(r8, r12));
        float r0 = r3[0] / r12;
        float r5 = r3[4] / r12;
        float r14 = r3[2];
        float r1 = r3[5];
        r9.setPivotX(0.0f);
        r9.setPivotY(0.0f);
        r9.setTranslationX(r14);
        r9.setTranslationY(r1);
        r9.setRotation(r13);
        r9.setScaleX(r0);
        r9.setScaleY(r5);
        return;
    L13:
        r4 = 1;
        goto L14
    }

    public void a(View r3, int r4, int r5, int r6, int r7) {
        a();
        Method r2 = f2800a;
        if (r2 != null) goto L12;
        return;
    L12:
        r2.invoke(r3, new Object[]{Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    public void a(View r3, int r4) {
        if (f2803d == false) goto L16;
    L9:
        Field r2 = f2802c;
        if (r2 == null) goto L18;
        int r5 = r2.getInt(r3);     // Catch: IllegalAccessException -> L13
        f2802c.setInt(r3, (r5 & (-13)) | r4);     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L18:
        return;
    L16:
        Field r0 = View.class.getDeclaredField("mViewFlags");     // Catch: NoSuchFieldException -> L7
        f2802c = r0;     // Catch: NoSuchFieldException -> L7
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        f2803d = true;
    L7:
        a(TAG, "fetchViewFlagsField: ");
        goto L8
    }

    private void a() {
        if (f2801b == false) goto L11;
        return;
    L11:
        Method r0 = View.class.getDeclaredMethod("setFrame", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L7
        f2800a = r0;     // Catch: NoSuchMethodException -> L7
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        f2801b = true;
        return;
    L7:
        e = move-exception;
        a(TAG, "Failed to retrieve setFrame method", e);
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
