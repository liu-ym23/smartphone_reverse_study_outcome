package com.stepos.taskrobot.base.util;

import C7.r;
import J7.c;
import S7.n;
import android.app.Application;
import android.graphics.Bitmap;
import f6.AbstractC1436a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import s9.C1923c;

@c(c = "com.stepos.taskrobot.base.util.FileUtil$saveScreenshotToTaskDir2$2", f = "FileUtil.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class FileUtil$saveScreenshotToTaskDir2$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4027a;
    public final /* synthetic */ Bitmap b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUtil$saveScreenshotToTaskDir2$2(String str, Bitmap bitmap, H7.c cVar) {
        super(2, cVar);
        this.f4027a = str;
        this.b = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new FileUtil$saveScreenshotToTaskDir2$2(this.f4027a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((FileUtil$saveScreenshotToTaskDir2$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        String str = this.f4027a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        b.b(obj);
        try {
            Application application = S0.b.p;
            File file = new File(application != null ? application.getFilesDir() : null, "tasks/".concat(str));
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "screenshot_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".png";
            File file2 = new File(file, str2);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                } finally {
                }
            }
            fileOutputStream.close();
            C1923c c1923c = a.f4028a;
            String message = "Screenshot saved: " + str2;
            k.f(message, "message");
            AbstractC1683A.n(a.f4028a, null, new FileUtil$logToTaskFile$1(str, message, null), 3);
            AbstractC1436a.a("FileUtil", "Screenshot saved to: " + file2.getAbsolutePath(), true);
            return file2.getAbsolutePath();
        } catch (Exception e) {
            AbstractC1436a.c("FileUtil", "Failed to save screenshot", e);
            C1923c c1923c2 = a.f4028a;
            AbstractC1683A.n(a.f4028a, null, new FileUtil$logToTaskFile$1(str, androidx.constraintlayout.core.dsl.a.h("Failed to save screenshot: ", e.getMessage(), "message"), null), 3);
            return null;
        }
    }
}
