package com.obric.appstore.network.entity.template;

import com.bytedance.apm.constant.CommonKey;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u0003¢\u0006\u0002\u0010\u0005R&\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementArrayInfoEntity;", "", CommonKey.KEY_VALUE, "", "Lcom/obric/appstore/network/entity/template/ElementEntity;", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ElementArrayInfoEntity {

    @SerializedName(CommonKey.KEY_VALUE)
    @NotNull
    private final List<List<ElementEntity<?>>> value;

    /* JADX WARN: Multi-variable type inference failed */
    public ElementArrayInfoEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<List<ElementEntity<?>>> getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ElementArrayInfoEntity(@NotNull List<? extends List<? extends ElementEntity<?>>> r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        this.value = r10;
    }

    public /* synthetic */ ElementArrayInfoEntity(List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = t.i();
    L5:
        this(r10);
    }
}
