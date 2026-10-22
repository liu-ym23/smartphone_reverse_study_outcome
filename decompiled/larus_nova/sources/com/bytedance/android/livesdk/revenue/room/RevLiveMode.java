package com.bytedance.android.livesdk.revenue.room;

import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\tH\u0016j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/room/RevLiveMode;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "", "getLogStreamingType", "", "isStreamingBackground", "isUsingCamera", "getSceneName", "", "getIndex", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "VIDEO", "AUDIO", "THIRD_PARTY", "SCREEN_RECORD", "MEDIA", "OFFICIAL_ACTIVITY", "ACQUAINTANCE", "UNDEFINED", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevLiveMode extends Enum<RevLiveMode> implements ILiveMode {
    public static final RevLiveMode ACQUAINTANCE = null;
    public static final RevLiveMode AUDIO = null;
    public static final a Companion = null;
    public static final RevLiveMode MEDIA = null;
    public static final RevLiveMode OFFICIAL_ACTIVITY = null;
    public static final RevLiveMode SCREEN_RECORD = null;
    public static final RevLiveMode THIRD_PARTY = null;
    public static final RevLiveMode UNDEFINED = null;
    public static final RevLiveMode VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevLiveMode[] f157275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function1<RevLiveMode, ILiveMode> f157276b = null;

    public static RevLiveMode valueOf(String r100) {
        return (RevLiveMode) r27.a.a(RevLiveMode.class, r100);
    }

    public static RevLiveMode[] values() {
        return (RevLiveMode[]) f157275a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.revenue.room.RevLiveMode$a] */
    static {
        RevLiveMode r100 = new RevLiveMode("VIDEO", 0);
        VIDEO = r100;
        RevLiveMode r101 = new RevLiveMode("AUDIO", 1);
        AUDIO = r101;
        RevLiveMode r102 = new RevLiveMode("THIRD_PARTY", 2);
        THIRD_PARTY = r102;
        RevLiveMode r103 = new RevLiveMode("SCREEN_RECORD", 3);
        SCREEN_RECORD = r103;
        RevLiveMode r104 = new RevLiveMode("MEDIA", 4);
        MEDIA = r104;
        RevLiveMode r105 = new RevLiveMode("OFFICIAL_ACTIVITY", 5);
        OFFICIAL_ACTIVITY = r105;
        RevLiveMode r106 = new RevLiveMode("ACQUAINTANCE", 6);
        ACQUAINTANCE = r106;
        RevLiveMode r107 = new RevLiveMode("UNDEFINED", 7);
        UNDEFINED = r107;
        f157275a = new RevLiveMode[]{r100, r101, r102, r103, r104, r105, r106, r107};
        Companion = new a();
        f157276b = new RevLiveMode$Companion$mapper$1((com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class));
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public String getLogStreamingType() {
        return String.valueOf(f157276b.invoke(this).getLogStreamingType());
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public String getSceneName() {
        return String.valueOf(f157276b.invoke(this).getSceneName());
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public boolean isStreamingBackground() {
        return f157276b.invoke(this).isStreamingBackground();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public boolean isUsingCamera() {
        return f157276b.invoke(this).isUsingCamera();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public int getIndex() {
        return ordinal();
    }

    public RevLiveMode(String r100, int r101) {
        super(r100, r101);
    }
}
