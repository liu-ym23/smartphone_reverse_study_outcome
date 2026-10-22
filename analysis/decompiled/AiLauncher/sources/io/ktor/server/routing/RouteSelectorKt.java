package io.ktor.server.routing;

import La.K;
import io.ktor.http.ContentType;
import io.ktor.http.ParametersKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u000b\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "", "segments", "", "segmentIndex", "name", "prefix", "suffix", "", "isOptional", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluatePathSegmentParameter", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/ktor/server/routing/RouteSelectorEvaluation;", "Lio/ktor/http/ContentType;", "other", "isCompatibleWith", "(Lio/ktor/http/ContentType;Lio/ktor/http/ContentType;)Z", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RouteSelectorKt {
    public static final RouteSelectorEvaluation evaluatePathSegmentParameter(List<String> segments, int i10, String name, String str, String str2, boolean z10) {
        String strL1;
        kotlin.jvm.internal.p.i(segments, "segments");
        kotlin.jvm.internal.p.i(name, "name");
        if (i10 >= segments.size()) {
            return evaluatePathSegmentParameter$failedEvaluation(z10, null);
        }
        String str3 = segments.get(i10);
        if (str3.length() == 0) {
            return evaluatePathSegmentParameter$failedEvaluation(z10, str3);
        }
        if (str == null) {
            strL1 = str3;
        } else {
            if (!La.D.X(str3, str, false, 2, null)) {
                return evaluatePathSegmentParameter$failedEvaluation(z10, str3);
            }
            strL1 = K.L1(str3, str.length());
        }
        if (str2 != null) {
            if (!La.D.K(strL1, str2, false, 2, null)) {
                return evaluatePathSegmentParameter$failedEvaluation(z10, str3);
            }
            strL1 = K.M1(strL1, str2.length());
        }
        return new RouteSelectorEvaluation.Success(((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) ? 0.8d : 0.9d, ParametersKt.parametersOf(name, strL1), 1);
    }

    public static /* synthetic */ RouteSelectorEvaluation evaluatePathSegmentParameter$default(List list, int i10, String str, String str2, String str3, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        if ((i11 & 16) != 0) {
            str3 = null;
        }
        return evaluatePathSegmentParameter(list, i10, str, str2, str3, z10);
    }

    private static final RouteSelectorEvaluation evaluatePathSegmentParameter$failedEvaluation(boolean z10, String str) {
        if (!z10) {
            return RouteSelectorEvaluation.INSTANCE.getFailedPath();
        }
        if (str != null && str.length() == 0) {
            return new RouteSelectorEvaluation.Success(0.2d, null, 1, 2, null);
        }
        return RouteSelectorEvaluation.INSTANCE.getMissing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCompatibleWith(ContentType contentType, ContentType contentType2) {
        if (kotlin.jvm.internal.p.d(contentType.getContentType(), "*") && kotlin.jvm.internal.p.d(contentType.getContentSubtype(), "*")) {
            return true;
        }
        if (kotlin.jvm.internal.p.d(contentType2.getContentType(), "*") && kotlin.jvm.internal.p.d(contentType2.getContentSubtype(), "*")) {
            return true;
        }
        return kotlin.jvm.internal.p.d(contentType.getContentSubtype(), "*") ? contentType2.match(contentType) : contentType.match(contentType2);
    }
}
