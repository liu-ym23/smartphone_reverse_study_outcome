package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/format/model/n0;", "", "", "avatarID", "Ljava/lang/String;", "getAvatarID", "()Ljava/lang/String;", "setAvatarID", "(Ljava/lang/String;)V", "avatarURL", "getAvatarURL", "setAvatarURL", "mapID", "getMapID", "setMapID", "mapURL", "getMapURL", "setMapURL", "", "resOtherURLs", "Ljava/util/List;", "getResOtherURLs", "()Ljava/util/List;", "setResOtherURLs", "(Ljava/util/List;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("avatar_id")
    private String avatarID;

    @SerializedName("avatar_url")
    private String avatarURL;

    @SerializedName("map_id")
    private String mapID;

    @SerializedName("map_url")
    private String mapURL;

    @SerializedName("res_other_urls")
    private List<String> resOtherURLs;

    public n0() {
    }
}
