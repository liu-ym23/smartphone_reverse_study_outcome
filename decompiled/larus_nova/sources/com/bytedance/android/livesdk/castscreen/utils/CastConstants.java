package com.bytedance.android.livesdk.castscreen.utils;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
public final class CastConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f104713a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/utils/CastConstants$CastUrlType;", "", "", "id", "I", "getId", "()I", "", "encodeTypeStr", "Ljava/lang/String;", "getEncodeTypeStr", "()Ljava/lang/String;", "nameStr", "getNameStr", "logNameStr", "getLogNameStr", UserProfileEvent.POSITION_NONE, "H264", "H264hls", "H265", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CastUrlType extends Enum<CastUrlType> {
        public static final CastUrlType H264 = null;
        public static final CastUrlType H264hls = null;
        public static final CastUrlType H265 = null;
        public static final CastUrlType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CastUrlType[] f104714a = null;
        private final String encodeTypeStr;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f104715id;
        private final String logNameStr;
        private final String nameStr;

        static {
            CastUrlType r100 = new CastUrlType(UserProfileEvent.POSITION_NONE, 0, -1, "none", "none", "none");
            NONE = r100;
            CastUrlType r101 = new CastUrlType("H264", 1, 0, "h264", "h264", "flv264");
            H264 = r101;
            CastUrlType r102 = new CastUrlType("H264hls", 2, 1, "h264", "h264hls", "hls264");
            H264hls = r102;
            CastUrlType r103 = new CastUrlType("H265", 3, 2, "bytevc1", "h265", "flv265");
            H265 = r103;
            f104714a = new CastUrlType[]{r100, r101, r102, r103};
        }

        public static CastUrlType valueOf(String r100) {
            return (CastUrlType) r27.a.a(CastUrlType.class, r100);
        }

        public static CastUrlType[] values() {
            return (CastUrlType[]) f104714a.clone();
        }

        public final String getEncodeTypeStr() {
            return this.encodeTypeStr;
        }

        public final int getId() {
            return this.f104715id;
        }

        public final String getLogNameStr() {
            return this.logNameStr;
        }

        public final String getNameStr() {
            return this.nameStr;
        }

        public CastUrlType(String r100, int r101, int r102, String r103, String r104, String r105) {
            super(r100, r101);
            this.f104715id = r102;
            this.encodeTypeStr = r103;
            this.nameStr = r104;
            this.logNameStr = r105;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/utils/CastConstants$EncodeType;", "", "", BaseSwitches.V, "Ljava/lang/String;", "getV", "()Ljava/lang/String;", "UNKNOWN", "H264", "BYTEVC1", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EncodeType extends Enum<EncodeType> {
        public static final EncodeType BYTEVC1 = null;
        public static final EncodeType H264 = null;
        public static final EncodeType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EncodeType[] f104716a = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final String f104717v;

        static {
            EncodeType r100 = new EncodeType("UNKNOWN", 0, "");
            UNKNOWN = r100;
            EncodeType r101 = new EncodeType("H264", 1, "264");
            H264 = r101;
            EncodeType r102 = new EncodeType("BYTEVC1", 2, "bytevc1");
            BYTEVC1 = r102;
            f104716a = new EncodeType[]{r100, r101, r102};
        }

        public static EncodeType valueOf(String r100) {
            return (EncodeType) r27.a.a(EncodeType.class, r100);
        }

        public static EncodeType[] values() {
            return (EncodeType[]) f104716a.clone();
        }

        public final String getV() {
            return this.f104717v;
        }

        public EncodeType(String r100, int r101, String r102) {
            super(r100, r101);
            this.f104717v = r102;
        }
    }

    public static final class a {
    }

    static {
    }
}
