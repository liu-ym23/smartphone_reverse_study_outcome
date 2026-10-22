package com.obric.appstore.network.entity.template;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/appstore/network/entity/template/ElementEntity;", "Info", "", "elementKey", "", "elementType", "", "elementInfo", "(Ljava/lang/String;ILjava/lang/Object;)V", "getElementInfo", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getElementKey", "()Ljava/lang/String;", "getElementType", "()I", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ElementEntity<Info> {

    @SerializedName("element_info")
    @Nullable
    private final Info elementInfo;

    @SerializedName("element_key")
    @NotNull
    private final String elementKey;

    @SerializedName("element_type")
    private final int elementType;

    public ElementEntity() {
        String r10 = null;
        int r11 = 0;
        Object r12 = null;
        this(r10, r11, r12, 7, null);
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

    public ElementEntity(@NotNull String r10, int r11, @Nullable Info r12) {
        q.g(r10, "elementKey");
        this.elementKey = r10;
        this.elementType = r11;
        this.elementInfo = r12;
    }

    public /* synthetic */ ElementEntity(String r10, int r11, Object r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
