package com.bytedance.android.live.service;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.profile.api.IProfileService;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget;
import com.bytedance.android.live.profile.servicewidget.f;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import j70.h;
import java.util.ArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.m0;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J0\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/service/ProfileService;", "Lcom/bytedance/android/live/profile/api/IProfileService;", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "Lns0/a;", "createProfileOuterContext", "Lj70/h;", "Lh70/b;", "getProfileServiceWidgetDescriptor", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "getLiveProfileJsFactory", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getProfileServiceWidget", "Landroidx/fragment/app/FragmentActivity;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "onWidgetLoaded", "", "openStatus", "isBeforeLive", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/base/model/user/r0;", "uploadAnchorStickerStatus", "", "anchorId", "anchorSecUid", "scene", "queryAnchorStickerStatus", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileService implements IProfileService {
    @Override // com.bytedance.android.live.profile.api.IProfileService
    public IJsMethodsProvideService.IFactory getLiveProfileJsFactory() {
        return new ws0.b();
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public Widget getProfileServiceWidget() {
        return new ProfileServiceWidget();
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public h<? extends h70.b> getProfileServiceWidgetDescriptor() {
        return new f();
    }

    public ProfileService() {
        k.l(IProfileService.class, this);
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public ns0.a createProfileOuterContext(o r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        return new ProfileOuterContext(r100);
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public void onWidgetLoaded(FragmentActivity r100) {
        if (ProfilePreInflateUtil.a() == true) goto L6;
        return;
    L6:
        if (r100 != null) goto L9;
        ALogger.e("NewUserProfile_PreLayout", "ProfileService onWidgetLoaded context is null");
        return;
    L9:
        m0 r101 = m0.f539067a;
        Integer r102 = r101.getValue();
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L18;
        ALogger.i("NewUserProfile_PreLayout", "ProfileService onWidgetLoaded isFullPreInflate");
        ProfilePreInflateUtil.d(r100, ArraysKt.toList(ProfilePreInflateViewInfo.values()));
        return;
    L18:
        Integer r106 = r101.getValue();
        if (r106 != null) goto L22;
    L24:
        r103 = false;
    L25:
        if (r103 == false) goto L38;
        ALogger.i("NewUserProfile_PreLayout", "ProfileService onWidgetLoaded isLazyPreInflate");
        ProfilePreInflateViewInfo[] r107 = ProfilePreInflateViewInfo.values();
        ArrayList r108 = new ArrayList();
        int r109 = r107.length;
    L27:
        if (r104 >= r109) goto L32;
        ProfilePreInflateViewInfo r110 = r107[r104];
        if (r110.getUsed() == false) goto L31;
        r108.add(r110);
    L31:
        r104 = r104 + 1;
        goto L27
    L32:
        ProfilePreInflateUtil.d(r100, r108);
        return;
    L38:
        return;
    L22:
        if (r106.intValue() != 2) goto L24;
    L13:
        if (r102.intValue() != 1) goto L15;
        r105 = true;
        goto L16
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public Single<e<r0>> uploadAnchorStickerStatus(boolean r110, boolean r111) {
        IMiddlewareUserService r100 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L20;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
        if (r101 == null) goto L21;
        String r102 = r101.n();
        if (r102 == null) goto L23;
        if (r110 == false) goto L11;
        long r103 = 1;
    L12:
        long r104 = r103;
        if (r111 == false) goto L15;
        String r105 = "start_live";
    L16:
        NewProfileApi r106 = (NewProfileApi) c.b().e(NewProfileApi.class);
        if (r106 != null) goto L19;
        return null;
    L19:
        return r106.uploadAnchorStickerStatusForSaas(r102, 1, r104, r105);
    L15:
        r105 = null;
        goto L16
    L11:
        r103 = 2;
        goto L12
    L23:
        return null;
    L21:
        return null;
    L20:
        return null;
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public Single<e<r0>> queryAnchorStickerStatus(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        Intrinsics.checkNotNullParameter(r101, "anchorSecUid");
        NewProfileApi r103 = (NewProfileApi) c.b().e(NewProfileApi.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.queryAnchorStickerStatusForSaas(r100, r100, r102);
    }
}
