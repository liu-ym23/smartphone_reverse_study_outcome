package v5;

import android.util.Log;
import kotlin.jvm.internal.g;
import lb.n;
import zb.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements r {
    @Override // zb.r
    public final Object a(Object obj, Object obj2, Object obj3, Object obj4) {
        int iIntValue = ((Integer) obj).intValue();
        String tag = (String) obj2;
        String msg = (String) obj3;
        Throwable th = (Throwable) obj4;
        g.f(tag, "tag");
        g.f(msg, "msg");
        if (iIntValue != 3) {
            if (iIntValue != 4) {
                if (iIntValue != 5) {
                    if (iIntValue != 6) {
                        if (th != null) {
                            Log.v(tag, msg, th);
                        } else {
                            Log.v(tag, msg);
                        }
                    } else if (th != null) {
                        Log.e(tag, msg, th);
                    } else {
                        Log.e(tag, msg);
                    }
                } else if (th != null) {
                    Log.w(tag, msg, th);
                } else {
                    Log.w(tag, msg);
                }
            } else if (th != null) {
                Log.i(tag, msg, th);
            } else {
                Log.i(tag, msg);
            }
        } else if (th != null) {
            Log.d(tag, msg, th);
        } else {
            Log.d(tag, msg);
        }
        return n.f10413a;
    }
}
