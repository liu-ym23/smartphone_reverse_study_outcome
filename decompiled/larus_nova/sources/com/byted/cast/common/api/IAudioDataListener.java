package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public interface IAudioDataListener {

    /* JADX INFO: renamed from: com.byted.cast.common.api.IAudioDataListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAudioOutput(IAudioDataListener r100, String r101, byte[] r102, int r103, int r104, int r105, int r106, long r107) {
        }
    }

    void onAudioOutput(String r100, byte[] r101, int r102, int r103, int r104, int r105, long r106);
}
