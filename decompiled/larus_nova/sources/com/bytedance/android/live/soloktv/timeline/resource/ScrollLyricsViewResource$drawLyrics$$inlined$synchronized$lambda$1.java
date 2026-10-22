package com.bytedance.android.live.soloktv.timeline.resource;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import fd2.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/soloktv/timeline/resource/ScrollLyricsViewResource$drawLyrics$1$3"}, k = 3, mv = {1, 5, 1})
final class ScrollLyricsViewResource$drawLyrics$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ rjc.c $time$inlined;
    final /* synthetic */ b this$0;

    public ScrollLyricsViewResource$drawLyrics$$inlined$synchronized$lambda$1(b r100, rjc.c r101) {
        this.this$0 = r100;
        this.$time$inlined = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Object r100 = this.this$0.f101509d;     // Catch: Exception -> L18
        monitor-enter(r100);     // Catch: Exception -> L18
        b r101 = this.this$0;     // Catch: Throwable -> L15
        if (r101.f101508c != null) goto L7;
        rjc.b r102 = r101.f101514i;     // Catch: Throwable -> L15
        r101.f101508c = Bitmap.createBitmap((int) r102.f538231a, (int) r102.f538232b, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L15
    L7:
        Bitmap r103 = this.this$0.f101508c;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L15
        Canvas r104 = new Canvas(r103);     // Catch: Throwable -> L15
        r104.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L15
        View r105 = this.this$0.f101507b;     // Catch: Throwable -> L15
        if (r105 == null) goto L10;
        r105.draw(r104);     // Catch: Throwable -> L15
    L10:
        long r106 = (long) (this.$time$inlined.f538236c * 1000);     // Catch: Throwable -> L15
        l r107 = this.this$0.f101506a;     // Catch: Throwable -> L15
        if (r107 == null) goto L13;
        l.b.a(r107, r106, false, 6);     // Catch: Throwable -> L15
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        monitor-exit(r100);     // Catch: Exception -> L18
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        String r109 = this.this$0.f101510e;
        String r110 = "imageAtTime main thread draw exception=" + Log.getStackTraceString(e);
        ALogger.e(bb0.b.b(), r109 + HTTP.HEADER_LINE_DELIM + r110 + ", invoke class :" + b.class.getSimpleName());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
