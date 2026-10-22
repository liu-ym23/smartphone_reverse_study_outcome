package androidx.media;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VolumeProviderCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: compiled from: VolumeProviderCompatApi21.java */
    public interface a {
        void a(int r1);

        void b(int r1);
    }

    public static Object a(final int r2, final int r3, final int r4, a r5) {
        final a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        return new VolumeProviderCompatApi21$1(r2, r3, r4, r6);
    }
}
