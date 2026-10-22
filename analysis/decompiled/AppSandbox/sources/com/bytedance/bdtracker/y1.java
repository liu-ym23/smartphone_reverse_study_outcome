package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;

/* loaded from: classes.dex */
public class y1 {
    public volatile e5 a;
    public Account b;
    public d4 c;

    public e5 a(d dVar, Context context, u1 u1Var) {
        if (this.a == null) {
            synchronized (y1.class) {
                if (this.a == null) {
                    if (context == null) {
                        throw new IllegalArgumentException("context == null");
                    }
                    if (this.c == null) {
                        this.c = new d4(dVar, context);
                    }
                    if (this.a == null) {
                        this.a = new e5(dVar, context, u1Var, this.c);
                        if (this.b != null) {
                            this.a.a(this.b);
                        }
                    }
                }
            }
        }
        return this.a;
    }
}
