package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class PreferenceInflater {
    private static final HashMap<String, Constructor<?>> CONSTRUCTOR_MAP = null;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = null;
    private static final String EXTRA_TAG_NAME = "extra";
    private static final String INTENT_TAG_NAME = "intent";
    private final Object[] mConstructorArgs;
    private final Context mContext;
    private String[] mDefaultPackages;
    private PreferenceManager mPreferenceManager;

    static {
        CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
        CONSTRUCTOR_MAP = new HashMap();
    }

    public PreferenceInflater(Context r2, PreferenceManager r3) {
        this.mConstructorArgs = new Object[2];
        this.mContext = r2;
        init(r3);
    }

    private void init(PreferenceManager r4) {
        this.mPreferenceManager = r4;
        setDefaultPackages(new String[]{Preference.class.getPackage().getName() + LibrarianImpl.Constants.DOT, SwitchPreference.class.getPackage().getName() + LibrarianImpl.Constants.DOT});
    }

    public void setDefaultPackages(String[] r1) {
        this.mDefaultPackages = r1;
    }

    public String[] getDefaultPackages() {
        return this.mDefaultPackages;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Preference inflate(int r2, PreferenceGroup r3) {
        XmlResourceParser r4 = getContext().getResources().getXml(r2);
        Preference r1 = inflate(r4, r3);     // Catch: Throwable -> L6
        r4.close();
        return r1;
    L6:
        th = move-exception;
        r4.close();
        throw th;
    }

    public Preference inflate(XmlPullParser r6, PreferenceGroup r7) {
        Object[] r0 = this.mConstructorArgs;
        monitor-enter(r0);
        AttributeSet r1 = Xml.asAttributeSet(r6);     // Catch: Throwable -> L23
        this.mConstructorArgs[0] = this.mContext;     // Catch: Throwable -> L23
    L27:
        int r2 = r6.next();     // Catch: IOException -> L15 XmlPullParserException -> L18 InflateException -> L21 Throwable -> L23
        if (r2 == 2) goto L9;
        if (r2 != 1) goto L27;
    L9:
        if (r2 != 2) goto L14;
        PreferenceGroup r8 = onMergeRoots(r7, (PreferenceGroup) createItemFromTag(r6.getName(), r1));     // Catch: IOException -> L15 XmlPullParserException -> L18 InflateException -> L21 Throwable -> L23
        rInflate(r6, r8, r1);     // Catch: IOException -> L15 XmlPullParserException -> L18 InflateException -> L21 Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r8;
    L14:
        throw new InflateException(r6.getPositionDescription() + ": No start tag found!");     // Catch: IOException -> L15 XmlPullParserException -> L18 InflateException -> L21 Throwable -> L23
    L18:
        e = move-exception;
        InflateException r9 = new InflateException(e.getMessage());     // Catch: Throwable -> L23
        r9.initCause(e);     // Catch: Throwable -> L23
        throw r9;     // Catch: Throwable -> L23
    L21:
        e = move-exception;
        throw e;     // Catch: Throwable -> L23
    L15:
        e = move-exception;
        InflateException r10 = new InflateException(r6.getPositionDescription() + ": " + e.getMessage());     // Catch: Throwable -> L23
        r10.initCause(e);     // Catch: Throwable -> L23
        throw r10;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private PreferenceGroup onMergeRoots(PreferenceGroup r1, PreferenceGroup r2) {
        if (r1 != null) goto L5;
        r2.onAttachedToHierarchy(this.mPreferenceManager);
        return r2;
    L5:
        return r1;
    }

    private Preference createItem(String r11, String[] r12, AttributeSet r13) throws ClassNotFoundException, InflateException {
        Constructor<?> r0 = CONSTRUCTOR_MAP.get(r11);
        if (r0 == null) goto L32;
    L23:
        Object[] r10 = this.mConstructorArgs;     // Catch: Exception -> L25 ClassNotFoundException -> L28
        r10[1] = r13;     // Catch: Exception -> L25 ClassNotFoundException -> L28
        return (Preference) r0.newInstance(r10);
    L32:
        ClassLoader r1 = this.mContext.getClassLoader();     // Catch: Exception -> L25 ClassNotFoundException -> L28
        if (r12 != null) goto L7;
    L21:
        Class<?> r5 = Class.forName(r11, false, r1);     // Catch: Exception -> L25 ClassNotFoundException -> L28
    L22:
        r0 = r5.getConstructor(CONSTRUCTOR_SIGNATURE);     // Catch: Exception -> L25 ClassNotFoundException -> L28
        r0.setAccessible(true);     // Catch: Exception -> L25 ClassNotFoundException -> L28
        CONSTRUCTOR_MAP.put(r11, r0);     // Catch: Exception -> L25 ClassNotFoundException -> L28
        goto L23
    L7:
        if (r12.length == 0) goto L21;
        int r4 = r12.length;     // Catch: Exception -> L25 ClassNotFoundException -> L28
        r5 = null;
        int r6 = 0;
        ClassNotFoundException e = null;
    L10:
        if (r6 >= r4) goto L16;
        r5 = Class.forName(r12[r6] + r11, false, r1);     // Catch: ClassNotFoundException -> L14 Exception -> L25
    L14:
        e = e;
        r6 = r6 + 1;
    L16:
        if (r5 != null) goto L22;
        if (e == null) goto L19;
        throw e;     // Catch: Exception -> L25 ClassNotFoundException -> L28
    L19:
        throw new InflateException(r13.getPositionDescription() + ": Error inflating class " + r11);     // Catch: Exception -> L25 ClassNotFoundException -> L28
    L25:
        e = move-exception;
        InflateException r14 = new InflateException(r13.getPositionDescription() + ": Error inflating class " + r11);
        r14.initCause(e);
        throw r14;
    L28:
        e = move-exception;
        throw e;
    }

    protected Preference onCreateItem(String r2, AttributeSet r3) throws ClassNotFoundException {
        return createItem(r2, this.mDefaultPackages, r3);
    }

    private Preference createItemFromTag(String r3, AttributeSet r4) {
    L14:
        e = move-exception;
        throw e;
    L11:
        e = move-exception;
        InflateException r0 = new InflateException(r4.getPositionDescription() + ": Error inflating class (not found)" + r3);
        r0.initCause(e);
        throw r0;
    L8:
        e = move-exception;
        InflateException r1 = new InflateException(r4.getPositionDescription() + ": Error inflating class " + r3);
        r1.initCause(e);
        throw r1;
    L4:
        if ((-1) != r3.indexOf(46)) goto L7;
        return onCreateItem(r3, r4);
    L7:
        return createItem(r3, null, r4);
    }

    private void rInflate(XmlPullParser r6, Preference r7, AttributeSet r8) throws XmlPullParserException, IOException {
        int r0 = r6.getDepth();
    L3:
        int r1 = r6.next();
        if (r1 != 3) goto L8;
        if (r6.getDepth() > r0) goto L8;
        return;
    L8:
        if (r1 == 1) goto L44;
        if (r1 != 2) goto L3;
        String r2 = r6.getName();
        if ("intent".equals(r2) == false) goto L20;
        r7.setIntent(Intent.parseIntent(getContext().getResources(), r6, r8));
    L16:
        e = move-exception;
        XmlPullParserException r9 = new XmlPullParserException("Error parsing preference");
        r9.initCause(e);
        throw r9;
    L20:
        if ("extra".equals(r2) == true) goto L21;
        Preference r3 = createItemFromTag(r2, r8);
        ((PreferenceGroup) r7).addItemFromInflater(r3);
        rInflate(r6, r3, r8);
        goto L3
    L21:
        getContext().getResources().parseBundleExtra("extra", r8, r7.getExtras());
        skipCurrentTag(r6);     // Catch: IOException -> L24
    L24:
        e = move-exception;
        XmlPullParserException r10 = new XmlPullParserException("Error parsing preference");
        r10.initCause(e);
        throw r10;
    }

    private static void skipCurrentTag(XmlPullParser r3) throws XmlPullParserException, IOException {
        int r0 = r3.getDepth();
    L3:
        int r1 = r3.next();
        if (r1 == 1) goto L9;
        if (r1 != 3) goto L3;
        if (r3.getDepth() > r0) goto L3;
        return;
    }
}
