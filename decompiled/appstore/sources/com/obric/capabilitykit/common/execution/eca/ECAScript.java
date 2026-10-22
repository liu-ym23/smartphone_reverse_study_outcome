package com.obric.capabilitykit.common.execution.eca;

import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAScript;", "Lcom/obric/capabilitykit/common/execution/eca/ECAModifiable;", "()V", "jobs", "", "Lcom/obric/capabilitykit/common/execution/eca/ECAJob;", "getJobs", "()Ljava/util/List;", "setJobs", "(Ljava/util/List;)V", "version", "", "getVersion", "()I", "firstJob", "ErrorCode", "ParseResult", "Parser", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ECAScript implements ECAModifiable {
    public List<? extends ECAJob> jobs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAScript$ErrorCode;", "", "()V", "NO_ERROR", "", "PARSE_ERROR_SYNTAX", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ErrorCode {

        @NotNull
        public static final ErrorCode INSTANCE = null;
        public static final int NO_ERROR = 0;
        public static final int PARSE_ERROR_SYNTAX = 1;

        static {
            INSTANCE = new ErrorCode();
        }

        private ErrorCode() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAScript$ParseResult;", "T", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript;", "", "errorCode", "", "eca", "(ILcom/obric/capabilitykit/common/execution/eca/ECAScript;)V", "getEca", "()Lcom/obric/capabilitykit/common/execution/eca/ECAScript;", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript;", "getErrorCode", "()I", "component1", "component2", "copy", "(ILcom/obric/capabilitykit/common/execution/eca/ECAScript;)Lcom/obric/capabilitykit/common/execution/eca/ECAScript$ParseResult;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ParseResult<T extends ECAScript> {

        @Nullable
        private final T eca;
        private final int errorCode;

        public ParseResult(int r10, @Nullable T r11) {
            this.errorCode = r10;
            this.eca = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParseResult copy$default(ParseResult r10, int r11, ECAScript r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r11 = r10.errorCode;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r12 = r10.eca;
        L9:
            return r10.copy(r11, r12);
        }

        public final int component1() {
            return this.errorCode;
        }

        @Nullable
        public final T component2() {
            return this.eca;
        }

        @NotNull
        public final ParseResult<T> copy(int r10, @Nullable T r11) {
            return new ParseResult(r10, r11);
        }

        public boolean equals(@Nullable Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ParseResult) == true) goto L8;
            return false;
        L8:
            ParseResult r11 = (ParseResult) r10;
            if (this.errorCode == r11.errorCode) goto L12;
            return false;
        L12:
            if (q.b(this.eca, r11.eca) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Nullable
        public final T getEca() {
            return this.eca;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public int hashCode() {
            int r10 = Integer.hashCode(this.errorCode) * 31;
            T r11 = this.eca;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return r10 + r12;
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        @NotNull
        public String toString() {
            return "ParseResult(errorCode=" + this.errorCode + ", eca=" + this.eca + ')';
        }

        public /* synthetic */ ParseResult(int r10, ECAScript r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 2) == 0) goto L5;
            r11 = null;
        L5:
            this(r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAScript$Parser;", "", "parse", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript$ParseResult;", "Lcom/obric/capabilitykit/common/execution/eca/ECAScript;", "script", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Parser {
        @NotNull
        ParseResult<? extends ECAScript> parse(@NotNull String r10);
    }

    public ECAScript() {
    }

    @Nullable
    public final ECAJob firstJob() {
        return (ECAJob) b0.Z(getJobs());
    }

    @NotNull
    public final List<ECAJob> getJobs() {
        List r10 = this.jobs;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("jobs");
        return null;
    }

    public abstract int getVersion();

    @Override // com.obric.capabilitykit.common.execution.eca.ECAModifiable
    public boolean isDirty() {
        return ECAModifiable.DefaultImpls.isDirty(this);
    }

    public final void setJobs(@NotNull List<? extends ECAJob> r10) {
        q.g(r10, "<set-?>");
        this.jobs = r10;
    }
}
