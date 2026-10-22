package com.bytedance.android.format.host.api;

import android.app.Activity;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import pr.b;
import pr.c;
import pr.g;
import pr.j;
import pr.l;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/format/host/api/IHostUser;", "", "Lpr/c;", "followReqParam", "Lpr/b;", "followLogParam", "Lpr/g;", "followCallback", "", "follow", "Lpr/l;", "getCurUser", "", Keys.API_RETURN_KEY_IS_LOGIN, "Landroid/app/Activity;", "activity", "", "enterFrom", "Lpr/j;", "listener", "login", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostUser {
    void follow(c r100, b r101, g r102);

    l getCurUser();

    boolean isLogin();

    void login(Activity r100, String r101, j r102);
}
