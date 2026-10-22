package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b2\n\u0002\u0010\u000e\n\u0002\b\u000e\bg\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001ZJ\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\t\u001a\u00020\bH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\r\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\r\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010(\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\r\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\"\u0010,\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\r\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\"\u00100\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\r\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\"\u00104\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\r\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\"\u00108\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\r\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R\"\u0010<\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\r\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R\"\u0010@\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b?\u0010\r\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR\"\u0010F\u001a\u00020\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\r\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010L\u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bK\u0010\r\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010S\u001a\u0004\u0018\u00010M8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\r\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010W\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bV\u0010\r\u001a\u0004\bT\u0010\u001c\"\u0004\bU\u0010\u001eR\u0014\u0010X\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010B¨\u0006["}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/f;", "Lvh7/c;", "Lpy/k;", ExifInterface.GPS_DIRECTION_TRUE, "", "resources", "dynamicImage", "extraDynamicImage", "", "isExtraValid", "getResources", "()Ljava/util/List;", "getResources$annotations", "()V", "getDynamicImage", "()Lpy/k;", "getDynamicImage$annotations", "getExtraDynamicImage", "getExtraDynamicImage$annotations", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "type", "", "getDuration", "()J", "setDuration", "(J)V", "getDuration$annotations", "duration", "getStart", "setStart", "getStart$annotations", "start", "getOffset", "setOffset", "getOffset$annotations", "offset", "getOffsetStart", "setOffsetStart", "getOffsetStart$annotations", "offsetStart", "getTimeOffset", "setTimeOffset", "getTimeOffset$annotations", "timeOffset", "getLevel", "setLevel", "getLevel$annotations", "level", "getX", "setX", "getX$annotations", "x", "getY", "setY", "getY$annotations", "y", "getSizeScale", "setSizeScale", "getSizeScale$annotations", "sizeScale", "getReshape", "()Z", "setReshape", "(Z)V", "getReshape$annotations", "reshape", "getReshapeStart", "()Ljava/lang/Long;", "setReshapeStart", "(Ljava/lang/Long;)V", "getReshapeStart$annotations", "reshapeStart", "", "getSoundUrl", "()Ljava/lang/String;", "setSoundUrl", "(Ljava/lang/String;)V", "getSoundUrl$annotations", "soundUrl", "getExtraDuration", "setExtraDuration", "getExtraDuration$annotations", "extraDuration", "isValid", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {
    public static final a Companion = null;
    public static final int TYPE_ICON_MOVE = 1;
    public static final int TYPE_MIC_SEAT = 4;
    public static final int TYPE_SEAT_SENDER = 5;
    public static final int TYPE_TRACK_EFFECT = 2;
    public static final int TYPE_TRANS_EFFECT = 3;
    public static final int TYPE_UNDEFINED = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f79388a = null;

        public a() {
        }

        static {
            f79388a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f79388a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    py.k dynamicImage();

    py.k extraDynamicImage();

    @FieldName(name = "duration_ms")
    long getDuration();

    @FieldName(name = "interact_emoji")
    py.k getDynamicImage();

    @FieldName(name = "own_emoji_duration_ms")
    long getExtraDuration();

    @FieldName(name = "own_emoji")
    py.k getExtraDynamicImage();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "offset")
    long getOffset();

    @FieldName(name = "offset_start")
    int getOffsetStart();

    @FieldName(name = "reshape")
    boolean getReshape();

    @FieldName(name = "reshape_start")
    Long getReshapeStart();

    @FieldName(name = "interact_emojis")
    List<py.k> getResources();

    @FieldName(name = "scale_up")
    long getSizeScale();

    @FieldName(name = "sound_url")
    String getSoundUrl();

    @FieldName(name = "start")
    long getStart();

    @FieldName(name = "time_offset")
    int getTimeOffset();

    @FieldName(name = "type")
    int getType();

    @FieldName(name = "x")
    int getX();

    @FieldName(name = "y")
    int getY();

    boolean isExtraValid();

    boolean isValid();

    <T extends py.k> List<T> resources();

    @FieldName(name = "duration_ms#setter")
    void setDuration(long r100);

    @FieldName(name = "own_emoji_duration_ms#setter")
    void setExtraDuration(long r100);

    @FieldName(name = "level#setter")
    void setLevel(int r100);

    @FieldName(name = "offset#setter")
    void setOffset(long r100);

    @FieldName(name = "offset_start#setter")
    void setOffsetStart(int r100);

    @FieldName(name = "reshape#setter")
    void setReshape(boolean r100);

    @FieldName(name = "reshape_start#setter")
    void setReshapeStart(Long r100);

    @FieldName(name = "scale_up#setter")
    void setSizeScale(long r100);

    @FieldName(name = "sound_url#setter")
    void setSoundUrl(String r100);

    @FieldName(name = "start#setter")
    void setStart(long r100);

    @FieldName(name = "time_offset#setter")
    void setTimeOffset(int r100);

    @FieldName(name = "type#setter")
    void setType(int r100);

    @FieldName(name = "x#setter")
    void setX(int r100);

    @FieldName(name = "y#setter")
    void setY(int r100);
}
