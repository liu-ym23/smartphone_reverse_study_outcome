package com.stepos.ability.appfunctions;

import androidx.appfunctions.AppFunctionAppException;
import androidx.appfunctions.AppFunctionAppUnknownException;
import androidx.appfunctions.AppFunctionCancelledException;
import androidx.appfunctions.AppFunctionDeniedException;
import androidx.appfunctions.AppFunctionDisabledException;
import androidx.appfunctions.AppFunctionElementAlreadyExistsException;
import androidx.appfunctions.AppFunctionElementNotFoundException;
import androidx.appfunctions.AppFunctionException;
import androidx.appfunctions.AppFunctionFunctionNotFoundException;
import androidx.appfunctions.AppFunctionInvalidArgumentException;
import androidx.appfunctions.AppFunctionLimitExceededException;
import androidx.appfunctions.AppFunctionNotSupportedException;
import androidx.appfunctions.AppFunctionPermissionRequiredException;
import androidx.appfunctions.AppFunctionRequestException;
import androidx.appfunctions.AppFunctionSystemException;
import androidx.appfunctions.AppFunctionSystemUnknownException;
import androidx.appfunctions.AppFunctionUnknownException;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stepos/ability/appfunctions/JetpackAppFunctionExceptionExt;", "", AppAgent.CONSTRUCT, "()V", "errorCode", "", "exception", "Landroidx/appfunctions/AppFunctionException;", "errorCategory", "categoryFromCode", "ERROR_CATEGORY_UNKNOWN", "ERROR_CATEGORY_REQUEST_ERROR", "ERROR_CATEGORY_SYSTEM", "ERROR_CATEGORY_APP", "ERROR_DENIED", "ERROR_INVALID_ARGUMENT", "ERROR_DISABLED", "ERROR_FUNCTION_NOT_FOUND", "ERROR_RESOURCE_NOT_FOUND", "ERROR_LIMIT_EXCEEDED", "ERROR_RESOURCE_ALREADY_EXISTS", "ERROR_SYSTEM_ERROR", "ERROR_CANCELLED", "ERROR_APP_UNKNOWN_ERROR", "ERROR_PERMISSION_REQUIRED", "ERROR_NOT_SUPPORTED", "appfunctions_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JetpackAppFunctionExceptionExt {
    private static final int ERROR_APP_UNKNOWN_ERROR = 3000;
    private static final int ERROR_CANCELLED = 2001;
    private static final int ERROR_CATEGORY_APP = 3;
    private static final int ERROR_CATEGORY_REQUEST_ERROR = 1;
    private static final int ERROR_CATEGORY_SYSTEM = 2;
    private static final int ERROR_CATEGORY_UNKNOWN = 0;
    private static final int ERROR_DENIED = 1000;
    private static final int ERROR_DISABLED = 1002;
    private static final int ERROR_FUNCTION_NOT_FOUND = 1003;
    private static final int ERROR_INVALID_ARGUMENT = 1001;
    private static final int ERROR_LIMIT_EXCEEDED = 1501;
    private static final int ERROR_NOT_SUPPORTED = 3501;
    private static final int ERROR_PERMISSION_REQUIRED = 3500;
    private static final int ERROR_RESOURCE_ALREADY_EXISTS = 1502;
    private static final int ERROR_RESOURCE_NOT_FOUND = 1500;
    private static final int ERROR_SYSTEM_ERROR = 2000;
    public static final JetpackAppFunctionExceptionExt INSTANCE = new JetpackAppFunctionExceptionExt();

    private JetpackAppFunctionExceptionExt() {
    }

    private final int categoryFromCode(int errorCode) {
        if (1000 <= errorCode && errorCode < 2000) {
            return 1;
        }
        if (2000 > errorCode || errorCode >= 3000) {
            return (3000 > errorCode || errorCode >= 4000) ? 0 : 3;
        }
        return 2;
    }

    public final int errorCategory(AppFunctionException exception) {
        k.f(exception, "exception");
        if (exception instanceof AppFunctionRequestException) {
            return 1;
        }
        if (exception instanceof AppFunctionSystemException) {
            return 2;
        }
        if (exception instanceof AppFunctionAppException) {
            return 3;
        }
        if (exception instanceof AppFunctionUnknownException) {
            return categoryFromCode(((AppFunctionUnknownException) exception).getErrorCode());
        }
        return 0;
    }

    public final int errorCode(AppFunctionException exception) {
        k.f(exception, "exception");
        if (exception instanceof AppFunctionUnknownException) {
            return ((AppFunctionUnknownException) exception).getErrorCode();
        }
        if (exception instanceof AppFunctionDeniedException) {
            return 1000;
        }
        if (exception instanceof AppFunctionInvalidArgumentException) {
            return 1001;
        }
        if (exception instanceof AppFunctionDisabledException) {
            return 1002;
        }
        if (exception instanceof AppFunctionFunctionNotFoundException) {
            return 1003;
        }
        if (exception instanceof AppFunctionElementNotFoundException) {
            return 1500;
        }
        if (exception instanceof AppFunctionLimitExceededException) {
            return 1501;
        }
        if (exception instanceof AppFunctionElementAlreadyExistsException) {
            return 1502;
        }
        if (exception instanceof AppFunctionSystemUnknownException) {
            return 2000;
        }
        if (exception instanceof AppFunctionCancelledException) {
            return 2001;
        }
        if (exception instanceof AppFunctionAppUnknownException) {
            return 3000;
        }
        if (exception instanceof AppFunctionPermissionRequiredException) {
            return 3500;
        }
        return exception instanceof AppFunctionNotSupportedException ? 3501 : 0;
    }
}
