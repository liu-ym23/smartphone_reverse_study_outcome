package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedInterpolationMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioCodecType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioProfile;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamSEIContentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamSyncStrategy;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoCodecType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedStreamLayoutMode;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import faceverify.w;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f18865q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f18866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f18867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f18868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f18869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f18870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q f18871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f18872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g[] f18873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f18876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f18877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f18878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f18879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LiveWrappedInterpolationMode f18880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LiveWrappedStreamLayoutMode f18881p;

    public static final class a {
        public static e a() {
            p r100 = new p();
            LiveWrappedMixedStreamVideoCodecType r101 = LiveWrappedMixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f18922a = r101;
            r100.f18923b = 15;
            r100.f18924c = 2;
            r100.f18928g = false;
            r100.f18927f = 640;
            r100.f18926e = 360;
            r100.f18925d = 500;
            c r102 = new c();
            r102.f18859a = LiveWrappedMixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
            r102.f18862d = 2;
            r102.f18860b = 64;
            r102.f18861c = 48000;
            r102.f18863e = LiveWrappedMixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
            f r103 = new f();
            r103.f18882a = false;
            LiveWrappedMixedStreamSEIContentMode r104 = LiveWrappedMixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r103.f18886e = r104;
            r103.f18885d = false;
            r103.f18884c = 0;
            r103.f18883b = 2.0f;
            r103.f18887f = 100;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r103.f18888g = "";
            k r105 = new k();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r105.f18915d = "";
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r105.f18916e = "";
            LiveWrappedMixedStreamSyncStrategy r106 = LiveWrappedMixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r105.f18912a = r106;
            r105.f18913b = 2000;
            r105.f18914c = true;
            r105.f18917f = 0;
            d r107 = new d();
            r107.f18864a = "";
            q r108 = new q();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r108.f18929a = "";
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r108.f18930b = "";
            j r109 = new j();
            e r110 = new e();
            r110.f18867b = r102;
            r110.f18866a = r100;
            r110.f18868c = r103;
            r110.f18869d = r105;
            r110.f18870e = r107;
            r110.f18871f = r108;
            r110.f18872g = r109;
            r110.f18875j = CustomHeaderConfig.COLOR_DARK;
            r110.f18874i = "";
            return r110;
        }
    }

    static {
    }

    public final JSONObject a() {
        String r100 = "height";
        String r101 = "width";
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r110 = new JSONObject();
        JSONObject r111 = new JSONObject();
        JSONObject r112 = new JSONObject();
        JSONObject r113 = new JSONObject();
        JSONObject r114 = new JSONObject();
        new JSONObject();
        JSONArray r115 = new JSONArray();
        JSONObject r116 = new JSONObject();
        JSONObject r117 = new JSONObject();
        JSONObject r105 = new JSONObject();
        p r118 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r118);     // Catch: Exception -> L39
        r102.put("videoCodec", r118.f18922a);     // Catch: Exception -> L39
        p r119 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r119);     // Catch: Exception -> L39
        r102.put("fps", r119.f18923b);     // Catch: Exception -> L39
        p r120 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r120);     // Catch: Exception -> L39
        r102.put("gop", r120.f18924c);     // Catch: Exception -> L39
        p r106 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L39
        r102.put("bitrate", r106.f18925d);     // Catch: Exception -> L39
        p r107 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r107);     // Catch: Exception -> L39
        r102.put("width", r107.f18926e);     // Catch: Exception -> L39
        p r108 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L39
        r102.put("height", r108.f18927f);     // Catch: Exception -> L39
        p r121 = this.f18866a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r121);     // Catch: Exception -> L39
        r102.put("enableBframe", r121.f18928g);     // Catch: Exception -> L39
        c r122 = this.f18867b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r122);     // Catch: Exception -> L39
        r103.put("audioCodec", r122.f18859a);     // Catch: Exception -> L39
        c r109 = this.f18867b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r109);     // Catch: Exception -> L39
        r103.put("bitrate", r109.f18860b);     // Catch: Exception -> L39
        c r123 = this.f18867b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r123);     // Catch: Exception -> L39
        r103.put("sampleRate", r123.f18861c);     // Catch: Exception -> L39
        c r124 = this.f18867b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r124);     // Catch: Exception -> L39
        r103.put("channels", r124.f18862d);     // Catch: Exception -> L39
        c r125 = this.f18867b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r125);     // Catch: Exception -> L39
        r103.put("audioProfile", r125.f18863e);     // Catch: Exception -> L39
        f r126 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r126);     // Catch: Exception -> L39
        r104.put("enableVolumeIndication", r126.f18882a);     // Catch: Exception -> L39
        f r127 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r127);     // Catch: Exception -> L39
        r104.put("talkVolume", r127.f18884c);     // Catch: Exception -> L39
        f r128 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r128);     // Catch: Exception -> L39
        r104.put("isAddVolumeValue", r128.f18885d);     // Catch: Exception -> L39
        f r129 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r129);     // Catch: Exception -> L39
        r104.put("volumeIndicationInterval", r129.f18883b);     // Catch: Exception -> L39
        f r130 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r130);     // Catch: Exception -> L39
        r104.put("seiContentMode", r130.f18886e);     // Catch: Exception -> L39
        f r131 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r131);     // Catch: Exception -> L39
        r104.put("seiPayloadType", r131.f18887f);     // Catch: Exception -> L39
        f r132 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r132);     // Catch: Exception -> L39
        r104.put("seiPayloadUuid", r132.f18888g);     // Catch: Exception -> L39
        f r133 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r133);     // Catch: Exception -> L39
        r104.put("mediaType", r133.f18889h);     // Catch: Exception -> L39
        f r134 = this.f18868c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r134);     // Catch: Exception -> L39
        r104.put("pushStreamMode", r134.f18890i);     // Catch: Exception -> L39
        k r135 = this.f18869d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r135);     // Catch: Exception -> L39
        r111.put("syncStrategy", r135.f18912a);     // Catch: Exception -> L39
        k r136 = this.f18869d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r136);     // Catch: Exception -> L39
        r111.put("maxCacheTimeMs", r136.f18913b);     // Catch: Exception -> L39
        k r137 = this.f18869d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r137);     // Catch: Exception -> L39
        r111.put("videoNeedSdkMix", r137.f18914c);     // Catch: Exception -> L39
        k r138 = this.f18869d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r138);     // Catch: Exception -> L39
        r111.put("baseuserID", r138.f18915d);     // Catch: Exception -> L39
        k r139 = this.f18869d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r139);     // Catch: Exception -> L39
        r111.put("baseRoomID", r139.f18916e);     // Catch: Exception -> L39
        k r140 = this.f18869d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r140);     // Catch: Exception -> L39
        r111.put("baseStreamStartDelayMs", r140.f18917f);     // Catch: Exception -> L39
        d r141 = this.f18870e;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r141);     // Catch: Exception -> L39
        r112.put("type", r141.f18864a);     // Catch: Exception -> L39
        q r142 = this.f18871f;     // Catch: Exception -> L39
        if (r142 == null) goto L22;
        Intrinsics.checkNotNull(r142);     // Catch: Exception -> L39
        r113.put("effectResourceUrl", r142.f18929a);     // Catch: Exception -> L39
        q r143 = this.f18871f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r143);     // Catch: Exception -> L39
        r113.put("effectResourceLocalPath", r143.f18930b);     // Catch: Exception -> L39
        q r144 = this.f18871f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r144);     // Catch: Exception -> L39
        r r145 = r144.f18931c;     // Catch: Exception -> L39
        if (r145 == null) goto L8;
        Long r146 = Long.valueOf(r145.f18932a);     // Catch: Exception -> L39
    L9:
        r113.put("msgID", r146);     // Catch: Exception -> L39
        q r147 = this.f18871f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r147);     // Catch: Exception -> L39
        r r148 = r147.f18931c;     // Catch: Exception -> L39
        if (r148 == null) goto L12;
        Long r149 = Long.valueOf(r148.f18933b);     // Catch: Exception -> L39
    L13:
        r113.put("arg1", r149);     // Catch: Exception -> L39
        q r150 = this.f18871f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r150);     // Catch: Exception -> L39
        r r151 = r150.f18931c;     // Catch: Exception -> L39
        if (r151 == null) goto L16;
        Long r152 = Long.valueOf(r151.f18934c);     // Catch: Exception -> L39
    L17:
        r113.put("arg2", r152);     // Catch: Exception -> L39
        q r153 = this.f18871f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r153);     // Catch: Exception -> L39
        r r154 = r153.f18931c;     // Catch: Exception -> L39
        if (r154 == null) goto L20;
        String r155 = r154.f18935d;     // Catch: Exception -> L39
    L21:
        r113.put("arg3", r155);     // Catch: Exception -> L39
        goto L22
    L20:
        r155 = null;
        goto L21
    L16:
        r152 = null;
        goto L17
    L12:
        r149 = null;
        goto L13
    L8:
        r146 = null;
    L22:
        r117.put("backgroundColor", this.f18875j);     // Catch: Exception -> L39
        r117.put("backgroundImageURL", this.f18876k);     // Catch: Exception -> L39
        g[] r156 = this.f18873h;     // Catch: Exception -> L39
        String r157 = "roomID";
        String r158 = "userID";
        if (r156 == null) goto L33;
        Intrinsics.checkNotNull(r156);     // Catch: Exception -> L39
        int r159 = r156.length;     // Catch: Exception -> L39
        int r160 = 0;
    L26:
        if (r160 >= r159) goto L32;
        int r210 = r159;
        g r161 = r156[r160];     // Catch: Exception -> L39
        if (r161 == null) goto L31;
        JSONObject r162 = new JSONObject();     // Catch: Exception -> L39
        r162.put(r158, r161.f18891a);     // Catch: Exception -> L39
        r162.put(r157, r161.f18892b);     // Catch: Exception -> L39
        r162.put("wtnStreamID", r161.f18893c);     // Catch: Exception -> L39
        r162.put("locationX", r161.f18894d);     // Catch: Exception -> L39
        r162.put("locationY", r161.f18895e);     // Catch: Exception -> L39
        r162.put(r101, r161.f18896f);     // Catch: Exception -> L39
        r162.put(r100, r161.f18897g);     // Catch: Exception -> L39
        r162.put("zOrder", r161.f18898h);     // Catch: Exception -> L39
        r162.put("alpha", r161.f18899i);     // Catch: Exception -> L39
        r162.put("cornerRadius", r161.f18900j);     // Catch: Exception -> L39
        r162.put("mediaType", r161.f18901k);     // Catch: Exception -> L39
        r162.put("renderMode", r161.f18902l);     // Catch: Exception -> L39
        r162.put("isLocalUser", r161.f18903m);     // Catch: Exception -> L39
        r162.put("streamType", r161.f18904n);     // Catch: Exception -> L39
        r162.put("applySpatialAudio", r161.f18907q);     // Catch: Exception -> L39
        r162.put("alternateImageFillMode", r161.f18905o);     // Catch: Exception -> L39
        r162.put("alternateImageURL", r161.f18906p);     // Catch: Exception -> L39
        r162.put("sourceCropX", r161.f18908r.f18938a);     // Catch: Exception -> L39
        r162.put("sourceCropY", r161.f18908r.f18939b);     // Catch: Exception -> L39
        r162.put("sourceCropW", r161.f18908r.f18940c);     // Catch: Exception -> L39
        r162.put("sourceCropH", r161.f18908r.f18941d);     // Catch: Exception -> L39
        r162.put("videoEnhancement", r161.f18909s);     // Catch: Exception -> L39
        r162.put("ignoreRtcSei", r161.f18911u);     // Catch: Exception -> L39
        r162.put("superResolutionMode", r161.f18910t);     // Catch: Exception -> L39
        r115.put(r162);     // Catch: Exception -> L39
    L31:
        r160 = r160 + 1;     // Catch: Exception -> L39
        r157 = r157;
        r100 = r100;
        r159 = r210;
        r156 = r156;
        r112 = r112;
        r158 = r158;
        r101 = r101;
        goto L26
    L32:
        String r211 = r158;
        JSONObject r212 = r112;
    L34:
        String r163 = r157;
        r117.put("regions", r115);     // Catch: Exception -> L39
        r117.put("userConfigExtraInfo", this.f18874i);     // Catch: Exception -> L39
        r117.put("transcode", r116);     // Catch: Exception -> L39
        r117.put("video", r102);     // Catch: Exception -> L39
        r117.put("audio", r103);     // Catch: Exception -> L39
        r117.put("serverControl", r104);     // Catch: Exception -> L39
        r117.put("clientMix", r110);     // Catch: Exception -> L39
        r117.put("syncControl", r111);     // Catch: Exception -> L39
        r117.put("audioEffect", r212);     // Catch: Exception -> L39
        r117.put("videoEffect", r113);     // Catch: Exception -> L39
        r117.put("layout", r114);     // Catch: Exception -> L39
        JSONObject r164 = this.f18879n;     // Catch: Exception -> L39
        if (r164 == null) goto L37;
        r117.put(w.META_COLL_KEY_AUTH_INFO, r164);     // Catch: Exception -> L39
    L37:
        r105.put("type", "transcode");     // Catch: Exception -> L39
        r105.put(r163, this.f18877l);     // Catch: Exception -> L39
        r105.put(r211, this.f18878m);     // Catch: Exception -> L39
        r105.put("transcodeMeta", r117);     // Catch: Exception -> L39
        r105.put("layoutMode", this.f18881p);     // Catch: Exception -> L39
        r105.put("interpolationMode", this.f18880o);     // Catch: Exception -> L39
        return r105;
    L33:
        r211 = "userID";
        r212 = r112;
    L39:
        return null;
    }

    public e() {
        this.f18874i = "";
        this.f18875j = CustomHeaderConfig.COLOR_DARK;
        this.f18876k = "";
        this.f18877l = "";
        this.f18878m = "";
        this.f18880o = LiveWrappedInterpolationMode.LAST_FRAME_FILL;
        this.f18881p = LiveWrappedStreamLayoutMode.AUTO;
    }
}
