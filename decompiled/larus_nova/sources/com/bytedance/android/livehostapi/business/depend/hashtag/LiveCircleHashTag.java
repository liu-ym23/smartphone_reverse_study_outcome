package com.bytedance.android.livehostapi.business.depend.hashtag;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class LiveCircleHashTag implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f102925id;
    private String name;

    public long getCircleId() {
        return this.f102925id;
    }

    public String getCircleName() {
        return this.name;
    }

    public LiveCircleHashTag(long r100, String r101) {
        this.f102925id = r100;
        this.name = r101;
    }
}
