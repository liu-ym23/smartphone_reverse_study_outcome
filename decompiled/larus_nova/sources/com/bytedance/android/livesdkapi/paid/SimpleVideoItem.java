package com.bytedance.android.livesdkapi.paid;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/paid/SimpleVideoItem;", "Ljava/io/Serializable;", "", "videoId", "Ljava/lang/String;", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "Lpy/k;", "cover", "Lpy/k;", "getCover", "()Lpy/k;", "setCover", "(Lpy/k;)V", "videoModelStr", "getVideoModelStr", "setVideoModelStr", "<init>", "()V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleVideoItem implements Serializable {
    public static final Companion Companion = null;
    private k cover;
    private String videoId;
    private String videoModelStr;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/paid/SimpleVideoItem$Companion;", "", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SimpleVideoItem() {
    }

    public final k getCover() {
        return this.cover;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getVideoModelStr() {
        return this.videoModelStr;
    }

    public final void setCover(k r100) {
        this.cover = r100;
    }

    public final void setVideoId(String r100) {
        this.videoId = r100;
    }

    public final void setVideoModelStr(String r100) {
        this.videoModelStr = r100;
    }
}
