package org.libpag;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class PAGDecoder {

    /* renamed from: a, reason: collision with root package name */
    private int f19131a;

    /* renamed from: b, reason: collision with root package name */
    private int f19132b;

    /* renamed from: c, reason: collision with root package name */
    private int f19133c;

    /* renamed from: d, reason: collision with root package name */
    private PAGSurface f19134d;

    /* renamed from: e, reason: collision with root package name */
    private PAGPlayer f19135e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f19136f;

    static {
        P4.a.a("pag");
    }

    public static PAGDecoder Make(PAGComposition pAGComposition) {
        return Make(pAGComposition, pAGComposition.frameRate(), 1.0f);
    }

    private boolean a() {
        if (this.f19134d == null) {
            this.f19134d = PAGSurface.MakeOffscreen(this.f19131a, this.f19132b);
        }
        PAGSurface pAGSurface = this.f19134d;
        if (pAGSurface != null) {
            this.f19135e.setSurface(pAGSurface);
        }
        return this.f19134d != null;
    }

    public boolean copyFrameTo(Bitmap bitmap, int i5) {
        if (bitmap == null || bitmap.isRecycled() || i5 < 0 || i5 >= this.f19133c || !a()) {
            return false;
        }
        this.f19135e.setProgress(k.b(i5, this.f19133c));
        this.f19135e.flush();
        return this.f19134d.copyPixelsTo(bitmap);
    }

    public Bitmap frameAtIndex(int i5) {
        Bitmap bitmap;
        if (i5 < 0 || i5 >= this.f19133c || !a()) {
            return null;
        }
        this.f19135e.setProgress(k.b(i5, this.f19133c));
        if (!this.f19135e.flush() && (bitmap = this.f19136f) != null && !bitmap.isRecycled()) {
            return this.f19136f;
        }
        Bitmap bitmapMakeSnapshot = this.f19134d.makeSnapshot();
        this.f19136f = bitmapMakeSnapshot;
        return bitmapMakeSnapshot;
    }

    public int height() {
        return this.f19132b;
    }

    public int numFrames() {
        return this.f19133c;
    }

    public void release() {
        PAGSurface pAGSurface = this.f19134d;
        if (pAGSurface != null) {
            pAGSurface.release();
        }
        this.f19135e.setSurface(null);
        this.f19135e.setComposition(null);
        this.f19135e.release();
    }

    public int width() {
        return this.f19131a;
    }

    public static PAGDecoder Make(PAGComposition pAGComposition, float f5, float f6) {
        if (pAGComposition == null) {
            return null;
        }
        if (f6 <= 0.0f) {
            f6 = 1.0f;
        }
        float fFrameRate = f5 <= 0.0f ? pAGComposition.frameRate() : Math.min(pAGComposition.frameRate(), f5);
        PAGDecoder pAGDecoder = new PAGDecoder();
        pAGDecoder.f19131a = Math.round(pAGComposition.width() * f6);
        pAGDecoder.f19132b = Math.round(pAGComposition.height() * f6);
        pAGDecoder.f19133c = (int) ((pAGComposition.duration() * fFrameRate) / 1000000.0f);
        PAGPlayer pAGPlayer = new PAGPlayer();
        pAGDecoder.f19135e = pAGPlayer;
        if (fFrameRate > 0.0f) {
            pAGPlayer.setMaxFrameRate(fFrameRate);
        }
        pAGDecoder.f19135e.setComposition(pAGComposition);
        return pAGDecoder;
    }
}
