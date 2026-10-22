package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Trace;
import androidx.emoji2.text.d;
import androidx.emoji2.text.g;
import java.nio.MappedByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f970a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f971b;

    public /* synthetic */ z0(androidx.room.i iVar, String[] strArr) {
        this.f970a = 2;
        this.f971b = strArr;
    }

    private final void a() {
        g.b bVar = (g.b) this.f971b;
        synchronized (bVar.f1962d) {
            try {
                if (bVar.h == null) {
                    return;
                }
                try {
                    s0.l lVarC = bVar.c();
                    int i10 = lVarC.f11866f;
                    if (i10 == 2) {
                        synchronized (bVar.f1962d) {
                        }
                    }
                    if (i10 != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i10 + ")");
                    }
                    try {
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        g.a aVar = bVar.f1961c;
                        Context context = bVar.f1959a;
                        aVar.getClass();
                        Typeface typefaceA = n0.e.a(context, new s0.l[]{lVarC}, 0);
                        MappedByteBuffer mappedByteBufferA = n0.i.a(bVar.f1959a, lVarC.f11861a);
                        if (mappedByteBufferA == null || typefaceA == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        try {
                            Trace.beginSection("EmojiCompat.MetadataRepo.create");
                            androidx.emoji2.text.h hVar = new androidx.emoji2.text.h(typefaceA, i1.d.b(mappedByteBufferA));
                            Trace.endSection();
                            synchronized (bVar.f1962d) {
                                try {
                                    d.i iVar = bVar.h;
                                    if (iVar != null) {
                                        iVar.b(hVar);
                                    }
                                } finally {
                                }
                            }
                            bVar.b();
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (bVar.f1962d) {
                        try {
                            d.i iVar2 = bVar.h;
                            if (iVar2 != null) {
                                iVar2.a(th2);
                            }
                            bVar.b();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    private final void b() {
        synchronized (((u9.a) this.f971b)) {
            if (u9.a.h) {
                return;
            }
            u9.a.h = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02ba A[LOOP:2: B:93:0x015f->B:178:0x02ba, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x02bf A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1112
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z0.run():void");
    }

    public /* synthetic */ z0(Object obj, int i10) {
        this.f970a = i10;
        this.f971b = obj;
    }
}
