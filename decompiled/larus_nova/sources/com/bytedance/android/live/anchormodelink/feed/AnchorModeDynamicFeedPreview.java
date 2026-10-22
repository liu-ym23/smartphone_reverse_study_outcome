package com.bytedance.android.live.anchormodelink.feed;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.anchormodelink.util.JsbParamParseUtil;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.jsbridge.method.l0;
import com.bytedance.android.live.liveinteract.jsbridge.method.s;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.AnchorModeParseSeiData;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.scope.j;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ly.h;
import ly.u;
import ny.o;
import ny.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u000fJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/feed/AnchorModeDynamicFeedPreview;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/anchormodelink/feed/b;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/b;", "", "getFeedViewName", "", "getMicSeatRvViewId", "Lcom/google/gson/JsonObject;", "getLinkmicAreaFrameInfo", "getLinkmicSeatListInfo", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorModeDynamicFeedPreview extends FrameLayout implements com.bytedance.android.live.anchormodelink.feed.b, LifecycleOwnerCompat, ViewModelStoreOwnerCompat, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f58579r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPreviewMultiLinkOuterConfigProvider f58580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.anchormodelink.feed.c f58581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f58583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LifecycleRegistry f58584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewModelStore f58585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewModelProvider f58586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DataCenter f58587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<iy.e> f58588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.anchormodelink.handlers.d f58589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public oy.c f58590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f58591l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f58592m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f58593n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f58594o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AnchorModeParseSeiData f58595p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j f58596q;

    public static final class a {
    }

    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModeDynamicFeedPreview f58597a;

        @Override // ly.u
        public final LivePlayerView R8() {
            IPreviewMultiLinkOuterConfigProvider r100 = this.f58597a.f58580a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r100.getLivePlayerView();
        }

        @Override // ly.u
        public final IRoom getRoom() {
            IPreviewMultiLinkOuterConfigProvider r100 = this.f58597a.f58580a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r100.getRoom();
        }

        @Override // ly.u
        public final IBaseUser getUser() {
            return ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().b();
        }

        @Override // ly.u
        public final String n6() {
            IPreviewMultiLinkOuterConfigProvider r100 = this.f58597a.f58580a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r100.getEnterFromMerge();
        }

        public b(AnchorModeDynamicFeedPreview r100) {
            this.f58597a = r100;
        }
    }

    public static final class c implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModeDynamicFeedPreview f58598a;

        public c(AnchorModeDynamicFeedPreview r100) {
            this.f58598a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.jsbridge.method.s
        public final JsonObject C(my.b r100) {
            Intrinsics.checkNotNullParameter(r100, "getStatusData");
            boolean r101 = iy.b.f496463a;
            iy.b.e("AnchorModeDynamicFeedPreview", "getLinkMicStatus type=" + r100.getType());
            List<iy.e> r102 = this.f58598a.f58588i;
            if (r102 == null) goto L11;
            Iterator r103 = ((ArrayList) r102).iterator();
        L6:
            if (r103.hasNext() == false) goto L16;
            iy.e r104 = (iy.e) r103.next();
            if (r104.c(r100.getType()) == false) goto L6;
            return r104.C(r100);
        L16:
            return null;
        L11:
            return null;
        }

        @Override // com.bytedance.android.live.liveinteract.jsbridge.method.s
        public final void P0(my.c r100, com.bytedance.android.live.liveinteract.jsbridge.method.k r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "updateStatus");
            Intrinsics.checkNotNullParameter(r101, "updateCallback");
            boolean r103 = iy.b.f496463a;
            iy.b.e("AnchorModeDynamicFeedPreview", "updateLinkMicStatus type=" + r100.getType() + " extra=" + r100.f516353b);
            List<iy.e> r104 = this.f58598a.f58588i;
            if (r104 == null) goto L10;
            Iterator r105 = ((ArrayList) r104).iterator();
        L6:
            if (r105.hasNext() == false) goto L16;
            iy.e r106 = (iy.e) r105.next();
            if (r106.a(r100.getType()) == false) goto L6;
            r106.b(r100, r101);
            goto L6
        L16:
            return;
        }
    }

    public static final class d implements iy.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModeDynamicFeedPreview f58599a;

        @Override // iy.h
        public final ApiServerException B4(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errMsg");
            return null;
        }

        @Override // iy.h
        public final boolean C4() {
            return false;
        }

        @Override // iy.h
        public final void Q1() {
        }

        @Override // iy.h
        public final String d() {
            return "";
        }

        @Override // iy.h
        public final int g() {
            return 0;
        }

        @Override // iy.h
        public final void m4() {
        }

        @Override // iy.h
        public final void n4(Function0<Unit> r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "success");
            Intrinsics.checkNotNullParameter(r101, "failed");
        }

        @Override // iy.h
        public final void o4(t r100, ei6.a r101) {
        }

        @Override // iy.h
        public final Object q4() {
            return null;
        }

        @Override // iy.h
        public final l r4() {
            return null;
        }

        @Override // iy.h
        public final boolean v4() {
            return false;
        }

        @Override // iy.h
        public final Integer O0() {
            return Integer.valueOf(this.f58599a.f58594o);
        }

        public final com.bytedance.android.live.anchormodelink.handlers.d a() {
            h r100 = this.f58599a.f58583d;
            if (r100 == null) goto L8;
            ly.t r101 = r100.f511257j;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.f511284a;
        L8:
            return null;
        }

        @Override // iy.h
        public Context getContext() {
            IPreviewMultiLinkOuterConfigProvider r100 = this.f58599a.f58580a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r100.getContext();
        }

        @Override // iy.h
        public final IRoomBase getRoom() {
            IPreviewMultiLinkOuterConfigProvider r100 = this.f58599a.f58580a;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
        L6:
            return r100.getRoom();
        }

        @Override // iy.h
        public final void p4() {
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
        }

        @Override // iy.h
        public final boolean t4() {
            return ((Boolean) vm2.d.f555826f.getValue(null, vm2.d.f555776a[4])).booleanValue();
        }

        @Override // iy.h
        public final void x4() {
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
            Intrinsics.checkNotNullParameter("Jsb invoke", "string");
        }

        @Override // iy.h
        public final long y4() {
            boolean r100 = ky.a.f506618a;
            return vm2.d.c0().getTalkingStateInterval();
        }

        public d(AnchorModeDynamicFeedPreview r100) {
            this.f58599a = r100;
        }

        @Override // iy.h
        public final void A4(JsonObject r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            if (this.f58599a.f58582c != 5) goto L32;
            int r101 = JsbParamParseUtil.f58790a;
            Intrinsics.checkNotNullParameter(r100, "params");
            oy.c r102 = null;
            JsonElement r103 = r100.get("params");     // Catch: Exception -> L25
            if (r103 == null) goto L12;
            JsonObject r104 = r103.getAsJsonObject();     // Catch: Exception -> L25
            if (r104 == null) goto L12;
            JsonElement r105 = r104.get(RemoteMessageConst.TO);     // Catch: Exception -> L25
            if (r105 == null) goto L12;
            JsonObject r106 = r105.getAsJsonObject();     // Catch: Exception -> L25
        L13:
            if (r106 == null) goto L21;
            JsonElement r107 = r106.get("uiAttributes");     // Catch: Exception -> L25
            if (r107 == null) goto L21;
            JsonObject r108 = r107.getAsJsonObject();     // Catch: Exception -> L25
            if (r108 == null) goto L21;
            JsonElement r109 = r108.get("playerFrame");     // Catch: Exception -> L25
            if (r109 == null) goto L21;
            JsonObject r110 = r109.getAsJsonObject();     // Catch: Exception -> L25
        L22:
            if (r110 == null) goto L27;
            r102 = new oy.c(s1.e(r110.get("x").getAsFloat()), s1.e(r110.get("y").getAsFloat()), s1.e(r110.get("w").getAsFloat()), s1.e(r110.get("h").getAsFloat()));     // Catch: Exception -> L25
        L27:
            if (r102 == null) goto L33;
            AnchorModeDynamicFeedPreview r111 = this.f58599a;
            r111.f58590k = r102;
            r111.e(r102);
            return;
        L33:
            return;
        L21:
            r110 = null;
        L12:
            r106 = null;
        L25:
            e = move-exception;
            boolean r112 = iy.b.f496463a;
            iy.b.b("getSeatViewContainerConfig parseJson error: (cause:" + e.getCause() + " message:" + e.getMessage() + " stack: " + bytekn.foundation.utils.b.a(e, 3) + ')');
            goto L27
        }

        @Override // iy.h
        public final void s4(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "seiObj");
            h r101 = this.f58599a.f58583d;
            if (r101 == null) goto L10;
            Intrinsics.checkNotNullParameter(r100, "seiData");
            ly.t r102 = r101.f511257j;
            if (r102 == null) goto L11;
            ih0.c r103 = r102.f511287d;
            if (r103 == null) goto L12;
            r103.sendJsEvent("H5_sei", r100);
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // iy.h
        public final void w4(JsonObject r100) {
            Intrinsics.checkNotNullParameter("liveLinkCallBack", "eventName");
            h r101 = this.f58599a.f58583d;
            if (r101 == null) goto L6;
            r101.h("liveLinkCallBack", r100);
            return;
        }

        @Override // iy.h
        public final Object u4(String r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r101, "setupLiveLinkParams");
            Intrinsics.checkNotNullParameter(r100, "liveCoreSetting");
            Intrinsics.checkNotNullParameter(r101, "setupLiveLinkParams");
            return null;
        }

        @Override // iy.h
        public final void z4(ny.e r100, ec6.a r101, Function0 r102, Function0 r103) {
            Intrinsics.checkNotNullParameter(r102, "onConfirm");
            Intrinsics.checkNotNullParameter(r103, "onCancel");
            Intrinsics.checkNotNullParameter(r102, "onConfirm");
            Intrinsics.checkNotNullParameter(r103, "onCancel");
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModeDynamicFeedPreview f58600a;

        public e(AnchorModeDynamicFeedPreview r100) {
            this.f58600a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorModeDynamicFeedPreview r100 = this.f58600a;     // Catch: Throwable -> L4
            int r101 = AnchorModeDynamicFeedPreview.f58579r;     // Catch: Throwable -> L4
            r100.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModeDynamicFeedPreview f58601a;

        public f(AnchorModeDynamicFeedPreview r100) {
            this.f58601a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorModeDynamicFeedPreview r100 = this.f58601a;     // Catch: Throwable -> L4
            int r101 = AnchorModeDynamicFeedPreview.f58579r;     // Catch: Throwable -> L4
            r100.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean c() {
        return false;
    }

    public HashMap<String, Object> getChatRoomEnterRoomExtraParam() {
        return null;
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.b
    public String getFeedViewName() {
        return "AnchorModeDynamicFeedPreview";
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicAreaFrameInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public JsonObject getLinkmicSeatListInfo() {
        return null;
    }

    public int getMicSeatRvViewId() {
        return 0;
    }

    @Override // com.bytedance.android.live.anchormodelink.feed.b
    public View getViewCompat() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final int i() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final boolean k() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final Integer a() {
        return Integer.valueOf(this.f58594o);
    }

    public final void b() {
        com.bytedance.android.live.anchormodelink.feed.c r100 = this.f58581b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L6:
        if (r100.shouldUseNewLivePlayerLayout() == false) goto L8;
        return;
    L8:
        boolean r101 = iy.b.f496463a;
        StringBuilder r102 = new StringBuilder("adjustContainerAndRenderView from:");
        IPreviewMultiLinkOuterConfigProvider r103 = this.f58580a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        r102.append(r103.getShowFrom());
        r102.append(" uiLayout=");
        r102.append(this.f58594o);
        iy.b.e("AnchorModeDynamicFeedPreview", r102.toString());
        IPreviewMultiLinkOuterConfigProvider r104 = this.f58580a;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L15:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r104.getShowFrom()) == true) goto L57;
        IPreviewMultiLinkOuterConfigProvider r105 = this.f58580a;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L19:
        com.bytedance.android.live.liveinteract.utils.h.b(r105.getPlayerContainerAbility());
        com.bytedance.android.live.anchormodelink.feed.c r106 = this.f58581b;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L22:
        int r110 = r106.getContainerWidth();
        com.bytedance.android.live.anchormodelink.feed.c r107 = this.f58581b;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L25:
        int r111 = r107.l();
        IPreviewMultiLinkOuterConfigProvider r108 = this.f58580a;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L28:
        LivePlayerView r109 = r108.getLivePlayerView();
        ViewParent r112 = null;
        if (r109 == null) goto L31;
        IRenderView r113 = r109.getRenderView();
    L32:
        com.bytedance.android.live.anchormodelink.feed.c r114 = this.f58581b;
        if (r114 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L35:
        IInteractPlayView r115 = r114.n();
        oy.c r116 = this.f58590k;
        boolean r117 = ky.a.f506618a;
        if (vm2.d.c0().getSearchFeedPlayerAdjustOpt() == true) goto L38;
    L41:
        if (r113 == null) goto L59;
        ViewGroup.LayoutParams r118 = r113.getLayoutParams();
        if ((r118 instanceof FrameLayout.LayoutParams) == true) goto L46;
        r118 = null;
    L46:
        if (((FrameLayout.LayoutParams) r118) == null) goto L60;
        if (r115 == null) goto L61;
        AnchorModeParseSeiData r119 = this.f58595p;
        int r120 = this.f58594o;
        ViewParent r121 = r113.getParent();
        if ((r121 instanceof LivePlayerView) == false) goto L52;
        r112 = r121;
    L52:
        LivePlayerView r122 = (LivePlayerView) r112;
        Context r123 = getContext();
        IPreviewMultiLinkOuterConfigProvider r124 = this.f58580a;
        if (r124 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L55:
        r115.resizePlayViewForNewLinkFeedView(r119, r120, r122, r123, r124.getRoom(), this.f58582c, r110, r111);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L38:
        if (this.f58582c != 5) goto L41;
        if (r116 == null) goto L41;
        e(r116);
        return;
    L31:
        r113 = null;
        goto L32
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        LifecycleRegistry r100 = this.f58584e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new LifecycleRegistry(this);
    }

    public final void j() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderPause");
        if (this.f58583d == null) goto L6;
        iy.b.e("AnchorModeDynamicCardManager", "onPause");
        return;
    }

    public final void m() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderResume");
        h r100 = this.f58583d;
        com.bytedance.android.live.anchormodelink.handlers.d r101 = null;
        if (r100 == null) goto L23;
        ly.t r102 = r100.f511257j;
        if (r102 == null) goto L9;
        ih0.c r103 = r102.f511287d;
        if (r103 == null) goto L9;
        View r104 = r103.S0();
    L10:
        StringBuilder r105 = new StringBuilder("onFeedResume is in self:");
        if (r104 == null) goto L13;
        ViewParent r106 = r104.getParent();
    L14:
        r105.append(Intrinsics.areEqual(r106, r100.f511251d));
        r105.append(" ,cardView=");
        r105.append(r104);
        iy.b.e("AnchorModeDynamicCardManager", r105.toString());
        if (r104 == null) goto L23;
        if ((!Intrinsics.areEqual(r104.getParent(), r100.f511251d)) == false) goto L23;
        u r107 = r100.f511256i;
        if (r107 == null) goto L23;
        IRoom r108 = r107.getRoom();
        if (r108 == null) goto L23;
        r100.e(IRoomKtKt.getId(r108));
        goto L23
    L13:
        r106 = null;
    L9:
        r104 = null;
    L23:
        h r109 = this.f58583d;
        if (r109 == null) goto L26;
        r109.c(this.f58596q);
    L26:
        h r110 = this.f58583d;
        if (r110 == null) goto L31;
        ly.t r111 = r110.f511257j;
        if (r111 == null) goto L31;
        com.bytedance.android.live.anchormodelink.handlers.d r112 = r111.f511284a;
    L33:
        if ((r112 instanceof com.bytedance.android.live.anchormodelink.handlers.d) == false) goto L36;
        r101 = r112;
    L36:
        if (r101 != null) goto L38;
        return;
    L38:
        iy.b.e("AnchorModeDynamicFeedPreview", "[seiHandler.setOutProvider] feed recover set");
        r101.f58669j = this.f58591l;
        return;
    L31:
        r112 = null;
        goto L33
    }

    public final void o() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderSelected");
        b();
        h r100 = this.f58583d;
        if (r100 == null) goto L10;
        r100.f511258k = true;
        ly.t r101 = r100.f511257j;
        if (r101 == null) goto L11;
        ih0.c r102 = r101.f511287d;
        if (r102 == null) goto L12;
        r102.updateData(r100.a());
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final MessageHub p() {
        IPreviewMultiLinkOuterConfigProvider r100 = this.f58580a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r100.getMessageHub();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final IRoom r() {
        IPreviewMultiLinkOuterConfigProvider r100 = this.f58580a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        return r100.getRoom();
    }

    public final void release() {
        iy.b.e("AnchorModeDynamicFeedPreview", "release");
        h r100 = this.f58583d;
        if (r100 == null) goto L5;
        r100.f();
    L5:
        this.f58583d = null;
        ViewModelStore r101 = this.f58585f;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        this.f58585f = null;
        LifecycleRegistry r102 = this.f58584e;
        if (r102 == null) goto L17;
        Lifecycle.State r103 = r102.getCurrentState();
        if (r103 == null) goto L17;
        if (r103.isAtLeast(Lifecycle.State.CREATED) != true) goto L17;
        LifecycleRegistry r104 = this.f58584e;
        if (r104 == null) goto L17;
        r104.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    L17:
        this.f58584e = null;
        this.f58586g = null;
        this.f58587h = null;
    }

    public final void s() {
        iy.b.e("AnchorModeDynamicFeedPreview", "onViewHolderUnSelected");
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        ViewModelStore r100 = this.f58585f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ViewModelStore();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void l() {
        b();
    }

    public final void e(oy.c r110) {
        com.bytedance.android.live.anchormodelink.feed.c r100 = this.f58581b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L5:
        int r101 = r100.getContainerWidth();
        com.bytedance.android.live.anchormodelink.feed.c r102 = this.f58581b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("configInnerProvider");
    L8:
        int r103 = r102.l();
        int r104 = s1.y();
        float r105 = r101;
        float r106 = r104;
        float r107 = r103;
        float r108 = s1.w() + StatusBarUtil.getStatusBarHeight(getContext());
        float r109 = Math.min(r105 / r106, r107 / r108);
        float r111 = r110.f527110a * r109;
        float r112 = (r110.f527111b * r109) + ((r107 - (r108 * r109)) / 2.0f);
        RectF r113 = new RectF(((r105 - (r106 * r109)) / 2.0f) + r111, r112, r111 + (r110.f527112c * r109), (r110.f527113d * r109) + r112);
        IPreviewMultiLinkOuterConfigProvider r114 = this.f58580a;
        if (r114 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L11:
        LivePlayerView r115 = r114.getLivePlayerView();
        Object r116 = null;
        if (r115 == null) goto L14;
        IRenderView r117 = r115.getRenderView();
    L15:
        boolean r118 = r117 instanceof View;
        if (r118 == true) goto L18;
        Object r119 = null;
    L19:
        View r120 = (View) r119;
        if (r120 == null) goto L36;
        if (r118 == true) goto L23;
        Object r121 = null;
    L24:
        View r122 = (View) r121;
        if (r122 == null) goto L27;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
    L29:
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        r123 = null;
    L31:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (r124 == null) goto L34;
        r124.width = (int) r113.width();
        r124.height = (int) r113.height();
        r124.topMargin = (int) r113.top;
        r124.leftMargin = (int) r113.left;
        Unit r125 = Unit.INSTANCE;
    L35:
        r120.setLayoutParams(r124);
        goto L36
    L34:
        r124 = null;
        goto L35
    L27:
        r123 = null;
        goto L29
    L23:
        r121 = r117;
    L36:
        float r126 = r107 * (r106 / r108);
        int r127 = (int) ((r105 - r126) / 2.0f);
        Rect r128 = new Rect(r127, 0, (int) (r127 + r126), r103);
        Rect r129 = new Rect(0, 0, r101, r103);
        float r130 = r113.left;
        float r131 = r128.left;
        if (r130 >= r131) goto L39;
        r129.left = (int) (r131 - r130);
    L39:
        if (r118 == false) goto L42;
        r116 = r117;
    L42:
        View r132 = (View) r116;
        if (r132 == null) goto L46;
        r132.requestLayout();
        return;
    L46:
        return;
    L18:
        r119 = r117;
        goto L19
    L14:
        r117 = null;
        goto L15
    }

    public final void g(AnchorModeParseSeiData r100) {
        Intrinsics.checkNotNullParameter(r100, "seiAppData");
        boolean r101 = iy.b.f496463a;
        iy.b.a("AnchorModeDynamicFeedPreview", "onSeiAppDataUpdated seiAppData:" + r100);
        IPreviewMultiLinkOuterConfigProvider r102 = this.f58580a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L6:
        if (r102.getFeedLiveType() != 5) goto L9;
        post(new e(this));
        return;
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "seiString");
        boolean r101 = iy.b.f496463a;
        iy.b.a("AnchorModeDynamicFeedPreview", "onSeiUpdated seiString:".concat(r100));
        com.bytedance.android.live.anchormodelink.handlers.d r102 = this.f58589j;
        if (r102 == null) goto L6;
        r102.j(r100);
        return;
    }

    public final void f(IPreviewMultiLinkOuterConfigProvider r110, com.bytedance.android.live.anchormodelink.feed.c r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "configOuterProvider");
        Intrinsics.checkNotNullParameter(r111, "configInnerProvider");
        boolean r100 = iy.b.f496463a;
        iy.b.e("AnchorModeDynamicFeedPreview", "init scope:" + this.f58596q);
        this.f58580a = r110;
        this.f58581b = r111;
        this.f58582c = r110.getShowFrom();
        if (this.f58584e != null) goto L6;
        this.f58584e = new LifecycleRegistry(this);
    L6:
        if (this.f58585f != null) goto L9;
        this.f58585f = new ViewModelStore();
    L9:
        if (this.f58586g != null) goto L12;
        this.f58586g = new ViewModelProvider(this);
    L12:
        if (this.f58587h != null) goto L14;
        this.f58587h = DataCenter.create(this.f58586g, this);
    L14:
        IPreviewMultiLinkOuterConfigProvider r113 = this.f58580a;
        if (r113 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L17:
        r113.getContainerView().post(new com.bytedance.android.live.anchormodelink.feed.a(this));
        Context r101 = getContext();
        DataCenter r102 = this.f58587h;
        Intrinsics.checkNotNull(r102);
        h r114 = new h(r101, r102, this, true, r110.getFeedLiveType(), false, (ViewGroup) getParent(), this.f58592m, this.f58593n);
        this.f58583d = r114;
        r114.g(r110.getRoom().getRoomId(), !r112);
        h r115 = this.f58583d;
        if (r115 == null) goto L20;
        r115.c(this.f58596q);
    L20:
        com.bytedance.android.live.anchormodelink.handlers.d r116 = this.f58591l.a();
        if (r116 == null) goto L25;
        this.f58589j = r116;
        r116.f58669j = this.f58591l;
        List<iy.e> r117 = this.f58588i;
        if (r117 == null) goto L25;
        ((ArrayList) r117).add(r116);
    L25:
        h r118 = this.f58591l.f58599a.f58583d;
        if (r118 == null) goto L30;
        ly.t r119 = r118.f511257j;
        if (r119 == null) goto L30;
        com.bytedance.android.live.anchormodelink.handlers.a r120 = r119.f511285b;
    L31:
        if (r120 == null) goto L35;
        List<iy.e> r121 = this.f58588i;
        if (r121 == null) goto L35;
        ((ArrayList) r121).add(r120);
    L35:
        List<iy.e> r122 = this.f58588i;
        if (r122 == null) goto L41;
        Iterator r123 = ((ArrayList) r122).iterator();
    L39:
        if (r123.hasNext() == false) goto L43;
        ((iy.e) r123.next()).onStart();
        goto L39
    L43:
        return;
    L41:
        return;
    L30:
        r120 = null;
        goto L31
    }

    public final void t(AnchorModeParseSeiData r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "seiData");
        boolean r103 = iy.b.f496463a;
        iy.b.e("AnchorModeDynamicFeedPreview", "updateUILayout seiVer=" + r101 + ", uiLayout=" + r102);
        this.f58595p = r100;
        this.f58594o = r102;
        post(new f(this));
        if (this.f58583d == null) goto L6;
        iy.b.e("AnchorModeDynamicCardManager", "onLayoutChange uiLayout：" + r102);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.b
    public final void updateViewInLiveBg(String r100, JsonObject r101, ih0.h r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "updateCallback");
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.b.a.a(r100, r101, (l0) r102);
    }

    public AnchorModeDynamicFeedPreview(Context r100, int r101, AnchorModeParseSeiData r102, j r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "seiData");
        super(r100, null, 0);
        this.f58594o = r101;
        this.f58595p = r102;
        this.f58596q = r103;
        this.f58588i = new ArrayList();
        this.f58591l = new d(this);
        this.f58592m = new c(this);
        this.f58593n = new b(this);
    }
}
