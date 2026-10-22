package com.bytedance.android.livesdkapi.paid;

import com.alipay.sdk.m.x.d;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdkapi/paid/PaidPrivilegeItem;", "Ljava/io/Serializable;", "()V", "clickVideoIndex", "", "getClickVideoIndex", "()I", "setClickVideoIndex", "(I)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "extraLogMap", "", "getExtraLogMap", "()Ljava/util/Map;", "setExtraLogMap", "(Ljava/util/Map;)V", "hybridSchema", "getHybridSchema", "setHybridSchema", "needBanRecord4Paid", "", "getNeedBanRecord4Paid", "()Z", "setNeedBanRecord4Paid", "(Z)V", "needHistoryStart", "getNeedHistoryStart", "setNeedHistoryStart", "title", "getTitle", d.f25925o, "type", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "videoList", "", "Lcom/bytedance/android/livesdkapi/paid/SimpleVideoItem;", "getVideoList", "()Ljava/util/List;", "setVideoList", "(Ljava/util/List;)V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidPrivilegeItem implements Serializable {
    public static final Companion Companion = null;
    public static final int PAID_RIGHT_TYPE_PHOTO = 5;
    public static final int PAID_RIGHT_TYPE_VIDEO = 6;
    private int clickVideoIndex;
    private String description;
    private Map<String, String> extraLogMap;
    private String hybridSchema;
    private boolean needBanRecord4Paid;
    private boolean needHistoryStart;
    private String title;
    private Integer type;
    private List<SimpleVideoItem> videoList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/paid/PaidPrivilegeItem$Companion;", "", "()V", "PAID_RIGHT_TYPE_PHOTO", "", "PAID_RIGHT_TYPE_VIDEO", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PaidPrivilegeItem() {
        this.title = "";
        this.description = "";
    }

    public final int getClickVideoIndex() {
        return this.clickVideoIndex;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Map<String, String> getExtraLogMap() {
        return this.extraLogMap;
    }

    public final String getHybridSchema() {
        return this.hybridSchema;
    }

    public final boolean getNeedBanRecord4Paid() {
        return this.needBanRecord4Paid;
    }

    public final boolean getNeedHistoryStart() {
        return this.needHistoryStart;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final List<SimpleVideoItem> getVideoList() {
        return this.videoList;
    }

    public final void setClickVideoIndex(int r100) {
        this.clickVideoIndex = r100;
    }

    public final void setDescription(String r100) {
        this.description = r100;
    }

    public final void setExtraLogMap(Map<String, String> r100) {
        this.extraLogMap = r100;
    }

    public final void setHybridSchema(String r100) {
        this.hybridSchema = r100;
    }

    public final void setNeedBanRecord4Paid(boolean r100) {
        this.needBanRecord4Paid = r100;
    }

    public final void setNeedHistoryStart(boolean r100) {
        this.needHistoryStart = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void setVideoList(List<SimpleVideoItem> r100) {
        this.videoList = r100;
    }
}
