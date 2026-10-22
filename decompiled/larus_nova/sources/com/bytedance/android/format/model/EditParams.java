package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoSeekTs;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/format/model/EditParams;", "Ljava/io/Serializable;", "", InstantPlayContext.PLAY_ID, "Ljava/lang/String;", "getPlay_id", "()Ljava/lang/String;", "", "has_modify", "Ljava/lang/Boolean;", "getHas_modify", "()Ljava/lang/Boolean;", "open_text", "getOpen_text", "", "Lcom/bytedance/android/format/model/EditParams$a;", "chapter", "Ljava/util/List;", "getChapter", "()Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EditParams implements Serializable {

    @SerializedName("chapter")
    private final List<a> chapter;

    @SerializedName("has_modify")
    private final Boolean has_modify;

    @SerializedName("open_text")
    private final String open_text;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String play_id;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/EditParams$a;", "", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", VideoSeekTs.KEY_ENDING, "getEnding", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("content")
        private final String content;

        @SerializedName(VideoSeekTs.KEY_ENDING)
        private final String ending;

        public a() {
            this.content = null;
            this.ending = null;
        }
    }

    public EditParams() {
    }

    public final List<a> getChapter() {
        return this.chapter;
    }

    public final Boolean getHas_modify() {
        return this.has_modify;
    }

    public final String getOpen_text() {
        return this.open_text;
    }

    public final String getPlay_id() {
        return this.play_id;
    }
}
