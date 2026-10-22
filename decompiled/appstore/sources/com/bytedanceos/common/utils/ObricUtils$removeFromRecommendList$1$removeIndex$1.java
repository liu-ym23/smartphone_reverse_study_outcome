package com.bytedanceos.common.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ObricUtils$removeFromRecommendList$1$removeIndex$1 extends Lambda implements Function1<JSONObject, Boolean> {
    public static final ObricUtils$removeFromRecommendList$1$removeIndex$1 INSTANCE = null;

    static {
        INSTANCE = new ObricUtils$removeFromRecommendList$1$removeIndex$1();
    }

    public ObricUtils$removeFromRecommendList$1$removeIndex$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(JSONObject r10) {
        return invoke2(r10);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@NotNull JSONObject r10) {
        kotlin.jvm.internal.q.g(r10, "it");
        String r11 = r10.optString("name");
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        if (kotlin.jvm.internal.q.b("一步精选", r11) == false) goto L8;
    L11:
        boolean r12 = true;
    L13:
        return Boolean.valueOf(r12);
    L8:
        if (kotlin.jvm.internal.q.b("礼包", r11) == true) goto L11;
        r12 = false;
        goto L13
    }
}
