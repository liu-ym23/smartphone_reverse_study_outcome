package L;

import K.W;
import android.media.CamcorderProfile;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c {
    public static W a(CamcorderProfile camcorderProfile) {
        return W.b.h(camcorderProfile.duration, camcorderProfile.fileFormat, b(camcorderProfile), c(camcorderProfile));
    }

    public static List<W.a> b(CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i10 = camcorderProfile.audioCodec;
        arrayList.add(W.a.a(i10, W.g(i10), camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels, W.c(camcorderProfile.audioCodec)));
        return arrayList;
    }

    public static List<W.c> c(CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i10 = camcorderProfile.videoCodec;
        arrayList.add(W.c.a(i10, W.d(i10), camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, -1, 8, 0, 0));
        return arrayList;
    }
}
