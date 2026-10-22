package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/k;", "", "Leb1/f;", "recordCompositionModel", "Leb1/f;", "b", "()Leb1/f;", "e", "(Leb1/f;)V", "", "draftId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lfb1/b;", "songSourceModel", "Lfb1/b;", "c", "()Lfb1/b;", "Lfb1/e;", "videoSourceModel", "Lfb1/e;", "d", "()Lfb1/e;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.bytedance.component.lyric.model.b> f101398a;

    @SerializedName("draft_id")
    private final String draftId;

    @SerializedName("user_record_model")
    private eb1.f recordCompositionModel;

    @SerializedName("song_model")
    private final fb1.b songSourceModel;

    @SerializedName("video_model")
    private final fb1.e videoSourceModel;

    public final String a() {
        return this.draftId;
    }

    public final eb1.f b() {
        return this.recordCompositionModel;
    }

    public final fb1.b c() {
        return this.songSourceModel;
    }

    public final fb1.e d() {
        return this.videoSourceModel;
    }

    public final void e(eb1.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordCompositionModel = r100;
    }

    public k(String r100, fb1.b r101, fb1.e r102) {
        Intrinsics.checkNotNullParameter(r100, "draftId");
        Intrinsics.checkNotNullParameter(r101, "songSourceModel");
        Intrinsics.checkNotNullParameter(r102, "videoSourceModel");
        this.draftId = r100;
        this.songSourceModel = r101;
        this.videoSourceModel = r102;
        this.recordCompositionModel = new eb1.f();
    }
}
