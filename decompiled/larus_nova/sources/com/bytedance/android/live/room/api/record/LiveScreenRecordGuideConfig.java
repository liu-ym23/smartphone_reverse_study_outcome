package com.bytedance.android.live.room.api.record;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/room/api/record/LiveScreenRecordGuideConfig;", "", "", "enableGuide", "Z", "c", "()Z", "enableInnerRecord", "d", "", "innerRecordMinDuration", "J", "e", "()J", "enableAnchorMetadata", "b", "verifyStartRecordInRoom", "f", "debug", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScreenRecordGuideConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f99092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f99093b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f99094c = null;

    @SerializedName("debug")
    private final boolean debug;

    @SerializedName("enable_anchor_metadata")
    private final boolean enableAnchorMetadata;

    @SerializedName("enable_guide")
    private final boolean enableGuide;

    @SerializedName("enable_inner_record")
    private final boolean enableInnerRecord;

    @SerializedName("inner_record_min_duration")
    private final long innerRecordMinDuration;

    @SerializedName("verify_record_start_in_room")
    private final boolean verifyStartRecordInRoom;

    public static final class a {
        public a() {
        }

        public static LiveScreenRecordGuideConfig b() {
            return (LiveScreenRecordGuideConfig) LiveScreenRecordGuideConfig.f99092a.getValue();
        }

        @JvmStatic
        public static boolean a(DataCenter r100) {
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r100 == null) goto L16;
            IRoom r102 = gb2.a.e(r100);
            if (r102 == null) goto L16;
            IRoomAuthStatus r103 = r102.getRoomAuthStatus();
            if (r103 == null) goto L16;
            if (r103.isEnablePinHighlight() != true) goto L16;
            boolean r104 = true;
        L18:
            if (b().d() == false) goto L23;
            if (r104 == false) goto L24;
            if (r101 == false) goto L25;
            return true;
        L25:
            return false;
        L24:
            return false;
        L23:
            return false;
        L16:
            r104 = false;
            goto L18
        L5:
            if (gb2.a.a(r100, false) == true) goto L7;
            r101 = true;
            goto L8
        }
    }

    static {
        f99094c = new a();
        f99092a = LazyKt.lazy(LiveScreenRecordGuideConfig$Companion$setting$2.INSTANCE);
        f99093b = LazyKt.lazy(LiveScreenRecordGuideConfig$Companion$releaseStream$2.INSTANCE);
    }

    public LiveScreenRecordGuideConfig() {
        this.innerRecordMinDuration = 3;
        this.verifyStartRecordInRoom = true;
    }

    public final boolean a() {
        return this.debug;
    }

    public final boolean b() {
        return this.enableAnchorMetadata;
    }

    public final boolean c() {
        return this.enableGuide;
    }

    public final boolean d() {
        return this.enableInnerRecord;
    }

    public final long e() {
        return this.innerRecordMinDuration;
    }

    public final boolean f() {
        return this.verifyStartRecordInRoom;
    }
}
