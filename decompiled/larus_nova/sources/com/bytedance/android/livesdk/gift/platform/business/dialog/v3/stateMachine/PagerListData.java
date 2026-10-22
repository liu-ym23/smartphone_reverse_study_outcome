package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import android.net.Uri;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b6\u00107R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\rR'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\rR'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\rR'\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R'\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\rR'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\rR'\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\rR'\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\rR'\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020.0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\rR'\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\r¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PagerListData;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/t0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "itemDataList$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getItemDataList", "()Lcom/bytedance/android/anya/t0;", "itemDataList", "Lcom/bytedance/android/anya/r0;", "", "tabType$delegate", "getTabType", "()Lcom/bytedance/android/anya/r0;", "tabType", "", "emptyListDescription$delegate", "getEmptyListDescription", "emptyListDescription", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CounterData;", "counterDataList$delegate", "getCounterDataList", "counterDataList", "", "hasMoreData$delegate", "getHasMoreData", "hasMoreData", "", "selectedTopicId$delegate", "getSelectedTopicId", "selectedTopicId", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TopicPagerListData;", "topicPagerListData$delegate", "getTopicPagerListData", "topicPagerListData", "currentTopicPagerPosition$delegate", "getCurrentTopicPagerPosition", "currentTopicPagerPosition", "canSlideTopic$delegate", "getCanSlideTopic", "canSlideTopic", "isTopicPage$delegate", "isTopicPage", "hasHeader$delegate", "getHasHeader", "hasHeader", "Landroid/net/Uri;", "pageSchemaUri$delegate", "getPageSchemaUri", "pageSchemaUri", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftLynxPageConfig;", "pageLynxConfig$delegate", "getPageLynxConfig", "pageLynxConfig", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PagerListData extends MVIState<PagerListData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty canSlideTopic$delegate;
    private final ReadOnlyProperty counterDataList$delegate;
    private final ReadOnlyProperty currentTopicPagerPosition$delegate;
    private final ReadOnlyProperty emptyListDescription$delegate;
    private final ReadOnlyProperty hasHeader$delegate;
    private final ReadOnlyProperty hasMoreData$delegate;
    private final ReadOnlyProperty isTopicPage$delegate;
    private final ReadOnlyProperty itemDataList$delegate;
    private final ReadOnlyProperty pageLynxConfig$delegate;
    private final ReadOnlyProperty pageSchemaUri$delegate;
    private final ReadOnlyProperty selectedTopicId$delegate;
    private final ReadOnlyProperty tabType$delegate;
    private final ReadOnlyProperty topicPagerListData$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PagerListData.class, "itemDataList", "getItemDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "tabType", "getTabType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "emptyListDescription", "getEmptyListDescription()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "counterDataList", "getCounterDataList()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "hasMoreData", "getHasMoreData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "selectedTopicId", "getSelectedTopicId()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "topicPagerListData", "getTopicPagerListData()Lcom/bytedance/android/anya/StateListProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "currentTopicPagerPosition", "getCurrentTopicPagerPosition()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "canSlideTopic", "getCanSlideTopic()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "isTopicPage", "isTopicPage()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "hasHeader", "getHasHeader()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "pageSchemaUri", "getPageSchemaUri()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(PagerListData.class, "pageLynxConfig", "getPageLynxConfig()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<PagerListData, Boolean> getCanSlideTopic() {
        return (r0) this.canSlideTopic$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final t0<PagerListData, CounterData> getCounterDataList() {
        return (t0) this.counterDataList$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<PagerListData, Integer> getCurrentTopicPagerPosition() {
        return (r0) this.currentTopicPagerPosition$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<PagerListData, String> getEmptyListDescription() {
        return (r0) this.emptyListDescription$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<PagerListData, Boolean> getHasHeader() {
        return (r0) this.hasHeader$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final r0<PagerListData, Boolean> getHasMoreData() {
        return (r0) this.hasMoreData$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final t0<PagerListData, ItemListData> getItemDataList() {
        return (t0) this.itemDataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<PagerListData, GiftLynxPageConfig> getPageLynxConfig() {
        return (r0) this.pageLynxConfig$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final r0<PagerListData, Uri> getPageSchemaUri() {
        return (r0) this.pageSchemaUri$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final r0<PagerListData, Long> getSelectedTopicId() {
        return (r0) this.selectedTopicId$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<PagerListData, Integer> getTabType() {
        return (r0) this.tabType$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final t0<PagerListData, TopicPagerListData> getTopicPagerListData() {
        return (t0) this.topicPagerListData$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<PagerListData, Boolean> isTopicPage() {
        return (r0) this.isTopicPage$delegate.getValue(this, $$delegatedProperties[9]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public PagerListData() {
        List r100 = CollectionsKt.emptyList();
        Function1<c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        u r103 = new u(r100, r101, r102);
        KProperty[] r104 = $$delegatedProperties;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.itemDataList$delegate = r103;
        Function1<c<STATE, ?>, Unit> r105 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r106 = this.propertyAddedCallback;
        r r107 = new r(0, r105, r106);
        r107.f41672a = r104[1].getName();
        r106.invoke(r107);
        this.tabType$delegate = r107;
        Function1<c<STATE, ?>, Unit> r108 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r109 = this.propertyAddedCallback;
        r r110 = new r("", r108, r109);
        r110.f41672a = r104[2].getName();
        r109.invoke(r110);
        this.emptyListDescription$delegate = r110;
        List r111 = CollectionsKt.emptyList();
        Function1<c<STATE, ?>, Unit> r112 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r113 = this.propertyAddedCallback;
        u r114 = new u(r111, r112, r113);
        r114.f41672a = r104[3].getName();
        r113.invoke(r114);
        this.counterDataList$delegate = r114;
        Boolean r115 = Boolean.FALSE;
        Function1<c<STATE, ?>, Unit> r116 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r117 = this.propertyAddedCallback;
        r r118 = new r(r115, r116, r117);
        r118.f41672a = r104[4].getName();
        r117.invoke(r118);
        this.hasMoreData$delegate = r118;
        Function1<c<STATE, ?>, Unit> r119 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r120 = this.propertyAddedCallback;
        r r121 = new r(-1L, r119, r120);
        r121.f41672a = r104[5].getName();
        r120.invoke(r121);
        this.selectedTopicId$delegate = r121;
        List r122 = CollectionsKt.listOf(new TopicPagerListData());
        Function1<c<STATE, ?>, Unit> r123 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r124 = this.propertyAddedCallback;
        u r125 = new u(r122, r123, r124);
        r125.f41672a = r104[6].getName();
        r124.invoke(r125);
        this.topicPagerListData$delegate = r125;
        Function1<c<STATE, ?>, Unit> r126 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r127 = this.propertyAddedCallback;
        r r128 = new r(-1, r126, r127);
        r128.f41672a = r104[7].getName();
        r127.invoke(r128);
        this.currentTopicPagerPosition$delegate = r128;
        Function1<c<STATE, ?>, Unit> r129 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r130 = this.propertyAddedCallback;
        r r131 = new r(r115, r129, r130);
        r131.f41672a = r104[8].getName();
        r130.invoke(r131);
        this.canSlideTopic$delegate = r131;
        Function1<c<STATE, ?>, Unit> r132 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r133 = this.propertyAddedCallback;
        r r134 = new r(r115, r132, r133);
        r134.f41672a = r104[9].getName();
        r133.invoke(r134);
        this.isTopicPage$delegate = r134;
        Function1<c<STATE, ?>, Unit> r135 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r136 = this.propertyAddedCallback;
        r r137 = new r(r115, r135, r136);
        r137.f41672a = r104[10].getName();
        r136.invoke(r137);
        this.hasHeader$delegate = r137;
        Uri r138 = Uri.EMPTY;
        Function1<c<STATE, ?>, Unit> r139 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r140 = this.propertyAddedCallback;
        r r141 = new r(r138, r139, r140);
        r141.f41672a = r104[11].getName();
        r140.invoke(r141);
        this.pageSchemaUri$delegate = r141;
        GiftLynxPageConfig r142 = new GiftLynxPageConfig(null, null, 3, null);
        Function1<c<STATE, ?>, Unit> r143 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r144 = this.propertyAddedCallback;
        r r145 = new r(r142, r143, r144);
        r145.f41672a = r104[12].getName();
        r144.invoke(r145);
        this.pageLynxConfig$delegate = r145;
    }
}
