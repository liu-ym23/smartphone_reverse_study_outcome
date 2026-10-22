package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ILivePlayerScene {
    public static final Companion Companion = null;
    private static final ILivePlayerScene innerDrawScene = null;
    private static final ILivePlayerScene previewScene = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene$Companion;", "", "()V", "innerDrawScene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "previewScene", "innerDraw", "preview", "scene", "newScene", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final ILivePlayerScene innerDraw() {
            return ILivePlayerScene.access$getInnerDrawScene$cp();
        }

        public final ILivePlayerScene preview() {
            return ILivePlayerScene.access$getPreviewScene$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ILivePlayerScene scene(String r100) {
            Intrinsics.checkNotNullParameter(r100, "newScene");
            return new PlayerScene(r100);
        }
    }

    public ILivePlayerScene() {
    }

    public abstract String getScene();

    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        previewScene = r100.scene("preview");
        innerDrawScene = r100.scene("inner_draw");
    }

    public int hashCode() {
        return getScene().hashCode();
    }

    public String toString() {
        return getScene();
    }

    public static final /* synthetic */ ILivePlayerScene access$getInnerDrawScene$cp() {
        return innerDrawScene;
    }

    public static final /* synthetic */ ILivePlayerScene access$getPreviewScene$cp() {
        return previewScene;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(r101, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(getScene(), ((PlayerScene) r100).getScene())) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.roomplayer.PlayerScene");
    L8:
        r102 = null;
        goto L10
    }
}
