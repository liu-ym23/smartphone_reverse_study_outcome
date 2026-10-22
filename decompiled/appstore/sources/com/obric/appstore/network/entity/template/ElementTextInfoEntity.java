package com.obric.appstore.network.entity.template;

import com.bytedance.apm.constant.CommonKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementTextInfoEntity;", "", CommonKey.KEY_VALUE, "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementTextInfoEntity {

    @SerializedName(CommonKey.KEY_VALUE)
    @Nullable
    private final String value;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementTextInfoEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    public ElementTextInfoEntity(@Nullable String r10) {
        this.value = r10;
    }

    public /* synthetic */ ElementTextInfoEntity(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
