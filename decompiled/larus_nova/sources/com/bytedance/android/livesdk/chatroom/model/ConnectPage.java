package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.ConnectPage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ConnectPage;", "", "", "type", "I", "", "schema", "Ljava/lang/String;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConnectPage implements vh7.h {
    public static final a Companion = null;
    public static final int TYPE_TREASURE_BOX = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WEEKEND_TASK = 1;

    @SerializedName("schema")
    public String schema;

    @SerializedName("type")
    public int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ConnectPage() {
    }

    public ConnectPage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.type = r100.i();
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.schema = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
