package com.bytedance.android.ec.store.window.popup.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/window/popup/entity/PopupActionType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OPEN_SCHEMA", "CLOSE_SELF", "DELAYED_CLOSE_SELF", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PopupActionType extends Enum<PopupActionType> {
    public static final PopupActionType CLOSE_SELF = null;
    public static final a Companion = null;
    public static final PopupActionType DELAYED_CLOSE_SELF = null;
    public static final PopupActionType OPEN_SCHEMA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupActionType[] f49026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, PopupActionType> f49027b = null;
    private final String desc;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.ec.store.window.popup.entity.PopupActionType$a] */
    static {
        int r100 = 0;
        PopupActionType r101 = new PopupActionType("OPEN_SCHEMA", 0, "open_schema");
        OPEN_SCHEMA = r101;
        PopupActionType r102 = new PopupActionType("CLOSE_SELF", 1, "close_self");
        CLOSE_SELF = r102;
        PopupActionType r103 = new PopupActionType("DELAYED_CLOSE_SELF", 2, "delayed_close_self");
        DELAYED_CLOSE_SELF = r103;
        f49026a = new PopupActionType[]{r101, r102, r103};
        Companion = new a();
        PopupActionType[] r104 = values();
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r104.length), 16));
        int r106 = r104.length;
    L3:
        if (r100 >= r106) goto L5;
        PopupActionType r107 = r104[r100];
        r105.put(r107.desc, r107);
        r100 = r100 + 1;
        goto L3
    L5:
        f49027b = r105;
    }

    public static PopupActionType valueOf(String r100) {
        return (PopupActionType) r27.a.a(PopupActionType.class, r100);
    }

    public static PopupActionType[] values() {
        return (PopupActionType[]) f49026a.clone();
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        return f49027b;
    }

    public PopupActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
