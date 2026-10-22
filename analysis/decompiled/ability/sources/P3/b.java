package P3;

import C7.r;
import S7.p;
import android.util.Log;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1085a;

    @Override // S7.p
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        Integer num = (Integer) obj;
        switch (this.f1085a) {
            case 0:
                int iIntValue = num.intValue();
                String tag = (String) obj2;
                String msg = (String) obj3;
                Throwable th = (Throwable) obj4;
                k.f(tag, "tag");
                k.f(msg, "msg");
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
                break;
            default:
                int iIntValue2 = num.intValue();
                String tag2 = (String) obj2;
                String msg2 = (String) obj3;
                Throwable th2 = (Throwable) obj4;
                k.f(tag2, "tag");
                k.f(msg2, "msg");
                if (iIntValue2 == 3) {
                    Log.d(tag2, msg2, th2);
                } else if (iIntValue2 == 4) {
                    Log.i(tag2, msg2, th2);
                } else if (iIntValue2 == 5) {
                    Log.w(tag2, msg2, th2);
                } else if (iIntValue2 != 6) {
                    Log.v(tag2, msg2, th2);
                } else {
                    Log.e(tag2, msg2, th2);
                }
                break;
        }
        return r.f317a;
    }
}
