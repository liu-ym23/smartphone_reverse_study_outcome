package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0005\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "Lcom/bytedance/live/datacontext/DataContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "share", "(Lcom/bytedance/android/live/effect/api/LiveEffectScene;)Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "panel", "(Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class StickerBaseViewModel extends DataContext {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }

        public static StickerBaseViewModel a(LiveEffectScene r100, Class r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "clazz");
            return (StickerBaseViewModel) com.bytedance.live.datacontext.d.e(r100.name() + r101.getName(), r101);
        }

        public static StickerBaseViewModel b(LiveEffectScene r100, String r101, Class r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "panel");
            Intrinsics.checkNotNullParameter(r102, "clazz");
            return (StickerBaseViewModel) com.bytedance.live.datacontext.d.e(r100.name() + r101 + r102.getName(), r102);
        }
    }

    static {
        Companion = new a();
    }

    public StickerBaseViewModel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T extends StickerBaseViewModel> T share(LiveEffectScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.name());
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        r101.append(StickerBaseViewModel.class.getName());
        com.bytedance.live.datacontext.b.a(this, r101.toString());
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T extends StickerBaseViewModel> T share(LiveEffectScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "panel");
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.name());
        r102.append(r101);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        r102.append(StickerBaseViewModel.class.getName());
        com.bytedance.live.datacontext.b.a(this, r102.toString());
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return this;
    }
}
