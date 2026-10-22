package com.obric.appstore.network.entity;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import com.obric.appstore.network.entity.template.ElementEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\"\u0010\u0004\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/appstore/network/entity/TemplateResp;", "", ServerElements.TEMPLATE, "", "data", "", "Lcom/obric/appstore/network/entity/template/ElementEntity;", "(Ljava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getTemplate", "()Ljava/lang/String;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TemplateResp {

    @SerializedName("data")
    @Nullable
    private final List<ElementEntity<?>> data;

    @SerializedName(ServerElements.TEMPLATE)
    @NotNull
    private final String template;

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateResp() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final List<ElementEntity<?>> getData() {
        return this.data;
    }

    @NotNull
    public final String getTemplate() {
        return this.template;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateResp(@NotNull String r10, @Nullable List<? extends ElementEntity<?>> r11) {
        q.g(r10, ServerElements.TEMPLATE);
        this.template = r10;
        this.data = r11;
    }

    public /* synthetic */ TemplateResp(String r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
