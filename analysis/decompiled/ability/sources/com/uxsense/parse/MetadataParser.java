package com.uxsense.parse;

import C7.r;
import J7.c;
import androidx.autofill.HintConstants;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.uxsense.base.metadata.Creation;
import com.uxsense.base.parse.ParseCache;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.pattern.PatternMatchResult;
import com.uxsense.file.FileResult;
import com.uxsense.parse.IdSource;
import com.uxsense.parse.ParseResult;
import com.uxsense.search.MatchMode;
import com.uxsense.search.MatchedComment;
import com.uxsense.search.MatchedCreation;
import com.uxsense.search.MatchedUser;
import com.uxsense.search.MetadataSearcher;
import com.uxsense.trace.ApexTrace;
import com.uxsense.utils.ALog;
import j9.t;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 g2\u00020\u0001:\u0003ghiB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013JF\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJ:\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ<\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0004\b\"\u0010#J4\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b(\u0010)J4\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b*\u0010)J0\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020$2\u0006\u0010-\u001a\u00020,2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b/\u00100J@\u00105\u001a\u00020.2\u0006\u0010+\u001a\u00020$2\u0006\u0010-\u001a\u00020,2\u0006\u00102\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00104\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b5\u00106J@\u00107\u001a\u00020.2\u0006\u0010+\u001a\u00020$2\u0006\u0010-\u001a\u00020,2\u0006\u00102\u001a\u0002012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00104\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b7\u00106J0\u0010<\u001a\u00020;2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00109\u001a\u0002082\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0082@¢\u0006\u0004\b<\u0010=J4\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b>\u0010)J4\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b?\u0010)J3\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b@\u0010AJ(\u0010F\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020DH\u0082@¢\u0006\u0004\bF\u0010GJ>\u0010M\u001a\u0004\u0018\u00010\u000e2\u0006\u0010H\u001a\u00020$2\u0006\u0010J\u001a\u00020I2\u0006\u00102\u001a\u0002012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0KH\u0082@¢\u0006\u0004\bM\u0010NJ(\u0010P\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020$2\u0006\u0010J\u001a\u00020I2\u0006\u0010O\u001a\u000201H\u0082@¢\u0006\u0004\bP\u0010QJ\u0018\u0010R\u001a\u00020\u000e2\u0006\u0010O\u001a\u000201H\u0082@¢\u0006\u0004\bR\u0010SJ \u0010T\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020$2\u0006\u0010O\u001a\u000201H\u0082@¢\u0006\u0004\bT\u0010UJ(\u0010W\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020$2\u0006\u0010J\u001a\u00020V2\u0006\u0010O\u001a\u000201H\u0082@¢\u0006\u0004\bW\u0010XJ#\u0010Z\u001a\u00020Y2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0KH\u0002¢\u0006\u0004\bZ\u0010[J#\u0010\\\u001a\u0002032\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0KH\u0002¢\u0006\u0004\b\\\u0010]J#\u0010_\u001a\u00020^2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0KH\u0002¢\u0006\u0004\b_\u0010`J#\u0010b\u001a\u00020a2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0KH\u0002¢\u0006\u0004\bb\u0010cR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010f¨\u0006j"}, d2 = {"Lcom/uxsense/parse/MetadataParser;", "", AppAgent.CONSTRUCT, "()V", "Lcom/uxsense/base/parse/ParseCache;", "cache", "Lcom/uxsense/parse/ParseResult;", "", "Lcom/uxsense/parse/MetadataParseResult;", "parse", "(Lcom/uxsense/base/parse/ParseCache;LH7/c;)Ljava/lang/Object;", "", "appName", "query", "", "userId", "", "threshold", "findCreationIdByQuery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;FLH7/c;)Ljava/lang/Object;", "", "limit", "Lcom/uxsense/search/MatchedCreation;", "searchCreations", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;FILH7/c;)Ljava/lang/Object;", "nickname", "findUserIdByNickname", "(Ljava/lang/String;Ljava/lang/String;FLH7/c;)Ljava/lang/Object;", "Lcom/uxsense/search/MatchedUser;", "searchUsers", "(Ljava/lang/String;Ljava/lang/String;FILH7/c;)Ljava/lang/Object;", "creationTitle", "authorNickname", "Lcom/uxsense/search/MatchedComment;", "findCommentsByCreationTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", "Lcom/uxsense/core/pattern/PatternMatchResult;", "results", "Lcom/uxsense/base/parse/ParseRule;", "rule", "parseUsers", "(Ljava/util/List;Lcom/uxsense/base/parse/ParseRule;Lcom/uxsense/base/parse/ParseCache;LH7/c;)Ljava/lang/Object;", "parseCreations", "result", "Lcom/uxsense/parse/MetadataConfig;", "config", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus;", "parseOneCreation", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/MetadataConfig;Lcom/uxsense/base/parse/ParseRule;Lcom/uxsense/base/parse/ParseCache;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/parse/MetadataParser$ResolveContext;", "resolveCtx", "Lcom/uxsense/parse/CreationKeyMapping;", "keyMapping", "handleDeduplicateSkip", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/MetadataConfig;Lcom/uxsense/parse/MetadataParser$ResolveContext;JLcom/uxsense/parse/CreationKeyMapping;Lcom/uxsense/base/parse/ParseCache;LH7/c;)Ljava/lang/Object;", "handleDeduplicateUpdate", "Lcom/uxsense/base/metadata/Creation;", "creation", "subDirs", "", "saveCreation", "(Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "parseComments", "parseChatMessages", "parseCustom", "(Ljava/util/List;Lcom/uxsense/base/parse/ParseRule;Lcom/uxsense/base/parse/ParseCache;)Lcom/uxsense/parse/ParseResult;", "Lcom/uxsense/core/base/parse/KViewNode;", "root", "Lcom/uxsense/parse/ContextExtractor;", "extractor", "extractContext", "(Lcom/uxsense/base/parse/ParseCache;Lcom/uxsense/core/base/parse/KViewNode;Lcom/uxsense/parse/ContextExtractor;LH7/c;)Ljava/lang/Object;", "contextMatch", "Lcom/uxsense/parse/IdSource;", AgentBusWakeContract.EXTRA_SOURCE, "", "fieldMapping", "resolveIdFromContextMatch", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/MetadataParser$ResolveContext;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "context", "resolveId", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/IdSource;Lcom/uxsense/parse/MetadataParser$ResolveContext;LH7/c;)Ljava/lang/Object;", "resolveIdByContext", "(Lcom/uxsense/parse/MetadataParser$ResolveContext;LH7/c;)Ljava/lang/Object;", "resolveIdByNickname", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/MetadataParser$ResolveContext;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/parse/IdSource$FromSearch;", "resolveIdBySearch", "(Lcom/uxsense/core/pattern/PatternMatchResult;Lcom/uxsense/parse/IdSource$FromSearch;Lcom/uxsense/parse/MetadataParser$ResolveContext;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/parse/UserKeyMapping;", "createUserKeyMapping", "(Ljava/util/Map;)Lcom/uxsense/parse/UserKeyMapping;", "createCreationKeyMapping", "(Ljava/util/Map;)Lcom/uxsense/parse/CreationKeyMapping;", "Lcom/uxsense/parse/CommentKeyMapping;", "createCommentKeyMapping", "(Ljava/util/Map;)Lcom/uxsense/parse/CommentKeyMapping;", "Lcom/uxsense/parse/ChatMessageKeyMapping;", "createChatMessageKeyMapping", "(Ljava/util/Map;)Lcom/uxsense/parse/ChatMessageKeyMapping;", "Lcom/uxsense/parse/ParseHandler;", "parseHandler", "Lcom/uxsense/parse/ParseHandler;", "Companion", "CreationParseStatus", "ResolveContext", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MetadataParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "MetadataParser";
    private final ParseHandler parseHandler = new ParseHandler();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/uxsense/parse/MetadataParser$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/uxsense/parse/MetadataParser$CreationParseStatus;", "", AppAgent.CONSTRUCT, "()V", "Success", "Skipped", "Error", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus$Error;", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus$Skipped;", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus$Success;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class CreationParseStatus {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/uxsense/parse/MetadataParser$CreationParseStatus$Error;", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error extends CreationParseStatus {
            private final String message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message) {
                super(null);
                k.f(message, "message");
                this.message = message;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final Error copy(String message) {
                k.f(message, "message");
                return new Error(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && k.b(this.message, ((Error) other).message);
            }

            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return B7.a.g(')', this.message, new StringBuilder("Error(message="));
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/uxsense/parse/MetadataParser$CreationParseStatus$Skipped;", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus;", "reason", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Skipped extends CreationParseStatus {
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Skipped(String reason) {
                super(null);
                k.f(reason, "reason");
                this.reason = reason;
            }

            public static /* synthetic */ Skipped copy$default(Skipped skipped, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = skipped.reason;
                }
                return skipped.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final Skipped copy(String reason) {
                k.f(reason, "reason");
                return new Skipped(reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Skipped) && k.b(this.reason, ((Skipped) other).reason);
            }

            public final String getReason() {
                return this.reason;
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return B7.a.g(')', this.reason, new StringBuilder("Skipped(reason="));
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/uxsense/parse/MetadataParser$CreationParseStatus$Success;", "Lcom/uxsense/parse/MetadataParser$CreationParseStatus;", "creation", "Lcom/uxsense/base/metadata/Creation;", AppAgent.CONSTRUCT, "(Lcom/uxsense/base/metadata/Creation;)V", "getCreation", "()Lcom/uxsense/base/metadata/Creation;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success extends CreationParseStatus {
            private final Creation creation;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Creation creation) {
                super(null);
                k.f(creation, "creation");
                this.creation = creation;
            }

            public static /* synthetic */ Success copy$default(Success success, Creation creation, int i, Object obj) {
                if ((i & 1) != 0) {
                    creation = success.creation;
                }
                return success.copy(creation);
            }

            /* renamed from: component1, reason: from getter */
            public final Creation getCreation() {
                return this.creation;
            }

            public final Success copy(Creation creation) {
                k.f(creation, "creation");
                return new Success(creation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && k.b(this.creation, ((Success) other).creation);
            }

            public final Creation getCreation() {
                return this.creation;
            }

            public int hashCode() {
                return this.creation.hashCode();
            }

            public String toString() {
                return "Success(creation=" + this.creation + ')';
            }
        }

        public /* synthetic */ CreationParseStatus(e eVar) {
            this();
        }

        private CreationParseStatus() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[MetadataType.values().length];
            try {
                iArr[MetadataType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MetadataType.CREATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MetadataType.COMMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MetadataType.CHAT_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MetadataType.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DeduplicateStrategy.values().length];
            try {
                iArr2[DeduplicateStrategy.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DeduplicateStrategy.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DeduplicateStrategy.UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SearchType.values().length];
            try {
                iArr3[SearchType.CREATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[SearchType.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {697, TypedValues.TransitionType.TYPE_TO, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 712, 717}, m = "extractContext")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$extractContext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.extractContext(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {962}, m = "findCreationIdByQuery")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$findCreationIdByQuery$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12781 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12781(H7.c<? super C12781> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.findCreationIdByQuery(null, null, null, 0.0f, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {1009}, m = "findUserIdByNickname")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$findUserIdByNickname$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12791 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12791(H7.c<? super C12791> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.findUserIdByNickname(null, null, 0.0f, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {394, 403}, m = "handleDeduplicateSkip")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$handleDeduplicateSkip$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12801 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C12801(H7.c<? super C12801> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.handleDeduplicateSkip(null, null, null, 0L, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {TypedValues.CycleType.TYPE_WAVE_SHAPE, 427, 449}, m = "handleDeduplicateUpdate")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$handleDeduplicateUpdate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12811 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C12811(H7.c<? super C12811> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.handleDeduplicateUpdate(null, null, null, 0L, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {75, 113, 119, MenuKt.InTransitionDuration, 121, 122, 119, MenuKt.InTransitionDuration, 121, 122}, m = "parse")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$parse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12821 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C12821(H7.c<? super C12821> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.parse(null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {600}, m = "parseChatMessages")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$parseChatMessages$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12831 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C12831(H7.c<? super C12831> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.parseChatMessages(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {InputDeviceCompat.SOURCE_DPAD, 547}, m = "parseComments")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$parseComments$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12841 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C12841(H7.c<? super C12841> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.parseComments(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {277, 296, 302}, m = "parseCreations")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$parseCreations$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12851 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C12851(H7.c<? super C12851> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.parseCreations(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {351, 362, 368, 371}, m = "parseOneCreation")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$parseOneCreation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12861 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C12861(H7.c<? super C12861> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.parseOneCreation(null, null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {180, 180, ComposerKt.referenceKey, 221}, m = "parseUsers")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$parseUsers$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12871 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public C12871(H7.c<? super C12871> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.parseUsers(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {813}, m = "resolveIdByContext")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$resolveIdByContext$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12881(H7.c<? super C12881> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.resolveIdByContext(null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {833}, m = "resolveIdByNickname")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$resolveIdByNickname$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12891 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12891(H7.c<? super C12891> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.resolveIdByNickname(null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {858, 862}, m = "resolveIdBySearch")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$resolveIdBySearch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12901 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12901(H7.c<? super C12901> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.resolveIdBySearch(null, null, null, this);
        }
    }

    @c(c = "com.uxsense.parse.MetadataParser", f = "MetadataParser.kt", l = {755, 771, 774}, m = "resolveIdFromContextMatch")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.parse.MetadataParser$resolveIdFromContextMatch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12911 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12911(H7.c<? super C12911> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataParser.this.resolveIdFromContextMatch(null, null, null, null, this);
        }
    }

    private final ChatMessageKeyMapping createChatMessageKeyMapping(Map<String, String> fieldMapping) {
        String str = fieldMapping.get("text");
        String str2 = str != null ? str : "text";
        String str3 = fieldMapping.get("at");
        return new ChatMessageKeyMapping(str2, str3 != null ? str3 : "at");
    }

    private final CommentKeyMapping createCommentKeyMapping(Map<String, String> fieldMapping) {
        String str = fieldMapping.get("parentCommentId");
        if (str == null) {
            str = "parentCommentId";
        }
        String str2 = fieldMapping.get("isAuthor");
        if (str2 == null) {
            str2 = "isAuthor";
        }
        String str3 = fieldMapping.get("nickname");
        if (str3 == null) {
            str3 = "nickname";
        }
        String str4 = fieldMapping.get("userId");
        if (str4 == null) {
            str4 = "userId";
        }
        String str5 = fieldMapping.get("content");
        if (str5 == null) {
            str5 = "content";
        }
        String str6 = fieldMapping.get("ts");
        if (str6 == null) {
            str6 = "ts";
        }
        String str7 = fieldMapping.get("hasReply");
        if (str7 == null) {
            str7 = "hasReply";
        }
        String str8 = fieldMapping.get("replyCount");
        if (str8 == null) {
            str8 = "replyCount";
        }
        String str9 = fieldMapping.get("likeCount");
        return new CommentKeyMapping(str, str2, str3, str4, str5, str6, str7, str8, str9 == null ? "likeCount" : str9);
    }

    private final CreationKeyMapping createCreationKeyMapping(Map<String, String> fieldMapping) {
        String str = fieldMapping.get("postId");
        String str2 = str != null ? str : "postId";
        String str3 = fieldMapping.get("uuid");
        String str4 = str3 != null ? str3 : "uuid";
        String str5 = fieldMapping.get("authorNickname");
        String str6 = str5 != null ? str5 : "authorNickname";
        String str7 = fieldMapping.get("cover");
        String str8 = str7 != null ? str7 : "cover";
        String str9 = fieldMapping.get("title");
        String str10 = str9 != null ? str9 : "title";
        String str11 = fieldMapping.get("content");
        String str12 = str11 != null ? str11 : "content";
        String str13 = fieldMapping.get("group");
        String str14 = str13 != null ? str13 : "group";
        String str15 = fieldMapping.get("tags");
        String str16 = str15 != null ? str15 : "tags";
        String str17 = fieldMapping.get("mentionedUsers");
        String str18 = str17 != null ? str17 : "mentionedUsers";
        String str19 = fieldMapping.get("location");
        if (str19 == null) {
            str19 = "location";
        }
        String str20 = fieldMapping.get("createdAt");
        if (str20 == null) {
            str20 = "createdAt";
        }
        String str21 = fieldMapping.get("lastEditedAt");
        String str22 = str21 == null ? "lastEditedAt" : str21;
        String str23 = fieldMapping.get("visibility");
        String str24 = str23 == null ? "visibility" : str23;
        String str25 = fieldMapping.get("likeCount");
        String str26 = str25 == null ? "likeCount" : str25;
        String str27 = fieldMapping.get("starCount");
        String str28 = str27 == null ? "starCount" : str27;
        String str29 = fieldMapping.get("shareCount");
        String str30 = str29 == null ? "shareCount" : str29;
        String str31 = fieldMapping.get("commentCount");
        String str32 = str31 == null ? "commentCount" : str31;
        String str33 = fieldMapping.get("viewCount");
        return new CreationKeyMapping(str2, str4, str6, null, str8, str10, str12, str14, str16, str18, null, str19, str20, null, str22, str24, new InteractionStatsKeyMapping(str26, str28, str30, str32, str33 == null ? "viewCount" : str33), 9224, null);
    }

    private final UserKeyMapping createUserKeyMapping(Map<String, String> fieldMapping) {
        String str = fieldMapping.get("nickname");
        if (str == null) {
            str = "nickname";
        }
        String str2 = fieldMapping.get("uuid");
        if (str2 == null) {
            str2 = "uuid";
        }
        String str3 = fieldMapping.get("avatar");
        if (str3 == null) {
            str3 = "avatar";
        }
        String str4 = fieldMapping.get("age");
        if (str4 == null) {
            str4 = "age";
        }
        String str5 = fieldMapping.get("bio");
        if (str5 == null) {
            str5 = "bio";
        }
        String str6 = fieldMapping.get(HintConstants.AUTOFILL_HINT_GENDER);
        if (str6 == null) {
            str6 = HintConstants.AUTOFILL_HINT_GENDER;
        }
        String str7 = fieldMapping.get("followersCount");
        String str8 = str7 != null ? str7 : "followersCount";
        String str9 = fieldMapping.get("followingCount");
        return new UserKeyMapping(str, str2, str3, str4, str5, str6, new UserStatsKeyMapping(str8, str9 != null ? str9 : "followingCount"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object extractContext(com.uxsense.base.parse.ParseCache r38, com.uxsense.core.base.parse.KViewNode r39, com.uxsense.parse.ContextExtractor r40, H7.c<? super com.uxsense.base.parse.ParseCache> r41) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.extractContext(com.uxsense.base.parse.ParseCache, com.uxsense.core.base.parse.KViewNode, com.uxsense.parse.ContextExtractor, H7.c):java.lang.Object");
    }

    public static /* synthetic */ Object findCommentsByCreationTitle$default(MetadataParser metadataParser, String str, String str2, String str3, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            str3 = null;
        }
        String str4 = str3;
        if ((i6 & 8) != 0) {
            i = 100;
        }
        return metadataParser.findCommentsByCreationTitle(str, str2, str4, i, cVar);
    }

    public static /* synthetic */ Object findCreationIdByQuery$default(MetadataParser metadataParser, String str, String str2, Long l, float f, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        Long l5 = l;
        if ((i & 8) != 0) {
            f = 0.5f;
        }
        return metadataParser.findCreationIdByQuery(str, str2, l5, f, cVar);
    }

    public static /* synthetic */ Object findUserIdByNickname$default(MetadataParser metadataParser, String str, String str2, float f, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.5f;
        }
        return metadataParser.findUserIdByNickname(str, str2, f, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleDeduplicateSkip(com.uxsense.core.pattern.PatternMatchResult r17, com.uxsense.parse.MetadataConfig r18, com.uxsense.parse.MetadataParser.ResolveContext r19, long r20, com.uxsense.parse.CreationKeyMapping r22, com.uxsense.base.parse.ParseCache r23, H7.c<? super com.uxsense.parse.MetadataParser.CreationParseStatus> r24) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.handleDeduplicateSkip(com.uxsense.core.pattern.PatternMatchResult, com.uxsense.parse.MetadataConfig, com.uxsense.parse.MetadataParser$ResolveContext, long, com.uxsense.parse.CreationKeyMapping, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleDeduplicateUpdate(com.uxsense.core.pattern.PatternMatchResult r23, com.uxsense.parse.MetadataConfig r24, com.uxsense.parse.MetadataParser.ResolveContext r25, long r26, com.uxsense.parse.CreationKeyMapping r28, com.uxsense.base.parse.ParseCache r29, H7.c<? super com.uxsense.parse.MetadataParser.CreationParseStatus> r30) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.handleDeduplicateUpdate(com.uxsense.core.pattern.PatternMatchResult, com.uxsense.parse.MetadataConfig, com.uxsense.parse.MetadataParser$ResolveContext, long, com.uxsense.parse.CreationKeyMapping, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(4:51|52|74|53) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0173, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0130 A[Catch: Exception -> 0x011c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x011c, blocks: (B:38:0x0115, B:46:0x0130), top: B:66:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014b A[Catch: Exception -> 0x0178, TRY_LEAVE, TryCatch #3 {Exception -> 0x0178, blocks: (B:36:0x0109, B:44:0x012a, B:49:0x0139, B:51:0x014b, B:33:0x0100), top: B:72:0x0109 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017c A[Catch: Exception -> 0x0173, TRY_LEAVE, TryCatch #4 {Exception -> 0x0173, blocks: (B:53:0x015c, B:59:0x017c), top: B:74:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.uxsense.parse.MetadataParser] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0106 -> B:14:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseChatMessages(java.util.List<com.uxsense.core.pattern.PatternMatchResult> r33, com.uxsense.base.parse.ParseRule r34, com.uxsense.base.parse.ParseCache r35, H7.c<? super com.uxsense.parse.ParseResult<com.uxsense.parse.MetadataParseResult>> r36) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.parseChatMessages(java.util.List, com.uxsense.base.parse.ParseRule, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:39|(1:127)|40|41|131|42|43|125|44|(14:47|18|129|48|(0)(0)|55|(0)(0)|59|61|(0)(0)|68|69|37|(5:87|(2:113|(1:115))(4:92|(1:94)(4:95|135|96|97)|98|(2:100|(4:103|104|117|118))(2:105|(1:107)(2:108|109)))|116|117|118)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(10:39|127|40|41|131|42|43|125|44|(14:47|18|129|48|(0)(0)|55|(0)(0)|59|61|(0)(0)|68|69|37|(5:87|(2:113|(1:115))(4:92|(1:94)(4:95|135|96|97)|98|(2:100|(4:103|104|117|118))(2:105|(1:107)(2:108|109)))|116|117|118)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:63|64|133|65|66|119|67) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ae, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01af, code lost:
    
        r5 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b1, code lost:
    
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01b3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01b4, code lost:
    
        r15 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01cc, code lost:
    
        r15 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ce, code lost:
    
        r4 = r7;
        r10 = r9;
        r9 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d4, code lost:
    
        r36 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0172 A[Catch: Exception -> 0x015e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x015e, blocks: (B:50:0x0157, B:57:0x0172), top: B:121:0x0157 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0184 A[Catch: Exception -> 0x01b7, TRY_LEAVE, TryCatch #5 {Exception -> 0x01b7, blocks: (B:48:0x014b, B:55:0x0166, B:61:0x017e, B:63:0x0184), top: B:129:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bd A[Catch: Exception -> 0x01ae, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ae, blocks: (B:67:0x01a4, B:77:0x01bd), top: B:119:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f9  */
    /* JADX WARN: Type inference failed for: r35v0, types: [com.uxsense.parse.MetadataParser] */
    /* JADX WARN: Type inference failed for: r4v33, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0146 -> B:18:0x0079). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x01dc -> B:69:0x01a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseComments(java.util.List<com.uxsense.core.pattern.PatternMatchResult> r36, com.uxsense.base.parse.ParseRule r37, com.uxsense.base.parse.ParseCache r38, H7.c<? super com.uxsense.parse.ParseResult<com.uxsense.parse.MetadataParseResult>> r39) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.parseComments(java.util.List, com.uxsense.base.parse.ParseRule, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x027d -> B:53:0x0282). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0295 -> B:58:0x028f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseCreations(java.util.List<com.uxsense.core.pattern.PatternMatchResult> r49, com.uxsense.base.parse.ParseRule r50, com.uxsense.base.parse.ParseCache r51, H7.c<? super com.uxsense.parse.ParseResult<com.uxsense.parse.MetadataParseResult>> r52) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.parseCreations(java.util.List, com.uxsense.base.parse.ParseRule, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    private final ParseResult<MetadataParseResult> parseCustom(List<PatternMatchResult> results, ParseRule rule, ParseCache cache) {
        ALog.d$default(TAG, "开始解析自定义类型，共有 " + results.size() + " 个匹配结果", null, 4, null);
        return new ParseResult.Error("Custom handler not implemented", new Exception("Not implemented"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0166 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:15:0x0037, B:47:0x0115, B:21:0x0047, B:54:0x0135, B:24:0x0056, B:60:0x0158, B:62:0x0166, B:64:0x016c, B:27:0x0074, B:34:0x00cb, B:36:0x00d9, B:38:0x00e6, B:44:0x0101, B:49:0x0118, B:50:0x011d, B:51:0x011e, B:56:0x0138, B:30:0x0086), top: B:71:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016c A[Catch: Exception -> 0x003c, TRY_LEAVE, TryCatch #0 {Exception -> 0x003c, blocks: (B:15:0x0037, B:47:0x0115, B:21:0x0047, B:54:0x0135, B:24:0x0056, B:60:0x0158, B:62:0x0166, B:64:0x016c, B:27:0x0074, B:34:0x00cb, B:36:0x00d9, B:38:0x00e6, B:44:0x0101, B:49:0x0118, B:50:0x011d, B:51:0x011e, B:56:0x0138, B:30:0x0086), top: B:71:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseOneCreation(com.uxsense.core.pattern.PatternMatchResult r22, com.uxsense.parse.MetadataConfig r23, com.uxsense.base.parse.ParseRule r24, com.uxsense.base.parse.ParseCache r25, H7.c<? super com.uxsense.parse.MetadataParser.CreationParseStatus> r26) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.parseOneCreation(com.uxsense.core.pattern.PatternMatchResult, com.uxsense.parse.MetadataConfig, com.uxsense.base.parse.ParseRule, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:248|96|97|283|98|99|111|(3:295|113|(3:115|(1:117)(1:120)|121))|305|122|(2:124|(6:164|282|165|(4:167|(2:278|169)(4:173|246|174|175)|176|(2:188|(4:190|303|191|192)(2:195|196))(2:178|(4:181|266|182|183)))(2:200|201)|320|(1:42))(21:262|132|(1:134)|135|136|(1:138)|139|140|141|244|142|143|252|144|145|254|146|147|264|148|(7:151|152|282|165|(0)(0)|320|(1:42))))(4:204|205|320|(1:42))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:(1:262)|132|(1:134)|135|136|(1:138)|139|140|141|244|142|143|252|144|145|254|146|147|264|148|(7:151|152|282|165|(0)(0)|320|(1:42))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:262|132|(1:134)|135|136|(1:138)|139|140|141|244|142|143|252|144|145|254|146|147|264|148|(7:151|152|282|165|(0)(0)|320|(1:42))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:66|258|67|68|69|260|94|(11:248|96|97|283|98|99|111|(3:295|113|(3:115|(1:117)(1:120)|121))|305|122|(2:124|(6:164|282|165|(4:167|(2:278|169)(4:173|246|174|175)|176|(2:188|(4:190|303|191|192)(2:195|196))(2:178|(4:181|266|182|183)))(2:200|201)|320|(1:42))(21:262|132|(1:134)|135|136|(1:138)|139|140|141|244|142|143|252|144|145|254|146|147|264|148|(7:151|152|282|165|(0)(0)|320|(1:42))))(4:204|205|320|(1:42)))(14:105|291|106|289|107|108|276|109|110|111|(0)|305|122|(0)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:299|59|60|313|61|62|309|63|(8:66|258|67|68|69|260|94|(11:248|96|97|283|98|99|111|(3:295|113|(3:115|(1:117)(1:120)|121))|305|122|(2:124|(6:164|282|165|(4:167|(2:278|169)(4:173|246|174|175)|176|(2:188|(4:190|303|191|192)(2:195|196))(2:178|(4:181|266|182|183)))(2:200|201)|320|(1:42))(21:262|132|(1:134)|135|136|(1:138)|139|140|141|244|142|143|252|144|145|254|146|147|264|148|(7:151|152|282|165|(0)(0)|320|(1:42))))(4:204|205|320|(1:42)))(14:105|291|106|289|107|108|276|109|110|111|(0)|305|122|(0)(0)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:315|91|307|92|93|69|260|94|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02a2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02a3, code lost:
    
        r17 = r4;
        r5 = r6;
        r14 = r8;
        r2 = r9;
        r4 = r12;
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03df, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03e0, code lost:
    
        r17 = r4;
        r5 = r6;
        r2 = r9;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03e9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03ea, code lost:
    
        r14 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03ec, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03ed, code lost:
    
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03f0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03f1, code lost:
    
        r11 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0516, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0517, code lost:
    
        r11 = r16;
        r12 = r19;
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0535, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0554, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0555, code lost:
    
        r14 = r6;
        r13 = r8;
        r15 = r10;
        r4 = r12;
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01fd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01fe, code lost:
    
        r17 = r4;
        r4 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0201, code lost:
    
        r5 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0205, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Path cross not found for [B:105:0x02b7, B:248:0x0291], limit reached: 316 */
    /* JADX WARN: Path cross not found for [B:248:0x0291, B:105:0x02b7], limit reached: 316 */
    /* JADX WARN: Path cross not found for [B:301:0x0182, B:53:0x018f], limit reached: 316 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0321 A[Catch: Exception -> 0x0516, TRY_LEAVE, TryCatch #31 {Exception -> 0x0516, blocks: (B:111:0x02d5, B:122:0x031d, B:124:0x0321, B:128:0x0344, B:110:0x02cb), top: B:305:0x031d }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x040d A[Catch: Exception -> 0x04a5, TRY_LEAVE, TryCatch #19 {Exception -> 0x04a5, blocks: (B:165:0x0407, B:167:0x040d, B:176:0x044a, B:178:0x044e, B:188:0x04ac, B:195:0x04dd, B:196:0x04e2, B:173:0x042b, B:175:0x043d, B:198:0x04e4, B:199:0x04ef, B:200:0x04f0, B:174:0x042f), top: B:282:0x0407, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04f0 A[Catch: Exception -> 0x04a5, TRY_LEAVE, TryCatch #19 {Exception -> 0x04a5, blocks: (B:165:0x0407, B:167:0x040d, B:176:0x044a, B:178:0x044e, B:188:0x04ac, B:195:0x04dd, B:196:0x04e2, B:173:0x042b, B:175:0x043d, B:198:0x04e4, B:199:0x04ef, B:200:0x04f0, B:174:0x042f), top: B:282:0x0407, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x02dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:181:0x047b -> B:266:0x047c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x04d0 -> B:42:0x015c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:201:0x0510 -> B:42:0x015c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x0527 -> B:42:0x015c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:241:0x05c2 -> B:42:0x015c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseUsers(java.util.List<com.uxsense.core.pattern.PatternMatchResult> r42, com.uxsense.base.parse.ParseRule r43, com.uxsense.base.parse.ParseCache r44, H7.c<? super com.uxsense.parse.ParseResult<com.uxsense.parse.MetadataParseResult>> r45) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.parseUsers(java.util.List, com.uxsense.base.parse.ParseRule, com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object resolveId(PatternMatchResult patternMatchResult, IdSource idSource, ResolveContext resolveContext, H7.c<? super Long> cVar) throws InterruptedException {
        long value;
        Long lG0;
        if (idSource instanceof IdSource.AutoGenerate) {
            value = ApexMetadataFileManager.INSTANCE.getIdGenerator_$uxsense_release().nextId();
        } else if (idSource instanceof IdSource.FromNode) {
            String value2 = patternMatchResult.getValue(((IdSource.FromNode) idSource).getNodeName());
            value = (value2 == null || (lG0 = t.g0(value2)) == null) ? -1L : lG0.longValue();
        } else {
            if (idSource instanceof IdSource.FromContext) {
                return resolveIdByContext(resolveContext, cVar);
            }
            if (!(idSource instanceof IdSource.Fixed)) {
                if (idSource instanceof IdSource.FromNickname) {
                    return resolveIdByNickname(patternMatchResult, resolveContext, cVar);
                }
                if (idSource instanceof IdSource.FromSearch) {
                    return resolveIdBySearch(patternMatchResult, (IdSource.FromSearch) idSource, resolveContext, cVar);
                }
                throw new NoWhenBranchMatchedException();
            }
            value = ((IdSource.Fixed) idSource).getValue();
        }
        return new Long(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveIdByContext(com.uxsense.parse.MetadataParser.ResolveContext r13, H7.c<? super java.lang.Long> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.uxsense.parse.MetadataParser.C12881
            if (r0 == 0) goto L14
            r0 = r14
            com.uxsense.parse.MetadataParser$resolveIdByContext$1 r0 = (com.uxsense.parse.MetadataParser.C12881) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            com.uxsense.parse.MetadataParser$resolveIdByContext$1 r0 = new com.uxsense.parse.MetadataParser$resolveIdByContext$1
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r12 = r9.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r9.label
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            kotlin.b.b(r12)
            goto L53
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L31:
            kotlin.b.b(r12)
            r12 = r1
            com.uxsense.user.ApexAccountManager r1 = com.uxsense.user.ApexAccountManager.INSTANCE
            java.lang.String r2 = r13.getAppName()
            int r3 = r13.getAndroidUserId()
            java.lang.Long r4 = r13.getUserId()
            r9.label = r12
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 120(0x78, float:1.68E-43)
            r11 = 0
            java.lang.Object r12 = com.uxsense.user.ApexAccountManager.findAccountOrCreate$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r12 != r14) goto L53
            return r14
        L53:
            com.uxsense.user.AccountEntry r12 = (com.uxsense.user.AccountEntry) r12
            long r12 = r12.getUserId()
            java.lang.Long r14 = new java.lang.Long
            r14.<init>(r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.resolveIdByContext(com.uxsense.parse.MetadataParser$ResolveContext, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        if (r12 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveIdByNickname(com.uxsense.core.pattern.PatternMatchResult r13, com.uxsense.parse.MetadataParser.ResolveContext r14, H7.c<? super java.lang.Long> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.uxsense.parse.MetadataParser.C12891
            if (r0 == 0) goto L14
            r0 = r15
            com.uxsense.parse.MetadataParser$resolveIdByNickname$1 r0 = (com.uxsense.parse.MetadataParser.C12891) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            com.uxsense.parse.MetadataParser$resolveIdByNickname$1 r0 = new com.uxsense.parse.MetadataParser$resolveIdByNickname$1
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r12 = r9.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r15 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r9.label
            r1 = 1
            if (r0 == 0) goto L31
            if (r0 != r1) goto L29
            kotlin.b.b(r12)
            goto L8b
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L31:
            kotlin.b.b(r12)
            java.lang.String r12 = r14.getNickname()
            r0 = 0
            if (r12 != 0) goto L5a
            java.lang.String r12 = r14.getNicknameNodeName()
            r2 = -1
            if (r12 != 0) goto L49
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r2)
            return r12
        L49:
            java.lang.String r12 = r13.getValue(r12)
            if (r12 == 0) goto L5c
            boolean r13 = j9.m.s0(r12)
            if (r13 != 0) goto L56
            goto L57
        L56:
            r12 = r0
        L57:
            if (r12 != 0) goto L5a
            goto L5c
        L5a:
            r6 = r12
            goto L62
        L5c:
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r2)
            return r12
        L62:
            java.lang.String r12 = "FromNickname: looking up userId for '"
            r13 = 39
            java.lang.String r12 = androidx.compose.foundation.b.m(r13, r12, r6)
            r13 = 4
            java.lang.String r2 = "MetadataParser"
            com.uxsense.utils.ALog.d$default(r2, r12, r0, r13, r0)
            r12 = r1
            com.uxsense.user.ApexAccountManager r1 = com.uxsense.user.ApexAccountManager.INSTANCE
            java.lang.String r2 = r14.getAppName()
            int r3 = r14.getAndroidUserId()
            r9.label = r12
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r10 = 76
            r11 = 0
            java.lang.Object r12 = com.uxsense.user.ApexAccountManager.findAccountOrCreate$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r12 != r15) goto L8b
            return r15
        L8b:
            com.uxsense.user.AccountEntry r12 = (com.uxsense.user.AccountEntry) r12
            long r12 = r12.getUserId()
            java.lang.Long r14 = new java.lang.Long
            r14.<init>(r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.resolveIdByNickname(com.uxsense.core.pattern.PatternMatchResult, com.uxsense.parse.MetadataParser$ResolveContext, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009a, code lost:
    
        if (r11 == r15) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cb, code lost:
    
        if (r11 == r15) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveIdBySearch(com.uxsense.core.pattern.PatternMatchResult r12, com.uxsense.parse.IdSource.FromSearch r13, com.uxsense.parse.MetadataParser.ResolveContext r14, H7.c<? super java.lang.Long> r15) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.resolveIdBySearch(com.uxsense.core.pattern.PatternMatchResult, com.uxsense.parse.IdSource$FromSearch, com.uxsense.parse.MetadataParser$ResolveContext, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d6, code lost:
    
        if (r3 == r4) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0157, code lost:
    
        if (r3 == r4) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018d, code lost:
    
        if (r3 == r4) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolveIdFromContextMatch(com.uxsense.core.pattern.PatternMatchResult r17, com.uxsense.parse.IdSource r18, com.uxsense.parse.MetadataParser.ResolveContext r19, java.util.Map<java.lang.String, java.lang.String> r20, H7.c<? super java.lang.Long> r21) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.resolveIdFromContextMatch(com.uxsense.core.pattern.PatternMatchResult, com.uxsense.parse.IdSource, com.uxsense.parse.MetadataParser$ResolveContext, java.util.Map, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveCreation(String str, Creation creation, List<String> list, H7.c<? super Boolean> cVar) {
        FileResult<r> fileResultSaveCreation;
        boolean z10;
        ApexTrace apexTrace = ApexTrace.INSTANCE;
        if (apexTrace.getEnabled()) {
            long jNanoTime = System.nanoTime();
            try {
                fileResultSaveCreation = this.parseHandler.saveCreation(str, creation, list);
            } finally {
                apexTrace.record("save_creation", System.nanoTime() - jNanoTime);
            }
        } else {
            fileResultSaveCreation = this.parseHandler.saveCreation(str, creation, list);
        }
        if (fileResultSaveCreation instanceof FileResult.Success) {
            ALog.d$default(TAG, "成功保存创作内容: id=" + creation.getCreationId(), null, 4, null);
            z10 = true;
        } else {
            if (!(fileResultSaveCreation instanceof FileResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            ALog.d$default(TAG, "保存创作内容失败: id=" + creation.getCreationId(), null, 4, null);
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object saveCreation$default(MetadataParser metadataParser, String str, Creation creation, List list, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            list = EmptyList.f4893a;
        }
        return metadataParser.saveCreation(str, creation, list, cVar);
    }

    public static /* synthetic */ Object searchCreations$default(MetadataParser metadataParser, String str, String str2, Long l, float f, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        Long l5 = l;
        if ((i6 & 8) != 0) {
            f = 0.3f;
        }
        float f7 = f;
        if ((i6 & 16) != 0) {
            i = 10;
        }
        return metadataParser.searchCreations(str, str2, l5, f7, i, cVar);
    }

    public static /* synthetic */ Object searchUsers$default(MetadataParser metadataParser, String str, String str2, float f, int i, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            f = 0.3f;
        }
        float f7 = f;
        if ((i6 & 8) != 0) {
            i = 10;
        }
        return metadataParser.searchUsers(str, str2, f7, i, cVar);
    }

    public final Object findCommentsByCreationTitle(String str, String str2, String str3, int i, H7.c<? super List<MatchedComment>> cVar) {
        return MetadataSearcher.findCommentsByCreation$default(MetadataSearcher.INSTANCE, str, str2, str3, null, i, cVar, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findCreationIdByQuery(java.lang.String r11, java.lang.String r12, java.lang.Long r13, float r14, H7.c<? super java.lang.Long> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.uxsense.parse.MetadataParser.C12781
            if (r0 == 0) goto L14
            r0 = r15
            com.uxsense.parse.MetadataParser$findCreationIdByQuery$1 r0 = (com.uxsense.parse.MetadataParser.C12781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            com.uxsense.parse.MetadataParser$findCreationIdByQuery$1 r0 = new com.uxsense.parse.MetadataParser$findCreationIdByQuery$1
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r10 = r8.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r15 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r8.label
            r9 = 0
            r1 = 1
            if (r0 == 0) goto L32
            if (r0 != r1) goto L2a
            kotlin.b.b(r10)
            goto L4f
        L2a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L32:
            kotlin.b.b(r10)
            boolean r10 = j9.m.s0(r12)
            if (r10 == 0) goto L3c
            return r9
        L3c:
            r10 = r1
            com.uxsense.search.MetadataSearcher r1 = com.uxsense.search.MetadataSearcher.INSTANCE
            com.uxsense.search.MatchMode r5 = com.uxsense.search.MatchMode.FUZZY
            r8.label = r10
            r7 = 1
            r2 = r11
            r3 = r12
            r4 = r13
            r6 = r14
            java.lang.Object r10 = r1.findCreationId(r2, r3, r4, r5, r6, r7, r8)
            if (r10 != r15) goto L4f
            return r15
        L4f:
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = D7.v.C0(r10)
            com.uxsense.search.MatchedCreation r10 = (com.uxsense.search.MatchedCreation) r10
            if (r10 == 0) goto L63
            long r10 = r10.getCreationId()
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r10)
            return r12
        L63:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.findCreationIdByQuery(java.lang.String, java.lang.String, java.lang.Long, float, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findUserIdByNickname(java.lang.String r10, java.lang.String r11, float r12, H7.c<? super java.lang.Long> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.uxsense.parse.MetadataParser.C12791
            if (r0 == 0) goto L14
            r0 = r13
            com.uxsense.parse.MetadataParser$findUserIdByNickname$1 r0 = (com.uxsense.parse.MetadataParser.C12791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.uxsense.parse.MetadataParser$findUserIdByNickname$1 r0 = new com.uxsense.parse.MetadataParser$findUserIdByNickname$1
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r9 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r13 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r0 = r7.label
            r8 = 0
            r1 = 1
            if (r0 == 0) goto L32
            if (r0 != r1) goto L2a
            kotlin.b.b(r9)
            goto L4e
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L32:
            kotlin.b.b(r9)
            boolean r9 = j9.m.s0(r11)
            if (r9 == 0) goto L3c
            return r8
        L3c:
            r9 = r1
            com.uxsense.search.MetadataSearcher r1 = com.uxsense.search.MetadataSearcher.INSTANCE
            com.uxsense.search.MatchMode r4 = com.uxsense.search.MatchMode.FUZZY
            r7.label = r9
            r6 = 1
            r2 = r10
            r3 = r11
            r5 = r12
            java.lang.Object r9 = r1.findUserId(r2, r3, r4, r5, r6, r7)
            if (r9 != r13) goto L4e
            return r13
        L4e:
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = D7.v.C0(r9)
            com.uxsense.search.MatchedUser r9 = (com.uxsense.search.MatchedUser) r9
            if (r9 == 0) goto L62
            long r9 = r9.getUserId()
            java.lang.Long r11 = new java.lang.Long
            r11.<init>(r9)
            return r11
        L62:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.findUserIdByNickname(java.lang.String, java.lang.String, float, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04f6 A[LOOP:1: B:180:0x04f0->B:182:0x04f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v39, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v42, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v44, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.uxsense.parse.MetadataParser] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.uxsense.trace.ApexTrace] */
    /* JADX WARN: Type inference failed for: r9v11, types: [com.uxsense.trace.ApexTrace] */
    /* JADX WARN: Type inference failed for: r9v13, types: [com.uxsense.trace.ApexTrace] */
    /* JADX WARN: Type inference failed for: r9v16, types: [com.uxsense.trace.ApexTrace, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v9, types: [com.uxsense.trace.ApexTrace] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x03bc -> B:164:0x044a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:143:0x03e7 -> B:144:0x03e9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parse(com.uxsense.base.parse.ParseCache r22, H7.c<? super com.uxsense.parse.ParseResult<? extends java.util.List<com.uxsense.parse.MetadataParseResult>>> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.parse.MetadataParser.parse(com.uxsense.base.parse.ParseCache, H7.c):java.lang.Object");
    }

    public final Object searchCreations(String str, String str2, Long l, float f, int i, H7.c<? super List<MatchedCreation>> cVar) {
        return MetadataSearcher.INSTANCE.findCreationId(str, str2, l, MatchMode.FUZZY, f, i, cVar);
    }

    public final Object searchUsers(String str, String str2, float f, int i, H7.c<? super List<MatchedUser>> cVar) {
        return MetadataSearcher.INSTANCE.findUserId(str, str2, MatchMode.FUZZY, f, i, cVar);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/uxsense/parse/MetadataParser$ResolveContext;", "", "appName", "", "androidUserId", "", "userId", "", "nicknameNodeName", "nickname", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getAndroidUserId", "()I", "getUserId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNicknameNodeName", "getNickname", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/uxsense/parse/MetadataParser$ResolveContext;", "equals", "", "other", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ResolveContext {
        private final int androidUserId;
        private final String appName;
        private final String nickname;
        private final String nicknameNodeName;
        private final Long userId;

        public ResolveContext(String appName, int i, Long l, String str, String str2) {
            k.f(appName, "appName");
            this.appName = appName;
            this.androidUserId = i;
            this.userId = l;
            this.nicknameNodeName = str;
            this.nickname = str2;
        }

        public static /* synthetic */ ResolveContext copy$default(ResolveContext resolveContext, String str, int i, Long l, String str2, String str3, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = resolveContext.appName;
            }
            if ((i6 & 2) != 0) {
                i = resolveContext.androidUserId;
            }
            if ((i6 & 4) != 0) {
                l = resolveContext.userId;
            }
            if ((i6 & 8) != 0) {
                str2 = resolveContext.nicknameNodeName;
            }
            if ((i6 & 16) != 0) {
                str3 = resolveContext.nickname;
            }
            String str4 = str3;
            Long l5 = l;
            return resolveContext.copy(str, i, l5, str2, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        /* renamed from: component2, reason: from getter */
        public final int getAndroidUserId() {
            return this.androidUserId;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getUserId() {
            return this.userId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getNicknameNodeName() {
            return this.nicknameNodeName;
        }

        /* renamed from: component5, reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        public final ResolveContext copy(String appName, int androidUserId, Long userId, String nicknameNodeName, String nickname) {
            k.f(appName, "appName");
            return new ResolveContext(appName, androidUserId, userId, nicknameNodeName, nickname);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResolveContext)) {
                return false;
            }
            ResolveContext resolveContext = (ResolveContext) other;
            return k.b(this.appName, resolveContext.appName) && this.androidUserId == resolveContext.androidUserId && k.b(this.userId, resolveContext.userId) && k.b(this.nicknameNodeName, resolveContext.nicknameNodeName) && k.b(this.nickname, resolveContext.nickname);
        }

        public final int getAndroidUserId() {
            return this.androidUserId;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getNicknameNodeName() {
            return this.nicknameNodeName;
        }

        public final Long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            int iA = androidx.constraintlayout.core.dsl.a.a(this.androidUserId, this.appName.hashCode() * 31, 31);
            Long l = this.userId;
            int iHashCode = (iA + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.nicknameNodeName;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.nickname;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ResolveContext(appName=");
            sb.append(this.appName);
            sb.append(", androidUserId=");
            sb.append(this.androidUserId);
            sb.append(", userId=");
            sb.append(this.userId);
            sb.append(", nicknameNodeName=");
            sb.append(this.nicknameNodeName);
            sb.append(", nickname=");
            return B7.a.g(')', this.nickname, sb);
        }

        public /* synthetic */ ResolveContext(String str, int i, Long l, String str2, String str3, int i6, e eVar) {
            this(str, i, (i6 & 4) != 0 ? null : l, (i6 & 8) != 0 ? null : str2, (i6 & 16) != 0 ? null : str3);
        }
    }
}
