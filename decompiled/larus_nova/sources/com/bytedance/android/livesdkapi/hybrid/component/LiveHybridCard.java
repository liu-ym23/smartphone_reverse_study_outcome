package com.bytedance.android.livesdkapi.hybrid.component;

import android.net.Uri;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface LiveHybridCard {
    void close();

    View getCardView();

    void load(String r100, Map<String, Object> r101);

    void loadSchema(Uri r100);

    void onPause();

    void onResume();

    void release();

    void visibleChange(boolean r100, String r101);
}
