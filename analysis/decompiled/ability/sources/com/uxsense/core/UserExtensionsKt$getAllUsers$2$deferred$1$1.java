package com.uxsense.core;

import C7.r;
import S7.n;
import com.uxsense.base.metadata.User;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@J7.c(c = "com.uxsense.core.UserExtensionsKt$getAllUsers$2$deferred$1$1", f = "UserExtensions.kt", l = {145}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes3.dex */
public final class UserExtensionsKt$getAllUsers$2$deferred$1$1 extends SuspendLambda implements n {
    final /* synthetic */ Path $file;
    final /* synthetic */ ApexMetadataFileManager $this_getAllUsers;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserExtensionsKt$getAllUsers$2$deferred$1$1(ApexMetadataFileManager apexMetadataFileManager, Path path, H7.c<? super UserExtensionsKt$getAllUsers$2$deferred$1$1> cVar) {
        super(2, cVar);
        this.$this_getAllUsers = apexMetadataFileManager;
        this.$file = path;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new UserExtensionsKt$getAllUsers$2$deferred$1$1(this.$this_getAllUsers, this.$file, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        FileStorageManager storage_$uxsense_release = this.$this_getAllUsers.getStorage_$uxsense_release();
        Path path = this.$file;
        k.c(path);
        x9.b bVarSerializer = User.INSTANCE.serializer();
        this.label = 1;
        Object json = storage_$uxsense_release.readJson(path, bVarSerializer, this);
        return json == coroutineSingletons ? coroutineSingletons : json;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<User>> cVar) {
        return ((UserExtensionsKt$getAllUsers$2$deferred$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
