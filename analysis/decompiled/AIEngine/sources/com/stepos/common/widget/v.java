package com.stepos.common.widget;

import android.content.Context;
import android.media.SoundPool;
import com.stepos.common.widget.ScrollTextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7197a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7198b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView.l f7199c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements SoundPool.OnLoadCompleteListener {
        public a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i10, int i11) {
            synchronized (v.this.f7199c) {
                try {
                    v vVar = v.this;
                    ScrollTextView.l lVar = vVar.f7199c;
                    if (!lVar.f7023g && vVar.f7197a == lVar.h) {
                        lVar.f7021e = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public v(ScrollTextView.l lVar, int i10, Context context) {
        this.f7199c = lVar;
        this.f7197a = i10;
        this.f7198b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.v.run():void");
    }
}
