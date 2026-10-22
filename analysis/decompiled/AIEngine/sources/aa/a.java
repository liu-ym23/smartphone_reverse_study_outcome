package aa;

import android.text.TextUtils;
import android.util.Pair;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.service.cache.ServiceCache;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static void a(Pair pair, String str, ServiceCache.b serviceContext) {
        String strConcat;
        g.f(serviceContext, "serviceContext");
        StringBuilder sb2 = new StringBuilder("the package name: " + str + ' ');
        if (TextUtils.isEmpty(serviceContext.f7646d)) {
            Class<?> cls = serviceContext.f7649g;
            g.c(cls);
            strConcat = "service :".concat(cls.getName());
        } else {
            strConcat = "method :" + serviceContext.f7646d;
        }
        Object first = pair.first;
        g.e(first, "first");
        if (!((Collection) first).isEmpty() && !((ArrayList) pair.first).contains(str)) {
            sb2.append("is not in the white list of the " + strConcat + ", please check @WhiteList annotation!");
            int i10 = TextUtils.isEmpty(serviceContext.f7646d) ? 47 : 45;
            String string = sb2.toString();
            g.e(string, "toString(...)");
            throw new IPCException(i10, string);
        }
        if (((ArrayList) pair.second).contains(str)) {
            sb2.append("is in the black list of the " + strConcat + ", please check @BlackList annotation!");
            int i11 = TextUtils.isEmpty(serviceContext.f7646d) ? 48 : 46;
            String string2 = sb2.toString();
            g.e(string2, "toString(...)");
            throw new IPCException(i11, string2);
        }
    }
}
