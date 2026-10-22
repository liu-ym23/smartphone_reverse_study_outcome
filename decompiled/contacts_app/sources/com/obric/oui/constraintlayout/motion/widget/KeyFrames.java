package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import com.GlobalProxyLancet;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        HashMap<String, Constructor<? extends Key>> r0 = new HashMap();
        sKeyMakers = r0;
        r0.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "unable to load", e);
    }

    public void addKey(Key r4) {
        if (this.mFramesMap.containsKey(Integer.valueOf(r4.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(r4.mTargetId), new ArrayList());
    L5:
        ArrayList<Key> r3 = this.mFramesMap.get(Integer.valueOf(r4.mTargetId));
        if (r3 == null) goto L9;
        r3.add(r4);
        return;
    }

    public KeyFrames() {
        this.mFramesMap = new HashMap();
    }

    public KeyFrames(Context r9, XmlPullParser r10) {
        this.mFramesMap = new HashMap();
        int r2 = r10.getEventType();     // Catch: IOException -> L61 XmlPullParserException -> L63
        Key r3 = null;
    L5:
        if (r2 == 1) goto L82;
        if (r2 == 2) goto L13;
        if (r2 == 3) goto L11;
    L59:
        r2 = r10.next();     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L5
    L11:
        if ("KeyFrameSet".equals(r10.getName()) == false) goto L59;
        return;
    L13:
        String r4 = r10.getName();     // Catch: IOException -> L61 XmlPullParserException -> L63
        if (sKeyMakers.containsKey(r4) == false) goto L48;
        switch(r4.hashCode()) {
            case -300573030: goto L31;
            case -298435811: goto L28;
            case 540053991: goto L25;
            case 1153397896: goto L22;
            case 1308496505: goto L19;
            default: goto L33;
        };     // Catch: IOException -> L61 XmlPullParserException -> L63
    L33:
        byte r5 = -1;
    L34:
        if (r5 == 0) goto L45;
        if (r5 == 1) goto L44;
        if (r5 == 2) goto L43;
        if (r5 == 3) goto L42;
        if (r5 != 4) goto L41;
        Key r6 = new KeyTrigger();     // Catch: IOException -> L61 XmlPullParserException -> L63
    L46:
        r6.load(r9, Xml.asAttributeSet(r10));     // Catch: IOException -> L61 XmlPullParserException -> L63
        addKey(r6);     // Catch: IOException -> L61 XmlPullParserException -> L63
        r3 = r6;
        goto L59
    L41:
        throw new NullPointerException("Key " + r4 + " not found");     // Catch: IOException -> L61 XmlPullParserException -> L63
    L42:
        r6 = new KeyTimeCycle();     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L46
    L43:
        r6 = new KeyCycle();     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L46
    L44:
        r6 = new KeyPosition();     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L46
    L45:
        r6 = new KeyAttributes();     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L46
    L19:
        if (r4.equals("KeyTrigger") == false) goto L33;
        r5 = 4;
        goto L34
    L22:
        if (r4.equals("KeyPosition") == false) goto L33;
        r5 = 1;
        goto L34
    L25:
        if (r4.equals("KeyCycle") == false) goto L33;
        r5 = 2;
        goto L34
    L28:
        if (r4.equals("KeyAttribute") == false) goto L33;
        r5 = 0;
        goto L34
    L31:
        if (r4.equals("KeyTimeCycle") == false) goto L33;
        r5 = 3;
        goto L34
    L48:
        if (r4.equalsIgnoreCase("CustomAttribute") == false) goto L54;
        if (r3 == null) goto L59;
        if (r3.mCustomConstraints == null) goto L59;
        ConstraintAttribute.parse(r9, r10, r3.mCustomConstraints);     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L59
    L54:
        if (r4.equalsIgnoreCase("CustomMethod") == false) goto L59;
        if (r3 == null) goto L59;
        if (r3.mCustomConstraints == null) goto L59;
        ConstraintAttribute.parse(r9, r10, r3.mCustomConstraints);     // Catch: IOException -> L61 XmlPullParserException -> L63
        goto L59
    L82:
        return;
    L61:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error parsing XML resource", e);
        return;
    L63:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error parsing XML resource", e);
    }

    public void addAllFrames(MotionController r2) {
        ArrayList<Key> r1 = this.mFramesMap.get(-1);
        if (r1 == null) goto L6;
        r2.addKeys(r1);
        return;
    }

    public void addFrames(MotionController r3) {
        ArrayList<Key> r0 = this.mFramesMap.get(Integer.valueOf(r3.mId));
        if (r0 == null) goto L5;
        r3.addKeys(r0);
    L5:
        ArrayList<Key> r2 = this.mFramesMap.get(-1);
        if (r2 == null) goto L13;
        Iterator<Key> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        Key r1 = r4.next();
        if (r1.matches(((ConstraintLayout.LayoutParams) r3.mView.getLayoutParams()).constraintTag) == false) goto L9;
        r3.addKey(r1);
        goto L9
    L19:
        return;
    }

    static String name(int r0, Context r1) {
        return r1.getResources().getResourceEntryName(r0);
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    public ArrayList<Key> getKeyFramesForView(int r1) {
        return this.mFramesMap.get(Integer.valueOf(r1));
    }
}
