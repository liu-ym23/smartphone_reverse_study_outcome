package com.bytedance.android.ec.store.api;

import android.app.Activity;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import fl.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J©\u0001\u0010\u0011\u001a\u00020\n2<\u0010\u000b\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042%\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH&J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002H&J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H&J\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0002H&J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&J\b\u0010 \u001a\u00020\nH&JZ\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u00012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00172\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017H&J\u0016\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020*0)0(H&J\u001c\u0010.\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u00022\b\u0010-\u001a\u0004\u0018\u00010\u0002H&J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020/H&J\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0002H&J\u0012\u00102\u001a\u0004\u0018\u00010/2\u0006\u0010\u0012\u001a\u00020\u0002H&¨\u00063"}, d2 = {"Lcom/bytedance/android/ec/store/api/IECStoreService;", "", "", "getFollowXTabSettings", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "listenerId", "Landroid/view/WindowManager;", "windowManager", "", "onShowListener", "", "scrollY", "scrollListener", "Lkotlin/Function1;", "onDestroyListener", "addBrandMallFractionListener", "id", "Lcom/bytedance/android/ec/store/api/IShopEventListener;", "listener", "registerShopFragmentListener", "unregisterShopFragmentListener", "", "getBizComponentFetchers", "url", "Lfl/b;", "shopPreloadConfig", "preFetchShopAPI", "preloadResource", "", "shouldRefreshShopCache", "onStoreEntranceShow", "type", "params", "handler", "urlExtraParams", "entranceInfoMap", "Landroidx/fragment/app/Fragment;", "createStoreShellFragment", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "getLivePlayActivityClass", "missItemId", "missToast", "notifyFollowStoreVideoMiss", "Lcom/bytedance/android/ec/store/api/ITabKitEventListener;", "registerTabKitEventListener", "unregisterTabKitEventListener", "getTabKitEventListener", "ec-biz-store-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECStoreService {
    void addBrandMallFractionListener(Function2<? super String, ? super WindowManager, Unit> r100, Function2<? super String, ? super Integer, Unit> r101, Function1<? super String, Unit> r102);

    Fragment createStoreShellFragment(String r100, int r101, String r102, Object r103, Map<String, String> r104, Map<String, String> r105);

    Map<String, Object> getBizComponentFetchers();

    String getFollowXTabSettings();

    List<Class<? extends Activity>> getLivePlayActivityClass();

    ITabKitEventListener getTabKitEventListener(String r100);

    void notifyFollowStoreVideoMiss(String r100, String r101);

    void onStoreEntranceShow();

    void preFetchShopAPI(String r100, b r101);

    void preloadResource(String r100);

    void registerShopFragmentListener(String r100, IShopEventListener r101);

    void registerTabKitEventListener(String r100, ITabKitEventListener r101);

    boolean shouldRefreshShopCache(String r100);

    void unregisterShopFragmentListener(String r100);

    void unregisterTabKitEventListener(String r100);
}
