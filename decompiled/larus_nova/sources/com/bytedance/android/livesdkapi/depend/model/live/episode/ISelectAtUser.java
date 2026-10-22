package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ISelectAtUser;", "", "atUserName", "", "getAtUserName", "()Ljava/lang/String;", "setAtUserName", "(Ljava/lang/String;)V", "endIndex", "", "getEndIndex", "()I", "setEndIndex", "(I)V", "fromIndex", "getFromIndex", "setFromIndex", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ISelectAtUser {
    String getAtUserName();

    int getEndIndex();

    int getFromIndex();

    IBaseUser getUser();

    void setAtUserName(String r100);

    void setEndIndex(int r100);

    void setFromIndex(int r100);
}
