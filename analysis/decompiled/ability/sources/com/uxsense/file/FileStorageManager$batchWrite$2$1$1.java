package com.uxsense.file;

import C7.r;
import J7.c;
import S7.n;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.uxsense.file.FileStorageManager$batchWrite$2$1$1", f = "FileStorageManager.kt", l = {TypedValues.PositionType.TYPE_PERCENT_HEIGHT}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes3.dex */
public final class FileStorageManager$batchWrite$2$1$1 extends SuspendLambda implements n {
    final /* synthetic */ String $content;
    final /* synthetic */ Path $path;
    int label;
    final /* synthetic */ FileStorageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorageManager$batchWrite$2$1$1(FileStorageManager fileStorageManager, Path path, String str, H7.c<? super FileStorageManager$batchWrite$2$1$1> cVar) {
        super(2, cVar);
        this.this$0 = fileStorageManager;
        this.$path = path;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new FileStorageManager$batchWrite$2$1$1(this.this$0, this.$path, this.$content, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        b.b(obj);
        FileStorageManager fileStorageManager = this.this$0;
        Path path = this.$path;
        String str = this.$content;
        this.label = 1;
        Object objWriteText$default = FileStorageManager.writeText$default(fileStorageManager, path, str, false, this, 4, null);
        return objWriteText$default == coroutineSingletons ? coroutineSingletons : objWriteText$default;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
        return ((FileStorageManager$batchWrite$2$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
