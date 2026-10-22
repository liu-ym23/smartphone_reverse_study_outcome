package com.bytedance.android.live;

import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import kotlin.Metadata;
import mv0.a0;
import mv0.d0;
import mv0.p;
import mv0.v;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/MiddlewareMsgWindowProxyService;", "Lcom/bytedance/android/live/room/api/messagewindow/service/dependenceproxy/IMsgWindowProxyService;", "Ll71/d;", "getLiveRoomBackendUtils", "Ll71/b;", "getDSLContainerDynamicProxy", "Ll71/a;", "getDSGuideUtils", "Ll71/e;", "getLiveRoomEventParamUtils", "Ll71/g;", "getVSRoomLog", "Ll71/f;", "getOpenPlatformAnchorService", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiddlewareMsgWindowProxyService implements IMsgWindowProxyService {
    public MiddlewareMsgWindowProxyService() {
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService
    public l71.a getDSGuideUtils() {
        return mv0.d.f515819a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService
    public l71.b getDSLContainerDynamicProxy() {
        return mv0.e.f515821a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService
    public l71.d getLiveRoomBackendUtils() {
        return p.f515825a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService
    public l71.e getLiveRoomEventParamUtils() {
        return v.f515827a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService
    public l71.f getOpenPlatformAnchorService() {
        return a0.f515816a;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService
    public l71.g getVSRoomLog() {
        return d0.f515820a;
    }
}
