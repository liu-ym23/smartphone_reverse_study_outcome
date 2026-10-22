package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.base.model.message.z4;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends e implements wlc.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f77495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f77496c;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f77497a;

        public a(m r100) {
            this.f77497a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            ALogger.i("IMStreamInfoCatcher", "update link state: " + r101);
            m r102 = this.f77497a;
            if (r101 != null) goto L6;
        L8:
            boolean r103 = false;
        L9:
            r102.f77495b = r103;
            return;
        L6:
            if (r101.intValue() != 2) goto L8;
            r103 = true;
            goto L9
        }
    }

    @Override // wlc.b
    public final void Rk(IStreamMessage r100) {
        if (this.f77495b == false) goto L6;
        return;
    L6:
        if ((r100 instanceof z4) == true) goto L8;
        r100 = null;
    L8:
        z4 r101 = (z4) r100;
        if (r101 == null) goto L18;
        String r102 = r101.getInfo();
        if (r102 == null) goto L19;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L14
        r103.put(r101.getKey(), new JSONObject(r102));     // Catch: Exception -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L14
        a(r103, 1, r102);     // Catch: Exception -> L14
        return;
    L14:
        ALogger.e("IMStreamInfoCatcher", "to jsonObject fail");
        return;
    L19:
        return;
    }

    public m(DataCenter r100, p0 r101) {
        Intrinsics.checkNotNullParameter(r100, "mDataCenter");
        Intrinsics.checkNotNullParameter(r101, "processor");
        super(r101);
        this.f77496c = new a(this);
        emc.a r102 = (emc.a) r100.get("data_stream_message_manager");
        if (r102 == null) goto L5;
        r102.addMessageListener(MessageType.STREAM_SYNC_MESSAGE.getWsMethod(), this);
    L5:
        hd0.c.f().c(this.f77496c);
    }
}
