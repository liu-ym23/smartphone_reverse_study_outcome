package bc8;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.service.AccountService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f18593b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f18594c = null;

    public e() {
    }

    static {
        f18592a = new e();
        f18593b = LazyKt.lazy(new c());
        f18594c = LazyKt.lazy(new d());
    }

    public final SuggestedActionData b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        boolean r101 = false;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        Object r103 = null;
        if (r102 == false) goto L9;
        return null;
    L9:
        String r104 = ((Keva) f18593b.getValue()).getString(a(this, r100), null);
        if (r104 != null) goto L13;
        return null;
    L13:
        if (r104.length() != 0) goto L15;
        r101 = true;
    L15:
        if (r101 == false) goto L27;
        return null;
    L27:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
        Object r106 = Result.m9449constructorimpl((SuggestedActionData) ((Gson) f18594c.getValue()).fromJson(r104, SuggestedActionData.class));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r106) == true) goto L26;
        r103 = r106;
    L26:
        return (SuggestedActionData) r103;
    L19:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        r102 = false;
        goto L6
    }

    public static String a(e r100, String r101) {
        String r102 = AccountService.f365697a.getUserId();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "botId");
        Intrinsics.checkNotNullParameter(r102, "uid");
        return r101 + '_' + r102;
    }
}
