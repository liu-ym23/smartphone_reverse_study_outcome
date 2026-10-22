package com.uxsense.search;

import C7.r;
import D7.v;
import D7.w;
import H4.o;
import J7.c;
import N9.j;
import S7.n;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.metadata.User;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.file.FileResult;
import com.uxsense.search.FuzzyMatcher;
import j9.m;
import j9.t;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012JX\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018JD\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ,\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b \u0010!JL\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b%\u0010&JP\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b'\u0010\u0012JM\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b(\u0010)JA\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b*\u0010+JI\u0010,\u001a\b\u0012\u0004\u0012\u00020$0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b,\u0010-JH\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b.\u0010\u0012JH\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b/\u0010\u0012J>\u00100\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b0\u0010\u001bJ>\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b1\u0010\u001bJF\u00102\u001a\b\u0012\u0004\u0012\u00020$0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b2\u00103J(\u00104\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\b4\u00105J*\u00106\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b6\u00107J\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b8\u00109J\"\u0010:\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b:\u0010;J&\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b=\u0010;J%\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0016H\u0002¢\u0006\u0004\b@\u0010AJ%\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001fH\u0002¢\u0006\u0004\b@\u0010CR\u0014\u0010D\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/uxsense/search/MetadataSearcher;", "", AppAgent.CONSTRUCT, "()V", "", "appName", "query", "", "userId", "Lcom/uxsense/search/MatchMode;", "mode", "", "threshold", "", "limit", "", "Lcom/uxsense/search/MatchedCreation;", "findCreationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/uxsense/search/MatchMode;FILH7/c;)Ljava/lang/Object;", "title", "authorNickname", "tag", "Lcom/uxsense/base/metadata/Creation;", "findCreationByFields", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILH7/c;)Ljava/lang/Object;", "Lcom/uxsense/search/MatchedUser;", "findUserId", "(Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/search/MatchMode;FILH7/c;)Ljava/lang/Object;", "nickname", "", "exactMatch", "Lcom/uxsense/base/metadata/User;", "findUserByNickname", "(Ljava/lang/String;Ljava/lang/String;ZLH7/c;)Ljava/lang/Object;", "creationTitle", "creationId", "Lcom/uxsense/search/MatchedComment;", "findCommentsByCreation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILH7/c;)Ljava/lang/Object;", "searchComments", "findCreationIdSync", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/uxsense/search/MatchMode;FI)Ljava/util/List;", "findUserIdSync", "(Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/search/MatchMode;FI)Ljava/util/List;", "findCommentsByCreationSync", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;I)Ljava/util/List;", "searchCreationByIndex", "searchCreationByScanning", "searchUserByIndex", "searchUserByScanning", "searchCommentsInCreation", "(Ljava/lang/String;JLjava/lang/String;Lcom/uxsense/search/MatchMode;FILH7/c;)Ljava/lang/Object;", "loadAllCreations", "(Ljava/lang/String;Ljava/lang/Long;LH7/c;)Ljava/lang/Object;", "loadCreationById", "(Ljava/lang/String;JJLH7/c;)Ljava/lang/Object;", "loadAllUsers", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "loadUserById", "(Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "Lcom/uxsense/base/metadata/Comment;", "loadCommentsForCreation", "creation", "Lcom/uxsense/search/MatchedField;", "findMatchedFields", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;)Ljava/util/List;", BffConstant.Role.User, "(Ljava/lang/String;Lcom/uxsense/base/metadata/User;)Ljava/util/List;", "DEFAULT_THRESHOLD", "F", "DEFAULT_LIMIT", "I", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MetadataSearcher {
    private static final int DEFAULT_LIMIT = 10;
    private static final float DEFAULT_THRESHOLD = 0.3f;
    public static final MetadataSearcher INSTANCE = new MetadataSearcher();

    @c(c = "com.uxsense.search.MetadataSearcher$findCommentsByCreation$2", f = "MetadataSearcher.kt", l = {321, 343, 346}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedComment;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findCommentsByCreation$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ String $authorNickname;
        final /* synthetic */ Long $creationId;
        final /* synthetic */ String $creationTitle;
        final /* synthetic */ int $limit;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Long l, String str, int i, String str2, String str3, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$creationId = l;
            this.$appName = str;
            this.$limit = i;
            this.$creationTitle = str2;
            this.$authorNickname = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$creationId, this.$appName, this.$limit, this.$creationTitle, this.$authorNickname, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
        
            if (r0 == r10) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
        
            if (r0 == r10) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0112, code lost:
        
            if (r4 == r10) goto L40;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0112 -> B:41:0x0115). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.MetadataSearcher.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedComment>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findCommentsByCreationSync$1", f = "MetadataSearcher.kt", l = {630}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedComment;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findCommentsByCreationSync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ String $authorNickname;
        final /* synthetic */ Long $creationId;
        final /* synthetic */ String $creationTitle;
        final /* synthetic */ int $limit;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, String str3, Long l, int i, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creationTitle = str2;
            this.$authorNickname = str3;
            this.$creationId = l;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$appName, this.$creationTitle, this.$authorNickname, this.$creationId, this.$limit, cVar);
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
            MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
            String str = this.$appName;
            String str2 = this.$creationTitle;
            String str3 = this.$authorNickname;
            Long l = this.$creationId;
            int i6 = this.$limit;
            this.label = 1;
            Object objFindCommentsByCreation = metadataSearcher.findCommentsByCreation(str, str2, str3, l, i6, this);
            return objFindCommentsByCreation == coroutineSingletons ? coroutineSingletons : objFindCommentsByCreation;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedComment>> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findCreationByFields$2", f = "MetadataSearcher.kt", l = {172}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findCreationByFields$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13342 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ String $authorNickname;
        final /* synthetic */ int $limit;
        final /* synthetic */ String $tag;
        final /* synthetic */ String $title;
        final /* synthetic */ Long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13342(String str, Long l, int i, String str2, String str3, String str4, H7.c<? super C13342> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = l;
            this.$limit = i;
            this.$title = str2;
            this.$authorNickname = str3;
            this.$tag = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13342(this.$appName, this.$userId, this.$limit, this.$title, this.$authorNickname, this.$tag, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
                String str = this.$appName;
                Long l = this.$userId;
                this.label = 1;
                obj = metadataSearcher.loadAllCreations(str, l, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            String str2 = this.$title;
            String str3 = this.$authorNickname;
            String str4 = this.$tag;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                Creation creation = (Creation) obj2;
                if (str2 == null || m.h0(creation.getTitle(), str2, true)) {
                    if (str3 == null || m.h0(creation.getAuthorNickname(), str3, true)) {
                        if (str4 != null) {
                            List<String> tags = creation.getTags();
                            if (!(tags instanceof Collection) || !tags.isEmpty()) {
                                Iterator<T> it = tags.iterator();
                                while (it.hasNext()) {
                                    if (t.X((String) it.next(), str4)) {
                                    }
                                }
                            }
                        }
                        arrayList.add(obj2);
                    }
                }
            }
            return v.a1(arrayList, this.$limit);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<Creation>> cVar) {
            return ((C13342) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findCreationId$2", f = "MetadataSearcher.kt", l = {64, 70}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedCreation;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findCreationId$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13352 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        final /* synthetic */ Long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13352(String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c<? super C13352> cVar) {
            super(2, cVar);
            this.$query = str;
            this.$appName = str2;
            this.$userId = l;
            this.$mode = matchMode;
            this.$threshold = f;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13352(this.$query, this.$appName, this.$userId, this.$mode, this.$threshold, this.$limit, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C13352 c13352;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                if (m.s0(this.$query)) {
                    return EmptyList.f4893a;
                }
                MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
                String str = this.$appName;
                String str2 = this.$query;
                Long l = this.$userId;
                MatchMode matchMode = this.$mode;
                float f = this.$threshold;
                int i6 = this.$limit;
                this.label = 1;
                c13352 = this;
                obj = metadataSearcher.searchCreationByIndex(str, str2, l, matchMode, f, i6, c13352);
                if (obj != coroutineSingletons) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            c13352 = this;
            List list = (List) obj;
            if (!list.isEmpty()) {
                return list;
            }
            MetadataSearcher metadataSearcher2 = MetadataSearcher.INSTANCE;
            String str3 = c13352.$appName;
            String str4 = c13352.$query;
            Long l5 = c13352.$userId;
            MatchMode matchMode2 = c13352.$mode;
            float f7 = c13352.$threshold;
            int i10 = c13352.$limit;
            c13352.label = 2;
            Object objSearchCreationByScanning = metadataSearcher2.searchCreationByScanning(str3, str4, l5, matchMode2, f7, i10, c13352);
            return objSearchCreationByScanning == coroutineSingletons ? coroutineSingletons : objSearchCreationByScanning;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedCreation>> cVar) {
            return ((C13352) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findCreationIdSync$1", f = "MetadataSearcher.kt", l = {TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedCreation;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findCreationIdSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13361 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        final /* synthetic */ Long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13361(String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c<? super C13361> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$query = str2;
            this.$userId = l;
            this.$mode = matchMode;
            this.$threshold = f;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13361(this.$appName, this.$query, this.$userId, this.$mode, this.$threshold, this.$limit, cVar);
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
            MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
            String str = this.$appName;
            String str2 = this.$query;
            Long l = this.$userId;
            MatchMode matchMode = this.$mode;
            float f = this.$threshold;
            int i6 = this.$limit;
            this.label = 1;
            Object objFindCreationId = metadataSearcher.findCreationId(str, str2, l, matchMode, f, i6, this);
            return objFindCreationId == coroutineSingletons ? coroutineSingletons : objFindCreationId;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedCreation>> cVar) {
            return ((C13361) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findUserByNickname$2", f = "MetadataSearcher.kt", l = {293}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/base/metadata/User;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findUserByNickname$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13372 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ boolean $exactMatch;
        final /* synthetic */ String $nickname;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13372(String str, boolean z10, String str2, H7.c<? super C13372> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$exactMatch = z10;
            this.$nickname = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13372(this.$appName, this.$exactMatch, this.$nickname, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
                String str = this.$appName;
                this.label = 1;
                obj = metadataSearcher.loadAllUsers(str, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            boolean z10 = this.$exactMatch;
            String str2 = this.$nickname;
            for (Object obj2 : (Iterable) obj) {
                User user = (User) obj2;
                if (z10 ? t.X(user.getNickname(), str2) : m.h0(user.getNickname(), str2, true)) {
                    return obj2;
                }
            }
            return null;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super User> cVar) {
            return ((C13372) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findUserId$2", f = "MetadataSearcher.kt", l = {ComposerKt.compositionLocalMapKey, 208}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedUser;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findUserId$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13382 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13382(String str, String str2, MatchMode matchMode, float f, int i, H7.c<? super C13382> cVar) {
            super(2, cVar);
            this.$query = str;
            this.$appName = str2;
            this.$mode = matchMode;
            this.$threshold = f;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13382(this.$query, this.$appName, this.$mode, this.$threshold, this.$limit, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C13382 c13382;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                if (m.s0(this.$query)) {
                    return EmptyList.f4893a;
                }
                MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
                String str = this.$appName;
                String str2 = this.$query;
                MatchMode matchMode = this.$mode;
                float f = this.$threshold;
                int i6 = this.$limit;
                this.label = 1;
                c13382 = this;
                obj = metadataSearcher.searchUserByIndex(str, str2, matchMode, f, i6, c13382);
                if (obj != coroutineSingletons) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            c13382 = this;
            List list = (List) obj;
            if (!list.isEmpty()) {
                return list;
            }
            MetadataSearcher metadataSearcher2 = MetadataSearcher.INSTANCE;
            String str3 = c13382.$appName;
            String str4 = c13382.$query;
            MatchMode matchMode2 = c13382.$mode;
            float f7 = c13382.$threshold;
            int i10 = c13382.$limit;
            c13382.label = 2;
            Object objSearchUserByScanning = metadataSearcher2.searchUserByScanning(str3, str4, matchMode2, f7, i10, c13382);
            return objSearchUserByScanning == coroutineSingletons ? coroutineSingletons : objSearchUserByScanning;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedUser>> cVar) {
            return ((C13382) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$findUserIdSync$1", f = "MetadataSearcher.kt", l = {617}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedUser;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$findUserIdSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13391 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13391(String str, String str2, MatchMode matchMode, float f, int i, H7.c<? super C13391> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$query = str2;
            this.$mode = matchMode;
            this.$threshold = f;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13391(this.$appName, this.$query, this.$mode, this.$threshold, this.$limit, cVar);
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
            MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
            String str = this.$appName;
            String str2 = this.$query;
            MatchMode matchMode = this.$mode;
            float f = this.$threshold;
            int i6 = this.$limit;
            this.label = 1;
            Object objFindUserId = metadataSearcher.findUserId(str, str2, matchMode, f, i6, this);
            return objFindUserId == coroutineSingletons ? coroutineSingletons : objFindUserId;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedUser>> cVar) {
            return ((C13391) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$loadAllCreations$2", f = "MetadataSearcher.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$loadAllCreations$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13402 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13402(Long l, String str, H7.c<? super C13402> cVar) {
            super(2, cVar);
            this.$userId = l;
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13402(this.$userId, this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            ArrayList arrayList = new ArrayList();
            if (this.$userId != null) {
                LocalDate localDateMinusYears = LocalDate.now().minusYears(1L);
                LocalDate localDateNow = LocalDate.now();
                ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
                String str = this.$appName;
                long jLongValue = this.$userId.longValue();
                k.c(localDateMinusYears);
                k.c(localDateNow);
                FileResult<List<Creation>> fileResultLoadCreationsByDateRangeSync = apexMetadataFileManager.loadCreationsByDateRangeSync(str, jLongValue, localDateMinusYears, localDateNow);
                if (fileResultLoadCreationsByDateRangeSync instanceof FileResult.Success) {
                    arrayList.addAll((Collection) ((FileResult.Success) fileResultLoadCreationsByDateRangeSync).getData());
                    return arrayList;
                }
                if (!(fileResultLoadCreationsByDateRangeSync instanceof FileResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                FileResult<List<User>> allUsersSync = ApexMetadataFileManager.INSTANCE.getAllUsersSync(this.$appName);
                if (allUsersSync instanceof FileResult.Success) {
                    for (User user : (List) ((FileResult.Success) allUsersSync).getData()) {
                        LocalDate localDateMinusYears2 = LocalDate.now().minusYears(1L);
                        LocalDate localDateNow2 = LocalDate.now();
                        ApexMetadataFileManager apexMetadataFileManager2 = ApexMetadataFileManager.INSTANCE;
                        String str2 = this.$appName;
                        long userId = user.getUserId();
                        k.c(localDateMinusYears2);
                        k.c(localDateNow2);
                        FileResult<List<Creation>> fileResultLoadCreationsByDateRangeSync2 = apexMetadataFileManager2.loadCreationsByDateRangeSync(str2, userId, localDateMinusYears2, localDateNow2);
                        if (fileResultLoadCreationsByDateRangeSync2 instanceof FileResult.Success) {
                            arrayList.addAll((Collection) ((FileResult.Success) fileResultLoadCreationsByDateRangeSync2).getData());
                        } else if (!(fileResultLoadCreationsByDateRangeSync2 instanceof FileResult.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                } else if (!(allUsersSync instanceof FileResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return arrayList;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<Creation>> cVar) {
            return ((C13402) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$loadAllUsers$2", f = "MetadataSearcher.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$loadAllUsers$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13412 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13412(String str, H7.c<? super C13412> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13412(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            FileResult<List<User>> allUsersSync = ApexMetadataFileManager.INSTANCE.getAllUsersSync(this.$appName);
            if (allUsersSync instanceof FileResult.Success) {
                return (List) ((FileResult.Success) allUsersSync).getData();
            }
            if (allUsersSync instanceof FileResult.Error) {
                return EmptyList.f4893a;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<User>> cVar) {
            return ((C13412) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$loadCommentsForCreation$2", f = "MetadataSearcher.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/Comment;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$loadCommentsForCreation$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13422 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13422(String str, long j5, H7.c<? super C13422> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creationId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13422(this.$appName, this.$creationId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            ArrayList arrayList = new ArrayList();
            FileResult<List<User>> allUsersSync = ApexMetadataFileManager.INSTANCE.getAllUsersSync(this.$appName);
            if (allUsersSync instanceof FileResult.Success) {
                Iterator it = ((List) ((FileResult.Success) allUsersSync).getData()).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(ApexMetadataFileManager.INSTANCE.loadLatestCommentsSync(this.$appName, ((User) it.next()).getUserId(), this.$creationId, 1000));
                }
            } else if (!(allUsersSync instanceof FileResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return arrayList;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<Comment>> cVar) {
            return ((C13422) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$loadCreationById$2", f = "MetadataSearcher.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/base/metadata/Creation;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$loadCreationById$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13432 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13432(String str, long j5, long j6, H7.c<? super C13432> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13432(this.$appName, this.$userId, this.$creationId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            LocalDate localDateMinusYears = LocalDate.now().minusYears(1L);
            LocalDate localDateNow = LocalDate.now();
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            k.c(localDateMinusYears);
            k.c(localDateNow);
            FileResult<List<Creation>> fileResultLoadCreationsByDateRangeSync = apexMetadataFileManager.loadCreationsByDateRangeSync(str, j5, localDateMinusYears, localDateNow);
            Object obj2 = null;
            if (!(fileResultLoadCreationsByDateRangeSync instanceof FileResult.Success)) {
                if (fileResultLoadCreationsByDateRangeSync instanceof FileResult.Error) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            Iterable iterable = (Iterable) ((FileResult.Success) fileResultLoadCreationsByDateRangeSync).getData();
            long j6 = this.$creationId;
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Creation) next).getCreationId() == j6) {
                    obj2 = next;
                    break;
                }
            }
            return (Creation) obj2;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Creation> cVar) {
            return ((C13432) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$loadUserById$2", f = "MetadataSearcher.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/base/metadata/User;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$loadUserById$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13442 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13442(String str, long j5, H7.c<? super C13442> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13442(this.$appName, this.$userId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            FileResult<User> fileResultLoadUserSync = ApexMetadataFileManager.INSTANCE.loadUserSync(this.$appName, this.$userId);
            if (fileResultLoadUserSync instanceof FileResult.Success) {
                return (User) ((FileResult.Success) fileResultLoadUserSync).getData();
            }
            if (fileResultLoadUserSync instanceof FileResult.Error) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super User> cVar) {
            return ((C13442) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$searchComments$2", f = "MetadataSearcher.kt", l = {379, 383}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedComment;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$searchComments$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13452 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Long $creationId;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13452(String str, Long l, String str2, MatchMode matchMode, float f, int i, H7.c<? super C13452> cVar) {
            super(2, cVar);
            this.$query = str;
            this.$creationId = l;
            this.$appName = str2;
            this.$mode = matchMode;
            this.$threshold = f;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13452(this.$query, this.$creationId, this.$appName, this.$mode, this.$threshold, this.$limit, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        
            if (r0 == r9) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 280
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.MetadataSearcher.C13452.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedComment>> cVar) {
            return ((C13452) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher", f = "MetadataSearcher.kt", l = {TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "searchCommentsInCreation")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.MetadataSearcher$searchCommentsInCreation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13461 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13461(H7.c<? super C13461> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataSearcher.this.searchCommentsInCreation(null, 0L, null, null, 0.0f, 0, this);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher", f = "MetadataSearcher.kt", l = {84, 98}, m = "searchCreationByIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.MetadataSearcher$searchCreationByIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13471 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13471(H7.c<? super C13471> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataSearcher.this.searchCreationByIndex(null, null, null, null, 0.0f, 0, this);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$searchCreationByScanning$2", f = "MetadataSearcher.kt", l = {124}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedCreation;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$searchCreationByScanning$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13482 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        final /* synthetic */ Long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13482(String str, Long l, int i, String str2, MatchMode matchMode, float f, H7.c<? super C13482> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = l;
            this.$limit = i;
            this.$query = str2;
            this.$mode = matchMode;
            this.$threshold = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13482(this.$appName, this.$userId, this.$limit, this.$query, this.$mode, this.$threshold, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objLoadAllCreations;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
                String str = this.$appName;
                Long l = this.$userId;
                this.label = 1;
                objLoadAllCreations = metadataSearcher.loadAllCreations(str, l, this);
                if (objLoadAllCreations == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                objLoadAllCreations = obj;
            }
            List<Creation> list = (List) objLoadAllCreations;
            String str2 = this.$query;
            MatchMode matchMode = this.$mode;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            for (Creation creation : list) {
                Pair<Float, List<MatchedField>> pairCalculateWeightedScore = FuzzyMatcher.INSTANCE.calculateWeightedScore(str2, o.N(new Pair("title", creation.getTitle()), new Pair("authorNickname", creation.getAuthorNickname()), new Pair("tags", v.I0(creation.getTags(), " ", null, null, null, 62)), new Pair("content", m.N0(500, creation.getContent()))), FuzzyMatcher.DefaultWeights.INSTANCE.getCREATION(), matchMode);
                arrayList.add(new MatchedCreation(creation.getCreationId(), creation.getUserId(), creation.getTitle(), creation.getAuthorNickname(), m.N0(200, creation.getContent()), creation.getTags(), ((Number) pairCalculateWeightedScore.f4886a).floatValue(), (List) pairCalculateWeightedScore.b));
            }
            float f = this.$threshold;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (((MatchedCreation) next).getMatchScore() >= f) {
                    arrayList2.add(next);
                }
            }
            return v.a1(v.Z0(arrayList2, new Comparator() { // from class: com.uxsense.search.MetadataSearcher$searchCreationByScanning$2$invokeSuspend$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    return j.m(Float.valueOf(((MatchedCreation) t10).getMatchScore()), Float.valueOf(((MatchedCreation) t9).getMatchScore()));
                }
            }), this.$limit);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedCreation>> cVar) {
            return ((C13482) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher", f = "MetadataSearcher.kt", l = {221, 233}, m = "searchUserByIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.search.MetadataSearcher$searchUserByIndex$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13491 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C13491(H7.c<? super C13491> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataSearcher.this.searchUserByIndex(null, null, null, 0.0f, 0, this);
        }
    }

    @c(c = "com.uxsense.search.MetadataSearcher$searchUserByScanning$2", f = "MetadataSearcher.kt", l = {256}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/search/MatchedUser;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.MetadataSearcher$searchUserByScanning$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13502 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $limit;
        final /* synthetic */ MatchMode $mode;
        final /* synthetic */ String $query;
        final /* synthetic */ float $threshold;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13502(String str, int i, String str2, MatchMode matchMode, float f, H7.c<? super C13502> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$limit = i;
            this.$query = str2;
            this.$mode = matchMode;
            this.$threshold = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13502(this.$appName, this.$limit, this.$query, this.$mode, this.$threshold, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                MetadataSearcher metadataSearcher = MetadataSearcher.INSTANCE;
                String str = this.$appName;
                this.label = 1;
                obj = metadataSearcher.loadAllUsers(str, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            List<User> list = (List) obj;
            String str2 = this.$query;
            MatchMode matchMode = this.$mode;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            for (User user : list) {
                Pair<Float, List<MatchedField>> pairCalculateWeightedScore = FuzzyMatcher.INSTANCE.calculateWeightedScore(str2, o.N(new Pair("nickname", user.getNickname()), new Pair("uuid", user.getUuid()), new Pair("bio", user.getBio())), FuzzyMatcher.DefaultWeights.INSTANCE.getUSER(), matchMode);
                arrayList.add(new MatchedUser(user.getUserId(), user.getNickname(), user.getUuid(), user.getBio(), ((Number) pairCalculateWeightedScore.f4886a).floatValue(), (List) pairCalculateWeightedScore.b));
            }
            float f = this.$threshold;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((MatchedUser) obj2).getMatchScore() >= f) {
                    arrayList2.add(obj2);
                }
            }
            return v.a1(v.Z0(arrayList2, new Comparator() { // from class: com.uxsense.search.MetadataSearcher$searchUserByScanning$2$invokeSuspend$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    return j.m(Float.valueOf(((MatchedUser) t10).getMatchScore()), Float.valueOf(((MatchedUser) t9).getMatchScore()));
                }
            }), this.$limit);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<MatchedUser>> cVar) {
            return ((C13502) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private MetadataSearcher() {
    }

    public static /* synthetic */ Object findCommentsByCreation$default(MetadataSearcher metadataSearcher, String str, String str2, String str3, Long l, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        if ((i6 & 4) != 0) {
            str3 = null;
        }
        if ((i6 & 8) != 0) {
            l = null;
        }
        if ((i6 & 16) != 0) {
            i = 100;
        }
        return metadataSearcher.findCommentsByCreation(str, str2, str3, l, i, cVar);
    }

    public static /* synthetic */ List findCommentsByCreationSync$default(MetadataSearcher metadataSearcher, String str, String str2, String str3, Long l, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        if ((i6 & 4) != 0) {
            str3 = null;
        }
        if ((i6 & 8) != 0) {
            l = null;
        }
        if ((i6 & 16) != 0) {
            i = 100;
        }
        return metadataSearcher.findCommentsByCreationSync(str, str2, str3, l, i);
    }

    public static /* synthetic */ Object findCreationByFields$default(MetadataSearcher metadataSearcher, String str, String str2, String str3, String str4, Long l, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = null;
        }
        if ((i6 & 4) != 0) {
            str3 = null;
        }
        if ((i6 & 8) != 0) {
            str4 = null;
        }
        if ((i6 & 16) != 0) {
            l = null;
        }
        if ((i6 & 32) != 0) {
            i = 10;
        }
        return metadataSearcher.findCreationByFields(str, str2, str3, str4, l, i, cVar);
    }

    public static /* synthetic */ Object findCreationId$default(MetadataSearcher metadataSearcher, String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        Long l5 = l;
        if ((i6 & 8) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        MatchMode matchMode2 = matchMode;
        if ((i6 & 16) != 0) {
            f = DEFAULT_THRESHOLD;
        }
        float f7 = f;
        if ((i6 & 32) != 0) {
            i = 10;
        }
        return metadataSearcher.findCreationId(str, str2, l5, matchMode2, f7, i, cVar);
    }

    public static /* synthetic */ List findCreationIdSync$default(MetadataSearcher metadataSearcher, String str, String str2, Long l, MatchMode matchMode, float f, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        Long l5 = l;
        if ((i6 & 8) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        MatchMode matchMode2 = matchMode;
        if ((i6 & 16) != 0) {
            f = DEFAULT_THRESHOLD;
        }
        float f7 = f;
        if ((i6 & 32) != 0) {
            i = 10;
        }
        return metadataSearcher.findCreationIdSync(str, str2, l5, matchMode2, f7, i);
    }

    private final List<MatchedField> findMatchedFields(String query, Creation creation) {
        ArrayList arrayList = new ArrayList();
        FuzzyMatcher fuzzyMatcher = FuzzyMatcher.INSTANCE;
        String strNormalize = fuzzyMatcher.normalize(query);
        if (m.h0(fuzzyMatcher.normalize(creation.getTitle()), strNormalize, false)) {
            arrayList.add(new MatchedField("title", creation.getTitle(), query, 0, 0, 24, null));
        }
        if (m.h0(fuzzyMatcher.normalize(creation.getAuthorNickname()), strNormalize, false)) {
            arrayList.add(new MatchedField("authorNickname", creation.getAuthorNickname(), query, 0, 0, 24, null));
        }
        Iterator<String> it = creation.getTags().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (m.h0(FuzzyMatcher.INSTANCE.normalize(next), strNormalize, false)) {
                arrayList.add(new MatchedField("tag", next, query, 0, 0, 24, null));
                break;
            }
        }
        if (m.h0(FuzzyMatcher.INSTANCE.normalize(creation.getContent()), strNormalize, false)) {
            arrayList.add(new MatchedField("content", m.N0(100, creation.getContent()), query, 0, 0, 24, null));
        }
        return arrayList;
    }

    public static /* synthetic */ Object findUserByNickname$default(MetadataSearcher metadataSearcher, String str, String str2, boolean z10, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = false;
        }
        return metadataSearcher.findUserByNickname(str, str2, z10, cVar);
    }

    public static /* synthetic */ Object findUserId$default(MetadataSearcher metadataSearcher, String str, String str2, MatchMode matchMode, float f, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        MatchMode matchMode2 = matchMode;
        if ((i6 & 8) != 0) {
            f = DEFAULT_THRESHOLD;
        }
        float f7 = f;
        if ((i6 & 16) != 0) {
            i = 10;
        }
        return metadataSearcher.findUserId(str, str2, matchMode2, f7, i, cVar);
    }

    public static /* synthetic */ List findUserIdSync$default(MetadataSearcher metadataSearcher, String str, String str2, MatchMode matchMode, float f, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        MatchMode matchMode2 = matchMode;
        if ((i6 & 8) != 0) {
            f = DEFAULT_THRESHOLD;
        }
        float f7 = f;
        if ((i6 & 16) != 0) {
            i = 10;
        }
        return metadataSearcher.findUserIdSync(str, str2, matchMode2, f7, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAllCreations(String str, Long l, H7.c<? super List<Creation>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13402(l, str, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAllUsers(String str, H7.c<? super List<User>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13412(str, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadCommentsForCreation(String str, long j5, H7.c<? super List<Comment>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13422(str, j5, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadCreationById(String str, long j5, long j6, H7.c<? super Creation> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13432(str, j5, j6, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadUserById(String str, long j5, H7.c<? super User> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13442(str, j5, null), cVar);
    }

    public static /* synthetic */ Object searchComments$default(MetadataSearcher metadataSearcher, String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        Long l5 = l;
        if ((i6 & 8) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        MatchMode matchMode2 = matchMode;
        if ((i6 & 16) != 0) {
            f = DEFAULT_THRESHOLD;
        }
        float f7 = f;
        if ((i6 & 32) != 0) {
            i = 10;
        }
        return metadataSearcher.searchComments(str, str2, l5, matchMode2, f7, i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchCommentsInCreation(java.lang.String r21, long r22, java.lang.String r24, com.uxsense.search.MatchMode r25, float r26, int r27, H7.c<? super java.util.List<com.uxsense.search.MatchedComment>> r28) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.MetadataSearcher.searchCommentsInCreation(java.lang.String, long, java.lang.String, com.uxsense.search.MatchMode, float, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0178, code lost:
    
        if (r1 == r3) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0178 -> B:13:0x0041). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchCreationByIndex(java.lang.String r21, java.lang.String r22, java.lang.Long r23, com.uxsense.search.MatchMode r24, float r25, int r26, H7.c<? super java.util.List<com.uxsense.search.MatchedCreation>> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.MetadataSearcher.searchCreationByIndex(java.lang.String, java.lang.String, java.lang.Long, com.uxsense.search.MatchMode, float, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object searchCreationByScanning(String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c<? super List<MatchedCreation>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13482(str, l, i, str2, matchMode, f, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0137, code lost:
    
        if (r1 == r3) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0137 -> B:13:0x0041). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchUserByIndex(java.lang.String r18, java.lang.String r19, com.uxsense.search.MatchMode r20, float r21, int r22, H7.c<? super java.util.List<com.uxsense.search.MatchedUser>> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.search.MetadataSearcher.searchUserByIndex(java.lang.String, java.lang.String, com.uxsense.search.MatchMode, float, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object searchUserByScanning(String str, String str2, MatchMode matchMode, float f, int i, H7.c<? super List<MatchedUser>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13502(str, i, str2, matchMode, f, null), cVar);
    }

    public final Object findCommentsByCreation(String str, String str2, String str3, Long l, int i, H7.c<? super List<MatchedComment>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(l, str, i, str2, str3, null), cVar);
    }

    public final List<MatchedComment> findCommentsByCreationSync(String appName, String creationTitle, String authorNickname, Long creationId, int limit) {
        k.f(appName, "appName");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new AnonymousClass1(appName, creationTitle, authorNickname, creationId, limit, null));
    }

    public final Object findCreationByFields(String str, String str2, String str3, String str4, Long l, int i, H7.c<? super List<Creation>> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13342(str, l, i, str2, str3, str4, null), cVar);
    }

    public final Object findCreationId(String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c<? super List<MatchedCreation>> cVar) {
        return AbstractC1683A.w(AbstractC1691I.f5315a, new C13352(str2, str, l, matchMode, f, i, null), cVar);
    }

    public final List<MatchedCreation> findCreationIdSync(String appName, String query, Long userId, MatchMode mode, float threshold, int limit) {
        k.f(appName, "appName");
        k.f(query, "query");
        k.f(mode, "mode");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13361(appName, query, userId, mode, threshold, limit, null));
    }

    public final Object findUserByNickname(String str, String str2, boolean z10, H7.c<? super User> cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C13372(str, z10, str2, null), cVar);
    }

    public final Object findUserId(String str, String str2, MatchMode matchMode, float f, int i, H7.c<? super List<MatchedUser>> cVar) {
        return AbstractC1683A.w(AbstractC1691I.f5315a, new C13382(str2, str, matchMode, f, i, null), cVar);
    }

    public final List<MatchedUser> findUserIdSync(String appName, String query, MatchMode mode, float threshold, int limit) {
        k.f(appName, "appName");
        k.f(query, "query");
        k.f(mode, "mode");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13391(appName, query, mode, threshold, limit, null));
    }

    public final Object searchComments(String str, String str2, Long l, MatchMode matchMode, float f, int i, H7.c<? super List<MatchedComment>> cVar) {
        return AbstractC1683A.w(AbstractC1691I.f5315a, new C13452(str2, l, str, matchMode, f, i, null), cVar);
    }

    private final List<MatchedField> findMatchedFields(String query, User user) {
        ArrayList arrayList = new ArrayList();
        FuzzyMatcher fuzzyMatcher = FuzzyMatcher.INSTANCE;
        String strNormalize = fuzzyMatcher.normalize(query);
        if (m.h0(fuzzyMatcher.normalize(user.getNickname()), strNormalize, false)) {
            arrayList.add(new MatchedField("nickname", user.getNickname(), query, 0, 0, 24, null));
        }
        if (m.h0(fuzzyMatcher.normalize(user.getUuid()), strNormalize, false)) {
            arrayList.add(new MatchedField("uuid", user.getUuid(), query, 0, 0, 24, null));
        }
        if (m.h0(fuzzyMatcher.normalize(user.getBio()), strNormalize, false)) {
            arrayList.add(new MatchedField("bio", m.N0(100, user.getBio()), query, 0, 0, 24, null));
        }
        return arrayList;
    }
}
