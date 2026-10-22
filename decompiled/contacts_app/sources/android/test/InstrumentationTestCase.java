package android.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.android.contacts.util.HanziToPinyin;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class InstrumentationTestCase extends TestCase {
    private Instrumentation mInstrumentation;

    public InstrumentationTestCase() {
    }

    static /* synthetic */ void access$000(InstrumentationTestCase r0, Method r1, int r2, boolean r3) throws Throwable {
        r0.runMethod(r1, r2, r3);
    }

    public void injectInstrumentation(Instrumentation r1) {
        this.mInstrumentation = r1;
    }

    @Deprecated
    public void injectInsrumentation(Instrumentation r1) {
        injectInstrumentation(r1);
    }

    public Instrumentation getInstrumentation() {
        return this.mInstrumentation;
    }

    public final <T extends Activity> T launchActivity(String r3, Class<T> r4, Bundle r5) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        if (r5 == null) goto L6;
        r0.putExtras(r5);
    L6:
        return (T) launchActivityWithIntent(r3, r4, r0);
    }

    public final <T extends Activity> T launchActivityWithIntent(String r1, Class<T> r2, Intent r3) {
        r3.setClassName(r1, r2.getName());
        r3.addFlags(268435456);
        T r4 = (T) getInstrumentation().startActivitySync(r3);
        getInstrumentation().waitForIdleSync();
        return r4;
    }

    public void runTestOnUiThread(final Runnable r4) throws Throwable {
        final Throwable[] r0 = new Throwable[1];
        getInstrumentation().runOnMainSync(new AnonymousClass1(this, r4, r0));
        Throwable r3 = r0[0];
        if (r3 != null) goto L5;
        return;
    L5:
        throw r3;
    }

    @Override // junit.framework.TestCase
    protected void runTest() throws Throwable {
        String r1 = getName();
        assertNotNull(r1);
        Method r2 = null;
        Class[] r4 = (Class[]) null;     // Catch: NoSuchMethodException -> L5
        r2 = getClass().getMethod(r1, null);     // Catch: NoSuchMethodException -> L5
    L6:
        final Method r6 = r2;
        if (Modifier.isPublic(r6.getModifiers()) == true) goto L10;
        fail("Method \"" + r1 + "\" should be public");
    L10:
        if (r6.isAnnotationPresent(FlakyTest.class) == false) goto L13;
        final int r7 = ((FlakyTest) r6.getAnnotation(FlakyTest.class)).tolerance();
        final boolean r8 = false;
    L17:
        if (r6.isAnnotationPresent(UiThreadTest.class) == false) goto L22;
        final Throwable[] r0 = new Throwable[1];
        getInstrumentation().runOnMainSync(new AnonymousClass2(this, r6, r7, r8, r0));
        Throwable r10 = r0[0];
        if (r10 == null) goto L26;
        throw r10;
    L26:
        return;
    L22:
        runMethod(r6, r7, r8);
        return;
    L13:
        if (r6.isAnnotationPresent(RepetitiveTest.class) == false) goto L15;
        r7 = ((RepetitiveTest) r6.getAnnotation(RepetitiveTest.class)).numIterations();
        r8 = true;
        goto L17
    L15:
        r8 = false;
        r7 = 1;
    L5:
        fail("Method \"" + r1 + "\" not found");
        goto L6
    }

    private void runMethod(Method r2, int r3) throws Throwable {
        runMethod(r2, r3, false);
    }

    private void runMethod(Method r7, int r8, boolean r9) throws Throwable {
        int r1 = 0;
    L3:
        Throwable r2 = null;
        Throwable r3 = null;
        Object[] r4 = (Object[]) null;     // Catch: Throwable -> L9 IllegalAccessException -> L11 InvocationTargetException -> L16
        r7.invoke(this, null);     // Catch: Throwable -> L9 IllegalAccessException -> L11 InvocationTargetException -> L16
        r1 = r1 + 1;
        if (r9 == false) goto L21;
        Bundle r5 = new Bundle();
    L8:
        r5.putInt("currentiterations", r1);
        getInstrumentation().sendStatus(2, r5);
        r2 = r3;
    L21:
        if (r1 >= r8) goto L24;
        if (r9 == true) goto L3;
        if (r2 != null) goto L3;
    L24:
        if (r2 != null) goto L26;
        return;
    L26:
        throw r2;
    L9:
        th = move-exception;
        int r6 = r1 + 1;
        if (r9 == false) goto L30;
        Bundle r10 = new Bundle();
        r10.putInt("currentiterations", r6);
        getInstrumentation().sendStatus(2, r10);
    L30:
        throw th;
    L11:
        e = move-exception;
        e.fillInStackTrace();     // Catch: Throwable -> L9
        r1 = r1 + 1;
        r2 = e;
        if (r9 == false) goto L21;
        r5 = new Bundle();
        r3 = e;
    L16:
        e = move-exception;
        e.fillInStackTrace();     // Catch: Throwable -> L9
        Throwable r11 = e.getTargetException();     // Catch: Throwable -> L9
        r1 = r1 + 1;
        r2 = r11;
        if (r9 == false) goto L21;
        r5 = new Bundle();
        r3 = r11;
        goto L8
    }

    public void sendKeys(String r12) {
        String[] r13 = r12.split(HanziToPinyin.Token.SEPARATOR);
        int r1 = r13.length;
        Instrumentation r11 = getInstrumentation();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L19;
        String r4 = r13[r3];
        int r5 = r4.indexOf(42);
        if (r5 != (-1)) goto L24;
        int r8 = 1;
    L8:
        if (r5 == (-1)) goto L10;
        r4 = r4.substring(r5 + 1);
    L10:
        int r6 = 0;
    L11:
        if (r6 >= r8) goto L18;
    L15:
        Log.w("ActivityTestCase", "Unknown keycode: KEYCODE_" + r4);
    L16:
        Log.w("ActivityTestCase", "Unknown keycode: KEYCODE_" + r4);
        goto L18
    L22:
        r11.sendKeyDownUpSync(KeyEvent.class.getField("KEYCODE_" + r4).getInt(null));     // Catch: SecurityException -> L21 IllegalAccessException -> L15 NoSuchFieldException -> L16
    L14:
        r6 = r6 + 1;
    L18:
        r3 = r3 + 1;
        goto L3
    L24:
        r8 = Integer.parseInt(r4.substring(0, r5));     // Catch: NumberFormatException -> L17
    L17:
        Log.w("ActivityTestCase", "Invalid repeat count: " + r4);
        goto L18
    L19:
        r11.waitForIdleSync();
    }

    public void sendKeys(int... r4) {
        int r0 = r4.length;
        Instrumentation r3 = getInstrumentation();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r3.sendKeyDownUpSync(r4[r1]);     // Catch: SecurityException -> L8
    L5:
        r1 = r1 + 1;
        goto L3
    L6:
        r3.waitForIdleSync();
    }

    public void sendRepeatedKeys(int... r7) {
        int r0 = r7.length;
        if ((r0 & 1) == 1) goto L14;
        Instrumentation r6 = getInstrumentation();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        int r3 = r7[r2];
        int r4 = r7[r2 + 1];
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L10;
        r6.sendKeyDownUpSync(r4);     // Catch: SecurityException -> L15
    L9:
        r5 = r5 + 1;
        goto L7
    L10:
        r2 = r2 + 2;
        goto L5
    L11:
        r6.waitForIdleSync();
        return;
    L14:
        throw new IllegalArgumentException("The size of the keys array must be a multiple of 2");
    }

    @Override // junit.framework.TestCase
    protected void tearDown() throws Exception {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        super.tearDown();
    }
}
