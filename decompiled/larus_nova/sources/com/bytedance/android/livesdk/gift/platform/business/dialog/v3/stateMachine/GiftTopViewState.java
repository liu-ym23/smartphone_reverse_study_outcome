package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.u0;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001^B\u0007¢\u0006\u0004\b\\\u0010]R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001c0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\rR'\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020 0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\rR'\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020$0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\rR'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\rR'\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020,0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\rR'\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002000\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\rR'\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002040\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\rR'\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002080\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\rR'\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020<0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010\rR'\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020@0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0005\u001a\u0004\bB\u0010\rR'\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020D0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0005\u001a\u0004\bF\u0010\rR'\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020H0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0005\u001a\u0004\bJ\u0010\rR'\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020L0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010\rR'\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020P0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0005\u001a\u0004\bR\u0010\rR'\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020T0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0005\u001a\u0004\bV\u0010\rR'\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020X0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0005\u001a\u0004\bZ\u0010\r¨\u0006_"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState$Mode;", "mode$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getMode", "()Lcom/bytedance/android/anya/r0;", "mode", "Lcom/bytedance/android/anya/u0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopEmptyState;", "emptySate$delegate", "getEmptySate", "()Lcom/bytedance/android/anya/u0;", "emptySate", "", "visibility$delegate", "getVisibility", RemoteMessageConst.Notification.VISIBILITY, "showAnim$delegate", "getShowAnim", "showAnim", "marketingHiddenAnim$delegate", "getMarketingHiddenAnim", "marketingHiddenAnim", "showDetail$delegate", "getShowDetail", "showDetail", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardViewState;", "buffCardViewState$delegate", "getBuffCardViewState", "buffCardViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxGrowthTouchState;", "lynxGrowthTouchState$delegate", "getLynxGrowthTouchState", "lynxGrowthTouchState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopDetailState;", "topDetailState$delegate", "getTopDetailState", "topDetailState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYViewState;", "diyCardViewState$delegate", "getDiyCardViewState", "diyCardViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftGroupViewState;", "groupViewState$delegate", "getGroupViewState", "groupViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftCustomBarViewState;", "customBarViewState$delegate", "getCustomBarViewState", "customBarViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopActivityState;", "activityState$delegate", "getActivityState", "activityState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopSeriesViewState;", "giftSeriesViewState$delegate", "getGiftSeriesViewState", "giftSeriesViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftMVICarnivalViewState;", "giftCarnivalViewState$delegate", "getGiftCarnivalViewState", "giftCarnivalViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopMarketingViewState;", "giftTopMarketingViewState$delegate", "getGiftTopMarketingViewState", "giftTopMarketingViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopBuffContainerViewState;", "giftBuffContainerViewState$delegate", "getGiftBuffContainerViewState", "giftBuffContainerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopDIYContainerViewState;", "giftDIYContainerViewState$delegate", "getGiftDIYContainerViewState", "giftDIYContainerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopGroupContainerViewState;", "giftGroupContainerViewState$delegate", "getGiftGroupContainerViewState", "giftGroupContainerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopCarouselViewState;", "giftCarouselViewState$delegate", "getGiftCarouselViewState", "giftCarouselViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopBannerContainerViewState;", "giftBannerViewState$delegate", "getGiftBannerViewState", "giftBannerViewState", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopCollectionViewState;", "giftCollectionViewState$delegate", "getGiftCollectionViewState", "giftCollectionViewState", "<init>", "()V", "Mode", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTopViewState extends MVIState<GiftTopViewState> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty activityState$delegate;
    private final ReadOnlyProperty buffCardViewState$delegate;
    private final ReadOnlyProperty customBarViewState$delegate;
    private final ReadOnlyProperty diyCardViewState$delegate;
    private final ReadOnlyProperty emptySate$delegate;
    private final ReadOnlyProperty giftBannerViewState$delegate;
    private final ReadOnlyProperty giftBuffContainerViewState$delegate;
    private final ReadOnlyProperty giftCarnivalViewState$delegate;
    private final ReadOnlyProperty giftCarouselViewState$delegate;
    private final ReadOnlyProperty giftCollectionViewState$delegate;
    private final ReadOnlyProperty giftDIYContainerViewState$delegate;
    private final ReadOnlyProperty giftGroupContainerViewState$delegate;
    private final ReadOnlyProperty giftSeriesViewState$delegate;
    private final ReadOnlyProperty giftTopMarketingViewState$delegate;
    private final ReadOnlyProperty groupViewState$delegate;
    private final ReadOnlyProperty lynxGrowthTouchState$delegate;
    private final ReadOnlyProperty marketingHiddenAnim$delegate;
    private final ReadOnlyProperty mode$delegate;
    private final ReadOnlyProperty showAnim$delegate;
    private final ReadOnlyProperty showDetail$delegate;
    private final ReadOnlyProperty topDetailState$delegate;
    private final ReadOnlyProperty visibility$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopViewState$Mode;", "", "(Ljava/lang/String;I)V", "Detail", "FansClub", "BuffCard", "IGift", "BagEntrance", "CustomGiftBagEntrance", "LynxGrowthTouch", "Group", "Default", "DIY", "Activity", "AuthFusion", "Series", "Marketing", "Carnival", "BuffContainer", "DIYContainer", "GroupContainer", "Carousel", "Banner", "Collection", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode Activity = null;
        public static final Mode AuthFusion = null;
        public static final Mode BagEntrance = null;
        public static final Mode Banner = null;
        public static final Mode BuffCard = null;
        public static final Mode BuffContainer = null;
        public static final Mode Carnival = null;
        public static final Mode Carousel = null;
        public static final Mode Collection = null;
        public static final Mode CustomGiftBagEntrance = null;
        public static final Mode DIY = null;
        public static final Mode DIYContainer = null;
        public static final Mode Default = null;
        public static final Mode Detail = null;
        public static final Mode FansClub = null;
        public static final Mode Group = null;
        public static final Mode GroupContainer = null;
        public static final Mode IGift = null;
        public static final Mode LynxGrowthTouch = null;
        public static final Mode Marketing = null;
        public static final Mode Series = null;

        static {
            Mode r100 = new Mode("Detail", 0);
            Detail = r100;
            Mode r101 = new Mode("FansClub", 1);
            FansClub = r101;
            Mode r102 = new Mode("BuffCard", 2);
            BuffCard = r102;
            Mode r103 = new Mode("IGift", 3);
            IGift = r103;
            Mode r104 = new Mode("BagEntrance", 4);
            BagEntrance = r104;
            Mode r105 = new Mode("CustomGiftBagEntrance", 5);
            CustomGiftBagEntrance = r105;
            Mode r106 = new Mode("LynxGrowthTouch", 6);
            LynxGrowthTouch = r106;
            Mode r107 = new Mode("Group", 7);
            Group = r107;
            Mode r108 = new Mode("Default", 8);
            Default = r108;
            Mode r109 = new Mode("DIY", 9);
            DIY = r109;
            Mode r110 = new Mode("Activity", 10);
            Activity = r110;
            Mode r111 = new Mode("AuthFusion", 11);
            AuthFusion = r111;
            Mode r112 = new Mode("Series", 12);
            Series = r112;
            Mode r113 = new Mode("Marketing", 13);
            Marketing = r113;
            Mode r114 = new Mode("Carnival", 14);
            Carnival = r114;
            Mode r115 = new Mode("BuffContainer", 15);
            BuffContainer = r115;
            Mode r116 = new Mode("DIYContainer", 16);
            DIYContainer = r116;
            Mode r117 = new Mode("GroupContainer", 17);
            GroupContainer = r117;
            Mode r118 = new Mode("Carousel", 18);
            Carousel = r118;
            Mode r119 = new Mode("Banner", 19);
            Banner = r119;
            Mode r120 = new Mode("Collection", 20);
            Collection = r120;
            $VALUES = new Mode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
        }

        public static Mode valueOf(String r100) {
            return (Mode) a.a(Mode.class, r100);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        private Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "mode", "getMode()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "emptySate", "getEmptySate()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, RemoteMessageConst.Notification.VISIBILITY, "getVisibility()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "showAnim", "getShowAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "marketingHiddenAnim", "getMarketingHiddenAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "showDetail", "getShowDetail()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "buffCardViewState", "getBuffCardViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "lynxGrowthTouchState", "getLynxGrowthTouchState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "topDetailState", "getTopDetailState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "diyCardViewState", "getDiyCardViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "groupViewState", "getGroupViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "customBarViewState", "getCustomBarViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "activityState", "getActivityState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftSeriesViewState", "getGiftSeriesViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftCarnivalViewState", "getGiftCarnivalViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftTopMarketingViewState", "getGiftTopMarketingViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftBuffContainerViewState", "getGiftBuffContainerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftDIYContainerViewState", "getGiftDIYContainerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftGroupContainerViewState", "getGiftGroupContainerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftCarouselViewState", "getGiftCarouselViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftBannerViewState", "getGiftBannerViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopViewState.class, "giftCollectionViewState", "getGiftCollectionViewState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final u0<GiftTopViewState, GiftTopActivityState> getActivityState() {
        return (u0) this.activityState$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final u0<GiftTopViewState, GiftBuffCardViewState> getBuffCardViewState() {
        return (u0) this.buffCardViewState$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final u0<GiftTopViewState, GiftCustomBarViewState> getCustomBarViewState() {
        return (u0) this.customBarViewState$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final u0<GiftTopViewState, GiftDIYViewState> getDiyCardViewState() {
        return (u0) this.diyCardViewState$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final u0<GiftTopViewState, GiftTopEmptyState> getEmptySate() {
        return (u0) this.emptySate$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final u0<GiftTopViewState, GiftTopBannerContainerViewState> getGiftBannerViewState() {
        return (u0) this.giftBannerViewState$delegate.getValue(this, $$delegatedProperties[20]);
    }

    public final u0<GiftTopViewState, GiftTopBuffContainerViewState> getGiftBuffContainerViewState() {
        return (u0) this.giftBuffContainerViewState$delegate.getValue(this, $$delegatedProperties[16]);
    }

    public final u0<GiftTopViewState, GiftMVICarnivalViewState> getGiftCarnivalViewState() {
        return (u0) this.giftCarnivalViewState$delegate.getValue(this, $$delegatedProperties[14]);
    }

    public final u0<GiftTopViewState, GiftTopCarouselViewState> getGiftCarouselViewState() {
        return (u0) this.giftCarouselViewState$delegate.getValue(this, $$delegatedProperties[19]);
    }

    public final u0<GiftTopViewState, GiftTopCollectionViewState> getGiftCollectionViewState() {
        return (u0) this.giftCollectionViewState$delegate.getValue(this, $$delegatedProperties[21]);
    }

    public final u0<GiftTopViewState, GiftTopDIYContainerViewState> getGiftDIYContainerViewState() {
        return (u0) this.giftDIYContainerViewState$delegate.getValue(this, $$delegatedProperties[17]);
    }

    public final u0<GiftTopViewState, GiftTopGroupContainerViewState> getGiftGroupContainerViewState() {
        return (u0) this.giftGroupContainerViewState$delegate.getValue(this, $$delegatedProperties[18]);
    }

    public final u0<GiftTopViewState, GiftTopSeriesViewState> getGiftSeriesViewState() {
        return (u0) this.giftSeriesViewState$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final u0<GiftTopViewState, GiftTopMarketingViewState> getGiftTopMarketingViewState() {
        return (u0) this.giftTopMarketingViewState$delegate.getValue(this, $$delegatedProperties[15]);
    }

    public final u0<GiftTopViewState, GiftGroupViewState> getGroupViewState() {
        return (u0) this.groupViewState$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final u0<GiftTopViewState, GiftLynxGrowthTouchState> getLynxGrowthTouchState() {
        return (u0) this.lynxGrowthTouchState$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<GiftTopViewState, Boolean> getMarketingHiddenAnim() {
        return (r0) this.marketingHiddenAnim$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final r0<GiftTopViewState, Mode> getMode() {
        return (r0) this.mode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftTopViewState, Boolean> getShowAnim() {
        return (r0) this.showAnim$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftTopViewState, Boolean> getShowDetail() {
        return (r0) this.showDetail$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final u0<GiftTopViewState, GiftTopDetailState> getTopDetailState() {
        return (u0) this.topDetailState$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final r0<GiftTopViewState, Boolean> getVisibility() {
        return (r0) this.visibility$delegate.getValue(this, $$delegatedProperties[2]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public GiftTopViewState() {
        Mode r100 = Mode.Default;
        Function1<c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        r r103 = new r(r100, r101, r102);
        KProperty[] r104 = $$delegatedProperties;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.mode$delegate = r103;
        Function1<c<STATE, ?>, Unit> r105 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r106 = this.propertyAddedCallback;
        SubStatePropertyImpl r107 = new SubStatePropertyImpl(GiftTopEmptyState.class, null, r105, r106);
        r107.f41672a = r104[1].getName();
        r106.invoke(r107);
        this.emptySate$delegate = r107;
        Boolean r108 = Boolean.TRUE;
        Function1<c<STATE, ?>, Unit> r109 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r110 = this.propertyAddedCallback;
        r r111 = new r(r108, r109, r110);
        r111.f41672a = r104[2].getName();
        r110.invoke(r111);
        this.visibility$delegate = r111;
        Boolean r112 = Boolean.FALSE;
        Function1<c<STATE, ?>, Unit> r113 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r114 = this.propertyAddedCallback;
        r r115 = new r(r112, r113, r114);
        r115.f41672a = r104[3].getName();
        r114.invoke(r115);
        this.showAnim$delegate = r115;
        Function1<c<STATE, ?>, Unit> r116 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r117 = this.propertyAddedCallback;
        r r118 = new r(r112, r116, r117);
        r118.f41672a = r104[4].getName();
        r117.invoke(r118);
        this.marketingHiddenAnim$delegate = r118;
        Function1<c<STATE, ?>, Unit> r119 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r120 = this.propertyAddedCallback;
        r r121 = new r(r112, r119, r120);
        r121.f41672a = r104[5].getName();
        r120.invoke(r121);
        this.showDetail$delegate = r121;
        Function1<c<STATE, ?>, Unit> r122 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r123 = this.propertyAddedCallback;
        SubStatePropertyImpl r124 = new SubStatePropertyImpl(GiftBuffCardViewState.class, null, r122, r123);
        r124.f41672a = r104[6].getName();
        r123.invoke(r124);
        this.buffCardViewState$delegate = r124;
        Function1<c<STATE, ?>, Unit> r125 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r126 = this.propertyAddedCallback;
        SubStatePropertyImpl r127 = new SubStatePropertyImpl(GiftLynxGrowthTouchState.class, null, r125, r126);
        r127.f41672a = r104[7].getName();
        r126.invoke(r127);
        this.lynxGrowthTouchState$delegate = r127;
        Function1<c<STATE, ?>, Unit> r128 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r129 = this.propertyAddedCallback;
        SubStatePropertyImpl r130 = new SubStatePropertyImpl(GiftTopDetailState.class, null, r128, r129);
        r130.f41672a = r104[8].getName();
        r129.invoke(r130);
        this.topDetailState$delegate = r130;
        Function1<c<STATE, ?>, Unit> r131 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r132 = this.propertyAddedCallback;
        SubStatePropertyImpl r133 = new SubStatePropertyImpl(GiftDIYViewState.class, null, r131, r132);
        r133.f41672a = r104[9].getName();
        r132.invoke(r133);
        this.diyCardViewState$delegate = r133;
        Function1<c<STATE, ?>, Unit> r134 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r135 = this.propertyAddedCallback;
        SubStatePropertyImpl r136 = new SubStatePropertyImpl(GiftGroupViewState.class, null, r134, r135);
        r136.f41672a = r104[10].getName();
        r135.invoke(r136);
        this.groupViewState$delegate = r136;
        Function1<c<STATE, ?>, Unit> r137 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r138 = this.propertyAddedCallback;
        SubStatePropertyImpl r139 = new SubStatePropertyImpl(GiftCustomBarViewState.class, null, r137, r138);
        r139.f41672a = r104[11].getName();
        r138.invoke(r139);
        this.customBarViewState$delegate = r139;
        Function1<c<STATE, ?>, Unit> r140 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r141 = this.propertyAddedCallback;
        SubStatePropertyImpl r142 = new SubStatePropertyImpl(GiftTopActivityState.class, null, r140, r141);
        r142.f41672a = r104[12].getName();
        r141.invoke(r142);
        this.activityState$delegate = r142;
        Function1<c<STATE, ?>, Unit> r143 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r144 = this.propertyAddedCallback;
        SubStatePropertyImpl r145 = new SubStatePropertyImpl(GiftTopSeriesViewState.class, null, r143, r144);
        r145.f41672a = r104[13].getName();
        r144.invoke(r145);
        this.giftSeriesViewState$delegate = r145;
        Function1<c<STATE, ?>, Unit> r146 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r147 = this.propertyAddedCallback;
        SubStatePropertyImpl r148 = new SubStatePropertyImpl(GiftMVICarnivalViewState.class, null, r146, r147);
        r148.f41672a = r104[14].getName();
        r147.invoke(r148);
        this.giftCarnivalViewState$delegate = r148;
        Function1<c<STATE, ?>, Unit> r149 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r150 = this.propertyAddedCallback;
        SubStatePropertyImpl r151 = new SubStatePropertyImpl(GiftTopMarketingViewState.class, null, r149, r150);
        r151.f41672a = r104[15].getName();
        r150.invoke(r151);
        this.giftTopMarketingViewState$delegate = r151;
        Function1<c<STATE, ?>, Unit> r152 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r153 = this.propertyAddedCallback;
        SubStatePropertyImpl r154 = new SubStatePropertyImpl(GiftTopBuffContainerViewState.class, null, r152, r153);
        r154.f41672a = r104[16].getName();
        r153.invoke(r154);
        this.giftBuffContainerViewState$delegate = r154;
        Function1<c<STATE, ?>, Unit> r155 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r156 = this.propertyAddedCallback;
        SubStatePropertyImpl r157 = new SubStatePropertyImpl(GiftTopDIYContainerViewState.class, null, r155, r156);
        r157.f41672a = r104[17].getName();
        r156.invoke(r157);
        this.giftDIYContainerViewState$delegate = r157;
        Function1<c<STATE, ?>, Unit> r158 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r159 = this.propertyAddedCallback;
        SubStatePropertyImpl r160 = new SubStatePropertyImpl(GiftTopGroupContainerViewState.class, null, r158, r159);
        r160.f41672a = r104[18].getName();
        r159.invoke(r160);
        this.giftGroupContainerViewState$delegate = r160;
        Function1<c<STATE, ?>, Unit> r161 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r162 = this.propertyAddedCallback;
        SubStatePropertyImpl r163 = new SubStatePropertyImpl(GiftTopCarouselViewState.class, null, r161, r162);
        r163.f41672a = r104[19].getName();
        r162.invoke(r163);
        this.giftCarouselViewState$delegate = r163;
        Function1<c<STATE, ?>, Unit> r164 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r165 = this.propertyAddedCallback;
        SubStatePropertyImpl r166 = new SubStatePropertyImpl(GiftTopBannerContainerViewState.class, null, r164, r165);
        r166.f41672a = r104[20].getName();
        r165.invoke(r166);
        this.giftBannerViewState$delegate = r166;
        Function1<c<STATE, ?>, Unit> r167 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r168 = this.propertyAddedCallback;
        SubStatePropertyImpl r169 = new SubStatePropertyImpl(GiftTopCollectionViewState.class, null, r167, r168);
        r169.f41672a = r104[21].getName();
        r168.invoke(r169);
        this.giftCollectionViewState$delegate = r169;
    }
}
