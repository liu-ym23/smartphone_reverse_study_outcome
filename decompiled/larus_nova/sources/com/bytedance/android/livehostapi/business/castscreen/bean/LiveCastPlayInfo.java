package com.bytedance.android.livehostapi.business.castscreen.bean;

import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastProxyCacheEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 m2\u00020\u0001:\u0001mB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020BJ\u0013\u0010c\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\f\u0010e\u001a\b\u0012\u0004\u0012\u00020B0fJ\u0014\u0010g\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0004J\b\u0010i\u001a\u00020$H\u0016J\u0010\u0010j\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u001dH\u0016J\u0014\u0010k\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0004J\b\u0010l\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR:\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010&\"\u0004\bE\u0010(R\u001e\u0010F\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010L\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001a\u0010U\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010&\"\u0004\bW\u0010(R\u001c\u0010X\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001a\u0010[\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010&\"\u0004\b]\u0010(R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040A¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`¨\u0006n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayInfo;", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastProxyCacheEquals;", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "autoPlay", "", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "coverInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastCoverInfo;", "getCoverInfo", "()Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastCoverInfo;", "setCoverInfo", "(Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastCoverInfo;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "extras", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExtras", "()Ljava/util/HashMap;", "setExtras", "(Ljava/util/HashMap;)V", "from", "", "getFrom", "()I", "setFrom", "(I)V", "isFakePlay", "setFakePlay", "liveInfo", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveInfo;", "getLiveInfo", "()Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveInfo;", "setLiveInfo", "(Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveInfo;)V", "logExtra", "Lorg/json/JSONObject;", "getLogExtra", "()Lorg/json/JSONObject;", "setLogExtra", "(Lorg/json/JSONObject;)V", "onlySupportXsg", "getOnlySupportXsg", "setOnlySupportXsg", "playConfig", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayConfig;", "getPlayConfig", "()Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayConfig;", "setPlayConfig", "(Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayConfig;)V", "resolutionInfoList", "", "Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastResolutionInfo;", "sceneId", "getSceneId", "setSceneId", "startPosition", "getStartPosition", "()Ljava/lang/Long;", "setStartPosition", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "targetResolution", "getTargetResolution", "setTargetResolution", "targetResolutionText", "getTargetResolutionText", "setTargetResolutionText", "title", "getTitle", d.f25925o, "urlExpire", "getUrlExpire", "setUrlExpire", "videoId", "getVideoId", "setVideoId", "videoType", "getVideoType", "setVideoType", "xsgOnlyResolutionInfoList", "getXsgOnlyResolutionInfoList", "()Ljava/util/List;", "addResolutionInfo", "resolutionInfo", "equals", "other", "getResolutionInfoList", "", "getUrlByResolution", "resolution", "hashCode", "liveProxyCacheEquals", "targetResolutionInfo", "toString", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastPlayInfo implements ILiveCastProxyCacheEquals {
    public static final Companion Companion = null;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_LIST_PLAY_SWITCHED = 1;
    public static final int VIDEO_TYPE_DEFAULT = 1;
    public static final int VIDEO_TYPE_ENCRYPTED_LIVE = 3;
    public static final int VIDEO_TYPE_LIVE = 2;
    public static final int VIDEO_TYPE_UNKNOWN = 0;
    private String albumId;
    private boolean autoPlay;
    private LiveCastCoverInfo coverInfo;
    private long duration;
    private HashMap<String, Object> extras;
    private int from;
    private boolean isFakePlay;
    private LiveCastLiveInfo liveInfo;
    private JSONObject logExtra;
    private boolean onlySupportXsg;
    private LiveCastPlayConfig playConfig;
    private final List<LiveCastResolutionInfo> resolutionInfoList;
    private int sceneId;
    private Long startPosition;
    private String targetResolution;
    private String targetResolutionText;
    private String title;
    private int urlExpire;
    private String videoId;
    private int videoType;
    private final List<String> xsgOnlyResolutionInfoList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastPlayInfo$Companion;", "", "()V", "FROM_DEFAULT", "", "FROM_LIST_PLAY_SWITCHED", "VIDEO_TYPE_DEFAULT", "VIDEO_TYPE_ENCRYPTED_LIVE", "VIDEO_TYPE_LIVE", "VIDEO_TYPE_UNKNOWN", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public int hashCode() {
        return (this.title + this.videoId + getUrlByResolution(this.targetResolution)).hashCode();
    }

    public String toString() {
        return "LiveCastPlayInfo{videoId: " + this.videoId + ", title: " + this.title + ", startPosition: " + this.startPosition + ", playConfig: " + this.playConfig + ", targetResolution: " + this.targetResolution + ", resolutionInfoList: " + this.resolutionInfoList + ", videoType: " + this.videoType + ", liveInfo: " + this.liveInfo + ", extras: " + this.extras + i.f25855d;
    }

    public LiveCastPlayInfo() {
        this.title = "";
        this.videoId = "";
        this.startPosition = 0L;
        this.playConfig = new LiveCastPlayConfig();
        this.resolutionInfoList = new ArrayList();
        this.targetResolution = "";
        this.targetResolutionText = "";
        this.liveInfo = new LiveCastLiveInfo();
        this.albumId = "";
        this.xsgOnlyResolutionInfoList = new ArrayList();
        this.logExtra = new JSONObject();
        this.extras = new HashMap();
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final LiveCastCoverInfo getCoverInfo() {
        return this.coverInfo;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final HashMap<String, Object> getExtras() {
        return this.extras;
    }

    public final int getFrom() {
        return this.from;
    }

    public final LiveCastLiveInfo getLiveInfo() {
        return this.liveInfo;
    }

    public final JSONObject getLogExtra() {
        return this.logExtra;
    }

    public final boolean getOnlySupportXsg() {
        return this.onlySupportXsg;
    }

    public final LiveCastPlayConfig getPlayConfig() {
        return this.playConfig;
    }

    public final List<LiveCastResolutionInfo> getResolutionInfoList() {
        return this.resolutionInfoList;
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public final Long getStartPosition() {
        return this.startPosition;
    }

    public final String getTargetResolution() {
        return this.targetResolution;
    }

    public final String getTargetResolutionText() {
        return this.targetResolutionText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUrlExpire() {
        return this.urlExpire;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final int getVideoType() {
        return this.videoType;
    }

    public final List<String> getXsgOnlyResolutionInfoList() {
        return this.xsgOnlyResolutionInfoList;
    }

    public final boolean isFakePlay() {
        return this.isFakePlay;
    }

    public final LiveCastPlayInfo addResolutionInfo(LiveCastResolutionInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "resolutionInfo");
        this.resolutionInfoList.add(r100);
        return this;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LiveCastPlayInfo) == false) goto L12;
        LiveCastPlayInfo r101 = (LiveCastPlayInfo) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(getUrlByResolution$default(this, null, 1, null), getUrlByResolution$default(r101, null, 1, null)) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public final String getUrlByResolution(String r100) {
        if (r100 != null) goto L4;
        r100 = this.targetResolution;
    L4:
        LiveCastResolutionInfo r101 = targetResolutionInfo(r100);
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getUrl();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastProxyCacheEquals
    public boolean liveProxyCacheEquals(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof LiveCastPlayInfo) == false) goto L36;
        LiveCastPlayInfo r101 = (LiveCastPlayInfo) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L9;
        return false;
    L9:
        if (this.from == r101.from) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.startPosition, r101.startPosition) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.playConfig, r101.playConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resolutionInfoList, r101.resolutionInfoList) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.targetResolution, r101.targetResolution) == true) goto L19;
        return false;
    L19:
        if (this.urlExpire == r101.urlExpire) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.targetResolutionText, r101.targetResolutionText) == true) goto L23;
        return false;
    L23:
        if (this.videoType == r101.videoType) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.albumId, r101.albumId) == true) goto L27;
        return false;
    L27:
        if (this.sceneId == r101.sceneId) goto L29;
        return false;
    L29:
        if (this.onlySupportXsg == r101.onlySupportXsg) goto L31;
        return false;
    L31:
        if (this.duration == r101.duration) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extras, r101.extras) == false) goto L51;
        return true;
    L51:
        return false;
    L36:
        return false;
    }

    public final void setAlbumId(String r100) {
        this.albumId = r100;
    }

    public final void setAutoPlay(boolean r100) {
        this.autoPlay = r100;
    }

    public final void setCoverInfo(LiveCastCoverInfo r100) {
        this.coverInfo = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setExtras(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extras = r100;
    }

    public final void setFakePlay(boolean r100) {
        this.isFakePlay = r100;
    }

    public final void setFrom(int r100) {
        this.from = r100;
    }

    public final void setLiveInfo(LiveCastLiveInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveInfo = r100;
    }

    public final void setLogExtra(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logExtra = r100;
    }

    public final void setOnlySupportXsg(boolean r100) {
        this.onlySupportXsg = r100;
    }

    public final void setPlayConfig(LiveCastPlayConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.playConfig = r100;
    }

    public final void setSceneId(int r100) {
        this.sceneId = r100;
    }

    public final void setStartPosition(Long r100) {
        this.startPosition = r100;
    }

    public final void setTargetResolution(String r100) {
        this.targetResolution = r100;
    }

    public final void setTargetResolutionText(String r100) {
        this.targetResolutionText = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrlExpire(int r100) {
        this.urlExpire = r100;
    }

    public final void setVideoId(String r100) {
        this.videoId = r100;
    }

    public final void setVideoType(int r100) {
        this.videoType = r100;
    }

    public final LiveCastResolutionInfo targetResolutionInfo(String r100) {
        Iterator<T> r101 = getResolutionInfoList().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((LiveCastResolutionInfo) r102).getResolution(), r100) == false) goto L4;
    L10:
        return (LiveCastResolutionInfo) r102;
    L8:
        r102 = null;
        goto L10
    }

    public static /* synthetic */ String getUrlByResolution$default(LiveCastPlayInfo r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.targetResolution;
    L6:
        return r100.getUrlByResolution(r101);
    }

    public static /* synthetic */ LiveCastResolutionInfo targetResolutionInfo$default(LiveCastPlayInfo r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.targetResolution;
    L6:
        return r100.targetResolutionInfo(r101);
    }
}
