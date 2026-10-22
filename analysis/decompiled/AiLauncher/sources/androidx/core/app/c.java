package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

/* loaded from: classes.dex */
public class c {

    public static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final ActivityOptions f12940a;

        public a(ActivityOptions activityOptions) {
            this.f12940a = activityOptions;
        }

        @Override // androidx.core.app.c
        public Bundle d() {
            return this.f12940a.toBundle();
        }
    }

    public static c a(Context context, int i10, int i11) {
        return new a(ActivityOptions.makeCustomAnimation(context, i10, i11));
    }

    public static c b(Activity activity, View view, String str) {
        return new a(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
    }

    public static c c(Activity activity, B0.d<View, String>... dVarArr) {
        Pair[] pairArr;
        if (dVarArr != null) {
            pairArr = new Pair[dVarArr.length];
            for (int i10 = 0; i10 < dVarArr.length; i10++) {
                B0.d<View, String> dVar = dVarArr[i10];
                pairArr[i10] = Pair.create(dVar.f1411a, dVar.f1412b);
            }
        } else {
            pairArr = null;
        }
        return new a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    public Bundle d() {
        throw null;
    }
}
