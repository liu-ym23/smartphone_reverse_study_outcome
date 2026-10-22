package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.n;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import py.k;
import vh7.c;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftDIYCardItem;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/model/n;", "diyCardInfo$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getDiyCardInfo", "()Lcom/bytedance/android/anya/r0;", "diyCardInfo", "", "selected$delegate", "getSelected", "selected", "Lpy/k;", "giftIcon$delegate", "getGiftIcon", "giftIcon", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/DIYCardSelectType;", "selectType$delegate", "getSelectType", "selectType", "showRemindDot$delegate", "getShowRemindDot", "showRemindDot", "", "expireTime$delegate", "getExpireTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftDIYCardItem extends MVIState<GiftDIYCardItem> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty diyCardInfo$delegate;
    private final ReadOnlyProperty expireTime$delegate;
    private final ReadOnlyProperty giftIcon$delegate;
    private final ReadOnlyProperty selectType$delegate;
    private final ReadOnlyProperty selected$delegate;
    private final ReadOnlyProperty showRemindDot$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "diyCardInfo", "getDiyCardInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "selected", "getSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "giftIcon", "getGiftIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "selectType", "getSelectType()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, "showRemindDot", "getShowRemindDot()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDIYCardItem.class, Keys.API_PARAM_KEY_SDK_EXPIRETIME, "getExpireTime()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftDIYCardItem, n> getDiyCardInfo() {
        return (r0) this.diyCardInfo$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftDIYCardItem, String> getExpireTime() {
        return (r0) this.expireTime$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final r0<GiftDIYCardItem, k> getGiftIcon() {
        return (r0) this.giftIcon$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftDIYCardItem, DIYCardSelectType> getSelectType() {
        return (r0) this.selectType$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final r0<GiftDIYCardItem, Boolean> getSelected() {
        return (r0) this.selected$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftDIYCardItem, Boolean> getShowRemindDot() {
        return (r0) this.showRemindDot$delegate.getValue(this, $$delegatedProperties[4]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public GiftDIYCardItem() {
        c r100 = f.c(n.class);
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        r r103 = new r(r100, r101, r102);
        KProperty[] r104 = $$delegatedProperties;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.diyCardInfo$delegate = r103;
        Boolean r105 = Boolean.FALSE;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r106 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r107 = this.propertyAddedCallback;
        r r108 = new r(r105, r106, r107);
        r108.f41672a = r104[1].getName();
        r107.invoke(r108);
        this.selected$delegate = r108;
        c r109 = f.c(k.class);
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r110 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r111 = this.propertyAddedCallback;
        r r112 = new r(r109, r110, r111);
        r112.f41672a = r104[2].getName();
        r111.invoke(r112);
        this.giftIcon$delegate = r112;
        DIYCardSelectType r113 = DIYCardSelectType.IDLE;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r114 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r115 = this.propertyAddedCallback;
        r r116 = new r(r113, r114, r115);
        r116.f41672a = r104[3].getName();
        r115.invoke(r116);
        this.selectType$delegate = r116;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r117 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r118 = this.propertyAddedCallback;
        r r119 = new r(r105, r117, r118);
        r119.f41672a = r104[4].getName();
        r118.invoke(r119);
        this.showRemindDot$delegate = r119;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r120 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r121 = this.propertyAddedCallback;
        r r122 = new r("", r120, r121);
        r122.f41672a = r104[5].getName();
        r121.invoke(r122);
        this.expireTime$delegate = r122;
    }
}
