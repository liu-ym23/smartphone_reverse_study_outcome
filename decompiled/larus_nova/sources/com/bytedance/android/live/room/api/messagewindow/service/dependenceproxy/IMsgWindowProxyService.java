package com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;
import l71.a;
import l71.b;
import l71.c;
import l71.d;
import l71.e;
import l71.f;
import l71.g;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.MsgWindowProxyService")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/service/dependenceproxy/IMsgWindowProxyService;", "Lcom/bytedance/android/live/base/IService;", "Ll71/c;", "getExternalBrowserService", "Ll71/d;", "getLiveRoomBackendUtils", "Ll71/b;", "getDSLContainerDynamicProxy", "Ll71/a;", "getDSGuideUtils", "Ll71/e;", "getLiveRoomEventParamUtils", "Ll71/g;", "getVSRoomLog", "Ll71/f;", "getOpenPlatformAnchorService", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMsgWindowProxyService extends IService {
    a getDSGuideUtils();

    b getDSLContainerDynamicProxy();

    c getExternalBrowserService();

    d getLiveRoomBackendUtils();

    e getLiveRoomEventParamUtils();

    f getOpenPlatformAnchorService();

    g getVSRoomLog();
}
