package com.bytedance.android.live.ktv.common.view;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f70815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveOnlineAvatarView f70816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f70817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f70818d;

    public e(HSImageView r100, LiveOnlineAvatarView r101, List r102, long r103) {
        this.f70815a = r100;
        this.f70816b = r101;
        this.f70817c = r102;
        this.f70818d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f70816b.getOnClickAvatarCb();
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke();
    L5:
        JSONArray r103 = new JSONArray();
        Iterator r104 = this.f70817c.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r103.put(((Number) r104.next()).longValue());
        goto L7
    L9:
        String r105 = ("sslocal://webcast_room?room_id=" + this.f70818d + "&enter_from_merge=chat&enter_method=ktv_friend_live_link&room_id_list=") + r103.toString();
        HashMap<String, String> r106 = this.f70816b.f70753d;
        if (r106 == null) goto L15;
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        Map.Entry<String, String> r108 = r107.next();
        StringBuilder r109 = new StringBuilder();
        r109.append(r105);
        r109.append("&" + r108.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r108.getValue());
        r105 = r109.toString();
    L15:
        IMiddlewareLiveService r110 = TTLiveServiceMiddleware.getLiveService();
        if (r110 == null) goto L21;
        r110.handleSchema(this.f70815a.getContext(), UriProtector.parse(r105));
        return;
    }
}
