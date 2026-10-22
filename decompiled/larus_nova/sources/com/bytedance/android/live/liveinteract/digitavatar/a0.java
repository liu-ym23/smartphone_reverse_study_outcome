package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f72594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f72595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<AvatarGender, y.a> f72596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f72597d;

    public static final class a implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AvatarGender f72598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f72599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f72600c;

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            ALogger.i("KtvDigitAvatar", "预下载" + this.f72598a + " avatar形象道具(stickId=" + this.f72598a.getStickId() + ")success，耗时 " + (System.currentTimeMillis() - this.f72599b) + "ms");
            b r101 = this.f72600c;
            if (r101 == null) goto L6;
            r101.d(this.f72598a, r100);
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            ALogger.w("KtvDigitAvatar", "预下载" + this.f72598a + " avatar形象道具(stickId=" + this.f72598a.getStickId() + ")fail，耗时 " + (System.currentTimeMillis() - this.f72599b) + "ms", r100);
            b r101 = this.f72600c;
            if (r101 == null) goto L6;
            r101.a(this.f72598a, r100);
            return;
        }

        public a(AvatarGender r100, long r101, b r102) {
            Intrinsics.checkNotNullParameter(r100, "gender");
            this.f72598a = r100;
            this.f72599b = r101;
            this.f72600c = r102;
        }
    }

    public interface b {
        void a(AvatarGender r100, Exception r101);

        void b(Exception r100);

        void c(Sticker r100);

        void d(AvatarGender r100, Sticker r101);
    }

    public a0() {
        this.f72597d = null;
        this.f72595b = new b0(this);
        this.f72596c = new LinkedHashMap();
    }

    public final void a(AvatarGender r100) {
        if (((LinkedHashMap) y.f72761a).get(r100) != null) goto L5;
        ALogger.i("KtvDigitAvatar", "开始预下载" + r100 + " avatar形象道具(stickId=" + r100.getStickId() + ')');
        System.currentTimeMillis();
        a r101 = new a(r100, System.currentTimeMillis(), this.f72597d);
        this.f72596c.put(r100, r101);
        y.b(r100, r101);
        return;
    L5:
        ALogger.i("KtvDigitAvatar", r100 + " avatar形象道具(stickId=" + r100.getStickId() + ")已经下载好了，不需要预下载, stickId=" + r100.getStickId());
    }
}
