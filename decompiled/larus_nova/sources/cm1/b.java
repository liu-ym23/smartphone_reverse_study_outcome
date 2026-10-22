package cm1;

import am2.x;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f24155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f24156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f24157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f24158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f24159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ViewModel f24160f;

    public b(a r100, long r101, String r102, Context r103, DataCenter r104) {
        this.f24155a = r100;
        this.f24156b = r101;
        this.f24157c = r102;
        this.f24158d = r103;
        this.f24159e = false;
        this.f24160f = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Context r102 = this.f24158d;
        if (r102 == null) goto L5;
        rm3.c.f(r102, R.string.ttlive_replay_report_succeed, true, 16);
    L5:
        a r103 = this.f24155a;
        String r104 = this.f24157c;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        long r105 = this.f24156b;
        boolean r106 = this.f24159e;
        ViewModel r107 = this.f24160f;
        r103.getClass();
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r104);
        r108.put("to_comment_id", String.valueOf(r105));
        r108.put("report_type", "report_message");
        if (r106 == false) goto L11;
        r108.put("request_page", UserProfileEvent.DATA_TYPE_CARD_AUDIENCE);
    L12:
        if (r107 != null) goto L14;
        return;
    L14:
        if ((r107 instanceof DataCenter) == false) goto L18;
        d.a((DataCenter) r107).d("user_report_submit_success", r108, new Object[]{x.class});
        return;
    L18:
        return;
    L11:
        r108.put("request_page", "comment_popup");
        goto L12
    }
}
