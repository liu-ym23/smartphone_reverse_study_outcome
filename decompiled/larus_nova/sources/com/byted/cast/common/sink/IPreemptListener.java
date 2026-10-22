package com.byted.cast.common.sink;

/* JADX INFO: loaded from: classes39.dex */
public interface IPreemptListener {

    /* JADX INFO: renamed from: com.byted.cast.common.sink.IPreemptListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onPreempt(IPreemptListener r100, ClientInfo r101) {
        }

        public static void $default$onPreempt(IPreemptListener r100, String r101, ClientInfo r102) {
        }
    }

    void onPreempt(ClientInfo r100);

    void onPreempt(String r100, ClientInfo r101);
}
