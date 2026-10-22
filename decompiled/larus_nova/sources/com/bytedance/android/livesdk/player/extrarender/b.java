package com.bytedance.android.livesdk.player.extrarender;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f155262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExtraRenderView f155263b;

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
        ILivePlayerExtraRenderController r101 = this.f155263b.getRenderController();
        StringBuilder r102 = new StringBuilder("remove extra surface SurfaceTexture@");
        r102.append(r100.hashCode());
        r102.append(" surface@");
        Surface r103 = (Surface) this.f155262a.element;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.hashCode());
    L6:
        r102.append(r104);
        r102.append(" onSurfaceTextureDestroyed");
        ILivePlayerExtraRenderController.DefaultImpls.log$default(r101, r102.toString(), false, 2, null);
        Object r105 = this.f155263b.getRenderController().getPlayerContext();
        if (r105 == null) goto L14;
        ITTLivePlayer r106 = ((LivePlayerContext) r105).f154929e;
        if (r106 == null) goto L11;
        r106.removeExtraSurface((Surface) this.f155262a.element, 1);
    L11:
        this.f155262a.element = null;
        return true;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.player.LivePlayerContext");
    L5:
        r104 = null;
        goto L6
    }

    public b(Ref.ObjectRef r100, ExtraRenderView r101) {
        this.f155262a = r100;
        this.f155263b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, android.view.Surface] */
    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
        this.f155262a.element = new Surface(r100);
        ILivePlayerExtraRenderController r103 = this.f155263b.getRenderController();
        StringBuilder r104 = new StringBuilder("set extra surface SurfaceTexture@");
        r104.append(r100.hashCode());
        r104.append(" surface@");
        Surface r105 = (Surface) this.f155262a.element;
        if (r105 == null) goto L5;
        Integer r106 = Integer.valueOf(r105.hashCode());
    L6:
        r104.append(r106);
        r104.append(" onSurfaceTextureAvailable");
        ILivePlayerExtraRenderController.DefaultImpls.log$default(r103, r104.toString(), false, 2, null);
        Object r107 = this.f155263b.getRenderController().getPlayerContext();
        if (r107 == null) goto L13;
        ITTLivePlayer r108 = ((LivePlayerContext) r107).f154929e;
        if (r108 == null) goto L14;
        r108.setExtraSurface((Surface) this.f155262a.element, 1);
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.player.LivePlayerContext");
    L5:
        r106 = null;
        goto L6
    }
}
