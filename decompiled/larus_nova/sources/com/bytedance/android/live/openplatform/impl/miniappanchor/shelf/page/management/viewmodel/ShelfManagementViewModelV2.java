package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingsInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.privatemsg.AnchorPrivateMsgContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.livesdk.sharedpref.b;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.model.VideoRef;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zo0.d;
import zo0.f;
import zo0.g;
import zo0.h;
import zp0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u0007¢\u0006\u0004\b^\u0010_J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002JK\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n2'\b\u0002\u0010\u0014\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0004J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0004J\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u0018\u0010(\u001a\u00020\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J\"\u0010+\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020)2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J8\u0010.\u001a\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060,2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\u0003J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0014J\t\u00103\u001a\u00020\u0003H\u0096\u0001J\u0011\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u000204H\u0096\u0001J\r\u00107\u001a\u00020\u0003*\u000204H\u0096\u0001R*\u0010:\u001a\u0002082\u0006\u00109\u001a\u0002088\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010B\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010J\u001a\u0004\u0018\u00010I2\b\u00109\u001a\u0004\u0018\u00010I8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR#\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0,0P8\u0006¢\u0006\f\n\u0004\bV\u0010R\u001a\u0004\bW\u0010TR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0P8\u0006¢\u0006\f\n\u0004\bX\u0010R\u001a\u0004\bY\u0010TR)\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u001a0Z0P8\u0006¢\u0006\f\n\u0004\b\\\u0010R\u001a\u0004\b]\u0010T¨\u0006b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModelV2;", "Landroidx/lifecycle/ViewModel;", "", "", "registerEditSellingPointEventListener", "registerEditCardEventListener", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "modifiedCardInfo", "", "modifiedCardPosition", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "getModifiedShelfInfo", "position", "", "selected", "changeCardSelectedStatus", "shelfInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSuccess", "Lkotlin/Function0;", "onFail", "modifyShelfInfo", "initData", "fetchPrivateMsgData", "Lbq0/a;", "businessToolModel", "addBusinessTool", "newExplainCard", "shelfCardInfo", "openCardLandingPage", "editExplainCard", "selectedAll", "unselectedAll", "isSelectedAll", "isSelectedExplainingCard", "selectCard", "unselectCard", "getSelectedCount", "batchDelete", "", "exitSource", "offShelf", "", "cardInfoList", "saveSort", "getEnterTimes", "recordEnterTimes", "onPageFirstFrameShown", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "isInLive$delegate", "Lkotlin/Lazy;", "isInLive", "()Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "getShelfInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "setShelfInfo", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;)V", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "shelfAppInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "getShelfAppInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "setShelfAppInfo", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;)V", "Landroidx/lifecycle/MutableLiveData;", "pageCount", "Landroidx/lifecycle/MutableLiveData;", "getPageCount", "()Landroidx/lifecycle/MutableLiveData;", "Laq0/a;", "shelfCardInfoList", "getShelfCardInfoList", VideoEventOneOutSync.END_TYPE_FINISH, "getFinish", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/model/BusinessToolType;", "businessToolsData", "getBusinessToolsData", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShelfManagementViewModelV2 extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ShelfManagementViewModelV2";
    private final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a $$delegate_0;
    private final MutableLiveData<Map<BusinessToolType, bq0.a>> businessToolsData;
    private final MutableLiveData<Boolean> finish;
    private final Lazy isInLive$delegate;
    public so0.a miniAppAnchorService;
    private final MutableLiveData<Integer> pageCount;
    private ShelfMicroAppInfo shelfAppInfo;
    private final MutableLiveData<List<aq0.a>> shelfCardInfoList;
    private ShelfInfo shelfInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void autoDispose(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.$$delegate_0.a(r100);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public final boolean isInLive() {
        return ((Boolean) this.isInLive$delegate.getValue()).booleanValue();
    }

    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        this.$$delegate_0.c(r100);
    }

    public final void fetchPrivateMsgData() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L16;
        AnchorPrivateMsgContextService r102 = (AnchorPrivateMsgContextService) r101.getService(AnchorPrivateMsgContextService.class);
        if (r102 == null) goto L17;
        ShelfMicroAppInfo r103 = this.shelfAppInfo;
        if (r103 == null) goto L13;
        String r104 = r103.appId;
        if (r104 == null) goto L13;
    L14:
        AnchorPrivateMsgContextService.f(r102, r104);
        return;
    L13:
        r104 = "";
        goto L14
    L17:
        return;
    }

    public final int getEnterTimes() {
        return b.C3.getValue().intValue();
    }

    public final so0.a getMiniAppAnchorService() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r100;
    }

    public final int getSelectedCount() {
        List<aq0.a> r100 = this.shelfCardInfoList.getValue();
        int r101 = 0;
        if (r100 == null) goto L17;
        List<aq0.a> r102 = r100;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        if (((aq0.a) r103.next()).f15878b == false) goto L11;
        r101 = r101 + 1;
        if (r101 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L7:
        if (r102.isEmpty() == false) goto L9;
    L17:
        return r101;
    }

    public void initData() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r100 = AnchorMiniAppDataContext.a.a();
        if (r100 == null) goto L8;
        n<ShelfInfo> r101 = r100.m8183getShelfInfo();
        if (r101 == null) goto L9;
        i80.a.b(r101, new C99281(this));
        return;
    L9:
        return;
    }

    public final boolean isSelectedExplainingCard() {
        List<aq0.a> r100 = this.shelfCardInfoList.getValue();
        Object r101 = null;
        if (r100 == null) goto L16;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        aq0.a r104 = (aq0.a) r103;
        if (r104.f15878b == true) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
        r101 = r103;
        goto L15
    L10:
        if (r104.f15877a.getStatus() != 1) goto L12;
        r105 = true;
    L15:
        r101 = (aq0.a) r101;
    L16:
        if (r101 != null) goto L25;
        return false;
    L25:
        return true;
    }

    public final void newExplainCard() {
        ShelfInfo r100 = this.shelfInfo;
        if (r100 != null) goto L5;
    L6:
        ShelfInfo r101 = this.shelfInfo;
        if (r101 != null) goto L9;
    L12:
        so0.a r102 = this.miniAppAnchorService;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L15:
        OpenPlatformContext r103 = r102.a();
        String r104 = "";
        if (r103 == null) goto L25;
        AnchorMiniAppAppLogContextService r105 = (AnchorMiniAppAppLogContextService) r103.getService(AnchorMiniAppAppLogContextService.class);
        if (r105 == null) goto L25;
        ShelfMicroAppInfo r106 = this.shelfAppInfo;
        if (r106 == null) goto L23;
        String r107 = r106.appId;
        if (r107 == null) goto L23;
    L24:
        r105.reportMpClick(r107, "shelf_setting_page");
    L23:
        r107 = "";
    L25:
        so0.a r108 = this.miniAppAnchorService;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L28:
        OpenPlatformContext r109 = r108.a();
        if (r109 == null) goto L43;
        AnchorMiniAppAppLogContextService r110 = (AnchorMiniAppAppLogContextService) r109.getService(AnchorMiniAppAppLogContextService.class);
        if (r110 == null) goto L43;
        ShelfMicroAppInfo r111 = this.shelfAppInfo;
        if (r111 == null) goto L38;
        String r112 = r111.appId;
        if (r112 == null) goto L38;
        String r113 = r112;
    L39:
        Integer r114 = this.pageCount.getValue();
        if (r114 != null) goto L42;
        r114 = 0;
    L42:
        AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r110, r113, "click_adding_page", r114.intValue(), 0, 8, null);
    L38:
        r113 = "";
    L43:
        ShelfInfo r115 = this.shelfInfo;
        if (r115 == null) goto L53;
        so0.a r116 = this.miniAppAnchorService;
        if (r116 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L48:
        OpenPlatformContext r117 = r116.a();
        if (r117 == null) goto L53;
        AnchorShelfContextService r118 = (AnchorShelfContextService) r117.getService(AnchorShelfContextService.class);
        if (r118 == null) goto L53;
        r118.copyShelfInfoTemp(r115);
    L53:
        so0.a r119 = this.miniAppAnchorService;
        if (r119 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L56:
        ShelfMicroAppInfo r120 = this.shelfAppInfo;
        if (r120 == null) goto L62;
        String r121 = r120.schema;
        if (r121 == null) goto L62;
        r104 = r121;
    L62:
        r119.openMiniApp(r104, new ko0.b(LaunchParamConstant$Scene.f83955a, "live", "preview", "solid_entrance", "live_take_page", "shelf_setting_page", null, null, null, false, true, null, 12224));
        return;
    L9:
        if (r101.d() != true) goto L12;
    L10:
        f2.c(s1.B(R.string.ttlive_open_platform_talent_can_only_add_one_page), 0);
        return;
    L5:
        if (r100.e() == true) goto L10;
        goto L6
    }

    public void onPageFirstFrameShown() {
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L11;
        OpenPlatformPerformanceReportService r102 = (OpenPlatformPerformanceReportService) r101.getService(OpenPlatformPerformanceReportService.class);
        if (r102 == null) goto L12;
        HashMap<String, f> r103 = g.f573094a;
        f r104 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        r104.b();
        f.a(r104, new d(r102));
        return;
    L12:
        return;
    }

    public final void recordEnterTimes() {
        e<Integer> r100 = b.C3;
        Integer r101 = Integer.valueOf(r100.getValue().intValue() + 1);
        r100.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r100, r101);
    }

    public final void selectedAll() {
        MutableLiveData<List<aq0.a>> r100 = this.shelfCardInfoList;
        List<aq0.a> r101 = r100.getValue();
        if (r101 == null) goto L8;
        List<aq0.a> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(aq0.a.a((aq0.a) r104.next(), true));
    L9:
        r100.setValue(r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void unselectedAll() {
        MutableLiveData<List<aq0.a>> r100 = this.shelfCardInfoList;
        List<aq0.a> r101 = r100.getValue();
        if (r101 == null) goto L8;
        List<aq0.a> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(aq0.a.a((aq0.a) r104.next(), false));
    L9:
        r100.setValue(r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public ShelfManagementViewModelV2() {
        this.$$delegate_0 = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.isInLive$delegate = LazyKt.lazy(new C99292(this));
        this.pageCount = new MutableLiveData();
        this.shelfCardInfoList = new MutableLiveData();
        this.finish = new MutableLiveData();
        this.businessToolsData = new MutableLiveData();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService(((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().f530019a.f530021b.get());
        registerEditSellingPointEventListener();
        registerEditCardEventListener();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r100 = AnchorMiniAppDataContext.a.a();
        if (r100 == null) goto L10;
        n<lo0.b> r101 = r100.getPrivateMsgTabInfo();
        if (r101 == null) goto L11;
        Disposable r102 = i80.a.b(r101, new AnonymousClass1(this));
        if (r102 == null) goto L12;
        autoDispose(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void registerEditCardEventListener() {
        autoDispose(m.f(xs2.b.a().b(zp0.b.class), new C99311(this)));
    }

    private final void registerEditSellingPointEventListener() {
        autoDispose(m.f(xs2.b.a().b(c.class), new C99321(this)));
    }

    public final boolean isSelectedAll() {
        int r100 = getSelectedCount();
        Integer r101 = this.pageCount.getValue();
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100 != r101.intValue()) goto L8;
        return true;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        so0.a r100 = this.miniAppAnchorService;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L10;
        AnchorShelfContextService r102 = (AnchorShelfContextService) r101.getService(AnchorShelfContextService.class);
        if (r102 == null) goto L10;
        r102.clearShelfInfoTemp();
    L10:
        dispose();
    }

    public final MutableLiveData<Map<BusinessToolType, bq0.a>> getBusinessToolsData() {
        return this.businessToolsData;
    }

    public final MutableLiveData<Boolean> getFinish() {
        return this.finish;
    }

    public final MutableLiveData<Integer> getPageCount() {
        return this.pageCount;
    }

    public final ShelfMicroAppInfo getShelfAppInfo() {
        return this.shelfAppInfo;
    }

    public final MutableLiveData<List<aq0.a>> getShelfCardInfoList() {
        return this.shelfCardInfoList;
    }

    public final ShelfInfo getShelfInfo() {
        return this.shelfInfo;
    }

    public final void addBusinessTool(bq0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "businessToolModel");
        MutableLiveData<Map<BusinessToolType, bq0.a>> r101 = this.businessToolsData;
        LinkedHashMap r102 = new LinkedHashMap();
        Map<BusinessToolType, bq0.a> r103 = this.businessToolsData.getValue();
        if (r103 != null) goto L5;
        r103 = MapsKt.emptyMap();
    L5:
        r102.putAll(r103);
        r102.put(r100.b(), r100);
        Unit r104 = Unit.INSTANCE;
        r101.setValue(r102);
    }

    public final void batchDelete(final Function0<Unit> r110) {
        if (isSelectedAll() == false) goto L5;
        offShelf("all_delete", r110);
        return;
    L5:
        ShelfInfo r100 = this.shelfInfo;
        if (r100 == null) goto L29;
        List<aq0.a> r101 = this.shelfCardInfoList.getValue();
        if (r101 == null) goto L19;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if ((!((aq0.a) r104).f15878b) == false) goto L11;
        r102.add(r104);
        goto L11
    L15:
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r106 = r102.iterator();
    L17:
        if (r106.hasNext() == false) goto L20;
        r105.add(((aq0.a) r106.next()).f15877a);
    L20:
        modifyShelfInfo(ShelfInfo.a(r100, null, r105, false, null, null, null, 1048573), new C99271(r110), AnonymousClass2.INSTANCE);
        return;
    L19:
        r105 = null;
        goto L20
    }

    public final void openCardLandingPage(ShelfCardInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "shelfCardInfo");
        ShelfInfo r100 = this.shelfInfo;
        if (r100 == null) goto L12;
        so0.a r101 = this.miniAppAnchorService;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r102 = r101.a();
        if (r102 == null) goto L12;
        AnchorShelfContextService r103 = (AnchorShelfContextService) r102.getService(AnchorShelfContextService.class);
        if (r103 == null) goto L12;
        r103.copyShelfInfoTemp(r100);
    L12:
        SchemaInfo.a r104 = new SchemaInfo.a(r110.a0());
        String r105 = r110.i0();
        if (r105 != null) goto L15;
    L20:
        SchemaInfo r106 = r104.c();
        if (r106 == null) goto L24;
        String r107 = r106.h();
        if (r107 == null) goto L24;
    L25:
        so0.a r108 = this.miniAppAnchorService;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L28:
        r108.openMiniApp(r107, new ko0.b(LaunchParamConstant$Scene.f83955a, "live", "preview", "solid_entrance", "live_take_page", "shelf_setting_page", null, null, null, false, false, null, 16320));
        return;
    L24:
        r107 = "";
        goto L25
    L15:
        if ((!StringsKt.isBlank(r105)) == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
        r104.g(r105);
        goto L20
    }

    public final void selectCard(int r100) {
        changeCardSelectedStatus(r100, true);
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.miniAppAnchorService = r100;
    }

    public final void setShelfAppInfo(ShelfMicroAppInfo r100) {
        this.shelfAppInfo = r100;
    }

    public final void setShelfInfo(ShelfInfo r100) {
        this.shelfInfo = r100;
    }

    public final void unselectCard(int r100) {
        changeCardSelectedStatus(r100, false);
    }

    private final void changeCardSelectedStatus(int r100, boolean r101) {
        MutableLiveData<List<aq0.a>> r102 = this.shelfCardInfoList;
        List<aq0.a> r103 = r102.getValue();
        if (r103 == null) goto L14;
        List<aq0.a> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
        int r107 = 0;
    L6:
        if (r106.hasNext() == false) goto L15;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        aq0.a r110 = (aq0.a) r108;
        if (r100 != r107) goto L13;
        r110 = aq0.a.a(r110, r101);
    L13:
        r105.add(r110);
        r107 = r109;
    L15:
        r102.setValue(r105);
        return;
    L14:
        r105 = null;
        goto L15
    }

    private final ShelfInfo getModifiedShelfInfo(ShelfCardInfo r110, int r111) {
        ArrayList r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        ShelfInfo r101 = this.shelfInfo;
        if (r101 == null) goto L24;
        List<ShelfCardInfo> r102 = r101.cardInfoList;
        if (r102 == null) goto L20;
        List<ShelfCardInfo> r103 = r102;
        r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r104 = r103.iterator();
        int r105 = 0;
    L11:
        if (r104.hasNext() == false) goto L20;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ShelfCardInfo r108 = (ShelfCardInfo) r106;
        if (r105 != r111) goto L18;
        r108 = r110;
    L18:
        r100.add(r108);
        r105 = r107;
    L20:
        return ShelfInfo.a(r101, null, r100, false, null, null, null, 1048573);
    L24:
        return null;
    }

    public final void editExplainCard(ShelfCardInfo r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "shelfCardInfo");
        HashMap<String, f> r100 = g.f573094a;
        f r101 = h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);
        r101.o();
        h.a(r101, "explain_card_setting");
        so0.a r102 = this.miniAppAnchorService;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r103 = r102.a();
        if (r103 == null) goto L11;
        ExplainCardSettingContextService r104 = (ExplainCardSettingContextService) r103.getService(ExplainCardSettingContextService.class);
        if (r104 == null) goto L12;
        r104.h(new ExplainCardSettingsInfo(this.shelfAppInfo, r110, null, true, true, 0, null, null, r111, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2));
        return;
    L12:
        return;
    }

    public final void offShelf(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "exitSource");
        so0.a r102 = this.miniAppAnchorService;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r103 = r102.a();
        if (r103 == null) goto L11;
        AnchorShelfContextService r104 = (AnchorShelfContextService) r103.getService(AnchorShelfContextService.class);
        if (r104 == null) goto L12;
        r104.offShelf(r100, r101);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ ShelfInfo access$getModifiedShelfInfo(ShelfManagementViewModelV2 r100, ShelfCardInfo r101, int r102) {
        return r100.getModifiedShelfInfo(r101, r102);
    }

    private final void modifyShelfInfo(ShelfInfo r100, final Function1<? super ShelfInfo, Unit> r110, Function0<Unit> r111) {
        so0.a r101 = this.miniAppAnchorService;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r102 = r101.a();
        if (r102 == null) goto L11;
        AnchorShelfContextService r103 = (AnchorShelfContextService) r102.getService(AnchorShelfContextService.class);
        if (r103 == null) goto L12;
        AnchorShelfContextService.modifyShelf$default(r103, r100, false, new C99301(r110), r111, 2, null);
        return;
    L12:
        return;
    }

    public final void saveSort(List<ShelfCardInfo> r110, final Function0<Unit> r111, final Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "cardInfoList");
        ShelfInfo r100 = this.shelfInfo;
        if (r100 == null) goto L6;
        modifyShelfInfo(ShelfInfo.a(r100, null, r110, false, null, null, null, 1048573), new C99331(r111), new C99342(r112));
        return;
    }

    public static final /* synthetic */ void access$modifyShelfInfo(ShelfManagementViewModelV2 r100, ShelfInfo r101, Function1 r102, Function0 r103) {
        r100.modifyShelfInfo(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void batchDelete$default(ShelfManagementViewModelV2 r100, Function0 r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.batchDelete(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: batchDelete");
    }

    public static /* synthetic */ ShelfInfo getModifiedShelfInfo$default(ShelfManagementViewModelV2 r100, ShelfCardInfo r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = -1;
    L7:
        return r100.getModifiedShelfInfo(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getModifiedShelfInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offShelf$default(ShelfManagementViewModelV2 r100, String r101, Function0 r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = "";
    L7:
        if ((r103 & 2) == 0) goto L9;
        r102 = null;
    L9:
        r100.offShelf(r101, r102);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offShelf");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void modifyShelfInfo$default(ShelfManagementViewModelV2 r100, ShelfInfo r101, Function1 r102, Function0 r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        r100.modifyShelfInfo(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyShelfInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveSort$default(ShelfManagementViewModelV2 r100, List r101, Function0 r102, Function0 r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        r100.saveSort(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveSort");
    }
}
