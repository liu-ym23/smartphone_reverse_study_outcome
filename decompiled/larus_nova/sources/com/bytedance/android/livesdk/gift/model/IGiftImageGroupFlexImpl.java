package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.GiftImageGroup")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftImageGroupFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/r1;", "", "", "Lpy/k;", "giftImageMap", "Ljava/util/Map;", "getGiftImageMap", "()Ljava/util/Map;", "setGiftImageMap", "(Ljava/util/Map;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftImageGroupFlexImpl extends FlexModelBase<r1> implements r1, vh7.h {

    @SerializedName("image_group")
    protected Map<Integer, ? extends py.k> giftImageMap;

    public IGiftImageGroupFlexImpl() {
        super(r1.class);
        this.giftImageMap = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.gift.model.r1
    public Map<Integer, py.k> getGiftImageMap() {
        return this.giftImageMap;
    }

    public IGiftImageGroupFlexImpl(am3.g r110) {
        super(r1.class);
        this.giftImageMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L24;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 2) goto L7;
        long r103 = r110.c();
        Integer r104 = null;
        Object r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L16;
        if (r106 != 1) goto L12;
        r104 = Integer.valueOf(r110.i());
        goto L9
    L12:
        if (r106 != 2) goto L13;
        r105 = vh7.f.a(r110, py.k.class);
        goto L9
    L13:
        am3.h.e(r110);
        goto L9
    L16:
        r110.d(r103);
        Map<Integer, ? extends py.k> r107 = this.giftImageMap;
        if (r104 == null) goto L23;
        if (r105 == null) goto L21;
        r107.put(r104, r105);
        goto L3
    L21:
        throw new IllegalStateException("Value must not be null");
    L23:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L24:
        r110.d(r100);
        setThreadSafe(true);
        if (this.giftImageMap != null) goto L45;
        this.giftImageMap = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
        return;
    }

    public void setGiftImageMap(Map<Integer, ? extends py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.giftImageMap = r100;
    }
}
