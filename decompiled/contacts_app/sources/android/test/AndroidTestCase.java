package android.test;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AndroidTestCase extends TestCase {
    protected Context mContext;
    private Context mTestContext;

    public AndroidTestCase() {
    }

    @Override // junit.framework.TestCase
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override // junit.framework.TestCase
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Suppress
    public void testAndroidTestCaseSetupProperly() {
        assertNotNull("Context is null. setContext should be called before tests are run", this.mContext);
    }

    public void setContext(Context r1) {
        this.mContext = r1;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setTestContext(Context r1) {
        this.mTestContext = r1;
    }

    public Context getTestContext() {
        return this.mTestContext;
    }

    public void assertActivityRequiresPermission(String r3, String r4, String r5) {
        Intent r1 = new Intent();
        r1.setClassName(r3, r4);
        r1.addFlags(268435456);
        getContext().startActivity(r1);     // Catch: SecurityException -> L5
        fail("expected security exception for " + r5);     // Catch: SecurityException -> L5
        return;
    L5:
        e = move-exception;
        assertNotNull("security exception's error message.", e.getMessage());
        assertTrue("error message should contain " + r5 + LibrarianImpl.Constants.DOT, e.getMessage().contains(r5));
    }

    public void assertReadingContentUriRequiresPermission(Uri r8, String r9) {
        getContext().getContentResolver().query(r8, null, null, null, null);     // Catch: SecurityException -> L5
        fail("expected SecurityException requiring " + r9);     // Catch: SecurityException -> L5
        return;
    L5:
        e = move-exception;
        assertNotNull("security exception's error message.", e.getMessage());
        assertTrue("error message should contain " + r9 + LibrarianImpl.Constants.DOT, e.getMessage().contains(r9));
    }

    public void assertWritingContentUriRequiresPermission(Uri r3, String r4) {
        getContext().getContentResolver().insert(r3, new ContentValues());     // Catch: SecurityException -> L5
        fail("expected SecurityException requiring " + r4);     // Catch: SecurityException -> L5
        return;
    L5:
        e = move-exception;
        assertNotNull("security exception's error message.", e.getMessage());
        assertTrue("error message should contain \"" + r4 + "\". Got: \"" + e.getMessage() + "\".", e.getMessage().contains(r4));
    }

    protected void scrubClass(Class<?> r7) throws IllegalAccessException {
        Field[] r1 = getClass().getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L16;
        Field r4 = r1[r3];
        if (r4.getType().isPrimitive() == true) goto L15;
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L15;
        r4.setAccessible(true);     // Catch: Exception -> L11
        r4.set(this, null);     // Catch: Exception -> L11
    L13:
        if (r4.get(this) == null) goto L15;
        Log.d("TestCase", "Error: Could not nullify field!");
    L11:
        Log.d("TestCase", "Error: Could not nullify field!");
    L15:
        r3 = r3 + 1;
        goto L3
    }
}
