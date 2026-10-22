package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import a1.c;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.a;
import ouc.b;
import ouc.d0;
import ouc.e;
import ouc.e0;
import ouc.i;
import ouc.j;
import ouc.k;
import ouc.w;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayParamsCodec;", "", "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "encodeV1", "", "entryId", BuyNowCloseMethod.MASK, "Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;", WsConstants.KEY_PAYLOAD, "", "entryIdFromParamsOrRaw", "params", "maskFromParamsOrDefault", "defaultMask", "parseJsonObjectOrNull", "Lkotlinx/serialization/json/JsonObject;", "text", "toJsonElement", "Lkotlinx/serialization/json/JsonElement;", "value", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayParamsCodec {
    public static final int $stable = 0;
    public static final CJOverlayParamsCodec INSTANCE = null;
    private static final a json = null;

    private CJOverlayParamsCodec() {
    }

    public static /* synthetic */ Unit a(e r100) {
        return json$lambda$0(r100);
    }

    static {
        INSTANCE = new CJOverlayParamsCodec();
        json = w.a(new c());
        $stable = 8;
    }

    private static final Unit json$lambda$0(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$Json");
        r100.f526814a = true;
        r100.f526816c = true;
        r100.f526820g = true;
        return Unit.INSTANCE;
    }

    private final d0 parseJsonObjectOrNull(String r100) {
        i r101 = json.e(r100);     // Catch: Throwable -> L8
        if ((r101 instanceof d0) == false) goto L11;
        return (d0) r101;
    L11:
        return null;
    L12:
        return null;
    }

    private final i toJsonElement(Object r100) {
        if (r100 != null) goto L5;
        return k.c("");
    L5:
        if ((r100 instanceof i) == false) goto L8;
        return (i) r100;
    L8:
        if ((r100 instanceof String) == false) goto L11;
        return k.c((String) r100);
    L11:
        if ((r100 instanceof Number) == false) goto L14;
        return k.b((Number) r100);
    L14:
        if ((r100 instanceof Boolean) == false) goto L17;
        return k.a((Boolean) r100);
    L17:
        if ((r100 instanceof Map) == false) goto L26;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((Map) r100).entrySet().iterator();
    L20:
        if (r102.hasNext() == false) goto L45;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r104 instanceof String) == false) goto L20;
        String r106 = (String) r104;
        i r107 = INSTANCE.toJsonElement(r105);
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r107, "element");
        i r108 = (i) r101.put(r106, r107);
        goto L20
    L45:
        return new d0(r101);
    L26:
        if ((r100 instanceof List) == false) goto L33;
        Iterable r109 = (Iterable) r100;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r111 = r109.iterator();
    L29:
        if (r111.hasNext() == false) goto L46;
        Object r112 = r111.next();
        r110.add(INSTANCE.toJsonElement(r112));
        goto L29
    L46:
        return new b(r110);
    L33:
        return k.c(r100.toString());
    }

    public final String entryIdFromParamsOrRaw(String r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        d0 r101 = parseJsonObjectOrNull(r100);
        if (r101 == null) goto L10;
        i r102 = (i) r101.get("entry_id");
        if (r102 == null) goto L11;
        String r103 = k.g(k.o(r102));
        if (r103 != null) goto L9;
        return r100;
    L9:
        return r103;
    L11:
        return r100;
    L10:
        return r100;
    }

    public final CJOverlayMask maskFromParamsOrDefault(String r100, CJOverlayMask r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "defaultMask");
        d0 r102 = parseJsonObjectOrNull(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        i r103 = (i) r102.get("mask_color");
        if (r103 == null) goto L9;
        String r104 = k.g(k.o(r103));
        if (r104 == null) goto L9;
    L10:
        i r105 = (i) r102.get("mask_blur");
        if (r105 == null) goto L15;
        Integer r106 = k.l(k.o(r105));
        if (r106 == null) goto L15;
        int r107 = r106.intValue();
    L17:
        return new CJOverlayMask(r104, r107);
    L15:
        r107 = r101.getMaskBlur();
    L9:
        r104 = r101.getMaskColor();
        goto L10
    }

    public final String encodeV1(String r100, CJOverlayMask r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "entryId");
        Intrinsics.checkNotNullParameter(r101, BuyNowCloseMethod.MASK);
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        e0 r103 = new e0();
        j.b(r103, BaseSwitches.V, 1);
        j.c(r103, "entry_id", r100);
        j.c(r103, "mask_color", r101.getMaskColor());
        j.b(r103, "mask_blur", Integer.valueOf(r101.getMaskBlur()));
        r103.b(WsConstants.KEY_PAYLOAD, INSTANCE.toJsonElement(r102));
        d0 r104 = r103.a();
        a r105 = json;
        r105.getClass();
        return r105.a(d0.Companion.serializer(), r104);
    }

    public static /* synthetic */ CJOverlayMask maskFromParamsOrDefault$default(CJOverlayParamsCodec r100, String r101, CJOverlayMask r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = new CJOverlayMask(null, 0, 3, null);
    L6:
        return r100.maskFromParamsOrDefault(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String encodeV1$default(CJOverlayParamsCodec r100, String r101, CJOverlayMask r102, Map r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = new CJOverlayMask(null, 0, 3, null);
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = MapsKt.emptyMap();
    L9:
        return r100.encodeV1(r101, r102, r103);
    }
}
