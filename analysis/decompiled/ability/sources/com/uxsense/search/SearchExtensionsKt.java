package com.uxsense.search;

import C7.r;
import J7.c;
import S7.n;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.metadata.User;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.search.ApexSearchIndexManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f\u001a:\u0010\u0015\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016\u001a@\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a=\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001e\u001a4\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b \u0010!\u001a1\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#\u001aP\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b'\u0010(\u001aM\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010-\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b-\u0010,\u001a\u001c\u0010/\u001a\u00020.*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b/\u0010,\u001a\u001c\u00100\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b0\u0010,¨\u00061"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "appName", "Lcom/uxsense/base/metadata/Creation;", "creation", "LC7/r;", "saveCreationWithIndex", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;LH7/c;)Ljava/lang/Object;", "", "creations", "saveCreationsWithIndex", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/base/metadata/User;", BffConstant.Role.User, "saveUserWithIndex", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Lcom/uxsense/base/metadata/User;LH7/c;)Ljava/lang/Object;", "", "userId", "creationId", "Lcom/uxsense/base/metadata/Comment;", "comments", "saveCommentsWithIndex", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJLjava/util/List;LH7/c;)Ljava/lang/Object;", "query", "", "limit", "Lcom/uxsense/search/MatchedCreation;", "searchCreation", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILH7/c;)Ljava/lang/Object;", "searchCreationSync", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;I)Ljava/util/List;", "Lcom/uxsense/search/MatchedUser;", "searchUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", "searchUserSync", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;I)Ljava/util/List;", "creationTitle", "authorNickname", "Lcom/uxsense/search/MatchedComment;", "searchCommentsByCreation", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILH7/c;)Ljava/lang/Object;", "searchCommentsByCreationSync", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;I)Ljava/util/List;", "rebuildSearchIndex", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "saveSearchIndex", "Lcom/uxsense/search/ApexSearchIndexManager$IndexStats;", "getSearchIndexStats", "clearSearchIndexCache", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SearchExtensionsKt {

    @c(c = "com.uxsense.search.SearchExtensionsKt$saveCommentsWithIndex$2", f = "SearchExtensions.kt", l = {85}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.SearchExtensionsKt$saveCommentsWithIndex$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ List<Comment> $comments;
        final /* synthetic */ long $creationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, long j5, List<Comment> list, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creationId = j5;
            this.$comments = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$appName, this.$creationId, this.$comments, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                ApexSearchIndexManager apexSearchIndexManager = ApexSearchIndexManager.INSTANCE;
                String str = this.$appName;
                long j5 = this.$creationId;
                List<Comment> list = this.$comments;
                this.label = 1;
                if (apexSearchIndexManager.indexComments(str, j5, list, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.search.SearchExtensionsKt$saveUserWithIndex$2", f = "SearchExtensions.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.search.SearchExtensionsKt$saveUserWithIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13512 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ User $user;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13512(String str, User user, H7.c<? super C13512> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$user = user;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13512(this.$appName, this.$user, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                ApexSearchIndexManager apexSearchIndexManager = ApexSearchIndexManager.INSTANCE;
                String str = this.$appName;
                User user = this.$user;
                this.label = 1;
                if (apexSearchIndexManager.indexUser(str, user, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C13512) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final Object clearSearchIndexCache(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super r> cVar) {
        Object objClearCache = ApexSearchIndexManager.INSTANCE.clearCache(str, cVar);
        return objClearCache == CoroutineSingletons.f4909a ? objClearCache : r.f317a;
    }

    public static final Object getSearchIndexStats(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super ApexSearchIndexManager.IndexStats> cVar) {
        return ApexSearchIndexManager.INSTANCE.getIndexStats(str, cVar);
    }

    public static final Object rebuildSearchIndex(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super r> cVar) {
        Object objRebuildIndex$default = ApexSearchIndexManager.rebuildIndex$default(ApexSearchIndexManager.INSTANCE, str, false, cVar, 2, null);
        return objRebuildIndex$default == CoroutineSingletons.f4909a ? objRebuildIndex$default : r.f317a;
    }

    public static final Object saveCommentsWithIndex(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, List<Comment> list, H7.c<? super r> cVar) {
        apexMetadataFileManager.saveCommentsSync(str, j5, j6, list, (16 & 16) != 0 ? 500 : 0);
        AbstractC1683A.n(apexMetadataFileManager.getScope_$uxsense_release(), null, new AnonymousClass2(str, j6, list, null), 3);
        return r.f317a;
    }

    public static final Object saveCreationWithIndex(ApexMetadataFileManager apexMetadataFileManager, String str, Creation creation, H7.c<? super r> cVar) {
        apexMetadataFileManager.saveCreationSync(str, creation);
        return r.f317a;
    }

    public static final Object saveCreationsWithIndex(ApexMetadataFileManager apexMetadataFileManager, String str, List<Creation> list, H7.c<? super r> cVar) {
        apexMetadataFileManager.saveCreationsSync(str, list);
        return r.f317a;
    }

    public static final Object saveSearchIndex(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super r> cVar) {
        Object objSaveAllIndex = ApexSearchIndexManager.INSTANCE.saveAllIndex(str, cVar);
        return objSaveAllIndex == CoroutineSingletons.f4909a ? objSaveAllIndex : r.f317a;
    }

    public static final Object saveUserWithIndex(ApexMetadataFileManager apexMetadataFileManager, String str, User user, H7.c<? super r> cVar) {
        apexMetadataFileManager.saveUserSync(str, user);
        AbstractC1683A.n(apexMetadataFileManager.getScope_$uxsense_release(), null, new C13512(str, user, null), 3);
        return r.f317a;
    }

    public static final Object searchCommentsByCreation(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, Long l, int i, H7.c<? super List<MatchedComment>> cVar) {
        return MetadataSearcher.INSTANCE.findCommentsByCreation(str, str2, str3, l, i, cVar);
    }

    public static /* synthetic */ Object searchCommentsByCreation$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, Long l, int i, H7.c cVar, int i6, Object obj) {
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
        return searchCommentsByCreation(apexMetadataFileManager, str, str2, str3, l, i, cVar);
    }

    public static final List<MatchedComment> searchCommentsByCreationSync(ApexMetadataFileManager apexMetadataFileManager, String appName, String str, String str2, Long l, int i) {
        k.f(apexMetadataFileManager, "<this>");
        k.f(appName, "appName");
        return MetadataSearcher.INSTANCE.findCommentsByCreationSync(appName, str, str2, l, i);
    }

    public static /* synthetic */ List searchCommentsByCreationSync$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, Long l, int i, int i6, Object obj) {
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
        return searchCommentsByCreationSync(apexMetadataFileManager, str, str2, str3, l, i);
    }

    public static final Object searchCreation(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, Long l, int i, H7.c<? super List<MatchedCreation>> cVar) {
        return MetadataSearcher.findCreationId$default(MetadataSearcher.INSTANCE, str, str2, l, null, 0.0f, i, cVar, 24, null);
    }

    public static /* synthetic */ Object searchCreation$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, Long l, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        Long l5 = l;
        if ((i6 & 8) != 0) {
            i = 10;
        }
        return searchCreation(apexMetadataFileManager, str, str2, l5, i, cVar);
    }

    public static final List<MatchedCreation> searchCreationSync(ApexMetadataFileManager apexMetadataFileManager, String appName, String query, Long l, int i) {
        k.f(apexMetadataFileManager, "<this>");
        k.f(appName, "appName");
        k.f(query, "query");
        return MetadataSearcher.findCreationIdSync$default(MetadataSearcher.INSTANCE, appName, query, l, null, 0.0f, i, 24, null);
    }

    public static /* synthetic */ List searchCreationSync$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, Long l, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        if ((i6 & 8) != 0) {
            i = 10;
        }
        return searchCreationSync(apexMetadataFileManager, str, str2, l, i);
    }

    public static final Object searchUser(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, int i, H7.c<? super List<MatchedUser>> cVar) {
        return MetadataSearcher.findUserId$default(MetadataSearcher.INSTANCE, str, str2, null, 0.0f, i, cVar, 12, null);
    }

    public static /* synthetic */ Object searchUser$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 10;
        }
        return searchUser(apexMetadataFileManager, str, str2, i, cVar);
    }

    public static final List<MatchedUser> searchUserSync(ApexMetadataFileManager apexMetadataFileManager, String appName, String query, int i) {
        k.f(apexMetadataFileManager, "<this>");
        k.f(appName, "appName");
        k.f(query, "query");
        return MetadataSearcher.findUserIdSync$default(MetadataSearcher.INSTANCE, appName, query, null, 0.0f, i, 12, null);
    }

    public static /* synthetic */ List searchUserSync$default(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 10;
        }
        return searchUserSync(apexMetadataFileManager, str, str2, i);
    }
}
