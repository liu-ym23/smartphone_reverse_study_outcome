package com.bytedance.android.live.liveinteract.digitavatar;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Metadata;
import kotlin.text.CharsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class DigitAvatarMsgController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f72554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f72555b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarMsgController$AvatarStickerType;", "", "Recognition", "DigitAvatar", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AvatarStickerType extends Enum<AvatarStickerType> {
        public static final AvatarStickerType DigitAvatar = null;
        public static final AvatarStickerType Recognition = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AvatarStickerType[] f72556a = null;

        static {
            AvatarStickerType r100 = new AvatarStickerType("Recognition", 0);
            Recognition = r100;
            AvatarStickerType r101 = new AvatarStickerType("DigitAvatar", 1);
            DigitAvatar = r101;
            f72556a = new AvatarStickerType[]{r100, r101};
        }

        public static AvatarStickerType valueOf(String r100) {
            return (AvatarStickerType) r27.a.a(AvatarStickerType.class, r100);
        }

        public static AvatarStickerType[] values() {
            return (AvatarStickerType[]) f72556a.clone();
        }

        public AvatarStickerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public DigitAvatarMsgController(com.bytedance.android.live.pushstream.d r100) {
        this.f72555b = r100;
        this.f72554a = new Handler(Looper.getMainLooper());
    }

    public final void b(int r100, float r101) {
        JSONArray r102 = new JSONArray();
        r102.put(0);
        r102.put(r100);
        r102.put(0);
        JSONArray r103 = new JSONArray();
        r103.put(0);
        r103.put(0);
        r103.put(0);
        JSONObject r104 = new JSONObject();
        r104.put("position", r102);
        r104.put("orientation", r103);
        r104.put("scale", Float.valueOf(r101));
        String r105 = r104.toString();
        ALogger.i("KtvDigitAvatar", "向effect发送调整相机位置指令 position=[0, " + r100 + ", 0], scale=" + r101);
        a(206, 0, r105);
    }

    public final void a(int r100, int r101, String r102) {
        ALogger.i("KtvDigitAvatar", "向Effect的消息：msgType=0x" + Integer.toString(8192, CharsKt.checkRadix(16)) + ", arg1=" + r100 + ", arg2=" + r101 + ", arg3=" + r102);
        com.bytedance.android.live.pushstream.d r103 = this.f72555b;
        if (r103 == null) goto L6;
        r103.i0(r100, r101, r102);
        return;
    }
}
