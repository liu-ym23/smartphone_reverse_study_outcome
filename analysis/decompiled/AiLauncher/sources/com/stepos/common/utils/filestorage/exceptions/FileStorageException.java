package com.stepos.common.utils.filestorage.exceptions;

import La.H;
import O6.l;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0007\t\n\u000b\f\r\u000e\u000fB\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "NotInitialized", "Network", "TosPutFailed", "GatewayException", "BizError", "AuditBlocked", "AuditFailed", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$AuditBlocked;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$AuditFailed;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$BizError;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$Network;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$NotInitialized;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$TosPutFailed;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FileStorageException extends Exception {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$AuditBlocked;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "", "fileId", "auditDecision", "auditRiskLevel", "auditSuggestText", "sensitiveDecision", "sensitiveLevel", "", "detectPassed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getFileId", "()Ljava/lang/String;", "getAuditDecision", "getAuditRiskLevel", "getAuditSuggestText", "getSensitiveDecision", "getSensitiveLevel", "Ljava/lang/Boolean;", "getDetectPassed", "()Ljava/lang/Boolean;", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AuditBlocked extends FileStorageException {
        private static final a Companion = new a(null);
        private final String auditDecision;
        private final String auditRiskLevel;
        private final String auditSuggestText;
        private final Boolean detectPassed;
        private final String fileId;
        private final String sensitiveDecision;
        private final String sensitiveLevel;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$AuditBlocked$a;", "", "<init>", "()V", "", "auditDecision", "auditRiskLevel", "auditSuggestText", "sensitiveDecision", "sensitiveLevel", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            public /* synthetic */ a(i iVar) {
                this();
            }

            public final String a(String auditDecision, String auditRiskLevel, String auditSuggestText, String sensitiveDecision, String sensitiveLevel) {
                p.i(auditDecision, "auditDecision");
                if (auditSuggestText != null && !H.x0(auditSuggestText)) {
                    return "Content blocked: " + auditSuggestText;
                }
                if (p.d(sensitiveDecision, "BLOCK")) {
                    if (sensitiveLevel == null) {
                        sensitiveLevel = l.DATE_SEPARATOR;
                    }
                    return "Content blocked by sensitive-detection (level=" + sensitiveLevel + ")";
                }
                if (auditRiskLevel == null) {
                    auditRiskLevel = l.DATE_SEPARATOR;
                }
                return "Content blocked by safety-audit (decision=" + auditDecision + ", riskLevel=" + auditRiskLevel + ")";
            }

            public a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AuditBlocked(String fileId, String auditDecision, String str, String str2, String str3, String str4, Boolean bool) {
            super(Companion.a(auditDecision, str, str2, str3, str4), null, 2, 0 == true ? 1 : 0);
            p.i(fileId, "fileId");
            p.i(auditDecision, "auditDecision");
            this.fileId = fileId;
            this.auditDecision = auditDecision;
            this.auditRiskLevel = str;
            this.auditSuggestText = str2;
            this.sensitiveDecision = str3;
            this.sensitiveLevel = str4;
            this.detectPassed = bool;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$AuditFailed;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "", "fileId", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getFileId", "()Ljava/lang/String;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AuditFailed extends FileStorageException {
        private final String fileId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AuditFailed(String fileId, String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            p.i(fileId, "fileId");
            p.i(message, "message");
            this.fileId = fileId;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$BizError;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "", "code", "", "httpStatus", "message", "path", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "I", Const.INTENT_KEY_APIKEY, "()I", "getPath", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BizError extends FileStorageException {
        private final String code;
        private final int httpStatus;
        private final String path;

        public /* synthetic */ BizError(String str, int i10, String str2, String str3, int i11, i iVar) {
            this(str, i10, str2, (i11 & 8) != 0 ? null : str3);
        }

        /* renamed from: a, reason: from getter */
        public final int getHttpStatus() {
            return this.httpStatus;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public BizError(String code, int i10, String message, String str) {
            super(message, null, 2, 0 == true ? 1 : 0);
            p.i(code, "code");
            p.i(message, "message");
            this.code = code;
            this.httpStatus = i10;
            this.path = str;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u000b\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "I", Const.INTENT_KEY_APIKEY, "()I", "SystemMaintenance", "DuplicateRequest", "MissingCommonParam", "SignatureInvalid", "TokenInvalid", "Other", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$DuplicateRequest;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$MissingCommonParam;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$Other;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$SignatureInvalid;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$SystemMaintenance;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$TokenInvalid;", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class GatewayException extends FileStorageException {
        private final int code;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$DuplicateRequest;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "message", "", "<init>", "(Ljava/lang/String;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class DuplicateRequest extends GatewayException {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DuplicateRequest(String message) {
                super(10011, message, null);
                p.i(message, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$MissingCommonParam;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "message", "", "<init>", "(Ljava/lang/String;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MissingCommonParam extends GatewayException {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MissingCommonParam(String message) {
                super(10012, message, null);
                p.i(message, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$Other;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Other extends GatewayException {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Other(int i10, String message) {
                super(i10, message, null);
                p.i(message, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$SignatureInvalid;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class SignatureInvalid extends GatewayException {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignatureInvalid(int i10, String message) {
                super(i10, message, null);
                p.i(message, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$SystemMaintenance;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "message", "", "<init>", "(Ljava/lang/String;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class SystemMaintenance extends GatewayException {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SystemMaintenance(String message) {
                super(10010, message, null);
                p.i(message, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException$TokenInvalid;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$GatewayException;", "message", "", "<init>", "(Ljava/lang/String;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class TokenInvalid extends GatewayException {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TokenInvalid(String message) {
                super(99999, message, null);
                p.i(message, "message");
            }
        }

        public /* synthetic */ GatewayException(int i10, String str, i iVar) {
            this(i10, str);
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GatewayException(int i10, String str) {
            super(str, null, 2, 0 == true ? 1 : 0);
            this.code = i10;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$Network;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Network extends FileStorageException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Network(String message, Throwable th) {
            super(message, th, null);
            p.i(message, "message");
        }

        public /* synthetic */ Network(String str, Throwable th, int i10, i iVar) {
            this(str, (i10 & 2) != 0 ? null : th);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$NotInitialized;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "<init>", "()V", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NotInitialized extends FileStorageException {
        public static final NotInitialized INSTANCE = new NotInitialized();

        /* JADX WARN: Multi-variable type inference failed */
        private NotInitialized() {
            super("FileStorageManager.setup() not called", null, 2, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException$TosPutFailed;", "Lcom/stepos/common/utils/filestorage/exceptions/FileStorageException;", "", "httpCode", "", "message", "", "cause", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "I", Const.INTENT_KEY_APIKEY, "()I", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TosPutFailed extends FileStorageException {
        private final int httpCode;

        public /* synthetic */ TosPutFailed(int i10, String str, Throwable th, int i11, i iVar) {
            this(i10, str, (i11 & 4) != 0 ? null : th);
        }

        /* renamed from: a, reason: from getter */
        public final int getHttpCode() {
            return this.httpCode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TosPutFailed(int i10, String message, Throwable th) {
            super(message, th, null);
            p.i(message, "message");
            this.httpCode = i10;
        }
    }

    public /* synthetic */ FileStorageException(String str, Throwable th, i iVar) {
        this(str, th);
    }

    public FileStorageException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ FileStorageException(String str, Throwable th, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : th, null);
    }
}
