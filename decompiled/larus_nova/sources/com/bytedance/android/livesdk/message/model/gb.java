package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004:\u0003\u001c\u001d\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/gb;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "Lcom/bytedance/android/livesdk/message/model/gb$b;", "getVideoCallback", "()Lcom/bytedance/android/livesdk/message/model/gb$b;", "setVideoCallback", "(Lcom/bytedance/android/livesdk/message/model/gb$b;)V", "videoCallback", "", "isTopEffectSamePlayer", "()Z", "setTopEffectSamePlayer", "(Z)V", "Lcom/bytedance/android/livesdk/message/model/gb$a;", "getElementClickListener", "()Lcom/bytedance/android/livesdk/message/model/gb$a;", "setElementClickListener", "(Lcom/bytedance/android/livesdk/message/model/gb$a;)V", "elementClickListener", "Lio/reactivex/disposables/CompositeDisposable;", "getPlayDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setPlayDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "playDisposable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface gb extends vh7.c<gb>, yh6.c {

    public interface a {
        void a(List<String> r100);
    }

    public interface b {
        void a();

        void b();

        void c(int r100, int r101);

        void d(c r100);

        void onError(Throwable r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f153646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f153647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f153648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f153649d;

        public c() {
        }
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ long getAssetId();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    a getElementClickListener();

    /* synthetic */ Map<String, String> getExtra();

    /* synthetic */ a8 getImageInfo();

    /* synthetic */ py.k getLandscapeBgImg();

    /* synthetic */ String getLandscapeContent();

    CompositeDisposable getPlayDisposable();

    /* synthetic */ int getPlayPriority();

    /* synthetic */ long getSceneContextId();

    b getVideoCallback();

    boolean isTopEffectSamePlayer();

    /* synthetic */ void setAssetId(long r100);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    void setElementClickListener(a r100);

    void setPlayDisposable(CompositeDisposable r100);

    void setTopEffectSamePlayer(boolean r100);

    void setVideoCallback(b r100);
}
