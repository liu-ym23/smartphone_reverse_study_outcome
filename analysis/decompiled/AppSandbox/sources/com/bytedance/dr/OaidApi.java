package com.bytedance.dr;

import android.content.Context;

/* loaded from: classes.dex */
public interface OaidApi {

    public static class a {
        public String a;
        public boolean b;

        public String toString() {
            StringBuilder sbA = com.bytedance.bdtracker.a.a("Result{oaid='");
            sbA.append(this.a);
            sbA.append('\'');
            sbA.append(", isTrackLimit=");
            sbA.append(this.b);
            sbA.append('}');
            return sbA.toString();
        }
    }

    String getName();

    a getOaid(Context context);

    boolean support(Context context);
}
