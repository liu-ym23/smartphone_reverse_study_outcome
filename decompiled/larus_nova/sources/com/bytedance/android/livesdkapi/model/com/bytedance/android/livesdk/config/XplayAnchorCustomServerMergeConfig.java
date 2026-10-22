package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0003\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig;", "", "()V", "clientMixInfo", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$ClientMixInfo;", "getClientMixInfo", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$ClientMixInfo;", "isInjectVideo", "", "()Z", "open", "getOpen", "subscribeMixInfo", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$XplaySubscribeMixInfo;", "getSubscribeMixInfo", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$XplaySubscribeMixInfo;", "ClientMixInfo", "Companion", "XplaySubscribeMixInfo", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayAnchorCustomServerMergeConfig {
    public static final Companion Companion = null;
    private static final XplayAnchorCustomServerMergeConfig DEFAULT_ITEM = null;

    @SerializedName("clientMixInfo")
    private final ClientMixInfo clientMixInfo;

    @SerializedName("isInjectVideo")
    private final boolean isInjectVideo;

    @SerializedName("open")
    private final boolean open;

    @SerializedName("subscribeMixInfo")
    private final XplaySubscribeMixInfo subscribeMixInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$ClientMixInfo;", "", "audioMixType", "", "(Ljava/lang/Long;)V", "getAudioMixType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$ClientMixInfo;", "equals", "", "other", "hashCode", "", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ClientMixInfo {

        @SerializedName("audio_mix_type")
        private final Long audioMixType;

        /* JADX WARN: Multi-variable type inference failed */
        public ClientMixInfo() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ClientMixInfo copy$default(ClientMixInfo r100, Long r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.audioMixType;
        L6:
            return r100.copy(r101);
        }

        public final Long component1() {
            return this.audioMixType;
        }

        public final ClientMixInfo copy(Long r100) {
            return new ClientMixInfo(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ClientMixInfo) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.audioMixType, ((ClientMixInfo) r100).audioMixType) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            Long r100 = this.audioMixType;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "ClientMixInfo(audioMixType=" + this.audioMixType + ")";
        }

        public final Long getAudioMixType() {
            return this.audioMixType;
        }

        public ClientMixInfo(Long r100) {
            this.audioMixType = r100;
        }

        public /* synthetic */ ClientMixInfo(Long r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$Companion;", "", "()V", "DEFAULT_ITEM", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig;", "getDEFAULT_ITEM", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final XplayAnchorCustomServerMergeConfig getDEFAULT_ITEM() {
            return XplayAnchorCustomServerMergeConfig.access$getDEFAULT_ITEM$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/XplayAnchorCustomServerMergeConfig$XplaySubscribeMixInfo;", "", "subscribeStreamType", "", "videoLayout", "", "audioLayout", "(ILjava/lang/String;Ljava/lang/String;)V", "getAudioLayout", "()Ljava/lang/String;", "getSubscribeStreamType", "()I", "getVideoLayout", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class XplaySubscribeMixInfo {

        @SerializedName("audioLayout")
        private final String audioLayout;

        @SerializedName("subscribeStreamType")
        private final int subscribeStreamType;

        @SerializedName("videoLayout")
        private final String videoLayout;

        public XplaySubscribeMixInfo() {
            this(0, null, null, 7, null);
        }

        public static /* synthetic */ XplaySubscribeMixInfo copy$default(XplaySubscribeMixInfo r100, int r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.subscribeStreamType;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.videoLayout;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.audioLayout;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final int component1() {
            return this.subscribeStreamType;
        }

        public final String component2() {
            return this.videoLayout;
        }

        public final String component3() {
            return this.audioLayout;
        }

        public final XplaySubscribeMixInfo copy(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "videoLayout");
            Intrinsics.checkNotNullParameter(r102, "audioLayout");
            return new XplaySubscribeMixInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof XplaySubscribeMixInfo) == false) goto L12;
            XplaySubscribeMixInfo r101 = (XplaySubscribeMixInfo) r100;
            if (this.subscribeStreamType == r101.subscribeStreamType) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.videoLayout, r101.videoLayout) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.audioLayout, r101.audioLayout) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r100 = this.subscribeStreamType * 31;
            String r101 = this.videoLayout;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.audioLayout;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "XplaySubscribeMixInfo(subscribeStreamType=" + this.subscribeStreamType + ", videoLayout=" + this.videoLayout + ", audioLayout=" + this.audioLayout + ")";
        }

        public final String getAudioLayout() {
            return this.audioLayout;
        }

        public final int getSubscribeStreamType() {
            return this.subscribeStreamType;
        }

        public final String getVideoLayout() {
            return this.videoLayout;
        }

        public XplaySubscribeMixInfo(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "videoLayout");
            Intrinsics.checkNotNullParameter(r102, "audioLayout");
            this.subscribeStreamType = r100;
            this.videoLayout = r101;
            this.audioLayout = r102;
        }

        public /* synthetic */ XplaySubscribeMixInfo(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    public XplayAnchorCustomServerMergeConfig() {
    }

    static {
        Companion = new Companion(null);
        DEFAULT_ITEM = new XplayAnchorCustomServerMergeConfig();
    }

    public static final /* synthetic */ XplayAnchorCustomServerMergeConfig access$getDEFAULT_ITEM$cp() {
        return DEFAULT_ITEM;
    }

    public final ClientMixInfo getClientMixInfo() {
        return this.clientMixInfo;
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final XplaySubscribeMixInfo getSubscribeMixInfo() {
        return this.subscribeMixInfo;
    }

    public final boolean isInjectVideo() {
        return this.isInjectVideo;
    }
}
