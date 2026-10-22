package com.bytedance.android.livesdkapi.depend.model.live;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class LiveHashTagUseInfo implements Parcelable {
    public static final Parcelable.Creator<LiveHashTagUseInfo> CREATOR = null;
    public boolean isChallengeUse;
    public boolean isDbUse;
    public boolean isOperationUse;
    public boolean isRecommendUse;
    public boolean isSearchUse;
    public boolean isSelfDefinedUse;

    private String getUseFlag(boolean r100) {
        if (r100 == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Map<String, String> generateUseInfoLog() {
        HashMap r100 = new HashMap();
        r100.put("is_recommend_use", getUseFlag(this.isRecommendUse));
        r100.put("is_search_use", getUseFlag(this.isSearchUse));
        r100.put("is_operation_use", getUseFlag(this.isOperationUse));
        r100.put("is_self_defined_use", getUseFlag(this.isSelfDefinedUse));
        r100.put("is_db_use", getUseFlag(this.isDbUse));
        r100.put("is_challenge_use", getUseFlag(this.isChallengeUse));
        return r100;
    }

    public LiveHashTagUseInfo() {
    }

    public LiveHashTagUseInfo(Parcel r100) {
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isRecommendUse = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.isSearchUse = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isOperationUse = r104;
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.isSelfDefinedUse = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.isDbUse = r106;
        if (r100.readByte() != 0) goto L26;
        r101 = false;
    L26:
        this.isChallengeUse = r101;
        return;
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public void useHashTagSource(String r100) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (StringUtils.equal(r100, "recommend") == false) goto L9;
        this.isRecommendUse = true;
        return;
    L9:
        if (StringUtils.equal(r100, WikiFolderPushPlugin.OPT) == false) goto L12;
        this.isOperationUse = true;
        return;
    L12:
        if (StringUtils.equal(r100, "db") == false) goto L15;
        this.isDbUse = true;
        return;
    L15:
        if (StringUtils.equal(r100, "self_defined") == false) goto L18;
        this.isSelfDefinedUse = true;
        return;
    L18:
        if (StringUtils.equal(r100, "search") == false) goto L21;
        this.isSearchUse = true;
        return;
    L21:
        if (StringUtils.equal(r100, "challenge") == false) goto L29;
        this.isChallengeUse = true;
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.isRecommendUse ? 1 : 0);
        r100.writeByte(this.isSearchUse ? 1 : 0);
        r100.writeByte(this.isOperationUse ? 1 : 0);
        r100.writeByte(this.isSelfDefinedUse ? 1 : 0);
        r100.writeByte(this.isDbUse ? 1 : 0);
        r100.writeByte(this.isChallengeUse ? 1 : 0);
    }
}
