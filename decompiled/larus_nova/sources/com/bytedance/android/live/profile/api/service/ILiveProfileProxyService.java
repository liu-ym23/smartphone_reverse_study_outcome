package com.bytedance.android.live.profile.api.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import qs0.b;
import qs0.c;
import qs0.d;
import qs0.e;
import qs0.f;
import qs0.g;
import qs0.h;
import qs0.i;
import qs0.j;
import qs0.k;
import qs0.l;
import qs0.m;
import qs0.n;
import qs0.o;
import qs0.q;
import qs0.r;
import qs0.s;
import qs0.t;
import qs0.u;
import qs0.v;
import qs0.w;
import qs0.x;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.service.LiveProfileProxyService")
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u001aH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\b\u0010!\u001a\u00020 H&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J8\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\u0016\u0010)\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"0(H&J\n\u0010-\u001a\u0004\u0018\u00010,H&J\b\u0010/\u001a\u00020.H&J\n\u00101\u001a\u0004\u0018\u000100H&J\b\u00103\u001a\u000202H&J\b\u00105\u001a\u000204H&J\b\u00107\u001a\u000206H&J\b\u00109\u001a\u000208H&J\u0016\u0010=\u001a\u00020<2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020*0:H&J\b\u0010>\u001a\u00020$H&J\b\u0010@\u001a\u00020?H&J\n\u0010B\u001a\u0004\u0018\u00010AH&¨\u0006C"}, d2 = {"Lcom/bytedance/android/live/profile/api/service/ILiveProfileProxyService;", "Lcom/bytedance/android/live/base/IService;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clz", "getTestHttpClientService", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lqs0/u;", "getIPkAudienceLinkOutServiceProxy", "Lqs0/i;", "getIInteractService", "Lqs0/v;", "getRoomServiceProxy", "Lqs0/o;", "getLiveSdkLogUtil", "Lqs0/s;", "getIMicRoomService", "Lqs0/x;", "getVrUtils", "Lqs0/k;", "getLinkPlayerState", "Lqs0/n;", "getLiveRoomEventParamUtils", "Lqs0/q;", "getILiveVideoFloatWindowService", "Lqs0/m;", "getILiveOntologyInfoManager", "Lqs0/r;", "getIMediaLinkOutService", "Lqs0/d;", "getIBroadcastService", "Lqs0/l;", "getLiveCommonConstants", "", "getPlayerUgcRoomUser", "", "isV1", "event", "label", "", "extra", "", "hsLiveAdMocServiceLogEvent", "Lqs0/b;", "getAudienceGameContext", "Lqs0/f;", "getIHostGameCP", "Lqs0/h;", "getInteractLogUtils", "Lqs0/c;", "getBackToRoomDataUtils", "Lqs0/j;", "getIKtvService", "Lqs0/e;", "getIHostCommerceServiceLive", "Lqs0/g;", "getIHostLiveLocalLife", "Lkotlin/Function0;", "action", "Lio/reactivex/disposables/Disposable;", "registerLiveEventEnd", "isShelfInfoNotNull", "Lqs0/t;", "getMultiAnchorOutService", "Lqs0/w;", "getSaaSAdapterService", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveProfileProxyService extends IService {
    b getAudienceGameContext();

    c getBackToRoomDataUtils();

    d getIBroadcastService();

    e getIHostCommerceServiceLive();

    f getIHostGameCP();

    g getIHostLiveLocalLife();

    i getIInteractService();

    j getIKtvService();

    m getILiveOntologyInfoManager();

    q getILiveVideoFloatWindowService();

    r getIMediaLinkOutService();

    s getIMicRoomService();

    u getIPkAudienceLinkOutServiceProxy();

    h getInteractLogUtils();

    k getLinkPlayerState();

    l getLiveCommonConstants();

    n getLiveRoomEventParamUtils();

    o getLiveSdkLogUtil();

    t getMultiAnchorOutService();

    String getPlayerUgcRoomUser();

    v getRoomServiceProxy();

    w getSaaSAdapterService();

    <T> T getTestHttpClientService(Class<T> r100);

    x getVrUtils();

    void hsLiveAdMocServiceLogEvent(boolean r100, String r101, String r102, Map<String, String> r103);

    boolean isShelfInfoNotNull();

    Disposable registerLiveEventEnd(Function0<Unit> r100);
}
