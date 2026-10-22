package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR2\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/format/model/y0;", "", "", "_scriptId", "Ljava/lang/String;", "Lcom/bytedance/android/format/model/o0;", "openVideo", "Lcom/bytedance/android/format/model/o0;", "getOpenVideo", "()Lcom/bytedance/android/format/model/o0;", "setOpenVideo", "(Lcom/bytedance/android/format/model/o0;)V", "waitingVideo", "getWaitingVideo", "setWaitingVideo", "", "scriptBanner", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setScriptBanner", "(Ljava/util/Map;)V", "backgroundBgm", "getBackgroundBgm", "setBackgroundBgm", "", "Lcom/bytedance/android/format/model/n;", "chapterBackgroupMediaList", "Ljava/util/List;", "getChapterBackgroupMediaList", "()Ljava/util/List;", "setChapterBackgroupMediaList", "(Ljava/util/List;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("script_id")
    private String _scriptId;

    @SerializedName("bgm")
    private o0 backgroundBgm;

    @SerializedName("chapter_backgroup_media_list")
    private List<n> chapterBackgroupMediaList;

    @SerializedName("open_video")
    private o0 openVideo;

    @SerializedName("script_banner")
    private Map<String, ? extends Object> scriptBanner;

    @SerializedName("waiting_video")
    private o0 waitingVideo;

    public y0() {
    }

    public final Map<String, Object> a() {
        return this.scriptBanner;
    }
}
