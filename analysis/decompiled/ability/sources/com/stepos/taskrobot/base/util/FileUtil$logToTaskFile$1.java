package com.stepos.taskrobot.base.util;

import C7.r;
import J7.c;
import S7.n;
import android.app.Application;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.taskrobot.base.util.FileUtil$logToTaskFile$1", f = "FileUtil.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class FileUtil$logToTaskFile$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4026a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUtil$logToTaskFile$1(String str, String str2, H7.c cVar) {
        super(2, cVar);
        this.f4026a = str;
        this.b = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new FileUtil$logToTaskFile$1(this.f4026a, this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        FileUtil$logToTaskFile$1 fileUtil$logToTaskFile$1 = (FileUtil$logToTaskFile$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        fileUtil$logToTaskFile$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        b.b(obj);
        try {
            Application application = S0.b.p;
            File file = new File(application != null ? application.getFilesDir() : null, "tasks/".concat(this.f4026a));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "process_log.txt");
            String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            FileWriter fileWriter = new FileWriter(file2, true);
            try {
                fileWriter.append((CharSequence) ("[" + str + "] " + this.b + "\n"));
                fileWriter.close();
            } finally {
            }
        } catch (Exception e) {
            Log.e("FileUtil", "Failed to write log", e);
        }
        return r.f317a;
    }
}
