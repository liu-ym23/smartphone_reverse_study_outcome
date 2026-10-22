package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipelineResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getText", "()Ljava/lang/String;", "status", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "getStatus", "()Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "isFailure", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "()Z", "Status", "Success", "Empty", "Skipped", "Failed", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Empty;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Failed;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Skipped;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Success;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SearchPipelineResult {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Empty;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult;", "reason", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "text", "getText", "status", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "getStatus", "()Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "component1", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Empty extends SearchPipelineResult {
        private final String reason;
        private final Status status;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public Empty() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Empty copy$default(Empty empty, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = empty.reason;
            }
            return empty.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Empty copy(String reason) {
            p.e(reason, "reason");
            return new Empty(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Empty) && p.a(this.reason, ((Empty) other).reason);
        }

        public final String getReason() {
            return this.reason;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public Status getStatus() {
            return this.status;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return m0.f.d("Empty(reason=", this.reason, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Empty(String reason) {
            super(null);
            p.e(reason, "reason");
            this.reason = reason;
            this.text = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            this.status = Status.EMPTY;
        }

        public /* synthetic */ Empty(String str, int i8, i iVar) {
            this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Failed;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult;", "error", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getText", "()Ljava/lang/String;", "status", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "getStatus", "()Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "component1", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed extends SearchPipelineResult {
        private final Throwable error;
        private final Status status;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(Throwable error) {
            super(null);
            p.e(error, "error");
            this.error = error;
            this.text = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            this.status = Status.FAILED;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                th = failed.error;
            }
            return failed.copy(th);
        }

        /* renamed from: component1, reason: from getter */
        public final Throwable getError() {
            return this.error;
        }

        public final Failed copy(Throwable error) {
            p.e(error, "error");
            return new Failed(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && p.a(this.error, ((Failed) other).error);
        }

        public final Throwable getError() {
            return this.error;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public Status getStatus() {
            return this.status;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.error + ")";
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Skipped;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult;", "reason", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "text", "getText", "status", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "getStatus", "()Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "component1", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Skipped extends SearchPipelineResult {
        private final String reason;
        private final Status status;
        private final String text;

        /* JADX WARN: Multi-variable type inference failed */
        public Skipped() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Skipped copy$default(Skipped skipped, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = skipped.reason;
            }
            return skipped.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Skipped copy(String reason) {
            p.e(reason, "reason");
            return new Skipped(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Skipped) && p.a(this.reason, ((Skipped) other).reason);
        }

        public final String getReason() {
            return this.reason;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public Status getStatus() {
            return this.status;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return m0.f.d("Skipped(reason=", this.reason, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Skipped(String reason) {
            super(null);
            p.e(reason, "reason");
            this.reason = reason;
            this.text = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            this.status = Status.SKIPPED;
        }

        public /* synthetic */ Skipped(String str, int i8, i iVar) {
            this((i8 & 1) != 0 ? "no search needed" : str);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "EMPTY", "SKIPPED", "FAILED", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ i5.a $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status SUCCESS = new Status("SUCCESS", 0);
        public static final Status EMPTY = new Status("EMPTY", 1);
        public static final Status SKIPPED = new Status("SKIPPED", 2);
        public static final Status FAILED = new Status("FAILED", 3);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SUCCESS, EMPTY, SKIPPED, FAILED};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = a.a.F(statusArr$values);
        }

        private Status(String str, int i8) {
        }

        public static i5.a getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Success;", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult;", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "status", "Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "getStatus", "()Lcom/stepos/stepclaw/memory/search/SearchPipelineResult$Status;", "component1", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends SearchPipelineResult {
        private final Status status;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String text) {
            super(null);
            p.e(text, "text");
            this.text = text;
            this.status = Status.SUCCESS;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = success.text;
            }
            return success.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Success copy(String text) {
            p.e(text, "text");
            return new Success(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && p.a(this.text, ((Success) other).text);
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public Status getStatus() {
            return this.status;
        }

        @Override // com.stepos.stepclaw.memory.search.SearchPipelineResult
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return m0.f.d("Success(text=", this.text, ")");
        }
    }

    public /* synthetic */ SearchPipelineResult(i iVar) {
        this();
    }

    public abstract Status getStatus();

    public abstract String getText();

    public final boolean isFailure() {
        return getStatus() == Status.FAILED;
    }

    private SearchPipelineResult() {
    }
}
