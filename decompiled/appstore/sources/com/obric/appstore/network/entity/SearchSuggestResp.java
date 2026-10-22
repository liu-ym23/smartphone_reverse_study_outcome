package com.obric.appstore.network.entity;

import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/network/entity/SearchSuggestResp;", "", "apps", "", "Lcom/obric/appstore/network/entity/CommonAppEntity;", ServerElements.KEYWORDS, "", "(Ljava/util/List;Ljava/util/List;)V", "getApps", "()Ljava/util/List;", "getKeywords", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchSuggestResp {

    @SerializedName("apps")
    @Nullable
    private final List<CommonAppEntity> apps;

    @SerializedName(ServerElements.KEYWORDS)
    @Nullable
    private final List<String> keywords;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSuggestResp() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final List<CommonAppEntity> getApps() {
        return this.apps;
    }

    @Nullable
    public final List<String> getKeywords() {
        return this.keywords;
    }

    public SearchSuggestResp(@Nullable List<CommonAppEntity> r10, @Nullable List<String> r11) {
        this.apps = r10;
        this.keywords = r11;
    }

    public /* synthetic */ SearchSuggestResp(List r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
