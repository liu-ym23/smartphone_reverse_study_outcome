package com.stepos.common.alphame;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b extends g {
    private ArrayList<String> mActions = new ArrayList<>();

    public b() {
    }

    public final void addAction(String str) {
        if (this.mActions.contains(str)) {
            return;
        }
        this.mActions.add(str.intern());
    }

    @Override // com.stepos.common.alphame.g
    public /* bridge */ /* synthetic */ int getId() {
        return super.getId();
    }

    public abstract void onReceiver(String str, Object obj);

    public b(String str) {
        addAction(str);
    }
}
