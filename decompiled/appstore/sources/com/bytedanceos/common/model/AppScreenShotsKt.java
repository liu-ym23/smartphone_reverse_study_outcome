package com.bytedanceos.common.model;

import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.k0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000*.\u0010\b\"\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u0004¨\u0006\t"}, d2 = {"Size1080", "", "Size540", "parseScreenShotMap", "", "", "jsonObject", "Lorg/json/JSONObject;", "AppScreenShotMap", "appstorecommon_sysapp_updateRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppScreenShots.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppScreenShots.kt\ncom/bytedanceos/common/model/AppScreenShotsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,26:1\n1#2:27\n*E\n"})
public final class AppScreenShotsKt {

    @NotNull
    public static final String Size1080 = "1080";

    @NotNull
    public static final String Size540 = "540";

    @NotNull
    public static final Map<String, List<String>> parseScreenShotMap(@NotNull JSONObject r10) {
        q.g(r10, "jsonObject");
        if (r10.isNull(ServerElements.PRINTSCREEN_MAPS) == true) goto L5;
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L8
        String r12 = r10.optString(ServerElements.PRINTSCREEN_MAPS);     // Catch: Throwable -> L8
        Object r13 = Result.m35constructorimpl((Map) fe.a.a().fromJson(r12, new AppScreenShotsKt$parseScreenShotMap$1$1().getType()));     // Catch: Throwable -> L8
    L11:
        if (Result.m38exceptionOrNullimpl(r13) == null) goto L15;
        r13 = k0.h();
    L15:
        return (Map) r13;
    L8:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r13 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L11
    L5:
        return k0.h();
    }
}
