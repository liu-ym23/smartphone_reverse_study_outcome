package com.bytedance.android.live.room;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;

/* JADX INFO: loaded from: classes47.dex */
public interface g {

    public interface a {
        void a(String r100);
    }

    public interface b {
        void b(String r100, String r101, IThemeShowArea r102, ThemeUpLoadListener r103, int r104);

        void c();

        void e(String r100, String r101, String r102);

        void g(String r100, int r101);

        void h();

        void onCanceled();

        void onError(String r100);
    }
}
