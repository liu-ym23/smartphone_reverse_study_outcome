package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class AudioStereoStrategyNode implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f155948d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<ILivePlayerClient> f155949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f155950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioStereoStrategyNode$observer$1 f155951c;

    public static final class a implements e.a {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e.a
        public final e create() {
            return new AudioStereoStrategyNode();
        }
    }

    public static final class b {
    }

    static {
        f155948d = new a();
    }

    public AudioStereoStrategyNode() {
        this.f155950b = MapsKt.emptyMap();
        this.f155951c = new AudioStereoStrategyNode$observer$1(this);
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(final j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f155949a = new WeakReference(r100.f155968d);
        UtilityKotlinExtentionsKt.s(0, false, false, new AudioStereoStrategyNode$onStreamPreparePlay$1(this, r100), 7);
    }
}
