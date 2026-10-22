package com.bytedance.android.livesdkapi.depend.live;

import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.livesdkapi.depend.IDependency;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveFeedEvent extends IDependency {
    void onLiveFeedHide(AppCompatActivity r100);

    void onLiveFeedShow(AppCompatActivity r100, Map<String, String> r101);
}
