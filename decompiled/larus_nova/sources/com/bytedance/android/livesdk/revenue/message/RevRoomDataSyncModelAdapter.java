package com.bytedance.android.livesdk.revenue.message;

import com.bytedance.android.livesdk.interactivity.service.wrds.RoomDataSyncModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/message/RevRoomDataSyncModelAdapter;", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Lcom/bytedance/android/livesdk/revenue/message/k;", "original", "Lcom/bytedance/android/livesdk/revenue/message/k;", "getOriginal", "()Lcom/bytedance/android/livesdk/revenue/message/k;", "<init>", "(Lcom/bytedance/android/livesdk/revenue/message/k;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-host-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RevRoomDataSyncModelAdapter extends RoomDataSyncModel {
    private final k original;

    public static final class a implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RevRoomDataSyncModelAdapter f157178a;

        public a(RevRoomDataSyncModelAdapter r100) {
            Intrinsics.checkNotNullParameter(r100, "adapter");
            this.f157178a = r100;
        }

        @Override // com.bytedance.android.livesdk.revenue.message.k.c
        public final RevWrdsSettingItemImpl a(Class r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "key");
            dc2.c r102 = RevRoomDataSyncModelAdapter.access$createSettingItem(this.f157178a, r100, r101);
            Intrinsics.checkNotNullParameter(r102, "$this$toRevType");
            return new RevWrdsSettingItemImpl(r102);
        }
    }

    public final k getOriginal() {
        return this.original;
    }

    public RevRoomDataSyncModelAdapter(k r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.original = r100;
        com.bytedance.android.live.revenue.core.util.l r101 = r100.f157187a;
        vh6.d<k.c> r102 = k.f157186c;
        a r103 = new a(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "value");
        r101.f91040a.put(r102, r103);
    }

    public static final /* synthetic */ dc2.c access$createSettingItem(RevRoomDataSyncModelAdapter r100, Class r101, String r102) {
        return r100.createSettingItem(r101, r102);
    }
}
