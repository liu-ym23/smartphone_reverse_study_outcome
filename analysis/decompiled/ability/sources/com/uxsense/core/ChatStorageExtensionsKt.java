package com.uxsense.core;

import C7.r;
import S7.n;
import androidx.appcompat.app.AppCompatDelegate;
import com.uxsense.base.metadata.Chat;
import com.uxsense.base.metadata.ChatMessage;
import com.uxsense.base.metadata.MessagePage;
import com.uxsense.file.FileResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\r\u001aJ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a:\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a6\u0010\u0019\u001a\u0004\u0018\u00010\u0016*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0019\u0010\u0018\u001aF\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u001c0\u001b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u001f\u0010\r¨\u0006 "}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "appName", "Lcom/uxsense/base/metadata/Chat;", "chat", "Lcom/uxsense/file/FileResult;", "LC7/r;", "saveChat", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Lcom/uxsense/base/metadata/Chat;LH7/c;)Ljava/lang/Object;", "", "userId", "chatId", "loadChat", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJLH7/c;)Ljava/lang/Object;", "", "Lcom/uxsense/base/metadata/ChatMessage;", "messages", "", "pageSize", "saveMessagePage", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJLjava/util/List;ILH7/c;)Ljava/lang/Object;", "pageId", "Lcom/uxsense/base/metadata/MessagePage;", "loadMessagePage", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJJLH7/c;)Ljava/lang/Object;", "safeLoadMessagePage", "limit", "Lkotlin/Pair;", "", "loadLatestMessages", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJILH7/c;)Ljava/lang/Object;", "loadAllMessages", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatStorageExtensionsKt {

    @J7.c(c = "com.uxsense.core.ChatStorageExtensionsKt$loadAllMessages$2", f = "ChatStorageExtensions.kt", l = {136, 142}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/ChatMessage;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ChatStorageExtensionsKt$loadAllMessages$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ ApexMetadataFileManager $this_loadAllMessages;
        final /* synthetic */ long $userId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_loadAllMessages = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_loadAllMessages, this.$appName, this.$userId, this.$chatId, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        
            if (r13 == r0) goto L22;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[RETURN] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:24:0x0086). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r12.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L27
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r12.L$1
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r12.L$0
                java.util.List r3 = (java.util.List) r3
                kotlin.b.b(r13)
                r9 = r12
                goto L86
            L1a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L22:
                kotlin.b.b(r13)
                r9 = r12
                goto L3d
            L27:
                kotlin.b.b(r13)
                r13 = r3
                com.uxsense.core.ApexMetadataFileManager r3 = r12.$this_loadAllMessages
                java.lang.String r4 = r12.$appName
                long r5 = r12.$userId
                long r7 = r12.$chatId
                r12.label = r13
                r9 = r12
                java.lang.Object r13 = com.uxsense.core.ChatStorageExtensionsKt.loadChat(r3, r4, r5, r7, r9)
                if (r13 != r0) goto L3d
                goto L83
            L3d:
                com.uxsense.file.FileResult r13 = (com.uxsense.file.FileResult) r13
                boolean r12 = r13 instanceof com.uxsense.file.FileResult.Success
                if (r12 != 0) goto L46
                kotlin.collections.EmptyList r12 = kotlin.collections.EmptyList.f4893a
                return r12
            L46:
                com.uxsense.file.FileResult$Success r13 = (com.uxsense.file.FileResult.Success) r13
                java.lang.Object r12 = r13.getData()
                com.uxsense.base.metadata.Chat r12 = (com.uxsense.base.metadata.Chat) r12
                java.util.ArrayList r13 = new java.util.ArrayList
                r13.<init>()
                java.util.List r12 = r12.getPageIds()
                java.util.Iterator r12 = r12.iterator()
                r1 = r12
            L5c:
                boolean r12 = r1.hasNext()
                if (r12 == 0) goto L95
                java.lang.Object r12 = r1.next()
                java.lang.Number r12 = (java.lang.Number) r12
                long r3 = r12.longValue()
                r11 = r9
                r9 = r3
                com.uxsense.core.ApexMetadataFileManager r3 = r11.$this_loadAllMessages
                java.lang.String r4 = r11.$appName
                long r5 = r11.$userId
                long r7 = r11.$chatId
                r11.L$0 = r13
                r11.L$1 = r1
                r11.label = r2
                java.lang.Object r12 = com.uxsense.core.ChatStorageExtensionsKt.access$safeLoadMessagePage(r3, r4, r5, r7, r9, r11)
                r9 = r11
                if (r12 != r0) goto L84
            L83:
                return r0
            L84:
                r3 = r13
                r13 = r12
            L86:
                com.uxsense.base.metadata.MessagePage r13 = (com.uxsense.base.metadata.MessagePage) r13
                if (r13 == 0) goto L93
                java.util.List r12 = r13.getMessages()
                java.util.Collection r12 = (java.util.Collection) r12
                r3.addAll(r12)
            L93:
                r13 = r3
                goto L5c
            L95:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ChatStorageExtensionsKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<ChatMessage>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ChatStorageExtensionsKt$loadLatestMessages$2", f = "ChatStorageExtensions.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 118}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lm9/z;", "Lkotlin/Pair;", "", "Lcom/uxsense/base/metadata/ChatMessage;", "", "<anonymous>", "(Lm9/z;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ChatStorageExtensionsKt$loadLatestMessages$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12472 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ int $limit;
        final /* synthetic */ ApexMetadataFileManager $this_loadLatestMessages;
        final /* synthetic */ long $userId;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12472(int i, ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super C12472> cVar) {
            super(2, cVar);
            this.$limit = i;
            this.$this_loadLatestMessages = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12472(this.$limit, this.$this_loadLatestMessages, this.$appName, this.$userId, this.$chatId, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        
            if (r0 == r9) goto L28;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:32:0x00bd, B:39:0x00f4], limit reached: 44 */
        /* JADX WARN: Path cross not found for [B:39:0x00f4, B:32:0x00bd], limit reached: 44 */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b8 -> B:30:0x00b9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ChatStorageExtensionsKt.C12472.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Pair<? extends List<ChatMessage>, Boolean>> cVar) {
            return ((C12472) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ChatStorageExtensionsKt", f = "ChatStorageExtensions.kt", l = {93}, m = "safeLoadMessagePage")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.ChatStorageExtensionsKt$safeLoadMessagePage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChatStorageExtensionsKt.safeLoadMessagePage(null, null, 0L, 0L, 0L, this);
        }
    }

    @J7.c(c = "com.uxsense.core.ChatStorageExtensionsKt$saveMessagePage$2", f = "ChatStorageExtensions.kt", l = {35, 50, 146, 149, 82}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ChatStorageExtensionsKt$saveMessagePage$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12482 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ List<ChatMessage> $messages;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ ApexMetadataFileManager $this_saveMessagePage;
        final /* synthetic */ long $userId;
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12482(List<ChatMessage> list, ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, int i, H7.c<? super C12482> cVar) {
            super(2, cVar);
            this.$messages = list;
            this.$this_saveMessagePage = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
            this.$pageSize = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12482(this.$messages, this.$this_saveMessagePage, this.$appName, this.$userId, this.$chatId, this.$pageSize, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x01a8, code lost:
        
            if (r5.writeJson(r7, r4, r8, r6) == r9) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x029c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0259 -> B:14:0x004f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r45) throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 700
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ChatStorageExtensionsKt.C12482.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12482) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final Object loadAllMessages(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super List<ChatMessage>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(apexMetadataFileManager, str, j5, j6, null), cVar);
    }

    public static final Object loadChat(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super FileResult<Chat>> cVar) {
        return apexMetadataFileManager.getStorage_$uxsense_release().readJson(apexMetadataFileManager.getChatFilePath(str, j5, j6), Chat.INSTANCE.serializer(), cVar);
    }

    public static final Object loadLatestMessages(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, int i, H7.c<? super Pair<? extends List<ChatMessage>, Boolean>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12472(i, apexMetadataFileManager, str, j5, j6, null), cVar);
    }

    public static final Object loadMessagePage(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, long j10, H7.c<? super FileResult<MessagePage>> cVar) {
        return apexMetadataFileManager.getStorage_$uxsense_release().readJson(apexMetadataFileManager.getMessagePageFilePath(str, j5, j6, j10), MessagePage.INSTANCE.serializer(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object safeLoadMessagePage(com.uxsense.core.ApexMetadataFileManager r4, java.lang.String r5, long r6, long r8, long r10, H7.c<? super com.uxsense.base.metadata.MessagePage> r12) {
        /*
            boolean r0 = r12 instanceof com.uxsense.core.ChatStorageExtensionsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.uxsense.core.ChatStorageExtensionsKt$safeLoadMessagePage$1 r0 = (com.uxsense.core.ChatStorageExtensionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r12 = r0
            goto L1a
        L14:
            com.uxsense.core.ChatStorageExtensionsKt$safeLoadMessagePage$1 r0 = new com.uxsense.core.ChatStorageExtensionsKt$safeLoadMessagePage$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r0 = r12.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r12.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.b.b(r0)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r0)
            r12.label = r3
            java.lang.Object r0 = loadMessagePage(r4, r5, r6, r8, r10, r12)
            if (r0 != r1) goto L3d
            return r1
        L3d:
            com.uxsense.file.FileResult r0 = (com.uxsense.file.FileResult) r0
            boolean r4 = r0 instanceof com.uxsense.file.FileResult.Success
            if (r4 == 0) goto L4c
            com.uxsense.file.FileResult$Success r0 = (com.uxsense.file.FileResult.Success) r0
            java.lang.Object r4 = r0.getData()
            com.uxsense.base.metadata.MessagePage r4 = (com.uxsense.base.metadata.MessagePage) r4
            return r4
        L4c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ChatStorageExtensionsKt.safeLoadMessagePage(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, long, long, H7.c):java.lang.Object");
    }

    public static final Object saveChat(ApexMetadataFileManager apexMetadataFileManager, String str, Chat chat, H7.c<? super FileResult<r>> cVar) {
        return apexMetadataFileManager.getStorage_$uxsense_release().writeJson(apexMetadataFileManager.getChatFilePath(str, chat.getUserId(), chat.getChatId()), chat, Chat.INSTANCE.serializer(), cVar);
    }

    public static final Object saveMessagePage(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, List<ChatMessage> list, int i, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12482(list, apexMetadataFileManager, str, j5, j6, i, null), cVar);
    }
}
