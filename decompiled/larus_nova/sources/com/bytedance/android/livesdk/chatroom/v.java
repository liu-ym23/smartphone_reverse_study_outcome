package com.bytedance.android.livesdk.chatroom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes7.dex */
public interface v {
    com.bytedance.live.datacontext.m<Long> a();

    void b(FragmentActivity r100);

    Disposable c(DataCenter r100, String r101);

    void d(Context r100, Throwable r101);

    boolean e();

    Dialog f(Context r100, IRoom r101, IBaseUser r102, boolean r103, boolean r104, UserProfileEvent r105, Bundle r106);

    com.bytedance.live.datacontext.m<Long> g();

    Dialog getEnsureKickOutDialog(Context r100, long r101, String r102, String r103, String r104);

    com.bytedance.live.datacontext.m<Integer> getProfileStyle();

    com.bytedance.live.datacontext.m<Boolean> h();

    Disposable i(long r100, boolean r101, com.bytedance.android.live.profile.usecase.o r102, com.bytedance.android.live.profile.usecase.p r103);

    boolean isRecording();

    void j(FragmentActivity r100);

    void userInfoAutoAntiDeterioration();
}
