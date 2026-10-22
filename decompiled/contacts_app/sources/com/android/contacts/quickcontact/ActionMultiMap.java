package com.android.contacts.quickcontact;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ActionMultiMap extends HashMap<String, ArrayList<Action>> {
    public ActionMultiMap() {
    }

    public void put(String r2, Action r3) {
        put(r2, r3, false);
    }

    public void put(String r2, Action r3, boolean r4) {
        ArrayList<Action> r0 = get(r2);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        put(r2, r0);
    L5:
        if (r4 == false) goto L7;
        r0.add(0, r3);
        return;
    L7:
        r0.add(r3);
    }
}
