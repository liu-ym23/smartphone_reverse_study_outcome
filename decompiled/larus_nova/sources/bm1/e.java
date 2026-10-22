package bm1;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.profilecard.ReplayLiveProfileDetailFragment;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLiveProfileDetailFragment f19547a;

    public e(ReplayLiveProfileDetailFragment r100) {
        this.f19547a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if ((r100.getTag() instanceof py.k) == false) goto L35;
        py.k r101 = (py.k) r100.getTag();
        if (StringUtils.isEmpty(r101.getSchema()) == false) goto L7;
        return;
    L7:
        if (this.f19547a.getContext() == null) goto L37;
        ReplayLiveProfileDetailFragment r102 = this.f19547a;
        String r103 = r101.getSchema();
        int r104 = ReplayLiveProfileDetailFragment.V;
        r102.getClass();
        Uri r105 = UriProtector.parse(r103);
        String r106 = UriProtector.getQueryParameter(r105, "noble_intercept");
        if (r106 != null) goto L30;
    L28:
        fq1.d.a().handleSchema(this.f19547a.getContext(), r103);
        return;
    L30:
        int r107 = CastIntegerProtector.parseInt(r106);     // Catch: Throwable -> L13
    L14:
        if (r107 == 0) goto L28;
        String r108 = UriProtector.getQueryParameter(r105, "url");
        if (r108 == null) goto L28;
        String r109 = UriProtector.parse(r108).buildUpon().appendQueryParameter("status_bar_height", String.valueOf(s1.G(StatusBarUtil.getStatusBarHeight(r102.getContext())))).build().toString();
        Set<String> r110 = UriProtector.getQueryParameterNames(r105);
        Uri.Builder r111 = r105.buildUpon().clearQuery();
        Iterator<String> r112 = r110.iterator();
    L21:
        if (r112.hasNext() == false) goto L27;
        String r113 = r112.next();
        if ("url".equals(r113) == false) goto L25;
        String r114 = r109;
    L26:
        r111.appendQueryParameter(r113, r114);
        goto L21
    L25:
        r114 = UriProtector.getQueryParameter(r105, r113);
        goto L26
    L27:
        HashMap r115 = new HashMap();
        r115.put("type", BrowserDependency.UrlClickType.CARD);
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r102.f109893r).d("livesdk_vs_nobility_page_click_vs", r115, new Object[]{null});
        r103 = r111.build().toString();
    L13:
        r107 = 0;
        goto L14
    L37:
        return;
    }
}
