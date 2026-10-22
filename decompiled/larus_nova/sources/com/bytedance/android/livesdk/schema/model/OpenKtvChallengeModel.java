package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J\b\u0010\u0012\u001a\u00020\fH\u0016R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/OpenKtvChallengeModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "()V", Keys.API_EVENT_KEY_PLAY_MODE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPlayMode", "()Ljava/util/ArrayList;", "setPlayMode", "(Ljava/util/ArrayList;)V", "sourceParams", "", "getSourceParams", "()Ljava/lang/String;", "setSourceParams", "(Ljava/lang/String;)V", "getPlayModes", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenKtvChallengeModel extends BaseSchemaModel {
    private ArrayList<Integer> playMode;

    @SerializedName("source_params")
    private String sourceParams;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.OPEN_KTV_CHALLENGE;
    }

    public final ArrayList<Integer> getPlayModes() {
        ArrayList<Integer> r100 = null;
        if (this.sourceParams != null) goto L5;
        return null;
    L5:
        ArrayList<Integer> r101 = this.playMode;
        if (r101 == null) goto L20;
        return r101;
    L20:
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(new JSONObject(this.sourceParams), FastStartLiveConfig.PLAY_MODE);     // Catch: Exception -> L19
        if (r102 == null) goto L16;
        ArrayList<Integer> r103 = new ArrayList();     // Catch: Exception -> L19
        int r104 = r102.length();     // Catch: Exception -> L18
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L15;
        r103.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r102, r105)));     // Catch: Exception -> L18
        r105 = r105 + 1;
    L15:
        r100 = r103;
    L16:
        this.playMode = r100;
        return r100;
    }

    public OpenKtvChallengeModel() {
    }

    public final ArrayList<Integer> getPlayMode() {
        return this.playMode;
    }

    public final String getSourceParams() {
        return this.sourceParams;
    }

    public final void setPlayMode(ArrayList<Integer> r100) {
        this.playMode = r100;
    }

    public final void setSourceParams(String r100) {
        this.sourceParams = r100;
    }
}
