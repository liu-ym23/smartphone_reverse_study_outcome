package com.uxsense.parse;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.ChatMessage;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.CommentIndex;
import com.uxsense.base.metadata.CommentStatus;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.metadata.InteractionStats;
import com.uxsense.base.metadata.MessageStatus;
import com.uxsense.base.metadata.MessageType;
import com.uxsense.base.metadata.User;
import com.uxsense.base.metadata.UserStats;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.file.FileResult;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u000f*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#J1\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020%¢\u0006\u0004\b'\u0010(J3\u0010,\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020&2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0*¢\u0006\u0004\b,\u0010-J)\u0010/\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020&0*¢\u0006\u0004\b/\u00100J;\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\b\b\u0002\u00102\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u000203¢\u0006\u0004\b5\u00106J9\u00108\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\f\u00107\u001a\b\u0012\u0004\u0012\u0002040*¢\u0006\u0004\b8\u00109J9\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0011\u0010A\u001a\u00020\u0017*\u00020\u000f¢\u0006\u0004\bA\u0010BJO\u0010H\u001a\b\u0012\u0004\u0012\u00020&0*2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170D2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00170F2\b\b\u0002\u0010\u001a\u001a\u00020%¢\u0006\u0004\bH\u0010IJY\u0010L\u001a\b\u0012\u0004\u0012\u0002040*2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040*2\u0006\u0010$\u001a\u00020\u00172\u0014\b\u0002\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170D2\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00170F2\b\b\u0002\u0010\u001a\u001a\u000203¢\u0006\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lcom/uxsense/parse/ParseHandler;", "", AppAgent.CONSTRUCT, "()V", "Lcom/uxsense/core/pattern/PatternMatchResult;", "result", "Lcom/uxsense/parse/UserStatsKeyMapping;", "mapping", "Lcom/uxsense/base/metadata/UserStats;", "parseUserStats", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/UserStatsKeyMapping;)Lcom/uxsense/base/metadata/UserStats;", "Lcom/uxsense/parse/InteractionStatsKeyMapping;", "Lcom/uxsense/base/metadata/InteractionStats;", "parseInteractionStats", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/InteractionStatsKeyMapping;)Lcom/uxsense/base/metadata/InteractionStats;", "", "text", "Lcom/uxsense/base/metadata/Visibility;", "parseVisibility", "(Ljava/lang/String;)Lcom/uxsense/base/metadata/Visibility;", "Lcom/uxsense/core/base/parse/KViewNode;", "extractText", "(Lcom/uxsense/core/base/parse/KViewNode;)Ljava/lang/String;", "", "userId", "Lcom/uxsense/parse/UserKeyMapping;", "keyMapping", "Lcom/uxsense/base/metadata/User;", "parseUser", "(Lcom/uxsense/core/pattern/PatternMatchResult;JLcom/uxsense/parse/UserKeyMapping;)Lcom/uxsense/base/metadata/User;", "appName", BffConstant.Role.User, "Lcom/uxsense/file/FileResult;", "LC7/r;", "saveUser", "(Ljava/lang/String;Lcom/uxsense/base/metadata/User;)Lcom/uxsense/file/FileResult;", "creationId", "Lcom/uxsense/parse/CreationKeyMapping;", "Lcom/uxsense/base/metadata/Creation;", "parseCreation", "(Lcom/uxsense/core/pattern/PatternMatchResult;JJLcom/uxsense/parse/CreationKeyMapping;)Lcom/uxsense/base/metadata/Creation;", "creation", "", "subDirs", "saveCreation", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;Ljava/util/List;)Lcom/uxsense/file/FileResult;", "creations", "saveCreations", "(Ljava/lang/String;Ljava/util/List;)Lcom/uxsense/file/FileResult;", "commentId", "rootCommentId", "Lcom/uxsense/parse/CommentKeyMapping;", "Lcom/uxsense/base/metadata/Comment;", "parseComment", "(Lcom/uxsense/core/pattern/PatternMatchResult;JJJLcom/uxsense/parse/CommentKeyMapping;)Lcom/uxsense/base/metadata/Comment;", "comments", "saveComments", "(Ljava/lang/String;JJLjava/util/List;)Lcom/uxsense/file/FileResult;", "messageId", "chatId", "senderId", "Lcom/uxsense/parse/ChatMessageKeyMapping;", "Lcom/uxsense/base/metadata/ChatMessage;", "parseChatMessage", "(Lcom/uxsense/core/pattern/PatternMatchResult;JJJLcom/uxsense/parse/ChatMessageKeyMapping;)Lcom/uxsense/base/metadata/ChatMessage;", "parseLongWithUnit", "(Ljava/lang/String;)J", "results", "Lkotlin/Function1;", "userIdProvider", "Lkotlin/Function0;", "creationIdProvider", "parseCreations", "(Ljava/util/List;LS7/k;LS7/a;Lcom/uxsense/parse/CreationKeyMapping;)Ljava/util/List;", "rootCommentIdProvider", "commentIdProvider", "parseComments", "(Ljava/util/List;JLS7/k;LS7/a;Lcom/uxsense/parse/CommentKeyMapping;)Ljava/util/List;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ParseHandler {
    private final String extractText(KViewNode kViewNode) {
        String string;
        String text = kViewNode.getText();
        return (text == null || (string = m.R0(text).toString()) == null) ? "" : string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatMessage parseChatMessage$default(ParseHandler parseHandler, PatternMatchResult patternMatchResult, long j5, long j6, long j10, ChatMessageKeyMapping chatMessageKeyMapping, int i, Object obj) {
        ChatMessageKeyMapping chatMessageKeyMapping2;
        if ((i & 16) != 0) {
            chatMessageKeyMapping2 = new ChatMessageKeyMapping(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        } else {
            chatMessageKeyMapping2 = chatMessageKeyMapping;
        }
        return parseHandler.parseChatMessage(patternMatchResult, j5, j6, j10, chatMessageKeyMapping2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseComments$lambda$4(PatternMatchResult it) {
        k.f(it, "it");
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseComments$lambda$5() {
        return ApexMetadataFileManager.INSTANCE.getIdGenerator_$uxsense_release().nextId();
    }

    public static /* synthetic */ Creation parseCreation$default(ParseHandler parseHandler, PatternMatchResult patternMatchResult, long j5, long j6, CreationKeyMapping creationKeyMapping, int i, Object obj) {
        CreationKeyMapping creationKeyMapping2;
        if ((i & 8) != 0) {
            creationKeyMapping2 = new CreationKeyMapping(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
        } else {
            creationKeyMapping2 = creationKeyMapping;
        }
        return parseHandler.parseCreation(patternMatchResult, j5, j6, creationKeyMapping2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long parseCreations$lambda$2() {
        return ApexMetadataFileManager.INSTANCE.getIdGenerator_$uxsense_release().nextId();
    }

    private final InteractionStats parseInteractionStats(PatternMatchResult result, InteractionStatsKeyMapping mapping) {
        String value = result.getValue(mapping.getLikeCount());
        long longWithUnit = value != null ? parseLongWithUnit(value) : 0L;
        String value2 = result.getValue(mapping.getStarCount());
        long longWithUnit2 = value2 != null ? parseLongWithUnit(value2) : 0L;
        String value3 = result.getValue(mapping.getShareCount());
        long longWithUnit3 = value3 != null ? parseLongWithUnit(value3) : 0L;
        String value4 = result.getValue(mapping.getCommentCount());
        long longWithUnit4 = value4 != null ? parseLongWithUnit(value4) : 0L;
        String value5 = result.getValue(mapping.getViewCount());
        return new InteractionStats(longWithUnit, longWithUnit2, longWithUnit3, longWithUnit4, value5 != null ? parseLongWithUnit(value5) : 0L, System.currentTimeMillis(), (List) null, 64, (e) null);
    }

    public static /* synthetic */ User parseUser$default(ParseHandler parseHandler, PatternMatchResult patternMatchResult, long j5, UserKeyMapping userKeyMapping, int i, Object obj) {
        if ((i & 4) != 0) {
            userKeyMapping = new UserKeyMapping(null, null, null, null, null, null, null, 127, null);
        }
        return parseHandler.parseUser(patternMatchResult, j5, userKeyMapping);
    }

    private final UserStats parseUserStats(PatternMatchResult result, UserStatsKeyMapping mapping) {
        String value = result.getValue(mapping.getFollowersCount());
        long longWithUnit = value != null ? parseLongWithUnit(value) : 0L;
        String value2 = result.getValue(mapping.getFollowingCount());
        return new UserStats(longWithUnit, (List) null, (List) null, value2 != null ? parseLongWithUnit(value2) : 0L, (List) null, 22, (e) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r0.equals("部分可见") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r0.equals("私密") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r0.equals("公开") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r0.equals(com.volcengine.tos.model.acl.ACLConst.ACL_PRIVATE) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        return com.uxsense.base.metadata.Visibility.PRIVATE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        if (r0.equals("partial") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        return com.uxsense.base.metadata.Visibility.PARTIAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        if (r0.equals("public") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return com.uxsense.base.metadata.Visibility.PUBLIC;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.uxsense.base.metadata.Visibility parseVisibility(java.lang.String r1) {
        /*
            r0 = this;
            if (r1 == 0) goto Le
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r1.toLowerCase(r0)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L58
            int r1 = r0.hashCode()
            switch(r1) {
                case -977423767: goto L4c;
                case -792934015: goto L40;
                case -314497661: goto L34;
                case 670484: goto L2b;
                case 989733: goto L22;
                case 1126007376: goto L19;
                default: goto L18;
            }
        L18:
            goto L58
        L19:
            java.lang.String r1 = "部分可见"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L49
            goto L58
        L22:
            java.lang.String r1 = "私密"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L58
        L2b:
            java.lang.String r1 = "公开"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L58
            goto L55
        L34:
            java.lang.String r1 = "private"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L58
        L3d:
            com.uxsense.base.metadata.Visibility r0 = com.uxsense.base.metadata.Visibility.PRIVATE
            return r0
        L40:
            java.lang.String r1 = "partial"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L49
            goto L58
        L49:
            com.uxsense.base.metadata.Visibility r0 = com.uxsense.base.metadata.Visibility.PARTIAL
            return r0
        L4c:
            java.lang.String r1 = "public"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L55
            goto L58
        L55:
            com.uxsense.base.metadata.Visibility r0 = com.uxsense.base.metadata.Visibility.PUBLIC
            return r0
        L58:
            com.uxsense.base.metadata.Visibility r0 = com.uxsense.base.metadata.Visibility.PUBLIC
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.ParseHandler.parseVisibility(java.lang.String):com.uxsense.base.metadata.Visibility");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static FileResult saveCreation$default(ParseHandler parseHandler, String str, Creation creation, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = EmptyList.f4893a;
        }
        return parseHandler.saveCreation(str, creation, list);
    }

    public final ChatMessage parseChatMessage(PatternMatchResult result, long messageId, long chatId, long senderId, ChatMessageKeyMapping keyMapping) {
        Long lG0;
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        String value = result.getValue(keyMapping.getText());
        if (value == null) {
            value = "";
        }
        String str = value;
        String value2 = result.getValue(keyMapping.getAt());
        return new ChatMessage(messageId, chatId, senderId, MessageType.TEXT, str, (List) null, (value2 == null || (lG0 = t.g0(value2)) == null) ? System.currentTimeMillis() : lG0.longValue(), MessageStatus.SENT, false, 0L, 512, (e) null);
    }

    public final Comment parseComment(PatternMatchResult result, long commentId, long creationId, long rootCommentId, CommentKeyMapping keyMapping) {
        Long lG0;
        Long lG02;
        Long lG03;
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        if (commentId <= 0 || creationId <= 0) {
            return null;
        }
        String value = result.getValue(keyMapping.getParentCommentId());
        long jLongValue = (value == null || (lG03 = t.g0(value)) == null) ? 0L : lG03.longValue();
        String value2 = result.getValue(keyMapping.isAuthor());
        boolean z10 = value2 != null ? Boolean.parseBoolean(value2) : false;
        String value3 = result.getValue(keyMapping.getNickname());
        String str = value3 == null ? "" : value3;
        String value4 = result.getValue(keyMapping.getUserId());
        long jLongValue2 = (value4 == null || (lG02 = t.g0(value4)) == null) ? 0L : lG02.longValue();
        String value5 = result.getValue(keyMapping.getContent());
        String str2 = value5 == null ? "" : value5;
        String value6 = result.getValue(keyMapping.getTs());
        long jCurrentTimeMillis = (value6 == null || (lG0 = t.g0(value6)) == null) ? System.currentTimeMillis() : lG0.longValue();
        String value7 = result.getValue(keyMapping.getHasReply());
        boolean z11 = value7 != null ? Boolean.parseBoolean(value7) : false;
        String value8 = result.getValue(keyMapping.getReplyCount());
        int longWithUnit = value8 != null ? (int) parseLongWithUnit(value8) : 0;
        String value9 = result.getValue(keyMapping.getLikeCount());
        return new Comment(commentId, creationId, rootCommentId, jLongValue, z10, str, (String) null, jLongValue2, str2, jCurrentTimeMillis, z11, longWithUnit, value9 != null ? parseLongWithUnit(value9) : 0L, (CommentStatus) null, false, (String) null, (List) null, 122944, (e) null);
    }

    public final List<Comment> parseComments(List<PatternMatchResult> results, long creationId, S7.k rootCommentIdProvider, S7.a commentIdProvider, CommentKeyMapping keyMapping) {
        k.f(results, "results");
        k.f(rootCommentIdProvider, "rootCommentIdProvider");
        k.f(commentIdProvider, "commentIdProvider");
        CommentKeyMapping keyMapping2 = keyMapping;
        k.f(keyMapping2, "keyMapping");
        ArrayList arrayList = new ArrayList();
        for (PatternMatchResult patternMatchResult : results) {
            long jLongValue = ((Number) commentIdProvider.invoke()).longValue();
            Object objInvoke = rootCommentIdProvider.invoke(patternMatchResult);
            if (((Number) objInvoke).longValue() <= 0) {
                objInvoke = null;
            }
            Long l = (Long) objInvoke;
            Comment comment = parseComment(patternMatchResult, jLongValue, creationId, l != null ? l.longValue() : jLongValue, keyMapping2);
            if (comment != null) {
                arrayList.add(comment);
            }
            keyMapping2 = keyMapping;
        }
        return arrayList;
    }

    public final Creation parseCreation(PatternMatchResult result, long creationId, long userId, CreationKeyMapping keyMapping) {
        List arrayList;
        List arrayList2;
        Long lG0;
        Long lG02;
        Long lG03;
        List<KViewNode> children;
        List<KViewNode> children2;
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        long jLongValue = 0;
        if (creationId <= 0 || userId <= 0) {
            return null;
        }
        String value = result.getValue(keyMapping.getPostId());
        String str = value == null ? "" : value;
        String value2 = result.getValue(keyMapping.getUuid());
        String str2 = value2 == null ? "" : value2;
        String value3 = result.getValue(keyMapping.getAuthorNickname());
        String str3 = value3 == null ? "" : value3;
        String value4 = result.getValue(keyMapping.getCover());
        String str4 = value4 == null ? "" : value4;
        String value5 = result.getValue(keyMapping.getTitle());
        String str5 = value5 == null ? "" : value5;
        String value6 = result.getValue(keyMapping.getContent());
        String str6 = value6 == null ? "" : value6;
        String value7 = result.getValue(keyMapping.getLocation());
        String str7 = value7 == null ? "" : value7;
        String value8 = result.getValue(keyMapping.getGroup());
        String str8 = value8 == null ? "" : value8;
        KViewNode kViewNode = result.get(keyMapping.getTags());
        if (kViewNode == null || (children2 = kViewNode.getChildren()) == null) {
            arrayList = EmptyList.f4893a;
        } else {
            arrayList = new ArrayList();
            Iterator<T> it = children2.iterator();
            while (it.hasNext()) {
                String text = ((KViewNode) it.next()).getText();
                if (text != null) {
                    arrayList.add(text);
                }
            }
        }
        List list = arrayList;
        KViewNode kViewNode2 = result.get(keyMapping.getMentionedUsers());
        if (kViewNode2 == null || (children = kViewNode2.getChildren()) == null) {
            arrayList2 = EmptyList.f4893a;
        } else {
            arrayList2 = new ArrayList();
            Iterator<T> it2 = children.iterator();
            while (it2.hasNext()) {
                String text2 = ((KViewNode) it2.next()).getText();
                if (text2 != null) {
                    arrayList2.add(text2);
                }
            }
        }
        List list2 = arrayList2;
        String value9 = result.getValue(keyMapping.getExtra());
        String str9 = value9 == null ? "" : value9;
        String value10 = result.getValue(keyMapping.getCreatedAt());
        long jCurrentTimeMillis = (value10 == null || (lG03 = t.g0(value10)) == null) ? System.currentTimeMillis() : lG03.longValue();
        String value11 = result.getValue(keyMapping.getPublishAt());
        long jLongValue2 = (value11 == null || (lG02 = t.g0(value11)) == null) ? 0L : lG02.longValue();
        String value12 = result.getValue(keyMapping.getLastEditedAt());
        if (value12 != null && (lG0 = t.g0(value12)) != null) {
            jLongValue = lG0.longValue();
        }
        return new Creation(creationId, str, userId, str2, str3, str4, (List) null, (List) null, keyMapping.getType(), str5, str6, str8, list, list2, str7, str9, jCurrentTimeMillis, jLongValue2, jLongValue, parseVisibility(result.getValue(keyMapping.getVisibility())), parseInteractionStats(result, keyMapping.getStatsMapping()), (CommentIndex) null, (List) null, 6291648, (e) null);
    }

    public final List<Creation> parseCreations(List<PatternMatchResult> results, S7.k userIdProvider, S7.a creationIdProvider, CreationKeyMapping keyMapping) {
        k.f(results, "results");
        k.f(userIdProvider, "userIdProvider");
        k.f(creationIdProvider, "creationIdProvider");
        k.f(keyMapping, "keyMapping");
        ArrayList arrayList = new ArrayList();
        for (PatternMatchResult patternMatchResult : results) {
            ParseHandler parseHandler = this;
            CreationKeyMapping creationKeyMapping = keyMapping;
            Creation creation = parseHandler.parseCreation(patternMatchResult, ((Number) creationIdProvider.invoke()).longValue(), ((Number) userIdProvider.invoke(patternMatchResult)).longValue(), creationKeyMapping);
            if (creation != null) {
                arrayList.add(creation);
            }
            this = parseHandler;
            keyMapping = creationKeyMapping;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r3.equals("千") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        if (r3.equals("万") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0089, code lost:
    
        if (r3.equals("w") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        r3 = 10000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        if (r3.equals("k") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
    
        r3 = 1000;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long parseLongWithUnit(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.k.f(r4, r3)
            java.lang.CharSequence r3 = j9.m.R0(r4)
            java.lang.String r3 = r3.toString()
            int r4 = r3.length()
            if (r4 != 0) goto L15
            goto L9f
        L15:
            kotlin.text.Regex r4 = new kotlin.text.Regex
            java.lang.String r0 = "([0-9.]+)\\s*([万wW千kK]?)"
            r4.<init>(r0)
            j9.l r4 = r4.b(r3)
            if (r4 != 0) goto L2d
            java.lang.Long r3 = j9.t.g0(r3)
            if (r3 == 0) goto L9f
            long r3 = r3.longValue()
            return r3
        L2d:
            java.util.List r3 = r4.a()
            r0 = 1
            D7.K r3 = (D7.K) r3
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            java.util.List r4 = r4.a()
            D7.K r4 = (D7.K) r4
            r0 = 2
            java.lang.Object r4 = r4.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Double r3 = j9.s.U(r3)
            if (r3 == 0) goto L9f
            double r0 = r3.doubleValue()
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r3 = r4.toLowerCase(r3)
            java.lang.String r4 = "toLowerCase(...)"
            kotlin.jvm.internal.k.e(r3, r4)
            int r4 = r3.hashCode()
            r2 = 107(0x6b, float:1.5E-43)
            if (r4 == r2) goto L92
            r2 = 119(0x77, float:1.67E-43)
            if (r4 == r2) goto L83
            r2 = 19975(0x4e07, float:2.7991E-41)
            if (r4 == r2) goto L7a
            r2 = 21315(0x5343, float:2.9869E-41)
            if (r4 == r2) goto L71
            goto L9a
        L71:
            java.lang.String r4 = "千"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L9c
            goto L9a
        L7a:
            java.lang.String r4 = "万"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L8c
            goto L9a
        L83:
            java.lang.String r4 = "w"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L8c
            goto L9a
        L8c:
            r3 = 10000(0x2710, float:1.4013E-41)
        L8e:
            double r3 = (double) r3
            double r0 = r0 * r3
            long r3 = (long) r0
            return r3
        L92:
            java.lang.String r4 = "k"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L9c
        L9a:
            long r3 = (long) r0
            return r3
        L9c:
            r3 = 1000(0x3e8, float:1.401E-42)
            goto L8e
        L9f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.ParseHandler.parseLongWithUnit(java.lang.String):long");
    }

    public final User parseUser(PatternMatchResult result, long userId, UserKeyMapping keyMapping) {
        k.f(result, "result");
        k.f(keyMapping, "keyMapping");
        if (userId <= 0) {
            return null;
        }
        String value = result.getValue(keyMapping.getNickname());
        String str = value == null ? "" : value;
        String value2 = result.getValue(keyMapping.getUuid());
        String str2 = value2 == null ? "" : value2;
        String value3 = result.getValue(keyMapping.getAvatar());
        String str3 = value3 == null ? "" : value3;
        String value4 = result.getValue(keyMapping.getAge());
        String str4 = value4 == null ? "" : value4;
        String value5 = result.getValue(keyMapping.getBio());
        String str5 = value5 == null ? "" : value5;
        String value6 = result.getValue(keyMapping.getGender());
        return new User(userId, str, str2, str3, str4, str5, value6 == null ? "" : value6, parseUserStats(result, keyMapping.getStatsMapping()), (List) null, 256, (e) null);
    }

    public final FileResult<r> saveComments(String appName, long userId, long creationId, List<Comment> comments) {
        k.f(appName, "appName");
        k.f(comments, "comments");
        return ApexMetadataFileManager.INSTANCE.saveCommentsSync(appName, userId, creationId, comments, (16 & 16) != 0 ? 500 : 0);
    }

    public final FileResult<r> saveCreation(String appName, Creation creation, List<String> subDirs) {
        k.f(appName, "appName");
        k.f(creation, "creation");
        k.f(subDirs, "subDirs");
        return ApexMetadataFileManager.INSTANCE.saveCreationSync(appName, creation, subDirs);
    }

    public final FileResult<r> saveCreations(String appName, List<Creation> creations) {
        k.f(appName, "appName");
        k.f(creations, "creations");
        return ApexMetadataFileManager.INSTANCE.saveCreationsSync(appName, creations);
    }

    public final FileResult<r> saveUser(String appName, User user) {
        k.f(appName, "appName");
        k.f(user, "user");
        return ApexMetadataFileManager.INSTANCE.saveUserSync(appName, user);
    }
}
