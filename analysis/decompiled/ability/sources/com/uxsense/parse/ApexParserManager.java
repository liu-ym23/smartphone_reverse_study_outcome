package com.uxsense.parse;

import C7.r;
import J7.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.metadata.User;
import com.uxsense.base.parse.ParseCache;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.ApexRuleManager;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.file.FileResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nJ$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\f\u0010\nJ<\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020!¢\u0006\u0004\b#\u0010$J;\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020'¢\u0006\u0004\b)\u0010*JO\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190,2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190.2\b\b\u0002\u0010\u001c\u001a\u00020!¢\u0006\u0004\b0\u00101JY\u00104\u001a\b\u0012\u0004\u0012\u00020(0\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010 \u001a\u00020\u00192\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190,2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00190.2\b\b\u0002\u0010\u001c\u001a\u00020'¢\u0006\u0004\b4\u00105J#\u0010:\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u001d¢\u0006\u0004\b:\u0010;J#\u0010=\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00106\u001a\u00020\r2\u0006\u0010<\u001a\u00020\"¢\u0006\u0004\b=\u0010>J)\u0010@\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00106\u001a\u00020\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\"0\u0007¢\u0006\u0004\b@\u0010AJ9\u0010C\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00106\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\f\u0010B\u001a\b\u0012\u0004\u0012\u00020(0\u0007¢\u0006\u0004\bC\u0010DJ\u0018\u0010E\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\bE\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\bG\u0010FR\u0014\u0010H\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006P"}, d2 = {"Lcom/uxsense/parse/ApexParserManager;", "", AppAgent.CONSTRUCT, "()V", "Lcom/uxsense/base/parse/ParseCache;", "cache", "Lcom/uxsense/parse/ParseResult;", "", "Lcom/uxsense/parse/MetadataParseResult;", "parseMetadata", "(Lcom/uxsense/base/parse/ParseCache;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/core/pattern/PatternMatchResult;", "parse", "", "packageName", "activityClass", "windowTitle", "type", "Lcom/uxsense/base/parse/ParseRule;", "findRule", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/parse/MetadataType;", "findRules", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/parse/MetadataType;LH7/c;)Ljava/lang/Object;", "result", "", "userId", "Lcom/uxsense/parse/UserKeyMapping;", "keyMapping", "Lcom/uxsense/base/metadata/User;", "parseUser", "(Lcom/uxsense/core/pattern/PatternMatchResult;JLcom/uxsense/parse/UserKeyMapping;)Lcom/uxsense/base/metadata/User;", "creationId", "Lcom/uxsense/parse/CreationKeyMapping;", "Lcom/uxsense/base/metadata/Creation;", "parseCreation", "(Lcom/uxsense/core/pattern/PatternMatchResult;JJLcom/uxsense/parse/CreationKeyMapping;)Lcom/uxsense/base/metadata/Creation;", "commentId", "rootCommentId", "Lcom/uxsense/parse/CommentKeyMapping;", "Lcom/uxsense/base/metadata/Comment;", "parseComment", "(Lcom/uxsense/core/pattern/PatternMatchResult;JJJLcom/uxsense/parse/CommentKeyMapping;)Lcom/uxsense/base/metadata/Comment;", "results", "Lkotlin/Function1;", "userIdProvider", "Lkotlin/Function0;", "creationIdProvider", "parseCreations", "(Ljava/util/List;LS7/k;LS7/a;Lcom/uxsense/parse/CreationKeyMapping;)Ljava/util/List;", "rootCommentIdProvider", "commentIdProvider", "parseComments", "(Ljava/util/List;JLS7/k;LS7/a;Lcom/uxsense/parse/CommentKeyMapping;)Ljava/util/List;", "appName", BffConstant.Role.User, "Lcom/uxsense/file/FileResult;", "LC7/r;", "saveUser", "(Ljava/lang/String;Lcom/uxsense/base/metadata/User;)Lcom/uxsense/file/FileResult;", "creation", "saveCreation", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;)Lcom/uxsense/file/FileResult;", "creations", "saveCreations", "(Ljava/lang/String;Ljava/util/List;)Lcom/uxsense/file/FileResult;", "comments", "saveComments", "(Ljava/lang/String;JJLjava/util/List;)Lcom/uxsense/file/FileResult;", "refreshRules", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "getRules", "TAG", "Ljava/lang/String;", "Lcom/uxsense/parse/MetadataParser;", "metadataParser", "Lcom/uxsense/parse/MetadataParser;", "Lcom/uxsense/parse/ParseHandler;", "parseHandler", "Lcom/uxsense/parse/ParseHandler;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexParserManager {
    private static final String TAG = "ApexParserManager";
    public static final ApexParserManager INSTANCE = new ApexParserManager();
    private static final MetadataParser metadataParser = new MetadataParser();
    private static final ParseHandler parseHandler = new ParseHandler();

    @c(c = "com.uxsense.parse.ApexParserManager", f = "ApexParserManager.kt", l = {102}, m = "findRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.ApexParserManager$findRules$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexParserManager.this.findRules(null, null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.ApexParserManager", f = "ApexParserManager.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "parse")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.ApexParserManager$parse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12771 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12771(H7.c<? super C12771> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexParserManager.this.parse(null, this);
        }
    }

    private ApexParserManager() {
    }

    public static /* synthetic */ Object findRule$default(ApexParserManager apexParserManager, String str, String str2, String str3, String str4, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return apexParserManager.findRule(str, str2, str3, str4, cVar);
    }

    public static /* synthetic */ Object findRules$default(ApexParserManager apexParserManager, String str, String str2, String str3, MetadataType metadataType, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            metadataType = null;
        }
        return apexParserManager.findRules(str, str2, str3, metadataType, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseComments$lambda$6(PatternMatchResult it) {
        k.f(it, "it");
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseComments$lambda$7() {
        return ApexMetadataFileManager.INSTANCE.getIdGenerator_$uxsense_release().nextId();
    }

    public static /* synthetic */ Creation parseCreation$default(ApexParserManager apexParserManager, PatternMatchResult patternMatchResult, long j5, long j6, CreationKeyMapping creationKeyMapping, int i, Object obj) {
        CreationKeyMapping creationKeyMapping2;
        if ((i & 8) != 0) {
            creationKeyMapping2 = new CreationKeyMapping(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
        } else {
            creationKeyMapping2 = creationKeyMapping;
        }
        return apexParserManager.parseCreation(patternMatchResult, j5, j6, creationKeyMapping2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseCreations$lambda$5() {
        return ApexMetadataFileManager.INSTANCE.getIdGenerator_$uxsense_release().nextId();
    }

    public static /* synthetic */ User parseUser$default(ApexParserManager apexParserManager, PatternMatchResult patternMatchResult, long j5, UserKeyMapping userKeyMapping, int i, Object obj) {
        if ((i & 4) != 0) {
            userKeyMapping = new UserKeyMapping(null, null, null, null, null, null, null, 127, null);
        }
        return apexParserManager.parseUser(patternMatchResult, j5, userKeyMapping);
    }

    public final Object findRule(String str, String str2, String str3, String str4, H7.c<? super ParseRule> cVar) {
        return ApexRuleManager.INSTANCE.findRule(str, str2, str3, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findRules(java.lang.String r7, java.lang.String r8, java.lang.String r9, com.uxsense.parse.MetadataType r10, H7.c<? super java.util.List<com.uxsense.base.parse.ParseRule>> r11) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.ApexParserManager.findRules(java.lang.String, java.lang.String, java.lang.String, com.uxsense.parse.MetadataType, H7.c):java.lang.Object");
    }

    public final Object getRules(String str, H7.c<? super List<ParseRule>> cVar) {
        return ApexRuleManager.INSTANCE.getRules(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parse(com.uxsense.base.parse.ParseCache r6, H7.c<? super com.uxsense.parse.ParseResult<? extends java.util.List<com.uxsense.core.pattern.PatternMatchResult>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.uxsense.parse.ApexParserManager.C12771
            if (r0 == 0) goto L13
            r0 = r7
            com.uxsense.parse.ApexParserManager$parse$1 r0 = (com.uxsense.parse.ApexParserManager.C12771) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.parse.ApexParserManager$parse$1 r0 = new com.uxsense.parse.ApexParserManager$parse$1
            r0.<init>(r7)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.lang.Object r6 = r0.L$0
            com.uxsense.base.parse.ParseCache r6 = (com.uxsense.base.parse.ParseCache) r6
            kotlin.b.b(r5)
            goto L5b
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.b.b(r5)
            java.util.List r5 = r6.getRules()
            java.lang.Object r5 = D7.v.C0(r5)
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            if (r5 != 0) goto L6c
            com.uxsense.core.ApexRuleManager r5 = com.uxsense.core.ApexRuleManager.INSTANCE
            java.lang.String r1 = r6.getPackageName()
            java.lang.String r3 = r6.getActivity()
            java.lang.String r4 = r6.getWindowTitle()
            r0.L$0 = r6
            r0.label = r2
            java.lang.Object r5 = r5.findRule(r1, r3, r4, r0)
            if (r5 != r7) goto L5b
            return r7
        L5b:
            com.uxsense.base.parse.ParseRule r5 = (com.uxsense.base.parse.ParseRule) r5
            if (r5 != 0) goto L6c
            com.uxsense.parse.ParseResult$Error r5 = new com.uxsense.parse.ParseResult$Error
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>()
            java.lang.String r7 = "No matching rule"
            r5.<init>(r7, r6)
            return r5
        L6c:
            com.uxsense.core.base.parse.KViewNode r6 = r6.getRoot()
            if (r6 != 0) goto L7f
            com.uxsense.parse.ParseResult$Error r5 = new com.uxsense.parse.ParseResult$Error
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>()
            java.lang.String r7 = "No root node"
            r5.<init>(r7, r6)
            return r5
        L7f:
            com.uxsense.ApexCore r7 = com.uxsense.ApexCore.INSTANCE
            com.uxsense.core.pattern.ViewPattern r0 = r5.getViewPattern()
            com.uxsense.core.pattern.ParentFilter r5 = r5.getParentFilter()
            java.util.List r5 = r7.match(r6, r0, r5)
            com.uxsense.parse.ParseResult$Success r6 = new com.uxsense.parse.ParseResult$Success
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.ApexParserManager.parse(com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    public final Comment parseComment(PatternMatchResult result, long commentId, long creationId, long rootCommentId, CommentKeyMapping keyMapping) {
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        return parseHandler.parseComment(result, commentId, creationId, rootCommentId, keyMapping);
    }

    public final List<Comment> parseComments(List<PatternMatchResult> results, long creationId, S7.k rootCommentIdProvider, S7.a commentIdProvider, CommentKeyMapping keyMapping) {
        k.f(results, "results");
        k.f(rootCommentIdProvider, "rootCommentIdProvider");
        k.f(commentIdProvider, "commentIdProvider");
        k.f(keyMapping, "keyMapping");
        return parseHandler.parseComments(results, creationId, rootCommentIdProvider, commentIdProvider, keyMapping);
    }

    public final Creation parseCreation(PatternMatchResult result, long creationId, long userId, CreationKeyMapping keyMapping) {
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        return parseHandler.parseCreation(result, creationId, userId, keyMapping);
    }

    public final List<Creation> parseCreations(List<PatternMatchResult> results, S7.k userIdProvider, S7.a creationIdProvider, CreationKeyMapping keyMapping) {
        k.f(results, "results");
        k.f(userIdProvider, "userIdProvider");
        k.f(creationIdProvider, "creationIdProvider");
        k.f(keyMapping, "keyMapping");
        return parseHandler.parseCreations(results, userIdProvider, creationIdProvider, keyMapping);
    }

    public final Object parseMetadata(ParseCache parseCache, H7.c<? super ParseResult<? extends List<MetadataParseResult>>> cVar) {
        return metadataParser.parse(parseCache, cVar);
    }

    public final User parseUser(PatternMatchResult result, long userId, UserKeyMapping keyMapping) {
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        return parseHandler.parseUser(result, userId, keyMapping);
    }

    public final Object refreshRules(String str, H7.c<? super r> cVar) {
        Object objRefreshRules = ApexRuleManager.INSTANCE.refreshRules(str, cVar);
        return objRefreshRules == CoroutineSingletons.f4909a ? objRefreshRules : r.f317a;
    }

    public final FileResult<r> saveComments(String appName, long userId, long creationId, List<Comment> comments) {
        k.f(appName, "appName");
        k.f(comments, "comments");
        return parseHandler.saveComments(appName, userId, creationId, comments);
    }

    public final FileResult<r> saveCreation(String appName, Creation creation) {
        k.f(appName, "appName");
        k.f(creation, "creation");
        return ParseHandler.saveCreation$default(parseHandler, appName, creation, null, 4, null);
    }

    public final FileResult<r> saveCreations(String appName, List<Creation> creations) {
        k.f(appName, "appName");
        k.f(creations, "creations");
        return parseHandler.saveCreations(appName, creations);
    }

    public final FileResult<r> saveUser(String appName, User user) {
        k.f(appName, "appName");
        k.f(user, "user");
        return parseHandler.saveUser(appName, user);
    }
}
