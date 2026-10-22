package br2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a {
    void Cc(IBaseUser r100, String r101, IRoom r102, Function1 r103);

    boolean Tg(IBaseUser r100, IRoom r101);

    boolean nk(IRoom r100, IFollowPair r101);
}
