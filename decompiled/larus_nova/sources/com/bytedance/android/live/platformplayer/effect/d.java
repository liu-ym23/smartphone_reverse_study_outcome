package com.bytedance.android.live.platformplayer.effect;

import com.bytedance.android.livesdkapi.roomplayer.ComposerResult;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.Set;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements ComposerResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VrEffectDownloader f85483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ILivePlayerClient f85484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f85485c;

    @Override // com.bytedance.android.livesdkapi.roomplayer.ComposerResult
    public final void onResult(int r100) {
        com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "setResourceRet=" + r100 + ",player=" + this.f85484b);
        VrEffectDownloader r101 = this.f85483a;
        if (r101.f85471d >= 0) goto L5;
        r101.f85471d = System.currentTimeMillis();
    L5:
        VrEffectDownloader r102 = this.f85483a;
        Set<String> r103 = VrEffectDownloader.f85466g;
        String r104 = VrEffectDownloader.f85467h;
        if (r100 != 0) goto L8;
        boolean r105 = true;
    L9:
        VrEffectDownloader.b(r102, r104, r105, this.f85485c);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public d(VrEffectDownloader r100, ILivePlayerClient r101, boolean r102) {
        this.f85483a = r100;
        this.f85484b = r101;
        this.f85485c = r102;
    }
}
