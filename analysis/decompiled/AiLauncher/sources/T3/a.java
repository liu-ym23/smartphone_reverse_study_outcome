package T3;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ability.bean.OriginalTaskConfig;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"LT3/a;", "", "<init>", "()V", "", "json", "Lcom/stepos/ability/bean/OriginalTaskConfig;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ability/bean/OriginalTaskConfig;", "Lcom/google/gson/Gson;", Const.INTENT_KEY_PKGNAME, "Lcom/google/gson/Gson;", "gson", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5866a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Gson gson = new Gson();

    public final OriginalTaskConfig a(String json) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((json == null || H.x0(json)) ? null : (OriginalTaskConfig) gson.fromJson(json, OriginalTaskConfig.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (OriginalTaskConfig) (Result.g(objB) ? null : objB);
    }
}
