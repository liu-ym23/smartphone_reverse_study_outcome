package com.bytedance.android.debug;

import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f42627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITextureViewPlayerController f42628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f42629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f42630d;

    public interface a {
        void a();

        void b();

        void onEnd();

        void onStart();

        void onStop();
    }

    public static final class b implements IPlayerActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f42631a;

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.CC.$default$onFirstFrame(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onReportPlayMetrics(Map r100) {
            IPlayerActionListener.CC.$default$onReportPlayMetrics(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onEnd() {
            a r100 = this.f42631a.f42630d;
            if (r100 == null) goto L6;
            r100.onEnd();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStart() {
            a r100 = this.f42631a.f42630d;
            if (r100 == null) goto L6;
            r100.onStart();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStop() {
            a r100 = this.f42631a.f42630d;
            if (r100 == null) goto L6;
            r100.onStop();
            return;
        }

        public b(l r100) {
            this.f42631a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onFileLoaded(int r100, int r101) {
            a r102 = this.f42631a.f42630d;
            if (r102 == null) goto L6;
            r102.a();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
            a r104 = this.f42631a.f42630d;
            if (r104 == null) goto L6;
            r104.b();
            return;
        }
    }

    public l() {
        this.f42629c = new b(this);
    }
}
