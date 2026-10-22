package stepai.android.mindx.client.config;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lstepai/android/mindx/client/config/StepChatResult;", "", "Success", "Error", "Lstepai/android/mindx/client/config/StepChatResult$Error;", "Lstepai/android/mindx/client/config/StepChatResult$Success;", "mindXClient_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface StepChatResult {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lstepai/android/mindx/client/config/StepChatResult$Error;", "Lstepai/android/mindx/client/config/StepChatResult;", "message", "", "id", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mindXClient_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Error implements StepChatResult {
        private final String id;
        private final String message;

        public Error(String message, String str) {
            k.f(message, "message");
            this.message = message;
            this.id = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            if ((i & 2) != 0) {
                str2 = error.id;
            }
            return error.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Error copy(String message, String id) {
            k.f(message, "message");
            return new Error(message, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return k.b(this.message, error.message) && k.b(this.id, error.id);
        }

        public final String getId() {
            return this.id;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            String str = this.id;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return a.m("Error(message=", this.message, ", id=", this.id, ")");
        }

        public /* synthetic */ Error(String str, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lstepai/android/mindx/client/config/StepChatResult$Success;", "Lstepai/android/mindx/client/config/StepChatResult;", "message", "", "id", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mindXClient_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success implements StepChatResult {
        private final String id;
        private final String message;

        public Success(String message, String id) {
            k.f(message, "message");
            k.f(id, "id");
            this.message = message;
            this.id = id;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.message;
            }
            if ((i & 2) != 0) {
                str2 = success.id;
            }
            return success.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Success copy(String message, String id) {
            k.f(message, "message");
            k.f(id, "id");
            return new Success(message, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return k.b(this.message, success.message) && k.b(this.id, success.id);
        }

        public final String getId() {
            return this.id;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.id.hashCode() + (this.message.hashCode() * 31);
        }

        public String toString() {
            return a.m("Success(message=", this.message, ", id=", this.id, ")");
        }
    }
}
