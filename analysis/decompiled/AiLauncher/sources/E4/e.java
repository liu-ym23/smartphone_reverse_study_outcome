package E4;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"LE4/e;", "", "e", Const.INTENT_KEY_APIKEY, "c", "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "LE4/e$a;", "LE4/e$b;", "LE4/e$c;", "LE4/e$d;", "LE4/e$e;", "LE4/e$f;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface e {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LE4/e$a;", "LE4/e;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class a implements e {
        public static final a INSTANCE = new a();

        public boolean equals(Object other) {
            return this == other || (other instanceof a);
        }

        public int hashCode() {
            return 1424870881;
        }

        public String toString() {
            return "Dismiss";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LE4/e$b;", "LE4/e;", "", "message", "", "retryable", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.e$b, reason: from toString */
    public static final /* data */ class Error implements e {
        private final String message;
        private final boolean retryable;

        public Error(String message, boolean z10) {
            kotlin.jvm.internal.p.i(message, "message");
            this.message = message;
            this.retryable = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getRetryable() {
            return this.retryable;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return kotlin.jvm.internal.p.d(this.message, error.message) && this.retryable == error.retryable;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + Boolean.hashCode(this.retryable);
        }

        public String toString() {
            return "Error(message=" + this.message + ", retryable=" + this.retryable + ")";
        }

        public /* synthetic */ Error(String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? true : z10);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"LE4/e$c;", "LE4/e;", "", "message", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.e$c, reason: from toString */
    public static final /* data */ class Loading implements e {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public Loading() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loading) && kotlin.jvm.internal.p.d(this.message, ((Loading) other).message);
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Loading(message=" + this.message + ")";
        }

        public Loading(String str) {
            this.message = str;
        }

        public /* synthetic */ Loading(String str, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LE4/e$d;", "LE4/e;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/content/Intent;", "intent", "Landroid/content/Intent;", Const.INTENT_KEY_PKGNAME, "()Landroid/content/Intent;", "dismissCurrent", "Z", Const.INTENT_KEY_APIKEY, "()Z", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.e$d, reason: from toString */
    public static final /* data */ class Navigate implements e {
        private final boolean dismissCurrent;
        private final Intent intent;

        /* renamed from: a, reason: from getter */
        public final boolean getDismissCurrent() {
            return this.dismissCurrent;
        }

        /* renamed from: b, reason: from getter */
        public final Intent getIntent() {
            return this.intent;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Navigate)) {
                return false;
            }
            Navigate navigate = (Navigate) other;
            return kotlin.jvm.internal.p.d(this.intent, navigate.intent) && this.dismissCurrent == navigate.dismissCurrent;
        }

        public int hashCode() {
            return (this.intent.hashCode() * 31) + Boolean.hashCode(this.dismissCurrent);
        }

        public String toString() {
            return "Navigate(intent=" + this.intent + ", dismissCurrent=" + this.dismissCurrent + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LE4/e$e;", "LE4/e;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.e$e, reason: collision with other inner class name */
    public static final /* data */ class C0026e implements e {
        public static final C0026e INSTANCE = new C0026e();

        public boolean equals(Object other) {
            return this == other || (other instanceof C0026e);
        }

        public int hashCode() {
            return 810298177;
        }

        public String toString() {
            return "None";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LE4/e$f;", "LE4/e;", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(LE4/c;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "LE4/c;", Const.INTENT_KEY_APIKEY, "()LE4/c;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: E4.e$f, reason: from toString */
    public static final /* data */ class Update implements e {
        private final FloatCardContent content;

        public Update(FloatCardContent content) {
            kotlin.jvm.internal.p.i(content, "content");
            this.content = content;
        }

        /* renamed from: a, reason: from getter */
        public final FloatCardContent getContent() {
            return this.content;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Update) && kotlin.jvm.internal.p.d(this.content, ((Update) other).content);
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        public String toString() {
            return "Update(content=" + this.content + ")";
        }
    }
}
