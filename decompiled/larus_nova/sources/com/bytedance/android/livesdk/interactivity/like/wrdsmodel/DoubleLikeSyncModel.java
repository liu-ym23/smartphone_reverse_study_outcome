package com.bytedance.android.livesdk.interactivity.like.wrdsmodel;

import com.bytedance.android.livesdk.interactivity.api.like.model.b;
import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import dc2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/wrdsmodel/DoubleLikeSyncModel;", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Ldc2/c;", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/b;", "doubleLikeSyncData$delegate", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", "getDoubleLikeSyncData", "()Ldc2/c;", "doubleLikeSyncData", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleLikeSyncModel extends RoomDataSyncModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final RoomDataSyncModel.a doubleLikeSyncData$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DoubleLikeSyncModel.class, "doubleLikeSyncData", "getDoubleLikeSyncData()Lcom/bytedance/android/livesdk/interactivity/service/wrds/WRDSSettingItem;", 0))};
    }

    public final c<b> getDoubleLikeSyncData() {
        return (c) this.doubleLikeSyncData$delegate.a(this, $$delegatedProperties[0]);
    }

    public DoubleLikeSyncModel() {
        this.doubleLikeSyncData$delegate = new RoomDataSyncModel.a(RoomDataSyncModel.access$createSettingItem(this, b.class, "DoubleLikeSyncData"));
    }
}
