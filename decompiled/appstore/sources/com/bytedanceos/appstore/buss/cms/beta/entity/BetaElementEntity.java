package com.bytedanceos.appstore.buss.cms.beta.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "Info", "", "()V", "elementInfo", "getElementInfo", "()Ljava/lang/Object;", "Ljava/lang/Object;", "elementKey", "", "getElementKey", "()Ljava/lang/String;", "elementType", "", "getElementType", "()I", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BetaElementEntity<Info> {

    @SerializedName("element_info")
    @Nullable
    private final Info elementInfo;

    @SerializedName("element_key")
    @NotNull
    private final String elementKey;

    @SerializedName("element_type")
    private final int elementType;

    public BetaElementEntity() {
        this.elementType = -1;
        this.elementKey = "";
    }

    @Nullable
    public final Info getElementInfo() {
        return this.elementInfo;
    }

    @NotNull
    public final String getElementKey() {
        return this.elementKey;
    }

    public final int getElementType() {
        return this.elementType;
    }
}
