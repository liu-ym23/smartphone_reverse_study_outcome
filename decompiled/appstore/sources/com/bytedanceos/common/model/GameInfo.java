package com.bytedanceos.common.model;

import com.bytedanceos.common.toolbox.ServerElements;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GameInfo extends GameModel {
    public String mCategory;
    public String mCount;
    public float mGameScores;
    public String mSoftType;

    public GameInfo(JSONObject r10) {
        this.mId = r10.optString("id");
        this.mName = r10.optString("name");
        this.mCategory = r10.optString("category");
        this.mPackageName = r10.optString("package");
        this.mSoftType = r10.optString("soft_type");
        this.mCount = r10.optString("count");
        this.mLogo = r10.optString(ServerElements.LOGO);
        this.mGameScores = Float.parseFloat(r10.optString(ServerElements.SCORES, "4.0f"));
    }
}
