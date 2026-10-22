package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel;

import a20.g;
import a20.i;
import a20.j;
import a20.k;
import a20.l;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import f10.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 °\u00012\u00020\u00012\u00020\u00022\u00020\u0002:\u0002±\u0001B\t¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J2\u0010\u000f\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0003H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0007J\b\u0010#\u001a\u00020\u0005H\u0015J\b\u0010$\u001a\u00020\u0005H\u0017J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016JT\u0010*\u001a\u00020\u00052\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0&0&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0&2\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0&0&2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0&2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\t\u0010+\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0096\u0001J\r\u0010/\u001a\u00020\u0005*\u00020,H\u0096\u0001R\"\u00100\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00107\u001a\b\u0012\u0004\u0012\u0002060\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010BR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010BR&\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0G0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010BR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0006¢\u0006\f\n\u0004\bI\u0010B\u001a\u0004\bJ\u0010KR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010BR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010BR \u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010BR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010BR>\u0010Q\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u0003\u0012\u0004\u0012\u00020\r0P0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010BR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001c0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010BR \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010BR \u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0&0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010BR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010BR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010BR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010BR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010BR\"\u0010Y\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00030@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010BR\"\u0010Z\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00030@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010BR\u001b\u0010`\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bb\u0010]\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bg\u0010]\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bl\u0010]\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bq\u0010]\u001a\u0004\br\u0010sR\u001b\u0010y\u001a\u00020u8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bv\u0010]\u001a\u0004\bw\u0010xR\u001b\u0010~\u001a\u00020z8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b{\u0010]\u001a\u0004\b|\u0010}R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0081\u0001R\u001d\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0081\u0001R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0081\u0001R\u001d\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0081\u0001R(\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0G0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u0081\u0001R\u001d\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u0081\u0001R\u001d\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u0081\u0001R#\u0010\u008f\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u0081\u0001R\u001d\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0081\u0001RA\u0010\u0093\u0001\u001a,\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u0003\u0012\u0004\u0012\u00020\r0P0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0081\u0001R\u001d\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0081\u0001R#\u0010\u0097\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0081\u0001R#\u0010\u0099\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0&0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0081\u0001R\u001d\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u0081\u0001R\u001d\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u0081\u0001R\u001d\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u0081\u0001R\u001d\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u0081\u0001R%\u0010£\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00030\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u0081\u0001R%\u0010¥\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00030\u007f8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u0081\u0001R\u0018\u0010©\u0001\u001a\u00030¦\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\"\u0010\u00ad\u0001\u001a\r\u0012\u0004\u0012\u000206\u0012\u0002\b\u00030ª\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001¨\u0006²\u0001"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewmodel/AbsOpenFeaturePanelViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "data", "", "showOpenFeatureGroupList", "Lc20/c;", "showOpenFeatureTabList", "", "tabNameList", "Lf10/f;", IconList.ELEM_NAME, "", "isFromCache", "showOpenFeatureTabListOld", "showNoOpenFeatureGroupListData", "showNoOpenFeatureTabListData", "event", "onEvent", "openSearchPage", "hideMountView", AppConstants.BUNDLE_TIP, "url", "showFeatureDescTip", "dismissContainer", "isShow", "setLoadingViewState", "", "index", "changeOpenFeatureTabIndex", "showNoDataListReceive", "showRequestOpenFeatureListError", "showOpenFeatureSearchResult", WidgetCostModule.TYPE_ON_CREATE, "onCleared", LiveCommonConstants.REASON_ON_DEDTROY, "showOpenFeatureListData", "", "groupIconList", "groupNameList", "tabIconList", "showOpenFeatureListOldData", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "hasReceivedOpenFeatureListData", "Z", "getHasReceivedOpenFeatureListData", "()Z", "setHasReceivedOpenFeatureListData", "(Z)V", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "gameDisplayItemList", "Ljava/util/List;", "getGameDisplayItemList", "()Ljava/util/List;", "setGameDisplayItemList", "(Ljava/util/List;)V", "gameIconList", "getGameIconList", "setGameIconList", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_openFeatureSearchFragment", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_openFeatureChooseFragment", "_changeShowIntroPanel", "_hideMountView", "_openFeatureDescPage", "Lkotlin/Pair;", "_showFeatureDescTip", "hasRecentUseGroup", "getHasRecentUseGroup", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_closePanel", "_openFeatureListLoadingState", "_openFeatureGroupListData", "_openFeatureTabListData", "Lkotlin/Triple;", "_openFeatureTabListOldData", "_openFeatureTabIndexData", "_openFeatureAllItemListData", "_openFeatureAllGameListData", "_noOpenFeatureGroupListData", "_noOpenFeatureTabListData", "_noOpenFeatureListData", "_requestOpenFeatureListDataError", "_openFeatureSearchResult", "_openFeatureNewSearchResult", "La20/k;", "featurePanelModel$delegate", "Lkotlin/Lazy;", "getFeaturePanelModel", "()La20/k;", "featurePanelModel", "La20/i;", "featureListHandler$delegate", "getFeatureListHandler", "()La20/i;", "featureListHandler", "La20/l;", "featureSearchHandler$delegate", "getFeatureSearchHandler", "()La20/l;", "featureSearchHandler", "La20/j;", "featureNewSearchHandler$delegate", "getFeatureNewSearchHandler", "()La20/j;", "featureNewSearchHandler", "La20/g;", "featureIconRunningStateManager$delegate", "getFeatureIconRunningStateManager", "()La20/g;", "featureIconRunningStateManager", "La20/f;", "featureIconRecentUsedManager$delegate", "getFeatureIconRecentUsedManager", "()La20/f;", "featureIconRecentUsedManager", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/business/j;", "openFeatureSearchPageCacheHelper$delegate", "getOpenFeatureSearchPageCacheHelper", "()Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/business/j;", "openFeatureSearchPageCacheHelper", "Landroidx/lifecycle/LiveData;", "getOpenSearchPage", "()Landroidx/lifecycle/LiveData;", "getOpenChoosePage", "openChoosePage", "getChangeShowIntroPanel", "changeShowIntroPanel", "getHideMountView", "getOpenDescPage", "openDescPage", "getShowFeatureDescTip", "getClosePanel", "closePanel", "getOpenFeatureListLoadingState", "openFeatureListLoadingState", "getOpenFeatureGroupListData", "openFeatureGroupListData", "getOpenFeatureTabListData", "openFeatureTabListData", "getOpenFeatureTabListOldData", "openFeatureTabListOldData", "getOpenFeatureTabIndexData", "openFeatureTabIndexData", "getOpenFeatureAllItemListData", "openFeatureAllItemListData", "getOpenFeatureAllGameListData", "openFeatureAllGameListData", "getNoOpenFeatureGroupListData", "noOpenFeatureGroupListData", "getNoOpenFeatureTabListData", "noOpenFeatureTabListData", "getNoOpenFeatureListData", "noOpenFeatureListData", "getRequestOpenFeatureListDataError", "requestOpenFeatureListDataError", "getOpenFeatureSearchResult", "openFeatureSearchResult", "getOpenFeatureNewSearchResult", "openFeatureNewSearchResult", "La20/d;", "getFeatureIconBehaviorController", "()La20/d;", "featureIconBehaviorController", "Le10/a;", "getOpenFeatureFilter", "()Le10/a;", "openFeatureFilter", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsOpenFeaturePanelViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String IS_IN_LIVE = "is_in_live";
    public static final String TAG = "AbsOpenFeaturePanelViewModel";
    private final /* synthetic */ i20.a $$delegate_0;
    private final NextLiveData<Boolean> _changeShowIntroPanel;
    private final NextLiveData<Boolean> _closePanel;
    private final NextLiveData<Boolean> _hideMountView;
    private final NextLiveData<Boolean> _noOpenFeatureGroupListData;
    private final NextLiveData<Boolean> _noOpenFeatureListData;
    private final NextLiveData<Boolean> _noOpenFeatureTabListData;
    private final NextLiveData<List<f>> _openFeatureAllGameListData;
    private final NextLiveData<List<Object>> _openFeatureAllItemListData;
    private final NextLiveData<Boolean> _openFeatureChooseFragment;
    private final NextLiveData<Boolean> _openFeatureDescPage;
    private final NextLiveData<List<Object>> _openFeatureGroupListData;
    private final NextLiveData<Boolean> _openFeatureListLoadingState;
    private final NextLiveData<List<f>> _openFeatureNewSearchResult;
    private final NextLiveData<Boolean> _openFeatureSearchFragment;
    private final NextLiveData<List<f>> _openFeatureSearchResult;
    private final NextLiveData<Integer> _openFeatureTabIndexData;
    private final NextLiveData<c20.c> _openFeatureTabListData;
    private final NextLiveData<Triple<List<String>, List<List<f>>, Boolean>> _openFeatureTabListOldData;
    private final NextLiveData<Boolean> _requestOpenFeatureListDataError;
    private final NextLiveData<Pair<String, String>> _showFeatureDescTip;
    private final Lazy featureIconRecentUsedManager$delegate;
    private final Lazy featureIconRunningStateManager$delegate;
    private final Lazy featureListHandler$delegate;
    private final Lazy featureNewSearchHandler$delegate;
    private final Lazy featurePanelModel$delegate;
    private final Lazy featureSearchHandler$delegate;
    private List<InteractEntranceCell> gameDisplayItemList;
    private List<f> gameIconList;
    private volatile boolean hasReceivedOpenFeatureListData;
    private final NextLiveData<Boolean> hasRecentUseGroup;
    private final Lazy openFeatureSearchPageCacheHelper$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static AbsOpenFeaturePanelViewModel a(boolean r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
            if (r100 == false) goto L9;
            FragmentActivity r102 = r101.getActivity();
            if (r102 == null) goto L16;
            LiveOpenFeaturePanelViewModel r103 = (LiveOpenFeaturePanelViewModel) ViewModelProviders.of(r102).get(LiveOpenFeaturePanelViewModel.class);
            if (r103 == null) goto L16;
            return r103;
        L16:
            return (LiveOpenFeaturePanelViewModel) ViewModelProviders.of(r101).get(LiveOpenFeaturePanelViewModel.class);
        L9:
            FragmentActivity r104 = r101.getActivity();
            if (r104 == null) goto L14;
            PreviewOpenFeaturePanelViewModel r105 = (PreviewOpenFeaturePanelViewModel) ViewModelProviders.of(r104).get(PreviewOpenFeaturePanelViewModel.class);
            if (r105 == null) goto L14;
            return r105;
        L14:
            return (PreviewOpenFeaturePanelViewModel) ViewModelProviders.of(r101).get(PreviewOpenFeaturePanelViewModel.class);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsOpenFeaturePanelViewModel f61683a;

        public b(AbsOpenFeaturePanelViewModel r100) {
            this.f61683a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AbsOpenFeaturePanelViewModel r101 = this.f61683a;
            AbsOpenFeaturePanelViewModel.access$onEvent(r101, (f0) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsOpenFeaturePanelViewModel f61684a;

        public c(AbsOpenFeaturePanelViewModel r100) {
            this.f61684a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AbsOpenFeaturePanelViewModel r101 = this.f61684a;
            AbsOpenFeaturePanelViewModel.access$onEvent(r101, (d10.b) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsOpenFeaturePanelViewModel f61685a;

        public d(AbsOpenFeaturePanelViewModel r100) {
            this.f61685a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AbsOpenFeaturePanelViewModel r101 = this.f61685a;
            AbsOpenFeaturePanelViewModel.access$onEvent(r101, (d10.d) r100);
        }
    }

    static {
        Companion = new a();
    }

    private final k getFeaturePanelModel() {
        return (k) this.featurePanelModel$delegate.getValue();
    }

    @JvmStatic
    public static final AbsOpenFeaturePanelViewModel initViewModel(boolean r100, Fragment r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    public void autoDispose(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.$$delegate_0.a(r100);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public abstract a20.d getFeatureIconBehaviorController();

    public a20.f getFeatureIconRecentUsedManager() {
        return (a20.f) this.featureIconRecentUsedManager$delegate.getValue();
    }

    public g getFeatureIconRunningStateManager() {
        return (g) this.featureIconRunningStateManager$delegate.getValue();
    }

    public i getFeatureListHandler() {
        return (i) this.featureListHandler$delegate.getValue();
    }

    public j getFeatureNewSearchHandler() {
        return (j) this.featureNewSearchHandler$delegate.getValue();
    }

    public l getFeatureSearchHandler() {
        return (l) this.featureSearchHandler$delegate.getValue();
    }

    public abstract e10.a<InteractEntranceCell, ?> getOpenFeatureFilter();

    public com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.j getOpenFeatureSearchPageCacheHelper() {
        return (com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.j) this.openFeatureSearchPageCacheHelper$delegate.getValue();
    }

    public abstract /* synthetic */ boolean isHiding();

    public abstract /* synthetic */ boolean isInLive();

    private final void showNoOpenFeatureGroupListData() {
        this._noOpenFeatureGroupListData.setValue(Boolean.TRUE);
    }

    private final void showNoOpenFeatureTabListData() {
        this._noOpenFeatureTabListData.setValue(Boolean.TRUE);
    }

    public void dismissContainer() {
        this._closePanel.setValue(Boolean.TRUE);
    }

    public void hideMountView() {
        this._hideMountView.setValue(Boolean.TRUE);
    }

    public void openSearchPage() {
        this._openFeatureSearchFragment.setValue(Boolean.TRUE);
    }

    public void showNoDataListReceive() {
        if (this.hasReceivedOpenFeatureListData == true) goto L6;
        setLoadingViewState(false);
        this._noOpenFeatureListData.setValue(Boolean.TRUE);
        return;
    }

    public void showRequestOpenFeatureListError() {
        if (this.hasReceivedOpenFeatureListData == true) goto L6;
        setLoadingViewState(false);
        this._requestOpenFeatureListDataError.setValue(Boolean.TRUE);
        return;
    }

    public AbsOpenFeaturePanelViewModel() {
        this.$$delegate_0 = new i20.a();
        onCreate();
        this.gameDisplayItemList = new ArrayList();
        this.gameIconList = new ArrayList();
        this._openFeatureSearchFragment = new NextLiveData();
        this._openFeatureChooseFragment = new NextLiveData();
        this._changeShowIntroPanel = new NextLiveData();
        this._hideMountView = new NextLiveData();
        this._openFeatureDescPage = new NextLiveData();
        this._showFeatureDescTip = new NextLiveData();
        this.hasRecentUseGroup = new NextLiveData();
        this._closePanel = new NextLiveData();
        this._openFeatureListLoadingState = new NextLiveData();
        this._openFeatureGroupListData = new NextLiveData();
        this._openFeatureTabListData = new NextLiveData();
        this._openFeatureTabListOldData = new NextLiveData();
        this._openFeatureTabIndexData = new NextLiveData();
        this._openFeatureAllItemListData = new NextLiveData();
        this._openFeatureAllGameListData = new NextLiveData();
        this._noOpenFeatureGroupListData = new NextLiveData();
        this._noOpenFeatureTabListData = new NextLiveData();
        this._noOpenFeatureListData = new NextLiveData();
        this._requestOpenFeatureListDataError = new NextLiveData();
        this._openFeatureSearchResult = new NextLiveData();
        this._openFeatureNewSearchResult = new NextLiveData();
        this.featurePanelModel$delegate = InfraKotlinExtsKt.mainThreadLazy(AbsOpenFeaturePanelViewModel$featurePanelModel$2.INSTANCE);
        this.featureListHandler$delegate = InfraKotlinExtsKt.mainThreadLazy(new AbsOpenFeaturePanelViewModel$featureListHandler$2(this));
        this.featureSearchHandler$delegate = InfraKotlinExtsKt.mainThreadLazy(new AbsOpenFeaturePanelViewModel$featureSearchHandler$2(this));
        this.featureNewSearchHandler$delegate = InfraKotlinExtsKt.mainThreadLazy(new AbsOpenFeaturePanelViewModel$featureNewSearchHandler$2(this));
        this.featureIconRunningStateManager$delegate = InfraKotlinExtsKt.mainThreadLazy(AbsOpenFeaturePanelViewModel$featureIconRunningStateManager$2.INSTANCE);
        this.featureIconRecentUsedManager$delegate = InfraKotlinExtsKt.mainThreadLazy(AbsOpenFeaturePanelViewModel$featureIconRecentUsedManager$2.INSTANCE);
        this.openFeatureSearchPageCacheHelper$delegate = InfraKotlinExtsKt.mainThreadLazy(AbsOpenFeaturePanelViewModel$openFeatureSearchPageCacheHelper$2.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        onDestroy();
    }

    public final void onCreate() {
        autoDispose(xs2.b.a().b(f0.class).subscribe(new b(this)));
        autoDispose(xs2.b.a().b(d10.b.class).subscribe(new c(this)));
        autoDispose(xs2.b.a().b(d10.d.class).subscribe(new d(this)));
    }

    public void onDestroy() {
        dismissContainer();
        getFeatureListHandler().onDestroy();
        getFeatureSearchHandler().onDestroy();
        getFeatureIconBehaviorController().onDestroy();
        getFeatureIconRecentUsedManager().clear();
        getFeatureIconRunningStateManager().clear();
        dispose();
    }

    public LiveData<Boolean> getChangeShowIntroPanel() {
        return this._changeShowIntroPanel;
    }

    public LiveData<Boolean> getClosePanel() {
        return this._closePanel;
    }

    public final List<InteractEntranceCell> getGameDisplayItemList() {
        return this.gameDisplayItemList;
    }

    public final List<f> getGameIconList() {
        return this.gameIconList;
    }

    public final boolean getHasReceivedOpenFeatureListData() {
        return this.hasReceivedOpenFeatureListData;
    }

    public final NextLiveData<Boolean> getHasRecentUseGroup() {
        return this.hasRecentUseGroup;
    }

    public LiveData<Boolean> getHideMountView() {
        return this._hideMountView;
    }

    public LiveData<Boolean> getNoOpenFeatureGroupListData() {
        return this._noOpenFeatureGroupListData;
    }

    public LiveData<Boolean> getNoOpenFeatureListData() {
        return this._noOpenFeatureListData;
    }

    public LiveData<Boolean> getNoOpenFeatureTabListData() {
        return this._noOpenFeatureTabListData;
    }

    public LiveData<Boolean> getOpenChoosePage() {
        return this._openFeatureChooseFragment;
    }

    public LiveData<Boolean> getOpenDescPage() {
        return this._openFeatureDescPage;
    }

    public LiveData<List<f>> getOpenFeatureAllGameListData() {
        return this._openFeatureAllGameListData;
    }

    public LiveData<List<Object>> getOpenFeatureAllItemListData() {
        return this._openFeatureAllItemListData;
    }

    public LiveData<List<Object>> getOpenFeatureGroupListData() {
        return this._openFeatureGroupListData;
    }

    public LiveData<Boolean> getOpenFeatureListLoadingState() {
        return this._openFeatureListLoadingState;
    }

    public LiveData<List<f>> getOpenFeatureNewSearchResult() {
        return this._openFeatureNewSearchResult;
    }

    public LiveData<List<f>> getOpenFeatureSearchResult() {
        return this._openFeatureSearchResult;
    }

    public LiveData<Integer> getOpenFeatureTabIndexData() {
        return this._openFeatureTabIndexData;
    }

    public LiveData<c20.c> getOpenFeatureTabListData() {
        return this._openFeatureTabListData;
    }

    public LiveData<Triple<List<String>, List<List<f>>, Boolean>> getOpenFeatureTabListOldData() {
        return this._openFeatureTabListOldData;
    }

    public LiveData<Boolean> getOpenSearchPage() {
        return this._openFeatureSearchFragment;
    }

    public LiveData<Boolean> getRequestOpenFeatureListDataError() {
        return this._requestOpenFeatureListDataError;
    }

    public LiveData<Pair<String, String>> getShowFeatureDescTip() {
        return this._showFeatureDescTip;
    }

    public static final /* synthetic */ k access$getFeaturePanelModel$p(AbsOpenFeaturePanelViewModel r100) {
        return r100.getFeaturePanelModel();
    }

    private final void onEvent(Object r100) {
        if ((r100 instanceof f0) == false) goto L27;
        int r101 = q.f60744a;
        q.g(r100.toString(), TAG);
        f0 r102 = (f0) r100;
        if (r102.f59340c == false) goto L10;
        if (r2.a(r102.f59338a) == false) goto L10;
        getFeatureIconRecentUsedManager().c(r102.f59338a);
    L10:
        if (r102.f59341d == true) goto L12;
    L14:
        getFeatureIconRunningStateManager().b(r102.f59338a);
    L16:
        if (r102.f59339b != ReloadPanelType.FROM_CAHCE) goto L19;
        getFeatureListHandler().e();
        showOpenFeatureSearchResult(this._openFeatureSearchResult.getValue());
    L19:
        if (r102.f59339b != ReloadPanelType.FROM_SEVER) goto L22;
        getFeatureListHandler().h();
    L22:
        if (isInLive() == false) goto L24;
        return;
    L24:
        if (r102.f59341d == false) goto L38;
        dismissContainer();
        return;
    L38:
        return;
    L12:
        if (r2.a(r102.f59338a) == false) goto L14;
        getFeatureIconRunningStateManager().c(r102.f59338a, isInLive());
        goto L16
    L27:
        if ((r100 instanceof d10.b) == false) goto L32;
        if (((d10.b) r100).f466249a != isInLive()) goto L40;
        dismissContainer();
        return;
    L40:
        return;
    L32:
        if ((r100 instanceof d10.d) == true) goto L34;
        return;
    L34:
        if (isInLive() == true) goto L43;
        hideMountView();
        return;
    }

    private final void showOpenFeatureGroupList(List<? extends Object> r100) {
        this._openFeatureGroupListData.setValue(r100);
    }

    private final void showOpenFeatureTabList(c20.c r100) {
        this._openFeatureTabListData.setValue(r100);
    }

    public void changeOpenFeatureTabIndex(int r100) {
        this._openFeatureTabIndexData.setValue(Integer.valueOf(r100));
    }

    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        i20.a r101 = this.$$delegate_0;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "d");
        r101.f488036a.remove(r100);
    }

    public final void setGameDisplayItemList(List<InteractEntranceCell> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameDisplayItemList = r100;
    }

    public final void setGameIconList(List<f> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameIconList = r100;
    }

    public final void setHasReceivedOpenFeatureListData(boolean r100) {
        this.hasReceivedOpenFeatureListData = r100;
    }

    public void setLoadingViewState(boolean r100) {
        this._openFeatureListLoadingState.setValue(Boolean.valueOf(r100));
    }

    public void showOpenFeatureListData(c20.c r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        if ((!r110.f22129a.isEmpty()) == false) goto L5;
    L6:
        this.hasReceivedOpenFeatureListData = true;
    L7:
        int r100 = 0;
        if (r110.f22129a.isEmpty() == false) goto L13;
        if (r110.f22131c.isEmpty() == false) goto L13;
        this.hasReceivedOpenFeatureListData = false;
        showNoDataListReceive();
        return;
    L13:
        if (r110.f22129a.isEmpty() == true) goto L15;
    L17:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r110.f22129a.iterator();
    L19:
        if (r102.hasNext() == false) goto L39;
        Object r103 = r102.next();
        int r104 = r100 + 1;
        if (r100 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        List r105 = (List) r103;
        if (r100 >= r110.f22130b.size()) goto L26;
        r101.add(new f10.b((String) ListProtector.get(r110.f22130b, r100)));
    L28:
        if (Intrinsics.areEqual((String) ListProtector.get(r110.f22130b, r100), "最近使用") == false) goto L33;
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L33;
        r101.add(new f10.d(r105));
    L38:
        r100 = r104;
    L33:
        if (Intrinsics.areEqual((String) ListProtector.get(r110.f22130b, r100), "最近使用") == true) goto L35;
    L37:
        r101.addAll(r105);
        goto L38
    L35:
        if (r105.size() <= 5) goto L37;
        r101.add(new f10.d(r105));
        goto L38
    L26:
        r101.add(new f10.b(""));
        goto L28
    L39:
        showOpenFeatureGroupList(r101);
        if (r110.f22131c.isEmpty() == false) goto L42;
        showNoOpenFeatureTabListData();
        return;
    L42:
        showOpenFeatureTabList(r110);
        return;
    L15:
        if ((!r110.f22131c.isEmpty()) == false) goto L17;
        showNoOpenFeatureGroupListData();
        showOpenFeatureTabList(r110);
        return;
    L5:
        if ((!r110.f22131c.isEmpty()) == false) goto L7;
        goto L6
    }

    public void showOpenFeatureSearchResult(List<f> r100) {
        this._openFeatureSearchResult.setValue(r100);
    }

    public static final /* synthetic */ void access$onEvent(AbsOpenFeaturePanelViewModel r100, Object r101) {
        r100.onEvent(r101);
    }

    public void showFeatureDescTip(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, AppConstants.BUNDLE_TIP);
        Intrinsics.checkNotNullParameter(r101, "url");
        this._showFeatureDescTip.postValue(new Pair(r100, r101));
    }

    private final void showOpenFeatureTabListOld(List<String> r100, List<? extends List<f>> r101, boolean r102) {
        this._openFeatureTabListOldData.setValue(new Triple(r100, r101, Boolean.valueOf(r102)));
    }

    public void showOpenFeatureListOldData(List<List<f>> r100, List<String> r110, List<List<f>> r111, List<String> r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "groupIconList");
        Intrinsics.checkNotNullParameter(r110, "groupNameList");
        Intrinsics.checkNotNullParameter(r111, "tabIconList");
        Intrinsics.checkNotNullParameter(r112, "tabNameList");
        if ((!r100.isEmpty()) == false) goto L5;
    L6:
        this.hasReceivedOpenFeatureListData = true;
    L7:
        int r101 = 0;
        if (r100.isEmpty() == false) goto L13;
        if (r111.isEmpty() == false) goto L13;
        this.hasReceivedOpenFeatureListData = false;
        showNoDataListReceive();
        return;
    L13:
        if (r100.isEmpty() == true) goto L15;
    L17:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L19:
        if (r103.hasNext() == false) goto L34;
        Object r104 = r103.next();
        int r105 = r101 + 1;
        if (r101 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        List r106 = (List) r104;
        if (r101 >= r110.size()) goto L26;
        r102.add(new f10.b((String) ListProtector.get(r110, r101)));
    L28:
        if (Intrinsics.areEqual((String) ListProtector.get(r110, r101), "最近使用") == true) goto L30;
    L32:
        r102.addAll(r106);
    L33:
        r101 = r105;
        goto L19
    L30:
        if (r106.size() <= 5) goto L32;
        r102.add(new f10.d(r106));
        goto L33
    L26:
        r102.add(new f10.b(""));
        goto L28
    L34:
        showOpenFeatureGroupList(r102);
        if (r111.isEmpty() == false) goto L37;
        showNoOpenFeatureTabListData();
        return;
    L37:
        showOpenFeatureTabListOld(r112, r111, r113);
        return;
    L15:
        if ((!r111.isEmpty()) == false) goto L17;
        showNoOpenFeatureGroupListData();
        showOpenFeatureTabListOld(r112, r111, r113);
        return;
    L5:
        if ((!r111.isEmpty()) == false) goto L7;
        goto L6
    }
}
