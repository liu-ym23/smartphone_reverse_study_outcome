package aa2;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class e implements r42.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransTextMessagePresenter f2320a;

    public /* synthetic */ e(TransTextMessagePresenter r100) {
        this.f2320a = r100;
    }

    public final void a(List r100) {
        TransTextMessagePresenter r101 = this.f2320a;
        r101.X = false;
        ArrayList r102 = (ArrayList) r100;
        if (r102.isEmpty() == false) goto L26;
        return;
    L26:
    L23:
        r101.f139289y = true;
        ALogger.e("HISTORY_COMMENT_TAG", "load more error," + r100.size() + HTTP.URL_DEFAULT + ((ArrayList) r101.f139270f).size());
    L24:
        HashMap r103 = new HashMap();
        r103.put("comment_send_num", String.valueOf(r100.size()));
        j0.l().sendLog("livesdk_history_comment_load", r103, new Object[]{new am2.x(), IRoom.class});
        return;
    L7:
        if ((((ArrayList) r101.f139270f).size() + r102.size()) <= 200) goto L9;
        r100 = r102.subList(0, Math.max(200 - ((ArrayList) r101.f139270f).size(), 0));     // Catch: Exception -> L23
        r101.f139289y = true;     // Catch: Exception -> L23
    L9:
        Iterator r104 = r100.iterator();     // Catch: Exception -> L23
    L10:
        if (r104.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r105 = i0.e((com.bytedance.android.live.base.model.message.t) r104.next(), r101.l0().f517050m, r101.f139269e);     // Catch: Exception -> L23
        if (r105 == null) goto L10;
        r105.f133146g = true;     // Catch: Exception -> L23
        if (r101.v0(r105) == true) goto L10;
        ListProtector.add(r101.f139270f, 0, r105);     // Catch: Exception -> L23
        ITextMessageView r106 = (ITextMessageView) r101.f531633a;     // Catch: Exception -> L23
        if (r106 == null) goto L10;
        r106.DD(0, 1, 0);     // Catch: Exception -> L23
        goto L10
    }
}
