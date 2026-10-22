package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.config.a9;
import com.bytedance.android.livesdk.ktvimpl.base.c;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import vm2.d;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\ba\u0010bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R$\u00100\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0006¢\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010-R8\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010706058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010 \u001a\u0004\b?\u0010\"\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0019\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR$\u0010E\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0012\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010\u0016R#\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b050)8\u0006¢\u0006\f\n\u0004\bH\u0010+\u001a\u0004\bI\u0010-R\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0006¢\u0006\f\n\u0004\bJ\u0010 \u001a\u0004\bK\u0010\"R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0006¢\u0006\f\n\u0004\bL\u0010+\u001a\u0004\bM\u0010-R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0006¢\u0006\f\n\u0004\bN\u0010+\u001a\u0004\bO\u0010-R\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0006¢\u0006\f\n\u0004\bP\u0010+\u001a\u0004\bQ\u0010-R!\u0010X\u001a\b\u0012\u0004\u0012\u00020S0R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR!\u0010]\u001a\b\u0012\u0004\u0012\u0002070Y8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010\\R\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020^0)8\u0006¢\u0006\f\n\u0004\b_\u0010+\u001a\u0004\b`\u0010-¨\u0006e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentUIContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "handleFeedLyricsSei", "", "isCurrentSingerInSeatList", "", "getSingApplyUnreadNum", "()Ljava/lang/Long;", "num", "setSingApplyUnreadNum", "getListenApplyUnreadNum", "setListenApplyUnreadNum", "handleFeedEnterData", "Lcom/bytedance/android/live/ktv/common/model/api/o0;", "selectedSecondLevelTab", "Lcom/bytedance/android/live/ktv/common/model/api/o0;", "getSelectedSecondLevelTab", "()Lcom/bytedance/android/live/ktv/common/model/api/o0;", "setSelectedSecondLevelTab", "(Lcom/bytedance/android/live/ktv/common/model/api/o0;)V", "", "selectedFirstLevelTab", "Ljava/lang/Integer;", "getSelectedFirstLevelTab", "()Ljava/lang/Integer;", "setSelectedFirstLevelTab", "(Ljava/lang/Integer;)V", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "multiChorusApplyTotalCount", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getMultiChorusApplyTotalCount", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "singleSingApplyTotalCount", "getSingleSingApplyTotalCount", "applySingUnreadNum", "getApplySingUnreadNum", "applyListenUnreadNum", "getApplyListenUnreadNum", "Landroidx/lifecycle/MutableLiveData;", "unreadMultiChorusApplyNum", "Landroidx/lifecycle/MutableLiveData;", "getUnreadMultiChorusApplyNum", "()Landroidx/lifecycle/MutableLiveData;", "myWantSingSongTotalNum", "getMyWantSingSongTotalNum", "currentShowingSelectedSubTab", "getCurrentShowingSelectedSubTab", "setCurrentShowingSelectedSubTab", "applyListenTotalNum", "getApplyListenTotalNum", "", "Lkotlin/Pair;", "", "orderSongReadList", "Ljava/util/List;", "getOrderSongReadList", "()Ljava/util/List;", "setOrderSongReadList", "(Ljava/util/List;)V", "orderSongUnReadNum", "getOrderSongUnReadNum", "setOrderSongUnReadNum", "(Lcom/bytedance/ies/sdk/widgets/NextLiveData;)V", "lastApplyMsgType", "getLastApplyMsgType", "setLastApplyMsgType", "orderedTabLastSelectedIndex", "getOrderedTabLastSelectedIndex", "setOrderedTabLastSelectedIndex", "selfWantListenSongList", "getSelfWantListenSongList", "showLyricsViewAndMidi", "getShowLyricsViewAndMidi", "scoreOpen", "getScoreOpen", "originOpen", "getOriginOpen", "singerScoreOpen", "getSingerScoreOpen", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/a;", "showOrHideAdjustDialogEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getShowOrHideAdjustDialogEvent", "()Lcom/bytedance/live/datacontext/n;", "showOrHideAdjustDialogEvent", "Lcom/bytedance/live/datacontext/k;", "permitUser$delegate", "getPermitUser", "()Lcom/bytedance/live/datacontext/k;", "permitUser", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "lyricsSeiModel", "getLyricsSeiModel", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentUIContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int MSG_LISTEN_LISTEN_CHANGED = 2;
    public static final int MSG_SING_APPLY_CHANGED = 1;
    private final MutableLiveData<Long> applyListenTotalNum;
    private final NextLiveData<Long> applyListenUnreadNum;
    private final NextLiveData<Long> applySingUnreadNum;
    private o0 currentShowingSelectedSubTab;
    private Integer lastApplyMsgType;
    private final MutableLiveData<k> lyricsSeiModel;
    private final NextLiveData<Long> multiChorusApplyTotalCount;
    private final MutableLiveData<Long> myWantSingSongTotalNum;
    private List<Pair<Long, String>> orderSongReadList;
    private NextLiveData<Integer> orderSongUnReadNum;
    private o0 orderedTabLastSelectedIndex;
    private final MutableLiveData<Boolean> originOpen;
    private final p permitUser$delegate;
    private final MutableLiveData<Boolean> scoreOpen;
    private Integer selectedFirstLevelTab;
    private o0 selectedSecondLevelTab;
    private final MutableLiveData<List<Long>> selfWantListenSongList;
    private final NextLiveData<Boolean> showLyricsViewAndMidi;
    private final p showOrHideAdjustDialogEvent$delegate;
    private final MutableLiveData<Boolean> singerScoreOpen;
    private final NextLiveData<Long> singleSingApplyTotalCount;
    private final MutableLiveData<Long> unreadMultiChorusApplyNum;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvComponentUIContext.class, "showOrHideAdjustDialogEvent", "getShowOrHideAdjustDialogEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentUIContext.class, "permitUser", "getPermitUser()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    public final com.bytedance.live.datacontext.k<String> getPermitUser() {
        return (com.bytedance.live.datacontext.k) this.permitUser$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.a> getShowOrHideAdjustDialogEvent() {
        return (n) this.showOrHideAdjustDialogEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final Long getListenApplyUnreadNum() {
        return this.applyListenUnreadNum.getValue();
    }

    public final Long getSingApplyUnreadNum() {
        return this.applySingUnreadNum.getValue();
    }

    public KtvComponentUIContext() {
        this.multiChorusApplyTotalCount = new NextLiveData();
        this.singleSingApplyTotalCount = new NextLiveData();
        this.applySingUnreadNum = new NextLiveData();
        this.applyListenUnreadNum = new NextLiveData();
        this.unreadMultiChorusApplyNum = new MutableLiveData();
        this.myWantSingSongTotalNum = new MutableLiveData();
        this.applyListenTotalNum = new MutableLiveData();
        this.orderSongReadList = new ArrayList();
        this.orderSongUnReadNum = new NextLiveData();
        this.selfWantListenSongList = new MutableLiveData();
        NextLiveData<Boolean> r100 = new NextLiveData();
        Boolean r101 = Boolean.TRUE;
        r100.setValue(r101);
        Unit r102 = Unit.INSTANCE;
        this.showLyricsViewAndMidi = r100;
        MutableLiveData<Boolean> r103 = new MutableLiveData();
        int r104 = c.f142400a;
        e<Boolean> r105 = com.bytedance.android.livesdk.sharedpref.c.I;
        boolean r106 = false;
        if (r105.getValue().booleanValue() == true) goto L17;
        f.d(r105, r101);
        if (j.i() == true) goto L11;
        e<Boolean> r107 = com.bytedance.android.livesdk.sharedpref.c.H;
        if (((a9) h.X2.getValue(null, h.f556082a[204(0xcc, float:2.86E-43)])).b() != 1) goto L9;
        boolean r108 = true;
    L10:
        Boolean r109 = Boolean.valueOf(r108);
        r107.getClass();
        f.d(r107, r109);
    L16:
        boolean r110 = com.bytedance.android.livesdk.sharedpref.c.H.getValue().booleanValue();
    L18:
        r103.setValue(Boolean.valueOf(r110));
        this.scoreOpen = r103;
        MutableLiveData<Boolean> r111 = new MutableLiveData();
        if (c.a() != 1) goto L21;
        r106 = true;
    L21:
        r111.setValue(Boolean.valueOf(r106));
        this.originOpen = r111;
        this.singerScoreOpen = new MutableLiveData(Boolean.FALSE);
        this.showOrHideAdjustDialogEvent$delegate = q.c(this);
        this.permitUser$delegate = com.bytedance.live.datacontext.e.b(this);
        this.lyricsSeiModel = new MutableLiveData();
        return;
    L9:
        r108 = false;
        goto L10
    L11:
        e<Boolean> r112 = com.bytedance.android.livesdk.sharedpref.c.H;
        if (((a9) h.X2.getValue(null, h.f556082a[204(0xcc, float:2.86E-43)])).a() != 1) goto L14;
        boolean r113 = true;
    L15:
        Boolean r114 = Boolean.valueOf(r113);
        r112.getClass();
        f.d(r112, r114);
        goto L16
    L14:
        r113 = false;
        goto L15
    L17:
        r110 = com.bytedance.android.livesdk.sharedpref.c.H.getValue().booleanValue();
        goto L18
    }

    public final MutableLiveData<Long> getApplyListenTotalNum() {
        return this.applyListenTotalNum;
    }

    public final NextLiveData<Long> getApplyListenUnreadNum() {
        return this.applyListenUnreadNum;
    }

    public final NextLiveData<Long> getApplySingUnreadNum() {
        return this.applySingUnreadNum;
    }

    public final o0 getCurrentShowingSelectedSubTab() {
        return this.currentShowingSelectedSubTab;
    }

    public final Integer getLastApplyMsgType() {
        return this.lastApplyMsgType;
    }

    public final MutableLiveData<k> getLyricsSeiModel() {
        return this.lyricsSeiModel;
    }

    public final NextLiveData<Long> getMultiChorusApplyTotalCount() {
        return this.multiChorusApplyTotalCount;
    }

    public final MutableLiveData<Long> getMyWantSingSongTotalNum() {
        return this.myWantSingSongTotalNum;
    }

    public final List<Pair<Long, String>> getOrderSongReadList() {
        return this.orderSongReadList;
    }

    public final NextLiveData<Integer> getOrderSongUnReadNum() {
        return this.orderSongUnReadNum;
    }

    public final o0 getOrderedTabLastSelectedIndex() {
        return this.orderedTabLastSelectedIndex;
    }

    public final MutableLiveData<Boolean> getOriginOpen() {
        return this.originOpen;
    }

    public final MutableLiveData<Boolean> getScoreOpen() {
        return this.scoreOpen;
    }

    public final Integer getSelectedFirstLevelTab() {
        return this.selectedFirstLevelTab;
    }

    public final o0 getSelectedSecondLevelTab() {
        return this.selectedSecondLevelTab;
    }

    public final MutableLiveData<List<Long>> getSelfWantListenSongList() {
        return this.selfWantListenSongList;
    }

    public final NextLiveData<Boolean> getShowLyricsViewAndMidi() {
        return this.showLyricsViewAndMidi;
    }

    public final MutableLiveData<Boolean> getSingerScoreOpen() {
        return this.singerScoreOpen;
    }

    public final NextLiveData<Long> getSingleSingApplyTotalCount() {
        return this.singleSingApplyTotalCount;
    }

    public final MutableLiveData<Long> getUnreadMultiChorusApplyNum() {
        return this.unreadMultiChorusApplyNum;
    }

    private final void handleFeedLyricsSei(DataCenter r100) {
        Object r101 = r100.get(ILiveRoomPlayFragmentConstant.VIDEO_KTV_SEI_MODEL);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof k) == false) goto L9;
        this.lyricsSeiModel.setValue((k) r101);
        return;
    }

    private final boolean isCurrentSingerInSeatList(DataCenter r100) {
        com.bytedance.android.live.base.model.user.o0.a r101 = com.bytedance.android.live.base.model.user.o0.f58946a;
        String r102 = (String) r100.get(ILiveRoomPlayFragmentConstant.VIDEO_KTV_CURRENT_SING_USER_ID, "");
        r101.getClass();
        boolean r103 = com.bytedance.android.live.base.model.user.o0.a.b(r102);
        boolean r104 = false;
        if (r103 == true) goto L5;
    L17:
        return r104;
    L5:
        if (((ArrayList) r100.get(ILiveRoomPlayFragmentConstant.FEED_LIVE_SEAT_LIST_MODEL, new ArrayList())).size() == 0) goto L17;
        Iterator r105 = ((ArrayList) r100.get(ILiveRoomPlayFragmentConstant.FEED_LIVE_SEAT_LIST_MODEL, new ArrayList())).iterator();
    L9:
        if (r105.hasNext() == false) goto L17;
        LinkPlayerInfo r106 = (LinkPlayerInfo) r105.next();
        com.bytedance.android.live.base.model.user.o0.a r107 = com.bytedance.android.live.base.model.user.o0.f58946a;
        IBaseUser r108 = r106.getUser();
        if (r108 == null) goto L13;
        String r109 = r108.getIdString();
    L14:
        String r110 = (String) r100.get(ILiveRoomPlayFragmentConstant.VIDEO_KTV_CURRENT_SING_USER_ID, "");
        r107.getClass();
        if (com.bytedance.android.live.base.model.user.o0.a.a(r109, r110) == false) goto L9;
        r104 = true;
        goto L9
    L13:
        r109 = null;
        goto L14
    }

    public final void handleFeedEnterData(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        if (d.q0().isFeedInfoTransport() == true) goto L5;
        return;
    L5:
        if (isCurrentSingerInSeatList(r100) == false) goto L9;
        handleFeedLyricsSei(r100);
        return;
    }

    public final void setCurrentShowingSelectedSubTab(o0 r100) {
        this.currentShowingSelectedSubTab = r100;
    }

    public final void setLastApplyMsgType(Integer r100) {
        this.lastApplyMsgType = r100;
    }

    public final void setListenApplyUnreadNum(long r100) {
        this.applyListenUnreadNum.setValue(Long.valueOf(r100));
    }

    public final void setOrderSongReadList(List<Pair<Long, String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.orderSongReadList = r100;
    }

    public final void setOrderSongUnReadNum(NextLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.orderSongUnReadNum = r100;
    }

    public final void setOrderedTabLastSelectedIndex(o0 r100) {
        this.orderedTabLastSelectedIndex = r100;
    }

    public final void setSelectedFirstLevelTab(Integer r100) {
        this.selectedFirstLevelTab = r100;
    }

    public final void setSelectedSecondLevelTab(o0 r100) {
        this.selectedSecondLevelTab = r100;
    }

    public final void setSingApplyUnreadNum(long r100) {
        this.applySingUnreadNum.setValue(Long.valueOf(r100));
    }
}
