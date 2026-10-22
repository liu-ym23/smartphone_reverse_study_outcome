package N5;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LN5/g;", "", "<init>", "()V", "", "templateType", "LN5/v;", Const.JSON_KEY_PROVIDER, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LN5/v;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LN5/v;", "Ljava/util/concurrent/ConcurrentHashMap;", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    public static final g INSTANCE = new g();
    private static final ConcurrentHashMap<String, v> providers = new ConcurrentHashMap<>();

    public final void a(String templateType, v provider) {
        kotlin.jvm.internal.p.i(templateType, "templateType");
        kotlin.jvm.internal.p.i(provider, "provider");
        providers.put(templateType, provider);
    }

    public final v b(String templateType) {
        if (templateType == null || templateType.length() == 0) {
            return null;
        }
        return providers.get(templateType);
    }
}
