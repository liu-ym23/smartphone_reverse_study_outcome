package com.bytedance.android.gamecp.common.track.model;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010(\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\rR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R$\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/model/GPViewTrackData;", "", "name", "", "attrs", "", "type", "Lcom/bytedance/android/gamecp/common/track/model/GPViewTrackType;", "dataType", "Lcom/bytedance/android/gamecp/common/track/model/GPTrackDataType;", "routerData", "locationData", "needReportRouterAttr", "", "trackStrategy", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/gamecp/common/track/TrackRegisterStrategy;", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/gamecp/common/track/model/GPViewTrackType;Lcom/bytedance/android/gamecp/common/track/model/GPTrackDataType;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/ref/WeakReference;)V", "getAttrs", "()Ljava/util/Map;", "setAttrs", "(Ljava/util/Map;)V", "getDataType", "()Lcom/bytedance/android/gamecp/common/track/model/GPTrackDataType;", "getLocationData", "setLocationData", "getName", "()Ljava/lang/String;", "getNeedReportRouterAttr", "()Z", "setNeedReportRouterAttr", "(Z)V", "getRouterData", "setRouterData", "getTrackStrategy", "()Ljava/lang/ref/WeakReference;", "setTrackStrategy", "(Ljava/lang/ref/WeakReference;)V", "getType", "()Lcom/bytedance/android/gamecp/common/track/model/GPViewTrackType;", "isModuleData", "isPageData", "isRootView", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GPViewTrackData {
    private Map<String, ? extends Object> attrs;
    private final GPTrackDataType dataType;
    private Map<String, ? extends Object> locationData;
    private final String name;
    private boolean needReportRouterAttr;
    private Map<String, ? extends Object> routerData;
    private WeakReference<TrackRegisterStrategy> trackStrategy;
    private final GPViewTrackType type;

    public final boolean isModuleData() {
        if (this.dataType != GPTrackDataType.MODULE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPageData() {
        if (this.dataType != GPTrackDataType.PAGE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isRootView() {
        if (this.type != GPViewTrackType.ROOT_VIEW) goto L5;
        return true;
    L5:
        return false;
    }

    public final Map<String, Object> getAttrs() {
        return this.attrs;
    }

    public final GPTrackDataType getDataType() {
        return this.dataType;
    }

    public final Map<String, Object> getLocationData() {
        return this.locationData;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedReportRouterAttr() {
        return this.needReportRouterAttr;
    }

    public final Map<String, Object> getRouterData() {
        return this.routerData;
    }

    public final WeakReference<TrackRegisterStrategy> getTrackStrategy() {
        return this.trackStrategy;
    }

    public final GPViewTrackType getType() {
        return this.type;
    }

    public final void setAttrs(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.attrs = r100;
    }

    public final void setLocationData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.locationData = r100;
    }

    public final void setNeedReportRouterAttr(boolean r100) {
        this.needReportRouterAttr = r100;
    }

    public final void setRouterData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.routerData = r100;
    }

    public final void setTrackStrategy(WeakReference<TrackRegisterStrategy> r100) {
        this.trackStrategy = r100;
    }

    public GPViewTrackData(String r100, Map<String, ? extends Object> r101, GPViewTrackType r102, GPTrackDataType r103, Map<String, ? extends Object> r104, Map<String, ? extends Object> r105, boolean r106, WeakReference<TrackRegisterStrategy> r107) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "attrs");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "dataType");
        Intrinsics.checkNotNullParameter(r104, "routerData");
        Intrinsics.checkNotNullParameter(r105, "locationData");
        this.name = r100;
        this.attrs = r101;
        this.type = r102;
        this.dataType = r103;
        this.routerData = r104;
        this.locationData = r105;
        this.needReportRouterAttr = r106;
        this.trackStrategy = r107;
    }

    public /* synthetic */ GPViewTrackData(String r110, Map r111, GPViewTrackType r112, GPTrackDataType r113, Map r114, Map r115, boolean r116, WeakReference r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 4) == 0) goto L5;
        GPViewTrackType r100 = GPViewTrackType.CHILD_VIEW;
    L7:
        if ((r210 & 8) == 0) goto L9;
        GPTrackDataType r101 = GPTrackDataType.MODULE;
    L11:
        if ((r210 & 16) == 0) goto L13;
        Map r102 = new HashMap();
    L15:
        if ((r210 & 32) == 0) goto L17;
        Map r103 = new HashMap();
    L19:
        if ((r210 & 64) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r210 & 128) == 0) goto L25;
        WeakReference r118 = null;
    L26:
        this(r110, r111, r100, r101, r102, r103, r104, r118);
        return;
    L25:
        r118 = r117;
        goto L26
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
