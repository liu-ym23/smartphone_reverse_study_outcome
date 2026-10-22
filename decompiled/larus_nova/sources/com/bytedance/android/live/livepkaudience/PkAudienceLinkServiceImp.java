package com.bytedance.android.live.livepkaudience;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.o;
import com.bytedance.android.live.livepkaudience.base.p;
import com.bytedance.android.live.livepkaudience.base.x;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.live.livepkaudience.base.z;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.service.d;
import com.bytedance.android.live.livepkaudience.service.e;
import com.bytedance.android.live.livepkaudience.service.f;
import com.bytedance.android.live.livepkaudience.widget.LinkPkInteractControlWidget;
import com.bytedance.android.live.pkaudience.api.BasePkInteractControlWidget;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import hh1.v0;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m00.g;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000Õ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001s\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\u0016\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u001c\u0010'\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\b\u0001\u0010%\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J2\u0010/\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020)H\u0016J\"\u00102\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u00020\rH\u0016J(\u00107\u001a\u00020\u000b2\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020$H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\u0010\u0010<\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\rH\u0016J\n\u0010>\u001a\u0004\u0018\u00010=H\u0016J\b\u0010?\u001a\u00020\u0002H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0016J\n\u0010B\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010F\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020GH\u0016J\b\u0010J\u001a\u00020\u000bH\u0016J\n\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010M\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010N\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010O\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010Q\u001a\u00020\u00022\b\u0010P\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010S\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010RH\u0016J\b\u0010T\u001a\u00020\u0002H\u0016J\u0010\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020$H\u0016J\b\u0010W\u001a\u00020\rH\u0016J\b\u0010X\u001a\u00020\rH\u0016J<\u0010a\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u00022\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010]\u001a\u00020)2\u0014\u0010`\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0016J\b\u0010b\u001a\u00020\u000bH\u0016J\u0010\u0010c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004H\u0016J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010d\u001a\u00020\u0002H\u0016J5\u0010m\u001a\u00060kj\u0002`l2'\u0010j\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(i\u0012\u0004\u0012\u00020\u000b0fH\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\b\u0010o\u001a\u00020\u000bH\u0016R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020p0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006x"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/PkAudienceLinkServiceImp;", "Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "", "isAnchor", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/LinkPlayerInfo;", "getOnlineUserListInInteractAudience", "Lcom/bytedance/android/live/livepkaudience/base/i;", "getPkLinkUserInfoCenter", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "user", "", "permit", "", "interactId", "isMuteRemoteAudio", "isSwitching", "markSwitchToMulti", "tryLoadPkAudienceWidget", "tryUnLoadPkAudienceWidget", "Lcom/bytedance/android/live/pkaudience/api/d;", "getPkAudienceLogData", "isInSelfAnchorLink", "getPkGuestLynxData", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "newObserver", "registerPkGuestLynxDataObserver", "unRegisterPkGuestLynxDataObserver", "resetLinkData", "Lcom/bytedance/android/live/pkaudience/api/b;", "listener", "addPkGuestListener", "onFirstRemoteVideoSend", "isLinkAudience", "Lhh1/v0;", "liveVideoClientFactory", "", "containerId", "Lcom/bytedance/android/live/pkaudience/api/BasePkInteractControlWidget;", "createRevPkAudienceControlWidget", "isRealHasAudienceBeforePk", "", "roomId", "uid", "secUid", "layout", "msgBoardItemId", "invite", "revSecUid", "reqFrom", "kickOut", "linkType", "applySource", "fromSource", "applyType", e1.REPLY_ACTION_APPLY, "cancelApply", "reason", "disconnect", "hideInteractDialog", "finishInteract", "Lei6/a;", "getGuestRtcClient", "isRtcEngineOn", "Lgd0/x;", "createRevRtcData", "getLiveVideoClientFactory", "revRtcData", "", "videoClientFactory", "setRevGuestManagerData", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "content", "setLinkerContentMap", "showInviteAndPermitDialog", "Lm00/g;", "getGuestLinkViewNew", "isNotSelfGuestByIId", "isSelfGuestByIId", "isSelfGuestByUid", "userId", "isNotSelfGuestByUid", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "isUserInInteractAudience", "handleInteractClick", "mode", "unLoadOtherWidget", "getGuestAnchorLinkMicId", "getSelfAnchorLinkMicId", "isSilence", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "switchAudioByClient", "kickOutAllGuest", "getAllOwnGuestUidList", "isLeft", "getSelfOnlineUserList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlineList", "onChange", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "registerOnlineListChange", "onPKInteractBizStart", "onPKInteractBizEnd", "Lcom/bytedance/android/live/livepkaudience/base/z;", "infoCenterCallbacks", "Ljava/util/List;", "com/bytedance/android/live/livepkaudience/PkAudienceLinkServiceImp$b", "infoCenterCallback", "Lcom/bytedance/android/live/livepkaudience/PkAudienceLinkServiceImp$b;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PkAudienceLinkServiceImp implements IPkAudienceLinkOutService {
    private final b infoCenterCallback;
    private final List<z> infoCenterCallbacks;

    public static final class a extends x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.pkaudience.api.b f81371a;

        public a(com.bytedance.android.live.pkaudience.api.b r100) {
            this.f81371a = r100;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
        public final void onPermitSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            Intrinsics.checkNotNullParameter(r100, "uid");
            com.bytedance.android.live.pkaudience.api.b r101 = this.f81371a;
            if (r101 == null) goto L6;
            r101.onPermitSuccess(r100);
            return;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
        public final void l(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            Intrinsics.checkNotNullParameter(r100, "uid");
            com.bytedance.android.live.pkaudience.api.b r102 = this.f81371a;
            if (r102 == null) goto L6;
            r102.l(r100, r101);
            return;
        }
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkAudienceLinkServiceImp f81372a;

        public b(PkAudienceLinkServiceImp r100) {
            this.f81372a = r100;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r100) {
            Iterator r101 = PkAudienceLinkServiceImp.access$getInfoCenterCallbacks$p(this.f81372a).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((z) r101.next()).onOnlineListChanged(r100);
            goto L4
        }
    }

    public static final class c extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f81373a;

        public c(Function1 r100) {
            this.f81373a = r100;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r100) {
            Function1 r101 = this.f81373a;
            if (r100 != null) goto L5;
            r100 = CollectionsKt.emptyList();
        L5:
            r101.invoke(r100);
        }
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void cancelApply() {
        d.f82252x0.getClass();
        d r100 = d.a.a();
        if (r100 == null) goto L6;
        r100.cancelApply();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public gd0.x createRevRtcData() {
        com.bytedance.android.live.livepkaudience.rtc.c.f82214t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r100 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.createRtcData();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public List<String> getAllOwnGuestUidList() {
        ArrayList r100 = new ArrayList();
        i r101 = getPkLinkUserInfoCenter();
        if (r101 == null) goto L18;
        CopyOnWriteArrayList<LinkPlayerInfo> r102 = r101.f81417c;
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        IBaseUser r104 = ((LinkPlayerInfo) r103.next()).getUser();
        if (r104 == null) goto L8;
        String r105 = r104.getIdString();
        if (r105 == null) goto L8;
        if (q0.a(r105) == false) goto L8;
        if (isSelfGuestByUid(r105) == false) goto L8;
        r100.add(r105);
    L18:
        return r100;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getGuestAnchorLinkMicId() {
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r100 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r100 == null) goto L6;
        String r101 = r100.getGuestAnchorLinkMicId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public g getGuestLinkViewNew() {
        d.f82252x0.getClass();
        d r100 = d.a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getGuestLinkViewNew();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public ei6.a getGuestRtcClient() {
        f.f82256z0.getClass();
        f r100 = f.a.a();
        if (r100 == null) goto L7;
        com.bytedance.android.live.livepkaudience.rtc.a r101 = r100.P2();
        if (r101 == null) goto L7;
        return r101.f82177a;
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public v0 getLiveVideoClientFactory() {
        com.bytedance.android.live.livepkaudience.rtc.c.f82214t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r100 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveVideoClientFactory();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public com.bytedance.android.live.pkaudience.api.d getPkAudienceLogData() {
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r100 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkAudienceLogData();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getPkGuestLynxData() {
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r100 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r100 == null) goto L8;
        MutableLiveData<String> r101 = r100.getGuestLynxListData();
        if (r101 == null) goto L8;
        String r102 = r101.getValue();
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public i getPkLinkUserInfoCenter() {
        if (v.a(((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getControlService().getCurrentMode(), 4) == false) goto L17;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.b.a.a() == null) goto L10;
        com.bytedance.android.live.livepkaudience.service.b r100 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r100 != null) goto L9;
        return null;
    L9:
        return r100.getLinkUserCenter();
    L10:
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.a.C1255a.a() == null) goto L18;
        com.bytedance.android.live.livepkaudience.service.a r101 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r101 != null) goto L15;
        return null;
    L15:
        return r101.getLinkUserCenter();
    L18:
        return null;
    L17:
        return null;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public String getSelfAnchorLinkMicId() {
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r100 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r100 == null) goto L6;
        String r101 = r100.getSelfAnchorLinkMicId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean handleInteractClick() {
        e.f82254y0.getClass();
        e r100 = e.a.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.handleInteractClick();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void hideInteractDialog() {
        e.f82254y0.getClass();
        e r100 = e.a.a();
        if (r100 == null) goto L6;
        r100.hideInteractDialog();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isInSelfAnchorLink() {
        IUserService r100 = (IUserService) k.f(IUserService.class);
        Boolean r101 = null;
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.user.f r102 = r100.user();
        if (r102 == null) goto L7;
        String r103 = r102.n();
    L8:
        if (r103 != null) goto L10;
    L26:
        return false;
    L10:
        if (q0.a(r103) != true) goto L26;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L26;
        com.bytedance.live.datacontext.i<Boolean> r105 = r104.isAnchor();
        if (r105 == null) goto L26;
        if (r105.getValue().booleanValue() == true) goto L26;
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r106 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r106 == null) goto L22;
        r101 = r106.hasAudienceJoinSelfAnchorLink();
    L22:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L26;
        if (isSelfGuestByUid(r103) == false) goto L26;
        return true;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isLinkAudience() {
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        if (com.bytedance.android.live.livepkaudience.service.b.a.a() == null) goto L11;
        com.bytedance.android.live.livepkaudience.service.b r100 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r100 == null) goto L7;
        int r101 = r100.H();
    L8:
        if (r101 <= 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = 0;
        goto L8
    L11:
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isRealHasAudienceBeforePk() {
        e.f82254y0.getClass();
        e r100 = e.a.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getSelfHasAudienceBeforePk();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isRtcEngineOn() {
        com.bytedance.android.live.livepkaudience.rtc.c.f82214t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r100 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isRtcEngineOn();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onFirstRemoteVideoSend() {
        d.f82252x0.getClass();
        d r100 = d.a.a();
        if (r100 == null) goto L6;
        r100.onFirstRemoteVideoSend();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onPKInteractBizEnd() {
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r100 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r100 == null) goto L6;
        i r101 = r100.getLinkUserCenter();
        if (r101 == null) goto L6;
    L10:
        if (r101 == null) goto L13;
        r101.J(this.infoCenterCallback);
        return;
    L13:
        return;
    L6:
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r102 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r102 == null) goto L9;
        r101 = r102.getLinkUserCenter();
        goto L10
    L9:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void onPKInteractBizStart() {
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r100 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r100 == null) goto L6;
        i r101 = r100.getLinkUserCenter();
        if (r101 == null) goto L6;
    L10:
        if (r101 == null) goto L13;
        r101.c(this.infoCenterCallback);
        return;
    L13:
        return;
    L6:
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r102 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r102 == null) goto L9;
        r101 = r102.getLinkUserCenter();
        goto L10
    L9:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void resetLinkData() {
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r100 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r100 == null) goto L6;
        r100.resetLinkData();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void showInviteAndPermitDialog() {
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r100 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r100 == null) goto L6;
        r100.bf(false);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void tryLoadPkAudienceWidget() {
        e.f82254y0.getClass();
        e r100 = e.a.a();
        if (r100 == null) goto L6;
        r100.tryLoadPkAudienceWidget();
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void tryUnLoadPkAudienceWidget() {
        e.f82254y0.getClass();
        e r100 = e.a.a();
        if (r100 == null) goto L6;
        r100.tryUnLoadPkAudienceWidget();
        return;
    }

    public PkAudienceLinkServiceImp() {
        this.infoCenterCallbacks = new ArrayList();
        this.infoCenterCallback = new b(this);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void kickOutAllGuest() {
        i r100 = getPkLinkUserInfoCenter();
        if (r100 == null) goto L25;
        CopyOnWriteArrayList<LinkPlayerInfo> r101 = r100.f81417c;
        if (r101 == null) goto L41;
        Iterator<LinkPlayerInfo> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L42;
        LinkPlayerInfo r103 = r102.next();
        IBaseUser r104 = r103.getUser();
        if (r104 == null) goto L12;
        String r105 = r104.getIdString();
    L13:
        if (r105 == null) goto L8;
        if (q0.a(r105) != true) goto L8;
        if (isSelfGuestByUid(r105) == false) goto L8;
        IBaseUser r106 = r103.getUser();
        if (r106 == null) goto L8;
        Intrinsics.checkNotNullParameter(r106, "$this$secUidExt");
        String r107 = r106.getCastSecUid();
        if (r107 == null) goto L8;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r108 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r108 == null) goto L8;
        com.bytedance.android.live.livepkaudience.service.b.C1256b.a(r108, r105, r107);
        goto L8
    L12:
        r105 = null;
        goto L13
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public /* bridge */ /* synthetic */ Object getGuestLinkViewNew() {
        return getGuestLinkViewNew();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public /* bridge */ /* synthetic */ Object getLiveVideoClientFactory() {
        return getLiveVideoClientFactory();
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public /* bridge */ /* synthetic */ com.bytedance.android.live.pkaudience.api.a getPkLinkUserInfoCenter() {
        return getPkLinkUserInfoCenter();
    }

    public static final /* synthetic */ List access$getInfoCenterCallbacks$p(PkAudienceLinkServiceImp r100) {
        return r100.infoCenterCallbacks;
    }

    private final List<LinkPlayerInfo> getOnlineUserListInInteractAudience(boolean r100) {
        if (r100 == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r101 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r101 == null) goto L10;
        i r102 = r101.getLinkUserCenter();
    L11:
        if (r102 != null) goto L13;
        return null;
    L13:
        if (Lists.isEmpty(r102.f81417c) == false) goto L15;
        return null;
    L15:
        return r102.f81417c;
    L10:
        r102 = null;
        goto L11
    L7:
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r103 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r103 == null) goto L10;
        r102 = r103.getLinkUserCenter();
        goto L11
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void addPkGuestListener(com.bytedance.android.live.pkaudience.api.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r102 = r101.isAnchor();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        boolean r105 = ((IUserService) k.n(IUserService.class)).user().c();
        a r106 = new a((com.bytedance.android.live.pkaudience.api.b) WeakReferenceWrapper.wrap(r100));
        if (r104 == false) goto L17;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r107 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r107 == null) goto L24;
        p r108 = r107.X4();
        if (r108 == null) goto L25;
        r108.a(r106);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        if (r105 == false) goto L27;
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r109 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r109 == null) goto L28;
        o r110 = r109.A0();
        if (r110 == null) goto L29;
        r110.a(r106);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L9:
        r104 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void disconnect(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        d.f82252x0.getClass();
        d r101 = d.a.a();
        if (r101 == null) goto L6;
        r101.disconnect(r100);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void finishInteract(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reqFrom");
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r101 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r101 == null) goto L6;
        r101.finishInteract(r100);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public List<ILinkPlayerInfoBridge> getSelfOnlineUserList(boolean r100) {
        ArrayList r101 = new ArrayList();
        i r102 = getPkLinkUserInfoCenter();
        if (r100 == false) goto L6;
        if (r102 == null) goto L8;
        CopyOnWriteArrayList<LinkPlayerInfo> r103 = r102.f81417c;
    L9:
        if (r103 == null) goto L44;
        Iterator<T> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L44;
        LinkPlayerInfo r105 = (LinkPlayerInfo) r104.next();
        if (r100 != true) goto L32;
        o0.a r106 = o0.f58946a;
        IBaseUser r107 = r105.getUser();
        if (r107 == null) goto L18;
        String r108 = r107.getIdString();
    L19:
        com.bytedance.android.livesdk.chatroom.o r109 = o3.f();
        if (r109 == null) goto L26;
        m<IRoom> r110 = r109.getRoom();
        if (r110 == null) goto L26;
        IRoom r111 = r110.getValue();
        if (r111 == null) goto L26;
        String r112 = r111.getOwnerUserIdString();
    L27:
        r106.getClass();
        if (o0.a.a(r108, r112) == true) goto L32;
        if (isSelfGuestByIId(r105.getInteractId()) == false) goto L32;
        r101.add(r105);
    L26:
        r112 = null;
        goto L27
    L18:
        r108 = null;
    L32:
        if (r100 == true) goto L12;
        o0.a r113 = o0.f58946a;
        if (getPkLinkUserInfoCenter() == null) goto L36;
        String r114 = i.j();
    L37:
        IBaseUser r115 = r105.getUser();
        if (r115 == null) goto L40;
        String r116 = r115.getIdString();
    L41:
        r113.getClass();
        if (o0.a.a(r114, r116) == true) goto L12;
        r101.add(r105);
        goto L12
    L40:
        r116 = null;
        goto L41
    L36:
        r114 = null;
    L44:
        return r101;
    L8:
        r103 = null;
        goto L9
    L6:
        if (r102 == null) goto L8;
        r103 = r102.f81418d;
        goto L9
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isMuteRemoteAudio(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        f.f82256z0.getClass();
        f r101 = f.a.a();
        if (r101 == null) goto L7;
        com.bytedance.android.live.livepkaudience.rtc.a r102 = r101.P2();
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r100, "interactId");
        return r102.f82196t.contains(r100);
    L7:
        return false;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isNotSelfGuestByIId(String r100) {
        i r101 = getPkLinkUserInfoCenter();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.v(r100);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isNotSelfGuestByUid(String r100) {
        i r101 = getPkLinkUserInfoCenter();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.w(r100);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isSelfGuestByIId(String r100) {
        i r101 = getPkLinkUserInfoCenter();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.z(r100);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isSelfGuestByUid(String r100) {
        i r101 = getPkLinkUserInfoCenter();
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.A(r100);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void markSwitchToMulti(boolean r100) {
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r101 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r101 == null) goto L6;
        r101.markSwitchToMulti(r100);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void permit(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r102 = r101.isAnchor();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        boolean r105 = ((IUserService) k.n(IUserService.class)).user().c();
        if (r104 == false) goto L17;
        IBaseUser r106 = r100.getUser();
        if (r106 == null) goto L22;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r107 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r107 == null) goto L23;
        r107.Fl((User) r106);
        return;
    L23:
        return;
    L22:
        return;
    L17:
        if (r105 == false) goto L25;
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r108 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r108 == null) goto L26;
        r108.wi((LinkPlayerInfo) r100);
        return;
    L26:
        return;
    L25:
        return;
    L9:
        r104 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public Disposable registerOnlineListChange(Function1<? super List<? extends ILinkPlayerInfoBridge>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onChange");
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r101 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r101 != null) goto L5;
    L6:
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r102 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r102 == null) goto L9;
        r102.getLinkUserCenter();
    L9:
        final c r103 = new c(r100);
        this.infoCenterCallbacks.add(r103);
        int r104 = h.f267513a;
        return h.a(new AnonymousClass1(this, r103));
    L5:
        if (r101.getLinkUserCenter() != null) goto L9;
        goto L6
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void registerPkGuestLynxDataObserver(Observer<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "newObserver");
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r101 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r101 == null) goto L8;
        MutableLiveData<String> r102 = r101.getGuestLynxListData();
        if (r102 == null) goto L9;
        r102.observeForever(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void setLinkerContentMap(ILinkerBattleConnectContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        com.bytedance.android.live.livepkaudience.rtc.c.f82214t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r101 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r101 == null) goto L6;
        r101.I7((LinkerBattleConnectContent) r100);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void unLoadOtherWidget(int r100) {
        e.f82254y0.getClass();
        e r101 = e.a.a();
        if (r101 == null) goto L6;
        r101.unLoadOtherWidget(r100);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void unRegisterPkGuestLynxDataObserver(Observer<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "newObserver");
        com.bytedance.android.live.livepkaudience.service.c.f82250w0.getClass();
        LinkPkInteractGuestDataContext r101 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r101 == null) goto L8;
        MutableLiveData<String> r102 = r101.getGuestLynxListData();
        if (r102 == null) goto L9;
        r102.removeObserver(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public BasePkInteractControlWidget createRevPkAudienceControlWidget(v0 r100, int r101) {
        return new LinkPkInteractControlWidget(r100, r101);
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public boolean isUserInInteractAudience(boolean r100, IBaseUser r101) {
        List<LinkPlayerInfo> r102 = getOnlineUserListInInteractAudience(r100);
        if (r101 != null) goto L5;
    L24:
        return false;
    L5:
        if (Lists.isEmpty(r102) == true) goto L24;
        if (r102 == null) goto L24;
        Iterator<LinkPlayerInfo> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L24;
        LinkPlayerInfo r104 = r103.next();
        if (r104 == null) goto L14;
        IBaseUser r105 = r104.getUser();
    L15:
        if (r105 == null) goto L10;
        IBaseUser r106 = r104.getUser();
        if (r106 == null) goto L10;
        String r107 = r106.getIdString();
        if (r107 == null) goto L10;
        if (d5.c(r107) != d5.c(r101.getIdString())) goto L10;
        return true;
    L14:
        r105 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void setRevGuestManagerData(gd0.x r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "revRtcData");
        if ((r101 instanceof v0) == true) goto L5;
        r101 = null;
    L5:
        v0 r102 = (v0) r101;
        com.bytedance.android.live.livepkaudience.rtc.c.f82214t0.getClass();
        com.bytedance.android.live.livepkaudience.rtc.c r103 = com.bytedance.android.live.livepkaudience.rtc.c.a.a();
        if (r103 == null) goto L9;
        r103.rd(r100, r102);
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void kickOut(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r102, "reqFrom");
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L9;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        boolean r107 = ((IUserService) k.n(IUserService.class)).user().c();
        if (r106 == false) goto L15;
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r108 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r108 == null) goto L20;
        r108.kickOut(r100, r101, r102);
        return;
    L20:
        return;
    L15:
        if (r107 == false) goto L22;
        com.bytedance.android.live.livepkaudience.service.a.f82246u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r109 = com.bytedance.android.live.livepkaudience.service.a.C1255a.a();
        if (r109 == null) goto L23;
        r109.kickOut(r100, r101, r102);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r106 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void apply(int r100, int r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "fromSource");
        d.f82252x0.getClass();
        d r104 = d.a.a();
        if (r104 == null) goto L6;
        r104.c2(r100, r101, r102, com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r103));
        return;
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void switchAudioByClient(boolean r100, List<com.bytedance.android.livesdk.link.model.bridge.k> r101, long r110, Map<Long, ? extends g2> r111) {
        Intrinsics.checkNotNullParameter(r101, "data");
        d.f82252x0.getClass();
        d r102 = d.a.a();
        if (r102 == null) goto L14;
        List<AnchorLinkUser> r103 = jm2.a.a(r101);
        if (r111 == null) goto L10;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r111.size()));
        Iterator<T> r112 = r111.entrySet().iterator();
    L8:
        if (r112.hasNext() == false) goto L11;
        Map.Entry r105 = (Map.Entry) r112.next();
        r104.put(r105.getKey(), (RoomLinkerContent) jm2.a.d((vh7.c) r105.getValue()));
    L11:
        r102.switchAudioByClient(r100, r103, r110, r104);
        return;
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService
    public void invite(long r110, String r111, String r112, int r113, long r114) {
        Intrinsics.checkNotNullParameter(r111, "uid");
        com.bytedance.android.live.livepkaudience.service.b.f82248v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r100 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r100 == null) goto L9;
        if (r112 != null) goto L6;
        String r101 = "";
    L7:
        r100.invite(r110, r111, r101, r113, r114);
        return;
    L6:
        r101 = r112;
        goto L7
    }
}
