package bh9;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import gd9.h;
import gd9.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f19070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f19071b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile com.larus.kmp.voice_setting.voice.dialog.v2.api.d f19072c;

    static {
        f19070a = LazyKt.lazy(new c());
        f19071b = LazyKt.lazy(new d());
    }

    public static void a() {
        if (f19072c == null) goto L5;
        return;
    L5:
        String r100 = "";
        String r101 = ((z) f19071b.getValue()).a("key_voice_material_response", "", "voice_material_repo");
        if (r101 == null) goto L9;
        r100 = r101;
    L9:
        h r102 = (h) f19070a.getValue();
        StringBuilder r103 = new StringBuilder("[loadVoiceMaterialResponse]: invoke sync dataStr isNotEmpty(");
        boolean r104 = false;
        if (r100.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        r103.append(r105);
        r103.append(')');
        r102.i("VoiceMaterialRepo", r103.toString());
        if (r100.length() <= 0) goto L16;
        r104 = true;
    L16:
        if (r104 == false) goto L37;
        Object r106 = null;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L24
        int r108 = com.larus.kmp.voice_setting.voice.dialog.v2.api.a.f353044a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);     // Catch: Throwable -> L24
        if (StringsKt.isBlank(r100) == false) goto L21;
        com.larus.kmp.voice_setting.voice.dialog.v2.api.d r109 = null;
    L22:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L24
    L26:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L30;
        ((h) f19070a.getValue()).e("VoiceMaterialRepo", "[loadVoiceMaterialResponse] error", r111);
    L30:
        if (Result.m9455isFailureimpl(r110) == true) goto L33;
        r106 = r110;
    L33:
        f19072c = (com.larus.kmp.voice_setting.voice.dialog.v2.api.d) r106;
        return;
    L21:
        wt7.c r112 = wt7.a.f561230a;     // Catch: Throwable -> L24
        juc.d<com.larus.kmp.voice_setting.voice.dialog.v2.api.d> r113 = com.larus.kmp.voice_setting.voice.dialog.v2.api.d.Companion.serializer();     // Catch: Throwable -> L24
        r112.getClass();     // Catch: Throwable -> L24
        r109 = (com.larus.kmp.voice_setting.voice.dialog.v2.api.d) wt7.c.a(r100, r113);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L37:
        return;
    L12:
        r105 = false;
        goto L13
    }
}
