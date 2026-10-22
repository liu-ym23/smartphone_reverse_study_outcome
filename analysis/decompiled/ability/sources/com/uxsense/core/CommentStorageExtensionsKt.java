package com.uxsense.core;

import C7.r;
import S7.n;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.CommentChunk;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a:\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001aJ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015\u001a:\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "appName", "", "userId", "Lcom/uxsense/base/metadata/CommentChunk;", "chunk", "Lcom/uxsense/file/FileResult;", "LC7/r;", "saveCommentChunk", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLcom/uxsense/base/metadata/CommentChunk;LH7/c;)Ljava/lang/Object;", "creationId", "chunkId", "loadCommentChunk", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJJLH7/c;)Ljava/lang/Object;", "", "Lcom/uxsense/base/metadata/Comment;", "comments", "", "maxCommentsPerChunk", "saveComments", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJLjava/util/List;ILH7/c;)Ljava/lang/Object;", "limit", "loadLatestComments", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJILH7/c;)Ljava/lang/Object;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommentStorageExtensionsKt {

    @J7.c(c = "com.uxsense.core.CommentStorageExtensionsKt$loadCommentChunk$2", f = "CommentStorageExtensions.kt", l = {99}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/CommentChunk;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CommentStorageExtensionsKt$loadCommentChunk$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chunkId;
        final /* synthetic */ long $creationId;
        final /* synthetic */ ApexMetadataFileManager $this_loadCommentChunk;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, long j10, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_loadCommentChunk = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
            this.$chunkId = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_loadCommentChunk, this.$appName, this.$userId, this.$creationId, this.$chunkId, cVar);
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
            Path commentChunkFilePath = this.$this_loadCommentChunk.getCommentChunkFilePath(this.$appName, this.$userId, this.$creationId, this.$chunkId);
            FileStorageManager storage_$uxsense_release = this.$this_loadCommentChunk.getStorage_$uxsense_release();
            x9.b bVarSerializer = CommentChunk.INSTANCE.serializer();
            this.label = 1;
            Object json = storage_$uxsense_release.readJson(commentChunkFilePath, bVarSerializer, this);
            return json == coroutineSingletons ? coroutineSingletons : json;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<CommentChunk>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CommentStorageExtensionsKt$loadLatestComments$2", f = "CommentStorageExtensions.kt", l = {100}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/Comment;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CommentStorageExtensionsKt$loadLatestComments$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12492 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        final /* synthetic */ int $limit;
        final /* synthetic */ ApexMetadataFileManager $this_loadLatestComments;
        final /* synthetic */ long $userId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12492(int i, ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super C12492> cVar) {
            super(2, cVar);
            this.$limit = i;
            this.$this_loadLatestComments = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12492(this.$limit, this.$this_loadLatestComments, this.$appName, this.$userId, this.$creationId, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008f -> B:24:0x0092). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L20
                if (r1 != r2) goto L18
                int r1 = r9.I$0
                java.lang.Object r3 = r9.L$1
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r9.L$0
                java.util.List r4 = (java.util.List) r4
                kotlin.b.b(r10)
                goto L92
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                kotlin.b.b(r10)
                int r10 = r9.$limit
                if (r10 > 0) goto L2a
                kotlin.collections.EmptyList r9 = kotlin.collections.EmptyList.f4893a
                return r9
            L2a:
                com.uxsense.core.ApexMetadataFileManager r3 = r9.$this_loadLatestComments
                java.lang.String r4 = r9.$appName
                long r5 = r9.$userId
                long r7 = r9.$creationId
                java.nio.file.Path r10 = r3.getCommentChunkDir(r4, r5, r7)
                java.io.File r10 = r10.toFile()
                java.io.File[] r10 = r10.listFiles()
                if (r10 == 0) goto L4a
                com.uxsense.core.CommentStorageExtensionsKt$loadLatestComments$2$invokeSuspend$$inlined$sortedBy$1 r1 = new com.uxsense.core.CommentStorageExtensionsKt$loadLatestComments$2$invokeSuspend$$inlined$sortedBy$1
                r1.<init>()
                java.util.List r10 = D7.q.D0(r10, r1)
                goto L4c
            L4a:
                kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.f4893a
            L4c:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                int r3 = r9.$limit
                D7.K r10 = D7.v.r0(r10)
                java.util.Iterator r10 = r10.iterator()
                r4 = r1
                r1 = r3
                r3 = r10
            L5e:
                boolean r10 = r3.hasNext()
                if (r10 == 0) goto Lc4
                java.lang.Object r10 = r3.next()
                java.io.File r10 = (java.io.File) r10
                if (r1 <= 0) goto Lc4
                com.uxsense.core.ApexMetadataFileManager r5 = r9.$this_loadLatestComments
                com.uxsense.file.FileStorageManager r5 = r5.getStorage_$uxsense_release()
                java.nio.file.Path r10 = r10.toPath()
                java.lang.String r6 = "toPath(...)"
                kotlin.jvm.internal.k.e(r10, r6)
                com.uxsense.base.metadata.CommentChunk$Companion r6 = com.uxsense.base.metadata.CommentChunk.INSTANCE
                x9.b r6 = r6.serializer()
                x9.a r6 = (x9.InterfaceC2123a) r6
                r9.L$0 = r4
                r9.L$1 = r3
                r9.I$0 = r1
                r9.label = r2
                java.lang.Object r10 = r5.readJson(r10, r6, r9)
                if (r10 != r0) goto L92
                return r0
            L92:
                com.uxsense.file.FileResult r10 = (com.uxsense.file.FileResult) r10
                boolean r5 = r10 instanceof com.uxsense.file.FileResult.Success
                if (r5 == 0) goto La5
                com.uxsense.file.FileResult$Success r10 = (com.uxsense.file.FileResult.Success) r10
                java.lang.Object r10 = r10.getData()
                com.uxsense.base.metadata.CommentChunk r10 = (com.uxsense.base.metadata.CommentChunk) r10
                java.util.List r10 = r10.getComments()
                goto La7
            La5:
                kotlin.collections.EmptyList r10 = kotlin.collections.EmptyList.f4893a
            La7:
                int r5 = r10.size()
                if (r5 > r1) goto Lb9
                r5 = r10
                java.util.Collection r5 = (java.util.Collection) r5
                r4.addAll(r5)
                int r10 = r10.size()
                int r1 = r1 - r10
                goto L5e
            Lb9:
                java.util.List r10 = D7.v.b1(r1, r10)
                java.util.Collection r10 = (java.util.Collection) r10
                r4.addAll(r10)
                r1 = 0
                goto L5e
            Lc4:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.CommentStorageExtensionsKt.C12492.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<Comment>> cVar) {
            return ((C12492) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CommentStorageExtensionsKt$saveCommentChunk$2", f = "CommentStorageExtensions.kt", l = {99}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CommentStorageExtensionsKt$saveCommentChunk$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12502 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ CommentChunk $chunk;
        final /* synthetic */ ApexMetadataFileManager $this_saveCommentChunk;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12502(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, CommentChunk commentChunk, H7.c<? super C12502> cVar) {
            super(2, cVar);
            this.$this_saveCommentChunk = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$chunk = commentChunk;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12502(this.$this_saveCommentChunk, this.$appName, this.$userId, this.$chunk, cVar);
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
            Path commentChunkFilePath = this.$this_saveCommentChunk.getCommentChunkFilePath(this.$appName, this.$userId, this.$chunk.getCreationId(), this.$chunk.getChunkId());
            FileStorageManager storage_$uxsense_release = this.$this_saveCommentChunk.getStorage_$uxsense_release();
            CommentChunk commentChunk = this.$chunk;
            x9.b bVarSerializer = CommentChunk.INSTANCE.serializer();
            this.label = 1;
            Object objWriteJson = storage_$uxsense_release.writeJson(commentChunkFilePath, commentChunk, bVarSerializer, this);
            return objWriteJson == coroutineSingletons ? coroutineSingletons : objWriteJson;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12502) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CommentStorageExtensionsKt$saveComments$2", f = "CommentStorageExtensions.kt", l = {100, 101, 102}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult$Success;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult$Success;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CommentStorageExtensionsKt$saveComments$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12512 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ List<Comment> $comments;
        final /* synthetic */ long $creationId;
        final /* synthetic */ int $maxCommentsPerChunk;
        final /* synthetic */ ApexMetadataFileManager $this_saveComments;
        final /* synthetic */ long $userId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12512(List<Comment> list, ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, int i, H7.c<? super C12512> cVar) {
            super(2, cVar);
            this.$comments = list;
            this.$this_saveComments = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
            this.$maxCommentsPerChunk = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12512(this.$comments, this.$this_saveComments, this.$appName, this.$userId, this.$creationId, this.$maxCommentsPerChunk, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0188, code lost:
        
            if (r15.writeJson(r6, r6, r7, r21) == r1) goto L39;
         */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0196  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0188 -> B:40:0x018b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 412
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.CommentStorageExtensionsKt.C12512.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult.Success<r>> cVar) {
            return ((C12512) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final Object loadCommentChunk(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, long j10, H7.c<? super FileResult<CommentChunk>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(apexMetadataFileManager, str, j5, j6, j10, null), cVar);
    }

    public static final Object loadLatestComments(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, int i, H7.c<? super List<Comment>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12492(i, apexMetadataFileManager, str, j5, j6, null), cVar);
    }

    public static final Object saveCommentChunk(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, CommentChunk commentChunk, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12502(apexMetadataFileManager, str, j5, commentChunk, null), cVar);
    }

    public static final Object saveComments(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, List<Comment> list, int i, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12512(list, apexMetadataFileManager, str, j5, j6, i, null), cVar);
    }
}
