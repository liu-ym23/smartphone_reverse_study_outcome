package androidx.constraintlayout.motion.widget;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, Constructor<? extends d>> f12282b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Integer, ArrayList<d>> f12283a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends d>> map = new HashMap<>();
        f12282b = map;
        try {
            map.put("KeyAttribute", e.class.getConstructor(null));
            f12282b.put("KeyPosition", h.class.getConstructor(null));
            f12282b.put("KeyCycle", f.class.getConstructor(null));
            f12282b.put("KeyTimeCycle", j.class.getConstructor(null));
            f12282b.put("KeyTrigger", k.class.getConstructor(null));
        } catch (NoSuchMethodException e10) {
            Log.e("KeyFrames", "unable to load", e10);
        }
    }

    public g() {
    }

    public void a(m mVar) {
        ArrayList<d> arrayList = this.f12283a.get(-1);
        if (arrayList != null) {
            mVar.b(arrayList);
        }
    }

    public void b(m mVar) {
        ArrayList<d> arrayList = this.f12283a.get(Integer.valueOf(mVar.f12383c));
        if (arrayList != null) {
            mVar.b(arrayList);
        }
        ArrayList<d> arrayList2 = this.f12283a.get(-1);
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.f(((ConstraintLayout.b) mVar.f12382b.getLayoutParams()).f12631c0)) {
                    mVar.a(next);
                }
            }
        }
    }

    public void c(d dVar) {
        if (!this.f12283a.containsKey(Integer.valueOf(dVar.f12239b))) {
            this.f12283a.put(Integer.valueOf(dVar.f12239b), new ArrayList<>());
        }
        ArrayList<d> arrayList = this.f12283a.get(Integer.valueOf(dVar.f12239b));
        if (arrayList != null) {
            arrayList.add(dVar);
        }
    }

    public ArrayList<d> d(int i10) {
        return this.f12283a.get(Integer.valueOf(i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.g.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
