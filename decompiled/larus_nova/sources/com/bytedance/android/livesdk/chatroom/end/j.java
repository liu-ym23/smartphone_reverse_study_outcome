package com.bytedance.android.livesdk.chatroom.end;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverStreamPlayView f106078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f106079b;

    public j(LiveCoverStreamPlayView r100, LifecycleOwner r101) {
        this.f106078a = r100;
        this.f106079b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == false) goto L23;
        this.f106078a.R5();
        return;
    L23:
        LiveSeiUtil.f71508i.getClass();     // Catch: JSONException -> L22
        JSONObject r102 = LiveSeiUtil.c(r101);     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r102.optString("stream_type")) == true) goto L8;
        this.f106078a.R5();     // Catch: JSONException -> L22
        return;
    L8:
        String r103 = r102.optString("app_data");     // Catch: JSONException -> L22
        String r104 = null;
        if (r103 != null) goto L11;
    L16:
        if (r104 == null) goto L18;
        boolean r105 = !this.f106078a.f105918g.contains(r104);     // Catch: JSONException -> L22
    L19:
        if (r105 == false) goto L26;
        this.f106078a.R5();     // Catch: JSONException -> L22
        return;
    L26:
        return;
    L18:
        r105 = false;
        goto L19
    L11:
        if ((!TextUtils.isEmpty(r103)) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
        r104 = new JSONObject(r103).optString("ver");     // Catch: JSONException -> L22
        goto L16
    }
}
