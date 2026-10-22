package com.android.contacts.bytedanceosquickcontact;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ActionMultiMap extends HashMap<String, ArrayList<Action>> {
    public ActionMultiMap() {
    }

    public void put(String r2, Action r3) {
        ArrayList<Action> r0 = get(r2);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        put(r2, r0);
    L5:
        r0.add(r3);
    }
}
