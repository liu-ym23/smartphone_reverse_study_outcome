package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.l1;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vh7.c;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R3\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftBuffCardItem;", "Lcom/bytedance/android/anya/MVIState;", "Lcom/bytedance/android/anya/r0;", "Lcom/bytedance/android/livesdk/gift/model/l1;", "buffInfo$delegate", "Lkotlin/properties/ReadOnlyProperty;", "getBuffInfo", "()Lcom/bytedance/android/anya/r0;", "buffInfo", "", "selected$delegate", "getSelected", "selected", "Lkotlin/Pair;", "", "expireTime$delegate", "getExpireTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "showAnim$delegate", "getShowAnim", "showAnim", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftBuffCardItem extends MVIState<GiftBuffCardItem> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final ReadOnlyProperty buffInfo$delegate;
    private final ReadOnlyProperty expireTime$delegate;
    private final ReadOnlyProperty selected$delegate;
    private final ReadOnlyProperty showAnim$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftBuffCardItem.class, "buffInfo", "getBuffInfo()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardItem.class, "selected", "getSelected()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardItem.class, Keys.API_PARAM_KEY_SDK_EXPIRETIME, "getExpireTime()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftBuffCardItem.class, "showAnim", "getShowAnim()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final r0<GiftBuffCardItem, l1> getBuffInfo() {
        return (r0) this.buffInfo$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final r0<GiftBuffCardItem, Pair<Long, Long>> getExpireTime() {
        return (r0) this.expireTime$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final r0<GiftBuffCardItem, Boolean> getSelected() {
        return (r0) this.selected$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final r0<GiftBuffCardItem, Boolean> getShowAnim() {
        return (r0) this.showAnim$delegate.getValue(this, $$delegatedProperties[3]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public GiftBuffCardItem() {
        c r100 = f.c(l1.class);
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r101 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r102 = this.propertyAddedCallback;
        r r103 = new r(r100, r101, r102);
        KProperty[] r104 = $$delegatedProperties;
        r103.f41672a = r104[0].getName();
        r102.invoke(r103);
        this.buffInfo$delegate = r103;
        Boolean r105 = Boolean.FALSE;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r106 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r107 = this.propertyAddedCallback;
        r r108 = new r(r105, r106, r107);
        r108.f41672a = r104[1].getName();
        r107.invoke(r108);
        this.selected$delegate = r108;
        Pair r109 = new Pair(0L, 0L);
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r110 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r111 = this.propertyAddedCallback;
        r r112 = new r(r109, r110, r111);
        r112.f41672a = r104[2].getName();
        r111.invoke(r112);
        this.expireTime$delegate = r112;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r113 = this.propertyChangeCallback;
        Function1<com.bytedance.android.anya.internal.c<STATE, ?>, Unit> r114 = this.propertyAddedCallback;
        r r115 = new r(r105, r113, r114);
        r115.f41672a = r104[3].getName();
        r114.invoke(r115);
        this.showAnim$delegate = r115;
    }
}
