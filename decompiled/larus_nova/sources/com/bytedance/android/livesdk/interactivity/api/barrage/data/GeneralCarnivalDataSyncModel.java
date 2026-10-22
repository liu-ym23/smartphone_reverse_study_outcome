package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/GeneralCarnivalDataSyncModel;", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Ldc2/c;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/k;", "carnivalMessage$delegate", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", "getCarnivalMessage", "()Ldc2/c;", "carnivalMessage", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GeneralCarnivalDataSyncModel extends RoomDataSyncModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final RoomDataSyncModel.a carnivalMessage$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GeneralCarnivalDataSyncModel.class, "carnivalMessage", "getCarnivalMessage()Lcom/bytedance/android/livesdk/interactivity/service/wrds/WRDSSettingItem;", 0))};
    }

    public final dc2.c<k> getCarnivalMessage() {
        return (dc2.c) this.carnivalMessage$delegate.a(this, $$delegatedProperties[0]);
    }

    public GeneralCarnivalDataSyncModel() {
        this.carnivalMessage$delegate = new RoomDataSyncModel.a(RoomDataSyncModel.access$createSettingItem(this, k.class, "GeneralCarnivalSyncData"));
    }
}
