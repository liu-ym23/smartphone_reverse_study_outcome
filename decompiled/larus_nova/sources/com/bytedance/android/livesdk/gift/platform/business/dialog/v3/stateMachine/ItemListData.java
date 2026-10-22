package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.c;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vh7.f;
import vz1.e;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b%\u0010&R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R'\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001d0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R'\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemListData;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemStatus;", "itemStatus$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getItemStatus", "()Lcom/bytedance/android/anya/r0;", "itemStatus", "", "visualStatus$delegate", "getVisualStatus", "visualStatus", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/SelectedStatus;", "selectedStatus$delegate", "getSelectedStatus", "selectedStatus", "Lvz1/e;", "itemData$delegate", "getItemData", "itemData", "", "isLoadingItem$delegate", "isLoadingItem", "showSweepAnim$delegate", "getShowSweepAnim", "showSweepAnim", "isGuideItem$delegate", "isGuideItem", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemDataType;", "itemDataType$delegate", "getItemDataType", "itemDataType", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/PinTopState;", "pinTopStatus$delegate", "getPinTopStatus", "pinTopStatus", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemListData extends MVIState<ItemListData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty isGuideItem$delegate;
    private final ReadOnlyProperty isLoadingItem$delegate;
    private final ReadOnlyProperty itemData$delegate;
    private final ReadOnlyProperty itemDataType$delegate;
    private final ReadOnlyProperty itemStatus$delegate;
    private final ReadOnlyProperty pinTopStatus$delegate;
    private final ReadOnlyProperty selectedStatus$delegate;
    private final ReadOnlyProperty showSweepAnim$delegate;
    private final ReadOnlyProperty visualStatus$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ItemListData.class, "itemStatus", "getItemStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "visualStatus", "getVisualStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "selectedStatus", "getSelectedStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "itemData", "getItemData()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "isLoadingItem", "isLoadingItem()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "showSweepAnim", "getShowSweepAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "isGuideItem", "isGuideItem()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "itemDataType", "getItemDataType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(ItemListData.class, "pinTopStatus", "getPinTopStatus()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<ItemListData, e> getItemData() {
        return (r0) this.itemData$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<ItemListData, ItemDataType> getItemDataType() {
        return (r0) this.itemDataType$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final r0<ItemListData, ItemStatus> getItemStatus() {
        return (r0) this.itemStatus$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<ItemListData, PinTopState> getPinTopStatus() {
        return (r0) this.pinTopStatus$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final r0<ItemListData, SelectedStatus> getSelectedStatus() {
        return (r0) this.selectedStatus$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<ItemListData, Boolean> getShowSweepAnim() {
        return (r0) this.showSweepAnim$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<ItemListData, Integer> getVisualStatus() {
        return (r0) this.visualStatus$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<ItemListData, Boolean> isGuideItem() {
        return (r0) this.isGuideItem$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final r0<ItemListData, Boolean> isLoadingItem() {
        return (r0) this.isLoadingItem$delegate.getValue(this, $$delegatedProperties[4]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public ItemListData() {
        ItemStatus r100 = ItemStatus.IDLE;
        Function1<c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        r r103 = new r(r100, r101, r102);
        KProperty[] r104 = $$delegatedProperties;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.itemStatus$delegate = r103;
        Integer r105 = Integer.valueOf(VisualStatus.INSTANCE.getIDLE());
        Function1<c<STATE, ?>, Unit> r106 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r107 = this.propertyAddedCallback;
        r r108 = new r(r105, r106, r107);
        r108.f41672a = r104[1].getName();
        r107.invoke(r108);
        this.visualStatus$delegate = r108;
        SelectedStatus r109 = SelectedStatus.IDLE;
        Function1<c<STATE, ?>, Unit> r110 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r111 = this.propertyAddedCallback;
        r r112 = new r(r109, r110, r111);
        r112.f41672a = r104[2].getName();
        r111.invoke(r112);
        this.selectedStatus$delegate = r112;
        e r113 = new e((h1) f.c(h1.class), 0, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108862);
        Function1<c<STATE, ?>, Unit> r114 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r115 = this.propertyAddedCallback;
        r r116 = new r(r113, r114, r115);
        r116.f41672a = r104[3].getName();
        r115.invoke(r116);
        this.itemData$delegate = r116;
        Boolean r117 = Boolean.FALSE;
        Function1<c<STATE, ?>, Unit> r118 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r119 = this.propertyAddedCallback;
        r r120 = new r(r117, r118, r119);
        r120.f41672a = r104[4].getName();
        r119.invoke(r120);
        this.isLoadingItem$delegate = r120;
        Function1<c<STATE, ?>, Unit> r121 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r122 = this.propertyAddedCallback;
        r r123 = new r(r117, r121, r122);
        r123.f41672a = r104[5].getName();
        r122.invoke(r123);
        this.showSweepAnim$delegate = r123;
        Function1<c<STATE, ?>, Unit> r124 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r125 = this.propertyAddedCallback;
        r r126 = new r(r117, r124, r125);
        r126.f41672a = r104[6].getName();
        r125.invoke(r126);
        this.isGuideItem$delegate = r126;
        ItemDataType r127 = ItemDataType.NORMAL_ITEM;
        Function1<c<STATE, ?>, Unit> r128 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r129 = this.propertyAddedCallback;
        r r130 = new r(r127, r128, r129);
        r130.f41672a = r104[7].getName();
        r129.invoke(r130);
        this.itemDataType$delegate = r130;
        PinTopState r131 = PinTopState.Companion.getDEFAULT_PIN_TOP_STATE();
        Function1<c<STATE, ?>, Unit> r132 = this.propertyChangeCallback;
        Function1<c<STATE, ?>, Unit> r133 = this.propertyAddedCallback;
        r r134 = new r(r131, r132, r133);
        r134.f41672a = r104[8].getName();
        r133.invoke(r134);
        this.pinTopStatus$delegate = r134;
    }
}
