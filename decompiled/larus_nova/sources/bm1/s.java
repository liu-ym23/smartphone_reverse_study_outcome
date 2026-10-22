package bm1;

import am2.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f19562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f19564e;

    public s(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f19564e = r100;
        this.f19560a = "";
        this.f19561b = "";
        this.f19562c = new LinkedHashMap();
        this.f19563d = "others";
    }

    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        HashMap r101 = (HashMap) r100;
        r101.put("vs_profile_card_position", this.f19560a);
        r101.putAll(MapsKt.toMap(this.f19562c));
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f19564e).d("enter_user_profile_page_click", r100, new Object[]{x.class, am2.c.class, IRoom.class});
    }
}
