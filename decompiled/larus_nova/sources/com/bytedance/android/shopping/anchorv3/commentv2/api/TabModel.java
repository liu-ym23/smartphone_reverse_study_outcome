package com.bytedance.android.shopping.anchorv3.commentv2.api;

import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentStatIdEnum;
import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentTabTypeEnum;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000b¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/api/TabModel;", "Ljava/io/Serializable;", "", "isStat", "isAllTab", "", "id", "J", "getId", "()J", "setId", "(J)V", "", "tagName", "Ljava/lang/String;", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "tagType", "getTagType", "setTagType", "sentiment", "getSentiment", "setSentiment", "tagVersion", "getTagVersion", "setTagVersion", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabModel implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f164721id;

    @SerializedName("sentiment")
    private long sentiment;

    @SerializedName("tag_name")
    private String tagName;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private long tagType;

    @SerializedName("tag_version")
    private long tagVersion;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isStat() {
        if (this.tagType != CommentTabTypeEnum.STAT.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public TabModel() {
        this.f164721id = 1;
        this.tagName = "全部";
        this.tagType = CommentTabTypeEnum.STAT.getType();
        this.sentiment = 1;
    }

    public final boolean isAllTab() {
        if (isStat() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f164721id != CommentStatIdEnum.ALL.getStatId()) goto L7;
        return true;
    }

    public final long getId() {
        return this.f164721id;
    }

    public final long getSentiment() {
        return this.sentiment;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final long getTagType() {
        return this.tagType;
    }

    public final long getTagVersion() {
        return this.tagVersion;
    }

    public final void setId(long r100) {
        this.f164721id = r100;
    }

    public final void setSentiment(long r100) {
        this.sentiment = r100;
    }

    public final void setTagName(String r100) {
        this.tagName = r100;
    }

    public final void setTagType(long r100) {
        this.tagType = r100;
    }

    public final void setTagVersion(long r100) {
        this.tagVersion = r100;
    }
}
