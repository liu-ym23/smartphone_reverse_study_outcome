package io.ktor.client.request.forms;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lio/ktor/client/request/forms/FormPart;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "key", UxipConstants.f30680s, "Lio/ktor/http/Headers;", "headers", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/Headers;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "component3", "()Lio/ktor/http/Headers;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/Headers;)Lio/ktor/client/request/forms/FormPart;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKey", "Ljava/lang/Object;", "getValue", "Lio/ktor/http/Headers;", "getHeaders", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FormPart<T> {
    private final Headers headers;
    private final String key;
    private final T value;

    public FormPart(String key, T value, Headers headers) {
        p.i(key, "key");
        p.i(value, "value");
        p.i(headers, "headers");
        this.key = key;
        this.value = value;
        this.headers = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormPart copy$default(FormPart formPart, String str, Object obj, Headers headers, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            str = formPart.key;
        }
        if ((i10 & 2) != 0) {
            obj = formPart.value;
        }
        if ((i10 & 4) != 0) {
            headers = formPart.headers;
        }
        return formPart.copy(str, obj, headers);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final T component2() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final Headers getHeaders() {
        return this.headers;
    }

    public final FormPart<T> copy(String key, T value, Headers headers) {
        p.i(key, "key");
        p.i(value, "value");
        p.i(headers, "headers");
        return new FormPart<>(key, value, headers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormPart)) {
            return false;
        }
        FormPart formPart = (FormPart) other;
        return p.d(this.key, formPart.key) && p.d(this.value, formPart.value) && p.d(this.headers, formPart.headers);
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final String getKey() {
        return this.key;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.value.hashCode()) * 31) + this.headers.hashCode();
    }

    public String toString() {
        return "FormPart(key=" + this.key + ", value=" + this.value + ", headers=" + this.headers + ')';
    }

    public /* synthetic */ FormPart(String str, Object obj, Headers headers, int i10, kotlin.jvm.internal.i iVar) {
        this(str, obj, (i10 & 4) != 0 ? Headers.INSTANCE.getEmpty() : headers);
    }
}
