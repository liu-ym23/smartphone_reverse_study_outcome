package com.bytedance.android.window.shop.widget.popup.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/popup/entity/WindowPopupActionType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OPEN_SCHEMA", "CLOSE_SELF", "DELAYED_CLOSE_SELF", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowPopupActionType extends Enum<WindowPopupActionType> {
    public static final WindowPopupActionType CLOSE_SELF = null;
    public static final a Companion = null;
    public static final WindowPopupActionType DELAYED_CLOSE_SELF = null;
    public static final WindowPopupActionType OPEN_SCHEMA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowPopupActionType[] f190074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, WindowPopupActionType> f190075b = null;
    private final String desc;

    public static final class a {
        public a() {
        }
    }

    static {
        int r100 = 0;
        WindowPopupActionType r101 = new WindowPopupActionType("OPEN_SCHEMA", 0, "open_schema");
        OPEN_SCHEMA = r101;
        WindowPopupActionType r102 = new WindowPopupActionType("CLOSE_SELF", 1, "close_self");
        CLOSE_SELF = r102;
        WindowPopupActionType r103 = new WindowPopupActionType("DELAYED_CLOSE_SELF", 2, "delayed_close_self");
        DELAYED_CLOSE_SELF = r103;
        f190074a = new WindowPopupActionType[]{r101, r102, r103};
        Companion = new a();
        WindowPopupActionType[] r104 = values();
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r104.length), 16));
        int r106 = r104.length;
    L3:
        if (r100 >= r106) goto L5;
        WindowPopupActionType r107 = r104[r100];
        r105.put(r107.desc, r107);
        r100 = r100 + 1;
        goto L3
    L5:
        f190075b = r105;
    }

    public static WindowPopupActionType valueOf(String r100) {
        return (WindowPopupActionType) r27.a.a(WindowPopupActionType.class, r100);
    }

    public static WindowPopupActionType[] values() {
        return (WindowPopupActionType[]) f190074a.clone();
    }

    public static final /* synthetic */ Map access$getMapping$cp() {
        return f190075b;
    }

    public WindowPopupActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
