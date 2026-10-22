package com.bytedance.android.livesdk.vscore_api.multicamera;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public interface IMultiCameraView {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/multicamera/IMultiCameraView$Source;", "", "CameraChange", "StyleAdapt", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Source extends Enum<Source> {
        public static final Source CameraChange = null;
        public static final Source StyleAdapt = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f159399a = null;

        static {
            Source r100 = new Source("CameraChange", 0);
            CameraChange = r100;
            Source r101 = new Source("StyleAdapt", 1);
            StyleAdapt = r101;
            f159399a = new Source[]{r100, r101};
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        public static Source[] values() {
            return (Source[]) f159399a.clone();
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    void Ma(boolean r100, boolean r101, Source r102);

    Lifecycle Qy();

    void X5(boolean r100, boolean r101, Source r102);
}
