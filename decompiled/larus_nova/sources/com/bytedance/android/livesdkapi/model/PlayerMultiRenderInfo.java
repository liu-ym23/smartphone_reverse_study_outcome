package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\r\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0006\u0010!\u001a\u00020\u001bJ\b\u0010\"\u001a\u0004\u0018\u00010\u0007J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020&HÖ\u0001R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMultiRenderInfo;", "", "multiDisplay", "Lcom/bytedance/android/livesdkapi/model/PlayerMultiDisplay;", "multiRenderMap", "", "", "Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "(Lcom/bytedance/android/livesdkapi/model/PlayerMultiDisplay;Ljava/util/Map;)V", "config", "Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderConfig;", "getConfig", "()Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderConfig;", "config$delegate", "Lkotlin/Lazy;", "getMultiDisplay", "()Lcom/bytedance/android/livesdkapi/model/PlayerMultiDisplay;", "setMultiDisplay", "(Lcom/bytedance/android/livesdkapi/model/PlayerMultiDisplay;)V", "getMultiRenderMap", "()Ljava/util/Map;", "setMultiRenderMap", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "extraRenderMap", "getDisplayId", "()Ljava/lang/Integer;", "hashCode", "isGameLink", "mainRenderInfo", BasicTestActionHandler.TEST_ACTION_RESET, "", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMultiRenderInfo {
    private final Lazy config$delegate;
    private PlayerMultiDisplay multiDisplay;
    private Map<Integer, RenderViewInfo> multiRenderMap;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerMultiRenderInfo copy$default(PlayerMultiRenderInfo r100, PlayerMultiDisplay r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.multiDisplay;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.multiRenderMap;
    L9:
        return r100.copy(r101, r102);
    }

    private final PlayerExtraRenderConfig getConfig() {
        return (PlayerExtraRenderConfig) this.config$delegate.getValue();
    }

    public final PlayerMultiDisplay component1() {
        return this.multiDisplay;
    }

    public final Map<Integer, RenderViewInfo> component2() {
        return this.multiRenderMap;
    }

    public final PlayerMultiRenderInfo copy(PlayerMultiDisplay r100, Map<Integer, RenderViewInfo> r101) {
        Intrinsics.checkNotNullParameter(r101, "multiRenderMap");
        return new PlayerMultiRenderInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMultiRenderInfo) == false) goto L10;
        PlayerMultiRenderInfo r101 = (PlayerMultiRenderInfo) r100;
        if (Intrinsics.areEqual(this.multiDisplay, r101.multiDisplay) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.multiRenderMap, r101.multiRenderMap) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        PlayerMultiDisplay r100 = this.multiDisplay;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<Integer, RenderViewInfo> r104 = this.multiRenderMap;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final void reset() {
        this.multiDisplay = null;
        this.multiRenderMap = new LinkedHashMap();
    }

    public String toString() {
        return "PlayerMultiRenderInfo(multiDisplay=" + this.multiDisplay + ", multiRenderMap=" + this.multiRenderMap + ")";
    }

    public final Map<Integer, RenderViewInfo> extraRenderMap() {
        Map<Integer, RenderViewInfo> r100 = this.multiRenderMap;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, RenderViewInfo>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<Integer, RenderViewInfo> r103 = r102.next();
        if (r103.getKey().intValue() == 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        return r101;
    }

    public final Integer getDisplayId() {
        PlayerMultiDisplay r100 = this.multiDisplay;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getDisplayId());
    }

    public final boolean isGameLink() {
        PlayerMultiDisplay r100 = this.multiDisplay;
        if (r100 == null) goto L7;
        int r101 = r100.getDisplayId();
        if (getConfig().getLegalDisplays().contains(Integer.valueOf(r101)) != true) goto L7;
        return true;
    L7:
        return false;
    }

    public final RenderViewInfo mainRenderInfo() {
        return this.multiRenderMap.get(0);
    }

    public final PlayerMultiDisplay getMultiDisplay() {
        return this.multiDisplay;
    }

    public final Map<Integer, RenderViewInfo> getMultiRenderMap() {
        return this.multiRenderMap;
    }

    public final void setMultiDisplay(PlayerMultiDisplay r100) {
        this.multiDisplay = r100;
    }

    public final void setMultiRenderMap(Map<Integer, RenderViewInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.multiRenderMap = r100;
    }

    public PlayerMultiRenderInfo(PlayerMultiDisplay r100, Map<Integer, RenderViewInfo> r101) {
        Intrinsics.checkNotNullParameter(r101, "multiRenderMap");
        this.multiDisplay = r100;
        this.multiRenderMap = r101;
        this.config$delegate = LazyKt.lazy(PlayerMultiRenderInfo$config$2.INSTANCE);
    }
}
