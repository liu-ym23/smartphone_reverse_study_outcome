package junit.framework;

import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes4.dex */
public class Assert {
    protected Assert() {
    }

    public static void assertTrue(String r0, boolean r1) {
        if (r1 == true) goto L5;
        fail(r0);
        return;
    }

    public static void assertTrue(boolean r1) {
        assertTrue(null, r1);
    }

    public static void assertFalse(String r0, boolean r1) {
        assertTrue(r0, !r1);
    }

    public static void assertFalse(boolean r1) {
        assertFalse(null, r1);
    }

    public static void fail(String r1) {
        if (r1 != null) goto L6;
        throw new AssertionFailedError();
    L6:
        throw new AssertionFailedError(r1);
    }

    public static void fail() {
        fail(null);
    }

    public static void assertEquals(String r1, Object r2, Object r3) {
        if (r2 != null) goto L5;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L9:
        failNotEquals(r1, r2, r3);
        return;
    L7:
        if (r2.equals(r3) == false) goto L9;
    }

    public static void assertEquals(Object r1, Object r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertEquals(String r1, String r2, String r3) {
        if (r2 != null) goto L5;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L9:
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        throw new ComparisonFailure(r1, r2, r3);
    L7:
        if (r2.equals(r3) == false) goto L9;
    }

    public static void assertEquals(String r1, String r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertEquals(String r2, double r3, double r5, double r7) {
        if (Double.compare(r3, r5) != 0) goto L6;
        return;
    L6:
        if (Math.abs(r3 - r5) <= r7) goto L9;
        failNotEquals(r2, new Double(r3), new Double(r5));
        return;
    }

    public static void assertEquals(double r7, double r9, double r11) {
        assertEquals(null, r7, r9, r11);
    }

    public static void assertEquals(String r1, float r2, float r3, float r4) {
        if (Float.compare(r2, r3) != 0) goto L6;
        return;
    L6:
        if (Math.abs(r2 - r3) <= r4) goto L9;
        failNotEquals(r1, new Float(r2), new Float(r3));
        return;
    }

    public static void assertEquals(float r1, float r2, float r3) {
        assertEquals(null, r1, r2, r3);
    }

    public static void assertEquals(String r1, long r2, long r4) {
        assertEquals(r1, new Long(r2), new Long(r4));
    }

    public static void assertEquals(long r1, long r3) {
        assertEquals(null, r1, r3);
    }

    public static void assertEquals(String r0, boolean r1, boolean r2) {
        assertEquals(r0, Boolean.valueOf(r1), Boolean.valueOf(r2));
    }

    public static void assertEquals(boolean r1, boolean r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertEquals(String r1, byte r2, byte r3) {
        assertEquals(r1, new Byte(r2), new Byte(r3));
    }

    public static void assertEquals(byte r1, byte r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertEquals(String r1, char r2, char r3) {
        assertEquals(r1, new Character(r2), new Character(r3));
    }

    public static void assertEquals(char r1, char r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertEquals(String r1, short r2, short r3) {
        assertEquals(r1, new Short(r2), new Short(r3));
    }

    public static void assertEquals(short r1, short r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertEquals(String r1, int r2, int r3) {
        assertEquals(r1, new Integer(r2), new Integer(r3));
    }

    public static void assertEquals(int r1, int r2) {
        assertEquals(null, r1, r2);
    }

    public static void assertNotNull(Object r1) {
        assertNotNull(null, r1);
    }

    public static void assertNotNull(String r0, Object r1) {
        if (r1 == null) goto L4;
        boolean r2 = true;
    L5:
        assertTrue(r0, r2);
        return;
    L4:
        r2 = false;
        goto L5
    }

    public static void assertNull(Object r2) {
        assertNull("Expected: <null> but was: " + String.valueOf(r2), r2);
    }

    public static void assertNull(String r0, Object r1) {
        if (r1 != null) goto L4;
        boolean r2 = true;
    L5:
        assertTrue(r0, r2);
        return;
    L4:
        r2 = false;
        goto L5
    }

    public static void assertSame(String r0, Object r1, Object r2) {
        if (r1 != r2) goto L4;
        return;
    L4:
        failNotSame(r0, r1, r2);
    }

    public static void assertSame(Object r1, Object r2) {
        assertSame(null, r1, r2);
    }

    public static void assertNotSame(String r0, Object r1, Object r2) {
        if (r1 != r2) goto L5;
        failSame(r0);
        return;
    }

    public static void assertNotSame(Object r1, Object r2) {
        assertNotSame(null, r1, r2);
    }

    public static void failSame(String r1) {
        if (r1 == null) goto L4;
        String r2 = r1 + HanziToPinyin.Token.SEPARATOR;
    L5:
        fail(r2 + "expected not same");
        return;
    L4:
        r2 = "";
        goto L5
    }

    public static void failNotSame(String r1, Object r2, Object r3) {
        if (r1 == null) goto L4;
        String r4 = r1 + HanziToPinyin.Token.SEPARATOR;
    L5:
        fail(r4 + "expected same:<" + r2 + "> was not:<" + r3 + ">");
        return;
    L4:
        r4 = "";
        goto L5
    }

    public static void failNotEquals(String r0, Object r1, Object r2) {
        fail(format(r0, r1, r2));
    }

    public static String format(String r1, Object r2, Object r3) {
        if (r1 != null) goto L4;
    L6:
        String r4 = "";
    L8:
        return r4 + "expected:<" + r2 + "> but was:<" + r3 + ">";
    L4:
        if (r1.length() <= 0) goto L6;
        r4 = r1 + HanziToPinyin.Token.SEPARATOR;
        goto L8
    }
}
