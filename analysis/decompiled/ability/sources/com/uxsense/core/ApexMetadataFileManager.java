package com.uxsense.core;

import C7.r;
import S7.k;
import S7.n;
import android.content.Context;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.Chat;
import com.uxsense.base.metadata.ChatMessage;
import com.uxsense.base.metadata.Comment;
import com.uxsense.base.metadata.CommentChunk;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.metadata.FollowerUser;
import com.uxsense.base.metadata.FollowingUser;
import com.uxsense.base.metadata.MessagePage;
import com.uxsense.base.metadata.User;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import com.uxsense.utils.LockFreeSnowflakeGenerator;
import j9.m;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import z2.l;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\rJ\u001d\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u0017J%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\u0017J%\u0010\"\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010\u001dJ%\u0010$\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014¢\u0006\u0004\b$\u0010\u001dJ-\u0010&\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014¢\u0006\u0004\b&\u0010 J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b'\u0010\rJ#\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\b\u0012\u0004\u0012\u00020(0*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b-\u0010.J7\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(0/¢\u0006\u0004\b1\u00102J7\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002030/¢\u0006\u0004\b4\u00102J+\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J+\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0014¢\u0006\u0004\b:\u0010;J+\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J+\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ!\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0D0*2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bE\u0010FJ#\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JJ+\u0010K\u001a\b\u0012\u0004\u0012\u00020G0*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\bK\u0010;JC\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0D2\b\b\u0002\u0010N\u001a\u00020@¢\u0006\u0004\bO\u0010PJ3\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\bR\u0010SJ?\u0010W\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0D\u0012\u0004\u0012\u00020V0U2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010T\u001a\u00020@¢\u0006\u0004\bW\u0010XJ+\u0010Y\u001a\b\u0012\u0004\u0012\u00020L0D2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\bY\u0010ZJ+\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020[¢\u0006\u0004\b]\u0010^J3\u0010_\u001a\b\u0012\u0004\u0012\u00020[0*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014¢\u0006\u0004\b_\u0010SJC\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\f\u0010a\u001a\b\u0012\u0004\u0012\u00020`0D2\b\b\u0002\u0010b\u001a\u00020@¢\u0006\u0004\bc\u0010PJ3\u0010d\u001a\b\u0012\u0004\u0012\u00020`0D2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010T\u001a\u00020@¢\u0006\u0004\bd\u0010eJ#\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010g\u001a\u00020f¢\u0006\u0004\bh\u0010iJ1\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010g\u001a\u00020f2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\t0D¢\u0006\u0004\bh\u0010kJ)\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060*2\u0006\u0010\n\u001a\u00020\t2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020f0D¢\u0006\u0004\bm\u0010nJ9\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0D0*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010p\u001a\u00020o2\u0006\u0010q\u001a\u00020o¢\u0006\u0004\br\u0010sJ'\u0010t\u001a\u0004\u0018\u00010f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014¢\u0006\u0004\bt\u0010uJ)\u0010v\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0D0*2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\bv\u0010.R\u0014\u0010w\u001a\u00020@8\u0006X\u0086T¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010y\u001a\u00020@8\u0006X\u0086T¢\u0006\u0006\n\u0004\by\u0010xR\u001a\u0010{\u001a\u00020z8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u001f\u0010\u0080\u0001\u001a\u00020\u007f8\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008d\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "", "appName", "Ljava/nio/file/Path;", "getRuleFile", "(Ljava/lang/String;)Ljava/nio/file/Path;", "getTriggerRuleFile", "getWatchProcessesFile", "()Ljava/nio/file/Path;", "getViewTriggerRuleFile", "getAccountFile", "getAppRootDir", "", "userId", "getUserRootDir", "(Ljava/lang/String;J)Ljava/nio/file/Path;", "getUserFilePath", "getUserStatsFilePath", "getUserChatsDir", "chatId", "getChatFilePath", "(Ljava/lang/String;JJ)Ljava/nio/file/Path;", "pageId", "getMessagePageFilePath", "(Ljava/lang/String;JJJ)Ljava/nio/file/Path;", "getCreationsDir", "getCreationsPageFile", "creationId", "getCommentChunkDir", "chunkId", "getCommentChunkFilePath", "getViewNodeCacheDir", "Lcom/uxsense/base/metadata/User;", BffConstant.Role.User, "Lcom/uxsense/file/FileResult;", "saveUserSync", "(Ljava/lang/String;Lcom/uxsense/base/metadata/User;)Lcom/uxsense/file/FileResult;", "loadUserSync", "(Ljava/lang/String;J)Lcom/uxsense/file/FileResult;", "Lkotlin/Function1;", "transform", "updateUserSync", "(Ljava/lang/String;JLS7/k;)Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/UserStats;", "updateUserStatsSync", "Lcom/uxsense/base/metadata/FollowingUser;", "newFollowing", "addFollowingUserSync", "(Ljava/lang/String;JLcom/uxsense/base/metadata/FollowingUser;)Lcom/uxsense/file/FileResult;", "targetUserId", "removeFollowingUserSync", "(Ljava/lang/String;JJ)Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/FollowerUser;", "newFollower", "addFollowerUserSync", "(Ljava/lang/String;JLcom/uxsense/base/metadata/FollowerUser;)Lcom/uxsense/file/FileResult;", "", "hours", "getFollowersGainedInLastHoursSync", "(Ljava/lang/String;JI)Lcom/uxsense/file/FileResult;", "", "getAllUsersSync", "(Ljava/lang/String;)Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/Chat;", "chat", "saveChatSync", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Chat;)Lcom/uxsense/file/FileResult;", "loadChatSync", "Lcom/uxsense/base/metadata/ChatMessage;", "messages", "pageSize", "saveMessagePageSync", "(Ljava/lang/String;JJLjava/util/List;I)Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/MessagePage;", "loadMessagePageSync", "(Ljava/lang/String;JJJ)Lcom/uxsense/file/FileResult;", "limit", "Lkotlin/Pair;", "", "loadLatestMessagesSync", "(Ljava/lang/String;JJI)Lkotlin/Pair;", "loadAllMessagesSync", "(Ljava/lang/String;JJ)Ljava/util/List;", "Lcom/uxsense/base/metadata/CommentChunk;", "chunk", "saveCommentChunkSync", "(Ljava/lang/String;JLcom/uxsense/base/metadata/CommentChunk;)Lcom/uxsense/file/FileResult;", "loadCommentChunkSync", "Lcom/uxsense/base/metadata/Comment;", "comments", "maxCommentsPerChunk", "saveCommentsSync", "loadLatestCommentsSync", "(Ljava/lang/String;JJI)Ljava/util/List;", "Lcom/uxsense/base/metadata/Creation;", "creation", "saveCreationSync", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;)Lcom/uxsense/file/FileResult;", "subDirs", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;Ljava/util/List;)Lcom/uxsense/file/FileResult;", "creations", "saveCreationsSync", "(Ljava/lang/String;Ljava/util/List;)Lcom/uxsense/file/FileResult;", "Ljava/time/LocalDate;", "startDate", "endDate", "loadCreationsByDateRangeSync", "(Ljava/lang/String;JLjava/time/LocalDate;Ljava/time/LocalDate;)Lcom/uxsense/file/FileResult;", "loadCreationByIdSync", "(Ljava/lang/String;JJ)Lcom/uxsense/base/metadata/Creation;", "loadAllCreationsSync", "DEFAULT_MAX_MESSAGES_PER_PAGE", "I", "DEFAULT_MAX_COMMENTS_PER_CHUNK", "Lcom/uxsense/file/FileStorageManager;", "storage_", "Lcom/uxsense/file/FileStorageManager;", "getStorage_$uxsense_release", "()Lcom/uxsense/file/FileStorageManager;", "Lm9/z;", "scope_", "Lm9/z;", "getScope_$uxsense_release", "()Lm9/z;", "Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "idGenerator_", "Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "getIdGenerator_$uxsense_release", "()Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "_basePath", "Ljava/lang/String;", "getBasePath$uxsense_release", "()Ljava/lang/String;", "basePath", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexMetadataFileManager {
    public static final int DEFAULT_MAX_COMMENTS_PER_CHUNK = 500;
    public static final int DEFAULT_MAX_MESSAGES_PER_PAGE = 200;
    private static volatile String _basePath;
    private static final LockFreeSnowflakeGenerator idGenerator_;
    private static final InterfaceC1733z scope_;
    public static final ApexMetadataFileManager INSTANCE = new ApexMetadataFileManager();
    private static final FileStorageManager storage_ = new FileStorageManager(null, 1, 0 == true ? 1 : 0);

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$addFollowerUserSync$1", f = "ApexMetadataFileManager.kt", l = {137}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$addFollowerUserSync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ FollowerUser $newFollower;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j5, FollowerUser followerUser, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$newFollower = followerUser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$appName, this.$userId, this.$newFollower, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            FollowerUser followerUser = this.$newFollower;
            this.label = 1;
            Object objAddFollowerUser = UserExtensionsKt.addFollowerUser(apexMetadataFileManager, str, j5, followerUser, this);
            return objAddFollowerUser == coroutineSingletons ? coroutineSingletons : objAddFollowerUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$addFollowingUserSync$1", f = "ApexMetadataFileManager.kt", l = {131}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$addFollowingUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12201 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ FollowingUser $newFollowing;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12201(String str, long j5, FollowingUser followingUser, H7.c<? super C12201> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$newFollowing = followingUser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12201(this.$appName, this.$userId, this.$newFollowing, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            FollowingUser followingUser = this.$newFollowing;
            this.label = 1;
            Object objAddFollowingUser = UserExtensionsKt.addFollowingUser(apexMetadataFileManager, str, j5, followingUser, this);
            return objAddFollowingUser == coroutineSingletons ? coroutineSingletons : objAddFollowingUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12201) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$getAllUsersSync$1", f = "ApexMetadataFileManager.kt", l = {143}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$getAllUsersSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12211 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12211(String str, H7.c<? super C12211> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12211(this.$appName, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            this.label = 1;
            Object allUsers = UserExtensionsKt.getAllUsers(apexMetadataFileManager, str, this);
            return allUsers == coroutineSingletons ? coroutineSingletons : allUsers;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<? extends List<User>>> cVar) {
            return ((C12211) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$getFollowersGainedInLastHoursSync$1", f = "ApexMetadataFileManager.kt", l = {140}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$getFollowersGainedInLastHoursSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12221 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ int $hours;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12221(String str, long j5, int i, H7.c<? super C12221> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$hours = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12221(this.$appName, this.$userId, this.$hours, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            int i6 = this.$hours;
            this.label = 1;
            Object followersGainedInLastHours = UserExtensionsKt.getFollowersGainedInLastHours(apexMetadataFileManager, str, j5, i6, this);
            return followersGainedInLastHours == coroutineSingletons ? coroutineSingletons : followersGainedInLastHours;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Long>> cVar) {
            return ((C12221) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadAllCreationsSync$1", f = "ApexMetadataFileManager.kt", l = {210}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadAllCreationsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12231 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12231(String str, long j5, H7.c<? super C12231> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12231(this.$appName, this.$userId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            this.label = 1;
            Object objLoadAllCreations = CreationExtensionsKt.loadAllCreations(apexMetadataFileManager, str, j5, this);
            return objLoadAllCreations == coroutineSingletons ? coroutineSingletons : objLoadAllCreations;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<? extends List<Creation>>> cVar) {
            return ((C12231) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadAllMessagesSync$1", f = "ApexMetadataFileManager.kt", l = {168}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/ChatMessage;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadAllMessagesSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12241 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12241(String str, long j5, long j6, H7.c<? super C12241> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12241(this.$appName, this.$userId, this.$chatId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$chatId;
            this.label = 1;
            Object objLoadAllMessages = ChatStorageExtensionsKt.loadAllMessages(apexMetadataFileManager, str, j5, j6, this);
            return objLoadAllMessages == coroutineSingletons ? coroutineSingletons : objLoadAllMessages;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<ChatMessage>> cVar) {
            return ((C12241) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadChatSync$1", f = "ApexMetadataFileManager.kt", l = {150}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/Chat;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadChatSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12251 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12251(String str, long j5, long j6, H7.c<? super C12251> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12251(this.$appName, this.$userId, this.$chatId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$chatId;
            this.label = 1;
            Object objLoadChat = ChatStorageExtensionsKt.loadChat(apexMetadataFileManager, str, j5, j6, this);
            return objLoadChat == coroutineSingletons ? coroutineSingletons : objLoadChat;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Chat>> cVar) {
            return ((C12251) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadCommentChunkSync$1", f = "ApexMetadataFileManager.kt", l = {175}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/CommentChunk;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadCommentChunkSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12261 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chunkId;
        final /* synthetic */ long $creationId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12261(String str, long j5, long j6, long j10, H7.c<? super C12261> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
            this.$chunkId = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12261(this.$appName, this.$userId, this.$creationId, this.$chunkId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$creationId;
            long j10 = this.$chunkId;
            this.label = 1;
            Object objLoadCommentChunk = CommentStorageExtensionsKt.loadCommentChunk(apexMetadataFileManager, str, j5, j6, j10, this);
            return objLoadCommentChunk == coroutineSingletons ? coroutineSingletons : objLoadCommentChunk;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<CommentChunk>> cVar) {
            return ((C12261) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadCreationByIdSync$1", f = "ApexMetadataFileManager.kt", l = {ComposerKt.reuseKey}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/base/metadata/Creation;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadCreationByIdSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12271 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12271(String str, long j5, long j6, H7.c<? super C12271> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12271(this.$appName, this.$userId, this.$creationId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$creationId;
            this.label = 1;
            Object objLoadCreationById = CreationExtensionsKt.loadCreationById(apexMetadataFileManager, str, j5, j6, this);
            return objLoadCreationById == coroutineSingletons ? coroutineSingletons : objLoadCreationById;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Creation> cVar) {
            return ((C12271) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadCreationsByDateRangeSync$1", f = "ApexMetadataFileManager.kt", l = {ComposerKt.providerMapsKey}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadCreationsByDateRangeSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12281 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ LocalDate $endDate;
        final /* synthetic */ LocalDate $startDate;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12281(String str, long j5, LocalDate localDate, LocalDate localDate2, H7.c<? super C12281> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$startDate = localDate;
            this.$endDate = localDate2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12281(this.$appName, this.$userId, this.$startDate, this.$endDate, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            LocalDate localDate = this.$startDate;
            LocalDate localDate2 = this.$endDate;
            this.label = 1;
            Object objLoadCreationsByDateRange = CreationExtensionsKt.loadCreationsByDateRange(apexMetadataFileManager, str, j5, localDate, localDate2, this);
            return objLoadCreationsByDateRange == coroutineSingletons ? coroutineSingletons : objLoadCreationsByDateRange;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<? extends List<Creation>>> cVar) {
            return ((C12281) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadLatestCommentsSync$1", f = "ApexMetadataFileManager.kt", l = {187}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/base/metadata/Comment;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadLatestCommentsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12291 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        final /* synthetic */ int $limit;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12291(String str, long j5, long j6, int i, H7.c<? super C12291> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12291(this.$appName, this.$userId, this.$creationId, this.$limit, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$creationId;
            int i6 = this.$limit;
            this.label = 1;
            Object objLoadLatestComments = CommentStorageExtensionsKt.loadLatestComments(apexMetadataFileManager, str, j5, j6, i6, this);
            return objLoadLatestComments == coroutineSingletons ? coroutineSingletons : objLoadLatestComments;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<Comment>> cVar) {
            return ((C12291) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadLatestMessagesSync$1", f = "ApexMetadataFileManager.kt", l = {165}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lm9/z;", "Lkotlin/Pair;", "", "Lcom/uxsense/base/metadata/ChatMessage;", "", "<anonymous>", "(Lm9/z;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadLatestMessagesSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12301 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ int $limit;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12301(String str, long j5, long j6, int i, H7.c<? super C12301> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12301(this.$appName, this.$userId, this.$chatId, this.$limit, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$chatId;
            int i6 = this.$limit;
            this.label = 1;
            Object objLoadLatestMessages = ChatStorageExtensionsKt.loadLatestMessages(apexMetadataFileManager, str, j5, j6, i6, this);
            return objLoadLatestMessages == coroutineSingletons ? coroutineSingletons : objLoadLatestMessages;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Pair<? extends List<ChatMessage>, Boolean>> cVar) {
            return ((C12301) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadMessagePageSync$1", f = "ApexMetadataFileManager.kt", l = {162}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/MessagePage;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadMessagePageSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12311 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ long $pageId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12311(String str, long j5, long j6, long j10, H7.c<? super C12311> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
            this.$pageId = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12311(this.$appName, this.$userId, this.$chatId, this.$pageId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$chatId;
            long j10 = this.$pageId;
            this.label = 1;
            Object objLoadMessagePage = ChatStorageExtensionsKt.loadMessagePage(apexMetadataFileManager, str, j5, j6, j10, this);
            return objLoadMessagePage == coroutineSingletons ? coroutineSingletons : objLoadMessagePage;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<MessagePage>> cVar) {
            return ((C12311) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$loadUserSync$1", f = "ApexMetadataFileManager.kt", l = {122}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$loadUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12321 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12321(String str, long j5, H7.c<? super C12321> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12321(this.$appName, this.$userId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            this.label = 1;
            Object objLoadUser = UserExtensionsKt.loadUser(apexMetadataFileManager, str, j5, this);
            return objLoadUser == coroutineSingletons ? coroutineSingletons : objLoadUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<User>> cVar) {
            return ((C12321) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$removeFollowingUserSync$1", f = "ApexMetadataFileManager.kt", l = {134}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$removeFollowingUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12331 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $targetUserId;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12331(String str, long j5, long j6, H7.c<? super C12331> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$targetUserId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12331(this.$appName, this.$userId, this.$targetUserId, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$targetUserId;
            this.label = 1;
            Object objRemoveFollowingUser = UserExtensionsKt.removeFollowingUser(apexMetadataFileManager, str, j5, j6, this);
            return objRemoveFollowingUser == coroutineSingletons ? coroutineSingletons : objRemoveFollowingUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12331) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveChatSync$1", f = "ApexMetadataFileManager.kt", l = {147}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveChatSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12341 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Chat $chat;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12341(String str, Chat chat, H7.c<? super C12341> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$chat = chat;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12341(this.$appName, this.$chat, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            Chat chat = this.$chat;
            this.label = 1;
            Object objSaveChat = ChatStorageExtensionsKt.saveChat(apexMetadataFileManager, str, chat, this);
            return objSaveChat == coroutineSingletons ? coroutineSingletons : objSaveChat;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12341) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveCommentChunkSync$1", f = "ApexMetadataFileManager.kt", l = {172}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveCommentChunkSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12351 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ CommentChunk $chunk;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12351(String str, long j5, CommentChunk commentChunk, H7.c<? super C12351> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$chunk = commentChunk;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12351(this.$appName, this.$userId, this.$chunk, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            CommentChunk commentChunk = this.$chunk;
            this.label = 1;
            Object objSaveCommentChunk = CommentStorageExtensionsKt.saveCommentChunk(apexMetadataFileManager, str, j5, commentChunk, this);
            return objSaveCommentChunk == coroutineSingletons ? coroutineSingletons : objSaveCommentChunk;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12351) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveCommentsSync$1", f = "ApexMetadataFileManager.kt", l = {184}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveCommentsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12361 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ List<Comment> $comments;
        final /* synthetic */ long $creationId;
        final /* synthetic */ int $maxCommentsPerChunk;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12361(String str, long j5, long j6, List<Comment> list, int i, H7.c<? super C12361> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
            this.$comments = list;
            this.$maxCommentsPerChunk = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12361(this.$appName, this.$userId, this.$creationId, this.$comments, this.$maxCommentsPerChunk, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$creationId;
            List<Comment> list = this.$comments;
            int i6 = this.$maxCommentsPerChunk;
            this.label = 1;
            Object objSaveComments = CommentStorageExtensionsKt.saveComments(apexMetadataFileManager, str, j5, j6, list, i6, this);
            return objSaveComments == coroutineSingletons ? coroutineSingletons : objSaveComments;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12361) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveCreationSync$1", f = "ApexMetadataFileManager.kt", l = {191}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveCreationSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12371 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Creation $creation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12371(String str, Creation creation, H7.c<? super C12371> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creation = creation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12371(this.$appName, this.$creation, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            Creation creation = this.$creation;
            this.label = 1;
            Object objSaveCreation = CreationExtensionsKt.saveCreation(apexMetadataFileManager, str, creation, this);
            return objSaveCreation == coroutineSingletons ? coroutineSingletons : objSaveCreation;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12371) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveCreationSync$2", f = "ApexMetadataFileManager.kt", l = {194}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveCreationSync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Creation $creation;
        final /* synthetic */ List<String> $subDirs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Creation creation, List<String> list, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creation = creation;
            this.$subDirs = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$appName, this.$creation, this.$subDirs, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            Creation creation = this.$creation;
            List<String> list = this.$subDirs;
            this.label = 1;
            Object objSaveCreation = CreationExtensionsKt.saveCreation(apexMetadataFileManager, str, creation, list, this);
            return objSaveCreation == coroutineSingletons ? coroutineSingletons : objSaveCreation;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveCreationsSync$1", f = "ApexMetadataFileManager.kt", l = {197}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveCreationsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12381 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ List<Creation> $creations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12381(String str, List<Creation> list, H7.c<? super C12381> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$creations = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12381(this.$appName, this.$creations, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            List<Creation> list = this.$creations;
            this.label = 1;
            Object objSaveCreations = CreationExtensionsKt.saveCreations(apexMetadataFileManager, str, list, this);
            return objSaveCreations == coroutineSingletons ? coroutineSingletons : objSaveCreations;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12381) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveMessagePageSync$1", f = "ApexMetadataFileManager.kt", l = {159}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveMessagePageSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12391 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $chatId;
        final /* synthetic */ List<ChatMessage> $messages;
        final /* synthetic */ int $pageSize;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12391(String str, long j5, long j6, List<ChatMessage> list, int i, H7.c<? super C12391> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$chatId = j6;
            this.$messages = list;
            this.$pageSize = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12391(this.$appName, this.$userId, this.$chatId, this.$messages, this.$pageSize, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            long j6 = this.$chatId;
            List<ChatMessage> list = this.$messages;
            int i6 = this.$pageSize;
            this.label = 1;
            Object objSaveMessagePage = ChatStorageExtensionsKt.saveMessagePage(apexMetadataFileManager, str, j5, j6, list, i6, this);
            return objSaveMessagePage == coroutineSingletons ? coroutineSingletons : objSaveMessagePage;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12391) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$saveUserSync$1", f = "ApexMetadataFileManager.kt", l = {119}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$saveUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12401 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ User $user;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12401(String str, User user, H7.c<? super C12401> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$user = user;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12401(this.$appName, this.$user, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            User user = this.$user;
            this.label = 1;
            Object objSaveUser = UserExtensionsKt.saveUser(apexMetadataFileManager, str, user, this);
            return objSaveUser == coroutineSingletons ? coroutineSingletons : objSaveUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12401) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$updateUserStatsSync$1", f = "ApexMetadataFileManager.kt", l = {128}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$updateUserStatsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12411 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ k $transform;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12411(String str, long j5, k kVar, H7.c<? super C12411> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$transform = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12411(this.$appName, this.$userId, this.$transform, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            k kVar = this.$transform;
            this.label = 1;
            Object objUpdateUserStats = UserExtensionsKt.updateUserStats(apexMetadataFileManager, str, j5, kVar, this);
            return objUpdateUserStats == coroutineSingletons ? coroutineSingletons : objUpdateUserStats;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12411) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexMetadataFileManager$updateUserSync$1", f = "ApexMetadataFileManager.kt", l = {125}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.ApexMetadataFileManager$updateUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12421 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ k $transform;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12421(String str, long j5, k kVar, H7.c<? super C12421> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$transform = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12421(this.$appName, this.$userId, this.$transform, cVar);
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
            ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            k kVar = this.$transform;
            this.label = 1;
            Object objUpdateUser = UserExtensionsKt.updateUser(apexMetadataFileManager, str, j5, kVar, this);
            return objUpdateUser == coroutineSingletons ? coroutineSingletons : objUpdateUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12421) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        scope_ = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        idGenerator_ = new LockFreeSnowflakeGenerator(1L, 1L);
    }

    private ApexMetadataFileManager() {
    }

    public final FileResult<r> addFollowerUserSync(String appName, long userId, FollowerUser newFollower) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(newFollower, "newFollower");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new AnonymousClass1(appName, userId, newFollower, null));
    }

    public final FileResult<r> addFollowingUserSync(String appName, long userId, FollowingUser newFollowing) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(newFollowing, "newFollowing");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12201(appName, userId, newFollowing, null));
    }

    public final Path getAccountFile(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path path = Paths.get(getBasePath$uxsense_release(), appName, "account.json");
        kotlin.jvm.internal.k.e(path, "get(...)");
        return path;
    }

    public final FileResult<List<User>> getAllUsersSync(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12211(appName, null));
    }

    public final Path getAppRootDir(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path path = Paths.get(getBasePath$uxsense_release(), appName);
        kotlin.jvm.internal.k.e(path, "get(...)");
        return path;
    }

    public final String getBasePath$uxsense_release() {
        String str = _basePath;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("ApexMetadataFileManager not initialized. Call ApexMetadataFileManager.init(context) or ApexSDK.initialize(context) first.");
    }

    public final Path getChatFilePath(String appName, long userId, long chatId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getUserChatsDir(appName, userId).resolve(chatId + ".json");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getCommentChunkDir(String appName, long userId, long creationId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getUserRootDir(appName, userId).resolve("comments/" + creationId);
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getCommentChunkFilePath(String appName, long userId, long creationId, long chunkId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getCommentChunkDir(appName, userId, creationId).resolve(chunkId + ".json");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getCreationsDir(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getUserRootDir(appName, userId).resolve("creations");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getCreationsPageFile(String appName, long userId, long pageId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getCreationsDir(appName, userId).resolve(pageId + ".json");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final FileResult<Long> getFollowersGainedInLastHoursSync(String appName, long userId, int hours) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12221(appName, userId, hours, null));
    }

    public final LockFreeSnowflakeGenerator getIdGenerator_$uxsense_release() {
        return idGenerator_;
    }

    public final Path getMessagePageFilePath(String appName, long userId, long chatId, long pageId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getUserChatsDir(appName, userId).resolve(chatId + "/pages/" + pageId + ".json");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getRuleFile(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path path = Paths.get(getBasePath$uxsense_release(), appName, "rules.json");
        kotlin.jvm.internal.k.e(path, "get(...)");
        return path;
    }

    public final InterfaceC1733z getScope_$uxsense_release() {
        return scope_;
    }

    public final FileStorageManager getStorage_$uxsense_release() {
        return storage_;
    }

    public final Path getTriggerRuleFile(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path path = Paths.get(getBasePath$uxsense_release(), appName, "trigger_rules.json");
        kotlin.jvm.internal.k.e(path, "get(...)");
        return path;
    }

    public final Path getUserChatsDir(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getUserRootDir(appName, userId).resolve("chats");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getUserFilePath(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getUserRootDir(appName, userId).resolve("user.json");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public final Path getUserRootDir(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path path = Paths.get(getBasePath$uxsense_release(), appName, String.valueOf(userId));
        kotlin.jvm.internal.k.e(path, "get(...)");
        return path;
    }

    public final Path getUserStatsFilePath(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return getUserFilePath(appName, userId);
    }

    public final Path getViewNodeCacheDir(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Path pathResolve = getAppRootDir(appName).resolve("cache");
        kotlin.jvm.internal.k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    @C7.c
    public final Path getViewTriggerRuleFile(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return getTriggerRuleFile(appName);
    }

    public final Path getWatchProcessesFile() {
        Path path = Paths.get(getBasePath$uxsense_release(), "watch_processes.json");
        kotlin.jvm.internal.k.e(path, "get(...)");
        return path;
    }

    public final void init(Context context) {
        int length;
        File file;
        int iP0;
        kotlin.jvm.internal.k.f(context, "context");
        File filesDir = context.getFilesDir();
        kotlin.jvm.internal.k.e(filesDir, "getFilesDir(...)");
        File file2 = new File("uxsense");
        String path = file2.getPath();
        kotlin.jvm.internal.k.e(path, "getPath(...)");
        char c = File.separatorChar;
        int iP02 = m.p0(path, c, 0, 4);
        if (iP02 != 0) {
            length = (iP02 <= 0 || path.charAt(iP02 + (-1)) != ':') ? (iP02 == -1 && m.l0(path, ':')) ? path.length() : 0 : iP02 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c || (iP0 = m.p0(path, c, 2, 4)) < 0) {
            length = 1;
        } else {
            int iP03 = m.p0(path, c, iP0 + 1, 4);
            length = iP03 >= 0 ? iP03 + 1 : path.length();
        }
        if (!(length > 0)) {
            String string = filesDir.toString();
            kotlin.jvm.internal.k.e(string, "toString(...)");
            if ((string.length() == 0) || m.l0(string, c)) {
                file = new File(string + file2);
            } else {
                file = new File(string + c + file2);
            }
            file2 = file;
        }
        _basePath = file2.getAbsolutePath();
    }

    public final FileResult<List<Creation>> loadAllCreationsSync(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12231(appName, userId, null));
    }

    public final List<ChatMessage> loadAllMessagesSync(String appName, long userId, long chatId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12241(appName, userId, chatId, null));
    }

    public final FileResult<Chat> loadChatSync(String appName, long userId, long chatId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12251(appName, userId, chatId, null));
    }

    public final FileResult<CommentChunk> loadCommentChunkSync(String appName, long userId, long creationId, long chunkId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12261(appName, userId, creationId, chunkId, null));
    }

    public final Creation loadCreationByIdSync(String appName, long userId, long creationId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (Creation) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12271(appName, userId, creationId, null));
    }

    public final FileResult<List<Creation>> loadCreationsByDateRangeSync(String appName, long userId, LocalDate startDate, LocalDate endDate) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(startDate, "startDate");
        kotlin.jvm.internal.k.f(endDate, "endDate");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12281(appName, userId, startDate, endDate, null));
    }

    public final List<Comment> loadLatestCommentsSync(String appName, long userId, long creationId, int limit) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12291(appName, userId, creationId, limit, null));
    }

    public final Pair<List<ChatMessage>, Boolean> loadLatestMessagesSync(String appName, long userId, long chatId, int limit) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (Pair) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12301(appName, userId, chatId, limit, null));
    }

    public final FileResult<MessagePage> loadMessagePageSync(String appName, long userId, long chatId, long pageId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12311(appName, userId, chatId, pageId, null));
    }

    public final FileResult<User> loadUserSync(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12321(appName, userId, null));
    }

    public final FileResult<r> removeFollowingUserSync(String appName, long userId, long targetUserId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12331(appName, userId, targetUserId, null));
    }

    public final FileResult<r> saveChatSync(String appName, Chat chat) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(chat, "chat");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12341(appName, chat, null));
    }

    public final FileResult<r> saveCommentChunkSync(String appName, long userId, CommentChunk chunk) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(chunk, "chunk");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12351(appName, userId, chunk, null));
    }

    public final FileResult<r> saveCommentsSync(String appName, long userId, long creationId, List<Comment> comments, int maxCommentsPerChunk) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(comments, "comments");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12361(appName, userId, creationId, comments, maxCommentsPerChunk, null));
    }

    public final FileResult<r> saveCreationSync(String appName, Creation creation) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(creation, "creation");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12371(appName, creation, null));
    }

    public final FileResult<r> saveCreationsSync(String appName, List<Creation> creations) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(creations, "creations");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12381(appName, creations, null));
    }

    public final FileResult<r> saveMessagePageSync(String appName, long userId, long chatId, List<ChatMessage> messages, int pageSize) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(messages, "messages");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12391(appName, userId, chatId, messages, pageSize, null));
    }

    public final FileResult<r> saveUserSync(String appName, User user) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(user, "user");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12401(appName, user, null));
    }

    public final FileResult<r> updateUserStatsSync(String appName, long userId, k transform) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(transform, "transform");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12411(appName, userId, transform, null));
    }

    public final FileResult<r> updateUserSync(String appName, long userId, k transform) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(transform, "transform");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C12421(appName, userId, transform, null));
    }

    public final FileResult<r> saveCreationSync(String appName, Creation creation, List<String> subDirs) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(creation, "creation");
        kotlin.jvm.internal.k.f(subDirs, "subDirs");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new AnonymousClass2(appName, creation, subDirs, null));
    }
}
