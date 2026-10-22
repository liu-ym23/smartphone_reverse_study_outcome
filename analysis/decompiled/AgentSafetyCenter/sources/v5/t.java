package v5;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements i {

    /* renamed from: a, reason: collision with root package name */
    public p f14811a;

    /* renamed from: b, reason: collision with root package name */
    public e6.m f14812b;

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c A[PHI: r11
      0x007c: PHI (r11v9 int) = (r11v6 int), (r11v6 int), (r11v15 int), (r11v15 int) binds: [B:42:0x0094, B:44:0x009a, B:30:0x006f, B:32:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // v5.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(nb.c r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.t.a(nb.c):java.lang.Object");
    }

    public final long b(MediaMetadataRetriever mediaMetadataRetriever) {
        Long lW;
        e6.m mVar = this.f14812b;
        e6.o oVar = (e6.o) mVar.f3583l.f3591c.get("coil#video_frame_micros");
        Long l2 = oVar != null ? oVar.f3588a : null;
        if (l2 != null) {
            return l2.longValue();
        }
        e6.o oVar2 = (e6.o) mVar.f3583l.f3591c.get("coil#video_frame_percent");
        Double d7 = (Double) (oVar2 != null ? oVar2.f3588a : null);
        long jLongValue = 0;
        if (d7 == null) {
            return 0L;
        }
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (strExtractMetadata != null && (lW = hc.o.W(strExtractMetadata)) != null) {
            jLongValue = lW.longValue();
        }
        return ac.a.R(d7.doubleValue() * jLongValue) * 1000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (t.c1.f(r8.getWidth(), r8.getHeight(), r9 instanceof f6.a ? ((f6.a) r9).f3916c : r8.getWidth(), r0 instanceof f6.a ? ((f6.a) r0).f3916c : r8.getHeight(), r7.f3577e) == 1.0d) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap c(android.graphics.Bitmap r8, f6.g r9) {
        /*
            r7 = this;
            p5.f r0 = r9.f3928b
            p5.f r9 = r9.f3927a
            e6.m r7 = r7.f14812b
            android.graphics.Bitmap$Config r1 = r8.getConfig()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.HARDWARE
            if (r1 != r2) goto L12
            android.graphics.Bitmap$Config r1 = r7.f3574b
            if (r1 != r2) goto L48
        L12:
            boolean r1 = r7.f3578f
            if (r1 == 0) goto L17
            goto L47
        L17:
            int r1 = r8.getWidth()
            int r3 = r8.getHeight()
            boolean r4 = r9 instanceof f6.a
            if (r4 == 0) goto L29
            r4 = r9
            f6.a r4 = (f6.a) r4
            int r4 = r4.f3916c
            goto L2d
        L29:
            int r4 = r8.getWidth()
        L2d:
            boolean r5 = r0 instanceof f6.a
            if (r5 == 0) goto L37
            r5 = r0
            f6.a r5 = (f6.a) r5
            int r5 = r5.f3916c
            goto L3b
        L37:
            int r5 = r8.getHeight()
        L3b:
            f6.f r6 = r7.f3577e
            double r3 = t.c1.f(r1, r3, r4, r5, r6)
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L48
        L47:
            return r8
        L48:
            int r1 = r8.getWidth()
            int r3 = r8.getHeight()
            boolean r4 = r9 instanceof f6.a
            if (r4 == 0) goto L59
            f6.a r9 = (f6.a) r9
            int r9 = r9.f3916c
            goto L5d
        L59:
            int r9 = r8.getWidth()
        L5d:
            boolean r4 = r0 instanceof f6.a
            if (r4 == 0) goto L66
            f6.a r0 = (f6.a) r0
            int r0 = r0.f3916c
            goto L6a
        L66:
            int r0 = r8.getHeight()
        L6a:
            f6.f r4 = r7.f3577e
            double r0 = t.c1.f(r1, r3, r9, r0, r4)
            float r9 = (float) r0
            int r0 = r8.getWidth()
            float r0 = (float) r0
            float r0 = r0 * r9
            int r0 = ac.a.Q(r0)
            int r1 = r8.getHeight()
            float r1 = (float) r1
            float r1 = r1 * r9
            int r1 = ac.a.Q(r1)
            android.graphics.Bitmap$Config r7 = r7.f3574b
            if (r7 != r2) goto L8b
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
        L8b:
            android.graphics.Paint r2 = new android.graphics.Paint
            r3 = 3
            r2.<init>(r3)
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r0, r1, r7)
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r7)
            r0.scale(r9, r9)
            r9 = 0
            r0.drawBitmap(r8, r9, r9, r2)
            r8.recycle()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v5.t.c(android.graphics.Bitmap, f6.g):android.graphics.Bitmap");
    }

    public final void d(MediaMetadataRetriever mediaMetadataRetriever, p pVar) throws IOException, SecurityException, IllegalArgumentException {
        e6.m mVar = this.f14812b;
        i1 i1VarE = pVar.e();
        if (!(i1VarE instanceof a)) {
            if (i1VarE instanceof e) {
                mediaMetadataRetriever.setDataSource(mVar.f3573a, ((e) i1VarE).f14783a);
                return;
            }
            if (!(i1VarE instanceof q)) {
                mediaMetadataRetriever.setDataSource(pVar.d().toFile().getPath());
                return;
            }
            StringBuilder sb2 = new StringBuilder("android.resource://");
            q qVar = (q) i1VarE;
            sb2.append(qVar.f14804a);
            sb2.append(JsonPointer.SEPARATOR);
            sb2.append(qVar.f14805b);
            mediaMetadataRetriever.setDataSource(sb2.toString());
            return;
        }
        AssetFileDescriptor assetFileDescriptorOpenFd = mVar.f3573a.getAssets().openFd(((a) i1VarE).f14772a);
        try {
            mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            assetFileDescriptorOpenFd.close();
        } finally {
        }
    }
}
