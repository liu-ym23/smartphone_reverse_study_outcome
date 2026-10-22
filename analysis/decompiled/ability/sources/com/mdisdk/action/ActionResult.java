package com.mdisdk.action;

import B7.a;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/mdisdk/action/ActionResult;", ExifInterface.GPS_DIRECTION_TRUE, "", AppAgent.CONSTRUCT, "()V", "tag", "", "getTag", "()Ljava/lang/String;", "args", "", "getArgs", "()[Ljava/lang/Object;", "Success", "Failure", "Lcom/mdisdk/action/ActionResult$Failure;", "Lcom/mdisdk/action/ActionResult$Success;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ActionResult<T> {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u001a\u0010\u001d\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013JH\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\"\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/mdisdk/action/ActionResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/mdisdk/action/ActionResult;", SettingsConfig.KEY_DATA, "message", "", "tag", "args", "", "", AppAgent.CONSTRUCT, "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getTag", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/mdisdk/action/ActionResult$Success;", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Success<T> extends ActionResult<T> {
        private final Object[] args;
        private final T data;
        private final String message;
        private final String tag;

        public /* synthetic */ Success(Object obj, String str, String str2, Object[] objArr, int i, e eVar) {
            this(obj, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : objArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, String str, String str2, Object[] objArr, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            if ((i & 2) != 0) {
                str = success.message;
            }
            if ((i & 4) != 0) {
                str2 = success.tag;
            }
            if ((i & 8) != 0) {
                objArr = success.args;
            }
            return success.copy(obj, str, str2, objArr);
        }

        public final T component1() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        /* renamed from: component4, reason: from getter */
        public final Object[] getArgs() {
            return this.args;
        }

        public final Success<T> copy(T data, String message, String tag, Object[] args) {
            k.f(message, "message");
            k.f(tag, "tag");
            return new Success<>(data, message, tag, args);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            if (!k.b(this.data, success.data) || !k.b(this.message, success.message) || !k.b(getTag(), success.getTag())) {
                return false;
            }
            if (getArgs() != null) {
                if (success.getArgs() == null || !Arrays.equals(getArgs(), success.getArgs())) {
                    return false;
                }
            } else if (success.getArgs() != null) {
                return false;
            }
            return true;
        }

        @Override // com.mdisdk.action.ActionResult
        public Object[] getArgs() {
            return this.args;
        }

        public final T getData() {
            return this.data;
        }

        public final String getMessage() {
            return this.message;
        }

        @Override // com.mdisdk.action.ActionResult
        public String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t9 = this.data;
            int iHashCode = (getTag().hashCode() + a.c((t9 != null ? t9.hashCode() : 0) * 31, 31, this.message)) * 31;
            Object[] args = getArgs();
            return iHashCode + (args != null ? Arrays.hashCode(args) : 0);
        }

        public String toString() {
            return "Success(data=" + this.data + ", message=" + this.message + ", tag=" + this.tag + ", args=" + Arrays.toString(this.args) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(T t9, String message, String tag, Object[] objArr) {
            super(null);
            k.f(message, "message");
            k.f(tag, "tag");
            this.data = t9;
            this.message = message;
            this.tag = tag;
            this.args = objArr;
        }
    }

    public /* synthetic */ ActionResult(e eVar) {
        this();
    }

    public abstract Object[] getArgs();

    public abstract String getTag();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u001a\u0010!\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JN\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0014\b\u0002\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010#J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\"\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/mdisdk/action/ActionResult$Failure;", "Lcom/mdisdk/action/ActionResult;", "", "reason", "", "throwable", "", "abort", "", "tag", "args", "", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;ZLjava/lang/String;[Ljava/lang/Object;)V", "getReason", "()Ljava/lang/String;", "getThrowable", "()Ljava/lang/Throwable;", "getAbort", "()Z", "getTag", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Throwable;ZLjava/lang/String;[Ljava/lang/Object;)Lcom/mdisdk/action/ActionResult$Failure;", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Failure extends ActionResult {
        private final boolean abort;
        private final Object[] args;
        private final String reason;
        private final String tag;
        private final Throwable throwable;

        public /* synthetic */ Failure(String str, Throwable th, boolean z10, String str2, Object[] objArr, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : th, (i & 4) != 0 ? false : z10, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? null : objArr);
        }

        public static /* synthetic */ Failure copy$default(Failure failure, String str, Throwable th, boolean z10, String str2, Object[] objArr, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.reason;
            }
            if ((i & 2) != 0) {
                th = failure.throwable;
            }
            if ((i & 4) != 0) {
                z10 = failure.abort;
            }
            if ((i & 8) != 0) {
                str2 = failure.tag;
            }
            if ((i & 16) != 0) {
                objArr = failure.args;
            }
            Object[] objArr2 = objArr;
            boolean z11 = z10;
            return failure.copy(str, th, z11, str2, objArr2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAbort() {
            return this.abort;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        /* renamed from: component5, reason: from getter */
        public final Object[] getArgs() {
            return this.args;
        }

        public final Failure copy(String reason, Throwable throwable, boolean abort, String tag, Object[] args) {
            k.f(reason, "reason");
            k.f(tag, "tag");
            return new Failure(reason, throwable, abort, tag, args);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            if (!k.b(this.reason, failure.reason) || !k.b(this.throwable, failure.throwable) || this.abort != failure.abort || !k.b(getTag(), failure.getTag())) {
                return false;
            }
            if (getArgs() != null) {
                if (failure.getArgs() == null || !Arrays.equals(getArgs(), failure.getArgs())) {
                    return false;
                }
            } else if (failure.getArgs() != null) {
                return false;
            }
            return true;
        }

        public final boolean getAbort() {
            return this.abort;
        }

        @Override // com.mdisdk.action.ActionResult
        public Object[] getArgs() {
            return this.args;
        }

        public final String getReason() {
            return this.reason;
        }

        @Override // com.mdisdk.action.ActionResult
        public String getTag() {
            return this.tag;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            int iHashCode = this.reason.hashCode() * 31;
            Throwable th = this.throwable;
            int iHashCode2 = (getTag().hashCode() + androidx.appfunctions.metadata.a.d((iHashCode + (th != null ? th.hashCode() : 0)) * 31, 31, this.abort)) * 31;
            Object[] args = getArgs();
            return iHashCode2 + (args != null ? Arrays.hashCode(args) : 0);
        }

        public String toString() {
            return "Failure(reason=" + this.reason + ", throwable=" + this.throwable + ", abort=" + this.abort + ", tag=" + this.tag + ", args=" + Arrays.toString(this.args) + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String reason, Throwable th, boolean z10, String tag, Object[] objArr) {
            super(null);
            k.f(reason, "reason");
            k.f(tag, "tag");
            this.reason = reason;
            this.throwable = th;
            this.abort = z10;
            this.tag = tag;
            this.args = objArr;
        }
    }

    private ActionResult() {
    }
}
