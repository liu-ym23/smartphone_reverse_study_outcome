package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public interface IActiveControl {

    /* JADX INFO: renamed from: com.byted.cast.common.api.IActiveControl$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$pause(IActiveControl r100, String r101) {
        }

        public static void $default$seekComplete(IActiveControl r100, String r101, int r102) {
        }

        public static void $default$seekStart(IActiveControl r100, String r101, int r102) {
        }

        public static void $default$start(IActiveControl r100, String r101) {
        }
    }

    void pause(String r100);

    void seekComplete(String r100, int r101);

    void seekStart(String r100, int r101);

    void start(String r100);

    void stop(String r100, boolean r101);

    void updateVolume(String r100);
}
