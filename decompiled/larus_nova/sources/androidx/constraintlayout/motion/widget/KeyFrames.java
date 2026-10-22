package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class KeyFrames {
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap;

    static {
        HashMap<String, Constructor<? extends Key>> r100 = new HashMap();
        sKeyMakers = r100;
        r100.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    private void addKey(Key r100) {
        if (this.mFramesMap.containsKey(Integer.valueOf(r100.mTargetId)) == true) goto L5;
        this.mFramesMap.put(Integer.valueOf(r100.mTargetId), new ArrayList());
    L5:
        this.mFramesMap.get(Integer.valueOf(r100.mTargetId)).add(r100);
    }

    public void addFrames(MotionController r100) {
        ArrayList<Key> r101 = this.mFramesMap.get(Integer.valueOf(r100.mId));
        if (r101 == null) goto L5;
        r100.addKeys(r101);
    L5:
        ArrayList<Key> r102 = this.mFramesMap.get(-1);
        if (r102 == null) goto L13;
        Iterator<Key> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L19;
        Key r104 = r103.next();
        if (r104.matches(((ConstraintLayout.LayoutParams) r100.mView.getLayoutParams()).constraintTag) == false) goto L9;
        r100.addKey(r104);
        goto L9
    L19:
        return;
    }

    public ArrayList<Key> getKeyFramesForView(int r100) {
        return this.mFramesMap.get(Integer.valueOf(r100));
    }

    public KeyFrames(Context r100, XmlPullParser r101) {
        this.mFramesMap = new HashMap();
        int r102 = r101.getEventType();     // Catch: IOException -> L27 XmlPullParserException -> L29
        Key r103 = null;
    L5:
        if (r102 == 1) goto L51;
        if (r102 != 2) goto L9;
        String r104 = r101.getName();     // Catch: IOException -> L27 XmlPullParserException -> L29
        if (sKeyMakers.containsKey(r104) == false) goto L20;
        Key r105 = sKeyMakers.get(r104).newInstance(new Object[0]);     // Catch: Exception -> L32
        r105.load(r100, Xml.asAttributeSet(r101));     // Catch: Exception -> L33
        addKey(r105);     // Catch: Exception -> L33
    L18:
        r103 = r105;
    L25:
        r102 = r101.next();     // Catch: IOException -> L27 XmlPullParserException -> L29
    L20:
        if (r104.equalsIgnoreCase("CustomAttribute") == false) goto L25;
        if (r103 == null) goto L25;
        HashMap<String, ConstraintAttribute> r106 = r103.mCustomConstraints;     // Catch: IOException -> L27 XmlPullParserException -> L29
        if (r106 == null) goto L25;
        ConstraintAttribute.parse(r100, r101, r106);     // Catch: IOException -> L27 XmlPullParserException -> L29
        goto L25
    L9:
        if (r102 != 3) goto L25;
        if ("KeyFrameSet".equals(r101.getName()) == false) goto L25;
        return;
    L51:
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    public static String name(int r100, Context r101) {
        return r101.getResources().getResourceEntryName(r100);
    }
}
