package n9;

import android.util.Pair;
import com.stepos.deepbinder.core.log.IPCLog;
import java.util.Map;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f10674a;

    @Override // zb.l
    public final Object invoke(Object obj) {
        boolean z;
        Map.Entry entry = (Map.Entry) obj;
        g.f(entry, "entry");
        Long l10 = (Long) ((Pair) entry.getKey()).second;
        if (l10 != null && l10.longValue() == this.f10674a) {
            IPCLog.INSTANCE.d("CallbackCache", "[passive][removeCallback]", "key", entry.getKey());
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
