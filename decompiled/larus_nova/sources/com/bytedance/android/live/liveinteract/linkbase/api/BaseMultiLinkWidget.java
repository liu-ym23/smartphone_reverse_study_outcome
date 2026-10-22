package com.bytedance.android.live.liveinteract.linkbase.api;

import androidx.exifinterface.media.ExifInterface;
import bn0.b;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.f0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J'\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013\u0012\u0004\u0012\u00020\u00110\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/f0;", "Lcom/bytedance/android/livesdk/chatroom/widget/j1;", "", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "", "getScene", "", "source", "setSource", "getSource", "Lbn0/b;", "multiLinkRoomScope", "setMultiLinkRoomScope", "getMultiLinkRoomScope", "Ldn0/b;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", NsdHelper.serviceTypeKey, "getScopeServiceInMultiLinkRoom", "(Ljava/lang/Class;)Ldn0/b;", "getScopeServiceOrNullInMultiLinkRoom", "_source", "Ljava/lang/String;", "_multiLinkRoomScope", "Lbn0/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "multiLinkRoomScopeServiceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseMultiLinkWidget extends MiddlewareRoomWidget implements f0, j1 {
    private b _multiLinkRoomScope;
    private String _source;
    private final ConcurrentHashMap<Class<? extends dn0.b>, dn0.b> multiLinkRoomScopeServiceMap;

    public abstract int getScene();

    public BaseMultiLinkWidget() {
        this.multiLinkRoomScopeServiceMap = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.j1
    public b getMultiLinkRoomScope() {
        return this._multiLinkRoomScope;
    }

    public String getSource() {
        return this._source;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.j1
    public <T extends dn0.b> T getScopeServiceInMultiLinkRoom(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        b r101 = this._multiLinkRoomScope;
        if (r101 == null) goto L18;
        m r102 = m.f163449e;
        Intrinsics.checkNotNull(r101);
        T r103 = (T) r102.d(r101, r100);
        if (r103 != null) goto L10;
        dn0.b r104 = this.multiLinkRoomScopeServiceMap.get(r100);
        if ((r104 instanceof dn0.b) == true) goto L9;
        r104 = null;
    L9:
        r103 = (T) r104;
    L10:
        if (r103 == null) goto L16;
        if (this.multiLinkRoomScopeServiceMap.containsKey(r100) == true) goto L14;
        this.multiLinkRoomScopeServiceMap.put((Class<? extends dn0.b>) r100, r103);
    L14:
        return r103;
    L16:
        throw new Exception("service can not be null, serviceType = " + r100);
    L18:
        throw new Exception("_multiLinkRoomScope can not be null");
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.j1
    public <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, NsdHelper.serviceTypeKey);
        b r101 = this._multiLinkRoomScope;
        T r102 = null;
        if (r101 == null) goto L19;
        m r103 = m.f163449e;
        Intrinsics.checkNotNull(r101);
        T r104 = (T) r103.d(r101, r100);
        if (r104 != null) goto L11;
        dn0.b r105 = this.multiLinkRoomScopeServiceMap.get(r100);
        if ((r105 instanceof dn0.b) == true) goto L9;
        r105 = null;
    L9:
        r104 = (T) r105;
    L11:
        if (this.multiLinkRoomScopeServiceMap.containsKey(r100) == false) goto L13;
    L18:
        return r104;
    L13:
        if ((r104 instanceof dn0.b) == false) goto L16;
        r102 = r104;
    L16:
        if (r102 == null) goto L18;
        this.multiLinkRoomScopeServiceMap.put((Class<? extends dn0.b>) r100, r102);
        goto L18
    L19:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.f0
    public void setMultiLinkRoomScope(b r100) {
        this._multiLinkRoomScope = r100;
    }

    public final void setSource(String r100) {
        this._source = r100;
    }
}
