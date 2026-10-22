package com.bytedance.android.livesdk.message.model.gift;

import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import gm2.h;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a extends lm2.a implements h {
    protected long absTimeStamp;

    @IgnoreProtoFieldCheck
    @SerializedName("user")
    public User mFromUser;

    @IgnoreProtoFieldCheck
    @SerializedName("log_id")
    public String mLogId;

    @IgnoreProtoFieldCheck
    @SerializedName("to_user")
    public User mToUser;
    private final Map<Integer, Long> timeStampMap;

    public a() {
        this.mLogId = "";
        this.mFromUser = null;
        this.mToUser = null;
        this.absTimeStamp = 0;
        this.timeStampMap = new HashMap();
    }

    public IBaseUser getFromUser() {
        return this.mFromUser;
    }

    public long getGiftTimeStamp() {
        return this.absTimeStamp;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public Map<Integer, Long> getMaps() {
        return this.timeStampMap;
    }

    public long getTimeStamp() {
        return this.absTimeStamp;
    }

    public IBaseUser getToUser() {
        return this.mToUser;
    }

    public Long getStampByIndex(int r100) {
        if (this.timeStampMap.containsKey(Integer.valueOf(r100)) == false) goto L7;
        return this.timeStampMap.get(Integer.valueOf(r100));
    L7:
        return -1L;
    }

    public void setFromUser(IBaseUser r100) {
        this.mFromUser = (User) m.b(r100, User.class);
    }

    public void setGiftTimeStamp(long r100) {
        this.absTimeStamp = r100;
    }

    public void setLogId(String r100) {
        this.mLogId = r100;
    }

    public void setMaps(Map<Integer, Long> r100) {
        this.timeStampMap.putAll(r100);
    }

    public void setTimeStamp(long r100) {
        this.absTimeStamp = r100;
    }

    public void setToUser(IBaseUser r100) {
        this.mToUser = (User) m.b(r100, User.class);
    }

    public void setTimeStampMap(int r100, long r101) {
        this.timeStampMap.put(Integer.valueOf(r100), Long.valueOf(r101));
    }
}
