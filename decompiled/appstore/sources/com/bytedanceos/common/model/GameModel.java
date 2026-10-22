package com.bytedanceos.common.model;

/* JADX INFO: loaded from: classes2.dex */
public class GameModel implements Model {
    public String mApiurl;
    public String mId;
    public String mLogo;
    public String mName;
    public String mPackageName;

    public GameModel() {
    }

    @Override // com.bytedanceos.common.model.Model
    public String getId() {
        return this.mId;
    }

    @Override // com.bytedanceos.common.model.Model
    public String getName() {
        return this.mPackageName;
    }
}
