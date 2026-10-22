package com.bytedance.android.shopping.store.home.api;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.model.entity.ShopAPIPreloadType;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.setting.k;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.home.preload.data.AIPreloadType;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.ShopSlcTemplateManager;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.framework.common.EmuiUtil;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj4.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b$\u0018\u0000 Ç\u00012\u00020\u0001:\u0002È\u0001B\u0011\u0012\u0007\u0010Â\u0001\u001a\u00020\u0006¢\u0006\u0005\bÆ\u0001\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\u0006J;\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR$\u00102\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR$\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R$\u00108\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R$\u0010;\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R$\u0010>\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0014\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010\u0018R$\u0010A\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0014\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018R0\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010 \u001a\u0004\bE\u0010\"\"\u0004\bF\u0010$R0\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010 \u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\"\u0010J\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010*\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R\"\u0010L\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010*\u001a\u0004\bM\u0010,\"\u0004\bN\u0010.R$\u0010O\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0014\u001a\u0004\bP\u0010\u0016\"\u0004\bQ\u0010\u0018R\u0017\u0010S\u001a\u00020R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR#\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020W0\u000e8\u0006¢\u0006\f\n\u0004\bX\u0010 \u001a\u0004\bY\u0010\"R$\u0010Z\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0014\u001a\u0004\b[\u0010\u0016\"\u0004\b\\\u0010\u0018R\"\u0010]\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010*\u001a\u0004\b^\u0010,\"\u0004\b_\u0010.R\"\u0010a\u001a\u00020`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0014\u001a\u0004\bh\u0010\u0016\"\u0004\bi\u0010\u0018R\u001a\u0010j\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\"\u0010n\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010k\u001a\u0004\bo\u0010m\"\u0004\bp\u0010qR\"\u0010r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010k\u001a\u0004\br\u0010m\"\u0004\bs\u0010qR$\u0010t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u0014\u001a\u0004\bu\u0010\u0016\"\u0004\bv\u0010\u0018R\"\u0010x\u001a\u00020w8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u007f\u001a\u00020~8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R)\u0010\u0085\u0001\u001a\u00020~8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u0014\u001a\u0005\b\u0089\u0001\u0010\u0016\"\u0005\b\u008a\u0001\u0010\u0018R(\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010\u0014\u001a\u0005\b\u008c\u0001\u0010\u0016\"\u0005\b\u008d\u0001\u0010\u0018R&\u0010\u008e\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010*\u001a\u0005\b\u008e\u0001\u0010,\"\u0005\b\u008f\u0001\u0010.R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\u0014\u001a\u0005\b\u0098\u0001\u0010\u0016\"\u0005\b\u0099\u0001\u0010\u0018R&\u0010\u009a\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010*\u001a\u0005\b\u009a\u0001\u0010,\"\u0005\b\u009b\u0001\u0010.R(\u0010\u009c\u0001\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\u001a\u001a\u0005\b\u009d\u0001\u0010\u001c\"\u0005\b\u009e\u0001\u0010\u001eR(\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u0014\u001a\u0005\b \u0001\u0010\u0016\"\u0005\b¡\u0001\u0010\u0018R(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\u0014\u001a\u0005\b£\u0001\u0010\u0016\"\u0005\b¤\u0001\u0010\u0018R,\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R+\u0010¬\u0001\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R(\u0010²\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010\u0014\u001a\u0005\b³\u0001\u0010\u0016\"\u0005\b´\u0001\u0010\u0018R&\u0010µ\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bµ\u0001\u0010*\u001a\u0005\b¶\u0001\u0010,\"\u0005\b·\u0001\u0010.R!\u0010»\u0001\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0005\bº\u0001\u0010\u0016R\u001f\u0010¾\u0001\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¼\u0001\u0010¹\u0001\u001a\u0005\b½\u0001\u0010\u0016R\u001f\u0010Á\u0001\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b¿\u0001\u0010¹\u0001\u001a\u0005\bÀ\u0001\u0010\u0016R\u001a\u0010Â\u0001\u001a\u00020\u00068\u0006¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u0014\u001a\u0005\bÃ\u0001\u0010\u0016R\u0013\u0010Ä\u0001\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010,R\u0013\u0010Å\u0001\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010,¨\u0006É\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "Lcom/bytedance/android/shopping/store/home/api/StoreBaseParam;", "Landroid/net/Uri;", "schema", "", "prepare", "", "getMarketInfo", "getLocalVersionWithoutContent", "getClientParams", "", "tabType", "", "extraLogExtra", "", "", "getTabMetaInfo", "(Ljava/lang/Integer;Ljava/util/Map;)Ljava/util/Map;", "updateSqlClientData", "shopId", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "shopType", "Ljava/lang/Integer;", "getShopType", "()Ljava/lang/Integer;", "setShopType", "(Ljava/lang/Integer;)V", "schemaQueryMap", "Ljava/util/Map;", "getSchemaQueryMap", "()Ljava/util/Map;", "setSchemaQueryMap", "(Ljava/util/Map;)V", "apiExtParam", "getApiExtParam", "setApiExtParam", "", "viewProductTab", "Z", "getViewProductTab", "()Z", "setViewProductTab", "(Z)V", "sortType", "getSortType", "setSortType", "pickType", "getPickType", "setPickType", "passthroughHybrid", "getPassthroughHybrid", "setPassthroughHybrid", "taskRequestParams", "getTaskRequestParams", "setTaskRequestParams", "memberTrackParams", "getMemberTrackParams", "setMemberTrackParams", "frame", "getFrame", "setFrame", "extra", "getExtra", "setExtra", "logExtra", "getLogExtra", "setLogExtra", "tabPerfLogExtra", "getTabPerfLogExtra", "setTabPerfLogExtra", "isCroppedStyle", "setCroppedStyle", "statusBarDarkFont", "getStatusBarDarkFont", "setStatusBarDarkFont", "shuffleProductIds", "getShuffleProductIds", "setShuffleProductIds", "Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "storeV3UIParam", "Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "getStoreV3UIParam", "()Lcom/bytedance/android/shopping/store/home/api/StoreV3UIParam;", "Lcom/bytedance/android/shopping/store/home/api/TabStyle;", "tabStyles", "getTabStyles", "inflowProductCardMode", "getInflowProductCardMode", "setInflowProductCardMode", "openByFragment", "getOpenByFragment", "setOpenByFragment", "", "lifecycleMonitorId", "J", "getLifecycleMonitorId", "()J", "setLifecycleMonitorId", "(J)V", "shopVersion", "getShopVersion", "setShopVersion", "flagSupportNestedTab", "I", "getFlagSupportNestedTab", "()I", "enableCommonAdTrack", "getEnableCommonAdTrack", "setEnableCommonAdTrack", "(I)V", "isFromAd", "setFromAd", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "apiPreloadType", "Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "getApiPreloadType", "()Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;", "setApiPreloadType", "(Lcom/bytedance/android/ec/model/entity/ShopAPIPreloadType;)V", "Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "infoAIPreloadType", "Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "getInfoAIPreloadType", "()Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;", "setInfoAIPreloadType", "(Lcom/bytedance/android/shopping/store/home/preload/data/AIPreloadType;)V", "tabAIPreloadType", "getTabAIPreloadType", "setTabAIPreloadType", "interceptBackProcessType", "getInterceptBackProcessType", "setInterceptBackProcessType", "btmPageId", "getBtmPageId", "setBtmPageId", "isSplitMode", "setSplitMode", "Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "splitParent", "Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "getSplitParent", "()Lcom/bytedance/android/ec/host/api/split/ECFoldScene;", "setSplitParent", "(Lcom/bytedance/android/ec/host/api/split/ECFoldScene;)V", "splitPageType", "getSplitPageType", "setSplitPageType", "isTopSplit", "setTopSplit", "storeUITheme", "getStoreUITheme", "setStoreUITheme", "primaryColor", EmuiUtil.GET_PRIMARY_COLOR, "setPrimaryColor", "secondaryColor", "getSecondaryColor", "setSecondaryColor", "", "transparency", "Ljava/lang/Double;", "getTransparency", "()Ljava/lang/Double;", "setTransparency", "(Ljava/lang/Double;)V", "flagHasActivityFloat", "Ljava/lang/Boolean;", "getFlagHasActivityFloat", "()Ljava/lang/Boolean;", "setFlagHasActivityFloat", "(Ljava/lang/Boolean;)V", "productTabPassThroughApi", "getProductTabPassThroughApi", "setProductTabPassThroughApi", "needShowMallBackView", "getNeedShowMallBackView", "setNeedShowMallBackView", "clientParam$delegate", "Lkotlin/Lazy;", "getClientParam", "clientParam", "localVersion$delegate", "getLocalVersion", "localVersion", "abParams$delegate", "getAbParams", "abParams", "secShopId", "getSecShopId", "isWhiteBrand", "isRedMan", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreParam extends StoreBaseParam {
    public static final a Companion = null;
    public static final String KEY_MODAL = "modal";
    private final Lazy abParams$delegate;
    private String apiExtParam;
    private ShopAPIPreloadType apiPreloadType;
    private String btmPageId;
    private final Lazy clientParam$delegate;
    private int enableCommonAdTrack;
    private String entranceInfo;
    private String extra;
    private Boolean flagHasActivityFloat;
    private final int flagSupportNestedTab;
    private String frame;
    private String inflowProductCardMode;
    private AIPreloadType infoAIPreloadType;
    private String interceptBackProcessType;
    private boolean isCroppedStyle;
    private int isFromAd;
    private boolean isSplitMode;
    private boolean isTopSplit;
    private long lifecycleMonitorId;
    private final Lazy localVersion$delegate;
    private Map<String, String> logExtra;
    private String memberTrackParams;
    private boolean needShowMallBackView;
    private boolean openByFragment;
    private String passthroughHybrid;
    private Integer pickType;
    private String primaryColor;
    private String productTabPassThroughApi;
    private Map<String, String> schemaQueryMap;
    private final String secShopId;
    private String secondaryColor;
    private String shopId;
    private Integer shopType;
    private String shopVersion;
    private String shuffleProductIds;
    private Integer sortType;
    private String splitPageType;
    private ECFoldScene splitParent;
    private boolean statusBarDarkFont;
    private Integer storeUITheme;
    private final StoreV3UIParam storeV3UIParam;
    private AIPreloadType tabAIPreloadType;
    private Map<String, String> tabPerfLogExtra;
    private final Map<Integer, TabStyle> tabStyles;
    private String taskRequestParams;
    private Double transparency;
    private boolean viewProductTab;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getAbParams() {
        return (String) this.abParams$delegate.getValue();
    }

    public final String getClientParam() {
        return (String) this.clientParam$delegate.getValue();
    }

    public final String getClientParams() {
        return null;
    }

    public final String getLocalVersion() {
        return (String) this.localVersion$delegate.getValue();
    }

    public final String getLocalVersionWithoutContent() {
        ConcurrentHashMap<String, ShopSliceItemConfig> r100 = ShopSlcTemplateManager.f186323i;
        if (r100.isEmpty() == false) goto L30;
        long r101 = wh.a.a("ecom_shop_slice_template");
        List r102 = (List) ShopSlcTemplateManager.f186322h.getValue();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        k r105 = (k) r104.next();
        SliceTemplate r106 = new SliceTemplate();
        r106.setName(r105.a());
        r106.setUrl(r105.c());
        r106.setVersion(String.valueOf(r101));
        r106.setType(SliceTemplateType.GECKO.getType());
        r103.add(r106);
        goto L6
    L8:
        ArrayList r107 = new ArrayList();
        ArrayList r108 = new ArrayList();
        ArrayList r109 = new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        Iterator r113 = r103.iterator();
    L10:
        if (r113.hasNext() == false) goto L29;
        SliceTemplate r114 = (SliceTemplate) r113.next();
        if (CollectionsKt.contains(ShopSlcTemplateManager.f186316b, r114.getName()) == false) goto L15;
        r110.add(r114);
    L15:
        if (CollectionsKt.contains(ShopSlcTemplateManager.f186319e, r114.getName()) == false) goto L18;
        r108.add(r114);
    L18:
        if (CollectionsKt.contains(ShopSlcTemplateManager.f186320f, r114.getName()) == false) goto L21;
        r109.add(r114);
    L21:
        if (CollectionsKt.contains(ShopSlcTemplateManager.f186318d, r114.getName()) == false) goto L24;
        r112.add(r114);
    L24:
        if (CollectionsKt.contains(ShopSlcTemplateManager.f186317c, r114.getName()) == false) goto L27;
        r111.add(r114);
    L27:
        if (CollectionsKt.contains(ShopSlcTemplateManager.f186321g, r114.getName()) == false) goto L10;
        r107.add(r114);
        goto L10
    L29:
        ConcurrentHashMap<String, ShopSliceItemConfig> r115 = ShopSlcTemplateManager.f186323i;
        String r116 = SliceItemType.SHOP_PROFILE_CONCISE.getType();
        ShopSliceItemConfig r117 = new ShopSliceItemConfig();
        r117.setTemplates(r107);
        Unit r118 = Unit.INSTANCE;
        r115.put(r116, r117);
        String r119 = SliceItemType.SHOP_PROFILE.getType();
        ShopSliceItemConfig r120 = new ShopSliceItemConfig();
        r120.setTemplates(r108);
        r115.put(r119, r120);
        String r121 = SliceItemType.SHOP_TOP_BAR.getType();
        ShopSliceItemConfig r122 = new ShopSliceItemConfig();
        r122.setTemplates(r109);
        r115.put(r121, r122);
        String r123 = SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType();
        ShopSliceItemConfig r124 = new ShopSliceItemConfig();
        r124.setTemplates(r110);
        r115.put(r123, r124);
        String r125 = SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK.getType();
        ShopSliceItemConfig r126 = new ShopSliceItemConfig();
        r126.setTemplates(r111);
        r115.put(r125, r126);
        String r127 = SliceItemType.SHOP_FILTER.getType();
        ShopSliceItemConfig r128 = new ShopSliceItemConfig();
        r128.setTemplates(r112);
        r115.put(r127, r128);
    L34:
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r130 = r103.iterator();
    L36:
        if (r130.hasNext() == false) goto L39;
        SliceTemplate r131 = (SliceTemplate) r130.next();
        SliceTemplate r132 = new SliceTemplate();
        r132.setContent(null);
        r132.setName(r131.getName());
        r132.setUrl(r131.getUrl());
        r132.setVersion(r131.getVersion());
        r132.setType(r131.getType());
        r132.setSpanSize(r131.getSpanSize());
        r132.setPredictHeight(r131.getPredictHeight());
        r129.add(r132);
        goto L36
    L39:
        return com.bytedance.android.ec.hybrid.list.util.k.d(CollectionsKt.toMutableList(r129));
    L30:
        Collection<ShopSliceItemConfig> r133 = r100.values();
        r103 = new ArrayList();
        Iterator<T> r134 = r133.iterator();
    L32:
        if (r134.hasNext() == false) goto L34;
        CollectionsKt.addAll(r103, ((ShopSliceItemConfig) r134.next()).getTemplates());
        goto L32
    }

    public final String getMarketInfo() {
        return this.schemaQueryMap.get("pass_through_marketing_info");
    }

    public final boolean isRedMan() {
        Integer r100 = this.shopType;
        int r101 = ShopType.RED_MAN.getType();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != r101) goto L8;
        return true;
    }

    public final boolean isWhiteBrand() {
        Integer r100 = this.shopType;
        int r101 = ShopType.WHITE_BRAND.getType();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != r101) goto L8;
        return true;
    }

    public final void updateSqlClientData() {
        String r100 = (String) getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API);
        if (r100 == null) goto L5;
        JSONObject r101 = com.bytedance.android.shopping.extensions.k.w(r100);
    L6:
        if (r101 == null) goto L8;
        Keva r102 = ECShopDataStorageForRemote.f183625a;
        r101.put("sql_data_from_client", ECShopDataStorageForRemote.b(this.secShopId, r.f48132a.getCurrentUserId()));
    L8:
        putPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API, String.valueOf(r101));
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final String getApiExtParam() {
        return this.apiExtParam;
    }

    public final ShopAPIPreloadType getApiPreloadType() {
        return this.apiPreloadType;
    }

    public final String getBtmPageId() {
        return this.btmPageId;
    }

    public final int getEnableCommonAdTrack() {
        return this.enableCommonAdTrack;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Boolean getFlagHasActivityFloat() {
        return this.flagHasActivityFloat;
    }

    public final int getFlagSupportNestedTab() {
        return this.flagSupportNestedTab;
    }

    public final String getFrame() {
        return this.frame;
    }

    public final String getInflowProductCardMode() {
        return this.inflowProductCardMode;
    }

    public final AIPreloadType getInfoAIPreloadType() {
        return this.infoAIPreloadType;
    }

    public final String getInterceptBackProcessType() {
        return this.interceptBackProcessType;
    }

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final String getMemberTrackParams() {
        return this.memberTrackParams;
    }

    public final boolean getNeedShowMallBackView() {
        return this.needShowMallBackView;
    }

    public final boolean getOpenByFragment() {
        return this.openByFragment;
    }

    public final String getPassthroughHybrid() {
        return this.passthroughHybrid;
    }

    public final Integer getPickType() {
        return this.pickType;
    }

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final String getProductTabPassThroughApi() {
        return this.productTabPassThroughApi;
    }

    public final Map<String, String> getSchemaQueryMap() {
        return this.schemaQueryMap;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getSecondaryColor() {
        return this.secondaryColor;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final Integer getShopType() {
        return this.shopType;
    }

    public final String getShopVersion() {
        return this.shopVersion;
    }

    public final String getShuffleProductIds() {
        return this.shuffleProductIds;
    }

    public final Integer getSortType() {
        return this.sortType;
    }

    public final String getSplitPageType() {
        return this.splitPageType;
    }

    public final ECFoldScene getSplitParent() {
        return this.splitParent;
    }

    public final boolean getStatusBarDarkFont() {
        return this.statusBarDarkFont;
    }

    public final Integer getStoreUITheme() {
        return this.storeUITheme;
    }

    public final StoreV3UIParam getStoreV3UIParam() {
        return this.storeV3UIParam;
    }

    public final AIPreloadType getTabAIPreloadType() {
        return this.tabAIPreloadType;
    }

    public final Map<String, String> getTabPerfLogExtra() {
        return this.tabPerfLogExtra;
    }

    public final Map<Integer, TabStyle> getTabStyles() {
        return this.tabStyles;
    }

    public final String getTaskRequestParams() {
        return this.taskRequestParams;
    }

    public final Double getTransparency() {
        return this.transparency;
    }

    public final boolean getViewProductTab() {
        return this.viewProductTab;
    }

    public final boolean isCroppedStyle() {
        return this.isCroppedStyle;
    }

    public final int isFromAd() {
        return this.isFromAd;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    public final boolean isTopSplit() {
        return this.isTopSplit;
    }

    public ECStoreParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "secShopId");
        this.secShopId = r100;
        this.schemaQueryMap = new HashMap();
        this.storeV3UIParam = new StoreV3UIParam();
        this.tabStyles = new LinkedHashMap();
        this.lifecycleMonitorId = -1;
        this.flagSupportNestedTab = 1;
        this.apiPreloadType = ShopAPIPreloadType.NO_PRELOAD;
        AIPreloadType r101 = AIPreloadType.NO_PRELOAD;
        this.infoAIPreloadType = r101;
        this.tabAIPreloadType = r101;
        this.splitPageType = "";
        LazyThreadSafetyMode r102 = LazyThreadSafetyMode.NONE;
        this.clientParam$delegate = LazyKt.lazy(r102, new ECStoreParam$clientParam$2(this));
        this.localVersion$delegate = LazyKt.lazy(r102, new ECStoreParam$localVersion$2(this));
        this.abParams$delegate = LazyKt.lazy(new ECStoreParam$abParams$2(this));
    }

    public final JSONObject a(Map<String, String> r100) {
        JSONObject r101 = new JSONObject();
        if (isEcShare() == false) goto L6;
        r101.put("is_ec_shopping", 1);
        r101.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, getShareContent());
        r101.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, getShareObject());
    L6:
        if (Intrinsics.areEqual(getShareContent(), "shop") == false) goto L8;
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, getEntranceLocation());
    L8:
        Map<String, String> r102 = this.logExtra;
        if (r102 == null) goto L14;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, String> r104 = r103.next();
        r101.put(r104.getKey(), r104.getValue());
    L14:
        Map<String, String> r105 = this.tabPerfLogExtra;
        if (r105 == null) goto L20;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        Map.Entry<String, String> r107 = r106.next();
        r101.put(r107.getKey(), r107.getValue());
    L20:
        if (r100 == null) goto L25;
        Iterator<Map.Entry<String, String>> r108 = r100.entrySet().iterator();
    L23:
        if (r108.hasNext() == false) goto L25;
        Map.Entry<String, String> r109 = r108.next();
        r101.put(r109.getKey(), r109.getValue());
    L25:
        return r101;
    }

    public final void prepare(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.schemaQueryMap = j1.a(r100);
        int r101 = com.bytedance.android.shopping.store.home.api.a.f183602a;
        Lazy r102 = ECStoreSettings.f48572a;
        int r103 = p.f45243a;
        String r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        b r106 = b.f499326b;     // Catch: Throwable -> L5
        Object r107 = jj4.a.a("ec_store_api_ext_param_config", JsonElement.class, null, false);     // Catch: Throwable -> L5
    L9:
        JsonElement r108 = (JsonElement) r107;
        if ((r108 instanceof JsonObject) == false) goto L13;
        com.bytedance.android.shopping.store.home.api.a.a((JsonObject) r108, r100);
        r104 = r108.toString();
    L13:
        this.apiExtParam = r104;
        boolean r109 = Intrinsics.areEqual(this.schemaQueryMap.get("modal"), "seven_split");
        boolean r110 = true;
        if (Intrinsics.areEqual(getEntranceLocation(), "video_bind_store") == false) goto L30;
        Lazy r111 = ECStoreSettings.f48572a;
        int r112 = p.f45243a;
        Object r113 = Boolean.TRUE;
        b r114 = b.f499326b;     // Catch: Throwable -> L20
        Object r115 = jj4.a.a("ec_store_enable_video_anchor_with_cropped_style", Boolean.class, r113, false);     // Catch: Throwable -> L20
        if (r115 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Throwable -> L20
    L27:
        if (((Boolean) r115).booleanValue() == true) goto L30;
        boolean r116 = false;
    L31:
        if (r109 == false) goto L34;
        if (r116 == false) goto L34;
    L35:
        this.isCroppedStyle = r110;
        this.enableCommonAdTrack = com.bytedance.android.shopping.extensions.k.r(UriProtector.getQueryParameter(r100, "enable_common_ad_track"), 0);
        this.isFromAd = com.bytedance.android.shopping.extensions.k.r(UriProtector.getQueryParameter(r100, "is_from_ad"), 0);
        return;
    L34:
        r110 = false;
    L20:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Object r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r118) == true) goto L25;
        r113 = r118;
    L25:
        r115 = r113;
    L30:
        r116 = true;
    L5:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == false) goto L9;
        r107 = null;
        goto L9
    }

    public final void setApiExtParam(String r100) {
        this.apiExtParam = r100;
    }

    public final void setApiPreloadType(ShopAPIPreloadType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.apiPreloadType = r100;
    }

    public final void setBtmPageId(String r100) {
        this.btmPageId = r100;
    }

    public final void setCroppedStyle(boolean r100) {
        this.isCroppedStyle = r100;
    }

    public final void setEnableCommonAdTrack(int r100) {
        this.enableCommonAdTrack = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setFlagHasActivityFloat(Boolean r100) {
        this.flagHasActivityFloat = r100;
    }

    public final void setFrame(String r100) {
        this.frame = r100;
    }

    public final void setFromAd(int r100) {
        this.isFromAd = r100;
    }

    public final void setInflowProductCardMode(String r100) {
        this.inflowProductCardMode = r100;
    }

    public final void setInfoAIPreloadType(AIPreloadType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.infoAIPreloadType = r100;
    }

    public final void setInterceptBackProcessType(String r100) {
        this.interceptBackProcessType = r100;
    }

    public final void setLifecycleMonitorId(long r100) {
        this.lifecycleMonitorId = r100;
    }

    public final void setLogExtra(Map<String, String> r100) {
        this.logExtra = r100;
    }

    public final void setMemberTrackParams(String r100) {
        this.memberTrackParams = r100;
    }

    public final void setNeedShowMallBackView(boolean r100) {
        this.needShowMallBackView = r100;
    }

    public final void setOpenByFragment(boolean r100) {
        this.openByFragment = r100;
    }

    public final void setPassthroughHybrid(String r100) {
        this.passthroughHybrid = r100;
    }

    public final void setPickType(Integer r100) {
        this.pickType = r100;
    }

    public final void setPrimaryColor(String r100) {
        this.primaryColor = r100;
    }

    public final void setProductTabPassThroughApi(String r100) {
        this.productTabPassThroughApi = r100;
    }

    public final void setSchemaQueryMap(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schemaQueryMap = r100;
    }

    public final void setSecondaryColor(String r100) {
        this.secondaryColor = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShopType(Integer r100) {
        this.shopType = r100;
    }

    public final void setShopVersion(String r100) {
        this.shopVersion = r100;
    }

    public final void setShuffleProductIds(String r100) {
        this.shuffleProductIds = r100;
    }

    public final void setSortType(Integer r100) {
        this.sortType = r100;
    }

    public final void setSplitMode(boolean r100) {
        this.isSplitMode = r100;
    }

    public final void setSplitPageType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.splitPageType = r100;
    }

    public final void setSplitParent(ECFoldScene r100) {
        this.splitParent = r100;
    }

    public final void setStatusBarDarkFont(boolean r100) {
        this.statusBarDarkFont = r100;
    }

    public final void setStoreUITheme(Integer r100) {
        this.storeUITheme = r100;
    }

    public final void setTabAIPreloadType(AIPreloadType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabAIPreloadType = r100;
    }

    public final void setTabPerfLogExtra(Map<String, String> r100) {
        this.tabPerfLogExtra = r100;
    }

    public final void setTaskRequestParams(String r100) {
        this.taskRequestParams = r100;
    }

    public final void setTopSplit(boolean r100) {
        this.isTopSplit = r100;
    }

    public final void setTransparency(Double r100) {
        this.transparency = r100;
    }

    public final void setViewProductTab(boolean r100) {
        this.viewProductTab = r100;
    }

    public final Map<String, Object> getTabMetaInfo(Integer r100, Map<String, String> r101) {
        Pair[] r102 = new Pair[33];
        String r103 = getStoreAccountParam().getUserId();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_KOL_ID, r103);
        String r105 = getStoreAccountParam().getSecUserId();
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102[1] = TuplesKt.to("sec_kol_id", r105);
        r102[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, getEntranceLocation());
        r102[3] = TuplesKt.to("enter_from", getEntranceLocation());
        String r106 = getShareInfo().getShopName();
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r102[4] = TuplesKt.to("shop_name", r106);
        r102[5] = TuplesKt.to(VrBgLogData.KEY_IS_PREVIEW, Boolean.valueOf(isPreview()));
        r102[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, 0);
        r102[7] = TuplesKt.to("source_page", "store_page");
        Integer r107 = getFollowStatus();
        String r108 = null;
        if (r107 == null) goto L14;
        String r109 = String.valueOf(r107.intValue());
    L15:
        if (r109 != null) goto L17;
        r109 = "";
    L17:
        r102[8] = TuplesKt.to("follow_status", r109);
        if (isPreview() == false) goto L20;
        String r110 = "1";
    L21:
        r102[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_ENTER_PREVIEW, r110);
        String r111 = getTempId();
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        r102[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TEMP_ID, r111);
        String r112 = getSearchParams();
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        r102[11] = TuplesKt.to("search_params", r112);
        String r113 = getStoreSourcePage();
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        r102[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r113);
        String r114 = getStoreSourceMethod();
        if (r114 != null) goto L33;
        r114 = "";
    L33:
        r102[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r114);
        String r115 = getStoreGroupType();
        if (r115 != null) goto L36;
        r115 = "";
    L36:
        r102[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r115);
        r102[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, getPreProductId());
        r102[16] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, getPreRoomId());
        r102[17] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, getPreGroupId());
        String r116 = (String) getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API);
        if (r116 != null) goto L39;
        r116 = "";
    L39:
        r102[18] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API, r116);
        String r117 = this.shopId;
        if (r117 != null) goto L42;
        r117 = "";
    L42:
        r102[19] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r117);
        r102[20] = TuplesKt.to("sec_shop_id", this.secShopId);
        String r118 = getStoreAccountParam().getUserId();
        if (r118 != null) goto L45;
        r118 = "";
    L45:
        r102[21] = TuplesKt.to("author_id", r118);
        r102[22] = TuplesKt.to("is_from_ad", Integer.valueOf(this.isFromAd));
        String r119 = this.schemaQueryMap.get("modal");
        if (r119 != null) goto L48;
        r119 = "";
    L48:
        r102[23] = TuplesKt.to("modal", r119);
        String r120 = getStoreAccountParam().getSecUserId();
        if (r120 != null) goto L51;
        r120 = "";
    L51:
        r102[24] = TuplesKt.to("sec_author_id", r120);
        String r121 = this.primaryColor;
        if (r121 != null) goto L54;
        r121 = "";
    L54:
        r102[25] = TuplesKt.to("primary_color", r121);
        String r122 = this.secondaryColor;
        if (r122 != null) goto L57;
        r122 = "";
    L57:
        r102[26] = TuplesKt.to("secondary_color", r122);
        Double r123 = this.transparency;
        if (r123 == null) goto L60;
        double r124 = r123.doubleValue();
    L61:
        r102[27] = TuplesKt.to("transparency", Double.valueOf(r124));
        String r125 = getProductBasicRequestParam().getToken();
        if (r125 != null) goto L64;
        r125 = "";
    L64:
        r102[28] = TuplesKt.to("token", r125);
        JSONObject r126 = com.bytedance.android.shopping.extensions.k.w(this.passthroughHybrid);
        if (r126 != null) goto L67;
        r126 = new JSONObject();
    L67:
        r102[29] = TuplesKt.to("pass_through_hybrid", r126);
        r102[30] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        String r127 = this.shopVersion;
        if (r127 != null) goto L70;
        r127 = "";
    L70:
        r102[31] = TuplesKt.to("shop_version", r127);
        r102[32] = TuplesKt.to("log_extra", a(r101).toString());
        Map<String, Object> r128 = MapsKt.mutableMapOf(r102);
        if (r100 == null) goto L87;
        r100.intValue();
        if (r100.intValue() != TabEnum.CATEGORY_TAB.getType()) goto L79;
        String r129 = getProductBasicRequestParam().getTmpId();
        if (r129 == null) goto L78;
        r104 = r129;
    L78:
        r128.put("tmp_id", r104);
    L86:
        r128.put("tab_type", r100);
        goto L87
    L79:
        TabStyle r130 = this.tabStyles.get(r100);
        if (r130 == null) goto L82;
        r108 = r130.getTemplateId();
    L82:
        if (r108 == null) goto L85;
        r104 = r108;
    L85:
        r128.put("tmp_id", r104);
    L87:
        String r131 = (String) getPassThroughParam(com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API);
        if (r131 == null) goto L97;
        JSONObject r132 = com.bytedance.android.shopping.extensions.k.w(r131);
        if (r132 == null) goto L97;
        r128.put("ecom_scene_id", r132.optString("ecom_scene_id"));
    L97:
        r128.put("client_experiment_list", new JSONObject(new HashMap(ECShopABSettings.f186148k.b())).toString());     // Catch: Throwable -> L94
    L96:
        return r128;
    L94:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L96
    L60:
        r124 = 1.0d;
        goto L61
    L20:
        r110 = "0";
        goto L21
    L14:
        r109 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject getLogExtraJsonObject$default(ECStoreParam r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.a(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map getTabMetaInfo$default(ECStoreParam r100, Integer r101, Map r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getTabMetaInfo(r101, r102);
    }
}
