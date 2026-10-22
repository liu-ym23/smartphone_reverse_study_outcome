package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r52.c1;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveShowMentionMessage;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveShowMentionMessage extends DynamicFactor<Integer> implements Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Long f123135d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f123136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f123137c;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveShowMentionMessage f123138a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 1009) goto L6;
            this.f123138a.update(0);
            return;
        }

        public b(LiveShowMentionMessage r100, Looper r101) {
            this.f123138a = r100;
            super(r101);
        }
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_mention_chat_show_in_public_screen";
    }

    static {
        f123135d = c1.f536159a.getValue();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.f123136b = new b(this, Looper.getMainLooper());
        this.f123137c.observe("data_mention_message_show_in_public_screen", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.f123137c.removeObserver(this);
        b r100 = this.f123136b;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        this.f123136b = null;
    }

    public LiveShowMentionMessage(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123137c = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L19;
        String r102 = r101.getKey();
        if (r102.hashCode() == 1342535624) goto L9;
        return;
    L9:
        if (r102.equals("data_mention_message_show_in_public_screen") == false) goto L17;
        update(1);
        b r103 = this.f123136b;
        if (r103 == null) goto L13;
        r103.removeMessages(1009);
    L13:
        b r104 = this.f123136b;
        if (r104 == null) goto L18;
        r104.sendEmptyMessageDelayed(1009, f123135d.longValue());
        return;
    L18:
        return;
    L17:
        return;
    }
}
